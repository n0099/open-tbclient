package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.a.d;
/* loaded from: classes8.dex */
public class VoteStatusView extends View {
    private boolean gOr;
    public int gOs;
    public int gOt;
    public int gOu;
    private Path gOv;
    private Path gOw;
    private Path gOx;
    private Path gOy;
    private Path gOz;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.gOr = true;
        initUI();
    }

    private void initUI() {
        this.gOu = an.getColor(R.color.cp_bg_line_c);
        this.gOs = an.getColor(R.color.cp_link_tip_b);
        this.gOt = an.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.gOu);
        this.gOv = new Path();
        this.gOw = new Path();
        this.gOx = new Path();
        this.gOy = new Path();
        this.gOz = new Path();
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
        this.gOv.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.gOw.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.gOx.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.gOy.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.gOz.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.gOu);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.gOr) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.gOs, this.gOt, Shader.TileMode.CLAMP);
            this.gOr = false;
        }
        if (this.status == d.gND) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gOz, this.mPaint);
        canvas.drawPath(this.gOx, this.mPaint);
        if (this.status == d.gNC) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gOy, this.mPaint);
        canvas.drawPath(this.gOw, this.mPaint);
        if (this.status == d.gNB) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.gOv, this.mPaint);
    }

    public void qJ(int i) {
        this.gOs = an.getColor(i, R.color.cp_link_tip_b);
        this.gOt = an.getColor(i, R.color.cp_link_tip_a);
        this.gOu = an.getColor(i, R.color.cp_bg_line_c);
        this.gOr = true;
        invalidate();
    }
}
