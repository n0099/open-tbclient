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
    private float dUA;
    private Paint dUB;
    private float dUx;
    private float dUy;
    private float dUz;
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
        this.dUB = new Paint();
        this.dUB.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dUB, 31);
        super.dispatchDraw(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        t(canvas);
        canvas.restore();
    }

    private void q(Canvas canvas) {
        if (this.dUx > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dUx);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dUx, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dUx * 2.0f, this.dUx * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void r(Canvas canvas) {
        if (this.dUy > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dUy, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dUy);
            path.arcTo(new RectF(width - (this.dUy * 2.0f), 0.0f, width, this.dUy * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void s(Canvas canvas) {
        if (this.dUz > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dUz);
            path.lineTo(0.0f, height);
            path.lineTo(this.dUz, height);
            path.arcTo(new RectF(0.0f, height - (this.dUz * 2.0f), this.dUz * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void t(Canvas canvas) {
        if (this.dUA > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dUA, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dUA);
            path.arcTo(new RectF(width - (this.dUA * 2.0f), height - (this.dUA * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dUx = f;
    }

    public void setTopRightRadius(float f) {
        this.dUy = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dUz = f;
    }

    public void setBottomRightRadius(float f) {
        this.dUA = f;
    }

    public void setRadius(float f) {
        this.dUx = f;
        this.dUz = f;
        this.dUy = f;
        this.dUA = f;
        invalidate();
    }
}
