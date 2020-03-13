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
/* loaded from: classes8.dex */
public class VoteStatusView extends View {
    private boolean fHl;
    public int fHm;
    public int fHn;
    public int fHo;
    private Path fHp;
    private Path fHq;
    private Path fHr;
    private Path fHs;
    private Path fHt;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.fHl = true;
        initUI();
    }

    private void initUI() {
        this.fHo = am.getColor(R.color.cp_bg_line_c);
        this.fHm = am.getColor(R.color.cp_link_tip_b);
        this.fHn = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fHo);
        this.fHp = new Path();
        this.fHq = new Path();
        this.fHr = new Path();
        this.fHs = new Path();
        this.fHt = new Path();
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
        this.fHp.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.fHq.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.fHr.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.fHs.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.fHt.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.fHo);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.fHl) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.fHm, this.fHn, Shader.TileMode.CLAMP);
            this.fHl = false;
        }
        if (this.status == d.fGy) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHt, this.mPaint);
        canvas.drawPath(this.fHr, this.mPaint);
        if (this.status == d.fGx) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHs, this.mPaint);
        canvas.drawPath(this.fHq, this.mPaint);
        if (this.status == d.fGw) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHp, this.mPaint);
    }

    public void pk(int i) {
        this.fHm = am.getColor(i, R.color.cp_link_tip_b);
        this.fHn = am.getColor(i, R.color.cp_link_tip_a);
        this.fHo = am.getColor(i, R.color.cp_bg_line_c);
        this.fHl = true;
        invalidate();
    }
}
