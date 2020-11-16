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
    private RectF GD;
    private int dmQ;
    private int fwb;
    private int fwc;
    private int fwd;
    private int fwe;
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
        this.fwb = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.fwb, this.fwb, this.fwb, this.fwb);
        this.fwe = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.fwc = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.fwd = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dmQ = ap.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.fwc, this.fwd, this.dmQ);
        this.GD = new RectF();
    }

    public void setShadowColor(int i) {
        this.dmQ = ap.getColor(i);
        bBY();
    }

    private void bBY() {
        this.paint.setShadowLayer(this.mShadowRadius, this.fwc, this.fwd, this.dmQ);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.GD.left = getPaddingLeft();
        this.GD.right = getWidth() - getPaddingRight();
        this.GD.bottom = getHeight() - getPaddingBottom();
        this.GD.top = getPaddingTop();
        canvas.drawRoundRect(this.GD, this.fwe, this.fwe, this.paint);
    }
}
