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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.i;
/* loaded from: classes15.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean eXD;
    private int iNd;
    private int iNe;
    private int iNf;
    private int iNg;
    private Drawable iNh;
    private Drawable iNi;
    private Drawable iNj;
    private int iNk;
    private int iNl;
    private int iNm;
    private int iNn;
    private RectF iNo;
    private RectF iNp;
    private i iNq;
    private HotTopicActivity iNr;
    private boolean isLeft;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eXD = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eXD = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eXD = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cpH();
        this.iNj = ao.getDrawable(R.drawable.icon_pic_vs);
        this.iNk = this.iNh.getIntrinsicWidth();
        this.iNl = this.iNh.getIntrinsicHeight();
        this.iNm = this.iNj.getIntrinsicWidth();
        this.iNn = this.iNj.getIntrinsicHeight();
        this.iNo = new RectF(0.0f, 0.0f, this.iNk, this.iNl);
        this.iNg = (this.iNl - this.iNn) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.iNq = iVar;
            this.iNr = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iNq.iJM != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.iNo.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.iNq.iKC++;
                    this.iNq.iJM = 1;
                } else if (this.iNp.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.iNq.iKF++;
                    this.iNq.iJM = 2;
                }
                cpH();
                if (this.iNq.iJM != 0) {
                    if (this.iNq.iKC + this.iNq.iKF > 50) {
                        this.eXD = true;
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
                                HotTopicPkView.this.eXD = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.iNr.coO();
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
        this.iNd = this.iNl;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.iNd + this.ds30);
        this.iNe = (this.width - (this.iNk * 2)) - 100;
        if (this.iNp == null) {
            this.iNp = new RectF(this.width - this.iNk, 0.0f, this.width, this.iNd);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        O(canvas);
        P(canvas);
        Q(canvas);
        G(canvas);
    }

    private void O(Canvas canvas) {
        if (this.iNq.iKC == 0 && this.iNq.iKF == 0) {
            this.iNf = (int) ((0.5d * this.iNe) + this.iNk + 50.0d);
        } else {
            this.iNf = (int) (((((float) this.iNq.iKC) / ((float) (this.iNq.iKC + this.iNq.iKF))) * this.iNe) + this.iNk + 50.0f);
        }
        if (this.iNq.iJM == 2) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.iNk / 2.0f, this.iNg, this.iNf, this.iNd - this.iNg, this.paint);
        if (this.iNq.iJM == 1) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.iNf, this.iNg, this.width - (this.iNk / 2.0f), this.iNd - this.iNg, this.paint);
    }

    private void P(Canvas canvas) {
        cpH();
        this.iNh.setBounds(0, 0, this.iNk, this.iNl);
        this.iNh.draw(canvas);
        this.iNi.setBounds(this.width - this.iNk, 0, this.width, this.iNl);
        this.iNi.draw(canvas);
    }

    private void Q(Canvas canvas) {
        this.iNj = ao.getDrawable(R.drawable.icon_pic_vs);
        if (this.eXD) {
            if (this.isLeft) {
                this.iNj.setBounds((this.iNf - (this.iNm / 2)) - 3, this.iNg, ((this.iNf - (this.iNm / 2)) - 3) + this.iNm, this.iNg + this.iNn);
                this.iNj.draw(canvas);
            } else {
                this.iNj.setBounds((this.iNf - (this.iNm / 2)) + 3, this.iNg, (this.iNf - (this.iNm / 2)) + 3 + this.iNm, this.iNg + this.iNn);
                this.iNj.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.iNj.setBounds(this.iNf - (this.iNm / 2), this.iNg, (this.iNf - (this.iNm / 2)) + this.iNm, this.iNg + this.iNn);
        this.iNj.draw(canvas);
    }

    private void G(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.iNq.iJM == 2) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.cp_other_b));
        }
        canvas.drawText(as.numberUniformFormat(this.iNq.iKC), this.iNk, this.iNd + dimensionPixelSize, this.paint);
        if (this.iNq.iJM == 1) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(as.numberUniformFormat(this.iNq.iKF), (this.width - this.iNk) - ((int) this.paint.measureText(as.numberUniformFormat(this.iNq.iKF))), dimensionPixelSize + this.iNd, this.paint);
    }

    private void cpH() {
        if (this.iNq == null) {
            this.iNh = ao.getDrawable(R.drawable.icon_pk_red_n);
            this.iNi = ao.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.iNq.iJM == 1) {
            this.iNh = ao.getDrawable(R.drawable.icon_pk_red_s);
            this.iNi = ao.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.iNq.iJM == 2) {
            this.iNi = ao.getDrawable(R.drawable.icon_pk_blule_s);
            this.iNh = ao.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.iNh = ao.getDrawable(R.drawable.icon_pk_red_n);
            this.iNi = ao.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
