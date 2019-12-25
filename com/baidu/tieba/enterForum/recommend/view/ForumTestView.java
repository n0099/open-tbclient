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
/* loaded from: classes6.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int AY;
    private int fSA;
    private Rect[] fSB;
    private float fSC;
    private float fSD;
    private float fSE;
    private float fSF;
    private float fSG;
    private ValueAnimator fSH;
    private float fSI;
    private ValueAnimator fSJ;
    private boolean fSK;
    private int fSL;
    private int fSM;
    private a fSN;
    private boolean fSO;
    private float fSP;
    private int fSQ;
    private List<f> fSn;
    private CellForumTestView fSo;
    private CellForumTestView fSp;
    private CellForumTestView fSq;
    private CellForumTestView fSr;
    private CellForumTestView fSs;
    private CellForumTestView fSt;
    private int fSu;
    private int fSv;
    private int fSw;
    private int fSx;
    private int fSy;
    private int fSz;
    private int mHeight;
    private boolean mIsMove;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void bwA();

        void dl(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fSB = new Rect[3];
        this.mIsMove = false;
        this.fSK = false;
        this.fSO = false;
        this.fSP = 0.0f;
        this.fSQ = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fSB = new Rect[3];
        this.mIsMove = false;
        this.fSK = false;
        this.fSO = false;
        this.fSP = 0.0f;
        this.fSQ = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fSB = new Rect[3];
        this.mIsMove = false;
        this.fSK = false;
        this.fSO = false;
        this.fSP = 0.0f;
        this.fSQ = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fSo = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fSp = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fSq = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fSr = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eL(context);
        resetData();
        ViewConfiguration.get(context);
        this.AY = ViewConfiguration.getMaximumFlingVelocity();
        this.fSo.setForumTestDelClickListener(this);
        this.fSp.setForumTestDelClickListener(this);
        this.fSq.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eL(Context context) {
        this.fSy = l.getDimens(context, R.dimen.tbds44);
        this.fSz = l.getDimens(context, R.dimen.tbds30);
        this.fSA = l.getDimens(context, R.dimen.tbds7);
        this.fSx = l.getDimens(context, R.dimen.tbds730);
        this.fSw = this.fSx - (this.fSz * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.fSu = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fSx + this.fSy;
        this.fSv = ((this.mWidth - this.fSu) - (this.fSA * 2)) / 2;
        this.fSE = this.fSz / (this.fSu + this.fSA);
        this.fSF = this.fSx / this.fSu;
        this.fSG = this.fSu / (this.fSu + this.fSA);
        this.fSB[0] = new Rect(this.fSv - this.fSu, this.fSy + this.fSz, this.fSv, this.fSy + this.fSz + this.fSw);
        this.fSB[1] = new Rect(this.fSv + this.fSA, this.fSy, this.fSv + this.fSA + this.fSu, this.fSy + this.fSx);
        this.fSB[2] = new Rect(this.mWidth - this.fSv, this.fSy + this.fSz, (this.mWidth - this.fSv) + this.fSu, this.fSy + this.fSz + this.fSw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fSJ = ValueAnimator.ofFloat(this.fSu, 0.0f);
        this.fSJ.setDuration(500L);
        this.fSJ.setInterpolator(new DecelerateInterpolator());
        this.fSJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fSL != 1) {
                    if (ForumTestView.this.fSL == 2 || ForumTestView.this.fSL == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fSE * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.fSF;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.fSI)) {
                            ForumTestView.this.fSr.setAlpha(0.0f);
                            ForumTestView.this.fSr.setVisibility(8);
                            ForumTestView.this.fSI = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fSs);
                            ForumTestView.this.d(ForumTestView.this.fSr);
                            ForumTestView.this.fSn.remove(ForumTestView.this.fSr.getData());
                            ForumTestView.this.kw(true);
                            ForumTestView.this.fSK = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fSs, floatValue, abs);
                            if ((ForumTestView.this.fSu * 2) / 5 >= ForumTestView.this.fSr.getViewRight() - ForumTestView.this.fSr.getViewLeft()) {
                                ForumTestView.this.fSr.setAlpha(0.0f);
                                ForumTestView.this.fSr.setVisibility(8);
                            } else {
                                ForumTestView.this.fSr.setViewLeft(ForumTestView.this.fSr.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fSr.setViewRight(ForumTestView.this.fSr.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fSr.setViewTop(ForumTestView.this.fSr.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fSr.setViewBottom(ForumTestView.this.fSr.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fSr.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fSu * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fSE * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.fSF;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.fSI)) {
                        ForumTestView.this.fSr.setAlpha(0.0f);
                        ForumTestView.this.fSr.setVisibility(8);
                        ForumTestView.this.fSI = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fSs);
                        ForumTestView.this.d(ForumTestView.this.fSr);
                        ForumTestView.this.d(ForumTestView.this.fSt);
                        ForumTestView.this.fSn.remove(ForumTestView.this.fSr.getData());
                        if (ForumTestView.this.fSo.getIndex() == 0) {
                            if (ForumTestView.this.fSo.getDataIndex() > ForumTestView.this.fSt.getDataIndex()) {
                                ForumTestView.this.fSo.setDataIndex(ForumTestView.this.fSo.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fSo);
                            }
                        } else if (ForumTestView.this.fSp.getIndex() == 0) {
                            if (ForumTestView.this.fSp.getDataIndex() > ForumTestView.this.fSt.getDataIndex()) {
                                ForumTestView.this.fSp.setDataIndex(ForumTestView.this.fSp.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fSp);
                            }
                        } else if (ForumTestView.this.fSq.getDataIndex() > ForumTestView.this.fSt.getDataIndex()) {
                            ForumTestView.this.fSq.setDataIndex(ForumTestView.this.fSq.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fSq);
                        }
                        if (ForumTestView.this.fSs.getDataIndex() > ForumTestView.this.fSt.getDataIndex()) {
                            ForumTestView.this.fSs.setDataIndex(ForumTestView.this.fSs.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fSs);
                        }
                        ForumTestView.this.fSt.setDataIndex(ForumTestView.this.fSt.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fSt);
                        ForumTestView.this.kw(true);
                        ForumTestView.this.fSK = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fSs, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fSt, floatValue2);
                        if ((ForumTestView.this.fSu * 2) / 5 >= ForumTestView.this.fSr.getViewRight() - ForumTestView.this.fSr.getViewLeft()) {
                            ForumTestView.this.fSr.setAlpha(0.0f);
                            ForumTestView.this.fSr.setVisibility(8);
                        } else {
                            ForumTestView.this.fSr.setViewLeft(ForumTestView.this.fSr.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fSr.setViewRight(ForumTestView.this.fSr.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fSr.setViewTop(ForumTestView.this.fSr.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fSr.setViewBottom(ForumTestView.this.fSr.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fSr.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fSu * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.fSF * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.fSI / 2.0f)) {
                    ForumTestView.this.fSr.setAlpha(0.0f);
                    ForumTestView.this.fSr.setVisibility(8);
                    ForumTestView.this.fSI = 0.0f;
                    ForumTestView.this.fSn.remove(ForumTestView.this.fSr.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.fSN != null) {
                        ForumTestView.this.fSN.dl(-1L);
                    }
                    ForumTestView.this.fSK = false;
                    if (ForumTestView.this.fSN != null && v.isEmpty(ForumTestView.this.fSn)) {
                        ForumTestView.this.fSN.bwA();
                    }
                } else {
                    ForumTestView.this.fSr.setViewLeft(ForumTestView.this.fSr.getMoveLeft() + floatValue3);
                    ForumTestView.this.fSr.setViewRight(ForumTestView.this.fSr.getMoveRight() - floatValue3);
                    ForumTestView.this.fSr.setViewTop(ForumTestView.this.fSr.getMoveTop() + f);
                    ForumTestView.this.fSr.setViewBottom(ForumTestView.this.fSr.getMoveBottom() - f);
                    ForumTestView.this.fSr.setAlpha(1.0f - (floatValue3 / ForumTestView.this.fSI));
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
            if (equipmentWidth != this.fSQ) {
                this.fSQ = equipmentWidth;
                eL(getContext());
                d(this.fSo);
                d(this.fSp);
                d(this.fSq);
                d(this.fSr);
            }
            a(this.fSo);
            a(this.fSp);
            a(this.fSq);
            a(this.fSr);
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
            this.fSo.layout((int) this.fSo.getViewLeft(), (int) this.fSo.getViewTop(), (int) this.fSo.getViewRight(), (int) this.fSo.getViewBottom());
            this.fSp.layout((int) this.fSp.getViewLeft(), (int) this.fSp.getViewTop(), (int) this.fSp.getViewRight(), (int) this.fSp.getViewBottom());
            this.fSq.layout((int) this.fSq.getViewLeft(), (int) this.fSq.getViewTop(), (int) this.fSq.getViewRight(), (int) this.fSq.getViewBottom());
            this.fSr.layout((int) this.fSr.getViewLeft(), (int) this.fSr.getViewTop(), (int) this.fSr.getViewRight(), (int) this.fSr.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.fSJ == null || !this.fSJ.isRunning()) {
            if (this.fSH == null || !this.fSH.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fSH != null) {
                        this.fSH.removeAllUpdateListeners();
                        this.fSH.cancel();
                    }
                    this.fSM = motionEvent.getPointerId(0);
                    this.fSC = x;
                    this.fSD = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fSC - x;
                    float f2 = this.fSD - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.mIsMove = true;
                        this.fSI = f;
                    } else if (Math.abs(f2) > 30.0f && !this.mIsMove) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fSE * f3;
                    if (this.mIsMove) {
                        b(this.fSo, f3, f4);
                        b(this.fSp, f3, f4);
                        b(this.fSq, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.AY);
                    float xVelocity = velocityTracker.getXVelocity(this.fSM);
                    if (this.mIsMove || this.fSI != 0.0f) {
                        ay(xVelocity);
                    }
                    this.mIsMove = false;
                    releaseVelocityTracker();
                }
                if (this.mIsMove || this.fSI != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.fSn.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fSB[0].right - (this.fSu / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fSB[0].right - (this.fSu / 2))) + this.fSB[2].left + (this.fSu / 2) + this.fSA);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fSu);
                    cellForumTestView.setViewTop(this.fSB[2].top);
                    cellForumTestView.setViewBottom(this.fSB[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fSn.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fSB[2].left + (this.fSu / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fSB[2].left + (this.fSu / 2))) + ((this.fSB[0].right - (this.fSu / 2)) - this.fSA));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fSu);
                    cellForumTestView.setViewTop(this.fSB[0].top);
                    cellForumTestView.setViewBottom(this.fSB[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fSn.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fSB[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fSB[0].top) {
                    cellForumTestView.setViewTop(this.fSB[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fSB[0].bottom) {
                    cellForumTestView.setViewBottom(this.fSB[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fSB[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fSB[1].top) {
                    cellForumTestView.setViewTop(this.fSB[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fSB[1].bottom) {
                    cellForumTestView.setViewBottom(this.fSB[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.fSN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw(boolean z) {
        if (this.fSN != null) {
            int i = -1;
            if (this.fSo.getIndex() == 1 && this.fSo.getData() != null) {
                this.fSN.dl(this.fSo.getData().testId);
                i = this.fSo.getDataIndex();
            } else if (this.fSp.getIndex() == 1 && this.fSp.getData() != null) {
                this.fSN.dl(this.fSp.getData().testId);
                i = this.fSp.getDataIndex();
            } else if (this.fSq.getIndex() == 1 && this.fSq.getData() != null) {
                this.fSN.dl(this.fSq.getData().testId);
                i = this.fSq.getDataIndex();
            } else {
                this.fSN.dl(-1L);
            }
            if (z) {
                rM(i);
            }
        }
    }

    private void initAnimation() {
        this.fSH = ValueAnimator.ofFloat(this.fSu, 0.0f);
        this.fSH.setDuration(200L);
        this.fSH.setInterpolator(new DecelerateInterpolator());
        this.fSH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.fSI)) {
                    boolean z = Math.abs(ForumTestView.this.fSI) >= ((float) ForumTestView.this.fSu) * 0.2f;
                    if (ForumTestView.this.fSO) {
                        if (ForumTestView.this.fSI > 0.0f) {
                            ForumTestView.this.bwx();
                        } else {
                            ForumTestView.this.bwy();
                        }
                        ForumTestView.this.fSO = false;
                    }
                    ForumTestView.this.fSP = 0.0f;
                    ForumTestView.this.fSI = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fSo);
                    ForumTestView.this.d(ForumTestView.this.fSp);
                    ForumTestView.this.d(ForumTestView.this.fSq);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.kw(z);
                } else {
                    if (ForumTestView.this.fSO) {
                        if (ForumTestView.this.fSI > 0.0f) {
                            if (ForumTestView.this.rK(2) != null && ForumTestView.this.rK(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bwx();
                                ForumTestView.this.fSO = false;
                            }
                        } else if (ForumTestView.this.rK(0) != null && ForumTestView.this.rK(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bwy();
                            ForumTestView.this.fSO = false;
                        }
                    }
                    float f = ForumTestView.this.fSP - floatValue;
                    float f2 = ForumTestView.this.fSE * f;
                    ForumTestView.this.b(ForumTestView.this.fSo, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fSp, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fSq, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fSP = floatValue;
            }
        });
    }

    private void ay(float f) {
        CellForumTestView rK;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fSO = false;
        this.fSP = 0.0f;
        initAnimation();
        if (this.fSn.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fSo.getVisibility() == 0) {
                cellForumTestView3 = this.fSo;
            }
            if (this.fSp.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fSp;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fSp;
            }
            if (this.fSq.getVisibility() == 0) {
                cellForumTestView2 = this.fSq;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fSB[0].left) || viewRight > ((float) this.fSB[2].right)) && Math.abs(this.fSI) >= this.fSu * 0.2f) {
                this.fSO = true;
            }
        } else if (this.fSn.size() > 2 && Math.abs(this.fSI) >= this.fSu * 0.2f) {
            this.fSO = true;
        }
        if (this.fSO && (rK = rK(1)) != null) {
            if (this.fSI >= this.fSu) {
                this.fSI -= this.fSu;
                this.fSO = false;
                bwy();
            } else if (this.fSI > 0.0f && this.fSI < this.fSu) {
                this.fSI = this.fSB[0].right - rK.getViewRight();
            } else if (this.fSI > (-this.fSu)) {
                this.fSI = this.fSB[2].left - rK.getViewLeft();
            } else {
                bwx();
                this.fSI += this.fSu;
                this.fSO = false;
            }
        }
        this.fSH.setFloatValues(0.0f, this.fSI);
        this.fSH.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwx() {
        this.fSo.setIndex(this.fSo.getIndex() + 1);
        this.fSp.setIndex(this.fSp.getIndex() + 1);
        this.fSq.setIndex(this.fSq.getIndex() + 1);
        b(this.fSo);
        b(this.fSp);
        b(this.fSq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwy() {
        this.fSo.setIndex(this.fSo.getIndex() - 1);
        this.fSp.setIndex(this.fSp.getIndex() - 1);
        this.fSq.setIndex(this.fSq.getIndex() - 1);
        b(this.fSo);
        b(this.fSp);
        b(this.fSq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView rK(int i) {
        if (this.fSo.getIndex() == i) {
            return this.fSo;
        }
        if (this.fSp.getIndex() == i) {
            return this.fSp;
        }
        if (this.fSq.getIndex() == i) {
            return this.fSq;
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
            int size = this.fSn.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int rL(int i) {
        int size = this.fSn.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fSB[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fSB[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fSB[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fSB[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.mIsMove && this.fSI == 0.0f) {
            this.fSn = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.fSo.setVisibility(0);
                this.fSp.setVisibility(0);
                this.fSq.setVisibility(0);
                this.fSo.setData(list.get(0));
                this.fSp.setData(list.get(1));
                this.fSq.setData(list.get(2));
                this.fSo.setDataIndex(0);
                this.fSp.setDataIndex(1);
                this.fSq.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.fSo.setVisibility(8);
                this.fSp.setVisibility(0);
                this.fSq.setVisibility(0);
                this.fSp.setDataIndex(1);
                this.fSq.setDataIndex(0);
                this.fSp.setData(list.get(1));
                this.fSq.setData(list.get(0));
                i = 1;
            } else {
                this.fSo.setVisibility(8);
                this.fSp.setVisibility(0);
                this.fSq.setVisibility(8);
                this.fSp.setDataIndex(0);
                this.fSp.setData(list.get(0));
                i = 0;
            }
            rM(i);
        }
    }

    private void resetData() {
        this.fSo.setIndex(0);
        this.fSp.setIndex(1);
        this.fSq.setIndex(2);
        this.fSr.setIndex(1);
        d(this.fSo);
        d(this.fSp);
        d(this.fSq);
        d(this.fSr);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void rJ(int i) {
        CellForumTestView cellForumTestView;
        this.fSK = true;
        this.fSr.setVisibility(0);
        this.fSr.setAlpha(1.0f);
        bwz();
        if (this.fSo.getIndex() == i && this.fSo.getVisibility() == 0) {
            cellForumTestView = this.fSo;
        } else if (this.fSp.getIndex() == i && this.fSp.getVisibility() == 0) {
            cellForumTestView = this.fSp;
        } else {
            cellForumTestView = this.fSq;
        }
        this.fSr.setData(cellForumTestView.getData());
        this.fSr.setDataIndex(cellForumTestView.getDataIndex());
        this.fSt = null;
        if (this.fSn.size() == 1) {
            this.fSL = 1;
            cellForumTestView.setVisibility(8);
            this.fSI = (this.fSu * 3) / 5;
        } else if (this.fSn.size() == 2) {
            this.fSL = 2;
            cellForumTestView.setVisibility(8);
            if (this.fSo.getVisibility() == 0) {
                this.fSs = this.fSo;
            } else if (this.fSp.getVisibility() == 0) {
                this.fSs = this.fSp;
            } else {
                this.fSs = this.fSq;
            }
            if (this.fSs.getViewRight() < this.fSB[1].left) {
                this.fSI = this.fSu + this.fSA;
                this.fSs.setIndex(this.fSs.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fSs.getViewLeft() > this.fSB[1].right) {
                this.fSI = (-this.fSu) - this.fSA;
                this.fSs.setIndex(this.fSs.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fSs);
            b(cellForumTestView);
        } else if (this.fSn.size() == 3) {
            this.fSL = 3;
            cellForumTestView.setVisibility(8);
            if (this.fSo.getIndex() == 2) {
                this.fSs = this.fSo;
            } else if (this.fSp.getIndex() == 2) {
                this.fSs = this.fSp;
            } else {
                this.fSs = this.fSq;
            }
            this.fSI = (-this.fSu) - this.fSA;
            this.fSs.setIndex(this.fSs.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fSs);
            b(cellForumTestView);
        } else {
            this.fSL = 4;
            this.fSt = cellForumTestView;
            if (this.fSo.getIndex() == 2) {
                this.fSs = this.fSo;
            } else if (this.fSp.getIndex() == 2) {
                this.fSs = this.fSp;
            } else {
                this.fSs = this.fSq;
            }
            this.fSI = (-this.fSu) - this.fSA;
            this.fSs.setIndex(this.fSs.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fSs);
            b(cellForumTestView);
            this.fSt.setViewLeft(this.fSB[2].right + this.fSA);
            this.fSt.setViewRight(this.fSB[2].right + this.fSA + this.fSu);
            this.fSt.setViewTop(this.fSB[2].top);
            this.fSt.setViewBottom(this.fSB[2].bottom);
            this.fSt.setMoveLeft(this.fSB[2].right + this.fSA);
            this.fSt.setMoveRight(this.fSB[2].right + this.fSA + this.fSu);
            this.fSt.setMoveTop(this.fSB[2].top);
            this.fSt.setMoveBottom(this.fSB[2].bottom);
            this.fSt.setData(this.fSn.get(rL(this.fSt.getDataIndex() + 2)));
        }
        this.fSJ.setFloatValues(0.0f, this.fSI);
        this.fSJ.start();
    }

    private void bwz() {
        this.fSo.setMoveLeft(this.fSo.getViewLeft());
        this.fSo.setMoveTop(this.fSo.getViewTop());
        this.fSo.setMoveRight(this.fSo.getViewRight());
        this.fSo.setMoveBottom(this.fSo.getViewBottom());
        this.fSp.setMoveLeft(this.fSp.getViewLeft());
        this.fSp.setMoveTop(this.fSp.getViewTop());
        this.fSp.setMoveRight(this.fSp.getViewRight());
        this.fSp.setMoveBottom(this.fSp.getViewBottom());
        this.fSq.setMoveLeft(this.fSq.getViewLeft());
        this.fSq.setMoveTop(this.fSq.getViewTop());
        this.fSq.setMoveRight(this.fSq.getViewRight());
        this.fSq.setMoveBottom(this.fSq.getViewBottom());
        this.fSr.setMoveLeft(this.fSr.getViewLeft());
        this.fSr.setMoveTop(this.fSr.getViewTop());
        this.fSr.setMoveRight(this.fSr.getViewRight());
        this.fSr.setMoveBottom(this.fSr.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.fSo.onChangeSkinType();
            this.fSp.onChangeSkinType();
            this.fSq.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.mIsMove && this.fSI == 0.0f) {
            if (this.fSH != null) {
                this.fSH.removeAllUpdateListeners();
                this.fSH.cancel();
            }
            if (this.fSJ != null) {
                this.fSJ.removeAllUpdateListeners();
                this.fSJ.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fSo != null) {
            this.fSo.setPageId(bdUniqueId);
        }
        if (this.fSp != null) {
            this.fSp.setPageId(bdUniqueId);
        }
        if (this.fSq != null) {
            this.fSq.setPageId(bdUniqueId);
        }
    }

    public void rM(int i) {
        f fVar;
        an a2;
        if (this.fSn != null && i >= 0 && i < this.fSn.size() && (fVar = this.fSn.get(i)) != null && (a2 = com.baidu.tieba.r.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.r.c.cHo().a(this.mPageId, com.baidu.tieba.r.a.Ir("" + fVar.testId), a2);
        }
    }
}
