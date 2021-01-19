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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes2.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int XM;
    private List<f> iGY;
    private CellForumTestView iGZ;
    private float iHA;
    private int iHB;
    private CellForumTestView iHa;
    private CellForumTestView iHb;
    private CellForumTestView iHc;
    private CellForumTestView iHd;
    private CellForumTestView iHe;
    private int iHf;
    private int iHg;
    private int iHh;
    private int iHi;
    private int iHj;
    private int iHk;
    private int iHl;
    private Rect[] iHm;
    private float iHn;
    private float iHo;
    private float iHp;
    private float iHq;
    private float iHr;
    private ValueAnimator iHs;
    private ValueAnimator iHt;
    private boolean iHu;
    private boolean iHv;
    private int iHw;
    private int iHx;
    private a iHy;
    private boolean iHz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void cvI();

        void gg(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iHm = new Rect[3];
        this.iHu = false;
        this.iHv = false;
        this.iHz = false;
        this.iHA = 0.0f;
        this.iHB = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iHm = new Rect[3];
        this.iHu = false;
        this.iHv = false;
        this.iHz = false;
        this.iHA = 0.0f;
        this.iHB = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iHm = new Rect[3];
        this.iHu = false;
        this.iHv = false;
        this.iHz = false;
        this.iHA = 0.0f;
        this.iHB = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.iGZ = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.iHa = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.iHb = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.iHc = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        gi(context);
        resetData();
        ViewConfiguration.get(context);
        this.XM = ViewConfiguration.getMaximumFlingVelocity();
        this.iGZ.setForumTestDelClickListener(this);
        this.iHa.setForumTestDelClickListener(this);
        this.iHb.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void gi(Context context) {
        this.iHj = l.getDimens(context, R.dimen.tbds44);
        this.iHk = l.getDimens(context, R.dimen.tbds30);
        this.iHl = l.getDimens(context, R.dimen.tbds7);
        this.iHi = l.getDimens(context, R.dimen.tbds730);
        this.iHh = this.iHi - (this.iHk * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.iHf = (int) (this.mWidth * 0.89f);
        this.mHeight = this.iHi + this.iHj;
        this.iHg = ((this.mWidth - this.iHf) - (this.iHl * 2)) / 2;
        this.iHp = this.iHk / (this.iHf + this.iHl);
        this.iHq = this.iHi / this.iHf;
        this.iHr = this.iHf / (this.iHf + this.iHl);
        this.iHm[0] = new Rect(this.iHg - this.iHf, this.iHj + this.iHk, this.iHg, this.iHj + this.iHk + this.iHh);
        this.iHm[1] = new Rect(this.iHg + this.iHl, this.iHj, this.iHg + this.iHl + this.iHf, this.iHj + this.iHi);
        this.iHm[2] = new Rect(this.mWidth - this.iHg, this.iHj + this.iHk, (this.mWidth - this.iHg) + this.iHf, this.iHj + this.iHk + this.iHh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iHt = ValueAnimator.ofFloat(this.iHf, 0.0f);
        this.iHt.setDuration(500L);
        this.iHt.setInterpolator(new DecelerateInterpolator());
        this.iHt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.iHw != 1) {
                    if (ForumTestView.this.iHw == 2 || ForumTestView.this.iHw == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.iHp * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.iHq;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.iHc.setAlpha(0.0f);
                            ForumTestView.this.iHc.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.iHd);
                            ForumTestView.this.d(ForumTestView.this.iHc);
                            ForumTestView.this.iGY.remove(ForumTestView.this.iHc.getData());
                            ForumTestView.this.pN(true);
                            ForumTestView.this.iHv = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.iHd, floatValue, abs);
                            if ((ForumTestView.this.iHf * 2) / 5 >= ForumTestView.this.iHc.getViewRight() - ForumTestView.this.iHc.getViewLeft()) {
                                ForumTestView.this.iHc.setAlpha(0.0f);
                                ForumTestView.this.iHc.setVisibility(8);
                            } else {
                                ForumTestView.this.iHc.setViewLeft(ForumTestView.this.iHc.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iHc.setViewRight(ForumTestView.this.iHc.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iHc.setViewTop(ForumTestView.this.iHc.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.iHc.setViewBottom(ForumTestView.this.iHc.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.iHc.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.iHf * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.iHp * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.iHq;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.iHc.setAlpha(0.0f);
                        ForumTestView.this.iHc.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.iHd);
                        ForumTestView.this.d(ForumTestView.this.iHc);
                        ForumTestView.this.d(ForumTestView.this.iHe);
                        ForumTestView.this.iGY.remove(ForumTestView.this.iHc.getData());
                        if (ForumTestView.this.iGZ.getIndex() == 0) {
                            if (ForumTestView.this.iGZ.getDataIndex() > ForumTestView.this.iHe.getDataIndex()) {
                                ForumTestView.this.iGZ.setDataIndex(ForumTestView.this.iGZ.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iGZ);
                            }
                        } else if (ForumTestView.this.iHa.getIndex() == 0) {
                            if (ForumTestView.this.iHa.getDataIndex() > ForumTestView.this.iHe.getDataIndex()) {
                                ForumTestView.this.iHa.setDataIndex(ForumTestView.this.iHa.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iHa);
                            }
                        } else if (ForumTestView.this.iHb.getDataIndex() > ForumTestView.this.iHe.getDataIndex()) {
                            ForumTestView.this.iHb.setDataIndex(ForumTestView.this.iHb.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iHb);
                        }
                        if (ForumTestView.this.iHd.getDataIndex() > ForumTestView.this.iHe.getDataIndex()) {
                            ForumTestView.this.iHd.setDataIndex(ForumTestView.this.iHd.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iHd);
                        }
                        ForumTestView.this.iHe.setDataIndex(ForumTestView.this.iHe.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.iHe);
                        ForumTestView.this.pN(true);
                        ForumTestView.this.iHv = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.iHd, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.iHe, floatValue2);
                        if ((ForumTestView.this.iHf * 2) / 5 >= ForumTestView.this.iHc.getViewRight() - ForumTestView.this.iHc.getViewLeft()) {
                            ForumTestView.this.iHc.setAlpha(0.0f);
                            ForumTestView.this.iHc.setVisibility(8);
                        } else {
                            ForumTestView.this.iHc.setViewLeft(ForumTestView.this.iHc.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iHc.setViewRight(ForumTestView.this.iHc.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iHc.setViewTop(ForumTestView.this.iHc.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.iHc.setViewBottom(ForumTestView.this.iHc.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.iHc.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.iHf * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.iHq * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.iHc.setAlpha(0.0f);
                    ForumTestView.this.iHc.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.iGY.remove(ForumTestView.this.iHc.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.iHy != null) {
                        ForumTestView.this.iHy.gg(-1L);
                    }
                    ForumTestView.this.iHv = false;
                    if (ForumTestView.this.iHy != null && x.isEmpty(ForumTestView.this.iGY)) {
                        ForumTestView.this.iHy.cvI();
                    }
                } else {
                    ForumTestView.this.iHc.setViewLeft(ForumTestView.this.iHc.getMoveLeft() + floatValue3);
                    ForumTestView.this.iHc.setViewRight(ForumTestView.this.iHc.getMoveRight() - floatValue3);
                    ForumTestView.this.iHc.setViewTop(ForumTestView.this.iHc.getMoveTop() + f);
                    ForumTestView.this.iHc.setViewBottom(ForumTestView.this.iHc.getMoveBottom() - f);
                    ForumTestView.this.iHc.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.iHB) {
                this.iHB = equipmentWidth;
                gi(getContext());
                d(this.iGZ);
                d(this.iHa);
                d(this.iHb);
                d(this.iHc);
            }
            a(this.iGZ);
            a(this.iHa);
            a(this.iHb);
            a(this.iHc);
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
            this.iGZ.layout((int) this.iGZ.getViewLeft(), (int) this.iGZ.getViewTop(), (int) this.iGZ.getViewRight(), (int) this.iGZ.getViewBottom());
            this.iHa.layout((int) this.iHa.getViewLeft(), (int) this.iHa.getViewTop(), (int) this.iHa.getViewRight(), (int) this.iHa.getViewBottom());
            this.iHb.layout((int) this.iHb.getViewLeft(), (int) this.iHb.getViewTop(), (int) this.iHb.getViewRight(), (int) this.iHb.getViewBottom());
            this.iHc.layout((int) this.iHc.getViewLeft(), (int) this.iHc.getViewTop(), (int) this.iHc.getViewRight(), (int) this.iHc.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.iHt == null || !this.iHt.isRunning()) {
            if (this.iHs == null || !this.iHs.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.iHs != null) {
                        this.iHs.removeAllUpdateListeners();
                        this.iHs.cancel();
                    }
                    this.iHx = motionEvent.getPointerId(0);
                    this.iHn = x;
                    this.iHo = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.iHn - x;
                    float f2 = this.iHo - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.iHu = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.iHu) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.iHp * f3;
                    if (this.iHu) {
                        b(this.iGZ, f3, f4);
                        b(this.iHa, f3, f4);
                        b(this.iHb, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.XM);
                    float xVelocity = velocityTracker.getXVelocity(this.iHx);
                    if (this.iHu || this.mDistance != 0.0f) {
                        aF(xVelocity);
                    }
                    this.iHu = false;
                    releaseVelocityTracker();
                }
                if (this.iHu || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.iGY.size() > 2) {
                if (cellForumTestView.getViewRight() < this.iHm[0].right - (this.iHf / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.iHm[0].right - (this.iHf / 2))) + this.iHm[2].left + (this.iHf / 2) + this.iHl);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.iHf);
                    cellForumTestView.setViewTop(this.iHm[2].top);
                    cellForumTestView.setViewBottom(this.iHm[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iGY.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.iHm[2].left + (this.iHf / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.iHm[2].left + (this.iHf / 2))) + ((this.iHm[0].right - (this.iHf / 2)) - this.iHl));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.iHf);
                    cellForumTestView.setViewTop(this.iHm[0].top);
                    cellForumTestView.setViewBottom(this.iHm[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iGY.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.iHm[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.iHm[0].top) {
                    cellForumTestView.setViewTop(this.iHm[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.iHm[0].bottom) {
                    cellForumTestView.setViewBottom(this.iHm[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.iHm[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.iHm[1].top) {
                    cellForumTestView.setViewTop(this.iHm[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.iHm[1].bottom) {
                    cellForumTestView.setViewBottom(this.iHm[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.iHy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pN(boolean z) {
        if (this.iHy != null) {
            int i = -1;
            if (this.iGZ.getIndex() == 1 && this.iGZ.getData() != null) {
                this.iHy.gg(this.iGZ.getData().testId);
                i = this.iGZ.getDataIndex();
            } else if (this.iHa.getIndex() == 1 && this.iHa.getData() != null) {
                this.iHy.gg(this.iHa.getData().testId);
                i = this.iHa.getDataIndex();
            } else if (this.iHb.getIndex() == 1 && this.iHb.getData() != null) {
                this.iHy.gg(this.iHb.getData().testId);
                i = this.iHb.getDataIndex();
            } else {
                this.iHy.gg(-1L);
            }
            if (z) {
                xE(i);
            }
        }
    }

    private void initAnimation() {
        this.iHs = ValueAnimator.ofFloat(this.iHf, 0.0f);
        this.iHs.setDuration(200L);
        this.iHs.setInterpolator(new DecelerateInterpolator());
        this.iHs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.iHf) * 0.2f;
                    if (ForumTestView.this.iHz) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cvF();
                        } else {
                            ForumTestView.this.cvG();
                        }
                        ForumTestView.this.iHz = false;
                    }
                    ForumTestView.this.iHA = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.iGZ);
                    ForumTestView.this.d(ForumTestView.this.iHa);
                    ForumTestView.this.d(ForumTestView.this.iHb);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.pN(z);
                } else {
                    if (ForumTestView.this.iHz) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.xC(2) != null && ForumTestView.this.xC(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cvF();
                                ForumTestView.this.iHz = false;
                            }
                        } else if (ForumTestView.this.xC(0) != null && ForumTestView.this.xC(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cvG();
                            ForumTestView.this.iHz = false;
                        }
                    }
                    float f = ForumTestView.this.iHA - floatValue;
                    float f2 = ForumTestView.this.iHp * f;
                    ForumTestView.this.b(ForumTestView.this.iGZ, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iHa, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iHb, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.iHA = floatValue;
            }
        });
    }

    private void aF(float f) {
        CellForumTestView xC;
        float viewLeft;
        float viewRight;
        this.iHz = false;
        this.iHA = 0.0f;
        initAnimation();
        if (this.iGY.size() == 2) {
            CellForumTestView cellForumTestView = null;
            CellForumTestView cellForumTestView2 = null;
            if (this.iGZ.getVisibility() == 0) {
                cellForumTestView = this.iGZ;
            }
            if (this.iHa.getVisibility() == 0) {
                if (cellForumTestView == null) {
                    cellForumTestView = this.iHa;
                } else {
                    cellForumTestView2 = this.iHa;
                }
            }
            if (this.iHb.getVisibility() == 0) {
                cellForumTestView2 = this.iHb;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                float viewLeft2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
                viewLeft = viewLeft2;
            } else {
                viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
            }
            if (!(viewLeft < ((float) this.iHm[0].left) || viewRight > ((float) this.iHm[2].right)) && Math.abs(this.mDistance) >= this.iHf * 0.2f) {
                this.iHz = true;
            }
        } else if (this.iGY.size() > 2 && Math.abs(this.mDistance) >= this.iHf * 0.2f) {
            this.iHz = true;
        }
        if (this.iHz && (xC = xC(1)) != null) {
            if (this.mDistance >= this.iHf) {
                this.mDistance -= this.iHf;
                this.iHz = false;
                cvG();
            } else if (this.mDistance > 0.0f && this.mDistance < this.iHf) {
                this.mDistance = this.iHm[0].right - xC.getViewRight();
            } else if (this.mDistance > (-this.iHf)) {
                this.mDistance = this.iHm[2].left - xC.getViewLeft();
            } else {
                cvF();
                this.mDistance += this.iHf;
                this.iHz = false;
            }
        }
        this.iHs.setFloatValues(0.0f, this.mDistance);
        this.iHs.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvF() {
        this.iGZ.setIndex(this.iGZ.getIndex() + 1);
        this.iHa.setIndex(this.iHa.getIndex() + 1);
        this.iHb.setIndex(this.iHb.getIndex() + 1);
        b(this.iGZ);
        b(this.iHa);
        b(this.iHb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvG() {
        this.iGZ.setIndex(this.iGZ.getIndex() - 1);
        this.iHa.setIndex(this.iHa.getIndex() - 1);
        this.iHb.setIndex(this.iHb.getIndex() - 1);
        b(this.iGZ);
        b(this.iHa);
        b(this.iHb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView xC(int i) {
        if (this.iGZ.getIndex() == i) {
            return this.iGZ;
        }
        if (this.iHa.getIndex() == i) {
            return this.iHa;
        }
        if (this.iHb.getIndex() == i) {
            return this.iHb;
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
            int size = this.iGY.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int xD(int i) {
        int size = this.iGY.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.iHm[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.iHm[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.iHm[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.iHm[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!x.isEmpty(list) && !this.iHu && this.mDistance == 0.0f) {
            this.iGY = list;
            resetData();
            if (x.getCount(list) > 2) {
                this.iGZ.setVisibility(0);
                this.iHa.setVisibility(0);
                this.iHb.setVisibility(0);
                this.iGZ.setData(list.get(0));
                this.iHa.setData(list.get(1));
                this.iHb.setData(list.get(2));
                this.iGZ.setDataIndex(0);
                this.iHa.setDataIndex(1);
                this.iHb.setDataIndex(2);
                i = 1;
            } else if (x.getCount(list) == 2) {
                this.iGZ.setVisibility(8);
                this.iHa.setVisibility(0);
                this.iHb.setVisibility(0);
                this.iHa.setDataIndex(1);
                this.iHb.setDataIndex(0);
                this.iHa.setData(list.get(1));
                this.iHb.setData(list.get(0));
                i = 1;
            } else {
                this.iGZ.setVisibility(8);
                this.iHa.setVisibility(0);
                this.iHb.setVisibility(8);
                this.iHa.setDataIndex(0);
                this.iHa.setData(list.get(0));
                i = 0;
            }
            xE(i);
        }
    }

    private void resetData() {
        this.iGZ.setIndex(0);
        this.iHa.setIndex(1);
        this.iHb.setIndex(2);
        this.iHc.setIndex(1);
        d(this.iGZ);
        d(this.iHa);
        d(this.iHb);
        d(this.iHc);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void xB(int i) {
        CellForumTestView cellForumTestView;
        this.iHv = true;
        this.iHc.setVisibility(0);
        this.iHc.setAlpha(1.0f);
        cvH();
        if (this.iGZ.getIndex() == i && this.iGZ.getVisibility() == 0) {
            cellForumTestView = this.iGZ;
        } else if (this.iHa.getIndex() == i && this.iHa.getVisibility() == 0) {
            cellForumTestView = this.iHa;
        } else {
            cellForumTestView = this.iHb;
        }
        this.iHc.setData(cellForumTestView.getData());
        this.iHc.setDataIndex(cellForumTestView.getDataIndex());
        this.iHe = null;
        if (this.iGY.size() == 1) {
            this.iHw = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.iHf * 3) / 5;
        } else if (this.iGY.size() == 2) {
            this.iHw = 2;
            cellForumTestView.setVisibility(8);
            if (this.iGZ.getVisibility() == 0) {
                this.iHd = this.iGZ;
            } else if (this.iHa.getVisibility() == 0) {
                this.iHd = this.iHa;
            } else {
                this.iHd = this.iHb;
            }
            if (this.iHd.getViewRight() < this.iHm[1].left) {
                this.mDistance = this.iHf + this.iHl;
                this.iHd.setIndex(this.iHd.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.iHd.getViewLeft() > this.iHm[1].right) {
                this.mDistance = (-this.iHf) - this.iHl;
                this.iHd.setIndex(this.iHd.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.iHd);
            b(cellForumTestView);
        } else if (this.iGY.size() == 3) {
            this.iHw = 3;
            cellForumTestView.setVisibility(8);
            if (this.iGZ.getIndex() == 2) {
                this.iHd = this.iGZ;
            } else if (this.iHa.getIndex() == 2) {
                this.iHd = this.iHa;
            } else {
                this.iHd = this.iHb;
            }
            this.mDistance = (-this.iHf) - this.iHl;
            this.iHd.setIndex(this.iHd.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.iHd);
            b(cellForumTestView);
        } else {
            this.iHw = 4;
            this.iHe = cellForumTestView;
            if (this.iGZ.getIndex() == 2) {
                this.iHd = this.iGZ;
            } else if (this.iHa.getIndex() == 2) {
                this.iHd = this.iHa;
            } else {
                this.iHd = this.iHb;
            }
            this.mDistance = (-this.iHf) - this.iHl;
            this.iHd.setIndex(this.iHd.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.iHd);
            b(cellForumTestView);
            this.iHe.setViewLeft(this.iHm[2].right + this.iHl);
            this.iHe.setViewRight(this.iHm[2].right + this.iHl + this.iHf);
            this.iHe.setViewTop(this.iHm[2].top);
            this.iHe.setViewBottom(this.iHm[2].bottom);
            this.iHe.setMoveLeft(this.iHm[2].right + this.iHl);
            this.iHe.setMoveRight(this.iHm[2].right + this.iHl + this.iHf);
            this.iHe.setMoveTop(this.iHm[2].top);
            this.iHe.setMoveBottom(this.iHm[2].bottom);
            this.iHe.setData(this.iGY.get(xD(this.iHe.getDataIndex() + 2)));
        }
        this.iHt.setFloatValues(0.0f, this.mDistance);
        this.iHt.start();
    }

    private void cvH() {
        this.iGZ.setMoveLeft(this.iGZ.getViewLeft());
        this.iGZ.setMoveTop(this.iGZ.getViewTop());
        this.iGZ.setMoveRight(this.iGZ.getViewRight());
        this.iGZ.setMoveBottom(this.iGZ.getViewBottom());
        this.iHa.setMoveLeft(this.iHa.getViewLeft());
        this.iHa.setMoveTop(this.iHa.getViewTop());
        this.iHa.setMoveRight(this.iHa.getViewRight());
        this.iHa.setMoveBottom(this.iHa.getViewBottom());
        this.iHb.setMoveLeft(this.iHb.getViewLeft());
        this.iHb.setMoveTop(this.iHb.getViewTop());
        this.iHb.setMoveRight(this.iHb.getViewRight());
        this.iHb.setMoveBottom(this.iHb.getViewBottom());
        this.iHc.setMoveLeft(this.iHc.getViewLeft());
        this.iHc.setMoveTop(this.iHc.getViewTop());
        this.iHc.setMoveRight(this.iHc.getViewRight());
        this.iHc.setMoveBottom(this.iHc.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.CAM_X0205);
            this.iGZ.onChangeSkinType();
            this.iHa.onChangeSkinType();
            this.iHb.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.iHu && this.mDistance == 0.0f) {
            if (this.iHs != null) {
                this.iHs.removeAllUpdateListeners();
                this.iHs.cancel();
            }
            if (this.iHt != null) {
                this.iHt.removeAllUpdateListeners();
                this.iHt.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.iGZ != null) {
            this.iGZ.setPageId(bdUniqueId);
        }
        if (this.iHa != null) {
            this.iHa.setPageId(bdUniqueId);
        }
        if (this.iHb != null) {
            this.iHb.setPageId(bdUniqueId);
        }
    }

    public void xE(int i) {
        f fVar;
        aq a2;
        if (this.iGY != null && i >= 0 && i < this.iGY.size() && (fVar = this.iGY.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dKg().a(this.mPageId, com.baidu.tieba.s.a.RU("" + fVar.testId), a2);
        }
    }
}
