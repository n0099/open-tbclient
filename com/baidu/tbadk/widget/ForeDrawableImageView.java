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
    private Drawable aBF;
    private String aBG;
    private int aBH;
    private Paint aBI;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBI = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aBI = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aBI = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aBI.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aBI.setColor(as.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aBG = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aBH = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(as.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aBF = drawable;
        if (this.aBF != null) {
            this.aBF.setBounds(0, 0, this.aBF.getIntrinsicHeight(), this.aBF.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aBF != null && this.aBF.isStateful() && this.aBF.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aBF != null) {
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
            int intrinsicWidth = this.aBF.getIntrinsicWidth();
            int intrinsicHeight = this.aBF.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aBF.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aBG) && !m.rh().rn()) {
            canvas.drawText(this.aBG, (int) (i - (this.aBI.measureText(this.aBG) / 2.0f)), this.aBH + i2, this.aBI);
        }
    }
}
