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
    private Drawable aXJ;
    private String aXK;
    private int aXL;
    private Paint aXM;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXM = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXM = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aXM = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aXM.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aXM.setColor(am.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aXK = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aXL = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(am.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aXJ = drawable;
        if (this.aXJ != null) {
            this.aXJ.setBounds(0, 0, this.aXJ.getIntrinsicHeight(), this.aXJ.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aXJ != null && this.aXJ.isStateful() && this.aXJ.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aXJ != null) {
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
            int intrinsicWidth = this.aXJ.getIntrinsicWidth();
            int intrinsicHeight = this.aXJ.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aXJ.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aXK) && !i.tt().tz()) {
            canvas.drawText(this.aXK, (int) (i - (this.aXM.measureText(this.aXK) / 2.0f)), this.aXL + i2, this.aXM);
        }
    }
}
