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
    private boolean igI;
    public int igJ;
    public int igK;
    public int igL;
    private Path igM;
    private Path igN;
    private Path igO;
    private Path igP;
    private Path igQ;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.igI = true;
        initUI();
    }

    private void initUI() {
        this.igL = ap.getColor(R.color.CAM_X0204);
        this.igJ = ap.getColor(R.color.CAM_X0303);
        this.igK = ap.getColor(R.color.CAM_X0302);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.igL);
        this.igM = new Path();
        this.igN = new Path();
        this.igO = new Path();
        this.igP = new Path();
        this.igQ = new Path();
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
        this.igM.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.igN.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.igO.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.igP.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.igQ.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.igL);
        this.mPaint.setShader(null);
        if (this.cHt == null || this.igI) {
            this.cHt = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.igJ, this.igK, Shader.TileMode.CLAMP);
            this.igI = false;
        }
        if (this.status == d.ifR) {
            this.mPaint.setShader(this.cHt);
        }
        canvas.drawPath(this.igQ, this.mPaint);
        canvas.drawPath(this.igO, this.mPaint);
        if (this.status == d.ifQ) {
            this.mPaint.setShader(this.cHt);
        }
        canvas.drawPath(this.igP, this.mPaint);
        canvas.drawPath(this.igN, this.mPaint);
        if (this.status == d.ifP) {
            this.mPaint.setShader(this.cHt);
        }
        canvas.drawPath(this.igM, this.mPaint);
    }

    public void vJ(int i) {
        this.igJ = ap.getColor(i, R.color.CAM_X0303);
        this.igK = ap.getColor(i, R.color.CAM_X0302);
        this.igL = ap.getColor(i, R.color.CAM_X0204);
        this.igI = true;
        invalidate();
    }
}
