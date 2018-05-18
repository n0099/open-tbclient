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
    private float dja;
    private float djb;
    private float djc;
    private float djd;
    private Paint dje;
    private Paint djf;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dje = new Paint();
        this.dje.setColor(-1);
        this.dje.setAntiAlias(true);
        this.dje.setStyle(Paint.Style.FILL);
        this.dje.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.djf = new Paint();
        this.djf.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.djf, 31);
        super.dispatchDraw(canvas);
        p(canvas);
        q(canvas);
        r(canvas);
        s(canvas);
        canvas.restore();
    }

    private void p(Canvas canvas) {
        if (this.dja > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dja);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dja, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dja * 2.0f, this.dja * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dje);
        }
    }

    private void q(Canvas canvas) {
        if (this.djb > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.djb, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.djb);
            path.arcTo(new RectF(width - (this.djb * 2.0f), 0.0f, width, this.djb * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dje);
        }
    }

    private void r(Canvas canvas) {
        if (this.djc > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.djc);
            path.lineTo(0.0f, height);
            path.lineTo(this.djc, height);
            path.arcTo(new RectF(0.0f, height - (this.djc * 2.0f), this.djc * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dje);
        }
    }

    private void s(Canvas canvas) {
        if (this.djd > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.djd, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.djd);
            path.arcTo(new RectF(width - (this.djd * 2.0f), height - (this.djd * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dje);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dja = f;
    }

    public void setTopRightRadius(float f) {
        this.djb = f;
    }

    public void setBottomLeftRadius(float f) {
        this.djc = f;
    }

    public void setBottomRightRadius(float f) {
        this.djd = f;
    }

    public void setRadius(float f) {
        this.dja = f;
        this.djc = f;
        this.djb = f;
        this.djd = f;
        invalidate();
    }
}
