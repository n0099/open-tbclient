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
    private float dPA;
    private float dPB;
    private Paint dPC;
    private Paint dPD;
    private float dPy;
    private float dPz;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dPC = new Paint();
        this.dPC.setColor(-1);
        this.dPC.setAntiAlias(true);
        this.dPC.setStyle(Paint.Style.FILL);
        this.dPC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.dPD = new Paint();
        this.dPD.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.dPD, 31);
        super.dispatchDraw(canvas);
        s(canvas);
        t(canvas);
        u(canvas);
        v(canvas);
        canvas.restore();
    }

    private void s(Canvas canvas) {
        if (this.dPy > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dPy);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dPy, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dPy * 2.0f, this.dPy * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dPC);
        }
    }

    private void t(Canvas canvas) {
        if (this.dPz > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dPz, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dPz);
            path.arcTo(new RectF(width - (this.dPz * 2.0f), 0.0f, width, this.dPz * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.dPC);
        }
    }

    private void u(Canvas canvas) {
        if (this.dPA > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dPA);
            path.lineTo(0.0f, height);
            path.lineTo(this.dPA, height);
            path.arcTo(new RectF(0.0f, height - (this.dPA * 2.0f), this.dPA * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dPC);
        }
    }

    private void v(Canvas canvas) {
        if (this.dPB > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dPB, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dPB);
            path.arcTo(new RectF(width - (this.dPB * 2.0f), height - (this.dPB * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.dPC);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dPy = f;
    }

    public void setTopRightRadius(float f) {
        this.dPz = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dPA = f;
    }

    public void setBottomRightRadius(float f) {
        this.dPB = f;
    }

    public void setRadius(float f) {
        this.dPy = f;
        this.dPA = f;
        this.dPz = f;
        this.dPB = f;
        invalidate();
    }
}
