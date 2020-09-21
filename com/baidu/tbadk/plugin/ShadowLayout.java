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
    private RectF Gl;
    private int cNY;
    private int eWj;
    private int eWk;
    private int eWl;
    private int eWm;
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
        this.eWj = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.eWj, this.eWj, this.eWj, this.eWj);
        this.eWm = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.eWk = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.eWl = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cNY = ap.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.eWk, this.eWl, this.cNY);
        this.Gl = new RectF();
    }

    public void setShadowColor(int i) {
        this.cNY = ap.getColor(i);
        bvD();
    }

    private void bvD() {
        this.paint.setShadowLayer(this.mShadowRadius, this.eWk, this.eWl, this.cNY);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Gl.left = getPaddingLeft();
        this.Gl.right = getWidth() - getPaddingRight();
        this.Gl.bottom = getHeight() - getPaddingBottom();
        this.Gl.top = getPaddingTop();
        canvas.drawRoundRect(this.Gl, this.eWm, this.eWm, this.paint);
    }
}
