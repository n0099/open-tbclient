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
    private int UN;
    private List<f> gEZ;
    private boolean gFA;
    private float gFB;
    private int gFC;
    private CellForumTestView gFa;
    private CellForumTestView gFb;
    private CellForumTestView gFc;
    private CellForumTestView gFd;
    private CellForumTestView gFe;
    private CellForumTestView gFf;
    private int gFg;
    private int gFh;
    private int gFi;
    private int gFj;
    private int gFk;
    private int gFl;
    private int gFm;
    private Rect[] gFn;
    private float gFo;
    private float gFp;
    private float gFq;
    private float gFr;
    private float gFs;
    private ValueAnimator gFt;
    private ValueAnimator gFu;
    private boolean gFv;
    private boolean gFw;
    private int gFx;
    private int gFy;
    private a gFz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void bJp();

        void dZ(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gFn = new Rect[3];
        this.gFv = false;
        this.gFw = false;
        this.gFA = false;
        this.gFB = 0.0f;
        this.gFC = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gFn = new Rect[3];
        this.gFv = false;
        this.gFw = false;
        this.gFA = false;
        this.gFB = 0.0f;
        this.gFC = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gFn = new Rect[3];
        this.gFv = false;
        this.gFw = false;
        this.gFA = false;
        this.gFB = 0.0f;
        this.gFC = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.gFa = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.gFb = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.gFc = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.gFd = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eF(context);
        resetData();
        ViewConfiguration.get(context);
        this.UN = ViewConfiguration.getMaximumFlingVelocity();
        this.gFa.setForumTestDelClickListener(this);
        this.gFb.setForumTestDelClickListener(this);
        this.gFc.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eF(Context context) {
        this.gFk = l.getDimens(context, R.dimen.tbds44);
        this.gFl = l.getDimens(context, R.dimen.tbds30);
        this.gFm = l.getDimens(context, R.dimen.tbds7);
        this.gFj = l.getDimens(context, R.dimen.tbds730);
        this.gFi = this.gFj - (this.gFl * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.gFg = (int) (this.mWidth * 0.89f);
        this.mHeight = this.gFj + this.gFk;
        this.gFh = ((this.mWidth - this.gFg) - (this.gFm * 2)) / 2;
        this.gFq = this.gFl / (this.gFg + this.gFm);
        this.gFr = this.gFj / this.gFg;
        this.gFs = this.gFg / (this.gFg + this.gFm);
        this.gFn[0] = new Rect(this.gFh - this.gFg, this.gFk + this.gFl, this.gFh, this.gFk + this.gFl + this.gFi);
        this.gFn[1] = new Rect(this.gFh + this.gFm, this.gFk, this.gFh + this.gFm + this.gFg, this.gFk + this.gFj);
        this.gFn[2] = new Rect(this.mWidth - this.gFh, this.gFk + this.gFl, (this.mWidth - this.gFh) + this.gFg, this.gFk + this.gFl + this.gFi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gFu = ValueAnimator.ofFloat(this.gFg, 0.0f);
        this.gFu.setDuration(500L);
        this.gFu.setInterpolator(new DecelerateInterpolator());
        this.gFu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.gFx != 1) {
                    if (ForumTestView.this.gFx == 2 || ForumTestView.this.gFx == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.gFq * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.gFr;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.gFd.setAlpha(0.0f);
                            ForumTestView.this.gFd.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.gFe);
                            ForumTestView.this.d(ForumTestView.this.gFd);
                            ForumTestView.this.gEZ.remove(ForumTestView.this.gFd.getData());
                            ForumTestView.this.lS(true);
                            ForumTestView.this.gFw = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.gFe, floatValue, abs);
                            if ((ForumTestView.this.gFg * 2) / 5 >= ForumTestView.this.gFd.getViewRight() - ForumTestView.this.gFd.getViewLeft()) {
                                ForumTestView.this.gFd.setAlpha(0.0f);
                                ForumTestView.this.gFd.setVisibility(8);
                            } else {
                                ForumTestView.this.gFd.setViewLeft(ForumTestView.this.gFd.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.gFd.setViewRight(ForumTestView.this.gFd.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.gFd.setViewTop(ForumTestView.this.gFd.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.gFd.setViewBottom(ForumTestView.this.gFd.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.gFd.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.gFg * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.gFq * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.gFr;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.gFd.setAlpha(0.0f);
                        ForumTestView.this.gFd.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.gFe);
                        ForumTestView.this.d(ForumTestView.this.gFd);
                        ForumTestView.this.d(ForumTestView.this.gFf);
                        ForumTestView.this.gEZ.remove(ForumTestView.this.gFd.getData());
                        if (ForumTestView.this.gFa.getIndex() == 0) {
                            if (ForumTestView.this.gFa.getDataIndex() > ForumTestView.this.gFf.getDataIndex()) {
                                ForumTestView.this.gFa.setDataIndex(ForumTestView.this.gFa.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.gFa);
                            }
                        } else if (ForumTestView.this.gFb.getIndex() == 0) {
                            if (ForumTestView.this.gFb.getDataIndex() > ForumTestView.this.gFf.getDataIndex()) {
                                ForumTestView.this.gFb.setDataIndex(ForumTestView.this.gFb.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.gFb);
                            }
                        } else if (ForumTestView.this.gFc.getDataIndex() > ForumTestView.this.gFf.getDataIndex()) {
                            ForumTestView.this.gFc.setDataIndex(ForumTestView.this.gFc.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.gFc);
                        }
                        if (ForumTestView.this.gFe.getDataIndex() > ForumTestView.this.gFf.getDataIndex()) {
                            ForumTestView.this.gFe.setDataIndex(ForumTestView.this.gFe.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.gFe);
                        }
                        ForumTestView.this.gFf.setDataIndex(ForumTestView.this.gFf.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.gFf);
                        ForumTestView.this.lS(true);
                        ForumTestView.this.gFw = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.gFe, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.gFf, floatValue2);
                        if ((ForumTestView.this.gFg * 2) / 5 >= ForumTestView.this.gFd.getViewRight() - ForumTestView.this.gFd.getViewLeft()) {
                            ForumTestView.this.gFd.setAlpha(0.0f);
                            ForumTestView.this.gFd.setVisibility(8);
                        } else {
                            ForumTestView.this.gFd.setViewLeft(ForumTestView.this.gFd.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.gFd.setViewRight(ForumTestView.this.gFd.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.gFd.setViewTop(ForumTestView.this.gFd.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.gFd.setViewBottom(ForumTestView.this.gFd.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.gFd.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.gFg * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.gFr * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.gFd.setAlpha(0.0f);
                    ForumTestView.this.gFd.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.gEZ.remove(ForumTestView.this.gFd.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.gFz != null) {
                        ForumTestView.this.gFz.dZ(-1L);
                    }
                    ForumTestView.this.gFw = false;
                    if (ForumTestView.this.gFz != null && v.isEmpty(ForumTestView.this.gEZ)) {
                        ForumTestView.this.gFz.bJp();
                    }
                } else {
                    ForumTestView.this.gFd.setViewLeft(ForumTestView.this.gFd.getMoveLeft() + floatValue3);
                    ForumTestView.this.gFd.setViewRight(ForumTestView.this.gFd.getMoveRight() - floatValue3);
                    ForumTestView.this.gFd.setViewTop(ForumTestView.this.gFd.getMoveTop() + f);
                    ForumTestView.this.gFd.setViewBottom(ForumTestView.this.gFd.getMoveBottom() - f);
                    ForumTestView.this.gFd.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.gFC) {
                this.gFC = equipmentWidth;
                eF(getContext());
                d(this.gFa);
                d(this.gFb);
                d(this.gFc);
                d(this.gFd);
            }
            a(this.gFa);
            a(this.gFb);
            a(this.gFc);
            a(this.gFd);
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
            this.gFa.layout((int) this.gFa.getViewLeft(), (int) this.gFa.getViewTop(), (int) this.gFa.getViewRight(), (int) this.gFa.getViewBottom());
            this.gFb.layout((int) this.gFb.getViewLeft(), (int) this.gFb.getViewTop(), (int) this.gFb.getViewRight(), (int) this.gFb.getViewBottom());
            this.gFc.layout((int) this.gFc.getViewLeft(), (int) this.gFc.getViewTop(), (int) this.gFc.getViewRight(), (int) this.gFc.getViewBottom());
            this.gFd.layout((int) this.gFd.getViewLeft(), (int) this.gFd.getViewTop(), (int) this.gFd.getViewRight(), (int) this.gFd.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.gFu == null || !this.gFu.isRunning()) {
            if (this.gFt == null || !this.gFt.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.gFt != null) {
                        this.gFt.removeAllUpdateListeners();
                        this.gFt.cancel();
                    }
                    this.gFy = motionEvent.getPointerId(0);
                    this.gFo = x;
                    this.gFp = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.gFo - x;
                    float f2 = this.gFp - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.gFv = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.gFv) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.gFq * f3;
                    if (this.gFv) {
                        b(this.gFa, f3, f4);
                        b(this.gFb, f3, f4);
                        b(this.gFc, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.UN);
                    float xVelocity = velocityTracker.getXVelocity(this.gFy);
                    if (this.gFv || this.mDistance != 0.0f) {
                        ag(xVelocity);
                    }
                    this.gFv = false;
                    releaseVelocityTracker();
                }
                if (this.gFv || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.gEZ.size() > 2) {
                if (cellForumTestView.getViewRight() < this.gFn[0].right - (this.gFg / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.gFn[0].right - (this.gFg / 2))) + this.gFn[2].left + (this.gFg / 2) + this.gFm);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.gFg);
                    cellForumTestView.setViewTop(this.gFn[2].top);
                    cellForumTestView.setViewBottom(this.gFn[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.gEZ.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.gFn[2].left + (this.gFg / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.gFn[2].left + (this.gFg / 2))) + ((this.gFn[0].right - (this.gFg / 2)) - this.gFm));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.gFg);
                    cellForumTestView.setViewTop(this.gFn[0].top);
                    cellForumTestView.setViewBottom(this.gFn[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.gEZ.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.gFn[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.gFn[0].top) {
                    cellForumTestView.setViewTop(this.gFn[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.gFn[0].bottom) {
                    cellForumTestView.setViewBottom(this.gFn[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.gFn[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.gFn[1].top) {
                    cellForumTestView.setViewTop(this.gFn[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.gFn[1].bottom) {
                    cellForumTestView.setViewBottom(this.gFn[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.gFz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (this.gFz != null) {
            int i = -1;
            if (this.gFa.getIndex() == 1 && this.gFa.getData() != null) {
                this.gFz.dZ(this.gFa.getData().testId);
                i = this.gFa.getDataIndex();
            } else if (this.gFb.getIndex() == 1 && this.gFb.getData() != null) {
                this.gFz.dZ(this.gFb.getData().testId);
                i = this.gFb.getDataIndex();
            } else if (this.gFc.getIndex() == 1 && this.gFc.getData() != null) {
                this.gFz.dZ(this.gFc.getData().testId);
                i = this.gFc.getDataIndex();
            } else {
                this.gFz.dZ(-1L);
            }
            if (z) {
                su(i);
            }
        }
    }

    private void initAnimation() {
        this.gFt = ValueAnimator.ofFloat(this.gFg, 0.0f);
        this.gFt.setDuration(200L);
        this.gFt.setInterpolator(new DecelerateInterpolator());
        this.gFt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.gFg) * 0.2f;
                    if (ForumTestView.this.gFA) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bJm();
                        } else {
                            ForumTestView.this.bJn();
                        }
                        ForumTestView.this.gFA = false;
                    }
                    ForumTestView.this.gFB = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.gFa);
                    ForumTestView.this.d(ForumTestView.this.gFb);
                    ForumTestView.this.d(ForumTestView.this.gFc);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.lS(z);
                } else {
                    if (ForumTestView.this.gFA) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.ss(2) != null && ForumTestView.this.ss(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bJm();
                                ForumTestView.this.gFA = false;
                            }
                        } else if (ForumTestView.this.ss(0) != null && ForumTestView.this.ss(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bJn();
                            ForumTestView.this.gFA = false;
                        }
                    }
                    float f = ForumTestView.this.gFB - floatValue;
                    float f2 = ForumTestView.this.gFq * f;
                    ForumTestView.this.b(ForumTestView.this.gFa, f, f2);
                    ForumTestView.this.b(ForumTestView.this.gFb, f, f2);
                    ForumTestView.this.b(ForumTestView.this.gFc, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.gFB = floatValue;
            }
        });
    }

    private void ag(float f) {
        CellForumTestView ss;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.gFA = false;
        this.gFB = 0.0f;
        initAnimation();
        if (this.gEZ.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.gFa.getVisibility() == 0) {
                cellForumTestView3 = this.gFa;
            }
            if (this.gFb.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.gFb;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.gFb;
            }
            if (this.gFc.getVisibility() == 0) {
                cellForumTestView2 = this.gFc;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.gFn[0].left) || viewRight > ((float) this.gFn[2].right)) && Math.abs(this.mDistance) >= this.gFg * 0.2f) {
                this.gFA = true;
            }
        } else if (this.gEZ.size() > 2 && Math.abs(this.mDistance) >= this.gFg * 0.2f) {
            this.gFA = true;
        }
        if (this.gFA && (ss = ss(1)) != null) {
            if (this.mDistance >= this.gFg) {
                this.mDistance -= this.gFg;
                this.gFA = false;
                bJn();
            } else if (this.mDistance > 0.0f && this.mDistance < this.gFg) {
                this.mDistance = this.gFn[0].right - ss.getViewRight();
            } else if (this.mDistance > (-this.gFg)) {
                this.mDistance = this.gFn[2].left - ss.getViewLeft();
            } else {
                bJm();
                this.mDistance += this.gFg;
                this.gFA = false;
            }
        }
        this.gFt.setFloatValues(0.0f, this.mDistance);
        this.gFt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJm() {
        this.gFa.setIndex(this.gFa.getIndex() + 1);
        this.gFb.setIndex(this.gFb.getIndex() + 1);
        this.gFc.setIndex(this.gFc.getIndex() + 1);
        b(this.gFa);
        b(this.gFb);
        b(this.gFc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJn() {
        this.gFa.setIndex(this.gFa.getIndex() - 1);
        this.gFb.setIndex(this.gFb.getIndex() - 1);
        this.gFc.setIndex(this.gFc.getIndex() - 1);
        b(this.gFa);
        b(this.gFb);
        b(this.gFc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView ss(int i) {
        if (this.gFa.getIndex() == i) {
            return this.gFa;
        }
        if (this.gFb.getIndex() == i) {
            return this.gFb;
        }
        if (this.gFc.getIndex() == i) {
            return this.gFc;
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
            int size = this.gEZ.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int st(int i) {
        int size = this.gEZ.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.gFn[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.gFn[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.gFn[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.gFn[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.gFv && this.mDistance == 0.0f) {
            this.gEZ = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.gFa.setVisibility(0);
                this.gFb.setVisibility(0);
                this.gFc.setVisibility(0);
                this.gFa.setData(list.get(0));
                this.gFb.setData(list.get(1));
                this.gFc.setData(list.get(2));
                this.gFa.setDataIndex(0);
                this.gFb.setDataIndex(1);
                this.gFc.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.gFa.setVisibility(8);
                this.gFb.setVisibility(0);
                this.gFc.setVisibility(0);
                this.gFb.setDataIndex(1);
                this.gFc.setDataIndex(0);
                this.gFb.setData(list.get(1));
                this.gFc.setData(list.get(0));
                i = 1;
            } else {
                this.gFa.setVisibility(8);
                this.gFb.setVisibility(0);
                this.gFc.setVisibility(8);
                this.gFb.setDataIndex(0);
                this.gFb.setData(list.get(0));
                i = 0;
            }
            su(i);
        }
    }

    private void resetData() {
        this.gFa.setIndex(0);
        this.gFb.setIndex(1);
        this.gFc.setIndex(2);
        this.gFd.setIndex(1);
        d(this.gFa);
        d(this.gFb);
        d(this.gFc);
        d(this.gFd);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void sr(int i) {
        CellForumTestView cellForumTestView;
        this.gFw = true;
        this.gFd.setVisibility(0);
        this.gFd.setAlpha(1.0f);
        bJo();
        if (this.gFa.getIndex() == i && this.gFa.getVisibility() == 0) {
            cellForumTestView = this.gFa;
        } else if (this.gFb.getIndex() == i && this.gFb.getVisibility() == 0) {
            cellForumTestView = this.gFb;
        } else {
            cellForumTestView = this.gFc;
        }
        this.gFd.setData(cellForumTestView.getData());
        this.gFd.setDataIndex(cellForumTestView.getDataIndex());
        this.gFf = null;
        if (this.gEZ.size() == 1) {
            this.gFx = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.gFg * 3) / 5;
        } else if (this.gEZ.size() == 2) {
            this.gFx = 2;
            cellForumTestView.setVisibility(8);
            if (this.gFa.getVisibility() == 0) {
                this.gFe = this.gFa;
            } else if (this.gFb.getVisibility() == 0) {
                this.gFe = this.gFb;
            } else {
                this.gFe = this.gFc;
            }
            if (this.gFe.getViewRight() < this.gFn[1].left) {
                this.mDistance = this.gFg + this.gFm;
                this.gFe.setIndex(this.gFe.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.gFe.getViewLeft() > this.gFn[1].right) {
                this.mDistance = (-this.gFg) - this.gFm;
                this.gFe.setIndex(this.gFe.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.gFe);
            b(cellForumTestView);
        } else if (this.gEZ.size() == 3) {
            this.gFx = 3;
            cellForumTestView.setVisibility(8);
            if (this.gFa.getIndex() == 2) {
                this.gFe = this.gFa;
            } else if (this.gFb.getIndex() == 2) {
                this.gFe = this.gFb;
            } else {
                this.gFe = this.gFc;
            }
            this.mDistance = (-this.gFg) - this.gFm;
            this.gFe.setIndex(this.gFe.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.gFe);
            b(cellForumTestView);
        } else {
            this.gFx = 4;
            this.gFf = cellForumTestView;
            if (this.gFa.getIndex() == 2) {
                this.gFe = this.gFa;
            } else if (this.gFb.getIndex() == 2) {
                this.gFe = this.gFb;
            } else {
                this.gFe = this.gFc;
            }
            this.mDistance = (-this.gFg) - this.gFm;
            this.gFe.setIndex(this.gFe.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.gFe);
            b(cellForumTestView);
            this.gFf.setViewLeft(this.gFn[2].right + this.gFm);
            this.gFf.setViewRight(this.gFn[2].right + this.gFm + this.gFg);
            this.gFf.setViewTop(this.gFn[2].top);
            this.gFf.setViewBottom(this.gFn[2].bottom);
            this.gFf.setMoveLeft(this.gFn[2].right + this.gFm);
            this.gFf.setMoveRight(this.gFn[2].right + this.gFm + this.gFg);
            this.gFf.setMoveTop(this.gFn[2].top);
            this.gFf.setMoveBottom(this.gFn[2].bottom);
            this.gFf.setData(this.gEZ.get(st(this.gFf.getDataIndex() + 2)));
        }
        this.gFu.setFloatValues(0.0f, this.mDistance);
        this.gFu.start();
    }

    private void bJo() {
        this.gFa.setMoveLeft(this.gFa.getViewLeft());
        this.gFa.setMoveTop(this.gFa.getViewTop());
        this.gFa.setMoveRight(this.gFa.getViewRight());
        this.gFa.setMoveBottom(this.gFa.getViewBottom());
        this.gFb.setMoveLeft(this.gFb.getViewLeft());
        this.gFb.setMoveTop(this.gFb.getViewTop());
        this.gFb.setMoveRight(this.gFb.getViewRight());
        this.gFb.setMoveBottom(this.gFb.getViewBottom());
        this.gFc.setMoveLeft(this.gFc.getViewLeft());
        this.gFc.setMoveTop(this.gFc.getViewTop());
        this.gFc.setMoveRight(this.gFc.getViewRight());
        this.gFc.setMoveBottom(this.gFc.getViewBottom());
        this.gFd.setMoveLeft(this.gFd.getViewLeft());
        this.gFd.setMoveTop(this.gFd.getViewTop());
        this.gFd.setMoveRight(this.gFd.getViewRight());
        this.gFd.setMoveBottom(this.gFd.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.gFa.onChangeSkinType();
            this.gFb.onChangeSkinType();
            this.gFc.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.gFv && this.mDistance == 0.0f) {
            if (this.gFt != null) {
                this.gFt.removeAllUpdateListeners();
                this.gFt.cancel();
            }
            if (this.gFu != null) {
                this.gFu.removeAllUpdateListeners();
                this.gFu.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.gFa != null) {
            this.gFa.setPageId(bdUniqueId);
        }
        if (this.gFb != null) {
            this.gFb.setPageId(bdUniqueId);
        }
        if (this.gFc != null) {
            this.gFc.setPageId(bdUniqueId);
        }
    }

    public void su(int i) {
        f fVar;
        an a2;
        if (this.gEZ != null && i >= 0 && i < this.gEZ.size() && (fVar = this.gEZ.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.cVr().a(this.mPageId, com.baidu.tieba.s.a.Kz("" + fVar.testId), a2);
        }
    }
}
