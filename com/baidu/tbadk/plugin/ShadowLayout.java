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
    private int cMK;
    private int cML;
    private int cMM;
    private int cMN;
    private int cMO;
    private RectF hQ;
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
        this.cMK = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.cMK, this.cMK, this.cMK, this.cMK);
        this.cMO = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.cML = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.cMM = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cMN = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.cML, this.cMM, this.cMN);
        this.hQ = new RectF();
    }

    public void setShadowColor(int i) {
        this.cMN = am.getColor(i);
        awX();
    }

    private void awX() {
        this.paint.setShadowLayer(this.mShadowRadius, this.cML, this.cMM, this.cMN);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.hQ.left = getPaddingLeft();
        this.hQ.right = getWidth() - getPaddingRight();
        this.hQ.bottom = getHeight() - getPaddingBottom();
        this.hQ.top = getPaddingTop();
        canvas.drawRoundRect(this.hQ, this.cMO, this.cMO, this.paint);
    }
}
