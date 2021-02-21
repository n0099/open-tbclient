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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes2.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int XI;
    private float bVe;
    private List<f> iMV;
    private CellForumTestView iMW;
    private CellForumTestView iMX;
    private CellForumTestView iMY;
    private CellForumTestView iMZ;
    private CellForumTestView iNa;
    private CellForumTestView iNb;
    private int iNc;
    private int iNd;
    private int iNe;
    private int iNf;
    private int iNg;
    private int iNh;
    private int iNi;
    private Rect[] iNj;
    private float iNk;
    private float iNl;
    private float iNm;
    private float iNn;
    private float iNo;
    private ValueAnimator iNp;
    private ValueAnimator iNq;
    private boolean iNr;
    private boolean iNs;
    private int iNt;
    private int iNu;
    private a iNv;
    private boolean iNw;
    private int iNx;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void cxb();

        void gl(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iNj = new Rect[3];
        this.iNr = false;
        this.iNs = false;
        this.iNw = false;
        this.bVe = 0.0f;
        this.iNx = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iNj = new Rect[3];
        this.iNr = false;
        this.iNs = false;
        this.iNw = false;
        this.bVe = 0.0f;
        this.iNx = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iNj = new Rect[3];
        this.iNr = false;
        this.iNs = false;
        this.iNw = false;
        this.bVe = 0.0f;
        this.iNx = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.iMW = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.iMX = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.iMY = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.iMZ = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        gj(context);
        resetData();
        ViewConfiguration.get(context);
        this.XI = ViewConfiguration.getMaximumFlingVelocity();
        this.iMW.setForumTestDelClickListener(this);
        this.iMX.setForumTestDelClickListener(this);
        this.iMY.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void gj(Context context) {
        this.iNg = l.getDimens(context, R.dimen.tbds44);
        this.iNh = l.getDimens(context, R.dimen.tbds30);
        this.iNi = l.getDimens(context, R.dimen.tbds7);
        this.iNf = l.getDimens(context, R.dimen.tbds730);
        this.iNe = this.iNf - (this.iNh * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.iNc = (int) (this.mWidth * 0.89f);
        this.mHeight = this.iNf + this.iNg;
        this.iNd = ((this.mWidth - this.iNc) - (this.iNi * 2)) / 2;
        this.iNm = this.iNh / (this.iNc + this.iNi);
        this.iNn = this.iNf / this.iNc;
        this.iNo = this.iNc / (this.iNc + this.iNi);
        this.iNj[0] = new Rect(this.iNd - this.iNc, this.iNg + this.iNh, this.iNd, this.iNg + this.iNh + this.iNe);
        this.iNj[1] = new Rect(this.iNd + this.iNi, this.iNg, this.iNd + this.iNi + this.iNc, this.iNg + this.iNf);
        this.iNj[2] = new Rect(this.mWidth - this.iNd, this.iNg + this.iNh, (this.mWidth - this.iNd) + this.iNc, this.iNg + this.iNh + this.iNe);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iNq = ValueAnimator.ofFloat(this.iNc, 0.0f);
        this.iNq.setDuration(500L);
        this.iNq.setInterpolator(new DecelerateInterpolator());
        this.iNq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.iNt != 1) {
                    if (ForumTestView.this.iNt == 2 || ForumTestView.this.iNt == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.iNm * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.iNn;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.iMZ.setAlpha(0.0f);
                            ForumTestView.this.iMZ.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.iNa);
                            ForumTestView.this.d(ForumTestView.this.iMZ);
                            ForumTestView.this.iMV.remove(ForumTestView.this.iMZ.getData());
                            ForumTestView.this.pX(true);
                            ForumTestView.this.iNs = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.iNa, floatValue, abs);
                            if ((ForumTestView.this.iNc * 2) / 5 >= ForumTestView.this.iMZ.getViewRight() - ForumTestView.this.iMZ.getViewLeft()) {
                                ForumTestView.this.iMZ.setAlpha(0.0f);
                                ForumTestView.this.iMZ.setVisibility(8);
                            } else {
                                ForumTestView.this.iMZ.setViewLeft(ForumTestView.this.iMZ.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iMZ.setViewRight(ForumTestView.this.iMZ.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iMZ.setViewTop(ForumTestView.this.iMZ.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.iMZ.setViewBottom(ForumTestView.this.iMZ.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.iMZ.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.iNc * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.iNm * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.iNn;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.iMZ.setAlpha(0.0f);
                        ForumTestView.this.iMZ.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.iNa);
                        ForumTestView.this.d(ForumTestView.this.iMZ);
                        ForumTestView.this.d(ForumTestView.this.iNb);
                        ForumTestView.this.iMV.remove(ForumTestView.this.iMZ.getData());
                        if (ForumTestView.this.iMW.getIndex() == 0) {
                            if (ForumTestView.this.iMW.getDataIndex() > ForumTestView.this.iNb.getDataIndex()) {
                                ForumTestView.this.iMW.setDataIndex(ForumTestView.this.iMW.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iMW);
                            }
                        } else if (ForumTestView.this.iMX.getIndex() == 0) {
                            if (ForumTestView.this.iMX.getDataIndex() > ForumTestView.this.iNb.getDataIndex()) {
                                ForumTestView.this.iMX.setDataIndex(ForumTestView.this.iMX.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iMX);
                            }
                        } else if (ForumTestView.this.iMY.getDataIndex() > ForumTestView.this.iNb.getDataIndex()) {
                            ForumTestView.this.iMY.setDataIndex(ForumTestView.this.iMY.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iMY);
                        }
                        if (ForumTestView.this.iNa.getDataIndex() > ForumTestView.this.iNb.getDataIndex()) {
                            ForumTestView.this.iNa.setDataIndex(ForumTestView.this.iNa.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iNa);
                        }
                        ForumTestView.this.iNb.setDataIndex(ForumTestView.this.iNb.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.iNb);
                        ForumTestView.this.pX(true);
                        ForumTestView.this.iNs = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.iNa, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.iNb, floatValue2);
                        if ((ForumTestView.this.iNc * 2) / 5 >= ForumTestView.this.iMZ.getViewRight() - ForumTestView.this.iMZ.getViewLeft()) {
                            ForumTestView.this.iMZ.setAlpha(0.0f);
                            ForumTestView.this.iMZ.setVisibility(8);
                        } else {
                            ForumTestView.this.iMZ.setViewLeft(ForumTestView.this.iMZ.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iMZ.setViewRight(ForumTestView.this.iMZ.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iMZ.setViewTop(ForumTestView.this.iMZ.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.iMZ.setViewBottom(ForumTestView.this.iMZ.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.iMZ.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.iNc * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.iNn * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.iMZ.setAlpha(0.0f);
                    ForumTestView.this.iMZ.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.iMV.remove(ForumTestView.this.iMZ.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.iNv != null) {
                        ForumTestView.this.iNv.gl(-1L);
                    }
                    ForumTestView.this.iNs = false;
                    if (ForumTestView.this.iNv != null && y.isEmpty(ForumTestView.this.iMV)) {
                        ForumTestView.this.iNv.cxb();
                    }
                } else {
                    ForumTestView.this.iMZ.setViewLeft(ForumTestView.this.iMZ.getMoveLeft() + floatValue3);
                    ForumTestView.this.iMZ.setViewRight(ForumTestView.this.iMZ.getMoveRight() - floatValue3);
                    ForumTestView.this.iMZ.setViewTop(ForumTestView.this.iMZ.getMoveTop() + f);
                    ForumTestView.this.iMZ.setViewBottom(ForumTestView.this.iMZ.getMoveBottom() - f);
                    ForumTestView.this.iMZ.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.iNx) {
                this.iNx = equipmentWidth;
                gj(getContext());
                d(this.iMW);
                d(this.iMX);
                d(this.iMY);
                d(this.iMZ);
            }
            a(this.iMW);
            a(this.iMX);
            a(this.iMY);
            a(this.iMZ);
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
            this.iMW.layout((int) this.iMW.getViewLeft(), (int) this.iMW.getViewTop(), (int) this.iMW.getViewRight(), (int) this.iMW.getViewBottom());
            this.iMX.layout((int) this.iMX.getViewLeft(), (int) this.iMX.getViewTop(), (int) this.iMX.getViewRight(), (int) this.iMX.getViewBottom());
            this.iMY.layout((int) this.iMY.getViewLeft(), (int) this.iMY.getViewTop(), (int) this.iMY.getViewRight(), (int) this.iMY.getViewBottom());
            this.iMZ.layout((int) this.iMZ.getViewLeft(), (int) this.iMZ.getViewTop(), (int) this.iMZ.getViewRight(), (int) this.iMZ.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.iNq == null || !this.iNq.isRunning()) {
            if (this.iNp == null || !this.iNp.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.iNp != null) {
                        this.iNp.removeAllUpdateListeners();
                        this.iNp.cancel();
                    }
                    this.iNu = motionEvent.getPointerId(0);
                    this.iNk = x;
                    this.iNl = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.iNk - x;
                    float f2 = this.iNl - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.iNr = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.iNr) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.iNm * f3;
                    if (this.iNr) {
                        b(this.iMW, f3, f4);
                        b(this.iMX, f3, f4);
                        b(this.iMY, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.XI);
                    float xVelocity = velocityTracker.getXVelocity(this.iNu);
                    if (this.iNr || this.mDistance != 0.0f) {
                        aI(xVelocity);
                    }
                    this.iNr = false;
                    releaseVelocityTracker();
                }
                if (this.iNr || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.iMV.size() > 2) {
                if (cellForumTestView.getViewRight() < this.iNj[0].right - (this.iNc / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.iNj[0].right - (this.iNc / 2))) + this.iNj[2].left + (this.iNc / 2) + this.iNi);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.iNc);
                    cellForumTestView.setViewTop(this.iNj[2].top);
                    cellForumTestView.setViewBottom(this.iNj[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iMV.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.iNj[2].left + (this.iNc / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.iNj[2].left + (this.iNc / 2))) + ((this.iNj[0].right - (this.iNc / 2)) - this.iNi));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.iNc);
                    cellForumTestView.setViewTop(this.iNj[0].top);
                    cellForumTestView.setViewBottom(this.iNj[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iMV.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.iNj[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.iNj[0].top) {
                    cellForumTestView.setViewTop(this.iNj[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.iNj[0].bottom) {
                    cellForumTestView.setViewBottom(this.iNj[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.iNj[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.iNj[1].top) {
                    cellForumTestView.setViewTop(this.iNj[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.iNj[1].bottom) {
                    cellForumTestView.setViewBottom(this.iNj[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.iNv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(boolean z) {
        if (this.iNv != null) {
            int i = -1;
            if (this.iMW.getIndex() == 1 && this.iMW.getData() != null) {
                this.iNv.gl(this.iMW.getData().testId);
                i = this.iMW.getDataIndex();
            } else if (this.iMX.getIndex() == 1 && this.iMX.getData() != null) {
                this.iNv.gl(this.iMX.getData().testId);
                i = this.iMX.getDataIndex();
            } else if (this.iMY.getIndex() == 1 && this.iMY.getData() != null) {
                this.iNv.gl(this.iMY.getData().testId);
                i = this.iMY.getDataIndex();
            } else {
                this.iNv.gl(-1L);
            }
            if (z) {
                xO(i);
            }
        }
    }

    private void initAnimation() {
        this.iNp = ValueAnimator.ofFloat(this.iNc, 0.0f);
        this.iNp.setDuration(200L);
        this.iNp.setInterpolator(new DecelerateInterpolator());
        this.iNp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.iNc) * 0.2f;
                    if (ForumTestView.this.iNw) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cwY();
                        } else {
                            ForumTestView.this.cwZ();
                        }
                        ForumTestView.this.iNw = false;
                    }
                    ForumTestView.this.bVe = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.iMW);
                    ForumTestView.this.d(ForumTestView.this.iMX);
                    ForumTestView.this.d(ForumTestView.this.iMY);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.pX(z);
                } else {
                    if (ForumTestView.this.iNw) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.xM(2) != null && ForumTestView.this.xM(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cwY();
                                ForumTestView.this.iNw = false;
                            }
                        } else if (ForumTestView.this.xM(0) != null && ForumTestView.this.xM(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cwZ();
                            ForumTestView.this.iNw = false;
                        }
                    }
                    float f = ForumTestView.this.bVe - floatValue;
                    float f2 = ForumTestView.this.iNm * f;
                    ForumTestView.this.b(ForumTestView.this.iMW, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iMX, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iMY, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.bVe = floatValue;
            }
        });
    }

    private void aI(float f) {
        CellForumTestView xM;
        float viewLeft;
        float viewRight;
        this.iNw = false;
        this.bVe = 0.0f;
        initAnimation();
        if (this.iMV.size() == 2) {
            CellForumTestView cellForumTestView = null;
            CellForumTestView cellForumTestView2 = null;
            if (this.iMW.getVisibility() == 0) {
                cellForumTestView = this.iMW;
            }
            if (this.iMX.getVisibility() == 0) {
                if (cellForumTestView == null) {
                    cellForumTestView = this.iMX;
                } else {
                    cellForumTestView2 = this.iMX;
                }
            }
            if (this.iMY.getVisibility() == 0) {
                cellForumTestView2 = this.iMY;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                float viewLeft2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
                viewLeft = viewLeft2;
            } else {
                viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
            }
            if (!(viewLeft < ((float) this.iNj[0].left) || viewRight > ((float) this.iNj[2].right)) && Math.abs(this.mDistance) >= this.iNc * 0.2f) {
                this.iNw = true;
            }
        } else if (this.iMV.size() > 2 && Math.abs(this.mDistance) >= this.iNc * 0.2f) {
            this.iNw = true;
        }
        if (this.iNw && (xM = xM(1)) != null) {
            if (this.mDistance >= this.iNc) {
                this.mDistance -= this.iNc;
                this.iNw = false;
                cwZ();
            } else if (this.mDistance > 0.0f && this.mDistance < this.iNc) {
                this.mDistance = this.iNj[0].right - xM.getViewRight();
            } else if (this.mDistance > (-this.iNc)) {
                this.mDistance = this.iNj[2].left - xM.getViewLeft();
            } else {
                cwY();
                this.mDistance += this.iNc;
                this.iNw = false;
            }
        }
        this.iNp.setFloatValues(0.0f, this.mDistance);
        this.iNp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwY() {
        this.iMW.setIndex(this.iMW.getIndex() + 1);
        this.iMX.setIndex(this.iMX.getIndex() + 1);
        this.iMY.setIndex(this.iMY.getIndex() + 1);
        b(this.iMW);
        b(this.iMX);
        b(this.iMY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwZ() {
        this.iMW.setIndex(this.iMW.getIndex() - 1);
        this.iMX.setIndex(this.iMX.getIndex() - 1);
        this.iMY.setIndex(this.iMY.getIndex() - 1);
        b(this.iMW);
        b(this.iMX);
        b(this.iMY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView xM(int i) {
        if (this.iMW.getIndex() == i) {
            return this.iMW;
        }
        if (this.iMX.getIndex() == i) {
            return this.iMX;
        }
        if (this.iMY.getIndex() == i) {
            return this.iMY;
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
            int size = this.iMV.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int xN(int i) {
        int size = this.iMV.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.iNj[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.iNj[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.iNj[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.iNj[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.iNr && this.mDistance == 0.0f) {
            this.iMV = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.iMW.setVisibility(0);
                this.iMX.setVisibility(0);
                this.iMY.setVisibility(0);
                this.iMW.setData(list.get(0));
                this.iMX.setData(list.get(1));
                this.iMY.setData(list.get(2));
                this.iMW.setDataIndex(0);
                this.iMX.setDataIndex(1);
                this.iMY.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.iMW.setVisibility(8);
                this.iMX.setVisibility(0);
                this.iMY.setVisibility(0);
                this.iMX.setDataIndex(1);
                this.iMY.setDataIndex(0);
                this.iMX.setData(list.get(1));
                this.iMY.setData(list.get(0));
                i = 1;
            } else {
                this.iMW.setVisibility(8);
                this.iMX.setVisibility(0);
                this.iMY.setVisibility(8);
                this.iMX.setDataIndex(0);
                this.iMX.setData(list.get(0));
                i = 0;
            }
            xO(i);
        }
    }

    private void resetData() {
        this.iMW.setIndex(0);
        this.iMX.setIndex(1);
        this.iMY.setIndex(2);
        this.iMZ.setIndex(1);
        d(this.iMW);
        d(this.iMX);
        d(this.iMY);
        d(this.iMZ);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void xL(int i) {
        CellForumTestView cellForumTestView;
        this.iNs = true;
        this.iMZ.setVisibility(0);
        this.iMZ.setAlpha(1.0f);
        cxa();
        if (this.iMW.getIndex() == i && this.iMW.getVisibility() == 0) {
            cellForumTestView = this.iMW;
        } else if (this.iMX.getIndex() == i && this.iMX.getVisibility() == 0) {
            cellForumTestView = this.iMX;
        } else {
            cellForumTestView = this.iMY;
        }
        this.iMZ.setData(cellForumTestView.getData());
        this.iMZ.setDataIndex(cellForumTestView.getDataIndex());
        this.iNb = null;
        if (this.iMV.size() == 1) {
            this.iNt = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.iNc * 3) / 5;
        } else if (this.iMV.size() == 2) {
            this.iNt = 2;
            cellForumTestView.setVisibility(8);
            if (this.iMW.getVisibility() == 0) {
                this.iNa = this.iMW;
            } else if (this.iMX.getVisibility() == 0) {
                this.iNa = this.iMX;
            } else {
                this.iNa = this.iMY;
            }
            if (this.iNa.getViewRight() < this.iNj[1].left) {
                this.mDistance = this.iNc + this.iNi;
                this.iNa.setIndex(this.iNa.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.iNa.getViewLeft() > this.iNj[1].right) {
                this.mDistance = (-this.iNc) - this.iNi;
                this.iNa.setIndex(this.iNa.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.iNa);
            b(cellForumTestView);
        } else if (this.iMV.size() == 3) {
            this.iNt = 3;
            cellForumTestView.setVisibility(8);
            if (this.iMW.getIndex() == 2) {
                this.iNa = this.iMW;
            } else if (this.iMX.getIndex() == 2) {
                this.iNa = this.iMX;
            } else {
                this.iNa = this.iMY;
            }
            this.mDistance = (-this.iNc) - this.iNi;
            this.iNa.setIndex(this.iNa.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.iNa);
            b(cellForumTestView);
        } else {
            this.iNt = 4;
            this.iNb = cellForumTestView;
            if (this.iMW.getIndex() == 2) {
                this.iNa = this.iMW;
            } else if (this.iMX.getIndex() == 2) {
                this.iNa = this.iMX;
            } else {
                this.iNa = this.iMY;
            }
            this.mDistance = (-this.iNc) - this.iNi;
            this.iNa.setIndex(this.iNa.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.iNa);
            b(cellForumTestView);
            this.iNb.setViewLeft(this.iNj[2].right + this.iNi);
            this.iNb.setViewRight(this.iNj[2].right + this.iNi + this.iNc);
            this.iNb.setViewTop(this.iNj[2].top);
            this.iNb.setViewBottom(this.iNj[2].bottom);
            this.iNb.setMoveLeft(this.iNj[2].right + this.iNi);
            this.iNb.setMoveRight(this.iNj[2].right + this.iNi + this.iNc);
            this.iNb.setMoveTop(this.iNj[2].top);
            this.iNb.setMoveBottom(this.iNj[2].bottom);
            this.iNb.setData(this.iMV.get(xN(this.iNb.getDataIndex() + 2)));
        }
        this.iNq.setFloatValues(0.0f, this.mDistance);
        this.iNq.start();
    }

    private void cxa() {
        this.iMW.setMoveLeft(this.iMW.getViewLeft());
        this.iMW.setMoveTop(this.iMW.getViewTop());
        this.iMW.setMoveRight(this.iMW.getViewRight());
        this.iMW.setMoveBottom(this.iMW.getViewBottom());
        this.iMX.setMoveLeft(this.iMX.getViewLeft());
        this.iMX.setMoveTop(this.iMX.getViewTop());
        this.iMX.setMoveRight(this.iMX.getViewRight());
        this.iMX.setMoveBottom(this.iMX.getViewBottom());
        this.iMY.setMoveLeft(this.iMY.getViewLeft());
        this.iMY.setMoveTop(this.iMY.getViewTop());
        this.iMY.setMoveRight(this.iMY.getViewRight());
        this.iMY.setMoveBottom(this.iMY.getViewBottom());
        this.iMZ.setMoveLeft(this.iMZ.getViewLeft());
        this.iMZ.setMoveTop(this.iMZ.getViewTop());
        this.iMZ.setMoveRight(this.iMZ.getViewRight());
        this.iMZ.setMoveBottom(this.iMZ.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0205);
            this.iMW.onChangeSkinType();
            this.iMX.onChangeSkinType();
            this.iMY.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.iNr && this.mDistance == 0.0f) {
            if (this.iNp != null) {
                this.iNp.removeAllUpdateListeners();
                this.iNp.cancel();
            }
            if (this.iNq != null) {
                this.iNq.removeAllUpdateListeners();
                this.iNq.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.iMW != null) {
            this.iMW.setPageId(bdUniqueId);
        }
        if (this.iMX != null) {
            this.iMX.setPageId(bdUniqueId);
        }
        if (this.iMY != null) {
            this.iMY.setPageId(bdUniqueId);
        }
    }

    public void xO(int i) {
        f fVar;
        ar a2;
        if (this.iMV != null && i >= 0 && i < this.iMV.size() && (fVar = this.iMV.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dMz().a(this.mPageId, com.baidu.tieba.s.a.Td("" + fVar.testId), a2);
        }
    }
}
