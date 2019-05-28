package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class TabItemView extends TextView {
    private d fKo;
    private boolean fKp;
    private int fKq;
    private int mState;
    public static int fKm = 0;
    public static int fKn = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = fKm;
        this.fKq = 0;
        this.fKo = dVar;
        this.fKp = z;
        m(context, i);
    }

    private void m(Context context, int i) {
        if (this.fKp) {
            setPadding(0, l.g(getContext(), R.dimen.tbds20), 0, 0);
            setTextSize(0, l.g(context, R.dimen.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.fKo != null) {
            setText(this.fKo.name);
        }
        ajG();
    }

    public void setState(int i) {
        if (this.fKo != null && this.fKo.fKl != null && this.fKo.fKl.fsG != null && this.fKo.fKl.fsG.size() > 0) {
            int i2 = -l.g(getContext(), R.dimen.tbds20);
            if (!this.fKp) {
                i2 = 0;
            }
            if (i == STATE_EXPANDED) {
                Drawable drawable = al.getDrawable(R.drawable.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = al.getDrawable(R.drawable.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        }
        if (this.fKp) {
            al.f(this, R.color.cp_cont_b, 1);
        } else {
            if (i == fKn || i == STATE_EXPANDED) {
                if (this.fKq == 0) {
                    al.f(this, R.color.cp_link_tip_a, 1);
                } else {
                    al.f(this, this.fKq, 1);
                }
            } else {
                al.f(this, R.color.cp_cont_f, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.fKo == null) {
            return -1;
        }
        return this.fKo.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void ajG() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.fKp) {
                setPadding(0, l.g(getContext(), R.dimen.ds16), spaceWidth, 0);
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
        if (this.fKo == null) {
            return null;
        }
        return this.fKo.url;
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
        this.fKp = z;
    }

    public void setSelectItemColorResId(int i) {
        this.fKq = i;
    }
}
