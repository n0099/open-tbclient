package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private int crS;
    private int crT;
    private int crU;
    private int crV;
    private int crW;
    private int mShadowRadius;
    private Paint paint;
    private RectF sz;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        qY();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        qY();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        qY();
    }

    private void qY() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.crS = getContext().getResources().getDimensionPixelSize(d.e.tbds20);
        setPadding(this.crS, this.crS, this.crS, this.crS);
        this.crW = getContext().getResources().getDimensionPixelSize(d.e.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(d.e.tbds10);
        this.crT = getContext().getResources().getDimensionPixelSize(d.e.tbds2);
        this.crU = getContext().getResources().getDimensionPixelSize(d.e.tbds5);
        this.crV = al.getColor(d.C0236d.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.crT, this.crU, this.crV);
        this.sz = new RectF();
    }

    public void setShadowColor(int i) {
        this.crV = al.getColor(i);
        apy();
    }

    private void apy() {
        this.paint.setShadowLayer(this.mShadowRadius, this.crT, this.crU, this.crV);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.sz.left = getPaddingLeft();
        this.sz.right = getWidth() - getPaddingRight();
        this.sz.bottom = getHeight() - getPaddingBottom();
        this.sz.top = getPaddingTop();
        canvas.drawRoundRect(this.sz, this.crW, this.crW, this.paint);
    }
}
