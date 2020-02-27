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
    private Paint aES;
    private float dcr;
    private float dcs;
    private float dct;
    private float dcv;
    private Paint gBk;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aES = new Paint();
        this.aES.setColor(-1);
        this.aES.setAntiAlias(true);
        this.aES.setStyle(Paint.Style.FILL);
        this.aES.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.gBk = new Paint();
        this.gBk.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.gBk, 31);
        super.dispatchDraw(canvas);
        G(canvas);
        H(canvas);
        I(canvas);
        J(canvas);
        canvas.restore();
    }

    private void G(Canvas canvas) {
        if (this.dcs > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dcs);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dcs, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dcs * 2.0f, this.dcs * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aES);
        }
    }

    private void H(Canvas canvas) {
        if (this.dcr > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dcr, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dcr);
            path.arcTo(new RectF(width - (this.dcr * 2.0f), 0.0f, width, this.dcr * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aES);
        }
    }

    private void I(Canvas canvas) {
        if (this.dcv > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dcv);
            path.lineTo(0.0f, height);
            path.lineTo(this.dcv, height);
            path.arcTo(new RectF(0.0f, height - (this.dcv * 2.0f), this.dcv * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aES);
        }
    }

    private void J(Canvas canvas) {
        if (this.dct > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dct, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dct);
            path.arcTo(new RectF(width - (this.dct * 2.0f), height - (this.dct * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aES);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dcs = f;
    }

    public void setTopRightRadius(float f) {
        this.dcr = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dcv = f;
    }

    public void setBottomRightRadius(float f) {
        this.dct = f;
    }

    public void setRadius(float f) {
        this.dcs = f;
        this.dcv = f;
        this.dcr = f;
        this.dct = f;
        invalidate();
    }
}
