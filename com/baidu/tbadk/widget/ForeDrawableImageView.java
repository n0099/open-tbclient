package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aJU;
    private String aJV;
    private int aJW;
    private Paint aJX;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJX = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aJX = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aJX = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aJX.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aJX.setColor(aq.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aJV = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aJW = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(aq.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aJU = drawable;
        if (this.aJU != null) {
            this.aJU.setBounds(0, 0, this.aJU.getIntrinsicHeight(), this.aJU.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aJU != null && this.aJU.isStateful() && this.aJU.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aJU != null) {
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
            int intrinsicWidth = this.aJU.getIntrinsicWidth();
            int intrinsicHeight = this.aJU.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aJU.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aJV) && !l.oQ().oW()) {
            canvas.drawText(this.aJV, (int) (i - (this.aJX.measureText(this.aJV) / 2.0f)), this.aJW + i2, this.aJX);
        }
    }
}
