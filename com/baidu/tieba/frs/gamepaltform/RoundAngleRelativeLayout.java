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
    private float dhT;
    private float dhU;
    private float dhV;
    private float dhW;
    private Paint dhX;
    private Paint dhY;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhX = new Paint();
        this.dhX.setColor(-1);
        this.dhX.setAntiAlias(true);
        this.dhX.setStyle(Paint.Style.FILL);
        this.dhX.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dhY = new Paint();
        this.dhY.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dhY, 31);
        super.dispatchDraw(canvas);
        p(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        canvas.restore();
    }

    private void p(Canvas canvas) {
        if (this.dhT > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dhT);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dhT, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dhT * 2.0f, this.dhT * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dhX);
        }
    }

    private void q(Canvas canvas) {
        if (this.dhU > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dhU, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dhU);
            path.arcTo(new RectF(width - (this.dhU * 2.0f), 0.0f, width, this.dhU * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dhX);
        }
    }

    private void r(Canvas canvas) {
        if (this.dhV > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dhV);
            path.lineTo(0.0f, height);
            path.lineTo(this.dhV, height);
            path.arcTo(new RectF(0.0f, height - (this.dhV * 2.0f), this.dhV * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dhX);
        }
    }

    private void s(Canvas canvas) {
        if (this.dhW > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dhW, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dhW);
            path.arcTo(new RectF(width - (this.dhW * 2.0f), height - (this.dhW * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dhX);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dhT = f;
    }

    public void setTopRightRadius(float f) {
        this.dhU = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dhV = f;
    }

    public void setBottomRightRadius(float f) {
        this.dhW = f;
    }

    public void setRadius(float f) {
        this.dhT = f;
        this.dhV = f;
        this.dhU = f;
        this.dhW = f;
        invalidate();
    }
}
