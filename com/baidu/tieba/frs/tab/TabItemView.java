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
    public static int cZj = 0;
    public static int cZk = 1;
    public static int cZl = 2;
    private d cZm;
    private boolean cZn;
    private int cZo;
    private int mState;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = cZj;
        this.cZo = 0;
        this.cZm = dVar;
        this.cZn = z;
        l(context, i);
    }

    private void l(Context context, int i) {
        if (this.cZn) {
            setPadding(0, l.f(getContext(), d.e.tbds20), 0, 0);
            setTextSize(0, l.f(context, d.e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cZm != null) {
            setText(this.cZm.name);
        }
        wE();
    }

    public void setState(int i) {
        if (this.cZm != null && this.cZm.cZi != null && this.cZm.cZi.cJX != null && this.cZm.cZi.cJX.size() > 0) {
            int i2 = -l.f(getContext(), d.e.tbds20);
            if (!this.cZn) {
                i2 = 0;
            }
            if (i == cZl) {
                Drawable drawable = aj.getDrawable(d.f.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = aj.getDrawable(d.f.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(d.e.tbds20));
        }
        if (this.cZn) {
            aj.c(this, d.C0082d.cp_cont_b, 1);
        } else {
            if (i == cZk || i == cZl) {
                if (this.cZo == 0) {
                    aj.c(this, d.C0082d.cp_link_tip_a, 1);
                } else {
                    aj.c(this, this.cZo, 1);
                }
            } else {
                aj.c(this, d.C0082d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.cZm == null) {
            return -1;
        }
        return this.cZm.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void wE() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.cZn) {
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
        if (this.cZm == null) {
            return null;
        }
        return this.cZm.url;
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
        this.cZn = z;
    }

    public void setSelectItemColorResId(int i) {
        this.cZo = i;
    }
}
