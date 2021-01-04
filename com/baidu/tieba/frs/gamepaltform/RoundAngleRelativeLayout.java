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
    private Paint bUF;
    private float fgd;
    private float fge;
    private float fgf;
    private float fgg;
    private Paint jxV;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUF = new Paint();
        this.bUF.setColor(-1);
        this.bUF.setAntiAlias(true);
        this.bUF.setStyle(Paint.Style.FILL);
        this.bUF.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.jxV = new Paint();
        this.jxV.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.jxV, 31);
        super.dispatchDraw(canvas);
        ab(canvas);
        ac(canvas);
        ad(canvas);
        ae(canvas);
        canvas.restore();
    }

    private void ab(Canvas canvas) {
        if (this.fge > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fge);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fge, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fge * 2.0f, this.fge * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bUF);
        }
    }

    private void ac(Canvas canvas) {
        if (this.fgd > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fgd, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fgd);
            path.arcTo(new RectF(width - (this.fgd * 2.0f), 0.0f, width, this.fgd * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bUF);
        }
    }

    private void ad(Canvas canvas) {
        if (this.fgg > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fgg);
            path.lineTo(0.0f, height);
            path.lineTo(this.fgg, height);
            path.arcTo(new RectF(0.0f, height - (this.fgg * 2.0f), this.fgg * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bUF);
        }
    }

    private void ae(Canvas canvas) {
        if (this.fgf > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fgf, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fgf);
            path.arcTo(new RectF(width - (this.fgf * 2.0f), height - (this.fgf * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bUF);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fge = f;
    }

    public void setTopRightRadius(float f) {
        this.fgd = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fgg = f;
    }

    public void setBottomRightRadius(float f) {
        this.fgf = f;
    }

    public void setRadius(float f) {
        this.fge = f;
        this.fgg = f;
        this.fgd = f;
        this.fgf = f;
        invalidate();
    }
}
