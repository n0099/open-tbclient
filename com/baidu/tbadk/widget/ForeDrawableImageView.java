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
    private Drawable cve;
    private String cvf;
    private int cvg;
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
        this.textPaint.setColor(al.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.cvf = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.cvg = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(al.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.cve = drawable;
        if (this.cve != null) {
            this.cve.setBounds(0, 0, this.cve.getIntrinsicHeight(), this.cve.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.cve != null && this.cve.isStateful() && this.cve.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.cve != null) {
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
            int intrinsicWidth = this.cve.getIntrinsicWidth();
            int intrinsicHeight = this.cve.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.cve.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.cvf) && !i.Wy().WC()) {
            canvas.drawText(this.cvf, (int) (i - (this.textPaint.measureText(this.cvf) / 2.0f)), this.cvg + i2, this.textPaint);
        }
    }
}
