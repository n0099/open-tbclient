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
    private float dXo;
    private float dXp;
    private float dXq;
    private float dXr;
    private Paint dXs;
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
        this.dXs = new Paint();
        this.dXs.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dXs, 31);
        super.dispatchDraw(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        t(canvas);
        canvas.restore();
    }

    private void q(Canvas canvas) {
        if (this.dXo > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dXo);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dXo, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dXo * 2.0f, this.dXo * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void r(Canvas canvas) {
        if (this.dXp > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dXp, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dXp);
            path.arcTo(new RectF(width - (this.dXp * 2.0f), 0.0f, width, this.dXp * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void s(Canvas canvas) {
        if (this.dXq > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dXq);
            path.lineTo(0.0f, height);
            path.lineTo(this.dXq, height);
            path.arcTo(new RectF(0.0f, height - (this.dXq * 2.0f), this.dXq * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void t(Canvas canvas) {
        if (this.dXr > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dXr, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dXr);
            path.arcTo(new RectF(width - (this.dXr * 2.0f), height - (this.dXr * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dXo = f;
    }

    public void setTopRightRadius(float f) {
        this.dXp = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dXq = f;
    }

    public void setBottomRightRadius(float f) {
        this.dXr = f;
    }

    public void setRadius(float f) {
        this.dXo = f;
        this.dXq = f;
        this.dXp = f;
        this.dXr = f;
        invalidate();
    }
}
