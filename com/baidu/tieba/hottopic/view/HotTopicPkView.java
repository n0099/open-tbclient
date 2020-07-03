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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.i;
/* loaded from: classes8.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean eRi;
    private int iGW;
    private int iGX;
    private int iGY;
    private int iGZ;
    private Drawable iHa;
    private Drawable iHb;
    private Drawable iHc;
    private int iHd;
    private int iHe;
    private int iHf;
    private int iHg;
    private RectF iHh;
    private RectF iHi;
    private i iHj;
    private HotTopicActivity iHk;
    private boolean isLeft;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eRi = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eRi = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eRi = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cmg();
        this.iHc = an.getDrawable(R.drawable.icon_pic_vs);
        this.iHd = this.iHa.getIntrinsicWidth();
        this.iHe = this.iHa.getIntrinsicHeight();
        this.iHf = this.iHc.getIntrinsicWidth();
        this.iHg = this.iHc.getIntrinsicHeight();
        this.iHh = new RectF(0.0f, 0.0f, this.iHd, this.iHe);
        this.iGZ = (this.iHe - this.iHg) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.iHj = iVar;
            this.iHk = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.iHj.iDG != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.iHh.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.iHj.iEw++;
                    this.iHj.iDG = 1;
                } else if (this.iHi.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.iHj.iEz++;
                    this.iHj.iDG = 2;
                }
                cmg();
                if (this.iHj.iDG != 0) {
                    if (this.iHj.iEw + this.iHj.iEz > 50) {
                        this.eRi = true;
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
                                HotTopicPkView.this.eRi = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.iHk.cln();
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
        this.iGW = this.iHe;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.iGW + this.ds30);
        this.iGX = (this.width - (this.iHd * 2)) - 100;
        if (this.iHi == null) {
            this.iHi = new RectF(this.width - this.iHd, 0.0f, this.width, this.iGW);
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
        if (this.iHj.iEw == 0 && this.iHj.iEz == 0) {
            this.iGY = (int) ((0.5d * this.iGX) + this.iHd + 50.0d);
        } else {
            this.iGY = (int) (((((float) this.iHj.iEw) / ((float) (this.iHj.iEw + this.iHj.iEz))) * this.iGX) + this.iHd + 50.0f);
        }
        if (this.iHj.iDG == 2) {
            this.paint.setColor(an.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(an.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.iHd / 2.0f, this.iGZ, this.iGY, this.iGW - this.iGZ, this.paint);
        if (this.iHj.iDG == 1) {
            this.paint.setColor(an.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(an.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.iGY, this.iGZ, this.width - (this.iHd / 2.0f), this.iGW - this.iGZ, this.paint);
    }

    private void P(Canvas canvas) {
        cmg();
        this.iHa.setBounds(0, 0, this.iHd, this.iHe);
        this.iHa.draw(canvas);
        this.iHb.setBounds(this.width - this.iHd, 0, this.width, this.iHe);
        this.iHb.draw(canvas);
    }

    private void Q(Canvas canvas) {
        this.iHc = an.getDrawable(R.drawable.icon_pic_vs);
        if (this.eRi) {
            if (this.isLeft) {
                this.iHc.setBounds((this.iGY - (this.iHf / 2)) - 3, this.iGZ, ((this.iGY - (this.iHf / 2)) - 3) + this.iHf, this.iGZ + this.iHg);
                this.iHc.draw(canvas);
            } else {
                this.iHc.setBounds((this.iGY - (this.iHf / 2)) + 3, this.iGZ, (this.iGY - (this.iHf / 2)) + 3 + this.iHf, this.iGZ + this.iHg);
                this.iHc.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.iHc.setBounds(this.iGY - (this.iHf / 2), this.iGZ, (this.iGY - (this.iHf / 2)) + this.iHf, this.iGZ + this.iHg);
        this.iHc.draw(canvas);
    }

    private void G(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.iHj.iDG == 2) {
            this.paint.setColor(an.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(an.getColor(R.color.cp_other_b));
        }
        canvas.drawText(ar.numberUniformFormat(this.iHj.iEw), this.iHd, this.iGW + dimensionPixelSize, this.paint);
        if (this.iHj.iDG == 1) {
            this.paint.setColor(an.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(an.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(ar.numberUniformFormat(this.iHj.iEz), (this.width - this.iHd) - ((int) this.paint.measureText(ar.numberUniformFormat(this.iHj.iEz))), dimensionPixelSize + this.iGW, this.paint);
    }

    private void cmg() {
        if (this.iHj == null) {
            this.iHa = an.getDrawable(R.drawable.icon_pk_red_n);
            this.iHb = an.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.iHj.iDG == 1) {
            this.iHa = an.getDrawable(R.drawable.icon_pk_red_s);
            this.iHb = an.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.iHj.iDG == 2) {
            this.iHb = an.getDrawable(R.drawable.icon_pk_blule_s);
            this.iHa = an.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.iHa = an.getDrawable(R.drawable.icon_pk_red_n);
            this.iHb = an.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
