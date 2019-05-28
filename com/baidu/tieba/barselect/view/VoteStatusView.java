package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
/* loaded from: classes3.dex */
public class VoteStatusView extends View {
    private Shader alP;
    private boolean euL;
    public int euM;
    public int euN;
    public int euO;
    private Path euP;
    private Path euQ;
    private Path euR;
    private Path euS;
    private Path euT;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.euL = true;
        initUI();
    }

    private void initUI() {
        this.euO = al.getColor(R.color.cp_bg_line_b);
        this.euM = al.getColor(R.color.cp_link_tip_b);
        this.euN = al.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.euO);
        this.euP = new Path();
        this.euQ = new Path();
        this.euR = new Path();
        this.euS = new Path();
        this.euT = new Path();
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
        this.euP.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.euQ.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.euR.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.euS.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.euT.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.euO);
        this.mPaint.setShader(null);
        if (this.alP == null || this.euL) {
            this.alP = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.euM, this.euN, Shader.TileMode.CLAMP);
            this.euL = false;
        }
        if (this.status == d.etY) {
            this.mPaint.setShader(this.alP);
        }
        canvas.drawPath(this.euT, this.mPaint);
        canvas.drawPath(this.euR, this.mPaint);
        if (this.status == d.etX) {
            this.mPaint.setShader(this.alP);
        }
        canvas.drawPath(this.euS, this.mPaint);
        canvas.drawPath(this.euQ, this.mPaint);
        if (this.status == d.etW) {
            this.mPaint.setShader(this.alP);
        }
        canvas.drawPath(this.euP, this.mPaint);
    }

    public void nq(int i) {
        this.euM = al.getColor(i, R.color.cp_link_tip_b);
        this.euN = al.getColor(i, R.color.cp_link_tip_a);
        this.euO = al.getColor(i, R.color.cp_bg_line_b);
        this.euL = true;
        invalidate();
    }
}
