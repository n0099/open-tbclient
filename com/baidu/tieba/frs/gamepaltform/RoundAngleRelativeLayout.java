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
    private float dMQ;
    private float dMR;
    private float dMS;
    private float dMT;
    private Paint dMU;
    private Paint dMV;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dMU = new Paint();
        this.dMU.setColor(-1);
        this.dMU.setAntiAlias(true);
        this.dMU.setStyle(Paint.Style.FILL);
        this.dMU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dMV = new Paint();
        this.dMV.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dMV, 31);
        super.dispatchDraw(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        t(canvas);
        canvas.restore();
    }

    private void q(Canvas canvas) {
        if (this.dMQ > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dMQ);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dMQ, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dMQ * 2.0f, this.dMQ * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dMU);
        }
    }

    private void r(Canvas canvas) {
        if (this.dMR > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dMR, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dMR);
            path.arcTo(new RectF(width - (this.dMR * 2.0f), 0.0f, width, this.dMR * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dMU);
        }
    }

    private void s(Canvas canvas) {
        if (this.dMS > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dMS);
            path.lineTo(0.0f, height);
            path.lineTo(this.dMS, height);
            path.arcTo(new RectF(0.0f, height - (this.dMS * 2.0f), this.dMS * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dMU);
        }
    }

    private void t(Canvas canvas) {
        if (this.dMT > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dMT, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dMT);
            path.arcTo(new RectF(width - (this.dMT * 2.0f), height - (this.dMT * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dMU);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dMQ = f;
    }

    public void setTopRightRadius(float f) {
        this.dMR = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dMS = f;
    }

    public void setBottomRightRadius(float f) {
        this.dMT = f;
    }

    public void setRadius(float f) {
        this.dMQ = f;
        this.dMS = f;
        this.dMR = f;
        this.dMT = f;
        invalidate();
    }
}
