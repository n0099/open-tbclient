package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aNH;
    private String aNI;
    private int aNJ;
    private Paint aNK;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNK = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNK = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aNK = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aNK.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aNK.setColor(aj.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aNI = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aNJ = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(aj.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aNH = drawable;
        if (this.aNH != null) {
            this.aNH.setBounds(0, 0, this.aNH.getIntrinsicHeight(), this.aNH.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aNH != null && this.aNH.isStateful() && this.aNH.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aNH != null) {
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
            int intrinsicWidth = this.aNH.getIntrinsicWidth();
            int intrinsicHeight = this.aNH.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aNH.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aNI) && !h.oT().oZ()) {
            canvas.drawText(this.aNI, (int) (i - (this.aNK.measureText(this.aNI) / 2.0f)), this.aNJ + i2, this.aNK);
        }
    }
}
