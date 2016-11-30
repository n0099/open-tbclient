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
    private Drawable aGo;
    private String aGp;
    private int aGq;
    private Paint aGr;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGr = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGr = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aGr = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aGr.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aGr.setColor(at.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aGp = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aGq = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(at.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aGo = drawable;
        if (this.aGo != null) {
            this.aGo.setBounds(0, 0, this.aGo.getIntrinsicHeight(), this.aGo.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aGo != null && this.aGo.isStateful() && this.aGo.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aGo != null) {
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
            int intrinsicWidth = this.aGo.getIntrinsicWidth();
            int intrinsicHeight = this.aGo.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aGo.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aGp) && !l.oJ().oP()) {
            canvas.drawText(this.aGp, (int) (i - (this.aGr.measureText(this.aGp) / 2.0f)), this.aGq + i2, this.aGr);
        }
    }
}
