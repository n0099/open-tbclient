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
/* loaded from: classes22.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint bMe;
    private float eQj;
    private float eQk;
    private float eQl;
    private float eQm;
    private Paint iXj;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bMe = new Paint();
        this.bMe.setColor(-1);
        this.bMe.setAntiAlias(true);
        this.bMe.setStyle(Paint.Style.FILL);
        this.bMe.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.iXj = new Paint();
        this.iXj.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.iXj, 31);
        super.dispatchDraw(canvas);
        S(canvas);
        T(canvas);
        U(canvas);
        V(canvas);
        canvas.restore();
    }

    private void S(Canvas canvas) {
        if (this.eQk > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.eQk);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.eQk, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.eQk * 2.0f, this.eQk * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bMe);
        }
    }

    private void T(Canvas canvas) {
        if (this.eQj > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.eQj, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.eQj);
            path.arcTo(new RectF(width - (this.eQj * 2.0f), 0.0f, width, this.eQj * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bMe);
        }
    }

    private void U(Canvas canvas) {
        if (this.eQm > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.eQm);
            path.lineTo(0.0f, height);
            path.lineTo(this.eQm, height);
            path.arcTo(new RectF(0.0f, height - (this.eQm * 2.0f), this.eQm * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bMe);
        }
    }

    private void V(Canvas canvas) {
        if (this.eQl > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.eQl, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.eQl);
            path.arcTo(new RectF(width - (this.eQl * 2.0f), height - (this.eQl * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bMe);
        }
    }

    public void setTopLeftRadius(float f) {
        this.eQk = f;
    }

    public void setTopRightRadius(float f) {
        this.eQj = f;
    }

    public void setBottomLeftRadius(float f) {
        this.eQm = f;
    }

    public void setBottomRightRadius(float f) {
        this.eQl = f;
    }

    public void setRadius(float f) {
        this.eQk = f;
        this.eQm = f;
        this.eQj = f;
        this.eQl = f;
        invalidate();
    }
}
