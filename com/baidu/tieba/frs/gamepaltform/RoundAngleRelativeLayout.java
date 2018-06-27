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
    private float dvA;
    private Paint dvB;
    private Paint dvC;
    private float dvx;
    private float dvy;
    private float dvz;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dvB = new Paint();
        this.dvB.setColor(-1);
        this.dvB.setAntiAlias(true);
        this.dvB.setStyle(Paint.Style.FILL);
        this.dvB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dvC = new Paint();
        this.dvC.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dvC, 31);
        super.dispatchDraw(canvas);
        s(canvas);
        t(canvas);
        u(canvas);
        v(canvas);
        canvas.restore();
    }

    private void s(Canvas canvas) {
        if (this.dvx > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dvx);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dvx, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dvx * 2.0f, this.dvx * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dvB);
        }
    }

    private void t(Canvas canvas) {
        if (this.dvy > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dvy, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dvy);
            path.arcTo(new RectF(width - (this.dvy * 2.0f), 0.0f, width, this.dvy * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dvB);
        }
    }

    private void u(Canvas canvas) {
        if (this.dvz > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dvz);
            path.lineTo(0.0f, height);
            path.lineTo(this.dvz, height);
            path.arcTo(new RectF(0.0f, height - (this.dvz * 2.0f), this.dvz * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dvB);
        }
    }

    private void v(Canvas canvas) {
        if (this.dvA > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dvA, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dvA);
            path.arcTo(new RectF(width - (this.dvA * 2.0f), height - (this.dvA * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dvB);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dvx = f;
    }

    public void setTopRightRadius(float f) {
        this.dvy = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dvz = f;
    }

    public void setBottomRightRadius(float f) {
        this.dvA = f;
    }

    public void setRadius(float f) {
        this.dvx = f;
        this.dvz = f;
        this.dvy = f;
        this.dvA = f;
        invalidate();
    }
}
