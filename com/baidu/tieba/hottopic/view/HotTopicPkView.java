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
/* loaded from: classes21.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean fSW;
    private boolean isLeft;
    private int kgA;
    private Drawable kgB;
    private Drawable kgC;
    private Drawable kgD;
    private int kgE;
    private int kgF;
    private int kgG;
    private int kgH;
    private RectF kgI;
    private RectF kgJ;
    private i kgK;
    private HotTopicActivity kgL;
    private int kgx;
    private int kgy;
    private int kgz;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fSW = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fSW = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fSW = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cSt();
        this.kgD = ap.getDrawable(R.drawable.icon_pic_vs);
        this.kgE = this.kgB.getIntrinsicWidth();
        this.kgF = this.kgB.getIntrinsicHeight();
        this.kgG = this.kgD.getIntrinsicWidth();
        this.kgH = this.kgD.getIntrinsicHeight();
        this.kgI = new RectF(0.0f, 0.0f, this.kgE, this.kgF);
        this.kgA = (this.kgF - this.kgH) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.kgK = iVar;
            this.kgL = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kgK.kdg != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.kgI.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kgK.kdW++;
                    this.kgK.kdg = 1;
                } else if (this.kgJ.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kgK.kdZ++;
                    this.kgK.kdg = 2;
                }
                cSt();
                if (this.kgK.kdg != 0) {
                    if (this.kgK.kdW + this.kgK.kdZ > 50) {
                        this.fSW = true;
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
                                HotTopicPkView.this.fSW = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.kgL.cRC();
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
        this.kgx = this.kgF;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.kgx + this.ds30);
        this.kgy = (this.width - (this.kgE * 2)) - 100;
        if (this.kgJ == null) {
            this.kgJ = new RectF(this.width - this.kgE, 0.0f, this.width, this.kgx);
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
        if (this.kgK.kdW == 0 && this.kgK.kdZ == 0) {
            this.kgz = (int) ((0.5d * this.kgy) + this.kgE + 50.0d);
        } else {
            this.kgz = (int) (((((float) this.kgK.kdW) / ((float) (this.kgK.kdW + this.kgK.kdZ))) * this.kgy) + this.kgE + 50.0f);
        }
        if (this.kgK.kdg == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.kgE / 2.0f, this.kgA, this.kgz, this.kgx - this.kgA, this.paint);
        if (this.kgK.kdg == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.kgz, this.kgA, this.width - (this.kgE / 2.0f), this.kgx - this.kgA, this.paint);
    }

    private void aa(Canvas canvas) {
        cSt();
        this.kgB.setBounds(0, 0, this.kgE, this.kgF);
        this.kgB.draw(canvas);
        this.kgC.setBounds(this.width - this.kgE, 0, this.width, this.kgF);
        this.kgC.draw(canvas);
    }

    private void ab(Canvas canvas) {
        this.kgD = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.fSW) {
            if (this.isLeft) {
                this.kgD.setBounds((this.kgz - (this.kgG / 2)) - 3, this.kgA, ((this.kgz - (this.kgG / 2)) - 3) + this.kgG, this.kgA + this.kgH);
                this.kgD.draw(canvas);
            } else {
                this.kgD.setBounds((this.kgz - (this.kgG / 2)) + 3, this.kgA, (this.kgz - (this.kgG / 2)) + 3 + this.kgG, this.kgA + this.kgH);
                this.kgD.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.kgD.setBounds(this.kgz - (this.kgG / 2), this.kgA, (this.kgz - (this.kgG / 2)) + this.kgG, this.kgA + this.kgH);
        this.kgD.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.kgK.kdg == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(au.numberUniformFormat(this.kgK.kdW), this.kgE, this.kgx + dimensionPixelSize, this.paint);
        if (this.kgK.kdg == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(au.numberUniformFormat(this.kgK.kdZ), (this.width - this.kgE) - ((int) this.paint.measureText(au.numberUniformFormat(this.kgK.kdZ))), dimensionPixelSize + this.kgx, this.paint);
    }

    private void cSt() {
        if (this.kgK == null) {
            this.kgB = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kgC = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.kgK.kdg == 1) {
            this.kgB = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.kgC = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.kgK.kdg == 2) {
            this.kgC = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.kgB = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.kgB = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kgC = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
