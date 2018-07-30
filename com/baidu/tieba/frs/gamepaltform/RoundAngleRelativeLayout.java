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
    private float dyk;
    private float dyl;
    private float dym;
    private float dyn;
    private Paint dyo;
    private Paint dyp;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dyo = new Paint();
        this.dyo.setColor(-1);
        this.dyo.setAntiAlias(true);
        this.dyo.setStyle(Paint.Style.FILL);
        this.dyo.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dyp = new Paint();
        this.dyp.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dyp, 31);
        super.dispatchDraw(canvas);
        r(canvas);
        s(canvas);
        t(canvas);
        u(canvas);
        canvas.restore();
    }

    private void r(Canvas canvas) {
        if (this.dyk > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dyk);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dyk, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dyk * 2.0f, this.dyk * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dyo);
        }
    }

    private void s(Canvas canvas) {
        if (this.dyl > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dyl, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dyl);
            path.arcTo(new RectF(width - (this.dyl * 2.0f), 0.0f, width, this.dyl * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dyo);
        }
    }

    private void t(Canvas canvas) {
        if (this.dym > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dym);
            path.lineTo(0.0f, height);
            path.lineTo(this.dym, height);
            path.arcTo(new RectF(0.0f, height - (this.dym * 2.0f), this.dym * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dyo);
        }
    }

    private void u(Canvas canvas) {
        if (this.dyn > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dyn, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dyn);
            path.arcTo(new RectF(width - (this.dyn * 2.0f), height - (this.dyn * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dyo);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dyk = f;
    }

    public void setTopRightRadius(float f) {
        this.dyl = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dym = f;
    }

    public void setBottomRightRadius(float f) {
        this.dyn = f;
    }

    public void setRadius(float f) {
        this.dyk = f;
        this.dym = f;
        this.dyl = f;
        this.dyn = f;
        invalidate();
    }
}
