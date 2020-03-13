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
    private int dFn;
    private int dFo;
    private int dFp;
    private int dFq;
    private int dde;
    private RectF jH;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        lQ();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        lQ();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        lQ();
    }

    private void lQ() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.dFn = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.dFn, this.dFn, this.dFn, this.dFn);
        this.dFq = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.dFo = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.dFp = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dde = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.dFo, this.dFp, this.dde);
        this.jH = new RectF();
    }

    public void setShadowColor(int i) {
        this.dde = am.getColor(i);
        aRx();
    }

    private void aRx() {
        this.paint.setShadowLayer(this.mShadowRadius, this.dFo, this.dFp, this.dde);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.jH.left = getPaddingLeft();
        this.jH.right = getWidth() - getPaddingRight();
        this.jH.bottom = getHeight() - getPaddingBottom();
        this.jH.top = getPaddingTop();
        canvas.drawRoundRect(this.jH, this.dFq, this.dFq, this.paint);
    }
}
