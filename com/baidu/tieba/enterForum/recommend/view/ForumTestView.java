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
    private CellForumTestView fXA;
    private CellForumTestView fXB;
    private CellForumTestView fXC;
    private CellForumTestView fXD;
    private CellForumTestView fXE;
    private int fXF;
    private int fXG;
    private int fXH;
    private int fXI;
    private int fXJ;
    private int fXK;
    private int fXL;
    private Rect[] fXM;
    private float fXN;
    private float fXO;
    private float fXP;
    private float fXQ;
    private float fXR;
    private ValueAnimator fXS;
    private ValueAnimator fXT;
    private boolean fXU;
    private int fXV;
    private int fXW;
    private a fXX;
    private boolean fXY;
    private float fXZ;
    private List<f> fXy;
    private CellForumTestView fXz;
    private int fYa;
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
        void bze();

        void dq(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fXM = new Rect[3];
        this.mIsMove = false;
        this.fXU = false;
        this.fXY = false;
        this.fXZ = 0.0f;
        this.fYa = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fXM = new Rect[3];
        this.mIsMove = false;
        this.fXU = false;
        this.fXY = false;
        this.fXZ = 0.0f;
        this.fYa = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fXM = new Rect[3];
        this.mIsMove = false;
        this.fXU = false;
        this.fXY = false;
        this.fXZ = 0.0f;
        this.fYa = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fXz = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fXA = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fXB = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fXC = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eO(context);
        resetData();
        ViewConfiguration.get(context);
        this.Bv = ViewConfiguration.getMaximumFlingVelocity();
        this.fXz.setForumTestDelClickListener(this);
        this.fXA.setForumTestDelClickListener(this);
        this.fXB.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eO(Context context) {
        this.fXJ = l.getDimens(context, R.dimen.tbds44);
        this.fXK = l.getDimens(context, R.dimen.tbds30);
        this.fXL = l.getDimens(context, R.dimen.tbds7);
        this.fXI = l.getDimens(context, R.dimen.tbds730);
        this.fXH = this.fXI - (this.fXK * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.fXF = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fXI + this.fXJ;
        this.fXG = ((this.mWidth - this.fXF) - (this.fXL * 2)) / 2;
        this.fXP = this.fXK / (this.fXF + this.fXL);
        this.fXQ = this.fXI / this.fXF;
        this.fXR = this.fXF / (this.fXF + this.fXL);
        this.fXM[0] = new Rect(this.fXG - this.fXF, this.fXJ + this.fXK, this.fXG, this.fXJ + this.fXK + this.fXH);
        this.fXM[1] = new Rect(this.fXG + this.fXL, this.fXJ, this.fXG + this.fXL + this.fXF, this.fXJ + this.fXI);
        this.fXM[2] = new Rect(this.mWidth - this.fXG, this.fXJ + this.fXK, (this.mWidth - this.fXG) + this.fXF, this.fXJ + this.fXK + this.fXH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fXT = ValueAnimator.ofFloat(this.fXF, 0.0f);
        this.fXT.setDuration(500L);
        this.fXT.setInterpolator(new DecelerateInterpolator());
        this.fXT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fXV != 1) {
                    if (ForumTestView.this.fXV == 2 || ForumTestView.this.fXV == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fXP * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.fXQ;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.fXC.setAlpha(0.0f);
                            ForumTestView.this.fXC.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fXD);
                            ForumTestView.this.d(ForumTestView.this.fXC);
                            ForumTestView.this.fXy.remove(ForumTestView.this.fXC.getData());
                            ForumTestView.this.kK(true);
                            ForumTestView.this.fXU = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fXD, floatValue, abs);
                            if ((ForumTestView.this.fXF * 2) / 5 >= ForumTestView.this.fXC.getViewRight() - ForumTestView.this.fXC.getViewLeft()) {
                                ForumTestView.this.fXC.setAlpha(0.0f);
                                ForumTestView.this.fXC.setVisibility(8);
                            } else {
                                ForumTestView.this.fXC.setViewLeft(ForumTestView.this.fXC.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fXC.setViewRight(ForumTestView.this.fXC.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fXC.setViewTop(ForumTestView.this.fXC.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fXC.setViewBottom(ForumTestView.this.fXC.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fXC.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fXF * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fXP * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.fXQ;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.fXC.setAlpha(0.0f);
                        ForumTestView.this.fXC.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fXD);
                        ForumTestView.this.d(ForumTestView.this.fXC);
                        ForumTestView.this.d(ForumTestView.this.fXE);
                        ForumTestView.this.fXy.remove(ForumTestView.this.fXC.getData());
                        if (ForumTestView.this.fXz.getIndex() == 0) {
                            if (ForumTestView.this.fXz.getDataIndex() > ForumTestView.this.fXE.getDataIndex()) {
                                ForumTestView.this.fXz.setDataIndex(ForumTestView.this.fXz.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fXz);
                            }
                        } else if (ForumTestView.this.fXA.getIndex() == 0) {
                            if (ForumTestView.this.fXA.getDataIndex() > ForumTestView.this.fXE.getDataIndex()) {
                                ForumTestView.this.fXA.setDataIndex(ForumTestView.this.fXA.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fXA);
                            }
                        } else if (ForumTestView.this.fXB.getDataIndex() > ForumTestView.this.fXE.getDataIndex()) {
                            ForumTestView.this.fXB.setDataIndex(ForumTestView.this.fXB.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fXB);
                        }
                        if (ForumTestView.this.fXD.getDataIndex() > ForumTestView.this.fXE.getDataIndex()) {
                            ForumTestView.this.fXD.setDataIndex(ForumTestView.this.fXD.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fXD);
                        }
                        ForumTestView.this.fXE.setDataIndex(ForumTestView.this.fXE.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fXE);
                        ForumTestView.this.kK(true);
                        ForumTestView.this.fXU = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fXD, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fXE, floatValue2);
                        if ((ForumTestView.this.fXF * 2) / 5 >= ForumTestView.this.fXC.getViewRight() - ForumTestView.this.fXC.getViewLeft()) {
                            ForumTestView.this.fXC.setAlpha(0.0f);
                            ForumTestView.this.fXC.setVisibility(8);
                        } else {
                            ForumTestView.this.fXC.setViewLeft(ForumTestView.this.fXC.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fXC.setViewRight(ForumTestView.this.fXC.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fXC.setViewTop(ForumTestView.this.fXC.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fXC.setViewBottom(ForumTestView.this.fXC.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fXC.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fXF * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.fXQ * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.fXC.setAlpha(0.0f);
                    ForumTestView.this.fXC.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.fXy.remove(ForumTestView.this.fXC.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.fXX != null) {
                        ForumTestView.this.fXX.dq(-1L);
                    }
                    ForumTestView.this.fXU = false;
                    if (ForumTestView.this.fXX != null && v.isEmpty(ForumTestView.this.fXy)) {
                        ForumTestView.this.fXX.bze();
                    }
                } else {
                    ForumTestView.this.fXC.setViewLeft(ForumTestView.this.fXC.getMoveLeft() + floatValue3);
                    ForumTestView.this.fXC.setViewRight(ForumTestView.this.fXC.getMoveRight() - floatValue3);
                    ForumTestView.this.fXC.setViewTop(ForumTestView.this.fXC.getMoveTop() + f);
                    ForumTestView.this.fXC.setViewBottom(ForumTestView.this.fXC.getMoveBottom() - f);
                    ForumTestView.this.fXC.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.fYa) {
                this.fYa = equipmentWidth;
                eO(getContext());
                d(this.fXz);
                d(this.fXA);
                d(this.fXB);
                d(this.fXC);
            }
            a(this.fXz);
            a(this.fXA);
            a(this.fXB);
            a(this.fXC);
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
            this.fXz.layout((int) this.fXz.getViewLeft(), (int) this.fXz.getViewTop(), (int) this.fXz.getViewRight(), (int) this.fXz.getViewBottom());
            this.fXA.layout((int) this.fXA.getViewLeft(), (int) this.fXA.getViewTop(), (int) this.fXA.getViewRight(), (int) this.fXA.getViewBottom());
            this.fXB.layout((int) this.fXB.getViewLeft(), (int) this.fXB.getViewTop(), (int) this.fXB.getViewRight(), (int) this.fXB.getViewBottom());
            this.fXC.layout((int) this.fXC.getViewLeft(), (int) this.fXC.getViewTop(), (int) this.fXC.getViewRight(), (int) this.fXC.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.fXT == null || !this.fXT.isRunning()) {
            if (this.fXS == null || !this.fXS.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fXS != null) {
                        this.fXS.removeAllUpdateListeners();
                        this.fXS.cancel();
                    }
                    this.fXW = motionEvent.getPointerId(0);
                    this.fXN = x;
                    this.fXO = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fXN - x;
                    float f2 = this.fXO - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.mIsMove = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.mIsMove) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fXP * f3;
                    if (this.mIsMove) {
                        b(this.fXz, f3, f4);
                        b(this.fXA, f3, f4);
                        b(this.fXB, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Bv);
                    float xVelocity = velocityTracker.getXVelocity(this.fXW);
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
            if (this.fXy.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fXM[0].right - (this.fXF / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fXM[0].right - (this.fXF / 2))) + this.fXM[2].left + (this.fXF / 2) + this.fXL);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fXF);
                    cellForumTestView.setViewTop(this.fXM[2].top);
                    cellForumTestView.setViewBottom(this.fXM[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fXy.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fXM[2].left + (this.fXF / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fXM[2].left + (this.fXF / 2))) + ((this.fXM[0].right - (this.fXF / 2)) - this.fXL));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fXF);
                    cellForumTestView.setViewTop(this.fXM[0].top);
                    cellForumTestView.setViewBottom(this.fXM[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fXy.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fXM[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fXM[0].top) {
                    cellForumTestView.setViewTop(this.fXM[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fXM[0].bottom) {
                    cellForumTestView.setViewBottom(this.fXM[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fXM[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fXM[1].top) {
                    cellForumTestView.setViewTop(this.fXM[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fXM[1].bottom) {
                    cellForumTestView.setViewBottom(this.fXM[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.fXX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(boolean z) {
        if (this.fXX != null) {
            int i = -1;
            if (this.fXz.getIndex() == 1 && this.fXz.getData() != null) {
                this.fXX.dq(this.fXz.getData().testId);
                i = this.fXz.getDataIndex();
            } else if (this.fXA.getIndex() == 1 && this.fXA.getData() != null) {
                this.fXX.dq(this.fXA.getData().testId);
                i = this.fXA.getDataIndex();
            } else if (this.fXB.getIndex() == 1 && this.fXB.getData() != null) {
                this.fXX.dq(this.fXB.getData().testId);
                i = this.fXB.getDataIndex();
            } else {
                this.fXX.dq(-1L);
            }
            if (z) {
                rX(i);
            }
        }
    }

    private void initAnimation() {
        this.fXS = ValueAnimator.ofFloat(this.fXF, 0.0f);
        this.fXS.setDuration(200L);
        this.fXS.setInterpolator(new DecelerateInterpolator());
        this.fXS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.fXF) * 0.2f;
                    if (ForumTestView.this.fXY) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bzb();
                        } else {
                            ForumTestView.this.bzc();
                        }
                        ForumTestView.this.fXY = false;
                    }
                    ForumTestView.this.fXZ = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fXz);
                    ForumTestView.this.d(ForumTestView.this.fXA);
                    ForumTestView.this.d(ForumTestView.this.fXB);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.kK(z);
                } else {
                    if (ForumTestView.this.fXY) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.rV(2) != null && ForumTestView.this.rV(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bzb();
                                ForumTestView.this.fXY = false;
                            }
                        } else if (ForumTestView.this.rV(0) != null && ForumTestView.this.rV(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bzc();
                            ForumTestView.this.fXY = false;
                        }
                    }
                    float f = ForumTestView.this.fXZ - floatValue;
                    float f2 = ForumTestView.this.fXP * f;
                    ForumTestView.this.b(ForumTestView.this.fXz, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fXA, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fXB, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fXZ = floatValue;
            }
        });
    }

    private void aw(float f) {
        CellForumTestView rV;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fXY = false;
        this.fXZ = 0.0f;
        initAnimation();
        if (this.fXy.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fXz.getVisibility() == 0) {
                cellForumTestView3 = this.fXz;
            }
            if (this.fXA.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fXA;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fXA;
            }
            if (this.fXB.getVisibility() == 0) {
                cellForumTestView2 = this.fXB;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fXM[0].left) || viewRight > ((float) this.fXM[2].right)) && Math.abs(this.mDistance) >= this.fXF * 0.2f) {
                this.fXY = true;
            }
        } else if (this.fXy.size() > 2 && Math.abs(this.mDistance) >= this.fXF * 0.2f) {
            this.fXY = true;
        }
        if (this.fXY && (rV = rV(1)) != null) {
            if (this.mDistance >= this.fXF) {
                this.mDistance -= this.fXF;
                this.fXY = false;
                bzc();
            } else if (this.mDistance > 0.0f && this.mDistance < this.fXF) {
                this.mDistance = this.fXM[0].right - rV.getViewRight();
            } else if (this.mDistance > (-this.fXF)) {
                this.mDistance = this.fXM[2].left - rV.getViewLeft();
            } else {
                bzb();
                this.mDistance += this.fXF;
                this.fXY = false;
            }
        }
        this.fXS.setFloatValues(0.0f, this.mDistance);
        this.fXS.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzb() {
        this.fXz.setIndex(this.fXz.getIndex() + 1);
        this.fXA.setIndex(this.fXA.getIndex() + 1);
        this.fXB.setIndex(this.fXB.getIndex() + 1);
        b(this.fXz);
        b(this.fXA);
        b(this.fXB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzc() {
        this.fXz.setIndex(this.fXz.getIndex() - 1);
        this.fXA.setIndex(this.fXA.getIndex() - 1);
        this.fXB.setIndex(this.fXB.getIndex() - 1);
        b(this.fXz);
        b(this.fXA);
        b(this.fXB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView rV(int i) {
        if (this.fXz.getIndex() == i) {
            return this.fXz;
        }
        if (this.fXA.getIndex() == i) {
            return this.fXA;
        }
        if (this.fXB.getIndex() == i) {
            return this.fXB;
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
            int size = this.fXy.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int rW(int i) {
        int size = this.fXy.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fXM[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fXM[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fXM[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fXM[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.mIsMove && this.mDistance == 0.0f) {
            this.fXy = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.fXz.setVisibility(0);
                this.fXA.setVisibility(0);
                this.fXB.setVisibility(0);
                this.fXz.setData(list.get(0));
                this.fXA.setData(list.get(1));
                this.fXB.setData(list.get(2));
                this.fXz.setDataIndex(0);
                this.fXA.setDataIndex(1);
                this.fXB.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.fXz.setVisibility(8);
                this.fXA.setVisibility(0);
                this.fXB.setVisibility(0);
                this.fXA.setDataIndex(1);
                this.fXB.setDataIndex(0);
                this.fXA.setData(list.get(1));
                this.fXB.setData(list.get(0));
                i = 1;
            } else {
                this.fXz.setVisibility(8);
                this.fXA.setVisibility(0);
                this.fXB.setVisibility(8);
                this.fXA.setDataIndex(0);
                this.fXA.setData(list.get(0));
                i = 0;
            }
            rX(i);
        }
    }

    private void resetData() {
        this.fXz.setIndex(0);
        this.fXA.setIndex(1);
        this.fXB.setIndex(2);
        this.fXC.setIndex(1);
        d(this.fXz);
        d(this.fXA);
        d(this.fXB);
        d(this.fXC);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void rU(int i) {
        CellForumTestView cellForumTestView;
        this.fXU = true;
        this.fXC.setVisibility(0);
        this.fXC.setAlpha(1.0f);
        bzd();
        if (this.fXz.getIndex() == i && this.fXz.getVisibility() == 0) {
            cellForumTestView = this.fXz;
        } else if (this.fXA.getIndex() == i && this.fXA.getVisibility() == 0) {
            cellForumTestView = this.fXA;
        } else {
            cellForumTestView = this.fXB;
        }
        this.fXC.setData(cellForumTestView.getData());
        this.fXC.setDataIndex(cellForumTestView.getDataIndex());
        this.fXE = null;
        if (this.fXy.size() == 1) {
            this.fXV = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.fXF * 3) / 5;
        } else if (this.fXy.size() == 2) {
            this.fXV = 2;
            cellForumTestView.setVisibility(8);
            if (this.fXz.getVisibility() == 0) {
                this.fXD = this.fXz;
            } else if (this.fXA.getVisibility() == 0) {
                this.fXD = this.fXA;
            } else {
                this.fXD = this.fXB;
            }
            if (this.fXD.getViewRight() < this.fXM[1].left) {
                this.mDistance = this.fXF + this.fXL;
                this.fXD.setIndex(this.fXD.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fXD.getViewLeft() > this.fXM[1].right) {
                this.mDistance = (-this.fXF) - this.fXL;
                this.fXD.setIndex(this.fXD.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fXD);
            b(cellForumTestView);
        } else if (this.fXy.size() == 3) {
            this.fXV = 3;
            cellForumTestView.setVisibility(8);
            if (this.fXz.getIndex() == 2) {
                this.fXD = this.fXz;
            } else if (this.fXA.getIndex() == 2) {
                this.fXD = this.fXA;
            } else {
                this.fXD = this.fXB;
            }
            this.mDistance = (-this.fXF) - this.fXL;
            this.fXD.setIndex(this.fXD.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fXD);
            b(cellForumTestView);
        } else {
            this.fXV = 4;
            this.fXE = cellForumTestView;
            if (this.fXz.getIndex() == 2) {
                this.fXD = this.fXz;
            } else if (this.fXA.getIndex() == 2) {
                this.fXD = this.fXA;
            } else {
                this.fXD = this.fXB;
            }
            this.mDistance = (-this.fXF) - this.fXL;
            this.fXD.setIndex(this.fXD.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fXD);
            b(cellForumTestView);
            this.fXE.setViewLeft(this.fXM[2].right + this.fXL);
            this.fXE.setViewRight(this.fXM[2].right + this.fXL + this.fXF);
            this.fXE.setViewTop(this.fXM[2].top);
            this.fXE.setViewBottom(this.fXM[2].bottom);
            this.fXE.setMoveLeft(this.fXM[2].right + this.fXL);
            this.fXE.setMoveRight(this.fXM[2].right + this.fXL + this.fXF);
            this.fXE.setMoveTop(this.fXM[2].top);
            this.fXE.setMoveBottom(this.fXM[2].bottom);
            this.fXE.setData(this.fXy.get(rW(this.fXE.getDataIndex() + 2)));
        }
        this.fXT.setFloatValues(0.0f, this.mDistance);
        this.fXT.start();
    }

    private void bzd() {
        this.fXz.setMoveLeft(this.fXz.getViewLeft());
        this.fXz.setMoveTop(this.fXz.getViewTop());
        this.fXz.setMoveRight(this.fXz.getViewRight());
        this.fXz.setMoveBottom(this.fXz.getViewBottom());
        this.fXA.setMoveLeft(this.fXA.getViewLeft());
        this.fXA.setMoveTop(this.fXA.getViewTop());
        this.fXA.setMoveRight(this.fXA.getViewRight());
        this.fXA.setMoveBottom(this.fXA.getViewBottom());
        this.fXB.setMoveLeft(this.fXB.getViewLeft());
        this.fXB.setMoveTop(this.fXB.getViewTop());
        this.fXB.setMoveRight(this.fXB.getViewRight());
        this.fXB.setMoveBottom(this.fXB.getViewBottom());
        this.fXC.setMoveLeft(this.fXC.getViewLeft());
        this.fXC.setMoveTop(this.fXC.getViewTop());
        this.fXC.setMoveRight(this.fXC.getViewRight());
        this.fXC.setMoveBottom(this.fXC.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.fXz.onChangeSkinType();
            this.fXA.onChangeSkinType();
            this.fXB.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.mIsMove && this.mDistance == 0.0f) {
            if (this.fXS != null) {
                this.fXS.removeAllUpdateListeners();
                this.fXS.cancel();
            }
            if (this.fXT != null) {
                this.fXT.removeAllUpdateListeners();
                this.fXT.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fXz != null) {
            this.fXz.setPageId(bdUniqueId);
        }
        if (this.fXA != null) {
            this.fXA.setPageId(bdUniqueId);
        }
        if (this.fXB != null) {
            this.fXB.setPageId(bdUniqueId);
        }
    }

    public void rX(int i) {
        f fVar;
        an a2;
        if (this.fXy != null && i >= 0 && i < this.fXy.size() && (fVar = this.fXy.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.cJY().a(this.mPageId, com.baidu.tieba.s.a.IP("" + fVar.testId), a2);
        }
    }
}
