package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int cFG = 0;
    public static int cFH = 1;
    public static int cFI = 2;
    private d cFJ;
    private boolean cFK;
    private int cFL;
    private int mState;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = cFG;
        this.cFL = 0;
        this.cFJ = dVar;
        this.cFK = z;
        n(context, i);
    }

    private void n(Context context, int i) {
        if (this.cFK) {
            setPadding(0, k.f(getContext(), d.f.ds16), 0, 0);
            setTextSize(0, k.f(context, d.f.ds32));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cFJ != null) {
            setText(this.cFJ.name);
        }
        xc();
    }

    public void setState(int i) {
        if (this.cFJ != null && this.cFJ.cFF != null && this.cFJ.cFF.csN != null && this.cFJ.cFF.csN.size() > 0) {
            int i2 = -k.f(getContext(), d.f.ds10);
            if (!this.cFK) {
                i2 = 0;
            }
            if (i == cFI) {
                Drawable drawable = aj.getDrawable(d.g.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = aj.getDrawable(d.g.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(d.f.ds8));
        }
        if (this.cFK) {
            aj.c(this, d.e.cp_cont_b, 1);
        } else {
            if (i == cFH || i == cFI) {
                if (this.cFL == 0) {
                    aj.c(this, d.e.cp_link_tip_a, 1);
                } else {
                    aj.c(this, this.cFL, 1);
                }
            } else {
                aj.c(this, d.e.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.cFJ == null) {
            return -1;
        }
        return this.cFJ.cCh;
    }

    public int getState() {
        return this.mState;
    }

    public void xc() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.cFK) {
                setPadding(0, k.f(getContext(), d.f.ds16), spaceWidth, 0);
            } else {
                setPadding(0, 0, spaceWidth, 0);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            canvas.translate(spaceWidth / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    private int getSpaceWidth() {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null || (drawable = compoundDrawables[2]) == null) {
            return -1;
        }
        float measureText = getPaint().measureText(getText().toString());
        return getWidth() - ((drawable.getIntrinsicWidth() + ((int) measureText)) + getCompoundDrawablePadding());
    }

    public String getUrl() {
        if (this.cFJ == null) {
            return null;
        }
        return this.cFJ.url;
    }

    public int getDrawableWidth() {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null || compoundDrawables.length < 3 || (drawable = compoundDrawables[2]) == null) {
            return 0;
        }
        return drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
    }

    public void setForNewFrame(boolean z) {
        this.cFK = z;
    }

    public void setSelectItemColorResId(int i) {
        this.cFL = i;
    }
}
