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
    private Paint bVj;
    private float ffj;
    private float ffk;
    private float ffl;
    private float ffm;
    private Paint jAS;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bVj = new Paint();
        this.bVj.setColor(-1);
        this.bVj.setAntiAlias(true);
        this.bVj.setStyle(Paint.Style.FILL);
        this.bVj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.jAS = new Paint();
        this.jAS.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.jAS, 31);
        super.dispatchDraw(canvas);
        ab(canvas);
        ac(canvas);
        ad(canvas);
        ae(canvas);
        canvas.restore();
    }

    private void ab(Canvas canvas) {
        if (this.ffk > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.ffk);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.ffk, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.ffk * 2.0f, this.ffk * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bVj);
        }
    }

    private void ac(Canvas canvas) {
        if (this.ffj > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.ffj, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.ffj);
            path.arcTo(new RectF(width - (this.ffj * 2.0f), 0.0f, width, this.ffj * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bVj);
        }
    }

    private void ad(Canvas canvas) {
        if (this.ffm > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.ffm);
            path.lineTo(0.0f, height);
            path.lineTo(this.ffm, height);
            path.arcTo(new RectF(0.0f, height - (this.ffm * 2.0f), this.ffm * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bVj);
        }
    }

    private void ae(Canvas canvas) {
        if (this.ffl > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.ffl, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.ffl);
            path.arcTo(new RectF(width - (this.ffl * 2.0f), height - (this.ffl * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bVj);
        }
    }

    public void setTopLeftRadius(float f) {
        this.ffk = f;
    }

    public void setTopRightRadius(float f) {
        this.ffj = f;
    }

    public void setBottomLeftRadius(float f) {
        this.ffm = f;
    }

    public void setBottomRightRadius(float f) {
        this.ffl = f;
    }

    public void setRadius(float f) {
        this.ffk = f;
        this.ffm = f;
        this.ffj = f;
        this.ffl = f;
        invalidate();
    }
}
