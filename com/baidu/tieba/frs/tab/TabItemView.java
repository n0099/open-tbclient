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
/* loaded from: classes4.dex */
public class TabItemView extends TextView {
    private d ftL;
    private boolean ftM;
    private int ftN;
    private int mState;
    public static int ftJ = 0;
    public static int ftK = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = ftJ;
        this.ftN = 0;
        this.ftL = dVar;
        this.ftM = z;
        m(context, i);
    }

    private void m(Context context, int i) {
        if (this.ftM) {
            setPadding(0, l.h(getContext(), d.e.tbds20), 0, 0);
            setTextSize(0, l.h(context, d.e.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.ftL != null) {
            setText(this.ftL.name);
        }
        aeK();
    }

    public void setState(int i) {
        if (this.ftL != null && this.ftL.ftI != null && this.ftL.ftI.fcE != null && this.ftL.ftI.fcE.size() > 0) {
            int i2 = -l.h(getContext(), d.e.tbds20);
            if (!this.ftM) {
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
        if (this.ftM) {
            al.d(this, d.C0277d.cp_cont_b, 1);
        } else {
            if (i == ftK || i == STATE_EXPANDED) {
                if (this.ftN == 0) {
                    al.d(this, d.C0277d.cp_link_tip_a, 1);
                } else {
                    al.d(this, this.ftN, 1);
                }
            } else {
                al.d(this, d.C0277d.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.ftL == null) {
            return -1;
        }
        return this.ftL.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void aeK() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.ftM) {
                setPadding(0, l.h(getContext(), d.e.ds16), spaceWidth, 0);
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
        if (this.ftL == null) {
            return null;
        }
        return this.ftL.url;
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
        this.ftM = z;
    }

    public void setSelectItemColorResId(int i) {
        this.ftN = i;
    }
}
