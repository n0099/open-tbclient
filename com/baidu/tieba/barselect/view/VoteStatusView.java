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
/* loaded from: classes20.dex */
public class VoteStatusView extends View {
    private boolean hVL;
    public int hVM;
    public int hVN;
    public int hVO;
    private Path hVP;
    private Path hVQ;
    private Path hVR;
    private Path hVS;
    private Path hVT;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.hVL = true;
        initUI();
    }

    private void initUI() {
        this.hVO = ap.getColor(R.color.CAM_X0204);
        this.hVM = ap.getColor(R.color.CAM_X0303);
        this.hVN = ap.getColor(R.color.CAM_X0302);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.hVO);
        this.hVP = new Path();
        this.hVQ = new Path();
        this.hVR = new Path();
        this.hVS = new Path();
        this.hVT = new Path();
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
        this.hVP.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.hVQ.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.hVR.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.hVS.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.hVT.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.hVO);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.hVL) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.hVM, this.hVN, Shader.TileMode.CLAMP);
            this.hVL = false;
        }
        if (this.status == d.hUU) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hVT, this.mPaint);
        canvas.drawPath(this.hVR, this.mPaint);
        if (this.status == d.hUT) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hVS, this.mPaint);
        canvas.drawPath(this.hVQ, this.mPaint);
        if (this.status == d.hUS) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hVP, this.mPaint);
    }

    public void vc(int i) {
        this.hVM = ap.getColor(i, R.color.CAM_X0303);
        this.hVN = ap.getColor(i, R.color.CAM_X0302);
        this.hVO = ap.getColor(i, R.color.CAM_X0204);
        this.hVL = true;
        invalidate();
    }
}
