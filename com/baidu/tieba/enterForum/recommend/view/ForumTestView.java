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
    private int Oa;
    private List<f> fbP;
    private CellForumTestView fbQ;
    private CellForumTestView fbR;
    private CellForumTestView fbS;
    private CellForumTestView fbT;
    private CellForumTestView fbU;
    private CellForumTestView fbV;
    private int fbW;
    private int fbX;
    private int fbY;
    private int fbZ;
    private int fca;
    private int fcb;
    private int fcc;
    private Rect[] fcd;
    private float fce;
    private float fcf;
    private float fcg;
    private float fch;
    private float fci;
    private ValueAnimator fcj;
    private float fck;
    private ValueAnimator fcl;
    private boolean fcm;
    private boolean fcn;
    private int fco;
    private int fcp;
    private a fcq;
    private boolean fcr;
    private float fcs;
    private int fct;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void dg(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fcd = new Rect[3];
        this.fcm = false;
        this.fcn = false;
        this.fcr = false;
        this.fcs = 0.0f;
        this.fct = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fcd = new Rect[3];
        this.fcm = false;
        this.fcn = false;
        this.fcr = false;
        this.fcs = 0.0f;
        this.fct = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fcd = new Rect[3];
        this.fcm = false;
        this.fcn = false;
        this.fcr = false;
        this.fcs = 0.0f;
        this.fct = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fbQ = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fbR = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fbS = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fbT = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        dF(context);
        resetData();
        ViewConfiguration.get(context);
        this.Oa = ViewConfiguration.getMaximumFlingVelocity();
        this.fbQ.setForumTestDelClickListener(this);
        this.fbR.setForumTestDelClickListener(this);
        this.fbS.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void dF(Context context) {
        this.fca = l.g(context, R.dimen.tbds44);
        this.fcb = l.g(context, R.dimen.tbds30);
        this.fcc = l.g(context, R.dimen.tbds7);
        this.fbZ = l.g(context, R.dimen.tbds730);
        this.fbY = this.fbZ - (this.fcb * 2);
        this.mWidth = l.af(getContext());
        this.fbW = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fbZ + this.fca;
        this.fbX = ((this.mWidth - this.fbW) - (this.fcc * 2)) / 2;
        this.fcg = this.fcb / (this.fbW + this.fcc);
        this.fch = this.fbZ / this.fbW;
        this.fci = this.fbW / (this.fbW + this.fcc);
        this.fcd[0] = new Rect(this.fbX - this.fbW, this.fca + this.fcb, this.fbX, this.fca + this.fcb + this.fbY);
        this.fcd[1] = new Rect(this.fbX + this.fcc, this.fca, this.fbX + this.fcc + this.fbW, this.fca + this.fbZ);
        this.fcd[2] = new Rect(this.mWidth - this.fbX, this.fca + this.fcb, (this.mWidth - this.fbX) + this.fbW, this.fca + this.fcb + this.fbY);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fcl = ValueAnimator.ofFloat(this.fbW, 0.0f);
        this.fcl.setDuration(500L);
        this.fcl.setInterpolator(new DecelerateInterpolator());
        this.fcl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fco != 1) {
                    if (ForumTestView.this.fco == 2 || ForumTestView.this.fco == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fcg * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.fch;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.fck)) {
                            ForumTestView.this.fbT.setAlpha(0.0f);
                            ForumTestView.this.fbT.setVisibility(8);
                            ForumTestView.this.fck = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fbU);
                            ForumTestView.this.d(ForumTestView.this.fbT);
                            ForumTestView.this.fbP.remove(ForumTestView.this.fbT.getData());
                            ForumTestView.this.jv(true);
                            ForumTestView.this.fcn = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fbU, floatValue, abs);
                            if ((ForumTestView.this.fbW * 2) / 5 >= ForumTestView.this.fbT.getViewRight() - ForumTestView.this.fbT.getViewLeft()) {
                                ForumTestView.this.fbT.setAlpha(0.0f);
                                ForumTestView.this.fbT.setVisibility(8);
                            } else {
                                ForumTestView.this.fbT.setViewLeft(ForumTestView.this.fbT.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fbT.setViewRight(ForumTestView.this.fbT.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fbT.setViewTop(ForumTestView.this.fbT.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fbT.setViewBottom(ForumTestView.this.fbT.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fbT.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fbW * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fcg * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.fch;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.fck)) {
                        ForumTestView.this.fbT.setAlpha(0.0f);
                        ForumTestView.this.fbT.setVisibility(8);
                        ForumTestView.this.fck = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fbU);
                        ForumTestView.this.d(ForumTestView.this.fbT);
                        ForumTestView.this.d(ForumTestView.this.fbV);
                        ForumTestView.this.fbP.remove(ForumTestView.this.fbT.getData());
                        if (ForumTestView.this.fbQ.getIndex() == 0) {
                            if (ForumTestView.this.fbQ.getDataIndex() > ForumTestView.this.fbV.getDataIndex()) {
                                ForumTestView.this.fbQ.setDataIndex(ForumTestView.this.fbQ.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fbQ);
                            }
                        } else if (ForumTestView.this.fbR.getIndex() == 0) {
                            if (ForumTestView.this.fbR.getDataIndex() > ForumTestView.this.fbV.getDataIndex()) {
                                ForumTestView.this.fbR.setDataIndex(ForumTestView.this.fbR.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fbR);
                            }
                        } else if (ForumTestView.this.fbS.getDataIndex() > ForumTestView.this.fbV.getDataIndex()) {
                            ForumTestView.this.fbS.setDataIndex(ForumTestView.this.fbS.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fbS);
                        }
                        if (ForumTestView.this.fbU.getDataIndex() > ForumTestView.this.fbV.getDataIndex()) {
                            ForumTestView.this.fbU.setDataIndex(ForumTestView.this.fbU.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fbU);
                        }
                        ForumTestView.this.fbV.setDataIndex(ForumTestView.this.fbV.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fbV);
                        ForumTestView.this.jv(true);
                        ForumTestView.this.fcn = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fbU, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fbV, floatValue2);
                        if ((ForumTestView.this.fbW * 2) / 5 >= ForumTestView.this.fbT.getViewRight() - ForumTestView.this.fbT.getViewLeft()) {
                            ForumTestView.this.fbT.setAlpha(0.0f);
                            ForumTestView.this.fbT.setVisibility(8);
                        } else {
                            ForumTestView.this.fbT.setViewLeft(ForumTestView.this.fbT.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fbT.setViewRight(ForumTestView.this.fbT.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fbT.setViewTop(ForumTestView.this.fbT.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fbT.setViewBottom(ForumTestView.this.fbT.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fbT.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fbW * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.fch * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.fck / 2.0f)) {
                    ForumTestView.this.fbT.setAlpha(0.0f);
                    ForumTestView.this.fbT.setVisibility(8);
                    ForumTestView.this.fck = 0.0f;
                    ForumTestView.this.fbP.remove(ForumTestView.this.fbT.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.fcq != null) {
                        ForumTestView.this.fcq.dg(-1L);
                    }
                    ForumTestView.this.fcn = false;
                } else {
                    ForumTestView.this.fbT.setViewLeft(ForumTestView.this.fbT.getMoveLeft() + floatValue3);
                    ForumTestView.this.fbT.setViewRight(ForumTestView.this.fbT.getMoveRight() - floatValue3);
                    ForumTestView.this.fbT.setViewTop(ForumTestView.this.fbT.getMoveTop() + f);
                    ForumTestView.this.fbT.setViewBottom(ForumTestView.this.fbT.getMoveBottom() - f);
                    ForumTestView.this.fbT.setAlpha(1.0f - (floatValue3 / ForumTestView.this.fck));
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
            int af = l.af(getContext());
            if (af != this.fct) {
                this.fct = af;
                dF(getContext());
                d(this.fbQ);
                d(this.fbR);
                d(this.fbS);
                d(this.fbT);
            }
            a(this.fbQ);
            a(this.fbR);
            a(this.fbS);
            a(this.fbT);
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
            this.fbQ.layout((int) this.fbQ.getViewLeft(), (int) this.fbQ.getViewTop(), (int) this.fbQ.getViewRight(), (int) this.fbQ.getViewBottom());
            this.fbR.layout((int) this.fbR.getViewLeft(), (int) this.fbR.getViewTop(), (int) this.fbR.getViewRight(), (int) this.fbR.getViewBottom());
            this.fbS.layout((int) this.fbS.getViewLeft(), (int) this.fbS.getViewTop(), (int) this.fbS.getViewRight(), (int) this.fbS.getViewBottom());
            this.fbT.layout((int) this.fbT.getViewLeft(), (int) this.fbT.getViewTop(), (int) this.fbT.getViewRight(), (int) this.fbT.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.fcl == null || !this.fcl.isRunning()) {
            if (this.fcj == null || !this.fcj.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fcj != null) {
                        this.fcj.removeAllUpdateListeners();
                        this.fcj.cancel();
                    }
                    this.fcp = motionEvent.getPointerId(0);
                    this.fce = x;
                    this.fcf = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fce - x;
                    float f2 = this.fcf - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.fcm = true;
                        this.fck = f;
                    } else if (Math.abs(f2) > 30.0f && !this.fcm) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fcg * f3;
                    if (this.fcm) {
                        b(this.fbQ, f3, f4);
                        b(this.fbR, f3, f4);
                        b(this.fbS, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Oa);
                    float xVelocity = velocityTracker.getXVelocity(this.fcp);
                    if (this.fcm || this.fck != 0.0f) {
                        aE(xVelocity);
                    }
                    this.fcm = false;
                    releaseVelocityTracker();
                }
                if (this.fcm || this.fck != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.fbP.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fcd[0].right - (this.fbW / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fcd[0].right - (this.fbW / 2))) + this.fcd[2].left + (this.fbW / 2) + this.fcc);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fbW);
                    cellForumTestView.setViewTop(this.fcd[2].top);
                    cellForumTestView.setViewBottom(this.fcd[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fbP.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fcd[2].left + (this.fbW / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fcd[2].left + (this.fbW / 2))) + ((this.fcd[0].right - (this.fbW / 2)) - this.fcc));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fbW);
                    cellForumTestView.setViewTop(this.fcd[0].top);
                    cellForumTestView.setViewBottom(this.fcd[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fbP.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fcd[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fcd[0].top) {
                    cellForumTestView.setViewTop(this.fcd[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fcd[0].bottom) {
                    cellForumTestView.setViewBottom(this.fcd[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fcd[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fcd[1].top) {
                    cellForumTestView.setViewTop(this.fcd[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fcd[1].bottom) {
                    cellForumTestView.setViewBottom(this.fcd[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.fcq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jv(boolean z) {
        if (this.fcq != null) {
            int i = -1;
            if (this.fbQ.getIndex() == 1 && this.fbQ.getData() != null) {
                this.fcq.dg(this.fbQ.getData().testId);
                i = this.fbQ.getDataIndex();
            } else if (this.fbR.getIndex() == 1 && this.fbR.getData() != null) {
                this.fcq.dg(this.fbR.getData().testId);
                i = this.fbR.getDataIndex();
            } else if (this.fbS.getIndex() == 1 && this.fbS.getData() != null) {
                this.fcq.dg(this.fbS.getData().testId);
                i = this.fbS.getDataIndex();
            } else {
                this.fcq.dg(-1L);
            }
            if (z) {
                qL(i);
            }
        }
    }

    private void Uf() {
        this.fcj = ValueAnimator.ofFloat(this.fbW, 0.0f);
        this.fcj.setDuration(200L);
        this.fcj.setInterpolator(new DecelerateInterpolator());
        this.fcj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.fck)) {
                    boolean z = Math.abs(ForumTestView.this.fck) >= ((float) ForumTestView.this.fbW) * 0.2f;
                    if (ForumTestView.this.fcr) {
                        if (ForumTestView.this.fck > 0.0f) {
                            ForumTestView.this.bhl();
                        } else {
                            ForumTestView.this.bhm();
                        }
                        ForumTestView.this.fcr = false;
                    }
                    ForumTestView.this.fcs = 0.0f;
                    ForumTestView.this.fck = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fbQ);
                    ForumTestView.this.d(ForumTestView.this.fbR);
                    ForumTestView.this.d(ForumTestView.this.fbS);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.jv(z);
                } else {
                    if (ForumTestView.this.fcr) {
                        if (ForumTestView.this.fck > 0.0f) {
                            if (ForumTestView.this.qJ(2) != null && ForumTestView.this.qJ(2).getViewLeft() >= l.af(ForumTestView.this.getContext())) {
                                ForumTestView.this.bhl();
                                ForumTestView.this.fcr = false;
                            }
                        } else if (ForumTestView.this.qJ(0) != null && ForumTestView.this.qJ(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bhm();
                            ForumTestView.this.fcr = false;
                        }
                    }
                    float f = ForumTestView.this.fcs - floatValue;
                    float f2 = ForumTestView.this.fcg * f;
                    ForumTestView.this.b(ForumTestView.this.fbQ, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fbR, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fbS, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fcs = floatValue;
            }
        });
    }

    private void aE(float f) {
        CellForumTestView qJ;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fcr = false;
        this.fcs = 0.0f;
        Uf();
        if (this.fbP.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fbQ.getVisibility() == 0) {
                cellForumTestView3 = this.fbQ;
            }
            if (this.fbR.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fbR;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fbR;
            }
            if (this.fbS.getVisibility() == 0) {
                cellForumTestView2 = this.fbS;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fcd[0].left) || viewRight > ((float) this.fcd[2].right)) && Math.abs(this.fck) >= this.fbW * 0.2f) {
                this.fcr = true;
            }
        } else if (this.fbP.size() > 2 && Math.abs(this.fck) >= this.fbW * 0.2f) {
            this.fcr = true;
        }
        if (this.fcr && (qJ = qJ(1)) != null) {
            if (this.fck >= this.fbW) {
                this.fck -= this.fbW;
                this.fcr = false;
                bhm();
            } else if (this.fck > 0.0f && this.fck < this.fbW) {
                this.fck = this.fcd[0].right - qJ.getViewRight();
            } else if (this.fck > (-this.fbW)) {
                this.fck = this.fcd[2].left - qJ.getViewLeft();
            } else {
                bhl();
                this.fck += this.fbW;
                this.fcr = false;
            }
        }
        this.fcj.setFloatValues(0.0f, this.fck);
        this.fcj.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhl() {
        this.fbQ.setIndex(this.fbQ.getIndex() + 1);
        this.fbR.setIndex(this.fbR.getIndex() + 1);
        this.fbS.setIndex(this.fbS.getIndex() + 1);
        b(this.fbQ);
        b(this.fbR);
        b(this.fbS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhm() {
        this.fbQ.setIndex(this.fbQ.getIndex() - 1);
        this.fbR.setIndex(this.fbR.getIndex() - 1);
        this.fbS.setIndex(this.fbS.getIndex() - 1);
        b(this.fbQ);
        b(this.fbR);
        b(this.fbS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView qJ(int i) {
        if (this.fbQ.getIndex() == i) {
            return this.fbQ;
        }
        if (this.fbR.getIndex() == i) {
            return this.fbR;
        }
        if (this.fbS.getIndex() == i) {
            return this.fbS;
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
            int size = this.fbP.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int qK(int i) {
        int size = this.fbP.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fcd[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fcd[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fcd[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fcd[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.aa(list) && !this.fcm && this.fck == 0.0f) {
            this.fbP = list;
            resetData();
            if (v.Z(list) > 2) {
                this.fbQ.setVisibility(0);
                this.fbR.setVisibility(0);
                this.fbS.setVisibility(0);
                this.fbQ.setData(list.get(0));
                this.fbR.setData(list.get(1));
                this.fbS.setData(list.get(2));
                this.fbQ.setDataIndex(0);
                this.fbR.setDataIndex(1);
                this.fbS.setDataIndex(2);
                i = 1;
            } else if (v.Z(list) == 2) {
                this.fbQ.setVisibility(8);
                this.fbR.setVisibility(0);
                this.fbS.setVisibility(0);
                this.fbR.setDataIndex(1);
                this.fbS.setDataIndex(0);
                this.fbR.setData(list.get(1));
                this.fbS.setData(list.get(0));
                i = 1;
            } else {
                this.fbQ.setVisibility(8);
                this.fbR.setVisibility(0);
                this.fbS.setVisibility(8);
                this.fbR.setDataIndex(0);
                this.fbR.setData(list.get(0));
                i = 0;
            }
            qL(i);
        }
    }

    private void resetData() {
        this.fbQ.setIndex(0);
        this.fbR.setIndex(1);
        this.fbS.setIndex(2);
        this.fbT.setIndex(1);
        d(this.fbQ);
        d(this.fbR);
        d(this.fbS);
        d(this.fbT);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void qI(int i) {
        CellForumTestView cellForumTestView;
        this.fcn = true;
        this.fbT.setVisibility(0);
        this.fbT.setAlpha(1.0f);
        bhn();
        if (this.fbQ.getIndex() == i && this.fbQ.getVisibility() == 0) {
            cellForumTestView = this.fbQ;
        } else if (this.fbR.getIndex() == i && this.fbR.getVisibility() == 0) {
            cellForumTestView = this.fbR;
        } else {
            cellForumTestView = this.fbS;
        }
        this.fbT.setData(cellForumTestView.getData());
        this.fbT.setDataIndex(cellForumTestView.getDataIndex());
        this.fbV = null;
        if (this.fbP.size() == 1) {
            this.fco = 1;
            cellForumTestView.setVisibility(8);
            this.fck = (this.fbW * 3) / 5;
        } else if (this.fbP.size() == 2) {
            this.fco = 2;
            cellForumTestView.setVisibility(8);
            if (this.fbQ.getVisibility() == 0) {
                this.fbU = this.fbQ;
            } else if (this.fbR.getVisibility() == 0) {
                this.fbU = this.fbR;
            } else {
                this.fbU = this.fbS;
            }
            if (this.fbU.getViewRight() < this.fcd[1].left) {
                this.fck = this.fbW + this.fcc;
                this.fbU.setIndex(this.fbU.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fbU.getViewLeft() > this.fcd[1].right) {
                this.fck = (-this.fbW) - this.fcc;
                this.fbU.setIndex(this.fbU.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fbU);
            b(cellForumTestView);
        } else if (this.fbP.size() == 3) {
            this.fco = 3;
            cellForumTestView.setVisibility(8);
            if (this.fbQ.getIndex() == 2) {
                this.fbU = this.fbQ;
            } else if (this.fbR.getIndex() == 2) {
                this.fbU = this.fbR;
            } else {
                this.fbU = this.fbS;
            }
            this.fck = (-this.fbW) - this.fcc;
            this.fbU.setIndex(this.fbU.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fbU);
            b(cellForumTestView);
        } else {
            this.fco = 4;
            this.fbV = cellForumTestView;
            if (this.fbQ.getIndex() == 2) {
                this.fbU = this.fbQ;
            } else if (this.fbR.getIndex() == 2) {
                this.fbU = this.fbR;
            } else {
                this.fbU = this.fbS;
            }
            this.fck = (-this.fbW) - this.fcc;
            this.fbU.setIndex(this.fbU.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fbU);
            b(cellForumTestView);
            this.fbV.setViewLeft(this.fcd[2].right + this.fcc);
            this.fbV.setViewRight(this.fcd[2].right + this.fcc + this.fbW);
            this.fbV.setViewTop(this.fcd[2].top);
            this.fbV.setViewBottom(this.fcd[2].bottom);
            this.fbV.setMoveLeft(this.fcd[2].right + this.fcc);
            this.fbV.setMoveRight(this.fcd[2].right + this.fcc + this.fbW);
            this.fbV.setMoveTop(this.fcd[2].top);
            this.fbV.setMoveBottom(this.fcd[2].bottom);
            this.fbV.setData(this.fbP.get(qK(this.fbV.getDataIndex() + 2)));
        }
        this.fcl.setFloatValues(0.0f, this.fck);
        this.fcl.start();
    }

    private void bhn() {
        this.fbQ.setMoveLeft(this.fbQ.getViewLeft());
        this.fbQ.setMoveTop(this.fbQ.getViewTop());
        this.fbQ.setMoveRight(this.fbQ.getViewRight());
        this.fbQ.setMoveBottom(this.fbQ.getViewBottom());
        this.fbR.setMoveLeft(this.fbR.getViewLeft());
        this.fbR.setMoveTop(this.fbR.getViewTop());
        this.fbR.setMoveRight(this.fbR.getViewRight());
        this.fbR.setMoveBottom(this.fbR.getViewBottom());
        this.fbS.setMoveLeft(this.fbS.getViewLeft());
        this.fbS.setMoveTop(this.fbS.getViewTop());
        this.fbS.setMoveRight(this.fbS.getViewRight());
        this.fbS.setMoveBottom(this.fbS.getViewBottom());
        this.fbT.setMoveLeft(this.fbT.getViewLeft());
        this.fbT.setMoveTop(this.fbT.getViewTop());
        this.fbT.setMoveRight(this.fbT.getViewRight());
        this.fbT.setMoveBottom(this.fbT.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_e);
            this.fbQ.onChangeSkinType();
            this.fbR.onChangeSkinType();
            this.fbS.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.fcm && this.fck == 0.0f) {
            if (this.fcj != null) {
                this.fcj.removeAllUpdateListeners();
                this.fcj.cancel();
            }
            if (this.fcl != null) {
                this.fcl.removeAllUpdateListeners();
                this.fcl.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fbQ != null) {
            this.fbQ.setPageId(bdUniqueId);
        }
        if (this.fbR != null) {
            this.fbR.setPageId(bdUniqueId);
        }
        if (this.fbS != null) {
            this.fbS.setPageId(bdUniqueId);
        }
    }

    public void qL(int i) {
        f fVar;
        an a2;
        if (this.fbP != null && i >= 0 && i < this.fbP.size() && (fVar = this.fbP.get(i)) != null && (a2 = com.baidu.tieba.q.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.q.c.cpt().a(this.mPageId, "enterfourm_rec_" + fVar.testId, a2);
        }
    }
}
