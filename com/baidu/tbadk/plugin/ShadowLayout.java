package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private int cBA;
    private int cBw;
    private int cBx;
    private int cBy;
    private int cBz;
    private int mShadowRadius;
    private Paint paint;
    private RectF qe;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        qp();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        qp();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        qp();
    }

    private void qp() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.cBw = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.cBw, this.cBw, this.cBw, this.cBw);
        this.cBA = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.cBx = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.cBy = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cBz = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.cBx, this.cBy, this.cBz);
        this.qe = new RectF();
    }

    public void setShadowColor(int i) {
        this.cBz = am.getColor(i);
        avI();
    }

    private void avI() {
        this.paint.setShadowLayer(this.mShadowRadius, this.cBx, this.cBy, this.cBz);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.qe.left = getPaddingLeft();
        this.qe.right = getWidth() - getPaddingRight();
        this.qe.bottom = getHeight() - getPaddingBottom();
        this.qe.top = getPaddingTop();
        canvas.drawRoundRect(this.qe, this.cBA, this.cBA, this.paint);
    }
}
