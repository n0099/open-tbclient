package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int cdE = 0;
    public static int cdF = 1;
    public static int cdG = 2;
    private i cdH;
    private int mState;

    public TabItemView(Context context, i iVar, int i) {
        super(context);
        this.mState = cdE;
        this.cdH = iVar;
        j(context, i);
    }

    private void j(Context context, int i) {
        setGravity(17);
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.cdH != null) {
            setText(this.cdH.name);
        }
        wH();
    }

    public void setState(int i) {
        if (this.cdH != null && this.cdH.cdD != null && this.cdH.cdD.bTm != null && this.cdH.cdD.bTm.size() > 0) {
            if (i == cdG) {
                Drawable drawable = av.getDrawable(r.f.icon_toolbar_arrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = av.getDrawable(r.f.icon_toolbar_arrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(r.e.ds16));
        }
        if (i == cdF || i == cdG) {
            av.c(this, r.d.cp_link_tip_a, 1);
        } else {
            av.c(this, r.d.cp_cont_f, 1);
        }
        setGravity(17);
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.cdH == null) {
            return -1;
        }
        return this.cdH.cdC;
    }

    public int getState() {
        return this.mState;
    }

    public void wH() {
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
        if (this.cdH == null) {
            return null;
        }
        return this.cdH.url;
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
