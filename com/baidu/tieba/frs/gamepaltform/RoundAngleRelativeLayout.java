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
/* loaded from: classes7.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint aAC;
    private float cYo;
    private float cYp;
    private float cYq;
    private float cYr;
    private Paint gzk;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aAC = new Paint();
        this.aAC.setColor(-1);
        this.aAC.setAntiAlias(true);
        this.aAC.setStyle(Paint.Style.FILL);
        this.aAC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.gzk = new Paint();
        this.gzk.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.gzk, 31);
        super.dispatchDraw(canvas);
        G(canvas);
        H(canvas);
        I(canvas);
        J(canvas);
        canvas.restore();
    }

    private void G(Canvas canvas) {
        if (this.cYp > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.cYp);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.cYp, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.cYp * 2.0f, this.cYp * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aAC);
        }
    }

    private void H(Canvas canvas) {
        if (this.cYo > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.cYo, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.cYo);
            path.arcTo(new RectF(width - (this.cYo * 2.0f), 0.0f, width, this.cYo * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aAC);
        }
    }

    private void I(Canvas canvas) {
        if (this.cYr > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.cYr);
            path.lineTo(0.0f, height);
            path.lineTo(this.cYr, height);
            path.arcTo(new RectF(0.0f, height - (this.cYr * 2.0f), this.cYr * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aAC);
        }
    }

    private void J(Canvas canvas) {
        if (this.cYq > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.cYq, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.cYq);
            path.arcTo(new RectF(width - (this.cYq * 2.0f), height - (this.cYq * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aAC);
        }
    }

    public void setTopLeftRadius(float f) {
        this.cYp = f;
    }

    public void setTopRightRadius(float f) {
        this.cYo = f;
    }

    public void setBottomLeftRadius(float f) {
        this.cYr = f;
    }

    public void setBottomRightRadius(float f) {
        this.cYq = f;
    }

    public void setRadius(float f) {
        this.cYp = f;
        this.cYr = f;
        this.cYo = f;
        this.cYq = f;
        invalidate();
    }
}
