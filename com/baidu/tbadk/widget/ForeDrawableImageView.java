package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.r;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Paint aLA;
    private Drawable aLx;
    private String aLy;
    private int aLz;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLA = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLA = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aLA = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aLA.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aLA.setColor(as.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aLy = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aLz = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(as.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aLx = drawable;
        if (this.aLx != null) {
            this.aLx.setBounds(0, 0, this.aLx.getIntrinsicHeight(), this.aLx.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aLx != null && this.aLx.isStateful() && this.aLx.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aLx != null) {
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
            int intrinsicWidth = this.aLx.getIntrinsicWidth();
            int intrinsicHeight = this.aLx.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aLx.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aLy) && !r.oK().oQ()) {
            canvas.drawText(this.aLy, (int) (i - (this.aLA.measureText(this.aLy) / 2.0f)), this.aLz + i2, this.aLA);
        }
    }
}
