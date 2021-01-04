package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private int dzP;
    private int fNv;
    private int fNw;
    private int fNx;
    private int fNy;
    private int mShadowRadius;
    private Paint paint;
    private RectF rectF;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        sa();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        sa();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        sa();
    }

    private void sa() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.fNv = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.fNv, this.fNv, this.fNv, this.fNv);
        this.fNy = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.fNw = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.fNx = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dzP = ao.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.fNw, this.fNx, this.dzP);
        this.rectF = new RectF();
    }

    public void setShadowColor(int i) {
        this.dzP = ao.getColor(i);
        bHU();
    }

    private void bHU() {
        this.paint.setShadowLayer(this.mShadowRadius, this.fNw, this.fNx, this.dzP);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.rectF.left = getPaddingLeft();
        this.rectF.right = getWidth() - getPaddingRight();
        this.rectF.bottom = getHeight() - getPaddingBottom();
        this.rectF.top = getPaddingTop();
        canvas.drawRoundRect(this.rectF, this.fNy, this.fNy, this.paint);
    }
}
