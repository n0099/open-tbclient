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
/* loaded from: classes8.dex */
public class VoteStatusView extends View {
    private boolean itf;
    public int itg;
    public int ith;
    public int iti;
    private Path itj;
    private Path itk;
    private Path itl;
    private Path itm;
    private Path itn;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.itf = true;
        initUI();
    }

    private void initUI() {
        this.iti = ao.getColor(R.color.CAM_X0204);
        this.itg = ao.getColor(R.color.CAM_X0303);
        this.ith = ao.getColor(R.color.CAM_X0302);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.iti);
        this.itj = new Path();
        this.itk = new Path();
        this.itl = new Path();
        this.itm = new Path();
        this.itn = new Path();
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
        this.itj.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.itk.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.itl.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.itm.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.itn.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.iti);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.itf) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.itg, this.ith, Shader.TileMode.CLAMP);
            this.itf = false;
        }
        if (this.status == d.iso) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.itn, this.mPaint);
        canvas.drawPath(this.itl, this.mPaint);
        if (this.status == d.isn) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.itm, this.mPaint);
        canvas.drawPath(this.itk, this.mPaint);
        if (this.status == d.ism) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.itj, this.mPaint);
    }

    public void vU(int i) {
        this.itg = ao.getColor(i, R.color.CAM_X0303);
        this.ith = ao.getColor(i, R.color.CAM_X0302);
        this.iti = ao.getColor(i, R.color.CAM_X0204);
        this.itf = true;
        invalidate();
    }
}
