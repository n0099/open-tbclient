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
    private Shader aFR;
    private boolean eJr;
    public int eJs;
    public int eJt;
    public int eJu;
    private Path eJv;
    private Path eJw;
    private Path eJx;
    private Path eJy;
    private Path eJz;
    private Paint mPaint;
    private int status;

    public VoteStatusView(Context context) {
        this(context, null);
    }

    public VoteStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.status = -1;
        this.eJr = true;
        initUI();
    }

    private void initUI() {
        this.eJu = am.getColor(R.color.cp_bg_line_c);
        this.eJs = am.getColor(R.color.cp_link_tip_b);
        this.eJt = am.getColor(R.color.cp_link_tip_a);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.eJu);
        this.eJv = new Path();
        this.eJw = new Path();
        this.eJx = new Path();
        this.eJy = new Path();
        this.eJz = new Path();
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
        this.eJv.addCircle(i / 2, i / 2, i / 2, Path.Direction.CW);
        this.eJw.addCircle(width / 2, i / 2, i / 2, Path.Direction.CW);
        this.eJx.addCircle(width - (i / 2), i / 2, i / 2, Path.Direction.CW);
        this.eJy.addRect(i / 2, (i * 9) / 26, width / 2, (i * 17) / 26, Path.Direction.CW);
        this.eJz.addRect(width / 2, (i * 9) / 26, width - (i / 2), (i * 17) / 26, Path.Direction.CW);
        this.mPaint.setColor(this.eJu);
        this.mPaint.setShader(null);
        if (this.aFR == null || this.eJr) {
            this.aFR = new LinearGradient(i / 2, 0.0f, width - (i / 2), 0.0f, this.eJs, this.eJt, Shader.TileMode.CLAMP);
            this.eJr = false;
        }
        if (this.status == d.eIE) {
            this.mPaint.setShader(this.aFR);
        }
        canvas.drawPath(this.eJz, this.mPaint);
        canvas.drawPath(this.eJx, this.mPaint);
        if (this.status == d.eID) {
            this.mPaint.setShader(this.aFR);
        }
        canvas.drawPath(this.eJy, this.mPaint);
        canvas.drawPath(this.eJw, this.mPaint);
        if (this.status == d.eIC) {
            this.mPaint.setShader(this.aFR);
        }
        canvas.drawPath(this.eJv, this.mPaint);
    }

    public void mD(int i) {
        this.eJs = am.getColor(i, R.color.cp_link_tip_b);
        this.eJt = am.getColor(i, R.color.cp_link_tip_a);
        this.eJu = am.getColor(i, R.color.cp_bg_line_c);
        this.eJr = true;
        invalidate();
    }
}
