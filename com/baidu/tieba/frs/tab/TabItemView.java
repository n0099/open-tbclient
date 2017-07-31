package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int cwk = 0;
    public static int cwl = 1;
    public static int cwm = 2;
    private d cwn;
    private boolean cwo;
    private int cwp;
    private int mState;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = cwk;
        this.cwp = 0;
        this.cwn = dVar;
        this.cwo = z;
        n(context, i);
    }

    private void n(Context context, int i) {
        if (this.cwo) {
            setPadding(0, k.g(getContext(), d.f.ds16), 0, 0);
            setTextSize(0, k.g(context, d.f.ds32));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cwn != null) {
            setText(this.cwn.name);
        }
        xd();
    }

    public void setState(int i) {
        if (this.cwn != null && this.cwn.cwj != null && this.cwn.cwj.clO != null && this.cwn.cwj.clO.size() > 0) {
            int i2 = -k.g(getContext(), d.f.ds10);
            if (!this.cwo) {
                i2 = 0;
            }
            if (i == cwm) {
                Drawable drawable = ai.getDrawable(d.g.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = ai.getDrawable(d.g.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(d.f.ds8));
        }
        if (this.cwo) {
            ai.c(this, d.e.cp_cont_b, 1);
        } else {
            if (i == cwl || i == cwm) {
                if (this.cwp == 0) {
                    ai.c(this, d.e.cp_link_tip_a, 1);
                } else {
                    ai.c(this, this.cwp, 1);
                }
            } else {
                ai.c(this, d.e.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.cwn == null) {
            return -1;
        }
        return this.cwn.cwi;
    }

    public int getState() {
        return this.mState;
    }

    public void xd() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.cwo) {
                setPadding(0, k.g(getContext(), d.f.ds16), spaceWidth, 0);
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
        if (this.cwn == null) {
            return null;
        }
        return this.cwn.url;
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
        this.cwo = z;
    }

    public void setSelectItemColorResId(int i) {
        this.cwp = i;
    }
}
