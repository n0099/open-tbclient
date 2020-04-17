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
    public int gmA;
    public int gmB;
    public int gmC;
    private Path gmD;
    private Path gmE;
    private Path gmF;
    private Path gmG;
    private Path gmH;
    private boolean gmz;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.gmz = true;
        initUI();
    }

    private void initUI() {
        this.gmC = am.getColor(R.color.cp_bg_line_c);
        this.gmA = am.getColor(R.color.cp_link_tip_b);
        this.gmB = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.gmC);
        this.gmD = new Path();
        this.gmE = new Path();
        this.gmF = new Path();
        this.gmG = new Path();
        this.gmH = new Path();
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
        this.gmD.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.gmE.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.gmF.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.gmG.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.gmH.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.gmC);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.gmz) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.gmA, this.gmB, Shader.TileMode.CLAMP);
            this.gmz = false;
        }
        if (this.status == d.glL) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gmH, this.mPaint);
        canvas.drawPath(this.gmF, this.mPaint);
        if (this.status == d.glK) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gmG, this.mPaint);
        canvas.drawPath(this.gmE, this.mPaint);
        if (this.status == d.glJ) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gmD, this.mPaint);
    }

    public void pH(int i) {
        this.gmA = am.getColor(i, R.color.cp_link_tip_b);
        this.gmB = am.getColor(i, R.color.cp_link_tip_a);
        this.gmC = am.getColor(i, R.color.cp_bg_line_c);
        this.gmz = true;
        invalidate();
    }
}
