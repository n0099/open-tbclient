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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.i;
/* loaded from: classes7.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean gbH;
    private boolean isLeft;
    private int kzB;
    private int kzC;
    private int kzD;
    private int kzE;
    private Drawable kzF;
    private Drawable kzG;
    private Drawable kzH;
    private int kzI;
    private int kzJ;
    private int kzK;
    private int kzL;
    private RectF kzM;
    private RectF kzN;
    private i kzO;
    private HotTopicActivity kzP;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gbH = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gbH = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gbH = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cTV();
        this.kzH = ap.getDrawable(R.drawable.icon_pic_vs);
        this.kzI = this.kzF.getIntrinsicWidth();
        this.kzJ = this.kzF.getIntrinsicHeight();
        this.kzK = this.kzH.getIntrinsicWidth();
        this.kzL = this.kzH.getIntrinsicHeight();
        this.kzM = new RectF(0.0f, 0.0f, this.kzI, this.kzJ);
        this.kzE = (this.kzJ - this.kzL) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.kzO = iVar;
            this.kzP = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kzO.kwk != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.kzM.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kzO.kxb++;
                    this.kzO.kwk = 1;
                } else if (this.kzN.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kzO.kxe++;
                    this.kzO.kwk = 2;
                }
                cTV();
                if (this.kzO.kwk != 0) {
                    if (this.kzO.kxb + this.kzO.kxe > 50) {
                        this.gbH = true;
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
                                HotTopicPkView.this.gbH = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.kzP.cTe();
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
        this.kzB = this.kzJ;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.kzB + this.ds30);
        this.kzC = (this.width - (this.kzI * 2)) - 100;
        if (this.kzN == null) {
            this.kzN = new RectF(this.width - this.kzI, 0.0f, this.width, this.kzB);
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
        if (this.kzO.kxb == 0 && this.kzO.kxe == 0) {
            this.kzD = (int) ((0.5d * this.kzC) + this.kzI + 50.0d);
        } else {
            this.kzD = (int) (((((float) this.kzO.kxb) / ((float) (this.kzO.kxb + this.kzO.kxe))) * this.kzC) + this.kzI + 50.0f);
        }
        if (this.kzO.kwk == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.kzI / 2.0f, this.kzE, this.kzD, this.kzB - this.kzE, this.paint);
        if (this.kzO.kwk == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.kzD, this.kzE, this.width - (this.kzI / 2.0f), this.kzB - this.kzE, this.paint);
    }

    private void ag(Canvas canvas) {
        cTV();
        this.kzF.setBounds(0, 0, this.kzI, this.kzJ);
        this.kzF.draw(canvas);
        this.kzG.setBounds(this.width - this.kzI, 0, this.width, this.kzJ);
        this.kzG.draw(canvas);
    }

    private void ah(Canvas canvas) {
        this.kzH = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.gbH) {
            if (this.isLeft) {
                this.kzH.setBounds((this.kzD - (this.kzK / 2)) - 3, this.kzE, ((this.kzD - (this.kzK / 2)) - 3) + this.kzK, this.kzE + this.kzL);
                this.kzH.draw(canvas);
            } else {
                this.kzH.setBounds((this.kzD - (this.kzK / 2)) + 3, this.kzE, (this.kzD - (this.kzK / 2)) + 3 + this.kzK, this.kzE + this.kzL);
                this.kzH.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.kzH.setBounds(this.kzD - (this.kzK / 2), this.kzE, (this.kzD - (this.kzK / 2)) + this.kzK, this.kzE + this.kzL);
        this.kzH.draw(canvas);
    }

    private void J(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.kzO.kwk == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(au.numberUniformFormat(this.kzO.kxb), this.kzI, this.kzB + dimensionPixelSize, this.paint);
        if (this.kzO.kwk == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(au.numberUniformFormat(this.kzO.kxe), (this.width - this.kzI) - ((int) this.paint.measureText(au.numberUniformFormat(this.kzO.kxe))), dimensionPixelSize + this.kzB, this.paint);
    }

    private void cTV() {
        if (this.kzO == null) {
            this.kzF = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kzG = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.kzO.kwk == 1) {
            this.kzF = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.kzG = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.kzO.kwk == 2) {
            this.kzG = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.kzF = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.kzF = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kzG = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
