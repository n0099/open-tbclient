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
    private float dyh;
    private float dyi;
    private float dyj;
    private float dyk;
    private Paint dyl;
    private Paint dym;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dyl = new Paint();
        this.dyl.setColor(-1);
        this.dyl.setAntiAlias(true);
        this.dyl.setStyle(Paint.Style.FILL);
        this.dyl.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dym = new Paint();
        this.dym.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dym, 31);
        super.dispatchDraw(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        t(canvas);
        canvas.restore();
    }

    private void q(Canvas canvas) {
        if (this.dyh > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dyh);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dyh, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dyh * 2.0f, this.dyh * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dyl);
        }
    }

    private void r(Canvas canvas) {
        if (this.dyi > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dyi, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dyi);
            path.arcTo(new RectF(width - (this.dyi * 2.0f), 0.0f, width, this.dyi * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dyl);
        }
    }

    private void s(Canvas canvas) {
        if (this.dyj > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dyj);
            path.lineTo(0.0f, height);
            path.lineTo(this.dyj, height);
            path.arcTo(new RectF(0.0f, height - (this.dyj * 2.0f), this.dyj * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dyl);
        }
    }

    private void t(Canvas canvas) {
        if (this.dyk > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dyk, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dyk);
            path.arcTo(new RectF(width - (this.dyk * 2.0f), height - (this.dyk * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dyl);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dyh = f;
    }

    public void setTopRightRadius(float f) {
        this.dyi = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dyj = f;
    }

    public void setBottomRightRadius(float f) {
        this.dyk = f;
    }

    public void setRadius(float f) {
        this.dyh = f;
        this.dyj = f;
        this.dyi = f;
        this.dyk = f;
        invalidate();
    }
}
