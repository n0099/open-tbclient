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
    private d efu;
    private boolean efv;
    private int efw;
    private int mState;
    public static int efs = 0;
    public static int eft = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = efs;
        this.efw = 0;
        this.efu = dVar;
        this.efv = z;
        o(context, i);
    }

    private void o(Context context, int i) {
        if (this.efv) {
            setPadding(0, l.h(getContext(), e.C0210e.tbds20), 0, 0);
            setTextSize(0, l.h(context, e.C0210e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.efu != null) {
            setText(this.efu.name);
        }
        Fw();
    }

    public void setState(int i) {
        if (this.efu != null && this.efu.efr != null && this.efu.efr.dOQ != null && this.efu.efr.dOQ.size() > 0) {
            int i2 = -l.h(getContext(), e.C0210e.tbds20);
            if (!this.efv) {
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
        if (this.efv) {
            al.c(this, e.d.cp_cont_b, 1);
        } else {
            if (i == eft || i == STATE_EXPANDED) {
                if (this.efw == 0) {
                    al.c(this, e.d.cp_link_tip_a, 1);
                } else {
                    al.c(this, this.efw, 1);
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
        if (this.efu == null) {
            return -1;
        }
        return this.efu.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void Fw() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.efv) {
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
        if (this.efu == null) {
            return null;
        }
        return this.efu.url;
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
        this.efv = z;
    }

    public void setSelectItemColorResId(int i) {
        this.efw = i;
    }
}
