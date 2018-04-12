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
    private float dhW;
    private float dhX;
    private float dhY;
    private float dhZ;
    private Paint dia;
    private Paint dib;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dia = new Paint();
        this.dia.setColor(-1);
        this.dia.setAntiAlias(true);
        this.dia.setStyle(Paint.Style.FILL);
        this.dia.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dib = new Paint();
        this.dib.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dib, 31);
        super.dispatchDraw(canvas);
        p(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        canvas.restore();
    }

    private void p(Canvas canvas) {
        if (this.dhW > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dhW);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dhW, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dhW * 2.0f, this.dhW * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dia);
        }
    }

    private void q(Canvas canvas) {
        if (this.dhX > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dhX, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dhX);
            path.arcTo(new RectF(width - (this.dhX * 2.0f), 0.0f, width, this.dhX * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dia);
        }
    }

    private void r(Canvas canvas) {
        if (this.dhY > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dhY);
            path.lineTo(0.0f, height);
            path.lineTo(this.dhY, height);
            path.arcTo(new RectF(0.0f, height - (this.dhY * 2.0f), this.dhY * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dia);
        }
    }

    private void s(Canvas canvas) {
        if (this.dhZ > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dhZ, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dhZ);
            path.arcTo(new RectF(width - (this.dhZ * 2.0f), height - (this.dhZ * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dia);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dhW = f;
    }

    public void setTopRightRadius(float f) {
        this.dhX = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dhY = f;
    }

    public void setBottomRightRadius(float f) {
        this.dhZ = f;
    }

    public void setRadius(float f) {
        this.dhW = f;
        this.dhY = f;
        this.dhX = f;
        this.dhZ = f;
        invalidate();
    }
}
