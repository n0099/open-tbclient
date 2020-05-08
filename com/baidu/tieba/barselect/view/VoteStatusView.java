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
    private boolean gmF;
    public int gmG;
    public int gmH;
    public int gmI;
    private Path gmJ;
    private Path gmK;
    private Path gmL;
    private Path gmM;
    private Path gmN;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.gmF = true;
        initUI();
    }

    private void initUI() {
        this.gmI = am.getColor(R.color.cp_bg_line_c);
        this.gmG = am.getColor(R.color.cp_link_tip_b);
        this.gmH = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.gmI);
        this.gmJ = new Path();
        this.gmK = new Path();
        this.gmL = new Path();
        this.gmM = new Path();
        this.gmN = new Path();
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
        this.gmJ.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.gmK.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.gmL.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.gmM.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.gmN.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.gmI);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.gmF) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.gmG, this.gmH, Shader.TileMode.CLAMP);
            this.gmF = false;
        }
        if (this.status == d.glR) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gmN, this.mPaint);
        canvas.drawPath(this.gmL, this.mPaint);
        if (this.status == d.glQ) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gmM, this.mPaint);
        canvas.drawPath(this.gmK, this.mPaint);
        if (this.status == d.glP) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gmJ, this.mPaint);
    }

    public void pH(int i) {
        this.gmG = am.getColor(i, R.color.cp_link_tip_b);
        this.gmH = am.getColor(i, R.color.cp_link_tip_a);
        this.gmI = am.getColor(i, R.color.cp_bg_line_c);
        this.gmF = true;
        invalidate();
    }
}
