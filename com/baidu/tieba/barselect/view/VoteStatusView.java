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
    private boolean fGW;
    public int fGX;
    public int fGY;
    public int fGZ;
    private Path fHa;
    private Path fHb;
    private Path fHc;
    private Path fHd;
    private Path fHe;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.fGW = true;
        initUI();
    }

    private void initUI() {
        this.fGZ = am.getColor(R.color.cp_bg_line_c);
        this.fGX = am.getColor(R.color.cp_link_tip_b);
        this.fGY = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fGZ);
        this.fHa = new Path();
        this.fHb = new Path();
        this.fHc = new Path();
        this.fHd = new Path();
        this.fHe = new Path();
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
        this.fHa.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.fHb.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.fHc.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.fHd.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.fHe.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.fGZ);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.fGW) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.fGX, this.fGY, Shader.TileMode.CLAMP);
            this.fGW = false;
        }
        if (this.status == d.fGj) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHe, this.mPaint);
        canvas.drawPath(this.fHc, this.mPaint);
        if (this.status == d.fGi) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHd, this.mPaint);
        canvas.drawPath(this.fHb, this.mPaint);
        if (this.status == d.fGh) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHa, this.mPaint);
    }

    public void pk(int i) {
        this.fGX = am.getColor(i, R.color.cp_link_tip_b);
        this.fGY = am.getColor(i, R.color.cp_link_tip_a);
        this.fGZ = am.getColor(i, R.color.cp_bg_line_c);
        this.fGW = true;
        invalidate();
    }
}
