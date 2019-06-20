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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private int cAa;
    private int cAb;
    private int cAc;
    private int cAd;
    private int czZ;
    private int mShadowRadius;
    private Paint paint;
    private RectF qc;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        pT();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        pT();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        pT();
    }

    private void pT() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.czZ = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.czZ, this.czZ, this.czZ, this.czZ);
        this.cAd = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.cAa = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.cAb = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cAc = al.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.cAa, this.cAb, this.cAc);
        this.qc = new RectF();
    }

    public void setShadowColor(int i) {
        this.cAc = al.getColor(i);
        aux();
    }

    private void aux() {
        this.paint.setShadowLayer(this.mShadowRadius, this.cAa, this.cAb, this.cAc);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.qc.left = getPaddingLeft();
        this.qc.right = getWidth() - getPaddingRight();
        this.qc.bottom = getHeight() - getPaddingBottom();
        this.qc.top = getPaddingTop();
        canvas.drawRoundRect(this.qc, this.cAd, this.cAd, this.paint);
    }
}
