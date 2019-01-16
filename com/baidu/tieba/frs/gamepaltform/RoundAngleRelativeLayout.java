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
/* loaded from: classes3.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private float dXU;
    private float dXV;
    private float dXW;
    private float dXX;
    private Paint dXY;
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
        this.dXY = new Paint();
        this.dXY.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dXY, 31);
        super.dispatchDraw(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        t(canvas);
        canvas.restore();
    }

    private void q(Canvas canvas) {
        if (this.dXU > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dXU);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dXU, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dXU * 2.0f, this.dXU * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void r(Canvas canvas) {
        if (this.dXV > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dXV, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dXV);
            path.arcTo(new RectF(width - (this.dXV * 2.0f), 0.0f, width, this.dXV * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void s(Canvas canvas) {
        if (this.dXW > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dXW);
            path.lineTo(0.0f, height);
            path.lineTo(this.dXW, height);
            path.arcTo(new RectF(0.0f, height - (this.dXW * 2.0f), this.dXW * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void t(Canvas canvas) {
        if (this.dXX > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dXX, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dXX);
            path.arcTo(new RectF(width - (this.dXX * 2.0f), height - (this.dXX * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dXU = f;
    }

    public void setTopRightRadius(float f) {
        this.dXV = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dXW = f;
    }

    public void setBottomRightRadius(float f) {
        this.dXX = f;
    }

    public void setRadius(float f) {
        this.dXU = f;
        this.dXW = f;
        this.dXV = f;
        this.dXX = f;
        invalidate();
    }
}
