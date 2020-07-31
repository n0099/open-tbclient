package com.baidu.tbadk.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class ShadowLayout extends FrameLayout {
    private RectF FG;
    private int eIJ;
    private int eIK;
    private int eIL;
    private int eIM;
    private int eeo;
    private int mShadowRadius;
    private Paint paint;

    public ShadowLayout(@NonNull Context context) {
        super(context);
        qS();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        qS();
    }

    public ShadowLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        qS();
    }

    private void qS() {
        setWillNotDraw(false);
        setLayerType(1, null);
        this.eIJ = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.eIJ, this.eIJ, this.eIJ, this.eIJ);
        this.eIM = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.eIK = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.eIL = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.eeo = ao.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.eIK, this.eIL, this.eeo);
        this.FG = new RectF();
    }

    public void setShadowColor(int i) {
        this.eeo = ao.getColor(i);
        blL();
    }

    private void blL() {
        this.paint.setShadowLayer(this.mShadowRadius, this.eIK, this.eIL, this.eeo);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.FG.left = getPaddingLeft();
        this.FG.right = getWidth() - getPaddingRight();
        this.FG.bottom = getHeight() - getPaddingBottom();
        this.FG.top = getPaddingTop();
        canvas.drawRoundRect(this.FG, this.eIM, this.eIM, this.paint);
    }
}
