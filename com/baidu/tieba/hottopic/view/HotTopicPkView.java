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
/* loaded from: classes21.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean fxx;
    private boolean isLeft;
    private int jzL;
    private int jzM;
    private int jzN;
    private int jzO;
    private Drawable jzP;
    private Drawable jzQ;
    private Drawable jzR;
    private int jzS;
    private int jzT;
    private int jzU;
    private int jzV;
    private RectF jzW;
    private RectF jzX;
    private i jzY;
    private HotTopicActivity jzZ;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fxx = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fxx = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fxx = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cHQ();
        this.jzR = ap.getDrawable(R.drawable.icon_pic_vs);
        this.jzS = this.jzP.getIntrinsicWidth();
        this.jzT = this.jzP.getIntrinsicHeight();
        this.jzU = this.jzR.getIntrinsicWidth();
        this.jzV = this.jzR.getIntrinsicHeight();
        this.jzW = new RectF(0.0f, 0.0f, this.jzS, this.jzT);
        this.jzO = (this.jzT - this.jzV) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.jzY = iVar;
            this.jzZ = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jzY.jwu != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jzW.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jzY.jxk++;
                    this.jzY.jwu = 1;
                } else if (this.jzX.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jzY.jxn++;
                    this.jzY.jwu = 2;
                }
                cHQ();
                if (this.jzY.jwu != 0) {
                    if (this.jzY.jxk + this.jzY.jxn > 50) {
                        this.fxx = true;
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
                                HotTopicPkView.this.fxx = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.jzZ.cGY();
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
        this.jzL = this.jzT;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.jzL + this.ds30);
        this.jzM = (this.width - (this.jzS * 2)) - 100;
        if (this.jzX == null) {
            this.jzX = new RectF(this.width - this.jzS, 0.0f, this.width, this.jzL);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        W(canvas);
        X(canvas);
        Y(canvas);
        C(canvas);
    }

    private void W(Canvas canvas) {
        if (this.jzY.jxk == 0 && this.jzY.jxn == 0) {
            this.jzN = (int) ((0.5d * this.jzM) + this.jzS + 50.0d);
        } else {
            this.jzN = (int) (((((float) this.jzY.jxk) / ((float) (this.jzY.jxk + this.jzY.jxn))) * this.jzM) + this.jzS + 50.0f);
        }
        if (this.jzY.jwu == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.jzS / 2.0f, this.jzO, this.jzN, this.jzL - this.jzO, this.paint);
        if (this.jzY.jwu == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.jzN, this.jzO, this.width - (this.jzS / 2.0f), this.jzL - this.jzO, this.paint);
    }

    private void X(Canvas canvas) {
        cHQ();
        this.jzP.setBounds(0, 0, this.jzS, this.jzT);
        this.jzP.draw(canvas);
        this.jzQ.setBounds(this.width - this.jzS, 0, this.width, this.jzT);
        this.jzQ.draw(canvas);
    }

    private void Y(Canvas canvas) {
        this.jzR = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.fxx) {
            if (this.isLeft) {
                this.jzR.setBounds((this.jzN - (this.jzU / 2)) - 3, this.jzO, ((this.jzN - (this.jzU / 2)) - 3) + this.jzU, this.jzO + this.jzV);
                this.jzR.draw(canvas);
            } else {
                this.jzR.setBounds((this.jzN - (this.jzU / 2)) + 3, this.jzO, (this.jzN - (this.jzU / 2)) + 3 + this.jzU, this.jzO + this.jzV);
                this.jzR.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.jzR.setBounds(this.jzN - (this.jzU / 2), this.jzO, (this.jzN - (this.jzU / 2)) + this.jzU, this.jzO + this.jzV);
        this.jzR.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.jzY.jwu == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawText(at.numberUniformFormat(this.jzY.jxk), this.jzS, this.jzL + dimensionPixelSize, this.paint);
        if (this.jzY.jwu == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(at.numberUniformFormat(this.jzY.jxn), (this.width - this.jzS) - ((int) this.paint.measureText(at.numberUniformFormat(this.jzY.jxn))), dimensionPixelSize + this.jzL, this.paint);
    }

    private void cHQ() {
        if (this.jzY == null) {
            this.jzP = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jzQ = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.jzY.jwu == 1) {
            this.jzP = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.jzQ = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.jzY.jwu == 2) {
            this.jzQ = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.jzP = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.jzP = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jzQ = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
