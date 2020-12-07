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
    private Paint bPB;
    private float eWC;
    private float eWD;
    private float eWE;
    private float eWF;
    private Paint jlu;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bPB = new Paint();
        this.bPB.setColor(-1);
        this.bPB.setAntiAlias(true);
        this.bPB.setStyle(Paint.Style.FILL);
        this.bPB.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.jlu = new Paint();
        this.jlu.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.jlu, 31);
        super.dispatchDraw(canvas);
        V(canvas);
        W(canvas);
        X(canvas);
        Y(canvas);
        canvas.restore();
    }

    private void V(Canvas canvas) {
        if (this.eWD > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.eWD);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.eWD, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.eWD * 2.0f, this.eWD * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bPB);
        }
    }

    private void W(Canvas canvas) {
        if (this.eWC > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.eWC, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.eWC);
            path.arcTo(new RectF(width - (this.eWC * 2.0f), 0.0f, width, this.eWC * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bPB);
        }
    }

    private void X(Canvas canvas) {
        if (this.eWF > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.eWF);
            path.lineTo(0.0f, height);
            path.lineTo(this.eWF, height);
            path.arcTo(new RectF(0.0f, height - (this.eWF * 2.0f), this.eWF * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bPB);
        }
    }

    private void Y(Canvas canvas) {
        if (this.eWE > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.eWE, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.eWE);
            path.arcTo(new RectF(width - (this.eWE * 2.0f), height - (this.eWE * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bPB);
        }
    }

    public void setTopLeftRadius(float f) {
        this.eWD = f;
    }

    public void setTopRightRadius(float f) {
        this.eWC = f;
    }

    public void setBottomLeftRadius(float f) {
        this.eWF = f;
    }

    public void setBottomRightRadius(float f) {
        this.eWE = f;
    }

    public void setRadius(float f) {
        this.eWD = f;
        this.eWF = f;
        this.eWC = f;
        this.eWE = f;
        invalidate();
    }
}
