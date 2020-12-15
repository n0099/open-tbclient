package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
/* loaded from: classes21.dex */
public class VoteStatusView extends View {
    private Shader cHt;
    private boolean igK;
    public int igL;
    public int igM;
    public int igN;
    private Path igO;
    private Path igP;
    private Path igQ;
    private Path igR;
    private Path igS;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.igK = true;
        initUI();
    }

    private void initUI() {
        this.igN = ap.getColor(R.color.CAM_X0204);
        this.igL = ap.getColor(R.color.CAM_X0303);
        this.igM = ap.getColor(R.color.CAM_X0302);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.igN);
        this.igO = new Path();
        this.igP = new Path();
        this.igQ = new Path();
        this.igR = new Path();
        this.igS = new Path();
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
        this.igO.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.igP.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.igQ.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.igR.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.igS.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.igN);
        this.mPaint.setShader(null);
        if (this.cHt == null || this.igK) {
            this.cHt = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.igL, this.igM, Shader.TileMode.CLAMP);
            this.igK = false;
        }
        if (this.status == d.ifT) {
            this.mPaint.setShader(this.cHt);
        }
        canvas.drawPath(this.igS, this.mPaint);
        canvas.drawPath(this.igQ, this.mPaint);
        if (this.status == d.ifS) {
            this.mPaint.setShader(this.cHt);
        }
        canvas.drawPath(this.igR, this.mPaint);
        canvas.drawPath(this.igP, this.mPaint);
        if (this.status == d.ifR) {
            this.mPaint.setShader(this.cHt);
        }
        canvas.drawPath(this.igO, this.mPaint);
    }

    public void vJ(int i) {
        this.igL = ap.getColor(i, R.color.CAM_X0303);
        this.igM = ap.getColor(i, R.color.CAM_X0302);
        this.igN = ap.getColor(i, R.color.CAM_X0204);
        this.igK = true;
        invalidate();
    }
}
