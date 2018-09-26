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
    private float dER;
    private float dES;
    private float dET;
    private float dEU;
    private Paint dEV;
    private Paint dEW;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dEV = new Paint();
        this.dEV.setColor(-1);
        this.dEV.setAntiAlias(true);
        this.dEV.setStyle(Paint.Style.FILL);
        this.dEV.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dEW = new Paint();
        this.dEW.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dEW, 31);
        super.dispatchDraw(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        t(canvas);
        canvas.restore();
    }

    private void q(Canvas canvas) {
        if (this.dER > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dER);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dER, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dER * 2.0f, this.dER * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dEV);
        }
    }

    private void r(Canvas canvas) {
        if (this.dES > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dES, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dES);
            path.arcTo(new RectF(width - (this.dES * 2.0f), 0.0f, width, this.dES * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dEV);
        }
    }

    private void s(Canvas canvas) {
        if (this.dET > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dET);
            path.lineTo(0.0f, height);
            path.lineTo(this.dET, height);
            path.arcTo(new RectF(0.0f, height - (this.dET * 2.0f), this.dET * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dEV);
        }
    }

    private void t(Canvas canvas) {
        if (this.dEU > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dEU, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dEU);
            path.arcTo(new RectF(width - (this.dEU * 2.0f), height - (this.dEU * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dEV);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dER = f;
    }

    public void setTopRightRadius(float f) {
        this.dES = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dET = f;
    }

    public void setBottomRightRadius(float f) {
        this.dEU = f;
    }

    public void setRadius(float f) {
        this.dER = f;
        this.dET = f;
        this.dES = f;
        this.dEU = f;
        invalidate();
    }
}
