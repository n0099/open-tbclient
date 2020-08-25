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
    private float hzA;
    private float hzB;
    private ValueAnimator hzC;
    private ValueAnimator hzD;
    private boolean hzE;
    private boolean hzF;
    private int hzG;
    private int hzH;
    private a hzI;
    private boolean hzJ;
    private float hzK;
    private int hzL;
    private List<f> hzi;
    private CellForumTestView hzj;
    private CellForumTestView hzk;
    private CellForumTestView hzl;
    private CellForumTestView hzm;
    private CellForumTestView hzn;
    private CellForumTestView hzo;
    private int hzp;
    private int hzq;
    private int hzr;
    private int hzs;
    private int hzt;
    private int hzu;
    private int hzv;
    private Rect[] hzw;
    private float hzx;
    private float hzy;
    private float hzz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void cgr();

        void eB(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hzw = new Rect[3];
        this.hzE = false;
        this.hzF = false;
        this.hzJ = false;
        this.hzK = 0.0f;
        this.hzL = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hzw = new Rect[3];
        this.hzE = false;
        this.hzF = false;
        this.hzJ = false;
        this.hzK = 0.0f;
        this.hzL = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hzw = new Rect[3];
        this.hzE = false;
        this.hzF = false;
        this.hzJ = false;
        this.hzK = 0.0f;
        this.hzL = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.hzj = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.hzk = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.hzl = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.hzm = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eX(context);
        resetData();
        ViewConfiguration.get(context);
        this.Wg = ViewConfiguration.getMaximumFlingVelocity();
        this.hzj.setForumTestDelClickListener(this);
        this.hzk.setForumTestDelClickListener(this);
        this.hzl.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eX(Context context) {
        this.hzt = l.getDimens(context, R.dimen.tbds44);
        this.hzu = l.getDimens(context, R.dimen.tbds30);
        this.hzv = l.getDimens(context, R.dimen.tbds7);
        this.hzs = l.getDimens(context, R.dimen.tbds730);
        this.hzr = this.hzs - (this.hzu * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.hzp = (int) (this.mWidth * 0.89f);
        this.mHeight = this.hzs + this.hzt;
        this.hzq = ((this.mWidth - this.hzp) - (this.hzv * 2)) / 2;
        this.hzz = this.hzu / (this.hzp + this.hzv);
        this.hzA = this.hzs / this.hzp;
        this.hzB = this.hzp / (this.hzp + this.hzv);
        this.hzw[0] = new Rect(this.hzq - this.hzp, this.hzt + this.hzu, this.hzq, this.hzt + this.hzu + this.hzr);
        this.hzw[1] = new Rect(this.hzq + this.hzv, this.hzt, this.hzq + this.hzv + this.hzp, this.hzt + this.hzs);
        this.hzw[2] = new Rect(this.mWidth - this.hzq, this.hzt + this.hzu, (this.mWidth - this.hzq) + this.hzp, this.hzt + this.hzu + this.hzr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hzD = ValueAnimator.ofFloat(this.hzp, 0.0f);
        this.hzD.setDuration(500L);
        this.hzD.setInterpolator(new DecelerateInterpolator());
        this.hzD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.hzG != 1) {
                    if (ForumTestView.this.hzG == 2 || ForumTestView.this.hzG == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.hzz * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.hzA;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.hzm.setAlpha(0.0f);
                            ForumTestView.this.hzm.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.hzn);
                            ForumTestView.this.d(ForumTestView.this.hzm);
                            ForumTestView.this.hzi.remove(ForumTestView.this.hzm.getData());
                            ForumTestView.this.nH(true);
                            ForumTestView.this.hzF = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.hzn, floatValue, abs);
                            if ((ForumTestView.this.hzp * 2) / 5 >= ForumTestView.this.hzm.getViewRight() - ForumTestView.this.hzm.getViewLeft()) {
                                ForumTestView.this.hzm.setAlpha(0.0f);
                                ForumTestView.this.hzm.setVisibility(8);
                            } else {
                                ForumTestView.this.hzm.setViewLeft(ForumTestView.this.hzm.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hzm.setViewRight(ForumTestView.this.hzm.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hzm.setViewTop(ForumTestView.this.hzm.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.hzm.setViewBottom(ForumTestView.this.hzm.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.hzm.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.hzp * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.hzz * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.hzA;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.hzm.setAlpha(0.0f);
                        ForumTestView.this.hzm.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.hzn);
                        ForumTestView.this.d(ForumTestView.this.hzm);
                        ForumTestView.this.d(ForumTestView.this.hzo);
                        ForumTestView.this.hzi.remove(ForumTestView.this.hzm.getData());
                        if (ForumTestView.this.hzj.getIndex() == 0) {
                            if (ForumTestView.this.hzj.getDataIndex() > ForumTestView.this.hzo.getDataIndex()) {
                                ForumTestView.this.hzj.setDataIndex(ForumTestView.this.hzj.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hzj);
                            }
                        } else if (ForumTestView.this.hzk.getIndex() == 0) {
                            if (ForumTestView.this.hzk.getDataIndex() > ForumTestView.this.hzo.getDataIndex()) {
                                ForumTestView.this.hzk.setDataIndex(ForumTestView.this.hzk.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hzk);
                            }
                        } else if (ForumTestView.this.hzl.getDataIndex() > ForumTestView.this.hzo.getDataIndex()) {
                            ForumTestView.this.hzl.setDataIndex(ForumTestView.this.hzl.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hzl);
                        }
                        if (ForumTestView.this.hzn.getDataIndex() > ForumTestView.this.hzo.getDataIndex()) {
                            ForumTestView.this.hzn.setDataIndex(ForumTestView.this.hzn.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hzn);
                        }
                        ForumTestView.this.hzo.setDataIndex(ForumTestView.this.hzo.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.hzo);
                        ForumTestView.this.nH(true);
                        ForumTestView.this.hzF = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.hzn, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.hzo, floatValue2);
                        if ((ForumTestView.this.hzp * 2) / 5 >= ForumTestView.this.hzm.getViewRight() - ForumTestView.this.hzm.getViewLeft()) {
                            ForumTestView.this.hzm.setAlpha(0.0f);
                            ForumTestView.this.hzm.setVisibility(8);
                        } else {
                            ForumTestView.this.hzm.setViewLeft(ForumTestView.this.hzm.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hzm.setViewRight(ForumTestView.this.hzm.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hzm.setViewTop(ForumTestView.this.hzm.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.hzm.setViewBottom(ForumTestView.this.hzm.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.hzm.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.hzp * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.hzA * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.hzm.setAlpha(0.0f);
                    ForumTestView.this.hzm.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.hzi.remove(ForumTestView.this.hzm.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.hzI != null) {
                        ForumTestView.this.hzI.eB(-1L);
                    }
                    ForumTestView.this.hzF = false;
                    if (ForumTestView.this.hzI != null && y.isEmpty(ForumTestView.this.hzi)) {
                        ForumTestView.this.hzI.cgr();
                    }
                } else {
                    ForumTestView.this.hzm.setViewLeft(ForumTestView.this.hzm.getMoveLeft() + floatValue3);
                    ForumTestView.this.hzm.setViewRight(ForumTestView.this.hzm.getMoveRight() - floatValue3);
                    ForumTestView.this.hzm.setViewTop(ForumTestView.this.hzm.getMoveTop() + f);
                    ForumTestView.this.hzm.setViewBottom(ForumTestView.this.hzm.getMoveBottom() - f);
                    ForumTestView.this.hzm.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.hzL) {
                this.hzL = equipmentWidth;
                eX(getContext());
                d(this.hzj);
                d(this.hzk);
                d(this.hzl);
                d(this.hzm);
            }
            a(this.hzj);
            a(this.hzk);
            a(this.hzl);
            a(this.hzm);
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
            this.hzj.layout((int) this.hzj.getViewLeft(), (int) this.hzj.getViewTop(), (int) this.hzj.getViewRight(), (int) this.hzj.getViewBottom());
            this.hzk.layout((int) this.hzk.getViewLeft(), (int) this.hzk.getViewTop(), (int) this.hzk.getViewRight(), (int) this.hzk.getViewBottom());
            this.hzl.layout((int) this.hzl.getViewLeft(), (int) this.hzl.getViewTop(), (int) this.hzl.getViewRight(), (int) this.hzl.getViewBottom());
            this.hzm.layout((int) this.hzm.getViewLeft(), (int) this.hzm.getViewTop(), (int) this.hzm.getViewRight(), (int) this.hzm.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.hzD == null || !this.hzD.isRunning()) {
            if (this.hzC == null || !this.hzC.isRunning()) {
                int action = motionEvent.getAction();
                Y(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.hzC != null) {
                        this.hzC.removeAllUpdateListeners();
                        this.hzC.cancel();
                    }
                    this.hzH = motionEvent.getPointerId(0);
                    this.hzx = x;
                    this.hzy = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.hzx - x;
                    float f2 = this.hzy - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.hzE = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.hzE) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.hzz * f3;
                    if (this.hzE) {
                        b(this.hzj, f3, f4);
                        b(this.hzk, f3, f4);
                        b(this.hzl, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Wg);
                    float xVelocity = velocityTracker.getXVelocity(this.hzH);
                    if (this.hzE || this.mDistance != 0.0f) {
                        am(xVelocity);
                    }
                    this.hzE = false;
                    releaseVelocityTracker();
                }
                if (this.hzE || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.hzi.size() > 2) {
                if (cellForumTestView.getViewRight() < this.hzw[0].right - (this.hzp / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.hzw[0].right - (this.hzp / 2))) + this.hzw[2].left + (this.hzp / 2) + this.hzv);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.hzp);
                    cellForumTestView.setViewTop(this.hzw[2].top);
                    cellForumTestView.setViewBottom(this.hzw[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hzi.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.hzw[2].left + (this.hzp / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.hzw[2].left + (this.hzp / 2))) + ((this.hzw[0].right - (this.hzp / 2)) - this.hzv));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.hzp);
                    cellForumTestView.setViewTop(this.hzw[0].top);
                    cellForumTestView.setViewBottom(this.hzw[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hzi.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.hzw[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.hzw[0].top) {
                    cellForumTestView.setViewTop(this.hzw[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.hzw[0].bottom) {
                    cellForumTestView.setViewBottom(this.hzw[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.hzw[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.hzw[1].top) {
                    cellForumTestView.setViewTop(this.hzw[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.hzw[1].bottom) {
                    cellForumTestView.setViewBottom(this.hzw[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.hzI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nH(boolean z) {
        if (this.hzI != null) {
            int i = -1;
            if (this.hzj.getIndex() == 1 && this.hzj.getData() != null) {
                this.hzI.eB(this.hzj.getData().testId);
                i = this.hzj.getDataIndex();
            } else if (this.hzk.getIndex() == 1 && this.hzk.getData() != null) {
                this.hzI.eB(this.hzk.getData().testId);
                i = this.hzk.getDataIndex();
            } else if (this.hzl.getIndex() == 1 && this.hzl.getData() != null) {
                this.hzI.eB(this.hzl.getData().testId);
                i = this.hzl.getDataIndex();
            } else {
                this.hzI.eB(-1L);
            }
            if (z) {
                wj(i);
            }
        }
    }

    private void initAnimation() {
        this.hzC = ValueAnimator.ofFloat(this.hzp, 0.0f);
        this.hzC.setDuration(200L);
        this.hzC.setInterpolator(new DecelerateInterpolator());
        this.hzC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.hzp) * 0.2f;
                    if (ForumTestView.this.hzJ) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cgo();
                        } else {
                            ForumTestView.this.cgp();
                        }
                        ForumTestView.this.hzJ = false;
                    }
                    ForumTestView.this.hzK = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.hzj);
                    ForumTestView.this.d(ForumTestView.this.hzk);
                    ForumTestView.this.d(ForumTestView.this.hzl);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.nH(z);
                } else {
                    if (ForumTestView.this.hzJ) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.wh(2) != null && ForumTestView.this.wh(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cgo();
                                ForumTestView.this.hzJ = false;
                            }
                        } else if (ForumTestView.this.wh(0) != null && ForumTestView.this.wh(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cgp();
                            ForumTestView.this.hzJ = false;
                        }
                    }
                    float f = ForumTestView.this.hzK - floatValue;
                    float f2 = ForumTestView.this.hzz * f;
                    ForumTestView.this.b(ForumTestView.this.hzj, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hzk, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hzl, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.hzK = floatValue;
            }
        });
    }

    private void am(float f) {
        CellForumTestView wh;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.hzJ = false;
        this.hzK = 0.0f;
        initAnimation();
        if (this.hzi.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.hzj.getVisibility() == 0) {
                cellForumTestView3 = this.hzj;
            }
            if (this.hzk.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.hzk;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.hzk;
            }
            if (this.hzl.getVisibility() == 0) {
                cellForumTestView2 = this.hzl;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.hzw[0].left) || viewRight > ((float) this.hzw[2].right)) && Math.abs(this.mDistance) >= this.hzp * 0.2f) {
                this.hzJ = true;
            }
        } else if (this.hzi.size() > 2 && Math.abs(this.mDistance) >= this.hzp * 0.2f) {
            this.hzJ = true;
        }
        if (this.hzJ && (wh = wh(1)) != null) {
            if (this.mDistance >= this.hzp) {
                this.mDistance -= this.hzp;
                this.hzJ = false;
                cgp();
            } else if (this.mDistance > 0.0f && this.mDistance < this.hzp) {
                this.mDistance = this.hzw[0].right - wh.getViewRight();
            } else if (this.mDistance > (-this.hzp)) {
                this.mDistance = this.hzw[2].left - wh.getViewLeft();
            } else {
                cgo();
                this.mDistance += this.hzp;
                this.hzJ = false;
            }
        }
        this.hzC.setFloatValues(0.0f, this.mDistance);
        this.hzC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgo() {
        this.hzj.setIndex(this.hzj.getIndex() + 1);
        this.hzk.setIndex(this.hzk.getIndex() + 1);
        this.hzl.setIndex(this.hzl.getIndex() + 1);
        b(this.hzj);
        b(this.hzk);
        b(this.hzl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgp() {
        this.hzj.setIndex(this.hzj.getIndex() - 1);
        this.hzk.setIndex(this.hzk.getIndex() - 1);
        this.hzl.setIndex(this.hzl.getIndex() - 1);
        b(this.hzj);
        b(this.hzk);
        b(this.hzl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView wh(int i) {
        if (this.hzj.getIndex() == i) {
            return this.hzj;
        }
        if (this.hzk.getIndex() == i) {
            return this.hzk;
        }
        if (this.hzl.getIndex() == i) {
            return this.hzl;
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
            int size = this.hzi.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int wi(int i) {
        int size = this.hzi.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.hzw[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.hzw[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.hzw[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.hzw[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.hzE && this.mDistance == 0.0f) {
            this.hzi = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.hzj.setVisibility(0);
                this.hzk.setVisibility(0);
                this.hzl.setVisibility(0);
                this.hzj.setData(list.get(0));
                this.hzk.setData(list.get(1));
                this.hzl.setData(list.get(2));
                this.hzj.setDataIndex(0);
                this.hzk.setDataIndex(1);
                this.hzl.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.hzj.setVisibility(8);
                this.hzk.setVisibility(0);
                this.hzl.setVisibility(0);
                this.hzk.setDataIndex(1);
                this.hzl.setDataIndex(0);
                this.hzk.setData(list.get(1));
                this.hzl.setData(list.get(0));
                i = 1;
            } else {
                this.hzj.setVisibility(8);
                this.hzk.setVisibility(0);
                this.hzl.setVisibility(8);
                this.hzk.setDataIndex(0);
                this.hzk.setData(list.get(0));
                i = 0;
            }
            wj(i);
        }
    }

    private void resetData() {
        this.hzj.setIndex(0);
        this.hzk.setIndex(1);
        this.hzl.setIndex(2);
        this.hzm.setIndex(1);
        d(this.hzj);
        d(this.hzk);
        d(this.hzl);
        d(this.hzm);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void wg(int i) {
        CellForumTestView cellForumTestView;
        this.hzF = true;
        this.hzm.setVisibility(0);
        this.hzm.setAlpha(1.0f);
        cgq();
        if (this.hzj.getIndex() == i && this.hzj.getVisibility() == 0) {
            cellForumTestView = this.hzj;
        } else if (this.hzk.getIndex() == i && this.hzk.getVisibility() == 0) {
            cellForumTestView = this.hzk;
        } else {
            cellForumTestView = this.hzl;
        }
        this.hzm.setData(cellForumTestView.getData());
        this.hzm.setDataIndex(cellForumTestView.getDataIndex());
        this.hzo = null;
        if (this.hzi.size() == 1) {
            this.hzG = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.hzp * 3) / 5;
        } else if (this.hzi.size() == 2) {
            this.hzG = 2;
            cellForumTestView.setVisibility(8);
            if (this.hzj.getVisibility() == 0) {
                this.hzn = this.hzj;
            } else if (this.hzk.getVisibility() == 0) {
                this.hzn = this.hzk;
            } else {
                this.hzn = this.hzl;
            }
            if (this.hzn.getViewRight() < this.hzw[1].left) {
                this.mDistance = this.hzp + this.hzv;
                this.hzn.setIndex(this.hzn.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.hzn.getViewLeft() > this.hzw[1].right) {
                this.mDistance = (-this.hzp) - this.hzv;
                this.hzn.setIndex(this.hzn.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.hzn);
            b(cellForumTestView);
        } else if (this.hzi.size() == 3) {
            this.hzG = 3;
            cellForumTestView.setVisibility(8);
            if (this.hzj.getIndex() == 2) {
                this.hzn = this.hzj;
            } else if (this.hzk.getIndex() == 2) {
                this.hzn = this.hzk;
            } else {
                this.hzn = this.hzl;
            }
            this.mDistance = (-this.hzp) - this.hzv;
            this.hzn.setIndex(this.hzn.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.hzn);
            b(cellForumTestView);
        } else {
            this.hzG = 4;
            this.hzo = cellForumTestView;
            if (this.hzj.getIndex() == 2) {
                this.hzn = this.hzj;
            } else if (this.hzk.getIndex() == 2) {
                this.hzn = this.hzk;
            } else {
                this.hzn = this.hzl;
            }
            this.mDistance = (-this.hzp) - this.hzv;
            this.hzn.setIndex(this.hzn.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.hzn);
            b(cellForumTestView);
            this.hzo.setViewLeft(this.hzw[2].right + this.hzv);
            this.hzo.setViewRight(this.hzw[2].right + this.hzv + this.hzp);
            this.hzo.setViewTop(this.hzw[2].top);
            this.hzo.setViewBottom(this.hzw[2].bottom);
            this.hzo.setMoveLeft(this.hzw[2].right + this.hzv);
            this.hzo.setMoveRight(this.hzw[2].right + this.hzv + this.hzp);
            this.hzo.setMoveTop(this.hzw[2].top);
            this.hzo.setMoveBottom(this.hzw[2].bottom);
            this.hzo.setData(this.hzi.get(wi(this.hzo.getDataIndex() + 2)));
        }
        this.hzD.setFloatValues(0.0f, this.mDistance);
        this.hzD.start();
    }

    private void cgq() {
        this.hzj.setMoveLeft(this.hzj.getViewLeft());
        this.hzj.setMoveTop(this.hzj.getViewTop());
        this.hzj.setMoveRight(this.hzj.getViewRight());
        this.hzj.setMoveBottom(this.hzj.getViewBottom());
        this.hzk.setMoveLeft(this.hzk.getViewLeft());
        this.hzk.setMoveTop(this.hzk.getViewTop());
        this.hzk.setMoveRight(this.hzk.getViewRight());
        this.hzk.setMoveBottom(this.hzk.getViewBottom());
        this.hzl.setMoveLeft(this.hzl.getViewLeft());
        this.hzl.setMoveTop(this.hzl.getViewTop());
        this.hzl.setMoveRight(this.hzl.getViewRight());
        this.hzl.setMoveBottom(this.hzl.getViewBottom());
        this.hzm.setMoveLeft(this.hzm.getViewLeft());
        this.hzm.setMoveTop(this.hzm.getViewTop());
        this.hzm.setMoveRight(this.hzm.getViewRight());
        this.hzm.setMoveBottom(this.hzm.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.hzj.onChangeSkinType();
            this.hzk.onChangeSkinType();
            this.hzl.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.hzE && this.mDistance == 0.0f) {
            if (this.hzC != null) {
                this.hzC.removeAllUpdateListeners();
                this.hzC.cancel();
            }
            if (this.hzD != null) {
                this.hzD.removeAllUpdateListeners();
                this.hzD.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.hzj != null) {
            this.hzj.setPageId(bdUniqueId);
        }
        if (this.hzk != null) {
            this.hzk.setPageId(bdUniqueId);
        }
        if (this.hzl != null) {
            this.hzl.setPageId(bdUniqueId);
        }
    }

    public void wj(int i) {
        f fVar;
        aq a2;
        if (this.hzi != null && i >= 0 && i < this.hzi.size() && (fVar = this.hzi.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dvE().a(this.mPageId, com.baidu.tieba.s.a.QA("" + fVar.testId), a2);
        }
    }
}
