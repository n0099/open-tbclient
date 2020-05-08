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
/* loaded from: classes9.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint baU;
    private float dCA;
    private float dCx;
    private float dCy;
    private float dCz;
    private Paint hlY;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baU = new Paint();
        this.baU.setColor(-1);
        this.baU.setAntiAlias(true);
        this.baU.setStyle(Paint.Style.FILL);
        this.baU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.hlY = new Paint();
        this.hlY.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.hlY, 31);
        super.dispatchDraw(canvas);
        I(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        canvas.restore();
    }

    private void I(Canvas canvas) {
        if (this.dCy > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dCy);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dCy, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dCy * 2.0f, this.dCy * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.baU);
        }
    }

    private void J(Canvas canvas) {
        if (this.dCx > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dCx, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dCx);
            path.arcTo(new RectF(width - (this.dCx * 2.0f), 0.0f, width, this.dCx * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.baU);
        }
    }

    private void K(Canvas canvas) {
        if (this.dCA > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dCA);
            path.lineTo(0.0f, height);
            path.lineTo(this.dCA, height);
            path.arcTo(new RectF(0.0f, height - (this.dCA * 2.0f), this.dCA * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.baU);
        }
    }

    private void L(Canvas canvas) {
        if (this.dCz > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dCz, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dCz);
            path.arcTo(new RectF(width - (this.dCz * 2.0f), height - (this.dCz * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.baU);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dCy = f;
    }

    public void setTopRightRadius(float f) {
        this.dCx = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dCA = f;
    }

    public void setBottomRightRadius(float f) {
        this.dCz = f;
    }

    public void setRadius(float f) {
        this.dCy = f;
        this.dCA = f;
        this.dCx = f;
        this.dCz = f;
        invalidate();
    }
}
