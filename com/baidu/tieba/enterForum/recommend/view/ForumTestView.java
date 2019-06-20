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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int NG;
    private List<f> eUU;
    private CellForumTestView eUV;
    private CellForumTestView eUW;
    private CellForumTestView eUX;
    private CellForumTestView eUY;
    private CellForumTestView eUZ;
    private CellForumTestView eVa;
    private int eVb;
    private int eVc;
    private int eVd;
    private int eVe;
    private int eVf;
    private int eVg;
    private int eVh;
    private Rect[] eVi;
    private float eVj;
    private float eVk;
    private float eVl;
    private float eVm;
    private float eVn;
    private ValueAnimator eVo;
    private float eVp;
    private ValueAnimator eVq;
    private boolean eVr;
    private boolean eVs;
    private int eVt;
    private int eVu;
    private a eVv;
    private boolean eVw;
    private float eVx;
    private int eVy;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void cW(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.eVi = new Rect[3];
        this.eVr = false;
        this.eVs = false;
        this.eVw = false;
        this.eVx = 0.0f;
        this.eVy = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eVi = new Rect[3];
        this.eVr = false;
        this.eVs = false;
        this.eVw = false;
        this.eVx = 0.0f;
        this.eVy = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eVi = new Rect[3];
        this.eVr = false;
        this.eVs = false;
        this.eVw = false;
        this.eVx = 0.0f;
        this.eVy = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.eUV = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.eUW = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.eUX = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.eUY = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        dC(context);
        resetData();
        ViewConfiguration.get(context);
        this.NG = ViewConfiguration.getMaximumFlingVelocity();
        this.eUV.setForumTestDelClickListener(this);
        this.eUW.setForumTestDelClickListener(this);
        this.eUX.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void dC(Context context) {
        this.eVf = l.g(context, R.dimen.tbds44);
        this.eVg = l.g(context, R.dimen.tbds30);
        this.eVh = l.g(context, R.dimen.tbds7);
        this.eVe = l.g(context, R.dimen.tbds730);
        this.eVd = this.eVe - (this.eVg * 2);
        this.mWidth = l.af(getContext());
        this.eVb = (int) (this.mWidth * 0.89f);
        this.mHeight = this.eVe + this.eVf;
        this.eVc = ((this.mWidth - this.eVb) - (this.eVh * 2)) / 2;
        this.eVl = this.eVg / (this.eVb + this.eVh);
        this.eVm = this.eVe / this.eVb;
        this.eVn = this.eVb / (this.eVb + this.eVh);
        this.eVi[0] = new Rect(this.eVc - this.eVb, this.eVf + this.eVg, this.eVc, this.eVf + this.eVg + this.eVd);
        this.eVi[1] = new Rect(this.eVc + this.eVh, this.eVf, this.eVc + this.eVh + this.eVb, this.eVf + this.eVe);
        this.eVi[2] = new Rect(this.mWidth - this.eVc, this.eVf + this.eVg, (this.mWidth - this.eVc) + this.eVb, this.eVf + this.eVg + this.eVd);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eVq = ValueAnimator.ofFloat(this.eVb, 0.0f);
        this.eVq.setDuration(500L);
        this.eVq.setInterpolator(new DecelerateInterpolator());
        this.eVq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.eVt != 1) {
                    if (ForumTestView.this.eVt == 2 || ForumTestView.this.eVt == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.eVl * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.eVm;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eVp)) {
                            ForumTestView.this.eUY.setAlpha(0.0f);
                            ForumTestView.this.eUY.setVisibility(8);
                            ForumTestView.this.eVp = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.eUZ);
                            ForumTestView.this.d(ForumTestView.this.eUY);
                            ForumTestView.this.eUU.remove(ForumTestView.this.eUY.getData());
                            ForumTestView.this.ji(true);
                            ForumTestView.this.eVs = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.eUZ, floatValue, abs);
                            if ((ForumTestView.this.eVb * 2) / 5 >= ForumTestView.this.eUY.getViewRight() - ForumTestView.this.eUY.getViewLeft()) {
                                ForumTestView.this.eUY.setAlpha(0.0f);
                                ForumTestView.this.eUY.setVisibility(8);
                            } else {
                                ForumTestView.this.eUY.setViewLeft(ForumTestView.this.eUY.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eUY.setViewRight(ForumTestView.this.eUY.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eUY.setViewTop(ForumTestView.this.eUY.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.eUY.setViewBottom(ForumTestView.this.eUY.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.eUY.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.eVb * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.eVl * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.eVm;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.eVp)) {
                        ForumTestView.this.eUY.setAlpha(0.0f);
                        ForumTestView.this.eUY.setVisibility(8);
                        ForumTestView.this.eVp = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.eUZ);
                        ForumTestView.this.d(ForumTestView.this.eUY);
                        ForumTestView.this.d(ForumTestView.this.eVa);
                        ForumTestView.this.eUU.remove(ForumTestView.this.eUY.getData());
                        if (ForumTestView.this.eUV.getIndex() == 0) {
                            if (ForumTestView.this.eUV.getDataIndex() > ForumTestView.this.eVa.getDataIndex()) {
                                ForumTestView.this.eUV.setDataIndex(ForumTestView.this.eUV.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eUV);
                            }
                        } else if (ForumTestView.this.eUW.getIndex() == 0) {
                            if (ForumTestView.this.eUW.getDataIndex() > ForumTestView.this.eVa.getDataIndex()) {
                                ForumTestView.this.eUW.setDataIndex(ForumTestView.this.eUW.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eUW);
                            }
                        } else if (ForumTestView.this.eUX.getDataIndex() > ForumTestView.this.eVa.getDataIndex()) {
                            ForumTestView.this.eUX.setDataIndex(ForumTestView.this.eUX.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eUX);
                        }
                        if (ForumTestView.this.eUZ.getDataIndex() > ForumTestView.this.eVa.getDataIndex()) {
                            ForumTestView.this.eUZ.setDataIndex(ForumTestView.this.eUZ.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eUZ);
                        }
                        ForumTestView.this.eVa.setDataIndex(ForumTestView.this.eVa.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.eVa);
                        ForumTestView.this.ji(true);
                        ForumTestView.this.eVs = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.eUZ, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.eVa, floatValue2);
                        if ((ForumTestView.this.eVb * 2) / 5 >= ForumTestView.this.eUY.getViewRight() - ForumTestView.this.eUY.getViewLeft()) {
                            ForumTestView.this.eUY.setAlpha(0.0f);
                            ForumTestView.this.eUY.setVisibility(8);
                        } else {
                            ForumTestView.this.eUY.setViewLeft(ForumTestView.this.eUY.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eUY.setViewRight(ForumTestView.this.eUY.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eUY.setViewTop(ForumTestView.this.eUY.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.eUY.setViewBottom(ForumTestView.this.eUY.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.eUY.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.eVb * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.eVm * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.eVp / 2.0f)) {
                    ForumTestView.this.eUY.setAlpha(0.0f);
                    ForumTestView.this.eUY.setVisibility(8);
                    ForumTestView.this.eVp = 0.0f;
                    ForumTestView.this.eUU.remove(ForumTestView.this.eUY.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.eVv != null) {
                        ForumTestView.this.eVv.cW(-1L);
                    }
                    ForumTestView.this.eVs = false;
                } else {
                    ForumTestView.this.eUY.setViewLeft(ForumTestView.this.eUY.getMoveLeft() + floatValue3);
                    ForumTestView.this.eUY.setViewRight(ForumTestView.this.eUY.getMoveRight() - floatValue3);
                    ForumTestView.this.eUY.setViewTop(ForumTestView.this.eUY.getMoveTop() + f);
                    ForumTestView.this.eUY.setViewBottom(ForumTestView.this.eUY.getMoveBottom() - f);
                    ForumTestView.this.eUY.setAlpha(1.0f - (floatValue3 / ForumTestView.this.eVp));
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
            if (af != this.eVy) {
                this.eVy = af;
                dC(getContext());
                d(this.eUV);
                d(this.eUW);
                d(this.eUX);
                d(this.eUY);
            }
            a(this.eUV);
            a(this.eUW);
            a(this.eUX);
            a(this.eUY);
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
            this.eUV.layout((int) this.eUV.getViewLeft(), (int) this.eUV.getViewTop(), (int) this.eUV.getViewRight(), (int) this.eUV.getViewBottom());
            this.eUW.layout((int) this.eUW.getViewLeft(), (int) this.eUW.getViewTop(), (int) this.eUW.getViewRight(), (int) this.eUW.getViewBottom());
            this.eUX.layout((int) this.eUX.getViewLeft(), (int) this.eUX.getViewTop(), (int) this.eUX.getViewRight(), (int) this.eUX.getViewBottom());
            this.eUY.layout((int) this.eUY.getViewLeft(), (int) this.eUY.getViewTop(), (int) this.eUY.getViewRight(), (int) this.eUY.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.eVq == null || !this.eVq.isRunning()) {
            if (this.eVo == null || !this.eVo.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.eVo != null) {
                        this.eVo.removeAllUpdateListeners();
                        this.eVo.cancel();
                    }
                    this.eVu = motionEvent.getPointerId(0);
                    this.eVj = x;
                    this.eVk = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.eVj - x;
                    float f2 = this.eVk - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.eVr = true;
                        this.eVp = f;
                    } else if (Math.abs(f2) > 30.0f && !this.eVr) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.eVl * f3;
                    if (this.eVr) {
                        b(this.eUV, f3, f4);
                        b(this.eUW, f3, f4);
                        b(this.eUX, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.NG);
                    float xVelocity = velocityTracker.getXVelocity(this.eVu);
                    if (this.eVr || this.eVp != 0.0f) {
                        aE(xVelocity);
                    }
                    this.eVr = false;
                    releaseVelocityTracker();
                }
                if (this.eVr || this.eVp != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.eUU.size() > 2) {
                if (cellForumTestView.getViewRight() < this.eVi[0].right - (this.eVb / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.eVi[0].right - (this.eVb / 2))) + this.eVi[2].left + (this.eVb / 2) + this.eVh);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.eVb);
                    cellForumTestView.setViewTop(this.eVi[2].top);
                    cellForumTestView.setViewBottom(this.eVi[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eUU.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.eVi[2].left + (this.eVb / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.eVi[2].left + (this.eVb / 2))) + ((this.eVi[0].right - (this.eVb / 2)) - this.eVh));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.eVb);
                    cellForumTestView.setViewTop(this.eVi[0].top);
                    cellForumTestView.setViewBottom(this.eVi[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eUU.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.eVi[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.eVi[0].top) {
                    cellForumTestView.setViewTop(this.eVi[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.eVi[0].bottom) {
                    cellForumTestView.setViewBottom(this.eVi[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.eVi[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.eVi[1].top) {
                    cellForumTestView.setViewTop(this.eVi[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.eVi[1].bottom) {
                    cellForumTestView.setViewBottom(this.eVi[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.eVv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji(boolean z) {
        if (this.eVv != null) {
            int i = -1;
            if (this.eUV.getIndex() == 1 && this.eUV.getData() != null) {
                this.eVv.cW(this.eUV.getData().testId);
                i = this.eUV.getDataIndex();
            } else if (this.eUW.getIndex() == 1 && this.eUW.getData() != null) {
                this.eVv.cW(this.eUW.getData().testId);
                i = this.eUW.getDataIndex();
            } else if (this.eUX.getIndex() == 1 && this.eUX.getData() != null) {
                this.eVv.cW(this.eUX.getData().testId);
                i = this.eUX.getDataIndex();
            } else {
                this.eVv.cW(-1L);
            }
            if (z) {
                qo(i);
            }
        }
    }

    private void Ti() {
        this.eVo = ValueAnimator.ofFloat(this.eVb, 0.0f);
        this.eVo.setDuration(200L);
        this.eVo.setInterpolator(new DecelerateInterpolator());
        this.eVo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eVp)) {
                    boolean z = Math.abs(ForumTestView.this.eVp) >= ((float) ForumTestView.this.eVb) * 0.2f;
                    if (ForumTestView.this.eVw) {
                        if (ForumTestView.this.eVp > 0.0f) {
                            ForumTestView.this.bez();
                        } else {
                            ForumTestView.this.beA();
                        }
                        ForumTestView.this.eVw = false;
                    }
                    ForumTestView.this.eVx = 0.0f;
                    ForumTestView.this.eVp = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.eUV);
                    ForumTestView.this.d(ForumTestView.this.eUW);
                    ForumTestView.this.d(ForumTestView.this.eUX);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.ji(z);
                } else {
                    if (ForumTestView.this.eVw) {
                        if (ForumTestView.this.eVp > 0.0f) {
                            if (ForumTestView.this.qm(2) != null && ForumTestView.this.qm(2).getViewLeft() >= l.af(ForumTestView.this.getContext())) {
                                ForumTestView.this.bez();
                                ForumTestView.this.eVw = false;
                            }
                        } else if (ForumTestView.this.qm(0) != null && ForumTestView.this.qm(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.beA();
                            ForumTestView.this.eVw = false;
                        }
                    }
                    float f = ForumTestView.this.eVx - floatValue;
                    float f2 = ForumTestView.this.eVl * f;
                    ForumTestView.this.b(ForumTestView.this.eUV, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eUW, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eUX, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.eVx = floatValue;
            }
        });
    }

    private void aE(float f) {
        CellForumTestView qm;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.eVw = false;
        this.eVx = 0.0f;
        Ti();
        if (this.eUU.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.eUV.getVisibility() == 0) {
                cellForumTestView3 = this.eUV;
            }
            if (this.eUW.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.eUW;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.eUW;
            }
            if (this.eUX.getVisibility() == 0) {
                cellForumTestView2 = this.eUX;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.eVi[0].left) || viewRight > ((float) this.eVi[2].right)) && Math.abs(this.eVp) >= this.eVb * 0.2f) {
                this.eVw = true;
            }
        } else if (this.eUU.size() > 2 && Math.abs(this.eVp) >= this.eVb * 0.2f) {
            this.eVw = true;
        }
        if (this.eVw && (qm = qm(1)) != null) {
            if (this.eVp >= this.eVb) {
                this.eVp -= this.eVb;
                this.eVw = false;
                beA();
            } else if (this.eVp > 0.0f && this.eVp < this.eVb) {
                this.eVp = this.eVi[0].right - qm.getViewRight();
            } else if (this.eVp > (-this.eVb)) {
                this.eVp = this.eVi[2].left - qm.getViewLeft();
            } else {
                bez();
                this.eVp += this.eVb;
                this.eVw = false;
            }
        }
        this.eVo.setFloatValues(0.0f, this.eVp);
        this.eVo.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bez() {
        this.eUV.setIndex(this.eUV.getIndex() + 1);
        this.eUW.setIndex(this.eUW.getIndex() + 1);
        this.eUX.setIndex(this.eUX.getIndex() + 1);
        b(this.eUV);
        b(this.eUW);
        b(this.eUX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beA() {
        this.eUV.setIndex(this.eUV.getIndex() - 1);
        this.eUW.setIndex(this.eUW.getIndex() - 1);
        this.eUX.setIndex(this.eUX.getIndex() - 1);
        b(this.eUV);
        b(this.eUW);
        b(this.eUX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView qm(int i) {
        if (this.eUV.getIndex() == i) {
            return this.eUV;
        }
        if (this.eUW.getIndex() == i) {
            return this.eUW;
        }
        if (this.eUX.getIndex() == i) {
            return this.eUX;
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
            int size = this.eUU.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int qn(int i) {
        int size = this.eUU.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.eVi[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.eVi[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.eVi[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.eVi[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.aa(list) && !this.eVr && this.eVp == 0.0f) {
            this.eUU = list;
            resetData();
            if (v.Z(list) > 2) {
                this.eUV.setVisibility(0);
                this.eUW.setVisibility(0);
                this.eUX.setVisibility(0);
                this.eUV.setData(list.get(0));
                this.eUW.setData(list.get(1));
                this.eUX.setData(list.get(2));
                this.eUV.setDataIndex(0);
                this.eUW.setDataIndex(1);
                this.eUX.setDataIndex(2);
                i = 1;
            } else if (v.Z(list) == 2) {
                this.eUV.setVisibility(8);
                this.eUW.setVisibility(0);
                this.eUX.setVisibility(0);
                this.eUW.setDataIndex(1);
                this.eUX.setDataIndex(0);
                this.eUW.setData(list.get(1));
                this.eUX.setData(list.get(0));
                i = 1;
            } else {
                this.eUV.setVisibility(8);
                this.eUW.setVisibility(0);
                this.eUX.setVisibility(8);
                this.eUW.setDataIndex(0);
                this.eUW.setData(list.get(0));
                i = 0;
            }
            qo(i);
        }
    }

    private void resetData() {
        this.eUV.setIndex(0);
        this.eUW.setIndex(1);
        this.eUX.setIndex(2);
        this.eUY.setIndex(1);
        d(this.eUV);
        d(this.eUW);
        d(this.eUX);
        d(this.eUY);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void ql(int i) {
        CellForumTestView cellForumTestView;
        this.eVs = true;
        this.eUY.setVisibility(0);
        this.eUY.setAlpha(1.0f);
        beB();
        if (this.eUV.getIndex() == i && this.eUV.getVisibility() == 0) {
            cellForumTestView = this.eUV;
        } else if (this.eUW.getIndex() == i && this.eUW.getVisibility() == 0) {
            cellForumTestView = this.eUW;
        } else {
            cellForumTestView = this.eUX;
        }
        this.eUY.setData(cellForumTestView.getData());
        this.eUY.setDataIndex(cellForumTestView.getDataIndex());
        this.eVa = null;
        if (this.eUU.size() == 1) {
            this.eVt = 1;
            cellForumTestView.setVisibility(8);
            this.eVp = (this.eVb * 3) / 5;
        } else if (this.eUU.size() == 2) {
            this.eVt = 2;
            cellForumTestView.setVisibility(8);
            if (this.eUV.getVisibility() == 0) {
                this.eUZ = this.eUV;
            } else if (this.eUW.getVisibility() == 0) {
                this.eUZ = this.eUW;
            } else {
                this.eUZ = this.eUX;
            }
            if (this.eUZ.getViewRight() < this.eVi[1].left) {
                this.eVp = this.eVb + this.eVh;
                this.eUZ.setIndex(this.eUZ.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.eUZ.getViewLeft() > this.eVi[1].right) {
                this.eVp = (-this.eVb) - this.eVh;
                this.eUZ.setIndex(this.eUZ.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.eUZ);
            b(cellForumTestView);
        } else if (this.eUU.size() == 3) {
            this.eVt = 3;
            cellForumTestView.setVisibility(8);
            if (this.eUV.getIndex() == 2) {
                this.eUZ = this.eUV;
            } else if (this.eUW.getIndex() == 2) {
                this.eUZ = this.eUW;
            } else {
                this.eUZ = this.eUX;
            }
            this.eVp = (-this.eVb) - this.eVh;
            this.eUZ.setIndex(this.eUZ.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.eUZ);
            b(cellForumTestView);
        } else {
            this.eVt = 4;
            this.eVa = cellForumTestView;
            if (this.eUV.getIndex() == 2) {
                this.eUZ = this.eUV;
            } else if (this.eUW.getIndex() == 2) {
                this.eUZ = this.eUW;
            } else {
                this.eUZ = this.eUX;
            }
            this.eVp = (-this.eVb) - this.eVh;
            this.eUZ.setIndex(this.eUZ.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.eUZ);
            b(cellForumTestView);
            this.eVa.setViewLeft(this.eVi[2].right + this.eVh);
            this.eVa.setViewRight(this.eVi[2].right + this.eVh + this.eVb);
            this.eVa.setViewTop(this.eVi[2].top);
            this.eVa.setViewBottom(this.eVi[2].bottom);
            this.eVa.setMoveLeft(this.eVi[2].right + this.eVh);
            this.eVa.setMoveRight(this.eVi[2].right + this.eVh + this.eVb);
            this.eVa.setMoveTop(this.eVi[2].top);
            this.eVa.setMoveBottom(this.eVi[2].bottom);
            this.eVa.setData(this.eUU.get(qn(this.eVa.getDataIndex() + 2)));
        }
        this.eVq.setFloatValues(0.0f, this.eVp);
        this.eVq.start();
    }

    private void beB() {
        this.eUV.setMoveLeft(this.eUV.getViewLeft());
        this.eUV.setMoveTop(this.eUV.getViewTop());
        this.eUV.setMoveRight(this.eUV.getViewRight());
        this.eUV.setMoveBottom(this.eUV.getViewBottom());
        this.eUW.setMoveLeft(this.eUW.getViewLeft());
        this.eUW.setMoveTop(this.eUW.getViewTop());
        this.eUW.setMoveRight(this.eUW.getViewRight());
        this.eUW.setMoveBottom(this.eUW.getViewBottom());
        this.eUX.setMoveLeft(this.eUX.getViewLeft());
        this.eUX.setMoveTop(this.eUX.getViewTop());
        this.eUX.setMoveRight(this.eUX.getViewRight());
        this.eUX.setMoveBottom(this.eUX.getViewBottom());
        this.eUY.setMoveLeft(this.eUY.getViewLeft());
        this.eUY.setMoveTop(this.eUY.getViewTop());
        this.eUY.setMoveRight(this.eUY.getViewRight());
        this.eUY.setMoveBottom(this.eUY.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, R.color.cp_bg_line_c);
            this.eUV.onChangeSkinType();
            this.eUW.onChangeSkinType();
            this.eUX.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.eVr && this.eVp == 0.0f) {
            if (this.eVo != null) {
                this.eVo.removeAllUpdateListeners();
                this.eVo.cancel();
            }
            if (this.eVq != null) {
                this.eVq.removeAllUpdateListeners();
                this.eVq.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.eUV != null) {
            this.eUV.setPageId(bdUniqueId);
        }
        if (this.eUW != null) {
            this.eUW.setPageId(bdUniqueId);
        }
        if (this.eUX != null) {
            this.eUX.setPageId(bdUniqueId);
        }
    }

    public void qo(int i) {
        f fVar;
        am a2;
        if (this.eUU != null && i >= 0 && i < this.eUU.size() && (fVar = this.eUU.get(i)) != null && (a2 = com.baidu.tieba.q.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.q.c.clw().a(this.mPageId, "enterfourm_rec_" + fVar.testId, a2);
        }
    }
}
