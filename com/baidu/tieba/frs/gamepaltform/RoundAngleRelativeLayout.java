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
    private Paint aEU;
    private float dcG;
    private float dcH;
    private float dcI;
    private float dcJ;
    private Paint gBy;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEU = new Paint();
        this.aEU.setColor(-1);
        this.aEU.setAntiAlias(true);
        this.aEU.setStyle(Paint.Style.FILL);
        this.aEU.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.gBy = new Paint();
        this.gBy.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.gBy, 31);
        super.dispatchDraw(canvas);
        G(canvas);
        H(canvas);
        I(canvas);
        J(canvas);
        canvas.restore();
    }

    private void G(Canvas canvas) {
        if (this.dcH > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.dcH);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.dcH, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.dcH * 2.0f, this.dcH * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aEU);
        }
    }

    private void H(Canvas canvas) {
        if (this.dcG > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dcG, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.dcG);
            path.arcTo(new RectF(width - (this.dcG * 2.0f), 0.0f, width, this.dcG * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.aEU);
        }
    }

    private void I(Canvas canvas) {
        if (this.dcJ > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.dcJ);
            path.lineTo(0.0f, height);
            path.lineTo(this.dcJ, height);
            path.arcTo(new RectF(0.0f, height - (this.dcJ * 2.0f), this.dcJ * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aEU);
        }
    }

    private void J(Canvas canvas) {
        if (this.dcI > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.dcI, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.dcI);
            path.arcTo(new RectF(width - (this.dcI * 2.0f), height - (this.dcI * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.aEU);
        }
    }

    public void setTopLeftRadius(float f) {
        this.dcH = f;
    }

    public void setTopRightRadius(float f) {
        this.dcG = f;
    }

    public void setBottomLeftRadius(float f) {
        this.dcJ = f;
    }

    public void setBottomRightRadius(float f) {
        this.dcI = f;
    }

    public void setRadius(float f) {
        this.dcH = f;
        this.dcJ = f;
        this.dcG = f;
        this.dcI = f;
        invalidate();
    }
}
