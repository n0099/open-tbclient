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
    private boolean hPo;
    public int hPp;
    public int hPq;
    public int hPr;
    private Path hPs;
    private Path hPt;
    private Path hPu;
    private Path hPv;
    private Path hPw;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.hPo = true;
        initUI();
    }

    private void initUI() {
        this.hPr = ap.getColor(R.color.cp_bg_line_c);
        this.hPp = ap.getColor(R.color.cp_link_tip_b);
        this.hPq = ap.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.hPr);
        this.hPs = new Path();
        this.hPt = new Path();
        this.hPu = new Path();
        this.hPv = new Path();
        this.hPw = new Path();
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
        this.hPs.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.hPt.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.hPu.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.hPv.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.hPw.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.hPr);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.hPo) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.hPp, this.hPq, Shader.TileMode.CLAMP);
            this.hPo = false;
        }
        if (this.status == d.hOx) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hPw, this.mPaint);
        canvas.drawPath(this.hPu, this.mPaint);
        if (this.status == d.hOw) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hPv, this.mPaint);
        canvas.drawPath(this.hPt, this.mPaint);
        if (this.status == d.hOv) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hPs, this.mPaint);
    }

    public void uu(int i) {
        this.hPp = ap.getColor(i, R.color.cp_link_tip_b);
        this.hPq = ap.getColor(i, R.color.cp_link_tip_a);
        this.hPr = ap.getColor(i, R.color.cp_bg_line_c);
        this.hPo = true;
        invalidate();
    }
}
