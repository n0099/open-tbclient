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
    private boolean ezR;
    public int ezS;
    public int ezT;
    public int ezU;
    private Path ezV;
    private Path ezW;
    private Path ezX;
    private Path ezY;
    private Path ezZ;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.ezR = true;
        initUI();
    }

    private void initUI() {
        this.ezU = am.getColor(R.color.cp_bg_line_b);
        this.ezS = am.getColor(R.color.cp_link_tip_b);
        this.ezT = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.ezU);
        this.ezV = new Path();
        this.ezW = new Path();
        this.ezX = new Path();
        this.ezY = new Path();
        this.ezZ = new Path();
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
        this.ezV.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.ezW.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.ezX.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.ezY.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.ezZ.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.ezU);
        this.mPaint.setShader(null);
        if (this.ams == null || this.ezR) {
            this.ams = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.ezS, this.ezT, Shader.TileMode.CLAMP);
            this.ezR = false;
        }
        if (this.status == d.eze) {
            this.mPaint.setShader(this.ams);
        }
        canvas.drawPath(this.ezZ, this.mPaint);
        canvas.drawPath(this.ezX, this.mPaint);
        if (this.status == d.ezd) {
            this.mPaint.setShader(this.ams);
        }
        canvas.drawPath(this.ezY, this.mPaint);
        canvas.drawPath(this.ezW, this.mPaint);
        if (this.status == d.ezc) {
            this.mPaint.setShader(this.ams);
        }
        canvas.drawPath(this.ezV, this.mPaint);
    }

    public void nA(int i) {
        this.ezS = am.getColor(i, R.color.cp_link_tip_b);
        this.ezT = am.getColor(i, R.color.cp_link_tip_a);
        this.ezU = am.getColor(i, R.color.cp_bg_line_b);
        this.ezR = true;
        invalidate();
    }
}
