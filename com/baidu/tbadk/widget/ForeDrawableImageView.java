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
    private Drawable bbi;
    private String bbj;
    private int bbk;
    private Paint bbl;

    public ForeDrawableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bbl = new Paint();
    }

    public ForeDrawableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbl = new Paint();
    }

    public ForeDrawableImageView(Context context) {
        super(context);
        this.bbl = new Paint();
    }

    public void setNoImageBottomTextSize(float f) {
        if (f > 0.0f) {
            this.bbl.setTextSize(f);
        }
    }

    public void setNoImageBottomTextColor(int i) {
        this.bbl.setColor(al.getColor(i));
    }

    public void setNoImageBottomText(String str) {
        this.bbj = str;
    }

    public void setNoImageBottomTextPadding(int i) {
        this.bbk = i;
    }

    public void setForegroundDrawable(int i) {
        setForegroundDrawable(al.getDrawable(i));
    }

    public void setForegroundDrawable(Drawable drawable) {
        this.bbi = drawable;
        if (this.bbi != null) {
            this.bbi.setBounds(0, 0, this.bbi.getIntrinsicHeight(), this.bbi.getMinimumWidth());
        }
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.bbi != null && this.bbi.isStateful() && this.bbi.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.bbi != null) {
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
            int intrinsicWidth = this.bbi.getIntrinsicWidth();
            int intrinsicHeight = this.bbi.getIntrinsicHeight();
            int i2 = (i / 2) - (intrinsicWidth / 2);
            int height = (getHeight() / 2) - (intrinsicHeight / 2);
            canvas.translate(i2, height);
            this.bbi.draw(canvas);
            canvas.restore();
            a(canvas, i2 + (intrinsicWidth / 2), height + intrinsicHeight);
        }
    }

    private void a(Canvas canvas, int i, int i2) {
        if (!StringUtils.isNull(this.bbj) && !i.uj().un()) {
            canvas.drawText(this.bbj, (int) (i - (this.bbl.measureText(this.bbj) / 2.0f)), this.bbk + i2, this.bbl);
        }
    }
}
