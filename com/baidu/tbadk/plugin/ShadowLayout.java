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
    private RectF Hx;
    private int dtT;
    private int fDQ;
    private int fDR;
    private int fDS;
    private int fDT;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        sz();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        sz();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        sz();
    }

    private void sz() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.fDQ = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.fDQ, this.fDQ, this.fDQ, this.fDQ);
        this.fDT = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.fDR = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.fDS = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dtT = ap.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.fDR, this.fDS, this.dtT);
        this.Hx = new RectF();
    }

    public void setShadowColor(int i) {
        this.dtT = ap.getColor(i);
        bFz();
    }

    private void bFz() {
        this.paint.setShadowLayer(this.mShadowRadius, this.fDR, this.fDS, this.dtT);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Hx.left = getPaddingLeft();
        this.Hx.right = getWidth() - getPaddingRight();
        this.Hx.bottom = getHeight() - getPaddingBottom();
        this.Hx.top = getPaddingTop();
        canvas.drawRoundRect(this.Hx, this.fDT, this.fDT, this.paint);
    }
}
