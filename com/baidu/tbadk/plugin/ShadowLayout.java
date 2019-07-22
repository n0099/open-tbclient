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
    private int cBp;
    private int cBq;
    private int cBr;
    private int cBs;
    private int cBt;
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
        this.cBp = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.cBp, this.cBp, this.cBp, this.cBp);
        this.cBt = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.cBq = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.cBr = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cBs = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.cBq, this.cBr, this.cBs);
        this.qe = new RectF();
    }

    public void setShadowColor(int i) {
        this.cBs = am.getColor(i);
        avG();
    }

    private void avG() {
        this.paint.setShadowLayer(this.mShadowRadius, this.cBq, this.cBr, this.cBs);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.qe.left = getPaddingLeft();
        this.qe.right = getWidth() - getPaddingRight();
        this.qe.bottom = getHeight() - getPaddingBottom();
        this.qe.top = getPaddingTop();
        canvas.drawRoundRect(this.qe, this.cBt, this.cBt, this.paint);
    }
}
