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
    private boolean fim;
    private boolean isLeft;
    private int jcb;
    private int jcc;
    private int jcd;
    private int jce;
    private Drawable jcf;
    private Drawable jcg;
    private Drawable jch;
    private int jci;
    private int jcj;
    private int jck;
    private int jcl;
    private RectF jcm;
    private RectF jcn;
    private i jco;
    private HotTopicActivity jcp;
    private int mSkinType;
    private Paint paint;
    private int width;

    public HotTopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fim = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fim = false;
        this.isLeft = false;
        init(context);
    }

    public HotTopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fim = false;
        this.isLeft = false;
        init(context);
    }

    private void init(Context context) {
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.ds30 = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds30);
        cAz();
        this.jch = ap.getDrawable(R.drawable.icon_pic_vs);
        this.jci = this.jcf.getIntrinsicWidth();
        this.jcj = this.jcf.getIntrinsicHeight();
        this.jck = this.jch.getIntrinsicWidth();
        this.jcl = this.jch.getIntrinsicHeight();
        this.jcm = new RectF(0.0f, 0.0f, this.jci, this.jcj);
        this.jce = (this.jcj - this.jcl) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.jco = iVar;
            this.jcp = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jco.iYK != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.jcm.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jco.iZA++;
                    this.jco.iYK = 1;
                } else if (this.jcn.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.jco.iZD++;
                    this.jco.iYK = 2;
                }
                cAz();
                if (this.jco.iYK != 0) {
                    if (this.jco.iZA + this.jco.iZD > 50) {
                        this.fim = true;
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
                                HotTopicPkView.this.fim = false;
                                HotTopicPkView.this.postInvalidate();
                            }
                        }).start();
                    } else {
                        invalidate();
                    }
                    this.jcp.czH();
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
        this.jcb = this.jcj;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.jcb + this.ds30);
        this.jcc = (this.width - (this.jci * 2)) - 100;
        if (this.jcn == null) {
            this.jcn = new RectF(this.width - this.jci, 0.0f, this.width, this.jcb);
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
        if (this.jco.iZA == 0 && this.jco.iZD == 0) {
            this.jcd = (int) ((0.5d * this.jcc) + this.jci + 50.0d);
        } else {
            this.jcd = (int) (((((float) this.jco.iZA) / ((float) (this.jco.iZA + this.jco.iZD))) * this.jcc) + this.jci + 50.0f);
        }
        if (this.jco.iYK == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawRect(this.jci / 2.0f, this.jce, this.jcd, this.jcb - this.jce, this.paint);
        if (this.jco.iYK == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawRect(this.jcd, this.jce, this.width - (this.jci / 2.0f), this.jcb - this.jce, this.paint);
    }

    private void W(Canvas canvas) {
        cAz();
        this.jcf.setBounds(0, 0, this.jci, this.jcj);
        this.jcf.draw(canvas);
        this.jcg.setBounds(this.width - this.jci, 0, this.width, this.jcj);
        this.jcg.draw(canvas);
    }

    private void X(Canvas canvas) {
        this.jch = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.fim) {
            if (this.isLeft) {
                this.jch.setBounds((this.jcd - (this.jck / 2)) - 3, this.jce, ((this.jcd - (this.jck / 2)) - 3) + this.jck, this.jce + this.jcl);
                this.jch.draw(canvas);
            } else {
                this.jch.setBounds((this.jcd - (this.jck / 2)) + 3, this.jce, (this.jcd - (this.jck / 2)) + 3 + this.jck, this.jce + this.jcl);
                this.jch.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.jch.setBounds(this.jcd - (this.jck / 2), this.jce, (this.jcd - (this.jck / 2)) + this.jck, this.jce + this.jcl);
        this.jch.draw(canvas);
    }

    private void C(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.jco.iYK == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_other_b));
        }
        canvas.drawText(at.numberUniformFormat(this.jco.iZA), this.jci, this.jcb + dimensionPixelSize, this.paint);
        if (this.jco.iYK == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.cp_link_tip_a));
        }
        canvas.drawText(at.numberUniformFormat(this.jco.iZD), (this.width - this.jci) - ((int) this.paint.measureText(at.numberUniformFormat(this.jco.iZD))), dimensionPixelSize + this.jcb, this.paint);
    }

    private void cAz() {
        if (this.jco == null) {
            this.jcf = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jcg = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.jco.iYK == 1) {
            this.jcf = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.jcg = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.jco.iYK == 2) {
            this.jcg = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.jcf = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.jcf = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.jcg = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
