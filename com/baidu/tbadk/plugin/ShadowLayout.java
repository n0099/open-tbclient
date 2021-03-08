package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private int dyL;
    private int fMA;
    private int fMB;
    private int fMC;
    private int fMz;
    private int mShadowRadius;
    private Paint paint;
    private RectF rectF;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        rX();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        rX();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        rX();
    }

    private void rX() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.fMz = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.fMz, this.fMz, this.fMz, this.fMz);
        this.fMC = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.fMA = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.fMB = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dyL = ap.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.fMA, this.fMB, this.dyL);
        this.rectF = new RectF();
    }

    public void setShadowColor(int i) {
        this.dyL = ap.getColor(i);
        bEz();
    }

    private void bEz() {
        this.paint.setShadowLayer(this.mShadowRadius, this.fMA, this.fMB, this.dyL);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.rectF.left = getPaddingLeft();
        this.rectF.right = getWidth() - getPaddingRight();
        this.rectF.bottom = getHeight() - getPaddingBottom();
        this.rectF.top = getPaddingTop();
        canvas.drawRoundRect(this.rectF, this.fMC, this.fMC, this.paint);
    }
}
