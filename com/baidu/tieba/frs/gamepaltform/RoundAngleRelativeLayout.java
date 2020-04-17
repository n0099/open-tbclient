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
    private Paint baP;
    private float dCt;
    private float dCu;
    private float dCv;
    private float dCw;
    private Paint hlS;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.baP = new Paint();
        this.baP.setColor(-1);
        this.baP.setAntiAlias(true);
        this.baP.setStyle(Paint.Style.FILL);
        this.baP.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.hlS = new Paint();
        this.hlS.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.hlS, 31);
        super.dispatchDraw(canvas);
        I(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        canvas.restore();
    }

    private void I(Canvas canvas) {
        if (this.dCu > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dCu);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dCu, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dCu * 2.0f, this.dCu * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.baP);
        }
    }

    private void J(Canvas canvas) {
        if (this.dCt > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dCt, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dCt);
            path.arcTo(new RectF(width - (this.dCt * 2.0f), 0.0f, width, this.dCt * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.baP);
        }
    }

    private void K(Canvas canvas) {
        if (this.dCw > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dCw);
            path.lineTo(0.0f, height);
            path.lineTo(this.dCw, height);
            path.arcTo(new RectF(0.0f, height - (this.dCw * 2.0f), this.dCw * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.baP);
        }
    }

    private void L(Canvas canvas) {
        if (this.dCv > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dCv, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dCv);
            path.arcTo(new RectF(width - (this.dCv * 2.0f), height - (this.dCv * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.baP);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dCu = f;
    }

    public void setTopRightRadius(float f) {
        this.dCt = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dCw = f;
    }

    public void setBottomRightRadius(float f) {
        this.dCv = f;
    }

    public void setRadius(float f) {
        this.dCu = f;
        this.dCw = f;
        this.dCt = f;
        this.dCv = f;
        invalidate();
    }
}
