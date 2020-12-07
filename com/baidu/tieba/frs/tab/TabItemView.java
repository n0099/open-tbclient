package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class TabItemView extends TextView {
    private d juB;
    private boolean juC;
    private int juD;
    private int mState;
    public static int juz = 0;
    public static int juA = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = juz;
        this.juD = 0;
        this.juB = dVar;
        this.juC = z;
        v(context, i);
    }

    private void v(Context context, int i) {
        if (this.juC) {
            setPadding(0, l.getDimens(getContext(), R.dimen.tbds20), 0, 0);
            setTextSize(0, l.getDimens(context, R.dimen.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.juB != null) {
            setText(this.juB.name);
        }
        bvt();
    }

    public void setState(int i) {
        if (this.juB != null && this.juB.juy != null && this.juB.juy.iXv != null && this.juB.juy.iXv.size() > 0) {
            int i2 = -l.getDimens(getContext(), R.dimen.tbds20);
            if (!this.juC) {
                i2 = 0;
            }
            if (i == STATE_EXPANDED) {
                Drawable drawable = ap.getDrawable(R.drawable.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = ap.getDrawable(R.drawable.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        }
        if (this.juC) {
            ap.setViewTextColor(this, R.color.CAM_X0105, 1);
        } else {
            if (i == juA || i == STATE_EXPANDED) {
                if (this.juD == 0) {
                    ap.setViewTextColor(this, R.color.CAM_X0302, 1);
                } else {
                    ap.setViewTextColor(this, this.juD, 1);
                }
            } else {
                ap.setViewTextColor(this, R.color.CAM_X0106, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.juB == null) {
            return -1;
        }
        return this.juB.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void bvt() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.juC) {
                setPadding(0, l.getDimens(getContext(), R.dimen.ds16), spaceWidth, 0);
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
        if (this.juB == null) {
            return null;
        }
        return this.juB.url;
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
        this.juC = z;
    }

    public void setSelectItemColorResId(int i) {
        this.juD = i;
    }
}
