package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
/* loaded from: classes5.dex */
public class VoteStatusView extends View {
    private Shader bbC;
    private boolean fBo;
    public int fBp;
    public int fBq;
    public int fBr;
    private Path fBs;
    private Path fBt;
    private Path fBu;
    private Path fBv;
    private Path fBw;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.fBo = true;
        initUI();
    }

    private void initUI() {
        this.fBr = am.getColor(R.color.cp_bg_line_c);
        this.fBp = am.getColor(R.color.cp_link_tip_b);
        this.fBq = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fBr);
        this.fBs = new Path();
        this.fBt = new Path();
        this.fBu = new Path();
        this.fBv = new Path();
        this.fBw = new Path();
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
        this.fBs.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.fBt.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.fBu.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.fBv.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.fBw.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.fBr);
        this.mPaint.setShader(null);
        if (this.bbC == null || this.fBo) {
            this.bbC = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.fBp, this.fBq, Shader.TileMode.CLAMP);
            this.fBo = false;
        }
        if (this.status == d.fAB) {
            this.mPaint.setShader(this.bbC);
        }
        canvas.drawPath(this.fBw, this.mPaint);
        canvas.drawPath(this.fBu, this.mPaint);
        if (this.status == d.fAA) {
            this.mPaint.setShader(this.bbC);
        }
        canvas.drawPath(this.fBv, this.mPaint);
        canvas.drawPath(this.fBt, this.mPaint);
        if (this.status == d.fAz) {
            this.mPaint.setShader(this.bbC);
        }
        canvas.drawPath(this.fBs, this.mPaint);
    }

    public void oT(int i) {
        this.fBp = am.getColor(i, R.color.cp_link_tip_b);
        this.fBq = am.getColor(i, R.color.cp_link_tip_a);
        this.fBr = am.getColor(i, R.color.cp_bg_line_c);
        this.fBo = true;
        invalidate();
    }
}
