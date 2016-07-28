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
    private Drawable aCS;
    private String aCT;
    private int aCU;
    private Paint aCV;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aCV = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aCV = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aCV = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aCV.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aCV.setColor(av.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aCT = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aCU = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(av.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aCS = drawable;
        if (this.aCS != null) {
            this.aCS.setBounds(0, 0, this.aCS.getIntrinsicHeight(), this.aCS.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aCS != null && this.aCS.isStateful() && this.aCS.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aCS != null) {
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
            int intrinsicWidth = this.aCS.getIntrinsicWidth();
            int intrinsicHeight = this.aCS.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aCS.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aCT) && !l.nL().nR()) {
            canvas.drawText(this.aCT, (int) (i - (this.aCV.measureText(this.aCT) / 2.0f)), this.aCU + i2, this.aCV);
        }
    }
}
