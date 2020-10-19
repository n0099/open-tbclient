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
/* loaded from: classes22.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint bDD;
    private float eBY;
    private float eBZ;
    private float eCa;
    private float eCb;
    private Paint iEQ;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bDD = new Paint();
        this.bDD.setColor(-1);
        this.bDD.setAntiAlias(true);
        this.bDD.setStyle(Paint.Style.FILL);
        this.bDD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.iEQ = new Paint();
        this.iEQ.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.iEQ, 31);
        super.dispatchDraw(canvas);
        S(canvas);
        T(canvas);
        U(canvas);
        V(canvas);
        canvas.restore();
    }

    private void S(Canvas canvas) {
        if (this.eBZ > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.eBZ);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.eBZ, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.eBZ * 2.0f, this.eBZ * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bDD);
        }
    }

    private void T(Canvas canvas) {
        if (this.eBY > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.eBY, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.eBY);
            path.arcTo(new RectF(width - (this.eBY * 2.0f), 0.0f, width, this.eBY * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bDD);
        }
    }

    private void U(Canvas canvas) {
        if (this.eCb > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.eCb);
            path.lineTo(0.0f, height);
            path.lineTo(this.eCb, height);
            path.arcTo(new RectF(0.0f, height - (this.eCb * 2.0f), this.eCb * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bDD);
        }
    }

    private void V(Canvas canvas) {
        if (this.eCa > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.eCa, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.eCa);
            path.arcTo(new RectF(width - (this.eCa * 2.0f), height - (this.eCa * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bDD);
        }
    }

    public void setTopLeftRadius(float f) {
        this.eBZ = f;
    }

    public void setTopRightRadius(float f) {
        this.eBY = f;
    }

    public void setBottomLeftRadius(float f) {
        this.eCb = f;
    }

    public void setBottomRightRadius(float f) {
        this.eCa = f;
    }

    public void setRadius(float f) {
        this.eBZ = f;
        this.eCb = f;
        this.eBY = f;
        this.eCa = f;
        invalidate();
    }
}
