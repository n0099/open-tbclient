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
/* loaded from: classes3.dex */
public class VoteStatusView extends View {
    private Shader amQ;
    private boolean eBA;
    public int eBB;
    public int eBC;
    public int eBD;
    private Path eBE;
    private Path eBF;
    private Path eBG;
    private Path eBH;
    private Path eBI;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.eBA = true;
        initUI();
    }

    private void initUI() {
        this.eBD = am.getColor(R.color.cp_bg_line_c);
        this.eBB = am.getColor(R.color.cp_link_tip_b);
        this.eBC = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.eBD);
        this.eBE = new Path();
        this.eBF = new Path();
        this.eBG = new Path();
        this.eBH = new Path();
        this.eBI = new Path();
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
        this.eBE.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.eBF.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.eBG.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.eBH.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.eBI.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.eBD);
        this.mPaint.setShader(null);
        if (this.amQ == null || this.eBA) {
            this.amQ = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.eBB, this.eBC, Shader.TileMode.CLAMP);
            this.eBA = false;
        }
        if (this.status == d.eAN) {
            this.mPaint.setShader(this.amQ);
        }
        canvas.drawPath(this.eBI, this.mPaint);
        canvas.drawPath(this.eBG, this.mPaint);
        if (this.status == d.eAM) {
            this.mPaint.setShader(this.amQ);
        }
        canvas.drawPath(this.eBH, this.mPaint);
        canvas.drawPath(this.eBF, this.mPaint);
        if (this.status == d.eAL) {
            this.mPaint.setShader(this.amQ);
        }
        canvas.drawPath(this.eBE, this.mPaint);
    }

    public void nE(int i) {
        this.eBB = am.getColor(i, R.color.cp_link_tip_b);
        this.eBC = am.getColor(i, R.color.cp_link_tip_a);
        this.eBD = am.getColor(i, R.color.cp_bg_line_c);
        this.eBA = true;
        invalidate();
    }
}
