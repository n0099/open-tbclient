package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class TabItemView extends TextView {
    private b dUu;
    private boolean dUv;
    private int dUw;
    private int mState;
    public static int dUs = 0;
    public static int dUt = 1;
    public static int STATE_EXPANDED = 2;

    public void setState(int i) {
        if (this.dUu != null && this.dUu.dUr != null && this.dUu.dUr.dHr != null && this.dUu.dUr.dHr.size() > 0) {
            int i2 = -l.t(getContext(), d.e.tbds20);
            if (!this.dUv) {
                i2 = 0;
            }
            if (i == STATE_EXPANDED) {
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
        if (this.dUv) {
            aj.e(this, d.C0140d.cp_cont_b, 1);
        } else {
            if (i == dUt || i == STATE_EXPANDED) {
                if (this.dUw == 0) {
                    aj.e(this, d.C0140d.cp_link_tip_a, 1);
                } else {
                    aj.e(this, this.dUw, 1);
                }
            } else {
                aj.e(this, d.C0140d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.dUu == null) {
            return -1;
        }
        return this.dUu.tabId;
    }

    public int getState() {
        return this.mState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.dUv) {
                setPadding(0, l.t(getContext(), d.e.ds16), spaceWidth, 0);
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
        if (this.dUu == null) {
            return null;
        }
        return this.dUu.url;
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
        this.dUv = z;
    }

    public void setSelectItemColorResId(int i) {
        this.dUw = i;
    }
}
