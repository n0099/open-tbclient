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
    private CellForumTestView fYA;
    private CellForumTestView fYB;
    private int fYC;
    private int fYD;
    private int fYE;
    private int fYF;
    private int fYG;
    private int fYH;
    private int fYI;
    private Rect[] fYJ;
    private float fYK;
    private float fYL;
    private float fYM;
    private float fYN;
    private float fYO;
    private ValueAnimator fYP;
    private ValueAnimator fYQ;
    private boolean fYR;
    private int fYS;
    private int fYT;
    private a fYU;
    private boolean fYV;
    private float fYW;
    private int fYX;
    private List<f> fYv;
    private CellForumTestView fYw;
    private CellForumTestView fYx;
    private CellForumTestView fYy;
    private CellForumTestView fYz;
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
        void bzn();

        void dq(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fYJ = new Rect[3];
        this.mIsMove = false;
        this.fYR = false;
        this.fYV = false;
        this.fYW = 0.0f;
        this.fYX = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fYJ = new Rect[3];
        this.mIsMove = false;
        this.fYR = false;
        this.fYV = false;
        this.fYW = 0.0f;
        this.fYX = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fYJ = new Rect[3];
        this.mIsMove = false;
        this.fYR = false;
        this.fYV = false;
        this.fYW = 0.0f;
        this.fYX = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fYw = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fYx = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fYy = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fYz = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eN(context);
        resetData();
        ViewConfiguration.get(context);
        this.Bv = ViewConfiguration.getMaximumFlingVelocity();
        this.fYw.setForumTestDelClickListener(this);
        this.fYx.setForumTestDelClickListener(this);
        this.fYy.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eN(Context context) {
        this.fYG = l.getDimens(context, R.dimen.tbds44);
        this.fYH = l.getDimens(context, R.dimen.tbds30);
        this.fYI = l.getDimens(context, R.dimen.tbds7);
        this.fYF = l.getDimens(context, R.dimen.tbds730);
        this.fYE = this.fYF - (this.fYH * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.fYC = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fYF + this.fYG;
        this.fYD = ((this.mWidth - this.fYC) - (this.fYI * 2)) / 2;
        this.fYM = this.fYH / (this.fYC + this.fYI);
        this.fYN = this.fYF / this.fYC;
        this.fYO = this.fYC / (this.fYC + this.fYI);
        this.fYJ[0] = new Rect(this.fYD - this.fYC, this.fYG + this.fYH, this.fYD, this.fYG + this.fYH + this.fYE);
        this.fYJ[1] = new Rect(this.fYD + this.fYI, this.fYG, this.fYD + this.fYI + this.fYC, this.fYG + this.fYF);
        this.fYJ[2] = new Rect(this.mWidth - this.fYD, this.fYG + this.fYH, (this.mWidth - this.fYD) + this.fYC, this.fYG + this.fYH + this.fYE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fYQ = ValueAnimator.ofFloat(this.fYC, 0.0f);
        this.fYQ.setDuration(500L);
        this.fYQ.setInterpolator(new DecelerateInterpolator());
        this.fYQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fYS != 1) {
                    if (ForumTestView.this.fYS == 2 || ForumTestView.this.fYS == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fYM * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.fYN;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.fYz.setAlpha(0.0f);
                            ForumTestView.this.fYz.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fYA);
                            ForumTestView.this.d(ForumTestView.this.fYz);
                            ForumTestView.this.fYv.remove(ForumTestView.this.fYz.getData());
                            ForumTestView.this.kP(true);
                            ForumTestView.this.fYR = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fYA, floatValue, abs);
                            if ((ForumTestView.this.fYC * 2) / 5 >= ForumTestView.this.fYz.getViewRight() - ForumTestView.this.fYz.getViewLeft()) {
                                ForumTestView.this.fYz.setAlpha(0.0f);
                                ForumTestView.this.fYz.setVisibility(8);
                            } else {
                                ForumTestView.this.fYz.setViewLeft(ForumTestView.this.fYz.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fYz.setViewRight(ForumTestView.this.fYz.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fYz.setViewTop(ForumTestView.this.fYz.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fYz.setViewBottom(ForumTestView.this.fYz.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fYz.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fYC * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fYM * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.fYN;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.fYz.setAlpha(0.0f);
                        ForumTestView.this.fYz.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fYA);
                        ForumTestView.this.d(ForumTestView.this.fYz);
                        ForumTestView.this.d(ForumTestView.this.fYB);
                        ForumTestView.this.fYv.remove(ForumTestView.this.fYz.getData());
                        if (ForumTestView.this.fYw.getIndex() == 0) {
                            if (ForumTestView.this.fYw.getDataIndex() > ForumTestView.this.fYB.getDataIndex()) {
                                ForumTestView.this.fYw.setDataIndex(ForumTestView.this.fYw.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fYw);
                            }
                        } else if (ForumTestView.this.fYx.getIndex() == 0) {
                            if (ForumTestView.this.fYx.getDataIndex() > ForumTestView.this.fYB.getDataIndex()) {
                                ForumTestView.this.fYx.setDataIndex(ForumTestView.this.fYx.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fYx);
                            }
                        } else if (ForumTestView.this.fYy.getDataIndex() > ForumTestView.this.fYB.getDataIndex()) {
                            ForumTestView.this.fYy.setDataIndex(ForumTestView.this.fYy.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fYy);
                        }
                        if (ForumTestView.this.fYA.getDataIndex() > ForumTestView.this.fYB.getDataIndex()) {
                            ForumTestView.this.fYA.setDataIndex(ForumTestView.this.fYA.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fYA);
                        }
                        ForumTestView.this.fYB.setDataIndex(ForumTestView.this.fYB.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fYB);
                        ForumTestView.this.kP(true);
                        ForumTestView.this.fYR = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fYA, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fYB, floatValue2);
                        if ((ForumTestView.this.fYC * 2) / 5 >= ForumTestView.this.fYz.getViewRight() - ForumTestView.this.fYz.getViewLeft()) {
                            ForumTestView.this.fYz.setAlpha(0.0f);
                            ForumTestView.this.fYz.setVisibility(8);
                        } else {
                            ForumTestView.this.fYz.setViewLeft(ForumTestView.this.fYz.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fYz.setViewRight(ForumTestView.this.fYz.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fYz.setViewTop(ForumTestView.this.fYz.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fYz.setViewBottom(ForumTestView.this.fYz.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fYz.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fYC * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.fYN * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.fYz.setAlpha(0.0f);
                    ForumTestView.this.fYz.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.fYv.remove(ForumTestView.this.fYz.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.fYU != null) {
                        ForumTestView.this.fYU.dq(-1L);
                    }
                    ForumTestView.this.fYR = false;
                    if (ForumTestView.this.fYU != null && v.isEmpty(ForumTestView.this.fYv)) {
                        ForumTestView.this.fYU.bzn();
                    }
                } else {
                    ForumTestView.this.fYz.setViewLeft(ForumTestView.this.fYz.getMoveLeft() + floatValue3);
                    ForumTestView.this.fYz.setViewRight(ForumTestView.this.fYz.getMoveRight() - floatValue3);
                    ForumTestView.this.fYz.setViewTop(ForumTestView.this.fYz.getMoveTop() + f);
                    ForumTestView.this.fYz.setViewBottom(ForumTestView.this.fYz.getMoveBottom() - f);
                    ForumTestView.this.fYz.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.fYX) {
                this.fYX = equipmentWidth;
                eN(getContext());
                d(this.fYw);
                d(this.fYx);
                d(this.fYy);
                d(this.fYz);
            }
            a(this.fYw);
            a(this.fYx);
            a(this.fYy);
            a(this.fYz);
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
            this.fYw.layout((int) this.fYw.getViewLeft(), (int) this.fYw.getViewTop(), (int) this.fYw.getViewRight(), (int) this.fYw.getViewBottom());
            this.fYx.layout((int) this.fYx.getViewLeft(), (int) this.fYx.getViewTop(), (int) this.fYx.getViewRight(), (int) this.fYx.getViewBottom());
            this.fYy.layout((int) this.fYy.getViewLeft(), (int) this.fYy.getViewTop(), (int) this.fYy.getViewRight(), (int) this.fYy.getViewBottom());
            this.fYz.layout((int) this.fYz.getViewLeft(), (int) this.fYz.getViewTop(), (int) this.fYz.getViewRight(), (int) this.fYz.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.fYQ == null || !this.fYQ.isRunning()) {
            if (this.fYP == null || !this.fYP.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fYP != null) {
                        this.fYP.removeAllUpdateListeners();
                        this.fYP.cancel();
                    }
                    this.fYT = motionEvent.getPointerId(0);
                    this.fYK = x;
                    this.fYL = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fYK - x;
                    float f2 = this.fYL - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.mIsMove = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.mIsMove) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fYM * f3;
                    if (this.mIsMove) {
                        b(this.fYw, f3, f4);
                        b(this.fYx, f3, f4);
                        b(this.fYy, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Bv);
                    float xVelocity = velocityTracker.getXVelocity(this.fYT);
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
            if (this.fYv.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fYJ[0].right - (this.fYC / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fYJ[0].right - (this.fYC / 2))) + this.fYJ[2].left + (this.fYC / 2) + this.fYI);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fYC);
                    cellForumTestView.setViewTop(this.fYJ[2].top);
                    cellForumTestView.setViewBottom(this.fYJ[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fYv.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fYJ[2].left + (this.fYC / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fYJ[2].left + (this.fYC / 2))) + ((this.fYJ[0].right - (this.fYC / 2)) - this.fYI));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fYC);
                    cellForumTestView.setViewTop(this.fYJ[0].top);
                    cellForumTestView.setViewBottom(this.fYJ[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fYv.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fYJ[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fYJ[0].top) {
                    cellForumTestView.setViewTop(this.fYJ[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fYJ[0].bottom) {
                    cellForumTestView.setViewBottom(this.fYJ[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fYJ[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fYJ[1].top) {
                    cellForumTestView.setViewTop(this.fYJ[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fYJ[1].bottom) {
                    cellForumTestView.setViewBottom(this.fYJ[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.fYU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(boolean z) {
        if (this.fYU != null) {
            int i = -1;
            if (this.fYw.getIndex() == 1 && this.fYw.getData() != null) {
                this.fYU.dq(this.fYw.getData().testId);
                i = this.fYw.getDataIndex();
            } else if (this.fYx.getIndex() == 1 && this.fYx.getData() != null) {
                this.fYU.dq(this.fYx.getData().testId);
                i = this.fYx.getDataIndex();
            } else if (this.fYy.getIndex() == 1 && this.fYy.getData() != null) {
                this.fYU.dq(this.fYy.getData().testId);
                i = this.fYy.getDataIndex();
            } else {
                this.fYU.dq(-1L);
            }
            if (z) {
                rZ(i);
            }
        }
    }

    private void initAnimation() {
        this.fYP = ValueAnimator.ofFloat(this.fYC, 0.0f);
        this.fYP.setDuration(200L);
        this.fYP.setInterpolator(new DecelerateInterpolator());
        this.fYP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.fYC) * 0.2f;
                    if (ForumTestView.this.fYV) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bzk();
                        } else {
                            ForumTestView.this.bzl();
                        }
                        ForumTestView.this.fYV = false;
                    }
                    ForumTestView.this.fYW = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fYw);
                    ForumTestView.this.d(ForumTestView.this.fYx);
                    ForumTestView.this.d(ForumTestView.this.fYy);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.kP(z);
                } else {
                    if (ForumTestView.this.fYV) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.rX(2) != null && ForumTestView.this.rX(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bzk();
                                ForumTestView.this.fYV = false;
                            }
                        } else if (ForumTestView.this.rX(0) != null && ForumTestView.this.rX(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bzl();
                            ForumTestView.this.fYV = false;
                        }
                    }
                    float f = ForumTestView.this.fYW - floatValue;
                    float f2 = ForumTestView.this.fYM * f;
                    ForumTestView.this.b(ForumTestView.this.fYw, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fYx, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fYy, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fYW = floatValue;
            }
        });
    }

    private void aw(float f) {
        CellForumTestView rX;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fYV = false;
        this.fYW = 0.0f;
        initAnimation();
        if (this.fYv.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fYw.getVisibility() == 0) {
                cellForumTestView3 = this.fYw;
            }
            if (this.fYx.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fYx;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fYx;
            }
            if (this.fYy.getVisibility() == 0) {
                cellForumTestView2 = this.fYy;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fYJ[0].left) || viewRight > ((float) this.fYJ[2].right)) && Math.abs(this.mDistance) >= this.fYC * 0.2f) {
                this.fYV = true;
            }
        } else if (this.fYv.size() > 2 && Math.abs(this.mDistance) >= this.fYC * 0.2f) {
            this.fYV = true;
        }
        if (this.fYV && (rX = rX(1)) != null) {
            if (this.mDistance >= this.fYC) {
                this.mDistance -= this.fYC;
                this.fYV = false;
                bzl();
            } else if (this.mDistance > 0.0f && this.mDistance < this.fYC) {
                this.mDistance = this.fYJ[0].right - rX.getViewRight();
            } else if (this.mDistance > (-this.fYC)) {
                this.mDistance = this.fYJ[2].left - rX.getViewLeft();
            } else {
                bzk();
                this.mDistance += this.fYC;
                this.fYV = false;
            }
        }
        this.fYP.setFloatValues(0.0f, this.mDistance);
        this.fYP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzk() {
        this.fYw.setIndex(this.fYw.getIndex() + 1);
        this.fYx.setIndex(this.fYx.getIndex() + 1);
        this.fYy.setIndex(this.fYy.getIndex() + 1);
        b(this.fYw);
        b(this.fYx);
        b(this.fYy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzl() {
        this.fYw.setIndex(this.fYw.getIndex() - 1);
        this.fYx.setIndex(this.fYx.getIndex() - 1);
        this.fYy.setIndex(this.fYy.getIndex() - 1);
        b(this.fYw);
        b(this.fYx);
        b(this.fYy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView rX(int i) {
        if (this.fYw.getIndex() == i) {
            return this.fYw;
        }
        if (this.fYx.getIndex() == i) {
            return this.fYx;
        }
        if (this.fYy.getIndex() == i) {
            return this.fYy;
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
            int size = this.fYv.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int rY(int i) {
        int size = this.fYv.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fYJ[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fYJ[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fYJ[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fYJ[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.mIsMove && this.mDistance == 0.0f) {
            this.fYv = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.fYw.setVisibility(0);
                this.fYx.setVisibility(0);
                this.fYy.setVisibility(0);
                this.fYw.setData(list.get(0));
                this.fYx.setData(list.get(1));
                this.fYy.setData(list.get(2));
                this.fYw.setDataIndex(0);
                this.fYx.setDataIndex(1);
                this.fYy.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.fYw.setVisibility(8);
                this.fYx.setVisibility(0);
                this.fYy.setVisibility(0);
                this.fYx.setDataIndex(1);
                this.fYy.setDataIndex(0);
                this.fYx.setData(list.get(1));
                this.fYy.setData(list.get(0));
                i = 1;
            } else {
                this.fYw.setVisibility(8);
                this.fYx.setVisibility(0);
                this.fYy.setVisibility(8);
                this.fYx.setDataIndex(0);
                this.fYx.setData(list.get(0));
                i = 0;
            }
            rZ(i);
        }
    }

    private void resetData() {
        this.fYw.setIndex(0);
        this.fYx.setIndex(1);
        this.fYy.setIndex(2);
        this.fYz.setIndex(1);
        d(this.fYw);
        d(this.fYx);
        d(this.fYy);
        d(this.fYz);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void rW(int i) {
        CellForumTestView cellForumTestView;
        this.fYR = true;
        this.fYz.setVisibility(0);
        this.fYz.setAlpha(1.0f);
        bzm();
        if (this.fYw.getIndex() == i && this.fYw.getVisibility() == 0) {
            cellForumTestView = this.fYw;
        } else if (this.fYx.getIndex() == i && this.fYx.getVisibility() == 0) {
            cellForumTestView = this.fYx;
        } else {
            cellForumTestView = this.fYy;
        }
        this.fYz.setData(cellForumTestView.getData());
        this.fYz.setDataIndex(cellForumTestView.getDataIndex());
        this.fYB = null;
        if (this.fYv.size() == 1) {
            this.fYS = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.fYC * 3) / 5;
        } else if (this.fYv.size() == 2) {
            this.fYS = 2;
            cellForumTestView.setVisibility(8);
            if (this.fYw.getVisibility() == 0) {
                this.fYA = this.fYw;
            } else if (this.fYx.getVisibility() == 0) {
                this.fYA = this.fYx;
            } else {
                this.fYA = this.fYy;
            }
            if (this.fYA.getViewRight() < this.fYJ[1].left) {
                this.mDistance = this.fYC + this.fYI;
                this.fYA.setIndex(this.fYA.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fYA.getViewLeft() > this.fYJ[1].right) {
                this.mDistance = (-this.fYC) - this.fYI;
                this.fYA.setIndex(this.fYA.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fYA);
            b(cellForumTestView);
        } else if (this.fYv.size() == 3) {
            this.fYS = 3;
            cellForumTestView.setVisibility(8);
            if (this.fYw.getIndex() == 2) {
                this.fYA = this.fYw;
            } else if (this.fYx.getIndex() == 2) {
                this.fYA = this.fYx;
            } else {
                this.fYA = this.fYy;
            }
            this.mDistance = (-this.fYC) - this.fYI;
            this.fYA.setIndex(this.fYA.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fYA);
            b(cellForumTestView);
        } else {
            this.fYS = 4;
            this.fYB = cellForumTestView;
            if (this.fYw.getIndex() == 2) {
                this.fYA = this.fYw;
            } else if (this.fYx.getIndex() == 2) {
                this.fYA = this.fYx;
            } else {
                this.fYA = this.fYy;
            }
            this.mDistance = (-this.fYC) - this.fYI;
            this.fYA.setIndex(this.fYA.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fYA);
            b(cellForumTestView);
            this.fYB.setViewLeft(this.fYJ[2].right + this.fYI);
            this.fYB.setViewRight(this.fYJ[2].right + this.fYI + this.fYC);
            this.fYB.setViewTop(this.fYJ[2].top);
            this.fYB.setViewBottom(this.fYJ[2].bottom);
            this.fYB.setMoveLeft(this.fYJ[2].right + this.fYI);
            this.fYB.setMoveRight(this.fYJ[2].right + this.fYI + this.fYC);
            this.fYB.setMoveTop(this.fYJ[2].top);
            this.fYB.setMoveBottom(this.fYJ[2].bottom);
            this.fYB.setData(this.fYv.get(rY(this.fYB.getDataIndex() + 2)));
        }
        this.fYQ.setFloatValues(0.0f, this.mDistance);
        this.fYQ.start();
    }

    private void bzm() {
        this.fYw.setMoveLeft(this.fYw.getViewLeft());
        this.fYw.setMoveTop(this.fYw.getViewTop());
        this.fYw.setMoveRight(this.fYw.getViewRight());
        this.fYw.setMoveBottom(this.fYw.getViewBottom());
        this.fYx.setMoveLeft(this.fYx.getViewLeft());
        this.fYx.setMoveTop(this.fYx.getViewTop());
        this.fYx.setMoveRight(this.fYx.getViewRight());
        this.fYx.setMoveBottom(this.fYx.getViewBottom());
        this.fYy.setMoveLeft(this.fYy.getViewLeft());
        this.fYy.setMoveTop(this.fYy.getViewTop());
        this.fYy.setMoveRight(this.fYy.getViewRight());
        this.fYy.setMoveBottom(this.fYy.getViewBottom());
        this.fYz.setMoveLeft(this.fYz.getViewLeft());
        this.fYz.setMoveTop(this.fYz.getViewTop());
        this.fYz.setMoveRight(this.fYz.getViewRight());
        this.fYz.setMoveBottom(this.fYz.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.fYw.onChangeSkinType();
            this.fYx.onChangeSkinType();
            this.fYy.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.mIsMove && this.mDistance == 0.0f) {
            if (this.fYP != null) {
                this.fYP.removeAllUpdateListeners();
                this.fYP.cancel();
            }
            if (this.fYQ != null) {
                this.fYQ.removeAllUpdateListeners();
                this.fYQ.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fYw != null) {
            this.fYw.setPageId(bdUniqueId);
        }
        if (this.fYx != null) {
            this.fYx.setPageId(bdUniqueId);
        }
        if (this.fYy != null) {
            this.fYy.setPageId(bdUniqueId);
        }
    }

    public void rZ(int i) {
        f fVar;
        an a2;
        if (this.fYv != null && i >= 0 && i < this.fYv.size() && (fVar = this.fYv.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.cKv().a(this.mPageId, com.baidu.tieba.s.a.IQ("" + fVar.testId), a2);
        }
    }
}
