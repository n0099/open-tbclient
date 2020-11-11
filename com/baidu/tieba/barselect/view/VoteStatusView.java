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
    private boolean hVl;
    public int hVm;
    public int hVn;
    public int hVo;
    private Path hVp;
    private Path hVq;
    private Path hVr;
    private Path hVs;
    private Path hVt;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.hVl = true;
        initUI();
    }

    private void initUI() {
        this.hVo = ap.getColor(R.color.cp_bg_line_c);
        this.hVm = ap.getColor(R.color.cp_link_tip_b);
        this.hVn = ap.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.hVo);
        this.hVp = new Path();
        this.hVq = new Path();
        this.hVr = new Path();
        this.hVs = new Path();
        this.hVt = new Path();
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
        this.hVp.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.hVq.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.hVr.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.hVs.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.hVt.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.hVo);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.hVl) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.hVm, this.hVn, Shader.TileMode.CLAMP);
            this.hVl = false;
        }
        if (this.status == d.hUu) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hVt, this.mPaint);
        canvas.drawPath(this.hVr, this.mPaint);
        if (this.status == d.hUt) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hVs, this.mPaint);
        canvas.drawPath(this.hVq, this.mPaint);
        if (this.status == d.hUs) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hVp, this.mPaint);
    }

    public void uE(int i) {
        this.hVm = ap.getColor(i, R.color.cp_link_tip_b);
        this.hVn = ap.getColor(i, R.color.cp_link_tip_a);
        this.hVo = ap.getColor(i, R.color.cp_bg_line_c);
        this.hVl = true;
        invalidate();
    }
}
