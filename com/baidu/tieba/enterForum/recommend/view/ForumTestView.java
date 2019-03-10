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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int Qa;
    private int eFA;
    private int eFB;
    private int eFC;
    private int eFD;
    private int eFE;
    private int eFF;
    private Rect[] eFG;
    private float eFH;
    private float eFI;
    private float eFJ;
    private float eFK;
    private float eFL;
    private ValueAnimator eFM;
    private float eFN;
    private ValueAnimator eFO;
    private boolean eFP;
    private boolean eFQ;
    private int eFR;
    private int eFS;
    private a eFT;
    private boolean eFU;
    private float eFV;
    private List<f> eFs;
    private CellForumTestView eFt;
    private CellForumTestView eFu;
    private CellForumTestView eFv;
    private CellForumTestView eFw;
    private CellForumTestView eFx;
    private CellForumTestView eFy;
    private int eFz;
    private int mHeight;
    private float mLastMotionX;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void cz(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eFG = new Rect[3];
        this.eFP = false;
        this.eFQ = false;
        this.eFU = false;
        this.eFV = 0.0f;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eFG = new Rect[3];
        this.eFP = false;
        this.eFQ = false;
        this.eFU = false;
        this.eFV = 0.0f;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eFG = new Rect[3];
        this.eFP = false;
        this.eFQ = false;
        this.eFU = false;
        this.eFV = 0.0f;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.forum_test_layout, (ViewGroup) this, true);
        this.eFt = (CellForumTestView) findViewById(d.g.forum_test_view_one);
        this.eFu = (CellForumTestView) findViewById(d.g.forum_test_view_two);
        this.eFv = (CellForumTestView) findViewById(d.g.forum_test_view_three);
        this.eFw = (CellForumTestView) findViewById(d.g.forum_test_view_del);
        this.eFD = l.h(context, d.e.tbds44);
        this.eFE = l.h(context, d.e.tbds30);
        this.eFF = l.h(context, d.e.tbds7);
        this.eFz = l.h(context, d.e.tbds962);
        this.eFC = l.h(context, d.e.tbds730);
        this.eFB = this.eFC - (this.eFE * 2);
        this.mWidth = l.aO(getContext());
        this.mHeight = this.eFC + this.eFD;
        this.eFA = ((this.mWidth - this.eFz) - (this.eFF * 2)) / 2;
        this.eFJ = this.eFE / (this.eFz + this.eFF);
        this.eFK = this.eFC / this.eFz;
        this.eFL = this.eFz / (this.eFz + this.eFF);
        this.eFG[0] = new Rect(this.eFA - this.eFz, this.eFD + this.eFE, this.eFA, this.eFD + this.eFE + this.eFB);
        this.eFG[1] = new Rect(this.eFA + this.eFF, this.eFD, this.eFA + this.eFF + this.eFz, this.eFD + this.eFC);
        this.eFG[2] = new Rect(this.mWidth - this.eFA, this.eFD + this.eFE, (this.mWidth - this.eFA) + this.eFz, this.eFD + this.eFE + this.eFB);
        resetData();
        ViewConfiguration.get(context);
        this.Qa = ViewConfiguration.getMaximumFlingVelocity();
        this.eFt.setForumTestDelClickListener(this);
        this.eFu.setForumTestDelClickListener(this);
        this.eFv.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eFO = ValueAnimator.ofFloat(this.eFz, 0.0f);
        this.eFO.setDuration(500L);
        this.eFO.setInterpolator(new DecelerateInterpolator());
        this.eFO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.eFR != 1) {
                    if (ForumTestView.this.eFR == 2 || ForumTestView.this.eFR == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.eFJ * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.eFK;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eFN)) {
                            ForumTestView.this.eFw.setAlpha(0.0f);
                            ForumTestView.this.eFw.setVisibility(8);
                            ForumTestView.this.eFN = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.eFx);
                            ForumTestView.this.d(ForumTestView.this.eFw);
                            ForumTestView.this.eFs.remove(ForumTestView.this.eFw.getData());
                            ForumTestView.this.akJ();
                            ForumTestView.this.eFQ = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.eFx, floatValue, abs);
                            if ((ForumTestView.this.eFz * 2) / 5 >= ForumTestView.this.eFw.getViewRight() - ForumTestView.this.eFw.getViewLeft()) {
                                ForumTestView.this.eFw.setAlpha(0.0f);
                                ForumTestView.this.eFw.setVisibility(8);
                            } else {
                                ForumTestView.this.eFw.setViewLeft(ForumTestView.this.eFw.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eFw.setViewRight(ForumTestView.this.eFw.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eFw.setViewTop(ForumTestView.this.eFw.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.eFw.setViewBottom(ForumTestView.this.eFw.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.eFw.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.eFz * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.eFJ * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.eFK;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.eFN)) {
                        ForumTestView.this.eFw.setAlpha(0.0f);
                        ForumTestView.this.eFw.setVisibility(8);
                        ForumTestView.this.eFN = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.eFx);
                        ForumTestView.this.d(ForumTestView.this.eFw);
                        ForumTestView.this.d(ForumTestView.this.eFy);
                        ForumTestView.this.eFs.remove(ForumTestView.this.eFw.getData());
                        if (ForumTestView.this.eFt.getIndex() == 0) {
                            if (ForumTestView.this.eFt.getDataIndex() > ForumTestView.this.eFy.getDataIndex()) {
                                ForumTestView.this.eFt.setDataIndex(ForumTestView.this.eFt.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eFt);
                            }
                        } else if (ForumTestView.this.eFu.getIndex() == 0) {
                            if (ForumTestView.this.eFu.getDataIndex() > ForumTestView.this.eFy.getDataIndex()) {
                                ForumTestView.this.eFu.setDataIndex(ForumTestView.this.eFu.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eFu);
                            }
                        } else if (ForumTestView.this.eFv.getDataIndex() > ForumTestView.this.eFy.getDataIndex()) {
                            ForumTestView.this.eFv.setDataIndex(ForumTestView.this.eFv.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eFv);
                        }
                        if (ForumTestView.this.eFx.getDataIndex() > ForumTestView.this.eFy.getDataIndex()) {
                            ForumTestView.this.eFx.setDataIndex(ForumTestView.this.eFx.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eFx);
                        }
                        ForumTestView.this.eFy.setDataIndex(ForumTestView.this.eFy.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.eFy);
                        ForumTestView.this.akJ();
                        ForumTestView.this.eFQ = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.eFx, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.eFy, floatValue2);
                        if ((ForumTestView.this.eFz * 2) / 5 >= ForumTestView.this.eFw.getViewRight() - ForumTestView.this.eFw.getViewLeft()) {
                            ForumTestView.this.eFw.setAlpha(0.0f);
                            ForumTestView.this.eFw.setVisibility(8);
                        } else {
                            ForumTestView.this.eFw.setViewLeft(ForumTestView.this.eFw.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eFw.setViewRight(ForumTestView.this.eFw.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eFw.setViewTop(ForumTestView.this.eFw.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.eFw.setViewBottom(ForumTestView.this.eFw.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.eFw.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.eFz * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.eFK * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.eFN / 2.0f)) {
                    ForumTestView.this.eFw.setAlpha(0.0f);
                    ForumTestView.this.eFw.setVisibility(8);
                    ForumTestView.this.eFN = 0.0f;
                    ForumTestView.this.eFs.remove(ForumTestView.this.eFw.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.eFT != null) {
                        ForumTestView.this.eFT.cz(-1L);
                    }
                    ForumTestView.this.eFQ = false;
                } else {
                    ForumTestView.this.eFw.setViewLeft(ForumTestView.this.eFw.getMoveLeft() + floatValue3);
                    ForumTestView.this.eFw.setViewRight(ForumTestView.this.eFw.getMoveRight() - floatValue3);
                    ForumTestView.this.eFw.setViewTop(ForumTestView.this.eFw.getMoveTop() + f);
                    ForumTestView.this.eFw.setViewBottom(ForumTestView.this.eFw.getMoveBottom() - f);
                    ForumTestView.this.eFw.setAlpha(1.0f - (floatValue3 / ForumTestView.this.eFN));
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
            a(this.eFt);
            a(this.eFu);
            a(this.eFv);
            a(this.eFw);
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
            this.eFt.layout((int) this.eFt.getViewLeft(), (int) this.eFt.getViewTop(), (int) this.eFt.getViewRight(), (int) this.eFt.getViewBottom());
            this.eFu.layout((int) this.eFu.getViewLeft(), (int) this.eFu.getViewTop(), (int) this.eFu.getViewRight(), (int) this.eFu.getViewBottom());
            this.eFv.layout((int) this.eFv.getViewLeft(), (int) this.eFv.getViewTop(), (int) this.eFv.getViewRight(), (int) this.eFv.getViewBottom());
            this.eFw.layout((int) this.eFw.getViewLeft(), (int) this.eFw.getViewTop(), (int) this.eFw.getViewRight(), (int) this.eFw.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.eFO == null || !this.eFO.isRunning()) {
            if (this.eFM == null || !this.eFM.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.eFM != null) {
                        this.eFM.removeAllUpdateListeners();
                        this.eFM.cancel();
                    }
                    this.eFS = motionEvent.getPointerId(0);
                    this.eFH = x;
                    this.eFI = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.eFH - x;
                    float f2 = this.eFI - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.eFP = true;
                        this.eFN = f;
                    } else if (Math.abs(f2) > 30.0f && !this.eFP) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.eFJ * f3;
                    if (this.eFP) {
                        b(this.eFt, f3, f4);
                        b(this.eFu, f3, f4);
                        b(this.eFv, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Qa);
                    float xVelocity = velocityTracker.getXVelocity(this.eFS);
                    if (this.eFP || this.eFN != 0.0f) {
                        aC(xVelocity);
                    }
                    this.eFP = false;
                    releaseVelocityTracker();
                }
                if (this.eFP || this.eFN != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.eFs.size() > 2) {
                if (cellForumTestView.getViewRight() < this.eFG[0].right - (this.eFz / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.eFG[0].right - (this.eFz / 2))) + this.eFG[2].left + (this.eFz / 2) + this.eFF);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.eFz);
                    cellForumTestView.setViewTop(this.eFG[2].top);
                    cellForumTestView.setViewBottom(this.eFG[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eFs.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.eFG[2].left + (this.eFz / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.eFG[2].left + (this.eFz / 2))) + ((this.eFG[0].right - (this.eFz / 2)) - this.eFF));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.eFz);
                    cellForumTestView.setViewTop(this.eFG[0].top);
                    cellForumTestView.setViewBottom(this.eFG[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eFs.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.eFG[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.eFG[0].top) {
                    cellForumTestView.setViewTop(this.eFG[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.eFG[0].bottom) {
                    cellForumTestView.setViewBottom(this.eFG[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.eFG[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.eFG[1].top) {
                    cellForumTestView.setViewTop(this.eFG[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.eFG[1].bottom) {
                    cellForumTestView.setViewBottom(this.eFG[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.eFT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        if (this.eFT != null) {
            if (this.eFt.getIndex() == 1 && this.eFt.getData() != null) {
                this.eFT.cz(this.eFt.getData().testId);
            } else if (this.eFu.getIndex() == 1 && this.eFu.getData() != null) {
                this.eFT.cz(this.eFu.getData().testId);
            } else if (this.eFv.getIndex() == 1 && this.eFv.getData() != null) {
                this.eFT.cz(this.eFv.getData().testId);
            } else {
                this.eFT.cz(-1L);
            }
        }
    }

    private void aXl() {
        this.eFM = ValueAnimator.ofFloat(this.eFz, 0.0f);
        this.eFM.setDuration(200L);
        this.eFM.setInterpolator(new DecelerateInterpolator());
        this.eFM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eFN)) {
                    if (ForumTestView.this.eFU) {
                        if (ForumTestView.this.eFN > 0.0f) {
                            ForumTestView.this.aXm();
                        } else {
                            ForumTestView.this.aXn();
                        }
                        ForumTestView.this.eFU = false;
                    }
                    ForumTestView.this.eFV = 0.0f;
                    ForumTestView.this.eFN = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.eFt);
                    ForumTestView.this.d(ForumTestView.this.eFu);
                    ForumTestView.this.d(ForumTestView.this.eFv);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.akJ();
                } else {
                    if (ForumTestView.this.eFU) {
                        if (ForumTestView.this.eFN > 0.0f) {
                            if (ForumTestView.this.pl(2) != null && ForumTestView.this.pl(2).getViewLeft() >= l.aO(ForumTestView.this.getContext())) {
                                ForumTestView.this.aXm();
                                ForumTestView.this.eFU = false;
                            }
                        } else if (ForumTestView.this.pl(0) != null && ForumTestView.this.pl(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.aXn();
                            ForumTestView.this.eFU = false;
                        }
                    }
                    float f = ForumTestView.this.eFV - floatValue;
                    float f2 = ForumTestView.this.eFJ * f;
                    ForumTestView.this.b(ForumTestView.this.eFt, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eFu, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eFv, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.eFV = floatValue;
            }
        });
    }

    private void aC(float f) {
        CellForumTestView pl;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.eFU = false;
        this.eFV = 0.0f;
        aXl();
        if (this.eFs.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.eFt.getVisibility() == 0) {
                cellForumTestView3 = this.eFt;
            }
            if (this.eFu.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.eFu;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.eFu;
            }
            if (this.eFv.getVisibility() == 0) {
                cellForumTestView2 = this.eFv;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.eFG[0].left) || viewRight > ((float) this.eFG[2].right)) && Math.abs(this.eFN) >= this.eFz * 0.2f) {
                this.eFU = true;
            }
        } else if (this.eFs.size() > 2 && Math.abs(this.eFN) >= this.eFz * 0.2f) {
            this.eFU = true;
        }
        if (this.eFU && (pl = pl(1)) != null) {
            if (this.eFN >= this.eFz) {
                this.eFN -= this.eFz;
                this.eFU = false;
                aXn();
            } else if (this.eFN > 0.0f && this.eFN < this.eFz) {
                this.eFN = this.eFG[0].right - pl.getViewRight();
            } else if (this.eFN > (-this.eFz)) {
                this.eFN = this.eFG[2].left - pl.getViewLeft();
            } else {
                aXm();
                this.eFN += this.eFz;
                this.eFU = false;
            }
        }
        this.eFM.setFloatValues(0.0f, this.eFN);
        this.eFM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        this.eFt.setIndex(this.eFt.getIndex() + 1);
        this.eFu.setIndex(this.eFu.getIndex() + 1);
        this.eFv.setIndex(this.eFv.getIndex() + 1);
        b(this.eFt);
        b(this.eFu);
        b(this.eFv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXn() {
        this.eFt.setIndex(this.eFt.getIndex() - 1);
        this.eFu.setIndex(this.eFu.getIndex() - 1);
        this.eFv.setIndex(this.eFv.getIndex() - 1);
        b(this.eFt);
        b(this.eFu);
        b(this.eFv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView pl(int i) {
        if (this.eFt.getIndex() == i) {
            return this.eFt;
        }
        if (this.eFu.getIndex() == i) {
            return this.eFu;
        }
        if (this.eFv.getIndex() == i) {
            return this.eFv;
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
            int size = this.eFs.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int pm(int i) {
        int size = this.eFs.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.eFG[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.eFG[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.eFG[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.eFG[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        if (!v.T(list) && !this.eFP && this.eFN == 0.0f) {
            this.eFs = list;
            resetData();
            if (v.S(list) > 2) {
                this.eFt.setVisibility(0);
                this.eFu.setVisibility(0);
                this.eFv.setVisibility(0);
                this.eFt.setData(list.get(0));
                this.eFu.setData(list.get(1));
                this.eFv.setData(list.get(2));
                this.eFt.setDataIndex(0);
                this.eFu.setDataIndex(1);
                this.eFv.setDataIndex(2);
            } else if (v.S(list) == 2) {
                this.eFt.setVisibility(8);
                this.eFu.setVisibility(0);
                this.eFv.setVisibility(0);
                this.eFu.setDataIndex(1);
                this.eFv.setDataIndex(0);
                this.eFu.setData(list.get(1));
                this.eFv.setData(list.get(0));
            } else {
                this.eFt.setVisibility(8);
                this.eFu.setVisibility(0);
                this.eFv.setVisibility(8);
                this.eFu.setDataIndex(0);
                this.eFu.setData(list.get(0));
            }
        }
    }

    private void resetData() {
        this.eFt.setIndex(0);
        this.eFu.setIndex(1);
        this.eFv.setIndex(2);
        this.eFw.setIndex(1);
        d(this.eFt);
        d(this.eFu);
        d(this.eFv);
        d(this.eFw);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void pk(int i) {
        CellForumTestView cellForumTestView;
        this.eFQ = true;
        this.eFw.setVisibility(0);
        this.eFw.setAlpha(1.0f);
        aXo();
        if (this.eFt.getIndex() == i && this.eFt.getVisibility() == 0) {
            cellForumTestView = this.eFt;
        } else if (this.eFu.getIndex() == i && this.eFu.getVisibility() == 0) {
            cellForumTestView = this.eFu;
        } else {
            cellForumTestView = this.eFv;
        }
        this.eFw.setData(cellForumTestView.getData());
        this.eFw.setDataIndex(cellForumTestView.getDataIndex());
        this.eFy = null;
        if (this.eFs.size() == 1) {
            this.eFR = 1;
            cellForumTestView.setVisibility(8);
            this.eFN = (this.eFz * 3) / 5;
        } else if (this.eFs.size() == 2) {
            this.eFR = 2;
            cellForumTestView.setVisibility(8);
            if (this.eFt.getVisibility() == 0) {
                this.eFx = this.eFt;
            } else if (this.eFu.getVisibility() == 0) {
                this.eFx = this.eFu;
            } else {
                this.eFx = this.eFv;
            }
            if (this.eFx.getViewRight() < this.eFG[1].left) {
                this.eFN = this.eFz + this.eFF;
                this.eFx.setIndex(this.eFx.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.eFx.getViewLeft() > this.eFG[1].right) {
                this.eFN = (-this.eFz) - this.eFF;
                this.eFx.setIndex(this.eFx.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.eFx);
            b(cellForumTestView);
        } else if (this.eFs.size() == 3) {
            this.eFR = 3;
            cellForumTestView.setVisibility(8);
            if (this.eFt.getIndex() == 2) {
                this.eFx = this.eFt;
            } else if (this.eFu.getIndex() == 2) {
                this.eFx = this.eFu;
            } else {
                this.eFx = this.eFv;
            }
            this.eFN = (-this.eFz) - this.eFF;
            this.eFx.setIndex(this.eFx.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.eFx);
            b(cellForumTestView);
        } else {
            this.eFR = 4;
            this.eFy = cellForumTestView;
            if (this.eFt.getIndex() == 2) {
                this.eFx = this.eFt;
            } else if (this.eFu.getIndex() == 2) {
                this.eFx = this.eFu;
            } else {
                this.eFx = this.eFv;
            }
            this.eFN = (-this.eFz) - this.eFF;
            this.eFx.setIndex(this.eFx.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.eFx);
            b(cellForumTestView);
            this.eFy.setViewLeft(this.eFG[2].right + this.eFF);
            this.eFy.setViewRight(this.eFG[2].right + this.eFF + this.eFz);
            this.eFy.setViewTop(this.eFG[2].top);
            this.eFy.setViewBottom(this.eFG[2].bottom);
            this.eFy.setMoveLeft(this.eFG[2].right + this.eFF);
            this.eFy.setMoveRight(this.eFG[2].right + this.eFF + this.eFz);
            this.eFy.setMoveTop(this.eFG[2].top);
            this.eFy.setMoveBottom(this.eFG[2].bottom);
            this.eFy.setData(this.eFs.get(pm(this.eFy.getDataIndex() + 2)));
        }
        this.eFO.setFloatValues(0.0f, this.eFN);
        this.eFO.start();
    }

    private void aXo() {
        this.eFt.setMoveLeft(this.eFt.getViewLeft());
        this.eFt.setMoveTop(this.eFt.getViewTop());
        this.eFt.setMoveRight(this.eFt.getViewRight());
        this.eFt.setMoveBottom(this.eFt.getViewBottom());
        this.eFu.setMoveLeft(this.eFu.getViewLeft());
        this.eFu.setMoveTop(this.eFu.getViewTop());
        this.eFu.setMoveRight(this.eFu.getViewRight());
        this.eFu.setMoveBottom(this.eFu.getViewBottom());
        this.eFv.setMoveLeft(this.eFv.getViewLeft());
        this.eFv.setMoveTop(this.eFv.getViewTop());
        this.eFv.setMoveRight(this.eFv.getViewRight());
        this.eFv.setMoveBottom(this.eFv.getViewBottom());
        this.eFw.setMoveLeft(this.eFw.getViewLeft());
        this.eFw.setMoveTop(this.eFw.getViewTop());
        this.eFw.setMoveRight(this.eFw.getViewRight());
        this.eFw.setMoveBottom(this.eFw.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0236d.cp_bg_line_c);
            this.eFt.onChangeSkinType();
            this.eFu.onChangeSkinType();
            this.eFv.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.eFP && this.eFN == 0.0f) {
            if (this.eFM != null) {
                this.eFM.removeAllUpdateListeners();
                this.eFM.cancel();
            }
            if (this.eFO != null) {
                this.eFO.removeAllUpdateListeners();
                this.eFO.cancel();
            }
        }
        super.onDetachedFromWindow();
    }
}
