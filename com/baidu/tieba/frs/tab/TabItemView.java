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
    public static int cyl = 0;
    public static int cym = 1;
    public static int cyn = 2;
    private d cyo;
    private boolean cyp;
    private int cyq;
    private int mState;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = cyl;
        this.cyq = 0;
        this.cyo = dVar;
        this.cyp = z;
        n(context, i);
    }

    private void n(Context context, int i) {
        if (this.cyp) {
            setPadding(0, k.g(getContext(), d.f.ds16), 0, 0);
            setTextSize(0, k.g(context, d.f.ds32));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cyo != null) {
            setText(this.cyo.name);
        }
        xd();
    }

    public void setState(int i) {
        if (this.cyo != null && this.cyo.cyk != null && this.cyo.cyk.cmB != null && this.cyo.cyk.cmB.size() > 0) {
            int i2 = -k.g(getContext(), d.f.ds10);
            if (!this.cyp) {
                i2 = 0;
            }
            if (i == cyn) {
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
        if (this.cyp) {
            ai.c(this, d.e.cp_cont_b, 1);
        } else {
            if (i == cym || i == cyn) {
                if (this.cyq == 0) {
                    ai.c(this, d.e.cp_link_tip_a, 1);
                } else {
                    ai.c(this, this.cyq, 1);
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
        if (this.cyo == null) {
            return -1;
        }
        return this.cyo.cuL;
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
            if (this.cyp) {
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
        if (this.cyo == null) {
            return null;
        }
        return this.cyo.url;
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
        this.cyp = z;
    }

    public void setSelectItemColorResId(int i) {
        this.cyq = i;
    }
}
