package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int bbt = 0;
    public static int bbu = 1;
    public static int bbv = 2;
    private g bbw;
    private int mState;

    public TabItemView(Context context, g gVar, int i) {
        super(context);
        this.mState = bbt;
        this.bbw = gVar;
        j(context, i);
    }

    private void j(Context context, int i) {
        setGravity(17);
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.bbw != null) {
            setText(this.bbw.name);
        }
        vA();
    }

    public void setState(int i) {
        if (this.bbw != null && this.bbw.bbs != null && this.bbw.bbs.size() > 0) {
            if (i == bbv) {
                Drawable drawable = an.getDrawable(i.e.icon_toolbar_arrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = an.getDrawable(i.e.icon_toolbar_arrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(i.d.ds16));
        }
        if (i == bbu || i == bbv) {
            an.b(this, i.c.s_actionbar_text_line_color_s, 1);
        } else {
            an.b(this, i.c.cp_cont_f, 1);
        }
        setGravity(17);
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.bbw == null) {
            return -1;
        }
        return this.bbw.bbr;
    }

    public int getState() {
        return this.mState;
    }

    public void vA() {
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
            canvas.translate(spaceWidth / 2, 0.0f);
        }
        super.onDraw(canvas);
    }

    private int getSpaceWidth() {
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null || (drawable = compoundDrawables[2]) == null) {
            return -1;
        }
        return (int) (getWidth() - ((drawable.getIntrinsicWidth() + getPaint().measureText(getText().toString())) + getCompoundDrawablePadding()));
    }
}
