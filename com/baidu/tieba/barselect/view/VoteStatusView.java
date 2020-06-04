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
    private boolean gBG;
    public int gBH;
    public int gBI;
    public int gBJ;
    private Path gBK;
    private Path gBL;
    private Path gBM;
    private Path gBN;
    private Path gBO;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.gBG = true;
        initUI();
    }

    private void initUI() {
        this.gBJ = am.getColor(R.color.cp_bg_line_c);
        this.gBH = am.getColor(R.color.cp_link_tip_b);
        this.gBI = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.gBJ);
        this.gBK = new Path();
        this.gBL = new Path();
        this.gBM = new Path();
        this.gBN = new Path();
        this.gBO = new Path();
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
        this.gBK.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.gBL.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.gBM.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.gBN.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.gBO.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.gBJ);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.gBG) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.gBH, this.gBI, Shader.TileMode.CLAMP);
            this.gBG = false;
        }
        if (this.status == d.gAS) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gBO, this.mPaint);
        canvas.drawPath(this.gBM, this.mPaint);
        if (this.status == d.gAR) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gBN, this.mPaint);
        canvas.drawPath(this.gBL, this.mPaint);
        if (this.status == d.gAQ) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gBK, this.mPaint);
    }

    public void qk(int i) {
        this.gBH = am.getColor(i, R.color.cp_link_tip_b);
        this.gBI = am.getColor(i, R.color.cp_link_tip_a);
        this.gBJ = am.getColor(i, R.color.cp_bg_line_c);
        this.gBG = true;
        invalidate();
    }
}
