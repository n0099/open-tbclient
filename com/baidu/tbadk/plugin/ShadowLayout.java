package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private RectF GD;
    private int diF;
    private int fqS;
    private int fqT;
    private int fqU;
    private int fqV;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        sw();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        sw();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        sw();
    }

    private void sw() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.fqS = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.fqS, this.fqS, this.fqS, this.fqS);
        this.fqV = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.fqT = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.fqU = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.diF = ap.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.fqT, this.fqU, this.diF);
        this.GD = new RectF();
    }

    public void setShadowColor(int i) {
        this.diF = ap.getColor(i);
        bAg();
    }

    private void bAg() {
        this.paint.setShadowLayer(this.mShadowRadius, this.fqT, this.fqU, this.diF);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.GD.left = getPaddingLeft();
        this.GD.right = getWidth() - getPaddingRight();
        this.GD.bottom = getHeight() - getPaddingBottom();
        this.GD.top = getPaddingTop();
        canvas.drawRoundRect(this.GD, this.fqV, this.fqV, this.paint);
    }
}
