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
/* loaded from: classes21.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint bxa;
    private float epM;
    private float epN;
    private float epO;
    private float epP;
    private Paint ipX;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bxa = new Paint();
        this.bxa.setColor(-1);
        this.bxa.setAntiAlias(true);
        this.bxa.setStyle(Paint.Style.FILL);
        this.bxa.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.ipX = new Paint();
        this.ipX.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.ipX, 31);
        super.dispatchDraw(canvas);
        R(canvas);
        S(canvas);
        T(canvas);
        U(canvas);
        canvas.restore();
    }

    private void R(Canvas canvas) {
        if (this.epN > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.epN);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.epN, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.epN * 2.0f, this.epN * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bxa);
        }
    }

    private void S(Canvas canvas) {
        if (this.epM > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.epM, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.epM);
            path.arcTo(new RectF(width - (this.epM * 2.0f), 0.0f, width, this.epM * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.bxa);
        }
    }

    private void T(Canvas canvas) {
        if (this.epP > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.epP);
            path.lineTo(0.0f, height);
            path.lineTo(this.epP, height);
            path.arcTo(new RectF(0.0f, height - (this.epP * 2.0f), this.epP * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bxa);
        }
    }

    private void U(Canvas canvas) {
        if (this.epO > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.epO, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.epO);
            path.arcTo(new RectF(width - (this.epO * 2.0f), height - (this.epO * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.bxa);
        }
    }

    public void setTopLeftRadius(float f) {
        this.epN = f;
    }

    public void setTopRightRadius(float f) {
        this.epM = f;
    }

    public void setBottomLeftRadius(float f) {
        this.epP = f;
    }

    public void setBottomRightRadius(float f) {
        this.epO = f;
    }

    public void setRadius(float f) {
        this.epN = f;
        this.epP = f;
        this.epM = f;
        this.epO = f;
        invalidate();
    }
}
