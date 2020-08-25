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
/* loaded from: classes2.dex */
public class ShadowLayout extends FrameLayout {
    private RectF Gl;
    private int cLU;
    private int eTp;
    private int eTq;
    private int eTr;
    private int eTs;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        sr();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        sr();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        sr();
    }

    private void sr() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.eTp = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.eTp, this.eTp, this.eTp, this.eTp);
        this.eTs = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.eTq = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.eTr = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cLU = ap.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.eTq, this.eTr, this.cLU);
        this.Gl = new RectF();
    }

    public void setShadowColor(int i) {
        this.cLU = ap.getColor(i);
        buy();
    }

    private void buy() {
        this.paint.setShadowLayer(this.mShadowRadius, this.eTq, this.eTr, this.cLU);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Gl.left = getPaddingLeft();
        this.Gl.right = getWidth() - getPaddingRight();
        this.Gl.bottom = getHeight() - getPaddingBottom();
        this.Gl.top = getPaddingTop();
        canvas.drawRoundRect(this.Gl, this.eTs, this.eTs, this.paint);
    }
}
