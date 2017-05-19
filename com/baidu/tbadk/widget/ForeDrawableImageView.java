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
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aKv;
    private String aKw;
    private int aKx;
    private Paint aKy;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKy = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKy = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aKy = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aKy.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aKy.setColor(aq.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aKw = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aKx = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(aq.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aKv = drawable;
        if (this.aKv != null) {
            this.aKv.setBounds(0, 0, this.aKv.getIntrinsicHeight(), this.aKv.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aKv != null && this.aKv.isStateful() && this.aKv.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aKv != null) {
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
            int intrinsicWidth = this.aKv.getIntrinsicWidth();
            int intrinsicHeight = this.aKv.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aKv.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aKw) && !r.oV().pb()) {
            canvas.drawText(this.aKw, (int) (i - (this.aKy.measureText(this.aKw) / 2.0f)), this.aKx + i2, this.aKy);
        }
    }
}
