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
/* loaded from: classes7.dex */
public class VoteStatusView extends View {
    private boolean ivZ;
    public int iwa;
    public int iwb;
    public int iwc;
    private Path iwd;
    private Path iwe;
    private Path iwf;
    private Path iwg;
    private Path iwh;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.ivZ = true;
        initUI();
    }

    private void initUI() {
        this.iwc = ap.getColor(R.color.CAM_X0204);
        this.iwa = ap.getColor(R.color.CAM_X0303);
        this.iwb = ap.getColor(R.color.CAM_X0302);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.iwc);
        this.iwd = new Path();
        this.iwe = new Path();
        this.iwf = new Path();
        this.iwg = new Path();
        this.iwh = new Path();
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
        this.iwd.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.iwe.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.iwf.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.iwg.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.iwh.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.iwc);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.ivZ) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.iwa, this.iwb, Shader.TileMode.CLAMP);
            this.ivZ = false;
        }
        if (this.status == d.ivi) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iwh, this.mPaint);
        canvas.drawPath(this.iwf, this.mPaint);
        if (this.status == d.ivh) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iwg, this.mPaint);
        canvas.drawPath(this.iwe, this.mPaint);
        if (this.status == d.ivg) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.iwd, this.mPaint);
    }

    public void uw(int i) {
        this.iwa = ap.getColor(i, R.color.CAM_X0303);
        this.iwb = ap.getColor(i, R.color.CAM_X0302);
        this.iwc = ap.getColor(i, R.color.CAM_X0204);
        this.ivZ = true;
        invalidate();
    }
}
