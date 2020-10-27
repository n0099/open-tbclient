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
    private Paint bGz;
    private float eKu;
    private float eKv;
    private float eKw;
    private float eKx;
    private Paint iRm;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bGz = new Paint();
        this.bGz.setColor(-1);
        this.bGz.setAntiAlias(true);
        this.bGz.setStyle(Paint.Style.FILL);
        this.bGz.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.iRm = new Paint();
        this.iRm.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.iRm, 31);
        super.dispatchDraw(canvas);
        S(canvas);
        T(canvas);
        U(canvas);
        V(canvas);
        canvas.restore();
    }

    private void S(Canvas canvas) {
        if (this.eKv > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.eKv);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.eKv, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.eKv * 2.0f, this.eKv * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bGz);
        }
    }

    private void T(Canvas canvas) {
        if (this.eKu > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.eKu, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.eKu);
            path.arcTo(new RectF(width - (this.eKu * 2.0f), 0.0f, width, this.eKu * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bGz);
        }
    }

    private void U(Canvas canvas) {
        if (this.eKx > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.eKx);
            path.lineTo(0.0f, height);
            path.lineTo(this.eKx, height);
            path.arcTo(new RectF(0.0f, height - (this.eKx * 2.0f), this.eKx * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bGz);
        }
    }

    private void V(Canvas canvas) {
        if (this.eKw > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.eKw, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.eKw);
            path.arcTo(new RectF(width - (this.eKw * 2.0f), height - (this.eKw * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bGz);
        }
    }

    public void setTopLeftRadius(float f) {
        this.eKv = f;
    }

    public void setTopRightRadius(float f) {
        this.eKu = f;
    }

    public void setBottomLeftRadius(float f) {
        this.eKx = f;
    }

    public void setBottomRightRadius(float f) {
        this.eKw = f;
    }

    public void setRadius(float f) {
        this.eKv = f;
        this.eKx = f;
        this.eKu = f;
        this.eKw = f;
        invalidate();
    }
}
