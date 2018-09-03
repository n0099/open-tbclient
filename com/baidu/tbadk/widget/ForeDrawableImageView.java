package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aXP;
    private String aXQ;
    private int aXR;
    private Paint aXS;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXS = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXS = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aXS = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aXS.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aXS.setColor(am.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aXQ = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aXR = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(am.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aXP = drawable;
        if (this.aXP != null) {
            this.aXP.setBounds(0, 0, this.aXP.getIntrinsicHeight(), this.aXP.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aXP != null && this.aXP.isStateful() && this.aXP.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aXP != null) {
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
            int intrinsicWidth = this.aXP.getIntrinsicWidth();
            int intrinsicHeight = this.aXP.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aXP.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aXQ) && !i.td().tj()) {
            canvas.drawText(this.aXQ, (int) (i - (this.aXS.measureText(this.aXQ) / 2.0f)), this.aXR + i2, this.aXS);
        }
    }
}
