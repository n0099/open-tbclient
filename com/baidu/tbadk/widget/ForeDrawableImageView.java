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
import com.baidu.tbadk.core.util.ai;
/* loaded from: classes.dex */
public class ForeDrawableImageView extends TbImageView {
    private Drawable aNT;
    private String aNU;
    private int aNV;
    private Paint aNW;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNW = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNW = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.aNW = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.aNW.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.aNW.setColor(ai.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.aNU = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.aNV = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(ai.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.aNT = drawable;
        if (this.aNT != null) {
            this.aNT.setBounds(0, 0, this.aNT.getIntrinsicHeight(), this.aNT.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.aNT != null && this.aNT.isStateful() && this.aNT.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.b.a.b, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.aNT != null) {
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
            int intrinsicWidth = this.aNT.getIntrinsicWidth();
            int intrinsicHeight = this.aNT.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.aNT.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.aNU) && !h.oX().pd()) {
            canvas.drawText(this.aNU, (int) (i - (this.aNW.measureText(this.aNU) / 2.0f)), this.aNV + i2, this.aNW);
        }
    }
}
