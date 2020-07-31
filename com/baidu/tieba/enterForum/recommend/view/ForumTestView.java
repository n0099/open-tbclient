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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes16.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int VC;
    private int hmA;
    private int hmB;
    private int hmC;
    private int hmD;
    private int hmE;
    private Rect[] hmF;
    private float hmG;
    private float hmH;
    private float hmI;
    private float hmJ;
    private float hmK;
    private ValueAnimator hmL;
    private ValueAnimator hmM;
    private boolean hmN;
    private boolean hmO;
    private int hmP;
    private int hmQ;
    private a hmR;
    private boolean hmS;
    private float hmT;
    private int hmU;
    private List<f> hmr;
    private CellForumTestView hms;
    private CellForumTestView hmt;
    private CellForumTestView hmu;
    private CellForumTestView hmv;
    private CellForumTestView hmw;
    private CellForumTestView hmx;
    private int hmy;
    private int hmz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void bWe();

        void eq(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hmF = new Rect[3];
        this.hmN = false;
        this.hmO = false;
        this.hmS = false;
        this.hmT = 0.0f;
        this.hmU = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hmF = new Rect[3];
        this.hmN = false;
        this.hmO = false;
        this.hmS = false;
        this.hmT = 0.0f;
        this.hmU = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hmF = new Rect[3];
        this.hmN = false;
        this.hmO = false;
        this.hmS = false;
        this.hmT = 0.0f;
        this.hmU = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.hms = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.hmt = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.hmu = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.hmv = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eN(context);
        resetData();
        ViewConfiguration.get(context);
        this.VC = ViewConfiguration.getMaximumFlingVelocity();
        this.hms.setForumTestDelClickListener(this);
        this.hmt.setForumTestDelClickListener(this);
        this.hmu.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eN(Context context) {
        this.hmC = l.getDimens(context, R.dimen.tbds44);
        this.hmD = l.getDimens(context, R.dimen.tbds30);
        this.hmE = l.getDimens(context, R.dimen.tbds7);
        this.hmB = l.getDimens(context, R.dimen.tbds730);
        this.hmA = this.hmB - (this.hmD * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.hmy = (int) (this.mWidth * 0.89f);
        this.mHeight = this.hmB + this.hmC;
        this.hmz = ((this.mWidth - this.hmy) - (this.hmE * 2)) / 2;
        this.hmI = this.hmD / (this.hmy + this.hmE);
        this.hmJ = this.hmB / this.hmy;
        this.hmK = this.hmy / (this.hmy + this.hmE);
        this.hmF[0] = new Rect(this.hmz - this.hmy, this.hmC + this.hmD, this.hmz, this.hmC + this.hmD + this.hmA);
        this.hmF[1] = new Rect(this.hmz + this.hmE, this.hmC, this.hmz + this.hmE + this.hmy, this.hmC + this.hmB);
        this.hmF[2] = new Rect(this.mWidth - this.hmz, this.hmC + this.hmD, (this.mWidth - this.hmz) + this.hmy, this.hmC + this.hmD + this.hmA);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hmM = ValueAnimator.ofFloat(this.hmy, 0.0f);
        this.hmM.setDuration(500L);
        this.hmM.setInterpolator(new DecelerateInterpolator());
        this.hmM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.hmP != 1) {
                    if (ForumTestView.this.hmP == 2 || ForumTestView.this.hmP == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.hmI * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.hmJ;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.hmv.setAlpha(0.0f);
                            ForumTestView.this.hmv.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.hmw);
                            ForumTestView.this.d(ForumTestView.this.hmv);
                            ForumTestView.this.hmr.remove(ForumTestView.this.hmv.getData());
                            ForumTestView.this.nd(true);
                            ForumTestView.this.hmO = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.hmw, floatValue, abs);
                            if ((ForumTestView.this.hmy * 2) / 5 >= ForumTestView.this.hmv.getViewRight() - ForumTestView.this.hmv.getViewLeft()) {
                                ForumTestView.this.hmv.setAlpha(0.0f);
                                ForumTestView.this.hmv.setVisibility(8);
                            } else {
                                ForumTestView.this.hmv.setViewLeft(ForumTestView.this.hmv.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hmv.setViewRight(ForumTestView.this.hmv.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hmv.setViewTop(ForumTestView.this.hmv.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.hmv.setViewBottom(ForumTestView.this.hmv.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.hmv.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.hmy * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.hmI * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.hmJ;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.hmv.setAlpha(0.0f);
                        ForumTestView.this.hmv.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.hmw);
                        ForumTestView.this.d(ForumTestView.this.hmv);
                        ForumTestView.this.d(ForumTestView.this.hmx);
                        ForumTestView.this.hmr.remove(ForumTestView.this.hmv.getData());
                        if (ForumTestView.this.hms.getIndex() == 0) {
                            if (ForumTestView.this.hms.getDataIndex() > ForumTestView.this.hmx.getDataIndex()) {
                                ForumTestView.this.hms.setDataIndex(ForumTestView.this.hms.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hms);
                            }
                        } else if (ForumTestView.this.hmt.getIndex() == 0) {
                            if (ForumTestView.this.hmt.getDataIndex() > ForumTestView.this.hmx.getDataIndex()) {
                                ForumTestView.this.hmt.setDataIndex(ForumTestView.this.hmt.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hmt);
                            }
                        } else if (ForumTestView.this.hmu.getDataIndex() > ForumTestView.this.hmx.getDataIndex()) {
                            ForumTestView.this.hmu.setDataIndex(ForumTestView.this.hmu.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hmu);
                        }
                        if (ForumTestView.this.hmw.getDataIndex() > ForumTestView.this.hmx.getDataIndex()) {
                            ForumTestView.this.hmw.setDataIndex(ForumTestView.this.hmw.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hmw);
                        }
                        ForumTestView.this.hmx.setDataIndex(ForumTestView.this.hmx.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.hmx);
                        ForumTestView.this.nd(true);
                        ForumTestView.this.hmO = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.hmw, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.hmx, floatValue2);
                        if ((ForumTestView.this.hmy * 2) / 5 >= ForumTestView.this.hmv.getViewRight() - ForumTestView.this.hmv.getViewLeft()) {
                            ForumTestView.this.hmv.setAlpha(0.0f);
                            ForumTestView.this.hmv.setVisibility(8);
                        } else {
                            ForumTestView.this.hmv.setViewLeft(ForumTestView.this.hmv.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hmv.setViewRight(ForumTestView.this.hmv.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hmv.setViewTop(ForumTestView.this.hmv.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.hmv.setViewBottom(ForumTestView.this.hmv.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.hmv.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.hmy * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.hmJ * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.hmv.setAlpha(0.0f);
                    ForumTestView.this.hmv.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.hmr.remove(ForumTestView.this.hmv.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.hmR != null) {
                        ForumTestView.this.hmR.eq(-1L);
                    }
                    ForumTestView.this.hmO = false;
                    if (ForumTestView.this.hmR != null && x.isEmpty(ForumTestView.this.hmr)) {
                        ForumTestView.this.hmR.bWe();
                    }
                } else {
                    ForumTestView.this.hmv.setViewLeft(ForumTestView.this.hmv.getMoveLeft() + floatValue3);
                    ForumTestView.this.hmv.setViewRight(ForumTestView.this.hmv.getMoveRight() - floatValue3);
                    ForumTestView.this.hmv.setViewTop(ForumTestView.this.hmv.getMoveTop() + f);
                    ForumTestView.this.hmv.setViewBottom(ForumTestView.this.hmv.getMoveBottom() - f);
                    ForumTestView.this.hmv.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.hmU) {
                this.hmU = equipmentWidth;
                eN(getContext());
                d(this.hms);
                d(this.hmt);
                d(this.hmu);
                d(this.hmv);
            }
            a(this.hms);
            a(this.hmt);
            a(this.hmu);
            a(this.hmv);
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
            this.hms.layout((int) this.hms.getViewLeft(), (int) this.hms.getViewTop(), (int) this.hms.getViewRight(), (int) this.hms.getViewBottom());
            this.hmt.layout((int) this.hmt.getViewLeft(), (int) this.hmt.getViewTop(), (int) this.hmt.getViewRight(), (int) this.hmt.getViewBottom());
            this.hmu.layout((int) this.hmu.getViewLeft(), (int) this.hmu.getViewTop(), (int) this.hmu.getViewRight(), (int) this.hmu.getViewBottom());
            this.hmv.layout((int) this.hmv.getViewLeft(), (int) this.hmv.getViewTop(), (int) this.hmv.getViewRight(), (int) this.hmv.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.hmM == null || !this.hmM.isRunning()) {
            if (this.hmL == null || !this.hmL.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.hmL != null) {
                        this.hmL.removeAllUpdateListeners();
                        this.hmL.cancel();
                    }
                    this.hmQ = motionEvent.getPointerId(0);
                    this.hmG = x;
                    this.hmH = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.hmG - x;
                    float f2 = this.hmH - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.hmN = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.hmN) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.hmI * f3;
                    if (this.hmN) {
                        b(this.hms, f3, f4);
                        b(this.hmt, f3, f4);
                        b(this.hmu, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.VC);
                    float xVelocity = velocityTracker.getXVelocity(this.hmQ);
                    if (this.hmN || this.mDistance != 0.0f) {
                        ag(xVelocity);
                    }
                    this.hmN = false;
                    releaseVelocityTracker();
                }
                if (this.hmN || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.hmr.size() > 2) {
                if (cellForumTestView.getViewRight() < this.hmF[0].right - (this.hmy / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.hmF[0].right - (this.hmy / 2))) + this.hmF[2].left + (this.hmy / 2) + this.hmE);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.hmy);
                    cellForumTestView.setViewTop(this.hmF[2].top);
                    cellForumTestView.setViewBottom(this.hmF[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hmr.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.hmF[2].left + (this.hmy / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.hmF[2].left + (this.hmy / 2))) + ((this.hmF[0].right - (this.hmy / 2)) - this.hmE));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.hmy);
                    cellForumTestView.setViewTop(this.hmF[0].top);
                    cellForumTestView.setViewBottom(this.hmF[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hmr.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.hmF[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.hmF[0].top) {
                    cellForumTestView.setViewTop(this.hmF[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.hmF[0].bottom) {
                    cellForumTestView.setViewBottom(this.hmF[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.hmF[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.hmF[1].top) {
                    cellForumTestView.setViewTop(this.hmF[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.hmF[1].bottom) {
                    cellForumTestView.setViewBottom(this.hmF[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.hmR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd(boolean z) {
        if (this.hmR != null) {
            int i = -1;
            if (this.hms.getIndex() == 1 && this.hms.getData() != null) {
                this.hmR.eq(this.hms.getData().testId);
                i = this.hms.getDataIndex();
            } else if (this.hmt.getIndex() == 1 && this.hmt.getData() != null) {
                this.hmR.eq(this.hmt.getData().testId);
                i = this.hmt.getDataIndex();
            } else if (this.hmu.getIndex() == 1 && this.hmu.getData() != null) {
                this.hmR.eq(this.hmu.getData().testId);
                i = this.hmu.getDataIndex();
            } else {
                this.hmR.eq(-1L);
            }
            if (z) {
                tU(i);
            }
        }
    }

    private void initAnimation() {
        this.hmL = ValueAnimator.ofFloat(this.hmy, 0.0f);
        this.hmL.setDuration(200L);
        this.hmL.setInterpolator(new DecelerateInterpolator());
        this.hmL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.hmy) * 0.2f;
                    if (ForumTestView.this.hmS) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bWb();
                        } else {
                            ForumTestView.this.bWc();
                        }
                        ForumTestView.this.hmS = false;
                    }
                    ForumTestView.this.hmT = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.hms);
                    ForumTestView.this.d(ForumTestView.this.hmt);
                    ForumTestView.this.d(ForumTestView.this.hmu);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.nd(z);
                } else {
                    if (ForumTestView.this.hmS) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.tS(2) != null && ForumTestView.this.tS(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bWb();
                                ForumTestView.this.hmS = false;
                            }
                        } else if (ForumTestView.this.tS(0) != null && ForumTestView.this.tS(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bWc();
                            ForumTestView.this.hmS = false;
                        }
                    }
                    float f = ForumTestView.this.hmT - floatValue;
                    float f2 = ForumTestView.this.hmI * f;
                    ForumTestView.this.b(ForumTestView.this.hms, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hmt, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hmu, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.hmT = floatValue;
            }
        });
    }

    private void ag(float f) {
        CellForumTestView tS;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.hmS = false;
        this.hmT = 0.0f;
        initAnimation();
        if (this.hmr.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.hms.getVisibility() == 0) {
                cellForumTestView3 = this.hms;
            }
            if (this.hmt.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.hmt;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.hmt;
            }
            if (this.hmu.getVisibility() == 0) {
                cellForumTestView2 = this.hmu;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.hmF[0].left) || viewRight > ((float) this.hmF[2].right)) && Math.abs(this.mDistance) >= this.hmy * 0.2f) {
                this.hmS = true;
            }
        } else if (this.hmr.size() > 2 && Math.abs(this.mDistance) >= this.hmy * 0.2f) {
            this.hmS = true;
        }
        if (this.hmS && (tS = tS(1)) != null) {
            if (this.mDistance >= this.hmy) {
                this.mDistance -= this.hmy;
                this.hmS = false;
                bWc();
            } else if (this.mDistance > 0.0f && this.mDistance < this.hmy) {
                this.mDistance = this.hmF[0].right - tS.getViewRight();
            } else if (this.mDistance > (-this.hmy)) {
                this.mDistance = this.hmF[2].left - tS.getViewLeft();
            } else {
                bWb();
                this.mDistance += this.hmy;
                this.hmS = false;
            }
        }
        this.hmL.setFloatValues(0.0f, this.mDistance);
        this.hmL.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWb() {
        this.hms.setIndex(this.hms.getIndex() + 1);
        this.hmt.setIndex(this.hmt.getIndex() + 1);
        this.hmu.setIndex(this.hmu.getIndex() + 1);
        b(this.hms);
        b(this.hmt);
        b(this.hmu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWc() {
        this.hms.setIndex(this.hms.getIndex() - 1);
        this.hmt.setIndex(this.hmt.getIndex() - 1);
        this.hmu.setIndex(this.hmu.getIndex() - 1);
        b(this.hms);
        b(this.hmt);
        b(this.hmu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView tS(int i) {
        if (this.hms.getIndex() == i) {
            return this.hms;
        }
        if (this.hmt.getIndex() == i) {
            return this.hmt;
        }
        if (this.hmu.getIndex() == i) {
            return this.hmu;
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
            int size = this.hmr.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int tT(int i) {
        int size = this.hmr.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.hmF[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.hmF[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.hmF[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.hmF[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!x.isEmpty(list) && !this.hmN && this.mDistance == 0.0f) {
            this.hmr = list;
            resetData();
            if (x.getCount(list) > 2) {
                this.hms.setVisibility(0);
                this.hmt.setVisibility(0);
                this.hmu.setVisibility(0);
                this.hms.setData(list.get(0));
                this.hmt.setData(list.get(1));
                this.hmu.setData(list.get(2));
                this.hms.setDataIndex(0);
                this.hmt.setDataIndex(1);
                this.hmu.setDataIndex(2);
                i = 1;
            } else if (x.getCount(list) == 2) {
                this.hms.setVisibility(8);
                this.hmt.setVisibility(0);
                this.hmu.setVisibility(0);
                this.hmt.setDataIndex(1);
                this.hmu.setDataIndex(0);
                this.hmt.setData(list.get(1));
                this.hmu.setData(list.get(0));
                i = 1;
            } else {
                this.hms.setVisibility(8);
                this.hmt.setVisibility(0);
                this.hmu.setVisibility(8);
                this.hmt.setDataIndex(0);
                this.hmt.setData(list.get(0));
                i = 0;
            }
            tU(i);
        }
    }

    private void resetData() {
        this.hms.setIndex(0);
        this.hmt.setIndex(1);
        this.hmu.setIndex(2);
        this.hmv.setIndex(1);
        d(this.hms);
        d(this.hmt);
        d(this.hmu);
        d(this.hmv);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void tR(int i) {
        CellForumTestView cellForumTestView;
        this.hmO = true;
        this.hmv.setVisibility(0);
        this.hmv.setAlpha(1.0f);
        bWd();
        if (this.hms.getIndex() == i && this.hms.getVisibility() == 0) {
            cellForumTestView = this.hms;
        } else if (this.hmt.getIndex() == i && this.hmt.getVisibility() == 0) {
            cellForumTestView = this.hmt;
        } else {
            cellForumTestView = this.hmu;
        }
        this.hmv.setData(cellForumTestView.getData());
        this.hmv.setDataIndex(cellForumTestView.getDataIndex());
        this.hmx = null;
        if (this.hmr.size() == 1) {
            this.hmP = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.hmy * 3) / 5;
        } else if (this.hmr.size() == 2) {
            this.hmP = 2;
            cellForumTestView.setVisibility(8);
            if (this.hms.getVisibility() == 0) {
                this.hmw = this.hms;
            } else if (this.hmt.getVisibility() == 0) {
                this.hmw = this.hmt;
            } else {
                this.hmw = this.hmu;
            }
            if (this.hmw.getViewRight() < this.hmF[1].left) {
                this.mDistance = this.hmy + this.hmE;
                this.hmw.setIndex(this.hmw.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.hmw.getViewLeft() > this.hmF[1].right) {
                this.mDistance = (-this.hmy) - this.hmE;
                this.hmw.setIndex(this.hmw.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.hmw);
            b(cellForumTestView);
        } else if (this.hmr.size() == 3) {
            this.hmP = 3;
            cellForumTestView.setVisibility(8);
            if (this.hms.getIndex() == 2) {
                this.hmw = this.hms;
            } else if (this.hmt.getIndex() == 2) {
                this.hmw = this.hmt;
            } else {
                this.hmw = this.hmu;
            }
            this.mDistance = (-this.hmy) - this.hmE;
            this.hmw.setIndex(this.hmw.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.hmw);
            b(cellForumTestView);
        } else {
            this.hmP = 4;
            this.hmx = cellForumTestView;
            if (this.hms.getIndex() == 2) {
                this.hmw = this.hms;
            } else if (this.hmt.getIndex() == 2) {
                this.hmw = this.hmt;
            } else {
                this.hmw = this.hmu;
            }
            this.mDistance = (-this.hmy) - this.hmE;
            this.hmw.setIndex(this.hmw.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.hmw);
            b(cellForumTestView);
            this.hmx.setViewLeft(this.hmF[2].right + this.hmE);
            this.hmx.setViewRight(this.hmF[2].right + this.hmE + this.hmy);
            this.hmx.setViewTop(this.hmF[2].top);
            this.hmx.setViewBottom(this.hmF[2].bottom);
            this.hmx.setMoveLeft(this.hmF[2].right + this.hmE);
            this.hmx.setMoveRight(this.hmF[2].right + this.hmE + this.hmy);
            this.hmx.setMoveTop(this.hmF[2].top);
            this.hmx.setMoveBottom(this.hmF[2].bottom);
            this.hmx.setData(this.hmr.get(tT(this.hmx.getDataIndex() + 2)));
        }
        this.hmM.setFloatValues(0.0f, this.mDistance);
        this.hmM.start();
    }

    private void bWd() {
        this.hms.setMoveLeft(this.hms.getViewLeft());
        this.hms.setMoveTop(this.hms.getViewTop());
        this.hms.setMoveRight(this.hms.getViewRight());
        this.hms.setMoveBottom(this.hms.getViewBottom());
        this.hmt.setMoveLeft(this.hmt.getViewLeft());
        this.hmt.setMoveTop(this.hmt.getViewTop());
        this.hmt.setMoveRight(this.hmt.getViewRight());
        this.hmt.setMoveBottom(this.hmt.getViewBottom());
        this.hmu.setMoveLeft(this.hmu.getViewLeft());
        this.hmu.setMoveTop(this.hmu.getViewTop());
        this.hmu.setMoveRight(this.hmu.getViewRight());
        this.hmu.setMoveBottom(this.hmu.getViewBottom());
        this.hmv.setMoveLeft(this.hmv.getViewLeft());
        this.hmv.setMoveTop(this.hmv.getViewTop());
        this.hmv.setMoveRight(this.hmv.getViewRight());
        this.hmv.setMoveBottom(this.hmv.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.hms.onChangeSkinType();
            this.hmt.onChangeSkinType();
            this.hmu.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.hmN && this.mDistance == 0.0f) {
            if (this.hmL != null) {
                this.hmL.removeAllUpdateListeners();
                this.hmL.cancel();
            }
            if (this.hmM != null) {
                this.hmM.removeAllUpdateListeners();
                this.hmM.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.hms != null) {
            this.hms.setPageId(bdUniqueId);
        }
        if (this.hmt != null) {
            this.hmt.setPageId(bdUniqueId);
        }
        if (this.hmu != null) {
            this.hmu.setPageId(bdUniqueId);
        }
    }

    public void tU(int i) {
        f fVar;
        ap a2;
        if (this.hmr != null && i >= 0 && i < this.hmr.size() && (fVar = this.hmr.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dkh().a(this.mPageId, com.baidu.tieba.s.a.Nz("" + fVar.testId), a2);
        }
    }
}
