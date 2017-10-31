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
    public static int cPA = 0;
    public static int cPB = 1;
    public static int cPC = 2;
    private d cPD;
    private boolean cPE;
    private int cPF;
    private int mState;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = cPA;
        this.cPF = 0;
        this.cPD = dVar;
        this.cPE = z;
        l(context, i);
    }

    private void l(Context context, int i) {
        if (this.cPE) {
            setPadding(0, l.f(getContext(), d.e.ds16), 0, 0);
            setTextSize(0, l.f(context, d.e.ds32));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cPD != null) {
            setText(this.cPD.name);
        }
        wB();
    }

    public void setState(int i) {
        if (this.cPD != null && this.cPD.cPz != null && this.cPD.cPz.cAA != null && this.cPD.cPz.cAA.size() > 0) {
            int i2 = -l.f(getContext(), d.e.ds10);
            if (!this.cPE) {
                i2 = 0;
            }
            if (i == cPC) {
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
        if (this.cPE) {
            aj.c(this, d.C0080d.cp_cont_b, 1);
        } else {
            if (i == cPB || i == cPC) {
                if (this.cPF == 0) {
                    aj.c(this, d.C0080d.cp_link_tip_a, 1);
                } else {
                    aj.c(this, this.cPF, 1);
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
        if (this.cPD == null) {
            return -1;
        }
        return this.cPD.cKA;
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
            if (this.cPE) {
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
        if (this.cPD == null) {
            return null;
        }
        return this.cPD.url;
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
        this.cPE = z;
    }

    public void setSelectItemColorResId(int i) {
        this.cPF = i;
    }
}
