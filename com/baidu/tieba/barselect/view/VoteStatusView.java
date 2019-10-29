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
    private Shader aGj;
    private boolean eKi;
    public int eKj;
    public int eKk;
    public int eKl;
    private Path eKm;
    private Path eKn;
    private Path eKo;
    private Path eKp;
    private Path eKq;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.eKi = true;
        initUI();
    }

    private void initUI() {
        this.eKl = am.getColor(R.color.cp_bg_line_c);
        this.eKj = am.getColor(R.color.cp_link_tip_b);
        this.eKk = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.eKl);
        this.eKm = new Path();
        this.eKn = new Path();
        this.eKo = new Path();
        this.eKp = new Path();
        this.eKq = new Path();
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
        this.eKm.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.eKn.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.eKo.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.eKp.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.eKq.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.eKl);
        this.mPaint.setShader(null);
        if (this.aGj == null || this.eKi) {
            this.aGj = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.eKj, this.eKk, Shader.TileMode.CLAMP);
            this.eKi = false;
        }
        if (this.status == d.eJv) {
            this.mPaint.setShader(this.aGj);
        }
        canvas.drawPath(this.eKq, this.mPaint);
        canvas.drawPath(this.eKo, this.mPaint);
        if (this.status == d.eJu) {
            this.mPaint.setShader(this.aGj);
        }
        canvas.drawPath(this.eKp, this.mPaint);
        canvas.drawPath(this.eKn, this.mPaint);
        if (this.status == d.eJt) {
            this.mPaint.setShader(this.aGj);
        }
        canvas.drawPath(this.eKm, this.mPaint);
    }

    public void mE(int i) {
        this.eKj = am.getColor(i, R.color.cp_link_tip_b);
        this.eKk = am.getColor(i, R.color.cp_link_tip_a);
        this.eKl = am.getColor(i, R.color.cp_bg_line_c);
        this.eKi = true;
        invalidate();
    }
}
