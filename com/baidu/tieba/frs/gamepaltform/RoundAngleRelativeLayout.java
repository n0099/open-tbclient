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
/* loaded from: classes2.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint bPT;
    private float fbu;
    private float fbv;
    private float fbw;
    private float fbx;
    private Paint jtp;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bPT = new Paint();
        this.bPT.setColor(-1);
        this.bPT.setAntiAlias(true);
        this.bPT.setStyle(Paint.Style.FILL);
        this.bPT.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.jtp = new Paint();
        this.jtp.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.jtp, 31);
        super.dispatchDraw(canvas);
        ab(canvas);
        ac(canvas);
        ad(canvas);
        ae(canvas);
        canvas.restore();
    }

    private void ab(Canvas canvas) {
        if (this.fbv > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fbv);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fbv, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fbv * 2.0f, this.fbv * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bPT);
        }
    }

    private void ac(Canvas canvas) {
        if (this.fbu > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fbu, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fbu);
            path.arcTo(new RectF(width - (this.fbu * 2.0f), 0.0f, width, this.fbu * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bPT);
        }
    }

    private void ad(Canvas canvas) {
        if (this.fbx > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fbx);
            path.lineTo(0.0f, height);
            path.lineTo(this.fbx, height);
            path.arcTo(new RectF(0.0f, height - (this.fbx * 2.0f), this.fbx * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bPT);
        }
    }

    private void ae(Canvas canvas) {
        if (this.fbw > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fbw, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fbw);
            path.arcTo(new RectF(width - (this.fbw * 2.0f), height - (this.fbw * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bPT);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fbv = f;
    }

    public void setTopRightRadius(float f) {
        this.fbu = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fbx = f;
    }

    public void setBottomRightRadius(float f) {
        this.fbw = f;
    }

    public void setRadius(float f) {
        this.fbv = f;
        this.fbx = f;
        this.fbu = f;
        this.fbw = f;
        invalidate();
    }
}
