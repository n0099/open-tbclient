package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.q;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aKm;
    private String aKn;
    private int aKo;
    private Paint aKp;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKp = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aKp = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aKp = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aKp.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aKp.setColor(aq.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aKn = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aKo = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(aq.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aKm = drawable;
        if (this.aKm != null) {
            this.aKm.setBounds(0, 0, this.aKm.getIntrinsicHeight(), this.aKm.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aKm != null && this.aKm.isStateful() && this.aKm.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aKm != null) {
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
            int intrinsicWidth = this.aKm.getIntrinsicWidth();
            int intrinsicHeight = this.aKm.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aKm.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aKn) && !q.po().pu()) {
            canvas.drawText(this.aKn, (int) (i - (this.aKp.measureText(this.aKn) / 2.0f)), this.aKo + i2, this.aKp);
        }
    }
}
