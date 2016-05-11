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
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aBC;
    private String aBD;
    private int aBE;
    private Paint aBF;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBF = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBF = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aBF = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aBF.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aBF.setColor(at.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aBD = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aBE = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(at.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aBC = drawable;
        if (this.aBC != null) {
            this.aBC.setBounds(0, 0, this.aBC.getIntrinsicHeight(), this.aBC.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aBC != null && this.aBC.isStateful() && this.aBC.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aBC != null) {
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
            int intrinsicWidth = this.aBC.getIntrinsicWidth();
            int intrinsicHeight = this.aBC.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aBC.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aBD) && !l.ob().oh()) {
            canvas.drawText(this.aBD, (int) (i - (this.aBF.measureText(this.aBD) / 2.0f)), this.aBE + i2, this.aBF);
        }
    }
}
