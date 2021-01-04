package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class TabItemView extends TextView {
    private d jGY;
    private boolean jGZ;
    private int jHa;
    private int mState;
    public static int jGW = 0;
    public static int jGX = 1;
    public static int STATE_EXPANDED = 2;

    public TabItemView(Context context, d dVar, int i, boolean z) {
        super(context);
        this.mState = jGW;
        this.jHa = 0;
        this.jGY = dVar;
        this.jGZ = z;
        w(context, i);
    }

    private void w(Context context, int i) {
        if (this.jGZ) {
            setPadding(0, l.getDimens(getContext(), R.dimen.tbds20), 0, 0);
            setTextSize(0, l.getDimens(context, R.dimen.tbds42));
        } else {
            setGravity(17);
        }
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.jGY != null) {
            setText(this.jGY.name);
        }
        bxO();
    }

    public void setState(int i) {
        if (this.jGY != null && this.jGY.jGV != null && this.jGY.jGV.jjK != null && this.jGY.jGV.jjK.size() > 0) {
            int i2 = -l.getDimens(getContext(), R.dimen.tbds20);
            if (!this.jGZ) {
                i2 = 0;
            }
            if (i == STATE_EXPANDED) {
                Drawable drawable = ao.getDrawable(R.drawable.icon_toolbar_arrow_up);
                drawable.setBounds(0, i2, drawable.getMinimumWidth(), drawable.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = ao.getDrawable(R.drawable.icon_arrow_gray_down);
                drawable2.setBounds(0, i2, drawable2.getMinimumWidth(), drawable2.getMinimumHeight() + i2);
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        }
        if (this.jGZ) {
            ao.setViewTextColor(this, R.color.CAM_X0105, 1);
        } else {
            if (i == jGX || i == STATE_EXPANDED) {
                if (this.jHa == 0) {
                    ao.setViewTextColor(this, R.color.CAM_X0302, 1);
                } else {
                    ao.setViewTextColor(this, this.jHa, 1);
                }
            } else {
                ao.setViewTextColor(this, R.color.CAM_X0106, 1);
            }
            setGravity(17);
        }
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.jGY == null) {
            return -1;
        }
        return this.jGY.tabId;
    }

    public int getState() {
        return this.mState;
    }

    public void bxO() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            if (this.jGZ) {
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
        if (this.jGY == null) {
            return null;
        }
        return this.jGY.url;
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
        this.jGZ = z;
    }

    public void setSelectItemColorResId(int i) {
        this.jHa = i;
    }
}
