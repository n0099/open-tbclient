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
    private boolean fGY;
    public int fGZ;
    public int fHa;
    public int fHb;
    private Path fHc;
    private Path fHd;
    private Path fHe;
    private Path fHf;
    private Path fHg;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.fGY = true;
        initUI();
    }

    private void initUI() {
        this.fHb = am.getColor(R.color.cp_bg_line_c);
        this.fGZ = am.getColor(R.color.cp_link_tip_b);
        this.fHa = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fHb);
        this.fHc = new Path();
        this.fHd = new Path();
        this.fHe = new Path();
        this.fHf = new Path();
        this.fHg = new Path();
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
        this.fHc.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.fHd.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.fHe.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.fHf.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.fHg.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.fHb);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.fGY) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.fGZ, this.fHa, Shader.TileMode.CLAMP);
            this.fGY = false;
        }
        if (this.status == d.fGl) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHg, this.mPaint);
        canvas.drawPath(this.fHe, this.mPaint);
        if (this.status == d.fGk) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHf, this.mPaint);
        canvas.drawPath(this.fHd, this.mPaint);
        if (this.status == d.fGj) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHc, this.mPaint);
    }

    public void pk(int i) {
        this.fGZ = am.getColor(i, R.color.cp_link_tip_b);
        this.fHa = am.getColor(i, R.color.cp_link_tip_a);
        this.fHb = am.getColor(i, R.color.cp_bg_line_c);
        this.fGY = true;
        invalidate();
    }
}
