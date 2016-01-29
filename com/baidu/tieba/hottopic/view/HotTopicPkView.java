package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class HotTopicPkView extends View {
    private int bMU;
    private int bMV;
    private int bMW;
    private int bMX;
    private Drawable bMY;
    private Drawable bMZ;
    private Drawable bNa;
    private int bNb;
    private int bNc;
    private int bNd;
    private int bNe;
    private RectF bNf;
    private RectF bNg;
    private int[] bNh;
    private int[] bNi;
    private com.baidu.tieba.hottopic.data.h bNj;
    private HotTopicActivity bNk;
    private boolean bNl;
    private boolean bNm;
    private int ds30;
    private final int offset;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offset = 50;
        this.bNh = new int[2];
        this.bNi = new int[2];
        this.bNl = false;
        this.bNm = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offset = 50;
        this.bNh = new int[2];
        this.bNi = new int[2];
        this.bNl = false;
        this.bNm = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.offset = 50;
        this.bNh = new int[2];
        this.bNi = new int[2];
        this.bNl = false;
        this.bNm = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(t.e.ds30);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bMY = ar.getDrawable(t.f.icon_pk_red_n_1);
            this.bMZ = ar.getDrawable(t.f.icon_pk_blule_n_1);
            this.bNa = ar.getDrawable(t.f.icon_pic_vs_1);
            this.bNh = new int[]{t.d.cp_other_b_1, t.d.topic_pk_agree_disable_1};
            this.bNi = new int[]{t.d.cp_link_tip_a_1, t.d.topic_pk_oppose_disable_1};
        } else {
            this.bMY = ar.getDrawable(t.f.icon_pk_red_n);
            this.bMZ = ar.getDrawable(t.f.icon_pk_blule_n);
            this.bNa = ar.getDrawable(t.f.icon_pic_vs);
            this.bNh = new int[]{t.d.cp_other_b, t.d.topic_pk_agree_disable};
            this.bNi = new int[]{t.d.cp_link_tip_a, t.d.topic_pk_oppose_disable};
        }
        this.bNb = this.bMY.getIntrinsicWidth();
        this.bNc = this.bMY.getIntrinsicHeight();
        this.bNd = this.bNa.getIntrinsicWidth();
        this.bNe = this.bNa.getIntrinsicHeight();
        this.bNf = new RectF(0.0f, 0.0f, this.bNb, this.bNc);
        this.bMX = (this.bNc - this.bNe) / 2;
    }

    public void a(com.baidu.tieba.hottopic.data.h hVar, HotTopicActivity hotTopicActivity) {
        this.bNj = hVar;
        this.bNk = hotTopicActivity;
        if (hVar.bKD == 1) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.bMY = ar.getDrawable(t.f.icon_pk_red_s_1);
                this.bMZ = ar.getDrawable(t.f.icon_pk_blule_d_1);
                return;
            }
            this.bMY = ar.getDrawable(t.f.icon_pk_red_s);
            this.bMZ = ar.getDrawable(t.f.icon_pk_blule_d);
        } else if (hVar.bKD == 2) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.bMZ = ar.getDrawable(t.f.icon_pk_blule_s_1);
                this.bMY = ar.getDrawable(t.f.icon_pk_red_d_1);
                return;
            }
            this.bMZ = ar.getDrawable(t.f.icon_pk_blule_s);
            this.bMY = ar.getDrawable(t.f.icon_pk_red_d);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bNj.bKD == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.bNf.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.bNj.bLk++;
                        this.bNj.bKD = 1;
                        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                            this.bMY = ar.getDrawable(t.f.icon_pk_red_s_1);
                            this.bMZ = ar.getDrawable(t.f.icon_pk_blule_d_1);
                        } else {
                            this.bMY = ar.getDrawable(t.f.icon_pk_red_s);
                            this.bMZ = ar.getDrawable(t.f.icon_pk_blule_d);
                        }
                    } else if (this.bNg.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.bNj.bLn++;
                        this.bNj.bKD = 2;
                        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                            this.bMZ = ar.getDrawable(t.f.icon_pk_blule_s_1);
                            this.bMY = ar.getDrawable(t.f.icon_pk_red_d_1);
                        } else {
                            this.bMZ = ar.getDrawable(t.f.icon_pk_blule_s);
                            this.bMY = ar.getDrawable(t.f.icon_pk_red_d);
                        }
                    }
                    if (this.bNj.bKD != 0) {
                        if (this.bNj.bLk + this.bNj.bLn > 50) {
                            this.bNl = true;
                            new Thread(new i(this)).start();
                        } else {
                            invalidate();
                        }
                        this.bNk.XA();
                        break;
                    }
                    break;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.bMY.setCallback(null);
        this.bMZ.setCallback(null);
        this.bNa.setCallback(null);
        this.bMY = null;
        this.bMZ = null;
        this.bNa = null;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.bMU = this.bNc;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.bMU + this.ds30);
        this.bMV = (this.width - (this.bNb * 2)) - 100;
        if (this.bNg == null) {
            this.bNg = new RectF(this.width - this.bNb, 0.0f, this.width, this.bMU);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        i(canvas);
        j(canvas);
        k(canvas);
        drawText(canvas);
    }

    private void i(Canvas canvas) {
        if (this.bNj.bLk == 0 && this.bNj.bLn == 0) {
            this.bMW = (int) ((0.5d * this.bMV) + this.bNb + 50.0d);
        } else {
            this.bMW = (int) (((((float) this.bNj.bLk) / ((float) (this.bNj.bLk + this.bNj.bLn))) * this.bMV) + this.bNb + 50.0f);
        }
        if (this.bNj.bKD == 2) {
            this.paint.setColor(getContext().getResources().getColor(this.bNh[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bNh[0]));
        }
        canvas.drawRect(this.bNb / 2, this.bMX, this.bMW, this.bMU - this.bMX, this.paint);
        if (this.bNj.bKD == 1) {
            this.paint.setColor(getContext().getResources().getColor(this.bNi[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bNi[0]));
        }
        canvas.drawRect(this.bMW, this.bMX, this.width - (this.bNb / 2), this.bMU - this.bMX, this.paint);
    }

    private void j(Canvas canvas) {
        this.bMY.setBounds(0, 0, this.bNb, this.bNc);
        this.bMY.draw(canvas);
        this.bMZ.setBounds(this.width - this.bNb, 0, this.width, this.bNc);
        this.bMZ.draw(canvas);
    }

    private void k(Canvas canvas) {
        if (this.bNl) {
            if (this.bNm) {
                this.bNa.setBounds((this.bMW - (this.bNd / 2)) - 3, this.bMX, ((this.bMW - (this.bNd / 2)) - 3) + this.bNd, this.bMX + this.bNe);
                this.bNa.draw(canvas);
            } else {
                this.bNa.setBounds((this.bMW - (this.bNd / 2)) + 3, this.bMX, (this.bMW - (this.bNd / 2)) + 3 + this.bNd, this.bMX + this.bNe);
                this.bNa.draw(canvas);
            }
            this.bNm = !this.bNm;
            return;
        }
        this.bNa.setBounds(this.bMW - (this.bNd / 2), this.bMX, (this.bMW - (this.bNd / 2)) + this.bNd, this.bMX + this.bNe);
        this.bNa.draw(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(t.e.ds25);
        this.paint.setTextSize(TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(t.e.fontsize28));
        if (this.bNj.bKD == 2) {
            this.paint.setColor(getContext().getResources().getColor(this.bNh[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bNh[0]));
        }
        canvas.drawText(aw.x(this.bNj.bLk), this.bNb, this.bMU + dimensionPixelSize, this.paint);
        if (this.bNj.bKD == 1) {
            this.paint.setColor(getContext().getResources().getColor(this.bNi[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bNi[0]));
        }
        canvas.drawText(aw.x(this.bNj.bLn), (this.width - this.bNb) - ((int) this.paint.measureText(aw.x(this.bNj.bLn))), dimensionPixelSize + this.bMU, this.paint);
    }
}
