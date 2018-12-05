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
    private d ebX;
    private boolean ebY;
    private int ebZ;
    private int mState;
    public static int ebV = 0;
    public static int ebW = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = ebV;
        this.ebZ = 0;
        this.ebX = dVar;
        this.ebY = z;
        o(context, i);
    }

    private void o(Context context, int i) {
        if (this.ebY) {
            setPadding(0, l.h(getContext(), e.C0210e.tbds20), 0, 0);
            setTextSize(0, l.h(context, e.C0210e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.ebX != null) {
            setText(this.ebX.name);
        }
        Fj();
    }

    public void setState(int i) {
        if (this.ebX != null && this.ebX.ebU != null && this.ebX.ebU.dLt != null && this.ebX.ebU.dLt.size() > 0) {
            int i2 = -l.h(getContext(), e.C0210e.tbds20);
            if (!this.ebY) {
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
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(e.C0210e.tbds20));
        }
        if (this.ebY) {
            al.c(this, e.d.cp_cont_b, 1);
        } else {
            if (i == ebW || i == STATE_EXPANDED) {
                if (this.ebZ == 0) {
                    al.c(this, e.d.cp_link_tip_a, 1);
                } else {
                    al.c(this, this.ebZ, 1);
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
        if (this.ebX == null) {
            return -1;
        }
        return this.ebX.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void Fj() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.ebY) {
                setPadding(0, l.h(getContext(), e.C0210e.ds16), spaceWidth, 0);
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
        if (this.ebX == null) {
            return null;
        }
        return this.ebX.url;
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
        this.ebY = z;
    }

    public void setSelectItemColorResId(int i) {
        this.ebZ = i;
    }
}
