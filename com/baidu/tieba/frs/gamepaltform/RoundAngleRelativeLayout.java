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
/* loaded from: classes4.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint asb;
    private float fHH;
    private float fHI;
    private float fHJ;
    private float fHK;
    private Paint fHL;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.asb = new Paint();
        this.asb.setColor(-1);
        this.asb.setAntiAlias(true);
        this.asb.setStyle(Paint.Style.FILL);
        this.asb.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.fHL = new Paint();
        this.fHL.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.fHL, 31);
        super.dispatchDraw(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        M(canvas);
        canvas.restore();
    }

    private void J(Canvas canvas) {
        if (this.fHH > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fHH);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fHH, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fHH * 2.0f, this.fHH * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.asb);
        }
    }

    private void K(Canvas canvas) {
        if (this.fHI > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fHI, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fHI);
            path.arcTo(new RectF(width - (this.fHI * 2.0f), 0.0f, width, this.fHI * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.asb);
        }
    }

    private void L(Canvas canvas) {
        if (this.fHJ > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fHJ);
            path.lineTo(0.0f, height);
            path.lineTo(this.fHJ, height);
            path.arcTo(new RectF(0.0f, height - (this.fHJ * 2.0f), this.fHJ * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.asb);
        }
    }

    private void M(Canvas canvas) {
        if (this.fHK > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fHK, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fHK);
            path.arcTo(new RectF(width - (this.fHK * 2.0f), height - (this.fHK * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.asb);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fHH = f;
    }

    public void setTopRightRadius(float f) {
        this.fHI = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fHJ = f;
    }

    public void setBottomRightRadius(float f) {
        this.fHK = f;
    }

    public void setRadius(float f) {
        this.fHH = f;
        this.fHJ = f;
        this.fHI = f;
        this.fHK = f;
        invalidate();
    }
}
