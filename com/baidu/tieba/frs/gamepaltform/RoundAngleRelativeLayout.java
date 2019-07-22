package com.baidu.tieba.frs.gamepaltform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes4.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private float fGD;
    private float fGE;
    private float fGF;
    private float fGG;
    private Paint fGH;
    private Paint roundPaint;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.roundPaint = new Paint();
        this.roundPaint.setColor(-1);
        this.roundPaint.setAntiAlias(true);
        this.roundPaint.setStyle(Paint.Style.FILL);
        this.roundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.fGH = new Paint();
        this.fGH.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.fGH, 31);
        super.dispatchDraw(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        M(canvas);
        canvas.restore();
    }

    private void J(Canvas canvas) {
        if (this.fGD > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fGD);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fGD, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fGD * 2.0f, this.fGD * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void K(Canvas canvas) {
        if (this.fGE > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fGE, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fGE);
            path.arcTo(new RectF(width - (this.fGE * 2.0f), 0.0f, width, this.fGE * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void L(Canvas canvas) {
        if (this.fGF > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fGF);
            path.lineTo(0.0f, height);
            path.lineTo(this.fGF, height);
            path.arcTo(new RectF(0.0f, height - (this.fGF * 2.0f), this.fGF * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void M(Canvas canvas) {
        if (this.fGG > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fGG, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fGG);
            path.arcTo(new RectF(width - (this.fGG * 2.0f), height - (this.fGG * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fGD = f;
    }

    public void setTopRightRadius(float f) {
        this.fGE = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fGF = f;
    }

    public void setBottomRightRadius(float f) {
        this.fGG = f;
    }

    public void setRadius(float f) {
        this.fGD = f;
        this.fGF = f;
        this.fGE = f;
        this.fGG = f;
        invalidate();
    }
}
