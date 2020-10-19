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
    private boolean hCS;
    public int hCT;
    public int hCU;
    public int hCV;
    private Path hCW;
    private Path hCX;
    private Path hCY;
    private Path hCZ;
    private Path hDa;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.hCS = true;
        initUI();
    }

    private void initUI() {
        this.hCV = ap.getColor(R.color.cp_bg_line_c);
        this.hCT = ap.getColor(R.color.cp_link_tip_b);
        this.hCU = ap.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.hCV);
        this.hCW = new Path();
        this.hCX = new Path();
        this.hCY = new Path();
        this.hCZ = new Path();
        this.hDa = new Path();
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
        this.hCW.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.hCX.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.hCY.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.hCZ.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.hDa.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.hCV);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.hCS) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.hCT, this.hCU, Shader.TileMode.CLAMP);
            this.hCS = false;
        }
        if (this.status == d.hCb) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hDa, this.mPaint);
        canvas.drawPath(this.hCY, this.mPaint);
        if (this.status == d.hCa) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hCZ, this.mPaint);
        canvas.drawPath(this.hCX, this.mPaint);
        if (this.status == d.hBZ) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hCW, this.mPaint);
    }

    public void uc(int i) {
        this.hCT = ap.getColor(i, R.color.cp_link_tip_b);
        this.hCU = ap.getColor(i, R.color.cp_link_tip_a);
        this.hCV = ap.getColor(i, R.color.cp_bg_line_c);
        this.hCS = true;
        invalidate();
    }
}
