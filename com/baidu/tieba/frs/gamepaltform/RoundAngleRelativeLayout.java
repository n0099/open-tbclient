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
    private float dso;
    private float dsp;
    private float dsq;
    private float dsr;
    private Paint dss;
    private Paint dst;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dss = new Paint();
        this.dss.setColor(-1);
        this.dss.setAntiAlias(true);
        this.dss.setStyle(Paint.Style.FILL);
        this.dss.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dst = new Paint();
        this.dst.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dst, 31);
        super.dispatchDraw(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        t(canvas);
        canvas.restore();
    }

    private void q(Canvas canvas) {
        if (this.dso > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dso);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dso, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dso * 2.0f, this.dso * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dss);
        }
    }

    private void r(Canvas canvas) {
        if (this.dsp > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dsp, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dsp);
            path.arcTo(new RectF(width - (this.dsp * 2.0f), 0.0f, width, this.dsp * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dss);
        }
    }

    private void s(Canvas canvas) {
        if (this.dsq > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dsq);
            path.lineTo(0.0f, height);
            path.lineTo(this.dsq, height);
            path.arcTo(new RectF(0.0f, height - (this.dsq * 2.0f), this.dsq * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dss);
        }
    }

    private void t(Canvas canvas) {
        if (this.dsr > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dsr, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dsr);
            path.arcTo(new RectF(width - (this.dsr * 2.0f), height - (this.dsr * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dss);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dso = f;
    }

    public void setTopRightRadius(float f) {
        this.dsp = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dsq = f;
    }

    public void setBottomRightRadius(float f) {
        this.dsr = f;
    }

    public void setRadius(float f) {
        this.dso = f;
        this.dsq = f;
        this.dsp = f;
        this.dsr = f;
        invalidate();
    }
}
