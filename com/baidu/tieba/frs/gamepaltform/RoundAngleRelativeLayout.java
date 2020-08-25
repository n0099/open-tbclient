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
/* loaded from: classes16.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint btE;
    private float enq;
    private float enr;
    private float ens;
    private float ent;
    private Paint iiP;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btE = new Paint();
        this.btE.setColor(-1);
        this.btE.setAntiAlias(true);
        this.btE.setStyle(Paint.Style.FILL);
        this.btE.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.iiP = new Paint();
        this.iiP.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.iiP, 31);
        super.dispatchDraw(canvas);
        R(canvas);
        S(canvas);
        T(canvas);
        U(canvas);
        canvas.restore();
    }

    private void R(Canvas canvas) {
        if (this.enr > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.enr);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.enr, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.enr * 2.0f, this.enr * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.btE);
        }
    }

    private void S(Canvas canvas) {
        if (this.enq > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.enq, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.enq);
            path.arcTo(new RectF(width - (this.enq * 2.0f), 0.0f, width, this.enq * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.btE);
        }
    }

    private void T(Canvas canvas) {
        if (this.ent > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.ent);
            path.lineTo(0.0f, height);
            path.lineTo(this.ent, height);
            path.arcTo(new RectF(0.0f, height - (this.ent * 2.0f), this.ent * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.btE);
        }
    }

    private void U(Canvas canvas) {
        if (this.ens > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.ens, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.ens);
            path.arcTo(new RectF(width - (this.ens * 2.0f), height - (this.ens * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.btE);
        }
    }

    public void setTopLeftRadius(float f) {
        this.enr = f;
    }

    public void setTopRightRadius(float f) {
        this.enq = f;
    }

    public void setBottomLeftRadius(float f) {
        this.ent = f;
    }

    public void setBottomRightRadius(float f) {
        this.ens = f;
    }

    public void setRadius(float f) {
        this.enr = f;
        this.ent = f;
        this.enq = f;
        this.ens = f;
        invalidate();
    }
}
