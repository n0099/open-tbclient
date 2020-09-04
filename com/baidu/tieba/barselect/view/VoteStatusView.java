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
    private boolean hgU;
    public int hgV;
    public int hgW;
    public int hgX;
    private Path hgY;
    private Path hgZ;
    private Path hha;
    private Path hhb;
    private Path hhc;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.hgU = true;
        initUI();
    }

    private void initUI() {
        this.hgX = ap.getColor(R.color.cp_bg_line_c);
        this.hgV = ap.getColor(R.color.cp_link_tip_b);
        this.hgW = ap.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.hgX);
        this.hgY = new Path();
        this.hgZ = new Path();
        this.hha = new Path();
        this.hhb = new Path();
        this.hhc = new Path();
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
        this.hgY.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.hgZ.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.hha.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.hhb.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.hhc.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.hgX);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.hgU) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.hgV, this.hgW, Shader.TileMode.CLAMP);
            this.hgU = false;
        }
        if (this.status == d.hgg) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hhc, this.mPaint);
        canvas.drawPath(this.hha, this.mPaint);
        if (this.status == d.hgf) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hhb, this.mPaint);
        canvas.drawPath(this.hgZ, this.mPaint);
        if (this.status == d.hge) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hgY, this.mPaint);
    }

    public void tl(int i) {
        this.hgV = ap.getColor(i, R.color.cp_link_tip_b);
        this.hgW = ap.getColor(i, R.color.cp_link_tip_a);
        this.hgX = ap.getColor(i, R.color.cp_bg_line_c);
        this.hgU = true;
        invalidate();
    }
}
