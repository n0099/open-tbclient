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
    private a eFB;
    private boolean eFC;
    private float eFD;
    private List<f> eFa;
    private CellForumTestView eFb;
    private CellForumTestView eFc;
    private CellForumTestView eFd;
    private CellForumTestView eFe;
    private CellForumTestView eFf;
    private CellForumTestView eFg;
    private int eFh;
    private int eFi;
    private int eFj;
    private int eFk;
    private int eFl;
    private int eFm;
    private int eFn;
    private Rect[] eFo;
    private float eFp;
    private float eFq;
    private float eFr;
    private float eFs;
    private float eFt;
    private ValueAnimator eFu;
    private float eFv;
    private ValueAnimator eFw;
    private boolean eFx;
    private boolean eFy;
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
        this.eFo = new Rect[3];
        this.eFx = false;
        this.eFy = false;
        this.eFC = false;
        this.eFD = 0.0f;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eFo = new Rect[3];
        this.eFx = false;
        this.eFy = false;
        this.eFC = false;
        this.eFD = 0.0f;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eFo = new Rect[3];
        this.eFx = false;
        this.eFy = false;
        this.eFC = false;
        this.eFD = 0.0f;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.forum_test_layout, (ViewGroup) this, true);
        this.eFb = (CellForumTestView) findViewById(d.g.forum_test_view_one);
        this.eFc = (CellForumTestView) findViewById(d.g.forum_test_view_two);
        this.eFd = (CellForumTestView) findViewById(d.g.forum_test_view_three);
        this.eFe = (CellForumTestView) findViewById(d.g.forum_test_view_del);
        this.eFl = l.h(context, d.e.tbds44);
        this.eFm = l.h(context, d.e.tbds30);
        this.eFn = l.h(context, d.e.tbds7);
        this.eFh = l.h(context, d.e.tbds962);
        this.eFk = l.h(context, d.e.tbds730);
        this.eFj = this.eFk - (this.eFm * 2);
        this.mWidth = l.aO(getContext());
        this.mHeight = this.eFk + this.eFl;
        this.eFi = ((this.mWidth - this.eFh) - (this.eFn * 2)) / 2;
        this.eFr = this.eFm / (this.eFh + this.eFn);
        this.eFs = this.eFk / this.eFh;
        this.eFt = this.eFh / (this.eFh + this.eFn);
        this.eFo[0] = new Rect(this.eFi - this.eFh, this.eFl + this.eFm, this.eFi, this.eFl + this.eFm + this.eFj);
        this.eFo[1] = new Rect(this.eFi + this.eFn, this.eFl, this.eFi + this.eFn + this.eFh, this.eFl + this.eFk);
        this.eFo[2] = new Rect(this.mWidth - this.eFi, this.eFl + this.eFm, (this.mWidth - this.eFi) + this.eFh, this.eFl + this.eFm + this.eFj);
        resetData();
        ViewConfiguration.get(context);
        this.Qb = ViewConfiguration.getMaximumFlingVelocity();
        this.eFb.setForumTestDelClickListener(this);
        this.eFc.setForumTestDelClickListener(this);
        this.eFd.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eFw = ValueAnimator.ofFloat(this.eFh, 0.0f);
        this.eFw.setDuration(500L);
        this.eFw.setInterpolator(new DecelerateInterpolator());
        this.eFw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.eFz != 1) {
                    if (ForumTestView.this.eFz == 2 || ForumTestView.this.eFz == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.eFr * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.eFs;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eFv)) {
                            ForumTestView.this.eFe.setAlpha(0.0f);
                            ForumTestView.this.eFe.setVisibility(8);
                            ForumTestView.this.eFv = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.eFf);
                            ForumTestView.this.d(ForumTestView.this.eFe);
                            ForumTestView.this.eFa.remove(ForumTestView.this.eFe.getData());
                            ForumTestView.this.akF();
                            ForumTestView.this.eFy = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.eFf, floatValue, abs);
                            if ((ForumTestView.this.eFh * 2) / 5 >= ForumTestView.this.eFe.getViewRight() - ForumTestView.this.eFe.getViewLeft()) {
                                ForumTestView.this.eFe.setAlpha(0.0f);
                                ForumTestView.this.eFe.setVisibility(8);
                            } else {
                                ForumTestView.this.eFe.setViewLeft(ForumTestView.this.eFe.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eFe.setViewRight(ForumTestView.this.eFe.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eFe.setViewTop(ForumTestView.this.eFe.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.eFe.setViewBottom(ForumTestView.this.eFe.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.eFe.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.eFh * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.eFr * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.eFs;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.eFv)) {
                        ForumTestView.this.eFe.setAlpha(0.0f);
                        ForumTestView.this.eFe.setVisibility(8);
                        ForumTestView.this.eFv = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.eFf);
                        ForumTestView.this.d(ForumTestView.this.eFe);
                        ForumTestView.this.d(ForumTestView.this.eFg);
                        ForumTestView.this.eFa.remove(ForumTestView.this.eFe.getData());
                        if (ForumTestView.this.eFb.getIndex() == 0) {
                            if (ForumTestView.this.eFb.getDataIndex() > ForumTestView.this.eFg.getDataIndex()) {
                                ForumTestView.this.eFb.setDataIndex(ForumTestView.this.eFb.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eFb);
                            }
                        } else if (ForumTestView.this.eFc.getIndex() == 0) {
                            if (ForumTestView.this.eFc.getDataIndex() > ForumTestView.this.eFg.getDataIndex()) {
                                ForumTestView.this.eFc.setDataIndex(ForumTestView.this.eFc.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eFc);
                            }
                        } else if (ForumTestView.this.eFd.getDataIndex() > ForumTestView.this.eFg.getDataIndex()) {
                            ForumTestView.this.eFd.setDataIndex(ForumTestView.this.eFd.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eFd);
                        }
                        if (ForumTestView.this.eFf.getDataIndex() > ForumTestView.this.eFg.getDataIndex()) {
                            ForumTestView.this.eFf.setDataIndex(ForumTestView.this.eFf.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eFf);
                        }
                        ForumTestView.this.eFg.setDataIndex(ForumTestView.this.eFg.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.eFg);
                        ForumTestView.this.akF();
                        ForumTestView.this.eFy = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.eFf, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.eFg, floatValue2);
                        if ((ForumTestView.this.eFh * 2) / 5 >= ForumTestView.this.eFe.getViewRight() - ForumTestView.this.eFe.getViewLeft()) {
                            ForumTestView.this.eFe.setAlpha(0.0f);
                            ForumTestView.this.eFe.setVisibility(8);
                        } else {
                            ForumTestView.this.eFe.setViewLeft(ForumTestView.this.eFe.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eFe.setViewRight(ForumTestView.this.eFe.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eFe.setViewTop(ForumTestView.this.eFe.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.eFe.setViewBottom(ForumTestView.this.eFe.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.eFe.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.eFh * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.eFs * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.eFv / 2.0f)) {
                    ForumTestView.this.eFe.setAlpha(0.0f);
                    ForumTestView.this.eFe.setVisibility(8);
                    ForumTestView.this.eFv = 0.0f;
                    ForumTestView.this.eFa.remove(ForumTestView.this.eFe.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.eFB != null) {
                        ForumTestView.this.eFB.cz(-1L);
                    }
                    ForumTestView.this.eFy = false;
                } else {
                    ForumTestView.this.eFe.setViewLeft(ForumTestView.this.eFe.getMoveLeft() + floatValue3);
                    ForumTestView.this.eFe.setViewRight(ForumTestView.this.eFe.getMoveRight() - floatValue3);
                    ForumTestView.this.eFe.setViewTop(ForumTestView.this.eFe.getMoveTop() + f);
                    ForumTestView.this.eFe.setViewBottom(ForumTestView.this.eFe.getMoveBottom() - f);
                    ForumTestView.this.eFe.setAlpha(1.0f - (floatValue3 / ForumTestView.this.eFv));
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
            a(this.eFb);
            a(this.eFc);
            a(this.eFd);
            a(this.eFe);
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
            this.eFb.layout((int) this.eFb.getViewLeft(), (int) this.eFb.getViewTop(), (int) this.eFb.getViewRight(), (int) this.eFb.getViewBottom());
            this.eFc.layout((int) this.eFc.getViewLeft(), (int) this.eFc.getViewTop(), (int) this.eFc.getViewRight(), (int) this.eFc.getViewBottom());
            this.eFd.layout((int) this.eFd.getViewLeft(), (int) this.eFd.getViewTop(), (int) this.eFd.getViewRight(), (int) this.eFd.getViewBottom());
            this.eFe.layout((int) this.eFe.getViewLeft(), (int) this.eFe.getViewTop(), (int) this.eFe.getViewRight(), (int) this.eFe.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.eFw == null || !this.eFw.isRunning()) {
            if (this.eFu == null || !this.eFu.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.eFu != null) {
                        this.eFu.removeAllUpdateListeners();
                        this.eFu.cancel();
                    }
                    this.eFA = motionEvent.getPointerId(0);
                    this.eFp = x;
                    this.eFq = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.eFp - x;
                    float f2 = this.eFq - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.eFx = true;
                        this.eFv = f;
                    } else if (Math.abs(f2) > 30.0f && !this.eFx) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.eFr * f3;
                    if (this.eFx) {
                        b(this.eFb, f3, f4);
                        b(this.eFc, f3, f4);
                        b(this.eFd, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Qb);
                    float xVelocity = velocityTracker.getXVelocity(this.eFA);
                    if (this.eFx || this.eFv != 0.0f) {
                        aC(xVelocity);
                    }
                    this.eFx = false;
                    releaseVelocityTracker();
                }
                if (this.eFx || this.eFv != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.eFa.size() > 2) {
                if (cellForumTestView.getViewRight() < this.eFo[0].right - (this.eFh / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.eFo[0].right - (this.eFh / 2))) + this.eFo[2].left + (this.eFh / 2) + this.eFn);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.eFh);
                    cellForumTestView.setViewTop(this.eFo[2].top);
                    cellForumTestView.setViewBottom(this.eFo[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eFa.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.eFo[2].left + (this.eFh / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.eFo[2].left + (this.eFh / 2))) + ((this.eFo[0].right - (this.eFh / 2)) - this.eFn));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.eFh);
                    cellForumTestView.setViewTop(this.eFo[0].top);
                    cellForumTestView.setViewBottom(this.eFo[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eFa.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.eFo[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.eFo[0].top) {
                    cellForumTestView.setViewTop(this.eFo[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.eFo[0].bottom) {
                    cellForumTestView.setViewBottom(this.eFo[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.eFo[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.eFo[1].top) {
                    cellForumTestView.setViewTop(this.eFo[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.eFo[1].bottom) {
                    cellForumTestView.setViewBottom(this.eFo[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.eFB = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akF() {
        if (this.eFB != null) {
            if (this.eFb.getIndex() == 1 && this.eFb.getData() != null) {
                this.eFB.cz(this.eFb.getData().testId);
            } else if (this.eFc.getIndex() == 1 && this.eFc.getData() != null) {
                this.eFB.cz(this.eFc.getData().testId);
            } else if (this.eFd.getIndex() == 1 && this.eFd.getData() != null) {
                this.eFB.cz(this.eFd.getData().testId);
            } else {
                this.eFB.cz(-1L);
            }
        }
    }

    private void aXi() {
        this.eFu = ValueAnimator.ofFloat(this.eFh, 0.0f);
        this.eFu.setDuration(200L);
        this.eFu.setInterpolator(new DecelerateInterpolator());
        this.eFu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eFv)) {
                    if (ForumTestView.this.eFC) {
                        if (ForumTestView.this.eFv > 0.0f) {
                            ForumTestView.this.aXj();
                        } else {
                            ForumTestView.this.aXk();
                        }
                        ForumTestView.this.eFC = false;
                    }
                    ForumTestView.this.eFD = 0.0f;
                    ForumTestView.this.eFv = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.eFb);
                    ForumTestView.this.d(ForumTestView.this.eFc);
                    ForumTestView.this.d(ForumTestView.this.eFd);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.akF();
                } else {
                    if (ForumTestView.this.eFC) {
                        if (ForumTestView.this.eFv > 0.0f) {
                            if (ForumTestView.this.ph(2) != null && ForumTestView.this.ph(2).getViewLeft() >= l.aO(ForumTestView.this.getContext())) {
                                ForumTestView.this.aXj();
                                ForumTestView.this.eFC = false;
                            }
                        } else if (ForumTestView.this.ph(0) != null && ForumTestView.this.ph(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.aXk();
                            ForumTestView.this.eFC = false;
                        }
                    }
                    float f = ForumTestView.this.eFD - floatValue;
                    float f2 = ForumTestView.this.eFr * f;
                    ForumTestView.this.b(ForumTestView.this.eFb, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eFc, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eFd, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.eFD = floatValue;
            }
        });
    }

    private void aC(float f) {
        CellForumTestView ph;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.eFC = false;
        this.eFD = 0.0f;
        aXi();
        if (this.eFa.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.eFb.getVisibility() == 0) {
                cellForumTestView3 = this.eFb;
            }
            if (this.eFc.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.eFc;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.eFc;
            }
            if (this.eFd.getVisibility() == 0) {
                cellForumTestView2 = this.eFd;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.eFo[0].left) || viewRight > ((float) this.eFo[2].right)) && Math.abs(this.eFv) >= this.eFh * 0.2f) {
                this.eFC = true;
            }
        } else if (this.eFa.size() > 2 && Math.abs(this.eFv) >= this.eFh * 0.2f) {
            this.eFC = true;
        }
        if (this.eFC && (ph = ph(1)) != null) {
            if (this.eFv >= this.eFh) {
                this.eFv -= this.eFh;
                this.eFC = false;
                aXk();
            } else if (this.eFv > 0.0f && this.eFv < this.eFh) {
                this.eFv = this.eFo[0].right - ph.getViewRight();
            } else if (this.eFv > (-this.eFh)) {
                this.eFv = this.eFo[2].left - ph.getViewLeft();
            } else {
                aXj();
                this.eFv += this.eFh;
                this.eFC = false;
            }
        }
        this.eFu.setFloatValues(0.0f, this.eFv);
        this.eFu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXj() {
        this.eFb.setIndex(this.eFb.getIndex() + 1);
        this.eFc.setIndex(this.eFc.getIndex() + 1);
        this.eFd.setIndex(this.eFd.getIndex() + 1);
        b(this.eFb);
        b(this.eFc);
        b(this.eFd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXk() {
        this.eFb.setIndex(this.eFb.getIndex() - 1);
        this.eFc.setIndex(this.eFc.getIndex() - 1);
        this.eFd.setIndex(this.eFd.getIndex() - 1);
        b(this.eFb);
        b(this.eFc);
        b(this.eFd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView ph(int i) {
        if (this.eFb.getIndex() == i) {
            return this.eFb;
        }
        if (this.eFc.getIndex() == i) {
            return this.eFc;
        }
        if (this.eFd.getIndex() == i) {
            return this.eFd;
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
            int size = this.eFa.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int pi(int i) {
        int size = this.eFa.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.eFo[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.eFo[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.eFo[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.eFo[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        if (!v.T(list) && !this.eFx && this.eFv == 0.0f) {
            this.eFa = list;
            resetData();
            if (v.S(list) > 2) {
                this.eFb.setVisibility(0);
                this.eFc.setVisibility(0);
                this.eFd.setVisibility(0);
                this.eFb.setData(list.get(0));
                this.eFc.setData(list.get(1));
                this.eFd.setData(list.get(2));
                this.eFb.setDataIndex(0);
                this.eFc.setDataIndex(1);
                this.eFd.setDataIndex(2);
            } else if (v.S(list) == 2) {
                this.eFb.setVisibility(8);
                this.eFc.setVisibility(0);
                this.eFd.setVisibility(0);
                this.eFc.setDataIndex(1);
                this.eFd.setDataIndex(0);
                this.eFc.setData(list.get(1));
                this.eFd.setData(list.get(0));
            } else {
                this.eFb.setVisibility(8);
                this.eFc.setVisibility(0);
                this.eFd.setVisibility(8);
                this.eFc.setDataIndex(0);
                this.eFc.setData(list.get(0));
            }
        }
    }

    private void resetData() {
        this.eFb.setIndex(0);
        this.eFc.setIndex(1);
        this.eFd.setIndex(2);
        this.eFe.setIndex(1);
        d(this.eFb);
        d(this.eFc);
        d(this.eFd);
        d(this.eFe);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void pg(int i) {
        CellForumTestView cellForumTestView;
        this.eFy = true;
        this.eFe.setVisibility(0);
        this.eFe.setAlpha(1.0f);
        aXl();
        if (this.eFb.getIndex() == i && this.eFb.getVisibility() == 0) {
            cellForumTestView = this.eFb;
        } else if (this.eFc.getIndex() == i && this.eFc.getVisibility() == 0) {
            cellForumTestView = this.eFc;
        } else {
            cellForumTestView = this.eFd;
        }
        this.eFe.setData(cellForumTestView.getData());
        this.eFe.setDataIndex(cellForumTestView.getDataIndex());
        this.eFg = null;
        if (this.eFa.size() == 1) {
            this.eFz = 1;
            cellForumTestView.setVisibility(8);
            this.eFv = (this.eFh * 3) / 5;
        } else if (this.eFa.size() == 2) {
            this.eFz = 2;
            cellForumTestView.setVisibility(8);
            if (this.eFb.getVisibility() == 0) {
                this.eFf = this.eFb;
            } else if (this.eFc.getVisibility() == 0) {
                this.eFf = this.eFc;
            } else {
                this.eFf = this.eFd;
            }
            if (this.eFf.getViewRight() < this.eFo[1].left) {
                this.eFv = this.eFh + this.eFn;
                this.eFf.setIndex(this.eFf.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.eFf.getViewLeft() > this.eFo[1].right) {
                this.eFv = (-this.eFh) - this.eFn;
                this.eFf.setIndex(this.eFf.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.eFf);
            b(cellForumTestView);
        } else if (this.eFa.size() == 3) {
            this.eFz = 3;
            cellForumTestView.setVisibility(8);
            if (this.eFb.getIndex() == 2) {
                this.eFf = this.eFb;
            } else if (this.eFc.getIndex() == 2) {
                this.eFf = this.eFc;
            } else {
                this.eFf = this.eFd;
            }
            this.eFv = (-this.eFh) - this.eFn;
            this.eFf.setIndex(this.eFf.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.eFf);
            b(cellForumTestView);
        } else {
            this.eFz = 4;
            this.eFg = cellForumTestView;
            if (this.eFb.getIndex() == 2) {
                this.eFf = this.eFb;
            } else if (this.eFc.getIndex() == 2) {
                this.eFf = this.eFc;
            } else {
                this.eFf = this.eFd;
            }
            this.eFv = (-this.eFh) - this.eFn;
            this.eFf.setIndex(this.eFf.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.eFf);
            b(cellForumTestView);
            this.eFg.setViewLeft(this.eFo[2].right + this.eFn);
            this.eFg.setViewRight(this.eFo[2].right + this.eFn + this.eFh);
            this.eFg.setViewTop(this.eFo[2].top);
            this.eFg.setViewBottom(this.eFo[2].bottom);
            this.eFg.setMoveLeft(this.eFo[2].right + this.eFn);
            this.eFg.setMoveRight(this.eFo[2].right + this.eFn + this.eFh);
            this.eFg.setMoveTop(this.eFo[2].top);
            this.eFg.setMoveBottom(this.eFo[2].bottom);
            this.eFg.setData(this.eFa.get(pi(this.eFg.getDataIndex() + 2)));
        }
        this.eFw.setFloatValues(0.0f, this.eFv);
        this.eFw.start();
    }

    private void aXl() {
        this.eFb.setMoveLeft(this.eFb.getViewLeft());
        this.eFb.setMoveTop(this.eFb.getViewTop());
        this.eFb.setMoveRight(this.eFb.getViewRight());
        this.eFb.setMoveBottom(this.eFb.getViewBottom());
        this.eFc.setMoveLeft(this.eFc.getViewLeft());
        this.eFc.setMoveTop(this.eFc.getViewTop());
        this.eFc.setMoveRight(this.eFc.getViewRight());
        this.eFc.setMoveBottom(this.eFc.getViewBottom());
        this.eFd.setMoveLeft(this.eFd.getViewLeft());
        this.eFd.setMoveTop(this.eFd.getViewTop());
        this.eFd.setMoveRight(this.eFd.getViewRight());
        this.eFd.setMoveBottom(this.eFd.getViewBottom());
        this.eFe.setMoveLeft(this.eFe.getViewLeft());
        this.eFe.setMoveTop(this.eFe.getViewTop());
        this.eFe.setMoveRight(this.eFe.getViewRight());
        this.eFe.setMoveBottom(this.eFe.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.cp_bg_line_c);
            this.eFb.onChangeSkinType();
            this.eFc.onChangeSkinType();
            this.eFd.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.eFx && this.eFv == 0.0f) {
            if (this.eFu != null) {
                this.eFu.removeAllUpdateListeners();
                this.eFu.cancel();
            }
            if (this.eFw != null) {
                this.eFw.removeAllUpdateListeners();
                this.eFw.cancel();
            }
        }
        super.onDetachedFromWindow();
    }
}
