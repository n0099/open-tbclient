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
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aFs;
    private String aFt;
    private int aFu;
    private Paint aFv;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFv = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aFv = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aFv = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aFv.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aFv.setColor(at.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aFt = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aFu = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(at.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aFs = drawable;
        if (this.aFs != null) {
            this.aFs.setBounds(0, 0, this.aFs.getIntrinsicHeight(), this.aFs.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aFs != null && this.aFs.isStateful() && this.aFs.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aFs != null) {
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
            int intrinsicWidth = this.aFs.getIntrinsicWidth();
            int intrinsicHeight = this.aFs.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aFs.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aFt) && !l.qE().qK()) {
            canvas.drawText(this.aFt, (int) (i - (this.aFv.measureText(this.aFt) / 2.0f)), this.aFu + i2, this.aFv);
        }
    }
}
