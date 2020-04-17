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
    private RectF Fd;
    private int dCR;
    private int efk;
    private int efl;
    private int efm;
    private int efn;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        qs();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        qs();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        qs();
    }

    private void qs() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.efk = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.efk, this.efk, this.efk, this.efk);
        this.efn = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.efl = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.efm = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dCR = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.efl, this.efm, this.dCR);
        this.Fd = new RectF();
    }

    public void setShadowColor(int i) {
        this.dCR = am.getColor(i);
        aZL();
    }

    private void aZL() {
        this.paint.setShadowLayer(this.mShadowRadius, this.efl, this.efm, this.dCR);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Fd.left = getPaddingLeft();
        this.Fd.right = getWidth() - getPaddingRight();
        this.Fd.bottom = getHeight() - getPaddingBottom();
        this.Fd.top = getPaddingTop();
        canvas.drawRoundRect(this.Fd, this.efn, this.efn, this.paint);
    }
}
