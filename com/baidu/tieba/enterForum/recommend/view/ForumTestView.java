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
    private int NH;
    private List<f> eUT;
    private CellForumTestView eUU;
    private CellForumTestView eUV;
    private CellForumTestView eUW;
    private CellForumTestView eUX;
    private CellForumTestView eUY;
    private CellForumTestView eUZ;
    private int eVa;
    private int eVb;
    private int eVc;
    private int eVd;
    private int eVe;
    private int eVf;
    private int eVg;
    private Rect[] eVh;
    private float eVi;
    private float eVj;
    private float eVk;
    private float eVl;
    private float eVm;
    private ValueAnimator eVn;
    private float eVo;
    private ValueAnimator eVp;
    private boolean eVq;
    private boolean eVr;
    private int eVs;
    private int eVt;
    private a eVu;
    private boolean eVv;
    private float eVw;
    private int eVx;
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
        this.eVh = new Rect[3];
        this.eVq = false;
        this.eVr = false;
        this.eVv = false;
        this.eVw = 0.0f;
        this.eVx = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.eVh = new Rect[3];
        this.eVq = false;
        this.eVr = false;
        this.eVv = false;
        this.eVw = 0.0f;
        this.eVx = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.eVh = new Rect[3];
        this.eVq = false;
        this.eVr = false;
        this.eVv = false;
        this.eVw = 0.0f;
        this.eVx = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.eUU = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.eUV = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.eUW = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.eUX = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        dC(context);
        resetData();
        ViewConfiguration.get(context);
        this.NH = ViewConfiguration.getMaximumFlingVelocity();
        this.eUU.setForumTestDelClickListener(this);
        this.eUV.setForumTestDelClickListener(this);
        this.eUW.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void dC(Context context) {
        this.eVe = l.g(context, R.dimen.tbds44);
        this.eVf = l.g(context, R.dimen.tbds30);
        this.eVg = l.g(context, R.dimen.tbds7);
        this.eVd = l.g(context, R.dimen.tbds730);
        this.eVc = this.eVd - (this.eVf * 2);
        this.mWidth = l.af(getContext());
        this.eVa = (int) (this.mWidth * 0.89f);
        this.mHeight = this.eVd + this.eVe;
        this.eVb = ((this.mWidth - this.eVa) - (this.eVg * 2)) / 2;
        this.eVk = this.eVf / (this.eVa + this.eVg);
        this.eVl = this.eVd / this.eVa;
        this.eVm = this.eVa / (this.eVa + this.eVg);
        this.eVh[0] = new Rect(this.eVb - this.eVa, this.eVe + this.eVf, this.eVb, this.eVe + this.eVf + this.eVc);
        this.eVh[1] = new Rect(this.eVb + this.eVg, this.eVe, this.eVb + this.eVg + this.eVa, this.eVe + this.eVd);
        this.eVh[2] = new Rect(this.mWidth - this.eVb, this.eVe + this.eVf, (this.mWidth - this.eVb) + this.eVa, this.eVe + this.eVf + this.eVc);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.eVp = ValueAnimator.ofFloat(this.eVa, 0.0f);
        this.eVp.setDuration(500L);
        this.eVp.setInterpolator(new DecelerateInterpolator());
        this.eVp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.eVs != 1) {
                    if (ForumTestView.this.eVs == 2 || ForumTestView.this.eVs == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.eVk * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.eVl;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eVo)) {
                            ForumTestView.this.eUX.setAlpha(0.0f);
                            ForumTestView.this.eUX.setVisibility(8);
                            ForumTestView.this.eVo = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.eUY);
                            ForumTestView.this.d(ForumTestView.this.eUX);
                            ForumTestView.this.eUT.remove(ForumTestView.this.eUX.getData());
                            ForumTestView.this.ji(true);
                            ForumTestView.this.eVr = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.eUY, floatValue, abs);
                            if ((ForumTestView.this.eVa * 2) / 5 >= ForumTestView.this.eUX.getViewRight() - ForumTestView.this.eUX.getViewLeft()) {
                                ForumTestView.this.eUX.setAlpha(0.0f);
                                ForumTestView.this.eUX.setVisibility(8);
                            } else {
                                ForumTestView.this.eUX.setViewLeft(ForumTestView.this.eUX.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eUX.setViewRight(ForumTestView.this.eUX.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eUX.setViewTop(ForumTestView.this.eUX.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.eUX.setViewBottom(ForumTestView.this.eUX.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.eUX.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.eVa * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.eVk * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.eVl;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.eVo)) {
                        ForumTestView.this.eUX.setAlpha(0.0f);
                        ForumTestView.this.eUX.setVisibility(8);
                        ForumTestView.this.eVo = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.eUY);
                        ForumTestView.this.d(ForumTestView.this.eUX);
                        ForumTestView.this.d(ForumTestView.this.eUZ);
                        ForumTestView.this.eUT.remove(ForumTestView.this.eUX.getData());
                        if (ForumTestView.this.eUU.getIndex() == 0) {
                            if (ForumTestView.this.eUU.getDataIndex() > ForumTestView.this.eUZ.getDataIndex()) {
                                ForumTestView.this.eUU.setDataIndex(ForumTestView.this.eUU.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eUU);
                            }
                        } else if (ForumTestView.this.eUV.getIndex() == 0) {
                            if (ForumTestView.this.eUV.getDataIndex() > ForumTestView.this.eUZ.getDataIndex()) {
                                ForumTestView.this.eUV.setDataIndex(ForumTestView.this.eUV.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eUV);
                            }
                        } else if (ForumTestView.this.eUW.getDataIndex() > ForumTestView.this.eUZ.getDataIndex()) {
                            ForumTestView.this.eUW.setDataIndex(ForumTestView.this.eUW.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eUW);
                        }
                        if (ForumTestView.this.eUY.getDataIndex() > ForumTestView.this.eUZ.getDataIndex()) {
                            ForumTestView.this.eUY.setDataIndex(ForumTestView.this.eUY.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eUY);
                        }
                        ForumTestView.this.eUZ.setDataIndex(ForumTestView.this.eUZ.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.eUZ);
                        ForumTestView.this.ji(true);
                        ForumTestView.this.eVr = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.eUY, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.eUZ, floatValue2);
                        if ((ForumTestView.this.eVa * 2) / 5 >= ForumTestView.this.eUX.getViewRight() - ForumTestView.this.eUX.getViewLeft()) {
                            ForumTestView.this.eUX.setAlpha(0.0f);
                            ForumTestView.this.eUX.setVisibility(8);
                        } else {
                            ForumTestView.this.eUX.setViewLeft(ForumTestView.this.eUX.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eUX.setViewRight(ForumTestView.this.eUX.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eUX.setViewTop(ForumTestView.this.eUX.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.eUX.setViewBottom(ForumTestView.this.eUX.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.eUX.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.eVa * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.eVl * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.eVo / 2.0f)) {
                    ForumTestView.this.eUX.setAlpha(0.0f);
                    ForumTestView.this.eUX.setVisibility(8);
                    ForumTestView.this.eVo = 0.0f;
                    ForumTestView.this.eUT.remove(ForumTestView.this.eUX.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.eVu != null) {
                        ForumTestView.this.eVu.cW(-1L);
                    }
                    ForumTestView.this.eVr = false;
                } else {
                    ForumTestView.this.eUX.setViewLeft(ForumTestView.this.eUX.getMoveLeft() + floatValue3);
                    ForumTestView.this.eUX.setViewRight(ForumTestView.this.eUX.getMoveRight() - floatValue3);
                    ForumTestView.this.eUX.setViewTop(ForumTestView.this.eUX.getMoveTop() + f);
                    ForumTestView.this.eUX.setViewBottom(ForumTestView.this.eUX.getMoveBottom() - f);
                    ForumTestView.this.eUX.setAlpha(1.0f - (floatValue3 / ForumTestView.this.eVo));
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
            if (af != this.eVx) {
                this.eVx = af;
                dC(getContext());
                d(this.eUU);
                d(this.eUV);
                d(this.eUW);
                d(this.eUX);
            }
            a(this.eUU);
            a(this.eUV);
            a(this.eUW);
            a(this.eUX);
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
            this.eUU.layout((int) this.eUU.getViewLeft(), (int) this.eUU.getViewTop(), (int) this.eUU.getViewRight(), (int) this.eUU.getViewBottom());
            this.eUV.layout((int) this.eUV.getViewLeft(), (int) this.eUV.getViewTop(), (int) this.eUV.getViewRight(), (int) this.eUV.getViewBottom());
            this.eUW.layout((int) this.eUW.getViewLeft(), (int) this.eUW.getViewTop(), (int) this.eUW.getViewRight(), (int) this.eUW.getViewBottom());
            this.eUX.layout((int) this.eUX.getViewLeft(), (int) this.eUX.getViewTop(), (int) this.eUX.getViewRight(), (int) this.eUX.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.eVp == null || !this.eVp.isRunning()) {
            if (this.eVn == null || !this.eVn.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.eVn != null) {
                        this.eVn.removeAllUpdateListeners();
                        this.eVn.cancel();
                    }
                    this.eVt = motionEvent.getPointerId(0);
                    this.eVi = x;
                    this.eVj = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.eVi - x;
                    float f2 = this.eVj - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.eVq = true;
                        this.eVo = f;
                    } else if (Math.abs(f2) > 30.0f && !this.eVq) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.eVk * f3;
                    if (this.eVq) {
                        b(this.eUU, f3, f4);
                        b(this.eUV, f3, f4);
                        b(this.eUW, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.NH);
                    float xVelocity = velocityTracker.getXVelocity(this.eVt);
                    if (this.eVq || this.eVo != 0.0f) {
                        aE(xVelocity);
                    }
                    this.eVq = false;
                    releaseVelocityTracker();
                }
                if (this.eVq || this.eVo != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.eUT.size() > 2) {
                if (cellForumTestView.getViewRight() < this.eVh[0].right - (this.eVa / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.eVh[0].right - (this.eVa / 2))) + this.eVh[2].left + (this.eVa / 2) + this.eVg);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.eVa);
                    cellForumTestView.setViewTop(this.eVh[2].top);
                    cellForumTestView.setViewBottom(this.eVh[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eUT.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.eVh[2].left + (this.eVa / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.eVh[2].left + (this.eVa / 2))) + ((this.eVh[0].right - (this.eVa / 2)) - this.eVg));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.eVa);
                    cellForumTestView.setViewTop(this.eVh[0].top);
                    cellForumTestView.setViewBottom(this.eVh[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eUT.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.eVh[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.eVh[0].top) {
                    cellForumTestView.setViewTop(this.eVh[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.eVh[0].bottom) {
                    cellForumTestView.setViewBottom(this.eVh[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.eVh[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.eVh[1].top) {
                    cellForumTestView.setViewTop(this.eVh[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.eVh[1].bottom) {
                    cellForumTestView.setViewBottom(this.eVh[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.eVu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ji(boolean z) {
        if (this.eVu != null) {
            int i = -1;
            if (this.eUU.getIndex() == 1 && this.eUU.getData() != null) {
                this.eVu.cW(this.eUU.getData().testId);
                i = this.eUU.getDataIndex();
            } else if (this.eUV.getIndex() == 1 && this.eUV.getData() != null) {
                this.eVu.cW(this.eUV.getData().testId);
                i = this.eUV.getDataIndex();
            } else if (this.eUW.getIndex() == 1 && this.eUW.getData() != null) {
                this.eVu.cW(this.eUW.getData().testId);
                i = this.eUW.getDataIndex();
            } else {
                this.eVu.cW(-1L);
            }
            if (z) {
                qo(i);
            }
        }
    }

    private void Ti() {
        this.eVn = ValueAnimator.ofFloat(this.eVa, 0.0f);
        this.eVn.setDuration(200L);
        this.eVn.setInterpolator(new DecelerateInterpolator());
        this.eVn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.eVo)) {
                    boolean z = Math.abs(ForumTestView.this.eVo) >= ((float) ForumTestView.this.eVa) * 0.2f;
                    if (ForumTestView.this.eVv) {
                        if (ForumTestView.this.eVo > 0.0f) {
                            ForumTestView.this.bew();
                        } else {
                            ForumTestView.this.bex();
                        }
                        ForumTestView.this.eVv = false;
                    }
                    ForumTestView.this.eVw = 0.0f;
                    ForumTestView.this.eVo = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.eUU);
                    ForumTestView.this.d(ForumTestView.this.eUV);
                    ForumTestView.this.d(ForumTestView.this.eUW);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.ji(z);
                } else {
                    if (ForumTestView.this.eVv) {
                        if (ForumTestView.this.eVo > 0.0f) {
                            if (ForumTestView.this.qm(2) != null && ForumTestView.this.qm(2).getViewLeft() >= l.af(ForumTestView.this.getContext())) {
                                ForumTestView.this.bew();
                                ForumTestView.this.eVv = false;
                            }
                        } else if (ForumTestView.this.qm(0) != null && ForumTestView.this.qm(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bex();
                            ForumTestView.this.eVv = false;
                        }
                    }
                    float f = ForumTestView.this.eVw - floatValue;
                    float f2 = ForumTestView.this.eVk * f;
                    ForumTestView.this.b(ForumTestView.this.eUU, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eUV, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eUW, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.eVw = floatValue;
            }
        });
    }

    private void aE(float f) {
        CellForumTestView qm;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.eVv = false;
        this.eVw = 0.0f;
        Ti();
        if (this.eUT.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.eUU.getVisibility() == 0) {
                cellForumTestView3 = this.eUU;
            }
            if (this.eUV.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.eUV;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.eUV;
            }
            if (this.eUW.getVisibility() == 0) {
                cellForumTestView2 = this.eUW;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.eVh[0].left) || viewRight > ((float) this.eVh[2].right)) && Math.abs(this.eVo) >= this.eVa * 0.2f) {
                this.eVv = true;
            }
        } else if (this.eUT.size() > 2 && Math.abs(this.eVo) >= this.eVa * 0.2f) {
            this.eVv = true;
        }
        if (this.eVv && (qm = qm(1)) != null) {
            if (this.eVo >= this.eVa) {
                this.eVo -= this.eVa;
                this.eVv = false;
                bex();
            } else if (this.eVo > 0.0f && this.eVo < this.eVa) {
                this.eVo = this.eVh[0].right - qm.getViewRight();
            } else if (this.eVo > (-this.eVa)) {
                this.eVo = this.eVh[2].left - qm.getViewLeft();
            } else {
                bew();
                this.eVo += this.eVa;
                this.eVv = false;
            }
        }
        this.eVn.setFloatValues(0.0f, this.eVo);
        this.eVn.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bew() {
        this.eUU.setIndex(this.eUU.getIndex() + 1);
        this.eUV.setIndex(this.eUV.getIndex() + 1);
        this.eUW.setIndex(this.eUW.getIndex() + 1);
        b(this.eUU);
        b(this.eUV);
        b(this.eUW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bex() {
        this.eUU.setIndex(this.eUU.getIndex() - 1);
        this.eUV.setIndex(this.eUV.getIndex() - 1);
        this.eUW.setIndex(this.eUW.getIndex() - 1);
        b(this.eUU);
        b(this.eUV);
        b(this.eUW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView qm(int i) {
        if (this.eUU.getIndex() == i) {
            return this.eUU;
        }
        if (this.eUV.getIndex() == i) {
            return this.eUV;
        }
        if (this.eUW.getIndex() == i) {
            return this.eUW;
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
            int size = this.eUT.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int qn(int i) {
        int size = this.eUT.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.eVh[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.eVh[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.eVh[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.eVh[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.aa(list) && !this.eVq && this.eVo == 0.0f) {
            this.eUT = list;
            resetData();
            if (v.Z(list) > 2) {
                this.eUU.setVisibility(0);
                this.eUV.setVisibility(0);
                this.eUW.setVisibility(0);
                this.eUU.setData(list.get(0));
                this.eUV.setData(list.get(1));
                this.eUW.setData(list.get(2));
                this.eUU.setDataIndex(0);
                this.eUV.setDataIndex(1);
                this.eUW.setDataIndex(2);
                i = 1;
            } else if (v.Z(list) == 2) {
                this.eUU.setVisibility(8);
                this.eUV.setVisibility(0);
                this.eUW.setVisibility(0);
                this.eUV.setDataIndex(1);
                this.eUW.setDataIndex(0);
                this.eUV.setData(list.get(1));
                this.eUW.setData(list.get(0));
                i = 1;
            } else {
                this.eUU.setVisibility(8);
                this.eUV.setVisibility(0);
                this.eUW.setVisibility(8);
                this.eUV.setDataIndex(0);
                this.eUV.setData(list.get(0));
                i = 0;
            }
            qo(i);
        }
    }

    private void resetData() {
        this.eUU.setIndex(0);
        this.eUV.setIndex(1);
        this.eUW.setIndex(2);
        this.eUX.setIndex(1);
        d(this.eUU);
        d(this.eUV);
        d(this.eUW);
        d(this.eUX);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void ql(int i) {
        CellForumTestView cellForumTestView;
        this.eVr = true;
        this.eUX.setVisibility(0);
        this.eUX.setAlpha(1.0f);
        bey();
        if (this.eUU.getIndex() == i && this.eUU.getVisibility() == 0) {
            cellForumTestView = this.eUU;
        } else if (this.eUV.getIndex() == i && this.eUV.getVisibility() == 0) {
            cellForumTestView = this.eUV;
        } else {
            cellForumTestView = this.eUW;
        }
        this.eUX.setData(cellForumTestView.getData());
        this.eUX.setDataIndex(cellForumTestView.getDataIndex());
        this.eUZ = null;
        if (this.eUT.size() == 1) {
            this.eVs = 1;
            cellForumTestView.setVisibility(8);
            this.eVo = (this.eVa * 3) / 5;
        } else if (this.eUT.size() == 2) {
            this.eVs = 2;
            cellForumTestView.setVisibility(8);
            if (this.eUU.getVisibility() == 0) {
                this.eUY = this.eUU;
            } else if (this.eUV.getVisibility() == 0) {
                this.eUY = this.eUV;
            } else {
                this.eUY = this.eUW;
            }
            if (this.eUY.getViewRight() < this.eVh[1].left) {
                this.eVo = this.eVa + this.eVg;
                this.eUY.setIndex(this.eUY.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.eUY.getViewLeft() > this.eVh[1].right) {
                this.eVo = (-this.eVa) - this.eVg;
                this.eUY.setIndex(this.eUY.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.eUY);
            b(cellForumTestView);
        } else if (this.eUT.size() == 3) {
            this.eVs = 3;
            cellForumTestView.setVisibility(8);
            if (this.eUU.getIndex() == 2) {
                this.eUY = this.eUU;
            } else if (this.eUV.getIndex() == 2) {
                this.eUY = this.eUV;
            } else {
                this.eUY = this.eUW;
            }
            this.eVo = (-this.eVa) - this.eVg;
            this.eUY.setIndex(this.eUY.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.eUY);
            b(cellForumTestView);
        } else {
            this.eVs = 4;
            this.eUZ = cellForumTestView;
            if (this.eUU.getIndex() == 2) {
                this.eUY = this.eUU;
            } else if (this.eUV.getIndex() == 2) {
                this.eUY = this.eUV;
            } else {
                this.eUY = this.eUW;
            }
            this.eVo = (-this.eVa) - this.eVg;
            this.eUY.setIndex(this.eUY.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.eUY);
            b(cellForumTestView);
            this.eUZ.setViewLeft(this.eVh[2].right + this.eVg);
            this.eUZ.setViewRight(this.eVh[2].right + this.eVg + this.eVa);
            this.eUZ.setViewTop(this.eVh[2].top);
            this.eUZ.setViewBottom(this.eVh[2].bottom);
            this.eUZ.setMoveLeft(this.eVh[2].right + this.eVg);
            this.eUZ.setMoveRight(this.eVh[2].right + this.eVg + this.eVa);
            this.eUZ.setMoveTop(this.eVh[2].top);
            this.eUZ.setMoveBottom(this.eVh[2].bottom);
            this.eUZ.setData(this.eUT.get(qn(this.eUZ.getDataIndex() + 2)));
        }
        this.eVp.setFloatValues(0.0f, this.eVo);
        this.eVp.start();
    }

    private void bey() {
        this.eUU.setMoveLeft(this.eUU.getViewLeft());
        this.eUU.setMoveTop(this.eUU.getViewTop());
        this.eUU.setMoveRight(this.eUU.getViewRight());
        this.eUU.setMoveBottom(this.eUU.getViewBottom());
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
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, R.color.cp_bg_line_c);
            this.eUU.onChangeSkinType();
            this.eUV.onChangeSkinType();
            this.eUW.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.eVq && this.eVo == 0.0f) {
            if (this.eVn != null) {
                this.eVn.removeAllUpdateListeners();
                this.eVn.cancel();
            }
            if (this.eVp != null) {
                this.eVp.removeAllUpdateListeners();
                this.eVp.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.eUU != null) {
            this.eUU.setPageId(bdUniqueId);
        }
        if (this.eUV != null) {
            this.eUV.setPageId(bdUniqueId);
        }
        if (this.eUW != null) {
            this.eUW.setPageId(bdUniqueId);
        }
    }

    public void qo(int i) {
        f fVar;
        am a2;
        if (this.eUT != null && i >= 0 && i < this.eUT.size() && (fVar = this.eUT.get(i)) != null && (a2 = com.baidu.tieba.q.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.q.c.clt().a(this.mPageId, "enterfourm_rec_" + fVar.testId, a2);
        }
    }
}
