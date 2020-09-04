package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private String bottomText;
    private int bottomTextPadding;
    private Drawable foregroundDrawable;
    private Paint textPaint;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.textPaint = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.textPaint = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.textPaint = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.textPaint.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.textPaint.setColor(ap.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.bottomText = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.bottomTextPadding = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(ap.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.foregroundDrawable = drawable;
        if (this.foregroundDrawable != null) {
            this.foregroundDrawable.setBounds(0, 0, this.foregroundDrawable.getIntrinsicHeight(), this.foregroundDrawable.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.foregroundDrawable != null && this.foregroundDrawable.isStateful() && this.foregroundDrawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.foregroundDrawable != null) {
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
            int intrinsicWidth = this.foregroundDrawable.getIntrinsicWidth();
            int intrinsicHeight = this.foregroundDrawable.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.foregroundDrawable.draw(canvas);
            canvas.restore();
            drawNoImageBottomText(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void drawNoImageBottomText(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.bottomText) && !k.bbM().isShowImages()) {
            canvas.drawText(this.bottomText, (int) (i - (this.textPaint.measureText(this.bottomText) / 2.0f)), this.bottomTextPadding + i2, this.textPaint);
        }
    }
}
