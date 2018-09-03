package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class TabItemView extends TextView {
    private d dFk;
    private boolean dFl;
    private int dFm;
    private int mState;
    public static int dFi = 0;
    public static int dFj = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = dFi;
        this.dFm = 0;
        this.dFk = dVar;
        this.dFl = z;
        l(context, i);
    }

    private void l(Context context, int i) {
        if (this.dFl) {
            setPadding(0, l.f(getContext(), f.e.tbds20), 0, 0);
            setTextSize(0, l.f(context, f.e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.dFk != null) {
            setText(this.dFk.name);
        }
        AD();
    }

    public void setState(int i) {
        if (this.dFk != null && this.dFk.dFh != null && this.dFk.dFh.dpw != null && this.dFk.dFh.dpw.size() > 0) {
            int i2 = -l.f(getContext(), f.e.tbds20);
            if (!this.dFl) {
                i2 = 0;
            }
            if (i == STATE_EXPANDED) {
                Drawable drawable = am.getDrawable(f.C0146f.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = am.getDrawable(f.C0146f.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(f.e.tbds20));
        }
        if (this.dFl) {
            am.c(this, f.d.cp_cont_b, 1);
        } else {
            if (i == dFj || i == STATE_EXPANDED) {
                if (this.dFm == 0) {
                    am.c(this, f.d.cp_link_tip_a, 1);
                } else {
                    am.c(this, this.dFm, 1);
                }
            } else {
                am.c(this, f.d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.dFk == null) {
            return -1;
        }
        return this.dFk.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void AD() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.dFl) {
                setPadding(0, l.f(getContext(), f.e.ds16), spaceWidth, 0);
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
        if (this.dFk == null) {
            return null;
        }
        return this.dFk.url;
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
        this.dFl = z;
    }

    public void setSelectItemColorResId(int i) {
        this.dFm = i;
    }
}
