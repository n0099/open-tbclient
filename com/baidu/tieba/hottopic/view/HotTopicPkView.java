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
    private boolean fLI;
    private boolean isLeft;
    private int jSh;
    private int jSi;
    private int jSj;
    private int jSk;
    private Drawable jSl;
    private Drawable jSm;
    private Drawable jSn;
    private int jSo;
    private int jSp;
    private int jSq;
    private int jSr;
    private RectF jSs;
    private RectF jSt;
    private i jSu;
    private HotTopicActivity jSv;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fLI = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fLI = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fLI = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cNy();
        this.jSn = ap.getDrawable(R.drawable.icon_pic_vs);
        this.jSo = this.jSl.getIntrinsicWidth();
        this.jSp = this.jSl.getIntrinsicHeight();
        this.jSq = this.jSn.getIntrinsicWidth();
        this.jSr = this.jSn.getIntrinsicHeight();
        this.jSs = new RectF(0.0f, 0.0f, this.jSo, this.jSp);
        this.jSk = (this.jSp - this.jSr) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.jSu = iVar;
            this.jSv = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jSu.jOR != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jSs.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jSu.jPH++;
                    this.jSu.jOR = 1;
                } else if (this.jSt.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jSu.jPK++;
                    this.jSu.jOR = 2;
                }
                cNy();
                if (this.jSu.jOR != 0) {
                    if (this.jSu.jPH + this.jSu.jPK > 50) {
                        this.fLI = true;
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
                                HotTopicPkView.this.fLI = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.jSv.cMG();
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
        this.jSh = this.jSp;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.jSh + this.ds30);
        this.jSi = (this.width - (this.jSo * 2)) - 100;
        if (this.jSt == null) {
            this.jSt = new RectF(this.width - this.jSo, 0.0f, this.width, this.jSh);
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
        if (this.jSu.jPH == 0 && this.jSu.jPK == 0) {
            this.jSj = (int) ((0.5d * this.jSi) + this.jSo + 50.0d);
        } else {
            this.jSj = (int) (((((float) this.jSu.jPH) / ((float) (this.jSu.jPH + this.jSu.jPK))) * this.jSi) + this.jSo + 50.0f);
        }
        if (this.jSu.jOR == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.jSo / 2.0f, this.jSk, this.jSj, this.jSh - this.jSk, this.paint);
        if (this.jSu.jOR == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.jSj, this.jSk, this.width - (this.jSo / 2.0f), this.jSh - this.jSk, this.paint);
    }

    private void X(Canvas canvas) {
        cNy();
        this.jSl.setBounds(0, 0, this.jSo, this.jSp);
        this.jSl.draw(canvas);
        this.jSm.setBounds(this.width - this.jSo, 0, this.width, this.jSp);
        this.jSm.draw(canvas);
    }

    private void Y(Canvas canvas) {
        this.jSn = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.fLI) {
            if (this.isLeft) {
                this.jSn.setBounds((this.jSj - (this.jSq / 2)) - 3, this.jSk, ((this.jSj - (this.jSq / 2)) - 3) + this.jSq, this.jSk + this.jSr);
                this.jSn.draw(canvas);
            } else {
                this.jSn.setBounds((this.jSj - (this.jSq / 2)) + 3, this.jSk, (this.jSj - (this.jSq / 2)) + 3 + this.jSq, this.jSk + this.jSr);
                this.jSn.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.jSn.setBounds(this.jSj - (this.jSq / 2), this.jSk, (this.jSj - (this.jSq / 2)) + this.jSq, this.jSk + this.jSr);
        this.jSn.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.jSu.jOR == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawText(at.numberUniformFormat(this.jSu.jPH), this.jSo, this.jSh + dimensionPixelSize, this.paint);
        if (this.jSu.jOR == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(at.numberUniformFormat(this.jSu.jPK), (this.width - this.jSo) - ((int) this.paint.measureText(at.numberUniformFormat(this.jSu.jPK))), dimensionPixelSize + this.jSh, this.paint);
    }

    private void cNy() {
        if (this.jSu == null) {
            this.jSl = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jSm = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.jSu.jOR == 1) {
            this.jSl = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.jSm = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.jSu.jOR == 2) {
            this.jSm = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.jSl = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.jSl = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jSm = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
