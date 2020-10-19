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
    private int WO;
    private float hVA;
    private float hVB;
    private float hVC;
    private float hVD;
    private float hVE;
    private ValueAnimator hVF;
    private ValueAnimator hVG;
    private boolean hVH;
    private boolean hVI;
    private int hVJ;
    private int hVK;
    private a hVL;
    private boolean hVM;
    private float hVN;
    private int hVO;
    private List<f> hVl;
    private CellForumTestView hVm;
    private CellForumTestView hVn;
    private CellForumTestView hVo;
    private CellForumTestView hVp;
    private CellForumTestView hVq;
    private CellForumTestView hVr;
    private int hVs;
    private int hVt;
    private int hVu;
    private int hVv;
    private int hVw;
    private int hVx;
    private int hVy;
    private Rect[] hVz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void cnf();

        void fc(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hVz = new Rect[3];
        this.hVH = false;
        this.hVI = false;
        this.hVM = false;
        this.hVN = 0.0f;
        this.hVO = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hVz = new Rect[3];
        this.hVH = false;
        this.hVI = false;
        this.hVM = false;
        this.hVN = 0.0f;
        this.hVO = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hVz = new Rect[3];
        this.hVH = false;
        this.hVI = false;
        this.hVM = false;
        this.hVN = 0.0f;
        this.hVO = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.hVm = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.hVn = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.hVo = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.hVp = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        fk(context);
        resetData();
        ViewConfiguration.get(context);
        this.WO = ViewConfiguration.getMaximumFlingVelocity();
        this.hVm.setForumTestDelClickListener(this);
        this.hVn.setForumTestDelClickListener(this);
        this.hVo.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void fk(Context context) {
        this.hVw = l.getDimens(context, R.dimen.tbds44);
        this.hVx = l.getDimens(context, R.dimen.tbds30);
        this.hVy = l.getDimens(context, R.dimen.tbds7);
        this.hVv = l.getDimens(context, R.dimen.tbds730);
        this.hVu = this.hVv - (this.hVx * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.hVs = (int) (this.mWidth * 0.89f);
        this.mHeight = this.hVv + this.hVw;
        this.hVt = ((this.mWidth - this.hVs) - (this.hVy * 2)) / 2;
        this.hVC = this.hVx / (this.hVs + this.hVy);
        this.hVD = this.hVv / this.hVs;
        this.hVE = this.hVs / (this.hVs + this.hVy);
        this.hVz[0] = new Rect(this.hVt - this.hVs, this.hVw + this.hVx, this.hVt, this.hVw + this.hVx + this.hVu);
        this.hVz[1] = new Rect(this.hVt + this.hVy, this.hVw, this.hVt + this.hVy + this.hVs, this.hVw + this.hVv);
        this.hVz[2] = new Rect(this.mWidth - this.hVt, this.hVw + this.hVx, (this.mWidth - this.hVt) + this.hVs, this.hVw + this.hVx + this.hVu);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hVG = ValueAnimator.ofFloat(this.hVs, 0.0f);
        this.hVG.setDuration(500L);
        this.hVG.setInterpolator(new DecelerateInterpolator());
        this.hVG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.hVJ != 1) {
                    if (ForumTestView.this.hVJ == 2 || ForumTestView.this.hVJ == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.hVC * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.hVD;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.hVp.setAlpha(0.0f);
                            ForumTestView.this.hVp.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.hVq);
                            ForumTestView.this.d(ForumTestView.this.hVp);
                            ForumTestView.this.hVl.remove(ForumTestView.this.hVp.getData());
                            ForumTestView.this.ou(true);
                            ForumTestView.this.hVI = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.hVq, floatValue, abs);
                            if ((ForumTestView.this.hVs * 2) / 5 >= ForumTestView.this.hVp.getViewRight() - ForumTestView.this.hVp.getViewLeft()) {
                                ForumTestView.this.hVp.setAlpha(0.0f);
                                ForumTestView.this.hVp.setVisibility(8);
                            } else {
                                ForumTestView.this.hVp.setViewLeft(ForumTestView.this.hVp.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hVp.setViewRight(ForumTestView.this.hVp.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hVp.setViewTop(ForumTestView.this.hVp.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.hVp.setViewBottom(ForumTestView.this.hVp.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.hVp.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.hVs * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.hVC * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.hVD;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.hVp.setAlpha(0.0f);
                        ForumTestView.this.hVp.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.hVq);
                        ForumTestView.this.d(ForumTestView.this.hVp);
                        ForumTestView.this.d(ForumTestView.this.hVr);
                        ForumTestView.this.hVl.remove(ForumTestView.this.hVp.getData());
                        if (ForumTestView.this.hVm.getIndex() == 0) {
                            if (ForumTestView.this.hVm.getDataIndex() > ForumTestView.this.hVr.getDataIndex()) {
                                ForumTestView.this.hVm.setDataIndex(ForumTestView.this.hVm.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hVm);
                            }
                        } else if (ForumTestView.this.hVn.getIndex() == 0) {
                            if (ForumTestView.this.hVn.getDataIndex() > ForumTestView.this.hVr.getDataIndex()) {
                                ForumTestView.this.hVn.setDataIndex(ForumTestView.this.hVn.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hVn);
                            }
                        } else if (ForumTestView.this.hVo.getDataIndex() > ForumTestView.this.hVr.getDataIndex()) {
                            ForumTestView.this.hVo.setDataIndex(ForumTestView.this.hVo.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hVo);
                        }
                        if (ForumTestView.this.hVq.getDataIndex() > ForumTestView.this.hVr.getDataIndex()) {
                            ForumTestView.this.hVq.setDataIndex(ForumTestView.this.hVq.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hVq);
                        }
                        ForumTestView.this.hVr.setDataIndex(ForumTestView.this.hVr.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.hVr);
                        ForumTestView.this.ou(true);
                        ForumTestView.this.hVI = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.hVq, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.hVr, floatValue2);
                        if ((ForumTestView.this.hVs * 2) / 5 >= ForumTestView.this.hVp.getViewRight() - ForumTestView.this.hVp.getViewLeft()) {
                            ForumTestView.this.hVp.setAlpha(0.0f);
                            ForumTestView.this.hVp.setVisibility(8);
                        } else {
                            ForumTestView.this.hVp.setViewLeft(ForumTestView.this.hVp.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hVp.setViewRight(ForumTestView.this.hVp.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hVp.setViewTop(ForumTestView.this.hVp.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.hVp.setViewBottom(ForumTestView.this.hVp.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.hVp.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.hVs * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.hVD * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.hVp.setAlpha(0.0f);
                    ForumTestView.this.hVp.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.hVl.remove(ForumTestView.this.hVp.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.hVL != null) {
                        ForumTestView.this.hVL.fc(-1L);
                    }
                    ForumTestView.this.hVI = false;
                    if (ForumTestView.this.hVL != null && y.isEmpty(ForumTestView.this.hVl)) {
                        ForumTestView.this.hVL.cnf();
                    }
                } else {
                    ForumTestView.this.hVp.setViewLeft(ForumTestView.this.hVp.getMoveLeft() + floatValue3);
                    ForumTestView.this.hVp.setViewRight(ForumTestView.this.hVp.getMoveRight() - floatValue3);
                    ForumTestView.this.hVp.setViewTop(ForumTestView.this.hVp.getMoveTop() + f);
                    ForumTestView.this.hVp.setViewBottom(ForumTestView.this.hVp.getMoveBottom() - f);
                    ForumTestView.this.hVp.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.hVO) {
                this.hVO = equipmentWidth;
                fk(getContext());
                d(this.hVm);
                d(this.hVn);
                d(this.hVo);
                d(this.hVp);
            }
            a(this.hVm);
            a(this.hVn);
            a(this.hVo);
            a(this.hVp);
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
            this.hVm.layout((int) this.hVm.getViewLeft(), (int) this.hVm.getViewTop(), (int) this.hVm.getViewRight(), (int) this.hVm.getViewBottom());
            this.hVn.layout((int) this.hVn.getViewLeft(), (int) this.hVn.getViewTop(), (int) this.hVn.getViewRight(), (int) this.hVn.getViewBottom());
            this.hVo.layout((int) this.hVo.getViewLeft(), (int) this.hVo.getViewTop(), (int) this.hVo.getViewRight(), (int) this.hVo.getViewBottom());
            this.hVp.layout((int) this.hVp.getViewLeft(), (int) this.hVp.getViewTop(), (int) this.hVp.getViewRight(), (int) this.hVp.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.hVG == null || !this.hVG.isRunning()) {
            if (this.hVF == null || !this.hVF.isRunning()) {
                int action = motionEvent.getAction();
                Y(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.hVF != null) {
                        this.hVF.removeAllUpdateListeners();
                        this.hVF.cancel();
                    }
                    this.hVK = motionEvent.getPointerId(0);
                    this.hVA = x;
                    this.hVB = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.hVA - x;
                    float f2 = this.hVB - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.hVH = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.hVH) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.hVC * f3;
                    if (this.hVH) {
                        b(this.hVm, f3, f4);
                        b(this.hVn, f3, f4);
                        b(this.hVo, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.WO);
                    float xVelocity = velocityTracker.getXVelocity(this.hVK);
                    if (this.hVH || this.mDistance != 0.0f) {
                        as(xVelocity);
                    }
                    this.hVH = false;
                    releaseVelocityTracker();
                }
                if (this.hVH || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.hVl.size() > 2) {
                if (cellForumTestView.getViewRight() < this.hVz[0].right - (this.hVs / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.hVz[0].right - (this.hVs / 2))) + this.hVz[2].left + (this.hVs / 2) + this.hVy);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.hVs);
                    cellForumTestView.setViewTop(this.hVz[2].top);
                    cellForumTestView.setViewBottom(this.hVz[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hVl.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.hVz[2].left + (this.hVs / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.hVz[2].left + (this.hVs / 2))) + ((this.hVz[0].right - (this.hVs / 2)) - this.hVy));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.hVs);
                    cellForumTestView.setViewTop(this.hVz[0].top);
                    cellForumTestView.setViewBottom(this.hVz[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hVl.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.hVz[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.hVz[0].top) {
                    cellForumTestView.setViewTop(this.hVz[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.hVz[0].bottom) {
                    cellForumTestView.setViewBottom(this.hVz[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.hVz[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.hVz[1].top) {
                    cellForumTestView.setViewTop(this.hVz[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.hVz[1].bottom) {
                    cellForumTestView.setViewBottom(this.hVz[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.hVL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ou(boolean z) {
        if (this.hVL != null) {
            int i = -1;
            if (this.hVm.getIndex() == 1 && this.hVm.getData() != null) {
                this.hVL.fc(this.hVm.getData().testId);
                i = this.hVm.getDataIndex();
            } else if (this.hVn.getIndex() == 1 && this.hVn.getData() != null) {
                this.hVL.fc(this.hVn.getData().testId);
                i = this.hVn.getDataIndex();
            } else if (this.hVo.getIndex() == 1 && this.hVo.getData() != null) {
                this.hVL.fc(this.hVo.getData().testId);
                i = this.hVo.getDataIndex();
            } else {
                this.hVL.fc(-1L);
            }
            if (z) {
                xo(i);
            }
        }
    }

    private void initAnimation() {
        this.hVF = ValueAnimator.ofFloat(this.hVs, 0.0f);
        this.hVF.setDuration(200L);
        this.hVF.setInterpolator(new DecelerateInterpolator());
        this.hVF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.hVs) * 0.2f;
                    if (ForumTestView.this.hVM) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cnc();
                        } else {
                            ForumTestView.this.cnd();
                        }
                        ForumTestView.this.hVM = false;
                    }
                    ForumTestView.this.hVN = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.hVm);
                    ForumTestView.this.d(ForumTestView.this.hVn);
                    ForumTestView.this.d(ForumTestView.this.hVo);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.ou(z);
                } else {
                    if (ForumTestView.this.hVM) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.xm(2) != null && ForumTestView.this.xm(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cnc();
                                ForumTestView.this.hVM = false;
                            }
                        } else if (ForumTestView.this.xm(0) != null && ForumTestView.this.xm(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cnd();
                            ForumTestView.this.hVM = false;
                        }
                    }
                    float f = ForumTestView.this.hVN - floatValue;
                    float f2 = ForumTestView.this.hVC * f;
                    ForumTestView.this.b(ForumTestView.this.hVm, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hVn, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hVo, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.hVN = floatValue;
            }
        });
    }

    private void as(float f) {
        CellForumTestView xm;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.hVM = false;
        this.hVN = 0.0f;
        initAnimation();
        if (this.hVl.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.hVm.getVisibility() == 0) {
                cellForumTestView3 = this.hVm;
            }
            if (this.hVn.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.hVn;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.hVn;
            }
            if (this.hVo.getVisibility() == 0) {
                cellForumTestView2 = this.hVo;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.hVz[0].left) || viewRight > ((float) this.hVz[2].right)) && Math.abs(this.mDistance) >= this.hVs * 0.2f) {
                this.hVM = true;
            }
        } else if (this.hVl.size() > 2 && Math.abs(this.mDistance) >= this.hVs * 0.2f) {
            this.hVM = true;
        }
        if (this.hVM && (xm = xm(1)) != null) {
            if (this.mDistance >= this.hVs) {
                this.mDistance -= this.hVs;
                this.hVM = false;
                cnd();
            } else if (this.mDistance > 0.0f && this.mDistance < this.hVs) {
                this.mDistance = this.hVz[0].right - xm.getViewRight();
            } else if (this.mDistance > (-this.hVs)) {
                this.mDistance = this.hVz[2].left - xm.getViewLeft();
            } else {
                cnc();
                this.mDistance += this.hVs;
                this.hVM = false;
            }
        }
        this.hVF.setFloatValues(0.0f, this.mDistance);
        this.hVF.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnc() {
        this.hVm.setIndex(this.hVm.getIndex() + 1);
        this.hVn.setIndex(this.hVn.getIndex() + 1);
        this.hVo.setIndex(this.hVo.getIndex() + 1);
        b(this.hVm);
        b(this.hVn);
        b(this.hVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnd() {
        this.hVm.setIndex(this.hVm.getIndex() - 1);
        this.hVn.setIndex(this.hVn.getIndex() - 1);
        this.hVo.setIndex(this.hVo.getIndex() - 1);
        b(this.hVm);
        b(this.hVn);
        b(this.hVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView xm(int i) {
        if (this.hVm.getIndex() == i) {
            return this.hVm;
        }
        if (this.hVn.getIndex() == i) {
            return this.hVn;
        }
        if (this.hVo.getIndex() == i) {
            return this.hVo;
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
            int size = this.hVl.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int xn(int i) {
        int size = this.hVl.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.hVz[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.hVz[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.hVz[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.hVz[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.hVH && this.mDistance == 0.0f) {
            this.hVl = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.hVm.setVisibility(0);
                this.hVn.setVisibility(0);
                this.hVo.setVisibility(0);
                this.hVm.setData(list.get(0));
                this.hVn.setData(list.get(1));
                this.hVo.setData(list.get(2));
                this.hVm.setDataIndex(0);
                this.hVn.setDataIndex(1);
                this.hVo.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.hVm.setVisibility(8);
                this.hVn.setVisibility(0);
                this.hVo.setVisibility(0);
                this.hVn.setDataIndex(1);
                this.hVo.setDataIndex(0);
                this.hVn.setData(list.get(1));
                this.hVo.setData(list.get(0));
                i = 1;
            } else {
                this.hVm.setVisibility(8);
                this.hVn.setVisibility(0);
                this.hVo.setVisibility(8);
                this.hVn.setDataIndex(0);
                this.hVn.setData(list.get(0));
                i = 0;
            }
            xo(i);
        }
    }

    private void resetData() {
        this.hVm.setIndex(0);
        this.hVn.setIndex(1);
        this.hVo.setIndex(2);
        this.hVp.setIndex(1);
        d(this.hVm);
        d(this.hVn);
        d(this.hVo);
        d(this.hVp);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void xl(int i) {
        CellForumTestView cellForumTestView;
        this.hVI = true;
        this.hVp.setVisibility(0);
        this.hVp.setAlpha(1.0f);
        cne();
        if (this.hVm.getIndex() == i && this.hVm.getVisibility() == 0) {
            cellForumTestView = this.hVm;
        } else if (this.hVn.getIndex() == i && this.hVn.getVisibility() == 0) {
            cellForumTestView = this.hVn;
        } else {
            cellForumTestView = this.hVo;
        }
        this.hVp.setData(cellForumTestView.getData());
        this.hVp.setDataIndex(cellForumTestView.getDataIndex());
        this.hVr = null;
        if (this.hVl.size() == 1) {
            this.hVJ = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.hVs * 3) / 5;
        } else if (this.hVl.size() == 2) {
            this.hVJ = 2;
            cellForumTestView.setVisibility(8);
            if (this.hVm.getVisibility() == 0) {
                this.hVq = this.hVm;
            } else if (this.hVn.getVisibility() == 0) {
                this.hVq = this.hVn;
            } else {
                this.hVq = this.hVo;
            }
            if (this.hVq.getViewRight() < this.hVz[1].left) {
                this.mDistance = this.hVs + this.hVy;
                this.hVq.setIndex(this.hVq.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.hVq.getViewLeft() > this.hVz[1].right) {
                this.mDistance = (-this.hVs) - this.hVy;
                this.hVq.setIndex(this.hVq.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.hVq);
            b(cellForumTestView);
        } else if (this.hVl.size() == 3) {
            this.hVJ = 3;
            cellForumTestView.setVisibility(8);
            if (this.hVm.getIndex() == 2) {
                this.hVq = this.hVm;
            } else if (this.hVn.getIndex() == 2) {
                this.hVq = this.hVn;
            } else {
                this.hVq = this.hVo;
            }
            this.mDistance = (-this.hVs) - this.hVy;
            this.hVq.setIndex(this.hVq.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.hVq);
            b(cellForumTestView);
        } else {
            this.hVJ = 4;
            this.hVr = cellForumTestView;
            if (this.hVm.getIndex() == 2) {
                this.hVq = this.hVm;
            } else if (this.hVn.getIndex() == 2) {
                this.hVq = this.hVn;
            } else {
                this.hVq = this.hVo;
            }
            this.mDistance = (-this.hVs) - this.hVy;
            this.hVq.setIndex(this.hVq.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.hVq);
            b(cellForumTestView);
            this.hVr.setViewLeft(this.hVz[2].right + this.hVy);
            this.hVr.setViewRight(this.hVz[2].right + this.hVy + this.hVs);
            this.hVr.setViewTop(this.hVz[2].top);
            this.hVr.setViewBottom(this.hVz[2].bottom);
            this.hVr.setMoveLeft(this.hVz[2].right + this.hVy);
            this.hVr.setMoveRight(this.hVz[2].right + this.hVy + this.hVs);
            this.hVr.setMoveTop(this.hVz[2].top);
            this.hVr.setMoveBottom(this.hVz[2].bottom);
            this.hVr.setData(this.hVl.get(xn(this.hVr.getDataIndex() + 2)));
        }
        this.hVG.setFloatValues(0.0f, this.mDistance);
        this.hVG.start();
    }

    private void cne() {
        this.hVm.setMoveLeft(this.hVm.getViewLeft());
        this.hVm.setMoveTop(this.hVm.getViewTop());
        this.hVm.setMoveRight(this.hVm.getViewRight());
        this.hVm.setMoveBottom(this.hVm.getViewBottom());
        this.hVn.setMoveLeft(this.hVn.getViewLeft());
        this.hVn.setMoveTop(this.hVn.getViewTop());
        this.hVn.setMoveRight(this.hVn.getViewRight());
        this.hVn.setMoveBottom(this.hVn.getViewBottom());
        this.hVo.setMoveLeft(this.hVo.getViewLeft());
        this.hVo.setMoveTop(this.hVo.getViewTop());
        this.hVo.setMoveRight(this.hVo.getViewRight());
        this.hVo.setMoveBottom(this.hVo.getViewBottom());
        this.hVp.setMoveLeft(this.hVp.getViewLeft());
        this.hVp.setMoveTop(this.hVp.getViewTop());
        this.hVp.setMoveRight(this.hVp.getViewRight());
        this.hVp.setMoveBottom(this.hVp.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.hVm.onChangeSkinType();
            this.hVn.onChangeSkinType();
            this.hVo.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.hVH && this.mDistance == 0.0f) {
            if (this.hVF != null) {
                this.hVF.removeAllUpdateListeners();
                this.hVF.cancel();
            }
            if (this.hVG != null) {
                this.hVG.removeAllUpdateListeners();
                this.hVG.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.hVm != null) {
            this.hVm.setPageId(bdUniqueId);
        }
        if (this.hVn != null) {
            this.hVn.setPageId(bdUniqueId);
        }
        if (this.hVo != null) {
            this.hVo.setPageId(bdUniqueId);
        }
    }

    public void xo(int i) {
        f fVar;
        aq a2;
        if (this.hVl != null && i >= 0 && i < this.hVl.size() && (fVar = this.hVl.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dDn().a(this.mPageId, com.baidu.tieba.s.a.RO("" + fVar.testId), a2);
        }
    }
}
