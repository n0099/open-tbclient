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
    private float dPr;
    private float dPs;
    private float dPt;
    private float dPu;
    private Paint dPv;
    private Paint dPw;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dPv = new Paint();
        this.dPv.setColor(-1);
        this.dPv.setAntiAlias(true);
        this.dPv.setStyle(Paint.Style.FILL);
        this.dPv.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dPw = new Paint();
        this.dPw.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dPw, 31);
        super.dispatchDraw(canvas);
        s(canvas);
        t(canvas);
        u(canvas);
        v(canvas);
        canvas.restore();
    }

    private void s(Canvas canvas) {
        if (this.dPr > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dPr);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dPr, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dPr * 2.0f, this.dPr * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dPv);
        }
    }

    private void t(Canvas canvas) {
        if (this.dPs > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dPs, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dPs);
            path.arcTo(new RectF(width - (this.dPs * 2.0f), 0.0f, width, this.dPs * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dPv);
        }
    }

    private void u(Canvas canvas) {
        if (this.dPt > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dPt);
            path.lineTo(0.0f, height);
            path.lineTo(this.dPt, height);
            path.arcTo(new RectF(0.0f, height - (this.dPt * 2.0f), this.dPt * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dPv);
        }
    }

    private void v(Canvas canvas) {
        if (this.dPu > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dPu, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dPu);
            path.arcTo(new RectF(width - (this.dPu * 2.0f), height - (this.dPu * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dPv);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dPr = f;
    }

    public void setTopRightRadius(float f) {
        this.dPs = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dPt = f;
    }

    public void setBottomRightRadius(float f) {
        this.dPu = f;
    }

    public void setRadius(float f) {
        this.dPr = f;
        this.dPt = f;
        this.dPs = f;
        this.dPu = f;
        invalidate();
    }
}
