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
    private int bFG;
    private int bFH;
    private int bFI;
    private int bFJ;
    private Drawable bFK;
    private Drawable bFL;
    private Drawable bFM;
    private int bFN;
    private int bFO;
    private int bFP;
    private int bFQ;
    private RectF bFR;
    private RectF bFS;
    private int[] bFT;
    private int[] bFU;
    private com.baidu.tieba.hottopic.data.e bFV;
    private HotTopicActivity bFW;
    private boolean bFX;
    private boolean bFY;
    private int ds30;
    private final int offset;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offset = 50;
        this.bFT = new int[2];
        this.bFU = new int[2];
        this.bFX = false;
        this.bFY = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offset = 50;
        this.bFT = new int[2];
        this.bFU = new int[2];
        this.bFX = false;
        this.bFY = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.offset = 50;
        this.bFT = new int[2];
        this.bFU = new int[2];
        this.bFX = false;
        this.bFY = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(n.d.ds30);
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.bFK = as.getDrawable(n.e.icon_pk_red_n_1);
            this.bFL = as.getDrawable(n.e.icon_pk_blule_n_1);
            this.bFM = as.getDrawable(n.e.icon_pic_vs_1);
            this.bFT = new int[]{n.c.cp_other_b_1, n.c.topic_pk_agree_disable_1};
            this.bFU = new int[]{n.c.cp_link_tip_a_1, n.c.topic_pk_oppose_disable_1};
        } else {
            this.bFK = as.getDrawable(n.e.icon_pk_red_n);
            this.bFL = as.getDrawable(n.e.icon_pk_blule_n);
            this.bFM = as.getDrawable(n.e.icon_pic_vs);
            this.bFT = new int[]{n.c.cp_other_b, n.c.topic_pk_agree_disable};
            this.bFU = new int[]{n.c.cp_link_tip_a, n.c.topic_pk_oppose_disable};
        }
        this.bFN = this.bFK.getIntrinsicWidth();
        this.bFO = this.bFK.getIntrinsicHeight();
        this.bFP = this.bFM.getIntrinsicWidth();
        this.bFQ = this.bFM.getIntrinsicHeight();
        this.bFR = new RectF(0.0f, 0.0f, this.bFN, this.bFO);
        this.bFJ = (this.bFO - this.bFQ) / 2;
    }

    public void a(com.baidu.tieba.hottopic.data.e eVar, HotTopicActivity hotTopicActivity) {
        this.bFV = eVar;
        this.bFW = hotTopicActivity;
        if (eVar.bDz == 1) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.bFK = as.getDrawable(n.e.icon_pk_red_s_1);
                this.bFL = as.getDrawable(n.e.icon_pk_blule_d_1);
                return;
            }
            this.bFK = as.getDrawable(n.e.icon_pk_red_s);
            this.bFL = as.getDrawable(n.e.icon_pk_blule_d);
        } else if (eVar.bDz == 2) {
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                this.bFL = as.getDrawable(n.e.icon_pk_blule_s_1);
                this.bFK = as.getDrawable(n.e.icon_pk_red_d_1);
                return;
            }
            this.bFL = as.getDrawable(n.e.icon_pk_blule_s);
            this.bFK = as.getDrawable(n.e.icon_pk_red_d);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.bFV.bDz == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (this.bFR.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.bFV.bDV++;
                        this.bFV.bDz = 1;
                        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                            this.bFK = as.getDrawable(n.e.icon_pk_red_s_1);
                            this.bFL = as.getDrawable(n.e.icon_pk_blule_d_1);
                        } else {
                            this.bFK = as.getDrawable(n.e.icon_pk_red_s);
                            this.bFL = as.getDrawable(n.e.icon_pk_blule_d);
                        }
                    } else if (this.bFS.contains(motionEvent.getX(), motionEvent.getY())) {
                        this.bFV.bDY++;
                        this.bFV.bDz = 2;
                        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                            this.bFL = as.getDrawable(n.e.icon_pk_blule_s_1);
                            this.bFK = as.getDrawable(n.e.icon_pk_red_d_1);
                        } else {
                            this.bFL = as.getDrawable(n.e.icon_pk_blule_s);
                            this.bFK = as.getDrawable(n.e.icon_pk_red_d);
                        }
                    }
                    if (this.bFV.bDz != 0) {
                        if (this.bFV.bDV + this.bFV.bDY > 50) {
                            this.bFX = true;
                            new Thread(new g(this)).start();
                        } else {
                            invalidate();
                        }
                        this.bFW.Uj();
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
        this.bFK.setCallback(null);
        this.bFL.setCallback(null);
        this.bFM.setCallback(null);
        this.bFK = null;
        this.bFL = null;
        this.bFM = null;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.bFG = this.bFO;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.bFG + this.ds30);
        this.bFH = (this.width - (this.bFN * 2)) - 100;
        if (this.bFS == null) {
            this.bFS = new RectF(this.width - this.bFN, 0.0f, this.width, this.bFG);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        h(canvas);
        i(canvas);
        j(canvas);
        drawText(canvas);
    }

    private void h(Canvas canvas) {
        if (this.bFV.bDV == 0 && this.bFV.bDY == 0) {
            this.bFI = (int) ((0.5d * this.bFH) + this.bFN + 50.0d);
        } else {
            this.bFI = (int) (((((float) this.bFV.bDV) / ((float) (this.bFV.bDV + this.bFV.bDY))) * this.bFH) + this.bFN + 50.0f);
        }
        if (this.bFV.bDz == 2) {
            this.paint.setColor(getContext().getResources().getColor(this.bFT[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bFT[0]));
        }
        canvas.drawRect(this.bFN / 2, this.bFJ, this.bFI, this.bFG - this.bFJ, this.paint);
        if (this.bFV.bDz == 1) {
            this.paint.setColor(getContext().getResources().getColor(this.bFU[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bFU[0]));
        }
        canvas.drawRect(this.bFI, this.bFJ, this.width - (this.bFN / 2), this.bFG - this.bFJ, this.paint);
    }

    private void i(Canvas canvas) {
        this.bFK.setBounds(0, 0, this.bFN, this.bFO);
        this.bFK.draw(canvas);
        this.bFL.setBounds(this.width - this.bFN, 0, this.width, this.bFO);
        this.bFL.draw(canvas);
    }

    private void j(Canvas canvas) {
        if (this.bFX) {
            if (this.bFY) {
                this.bFM.setBounds((this.bFI - (this.bFP / 2)) - 3, this.bFJ, ((this.bFI - (this.bFP / 2)) - 3) + this.bFP, this.bFJ + this.bFQ);
                this.bFM.draw(canvas);
            } else {
                this.bFM.setBounds((this.bFI - (this.bFP / 2)) + 3, this.bFJ, (this.bFI - (this.bFP / 2)) + 3 + this.bFP, this.bFJ + this.bFQ);
                this.bFM.draw(canvas);
            }
            this.bFY = !this.bFY;
            return;
        }
        this.bFM.setBounds(this.bFI - (this.bFP / 2), this.bFJ, (this.bFI - (this.bFP / 2)) + this.bFP, this.bFJ + this.bFQ);
        this.bFM.draw(canvas);
    }

    private void drawText(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(n.d.ds25);
        this.paint.setTextSize(TbadkCoreApplication.m411getInst().getContext().getResources().getDimensionPixelSize(n.d.fontsize28));
        if (this.bFV.bDz == 2) {
            this.paint.setColor(getContext().getResources().getColor(this.bFT[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bFT[0]));
        }
        canvas.drawText(ax.v(this.bFV.bDV), this.bFN, this.bFG + dimensionPixelSize, this.paint);
        if (this.bFV.bDz == 1) {
            this.paint.setColor(getContext().getResources().getColor(this.bFU[1]));
        } else {
            this.paint.setColor(getContext().getResources().getColor(this.bFU[0]));
        }
        canvas.drawText(ax.v(this.bFV.bDY), (this.width - this.bFN) - ((int) this.paint.measureText(ax.v(this.bFV.bDY))), dimensionPixelSize + this.bFG, this.paint);
    }
}
