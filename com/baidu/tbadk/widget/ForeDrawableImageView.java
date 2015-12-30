package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aDm;
    private String aDn;
    private int aDo;
    private Paint aDp;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDp = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDp = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aDp = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aDp.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aDp.setColor(as.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aDn = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aDo = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(as.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aDm = drawable;
        if (this.aDm != null) {
            this.aDm.setBounds(0, 0, this.aDm.getIntrinsicHeight(), this.aDm.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aDm != null && this.aDm.isStateful() && this.aDm.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aDm != null) {
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
            int intrinsicWidth = this.aDm.getIntrinsicWidth();
            int intrinsicHeight = this.aDm.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aDm.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aDn) && !m.qQ().qW()) {
            canvas.drawText(this.aDn, (int) (i - (this.aDp.measureText(this.aDn) / 2.0f)), this.aDo + i2, this.aDp);
        }
    }
}
