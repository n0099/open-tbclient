package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int biu = 0;
    public static int biv = 1;
    public static int biw = 2;
    private h bix;
    private int mState;

    public TabItemView(Context context, h hVar, int i) {
        super(context);
        this.mState = biu;
        this.bix = hVar;
        j(context, i);
    }

    private void j(Context context, int i) {
        setGravity(17);
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.bix != null) {
            setText(this.bix.name);
        }
        wh();
    }

    public void setState(int i) {
        if (this.bix != null && this.bix.bit != null && this.bix.bit.beJ != null && this.bix.bit.beJ.size() > 0) {
            if (i == biw) {
                Drawable drawable = as.getDrawable(n.e.icon_toolbar_arrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = as.getDrawable(n.e.icon_toolbar_arrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(n.d.ds16));
        }
        if (i == biv || i == biw) {
            as.b(this, n.c.s_actionbar_text_line_color_s, 1);
        } else {
            as.b(this, n.c.cp_cont_f, 1);
        }
        setGravity(17);
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.bix == null) {
            return -1;
        }
        return this.bix.bis;
    }

    public int getState() {
        return this.mState;
    }

    public void wh() {
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
