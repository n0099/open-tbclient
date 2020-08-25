package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
/* loaded from: classes15.dex */
public class VoteStatusView extends View {
    private boolean hgQ;
    public int hgR;
    public int hgS;
    public int hgT;
    private Path hgU;
    private Path hgV;
    private Path hgW;
    private Path hgX;
    private Path hgY;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.hgQ = true;
        initUI();
    }

    private void initUI() {
        this.hgT = ap.getColor(R.color.cp_bg_line_c);
        this.hgR = ap.getColor(R.color.cp_link_tip_b);
        this.hgS = ap.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.hgT);
        this.hgU = new Path();
        this.hgV = new Path();
        this.hgW = new Path();
        this.hgX = new Path();
        this.hgY = new Path();
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
        this.hgU.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.hgV.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.hgW.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.hgX.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.hgY.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.hgT);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.hgQ) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.hgR, this.hgS, Shader.TileMode.CLAMP);
            this.hgQ = false;
        }
        if (this.status == d.hgc) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hgY, this.mPaint);
        canvas.drawPath(this.hgW, this.mPaint);
        if (this.status == d.hgb) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hgX, this.mPaint);
        canvas.drawPath(this.hgV, this.mPaint);
        if (this.status == d.hga) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hgU, this.mPaint);
    }

    public void tl(int i) {
        this.hgR = ap.getColor(i, R.color.cp_link_tip_b);
        this.hgS = ap.getColor(i, R.color.cp_link_tip_a);
        this.hgT = ap.getColor(i, R.color.cp_bg_line_c);
        this.hgQ = true;
        invalidate();
    }
}
