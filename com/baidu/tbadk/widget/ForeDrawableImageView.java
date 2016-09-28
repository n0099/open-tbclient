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
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private int aFA;
    private Paint aFB;
    private Drawable aFy;
    private String aFz;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFB = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFB = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aFB = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aFB.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aFB.setColor(av.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aFz = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aFA = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(av.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aFy = drawable;
        if (this.aFy != null) {
            this.aFy.setBounds(0, 0, this.aFy.getIntrinsicHeight(), this.aFy.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aFy != null && this.aFy.isStateful() && this.aFy.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aFy != null) {
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
            int intrinsicWidth = this.aFy.getIntrinsicWidth();
            int intrinsicHeight = this.aFy.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aFy.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aFz) && !l.oH().oN()) {
            canvas.drawText(this.aFz, (int) (i - (this.aFB.measureText(this.aFz) / 2.0f)), this.aFA + i2, this.aFB);
        }
    }
}
