package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class TabItemView extends TextView {
    private d doU;
    private boolean doV;
    private int doW;
    private int mState;
    public static int doS = 0;
    public static int doT = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = doS;
        this.doW = 0;
        this.doU = dVar;
        this.doV = z;
        k(context, i);
    }

    private void k(Context context, int i) {
        if (this.doV) {
            setPadding(0, l.e(getContext(), d.e.tbds20), 0, 0);
            setTextSize(0, l.e(context, d.e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.doU != null) {
            setText(this.doU.name);
        }
        wY();
    }

    public void setState(int i) {
        if (this.doU != null && this.doU.doR != null && this.doU.doR.daa != null && this.doU.doR.daa.size() > 0) {
            int i2 = -l.e(getContext(), d.e.tbds20);
            if (!this.doV) {
                i2 = 0;
            }
            if (i == STATE_EXPANDED) {
                Drawable drawable = ak.getDrawable(d.f.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = ak.getDrawable(d.f.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(d.e.tbds20));
        }
        if (this.doV) {
            ak.c(this, d.C0126d.cp_cont_b, 1);
        } else {
            if (i == doT || i == STATE_EXPANDED) {
                if (this.doW == 0) {
                    ak.c(this, d.C0126d.cp_link_tip_a, 1);
                } else {
                    ak.c(this, this.doW, 1);
                }
            } else {
                ak.c(this, d.C0126d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.doU == null) {
            return -1;
        }
        return this.doU.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void wY() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.doV) {
                setPadding(0, l.e(getContext(), d.e.ds16), spaceWidth, 0);
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
        if (this.doU == null) {
            return null;
        }
        return this.doU.url;
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
        this.doV = z;
    }

    public void setSelectItemColorResId(int i) {
        this.doW = i;
    }
}
