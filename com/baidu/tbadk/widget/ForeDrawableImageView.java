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
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable bCj;
    private String bCk;
    private int bCl;
    private Paint bCm;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCm = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCm = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.bCm = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.bCm.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.bCm.setColor(aj.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.bCk = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.bCl = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(aj.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.bCj = drawable;
        if (this.bCj != null) {
            this.bCj.setBounds(0, 0, this.bCj.getIntrinsicHeight(), this.bCj.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.bCj != null && this.bCj.isStateful() && this.bCj.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.bCj != null) {
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
            int intrinsicWidth = this.bCj.getIntrinsicWidth();
            int intrinsicHeight = this.bCj.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.bCj.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.bCk) && !i.wB().wH()) {
            canvas.drawText(this.bCk, (int) (i - (this.bCm.measureText(this.bCk) / 2.0f)), this.bCl + i2, this.bCm);
        }
    }
}
