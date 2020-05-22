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
    private Path gBA;
    private Path gBB;
    private Path gBC;
    private Path gBD;
    private boolean gBv;
    public int gBw;
    public int gBx;
    public int gBy;
    private Path gBz;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.gBv = true;
        initUI();
    }

    private void initUI() {
        this.gBy = am.getColor(R.color.cp_bg_line_c);
        this.gBw = am.getColor(R.color.cp_link_tip_b);
        this.gBx = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.gBy);
        this.gBz = new Path();
        this.gBA = new Path();
        this.gBB = new Path();
        this.gBC = new Path();
        this.gBD = new Path();
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
        this.gBz.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.gBA.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.gBB.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.gBC.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.gBD.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.gBy);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.gBv) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.gBw, this.gBx, Shader.TileMode.CLAMP);
            this.gBv = false;
        }
        if (this.status == d.gAH) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gBD, this.mPaint);
        canvas.drawPath(this.gBB, this.mPaint);
        if (this.status == d.gAG) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gBC, this.mPaint);
        canvas.drawPath(this.gBA, this.mPaint);
        if (this.status == d.gAF) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gBz, this.mPaint);
    }

    public void qi(int i) {
        this.gBw = am.getColor(i, R.color.cp_link_tip_b);
        this.gBx = am.getColor(i, R.color.cp_link_tip_a);
        this.gBy = am.getColor(i, R.color.cp_bg_line_c);
        this.gBv = true;
        invalidate();
    }
}
