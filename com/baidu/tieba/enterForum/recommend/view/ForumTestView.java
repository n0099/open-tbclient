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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes22.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int WP;
    private List<f> ihL;
    private CellForumTestView ihM;
    private CellForumTestView ihN;
    private CellForumTestView ihO;
    private CellForumTestView ihP;
    private CellForumTestView ihQ;
    private CellForumTestView ihR;
    private int ihS;
    private int ihT;
    private int ihU;
    private int ihV;
    private int ihW;
    private int ihX;
    private int ihY;
    private Rect[] ihZ;
    private float iia;
    private float iib;
    private float iic;
    private float iid;
    private float iie;
    private ValueAnimator iif;
    private ValueAnimator iig;
    private boolean iih;
    private boolean iii;
    private int iij;
    private int iik;
    private a iil;
    private boolean iim;
    private float iin;
    private int iio;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void cqm();

        void fd(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ihZ = new Rect[3];
        this.iih = false;
        this.iii = false;
        this.iim = false;
        this.iin = 0.0f;
        this.iio = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ihZ = new Rect[3];
        this.iih = false;
        this.iii = false;
        this.iim = false;
        this.iin = 0.0f;
        this.iio = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ihZ = new Rect[3];
        this.iih = false;
        this.iii = false;
        this.iim = false;
        this.iin = 0.0f;
        this.iio = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.ihM = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.ihN = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.ihO = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.ihP = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        fl(context);
        resetData();
        ViewConfiguration.get(context);
        this.WP = ViewConfiguration.getMaximumFlingVelocity();
        this.ihM.setForumTestDelClickListener(this);
        this.ihN.setForumTestDelClickListener(this);
        this.ihO.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void fl(Context context) {
        this.ihW = l.getDimens(context, R.dimen.tbds44);
        this.ihX = l.getDimens(context, R.dimen.tbds30);
        this.ihY = l.getDimens(context, R.dimen.tbds7);
        this.ihV = l.getDimens(context, R.dimen.tbds730);
        this.ihU = this.ihV - (this.ihX * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.ihS = (int) (this.mWidth * 0.89f);
        this.mHeight = this.ihV + this.ihW;
        this.ihT = ((this.mWidth - this.ihS) - (this.ihY * 2)) / 2;
        this.iic = this.ihX / (this.ihS + this.ihY);
        this.iid = this.ihV / this.ihS;
        this.iie = this.ihS / (this.ihS + this.ihY);
        this.ihZ[0] = new Rect(this.ihT - this.ihS, this.ihW + this.ihX, this.ihT, this.ihW + this.ihX + this.ihU);
        this.ihZ[1] = new Rect(this.ihT + this.ihY, this.ihW, this.ihT + this.ihY + this.ihS, this.ihW + this.ihV);
        this.ihZ[2] = new Rect(this.mWidth - this.ihT, this.ihW + this.ihX, (this.mWidth - this.ihT) + this.ihS, this.ihW + this.ihX + this.ihU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iig = ValueAnimator.ofFloat(this.ihS, 0.0f);
        this.iig.setDuration(500L);
        this.iig.setInterpolator(new DecelerateInterpolator());
        this.iig.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.iij != 1) {
                    if (ForumTestView.this.iij == 2 || ForumTestView.this.iij == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.iic * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.iid;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.ihP.setAlpha(0.0f);
                            ForumTestView.this.ihP.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.ihQ);
                            ForumTestView.this.d(ForumTestView.this.ihP);
                            ForumTestView.this.ihL.remove(ForumTestView.this.ihP.getData());
                            ForumTestView.this.oM(true);
                            ForumTestView.this.iii = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.ihQ, floatValue, abs);
                            if ((ForumTestView.this.ihS * 2) / 5 >= ForumTestView.this.ihP.getViewRight() - ForumTestView.this.ihP.getViewLeft()) {
                                ForumTestView.this.ihP.setAlpha(0.0f);
                                ForumTestView.this.ihP.setVisibility(8);
                            } else {
                                ForumTestView.this.ihP.setViewLeft(ForumTestView.this.ihP.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.ihP.setViewRight(ForumTestView.this.ihP.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.ihP.setViewTop(ForumTestView.this.ihP.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.ihP.setViewBottom(ForumTestView.this.ihP.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.ihP.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.ihS * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.iic * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.iid;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.ihP.setAlpha(0.0f);
                        ForumTestView.this.ihP.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.ihQ);
                        ForumTestView.this.d(ForumTestView.this.ihP);
                        ForumTestView.this.d(ForumTestView.this.ihR);
                        ForumTestView.this.ihL.remove(ForumTestView.this.ihP.getData());
                        if (ForumTestView.this.ihM.getIndex() == 0) {
                            if (ForumTestView.this.ihM.getDataIndex() > ForumTestView.this.ihR.getDataIndex()) {
                                ForumTestView.this.ihM.setDataIndex(ForumTestView.this.ihM.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.ihM);
                            }
                        } else if (ForumTestView.this.ihN.getIndex() == 0) {
                            if (ForumTestView.this.ihN.getDataIndex() > ForumTestView.this.ihR.getDataIndex()) {
                                ForumTestView.this.ihN.setDataIndex(ForumTestView.this.ihN.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.ihN);
                            }
                        } else if (ForumTestView.this.ihO.getDataIndex() > ForumTestView.this.ihR.getDataIndex()) {
                            ForumTestView.this.ihO.setDataIndex(ForumTestView.this.ihO.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.ihO);
                        }
                        if (ForumTestView.this.ihQ.getDataIndex() > ForumTestView.this.ihR.getDataIndex()) {
                            ForumTestView.this.ihQ.setDataIndex(ForumTestView.this.ihQ.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.ihQ);
                        }
                        ForumTestView.this.ihR.setDataIndex(ForumTestView.this.ihR.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.ihR);
                        ForumTestView.this.oM(true);
                        ForumTestView.this.iii = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.ihQ, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.ihR, floatValue2);
                        if ((ForumTestView.this.ihS * 2) / 5 >= ForumTestView.this.ihP.getViewRight() - ForumTestView.this.ihP.getViewLeft()) {
                            ForumTestView.this.ihP.setAlpha(0.0f);
                            ForumTestView.this.ihP.setVisibility(8);
                        } else {
                            ForumTestView.this.ihP.setViewLeft(ForumTestView.this.ihP.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.ihP.setViewRight(ForumTestView.this.ihP.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.ihP.setViewTop(ForumTestView.this.ihP.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.ihP.setViewBottom(ForumTestView.this.ihP.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.ihP.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.ihS * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.iid * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.ihP.setAlpha(0.0f);
                    ForumTestView.this.ihP.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.ihL.remove(ForumTestView.this.ihP.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.iil != null) {
                        ForumTestView.this.iil.fd(-1L);
                    }
                    ForumTestView.this.iii = false;
                    if (ForumTestView.this.iil != null && y.isEmpty(ForumTestView.this.ihL)) {
                        ForumTestView.this.iil.cqm();
                    }
                } else {
                    ForumTestView.this.ihP.setViewLeft(ForumTestView.this.ihP.getMoveLeft() + floatValue3);
                    ForumTestView.this.ihP.setViewRight(ForumTestView.this.ihP.getMoveRight() - floatValue3);
                    ForumTestView.this.ihP.setViewTop(ForumTestView.this.ihP.getMoveTop() + f);
                    ForumTestView.this.ihP.setViewBottom(ForumTestView.this.ihP.getMoveBottom() - f);
                    ForumTestView.this.ihP.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.iio) {
                this.iio = equipmentWidth;
                fl(getContext());
                d(this.ihM);
                d(this.ihN);
                d(this.ihO);
                d(this.ihP);
            }
            a(this.ihM);
            a(this.ihN);
            a(this.ihO);
            a(this.ihP);
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
            this.ihM.layout((int) this.ihM.getViewLeft(), (int) this.ihM.getViewTop(), (int) this.ihM.getViewRight(), (int) this.ihM.getViewBottom());
            this.ihN.layout((int) this.ihN.getViewLeft(), (int) this.ihN.getViewTop(), (int) this.ihN.getViewRight(), (int) this.ihN.getViewBottom());
            this.ihO.layout((int) this.ihO.getViewLeft(), (int) this.ihO.getViewTop(), (int) this.ihO.getViewRight(), (int) this.ihO.getViewBottom());
            this.ihP.layout((int) this.ihP.getViewLeft(), (int) this.ihP.getViewTop(), (int) this.ihP.getViewRight(), (int) this.ihP.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.iig == null || !this.iig.isRunning()) {
            if (this.iif == null || !this.iif.isRunning()) {
                int action = motionEvent.getAction();
                Y(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.iif != null) {
                        this.iif.removeAllUpdateListeners();
                        this.iif.cancel();
                    }
                    this.iik = motionEvent.getPointerId(0);
                    this.iia = x;
                    this.iib = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.iia - x;
                    float f2 = this.iib - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.iih = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.iih) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.iic * f3;
                    if (this.iih) {
                        b(this.ihM, f3, f4);
                        b(this.ihN, f3, f4);
                        b(this.ihO, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.WP);
                    float xVelocity = velocityTracker.getXVelocity(this.iik);
                    if (this.iih || this.mDistance != 0.0f) {
                        au(xVelocity);
                    }
                    this.iih = false;
                    releaseVelocityTracker();
                }
                if (this.iih || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return true;
    }

    private void Y(MotionEvent motionEvent) {
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
            if (this.ihL.size() > 2) {
                if (cellForumTestView.getViewRight() < this.ihZ[0].right - (this.ihS / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.ihZ[0].right - (this.ihS / 2))) + this.ihZ[2].left + (this.ihS / 2) + this.ihY);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.ihS);
                    cellForumTestView.setViewTop(this.ihZ[2].top);
                    cellForumTestView.setViewBottom(this.ihZ[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.ihL.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.ihZ[2].left + (this.ihS / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.ihZ[2].left + (this.ihS / 2))) + ((this.ihZ[0].right - (this.ihS / 2)) - this.ihY));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.ihS);
                    cellForumTestView.setViewTop(this.ihZ[0].top);
                    cellForumTestView.setViewBottom(this.ihZ[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.ihL.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.ihZ[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.ihZ[0].top) {
                    cellForumTestView.setViewTop(this.ihZ[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.ihZ[0].bottom) {
                    cellForumTestView.setViewBottom(this.ihZ[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.ihZ[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.ihZ[1].top) {
                    cellForumTestView.setViewTop(this.ihZ[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.ihZ[1].bottom) {
                    cellForumTestView.setViewBottom(this.ihZ[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.iil = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oM(boolean z) {
        if (this.iil != null) {
            int i = -1;
            if (this.ihM.getIndex() == 1 && this.ihM.getData() != null) {
                this.iil.fd(this.ihM.getData().testId);
                i = this.ihM.getDataIndex();
            } else if (this.ihN.getIndex() == 1 && this.ihN.getData() != null) {
                this.iil.fd(this.ihN.getData().testId);
                i = this.ihN.getDataIndex();
            } else if (this.ihO.getIndex() == 1 && this.ihO.getData() != null) {
                this.iil.fd(this.ihO.getData().testId);
                i = this.ihO.getDataIndex();
            } else {
                this.iil.fd(-1L);
            }
            if (z) {
                xH(i);
            }
        }
    }

    private void initAnimation() {
        this.iif = ValueAnimator.ofFloat(this.ihS, 0.0f);
        this.iif.setDuration(200L);
        this.iif.setInterpolator(new DecelerateInterpolator());
        this.iif.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.ihS) * 0.2f;
                    if (ForumTestView.this.iim) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cqj();
                        } else {
                            ForumTestView.this.cqk();
                        }
                        ForumTestView.this.iim = false;
                    }
                    ForumTestView.this.iin = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.ihM);
                    ForumTestView.this.d(ForumTestView.this.ihN);
                    ForumTestView.this.d(ForumTestView.this.ihO);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.oM(z);
                } else {
                    if (ForumTestView.this.iim) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.xF(2) != null && ForumTestView.this.xF(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cqj();
                                ForumTestView.this.iim = false;
                            }
                        } else if (ForumTestView.this.xF(0) != null && ForumTestView.this.xF(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cqk();
                            ForumTestView.this.iim = false;
                        }
                    }
                    float f = ForumTestView.this.iin - floatValue;
                    float f2 = ForumTestView.this.iic * f;
                    ForumTestView.this.b(ForumTestView.this.ihM, f, f2);
                    ForumTestView.this.b(ForumTestView.this.ihN, f, f2);
                    ForumTestView.this.b(ForumTestView.this.ihO, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.iin = floatValue;
            }
        });
    }

    private void au(float f) {
        CellForumTestView xF;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.iim = false;
        this.iin = 0.0f;
        initAnimation();
        if (this.ihL.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.ihM.getVisibility() == 0) {
                cellForumTestView3 = this.ihM;
            }
            if (this.ihN.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.ihN;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.ihN;
            }
            if (this.ihO.getVisibility() == 0) {
                cellForumTestView2 = this.ihO;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.ihZ[0].left) || viewRight > ((float) this.ihZ[2].right)) && Math.abs(this.mDistance) >= this.ihS * 0.2f) {
                this.iim = true;
            }
        } else if (this.ihL.size() > 2 && Math.abs(this.mDistance) >= this.ihS * 0.2f) {
            this.iim = true;
        }
        if (this.iim && (xF = xF(1)) != null) {
            if (this.mDistance >= this.ihS) {
                this.mDistance -= this.ihS;
                this.iim = false;
                cqk();
            } else if (this.mDistance > 0.0f && this.mDistance < this.ihS) {
                this.mDistance = this.ihZ[0].right - xF.getViewRight();
            } else if (this.mDistance > (-this.ihS)) {
                this.mDistance = this.ihZ[2].left - xF.getViewLeft();
            } else {
                cqj();
                this.mDistance += this.ihS;
                this.iim = false;
            }
        }
        this.iif.setFloatValues(0.0f, this.mDistance);
        this.iif.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqj() {
        this.ihM.setIndex(this.ihM.getIndex() + 1);
        this.ihN.setIndex(this.ihN.getIndex() + 1);
        this.ihO.setIndex(this.ihO.getIndex() + 1);
        b(this.ihM);
        b(this.ihN);
        b(this.ihO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqk() {
        this.ihM.setIndex(this.ihM.getIndex() - 1);
        this.ihN.setIndex(this.ihN.getIndex() - 1);
        this.ihO.setIndex(this.ihO.getIndex() - 1);
        b(this.ihM);
        b(this.ihN);
        b(this.ihO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView xF(int i) {
        if (this.ihM.getIndex() == i) {
            return this.ihM;
        }
        if (this.ihN.getIndex() == i) {
            return this.ihN;
        }
        if (this.ihO.getIndex() == i) {
            return this.ihO;
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
            int size = this.ihL.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int xG(int i) {
        int size = this.ihL.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.ihZ[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.ihZ[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.ihZ[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.ihZ[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.iih && this.mDistance == 0.0f) {
            this.ihL = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.ihM.setVisibility(0);
                this.ihN.setVisibility(0);
                this.ihO.setVisibility(0);
                this.ihM.setData(list.get(0));
                this.ihN.setData(list.get(1));
                this.ihO.setData(list.get(2));
                this.ihM.setDataIndex(0);
                this.ihN.setDataIndex(1);
                this.ihO.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.ihM.setVisibility(8);
                this.ihN.setVisibility(0);
                this.ihO.setVisibility(0);
                this.ihN.setDataIndex(1);
                this.ihO.setDataIndex(0);
                this.ihN.setData(list.get(1));
                this.ihO.setData(list.get(0));
                i = 1;
            } else {
                this.ihM.setVisibility(8);
                this.ihN.setVisibility(0);
                this.ihO.setVisibility(8);
                this.ihN.setDataIndex(0);
                this.ihN.setData(list.get(0));
                i = 0;
            }
            xH(i);
        }
    }

    private void resetData() {
        this.ihM.setIndex(0);
        this.ihN.setIndex(1);
        this.ihO.setIndex(2);
        this.ihP.setIndex(1);
        d(this.ihM);
        d(this.ihN);
        d(this.ihO);
        d(this.ihP);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void xE(int i) {
        CellForumTestView cellForumTestView;
        this.iii = true;
        this.ihP.setVisibility(0);
        this.ihP.setAlpha(1.0f);
        cql();
        if (this.ihM.getIndex() == i && this.ihM.getVisibility() == 0) {
            cellForumTestView = this.ihM;
        } else if (this.ihN.getIndex() == i && this.ihN.getVisibility() == 0) {
            cellForumTestView = this.ihN;
        } else {
            cellForumTestView = this.ihO;
        }
        this.ihP.setData(cellForumTestView.getData());
        this.ihP.setDataIndex(cellForumTestView.getDataIndex());
        this.ihR = null;
        if (this.ihL.size() == 1) {
            this.iij = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.ihS * 3) / 5;
        } else if (this.ihL.size() == 2) {
            this.iij = 2;
            cellForumTestView.setVisibility(8);
            if (this.ihM.getVisibility() == 0) {
                this.ihQ = this.ihM;
            } else if (this.ihN.getVisibility() == 0) {
                this.ihQ = this.ihN;
            } else {
                this.ihQ = this.ihO;
            }
            if (this.ihQ.getViewRight() < this.ihZ[1].left) {
                this.mDistance = this.ihS + this.ihY;
                this.ihQ.setIndex(this.ihQ.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.ihQ.getViewLeft() > this.ihZ[1].right) {
                this.mDistance = (-this.ihS) - this.ihY;
                this.ihQ.setIndex(this.ihQ.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.ihQ);
            b(cellForumTestView);
        } else if (this.ihL.size() == 3) {
            this.iij = 3;
            cellForumTestView.setVisibility(8);
            if (this.ihM.getIndex() == 2) {
                this.ihQ = this.ihM;
            } else if (this.ihN.getIndex() == 2) {
                this.ihQ = this.ihN;
            } else {
                this.ihQ = this.ihO;
            }
            this.mDistance = (-this.ihS) - this.ihY;
            this.ihQ.setIndex(this.ihQ.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.ihQ);
            b(cellForumTestView);
        } else {
            this.iij = 4;
            this.ihR = cellForumTestView;
            if (this.ihM.getIndex() == 2) {
                this.ihQ = this.ihM;
            } else if (this.ihN.getIndex() == 2) {
                this.ihQ = this.ihN;
            } else {
                this.ihQ = this.ihO;
            }
            this.mDistance = (-this.ihS) - this.ihY;
            this.ihQ.setIndex(this.ihQ.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.ihQ);
            b(cellForumTestView);
            this.ihR.setViewLeft(this.ihZ[2].right + this.ihY);
            this.ihR.setViewRight(this.ihZ[2].right + this.ihY + this.ihS);
            this.ihR.setViewTop(this.ihZ[2].top);
            this.ihR.setViewBottom(this.ihZ[2].bottom);
            this.ihR.setMoveLeft(this.ihZ[2].right + this.ihY);
            this.ihR.setMoveRight(this.ihZ[2].right + this.ihY + this.ihS);
            this.ihR.setMoveTop(this.ihZ[2].top);
            this.ihR.setMoveBottom(this.ihZ[2].bottom);
            this.ihR.setData(this.ihL.get(xG(this.ihR.getDataIndex() + 2)));
        }
        this.iig.setFloatValues(0.0f, this.mDistance);
        this.iig.start();
    }

    private void cql() {
        this.ihM.setMoveLeft(this.ihM.getViewLeft());
        this.ihM.setMoveTop(this.ihM.getViewTop());
        this.ihM.setMoveRight(this.ihM.getViewRight());
        this.ihM.setMoveBottom(this.ihM.getViewBottom());
        this.ihN.setMoveLeft(this.ihN.getViewLeft());
        this.ihN.setMoveTop(this.ihN.getViewTop());
        this.ihN.setMoveRight(this.ihN.getViewRight());
        this.ihN.setMoveBottom(this.ihN.getViewBottom());
        this.ihO.setMoveLeft(this.ihO.getViewLeft());
        this.ihO.setMoveTop(this.ihO.getViewTop());
        this.ihO.setMoveRight(this.ihO.getViewRight());
        this.ihO.setMoveBottom(this.ihO.getViewBottom());
        this.ihP.setMoveLeft(this.ihP.getViewLeft());
        this.ihP.setMoveTop(this.ihP.getViewTop());
        this.ihP.setMoveRight(this.ihP.getViewRight());
        this.ihP.setMoveBottom(this.ihP.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.ihM.onChangeSkinType();
            this.ihN.onChangeSkinType();
            this.ihO.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.iih && this.mDistance == 0.0f) {
            if (this.iif != null) {
                this.iif.removeAllUpdateListeners();
                this.iif.cancel();
            }
            if (this.iig != null) {
                this.iig.removeAllUpdateListeners();
                this.iig.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.ihM != null) {
            this.ihM.setPageId(bdUniqueId);
        }
        if (this.ihN != null) {
            this.ihN.setPageId(bdUniqueId);
        }
        if (this.ihO != null) {
            this.ihO.setPageId(bdUniqueId);
        }
    }

    public void xH(int i) {
        f fVar;
        aq a2;
        if (this.ihL != null && i >= 0 && i < this.ihL.size() && (fVar = this.ihL.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dGv().a(this.mPageId, com.baidu.tieba.s.a.Sn("" + fVar.testId), a2);
        }
    }
}
