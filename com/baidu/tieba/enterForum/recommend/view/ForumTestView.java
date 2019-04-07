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
    private List<f> eEZ;
    private a eFA;
    private boolean eFB;
    private float eFC;
    private CellForumTestView eFa;
    private CellForumTestView eFb;
    private CellForumTestView eFc;
    private CellForumTestView eFd;
    private CellForumTestView eFe;
    private CellForumTestView eFf;
    private int eFg;
    private int eFh;
    private int eFi;
    private int eFj;
    private int eFk;
    private int eFl;
    private int eFm;
    private Rect[] eFn;
    private float eFo;
    private float eFp;
    private float eFq;
    private float eFr;
    private float eFs;
    private ValueAnimator eFt;
    private float eFu;
    private ValueAnimator eFv;
    private boolean eFw;
    private boolean eFx;
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
        this.eFn = new Rect[3];
        this.eFw = false;
        this.eFx = false;
        this.eFB = false;
        this.eFC = 0.0f;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eFn = new Rect[3];
        this.eFw = false;
        this.eFx = false;
        this.eFB = false;
        this.eFC = 0.0f;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eFn = new Rect[3];
        this.eFw = false;
        this.eFx = false;
        this.eFB = false;
        this.eFC = 0.0f;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.forum_test_layout, (ViewGroup) this, true);
        this.eFa = (CellForumTestView) findViewById(d.g.forum_test_view_one);
        this.eFb = (CellForumTestView) findViewById(d.g.forum_test_view_two);
        this.eFc = (CellForumTestView) findViewById(d.g.forum_test_view_three);
        this.eFd = (CellForumTestView) findViewById(d.g.forum_test_view_del);
        this.eFk = l.h(context, d.e.tbds44);
        this.eFl = l.h(context, d.e.tbds30);
        this.eFm = l.h(context, d.e.tbds7);
        this.eFg = l.h(context, d.e.tbds962);
        this.eFj = l.h(context, d.e.tbds730);
        this.eFi = this.eFj - (this.eFl * 2);
        this.mWidth = l.aO(getContext());
        this.mHeight = this.eFj + this.eFk;
        this.eFh = ((this.mWidth - this.eFg) - (this.eFm * 2)) / 2;
        this.eFq = this.eFl / (this.eFg + this.eFm);
        this.eFr = this.eFj / this.eFg;
        this.eFs = this.eFg / (this.eFg + this.eFm);
        this.eFn[0] = new Rect(this.eFh - this.eFg, this.eFk + this.eFl, this.eFh, this.eFk + this.eFl + this.eFi);
        this.eFn[1] = new Rect(this.eFh + this.eFm, this.eFk, this.eFh + this.eFm + this.eFg, this.eFk + this.eFj);
        this.eFn[2] = new Rect(this.mWidth - this.eFh, this.eFk + this.eFl, (this.mWidth - this.eFh) + this.eFg, this.eFk + this.eFl + this.eFi);
        resetData();
        ViewConfiguration.get(context);
        this.Qb = ViewConfiguration.getMaximumFlingVelocity();
        this.eFa.setForumTestDelClickListener(this);
        this.eFb.setForumTestDelClickListener(this);
        this.eFc.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eFv = ValueAnimator.ofFloat(this.eFg, 0.0f);
        this.eFv.setDuration(500L);
        this.eFv.setInterpolator(new DecelerateInterpolator());
        this.eFv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.eFy != 1) {
                    if (ForumTestView.this.eFy == 2 || ForumTestView.this.eFy == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.eFq * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.eFr;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eFu)) {
                            ForumTestView.this.eFd.setAlpha(0.0f);
                            ForumTestView.this.eFd.setVisibility(8);
                            ForumTestView.this.eFu = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.eFe);
                            ForumTestView.this.d(ForumTestView.this.eFd);
                            ForumTestView.this.eEZ.remove(ForumTestView.this.eFd.getData());
                            ForumTestView.this.akF();
                            ForumTestView.this.eFx = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.eFe, floatValue, abs);
                            if ((ForumTestView.this.eFg * 2) / 5 >= ForumTestView.this.eFd.getViewRight() - ForumTestView.this.eFd.getViewLeft()) {
                                ForumTestView.this.eFd.setAlpha(0.0f);
                                ForumTestView.this.eFd.setVisibility(8);
                            } else {
                                ForumTestView.this.eFd.setViewLeft(ForumTestView.this.eFd.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eFd.setViewRight(ForumTestView.this.eFd.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eFd.setViewTop(ForumTestView.this.eFd.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.eFd.setViewBottom(ForumTestView.this.eFd.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.eFd.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.eFg * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.eFq * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.eFr;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.eFu)) {
                        ForumTestView.this.eFd.setAlpha(0.0f);
                        ForumTestView.this.eFd.setVisibility(8);
                        ForumTestView.this.eFu = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.eFe);
                        ForumTestView.this.d(ForumTestView.this.eFd);
                        ForumTestView.this.d(ForumTestView.this.eFf);
                        ForumTestView.this.eEZ.remove(ForumTestView.this.eFd.getData());
                        if (ForumTestView.this.eFa.getIndex() == 0) {
                            if (ForumTestView.this.eFa.getDataIndex() > ForumTestView.this.eFf.getDataIndex()) {
                                ForumTestView.this.eFa.setDataIndex(ForumTestView.this.eFa.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eFa);
                            }
                        } else if (ForumTestView.this.eFb.getIndex() == 0) {
                            if (ForumTestView.this.eFb.getDataIndex() > ForumTestView.this.eFf.getDataIndex()) {
                                ForumTestView.this.eFb.setDataIndex(ForumTestView.this.eFb.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eFb);
                            }
                        } else if (ForumTestView.this.eFc.getDataIndex() > ForumTestView.this.eFf.getDataIndex()) {
                            ForumTestView.this.eFc.setDataIndex(ForumTestView.this.eFc.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eFc);
                        }
                        if (ForumTestView.this.eFe.getDataIndex() > ForumTestView.this.eFf.getDataIndex()) {
                            ForumTestView.this.eFe.setDataIndex(ForumTestView.this.eFe.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eFe);
                        }
                        ForumTestView.this.eFf.setDataIndex(ForumTestView.this.eFf.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.eFf);
                        ForumTestView.this.akF();
                        ForumTestView.this.eFx = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.eFe, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.eFf, floatValue2);
                        if ((ForumTestView.this.eFg * 2) / 5 >= ForumTestView.this.eFd.getViewRight() - ForumTestView.this.eFd.getViewLeft()) {
                            ForumTestView.this.eFd.setAlpha(0.0f);
                            ForumTestView.this.eFd.setVisibility(8);
                        } else {
                            ForumTestView.this.eFd.setViewLeft(ForumTestView.this.eFd.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eFd.setViewRight(ForumTestView.this.eFd.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eFd.setViewTop(ForumTestView.this.eFd.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.eFd.setViewBottom(ForumTestView.this.eFd.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.eFd.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.eFg * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.eFr * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.eFu / 2.0f)) {
                    ForumTestView.this.eFd.setAlpha(0.0f);
                    ForumTestView.this.eFd.setVisibility(8);
                    ForumTestView.this.eFu = 0.0f;
                    ForumTestView.this.eEZ.remove(ForumTestView.this.eFd.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.eFA != null) {
                        ForumTestView.this.eFA.cz(-1L);
                    }
                    ForumTestView.this.eFx = false;
                } else {
                    ForumTestView.this.eFd.setViewLeft(ForumTestView.this.eFd.getMoveLeft() + floatValue3);
                    ForumTestView.this.eFd.setViewRight(ForumTestView.this.eFd.getMoveRight() - floatValue3);
                    ForumTestView.this.eFd.setViewTop(ForumTestView.this.eFd.getMoveTop() + f);
                    ForumTestView.this.eFd.setViewBottom(ForumTestView.this.eFd.getMoveBottom() - f);
                    ForumTestView.this.eFd.setAlpha(1.0f - (floatValue3 / ForumTestView.this.eFu));
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
            a(this.eFa);
            a(this.eFb);
            a(this.eFc);
            a(this.eFd);
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
            this.eFa.layout((int) this.eFa.getViewLeft(), (int) this.eFa.getViewTop(), (int) this.eFa.getViewRight(), (int) this.eFa.getViewBottom());
            this.eFb.layout((int) this.eFb.getViewLeft(), (int) this.eFb.getViewTop(), (int) this.eFb.getViewRight(), (int) this.eFb.getViewBottom());
            this.eFc.layout((int) this.eFc.getViewLeft(), (int) this.eFc.getViewTop(), (int) this.eFc.getViewRight(), (int) this.eFc.getViewBottom());
            this.eFd.layout((int) this.eFd.getViewLeft(), (int) this.eFd.getViewTop(), (int) this.eFd.getViewRight(), (int) this.eFd.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.eFv == null || !this.eFv.isRunning()) {
            if (this.eFt == null || !this.eFt.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.eFt != null) {
                        this.eFt.removeAllUpdateListeners();
                        this.eFt.cancel();
                    }
                    this.eFz = motionEvent.getPointerId(0);
                    this.eFo = x;
                    this.eFp = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.eFo - x;
                    float f2 = this.eFp - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.eFw = true;
                        this.eFu = f;
                    } else if (Math.abs(f2) > 30.0f && !this.eFw) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.eFq * f3;
                    if (this.eFw) {
                        b(this.eFa, f3, f4);
                        b(this.eFb, f3, f4);
                        b(this.eFc, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Qb);
                    float xVelocity = velocityTracker.getXVelocity(this.eFz);
                    if (this.eFw || this.eFu != 0.0f) {
                        aC(xVelocity);
                    }
                    this.eFw = false;
                    releaseVelocityTracker();
                }
                if (this.eFw || this.eFu != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.eEZ.size() > 2) {
                if (cellForumTestView.getViewRight() < this.eFn[0].right - (this.eFg / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.eFn[0].right - (this.eFg / 2))) + this.eFn[2].left + (this.eFg / 2) + this.eFm);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.eFg);
                    cellForumTestView.setViewTop(this.eFn[2].top);
                    cellForumTestView.setViewBottom(this.eFn[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eEZ.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.eFn[2].left + (this.eFg / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.eFn[2].left + (this.eFg / 2))) + ((this.eFn[0].right - (this.eFg / 2)) - this.eFm));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.eFg);
                    cellForumTestView.setViewTop(this.eFn[0].top);
                    cellForumTestView.setViewBottom(this.eFn[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eEZ.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.eFn[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.eFn[0].top) {
                    cellForumTestView.setViewTop(this.eFn[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.eFn[0].bottom) {
                    cellForumTestView.setViewBottom(this.eFn[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.eFn[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.eFn[1].top) {
                    cellForumTestView.setViewTop(this.eFn[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.eFn[1].bottom) {
                    cellForumTestView.setViewBottom(this.eFn[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.eFA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akF() {
        if (this.eFA != null) {
            if (this.eFa.getIndex() == 1 && this.eFa.getData() != null) {
                this.eFA.cz(this.eFa.getData().testId);
            } else if (this.eFb.getIndex() == 1 && this.eFb.getData() != null) {
                this.eFA.cz(this.eFb.getData().testId);
            } else if (this.eFc.getIndex() == 1 && this.eFc.getData() != null) {
                this.eFA.cz(this.eFc.getData().testId);
            } else {
                this.eFA.cz(-1L);
            }
        }
    }

    private void aXi() {
        this.eFt = ValueAnimator.ofFloat(this.eFg, 0.0f);
        this.eFt.setDuration(200L);
        this.eFt.setInterpolator(new DecelerateInterpolator());
        this.eFt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eFu)) {
                    if (ForumTestView.this.eFB) {
                        if (ForumTestView.this.eFu > 0.0f) {
                            ForumTestView.this.aXj();
                        } else {
                            ForumTestView.this.aXk();
                        }
                        ForumTestView.this.eFB = false;
                    }
                    ForumTestView.this.eFC = 0.0f;
                    ForumTestView.this.eFu = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.eFa);
                    ForumTestView.this.d(ForumTestView.this.eFb);
                    ForumTestView.this.d(ForumTestView.this.eFc);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.akF();
                } else {
                    if (ForumTestView.this.eFB) {
                        if (ForumTestView.this.eFu > 0.0f) {
                            if (ForumTestView.this.ph(2) != null && ForumTestView.this.ph(2).getViewLeft() >= l.aO(ForumTestView.this.getContext())) {
                                ForumTestView.this.aXj();
                                ForumTestView.this.eFB = false;
                            }
                        } else if (ForumTestView.this.ph(0) != null && ForumTestView.this.ph(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.aXk();
                            ForumTestView.this.eFB = false;
                        }
                    }
                    float f = ForumTestView.this.eFC - floatValue;
                    float f2 = ForumTestView.this.eFq * f;
                    ForumTestView.this.b(ForumTestView.this.eFa, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eFb, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eFc, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.eFC = floatValue;
            }
        });
    }

    private void aC(float f) {
        CellForumTestView ph;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.eFB = false;
        this.eFC = 0.0f;
        aXi();
        if (this.eEZ.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.eFa.getVisibility() == 0) {
                cellForumTestView3 = this.eFa;
            }
            if (this.eFb.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.eFb;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.eFb;
            }
            if (this.eFc.getVisibility() == 0) {
                cellForumTestView2 = this.eFc;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.eFn[0].left) || viewRight > ((float) this.eFn[2].right)) && Math.abs(this.eFu) >= this.eFg * 0.2f) {
                this.eFB = true;
            }
        } else if (this.eEZ.size() > 2 && Math.abs(this.eFu) >= this.eFg * 0.2f) {
            this.eFB = true;
        }
        if (this.eFB && (ph = ph(1)) != null) {
            if (this.eFu >= this.eFg) {
                this.eFu -= this.eFg;
                this.eFB = false;
                aXk();
            } else if (this.eFu > 0.0f && this.eFu < this.eFg) {
                this.eFu = this.eFn[0].right - ph.getViewRight();
            } else if (this.eFu > (-this.eFg)) {
                this.eFu = this.eFn[2].left - ph.getViewLeft();
            } else {
                aXj();
                this.eFu += this.eFg;
                this.eFB = false;
            }
        }
        this.eFt.setFloatValues(0.0f, this.eFu);
        this.eFt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXj() {
        this.eFa.setIndex(this.eFa.getIndex() + 1);
        this.eFb.setIndex(this.eFb.getIndex() + 1);
        this.eFc.setIndex(this.eFc.getIndex() + 1);
        b(this.eFa);
        b(this.eFb);
        b(this.eFc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXk() {
        this.eFa.setIndex(this.eFa.getIndex() - 1);
        this.eFb.setIndex(this.eFb.getIndex() - 1);
        this.eFc.setIndex(this.eFc.getIndex() - 1);
        b(this.eFa);
        b(this.eFb);
        b(this.eFc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView ph(int i) {
        if (this.eFa.getIndex() == i) {
            return this.eFa;
        }
        if (this.eFb.getIndex() == i) {
            return this.eFb;
        }
        if (this.eFc.getIndex() == i) {
            return this.eFc;
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
            int size = this.eEZ.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int pi(int i) {
        int size = this.eEZ.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.eFn[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.eFn[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.eFn[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.eFn[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        if (!v.T(list) && !this.eFw && this.eFu == 0.0f) {
            this.eEZ = list;
            resetData();
            if (v.S(list) > 2) {
                this.eFa.setVisibility(0);
                this.eFb.setVisibility(0);
                this.eFc.setVisibility(0);
                this.eFa.setData(list.get(0));
                this.eFb.setData(list.get(1));
                this.eFc.setData(list.get(2));
                this.eFa.setDataIndex(0);
                this.eFb.setDataIndex(1);
                this.eFc.setDataIndex(2);
            } else if (v.S(list) == 2) {
                this.eFa.setVisibility(8);
                this.eFb.setVisibility(0);
                this.eFc.setVisibility(0);
                this.eFb.setDataIndex(1);
                this.eFc.setDataIndex(0);
                this.eFb.setData(list.get(1));
                this.eFc.setData(list.get(0));
            } else {
                this.eFa.setVisibility(8);
                this.eFb.setVisibility(0);
                this.eFc.setVisibility(8);
                this.eFb.setDataIndex(0);
                this.eFb.setData(list.get(0));
            }
        }
    }

    private void resetData() {
        this.eFa.setIndex(0);
        this.eFb.setIndex(1);
        this.eFc.setIndex(2);
        this.eFd.setIndex(1);
        d(this.eFa);
        d(this.eFb);
        d(this.eFc);
        d(this.eFd);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void pg(int i) {
        CellForumTestView cellForumTestView;
        this.eFx = true;
        this.eFd.setVisibility(0);
        this.eFd.setAlpha(1.0f);
        aXl();
        if (this.eFa.getIndex() == i && this.eFa.getVisibility() == 0) {
            cellForumTestView = this.eFa;
        } else if (this.eFb.getIndex() == i && this.eFb.getVisibility() == 0) {
            cellForumTestView = this.eFb;
        } else {
            cellForumTestView = this.eFc;
        }
        this.eFd.setData(cellForumTestView.getData());
        this.eFd.setDataIndex(cellForumTestView.getDataIndex());
        this.eFf = null;
        if (this.eEZ.size() == 1) {
            this.eFy = 1;
            cellForumTestView.setVisibility(8);
            this.eFu = (this.eFg * 3) / 5;
        } else if (this.eEZ.size() == 2) {
            this.eFy = 2;
            cellForumTestView.setVisibility(8);
            if (this.eFa.getVisibility() == 0) {
                this.eFe = this.eFa;
            } else if (this.eFb.getVisibility() == 0) {
                this.eFe = this.eFb;
            } else {
                this.eFe = this.eFc;
            }
            if (this.eFe.getViewRight() < this.eFn[1].left) {
                this.eFu = this.eFg + this.eFm;
                this.eFe.setIndex(this.eFe.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.eFe.getViewLeft() > this.eFn[1].right) {
                this.eFu = (-this.eFg) - this.eFm;
                this.eFe.setIndex(this.eFe.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.eFe);
            b(cellForumTestView);
        } else if (this.eEZ.size() == 3) {
            this.eFy = 3;
            cellForumTestView.setVisibility(8);
            if (this.eFa.getIndex() == 2) {
                this.eFe = this.eFa;
            } else if (this.eFb.getIndex() == 2) {
                this.eFe = this.eFb;
            } else {
                this.eFe = this.eFc;
            }
            this.eFu = (-this.eFg) - this.eFm;
            this.eFe.setIndex(this.eFe.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.eFe);
            b(cellForumTestView);
        } else {
            this.eFy = 4;
            this.eFf = cellForumTestView;
            if (this.eFa.getIndex() == 2) {
                this.eFe = this.eFa;
            } else if (this.eFb.getIndex() == 2) {
                this.eFe = this.eFb;
            } else {
                this.eFe = this.eFc;
            }
            this.eFu = (-this.eFg) - this.eFm;
            this.eFe.setIndex(this.eFe.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.eFe);
            b(cellForumTestView);
            this.eFf.setViewLeft(this.eFn[2].right + this.eFm);
            this.eFf.setViewRight(this.eFn[2].right + this.eFm + this.eFg);
            this.eFf.setViewTop(this.eFn[2].top);
            this.eFf.setViewBottom(this.eFn[2].bottom);
            this.eFf.setMoveLeft(this.eFn[2].right + this.eFm);
            this.eFf.setMoveRight(this.eFn[2].right + this.eFm + this.eFg);
            this.eFf.setMoveTop(this.eFn[2].top);
            this.eFf.setMoveBottom(this.eFn[2].bottom);
            this.eFf.setData(this.eEZ.get(pi(this.eFf.getDataIndex() + 2)));
        }
        this.eFv.setFloatValues(0.0f, this.eFu);
        this.eFv.start();
    }

    private void aXl() {
        this.eFa.setMoveLeft(this.eFa.getViewLeft());
        this.eFa.setMoveTop(this.eFa.getViewTop());
        this.eFa.setMoveRight(this.eFa.getViewRight());
        this.eFa.setMoveBottom(this.eFa.getViewBottom());
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
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.cp_bg_line_c);
            this.eFa.onChangeSkinType();
            this.eFb.onChangeSkinType();
            this.eFc.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.eFw && this.eFu == 0.0f) {
            if (this.eFt != null) {
                this.eFt.removeAllUpdateListeners();
                this.eFt.cancel();
            }
            if (this.eFv != null) {
                this.eFv.removeAllUpdateListeners();
                this.eFv.cancel();
            }
        }
        super.onDetachedFromWindow();
    }
}
