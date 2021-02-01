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
    private Paint bTJ;
    private float fdK;
    private float fdL;
    private float fdM;
    private float fdN;
    private Paint jyV;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bTJ = new Paint();
        this.bTJ.setColor(-1);
        this.bTJ.setAntiAlias(true);
        this.bTJ.setStyle(Paint.Style.FILL);
        this.bTJ.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.jyV = new Paint();
        this.jyV.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.jyV, 31);
        super.dispatchDraw(canvas);
        ab(canvas);
        ac(canvas);
        ad(canvas);
        ae(canvas);
        canvas.restore();
    }

    private void ab(Canvas canvas) {
        if (this.fdL > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fdL);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fdL, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fdL * 2.0f, this.fdL * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bTJ);
        }
    }

    private void ac(Canvas canvas) {
        if (this.fdK > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fdK, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fdK);
            path.arcTo(new RectF(width - (this.fdK * 2.0f), 0.0f, width, this.fdK * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bTJ);
        }
    }

    private void ad(Canvas canvas) {
        if (this.fdN > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fdN);
            path.lineTo(0.0f, height);
            path.lineTo(this.fdN, height);
            path.arcTo(new RectF(0.0f, height - (this.fdN * 2.0f), this.fdN * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bTJ);
        }
    }

    private void ae(Canvas canvas) {
        if (this.fdM > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fdM, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fdM);
            path.arcTo(new RectF(width - (this.fdM * 2.0f), height - (this.fdM * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bTJ);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fdL = f;
    }

    public void setTopRightRadius(float f) {
        this.fdK = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fdN = f;
    }

    public void setBottomRightRadius(float f) {
        this.fdM = f;
    }

    public void setRadius(float f) {
        this.fdL = f;
        this.fdN = f;
        this.fdK = f;
        this.fdM = f;
        invalidate();
    }
}
