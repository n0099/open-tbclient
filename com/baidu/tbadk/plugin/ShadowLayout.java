package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private int dxk;
    private int fKZ;
    private int fLa;
    private int fLb;
    private int fLc;
    private int mShadowRadius;
    private Paint paint;
    private RectF rectF;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        rX();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        rX();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        rX();
    }

    private void rX() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.fKZ = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.fKZ, this.fKZ, this.fKZ, this.fKZ);
        this.fLc = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.fLa = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.fLb = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dxk = ap.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.fLa, this.fLb, this.dxk);
        this.rectF = new RectF();
    }

    public void setShadowColor(int i) {
        this.dxk = ap.getColor(i);
        bEv();
    }

    private void bEv() {
        this.paint.setShadowLayer(this.mShadowRadius, this.fLa, this.fLb, this.dxk);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.rectF.left = getPaddingLeft();
        this.rectF.right = getWidth() - getPaddingRight();
        this.rectF.bottom = getHeight() - getPaddingBottom();
        this.rectF.top = getPaddingTop();
        canvas.drawRoundRect(this.rectF, this.fLc, this.fLc, this.paint);
    }
}
