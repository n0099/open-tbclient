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
/* loaded from: classes15.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean fir;
    private boolean isLeft;
    private int jch;
    private int jci;
    private int jcj;
    private int jck;
    private Drawable jcl;
    private Drawable jcm;
    private Drawable jcn;
    private int jco;
    private int jcp;
    private int jcq;
    private int jcr;
    private RectF jcs;
    private RectF jct;
    private i jcu;
    private HotTopicActivity jcv;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fir = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fir = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fir = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cAA();
        this.jcn = ap.getDrawable(R.drawable.icon_pic_vs);
        this.jco = this.jcl.getIntrinsicWidth();
        this.jcp = this.jcl.getIntrinsicHeight();
        this.jcq = this.jcn.getIntrinsicWidth();
        this.jcr = this.jcn.getIntrinsicHeight();
        this.jcs = new RectF(0.0f, 0.0f, this.jco, this.jcp);
        this.jck = (this.jcp - this.jcr) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.jcu = iVar;
            this.jcv = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jcu.iYQ != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jcs.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jcu.iZG++;
                    this.jcu.iYQ = 1;
                } else if (this.jct.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jcu.iZJ++;
                    this.jcu.iYQ = 2;
                }
                cAA();
                if (this.jcu.iYQ != 0) {
                    if (this.jcu.iZG + this.jcu.iZJ > 50) {
                        this.fir = true;
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
                                HotTopicPkView.this.fir = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.jcv.czI();
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
        this.jch = this.jcp;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.jch + this.ds30);
        this.jci = (this.width - (this.jco * 2)) - 100;
        if (this.jct == null) {
            this.jct = new RectF(this.width - this.jco, 0.0f, this.width, this.jch);
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
        if (this.jcu.iZG == 0 && this.jcu.iZJ == 0) {
            this.jcj = (int) ((0.5d * this.jci) + this.jco + 50.0d);
        } else {
            this.jcj = (int) (((((float) this.jcu.iZG) / ((float) (this.jcu.iZG + this.jcu.iZJ))) * this.jci) + this.jco + 50.0f);
        }
        if (this.jcu.iYQ == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.jco / 2.0f, this.jck, this.jcj, this.jch - this.jck, this.paint);
        if (this.jcu.iYQ == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.jcj, this.jck, this.width - (this.jco / 2.0f), this.jch - this.jck, this.paint);
    }

    private void W(Canvas canvas) {
        cAA();
        this.jcl.setBounds(0, 0, this.jco, this.jcp);
        this.jcl.draw(canvas);
        this.jcm.setBounds(this.width - this.jco, 0, this.width, this.jcp);
        this.jcm.draw(canvas);
    }

    private void X(Canvas canvas) {
        this.jcn = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.fir) {
            if (this.isLeft) {
                this.jcn.setBounds((this.jcj - (this.jcq / 2)) - 3, this.jck, ((this.jcj - (this.jcq / 2)) - 3) + this.jcq, this.jck + this.jcr);
                this.jcn.draw(canvas);
            } else {
                this.jcn.setBounds((this.jcj - (this.jcq / 2)) + 3, this.jck, (this.jcj - (this.jcq / 2)) + 3 + this.jcq, this.jck + this.jcr);
                this.jcn.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.jcn.setBounds(this.jcj - (this.jcq / 2), this.jck, (this.jcj - (this.jcq / 2)) + this.jcq, this.jck + this.jcr);
        this.jcn.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.jcu.iYQ == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawText(at.numberUniformFormat(this.jcu.iZG), this.jco, this.jch + dimensionPixelSize, this.paint);
        if (this.jcu.iYQ == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(at.numberUniformFormat(this.jcu.iZJ), (this.width - this.jco) - ((int) this.paint.measureText(at.numberUniformFormat(this.jcu.iZJ))), dimensionPixelSize + this.jch, this.paint);
    }

    private void cAA() {
        if (this.jcu == null) {
            this.jcl = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jcm = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.jcu.iYQ == 1) {
            this.jcl = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.jcm = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.jcu.iYQ == 2) {
            this.jcm = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.jcl = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.jcl = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jcm = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
