package com.baidu.tieba.ala.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class RoundProgressBar extends View {
    private float aJh;
    private int aJi;
    private int max;
    private Paint paint;
    private int progress;
    private int progressColor;
    private int roundColor;
    private float roundWidth;
    private int style;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.RoundProgressBar);
        this.roundColor = obtainStyledAttributes.getColor(a.k.RoundProgressBar_srp_roundColor, SupportMenu.CATEGORY_MASK);
        this.roundWidth = obtainStyledAttributes.getDimension(a.k.RoundProgressBar_srp_roundWidth, 5.0f);
        this.progressColor = obtainStyledAttributes.getColor(a.k.RoundProgressBar_srp_progressColor, -16711936);
        this.aJh = obtainStyledAttributes.getDimension(a.k.RoundProgressBar_srp_progressWidth, this.roundWidth);
        this.max = obtainStyledAttributes.getInteger(a.k.RoundProgressBar_srp_max, 100);
        this.style = obtainStyledAttributes.getInt(a.k.RoundProgressBar_srp_style, 0);
        this.aJi = obtainStyledAttributes.getInt(a.k.RoundProgressBar_srp_startAngle, 90);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f = 350.0f;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int i = (int) (width - (this.roundWidth / 2.0f));
        this.paint.setStrokeWidth(this.roundWidth);
        this.paint.setColor(this.roundColor);
        this.paint.setAntiAlias(true);
        switch (this.style) {
            case 0:
                this.paint.setStyle(Paint.Style.STROKE);
                break;
            case 1:
                this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
                break;
        }
        canvas.drawCircle(width, width, i, this.paint);
        this.paint.setStrokeWidth(this.aJh);
        this.paint.setColor(this.progressColor);
        RectF rectF = new RectF(width - i, width - i, width + i, width + i);
        float f2 = (float) ((360.0d * this.progress) / this.max);
        if (f2 < 350.0f || f2 >= 360.0f) {
            f = f2 >= 360.0f ? 360.0f : f2;
        }
        switch (this.style) {
            case 0:
                this.paint.setStrokeCap(Paint.Cap.ROUND);
                canvas.drawArc(rectF, this.aJi, f, false, this.paint);
                return;
            case 1:
                canvas.drawArc(rectF, this.aJi, f, true, this.paint);
                return;
            default:
                return;
        }
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.max) {
            i = this.max;
        }
        this.progress = i;
        invalidate();
    }
}
