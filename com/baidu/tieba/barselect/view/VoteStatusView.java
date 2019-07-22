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
    private Shader ams;
    private boolean ezK;
    public int ezL;
    public int ezM;
    public int ezN;
    private Path ezO;
    private Path ezP;
    private Path ezQ;
    private Path ezR;
    private Path ezS;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.ezK = true;
        initUI();
    }

    private void initUI() {
        this.ezN = am.getColor(R.color.cp_bg_line_b);
        this.ezL = am.getColor(R.color.cp_link_tip_b);
        this.ezM = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.ezN);
        this.ezO = new Path();
        this.ezP = new Path();
        this.ezQ = new Path();
        this.ezR = new Path();
        this.ezS = new Path();
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
        this.ezO.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.ezP.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.ezQ.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.ezR.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.ezS.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.ezN);
        this.mPaint.setShader(null);
        if (this.ams == null || this.ezK) {
            this.ams = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.ezL, this.ezM, Shader.TileMode.CLAMP);
            this.ezK = false;
        }
        if (this.status == d.eyX) {
            this.mPaint.setShader(this.ams);
        }
        canvas.drawPath(this.ezS, this.mPaint);
        canvas.drawPath(this.ezQ, this.mPaint);
        if (this.status == d.eyW) {
            this.mPaint.setShader(this.ams);
        }
        canvas.drawPath(this.ezR, this.mPaint);
        canvas.drawPath(this.ezP, this.mPaint);
        if (this.status == d.eyV) {
            this.mPaint.setShader(this.ams);
        }
        canvas.drawPath(this.ezO, this.mPaint);
    }

    public void nz(int i) {
        this.ezL = am.getColor(i, R.color.cp_link_tip_b);
        this.ezM = am.getColor(i, R.color.cp_link_tip_a);
        this.ezN = am.getColor(i, R.color.cp_bg_line_b);
        this.ezK = true;
        invalidate();
    }
}
