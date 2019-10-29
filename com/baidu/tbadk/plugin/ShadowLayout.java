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
    private int cNB;
    private int cNC;
    private int cND;
    private int cNE;
    private int cNF;
    private RectF iu;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        lj();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        lj();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        lj();
    }

    private void lj() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.cNB = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.cNB, this.cNB, this.cNB, this.cNB);
        this.cNF = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.cNC = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.cND = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cNE = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.cNC, this.cND, this.cNE);
        this.iu = new RectF();
    }

    public void setShadowColor(int i) {
        this.cNE = am.getColor(i);
        awZ();
    }

    private void awZ() {
        this.paint.setShadowLayer(this.mShadowRadius, this.cNC, this.cND, this.cNE);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.iu.left = getPaddingLeft();
        this.iu.right = getWidth() - getPaddingRight();
        this.iu.bottom = getHeight() - getPaddingBottom();
        this.iu.top = getPaddingTop();
        canvas.drawRoundRect(this.iu, this.cNF, this.cNF, this.paint);
    }
}
