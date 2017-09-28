package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    private d cGC;
    private boolean cGD;
    private int cGE;
    private int mState;
    public static int cGz = 0;
    public static int cGA = 1;
    public static int cGB = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = cGz;
        this.cGE = 0;
        this.cGC = dVar;
        this.cGD = z;
        m(context, i);
    }

    private void m(Context context, int i) {
        if (this.cGD) {
            setPadding(0, l.f(getContext(), d.f.ds16), 0, 0);
            setTextSize(0, l.f(context, d.f.ds32));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cGC != null) {
            setText(this.cGC.name);
        }
        wB();
    }

    public void setState(int i) {
        if (this.cGC != null && this.cGC.cGy != null && this.cGC.cGy.ctp != null && this.cGC.cGy.ctp.size() > 0) {
            int i2 = -l.f(getContext(), d.f.ds10);
            if (!this.cGD) {
                i2 = 0;
            }
            if (i == cGB) {
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
        if (this.cGD) {
            aj.c(this, d.e.cp_cont_b, 1);
        } else {
            if (i == cGA || i == cGB) {
                if (this.cGE == 0) {
                    aj.c(this, d.e.cp_link_tip_a, 1);
                } else {
                    aj.c(this, this.cGE, 1);
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
        if (this.cGC == null) {
            return -1;
        }
        return this.cGC.cDa;
    }

    public int getState() {
        return this.mState;
    }

    public void wB() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.cGD) {
                setPadding(0, l.f(getContext(), d.f.ds16), spaceWidth, 0);
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
        if (this.cGC == null) {
            return null;
        }
        return this.cGC.url;
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
        this.cGD = z;
    }

    public void setSelectItemColorResId(int i) {
        this.cGE = i;
    }
}
