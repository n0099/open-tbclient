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
    private Paint bnS;
    private float edQ;
    private float edR;
    private float edS;
    private float edT;
    private Paint hUG;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnS = new Paint();
        this.bnS.setColor(-1);
        this.bnS.setAntiAlias(true);
        this.bnS.setStyle(Paint.Style.FILL);
        this.bnS.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.hUG = new Paint();
        this.hUG.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.hUG, 31);
        super.dispatchDraw(canvas);
        K(canvas);
        L(canvas);
        M(canvas);
        N(canvas);
        canvas.restore();
    }

    private void K(Canvas canvas) {
        if (this.edR > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.edR);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.edR, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.edR * 2.0f, this.edR * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bnS);
        }
    }

    private void L(Canvas canvas) {
        if (this.edQ > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.edQ, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.edQ);
            path.arcTo(new RectF(width - (this.edQ * 2.0f), 0.0f, width, this.edQ * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bnS);
        }
    }

    private void M(Canvas canvas) {
        if (this.edT > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.edT);
            path.lineTo(0.0f, height);
            path.lineTo(this.edT, height);
            path.arcTo(new RectF(0.0f, height - (this.edT * 2.0f), this.edT * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bnS);
        }
    }

    private void N(Canvas canvas) {
        if (this.edS > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.edS, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.edS);
            path.arcTo(new RectF(width - (this.edS * 2.0f), height - (this.edS * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bnS);
        }
    }

    public void setTopLeftRadius(float f) {
        this.edR = f;
    }

    public void setTopRightRadius(float f) {
        this.edQ = f;
    }

    public void setBottomLeftRadius(float f) {
        this.edT = f;
    }

    public void setBottomRightRadius(float f) {
        this.edS = f;
    }

    public void setRadius(float f) {
        this.edR = f;
        this.edT = f;
        this.edQ = f;
        this.edS = f;
        invalidate();
    }
}
