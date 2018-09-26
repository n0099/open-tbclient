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
/* loaded from: classes2.dex */
public class TabItemView extends TextView {
    private d dMs;
    private boolean dMt;
    private int dMu;
    private int mState;
    public static int dMq = 0;
    public static int dMr = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = dMq;
        this.dMu = 0;
        this.dMs = dVar;
        this.dMt = z;
        n(context, i);
    }

    private void n(Context context, int i) {
        if (this.dMt) {
            setPadding(0, l.h(getContext(), e.C0141e.tbds20), 0, 0);
            setTextSize(0, l.h(context, e.C0141e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.dMs != null) {
            setText(this.dMs.name);
        }
        BQ();
    }

    public void setState(int i) {
        if (this.dMs != null && this.dMs.dMp != null && this.dMs.dMp.dvD != null && this.dMs.dMp.dvD.size() > 0) {
            int i2 = -l.h(getContext(), e.C0141e.tbds20);
            if (!this.dMt) {
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
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(e.C0141e.tbds20));
        }
        if (this.dMt) {
            al.c(this, e.d.cp_cont_b, 1);
        } else {
            if (i == dMr || i == STATE_EXPANDED) {
                if (this.dMu == 0) {
                    al.c(this, e.d.cp_link_tip_a, 1);
                } else {
                    al.c(this, this.dMu, 1);
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
        if (this.dMs == null) {
            return -1;
        }
        return this.dMs.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void BQ() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.dMt) {
                setPadding(0, l.h(getContext(), e.C0141e.ds16), spaceWidth, 0);
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
        if (this.dMs == null) {
            return null;
        }
        return this.dMs.url;
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
        this.dMt = z;
    }

    public void setSelectItemColorResId(int i) {
        this.dMu = i;
    }
}
