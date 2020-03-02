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
/* loaded from: classes9.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int Bv;
    private List<f> fXA;
    private CellForumTestView fXB;
    private CellForumTestView fXC;
    private CellForumTestView fXD;
    private CellForumTestView fXE;
    private CellForumTestView fXF;
    private CellForumTestView fXG;
    private int fXH;
    private int fXI;
    private int fXJ;
    private int fXK;
    private int fXL;
    private int fXM;
    private int fXN;
    private Rect[] fXO;
    private float fXP;
    private float fXQ;
    private float fXR;
    private float fXS;
    private float fXT;
    private ValueAnimator fXU;
    private ValueAnimator fXV;
    private boolean fXW;
    private int fXX;
    private int fXY;
    private a fXZ;
    private boolean fYa;
    private float fYb;
    private int fYc;
    private float mDistance;
    private int mHeight;
    private boolean mIsMove;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void bzg();

        void dq(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fXO = new Rect[3];
        this.mIsMove = false;
        this.fXW = false;
        this.fYa = false;
        this.fYb = 0.0f;
        this.fYc = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fXO = new Rect[3];
        this.mIsMove = false;
        this.fXW = false;
        this.fYa = false;
        this.fYb = 0.0f;
        this.fYc = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fXO = new Rect[3];
        this.mIsMove = false;
        this.fXW = false;
        this.fYa = false;
        this.fYb = 0.0f;
        this.fYc = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fXB = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fXC = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fXD = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fXE = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eO(context);
        resetData();
        ViewConfiguration.get(context);
        this.Bv = ViewConfiguration.getMaximumFlingVelocity();
        this.fXB.setForumTestDelClickListener(this);
        this.fXC.setForumTestDelClickListener(this);
        this.fXD.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eO(Context context) {
        this.fXL = l.getDimens(context, R.dimen.tbds44);
        this.fXM = l.getDimens(context, R.dimen.tbds30);
        this.fXN = l.getDimens(context, R.dimen.tbds7);
        this.fXK = l.getDimens(context, R.dimen.tbds730);
        this.fXJ = this.fXK - (this.fXM * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.fXH = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fXK + this.fXL;
        this.fXI = ((this.mWidth - this.fXH) - (this.fXN * 2)) / 2;
        this.fXR = this.fXM / (this.fXH + this.fXN);
        this.fXS = this.fXK / this.fXH;
        this.fXT = this.fXH / (this.fXH + this.fXN);
        this.fXO[0] = new Rect(this.fXI - this.fXH, this.fXL + this.fXM, this.fXI, this.fXL + this.fXM + this.fXJ);
        this.fXO[1] = new Rect(this.fXI + this.fXN, this.fXL, this.fXI + this.fXN + this.fXH, this.fXL + this.fXK);
        this.fXO[2] = new Rect(this.mWidth - this.fXI, this.fXL + this.fXM, (this.mWidth - this.fXI) + this.fXH, this.fXL + this.fXM + this.fXJ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fXV = ValueAnimator.ofFloat(this.fXH, 0.0f);
        this.fXV.setDuration(500L);
        this.fXV.setInterpolator(new DecelerateInterpolator());
        this.fXV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fXX != 1) {
                    if (ForumTestView.this.fXX == 2 || ForumTestView.this.fXX == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fXR * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.fXS;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.fXE.setAlpha(0.0f);
                            ForumTestView.this.fXE.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fXF);
                            ForumTestView.this.d(ForumTestView.this.fXE);
                            ForumTestView.this.fXA.remove(ForumTestView.this.fXE.getData());
                            ForumTestView.this.kK(true);
                            ForumTestView.this.fXW = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fXF, floatValue, abs);
                            if ((ForumTestView.this.fXH * 2) / 5 >= ForumTestView.this.fXE.getViewRight() - ForumTestView.this.fXE.getViewLeft()) {
                                ForumTestView.this.fXE.setAlpha(0.0f);
                                ForumTestView.this.fXE.setVisibility(8);
                            } else {
                                ForumTestView.this.fXE.setViewLeft(ForumTestView.this.fXE.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fXE.setViewRight(ForumTestView.this.fXE.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fXE.setViewTop(ForumTestView.this.fXE.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fXE.setViewBottom(ForumTestView.this.fXE.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fXE.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fXH * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fXR * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.fXS;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.fXE.setAlpha(0.0f);
                        ForumTestView.this.fXE.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fXF);
                        ForumTestView.this.d(ForumTestView.this.fXE);
                        ForumTestView.this.d(ForumTestView.this.fXG);
                        ForumTestView.this.fXA.remove(ForumTestView.this.fXE.getData());
                        if (ForumTestView.this.fXB.getIndex() == 0) {
                            if (ForumTestView.this.fXB.getDataIndex() > ForumTestView.this.fXG.getDataIndex()) {
                                ForumTestView.this.fXB.setDataIndex(ForumTestView.this.fXB.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fXB);
                            }
                        } else if (ForumTestView.this.fXC.getIndex() == 0) {
                            if (ForumTestView.this.fXC.getDataIndex() > ForumTestView.this.fXG.getDataIndex()) {
                                ForumTestView.this.fXC.setDataIndex(ForumTestView.this.fXC.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fXC);
                            }
                        } else if (ForumTestView.this.fXD.getDataIndex() > ForumTestView.this.fXG.getDataIndex()) {
                            ForumTestView.this.fXD.setDataIndex(ForumTestView.this.fXD.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fXD);
                        }
                        if (ForumTestView.this.fXF.getDataIndex() > ForumTestView.this.fXG.getDataIndex()) {
                            ForumTestView.this.fXF.setDataIndex(ForumTestView.this.fXF.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fXF);
                        }
                        ForumTestView.this.fXG.setDataIndex(ForumTestView.this.fXG.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fXG);
                        ForumTestView.this.kK(true);
                        ForumTestView.this.fXW = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fXF, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fXG, floatValue2);
                        if ((ForumTestView.this.fXH * 2) / 5 >= ForumTestView.this.fXE.getViewRight() - ForumTestView.this.fXE.getViewLeft()) {
                            ForumTestView.this.fXE.setAlpha(0.0f);
                            ForumTestView.this.fXE.setVisibility(8);
                        } else {
                            ForumTestView.this.fXE.setViewLeft(ForumTestView.this.fXE.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fXE.setViewRight(ForumTestView.this.fXE.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fXE.setViewTop(ForumTestView.this.fXE.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fXE.setViewBottom(ForumTestView.this.fXE.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fXE.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fXH * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.fXS * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.fXE.setAlpha(0.0f);
                    ForumTestView.this.fXE.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.fXA.remove(ForumTestView.this.fXE.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.fXZ != null) {
                        ForumTestView.this.fXZ.dq(-1L);
                    }
                    ForumTestView.this.fXW = false;
                    if (ForumTestView.this.fXZ != null && v.isEmpty(ForumTestView.this.fXA)) {
                        ForumTestView.this.fXZ.bzg();
                    }
                } else {
                    ForumTestView.this.fXE.setViewLeft(ForumTestView.this.fXE.getMoveLeft() + floatValue3);
                    ForumTestView.this.fXE.setViewRight(ForumTestView.this.fXE.getMoveRight() - floatValue3);
                    ForumTestView.this.fXE.setViewTop(ForumTestView.this.fXE.getMoveTop() + f);
                    ForumTestView.this.fXE.setViewBottom(ForumTestView.this.fXE.getMoveBottom() - f);
                    ForumTestView.this.fXE.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.fYc) {
                this.fYc = equipmentWidth;
                eO(getContext());
                d(this.fXB);
                d(this.fXC);
                d(this.fXD);
                d(this.fXE);
            }
            a(this.fXB);
            a(this.fXC);
            a(this.fXD);
            a(this.fXE);
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
            this.fXB.layout((int) this.fXB.getViewLeft(), (int) this.fXB.getViewTop(), (int) this.fXB.getViewRight(), (int) this.fXB.getViewBottom());
            this.fXC.layout((int) this.fXC.getViewLeft(), (int) this.fXC.getViewTop(), (int) this.fXC.getViewRight(), (int) this.fXC.getViewBottom());
            this.fXD.layout((int) this.fXD.getViewLeft(), (int) this.fXD.getViewTop(), (int) this.fXD.getViewRight(), (int) this.fXD.getViewBottom());
            this.fXE.layout((int) this.fXE.getViewLeft(), (int) this.fXE.getViewTop(), (int) this.fXE.getViewRight(), (int) this.fXE.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.fXV == null || !this.fXV.isRunning()) {
            if (this.fXU == null || !this.fXU.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fXU != null) {
                        this.fXU.removeAllUpdateListeners();
                        this.fXU.cancel();
                    }
                    this.fXY = motionEvent.getPointerId(0);
                    this.fXP = x;
                    this.fXQ = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fXP - x;
                    float f2 = this.fXQ - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.mIsMove = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.mIsMove) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fXR * f3;
                    if (this.mIsMove) {
                        b(this.fXB, f3, f4);
                        b(this.fXC, f3, f4);
                        b(this.fXD, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Bv);
                    float xVelocity = velocityTracker.getXVelocity(this.fXY);
                    if (this.mIsMove || this.mDistance != 0.0f) {
                        aw(xVelocity);
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
            if (this.fXA.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fXO[0].right - (this.fXH / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fXO[0].right - (this.fXH / 2))) + this.fXO[2].left + (this.fXH / 2) + this.fXN);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fXH);
                    cellForumTestView.setViewTop(this.fXO[2].top);
                    cellForumTestView.setViewBottom(this.fXO[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fXA.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fXO[2].left + (this.fXH / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fXO[2].left + (this.fXH / 2))) + ((this.fXO[0].right - (this.fXH / 2)) - this.fXN));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fXH);
                    cellForumTestView.setViewTop(this.fXO[0].top);
                    cellForumTestView.setViewBottom(this.fXO[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fXA.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fXO[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fXO[0].top) {
                    cellForumTestView.setViewTop(this.fXO[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fXO[0].bottom) {
                    cellForumTestView.setViewBottom(this.fXO[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fXO[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fXO[1].top) {
                    cellForumTestView.setViewTop(this.fXO[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fXO[1].bottom) {
                    cellForumTestView.setViewBottom(this.fXO[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.fXZ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(boolean z) {
        if (this.fXZ != null) {
            int i = -1;
            if (this.fXB.getIndex() == 1 && this.fXB.getData() != null) {
                this.fXZ.dq(this.fXB.getData().testId);
                i = this.fXB.getDataIndex();
            } else if (this.fXC.getIndex() == 1 && this.fXC.getData() != null) {
                this.fXZ.dq(this.fXC.getData().testId);
                i = this.fXC.getDataIndex();
            } else if (this.fXD.getIndex() == 1 && this.fXD.getData() != null) {
                this.fXZ.dq(this.fXD.getData().testId);
                i = this.fXD.getDataIndex();
            } else {
                this.fXZ.dq(-1L);
            }
            if (z) {
                rX(i);
            }
        }
    }

    private void initAnimation() {
        this.fXU = ValueAnimator.ofFloat(this.fXH, 0.0f);
        this.fXU.setDuration(200L);
        this.fXU.setInterpolator(new DecelerateInterpolator());
        this.fXU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.fXH) * 0.2f;
                    if (ForumTestView.this.fYa) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bzd();
                        } else {
                            ForumTestView.this.bze();
                        }
                        ForumTestView.this.fYa = false;
                    }
                    ForumTestView.this.fYb = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fXB);
                    ForumTestView.this.d(ForumTestView.this.fXC);
                    ForumTestView.this.d(ForumTestView.this.fXD);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.kK(z);
                } else {
                    if (ForumTestView.this.fYa) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.rV(2) != null && ForumTestView.this.rV(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bzd();
                                ForumTestView.this.fYa = false;
                            }
                        } else if (ForumTestView.this.rV(0) != null && ForumTestView.this.rV(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bze();
                            ForumTestView.this.fYa = false;
                        }
                    }
                    float f = ForumTestView.this.fYb - floatValue;
                    float f2 = ForumTestView.this.fXR * f;
                    ForumTestView.this.b(ForumTestView.this.fXB, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fXC, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fXD, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fYb = floatValue;
            }
        });
    }

    private void aw(float f) {
        CellForumTestView rV;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fYa = false;
        this.fYb = 0.0f;
        initAnimation();
        if (this.fXA.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fXB.getVisibility() == 0) {
                cellForumTestView3 = this.fXB;
            }
            if (this.fXC.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fXC;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fXC;
            }
            if (this.fXD.getVisibility() == 0) {
                cellForumTestView2 = this.fXD;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fXO[0].left) || viewRight > ((float) this.fXO[2].right)) && Math.abs(this.mDistance) >= this.fXH * 0.2f) {
                this.fYa = true;
            }
        } else if (this.fXA.size() > 2 && Math.abs(this.mDistance) >= this.fXH * 0.2f) {
            this.fYa = true;
        }
        if (this.fYa && (rV = rV(1)) != null) {
            if (this.mDistance >= this.fXH) {
                this.mDistance -= this.fXH;
                this.fYa = false;
                bze();
            } else if (this.mDistance > 0.0f && this.mDistance < this.fXH) {
                this.mDistance = this.fXO[0].right - rV.getViewRight();
            } else if (this.mDistance > (-this.fXH)) {
                this.mDistance = this.fXO[2].left - rV.getViewLeft();
            } else {
                bzd();
                this.mDistance += this.fXH;
                this.fYa = false;
            }
        }
        this.fXU.setFloatValues(0.0f, this.mDistance);
        this.fXU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzd() {
        this.fXB.setIndex(this.fXB.getIndex() + 1);
        this.fXC.setIndex(this.fXC.getIndex() + 1);
        this.fXD.setIndex(this.fXD.getIndex() + 1);
        b(this.fXB);
        b(this.fXC);
        b(this.fXD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bze() {
        this.fXB.setIndex(this.fXB.getIndex() - 1);
        this.fXC.setIndex(this.fXC.getIndex() - 1);
        this.fXD.setIndex(this.fXD.getIndex() - 1);
        b(this.fXB);
        b(this.fXC);
        b(this.fXD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView rV(int i) {
        if (this.fXB.getIndex() == i) {
            return this.fXB;
        }
        if (this.fXC.getIndex() == i) {
            return this.fXC;
        }
        if (this.fXD.getIndex() == i) {
            return this.fXD;
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
            int size = this.fXA.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int rW(int i) {
        int size = this.fXA.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fXO[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fXO[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fXO[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fXO[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.mIsMove && this.mDistance == 0.0f) {
            this.fXA = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.fXB.setVisibility(0);
                this.fXC.setVisibility(0);
                this.fXD.setVisibility(0);
                this.fXB.setData(list.get(0));
                this.fXC.setData(list.get(1));
                this.fXD.setData(list.get(2));
                this.fXB.setDataIndex(0);
                this.fXC.setDataIndex(1);
                this.fXD.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.fXB.setVisibility(8);
                this.fXC.setVisibility(0);
                this.fXD.setVisibility(0);
                this.fXC.setDataIndex(1);
                this.fXD.setDataIndex(0);
                this.fXC.setData(list.get(1));
                this.fXD.setData(list.get(0));
                i = 1;
            } else {
                this.fXB.setVisibility(8);
                this.fXC.setVisibility(0);
                this.fXD.setVisibility(8);
                this.fXC.setDataIndex(0);
                this.fXC.setData(list.get(0));
                i = 0;
            }
            rX(i);
        }
    }

    private void resetData() {
        this.fXB.setIndex(0);
        this.fXC.setIndex(1);
        this.fXD.setIndex(2);
        this.fXE.setIndex(1);
        d(this.fXB);
        d(this.fXC);
        d(this.fXD);
        d(this.fXE);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void rU(int i) {
        CellForumTestView cellForumTestView;
        this.fXW = true;
        this.fXE.setVisibility(0);
        this.fXE.setAlpha(1.0f);
        bzf();
        if (this.fXB.getIndex() == i && this.fXB.getVisibility() == 0) {
            cellForumTestView = this.fXB;
        } else if (this.fXC.getIndex() == i && this.fXC.getVisibility() == 0) {
            cellForumTestView = this.fXC;
        } else {
            cellForumTestView = this.fXD;
        }
        this.fXE.setData(cellForumTestView.getData());
        this.fXE.setDataIndex(cellForumTestView.getDataIndex());
        this.fXG = null;
        if (this.fXA.size() == 1) {
            this.fXX = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.fXH * 3) / 5;
        } else if (this.fXA.size() == 2) {
            this.fXX = 2;
            cellForumTestView.setVisibility(8);
            if (this.fXB.getVisibility() == 0) {
                this.fXF = this.fXB;
            } else if (this.fXC.getVisibility() == 0) {
                this.fXF = this.fXC;
            } else {
                this.fXF = this.fXD;
            }
            if (this.fXF.getViewRight() < this.fXO[1].left) {
                this.mDistance = this.fXH + this.fXN;
                this.fXF.setIndex(this.fXF.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fXF.getViewLeft() > this.fXO[1].right) {
                this.mDistance = (-this.fXH) - this.fXN;
                this.fXF.setIndex(this.fXF.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fXF);
            b(cellForumTestView);
        } else if (this.fXA.size() == 3) {
            this.fXX = 3;
            cellForumTestView.setVisibility(8);
            if (this.fXB.getIndex() == 2) {
                this.fXF = this.fXB;
            } else if (this.fXC.getIndex() == 2) {
                this.fXF = this.fXC;
            } else {
                this.fXF = this.fXD;
            }
            this.mDistance = (-this.fXH) - this.fXN;
            this.fXF.setIndex(this.fXF.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fXF);
            b(cellForumTestView);
        } else {
            this.fXX = 4;
            this.fXG = cellForumTestView;
            if (this.fXB.getIndex() == 2) {
                this.fXF = this.fXB;
            } else if (this.fXC.getIndex() == 2) {
                this.fXF = this.fXC;
            } else {
                this.fXF = this.fXD;
            }
            this.mDistance = (-this.fXH) - this.fXN;
            this.fXF.setIndex(this.fXF.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fXF);
            b(cellForumTestView);
            this.fXG.setViewLeft(this.fXO[2].right + this.fXN);
            this.fXG.setViewRight(this.fXO[2].right + this.fXN + this.fXH);
            this.fXG.setViewTop(this.fXO[2].top);
            this.fXG.setViewBottom(this.fXO[2].bottom);
            this.fXG.setMoveLeft(this.fXO[2].right + this.fXN);
            this.fXG.setMoveRight(this.fXO[2].right + this.fXN + this.fXH);
            this.fXG.setMoveTop(this.fXO[2].top);
            this.fXG.setMoveBottom(this.fXO[2].bottom);
            this.fXG.setData(this.fXA.get(rW(this.fXG.getDataIndex() + 2)));
        }
        this.fXV.setFloatValues(0.0f, this.mDistance);
        this.fXV.start();
    }

    private void bzf() {
        this.fXB.setMoveLeft(this.fXB.getViewLeft());
        this.fXB.setMoveTop(this.fXB.getViewTop());
        this.fXB.setMoveRight(this.fXB.getViewRight());
        this.fXB.setMoveBottom(this.fXB.getViewBottom());
        this.fXC.setMoveLeft(this.fXC.getViewLeft());
        this.fXC.setMoveTop(this.fXC.getViewTop());
        this.fXC.setMoveRight(this.fXC.getViewRight());
        this.fXC.setMoveBottom(this.fXC.getViewBottom());
        this.fXD.setMoveLeft(this.fXD.getViewLeft());
        this.fXD.setMoveTop(this.fXD.getViewTop());
        this.fXD.setMoveRight(this.fXD.getViewRight());
        this.fXD.setMoveBottom(this.fXD.getViewBottom());
        this.fXE.setMoveLeft(this.fXE.getViewLeft());
        this.fXE.setMoveTop(this.fXE.getViewTop());
        this.fXE.setMoveRight(this.fXE.getViewRight());
        this.fXE.setMoveBottom(this.fXE.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.fXB.onChangeSkinType();
            this.fXC.onChangeSkinType();
            this.fXD.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.mIsMove && this.mDistance == 0.0f) {
            if (this.fXU != null) {
                this.fXU.removeAllUpdateListeners();
                this.fXU.cancel();
            }
            if (this.fXV != null) {
                this.fXV.removeAllUpdateListeners();
                this.fXV.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fXB != null) {
            this.fXB.setPageId(bdUniqueId);
        }
        if (this.fXC != null) {
            this.fXC.setPageId(bdUniqueId);
        }
        if (this.fXD != null) {
            this.fXD.setPageId(bdUniqueId);
        }
    }

    public void rX(int i) {
        f fVar;
        an a2;
        if (this.fXA != null && i >= 0 && i < this.fXA.size() && (fVar = this.fXA.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.cKa().a(this.mPageId, com.baidu.tieba.s.a.IP("" + fVar.testId), a2);
        }
    }
}
