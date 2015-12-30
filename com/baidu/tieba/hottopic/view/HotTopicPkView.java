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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class HotTopicPkView extends View {
    private int[] bJA;
    private int[] bJB;
    private com.baidu.tieba.hottopic.data.e bJC;
    private HotTopicActivity bJD;
    private boolean bJE;
    private boolean bJF;
    private int bJn;
    private int bJo;
    private int bJp;
    private int bJq;
    private Drawable bJr;
    private Drawable bJs;
    private Drawable bJt;
    private int bJu;
    private int bJv;
    private int bJw;
    private int bJx;
    private RectF bJy;
    private RectF bJz;
    private int ds30;
    private final int offset;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offset = 50;
        this.bJA = new int[2];
        this.bJB = new int[2];
        this.bJE = false;
        this.bJF = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offset = 50;
        this.bJA = new int[2];
        this.bJB = new int[2];
        this.bJE = false;
        this.bJF = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.offset = 50;
        this.bJA = new int[2];
        this.bJB = new int[2];
        this.bJE = false;
        this.bJF = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(n.e.ds30);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bJr = as.getDrawable(n.f.icon_pk_red_n_1);
            this.bJs = as.getDrawable(n.f.icon_pk_blule_n_1);
            this.bJt = as.getDrawable(n.f.icon_pic_vs_1);
            this.bJA = new int[]{n.d.cp_other_b_1, n.d.topic_pk_agree_disable_1};
            this.bJB = new int[]{n.d.cp_link_tip_a_1, n.d.topic_pk_oppose_disable_1};
        } else {
            this.bJr = as.getDrawable(n.f.icon_pk_red_n);
            this.bJs = as.getDrawable(n.f.icon_pk_blule_n);
            this.bJt = as.getDrawable(n.f.icon_pic_vs);
            this.bJA = new int[]{n.d.cp_other_b, n.d.topic_pk_agree_disable};
            this.bJB = new int[]{n.d.cp_link_tip_a, n.d.topic_pk_oppose_disable};
        }
        this.bJu = this.bJr.getIntrinsicWidth();
        this.bJv = this.bJr.getIntrinsicHeight();
        this.bJw = this.bJt.getIntrinsicWidth();
        this.bJx = this.bJt.getIntrinsicHeight();
        this.bJy = new RectF(0.0f, 0.0f, this.bJu, this.bJv);
        this.bJq = (this.bJv - this.bJx) / 2;
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar, HotTopicActivity hotTopicActivity) {
        this.bJC = eVar;
        this.bJD = hotTopicActivity;
        if (eVar.bHd == 1) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.bJr = as.getDrawable(n.f.icon_pk_red_s_1);
                this.bJs = as.getDrawable(n.f.icon_pk_blule_d_1);
                return;
            }
            this.bJr = as.getDrawable(n.f.icon_pk_red_s);
            this.bJs = as.getDrawable(n.f.icon_pk_blule_d);
        } else if (eVar.bHd == 2) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.bJs = as.getDrawable(n.f.icon_pk_blule_s_1);
                this.bJr = as.getDrawable(n.f.icon_pk_red_d_1);
                return;
            }
            this.bJs = as.getDrawable(n.f.icon_pk_blule_s);
            this.bJr = as.getDrawable(n.f.icon_pk_red_d);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bJC.bHd == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.bJy.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.bJC.bHy++;
                        this.bJC.bHd = 1;
                        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                            this.bJr = as.getDrawable(n.f.icon_pk_red_s_1);
                            this.bJs = as.getDrawable(n.f.icon_pk_blule_d_1);
                        } else {
                            this.bJr = as.getDrawable(n.f.icon_pk_red_s);
                            this.bJs = as.getDrawable(n.f.icon_pk_blule_d);
                        }
                    } else if (this.bJz.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.bJC.bHB++;
                        this.bJC.bHd = 2;
                        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                            this.bJs = as.getDrawable(n.f.icon_pk_blule_s_1);
                            this.bJr = as.getDrawable(n.f.icon_pk_red_d_1);
                        } else {
                            this.bJs = as.getDrawable(n.f.icon_pk_blule_s);
                            this.bJr = as.getDrawable(n.f.icon_pk_red_d);
                        }
                    }
                    if (this.bJC.bHd != 0) {
                        if (this.bJC.bHy + this.bJC.bHB > 50) {
                            this.bJE = true;
                            new Thread(new g(this)).start();
                        } else {
                            invalidate();
                        }
                        this.bJD.Vl();
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
        this.bJr.setCallback(null);
        this.bJs.setCallback(null);
        this.bJt.setCallback(null);
        this.bJr = null;
        this.bJs = null;
        this.bJt = null;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.bJn = this.bJv;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.bJn + this.ds30);
        this.bJo = (this.width - (this.bJu * 2)) - 100;
        if (this.bJz == null) {
            this.bJz = new RectF(this.width - this.bJu, 0.0f, this.width, this.bJn);
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
        if (this.bJC.bHy == 0 && this.bJC.bHB == 0) {
            this.bJp = (int) ((0.5d * this.bJo) + this.bJu + 50.0d);
        } else {
            this.bJp = (int) (((((float) this.bJC.bHy) / ((float) (this.bJC.bHy + this.bJC.bHB))) * this.bJo) + this.bJu + 50.0f);
        }
        if (this.bJC.bHd == 2) {
            this.paint.setColor(getContext().getResources().getColor(this.bJA[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bJA[0]));
        }
        canvas.drawRect(this.bJu / 2, this.bJq, this.bJp, this.bJn - this.bJq, this.paint);
        if (this.bJC.bHd == 1) {
            this.paint.setColor(getContext().getResources().getColor(this.bJB[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bJB[0]));
        }
        canvas.drawRect(this.bJp, this.bJq, this.width - (this.bJu / 2), this.bJn - this.bJq, this.paint);
    }

    private void j(Canvas canvas) {
        this.bJr.setBounds(0, 0, this.bJu, this.bJv);
        this.bJr.draw(canvas);
        this.bJs.setBounds(this.width - this.bJu, 0, this.width, this.bJv);
        this.bJs.draw(canvas);
    }

    private void k(Canvas canvas) {
        if (this.bJE) {
            if (this.bJF) {
                this.bJt.setBounds((this.bJp - (this.bJw / 2)) - 3, this.bJq, ((this.bJp - (this.bJw / 2)) - 3) + this.bJw, this.bJq + this.bJx);
                this.bJt.draw(canvas);
            } else {
                this.bJt.setBounds((this.bJp - (this.bJw / 2)) + 3, this.bJq, (this.bJp - (this.bJw / 2)) + 3 + this.bJw, this.bJq + this.bJx);
                this.bJt.draw(canvas);
            }
            this.bJF = !this.bJF;
            return;
        }
        this.bJt.setBounds(this.bJp - (this.bJw / 2), this.bJq, (this.bJp - (this.bJw / 2)) + this.bJw, this.bJq + this.bJx);
        this.bJt.draw(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(n.e.ds25);
        this.paint.setTextSize(TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(n.e.fontsize28));
        if (this.bJC.bHd == 2) {
            this.paint.setColor(getContext().getResources().getColor(this.bJA[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bJA[0]));
        }
        canvas.drawText(ax.w(this.bJC.bHy), this.bJu, this.bJn + dimensionPixelSize, this.paint);
        if (this.bJC.bHd == 1) {
            this.paint.setColor(getContext().getResources().getColor(this.bJB[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bJB[0]));
        }
        canvas.drawText(ax.w(this.bJC.bHB), (this.width - this.bJu) - ((int) this.paint.measureText(ax.w(this.bJC.bHB))), dimensionPixelSize + this.bJn, this.paint);
    }
}
