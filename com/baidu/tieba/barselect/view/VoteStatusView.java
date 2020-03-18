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
    private boolean fHT;
    public int fHU;
    public int fHV;
    public int fHW;
    private Path fHX;
    private Path fHY;
    private Path fHZ;
    private Path fIa;
    private Path fIb;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.fHT = true;
        initUI();
    }

    private void initUI() {
        this.fHW = am.getColor(R.color.cp_bg_line_c);
        this.fHU = am.getColor(R.color.cp_link_tip_b);
        this.fHV = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.fHW);
        this.fHX = new Path();
        this.fHY = new Path();
        this.fHZ = new Path();
        this.fIa = new Path();
        this.fIb = new Path();
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
        this.fHX.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.fHY.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.fHZ.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.fIa.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.fIb.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.fHW);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.fHT) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.fHU, this.fHV, Shader.TileMode.CLAMP);
            this.fHT = false;
        }
        if (this.status == d.fHg) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fIb, this.mPaint);
        canvas.drawPath(this.fHZ, this.mPaint);
        if (this.status == d.fHf) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fIa, this.mPaint);
        canvas.drawPath(this.fHY, this.mPaint);
        if (this.status == d.fHe) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.fHX, this.mPaint);
    }

    public void pm(int i) {
        this.fHU = am.getColor(i, R.color.cp_link_tip_b);
        this.fHV = am.getColor(i, R.color.cp_link_tip_a);
        this.fHW = am.getColor(i, R.color.cp_bg_line_c);
        this.fHT = true;
        invalidate();
    }
}
