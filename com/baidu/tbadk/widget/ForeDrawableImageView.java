package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aOR;
    private String aOS;
    private int aOT;
    private Paint aOU;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOU = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOU = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aOU = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aOU.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aOU.setColor(ak.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aOS = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aOT = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(ak.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aOR = drawable;
        if (this.aOR != null) {
            this.aOR.setBounds(0, 0, this.aOR.getIntrinsicHeight(), this.aOR.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aOR != null && this.aOR.isStateful() && this.aOR.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aOR != null) {
            canvas.save();
            ViewParent parent = getParent();
            if (!(parent instanceof View)) {
                i = 0;
            } else {
                i = ((View) parent).getMeasuredWidth();
            }
            int width = getWidth();
            if (width <= i) {
                i = width;
            }
            int intrinsicWidth = this.aOR.getIntrinsicWidth();
            int intrinsicHeight = this.aOR.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aOR.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aOS) && !i.pY().qe()) {
            canvas.drawText(this.aOS, (int) (i - (this.aOU.measureText(this.aOS) / 2.0f)), this.aOT + i2, this.aOU);
        }
    }
}
