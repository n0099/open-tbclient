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
    private Paint aFi;
    private float dcT;
    private float dcU;
    private float dcV;
    private float dcW;
    private Paint gCw;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFi = new Paint();
        this.aFi.setColor(-1);
        this.aFi.setAntiAlias(true);
        this.aFi.setStyle(Paint.Style.FILL);
        this.aFi.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.gCw = new Paint();
        this.gCw.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.gCw, 31);
        super.dispatchDraw(canvas);
        H(canvas);
        I(canvas);
        J(canvas);
        K(canvas);
        canvas.restore();
    }

    private void H(Canvas canvas) {
        if (this.dcU > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dcU);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dcU, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dcU * 2.0f, this.dcU * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aFi);
        }
    }

    private void I(Canvas canvas) {
        if (this.dcT > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dcT, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dcT);
            path.arcTo(new RectF(width - (this.dcT * 2.0f), 0.0f, width, this.dcT * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aFi);
        }
    }

    private void J(Canvas canvas) {
        if (this.dcW > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dcW);
            path.lineTo(0.0f, height);
            path.lineTo(this.dcW, height);
            path.arcTo(new RectF(0.0f, height - (this.dcW * 2.0f), this.dcW * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aFi);
        }
    }

    private void K(Canvas canvas) {
        if (this.dcV > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dcV, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dcV);
            path.arcTo(new RectF(width - (this.dcV * 2.0f), height - (this.dcV * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aFi);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dcU = f;
    }

    public void setTopRightRadius(float f) {
        this.dcT = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dcW = f;
    }

    public void setBottomRightRadius(float f) {
        this.dcV = f;
    }

    public void setRadius(float f) {
        this.dcU = f;
        this.dcW = f;
        this.dcT = f;
        this.dcV = f;
        invalidate();
    }
}
