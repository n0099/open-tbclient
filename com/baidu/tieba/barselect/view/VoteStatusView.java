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
/* loaded from: classes20.dex */
public class VoteStatusView extends View {
    private boolean hnY;
    public int hnZ;
    public int hoa;
    public int hob;
    private Path hoc;
    private Path hod;
    private Path hoe;
    private Path hof;
    private Path hog;
    private Paint mPaint;
    private Shader mShader;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.hnY = true;
        initUI();
    }

    private void initUI() {
        this.hob = ap.getColor(R.color.cp_bg_line_c);
        this.hnZ = ap.getColor(R.color.cp_link_tip_b);
        this.hoa = ap.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.hob);
        this.hoc = new Path();
        this.hod = new Path();
        this.hoe = new Path();
        this.hof = new Path();
        this.hog = new Path();
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
        this.hoc.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.hod.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.hoe.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.hof.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.hog.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.hob);
        this.mPaint.setShader(null);
        if (this.mShader == null || this.hnY) {
            this.mShader = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.hnZ, this.hoa, Shader.TileMode.CLAMP);
            this.hnY = false;
        }
        if (this.status == d.hnh) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hog, this.mPaint);
        canvas.drawPath(this.hoe, this.mPaint);
        if (this.status == d.hng) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hof, this.mPaint);
        canvas.drawPath(this.hod, this.mPaint);
        if (this.status == d.hnf) {
            this.mPaint.setShader(this.mShader);
        }
        canvas.drawPath(this.hoc, this.mPaint);
    }

    public void tE(int i) {
        this.hnZ = ap.getColor(i, R.color.cp_link_tip_b);
        this.hoa = ap.getColor(i, R.color.cp_link_tip_a);
        this.hob = ap.getColor(i, R.color.cp_bg_line_c);
        this.hnY = true;
        invalidate();
    }
}
