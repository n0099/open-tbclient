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
    private boolean euK;
    public int euL;
    public int euM;
    public int euN;
    private Path euO;
    private Path euP;
    private Path euQ;
    private Path euR;
    private Path euS;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.euK = true;
        initUI();
    }

    private void initUI() {
        this.euN = al.getColor(R.color.cp_bg_line_b);
        this.euL = al.getColor(R.color.cp_link_tip_b);
        this.euM = al.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.euN);
        this.euO = new Path();
        this.euP = new Path();
        this.euQ = new Path();
        this.euR = new Path();
        this.euS = new Path();
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
        this.euO.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.euP.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.euQ.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.euR.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.euS.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.euN);
        this.mPaint.setShader(null);
        if (this.alP == null || this.euK) {
            this.alP = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.euL, this.euM, Shader.TileMode.CLAMP);
            this.euK = false;
        }
        if (this.status == d.etX) {
            this.mPaint.setShader(this.alP);
        }
        canvas.drawPath(this.euS, this.mPaint);
        canvas.drawPath(this.euQ, this.mPaint);
        if (this.status == d.etW) {
            this.mPaint.setShader(this.alP);
        }
        canvas.drawPath(this.euR, this.mPaint);
        canvas.drawPath(this.euP, this.mPaint);
        if (this.status == d.etV) {
            this.mPaint.setShader(this.alP);
        }
        canvas.drawPath(this.euO, this.mPaint);
    }

    public void nq(int i) {
        this.euL = al.getColor(i, R.color.cp_link_tip_b);
        this.euM = al.getColor(i, R.color.cp_link_tip_a);
        this.euN = al.getColor(i, R.color.cp_bg_line_b);
        this.euK = true;
        invalidate();
    }
}
