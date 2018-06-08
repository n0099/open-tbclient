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
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aWO;
    private String aWP;
    private int aWQ;
    private Paint aWR;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWR = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWR = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aWR = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aWR.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aWR.setColor(al.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aWP = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aWQ = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(al.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aWO = drawable;
        if (this.aWO != null) {
            this.aWO.setBounds(0, 0, this.aWO.getIntrinsicHeight(), this.aWO.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aWO != null && this.aWO.isStateful() && this.aWO.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aWO != null) {
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
            int intrinsicWidth = this.aWO.getIntrinsicWidth();
            int intrinsicHeight = this.aWO.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aWO.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aWP) && !i.tt().tz()) {
            canvas.drawText(this.aWP, (int) (i - (this.aWR.measureText(this.aWP) / 2.0f)), this.aWQ + i2, this.aWR);
        }
    }
}
