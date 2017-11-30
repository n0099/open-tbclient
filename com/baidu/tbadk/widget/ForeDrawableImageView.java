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
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aOq;
    private String aOr;
    private int aOs;
    private Paint aOt;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOt = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOt = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aOt = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aOt.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aOt.setColor(aj.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aOr = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aOs = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(aj.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aOq = drawable;
        if (this.aOq != null) {
            this.aOq.setBounds(0, 0, this.aOq.getIntrinsicHeight(), this.aOq.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aOq != null && this.aOq.isStateful() && this.aOq.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aOq != null) {
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
            int intrinsicWidth = this.aOq.getIntrinsicWidth();
            int intrinsicHeight = this.aOq.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aOq.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aOr) && !h.pa().pg()) {
            canvas.drawText(this.aOr, (int) (i - (this.aOt.measureText(this.aOr) / 2.0f)), this.aOs + i2, this.aOt);
        }
    }
}
