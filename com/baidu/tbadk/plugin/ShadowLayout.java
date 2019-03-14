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
    private int crQ;
    private int crR;
    private int crS;
    private int crT;
    private int crU;
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
        this.crQ = getContext().getResources().getDimensionPixelSize(d.e.tbds20);
        setPadding(this.crQ, this.crQ, this.crQ, this.crQ);
        this.crU = getContext().getResources().getDimensionPixelSize(d.e.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(d.e.tbds10);
        this.crR = getContext().getResources().getDimensionPixelSize(d.e.tbds2);
        this.crS = getContext().getResources().getDimensionPixelSize(d.e.tbds5);
        this.crT = al.getColor(d.C0277d.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.crR, this.crS, this.crT);
        this.sz = new RectF();
    }

    public void setShadowColor(int i) {
        this.crT = al.getColor(i);
        apx();
    }

    private void apx() {
        this.paint.setShadowLayer(this.mShadowRadius, this.crR, this.crS, this.crT);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.sz.left = getPaddingLeft();
        this.sz.right = getWidth() - getPaddingRight();
        this.sz.bottom = getHeight() - getPaddingBottom();
        this.sz.top = getPaddingTop();
        canvas.drawRoundRect(this.sz, this.crU, this.crU, this.paint);
    }
}
