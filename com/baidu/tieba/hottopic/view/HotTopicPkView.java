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
    private int iNb;
    private int iNc;
    private int iNd;
    private int iNe;
    private Drawable iNf;
    private Drawable iNg;
    private Drawable iNh;
    private int iNi;
    private int iNj;
    private int iNk;
    private int iNl;
    private RectF iNm;
    private RectF iNn;
    private i iNo;
    private HotTopicActivity iNp;
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
        this.iNh = ao.getDrawable(R.drawable.icon_pic_vs);
        this.iNi = this.iNf.getIntrinsicWidth();
        this.iNj = this.iNf.getIntrinsicHeight();
        this.iNk = this.iNh.getIntrinsicWidth();
        this.iNl = this.iNh.getIntrinsicHeight();
        this.iNm = new RectF(0.0f, 0.0f, this.iNi, this.iNj);
        this.iNe = (this.iNj - this.iNl) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.iNo = iVar;
            this.iNp = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iNo.iJK != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.iNm.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.iNo.iKA++;
                    this.iNo.iJK = 1;
                } else if (this.iNn.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.iNo.iKD++;
                    this.iNo.iJK = 2;
                }
                cpH();
                if (this.iNo.iJK != 0) {
                    if (this.iNo.iKA + this.iNo.iKD > 50) {
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
                    this.iNp.coO();
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
        this.iNb = this.iNj;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.iNb + this.ds30);
        this.iNc = (this.width - (this.iNi * 2)) - 100;
        if (this.iNn == null) {
            this.iNn = new RectF(this.width - this.iNi, 0.0f, this.width, this.iNb);
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
        if (this.iNo.iKA == 0 && this.iNo.iKD == 0) {
            this.iNd = (int) ((0.5d * this.iNc) + this.iNi + 50.0d);
        } else {
            this.iNd = (int) (((((float) this.iNo.iKA) / ((float) (this.iNo.iKA + this.iNo.iKD))) * this.iNc) + this.iNi + 50.0f);
        }
        if (this.iNo.iJK == 2) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.iNi / 2.0f, this.iNe, this.iNd, this.iNb - this.iNe, this.paint);
        if (this.iNo.iJK == 1) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.iNd, this.iNe, this.width - (this.iNi / 2.0f), this.iNb - this.iNe, this.paint);
    }

    private void P(Canvas canvas) {
        cpH();
        this.iNf.setBounds(0, 0, this.iNi, this.iNj);
        this.iNf.draw(canvas);
        this.iNg.setBounds(this.width - this.iNi, 0, this.width, this.iNj);
        this.iNg.draw(canvas);
    }

    private void Q(Canvas canvas) {
        this.iNh = ao.getDrawable(R.drawable.icon_pic_vs);
        if (this.eXD) {
            if (this.isLeft) {
                this.iNh.setBounds((this.iNd - (this.iNk / 2)) - 3, this.iNe, ((this.iNd - (this.iNk / 2)) - 3) + this.iNk, this.iNe + this.iNl);
                this.iNh.draw(canvas);
            } else {
                this.iNh.setBounds((this.iNd - (this.iNk / 2)) + 3, this.iNe, (this.iNd - (this.iNk / 2)) + 3 + this.iNk, this.iNe + this.iNl);
                this.iNh.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.iNh.setBounds(this.iNd - (this.iNk / 2), this.iNe, (this.iNd - (this.iNk / 2)) + this.iNk, this.iNe + this.iNl);
        this.iNh.draw(canvas);
    }

    private void G(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.iNo.iJK == 2) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.cp_other_b));
        }
        canvas.drawText(as.numberUniformFormat(this.iNo.iKA), this.iNi, this.iNb + dimensionPixelSize, this.paint);
        if (this.iNo.iJK == 1) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(as.numberUniformFormat(this.iNo.iKD), (this.width - this.iNi) - ((int) this.paint.measureText(as.numberUniformFormat(this.iNo.iKD))), dimensionPixelSize + this.iNb, this.paint);
    }

    private void cpH() {
        if (this.iNo == null) {
            this.iNf = ao.getDrawable(R.drawable.icon_pk_red_n);
            this.iNg = ao.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.iNo.iJK == 1) {
            this.iNf = ao.getDrawable(R.drawable.icon_pk_red_s);
            this.iNg = ao.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.iNo.iJK == 2) {
            this.iNg = ao.getDrawable(R.drawable.icon_pk_blule_s);
            this.iNf = ao.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.iNf = ao.getDrawable(R.drawable.icon_pk_red_n);
            this.iNg = ao.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
