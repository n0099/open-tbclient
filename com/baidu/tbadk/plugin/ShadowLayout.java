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
    private int cYC;
    private int dAO;
    private int dAP;
    private int dAQ;
    private int dAR;
    private RectF jE;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        lB();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        lB();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        lB();
    }

    private void lB() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.dAO = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.dAO, this.dAO, this.dAO, this.dAO);
        this.dAR = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.dAP = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.dAQ = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cYC = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.dAP, this.dAQ, this.cYC);
        this.jE = new RectF();
    }

    public void setShadowColor(int i) {
        this.cYC = am.getColor(i);
        aOL();
    }

    private void aOL() {
        this.paint.setShadowLayer(this.mShadowRadius, this.dAP, this.dAQ, this.cYC);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.jE.left = getPaddingLeft();
        this.jE.right = getWidth() - getPaddingRight();
        this.jE.bottom = getHeight() - getPaddingBottom();
        this.jE.top = getPaddingTop();
        canvas.drawRoundRect(this.jE, this.dAR, this.dAR, this.paint);
    }
}
