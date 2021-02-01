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
/* loaded from: classes8.dex */
public class VoteStatusView extends View {
    private boolean iuc;
    public int iud;
    public int iue;
    public int iuf;
    private Path iug;
    private Path iuh;
    private Path iui;
    private Path iuj;
    private Path iuk;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.iuc = true;
        initUI();
    }

    private void initUI() {
        this.iuf = ap.getColor(R.color.CAM_X0204);
        this.iud = ap.getColor(R.color.CAM_X0303);
        this.iue = ap.getColor(R.color.CAM_X0302);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.iuf);
        this.iug = new Path();
        this.iuh = new Path();
        this.iui = new Path();
        this.iuj = new Path();
        this.iuk = new Path();
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
        this.iug.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.iuh.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.iui.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.iuj.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.iuk.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.iuf);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.iuc) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.iud, this.iue, Shader.TileMode.CLAMP);
            this.iuc = false;
        }
        if (this.status == d.itl) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iuk, this.mPaint);
        canvas.drawPath(this.iui, this.mPaint);
        if (this.status == d.itk) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iuj, this.mPaint);
        canvas.drawPath(this.iuh, this.mPaint);
        if (this.status == d.itj) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iug, this.mPaint);
    }

    public void uu(int i) {
        this.iud = ap.getColor(i, R.color.CAM_X0303);
        this.iue = ap.getColor(i, R.color.CAM_X0302);
        this.iuf = ap.getColor(i, R.color.CAM_X0204);
        this.iuc = true;
        invalidate();
    }
}
