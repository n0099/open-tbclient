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
    private int Bv;
    private List<f> fXN;
    private CellForumTestView fXO;
    private CellForumTestView fXP;
    private CellForumTestView fXQ;
    private CellForumTestView fXR;
    private CellForumTestView fXS;
    private CellForumTestView fXT;
    private int fXU;
    private int fXV;
    private int fXW;
    private int fXX;
    private int fXY;
    private int fXZ;
    private int fYa;
    private Rect[] fYb;
    private float fYc;
    private float fYd;
    private float fYe;
    private float fYf;
    private float fYg;
    private ValueAnimator fYh;
    private ValueAnimator fYi;
    private boolean fYj;
    private int fYk;
    private int fYl;
    private a fYm;
    private boolean fYn;
    private float fYo;
    private int fYp;
    private float mDistance;
    private int mHeight;
    private boolean mIsMove;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void bzh();

        void dq(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fYb = new Rect[3];
        this.mIsMove = false;
        this.fYj = false;
        this.fYn = false;
        this.fYo = 0.0f;
        this.fYp = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fYb = new Rect[3];
        this.mIsMove = false;
        this.fYj = false;
        this.fYn = false;
        this.fYo = 0.0f;
        this.fYp = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fYb = new Rect[3];
        this.mIsMove = false;
        this.fYj = false;
        this.fYn = false;
        this.fYo = 0.0f;
        this.fYp = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fXO = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fXP = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fXQ = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fXR = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eO(context);
        resetData();
        ViewConfiguration.get(context);
        this.Bv = ViewConfiguration.getMaximumFlingVelocity();
        this.fXO.setForumTestDelClickListener(this);
        this.fXP.setForumTestDelClickListener(this);
        this.fXQ.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eO(Context context) {
        this.fXY = l.getDimens(context, R.dimen.tbds44);
        this.fXZ = l.getDimens(context, R.dimen.tbds30);
        this.fYa = l.getDimens(context, R.dimen.tbds7);
        this.fXX = l.getDimens(context, R.dimen.tbds730);
        this.fXW = this.fXX - (this.fXZ * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.fXU = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fXX + this.fXY;
        this.fXV = ((this.mWidth - this.fXU) - (this.fYa * 2)) / 2;
        this.fYe = this.fXZ / (this.fXU + this.fYa);
        this.fYf = this.fXX / this.fXU;
        this.fYg = this.fXU / (this.fXU + this.fYa);
        this.fYb[0] = new Rect(this.fXV - this.fXU, this.fXY + this.fXZ, this.fXV, this.fXY + this.fXZ + this.fXW);
        this.fYb[1] = new Rect(this.fXV + this.fYa, this.fXY, this.fXV + this.fYa + this.fXU, this.fXY + this.fXX);
        this.fYb[2] = new Rect(this.mWidth - this.fXV, this.fXY + this.fXZ, (this.mWidth - this.fXV) + this.fXU, this.fXY + this.fXZ + this.fXW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fYi = ValueAnimator.ofFloat(this.fXU, 0.0f);
        this.fYi.setDuration(500L);
        this.fYi.setInterpolator(new DecelerateInterpolator());
        this.fYi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fYk != 1) {
                    if (ForumTestView.this.fYk == 2 || ForumTestView.this.fYk == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fYe * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.fYf;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.fXR.setAlpha(0.0f);
                            ForumTestView.this.fXR.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fXS);
                            ForumTestView.this.d(ForumTestView.this.fXR);
                            ForumTestView.this.fXN.remove(ForumTestView.this.fXR.getData());
                            ForumTestView.this.kK(true);
                            ForumTestView.this.fYj = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fXS, floatValue, abs);
                            if ((ForumTestView.this.fXU * 2) / 5 >= ForumTestView.this.fXR.getViewRight() - ForumTestView.this.fXR.getViewLeft()) {
                                ForumTestView.this.fXR.setAlpha(0.0f);
                                ForumTestView.this.fXR.setVisibility(8);
                            } else {
                                ForumTestView.this.fXR.setViewLeft(ForumTestView.this.fXR.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fXR.setViewRight(ForumTestView.this.fXR.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fXR.setViewTop(ForumTestView.this.fXR.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fXR.setViewBottom(ForumTestView.this.fXR.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fXR.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fXU * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fYe * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.fYf;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.fXR.setAlpha(0.0f);
                        ForumTestView.this.fXR.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fXS);
                        ForumTestView.this.d(ForumTestView.this.fXR);
                        ForumTestView.this.d(ForumTestView.this.fXT);
                        ForumTestView.this.fXN.remove(ForumTestView.this.fXR.getData());
                        if (ForumTestView.this.fXO.getIndex() == 0) {
                            if (ForumTestView.this.fXO.getDataIndex() > ForumTestView.this.fXT.getDataIndex()) {
                                ForumTestView.this.fXO.setDataIndex(ForumTestView.this.fXO.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fXO);
                            }
                        } else if (ForumTestView.this.fXP.getIndex() == 0) {
                            if (ForumTestView.this.fXP.getDataIndex() > ForumTestView.this.fXT.getDataIndex()) {
                                ForumTestView.this.fXP.setDataIndex(ForumTestView.this.fXP.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fXP);
                            }
                        } else if (ForumTestView.this.fXQ.getDataIndex() > ForumTestView.this.fXT.getDataIndex()) {
                            ForumTestView.this.fXQ.setDataIndex(ForumTestView.this.fXQ.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fXQ);
                        }
                        if (ForumTestView.this.fXS.getDataIndex() > ForumTestView.this.fXT.getDataIndex()) {
                            ForumTestView.this.fXS.setDataIndex(ForumTestView.this.fXS.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fXS);
                        }
                        ForumTestView.this.fXT.setDataIndex(ForumTestView.this.fXT.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fXT);
                        ForumTestView.this.kK(true);
                        ForumTestView.this.fYj = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fXS, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fXT, floatValue2);
                        if ((ForumTestView.this.fXU * 2) / 5 >= ForumTestView.this.fXR.getViewRight() - ForumTestView.this.fXR.getViewLeft()) {
                            ForumTestView.this.fXR.setAlpha(0.0f);
                            ForumTestView.this.fXR.setVisibility(8);
                        } else {
                            ForumTestView.this.fXR.setViewLeft(ForumTestView.this.fXR.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fXR.setViewRight(ForumTestView.this.fXR.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fXR.setViewTop(ForumTestView.this.fXR.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fXR.setViewBottom(ForumTestView.this.fXR.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fXR.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fXU * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.fYf * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.fXR.setAlpha(0.0f);
                    ForumTestView.this.fXR.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.fXN.remove(ForumTestView.this.fXR.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.fYm != null) {
                        ForumTestView.this.fYm.dq(-1L);
                    }
                    ForumTestView.this.fYj = false;
                    if (ForumTestView.this.fYm != null && v.isEmpty(ForumTestView.this.fXN)) {
                        ForumTestView.this.fYm.bzh();
                    }
                } else {
                    ForumTestView.this.fXR.setViewLeft(ForumTestView.this.fXR.getMoveLeft() + floatValue3);
                    ForumTestView.this.fXR.setViewRight(ForumTestView.this.fXR.getMoveRight() - floatValue3);
                    ForumTestView.this.fXR.setViewTop(ForumTestView.this.fXR.getMoveTop() + f);
                    ForumTestView.this.fXR.setViewBottom(ForumTestView.this.fXR.getMoveBottom() - f);
                    ForumTestView.this.fXR.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.fYp) {
                this.fYp = equipmentWidth;
                eO(getContext());
                d(this.fXO);
                d(this.fXP);
                d(this.fXQ);
                d(this.fXR);
            }
            a(this.fXO);
            a(this.fXP);
            a(this.fXQ);
            a(this.fXR);
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
            this.fXO.layout((int) this.fXO.getViewLeft(), (int) this.fXO.getViewTop(), (int) this.fXO.getViewRight(), (int) this.fXO.getViewBottom());
            this.fXP.layout((int) this.fXP.getViewLeft(), (int) this.fXP.getViewTop(), (int) this.fXP.getViewRight(), (int) this.fXP.getViewBottom());
            this.fXQ.layout((int) this.fXQ.getViewLeft(), (int) this.fXQ.getViewTop(), (int) this.fXQ.getViewRight(), (int) this.fXQ.getViewBottom());
            this.fXR.layout((int) this.fXR.getViewLeft(), (int) this.fXR.getViewTop(), (int) this.fXR.getViewRight(), (int) this.fXR.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.fYi == null || !this.fYi.isRunning()) {
            if (this.fYh == null || !this.fYh.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fYh != null) {
                        this.fYh.removeAllUpdateListeners();
                        this.fYh.cancel();
                    }
                    this.fYl = motionEvent.getPointerId(0);
                    this.fYc = x;
                    this.fYd = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fYc - x;
                    float f2 = this.fYd - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.mIsMove = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.mIsMove) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fYe * f3;
                    if (this.mIsMove) {
                        b(this.fXO, f3, f4);
                        b(this.fXP, f3, f4);
                        b(this.fXQ, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Bv);
                    float xVelocity = velocityTracker.getXVelocity(this.fYl);
                    if (this.mIsMove || this.mDistance != 0.0f) {
                        aw(xVelocity);
                    }
                    this.mIsMove = false;
                    releaseVelocityTracker();
                }
                if (this.mIsMove || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.fXN.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fYb[0].right - (this.fXU / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fYb[0].right - (this.fXU / 2))) + this.fYb[2].left + (this.fXU / 2) + this.fYa);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fXU);
                    cellForumTestView.setViewTop(this.fYb[2].top);
                    cellForumTestView.setViewBottom(this.fYb[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fXN.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fYb[2].left + (this.fXU / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fYb[2].left + (this.fXU / 2))) + ((this.fYb[0].right - (this.fXU / 2)) - this.fYa));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fXU);
                    cellForumTestView.setViewTop(this.fYb[0].top);
                    cellForumTestView.setViewBottom(this.fYb[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fXN.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fYb[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fYb[0].top) {
                    cellForumTestView.setViewTop(this.fYb[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fYb[0].bottom) {
                    cellForumTestView.setViewBottom(this.fYb[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fYb[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fYb[1].top) {
                    cellForumTestView.setViewTop(this.fYb[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fYb[1].bottom) {
                    cellForumTestView.setViewBottom(this.fYb[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.fYm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(boolean z) {
        if (this.fYm != null) {
            int i = -1;
            if (this.fXO.getIndex() == 1 && this.fXO.getData() != null) {
                this.fYm.dq(this.fXO.getData().testId);
                i = this.fXO.getDataIndex();
            } else if (this.fXP.getIndex() == 1 && this.fXP.getData() != null) {
                this.fYm.dq(this.fXP.getData().testId);
                i = this.fXP.getDataIndex();
            } else if (this.fXQ.getIndex() == 1 && this.fXQ.getData() != null) {
                this.fYm.dq(this.fXQ.getData().testId);
                i = this.fXQ.getDataIndex();
            } else {
                this.fYm.dq(-1L);
            }
            if (z) {
                rX(i);
            }
        }
    }

    private void initAnimation() {
        this.fYh = ValueAnimator.ofFloat(this.fXU, 0.0f);
        this.fYh.setDuration(200L);
        this.fYh.setInterpolator(new DecelerateInterpolator());
        this.fYh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.fXU) * 0.2f;
                    if (ForumTestView.this.fYn) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bze();
                        } else {
                            ForumTestView.this.bzf();
                        }
                        ForumTestView.this.fYn = false;
                    }
                    ForumTestView.this.fYo = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fXO);
                    ForumTestView.this.d(ForumTestView.this.fXP);
                    ForumTestView.this.d(ForumTestView.this.fXQ);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.kK(z);
                } else {
                    if (ForumTestView.this.fYn) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.rV(2) != null && ForumTestView.this.rV(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bze();
                                ForumTestView.this.fYn = false;
                            }
                        } else if (ForumTestView.this.rV(0) != null && ForumTestView.this.rV(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bzf();
                            ForumTestView.this.fYn = false;
                        }
                    }
                    float f = ForumTestView.this.fYo - floatValue;
                    float f2 = ForumTestView.this.fYe * f;
                    ForumTestView.this.b(ForumTestView.this.fXO, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fXP, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fXQ, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fYo = floatValue;
            }
        });
    }

    private void aw(float f) {
        CellForumTestView rV;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fYn = false;
        this.fYo = 0.0f;
        initAnimation();
        if (this.fXN.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fXO.getVisibility() == 0) {
                cellForumTestView3 = this.fXO;
            }
            if (this.fXP.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fXP;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fXP;
            }
            if (this.fXQ.getVisibility() == 0) {
                cellForumTestView2 = this.fXQ;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fYb[0].left) || viewRight > ((float) this.fYb[2].right)) && Math.abs(this.mDistance) >= this.fXU * 0.2f) {
                this.fYn = true;
            }
        } else if (this.fXN.size() > 2 && Math.abs(this.mDistance) >= this.fXU * 0.2f) {
            this.fYn = true;
        }
        if (this.fYn && (rV = rV(1)) != null) {
            if (this.mDistance >= this.fXU) {
                this.mDistance -= this.fXU;
                this.fYn = false;
                bzf();
            } else if (this.mDistance > 0.0f && this.mDistance < this.fXU) {
                this.mDistance = this.fYb[0].right - rV.getViewRight();
            } else if (this.mDistance > (-this.fXU)) {
                this.mDistance = this.fYb[2].left - rV.getViewLeft();
            } else {
                bze();
                this.mDistance += this.fXU;
                this.fYn = false;
            }
        }
        this.fYh.setFloatValues(0.0f, this.mDistance);
        this.fYh.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bze() {
        this.fXO.setIndex(this.fXO.getIndex() + 1);
        this.fXP.setIndex(this.fXP.getIndex() + 1);
        this.fXQ.setIndex(this.fXQ.getIndex() + 1);
        b(this.fXO);
        b(this.fXP);
        b(this.fXQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzf() {
        this.fXO.setIndex(this.fXO.getIndex() - 1);
        this.fXP.setIndex(this.fXP.getIndex() - 1);
        this.fXQ.setIndex(this.fXQ.getIndex() - 1);
        b(this.fXO);
        b(this.fXP);
        b(this.fXQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView rV(int i) {
        if (this.fXO.getIndex() == i) {
            return this.fXO;
        }
        if (this.fXP.getIndex() == i) {
            return this.fXP;
        }
        if (this.fXQ.getIndex() == i) {
            return this.fXQ;
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
            int size = this.fXN.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int rW(int i) {
        int size = this.fXN.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fYb[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fYb[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fYb[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fYb[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.mIsMove && this.mDistance == 0.0f) {
            this.fXN = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.fXO.setVisibility(0);
                this.fXP.setVisibility(0);
                this.fXQ.setVisibility(0);
                this.fXO.setData(list.get(0));
                this.fXP.setData(list.get(1));
                this.fXQ.setData(list.get(2));
                this.fXO.setDataIndex(0);
                this.fXP.setDataIndex(1);
                this.fXQ.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.fXO.setVisibility(8);
                this.fXP.setVisibility(0);
                this.fXQ.setVisibility(0);
                this.fXP.setDataIndex(1);
                this.fXQ.setDataIndex(0);
                this.fXP.setData(list.get(1));
                this.fXQ.setData(list.get(0));
                i = 1;
            } else {
                this.fXO.setVisibility(8);
                this.fXP.setVisibility(0);
                this.fXQ.setVisibility(8);
                this.fXP.setDataIndex(0);
                this.fXP.setData(list.get(0));
                i = 0;
            }
            rX(i);
        }
    }

    private void resetData() {
        this.fXO.setIndex(0);
        this.fXP.setIndex(1);
        this.fXQ.setIndex(2);
        this.fXR.setIndex(1);
        d(this.fXO);
        d(this.fXP);
        d(this.fXQ);
        d(this.fXR);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void rU(int i) {
        CellForumTestView cellForumTestView;
        this.fYj = true;
        this.fXR.setVisibility(0);
        this.fXR.setAlpha(1.0f);
        bzg();
        if (this.fXO.getIndex() == i && this.fXO.getVisibility() == 0) {
            cellForumTestView = this.fXO;
        } else if (this.fXP.getIndex() == i && this.fXP.getVisibility() == 0) {
            cellForumTestView = this.fXP;
        } else {
            cellForumTestView = this.fXQ;
        }
        this.fXR.setData(cellForumTestView.getData());
        this.fXR.setDataIndex(cellForumTestView.getDataIndex());
        this.fXT = null;
        if (this.fXN.size() == 1) {
            this.fYk = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.fXU * 3) / 5;
        } else if (this.fXN.size() == 2) {
            this.fYk = 2;
            cellForumTestView.setVisibility(8);
            if (this.fXO.getVisibility() == 0) {
                this.fXS = this.fXO;
            } else if (this.fXP.getVisibility() == 0) {
                this.fXS = this.fXP;
            } else {
                this.fXS = this.fXQ;
            }
            if (this.fXS.getViewRight() < this.fYb[1].left) {
                this.mDistance = this.fXU + this.fYa;
                this.fXS.setIndex(this.fXS.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fXS.getViewLeft() > this.fYb[1].right) {
                this.mDistance = (-this.fXU) - this.fYa;
                this.fXS.setIndex(this.fXS.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fXS);
            b(cellForumTestView);
        } else if (this.fXN.size() == 3) {
            this.fYk = 3;
            cellForumTestView.setVisibility(8);
            if (this.fXO.getIndex() == 2) {
                this.fXS = this.fXO;
            } else if (this.fXP.getIndex() == 2) {
                this.fXS = this.fXP;
            } else {
                this.fXS = this.fXQ;
            }
            this.mDistance = (-this.fXU) - this.fYa;
            this.fXS.setIndex(this.fXS.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fXS);
            b(cellForumTestView);
        } else {
            this.fYk = 4;
            this.fXT = cellForumTestView;
            if (this.fXO.getIndex() == 2) {
                this.fXS = this.fXO;
            } else if (this.fXP.getIndex() == 2) {
                this.fXS = this.fXP;
            } else {
                this.fXS = this.fXQ;
            }
            this.mDistance = (-this.fXU) - this.fYa;
            this.fXS.setIndex(this.fXS.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fXS);
            b(cellForumTestView);
            this.fXT.setViewLeft(this.fYb[2].right + this.fYa);
            this.fXT.setViewRight(this.fYb[2].right + this.fYa + this.fXU);
            this.fXT.setViewTop(this.fYb[2].top);
            this.fXT.setViewBottom(this.fYb[2].bottom);
            this.fXT.setMoveLeft(this.fYb[2].right + this.fYa);
            this.fXT.setMoveRight(this.fYb[2].right + this.fYa + this.fXU);
            this.fXT.setMoveTop(this.fYb[2].top);
            this.fXT.setMoveBottom(this.fYb[2].bottom);
            this.fXT.setData(this.fXN.get(rW(this.fXT.getDataIndex() + 2)));
        }
        this.fYi.setFloatValues(0.0f, this.mDistance);
        this.fYi.start();
    }

    private void bzg() {
        this.fXO.setMoveLeft(this.fXO.getViewLeft());
        this.fXO.setMoveTop(this.fXO.getViewTop());
        this.fXO.setMoveRight(this.fXO.getViewRight());
        this.fXO.setMoveBottom(this.fXO.getViewBottom());
        this.fXP.setMoveLeft(this.fXP.getViewLeft());
        this.fXP.setMoveTop(this.fXP.getViewTop());
        this.fXP.setMoveRight(this.fXP.getViewRight());
        this.fXP.setMoveBottom(this.fXP.getViewBottom());
        this.fXQ.setMoveLeft(this.fXQ.getViewLeft());
        this.fXQ.setMoveTop(this.fXQ.getViewTop());
        this.fXQ.setMoveRight(this.fXQ.getViewRight());
        this.fXQ.setMoveBottom(this.fXQ.getViewBottom());
        this.fXR.setMoveLeft(this.fXR.getViewLeft());
        this.fXR.setMoveTop(this.fXR.getViewTop());
        this.fXR.setMoveRight(this.fXR.getViewRight());
        this.fXR.setMoveBottom(this.fXR.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.fXO.onChangeSkinType();
            this.fXP.onChangeSkinType();
            this.fXQ.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.mIsMove && this.mDistance == 0.0f) {
            if (this.fYh != null) {
                this.fYh.removeAllUpdateListeners();
                this.fYh.cancel();
            }
            if (this.fYi != null) {
                this.fYi.removeAllUpdateListeners();
                this.fYi.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fXO != null) {
            this.fXO.setPageId(bdUniqueId);
        }
        if (this.fXP != null) {
            this.fXP.setPageId(bdUniqueId);
        }
        if (this.fXQ != null) {
            this.fXQ.setPageId(bdUniqueId);
        }
    }

    public void rX(int i) {
        f fVar;
        an a2;
        if (this.fXN != null && i >= 0 && i < this.fXN.size() && (fVar = this.fXN.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.cKb().a(this.mPageId, com.baidu.tieba.s.a.IQ("" + fVar.testId), a2);
        }
    }
}
