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
import d.a.m0.r.k;
/* loaded from: classes3.dex */
public class ForeDrawableImageView extends TbImageView {
    public Drawable w0;
    public String x0;
    public int y0;
    public Paint z0;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.z0 = new Paint();
    }

    public final void b0(Canvas canvas, int i2, int i3) {
        if (StringUtils.isNull(this.x0) || k.c().g()) {
            return;
        }
        canvas.drawText(this.x0, (int) (i2 - (this.z0.measureText(this.x0) / 2.0f)), i3 + this.y0, this.z0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.w0;
        if (drawable != null && drawable.isStateful() && this.w0.setState(getDrawableState())) {
            invalidate();
        }
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
            int i2 = intrinsicWidth / 2;
            int i3 = (measuredWidth / 2) - i2;
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i3, height);
            this.w0.draw(canvas);
            canvas.restore();
            b0(canvas, i3 + i2, height + intrinsicHeight);
        }
    }

    public void setForegroundDrawable(int i2) {
        setForegroundDrawable(SkinManager.getDrawable(i2));
    }

    public void setNoImageBottomText(String str) {
        this.x0 = str;
    }

    public void setNoImageBottomTextColor(int i2) {
        this.z0.setColor(SkinManager.getColor(i2));
    }

    public void setNoImageBottomTextPadding(int i2) {
        this.y0 = i2;
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
