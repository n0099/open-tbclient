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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.i;
/* loaded from: classes8.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean gcz;
    private boolean isLeft;
    private int ktJ;
    private int ktK;
    private int ktL;
    private int ktM;
    private Drawable ktN;
    private Drawable ktO;
    private Drawable ktP;
    private int ktQ;
    private int ktR;
    private int ktS;
    private int ktT;
    private RectF ktU;
    private RectF ktV;
    private i ktW;
    private HotTopicActivity ktX;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gcz = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gcz = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gcz = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cVz();
        this.ktP = ao.getDrawable(R.drawable.icon_pic_vs);
        this.ktQ = this.ktN.getIntrinsicWidth();
        this.ktR = this.ktN.getIntrinsicHeight();
        this.ktS = this.ktP.getIntrinsicWidth();
        this.ktT = this.ktP.getIntrinsicHeight();
        this.ktU = new RectF(0.0f, 0.0f, this.ktQ, this.ktR);
        this.ktM = (this.ktR - this.ktT) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.ktW = iVar;
            this.ktX = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ktW.kqs != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.ktU.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.ktW.krj++;
                    this.ktW.kqs = 1;
                } else if (this.ktV.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.ktW.krm++;
                    this.ktW.kqs = 2;
                }
                cVz();
                if (this.ktW.kqs != 0) {
                    if (this.ktW.krj + this.ktW.krm > 50) {
                        this.gcz = true;
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
                                HotTopicPkView.this.gcz = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.ktX.cUI();
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
        this.ktJ = this.ktR;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.ktJ + this.ds30);
        this.ktK = (this.width - (this.ktQ * 2)) - 100;
        if (this.ktV == null) {
            this.ktV = new RectF(this.width - this.ktQ, 0.0f, this.width, this.ktJ);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        af(canvas);
        ag(canvas);
        ah(canvas);
        J(canvas);
    }

    private void af(Canvas canvas) {
        if (this.ktW.krj == 0 && this.ktW.krm == 0) {
            this.ktL = (int) ((0.5d * this.ktK) + this.ktQ + 50.0d);
        } else {
            this.ktL = (int) (((((float) this.ktW.krj) / ((float) (this.ktW.krj + this.ktW.krm))) * this.ktK) + this.ktQ + 50.0f);
        }
        if (this.ktW.kqs == 2) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.ktQ / 2.0f, this.ktM, this.ktL, this.ktJ - this.ktM, this.paint);
        if (this.ktW.kqs == 1) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.ktL, this.ktM, this.width - (this.ktQ / 2.0f), this.ktJ - this.ktM, this.paint);
    }

    private void ag(Canvas canvas) {
        cVz();
        this.ktN.setBounds(0, 0, this.ktQ, this.ktR);
        this.ktN.draw(canvas);
        this.ktO.setBounds(this.width - this.ktQ, 0, this.width, this.ktR);
        this.ktO.draw(canvas);
    }

    private void ah(Canvas canvas) {
        this.ktP = ao.getDrawable(R.drawable.icon_pic_vs);
        if (this.gcz) {
            if (this.isLeft) {
                this.ktP.setBounds((this.ktL - (this.ktS / 2)) - 3, this.ktM, ((this.ktL - (this.ktS / 2)) - 3) + this.ktS, this.ktM + this.ktT);
                this.ktP.draw(canvas);
            } else {
                this.ktP.setBounds((this.ktL - (this.ktS / 2)) + 3, this.ktM, (this.ktL - (this.ktS / 2)) + 3 + this.ktS, this.ktM + this.ktT);
                this.ktP.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.ktP.setBounds(this.ktL - (this.ktS / 2), this.ktM, (this.ktL - (this.ktS / 2)) + this.ktS, this.ktM + this.ktT);
        this.ktP.draw(canvas);
    }

    private void J(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.ktW.kqs == 2) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(at.numberUniformFormat(this.ktW.krj), this.ktQ, this.ktJ + dimensionPixelSize, this.paint);
        if (this.ktW.kqs == 1) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(at.numberUniformFormat(this.ktW.krm), (this.width - this.ktQ) - ((int) this.paint.measureText(at.numberUniformFormat(this.ktW.krm))), dimensionPixelSize + this.ktJ, this.paint);
    }

    private void cVz() {
        if (this.ktW == null) {
            this.ktN = ao.getDrawable(R.drawable.icon_pk_red_n);
            this.ktO = ao.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.ktW.kqs == 1) {
            this.ktN = ao.getDrawable(R.drawable.icon_pk_red_s);
            this.ktO = ao.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.ktW.kqs == 2) {
            this.ktO = ao.getDrawable(R.drawable.icon_pk_blule_s);
            this.ktN = ao.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.ktN = ao.getDrawable(R.drawable.icon_pk_red_n);
            this.ktO = ao.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
