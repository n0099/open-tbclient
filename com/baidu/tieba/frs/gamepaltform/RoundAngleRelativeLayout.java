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
    private float fJg;
    private float fJh;
    private float fJi;
    private float fJj;
    private Paint fJk;
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
        this.fJk = new Paint();
        this.fJk.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.fJk, 31);
        super.dispatchDraw(canvas);
        L(canvas);
        M(canvas);
        N(canvas);
        O(canvas);
        canvas.restore();
    }

    private void L(Canvas canvas) {
        if (this.fJg > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fJg);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fJg, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fJg * 2.0f, this.fJg * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void M(Canvas canvas) {
        if (this.fJh > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fJh, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fJh);
            path.arcTo(new RectF(width - (this.fJh * 2.0f), 0.0f, width, this.fJh * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void N(Canvas canvas) {
        if (this.fJi > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fJi);
            path.lineTo(0.0f, height);
            path.lineTo(this.fJi, height);
            path.arcTo(new RectF(0.0f, height - (this.fJi * 2.0f), this.fJi * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    private void O(Canvas canvas) {
        if (this.fJj > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fJj, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fJj);
            path.arcTo(new RectF(width - (this.fJj * 2.0f), height - (this.fJj * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.roundPaint);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fJg = f;
    }

    public void setTopRightRadius(float f) {
        this.fJh = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fJi = f;
    }

    public void setBottomRightRadius(float f) {
        this.fJj = f;
    }

    public void setRadius(float f) {
        this.fJg = f;
        this.fJi = f;
        this.fJh = f;
        this.fJj = f;
        invalidate();
    }
}
