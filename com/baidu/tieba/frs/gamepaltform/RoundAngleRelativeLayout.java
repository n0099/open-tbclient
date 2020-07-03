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
    private Paint bnx;
    private float dXw;
    private float dXx;
    private float dXy;
    private float dXz;
    private Paint hOH;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnx = new Paint();
        this.bnx.setColor(-1);
        this.bnx.setAntiAlias(true);
        this.bnx.setStyle(Paint.Style.FILL);
        this.bnx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.hOH = new Paint();
        this.hOH.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.hOH, 31);
        super.dispatchDraw(canvas);
        K(canvas);
        L(canvas);
        M(canvas);
        N(canvas);
        canvas.restore();
    }

    private void K(Canvas canvas) {
        if (this.dXx > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dXx);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dXx, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dXx * 2.0f, this.dXx * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bnx);
        }
    }

    private void L(Canvas canvas) {
        if (this.dXw > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dXw, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dXw);
            path.arcTo(new RectF(width - (this.dXw * 2.0f), 0.0f, width, this.dXw * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bnx);
        }
    }

    private void M(Canvas canvas) {
        if (this.dXz > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dXz);
            path.lineTo(0.0f, height);
            path.lineTo(this.dXz, height);
            path.arcTo(new RectF(0.0f, height - (this.dXz * 2.0f), this.dXz * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bnx);
        }
    }

    private void N(Canvas canvas) {
        if (this.dXy > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dXy, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dXy);
            path.arcTo(new RectF(width - (this.dXy * 2.0f), height - (this.dXy * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bnx);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dXx = f;
    }

    public void setTopRightRadius(float f) {
        this.dXw = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dXz = f;
    }

    public void setBottomRightRadius(float f) {
        this.dXy = f;
    }

    public void setRadius(float f) {
        this.dXx = f;
        this.dXz = f;
        this.dXw = f;
        this.dXy = f;
        invalidate();
    }
}
