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
    private float dPm;
    private float dPn;
    private float dPo;
    private float dPp;
    private Paint dPq;
    private Paint dPr;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dPq = new Paint();
        this.dPq.setColor(-1);
        this.dPq.setAntiAlias(true);
        this.dPq.setStyle(Paint.Style.FILL);
        this.dPq.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dPr = new Paint();
        this.dPr.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dPr, 31);
        super.dispatchDraw(canvas);
        s(canvas);
        t(canvas);
        u(canvas);
        v(canvas);
        canvas.restore();
    }

    private void s(Canvas canvas) {
        if (this.dPm > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dPm);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dPm, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dPm * 2.0f, this.dPm * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dPq);
        }
    }

    private void t(Canvas canvas) {
        if (this.dPn > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dPn, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dPn);
            path.arcTo(new RectF(width - (this.dPn * 2.0f), 0.0f, width, this.dPn * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dPq);
        }
    }

    private void u(Canvas canvas) {
        if (this.dPo > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dPo);
            path.lineTo(0.0f, height);
            path.lineTo(this.dPo, height);
            path.arcTo(new RectF(0.0f, height - (this.dPo * 2.0f), this.dPo * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dPq);
        }
    }

    private void v(Canvas canvas) {
        if (this.dPp > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dPp, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dPp);
            path.arcTo(new RectF(width - (this.dPp * 2.0f), height - (this.dPp * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dPq);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dPm = f;
    }

    public void setTopRightRadius(float f) {
        this.dPn = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dPo = f;
    }

    public void setBottomRightRadius(float f) {
        this.dPp = f;
    }

    public void setRadius(float f) {
        this.dPm = f;
        this.dPo = f;
        this.dPn = f;
        this.dPp = f;
        invalidate();
    }
}
