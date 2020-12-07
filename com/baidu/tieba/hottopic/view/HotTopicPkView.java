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
    private Drawable kgA;
    private Drawable kgB;
    private int kgC;
    private int kgD;
    private int kgE;
    private int kgF;
    private RectF kgG;
    private RectF kgH;
    private i kgI;
    private HotTopicActivity kgJ;
    private int kgv;
    private int kgw;
    private int kgx;
    private int kgy;
    private Drawable kgz;
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
        cSs();
        this.kgB = ap.getDrawable(R.drawable.icon_pic_vs);
        this.kgC = this.kgz.getIntrinsicWidth();
        this.kgD = this.kgz.getIntrinsicHeight();
        this.kgE = this.kgB.getIntrinsicWidth();
        this.kgF = this.kgB.getIntrinsicHeight();
        this.kgG = new RectF(0.0f, 0.0f, this.kgC, this.kgD);
        this.kgy = (this.kgD - this.kgF) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.kgI = iVar;
            this.kgJ = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kgI.kde != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.kgG.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kgI.kdU++;
                    this.kgI.kde = 1;
                } else if (this.kgH.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kgI.kdX++;
                    this.kgI.kde = 2;
                }
                cSs();
                if (this.kgI.kde != 0) {
                    if (this.kgI.kdU + this.kgI.kdX > 50) {
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
                    this.kgJ.cRB();
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
        this.kgv = this.kgD;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.kgv + this.ds30);
        this.kgw = (this.width - (this.kgC * 2)) - 100;
        if (this.kgH == null) {
            this.kgH = new RectF(this.width - this.kgC, 0.0f, this.width, this.kgv);
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
        if (this.kgI.kdU == 0 && this.kgI.kdX == 0) {
            this.kgx = (int) ((0.5d * this.kgw) + this.kgC + 50.0d);
        } else {
            this.kgx = (int) (((((float) this.kgI.kdU) / ((float) (this.kgI.kdU + this.kgI.kdX))) * this.kgw) + this.kgC + 50.0f);
        }
        if (this.kgI.kde == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.kgC / 2.0f, this.kgy, this.kgx, this.kgv - this.kgy, this.paint);
        if (this.kgI.kde == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.kgx, this.kgy, this.width - (this.kgC / 2.0f), this.kgv - this.kgy, this.paint);
    }

    private void aa(Canvas canvas) {
        cSs();
        this.kgz.setBounds(0, 0, this.kgC, this.kgD);
        this.kgz.draw(canvas);
        this.kgA.setBounds(this.width - this.kgC, 0, this.width, this.kgD);
        this.kgA.draw(canvas);
    }

    private void ab(Canvas canvas) {
        this.kgB = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.fSW) {
            if (this.isLeft) {
                this.kgB.setBounds((this.kgx - (this.kgE / 2)) - 3, this.kgy, ((this.kgx - (this.kgE / 2)) - 3) + this.kgE, this.kgy + this.kgF);
                this.kgB.draw(canvas);
            } else {
                this.kgB.setBounds((this.kgx - (this.kgE / 2)) + 3, this.kgy, (this.kgx - (this.kgE / 2)) + 3 + this.kgE, this.kgy + this.kgF);
                this.kgB.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.kgB.setBounds(this.kgx - (this.kgE / 2), this.kgy, (this.kgx - (this.kgE / 2)) + this.kgE, this.kgy + this.kgF);
        this.kgB.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.kgI.kde == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(au.numberUniformFormat(this.kgI.kdU), this.kgC, this.kgv + dimensionPixelSize, this.paint);
        if (this.kgI.kde == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(au.numberUniformFormat(this.kgI.kdX), (this.width - this.kgC) - ((int) this.paint.measureText(au.numberUniformFormat(this.kgI.kdX))), dimensionPixelSize + this.kgv, this.paint);
    }

    private void cSs() {
        if (this.kgI == null) {
            this.kgz = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kgA = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.kgI.kde == 1) {
            this.kgz = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.kgA = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.kgI.kde == 2) {
            this.kgA = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.kgz = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.kgz = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kgA = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
