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
    private int cLY;
    private int eTt;
    private int eTu;
    private int eTv;
    private int eTw;
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
        this.eTt = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.eTt, this.eTt, this.eTt, this.eTt);
        this.eTw = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.eTu = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.eTv = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cLY = ap.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.eTu, this.eTv, this.cLY);
        this.Gl = new RectF();
    }

    public void setShadowColor(int i) {
        this.cLY = ap.getColor(i);
        buz();
    }

    private void buz() {
        this.paint.setShadowLayer(this.mShadowRadius, this.eTu, this.eTv, this.cLY);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Gl.left = getPaddingLeft();
        this.Gl.right = getWidth() - getPaddingRight();
        this.Gl.bottom = getHeight() - getPaddingBottom();
        this.Gl.top = getPaddingTop();
        canvas.drawRoundRect(this.Gl, this.eTw, this.eTw, this.paint);
    }
}
