package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.ai;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aNV;
    private String aNW;
    private int aNX;
    private Paint aNY;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNY = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNY = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aNY = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aNY.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aNY.setColor(ai.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aNW = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aNX = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(ai.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aNV = drawable;
        if (this.aNV != null) {
            this.aNV.setBounds(0, 0, this.aNV.getIntrinsicHeight(), this.aNV.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aNV != null && this.aNV.isStateful() && this.aNV.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aNV != null) {
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
            int intrinsicWidth = this.aNV.getIntrinsicWidth();
            int intrinsicHeight = this.aNV.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aNV.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aNW) && !h.oY().pe()) {
            canvas.drawText(this.aNW, (int) (i - (this.aNY.measureText(this.aNW) / 2.0f)), this.aNX + i2, this.aNY);
        }
    }
}
