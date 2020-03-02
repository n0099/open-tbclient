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
    private int dFa;
    private int dFb;
    private int dFc;
    private int dFd;
    private int dcR;
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
        this.dFa = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.dFa, this.dFa, this.dFa, this.dFa);
        this.dFd = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.dFb = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.dFc = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dcR = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.dFb, this.dFc, this.dcR);
        this.jH = new RectF();
    }

    public void setShadowColor(int i) {
        this.dcR = am.getColor(i);
        aRw();
    }

    private void aRw() {
        this.paint.setShadowLayer(this.mShadowRadius, this.dFb, this.dFc, this.dcR);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.jH.left = getPaddingLeft();
        this.jH.right = getWidth() - getPaddingRight();
        this.jH.bottom = getHeight() - getPaddingBottom();
        this.jH.top = getPaddingTop();
        canvas.drawRoundRect(this.jH, this.dFd, this.dFd, this.paint);
    }
}
