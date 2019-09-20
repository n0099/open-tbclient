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
    private int cCs;
    private int cCt;
    private int cCu;
    private int cCv;
    private int cCw;
    private int mShadowRadius;
    private Paint paint;
    private RectF qe;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        qq();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        qq();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        qq();
    }

    private void qq() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.cCs = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.cCs, this.cCs, this.cCs, this.cCs);
        this.cCw = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.cCt = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.cCu = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cCv = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.cCt, this.cCu, this.cCv);
        this.qe = new RectF();
    }

    public void setShadowColor(int i) {
        this.cCv = am.getColor(i);
        avU();
    }

    private void avU() {
        this.paint.setShadowLayer(this.mShadowRadius, this.cCt, this.cCu, this.cCv);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.qe.left = getPaddingLeft();
        this.qe.right = getWidth() - getPaddingRight();
        this.qe.bottom = getHeight() - getPaddingBottom();
        this.qe.top = getPaddingTop();
        canvas.drawRoundRect(this.qe, this.cCw, this.cCw, this.paint);
    }
}
