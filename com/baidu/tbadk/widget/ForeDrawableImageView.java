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
    private Drawable aCc;
    private String aCd;
    private int aCe;
    private Paint aCf;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCf = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCf = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aCf = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aCf.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aCf.setColor(av.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aCd = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aCe = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(av.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aCc = drawable;
        if (this.aCc != null) {
            this.aCc.setBounds(0, 0, this.aCc.getIntrinsicHeight(), this.aCc.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aCc != null && this.aCc.isStateful() && this.aCc.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aCc != null) {
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
            int intrinsicWidth = this.aCc.getIntrinsicWidth();
            int intrinsicHeight = this.aCc.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aCc.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aCd) && !l.nW().oc()) {
            canvas.drawText(this.aCd, (int) (i - (this.aCf.measureText(this.aCd) / 2.0f)), this.aCe + i2, this.aCf);
        }
    }
}
