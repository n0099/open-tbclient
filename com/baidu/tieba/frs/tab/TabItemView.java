package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int baV = 0;
    public static int baW = 1;
    public static int baX = 2;
    private g baY;
    private int mState;

    public TabItemView(Context context, g gVar, int i) {
        super(context);
        this.mState = baV;
        this.baY = gVar;
        j(context, i);
    }

    private void j(Context context, int i) {
        setWidth(context.getResources().getDimensionPixelSize(i.d.ds160));
        setHeight(context.getResources().getDimensionPixelSize(i.d.ds80));
        setGravity(17);
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.baY != null) {
            setText(this.baY.name);
        }
        vD();
    }

    public void setState(int i) {
        if (this.baY != null && this.baY.baU != null && this.baY.baU.size() > 0) {
            if (i == baX) {
                Drawable drawable = al.getDrawable(i.e.icon_toolbar_arrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = al.getDrawable(i.e.icon_toolbar_arrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(i.d.ds16));
        }
        if (i == baW || i == baX) {
            al.b(this, i.c.cp_link_tip_a, 1);
        } else {
            al.b(this, i.c.cp_cont_f, 1);
        }
        setGravity(17);
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.baY == null) {
            return -1;
        }
        return this.baY.baT;
    }

    public int getState() {
        return this.mState;
    }

    public void vD() {
        setState(this.mState);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && (drawable = compoundDrawables[2]) != null) {
            float intrinsicWidth = drawable.getIntrinsicWidth() + getPaint().measureText(getText().toString()) + getCompoundDrawablePadding();
            setPadding(0, 0, (int) (getWidth() - intrinsicWidth), 0);
            canvas.translate((getWidth() - intrinsicWidth) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }
}
