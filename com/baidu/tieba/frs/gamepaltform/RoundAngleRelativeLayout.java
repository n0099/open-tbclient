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
    private float flA;
    private Paint flB;
    private float flx;
    private float fly;
    private float flz;
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
        this.flB = new Paint();
        this.flB.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.flB, 31);
        super.dispatchDraw(canvas);
        I(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        canvas.restore();
    }

    private void I(Canvas canvas) {
        if (this.flx > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.flx);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.flx, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.flx * 2.0f, this.flx * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void J(Canvas canvas) {
        if (this.fly > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fly, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fly);
            path.arcTo(new RectF(width - (this.fly * 2.0f), 0.0f, width, this.fly * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void K(Canvas canvas) {
        if (this.flz > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.flz);
            path.lineTo(0.0f, height);
            path.lineTo(this.flz, height);
            path.arcTo(new RectF(0.0f, height - (this.flz * 2.0f), this.flz * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void L(Canvas canvas) {
        if (this.flA > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.flA, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.flA);
            path.arcTo(new RectF(width - (this.flA * 2.0f), height - (this.flA * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.flx = f;
    }

    public void setTopRightRadius(float f) {
        this.fly = f;
    }

    public void setBottomLeftRadius(float f) {
        this.flz = f;
    }

    public void setBottomRightRadius(float f) {
        this.flA = f;
    }

    public void setRadius(float f) {
        this.flx = f;
        this.flz = f;
        this.fly = f;
        this.flA = f;
        invalidate();
    }
}
