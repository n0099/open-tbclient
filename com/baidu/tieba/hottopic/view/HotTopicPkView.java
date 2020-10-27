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
    private boolean fFS;
    private boolean isLeft;
    private int jMk;
    private int jMl;
    private int jMm;
    private int jMn;
    private Drawable jMo;
    private Drawable jMp;
    private Drawable jMq;
    private int jMr;
    private int jMs;
    private int jMt;
    private int jMu;
    private RectF jMv;
    private RectF jMw;
    private i jMx;
    private HotTopicActivity jMy;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fFS = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fFS = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fFS = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cKX();
        this.jMq = ap.getDrawable(R.drawable.icon_pic_vs);
        this.jMr = this.jMo.getIntrinsicWidth();
        this.jMs = this.jMo.getIntrinsicHeight();
        this.jMt = this.jMq.getIntrinsicWidth();
        this.jMu = this.jMq.getIntrinsicHeight();
        this.jMv = new RectF(0.0f, 0.0f, this.jMr, this.jMs);
        this.jMn = (this.jMs - this.jMu) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.jMx = iVar;
            this.jMy = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jMx.jIT != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jMv.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jMx.jJJ++;
                    this.jMx.jIT = 1;
                } else if (this.jMw.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jMx.jJM++;
                    this.jMx.jIT = 2;
                }
                cKX();
                if (this.jMx.jIT != 0) {
                    if (this.jMx.jJJ + this.jMx.jJM > 50) {
                        this.fFS = true;
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
                                HotTopicPkView.this.fFS = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.jMy.cKf();
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
        this.jMk = this.jMs;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.jMk + this.ds30);
        this.jMl = (this.width - (this.jMr * 2)) - 100;
        if (this.jMw == null) {
            this.jMw = new RectF(this.width - this.jMr, 0.0f, this.width, this.jMk);
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
        if (this.jMx.jJJ == 0 && this.jMx.jJM == 0) {
            this.jMm = (int) ((0.5d * this.jMl) + this.jMr + 50.0d);
        } else {
            this.jMm = (int) (((((float) this.jMx.jJJ) / ((float) (this.jMx.jJJ + this.jMx.jJM))) * this.jMl) + this.jMr + 50.0f);
        }
        if (this.jMx.jIT == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.jMr / 2.0f, this.jMn, this.jMm, this.jMk - this.jMn, this.paint);
        if (this.jMx.jIT == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.jMm, this.jMn, this.width - (this.jMr / 2.0f), this.jMk - this.jMn, this.paint);
    }

    private void X(Canvas canvas) {
        cKX();
        this.jMo.setBounds(0, 0, this.jMr, this.jMs);
        this.jMo.draw(canvas);
        this.jMp.setBounds(this.width - this.jMr, 0, this.width, this.jMs);
        this.jMp.draw(canvas);
    }

    private void Y(Canvas canvas) {
        this.jMq = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.fFS) {
            if (this.isLeft) {
                this.jMq.setBounds((this.jMm - (this.jMt / 2)) - 3, this.jMn, ((this.jMm - (this.jMt / 2)) - 3) + this.jMt, this.jMn + this.jMu);
                this.jMq.draw(canvas);
            } else {
                this.jMq.setBounds((this.jMm - (this.jMt / 2)) + 3, this.jMn, (this.jMm - (this.jMt / 2)) + 3 + this.jMt, this.jMn + this.jMu);
                this.jMq.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.jMq.setBounds(this.jMm - (this.jMt / 2), this.jMn, (this.jMm - (this.jMt / 2)) + this.jMt, this.jMn + this.jMu);
        this.jMq.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.jMx.jIT == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawText(at.numberUniformFormat(this.jMx.jJJ), this.jMr, this.jMk + dimensionPixelSize, this.paint);
        if (this.jMx.jIT == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(at.numberUniformFormat(this.jMx.jJM), (this.width - this.jMr) - ((int) this.paint.measureText(at.numberUniformFormat(this.jMx.jJM))), dimensionPixelSize + this.jMk, this.paint);
    }

    private void cKX() {
        if (this.jMx == null) {
            this.jMo = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jMp = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.jMx.jIT == 1) {
            this.jMo = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.jMp = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.jMx.jIT == 2) {
            this.jMp = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.jMo = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.jMo = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jMp = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
