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
    private int dCV;
    private int efp;
    private int efq;
    private int efr;
    private int efs;
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
        this.efp = getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
        setPadding(this.efp, this.efp, this.efp, this.efp);
        this.efs = getContext().getResources().getDimensionPixelSize(R.dimen.tbds25);
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.efq = getContext().getResources().getDimensionPixelSize(R.dimen.tbds2);
        this.efr = getContext().getResources().getDimensionPixelSize(R.dimen.tbds5);
        this.dCV = am.getColor(R.color.plugin_button_shadow_blue);
        this.paint = new Paint();
        this.paint.setColor(0);
        this.paint.setShadowLayer(this.mShadowRadius, this.efq, this.efr, this.dCV);
        this.Fg = new RectF();
    }

    public void setShadowColor(int i) {
        this.dCV = am.getColor(i);
        aZJ();
    }

    private void aZJ() {
        this.paint.setShadowLayer(this.mShadowRadius, this.efq, this.efr, this.dCV);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Fg.left = getPaddingLeft();
        this.Fg.right = getWidth() - getPaddingRight();
        this.Fg.bottom = getHeight() - getPaddingBottom();
        this.Fg.top = getPaddingTop();
        canvas.drawRoundRect(this.Fg, this.efs, this.efs, this.paint);
    }
}
