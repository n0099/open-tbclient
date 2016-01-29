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
    private Drawable aEc;
    private String aEd;
    private int aEe;
    private Paint aEf;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEf = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEf = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aEf = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aEf.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aEf.setColor(ar.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aEd = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aEe = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(ar.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aEc = drawable;
        if (this.aEc != null) {
            this.aEc.setBounds(0, 0, this.aEc.getIntrinsicHeight(), this.aEc.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aEc != null && this.aEc.isStateful() && this.aEc.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aEc != null) {
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
            int intrinsicWidth = this.aEc.getIntrinsicWidth();
            int intrinsicHeight = this.aEc.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aEc.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aEd) && !l.rn().rt()) {
            canvas.drawText(this.aEd, (int) (i - (this.aEf.measureText(this.aEd) / 2.0f)), this.aEe + i2, this.aEf);
        }
    }
}
