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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.i;
/* loaded from: classes7.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean fXQ;
    private boolean isLeft;
    private int kpe;
    private int kpf;
    private int kpg;
    private int kph;
    private Drawable kpi;
    private Drawable kpj;
    private Drawable kpk;
    private int kpl;
    private int kpm;
    private int kpn;
    private int kpo;
    private RectF kpp;
    private RectF kpq;
    private i kpr;
    private HotTopicActivity kps;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fXQ = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fXQ = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fXQ = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cRI();
        this.kpk = ao.getDrawable(R.drawable.icon_pic_vs);
        this.kpl = this.kpi.getIntrinsicWidth();
        this.kpm = this.kpi.getIntrinsicHeight();
        this.kpn = this.kpk.getIntrinsicWidth();
        this.kpo = this.kpk.getIntrinsicHeight();
        this.kpp = new RectF(0.0f, 0.0f, this.kpl, this.kpm);
        this.kph = (this.kpm - this.kpo) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.kpr = iVar;
            this.kps = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kpr.klN != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.kpp.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kpr.kmE++;
                    this.kpr.klN = 1;
                } else if (this.kpq.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kpr.kmH++;
                    this.kpr.klN = 2;
                }
                cRI();
                if (this.kpr.klN != 0) {
                    if (this.kpr.kmE + this.kpr.kmH > 50) {
                        this.fXQ = true;
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
                                HotTopicPkView.this.fXQ = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.kps.cQR();
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
        this.kpe = this.kpm;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.kpe + this.ds30);
        this.kpf = (this.width - (this.kpl * 2)) - 100;
        if (this.kpq == null) {
            this.kpq = new RectF(this.width - this.kpl, 0.0f, this.width, this.kpe);
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
        if (this.kpr.kmE == 0 && this.kpr.kmH == 0) {
            this.kpg = (int) ((0.5d * this.kpf) + this.kpl + 50.0d);
        } else {
            this.kpg = (int) (((((float) this.kpr.kmE) / ((float) (this.kpr.kmE + this.kpr.kmH))) * this.kpf) + this.kpl + 50.0f);
        }
        if (this.kpr.klN == 2) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.kpl / 2.0f, this.kph, this.kpg, this.kpe - this.kph, this.paint);
        if (this.kpr.klN == 1) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.kpg, this.kph, this.width - (this.kpl / 2.0f), this.kpe - this.kph, this.paint);
    }

    private void ag(Canvas canvas) {
        cRI();
        this.kpi.setBounds(0, 0, this.kpl, this.kpm);
        this.kpi.draw(canvas);
        this.kpj.setBounds(this.width - this.kpl, 0, this.width, this.kpm);
        this.kpj.draw(canvas);
    }

    private void ah(Canvas canvas) {
        this.kpk = ao.getDrawable(R.drawable.icon_pic_vs);
        if (this.fXQ) {
            if (this.isLeft) {
                this.kpk.setBounds((this.kpg - (this.kpn / 2)) - 3, this.kph, ((this.kpg - (this.kpn / 2)) - 3) + this.kpn, this.kph + this.kpo);
                this.kpk.draw(canvas);
            } else {
                this.kpk.setBounds((this.kpg - (this.kpn / 2)) + 3, this.kph, (this.kpg - (this.kpn / 2)) + 3 + this.kpn, this.kph + this.kpo);
                this.kpk.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.kpk.setBounds(this.kpg - (this.kpn / 2), this.kph, (this.kpg - (this.kpn / 2)) + this.kpn, this.kph + this.kpo);
        this.kpk.draw(canvas);
    }

    private void J(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.kpr.klN == 2) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(at.numberUniformFormat(this.kpr.kmE), this.kpl, this.kpe + dimensionPixelSize, this.paint);
        if (this.kpr.klN == 1) {
            this.paint.setColor(ao.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ao.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(at.numberUniformFormat(this.kpr.kmH), (this.width - this.kpl) - ((int) this.paint.measureText(at.numberUniformFormat(this.kpr.kmH))), dimensionPixelSize + this.kpe, this.paint);
    }

    private void cRI() {
        if (this.kpr == null) {
            this.kpi = ao.getDrawable(R.drawable.icon_pk_red_n);
            this.kpj = ao.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.kpr.klN == 1) {
            this.kpi = ao.getDrawable(R.drawable.icon_pk_red_s);
            this.kpj = ao.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.kpr.klN == 2) {
            this.kpj = ao.getDrawable(R.drawable.icon_pk_blule_s);
            this.kpi = ao.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.kpi = ao.getDrawable(R.drawable.icon_pk_red_n);
            this.kpj = ao.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
