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
/* loaded from: classes16.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int Wg;
    private int hzA;
    private int hzB;
    private Rect[] hzC;
    private float hzD;
    private float hzE;
    private float hzF;
    private float hzG;
    private float hzH;
    private ValueAnimator hzI;
    private ValueAnimator hzJ;
    private boolean hzK;
    private boolean hzL;
    private int hzM;
    private int hzN;
    private a hzO;
    private boolean hzP;
    private float hzQ;
    private int hzR;
    private List<f> hzo;
    private CellForumTestView hzp;
    private CellForumTestView hzq;
    private CellForumTestView hzr;
    private CellForumTestView hzs;
    private CellForumTestView hzt;
    private CellForumTestView hzu;
    private int hzv;
    private int hzw;
    private int hzx;
    private int hzy;
    private int hzz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void cgs();

        void eB(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hzC = new Rect[3];
        this.hzK = false;
        this.hzL = false;
        this.hzP = false;
        this.hzQ = 0.0f;
        this.hzR = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hzC = new Rect[3];
        this.hzK = false;
        this.hzL = false;
        this.hzP = false;
        this.hzQ = 0.0f;
        this.hzR = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hzC = new Rect[3];
        this.hzK = false;
        this.hzL = false;
        this.hzP = false;
        this.hzQ = 0.0f;
        this.hzR = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.hzp = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.hzq = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.hzr = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.hzs = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eX(context);
        resetData();
        ViewConfiguration.get(context);
        this.Wg = ViewConfiguration.getMaximumFlingVelocity();
        this.hzp.setForumTestDelClickListener(this);
        this.hzq.setForumTestDelClickListener(this);
        this.hzr.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eX(Context context) {
        this.hzz = l.getDimens(context, R.dimen.tbds44);
        this.hzA = l.getDimens(context, R.dimen.tbds30);
        this.hzB = l.getDimens(context, R.dimen.tbds7);
        this.hzy = l.getDimens(context, R.dimen.tbds730);
        this.hzx = this.hzy - (this.hzA * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.hzv = (int) (this.mWidth * 0.89f);
        this.mHeight = this.hzy + this.hzz;
        this.hzw = ((this.mWidth - this.hzv) - (this.hzB * 2)) / 2;
        this.hzF = this.hzA / (this.hzv + this.hzB);
        this.hzG = this.hzy / this.hzv;
        this.hzH = this.hzv / (this.hzv + this.hzB);
        this.hzC[0] = new Rect(this.hzw - this.hzv, this.hzz + this.hzA, this.hzw, this.hzz + this.hzA + this.hzx);
        this.hzC[1] = new Rect(this.hzw + this.hzB, this.hzz, this.hzw + this.hzB + this.hzv, this.hzz + this.hzy);
        this.hzC[2] = new Rect(this.mWidth - this.hzw, this.hzz + this.hzA, (this.mWidth - this.hzw) + this.hzv, this.hzz + this.hzA + this.hzx);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hzJ = ValueAnimator.ofFloat(this.hzv, 0.0f);
        this.hzJ.setDuration(500L);
        this.hzJ.setInterpolator(new DecelerateInterpolator());
        this.hzJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.hzM != 1) {
                    if (ForumTestView.this.hzM == 2 || ForumTestView.this.hzM == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.hzF * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.hzG;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.hzs.setAlpha(0.0f);
                            ForumTestView.this.hzs.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.hzt);
                            ForumTestView.this.d(ForumTestView.this.hzs);
                            ForumTestView.this.hzo.remove(ForumTestView.this.hzs.getData());
                            ForumTestView.this.nJ(true);
                            ForumTestView.this.hzL = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.hzt, floatValue, abs);
                            if ((ForumTestView.this.hzv * 2) / 5 >= ForumTestView.this.hzs.getViewRight() - ForumTestView.this.hzs.getViewLeft()) {
                                ForumTestView.this.hzs.setAlpha(0.0f);
                                ForumTestView.this.hzs.setVisibility(8);
                            } else {
                                ForumTestView.this.hzs.setViewLeft(ForumTestView.this.hzs.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hzs.setViewRight(ForumTestView.this.hzs.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hzs.setViewTop(ForumTestView.this.hzs.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.hzs.setViewBottom(ForumTestView.this.hzs.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.hzs.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.hzv * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.hzF * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.hzG;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.hzs.setAlpha(0.0f);
                        ForumTestView.this.hzs.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.hzt);
                        ForumTestView.this.d(ForumTestView.this.hzs);
                        ForumTestView.this.d(ForumTestView.this.hzu);
                        ForumTestView.this.hzo.remove(ForumTestView.this.hzs.getData());
                        if (ForumTestView.this.hzp.getIndex() == 0) {
                            if (ForumTestView.this.hzp.getDataIndex() > ForumTestView.this.hzu.getDataIndex()) {
                                ForumTestView.this.hzp.setDataIndex(ForumTestView.this.hzp.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hzp);
                            }
                        } else if (ForumTestView.this.hzq.getIndex() == 0) {
                            if (ForumTestView.this.hzq.getDataIndex() > ForumTestView.this.hzu.getDataIndex()) {
                                ForumTestView.this.hzq.setDataIndex(ForumTestView.this.hzq.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hzq);
                            }
                        } else if (ForumTestView.this.hzr.getDataIndex() > ForumTestView.this.hzu.getDataIndex()) {
                            ForumTestView.this.hzr.setDataIndex(ForumTestView.this.hzr.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hzr);
                        }
                        if (ForumTestView.this.hzt.getDataIndex() > ForumTestView.this.hzu.getDataIndex()) {
                            ForumTestView.this.hzt.setDataIndex(ForumTestView.this.hzt.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hzt);
                        }
                        ForumTestView.this.hzu.setDataIndex(ForumTestView.this.hzu.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.hzu);
                        ForumTestView.this.nJ(true);
                        ForumTestView.this.hzL = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.hzt, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.hzu, floatValue2);
                        if ((ForumTestView.this.hzv * 2) / 5 >= ForumTestView.this.hzs.getViewRight() - ForumTestView.this.hzs.getViewLeft()) {
                            ForumTestView.this.hzs.setAlpha(0.0f);
                            ForumTestView.this.hzs.setVisibility(8);
                        } else {
                            ForumTestView.this.hzs.setViewLeft(ForumTestView.this.hzs.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hzs.setViewRight(ForumTestView.this.hzs.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hzs.setViewTop(ForumTestView.this.hzs.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.hzs.setViewBottom(ForumTestView.this.hzs.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.hzs.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.hzv * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.hzG * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.hzs.setAlpha(0.0f);
                    ForumTestView.this.hzs.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.hzo.remove(ForumTestView.this.hzs.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.hzO != null) {
                        ForumTestView.this.hzO.eB(-1L);
                    }
                    ForumTestView.this.hzL = false;
                    if (ForumTestView.this.hzO != null && y.isEmpty(ForumTestView.this.hzo)) {
                        ForumTestView.this.hzO.cgs();
                    }
                } else {
                    ForumTestView.this.hzs.setViewLeft(ForumTestView.this.hzs.getMoveLeft() + floatValue3);
                    ForumTestView.this.hzs.setViewRight(ForumTestView.this.hzs.getMoveRight() - floatValue3);
                    ForumTestView.this.hzs.setViewTop(ForumTestView.this.hzs.getMoveTop() + f);
                    ForumTestView.this.hzs.setViewBottom(ForumTestView.this.hzs.getMoveBottom() - f);
                    ForumTestView.this.hzs.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.hzR) {
                this.hzR = equipmentWidth;
                eX(getContext());
                d(this.hzp);
                d(this.hzq);
                d(this.hzr);
                d(this.hzs);
            }
            a(this.hzp);
            a(this.hzq);
            a(this.hzr);
            a(this.hzs);
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
            this.hzp.layout((int) this.hzp.getViewLeft(), (int) this.hzp.getViewTop(), (int) this.hzp.getViewRight(), (int) this.hzp.getViewBottom());
            this.hzq.layout((int) this.hzq.getViewLeft(), (int) this.hzq.getViewTop(), (int) this.hzq.getViewRight(), (int) this.hzq.getViewBottom());
            this.hzr.layout((int) this.hzr.getViewLeft(), (int) this.hzr.getViewTop(), (int) this.hzr.getViewRight(), (int) this.hzr.getViewBottom());
            this.hzs.layout((int) this.hzs.getViewLeft(), (int) this.hzs.getViewTop(), (int) this.hzs.getViewRight(), (int) this.hzs.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.hzJ == null || !this.hzJ.isRunning()) {
            if (this.hzI == null || !this.hzI.isRunning()) {
                int action = motionEvent.getAction();
                Y(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.hzI != null) {
                        this.hzI.removeAllUpdateListeners();
                        this.hzI.cancel();
                    }
                    this.hzN = motionEvent.getPointerId(0);
                    this.hzD = x;
                    this.hzE = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.hzD - x;
                    float f2 = this.hzE - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.hzK = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.hzK) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.hzF * f3;
                    if (this.hzK) {
                        b(this.hzp, f3, f4);
                        b(this.hzq, f3, f4);
                        b(this.hzr, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Wg);
                    float xVelocity = velocityTracker.getXVelocity(this.hzN);
                    if (this.hzK || this.mDistance != 0.0f) {
                        am(xVelocity);
                    }
                    this.hzK = false;
                    releaseVelocityTracker();
                }
                if (this.hzK || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.hzo.size() > 2) {
                if (cellForumTestView.getViewRight() < this.hzC[0].right - (this.hzv / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.hzC[0].right - (this.hzv / 2))) + this.hzC[2].left + (this.hzv / 2) + this.hzB);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.hzv);
                    cellForumTestView.setViewTop(this.hzC[2].top);
                    cellForumTestView.setViewBottom(this.hzC[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hzo.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.hzC[2].left + (this.hzv / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.hzC[2].left + (this.hzv / 2))) + ((this.hzC[0].right - (this.hzv / 2)) - this.hzB));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.hzv);
                    cellForumTestView.setViewTop(this.hzC[0].top);
                    cellForumTestView.setViewBottom(this.hzC[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hzo.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.hzC[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.hzC[0].top) {
                    cellForumTestView.setViewTop(this.hzC[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.hzC[0].bottom) {
                    cellForumTestView.setViewBottom(this.hzC[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.hzC[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.hzC[1].top) {
                    cellForumTestView.setViewTop(this.hzC[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.hzC[1].bottom) {
                    cellForumTestView.setViewBottom(this.hzC[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.hzO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(boolean z) {
        if (this.hzO != null) {
            int i = -1;
            if (this.hzp.getIndex() == 1 && this.hzp.getData() != null) {
                this.hzO.eB(this.hzp.getData().testId);
                i = this.hzp.getDataIndex();
            } else if (this.hzq.getIndex() == 1 && this.hzq.getData() != null) {
                this.hzO.eB(this.hzq.getData().testId);
                i = this.hzq.getDataIndex();
            } else if (this.hzr.getIndex() == 1 && this.hzr.getData() != null) {
                this.hzO.eB(this.hzr.getData().testId);
                i = this.hzr.getDataIndex();
            } else {
                this.hzO.eB(-1L);
            }
            if (z) {
                wj(i);
            }
        }
    }

    private void initAnimation() {
        this.hzI = ValueAnimator.ofFloat(this.hzv, 0.0f);
        this.hzI.setDuration(200L);
        this.hzI.setInterpolator(new DecelerateInterpolator());
        this.hzI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.hzv) * 0.2f;
                    if (ForumTestView.this.hzP) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cgp();
                        } else {
                            ForumTestView.this.cgq();
                        }
                        ForumTestView.this.hzP = false;
                    }
                    ForumTestView.this.hzQ = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.hzp);
                    ForumTestView.this.d(ForumTestView.this.hzq);
                    ForumTestView.this.d(ForumTestView.this.hzr);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.nJ(z);
                } else {
                    if (ForumTestView.this.hzP) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.wh(2) != null && ForumTestView.this.wh(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cgp();
                                ForumTestView.this.hzP = false;
                            }
                        } else if (ForumTestView.this.wh(0) != null && ForumTestView.this.wh(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cgq();
                            ForumTestView.this.hzP = false;
                        }
                    }
                    float f = ForumTestView.this.hzQ - floatValue;
                    float f2 = ForumTestView.this.hzF * f;
                    ForumTestView.this.b(ForumTestView.this.hzp, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hzq, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hzr, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.hzQ = floatValue;
            }
        });
    }

    private void am(float f) {
        CellForumTestView wh;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.hzP = false;
        this.hzQ = 0.0f;
        initAnimation();
        if (this.hzo.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.hzp.getVisibility() == 0) {
                cellForumTestView3 = this.hzp;
            }
            if (this.hzq.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.hzq;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.hzq;
            }
            if (this.hzr.getVisibility() == 0) {
                cellForumTestView2 = this.hzr;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.hzC[0].left) || viewRight > ((float) this.hzC[2].right)) && Math.abs(this.mDistance) >= this.hzv * 0.2f) {
                this.hzP = true;
            }
        } else if (this.hzo.size() > 2 && Math.abs(this.mDistance) >= this.hzv * 0.2f) {
            this.hzP = true;
        }
        if (this.hzP && (wh = wh(1)) != null) {
            if (this.mDistance >= this.hzv) {
                this.mDistance -= this.hzv;
                this.hzP = false;
                cgq();
            } else if (this.mDistance > 0.0f && this.mDistance < this.hzv) {
                this.mDistance = this.hzC[0].right - wh.getViewRight();
            } else if (this.mDistance > (-this.hzv)) {
                this.mDistance = this.hzC[2].left - wh.getViewLeft();
            } else {
                cgp();
                this.mDistance += this.hzv;
                this.hzP = false;
            }
        }
        this.hzI.setFloatValues(0.0f, this.mDistance);
        this.hzI.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgp() {
        this.hzp.setIndex(this.hzp.getIndex() + 1);
        this.hzq.setIndex(this.hzq.getIndex() + 1);
        this.hzr.setIndex(this.hzr.getIndex() + 1);
        b(this.hzp);
        b(this.hzq);
        b(this.hzr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgq() {
        this.hzp.setIndex(this.hzp.getIndex() - 1);
        this.hzq.setIndex(this.hzq.getIndex() - 1);
        this.hzr.setIndex(this.hzr.getIndex() - 1);
        b(this.hzp);
        b(this.hzq);
        b(this.hzr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView wh(int i) {
        if (this.hzp.getIndex() == i) {
            return this.hzp;
        }
        if (this.hzq.getIndex() == i) {
            return this.hzq;
        }
        if (this.hzr.getIndex() == i) {
            return this.hzr;
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
            int size = this.hzo.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int wi(int i) {
        int size = this.hzo.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.hzC[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.hzC[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.hzC[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.hzC[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.hzK && this.mDistance == 0.0f) {
            this.hzo = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.hzp.setVisibility(0);
                this.hzq.setVisibility(0);
                this.hzr.setVisibility(0);
                this.hzp.setData(list.get(0));
                this.hzq.setData(list.get(1));
                this.hzr.setData(list.get(2));
                this.hzp.setDataIndex(0);
                this.hzq.setDataIndex(1);
                this.hzr.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.hzp.setVisibility(8);
                this.hzq.setVisibility(0);
                this.hzr.setVisibility(0);
                this.hzq.setDataIndex(1);
                this.hzr.setDataIndex(0);
                this.hzq.setData(list.get(1));
                this.hzr.setData(list.get(0));
                i = 1;
            } else {
                this.hzp.setVisibility(8);
                this.hzq.setVisibility(0);
                this.hzr.setVisibility(8);
                this.hzq.setDataIndex(0);
                this.hzq.setData(list.get(0));
                i = 0;
            }
            wj(i);
        }
    }

    private void resetData() {
        this.hzp.setIndex(0);
        this.hzq.setIndex(1);
        this.hzr.setIndex(2);
        this.hzs.setIndex(1);
        d(this.hzp);
        d(this.hzq);
        d(this.hzr);
        d(this.hzs);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void wg(int i) {
        CellForumTestView cellForumTestView;
        this.hzL = true;
        this.hzs.setVisibility(0);
        this.hzs.setAlpha(1.0f);
        cgr();
        if (this.hzp.getIndex() == i && this.hzp.getVisibility() == 0) {
            cellForumTestView = this.hzp;
        } else if (this.hzq.getIndex() == i && this.hzq.getVisibility() == 0) {
            cellForumTestView = this.hzq;
        } else {
            cellForumTestView = this.hzr;
        }
        this.hzs.setData(cellForumTestView.getData());
        this.hzs.setDataIndex(cellForumTestView.getDataIndex());
        this.hzu = null;
        if (this.hzo.size() == 1) {
            this.hzM = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.hzv * 3) / 5;
        } else if (this.hzo.size() == 2) {
            this.hzM = 2;
            cellForumTestView.setVisibility(8);
            if (this.hzp.getVisibility() == 0) {
                this.hzt = this.hzp;
            } else if (this.hzq.getVisibility() == 0) {
                this.hzt = this.hzq;
            } else {
                this.hzt = this.hzr;
            }
            if (this.hzt.getViewRight() < this.hzC[1].left) {
                this.mDistance = this.hzv + this.hzB;
                this.hzt.setIndex(this.hzt.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.hzt.getViewLeft() > this.hzC[1].right) {
                this.mDistance = (-this.hzv) - this.hzB;
                this.hzt.setIndex(this.hzt.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.hzt);
            b(cellForumTestView);
        } else if (this.hzo.size() == 3) {
            this.hzM = 3;
            cellForumTestView.setVisibility(8);
            if (this.hzp.getIndex() == 2) {
                this.hzt = this.hzp;
            } else if (this.hzq.getIndex() == 2) {
                this.hzt = this.hzq;
            } else {
                this.hzt = this.hzr;
            }
            this.mDistance = (-this.hzv) - this.hzB;
            this.hzt.setIndex(this.hzt.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.hzt);
            b(cellForumTestView);
        } else {
            this.hzM = 4;
            this.hzu = cellForumTestView;
            if (this.hzp.getIndex() == 2) {
                this.hzt = this.hzp;
            } else if (this.hzq.getIndex() == 2) {
                this.hzt = this.hzq;
            } else {
                this.hzt = this.hzr;
            }
            this.mDistance = (-this.hzv) - this.hzB;
            this.hzt.setIndex(this.hzt.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.hzt);
            b(cellForumTestView);
            this.hzu.setViewLeft(this.hzC[2].right + this.hzB);
            this.hzu.setViewRight(this.hzC[2].right + this.hzB + this.hzv);
            this.hzu.setViewTop(this.hzC[2].top);
            this.hzu.setViewBottom(this.hzC[2].bottom);
            this.hzu.setMoveLeft(this.hzC[2].right + this.hzB);
            this.hzu.setMoveRight(this.hzC[2].right + this.hzB + this.hzv);
            this.hzu.setMoveTop(this.hzC[2].top);
            this.hzu.setMoveBottom(this.hzC[2].bottom);
            this.hzu.setData(this.hzo.get(wi(this.hzu.getDataIndex() + 2)));
        }
        this.hzJ.setFloatValues(0.0f, this.mDistance);
        this.hzJ.start();
    }

    private void cgr() {
        this.hzp.setMoveLeft(this.hzp.getViewLeft());
        this.hzp.setMoveTop(this.hzp.getViewTop());
        this.hzp.setMoveRight(this.hzp.getViewRight());
        this.hzp.setMoveBottom(this.hzp.getViewBottom());
        this.hzq.setMoveLeft(this.hzq.getViewLeft());
        this.hzq.setMoveTop(this.hzq.getViewTop());
        this.hzq.setMoveRight(this.hzq.getViewRight());
        this.hzq.setMoveBottom(this.hzq.getViewBottom());
        this.hzr.setMoveLeft(this.hzr.getViewLeft());
        this.hzr.setMoveTop(this.hzr.getViewTop());
        this.hzr.setMoveRight(this.hzr.getViewRight());
        this.hzr.setMoveBottom(this.hzr.getViewBottom());
        this.hzs.setMoveLeft(this.hzs.getViewLeft());
        this.hzs.setMoveTop(this.hzs.getViewTop());
        this.hzs.setMoveRight(this.hzs.getViewRight());
        this.hzs.setMoveBottom(this.hzs.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.hzp.onChangeSkinType();
            this.hzq.onChangeSkinType();
            this.hzr.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.hzK && this.mDistance == 0.0f) {
            if (this.hzI != null) {
                this.hzI.removeAllUpdateListeners();
                this.hzI.cancel();
            }
            if (this.hzJ != null) {
                this.hzJ.removeAllUpdateListeners();
                this.hzJ.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.hzp != null) {
            this.hzp.setPageId(bdUniqueId);
        }
        if (this.hzq != null) {
            this.hzq.setPageId(bdUniqueId);
        }
        if (this.hzr != null) {
            this.hzr.setPageId(bdUniqueId);
        }
    }

    public void wj(int i) {
        f fVar;
        aq a2;
        if (this.hzo != null && i >= 0 && i < this.hzo.size() && (fVar = this.hzo.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dvJ().a(this.mPageId, com.baidu.tieba.s.a.QA("" + fVar.testId), a2);
        }
    }
}
