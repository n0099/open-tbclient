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
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable bfK;
    private String bfL;
    private int bfM;
    private Paint bfN;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfN = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfN = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.bfN = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.bfN.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.bfN.setColor(al.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.bfL = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.bfM = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(al.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.bfK = drawable;
        if (this.bfK != null) {
            this.bfK.setBounds(0, 0, this.bfK.getIntrinsicHeight(), this.bfK.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.bfK != null && this.bfK.isStateful() && this.bfK.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.bfK != null) {
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
            int intrinsicWidth = this.bfK.getIntrinsicWidth();
            int intrinsicHeight = this.bfK.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.bfK.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.bfL) && !i.ws().ww()) {
            canvas.drawText(this.bfL, (int) (i - (this.bfN.measureText(this.bfL) / 2.0f)), this.bfM + i2, this.bfN);
        }
    }
}
