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
/* loaded from: classes4.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private List<f> feA;
    private CellForumTestView feB;
    private CellForumTestView feC;
    private CellForumTestView feD;
    private CellForumTestView feE;
    private CellForumTestView feF;
    private CellForumTestView feG;
    private int feH;
    private int feI;
    private int feJ;
    private int feK;
    private int feL;
    private int feM;
    private int feN;
    private Rect[] feO;
    private float feP;
    private float feQ;
    private float feR;
    private float feS;
    private float feT;
    private ValueAnimator feU;
    private float feV;
    private ValueAnimator feW;
    private boolean feX;
    private boolean feY;
    private int feZ;
    private int ffa;
    private a ffb;
    private boolean ffc;
    private float ffd;
    private int ffe;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;
    private int yV;

    /* loaded from: classes4.dex */
    public interface a {
        void cG(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.feO = new Rect[3];
        this.feX = false;
        this.feY = false;
        this.ffc = false;
        this.ffd = 0.0f;
        this.ffe = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.feO = new Rect[3];
        this.feX = false;
        this.feY = false;
        this.ffc = false;
        this.ffd = 0.0f;
        this.ffe = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.feO = new Rect[3];
        this.feX = false;
        this.feY = false;
        this.ffc = false;
        this.ffd = 0.0f;
        this.ffe = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.feB = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.feC = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.feD = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.feE = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        ds(context);
        resetData();
        ViewConfiguration.get(context);
        this.yV = ViewConfiguration.getMaximumFlingVelocity();
        this.feB.setForumTestDelClickListener(this);
        this.feC.setForumTestDelClickListener(this);
        this.feD.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void ds(Context context) {
        this.feL = l.getDimens(context, R.dimen.tbds44);
        this.feM = l.getDimens(context, R.dimen.tbds30);
        this.feN = l.getDimens(context, R.dimen.tbds7);
        this.feK = l.getDimens(context, R.dimen.tbds730);
        this.feJ = this.feK - (this.feM * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.feH = (int) (this.mWidth * 0.89f);
        this.mHeight = this.feK + this.feL;
        this.feI = ((this.mWidth - this.feH) - (this.feN * 2)) / 2;
        this.feR = this.feM / (this.feH + this.feN);
        this.feS = this.feK / this.feH;
        this.feT = this.feH / (this.feH + this.feN);
        this.feO[0] = new Rect(this.feI - this.feH, this.feL + this.feM, this.feI, this.feL + this.feM + this.feJ);
        this.feO[1] = new Rect(this.feI + this.feN, this.feL, this.feI + this.feN + this.feH, this.feL + this.feK);
        this.feO[2] = new Rect(this.mWidth - this.feI, this.feL + this.feM, (this.mWidth - this.feI) + this.feH, this.feL + this.feM + this.feJ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.feW = ValueAnimator.ofFloat(this.feH, 0.0f);
        this.feW.setDuration(500L);
        this.feW.setInterpolator(new DecelerateInterpolator());
        this.feW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.feZ != 1) {
                    if (ForumTestView.this.feZ == 2 || ForumTestView.this.feZ == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.feR * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.feS;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.feV)) {
                            ForumTestView.this.feE.setAlpha(0.0f);
                            ForumTestView.this.feE.setVisibility(8);
                            ForumTestView.this.feV = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.feF);
                            ForumTestView.this.d(ForumTestView.this.feE);
                            ForumTestView.this.feA.remove(ForumTestView.this.feE.getData());
                            ForumTestView.this.jk(true);
                            ForumTestView.this.feY = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.feF, floatValue, abs);
                            if ((ForumTestView.this.feH * 2) / 5 >= ForumTestView.this.feE.getViewRight() - ForumTestView.this.feE.getViewLeft()) {
                                ForumTestView.this.feE.setAlpha(0.0f);
                                ForumTestView.this.feE.setVisibility(8);
                            } else {
                                ForumTestView.this.feE.setViewLeft(ForumTestView.this.feE.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.feE.setViewRight(ForumTestView.this.feE.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.feE.setViewTop(ForumTestView.this.feE.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.feE.setViewBottom(ForumTestView.this.feE.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.feE.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.feH * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.feR * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.feS;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.feV)) {
                        ForumTestView.this.feE.setAlpha(0.0f);
                        ForumTestView.this.feE.setVisibility(8);
                        ForumTestView.this.feV = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.feF);
                        ForumTestView.this.d(ForumTestView.this.feE);
                        ForumTestView.this.d(ForumTestView.this.feG);
                        ForumTestView.this.feA.remove(ForumTestView.this.feE.getData());
                        if (ForumTestView.this.feB.getIndex() == 0) {
                            if (ForumTestView.this.feB.getDataIndex() > ForumTestView.this.feG.getDataIndex()) {
                                ForumTestView.this.feB.setDataIndex(ForumTestView.this.feB.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.feB);
                            }
                        } else if (ForumTestView.this.feC.getIndex() == 0) {
                            if (ForumTestView.this.feC.getDataIndex() > ForumTestView.this.feG.getDataIndex()) {
                                ForumTestView.this.feC.setDataIndex(ForumTestView.this.feC.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.feC);
                            }
                        } else if (ForumTestView.this.feD.getDataIndex() > ForumTestView.this.feG.getDataIndex()) {
                            ForumTestView.this.feD.setDataIndex(ForumTestView.this.feD.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.feD);
                        }
                        if (ForumTestView.this.feF.getDataIndex() > ForumTestView.this.feG.getDataIndex()) {
                            ForumTestView.this.feF.setDataIndex(ForumTestView.this.feF.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.feF);
                        }
                        ForumTestView.this.feG.setDataIndex(ForumTestView.this.feG.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.feG);
                        ForumTestView.this.jk(true);
                        ForumTestView.this.feY = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.feF, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.feG, floatValue2);
                        if ((ForumTestView.this.feH * 2) / 5 >= ForumTestView.this.feE.getViewRight() - ForumTestView.this.feE.getViewLeft()) {
                            ForumTestView.this.feE.setAlpha(0.0f);
                            ForumTestView.this.feE.setVisibility(8);
                        } else {
                            ForumTestView.this.feE.setViewLeft(ForumTestView.this.feE.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.feE.setViewRight(ForumTestView.this.feE.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.feE.setViewTop(ForumTestView.this.feE.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.feE.setViewBottom(ForumTestView.this.feE.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.feE.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.feH * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.feS * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.feV / 2.0f)) {
                    ForumTestView.this.feE.setAlpha(0.0f);
                    ForumTestView.this.feE.setVisibility(8);
                    ForumTestView.this.feV = 0.0f;
                    ForumTestView.this.feA.remove(ForumTestView.this.feE.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.ffb != null) {
                        ForumTestView.this.ffb.cG(-1L);
                    }
                    ForumTestView.this.feY = false;
                } else {
                    ForumTestView.this.feE.setViewLeft(ForumTestView.this.feE.getMoveLeft() + floatValue3);
                    ForumTestView.this.feE.setViewRight(ForumTestView.this.feE.getMoveRight() - floatValue3);
                    ForumTestView.this.feE.setViewTop(ForumTestView.this.feE.getMoveTop() + f);
                    ForumTestView.this.feE.setViewBottom(ForumTestView.this.feE.getMoveBottom() - f);
                    ForumTestView.this.feE.setAlpha(1.0f - (floatValue3 / ForumTestView.this.feV));
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
            if (equipmentWidth != this.ffe) {
                this.ffe = equipmentWidth;
                ds(getContext());
                d(this.feB);
                d(this.feC);
                d(this.feD);
                d(this.feE);
            }
            a(this.feB);
            a(this.feC);
            a(this.feD);
            a(this.feE);
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
            this.feB.layout((int) this.feB.getViewLeft(), (int) this.feB.getViewTop(), (int) this.feB.getViewRight(), (int) this.feB.getViewBottom());
            this.feC.layout((int) this.feC.getViewLeft(), (int) this.feC.getViewTop(), (int) this.feC.getViewRight(), (int) this.feC.getViewBottom());
            this.feD.layout((int) this.feD.getViewLeft(), (int) this.feD.getViewTop(), (int) this.feD.getViewRight(), (int) this.feD.getViewBottom());
            this.feE.layout((int) this.feE.getViewLeft(), (int) this.feE.getViewTop(), (int) this.feE.getViewRight(), (int) this.feE.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.feW == null || !this.feW.isRunning()) {
            if (this.feU == null || !this.feU.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.feU != null) {
                        this.feU.removeAllUpdateListeners();
                        this.feU.cancel();
                    }
                    this.ffa = motionEvent.getPointerId(0);
                    this.feP = x;
                    this.feQ = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.feP - x;
                    float f2 = this.feQ - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.feX = true;
                        this.feV = f;
                    } else if (Math.abs(f2) > 30.0f && !this.feX) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.feR * f3;
                    if (this.feX) {
                        b(this.feB, f3, f4);
                        b(this.feC, f3, f4);
                        b(this.feD, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.yV);
                    float xVelocity = velocityTracker.getXVelocity(this.ffa);
                    if (this.feX || this.feV != 0.0f) {
                        ak(xVelocity);
                    }
                    this.feX = false;
                    releaseVelocityTracker();
                }
                if (this.feX || this.feV != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.feA.size() > 2) {
                if (cellForumTestView.getViewRight() < this.feO[0].right - (this.feH / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.feO[0].right - (this.feH / 2))) + this.feO[2].left + (this.feH / 2) + this.feN);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.feH);
                    cellForumTestView.setViewTop(this.feO[2].top);
                    cellForumTestView.setViewBottom(this.feO[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.feA.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.feO[2].left + (this.feH / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.feO[2].left + (this.feH / 2))) + ((this.feO[0].right - (this.feH / 2)) - this.feN));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.feH);
                    cellForumTestView.setViewTop(this.feO[0].top);
                    cellForumTestView.setViewBottom(this.feO[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.feA.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.feO[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.feO[0].top) {
                    cellForumTestView.setViewTop(this.feO[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.feO[0].bottom) {
                    cellForumTestView.setViewBottom(this.feO[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.feO[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.feO[1].top) {
                    cellForumTestView.setViewTop(this.feO[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.feO[1].bottom) {
                    cellForumTestView.setViewBottom(this.feO[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.ffb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(boolean z) {
        if (this.ffb != null) {
            int i = -1;
            if (this.feB.getIndex() == 1 && this.feB.getData() != null) {
                this.ffb.cG(this.feB.getData().testId);
                i = this.feB.getDataIndex();
            } else if (this.feC.getIndex() == 1 && this.feC.getData() != null) {
                this.ffb.cG(this.feC.getData().testId);
                i = this.feC.getDataIndex();
            } else if (this.feD.getIndex() == 1 && this.feD.getData() != null) {
                this.ffb.cG(this.feD.getData().testId);
                i = this.feD.getDataIndex();
            } else {
                this.ffb.cG(-1L);
            }
            if (z) {
                pH(i);
            }
        }
    }

    private void wI() {
        this.feU = ValueAnimator.ofFloat(this.feH, 0.0f);
        this.feU.setDuration(200L);
        this.feU.setInterpolator(new DecelerateInterpolator());
        this.feU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.feV)) {
                    boolean z = Math.abs(ForumTestView.this.feV) >= ((float) ForumTestView.this.feH) * 0.2f;
                    if (ForumTestView.this.ffc) {
                        if (ForumTestView.this.feV > 0.0f) {
                            ForumTestView.this.bff();
                        } else {
                            ForumTestView.this.bfg();
                        }
                        ForumTestView.this.ffc = false;
                    }
                    ForumTestView.this.ffd = 0.0f;
                    ForumTestView.this.feV = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.feB);
                    ForumTestView.this.d(ForumTestView.this.feC);
                    ForumTestView.this.d(ForumTestView.this.feD);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.jk(z);
                } else {
                    if (ForumTestView.this.ffc) {
                        if (ForumTestView.this.feV > 0.0f) {
                            if (ForumTestView.this.pF(2) != null && ForumTestView.this.pF(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bff();
                                ForumTestView.this.ffc = false;
                            }
                        } else if (ForumTestView.this.pF(0) != null && ForumTestView.this.pF(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bfg();
                            ForumTestView.this.ffc = false;
                        }
                    }
                    float f = ForumTestView.this.ffd - floatValue;
                    float f2 = ForumTestView.this.feR * f;
                    ForumTestView.this.b(ForumTestView.this.feB, f, f2);
                    ForumTestView.this.b(ForumTestView.this.feC, f, f2);
                    ForumTestView.this.b(ForumTestView.this.feD, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.ffd = floatValue;
            }
        });
    }

    private void ak(float f) {
        CellForumTestView pF;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.ffc = false;
        this.ffd = 0.0f;
        wI();
        if (this.feA.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.feB.getVisibility() == 0) {
                cellForumTestView3 = this.feB;
            }
            if (this.feC.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.feC;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.feC;
            }
            if (this.feD.getVisibility() == 0) {
                cellForumTestView2 = this.feD;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.feO[0].left) || viewRight > ((float) this.feO[2].right)) && Math.abs(this.feV) >= this.feH * 0.2f) {
                this.ffc = true;
            }
        } else if (this.feA.size() > 2 && Math.abs(this.feV) >= this.feH * 0.2f) {
            this.ffc = true;
        }
        if (this.ffc && (pF = pF(1)) != null) {
            if (this.feV >= this.feH) {
                this.feV -= this.feH;
                this.ffc = false;
                bfg();
            } else if (this.feV > 0.0f && this.feV < this.feH) {
                this.feV = this.feO[0].right - pF.getViewRight();
            } else if (this.feV > (-this.feH)) {
                this.feV = this.feO[2].left - pF.getViewLeft();
            } else {
                bff();
                this.feV += this.feH;
                this.ffc = false;
            }
        }
        this.feU.setFloatValues(0.0f, this.feV);
        this.feU.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bff() {
        this.feB.setIndex(this.feB.getIndex() + 1);
        this.feC.setIndex(this.feC.getIndex() + 1);
        this.feD.setIndex(this.feD.getIndex() + 1);
        b(this.feB);
        b(this.feC);
        b(this.feD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfg() {
        this.feB.setIndex(this.feB.getIndex() - 1);
        this.feC.setIndex(this.feC.getIndex() - 1);
        this.feD.setIndex(this.feD.getIndex() - 1);
        b(this.feB);
        b(this.feC);
        b(this.feD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView pF(int i) {
        if (this.feB.getIndex() == i) {
            return this.feB;
        }
        if (this.feC.getIndex() == i) {
            return this.feC;
        }
        if (this.feD.getIndex() == i) {
            return this.feD;
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
            int size = this.feA.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int pG(int i) {
        int size = this.feA.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.feO[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.feO[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.feO[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.feO[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.feX && this.feV == 0.0f) {
            this.feA = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.feB.setVisibility(0);
                this.feC.setVisibility(0);
                this.feD.setVisibility(0);
                this.feB.setData(list.get(0));
                this.feC.setData(list.get(1));
                this.feD.setData(list.get(2));
                this.feB.setDataIndex(0);
                this.feC.setDataIndex(1);
                this.feD.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.feB.setVisibility(8);
                this.feC.setVisibility(0);
                this.feD.setVisibility(0);
                this.feC.setDataIndex(1);
                this.feD.setDataIndex(0);
                this.feC.setData(list.get(1));
                this.feD.setData(list.get(0));
                i = 1;
            } else {
                this.feB.setVisibility(8);
                this.feC.setVisibility(0);
                this.feD.setVisibility(8);
                this.feC.setDataIndex(0);
                this.feC.setData(list.get(0));
                i = 0;
            }
            pH(i);
        }
    }

    private void resetData() {
        this.feB.setIndex(0);
        this.feC.setIndex(1);
        this.feD.setIndex(2);
        this.feE.setIndex(1);
        d(this.feB);
        d(this.feC);
        d(this.feD);
        d(this.feE);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void pE(int i) {
        CellForumTestView cellForumTestView;
        this.feY = true;
        this.feE.setVisibility(0);
        this.feE.setAlpha(1.0f);
        bfh();
        if (this.feB.getIndex() == i && this.feB.getVisibility() == 0) {
            cellForumTestView = this.feB;
        } else if (this.feC.getIndex() == i && this.feC.getVisibility() == 0) {
            cellForumTestView = this.feC;
        } else {
            cellForumTestView = this.feD;
        }
        this.feE.setData(cellForumTestView.getData());
        this.feE.setDataIndex(cellForumTestView.getDataIndex());
        this.feG = null;
        if (this.feA.size() == 1) {
            this.feZ = 1;
            cellForumTestView.setVisibility(8);
            this.feV = (this.feH * 3) / 5;
        } else if (this.feA.size() == 2) {
            this.feZ = 2;
            cellForumTestView.setVisibility(8);
            if (this.feB.getVisibility() == 0) {
                this.feF = this.feB;
            } else if (this.feC.getVisibility() == 0) {
                this.feF = this.feC;
            } else {
                this.feF = this.feD;
            }
            if (this.feF.getViewRight() < this.feO[1].left) {
                this.feV = this.feH + this.feN;
                this.feF.setIndex(this.feF.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.feF.getViewLeft() > this.feO[1].right) {
                this.feV = (-this.feH) - this.feN;
                this.feF.setIndex(this.feF.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.feF);
            b(cellForumTestView);
        } else if (this.feA.size() == 3) {
            this.feZ = 3;
            cellForumTestView.setVisibility(8);
            if (this.feB.getIndex() == 2) {
                this.feF = this.feB;
            } else if (this.feC.getIndex() == 2) {
                this.feF = this.feC;
            } else {
                this.feF = this.feD;
            }
            this.feV = (-this.feH) - this.feN;
            this.feF.setIndex(this.feF.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.feF);
            b(cellForumTestView);
        } else {
            this.feZ = 4;
            this.feG = cellForumTestView;
            if (this.feB.getIndex() == 2) {
                this.feF = this.feB;
            } else if (this.feC.getIndex() == 2) {
                this.feF = this.feC;
            } else {
                this.feF = this.feD;
            }
            this.feV = (-this.feH) - this.feN;
            this.feF.setIndex(this.feF.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.feF);
            b(cellForumTestView);
            this.feG.setViewLeft(this.feO[2].right + this.feN);
            this.feG.setViewRight(this.feO[2].right + this.feN + this.feH);
            this.feG.setViewTop(this.feO[2].top);
            this.feG.setViewBottom(this.feO[2].bottom);
            this.feG.setMoveLeft(this.feO[2].right + this.feN);
            this.feG.setMoveRight(this.feO[2].right + this.feN + this.feH);
            this.feG.setMoveTop(this.feO[2].top);
            this.feG.setMoveBottom(this.feO[2].bottom);
            this.feG.setData(this.feA.get(pG(this.feG.getDataIndex() + 2)));
        }
        this.feW.setFloatValues(0.0f, this.feV);
        this.feW.start();
    }

    private void bfh() {
        this.feB.setMoveLeft(this.feB.getViewLeft());
        this.feB.setMoveTop(this.feB.getViewTop());
        this.feB.setMoveRight(this.feB.getViewRight());
        this.feB.setMoveBottom(this.feB.getViewBottom());
        this.feC.setMoveLeft(this.feC.getViewLeft());
        this.feC.setMoveTop(this.feC.getViewTop());
        this.feC.setMoveRight(this.feC.getViewRight());
        this.feC.setMoveBottom(this.feC.getViewBottom());
        this.feD.setMoveLeft(this.feD.getViewLeft());
        this.feD.setMoveTop(this.feD.getViewTop());
        this.feD.setMoveRight(this.feD.getViewRight());
        this.feD.setMoveBottom(this.feD.getViewBottom());
        this.feE.setMoveLeft(this.feE.getViewLeft());
        this.feE.setMoveTop(this.feE.getViewTop());
        this.feE.setMoveRight(this.feE.getViewRight());
        this.feE.setMoveBottom(this.feE.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.feB.onChangeSkinType();
            this.feC.onChangeSkinType();
            this.feD.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.feX && this.feV == 0.0f) {
            if (this.feU != null) {
                this.feU.removeAllUpdateListeners();
                this.feU.cancel();
            }
            if (this.feW != null) {
                this.feW.removeAllUpdateListeners();
                this.feW.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.feB != null) {
            this.feB.setPageId(bdUniqueId);
        }
        if (this.feC != null) {
            this.feC.setPageId(bdUniqueId);
        }
        if (this.feD != null) {
            this.feD.setPageId(bdUniqueId);
        }
    }

    public void pH(int i) {
        f fVar;
        an a2;
        if (this.feA != null && i >= 0 && i < this.feA.size() && (fVar = this.feA.get(i)) != null && (a2 = com.baidu.tieba.q.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.q.c.cnk().a(this.mPageId, "enterfourm_rec_" + fVar.testId, a2);
        }
    }
}
