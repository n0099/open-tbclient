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
    private int dFD;
    private int dFE;
    private int dFF;
    private int dFG;
    private int ddr;
    private RectF jG;
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
        this.dFD = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.dFD, this.dFD, this.dFD, this.dFD);
        this.dFG = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.dFE = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.dFF = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.ddr = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.dFE, this.dFF, this.ddr);
        this.jG = new RectF();
    }

    public void setShadowColor(int i) {
        this.ddr = am.getColor(i);
        aRB();
    }

    private void aRB() {
        this.paint.setShadowLayer(this.mShadowRadius, this.dFE, this.dFF, this.ddr);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.jG.left = getPaddingLeft();
        this.jG.right = getWidth() - getPaddingRight();
        this.jG.bottom = getHeight() - getPaddingBottom();
        this.jG.top = getPaddingTop();
        canvas.drawRoundRect(this.jG, this.dFG, this.dFG, this.paint);
    }
}
