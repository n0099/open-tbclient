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
/* loaded from: classes8.dex */
public class HotTopicPkView extends View {
    private int ds30;
    private boolean gag;
    private boolean isLeft;
    private int kxl;
    private int kxm;
    private int kxn;
    private int kxo;
    private Drawable kxp;
    private Drawable kxq;
    private Drawable kxr;
    private int kxs;
    private int kxt;
    private int kxu;
    private int kxv;
    private RectF kxw;
    private RectF kxx;
    private i kxy;
    private HotTopicActivity kxz;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gag = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gag = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gag = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cTH();
        this.kxr = ap.getDrawable(R.drawable.icon_pic_vs);
        this.kxs = this.kxp.getIntrinsicWidth();
        this.kxt = this.kxp.getIntrinsicHeight();
        this.kxu = this.kxr.getIntrinsicWidth();
        this.kxv = this.kxr.getIntrinsicHeight();
        this.kxw = new RectF(0.0f, 0.0f, this.kxs, this.kxt);
        this.kxo = (this.kxt - this.kxv) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.kxy = iVar;
            this.kxz = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kxy.ktU != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.kxw.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kxy.kuL++;
                    this.kxy.ktU = 1;
                } else if (this.kxx.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kxy.kuO++;
                    this.kxy.ktU = 2;
                }
                cTH();
                if (this.kxy.ktU != 0) {
                    if (this.kxy.kuL + this.kxy.kuO > 50) {
                        this.gag = true;
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
                                HotTopicPkView.this.gag = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.kxz.cSQ();
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
        this.kxl = this.kxt;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.kxl + this.ds30);
        this.kxm = (this.width - (this.kxs * 2)) - 100;
        if (this.kxx == null) {
            this.kxx = new RectF(this.width - this.kxs, 0.0f, this.width, this.kxl);
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
        if (this.kxy.kuL == 0 && this.kxy.kuO == 0) {
            this.kxn = (int) ((0.5d * this.kxm) + this.kxs + 50.0d);
        } else {
            this.kxn = (int) (((((float) this.kxy.kuL) / ((float) (this.kxy.kuL + this.kxy.kuO))) * this.kxm) + this.kxs + 50.0f);
        }
        if (this.kxy.ktU == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.kxs / 2.0f, this.kxo, this.kxn, this.kxl - this.kxo, this.paint);
        if (this.kxy.ktU == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.kxn, this.kxo, this.width - (this.kxs / 2.0f), this.kxl - this.kxo, this.paint);
    }

    private void ag(Canvas canvas) {
        cTH();
        this.kxp.setBounds(0, 0, this.kxs, this.kxt);
        this.kxp.draw(canvas);
        this.kxq.setBounds(this.width - this.kxs, 0, this.width, this.kxt);
        this.kxq.draw(canvas);
    }

    private void ah(Canvas canvas) {
        this.kxr = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.gag) {
            if (this.isLeft) {
                this.kxr.setBounds((this.kxn - (this.kxu / 2)) - 3, this.kxo, ((this.kxn - (this.kxu / 2)) - 3) + this.kxu, this.kxo + this.kxv);
                this.kxr.draw(canvas);
            } else {
                this.kxr.setBounds((this.kxn - (this.kxu / 2)) + 3, this.kxo, (this.kxn - (this.kxu / 2)) + 3 + this.kxu, this.kxo + this.kxv);
                this.kxr.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.kxr.setBounds(this.kxn - (this.kxu / 2), this.kxo, (this.kxn - (this.kxu / 2)) + this.kxu, this.kxo + this.kxv);
        this.kxr.draw(canvas);
    }

    private void J(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.kxy.ktU == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(au.numberUniformFormat(this.kxy.kuL), this.kxs, this.kxl + dimensionPixelSize, this.paint);
        if (this.kxy.ktU == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(au.numberUniformFormat(this.kxy.kuO), (this.width - this.kxs) - ((int) this.paint.measureText(au.numberUniformFormat(this.kxy.kuO))), dimensionPixelSize + this.kxl, this.paint);
    }

    private void cTH() {
        if (this.kxy == null) {
            this.kxp = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kxq = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.kxy.ktU == 1) {
            this.kxp = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.kxq = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.kxy.ktU == 2) {
            this.kxq = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.kxp = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.kxp = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kxq = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
