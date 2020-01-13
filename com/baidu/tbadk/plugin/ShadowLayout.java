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
    private int cYM;
    private int dAY;
    private int dAZ;
    private int dBa;
    private int dBb;
    private RectF jD;
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
        this.dAY = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.dAY, this.dAY, this.dAY, this.dAY);
        this.dBb = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.dAZ = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.dBa = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.cYM = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.dAZ, this.dBa, this.cYM);
        this.jD = new RectF();
    }

    public void setShadowColor(int i) {
        this.cYM = am.getColor(i);
        aPe();
    }

    private void aPe() {
        this.paint.setShadowLayer(this.mShadowRadius, this.dAZ, this.dBa, this.cYM);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.jD.left = getPaddingLeft();
        this.jD.right = getWidth() - getPaddingRight();
        this.jD.bottom = getHeight() - getPaddingBottom();
        this.jD.top = getPaddingTop();
        canvas.drawRoundRect(this.jD, this.dBb, this.dBb, this.paint);
    }
}
