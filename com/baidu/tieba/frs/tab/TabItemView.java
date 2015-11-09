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
    public static int bbP = 0;
    public static int bbQ = 1;
    public static int bbR = 2;
    private h bbS;
    private int mState;

    public TabItemView(Context context, h hVar, int i) {
        super(context);
        this.mState = bbP;
        this.bbS = hVar;
        j(context, i);
    }

    private void j(Context context, int i) {
        setGravity(17);
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.bbS != null) {
            setText(this.bbS.name);
        }
        vB();
    }

    public void setState(int i) {
        if (this.bbS != null && this.bbS.bbO != null && this.bbS.bbO.aYK != null && this.bbS.bbO.aYK.size() > 0) {
            if (i == bbR) {
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
        if (i == bbQ || i == bbR) {
            an.b(this, i.c.s_actionbar_text_line_color_s, 1);
        } else {
            an.b(this, i.c.cp_cont_f, 1);
        }
        setGravity(17);
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.bbS == null) {
            return -1;
        }
        return this.bbS.bbN;
    }

    public int getState() {
        return this.mState;
    }

    public void vB() {
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
        Drawable drawable;
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables != null && (drawable = compoundDrawables[2]) != null) {
            float intrinsicWidth = drawable.getIntrinsicWidth() + getPaint().measureText(getText().toString()) + getCompoundDrawablePadding();
            setPadding(0, 0, (int) (getWidth() - intrinsicWidth), 0);
            canvas.translate((getWidth() - intrinsicWidth) / 2.0f, 0.0f);
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
