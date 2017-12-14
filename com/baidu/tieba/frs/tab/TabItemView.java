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
    public static int cZv = 0;
    public static int cZw = 1;
    public static int cZx = 2;
    private int cZA;
    private d cZy;
    private boolean cZz;
    private int mState;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = cZv;
        this.cZA = 0;
        this.cZy = dVar;
        this.cZz = z;
        l(context, i);
    }

    private void l(Context context, int i) {
        if (this.cZz) {
            setPadding(0, l.f(getContext(), d.e.tbds20), 0, 0);
            setTextSize(0, l.f(context, d.e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cZy != null) {
            setText(this.cZy.name);
        }
        wC();
    }

    public void setState(int i) {
        if (this.cZy != null && this.cZy.cZu != null && this.cZy.cZu.cKh != null && this.cZy.cZu.cKh.size() > 0) {
            int i2 = -l.f(getContext(), d.e.tbds20);
            if (!this.cZz) {
                i2 = 0;
            }
            if (i == cZx) {
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
        if (this.cZz) {
            aj.c(this, d.C0096d.cp_cont_b, 1);
        } else {
            if (i == cZw || i == cZx) {
                if (this.cZA == 0) {
                    aj.c(this, d.C0096d.cp_link_tip_a, 1);
                } else {
                    aj.c(this, this.cZA, 1);
                }
            } else {
                aj.c(this, d.C0096d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.cZy == null) {
            return -1;
        }
        return this.cZy.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void wC() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.cZz) {
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
        if (this.cZy == null) {
            return null;
        }
        return this.cZy.url;
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
        this.cZz = z;
    }

    public void setSelectItemColorResId(int i) {
        this.cZA = i;
    }
}
