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
    private Drawable aOS;
    private String aOT;
    private int aOU;
    private Paint aOV;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOV = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOV = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aOV = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aOV.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aOV.setColor(ak.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aOT = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aOU = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(ak.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aOS = drawable;
        if (this.aOS != null) {
            this.aOS.setBounds(0, 0, this.aOS.getIntrinsicHeight(), this.aOS.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aOS != null && this.aOS.isStateful() && this.aOS.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aOS != null) {
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
            int intrinsicWidth = this.aOS.getIntrinsicWidth();
            int intrinsicHeight = this.aOS.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aOS.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aOT) && !i.pX().qd()) {
            canvas.drawText(this.aOT, (int) (i - (this.aOV.measureText(this.aOT) / 2.0f)), this.aOU + i2, this.aOV);
        }
    }
}
