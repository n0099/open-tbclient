package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class TabItemView extends TextView {
    private d dVu;
    private boolean dVv;
    private int dVw;
    private int mState;
    public static int dVs = 0;
    public static int dVt = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = dVs;
        this.dVw = 0;
        this.dVu = dVar;
        this.dVv = z;
        o(context, i);
    }

    private void o(Context context, int i) {
        if (this.dVv) {
            setPadding(0, l.h(getContext(), e.C0200e.tbds20), 0, 0);
            setTextSize(0, l.h(context, e.C0200e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.dVu != null) {
            setText(this.dVu.name);
        }
        Ef();
    }

    public void setState(int i) {
        if (this.dVu != null && this.dVu.dVr != null && this.dVu.dVr.dEU != null && this.dVu.dVr.dEU.size() > 0) {
            int i2 = -l.h(getContext(), e.C0200e.tbds20);
            if (!this.dVv) {
                i2 = 0;
            }
            if (i == STATE_EXPANDED) {
                Drawable drawable = al.getDrawable(e.f.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = al.getDrawable(e.f.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(e.C0200e.tbds20));
        }
        if (this.dVv) {
            al.c(this, e.d.cp_cont_b, 1);
        } else {
            if (i == dVt || i == STATE_EXPANDED) {
                if (this.dVw == 0) {
                    al.c(this, e.d.cp_link_tip_a, 1);
                } else {
                    al.c(this, this.dVw, 1);
                }
            } else {
                al.c(this, e.d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.dVu == null) {
            return -1;
        }
        return this.dVu.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void Ef() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.dVv) {
                setPadding(0, l.h(getContext(), e.C0200e.ds16), spaceWidth, 0);
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
        if (this.dVu == null) {
            return null;
        }
        return this.dVu.url;
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
        this.dVv = z;
    }

    public void setSelectItemColorResId(int i) {
        this.dVw = i;
    }
}
