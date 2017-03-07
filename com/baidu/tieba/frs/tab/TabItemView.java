package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int caO = 0;
    public static int caP = 1;
    public static int caQ = 2;
    private i caR;
    private int mState;

    public TabItemView(Context context, i iVar, int i) {
        super(context);
        this.mState = caO;
        this.caR = iVar;
        m(context, i);
    }

    private void m(Context context, int i) {
        setGravity(17);
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.caR != null) {
            setText(this.caR.name);
        }
        wP();
    }

    public void setState(int i) {
        if (this.caR != null && this.caR.caN != null && this.caR.caN.bQd != null && this.caR.caN.bQd.size() > 0) {
            if (i == caQ) {
                Drawable drawable = aq.getDrawable(w.g.icon_toolbar_arrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = aq.getDrawable(w.g.icon_toolbar_arrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(w.f.ds16));
        }
        if (i == caP || i == caQ) {
            aq.c(this, w.e.cp_link_tip_a, 1);
        } else {
            aq.c(this, w.e.cp_cont_f, 1);
        }
        setGravity(17);
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.caR == null) {
            return -1;
        }
        return this.caR.caM;
    }

    public int getState() {
        return this.mState;
    }

    public void wP() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int spaceWidth = getSpaceWidth();
        if (spaceWidth >= 0) {
            setPadding(0, 0, spaceWidth, 0);
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
        if (this.caR == null) {
            return null;
        }
        return this.caR.url;
    }

    public int getDrawableWidth() {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null || compoundDrawables.length < 3 || (drawable = compoundDrawables[2]) == null) {
            return 0;
        }
        return drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
    }
}
