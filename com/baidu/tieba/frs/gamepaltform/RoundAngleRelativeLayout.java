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
    private Paint biu;
    private float dQE;
    private float dQF;
    private float dQG;
    private float dQH;
    private Paint hBz;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.biu = new Paint();
        this.biu.setColor(-1);
        this.biu.setAntiAlias(true);
        this.biu.setStyle(Paint.Style.FILL);
        this.biu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.hBz = new Paint();
        this.hBz.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.hBz, 31);
        super.dispatchDraw(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        M(canvas);
        canvas.restore();
    }

    private void J(Canvas canvas) {
        if (this.dQF > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dQF);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dQF, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dQF * 2.0f, this.dQF * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.biu);
        }
    }

    private void K(Canvas canvas) {
        if (this.dQE > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dQE, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dQE);
            path.arcTo(new RectF(width - (this.dQE * 2.0f), 0.0f, width, this.dQE * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.biu);
        }
    }

    private void L(Canvas canvas) {
        if (this.dQH > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dQH);
            path.lineTo(0.0f, height);
            path.lineTo(this.dQH, height);
            path.arcTo(new RectF(0.0f, height - (this.dQH * 2.0f), this.dQH * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.biu);
        }
    }

    private void M(Canvas canvas) {
        if (this.dQG > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dQG, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dQG);
            path.arcTo(new RectF(width - (this.dQG * 2.0f), height - (this.dQG * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.biu);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dQF = f;
    }

    public void setTopRightRadius(float f) {
        this.dQE = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dQH = f;
    }

    public void setBottomRightRadius(float f) {
        this.dQG = f;
    }

    public void setRadius(float f) {
        this.dQF = f;
        this.dQH = f;
        this.dQE = f;
        this.dQG = f;
        invalidate();
    }
}
