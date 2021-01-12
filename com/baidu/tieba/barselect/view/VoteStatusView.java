package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
/* loaded from: classes7.dex */
public class VoteStatusView extends View {
    public int ioA;
    public int ioB;
    private Path ioC;
    private Path ioD;
    private Path ioE;
    private Path ioF;
    private Path ioG;
    private boolean ioy;
    public int ioz;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.ioy = true;
        initUI();
    }

    private void initUI() {
        this.ioB = ao.getColor(R.color.CAM_X0204);
        this.ioz = ao.getColor(R.color.CAM_X0303);
        this.ioA = ao.getColor(R.color.CAM_X0302);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.ioB);
        this.ioC = new Path();
        this.ioD = new Path();
        this.ioE = new Path();
        this.ioF = new Path();
        this.ioG = new Path();
    }

    public void setStatus(int i) {
        this.status = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int height = (canvas.getHeight() - getPaddingBottom()) - getPaddingTop();
        int width = (canvas.getWidth() - getPaddingLeft()) - getPaddingRight();
        int i = height * 6 >= width ? width / 6 : height;
        this.ioC.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.ioD.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.ioE.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.ioF.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.ioG.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.ioB);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.ioy) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.ioz, this.ioA, Shader.TileMode.CLAMP);
            this.ioy = false;
        }
        if (this.status == d.inH) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.ioG, this.mPaint);
        canvas.drawPath(this.ioE, this.mPaint);
        if (this.status == d.inG) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.ioF, this.mPaint);
        canvas.drawPath(this.ioD, this.mPaint);
        if (this.status == d.inF) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.ioC, this.mPaint);
    }

    public void uo(int i) {
        this.ioz = ao.getColor(i, R.color.CAM_X0303);
        this.ioA = ao.getColor(i, R.color.CAM_X0302);
        this.ioB = ao.getColor(i, R.color.CAM_X0204);
        this.ioy = true;
        invalidate();
    }
}
