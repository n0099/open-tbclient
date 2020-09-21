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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.i;
/* loaded from: classes20.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean flj;
    private boolean isLeft;
    private int jkN;
    private int jkO;
    private int jkP;
    private int jkQ;
    private Drawable jkR;
    private Drawable jkS;
    private Drawable jkT;
    private int jkU;
    private int jkV;
    private int jkW;
    private int jkX;
    private RectF jkY;
    private RectF jkZ;
    private i jla;
    private HotTopicActivity jlb;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.flj = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.flj = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.flj = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cEh();
        this.jkT = ap.getDrawable(R.drawable.icon_pic_vs);
        this.jkU = this.jkR.getIntrinsicWidth();
        this.jkV = this.jkR.getIntrinsicHeight();
        this.jkW = this.jkT.getIntrinsicWidth();
        this.jkX = this.jkT.getIntrinsicHeight();
        this.jkY = new RectF(0.0f, 0.0f, this.jkU, this.jkV);
        this.jkQ = (this.jkV - this.jkX) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.jla = iVar;
            this.jlb = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jla.jhv != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jkY.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jla.jim++;
                    this.jla.jhv = 1;
                } else if (this.jkZ.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jla.jip++;
                    this.jla.jhv = 2;
                }
                cEh();
                if (this.jla.jhv != 0) {
                    if (this.jla.jim + this.jla.jip > 50) {
                        this.flj = true;
                        new Thread(new Runnable() { // from class: com.baidu.tieba.hottopic.view.HotTopicPkView.1
                            @Override // java.lang.Runnable
                            public void run() {
                                for (int i = 0; i < 4; i++) {
                                    HotTopicPkView.this.postInvalidate();
                                    try {
                                        Thread.sleep(100L);
                                    } catch (InterruptedException e) {
                                    }
                                }
                                HotTopicPkView.this.flj = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.jlb.cDp();
                    return true;
                }
                return true;
            default:
                return super.onTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.jkN = this.jkV;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.jkN + this.ds30);
        this.jkO = (this.width - (this.jkU * 2)) - 100;
        if (this.jkZ == null) {
            this.jkZ = new RectF(this.width - this.jkU, 0.0f, this.width, this.jkN);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        V(canvas);
        W(canvas);
        X(canvas);
        C(canvas);
    }

    private void V(Canvas canvas) {
        if (this.jla.jim == 0 && this.jla.jip == 0) {
            this.jkP = (int) ((0.5d * this.jkO) + this.jkU + 50.0d);
        } else {
            this.jkP = (int) (((((float) this.jla.jim) / ((float) (this.jla.jim + this.jla.jip))) * this.jkO) + this.jkU + 50.0f);
        }
        if (this.jla.jhv == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.jkU / 2.0f, this.jkQ, this.jkP, this.jkN - this.jkQ, this.paint);
        if (this.jla.jhv == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.jkP, this.jkQ, this.width - (this.jkU / 2.0f), this.jkN - this.jkQ, this.paint);
    }

    private void W(Canvas canvas) {
        cEh();
        this.jkR.setBounds(0, 0, this.jkU, this.jkV);
        this.jkR.draw(canvas);
        this.jkS.setBounds(this.width - this.jkU, 0, this.width, this.jkV);
        this.jkS.draw(canvas);
    }

    private void X(Canvas canvas) {
        this.jkT = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.flj) {
            if (this.isLeft) {
                this.jkT.setBounds((this.jkP - (this.jkW / 2)) - 3, this.jkQ, ((this.jkP - (this.jkW / 2)) - 3) + this.jkW, this.jkQ + this.jkX);
                this.jkT.draw(canvas);
            } else {
                this.jkT.setBounds((this.jkP - (this.jkW / 2)) + 3, this.jkQ, (this.jkP - (this.jkW / 2)) + 3 + this.jkW, this.jkQ + this.jkX);
                this.jkT.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.jkT.setBounds(this.jkP - (this.jkW / 2), this.jkQ, (this.jkP - (this.jkW / 2)) + this.jkW, this.jkQ + this.jkX);
        this.jkT.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.jla.jhv == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawText(at.numberUniformFormat(this.jla.jim), this.jkU, this.jkN + dimensionPixelSize, this.paint);
        if (this.jla.jhv == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(at.numberUniformFormat(this.jla.jip), (this.width - this.jkU) - ((int) this.paint.measureText(at.numberUniformFormat(this.jla.jip))), dimensionPixelSize + this.jkN, this.paint);
    }

    private void cEh() {
        if (this.jla == null) {
            this.jkR = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jkS = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.jla.jhv == 1) {
            this.jkR = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.jkS = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.jla.jhv == 2) {
            this.jkS = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.jkR = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.jkR = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jkS = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
