package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class TabItemView extends TextView {
    private d dzo;
    private boolean dzp;
    private int dzq;
    private int mState;
    public static int dzm = 0;
    public static int dzn = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = dzm;
        this.dzq = 0;
        this.dzo = dVar;
        this.dzp = z;
        k(context, i);
    }

    private void k(Context context, int i) {
        if (this.dzp) {
            setPadding(0, l.e(getContext(), d.e.tbds20), 0, 0);
            setTextSize(0, l.e(context, d.e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.dzo != null) {
            setText(this.dzo.name);
        }
        Ay();
    }

    public void setState(int i) {
        if (this.dzo != null && this.dzo.dzl != null && this.dzo.dzl.dkz != null && this.dzo.dzl.dkz.size() > 0) {
            int i2 = -l.e(getContext(), d.e.tbds20);
            if (!this.dzp) {
                i2 = 0;
            }
            if (i == STATE_EXPANDED) {
                Drawable drawable = al.getDrawable(d.f.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = al.getDrawable(d.f.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(d.e.tbds20));
        }
        if (this.dzp) {
            al.c(this, d.C0141d.cp_cont_b, 1);
        } else {
            if (i == dzn || i == STATE_EXPANDED) {
                if (this.dzq == 0) {
                    al.c(this, d.C0141d.cp_link_tip_a, 1);
                } else {
                    al.c(this, this.dzq, 1);
                }
            } else {
                al.c(this, d.C0141d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.dzo == null) {
            return -1;
        }
        return this.dzo.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void Ay() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.dzp) {
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
        if (this.dzo == null) {
            return null;
        }
        return this.dzo.url;
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
        this.dzp = z;
    }

    public void setSelectItemColorResId(int i) {
        this.dzq = i;
    }
}
