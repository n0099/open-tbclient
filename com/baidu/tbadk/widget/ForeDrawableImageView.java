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
    private Drawable aNE;
    private String aNF;
    private int aNG;
    private Paint aNH;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNH = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNH = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aNH = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aNH.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aNH.setColor(aj.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aNF = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aNG = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(aj.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aNE = drawable;
        if (this.aNE != null) {
            this.aNE.setBounds(0, 0, this.aNE.getIntrinsicHeight(), this.aNE.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aNE != null && this.aNE.isStateful() && this.aNE.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aNE != null) {
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
            int intrinsicWidth = this.aNE.getIntrinsicWidth();
            int intrinsicHeight = this.aNE.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aNE.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aNF) && !h.oS().oY()) {
            canvas.drawText(this.aNF, (int) (i - (this.aNH.measureText(this.aNF) / 2.0f)), this.aNG + i2, this.aNH);
        }
    }
}
