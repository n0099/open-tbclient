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
    private boolean iuq;
    public int iur;
    public int ius;
    public int iut;
    private Path iuu;
    private Path iuv;
    private Path iuw;
    private Path iux;
    private Path iuy;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.iuq = true;
        initUI();
    }

    private void initUI() {
        this.iut = ap.getColor(R.color.CAM_X0204);
        this.iur = ap.getColor(R.color.CAM_X0303);
        this.ius = ap.getColor(R.color.CAM_X0302);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.iut);
        this.iuu = new Path();
        this.iuv = new Path();
        this.iuw = new Path();
        this.iux = new Path();
        this.iuy = new Path();
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
        this.iuu.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.iuv.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.iuw.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.iux.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.iuy.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.iut);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.iuq) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.iur, this.ius, Shader.TileMode.CLAMP);
            this.iuq = false;
        }
        if (this.status == d.itz) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iuy, this.mPaint);
        canvas.drawPath(this.iuw, this.mPaint);
        if (this.status == d.ity) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iux, this.mPaint);
        canvas.drawPath(this.iuv, this.mPaint);
        if (this.status == d.itx) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iuu, this.mPaint);
    }

    public void uu(int i) {
        this.iur = ap.getColor(i, R.color.CAM_X0303);
        this.ius = ap.getColor(i, R.color.CAM_X0302);
        this.iut = ap.getColor(i, R.color.CAM_X0204);
        this.iuq = true;
        invalidate();
    }
}
