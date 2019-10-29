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
/* loaded from: classes4.dex */
public class RoundAngleRelativeLayout extends RelativeLayout {
    private Paint ast;
    private float fIA;
    private float fIB;
    private Paint fIC;
    private float fIy;
    private float fIz;

    public RoundAngleRelativeLayout(Context context) {
        this(context, null);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ast = new Paint();
        this.ast.setColor(-1);
        this.ast.setAntiAlias(true);
        this.ast.setStyle(Paint.Style.FILL);
        this.ast.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.fIC = new Paint();
        this.fIC.setXfermode(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.fIC, 31);
        super.dispatchDraw(canvas);
        J(canvas);
        K(canvas);
        L(canvas);
        M(canvas);
        canvas.restore();
    }

    private void J(Canvas canvas) {
        if (this.fIy > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.fIy);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.fIy, 0.0f);
            path.arcTo(new RectF(0.0f, 0.0f, this.fIy * 2.0f, this.fIy * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.ast);
        }
    }

    private void K(Canvas canvas) {
        if (this.fIz > 0.0f) {
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fIz, 0.0f);
            path.lineTo(width, 0.0f);
            path.lineTo(width, this.fIz);
            path.arcTo(new RectF(width - (this.fIz * 2.0f), 0.0f, width, this.fIz * 2.0f), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.ast);
        }
    }

    private void L(Canvas canvas) {
        if (this.fIA > 0.0f) {
            int height = getHeight();
            Path path = new Path();
            path.moveTo(0.0f, height - this.fIA);
            path.lineTo(0.0f, height);
            path.lineTo(this.fIA, height);
            path.arcTo(new RectF(0.0f, height - (this.fIA * 2.0f), this.fIA * 2.0f, height), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.ast);
        }
    }

    private void M(Canvas canvas) {
        if (this.fIB > 0.0f) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            path.moveTo(width - this.fIB, height);
            path.lineTo(width, height);
            path.lineTo(width, height - this.fIB);
            path.arcTo(new RectF(width - (this.fIB * 2.0f), height - (this.fIB * 2.0f), width, height), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.ast);
        }
    }

    public void setTopLeftRadius(float f) {
        this.fIy = f;
    }

    public void setTopRightRadius(float f) {
        this.fIz = f;
    }

    public void setBottomLeftRadius(float f) {
        this.fIA = f;
    }

    public void setBottomRightRadius(float f) {
        this.fIB = f;
    }

    public void setRadius(float f) {
        this.fIy = f;
        this.fIA = f;
        this.fIz = f;
        this.fIB = f;
        invalidate();
    }
}
