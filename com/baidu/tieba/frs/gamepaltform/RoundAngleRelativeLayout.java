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
/* loaded from: classes21.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint bKu;
    private float ePn;
    private float ePo;
    private float ePp;
    private float ePq;
    private Paint iXV;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bKu = new Paint();
        this.bKu.setColor(-1);
        this.bKu.setAntiAlias(true);
        this.bKu.setStyle(Paint.Style.FILL);
        this.bKu.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.iXV = new Paint();
        this.iXV.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.iXV, 31);
        super.dispatchDraw(canvas);
        V(canvas);
        W(canvas);
        X(canvas);
        Y(canvas);
        canvas.restore();
    }

    private void V(Canvas canvas) {
        if (this.ePo > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.ePo);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.ePo, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.ePo * 2.0f, this.ePo * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bKu);
        }
    }

    private void W(Canvas canvas) {
        if (this.ePn > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.ePn, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.ePn);
            path.arcTo(new RectF(width - (this.ePn * 2.0f), 0.0f, width, this.ePn * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bKu);
        }
    }

    private void X(Canvas canvas) {
        if (this.ePq > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.ePq);
            path.lineTo(0.0f, height);
            path.lineTo(this.ePq, height);
            path.arcTo(new RectF(0.0f, height - (this.ePq * 2.0f), this.ePq * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bKu);
        }
    }

    private void Y(Canvas canvas) {
        if (this.ePp > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.ePp, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.ePp);
            path.arcTo(new RectF(width - (this.ePp * 2.0f), height - (this.ePp * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bKu);
        }
    }

    public void setTopLeftRadius(float f) {
        this.ePo = f;
    }

    public void setTopRightRadius(float f) {
        this.ePn = f;
    }

    public void setBottomLeftRadius(float f) {
        this.ePq = f;
    }

    public void setBottomRightRadius(float f) {
        this.ePp = f;
    }

    public void setRadius(float f) {
        this.ePo = f;
        this.ePq = f;
        this.ePn = f;
        this.ePp = f;
        invalidate();
    }
}
