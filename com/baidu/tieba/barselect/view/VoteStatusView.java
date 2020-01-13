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
/* loaded from: classes6.dex */
public class VoteStatusView extends View {
    public int fEA;
    public int fEB;
    public int fEC;
    private Path fED;
    private Path fEE;
    private Path fEF;
    private Path fEG;
    private Path fEH;
    private boolean fEz;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.fEz = true;
        initUI();
    }

    private void initUI() {
        this.fEC = am.getColor(R.color.cp_bg_line_c);
        this.fEA = am.getColor(R.color.cp_link_tip_b);
        this.fEB = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fEC);
        this.fED = new Path();
        this.fEE = new Path();
        this.fEF = new Path();
        this.fEG = new Path();
        this.fEH = new Path();
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
        this.fED.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.fEE.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.fEF.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.fEG.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.fEH.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.fEC);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.fEz) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.fEA, this.fEB, Shader.TileMode.CLAMP);
            this.fEz = false;
        }
        if (this.status == d.fDM) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fEH, this.mPaint);
        canvas.drawPath(this.fEF, this.mPaint);
        if (this.status == d.fDL) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fEG, this.mPaint);
        canvas.drawPath(this.fEE, this.mPaint);
        if (this.status == d.fDK) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fED, this.mPaint);
    }

    public void oU(int i) {
        this.fEA = am.getColor(i, R.color.cp_link_tip_b);
        this.fEB = am.getColor(i, R.color.cp_link_tip_a);
        this.fEC = am.getColor(i, R.color.cp_bg_line_c);
        this.fEz = true;
        invalidate();
    }
}
