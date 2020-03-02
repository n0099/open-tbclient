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
/* loaded from: classes9.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint aET;
    private float dcs;
    private float dct;
    private float dcv;
    private float dcw;
    private Paint gBm;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aET = new Paint();
        this.aET.setColor(-1);
        this.aET.setAntiAlias(true);
        this.aET.setStyle(Paint.Style.FILL);
        this.aET.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.gBm = new Paint();
        this.gBm.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.gBm, 31);
        super.dispatchDraw(canvas);
        G(canvas);
        H(canvas);
        I(canvas);
        J(canvas);
        canvas.restore();
    }

    private void G(Canvas canvas) {
        if (this.dct > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dct);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dct, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dct * 2.0f, this.dct * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aET);
        }
    }

    private void H(Canvas canvas) {
        if (this.dcs > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dcs, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dcs);
            path.arcTo(new RectF(width - (this.dcs * 2.0f), 0.0f, width, this.dcs * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aET);
        }
    }

    private void I(Canvas canvas) {
        if (this.dcw > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dcw);
            path.lineTo(0.0f, height);
            path.lineTo(this.dcw, height);
            path.arcTo(new RectF(0.0f, height - (this.dcw * 2.0f), this.dcw * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aET);
        }
    }

    private void J(Canvas canvas) {
        if (this.dcv > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dcv, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dcv);
            path.arcTo(new RectF(width - (this.dcv * 2.0f), height - (this.dcv * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aET);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dct = f;
    }

    public void setTopRightRadius(float f) {
        this.dcs = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dcw = f;
    }

    public void setBottomRightRadius(float f) {
        this.dcv = f;
    }

    public void setRadius(float f) {
        this.dct = f;
        this.dcw = f;
        this.dcs = f;
        this.dcv = f;
        invalidate();
    }
}
