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
    public static int cPU = 0;
    public static int cPV = 1;
    public static int cPW = 2;
    private d cPX;
    private boolean cPY;
    private int cPZ;
    private int mState;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = cPU;
        this.cPZ = 0;
        this.cPX = dVar;
        this.cPY = z;
        l(context, i);
    }

    private void l(Context context, int i) {
        if (this.cPY) {
            setPadding(0, l.f(getContext(), d.e.ds16), 0, 0);
            setTextSize(0, l.f(context, d.e.ds32));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cPX != null) {
            setText(this.cPX.name);
        }
        wB();
    }

    public void setState(int i) {
        if (this.cPX != null && this.cPX.cPT != null && this.cPX.cPT.cAT != null && this.cPX.cPT.cAT.size() > 0) {
            int i2 = -l.f(getContext(), d.e.ds10);
            if (!this.cPY) {
                i2 = 0;
            }
            if (i == cPW) {
                Drawable drawable = aj.getDrawable(d.f.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = aj.getDrawable(d.f.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(d.e.ds8));
        }
        if (this.cPY) {
            aj.c(this, d.C0080d.cp_cont_b, 1);
        } else {
            if (i == cPV || i == cPW) {
                if (this.cPZ == 0) {
                    aj.c(this, d.C0080d.cp_link_tip_a, 1);
                } else {
                    aj.c(this, this.cPZ, 1);
                }
            } else {
                aj.c(this, d.C0080d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.cPX == null) {
            return -1;
        }
        return this.cPX.cKT;
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
            if (this.cPY) {
                setPadding(0, l.f(getContext(), d.e.ds16), spaceWidth, 0);
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
        if (this.cPX == null) {
            return null;
        }
        return this.cPX.url;
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
        this.cPY = z;
    }

    public void setSelectItemColorResId(int i) {
        this.cPZ = i;
    }
}
