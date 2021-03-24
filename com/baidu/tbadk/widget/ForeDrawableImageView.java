package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import d.b.h0.r.k;
/* loaded from: classes3.dex */
public class ForeDrawableImageView extends TbImageView {
    public Drawable w0;
    public String x0;
    public int y0;
    public Paint z0;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z0 = new Paint();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.w0;
        if (drawable != null && drawable.isStateful() && this.w0.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void f0(Canvas canvas, int i, int i2) {
        if (StringUtils.isNull(this.x0) || k.c().g()) {
            return;
        }
        canvas.drawText(this.x0, (int) (i - (this.z0.measureText(this.x0) / 2.0f)), i2 + this.y0, this.z0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.w0 != null) {
            canvas.save();
            ViewParent parent = getParent();
            int measuredWidth = parent instanceof View ? ((View) parent).getMeasuredWidth() : 0;
            int width = getWidth();
            if (width <= measuredWidth) {
                measuredWidth = width;
            }
            int intrinsicWidth = this.w0.getIntrinsicWidth();
            int intrinsicHeight = this.w0.getIntrinsicHeight();
            int i = intrinsicWidth / 2;
            int i2 = (measuredWidth / 2) - i;
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.w0.draw(canvas);
            canvas.restore();
            f0(canvas, i2 + i, height + intrinsicHeight);
        }
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(SkinManager.getDrawable(i));
    }

    public void setNoImageBottomText(String str) {
        this.x0 = str;
    }

    public void setNoImageBottomTextColor(int i) {
        this.z0.setColor(SkinManager.getColor(i));
    }

    public void setNoImageBottomTextPadding(int i) {
        this.y0 = i;
    }

    public void setNoImageBottomTextSize(float f2) {
        if (f2 > 0.0f) {
            this.z0.setTextSize(f2);
        }
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.w0 = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicHeight(), this.w0.getMinimumWidth());
        }
        invalidate();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z0 = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.z0 = new Paint();
    }
}
