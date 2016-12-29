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
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aFI;
    private String aFJ;
    private int aFK;
    private Paint aFL;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFL = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFL = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aFL = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aFL.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aFL.setColor(ar.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aFJ = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aFK = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(ar.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aFI = drawable;
        if (this.aFI != null) {
            this.aFI.setBounds(0, 0, this.aFI.getIntrinsicHeight(), this.aFI.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aFI != null && this.aFI.isStateful() && this.aFI.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aFI != null) {
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
            int intrinsicWidth = this.aFI.getIntrinsicWidth();
            int intrinsicHeight = this.aFI.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aFI.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aFJ) && !l.oJ().oP()) {
            canvas.drawText(this.aFJ, (int) (i - (this.aFL.measureText(this.aFJ) / 2.0f)), this.aFK + i2, this.aFL);
        }
    }
}
