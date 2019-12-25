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
/* loaded from: classes6.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint azR;
    private float cYe;
    private float cYf;
    private float cYg;
    private float cYh;
    private Paint gwa;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azR = new Paint();
        this.azR.setColor(-1);
        this.azR.setAntiAlias(true);
        this.azR.setStyle(Paint.Style.FILL);
        this.azR.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.gwa = new Paint();
        this.gwa.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.gwa, 31);
        super.dispatchDraw(canvas);
        G(canvas);
        H(canvas);
        I(canvas);
        J(canvas);
        canvas.restore();
    }

    private void G(Canvas canvas) {
        if (this.cYf > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.cYf);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.cYf, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.cYf * 2.0f, this.cYf * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.azR);
        }
    }

    private void H(Canvas canvas) {
        if (this.cYe > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.cYe, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.cYe);
            path.arcTo(new RectF(width - (this.cYe * 2.0f), 0.0f, width, this.cYe * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.azR);
        }
    }

    private void I(Canvas canvas) {
        if (this.cYh > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.cYh);
            path.lineTo(0.0f, height);
            path.lineTo(this.cYh, height);
            path.arcTo(new RectF(0.0f, height - (this.cYh * 2.0f), this.cYh * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.azR);
        }
    }

    private void J(Canvas canvas) {
        if (this.cYg > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.cYg, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.cYg);
            path.arcTo(new RectF(width - (this.cYg * 2.0f), height - (this.cYg * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.azR);
        }
    }

    public void setTopLeftRadius(float f) {
        this.cYf = f;
    }

    public void setTopRightRadius(float f) {
        this.cYe = f;
    }

    public void setBottomLeftRadius(float f) {
        this.cYh = f;
    }

    public void setBottomRightRadius(float f) {
        this.cYg = f;
    }

    public void setRadius(float f) {
        this.cYf = f;
        this.cYh = f;
        this.cYe = f;
        this.cYg = f;
        invalidate();
    }
}
