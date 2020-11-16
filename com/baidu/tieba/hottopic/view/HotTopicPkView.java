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
/* loaded from: classes20.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean fLl;
    private boolean isLeft;
    private int jSR;
    private int jSS;
    private int jST;
    private int jSU;
    private Drawable jSV;
    private Drawable jSW;
    private Drawable jSX;
    private int jSY;
    private int jSZ;
    private int jTa;
    private int jTb;
    private RectF jTc;
    private RectF jTd;
    private i jTe;
    private HotTopicActivity jTf;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fLl = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fLl = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fLl = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cNe();
        this.jSX = ap.getDrawable(R.drawable.icon_pic_vs);
        this.jSY = this.jSV.getIntrinsicWidth();
        this.jSZ = this.jSV.getIntrinsicHeight();
        this.jTa = this.jSX.getIntrinsicWidth();
        this.jTb = this.jSX.getIntrinsicHeight();
        this.jTc = new RectF(0.0f, 0.0f, this.jSY, this.jSZ);
        this.jSU = (this.jSZ - this.jTb) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.jTe = iVar;
            this.jTf = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jTe.jPB != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jTc.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jTe.jQr++;
                    this.jTe.jPB = 1;
                } else if (this.jTd.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jTe.jQu++;
                    this.jTe.jPB = 2;
                }
                cNe();
                if (this.jTe.jPB != 0) {
                    if (this.jTe.jQr + this.jTe.jQu > 50) {
                        this.fLl = true;
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
                                HotTopicPkView.this.fLl = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.jTf.cMn();
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
        this.jSR = this.jSZ;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.jSR + this.ds30);
        this.jSS = (this.width - (this.jSY * 2)) - 100;
        if (this.jTd == null) {
            this.jTd = new RectF(this.width - this.jSY, 0.0f, this.width, this.jSR);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Z(canvas);
        aa(canvas);
        ab(canvas);
        C(canvas);
    }

    private void Z(Canvas canvas) {
        if (this.jTe.jQr == 0 && this.jTe.jQu == 0) {
            this.jST = (int) ((0.5d * this.jSS) + this.jSY + 50.0d);
        } else {
            this.jST = (int) (((((float) this.jTe.jQr) / ((float) (this.jTe.jQr + this.jTe.jQu))) * this.jSS) + this.jSY + 50.0f);
        }
        if (this.jTe.jPB == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.jSY / 2.0f, this.jSU, this.jST, this.jSR - this.jSU, this.paint);
        if (this.jTe.jPB == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.jST, this.jSU, this.width - (this.jSY / 2.0f), this.jSR - this.jSU, this.paint);
    }

    private void aa(Canvas canvas) {
        cNe();
        this.jSV.setBounds(0, 0, this.jSY, this.jSZ);
        this.jSV.draw(canvas);
        this.jSW.setBounds(this.width - this.jSY, 0, this.width, this.jSZ);
        this.jSW.draw(canvas);
    }

    private void ab(Canvas canvas) {
        this.jSX = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.fLl) {
            if (this.isLeft) {
                this.jSX.setBounds((this.jST - (this.jTa / 2)) - 3, this.jSU, ((this.jST - (this.jTa / 2)) - 3) + this.jTa, this.jSU + this.jTb);
                this.jSX.draw(canvas);
            } else {
                this.jSX.setBounds((this.jST - (this.jTa / 2)) + 3, this.jSU, (this.jST - (this.jTa / 2)) + 3 + this.jTa, this.jSU + this.jTb);
                this.jSX.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.jSX.setBounds(this.jST - (this.jTa / 2), this.jSU, (this.jST - (this.jTa / 2)) + this.jTa, this.jSU + this.jTb);
        this.jSX.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.jTe.jPB == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(au.numberUniformFormat(this.jTe.jQr), this.jSY, this.jSR + dimensionPixelSize, this.paint);
        if (this.jTe.jPB == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(au.numberUniformFormat(this.jTe.jQu), (this.width - this.jSY) - ((int) this.paint.measureText(au.numberUniformFormat(this.jTe.jQu))), dimensionPixelSize + this.jSR, this.paint);
    }

    private void cNe() {
        if (this.jTe == null) {
            this.jSV = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jSW = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.jTe.jPB == 1) {
            this.jSV = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.jSW = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.jTe.jPB == 2) {
            this.jSW = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.jSV = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.jSV = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jSW = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
