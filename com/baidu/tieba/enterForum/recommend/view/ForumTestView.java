package com.baidu.tieba.enterForum.recommend.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes9.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int VJ;
    private List<f> hgH;
    private CellForumTestView hgI;
    private CellForumTestView hgJ;
    private CellForumTestView hgK;
    private CellForumTestView hgL;
    private CellForumTestView hgM;
    private CellForumTestView hgN;
    private int hgO;
    private int hgP;
    private int hgQ;
    private int hgR;
    private int hgS;
    private int hgT;
    private int hgU;
    private Rect[] hgV;
    private float hgW;
    private float hgX;
    private float hgY;
    private float hgZ;
    private float hha;
    private ValueAnimator hhb;
    private ValueAnimator hhc;
    private boolean hhd;
    private boolean hhe;
    private int hhf;
    private int hhg;
    private a hhh;
    private boolean hhi;
    private float hhj;
    private int hhk;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void bSN();

        void ed(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hgV = new Rect[3];
        this.hhd = false;
        this.hhe = false;
        this.hhi = false;
        this.hhj = 0.0f;
        this.hhk = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hgV = new Rect[3];
        this.hhd = false;
        this.hhe = false;
        this.hhi = false;
        this.hhj = 0.0f;
        this.hhk = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hgV = new Rect[3];
        this.hhd = false;
        this.hhe = false;
        this.hhi = false;
        this.hhj = 0.0f;
        this.hhk = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.hgI = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.hgJ = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.hgK = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.hgL = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eJ(context);
        resetData();
        ViewConfiguration.get(context);
        this.VJ = ViewConfiguration.getMaximumFlingVelocity();
        this.hgI.setForumTestDelClickListener(this);
        this.hgJ.setForumTestDelClickListener(this);
        this.hgK.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eJ(Context context) {
        this.hgS = l.getDimens(context, R.dimen.tbds44);
        this.hgT = l.getDimens(context, R.dimen.tbds30);
        this.hgU = l.getDimens(context, R.dimen.tbds7);
        this.hgR = l.getDimens(context, R.dimen.tbds730);
        this.hgQ = this.hgR - (this.hgT * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.hgO = (int) (this.mWidth * 0.89f);
        this.mHeight = this.hgR + this.hgS;
        this.hgP = ((this.mWidth - this.hgO) - (this.hgU * 2)) / 2;
        this.hgY = this.hgT / (this.hgO + this.hgU);
        this.hgZ = this.hgR / this.hgO;
        this.hha = this.hgO / (this.hgO + this.hgU);
        this.hgV[0] = new Rect(this.hgP - this.hgO, this.hgS + this.hgT, this.hgP, this.hgS + this.hgT + this.hgQ);
        this.hgV[1] = new Rect(this.hgP + this.hgU, this.hgS, this.hgP + this.hgU + this.hgO, this.hgS + this.hgR);
        this.hgV[2] = new Rect(this.mWidth - this.hgP, this.hgS + this.hgT, (this.mWidth - this.hgP) + this.hgO, this.hgS + this.hgT + this.hgQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hhc = ValueAnimator.ofFloat(this.hgO, 0.0f);
        this.hhc.setDuration(500L);
        this.hhc.setInterpolator(new DecelerateInterpolator());
        this.hhc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.hhf != 1) {
                    if (ForumTestView.this.hhf == 2 || ForumTestView.this.hhf == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.hgY * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.hgZ;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.hgL.setAlpha(0.0f);
                            ForumTestView.this.hgL.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.hgM);
                            ForumTestView.this.d(ForumTestView.this.hgL);
                            ForumTestView.this.hgH.remove(ForumTestView.this.hgL.getData());
                            ForumTestView.this.my(true);
                            ForumTestView.this.hhe = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.hgM, floatValue, abs);
                            if ((ForumTestView.this.hgO * 2) / 5 >= ForumTestView.this.hgL.getViewRight() - ForumTestView.this.hgL.getViewLeft()) {
                                ForumTestView.this.hgL.setAlpha(0.0f);
                                ForumTestView.this.hgL.setVisibility(8);
                            } else {
                                ForumTestView.this.hgL.setViewLeft(ForumTestView.this.hgL.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hgL.setViewRight(ForumTestView.this.hgL.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hgL.setViewTop(ForumTestView.this.hgL.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.hgL.setViewBottom(ForumTestView.this.hgL.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.hgL.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.hgO * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.hgY * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.hgZ;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.hgL.setAlpha(0.0f);
                        ForumTestView.this.hgL.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.hgM);
                        ForumTestView.this.d(ForumTestView.this.hgL);
                        ForumTestView.this.d(ForumTestView.this.hgN);
                        ForumTestView.this.hgH.remove(ForumTestView.this.hgL.getData());
                        if (ForumTestView.this.hgI.getIndex() == 0) {
                            if (ForumTestView.this.hgI.getDataIndex() > ForumTestView.this.hgN.getDataIndex()) {
                                ForumTestView.this.hgI.setDataIndex(ForumTestView.this.hgI.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hgI);
                            }
                        } else if (ForumTestView.this.hgJ.getIndex() == 0) {
                            if (ForumTestView.this.hgJ.getDataIndex() > ForumTestView.this.hgN.getDataIndex()) {
                                ForumTestView.this.hgJ.setDataIndex(ForumTestView.this.hgJ.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hgJ);
                            }
                        } else if (ForumTestView.this.hgK.getDataIndex() > ForumTestView.this.hgN.getDataIndex()) {
                            ForumTestView.this.hgK.setDataIndex(ForumTestView.this.hgK.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hgK);
                        }
                        if (ForumTestView.this.hgM.getDataIndex() > ForumTestView.this.hgN.getDataIndex()) {
                            ForumTestView.this.hgM.setDataIndex(ForumTestView.this.hgM.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hgM);
                        }
                        ForumTestView.this.hgN.setDataIndex(ForumTestView.this.hgN.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.hgN);
                        ForumTestView.this.my(true);
                        ForumTestView.this.hhe = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.hgM, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.hgN, floatValue2);
                        if ((ForumTestView.this.hgO * 2) / 5 >= ForumTestView.this.hgL.getViewRight() - ForumTestView.this.hgL.getViewLeft()) {
                            ForumTestView.this.hgL.setAlpha(0.0f);
                            ForumTestView.this.hgL.setVisibility(8);
                        } else {
                            ForumTestView.this.hgL.setViewLeft(ForumTestView.this.hgL.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hgL.setViewRight(ForumTestView.this.hgL.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hgL.setViewTop(ForumTestView.this.hgL.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.hgL.setViewBottom(ForumTestView.this.hgL.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.hgL.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.hgO * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.hgZ * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.hgL.setAlpha(0.0f);
                    ForumTestView.this.hgL.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.hgH.remove(ForumTestView.this.hgL.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.hhh != null) {
                        ForumTestView.this.hhh.ed(-1L);
                    }
                    ForumTestView.this.hhe = false;
                    if (ForumTestView.this.hhh != null && w.isEmpty(ForumTestView.this.hgH)) {
                        ForumTestView.this.hhh.bSN();
                    }
                } else {
                    ForumTestView.this.hgL.setViewLeft(ForumTestView.this.hgL.getMoveLeft() + floatValue3);
                    ForumTestView.this.hgL.setViewRight(ForumTestView.this.hgL.getMoveRight() - floatValue3);
                    ForumTestView.this.hgL.setViewTop(ForumTestView.this.hgL.getMoveTop() + f);
                    ForumTestView.this.hgL.setViewBottom(ForumTestView.this.hgL.getMoveBottom() - f);
                    ForumTestView.this.hgL.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
                }
                ForumTestView.this.requestLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CellForumTestView cellForumTestView, float f, float f2) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(cellForumTestView.getMoveLeft() + f);
            cellForumTestView.setViewRight(cellForumTestView.getMoveRight() + f);
            cellForumTestView.setViewTop(cellForumTestView.getMoveTop() - f2);
            cellForumTestView.setViewBottom(cellForumTestView.getMoveBottom() + f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CellForumTestView cellForumTestView, float f) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(cellForumTestView.getMoveLeft() + f);
            cellForumTestView.setViewRight(cellForumTestView.getMoveRight() + f);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (getVisibility() == 0) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            if (equipmentWidth != this.hhk) {
                this.hhk = equipmentWidth;
                eJ(getContext());
                d(this.hgI);
                d(this.hgJ);
                d(this.hgK);
                d(this.hgL);
            }
            a(this.hgI);
            a(this.hgJ);
            a(this.hgK);
            a(this.hgL);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }

    private void a(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.getLayoutParams().width = (int) (cellForumTestView.getViewRight() - cellForumTestView.getViewLeft());
            cellForumTestView.getLayoutParams().height = (int) (cellForumTestView.getViewBottom() - cellForumTestView.getViewTop());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getVisibility() == 0) {
            this.hgI.layout((int) this.hgI.getViewLeft(), (int) this.hgI.getViewTop(), (int) this.hgI.getViewRight(), (int) this.hgI.getViewBottom());
            this.hgJ.layout((int) this.hgJ.getViewLeft(), (int) this.hgJ.getViewTop(), (int) this.hgJ.getViewRight(), (int) this.hgJ.getViewBottom());
            this.hgK.layout((int) this.hgK.getViewLeft(), (int) this.hgK.getViewTop(), (int) this.hgK.getViewRight(), (int) this.hgK.getViewBottom());
            this.hgL.layout((int) this.hgL.getViewLeft(), (int) this.hgL.getViewTop(), (int) this.hgL.getViewRight(), (int) this.hgL.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.hhc == null || !this.hhc.isRunning()) {
            if (this.hhb == null || !this.hhb.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.hhb != null) {
                        this.hhb.removeAllUpdateListeners();
                        this.hhb.cancel();
                    }
                    this.hhg = motionEvent.getPointerId(0);
                    this.hgW = x;
                    this.hgX = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.hgW - x;
                    float f2 = this.hgX - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.hhd = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.hhd) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.hgY * f3;
                    if (this.hhd) {
                        b(this.hgI, f3, f4);
                        b(this.hgJ, f3, f4);
                        b(this.hgK, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.VJ);
                    float xVelocity = velocityTracker.getXVelocity(this.hhg);
                    if (this.hhd || this.mDistance != 0.0f) {
                        ag(xVelocity);
                    }
                    this.hhd = false;
                    releaseVelocityTracker();
                }
                if (this.hhd || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return true;
    }

    private void acquireVelocityTracker(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CellForumTestView cellForumTestView, float f, float f2) {
        if (cellForumTestView != null && cellForumTestView.getVisibility() != 8) {
            if (this.hgH.size() > 2) {
                if (cellForumTestView.getViewRight() < this.hgV[0].right - (this.hgO / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.hgV[0].right - (this.hgO / 2))) + this.hgV[2].left + (this.hgO / 2) + this.hgU);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.hgO);
                    cellForumTestView.setViewTop(this.hgV[2].top);
                    cellForumTestView.setViewBottom(this.hgV[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hgH.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.hgV[2].left + (this.hgO / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.hgV[2].left + (this.hgO / 2))) + ((this.hgV[0].right - (this.hgO / 2)) - this.hgU));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.hgO);
                    cellForumTestView.setViewTop(this.hgV[0].top);
                    cellForumTestView.setViewBottom(this.hgV[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hgH.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.hgV[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.hgV[0].top) {
                    cellForumTestView.setViewTop(this.hgV[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.hgV[0].bottom) {
                    cellForumTestView.setViewBottom(this.hgV[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.hgV[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.hgV[1].top) {
                    cellForumTestView.setViewTop(this.hgV[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.hgV[1].bottom) {
                    cellForumTestView.setViewBottom(this.hgV[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.hhh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my(boolean z) {
        if (this.hhh != null) {
            int i = -1;
            if (this.hgI.getIndex() == 1 && this.hgI.getData() != null) {
                this.hhh.ed(this.hgI.getData().testId);
                i = this.hgI.getDataIndex();
            } else if (this.hgJ.getIndex() == 1 && this.hgJ.getData() != null) {
                this.hhh.ed(this.hgJ.getData().testId);
                i = this.hgJ.getDataIndex();
            } else if (this.hgK.getIndex() == 1 && this.hgK.getData() != null) {
                this.hhh.ed(this.hgK.getData().testId);
                i = this.hgK.getDataIndex();
            } else {
                this.hhh.ed(-1L);
            }
            if (z) {
                tC(i);
            }
        }
    }

    private void initAnimation() {
        this.hhb = ValueAnimator.ofFloat(this.hgO, 0.0f);
        this.hhb.setDuration(200L);
        this.hhb.setInterpolator(new DecelerateInterpolator());
        this.hhb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.hgO) * 0.2f;
                    if (ForumTestView.this.hhi) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bSK();
                        } else {
                            ForumTestView.this.bSL();
                        }
                        ForumTestView.this.hhi = false;
                    }
                    ForumTestView.this.hhj = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.hgI);
                    ForumTestView.this.d(ForumTestView.this.hgJ);
                    ForumTestView.this.d(ForumTestView.this.hgK);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.my(z);
                } else {
                    if (ForumTestView.this.hhi) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.tA(2) != null && ForumTestView.this.tA(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bSK();
                                ForumTestView.this.hhi = false;
                            }
                        } else if (ForumTestView.this.tA(0) != null && ForumTestView.this.tA(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bSL();
                            ForumTestView.this.hhi = false;
                        }
                    }
                    float f = ForumTestView.this.hhj - floatValue;
                    float f2 = ForumTestView.this.hgY * f;
                    ForumTestView.this.b(ForumTestView.this.hgI, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hgJ, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hgK, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.hhj = floatValue;
            }
        });
    }

    private void ag(float f) {
        CellForumTestView tA;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.hhi = false;
        this.hhj = 0.0f;
        initAnimation();
        if (this.hgH.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.hgI.getVisibility() == 0) {
                cellForumTestView3 = this.hgI;
            }
            if (this.hgJ.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.hgJ;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.hgJ;
            }
            if (this.hgK.getVisibility() == 0) {
                cellForumTestView2 = this.hgK;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.hgV[0].left) || viewRight > ((float) this.hgV[2].right)) && Math.abs(this.mDistance) >= this.hgO * 0.2f) {
                this.hhi = true;
            }
        } else if (this.hgH.size() > 2 && Math.abs(this.mDistance) >= this.hgO * 0.2f) {
            this.hhi = true;
        }
        if (this.hhi && (tA = tA(1)) != null) {
            if (this.mDistance >= this.hgO) {
                this.mDistance -= this.hgO;
                this.hhi = false;
                bSL();
            } else if (this.mDistance > 0.0f && this.mDistance < this.hgO) {
                this.mDistance = this.hgV[0].right - tA.getViewRight();
            } else if (this.mDistance > (-this.hgO)) {
                this.mDistance = this.hgV[2].left - tA.getViewLeft();
            } else {
                bSK();
                this.mDistance += this.hgO;
                this.hhi = false;
            }
        }
        this.hhb.setFloatValues(0.0f, this.mDistance);
        this.hhb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSK() {
        this.hgI.setIndex(this.hgI.getIndex() + 1);
        this.hgJ.setIndex(this.hgJ.getIndex() + 1);
        this.hgK.setIndex(this.hgK.getIndex() + 1);
        b(this.hgI);
        b(this.hgJ);
        b(this.hgK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSL() {
        this.hgI.setIndex(this.hgI.getIndex() - 1);
        this.hgJ.setIndex(this.hgJ.getIndex() - 1);
        this.hgK.setIndex(this.hgK.getIndex() - 1);
        b(this.hgI);
        b(this.hgJ);
        b(this.hgK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView tA(int i) {
        if (this.hgI.getIndex() == i) {
            return this.hgI;
        }
        if (this.hgJ.getIndex() == i) {
            return this.hgJ;
        }
        if (this.hgK.getIndex() == i) {
            return this.hgK;
        }
        return null;
    }

    private void b(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            int index = cellForumTestView.getIndex() % 3;
            if (index == -2) {
                index = 1;
            }
            if (index == -1) {
                index = 2;
            }
            cellForumTestView.setIndex(index);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            int size = this.hgH.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int tB(int i) {
        int size = this.hgH.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.hgV[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.hgV[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.hgV[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.hgV[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!w.isEmpty(list) && !this.hhd && this.mDistance == 0.0f) {
            this.hgH = list;
            resetData();
            if (w.getCount(list) > 2) {
                this.hgI.setVisibility(0);
                this.hgJ.setVisibility(0);
                this.hgK.setVisibility(0);
                this.hgI.setData(list.get(0));
                this.hgJ.setData(list.get(1));
                this.hgK.setData(list.get(2));
                this.hgI.setDataIndex(0);
                this.hgJ.setDataIndex(1);
                this.hgK.setDataIndex(2);
                i = 1;
            } else if (w.getCount(list) == 2) {
                this.hgI.setVisibility(8);
                this.hgJ.setVisibility(0);
                this.hgK.setVisibility(0);
                this.hgJ.setDataIndex(1);
                this.hgK.setDataIndex(0);
                this.hgJ.setData(list.get(1));
                this.hgK.setData(list.get(0));
                i = 1;
            } else {
                this.hgI.setVisibility(8);
                this.hgJ.setVisibility(0);
                this.hgK.setVisibility(8);
                this.hgJ.setDataIndex(0);
                this.hgJ.setData(list.get(0));
                i = 0;
            }
            tC(i);
        }
    }

    private void resetData() {
        this.hgI.setIndex(0);
        this.hgJ.setIndex(1);
        this.hgK.setIndex(2);
        this.hgL.setIndex(1);
        d(this.hgI);
        d(this.hgJ);
        d(this.hgK);
        d(this.hgL);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void tz(int i) {
        CellForumTestView cellForumTestView;
        this.hhe = true;
        this.hgL.setVisibility(0);
        this.hgL.setAlpha(1.0f);
        bSM();
        if (this.hgI.getIndex() == i && this.hgI.getVisibility() == 0) {
            cellForumTestView = this.hgI;
        } else if (this.hgJ.getIndex() == i && this.hgJ.getVisibility() == 0) {
            cellForumTestView = this.hgJ;
        } else {
            cellForumTestView = this.hgK;
        }
        this.hgL.setData(cellForumTestView.getData());
        this.hgL.setDataIndex(cellForumTestView.getDataIndex());
        this.hgN = null;
        if (this.hgH.size() == 1) {
            this.hhf = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.hgO * 3) / 5;
        } else if (this.hgH.size() == 2) {
            this.hhf = 2;
            cellForumTestView.setVisibility(8);
            if (this.hgI.getVisibility() == 0) {
                this.hgM = this.hgI;
            } else if (this.hgJ.getVisibility() == 0) {
                this.hgM = this.hgJ;
            } else {
                this.hgM = this.hgK;
            }
            if (this.hgM.getViewRight() < this.hgV[1].left) {
                this.mDistance = this.hgO + this.hgU;
                this.hgM.setIndex(this.hgM.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.hgM.getViewLeft() > this.hgV[1].right) {
                this.mDistance = (-this.hgO) - this.hgU;
                this.hgM.setIndex(this.hgM.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.hgM);
            b(cellForumTestView);
        } else if (this.hgH.size() == 3) {
            this.hhf = 3;
            cellForumTestView.setVisibility(8);
            if (this.hgI.getIndex() == 2) {
                this.hgM = this.hgI;
            } else if (this.hgJ.getIndex() == 2) {
                this.hgM = this.hgJ;
            } else {
                this.hgM = this.hgK;
            }
            this.mDistance = (-this.hgO) - this.hgU;
            this.hgM.setIndex(this.hgM.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.hgM);
            b(cellForumTestView);
        } else {
            this.hhf = 4;
            this.hgN = cellForumTestView;
            if (this.hgI.getIndex() == 2) {
                this.hgM = this.hgI;
            } else if (this.hgJ.getIndex() == 2) {
                this.hgM = this.hgJ;
            } else {
                this.hgM = this.hgK;
            }
            this.mDistance = (-this.hgO) - this.hgU;
            this.hgM.setIndex(this.hgM.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.hgM);
            b(cellForumTestView);
            this.hgN.setViewLeft(this.hgV[2].right + this.hgU);
            this.hgN.setViewRight(this.hgV[2].right + this.hgU + this.hgO);
            this.hgN.setViewTop(this.hgV[2].top);
            this.hgN.setViewBottom(this.hgV[2].bottom);
            this.hgN.setMoveLeft(this.hgV[2].right + this.hgU);
            this.hgN.setMoveRight(this.hgV[2].right + this.hgU + this.hgO);
            this.hgN.setMoveTop(this.hgV[2].top);
            this.hgN.setMoveBottom(this.hgV[2].bottom);
            this.hgN.setData(this.hgH.get(tB(this.hgN.getDataIndex() + 2)));
        }
        this.hhc.setFloatValues(0.0f, this.mDistance);
        this.hhc.start();
    }

    private void bSM() {
        this.hgI.setMoveLeft(this.hgI.getViewLeft());
        this.hgI.setMoveTop(this.hgI.getViewTop());
        this.hgI.setMoveRight(this.hgI.getViewRight());
        this.hgI.setMoveBottom(this.hgI.getViewBottom());
        this.hgJ.setMoveLeft(this.hgJ.getViewLeft());
        this.hgJ.setMoveTop(this.hgJ.getViewTop());
        this.hgJ.setMoveRight(this.hgJ.getViewRight());
        this.hgJ.setMoveBottom(this.hgJ.getViewBottom());
        this.hgK.setMoveLeft(this.hgK.getViewLeft());
        this.hgK.setMoveTop(this.hgK.getViewTop());
        this.hgK.setMoveRight(this.hgK.getViewRight());
        this.hgK.setMoveBottom(this.hgK.getViewBottom());
        this.hgL.setMoveLeft(this.hgL.getViewLeft());
        this.hgL.setMoveTop(this.hgL.getViewTop());
        this.hgL.setMoveRight(this.hgL.getViewRight());
        this.hgL.setMoveBottom(this.hgL.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            an.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.hgI.onChangeSkinType();
            this.hgJ.onChangeSkinType();
            this.hgK.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.hhd && this.mDistance == 0.0f) {
            if (this.hhb != null) {
                this.hhb.removeAllUpdateListeners();
                this.hhb.cancel();
            }
            if (this.hhc != null) {
                this.hhc.removeAllUpdateListeners();
                this.hhc.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.hgI != null) {
            this.hgI.setPageId(bdUniqueId);
        }
        if (this.hgJ != null) {
            this.hgJ.setPageId(bdUniqueId);
        }
        if (this.hgK != null) {
            this.hgK.setPageId(bdUniqueId);
        }
    }

    public void tC(int i) {
        f fVar;
        ao a2;
        if (this.hgH != null && i >= 0 && i < this.hgH.size() && (fVar = this.hgH.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dgY().a(this.mPageId, com.baidu.tieba.s.a.MR("" + fVar.testId), a2);
        }
    }
}
