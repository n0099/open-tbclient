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
/* loaded from: classes16.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint btH;
    private float enu;
    private float enw;
    private float enx;
    private float eny;
    private Paint iiV;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btH = new Paint();
        this.btH.setColor(-1);
        this.btH.setAntiAlias(true);
        this.btH.setStyle(Paint.Style.FILL);
        this.btH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.iiV = new Paint();
        this.iiV.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.iiV, 31);
        super.dispatchDraw(canvas);
        R(canvas);
        S(canvas);
        T(canvas);
        U(canvas);
        canvas.restore();
    }

    private void R(Canvas canvas) {
        if (this.enw > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.enw);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.enw, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.enw * 2.0f, this.enw * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.btH);
        }
    }

    private void S(Canvas canvas) {
        if (this.enu > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.enu, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.enu);
            path.arcTo(new RectF(width - (this.enu * 2.0f), 0.0f, width, this.enu * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.btH);
        }
    }

    private void T(Canvas canvas) {
        if (this.eny > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.eny);
            path.lineTo(0.0f, height);
            path.lineTo(this.eny, height);
            path.arcTo(new RectF(0.0f, height - (this.eny * 2.0f), this.eny * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.btH);
        }
    }

    private void U(Canvas canvas) {
        if (this.enx > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.enx, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.enx);
            path.arcTo(new RectF(width - (this.enx * 2.0f), height - (this.enx * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.btH);
        }
    }

    public void setTopLeftRadius(float f) {
        this.enw = f;
    }

    public void setTopRightRadius(float f) {
        this.enu = f;
    }

    public void setBottomLeftRadius(float f) {
        this.eny = f;
    }

    public void setBottomRightRadius(float f) {
        this.enx = f;
    }

    public void setRadius(float f) {
        this.enw = f;
        this.eny = f;
        this.enu = f;
        this.enx = f;
        invalidate();
    }
}
