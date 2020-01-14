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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes7.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int Bd;
    private CellForumTestView fVA;
    private CellForumTestView fVB;
    private CellForumTestView fVC;
    private CellForumTestView fVD;
    private int fVE;
    private int fVF;
    private int fVG;
    private int fVH;
    private int fVI;
    private int fVJ;
    private int fVK;
    private Rect[] fVL;
    private float fVM;
    private float fVN;
    private float fVO;
    private float fVP;
    private float fVQ;
    private ValueAnimator fVR;
    private ValueAnimator fVS;
    private boolean fVT;
    private int fVU;
    private int fVV;
    private a fVW;
    private boolean fVX;
    private float fVY;
    private int fVZ;
    private List<f> fVx;
    private CellForumTestView fVy;
    private CellForumTestView fVz;
    private float mDistance;
    private int mHeight;
    private boolean mIsMove;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes7.dex */
    public interface a {
        void bxC();

        void dq(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fVL = new Rect[3];
        this.mIsMove = false;
        this.fVT = false;
        this.fVX = false;
        this.fVY = 0.0f;
        this.fVZ = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fVL = new Rect[3];
        this.mIsMove = false;
        this.fVT = false;
        this.fVX = false;
        this.fVY = 0.0f;
        this.fVZ = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fVL = new Rect[3];
        this.mIsMove = false;
        this.fVT = false;
        this.fVX = false;
        this.fVY = 0.0f;
        this.fVZ = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fVy = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fVz = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fVA = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fVB = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eL(context);
        resetData();
        ViewConfiguration.get(context);
        this.Bd = ViewConfiguration.getMaximumFlingVelocity();
        this.fVy.setForumTestDelClickListener(this);
        this.fVz.setForumTestDelClickListener(this);
        this.fVA.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eL(Context context) {
        this.fVI = l.getDimens(context, R.dimen.tbds44);
        this.fVJ = l.getDimens(context, R.dimen.tbds30);
        this.fVK = l.getDimens(context, R.dimen.tbds7);
        this.fVH = l.getDimens(context, R.dimen.tbds730);
        this.fVG = this.fVH - (this.fVJ * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.fVE = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fVH + this.fVI;
        this.fVF = ((this.mWidth - this.fVE) - (this.fVK * 2)) / 2;
        this.fVO = this.fVJ / (this.fVE + this.fVK);
        this.fVP = this.fVH / this.fVE;
        this.fVQ = this.fVE / (this.fVE + this.fVK);
        this.fVL[0] = new Rect(this.fVF - this.fVE, this.fVI + this.fVJ, this.fVF, this.fVI + this.fVJ + this.fVG);
        this.fVL[1] = new Rect(this.fVF + this.fVK, this.fVI, this.fVF + this.fVK + this.fVE, this.fVI + this.fVH);
        this.fVL[2] = new Rect(this.mWidth - this.fVF, this.fVI + this.fVJ, (this.mWidth - this.fVF) + this.fVE, this.fVI + this.fVJ + this.fVG);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fVS = ValueAnimator.ofFloat(this.fVE, 0.0f);
        this.fVS.setDuration(500L);
        this.fVS.setInterpolator(new DecelerateInterpolator());
        this.fVS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fVU != 1) {
                    if (ForumTestView.this.fVU == 2 || ForumTestView.this.fVU == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fVO * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.fVP;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.fVB.setAlpha(0.0f);
                            ForumTestView.this.fVB.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fVC);
                            ForumTestView.this.d(ForumTestView.this.fVB);
                            ForumTestView.this.fVx.remove(ForumTestView.this.fVB.getData());
                            ForumTestView.this.kH(true);
                            ForumTestView.this.fVT = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fVC, floatValue, abs);
                            if ((ForumTestView.this.fVE * 2) / 5 >= ForumTestView.this.fVB.getViewRight() - ForumTestView.this.fVB.getViewLeft()) {
                                ForumTestView.this.fVB.setAlpha(0.0f);
                                ForumTestView.this.fVB.setVisibility(8);
                            } else {
                                ForumTestView.this.fVB.setViewLeft(ForumTestView.this.fVB.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fVB.setViewRight(ForumTestView.this.fVB.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fVB.setViewTop(ForumTestView.this.fVB.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fVB.setViewBottom(ForumTestView.this.fVB.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fVB.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fVE * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fVO * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.fVP;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.fVB.setAlpha(0.0f);
                        ForumTestView.this.fVB.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fVC);
                        ForumTestView.this.d(ForumTestView.this.fVB);
                        ForumTestView.this.d(ForumTestView.this.fVD);
                        ForumTestView.this.fVx.remove(ForumTestView.this.fVB.getData());
                        if (ForumTestView.this.fVy.getIndex() == 0) {
                            if (ForumTestView.this.fVy.getDataIndex() > ForumTestView.this.fVD.getDataIndex()) {
                                ForumTestView.this.fVy.setDataIndex(ForumTestView.this.fVy.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fVy);
                            }
                        } else if (ForumTestView.this.fVz.getIndex() == 0) {
                            if (ForumTestView.this.fVz.getDataIndex() > ForumTestView.this.fVD.getDataIndex()) {
                                ForumTestView.this.fVz.setDataIndex(ForumTestView.this.fVz.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fVz);
                            }
                        } else if (ForumTestView.this.fVA.getDataIndex() > ForumTestView.this.fVD.getDataIndex()) {
                            ForumTestView.this.fVA.setDataIndex(ForumTestView.this.fVA.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fVA);
                        }
                        if (ForumTestView.this.fVC.getDataIndex() > ForumTestView.this.fVD.getDataIndex()) {
                            ForumTestView.this.fVC.setDataIndex(ForumTestView.this.fVC.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fVC);
                        }
                        ForumTestView.this.fVD.setDataIndex(ForumTestView.this.fVD.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fVD);
                        ForumTestView.this.kH(true);
                        ForumTestView.this.fVT = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fVC, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fVD, floatValue2);
                        if ((ForumTestView.this.fVE * 2) / 5 >= ForumTestView.this.fVB.getViewRight() - ForumTestView.this.fVB.getViewLeft()) {
                            ForumTestView.this.fVB.setAlpha(0.0f);
                            ForumTestView.this.fVB.setVisibility(8);
                        } else {
                            ForumTestView.this.fVB.setViewLeft(ForumTestView.this.fVB.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fVB.setViewRight(ForumTestView.this.fVB.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fVB.setViewTop(ForumTestView.this.fVB.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fVB.setViewBottom(ForumTestView.this.fVB.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fVB.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fVE * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.fVP * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.fVB.setAlpha(0.0f);
                    ForumTestView.this.fVB.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.fVx.remove(ForumTestView.this.fVB.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.fVW != null) {
                        ForumTestView.this.fVW.dq(-1L);
                    }
                    ForumTestView.this.fVT = false;
                    if (ForumTestView.this.fVW != null && v.isEmpty(ForumTestView.this.fVx)) {
                        ForumTestView.this.fVW.bxC();
                    }
                } else {
                    ForumTestView.this.fVB.setViewLeft(ForumTestView.this.fVB.getMoveLeft() + floatValue3);
                    ForumTestView.this.fVB.setViewRight(ForumTestView.this.fVB.getMoveRight() - floatValue3);
                    ForumTestView.this.fVB.setViewTop(ForumTestView.this.fVB.getMoveTop() + f);
                    ForumTestView.this.fVB.setViewBottom(ForumTestView.this.fVB.getMoveBottom() - f);
                    ForumTestView.this.fVB.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.fVZ) {
                this.fVZ = equipmentWidth;
                eL(getContext());
                d(this.fVy);
                d(this.fVz);
                d(this.fVA);
                d(this.fVB);
            }
            a(this.fVy);
            a(this.fVz);
            a(this.fVA);
            a(this.fVB);
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
            this.fVy.layout((int) this.fVy.getViewLeft(), (int) this.fVy.getViewTop(), (int) this.fVy.getViewRight(), (int) this.fVy.getViewBottom());
            this.fVz.layout((int) this.fVz.getViewLeft(), (int) this.fVz.getViewTop(), (int) this.fVz.getViewRight(), (int) this.fVz.getViewBottom());
            this.fVA.layout((int) this.fVA.getViewLeft(), (int) this.fVA.getViewTop(), (int) this.fVA.getViewRight(), (int) this.fVA.getViewBottom());
            this.fVB.layout((int) this.fVB.getViewLeft(), (int) this.fVB.getViewTop(), (int) this.fVB.getViewRight(), (int) this.fVB.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.fVS == null || !this.fVS.isRunning()) {
            if (this.fVR == null || !this.fVR.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fVR != null) {
                        this.fVR.removeAllUpdateListeners();
                        this.fVR.cancel();
                    }
                    this.fVV = motionEvent.getPointerId(0);
                    this.fVM = x;
                    this.fVN = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fVM - x;
                    float f2 = this.fVN - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.mIsMove = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.mIsMove) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fVO * f3;
                    if (this.mIsMove) {
                        b(this.fVy, f3, f4);
                        b(this.fVz, f3, f4);
                        b(this.fVA, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Bd);
                    float xVelocity = velocityTracker.getXVelocity(this.fVV);
                    if (this.mIsMove || this.mDistance != 0.0f) {
                        ax(xVelocity);
                    }
                    this.mIsMove = false;
                    releaseVelocityTracker();
                }
                if (this.mIsMove || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.fVx.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fVL[0].right - (this.fVE / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fVL[0].right - (this.fVE / 2))) + this.fVL[2].left + (this.fVE / 2) + this.fVK);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fVE);
                    cellForumTestView.setViewTop(this.fVL[2].top);
                    cellForumTestView.setViewBottom(this.fVL[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fVx.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fVL[2].left + (this.fVE / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fVL[2].left + (this.fVE / 2))) + ((this.fVL[0].right - (this.fVE / 2)) - this.fVK));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fVE);
                    cellForumTestView.setViewTop(this.fVL[0].top);
                    cellForumTestView.setViewBottom(this.fVL[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fVx.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fVL[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fVL[0].top) {
                    cellForumTestView.setViewTop(this.fVL[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fVL[0].bottom) {
                    cellForumTestView.setViewBottom(this.fVL[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fVL[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fVL[1].top) {
                    cellForumTestView.setViewTop(this.fVL[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fVL[1].bottom) {
                    cellForumTestView.setViewBottom(this.fVL[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.fVW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kH(boolean z) {
        if (this.fVW != null) {
            int i = -1;
            if (this.fVy.getIndex() == 1 && this.fVy.getData() != null) {
                this.fVW.dq(this.fVy.getData().testId);
                i = this.fVy.getDataIndex();
            } else if (this.fVz.getIndex() == 1 && this.fVz.getData() != null) {
                this.fVW.dq(this.fVz.getData().testId);
                i = this.fVz.getDataIndex();
            } else if (this.fVA.getIndex() == 1 && this.fVA.getData() != null) {
                this.fVW.dq(this.fVA.getData().testId);
                i = this.fVA.getDataIndex();
            } else {
                this.fVW.dq(-1L);
            }
            if (z) {
                rR(i);
            }
        }
    }

    private void initAnimation() {
        this.fVR = ValueAnimator.ofFloat(this.fVE, 0.0f);
        this.fVR.setDuration(200L);
        this.fVR.setInterpolator(new DecelerateInterpolator());
        this.fVR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.fVE) * 0.2f;
                    if (ForumTestView.this.fVX) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bxz();
                        } else {
                            ForumTestView.this.bxA();
                        }
                        ForumTestView.this.fVX = false;
                    }
                    ForumTestView.this.fVY = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fVy);
                    ForumTestView.this.d(ForumTestView.this.fVz);
                    ForumTestView.this.d(ForumTestView.this.fVA);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.kH(z);
                } else {
                    if (ForumTestView.this.fVX) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.rP(2) != null && ForumTestView.this.rP(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bxz();
                                ForumTestView.this.fVX = false;
                            }
                        } else if (ForumTestView.this.rP(0) != null && ForumTestView.this.rP(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bxA();
                            ForumTestView.this.fVX = false;
                        }
                    }
                    float f = ForumTestView.this.fVY - floatValue;
                    float f2 = ForumTestView.this.fVO * f;
                    ForumTestView.this.b(ForumTestView.this.fVy, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fVz, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fVA, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fVY = floatValue;
            }
        });
    }

    private void ax(float f) {
        CellForumTestView rP;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fVX = false;
        this.fVY = 0.0f;
        initAnimation();
        if (this.fVx.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fVy.getVisibility() == 0) {
                cellForumTestView3 = this.fVy;
            }
            if (this.fVz.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fVz;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fVz;
            }
            if (this.fVA.getVisibility() == 0) {
                cellForumTestView2 = this.fVA;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fVL[0].left) || viewRight > ((float) this.fVL[2].right)) && Math.abs(this.mDistance) >= this.fVE * 0.2f) {
                this.fVX = true;
            }
        } else if (this.fVx.size() > 2 && Math.abs(this.mDistance) >= this.fVE * 0.2f) {
            this.fVX = true;
        }
        if (this.fVX && (rP = rP(1)) != null) {
            if (this.mDistance >= this.fVE) {
                this.mDistance -= this.fVE;
                this.fVX = false;
                bxA();
            } else if (this.mDistance > 0.0f && this.mDistance < this.fVE) {
                this.mDistance = this.fVL[0].right - rP.getViewRight();
            } else if (this.mDistance > (-this.fVE)) {
                this.mDistance = this.fVL[2].left - rP.getViewLeft();
            } else {
                bxz();
                this.mDistance += this.fVE;
                this.fVX = false;
            }
        }
        this.fVR.setFloatValues(0.0f, this.mDistance);
        this.fVR.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxz() {
        this.fVy.setIndex(this.fVy.getIndex() + 1);
        this.fVz.setIndex(this.fVz.getIndex() + 1);
        this.fVA.setIndex(this.fVA.getIndex() + 1);
        b(this.fVy);
        b(this.fVz);
        b(this.fVA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxA() {
        this.fVy.setIndex(this.fVy.getIndex() - 1);
        this.fVz.setIndex(this.fVz.getIndex() - 1);
        this.fVA.setIndex(this.fVA.getIndex() - 1);
        b(this.fVy);
        b(this.fVz);
        b(this.fVA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView rP(int i) {
        if (this.fVy.getIndex() == i) {
            return this.fVy;
        }
        if (this.fVz.getIndex() == i) {
            return this.fVz;
        }
        if (this.fVA.getIndex() == i) {
            return this.fVA;
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
            int size = this.fVx.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int rQ(int i) {
        int size = this.fVx.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fVL[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fVL[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fVL[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fVL[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.mIsMove && this.mDistance == 0.0f) {
            this.fVx = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.fVy.setVisibility(0);
                this.fVz.setVisibility(0);
                this.fVA.setVisibility(0);
                this.fVy.setData(list.get(0));
                this.fVz.setData(list.get(1));
                this.fVA.setData(list.get(2));
                this.fVy.setDataIndex(0);
                this.fVz.setDataIndex(1);
                this.fVA.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.fVy.setVisibility(8);
                this.fVz.setVisibility(0);
                this.fVA.setVisibility(0);
                this.fVz.setDataIndex(1);
                this.fVA.setDataIndex(0);
                this.fVz.setData(list.get(1));
                this.fVA.setData(list.get(0));
                i = 1;
            } else {
                this.fVy.setVisibility(8);
                this.fVz.setVisibility(0);
                this.fVA.setVisibility(8);
                this.fVz.setDataIndex(0);
                this.fVz.setData(list.get(0));
                i = 0;
            }
            rR(i);
        }
    }

    private void resetData() {
        this.fVy.setIndex(0);
        this.fVz.setIndex(1);
        this.fVA.setIndex(2);
        this.fVB.setIndex(1);
        d(this.fVy);
        d(this.fVz);
        d(this.fVA);
        d(this.fVB);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void rO(int i) {
        CellForumTestView cellForumTestView;
        this.fVT = true;
        this.fVB.setVisibility(0);
        this.fVB.setAlpha(1.0f);
        bxB();
        if (this.fVy.getIndex() == i && this.fVy.getVisibility() == 0) {
            cellForumTestView = this.fVy;
        } else if (this.fVz.getIndex() == i && this.fVz.getVisibility() == 0) {
            cellForumTestView = this.fVz;
        } else {
            cellForumTestView = this.fVA;
        }
        this.fVB.setData(cellForumTestView.getData());
        this.fVB.setDataIndex(cellForumTestView.getDataIndex());
        this.fVD = null;
        if (this.fVx.size() == 1) {
            this.fVU = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.fVE * 3) / 5;
        } else if (this.fVx.size() == 2) {
            this.fVU = 2;
            cellForumTestView.setVisibility(8);
            if (this.fVy.getVisibility() == 0) {
                this.fVC = this.fVy;
            } else if (this.fVz.getVisibility() == 0) {
                this.fVC = this.fVz;
            } else {
                this.fVC = this.fVA;
            }
            if (this.fVC.getViewRight() < this.fVL[1].left) {
                this.mDistance = this.fVE + this.fVK;
                this.fVC.setIndex(this.fVC.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fVC.getViewLeft() > this.fVL[1].right) {
                this.mDistance = (-this.fVE) - this.fVK;
                this.fVC.setIndex(this.fVC.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fVC);
            b(cellForumTestView);
        } else if (this.fVx.size() == 3) {
            this.fVU = 3;
            cellForumTestView.setVisibility(8);
            if (this.fVy.getIndex() == 2) {
                this.fVC = this.fVy;
            } else if (this.fVz.getIndex() == 2) {
                this.fVC = this.fVz;
            } else {
                this.fVC = this.fVA;
            }
            this.mDistance = (-this.fVE) - this.fVK;
            this.fVC.setIndex(this.fVC.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fVC);
            b(cellForumTestView);
        } else {
            this.fVU = 4;
            this.fVD = cellForumTestView;
            if (this.fVy.getIndex() == 2) {
                this.fVC = this.fVy;
            } else if (this.fVz.getIndex() == 2) {
                this.fVC = this.fVz;
            } else {
                this.fVC = this.fVA;
            }
            this.mDistance = (-this.fVE) - this.fVK;
            this.fVC.setIndex(this.fVC.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fVC);
            b(cellForumTestView);
            this.fVD.setViewLeft(this.fVL[2].right + this.fVK);
            this.fVD.setViewRight(this.fVL[2].right + this.fVK + this.fVE);
            this.fVD.setViewTop(this.fVL[2].top);
            this.fVD.setViewBottom(this.fVL[2].bottom);
            this.fVD.setMoveLeft(this.fVL[2].right + this.fVK);
            this.fVD.setMoveRight(this.fVL[2].right + this.fVK + this.fVE);
            this.fVD.setMoveTop(this.fVL[2].top);
            this.fVD.setMoveBottom(this.fVL[2].bottom);
            this.fVD.setData(this.fVx.get(rQ(this.fVD.getDataIndex() + 2)));
        }
        this.fVS.setFloatValues(0.0f, this.mDistance);
        this.fVS.start();
    }

    private void bxB() {
        this.fVy.setMoveLeft(this.fVy.getViewLeft());
        this.fVy.setMoveTop(this.fVy.getViewTop());
        this.fVy.setMoveRight(this.fVy.getViewRight());
        this.fVy.setMoveBottom(this.fVy.getViewBottom());
        this.fVz.setMoveLeft(this.fVz.getViewLeft());
        this.fVz.setMoveTop(this.fVz.getViewTop());
        this.fVz.setMoveRight(this.fVz.getViewRight());
        this.fVz.setMoveBottom(this.fVz.getViewBottom());
        this.fVA.setMoveLeft(this.fVA.getViewLeft());
        this.fVA.setMoveTop(this.fVA.getViewTop());
        this.fVA.setMoveRight(this.fVA.getViewRight());
        this.fVA.setMoveBottom(this.fVA.getViewBottom());
        this.fVB.setMoveLeft(this.fVB.getViewLeft());
        this.fVB.setMoveTop(this.fVB.getViewTop());
        this.fVB.setMoveRight(this.fVB.getViewRight());
        this.fVB.setMoveBottom(this.fVB.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.fVy.onChangeSkinType();
            this.fVz.onChangeSkinType();
            this.fVA.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.mIsMove && this.mDistance == 0.0f) {
            if (this.fVR != null) {
                this.fVR.removeAllUpdateListeners();
                this.fVR.cancel();
            }
            if (this.fVS != null) {
                this.fVS.removeAllUpdateListeners();
                this.fVS.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fVy != null) {
            this.fVy.setPageId(bdUniqueId);
        }
        if (this.fVz != null) {
            this.fVz.setPageId(bdUniqueId);
        }
        if (this.fVA != null) {
            this.fVA.setPageId(bdUniqueId);
        }
    }

    public void rR(int i) {
        f fVar;
        an a2;
        if (this.fVx != null && i >= 0 && i < this.fVx.size() && (fVar = this.fVx.get(i)) != null && (a2 = com.baidu.tieba.r.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.r.c.cIu().a(this.mPageId, com.baidu.tieba.r.a.IB("" + fVar.testId), a2);
        }
    }
}
