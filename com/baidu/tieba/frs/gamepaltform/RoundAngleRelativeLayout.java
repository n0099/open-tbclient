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
    private float flj;
    private float flk;
    private float fll;
    private float flm;
    private Paint fln;
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
        this.fln = new Paint();
        this.fln.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.fln, 31);
        super.dispatchDraw(canvas);
        I(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        canvas.restore();
    }

    private void I(Canvas canvas) {
        if (this.flj > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.flj);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.flj, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.flj * 2.0f, this.flj * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void J(Canvas canvas) {
        if (this.flk > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.flk, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.flk);
            path.arcTo(new RectF(width - (this.flk * 2.0f), 0.0f, width, this.flk * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void K(Canvas canvas) {
        if (this.fll > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fll);
            path.lineTo(0.0f, height);
            path.lineTo(this.fll, height);
            path.arcTo(new RectF(0.0f, height - (this.fll * 2.0f), this.fll * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void L(Canvas canvas) {
        if (this.flm > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.flm, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.flm);
            path.arcTo(new RectF(width - (this.flm * 2.0f), height - (this.flm * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.flj = f;
    }

    public void setTopRightRadius(float f) {
        this.flk = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fll = f;
    }

    public void setBottomRightRadius(float f) {
        this.flm = f;
    }

    public void setRadius(float f) {
        this.flj = f;
        this.fll = f;
        this.flk = f;
        this.flm = f;
        invalidate();
    }
}
