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
    private List<f> iMH;
    private CellForumTestView iMI;
    private CellForumTestView iMJ;
    private CellForumTestView iMK;
    private CellForumTestView iML;
    private CellForumTestView iMM;
    private CellForumTestView iMN;
    private int iMO;
    private int iMP;
    private int iMQ;
    private int iMR;
    private int iMS;
    private int iMT;
    private int iMU;
    private Rect[] iMV;
    private float iMW;
    private float iMX;
    private float iMY;
    private float iMZ;
    private float iNa;
    private ValueAnimator iNb;
    private ValueAnimator iNc;
    private boolean iNd;
    private boolean iNe;
    private int iNf;
    private int iNg;
    private a iNh;
    private boolean iNi;
    private int iNj;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void cwU();

        void gl(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iMV = new Rect[3];
        this.iNd = false;
        this.iNe = false;
        this.iNi = false;
        this.bVe = 0.0f;
        this.iNj = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iMV = new Rect[3];
        this.iNd = false;
        this.iNe = false;
        this.iNi = false;
        this.bVe = 0.0f;
        this.iNj = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iMV = new Rect[3];
        this.iNd = false;
        this.iNe = false;
        this.iNi = false;
        this.bVe = 0.0f;
        this.iNj = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.iMI = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.iMJ = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.iMK = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.iML = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        gj(context);
        resetData();
        ViewConfiguration.get(context);
        this.XI = ViewConfiguration.getMaximumFlingVelocity();
        this.iMI.setForumTestDelClickListener(this);
        this.iMJ.setForumTestDelClickListener(this);
        this.iMK.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void gj(Context context) {
        this.iMS = l.getDimens(context, R.dimen.tbds44);
        this.iMT = l.getDimens(context, R.dimen.tbds30);
        this.iMU = l.getDimens(context, R.dimen.tbds7);
        this.iMR = l.getDimens(context, R.dimen.tbds730);
        this.iMQ = this.iMR - (this.iMT * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.iMO = (int) (this.mWidth * 0.89f);
        this.mHeight = this.iMR + this.iMS;
        this.iMP = ((this.mWidth - this.iMO) - (this.iMU * 2)) / 2;
        this.iMY = this.iMT / (this.iMO + this.iMU);
        this.iMZ = this.iMR / this.iMO;
        this.iNa = this.iMO / (this.iMO + this.iMU);
        this.iMV[0] = new Rect(this.iMP - this.iMO, this.iMS + this.iMT, this.iMP, this.iMS + this.iMT + this.iMQ);
        this.iMV[1] = new Rect(this.iMP + this.iMU, this.iMS, this.iMP + this.iMU + this.iMO, this.iMS + this.iMR);
        this.iMV[2] = new Rect(this.mWidth - this.iMP, this.iMS + this.iMT, (this.mWidth - this.iMP) + this.iMO, this.iMS + this.iMT + this.iMQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iNc = ValueAnimator.ofFloat(this.iMO, 0.0f);
        this.iNc.setDuration(500L);
        this.iNc.setInterpolator(new DecelerateInterpolator());
        this.iNc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.iNf != 1) {
                    if (ForumTestView.this.iNf == 2 || ForumTestView.this.iNf == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.iMY * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.iMZ;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.iML.setAlpha(0.0f);
                            ForumTestView.this.iML.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.iMM);
                            ForumTestView.this.d(ForumTestView.this.iML);
                            ForumTestView.this.iMH.remove(ForumTestView.this.iML.getData());
                            ForumTestView.this.pX(true);
                            ForumTestView.this.iNe = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.iMM, floatValue, abs);
                            if ((ForumTestView.this.iMO * 2) / 5 >= ForumTestView.this.iML.getViewRight() - ForumTestView.this.iML.getViewLeft()) {
                                ForumTestView.this.iML.setAlpha(0.0f);
                                ForumTestView.this.iML.setVisibility(8);
                            } else {
                                ForumTestView.this.iML.setViewLeft(ForumTestView.this.iML.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iML.setViewRight(ForumTestView.this.iML.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iML.setViewTop(ForumTestView.this.iML.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.iML.setViewBottom(ForumTestView.this.iML.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.iML.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.iMO * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.iMY * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.iMZ;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.iML.setAlpha(0.0f);
                        ForumTestView.this.iML.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.iMM);
                        ForumTestView.this.d(ForumTestView.this.iML);
                        ForumTestView.this.d(ForumTestView.this.iMN);
                        ForumTestView.this.iMH.remove(ForumTestView.this.iML.getData());
                        if (ForumTestView.this.iMI.getIndex() == 0) {
                            if (ForumTestView.this.iMI.getDataIndex() > ForumTestView.this.iMN.getDataIndex()) {
                                ForumTestView.this.iMI.setDataIndex(ForumTestView.this.iMI.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iMI);
                            }
                        } else if (ForumTestView.this.iMJ.getIndex() == 0) {
                            if (ForumTestView.this.iMJ.getDataIndex() > ForumTestView.this.iMN.getDataIndex()) {
                                ForumTestView.this.iMJ.setDataIndex(ForumTestView.this.iMJ.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iMJ);
                            }
                        } else if (ForumTestView.this.iMK.getDataIndex() > ForumTestView.this.iMN.getDataIndex()) {
                            ForumTestView.this.iMK.setDataIndex(ForumTestView.this.iMK.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iMK);
                        }
                        if (ForumTestView.this.iMM.getDataIndex() > ForumTestView.this.iMN.getDataIndex()) {
                            ForumTestView.this.iMM.setDataIndex(ForumTestView.this.iMM.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iMM);
                        }
                        ForumTestView.this.iMN.setDataIndex(ForumTestView.this.iMN.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.iMN);
                        ForumTestView.this.pX(true);
                        ForumTestView.this.iNe = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.iMM, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.iMN, floatValue2);
                        if ((ForumTestView.this.iMO * 2) / 5 >= ForumTestView.this.iML.getViewRight() - ForumTestView.this.iML.getViewLeft()) {
                            ForumTestView.this.iML.setAlpha(0.0f);
                            ForumTestView.this.iML.setVisibility(8);
                        } else {
                            ForumTestView.this.iML.setViewLeft(ForumTestView.this.iML.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iML.setViewRight(ForumTestView.this.iML.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iML.setViewTop(ForumTestView.this.iML.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.iML.setViewBottom(ForumTestView.this.iML.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.iML.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.iMO * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.iMZ * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.iML.setAlpha(0.0f);
                    ForumTestView.this.iML.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.iMH.remove(ForumTestView.this.iML.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.iNh != null) {
                        ForumTestView.this.iNh.gl(-1L);
                    }
                    ForumTestView.this.iNe = false;
                    if (ForumTestView.this.iNh != null && y.isEmpty(ForumTestView.this.iMH)) {
                        ForumTestView.this.iNh.cwU();
                    }
                } else {
                    ForumTestView.this.iML.setViewLeft(ForumTestView.this.iML.getMoveLeft() + floatValue3);
                    ForumTestView.this.iML.setViewRight(ForumTestView.this.iML.getMoveRight() - floatValue3);
                    ForumTestView.this.iML.setViewTop(ForumTestView.this.iML.getMoveTop() + f);
                    ForumTestView.this.iML.setViewBottom(ForumTestView.this.iML.getMoveBottom() - f);
                    ForumTestView.this.iML.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.iNj) {
                this.iNj = equipmentWidth;
                gj(getContext());
                d(this.iMI);
                d(this.iMJ);
                d(this.iMK);
                d(this.iML);
            }
            a(this.iMI);
            a(this.iMJ);
            a(this.iMK);
            a(this.iML);
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
            this.iMI.layout((int) this.iMI.getViewLeft(), (int) this.iMI.getViewTop(), (int) this.iMI.getViewRight(), (int) this.iMI.getViewBottom());
            this.iMJ.layout((int) this.iMJ.getViewLeft(), (int) this.iMJ.getViewTop(), (int) this.iMJ.getViewRight(), (int) this.iMJ.getViewBottom());
            this.iMK.layout((int) this.iMK.getViewLeft(), (int) this.iMK.getViewTop(), (int) this.iMK.getViewRight(), (int) this.iMK.getViewBottom());
            this.iML.layout((int) this.iML.getViewLeft(), (int) this.iML.getViewTop(), (int) this.iML.getViewRight(), (int) this.iML.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.iNc == null || !this.iNc.isRunning()) {
            if (this.iNb == null || !this.iNb.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.iNb != null) {
                        this.iNb.removeAllUpdateListeners();
                        this.iNb.cancel();
                    }
                    this.iNg = motionEvent.getPointerId(0);
                    this.iMW = x;
                    this.iMX = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.iMW - x;
                    float f2 = this.iMX - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.iNd = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.iNd) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.iMY * f3;
                    if (this.iNd) {
                        b(this.iMI, f3, f4);
                        b(this.iMJ, f3, f4);
                        b(this.iMK, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.XI);
                    float xVelocity = velocityTracker.getXVelocity(this.iNg);
                    if (this.iNd || this.mDistance != 0.0f) {
                        aI(xVelocity);
                    }
                    this.iNd = false;
                    releaseVelocityTracker();
                }
                if (this.iNd || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.iMH.size() > 2) {
                if (cellForumTestView.getViewRight() < this.iMV[0].right - (this.iMO / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.iMV[0].right - (this.iMO / 2))) + this.iMV[2].left + (this.iMO / 2) + this.iMU);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.iMO);
                    cellForumTestView.setViewTop(this.iMV[2].top);
                    cellForumTestView.setViewBottom(this.iMV[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iMH.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.iMV[2].left + (this.iMO / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.iMV[2].left + (this.iMO / 2))) + ((this.iMV[0].right - (this.iMO / 2)) - this.iMU));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.iMO);
                    cellForumTestView.setViewTop(this.iMV[0].top);
                    cellForumTestView.setViewBottom(this.iMV[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iMH.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.iMV[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.iMV[0].top) {
                    cellForumTestView.setViewTop(this.iMV[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.iMV[0].bottom) {
                    cellForumTestView.setViewBottom(this.iMV[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.iMV[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.iMV[1].top) {
                    cellForumTestView.setViewTop(this.iMV[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.iMV[1].bottom) {
                    cellForumTestView.setViewBottom(this.iMV[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.iNh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(boolean z) {
        if (this.iNh != null) {
            int i = -1;
            if (this.iMI.getIndex() == 1 && this.iMI.getData() != null) {
                this.iNh.gl(this.iMI.getData().testId);
                i = this.iMI.getDataIndex();
            } else if (this.iMJ.getIndex() == 1 && this.iMJ.getData() != null) {
                this.iNh.gl(this.iMJ.getData().testId);
                i = this.iMJ.getDataIndex();
            } else if (this.iMK.getIndex() == 1 && this.iMK.getData() != null) {
                this.iNh.gl(this.iMK.getData().testId);
                i = this.iMK.getDataIndex();
            } else {
                this.iNh.gl(-1L);
            }
            if (z) {
                xO(i);
            }
        }
    }

    private void initAnimation() {
        this.iNb = ValueAnimator.ofFloat(this.iMO, 0.0f);
        this.iNb.setDuration(200L);
        this.iNb.setInterpolator(new DecelerateInterpolator());
        this.iNb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.iMO) * 0.2f;
                    if (ForumTestView.this.iNi) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cwR();
                        } else {
                            ForumTestView.this.cwS();
                        }
                        ForumTestView.this.iNi = false;
                    }
                    ForumTestView.this.bVe = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.iMI);
                    ForumTestView.this.d(ForumTestView.this.iMJ);
                    ForumTestView.this.d(ForumTestView.this.iMK);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.pX(z);
                } else {
                    if (ForumTestView.this.iNi) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.xM(2) != null && ForumTestView.this.xM(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cwR();
                                ForumTestView.this.iNi = false;
                            }
                        } else if (ForumTestView.this.xM(0) != null && ForumTestView.this.xM(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cwS();
                            ForumTestView.this.iNi = false;
                        }
                    }
                    float f = ForumTestView.this.bVe - floatValue;
                    float f2 = ForumTestView.this.iMY * f;
                    ForumTestView.this.b(ForumTestView.this.iMI, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iMJ, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iMK, f, f2);
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
        this.iNi = false;
        this.bVe = 0.0f;
        initAnimation();
        if (this.iMH.size() == 2) {
            CellForumTestView cellForumTestView = null;
            CellForumTestView cellForumTestView2 = null;
            if (this.iMI.getVisibility() == 0) {
                cellForumTestView = this.iMI;
            }
            if (this.iMJ.getVisibility() == 0) {
                if (cellForumTestView == null) {
                    cellForumTestView = this.iMJ;
                } else {
                    cellForumTestView2 = this.iMJ;
                }
            }
            if (this.iMK.getVisibility() == 0) {
                cellForumTestView2 = this.iMK;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                float viewLeft2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
                viewLeft = viewLeft2;
            } else {
                viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
            }
            if (!(viewLeft < ((float) this.iMV[0].left) || viewRight > ((float) this.iMV[2].right)) && Math.abs(this.mDistance) >= this.iMO * 0.2f) {
                this.iNi = true;
            }
        } else if (this.iMH.size() > 2 && Math.abs(this.mDistance) >= this.iMO * 0.2f) {
            this.iNi = true;
        }
        if (this.iNi && (xM = xM(1)) != null) {
            if (this.mDistance >= this.iMO) {
                this.mDistance -= this.iMO;
                this.iNi = false;
                cwS();
            } else if (this.mDistance > 0.0f && this.mDistance < this.iMO) {
                this.mDistance = this.iMV[0].right - xM.getViewRight();
            } else if (this.mDistance > (-this.iMO)) {
                this.mDistance = this.iMV[2].left - xM.getViewLeft();
            } else {
                cwR();
                this.mDistance += this.iMO;
                this.iNi = false;
            }
        }
        this.iNb.setFloatValues(0.0f, this.mDistance);
        this.iNb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwR() {
        this.iMI.setIndex(this.iMI.getIndex() + 1);
        this.iMJ.setIndex(this.iMJ.getIndex() + 1);
        this.iMK.setIndex(this.iMK.getIndex() + 1);
        b(this.iMI);
        b(this.iMJ);
        b(this.iMK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwS() {
        this.iMI.setIndex(this.iMI.getIndex() - 1);
        this.iMJ.setIndex(this.iMJ.getIndex() - 1);
        this.iMK.setIndex(this.iMK.getIndex() - 1);
        b(this.iMI);
        b(this.iMJ);
        b(this.iMK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView xM(int i) {
        if (this.iMI.getIndex() == i) {
            return this.iMI;
        }
        if (this.iMJ.getIndex() == i) {
            return this.iMJ;
        }
        if (this.iMK.getIndex() == i) {
            return this.iMK;
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
            int size = this.iMH.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int xN(int i) {
        int size = this.iMH.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.iMV[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.iMV[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.iMV[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.iMV[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.iNd && this.mDistance == 0.0f) {
            this.iMH = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.iMI.setVisibility(0);
                this.iMJ.setVisibility(0);
                this.iMK.setVisibility(0);
                this.iMI.setData(list.get(0));
                this.iMJ.setData(list.get(1));
                this.iMK.setData(list.get(2));
                this.iMI.setDataIndex(0);
                this.iMJ.setDataIndex(1);
                this.iMK.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.iMI.setVisibility(8);
                this.iMJ.setVisibility(0);
                this.iMK.setVisibility(0);
                this.iMJ.setDataIndex(1);
                this.iMK.setDataIndex(0);
                this.iMJ.setData(list.get(1));
                this.iMK.setData(list.get(0));
                i = 1;
            } else {
                this.iMI.setVisibility(8);
                this.iMJ.setVisibility(0);
                this.iMK.setVisibility(8);
                this.iMJ.setDataIndex(0);
                this.iMJ.setData(list.get(0));
                i = 0;
            }
            xO(i);
        }
    }

    private void resetData() {
        this.iMI.setIndex(0);
        this.iMJ.setIndex(1);
        this.iMK.setIndex(2);
        this.iML.setIndex(1);
        d(this.iMI);
        d(this.iMJ);
        d(this.iMK);
        d(this.iML);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void xL(int i) {
        CellForumTestView cellForumTestView;
        this.iNe = true;
        this.iML.setVisibility(0);
        this.iML.setAlpha(1.0f);
        cwT();
        if (this.iMI.getIndex() == i && this.iMI.getVisibility() == 0) {
            cellForumTestView = this.iMI;
        } else if (this.iMJ.getIndex() == i && this.iMJ.getVisibility() == 0) {
            cellForumTestView = this.iMJ;
        } else {
            cellForumTestView = this.iMK;
        }
        this.iML.setData(cellForumTestView.getData());
        this.iML.setDataIndex(cellForumTestView.getDataIndex());
        this.iMN = null;
        if (this.iMH.size() == 1) {
            this.iNf = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.iMO * 3) / 5;
        } else if (this.iMH.size() == 2) {
            this.iNf = 2;
            cellForumTestView.setVisibility(8);
            if (this.iMI.getVisibility() == 0) {
                this.iMM = this.iMI;
            } else if (this.iMJ.getVisibility() == 0) {
                this.iMM = this.iMJ;
            } else {
                this.iMM = this.iMK;
            }
            if (this.iMM.getViewRight() < this.iMV[1].left) {
                this.mDistance = this.iMO + this.iMU;
                this.iMM.setIndex(this.iMM.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.iMM.getViewLeft() > this.iMV[1].right) {
                this.mDistance = (-this.iMO) - this.iMU;
                this.iMM.setIndex(this.iMM.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.iMM);
            b(cellForumTestView);
        } else if (this.iMH.size() == 3) {
            this.iNf = 3;
            cellForumTestView.setVisibility(8);
            if (this.iMI.getIndex() == 2) {
                this.iMM = this.iMI;
            } else if (this.iMJ.getIndex() == 2) {
                this.iMM = this.iMJ;
            } else {
                this.iMM = this.iMK;
            }
            this.mDistance = (-this.iMO) - this.iMU;
            this.iMM.setIndex(this.iMM.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.iMM);
            b(cellForumTestView);
        } else {
            this.iNf = 4;
            this.iMN = cellForumTestView;
            if (this.iMI.getIndex() == 2) {
                this.iMM = this.iMI;
            } else if (this.iMJ.getIndex() == 2) {
                this.iMM = this.iMJ;
            } else {
                this.iMM = this.iMK;
            }
            this.mDistance = (-this.iMO) - this.iMU;
            this.iMM.setIndex(this.iMM.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.iMM);
            b(cellForumTestView);
            this.iMN.setViewLeft(this.iMV[2].right + this.iMU);
            this.iMN.setViewRight(this.iMV[2].right + this.iMU + this.iMO);
            this.iMN.setViewTop(this.iMV[2].top);
            this.iMN.setViewBottom(this.iMV[2].bottom);
            this.iMN.setMoveLeft(this.iMV[2].right + this.iMU);
            this.iMN.setMoveRight(this.iMV[2].right + this.iMU + this.iMO);
            this.iMN.setMoveTop(this.iMV[2].top);
            this.iMN.setMoveBottom(this.iMV[2].bottom);
            this.iMN.setData(this.iMH.get(xN(this.iMN.getDataIndex() + 2)));
        }
        this.iNc.setFloatValues(0.0f, this.mDistance);
        this.iNc.start();
    }

    private void cwT() {
        this.iMI.setMoveLeft(this.iMI.getViewLeft());
        this.iMI.setMoveTop(this.iMI.getViewTop());
        this.iMI.setMoveRight(this.iMI.getViewRight());
        this.iMI.setMoveBottom(this.iMI.getViewBottom());
        this.iMJ.setMoveLeft(this.iMJ.getViewLeft());
        this.iMJ.setMoveTop(this.iMJ.getViewTop());
        this.iMJ.setMoveRight(this.iMJ.getViewRight());
        this.iMJ.setMoveBottom(this.iMJ.getViewBottom());
        this.iMK.setMoveLeft(this.iMK.getViewLeft());
        this.iMK.setMoveTop(this.iMK.getViewTop());
        this.iMK.setMoveRight(this.iMK.getViewRight());
        this.iMK.setMoveBottom(this.iMK.getViewBottom());
        this.iML.setMoveLeft(this.iML.getViewLeft());
        this.iML.setMoveTop(this.iML.getViewTop());
        this.iML.setMoveRight(this.iML.getViewRight());
        this.iML.setMoveBottom(this.iML.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0205);
            this.iMI.onChangeSkinType();
            this.iMJ.onChangeSkinType();
            this.iMK.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.iNd && this.mDistance == 0.0f) {
            if (this.iNb != null) {
                this.iNb.removeAllUpdateListeners();
                this.iNb.cancel();
            }
            if (this.iNc != null) {
                this.iNc.removeAllUpdateListeners();
                this.iNc.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.iMI != null) {
            this.iMI.setPageId(bdUniqueId);
        }
        if (this.iMJ != null) {
            this.iMJ.setPageId(bdUniqueId);
        }
        if (this.iMK != null) {
            this.iMK.setPageId(bdUniqueId);
        }
    }

    public void xO(int i) {
        f fVar;
        ar a2;
        if (this.iMH != null && i >= 0 && i < this.iMH.size() && (fVar = this.iMH.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dMr().a(this.mPageId, com.baidu.tieba.s.a.SR("" + fVar.testId), a2);
        }
    }
}
