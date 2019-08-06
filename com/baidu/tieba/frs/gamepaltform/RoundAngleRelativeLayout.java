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
/* loaded from: classes4.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private float fHr;
    private float fHs;
    private float fHt;
    private float fHu;
    private Paint fHv;
    private Paint roundPaint;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.roundPaint = new Paint();
        this.roundPaint.setColor(-1);
        this.roundPaint.setAntiAlias(true);
        this.roundPaint.setStyle(Paint.Style.FILL);
        this.roundPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.fHv = new Paint();
        this.fHv.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.fHv, 31);
        super.dispatchDraw(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        M(canvas);
        canvas.restore();
    }

    private void J(Canvas canvas) {
        if (this.fHr > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fHr);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fHr, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fHr * 2.0f, this.fHr * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void K(Canvas canvas) {
        if (this.fHs > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fHs, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fHs);
            path.arcTo(new RectF(width - (this.fHs * 2.0f), 0.0f, width, this.fHs * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void L(Canvas canvas) {
        if (this.fHt > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fHt);
            path.lineTo(0.0f, height);
            path.lineTo(this.fHt, height);
            path.arcTo(new RectF(0.0f, height - (this.fHt * 2.0f), this.fHt * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void M(Canvas canvas) {
        if (this.fHu > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fHu, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fHu);
            path.arcTo(new RectF(width - (this.fHu * 2.0f), height - (this.fHu * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fHr = f;
    }

    public void setTopRightRadius(float f) {
        this.fHs = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fHt = f;
    }

    public void setBottomRightRadius(float f) {
        this.fHu = f;
    }

    public void setRadius(float f) {
        this.fHr = f;
        this.fHt = f;
        this.fHs = f;
        this.fHu = f;
        invalidate();
    }
}
