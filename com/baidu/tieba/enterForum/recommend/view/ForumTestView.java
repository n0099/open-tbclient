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
    private int Qb;
    private int eFA;
    private int eFB;
    private Rect[] eFC;
    private float eFD;
    private float eFE;
    private float eFF;
    private float eFG;
    private float eFH;
    private ValueAnimator eFI;
    private float eFJ;
    private ValueAnimator eFK;
    private boolean eFL;
    private boolean eFM;
    private int eFN;
    private int eFO;
    private a eFP;
    private boolean eFQ;
    private float eFR;
    private List<f> eFo;
    private CellForumTestView eFp;
    private CellForumTestView eFq;
    private CellForumTestView eFr;
    private CellForumTestView eFs;
    private CellForumTestView eFt;
    private CellForumTestView eFu;
    private int eFv;
    private int eFw;
    private int eFx;
    private int eFy;
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
        this.eFC = new Rect[3];
        this.eFL = false;
        this.eFM = false;
        this.eFQ = false;
        this.eFR = 0.0f;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eFC = new Rect[3];
        this.eFL = false;
        this.eFM = false;
        this.eFQ = false;
        this.eFR = 0.0f;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eFC = new Rect[3];
        this.eFL = false;
        this.eFM = false;
        this.eFQ = false;
        this.eFR = 0.0f;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.forum_test_layout, (ViewGroup) this, true);
        this.eFp = (CellForumTestView) findViewById(d.g.forum_test_view_one);
        this.eFq = (CellForumTestView) findViewById(d.g.forum_test_view_two);
        this.eFr = (CellForumTestView) findViewById(d.g.forum_test_view_three);
        this.eFs = (CellForumTestView) findViewById(d.g.forum_test_view_del);
        this.eFz = l.h(context, d.e.tbds44);
        this.eFA = l.h(context, d.e.tbds30);
        this.eFB = l.h(context, d.e.tbds7);
        this.eFv = l.h(context, d.e.tbds962);
        this.eFy = l.h(context, d.e.tbds730);
        this.eFx = this.eFy - (this.eFA * 2);
        this.mWidth = l.aO(getContext());
        this.mHeight = this.eFy + this.eFz;
        this.eFw = ((this.mWidth - this.eFv) - (this.eFB * 2)) / 2;
        this.eFF = this.eFA / (this.eFv + this.eFB);
        this.eFG = this.eFy / this.eFv;
        this.eFH = this.eFv / (this.eFv + this.eFB);
        this.eFC[0] = new Rect(this.eFw - this.eFv, this.eFz + this.eFA, this.eFw, this.eFz + this.eFA + this.eFx);
        this.eFC[1] = new Rect(this.eFw + this.eFB, this.eFz, this.eFw + this.eFB + this.eFv, this.eFz + this.eFy);
        this.eFC[2] = new Rect(this.mWidth - this.eFw, this.eFz + this.eFA, (this.mWidth - this.eFw) + this.eFv, this.eFz + this.eFA + this.eFx);
        resetData();
        ViewConfiguration.get(context);
        this.Qb = ViewConfiguration.getMaximumFlingVelocity();
        this.eFp.setForumTestDelClickListener(this);
        this.eFq.setForumTestDelClickListener(this);
        this.eFr.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eFK = ValueAnimator.ofFloat(this.eFv, 0.0f);
        this.eFK.setDuration(500L);
        this.eFK.setInterpolator(new DecelerateInterpolator());
        this.eFK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.eFN != 1) {
                    if (ForumTestView.this.eFN == 2 || ForumTestView.this.eFN == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.eFF * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.eFG;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eFJ)) {
                            ForumTestView.this.eFs.setAlpha(0.0f);
                            ForumTestView.this.eFs.setVisibility(8);
                            ForumTestView.this.eFJ = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.eFt);
                            ForumTestView.this.d(ForumTestView.this.eFs);
                            ForumTestView.this.eFo.remove(ForumTestView.this.eFs.getData());
                            ForumTestView.this.akI();
                            ForumTestView.this.eFM = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.eFt, floatValue, abs);
                            if ((ForumTestView.this.eFv * 2) / 5 >= ForumTestView.this.eFs.getViewRight() - ForumTestView.this.eFs.getViewLeft()) {
                                ForumTestView.this.eFs.setAlpha(0.0f);
                                ForumTestView.this.eFs.setVisibility(8);
                            } else {
                                ForumTestView.this.eFs.setViewLeft(ForumTestView.this.eFs.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eFs.setViewRight(ForumTestView.this.eFs.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eFs.setViewTop(ForumTestView.this.eFs.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.eFs.setViewBottom(ForumTestView.this.eFs.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.eFs.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.eFv * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.eFF * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.eFG;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.eFJ)) {
                        ForumTestView.this.eFs.setAlpha(0.0f);
                        ForumTestView.this.eFs.setVisibility(8);
                        ForumTestView.this.eFJ = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.eFt);
                        ForumTestView.this.d(ForumTestView.this.eFs);
                        ForumTestView.this.d(ForumTestView.this.eFu);
                        ForumTestView.this.eFo.remove(ForumTestView.this.eFs.getData());
                        if (ForumTestView.this.eFp.getIndex() == 0) {
                            if (ForumTestView.this.eFp.getDataIndex() > ForumTestView.this.eFu.getDataIndex()) {
                                ForumTestView.this.eFp.setDataIndex(ForumTestView.this.eFp.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eFp);
                            }
                        } else if (ForumTestView.this.eFq.getIndex() == 0) {
                            if (ForumTestView.this.eFq.getDataIndex() > ForumTestView.this.eFu.getDataIndex()) {
                                ForumTestView.this.eFq.setDataIndex(ForumTestView.this.eFq.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eFq);
                            }
                        } else if (ForumTestView.this.eFr.getDataIndex() > ForumTestView.this.eFu.getDataIndex()) {
                            ForumTestView.this.eFr.setDataIndex(ForumTestView.this.eFr.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eFr);
                        }
                        if (ForumTestView.this.eFt.getDataIndex() > ForumTestView.this.eFu.getDataIndex()) {
                            ForumTestView.this.eFt.setDataIndex(ForumTestView.this.eFt.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eFt);
                        }
                        ForumTestView.this.eFu.setDataIndex(ForumTestView.this.eFu.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.eFu);
                        ForumTestView.this.akI();
                        ForumTestView.this.eFM = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.eFt, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.eFu, floatValue2);
                        if ((ForumTestView.this.eFv * 2) / 5 >= ForumTestView.this.eFs.getViewRight() - ForumTestView.this.eFs.getViewLeft()) {
                            ForumTestView.this.eFs.setAlpha(0.0f);
                            ForumTestView.this.eFs.setVisibility(8);
                        } else {
                            ForumTestView.this.eFs.setViewLeft(ForumTestView.this.eFs.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eFs.setViewRight(ForumTestView.this.eFs.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eFs.setViewTop(ForumTestView.this.eFs.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.eFs.setViewBottom(ForumTestView.this.eFs.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.eFs.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.eFv * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.eFG * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.eFJ / 2.0f)) {
                    ForumTestView.this.eFs.setAlpha(0.0f);
                    ForumTestView.this.eFs.setVisibility(8);
                    ForumTestView.this.eFJ = 0.0f;
                    ForumTestView.this.eFo.remove(ForumTestView.this.eFs.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.eFP != null) {
                        ForumTestView.this.eFP.cz(-1L);
                    }
                    ForumTestView.this.eFM = false;
                } else {
                    ForumTestView.this.eFs.setViewLeft(ForumTestView.this.eFs.getMoveLeft() + floatValue3);
                    ForumTestView.this.eFs.setViewRight(ForumTestView.this.eFs.getMoveRight() - floatValue3);
                    ForumTestView.this.eFs.setViewTop(ForumTestView.this.eFs.getMoveTop() + f);
                    ForumTestView.this.eFs.setViewBottom(ForumTestView.this.eFs.getMoveBottom() - f);
                    ForumTestView.this.eFs.setAlpha(1.0f - (floatValue3 / ForumTestView.this.eFJ));
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
            a(this.eFp);
            a(this.eFq);
            a(this.eFr);
            a(this.eFs);
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
            this.eFp.layout((int) this.eFp.getViewLeft(), (int) this.eFp.getViewTop(), (int) this.eFp.getViewRight(), (int) this.eFp.getViewBottom());
            this.eFq.layout((int) this.eFq.getViewLeft(), (int) this.eFq.getViewTop(), (int) this.eFq.getViewRight(), (int) this.eFq.getViewBottom());
            this.eFr.layout((int) this.eFr.getViewLeft(), (int) this.eFr.getViewTop(), (int) this.eFr.getViewRight(), (int) this.eFr.getViewBottom());
            this.eFs.layout((int) this.eFs.getViewLeft(), (int) this.eFs.getViewTop(), (int) this.eFs.getViewRight(), (int) this.eFs.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.eFK == null || !this.eFK.isRunning()) {
            if (this.eFI == null || !this.eFI.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.eFI != null) {
                        this.eFI.removeAllUpdateListeners();
                        this.eFI.cancel();
                    }
                    this.eFO = motionEvent.getPointerId(0);
                    this.eFD = x;
                    this.eFE = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.eFD - x;
                    float f2 = this.eFE - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.eFL = true;
                        this.eFJ = f;
                    } else if (Math.abs(f2) > 30.0f && !this.eFL) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.eFF * f3;
                    if (this.eFL) {
                        b(this.eFp, f3, f4);
                        b(this.eFq, f3, f4);
                        b(this.eFr, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Qb);
                    float xVelocity = velocityTracker.getXVelocity(this.eFO);
                    if (this.eFL || this.eFJ != 0.0f) {
                        aC(xVelocity);
                    }
                    this.eFL = false;
                    releaseVelocityTracker();
                }
                if (this.eFL || this.eFJ != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.eFo.size() > 2) {
                if (cellForumTestView.getViewRight() < this.eFC[0].right - (this.eFv / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.eFC[0].right - (this.eFv / 2))) + this.eFC[2].left + (this.eFv / 2) + this.eFB);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.eFv);
                    cellForumTestView.setViewTop(this.eFC[2].top);
                    cellForumTestView.setViewBottom(this.eFC[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eFo.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.eFC[2].left + (this.eFv / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.eFC[2].left + (this.eFv / 2))) + ((this.eFC[0].right - (this.eFv / 2)) - this.eFB));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.eFv);
                    cellForumTestView.setViewTop(this.eFC[0].top);
                    cellForumTestView.setViewBottom(this.eFC[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eFo.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.eFC[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.eFC[0].top) {
                    cellForumTestView.setViewTop(this.eFC[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.eFC[0].bottom) {
                    cellForumTestView.setViewBottom(this.eFC[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.eFC[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.eFC[1].top) {
                    cellForumTestView.setViewTop(this.eFC[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.eFC[1].bottom) {
                    cellForumTestView.setViewBottom(this.eFC[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.eFP = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        if (this.eFP != null) {
            if (this.eFp.getIndex() == 1 && this.eFp.getData() != null) {
                this.eFP.cz(this.eFp.getData().testId);
            } else if (this.eFq.getIndex() == 1 && this.eFq.getData() != null) {
                this.eFP.cz(this.eFq.getData().testId);
            } else if (this.eFr.getIndex() == 1 && this.eFr.getData() != null) {
                this.eFP.cz(this.eFr.getData().testId);
            } else {
                this.eFP.cz(-1L);
            }
        }
    }

    private void aXk() {
        this.eFI = ValueAnimator.ofFloat(this.eFv, 0.0f);
        this.eFI.setDuration(200L);
        this.eFI.setInterpolator(new DecelerateInterpolator());
        this.eFI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eFJ)) {
                    if (ForumTestView.this.eFQ) {
                        if (ForumTestView.this.eFJ > 0.0f) {
                            ForumTestView.this.aXl();
                        } else {
                            ForumTestView.this.aXm();
                        }
                        ForumTestView.this.eFQ = false;
                    }
                    ForumTestView.this.eFR = 0.0f;
                    ForumTestView.this.eFJ = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.eFp);
                    ForumTestView.this.d(ForumTestView.this.eFq);
                    ForumTestView.this.d(ForumTestView.this.eFr);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.akI();
                } else {
                    if (ForumTestView.this.eFQ) {
                        if (ForumTestView.this.eFJ > 0.0f) {
                            if (ForumTestView.this.pl(2) != null && ForumTestView.this.pl(2).getViewLeft() >= l.aO(ForumTestView.this.getContext())) {
                                ForumTestView.this.aXl();
                                ForumTestView.this.eFQ = false;
                            }
                        } else if (ForumTestView.this.pl(0) != null && ForumTestView.this.pl(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.aXm();
                            ForumTestView.this.eFQ = false;
                        }
                    }
                    float f = ForumTestView.this.eFR - floatValue;
                    float f2 = ForumTestView.this.eFF * f;
                    ForumTestView.this.b(ForumTestView.this.eFp, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eFq, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eFr, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.eFR = floatValue;
            }
        });
    }

    private void aC(float f) {
        CellForumTestView pl;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.eFQ = false;
        this.eFR = 0.0f;
        aXk();
        if (this.eFo.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.eFp.getVisibility() == 0) {
                cellForumTestView3 = this.eFp;
            }
            if (this.eFq.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.eFq;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.eFq;
            }
            if (this.eFr.getVisibility() == 0) {
                cellForumTestView2 = this.eFr;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.eFC[0].left) || viewRight > ((float) this.eFC[2].right)) && Math.abs(this.eFJ) >= this.eFv * 0.2f) {
                this.eFQ = true;
            }
        } else if (this.eFo.size() > 2 && Math.abs(this.eFJ) >= this.eFv * 0.2f) {
            this.eFQ = true;
        }
        if (this.eFQ && (pl = pl(1)) != null) {
            if (this.eFJ >= this.eFv) {
                this.eFJ -= this.eFv;
                this.eFQ = false;
                aXm();
            } else if (this.eFJ > 0.0f && this.eFJ < this.eFv) {
                this.eFJ = this.eFC[0].right - pl.getViewRight();
            } else if (this.eFJ > (-this.eFv)) {
                this.eFJ = this.eFC[2].left - pl.getViewLeft();
            } else {
                aXl();
                this.eFJ += this.eFv;
                this.eFQ = false;
            }
        }
        this.eFI.setFloatValues(0.0f, this.eFJ);
        this.eFI.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXl() {
        this.eFp.setIndex(this.eFp.getIndex() + 1);
        this.eFq.setIndex(this.eFq.getIndex() + 1);
        this.eFr.setIndex(this.eFr.getIndex() + 1);
        b(this.eFp);
        b(this.eFq);
        b(this.eFr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        this.eFp.setIndex(this.eFp.getIndex() - 1);
        this.eFq.setIndex(this.eFq.getIndex() - 1);
        this.eFr.setIndex(this.eFr.getIndex() - 1);
        b(this.eFp);
        b(this.eFq);
        b(this.eFr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView pl(int i) {
        if (this.eFp.getIndex() == i) {
            return this.eFp;
        }
        if (this.eFq.getIndex() == i) {
            return this.eFq;
        }
        if (this.eFr.getIndex() == i) {
            return this.eFr;
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
            int size = this.eFo.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int pm(int i) {
        int size = this.eFo.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.eFC[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.eFC[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.eFC[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.eFC[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        if (!v.T(list) && !this.eFL && this.eFJ == 0.0f) {
            this.eFo = list;
            resetData();
            if (v.S(list) > 2) {
                this.eFp.setVisibility(0);
                this.eFq.setVisibility(0);
                this.eFr.setVisibility(0);
                this.eFp.setData(list.get(0));
                this.eFq.setData(list.get(1));
                this.eFr.setData(list.get(2));
                this.eFp.setDataIndex(0);
                this.eFq.setDataIndex(1);
                this.eFr.setDataIndex(2);
            } else if (v.S(list) == 2) {
                this.eFp.setVisibility(8);
                this.eFq.setVisibility(0);
                this.eFr.setVisibility(0);
                this.eFq.setDataIndex(1);
                this.eFr.setDataIndex(0);
                this.eFq.setData(list.get(1));
                this.eFr.setData(list.get(0));
            } else {
                this.eFp.setVisibility(8);
                this.eFq.setVisibility(0);
                this.eFr.setVisibility(8);
                this.eFq.setDataIndex(0);
                this.eFq.setData(list.get(0));
            }
        }
    }

    private void resetData() {
        this.eFp.setIndex(0);
        this.eFq.setIndex(1);
        this.eFr.setIndex(2);
        this.eFs.setIndex(1);
        d(this.eFp);
        d(this.eFq);
        d(this.eFr);
        d(this.eFs);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void pk(int i) {
        CellForumTestView cellForumTestView;
        this.eFM = true;
        this.eFs.setVisibility(0);
        this.eFs.setAlpha(1.0f);
        aXn();
        if (this.eFp.getIndex() == i && this.eFp.getVisibility() == 0) {
            cellForumTestView = this.eFp;
        } else if (this.eFq.getIndex() == i && this.eFq.getVisibility() == 0) {
            cellForumTestView = this.eFq;
        } else {
            cellForumTestView = this.eFr;
        }
        this.eFs.setData(cellForumTestView.getData());
        this.eFs.setDataIndex(cellForumTestView.getDataIndex());
        this.eFu = null;
        if (this.eFo.size() == 1) {
            this.eFN = 1;
            cellForumTestView.setVisibility(8);
            this.eFJ = (this.eFv * 3) / 5;
        } else if (this.eFo.size() == 2) {
            this.eFN = 2;
            cellForumTestView.setVisibility(8);
            if (this.eFp.getVisibility() == 0) {
                this.eFt = this.eFp;
            } else if (this.eFq.getVisibility() == 0) {
                this.eFt = this.eFq;
            } else {
                this.eFt = this.eFr;
            }
            if (this.eFt.getViewRight() < this.eFC[1].left) {
                this.eFJ = this.eFv + this.eFB;
                this.eFt.setIndex(this.eFt.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.eFt.getViewLeft() > this.eFC[1].right) {
                this.eFJ = (-this.eFv) - this.eFB;
                this.eFt.setIndex(this.eFt.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.eFt);
            b(cellForumTestView);
        } else if (this.eFo.size() == 3) {
            this.eFN = 3;
            cellForumTestView.setVisibility(8);
            if (this.eFp.getIndex() == 2) {
                this.eFt = this.eFp;
            } else if (this.eFq.getIndex() == 2) {
                this.eFt = this.eFq;
            } else {
                this.eFt = this.eFr;
            }
            this.eFJ = (-this.eFv) - this.eFB;
            this.eFt.setIndex(this.eFt.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.eFt);
            b(cellForumTestView);
        } else {
            this.eFN = 4;
            this.eFu = cellForumTestView;
            if (this.eFp.getIndex() == 2) {
                this.eFt = this.eFp;
            } else if (this.eFq.getIndex() == 2) {
                this.eFt = this.eFq;
            } else {
                this.eFt = this.eFr;
            }
            this.eFJ = (-this.eFv) - this.eFB;
            this.eFt.setIndex(this.eFt.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.eFt);
            b(cellForumTestView);
            this.eFu.setViewLeft(this.eFC[2].right + this.eFB);
            this.eFu.setViewRight(this.eFC[2].right + this.eFB + this.eFv);
            this.eFu.setViewTop(this.eFC[2].top);
            this.eFu.setViewBottom(this.eFC[2].bottom);
            this.eFu.setMoveLeft(this.eFC[2].right + this.eFB);
            this.eFu.setMoveRight(this.eFC[2].right + this.eFB + this.eFv);
            this.eFu.setMoveTop(this.eFC[2].top);
            this.eFu.setMoveBottom(this.eFC[2].bottom);
            this.eFu.setData(this.eFo.get(pm(this.eFu.getDataIndex() + 2)));
        }
        this.eFK.setFloatValues(0.0f, this.eFJ);
        this.eFK.start();
    }

    private void aXn() {
        this.eFp.setMoveLeft(this.eFp.getViewLeft());
        this.eFp.setMoveTop(this.eFp.getViewTop());
        this.eFp.setMoveRight(this.eFp.getViewRight());
        this.eFp.setMoveBottom(this.eFp.getViewBottom());
        this.eFq.setMoveLeft(this.eFq.getViewLeft());
        this.eFq.setMoveTop(this.eFq.getViewTop());
        this.eFq.setMoveRight(this.eFq.getViewRight());
        this.eFq.setMoveBottom(this.eFq.getViewBottom());
        this.eFr.setMoveLeft(this.eFr.getViewLeft());
        this.eFr.setMoveTop(this.eFr.getViewTop());
        this.eFr.setMoveRight(this.eFr.getViewRight());
        this.eFr.setMoveBottom(this.eFr.getViewBottom());
        this.eFs.setMoveLeft(this.eFs.getViewLeft());
        this.eFs.setMoveTop(this.eFs.getViewTop());
        this.eFs.setMoveRight(this.eFs.getViewRight());
        this.eFs.setMoveBottom(this.eFs.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.cp_bg_line_c);
            this.eFp.onChangeSkinType();
            this.eFq.onChangeSkinType();
            this.eFr.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.eFL && this.eFJ == 0.0f) {
            if (this.eFI != null) {
                this.eFI.removeAllUpdateListeners();
                this.eFI.cancel();
            }
            if (this.eFK != null) {
                this.eFK.removeAllUpdateListeners();
                this.eFK.cancel();
            }
        }
        super.onDetachedFromWindow();
    }
}
