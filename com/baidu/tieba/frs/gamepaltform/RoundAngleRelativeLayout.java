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
    private float fBF;
    private float fBG;
    private float fBH;
    private float fBI;
    private Paint fBJ;
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
        this.fBJ = new Paint();
        this.fBJ.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.fBJ, 31);
        super.dispatchDraw(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        M(canvas);
        canvas.restore();
    }

    private void J(Canvas canvas) {
        if (this.fBF > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fBF);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fBF, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fBF * 2.0f, this.fBF * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void K(Canvas canvas) {
        if (this.fBG > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fBG, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fBG);
            path.arcTo(new RectF(width - (this.fBG * 2.0f), 0.0f, width, this.fBG * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void L(Canvas canvas) {
        if (this.fBH > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fBH);
            path.lineTo(0.0f, height);
            path.lineTo(this.fBH, height);
            path.arcTo(new RectF(0.0f, height - (this.fBH * 2.0f), this.fBH * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void M(Canvas canvas) {
        if (this.fBI > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fBI, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fBI);
            path.arcTo(new RectF(width - (this.fBI * 2.0f), height - (this.fBI * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fBF = f;
    }

    public void setTopRightRadius(float f) {
        this.fBG = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fBH = f;
    }

    public void setBottomRightRadius(float f) {
        this.fBI = f;
    }

    public void setRadius(float f) {
        this.fBF = f;
        this.fBH = f;
        this.fBG = f;
        this.fBI = f;
        invalidate();
    }
}
