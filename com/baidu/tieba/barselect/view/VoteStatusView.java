package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
/* loaded from: classes15.dex */
public class VoteStatusView extends View {
    private boolean gTX;
    public int gTY;
    public int gTZ;
    public int gUa;
    private Path gUb;
    private Path gUc;
    private Path gUd;
    private Path gUe;
    private Path gUf;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.gTX = true;
        initUI();
    }

    private void initUI() {
        this.gUa = ao.getColor(R.color.cp_bg_line_c);
        this.gTY = ao.getColor(R.color.cp_link_tip_b);
        this.gTZ = ao.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.gUa);
        this.gUb = new Path();
        this.gUc = new Path();
        this.gUd = new Path();
        this.gUe = new Path();
        this.gUf = new Path();
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
        this.gUb.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.gUc.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.gUd.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.gUe.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.gUf.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.gUa);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.gTX) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.gTY, this.gTZ, Shader.TileMode.CLAMP);
            this.gTX = false;
        }
        if (this.status == d.gTj) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gUf, this.mPaint);
        canvas.drawPath(this.gUd, this.mPaint);
        if (this.status == d.gTi) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gUe, this.mPaint);
        canvas.drawPath(this.gUc, this.mPaint);
        if (this.status == d.gTh) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gUb, this.mPaint);
    }

    public void qZ(int i) {
        this.gTY = ao.getColor(i, R.color.cp_link_tip_b);
        this.gTZ = ao.getColor(i, R.color.cp_link_tip_a);
        this.gUa = ao.getColor(i, R.color.cp_bg_line_c);
        this.gTX = true;
        invalidate();
    }
}
