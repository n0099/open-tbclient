package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private RectF FG;
    private int dXU;
    private int eCu;
    private int eCv;
    private int eCw;
    private int eCx;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        qP();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        qP();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        qP();
    }

    private void qP() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.eCu = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.eCu, this.eCu, this.eCu, this.eCu);
        this.eCx = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.eCv = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.eCw = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dXU = an.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.eCv, this.eCw, this.dXU);
        this.FG = new RectF();
    }

    public void setShadowColor(int i) {
        this.dXU = an.getColor(i);
        bia();
    }

    private void bia() {
        this.paint.setShadowLayer(this.mShadowRadius, this.eCv, this.eCw, this.dXU);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.FG.left = getPaddingLeft();
        this.FG.right = getWidth() - getPaddingRight();
        this.FG.bottom = getHeight() - getPaddingBottom();
        this.FG.top = getPaddingTop();
        canvas.drawRoundRect(this.FG, this.eCx, this.eCx, this.paint);
    }
}
