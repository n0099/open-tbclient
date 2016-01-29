package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class TabItemView extends TextView {
    public static int boZ = 0;
    public static int bpa = 1;
    public static int bpb = 2;
    private h bpc;
    private int mState;

    public TabItemView(Context context, h hVar, int i) {
        super(context);
        this.mState = boZ;
        this.bpc = hVar;
        h(context, i);
    }

    private void h(Context context, int i) {
        setGravity(17);
        setSingleLine();
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (this.bpc != null) {
            setText(this.bpc.name);
        }
        xf();
    }

    public void setState(int i) {
        if (this.bpc != null && this.bpc.boY != null && this.bpc.boY.bly != null && this.bpc.boY.bly.size() > 0) {
            if (i == bpb) {
                Drawable drawable = ar.getDrawable(t.f.icon_toolbar_arrow_up);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                setCompoundDrawables(null, null, drawable, null);
            } else {
                Drawable drawable2 = ar.getDrawable(t.f.icon_toolbar_arrow_down);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                setCompoundDrawables(null, null, drawable2, null);
            }
            setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(t.e.ds16));
        }
        if (i == bpa || i == bpb) {
            ar.b(this, t.d.s_actionbar_text_line_color_s, 1);
        } else {
            ar.b(this, t.d.cp_cont_f, 1);
        }
        setGravity(17);
        this.mState = i;
        invalidate();
    }

    public int getTabId() {
        if (this.bpc == null) {
            return -1;
        }
        return this.bpc.boX;
    }

    public int getState() {
        return this.mState;
    }

    public void xf() {
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
        float measureText = getPaint().measureText(getText().toString());
        return getWidth() - ((drawable.getIntrinsicWidth() + ((int) measureText)) + getCompoundDrawablePadding());
    }
}
