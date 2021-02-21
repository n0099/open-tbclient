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
    private int kxA;
    private int kxB;
    private int kxC;
    private Drawable kxD;
    private Drawable kxE;
    private Drawable kxF;
    private int kxG;
    private int kxH;
    private int kxI;
    private int kxJ;
    private RectF kxK;
    private RectF kxL;
    private i kxM;
    private HotTopicActivity kxN;
    private int kxz;
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
        cTO();
        this.kxF = ap.getDrawable(R.drawable.icon_pic_vs);
        this.kxG = this.kxD.getIntrinsicWidth();
        this.kxH = this.kxD.getIntrinsicHeight();
        this.kxI = this.kxF.getIntrinsicWidth();
        this.kxJ = this.kxF.getIntrinsicHeight();
        this.kxK = new RectF(0.0f, 0.0f, this.kxG, this.kxH);
        this.kxC = (this.kxH - this.kxJ) / 2;
    }

    public void setData(i iVar, HotTopicActivity hotTopicActivity) {
        if (iVar != null && hotTopicActivity != null) {
            this.kxM = iVar;
            this.kxN = hotTopicActivity;
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kxM.kui != 0) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (this.kxK.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kxM.kuZ++;
                    this.kxM.kui = 1;
                } else if (this.kxL.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.kxM.kvc++;
                    this.kxM.kui = 2;
                }
                cTO();
                if (this.kxM.kui != 0) {
                    if (this.kxM.kuZ + this.kxM.kvc > 50) {
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
                    this.kxN.cSX();
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
        this.kxz = this.kxH;
        this.width = View.MeasureSpec.getSize(i);
        setMeasuredDimension(this.width, this.kxz + this.ds30);
        this.kxA = (this.width - (this.kxG * 2)) - 100;
        if (this.kxL == null) {
            this.kxL = new RectF(this.width - this.kxG, 0.0f, this.width, this.kxz);
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
        if (this.kxM.kuZ == 0 && this.kxM.kvc == 0) {
            this.kxB = (int) ((0.5d * this.kxA) + this.kxG + 50.0d);
        } else {
            this.kxB = (int) (((((float) this.kxM.kuZ) / ((float) (this.kxM.kuZ + this.kxM.kvc))) * this.kxA) + this.kxG + 50.0f);
        }
        if (this.kxM.kui == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawRect(this.kxG / 2.0f, this.kxC, this.kxB, this.kxz - this.kxC, this.paint);
        if (this.kxM.kui == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawRect(this.kxB, this.kxC, this.width - (this.kxG / 2.0f), this.kxz - this.kxC, this.paint);
    }

    private void ag(Canvas canvas) {
        cTO();
        this.kxD.setBounds(0, 0, this.kxG, this.kxH);
        this.kxD.draw(canvas);
        this.kxE.setBounds(this.width - this.kxG, 0, this.width, this.kxH);
        this.kxE.draw(canvas);
    }

    private void ah(Canvas canvas) {
        this.kxF = ap.getDrawable(R.drawable.icon_pic_vs);
        if (this.gag) {
            if (this.isLeft) {
                this.kxF.setBounds((this.kxB - (this.kxI / 2)) - 3, this.kxC, ((this.kxB - (this.kxI / 2)) - 3) + this.kxI, this.kxC + this.kxJ);
                this.kxF.draw(canvas);
            } else {
                this.kxF.setBounds((this.kxB - (this.kxI / 2)) + 3, this.kxC, (this.kxB - (this.kxI / 2)) + 3 + this.kxI, this.kxC + this.kxJ);
                this.kxF.draw(canvas);
            }
            this.isLeft = !this.isLeft;
            return;
        }
        this.kxF.setBounds(this.kxB - (this.kxI / 2), this.kxC, (this.kxB - (this.kxI / 2)) + this.kxI, this.kxC + this.kxJ);
        this.kxF.draw(canvas);
    }

    private void J(Canvas canvas) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.ds25);
        this.paint.setTextSize(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.fontsize28));
        if (this.kxM.kui == 2) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_agree_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0308));
        }
        canvas.drawText(au.numberUniformFormat(this.kxM.kuZ), this.kxG, this.kxz + dimensionPixelSize, this.paint);
        if (this.kxM.kui == 1) {
            this.paint.setColor(ap.getColor(R.color.topic_pk_oppose_disable));
        } else {
            this.paint.setColor(ap.getColor(R.color.CAM_X0302));
        }
        canvas.drawText(au.numberUniformFormat(this.kxM.kvc), (this.width - this.kxG) - ((int) this.paint.measureText(au.numberUniformFormat(this.kxM.kvc))), dimensionPixelSize + this.kxz, this.paint);
    }

    private void cTO() {
        if (this.kxM == null) {
            this.kxD = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kxE = ap.getDrawable(R.drawable.icon_pk_blule_n);
        } else if (this.kxM.kui == 1) {
            this.kxD = ap.getDrawable(R.drawable.icon_pk_red_s);
            this.kxE = ap.getDrawable(R.drawable.icon_pk_blule_d);
        } else if (this.kxM.kui == 2) {
            this.kxE = ap.getDrawable(R.drawable.icon_pk_blule_s);
            this.kxD = ap.getDrawable(R.drawable.icon_pk_red_d);
        } else {
            this.kxD = ap.getDrawable(R.drawable.icon_pk_red_n);
            this.kxE = ap.getDrawable(R.drawable.icon_pk_blule_n);
        }
    }
}
