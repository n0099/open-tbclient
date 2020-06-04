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
    private RectF Fg;
    private int dRc;
    private int etD;
    private int etE;
    private int etF;
    private int etG;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        qy();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        qy();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        qy();
    }

    private void qy() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.etD = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.etD, this.etD, this.etD, this.etD);
        this.etG = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.etE = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.etF = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dRc = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.etE, this.etF, this.dRc);
        this.Fg = new RectF();
    }

    public void setShadowColor(int i) {
        this.dRc = am.getColor(i);
        bfU();
    }

    private void bfU() {
        this.paint.setShadowLayer(this.mShadowRadius, this.etE, this.etF, this.dRc);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Fg.left = getPaddingLeft();
        this.Fg.right = getWidth() - getPaddingRight();
        this.Fg.bottom = getHeight() - getPaddingBottom();
        this.Fg.top = getPaddingTop();
        canvas.drawRoundRect(this.Fg, this.etG, this.etG, this.paint);
    }
}
