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
    private int Zb;
    private float bWE;
    private List<f> iOE;
    private CellForumTestView iOF;
    private CellForumTestView iOG;
    private CellForumTestView iOH;
    private CellForumTestView iOI;
    private CellForumTestView iOJ;
    private CellForumTestView iOK;
    private int iOL;
    private int iOM;
    private int iON;
    private int iOO;
    private int iOP;
    private int iOQ;
    private int iOR;
    private Rect[] iOS;
    private float iOT;
    private float iOU;
    private float iOV;
    private float iOW;
    private float iOX;
    private ValueAnimator iOY;
    private ValueAnimator iOZ;
    private boolean iPa;
    private boolean iPb;
    private int iPc;
    private int iPd;
    private a iPe;
    private boolean iPf;
    private int iPg;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void cxh();

        void gl(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iOS = new Rect[3];
        this.iPa = false;
        this.iPb = false;
        this.iPf = false;
        this.bWE = 0.0f;
        this.iPg = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iOS = new Rect[3];
        this.iPa = false;
        this.iPb = false;
        this.iPf = false;
        this.bWE = 0.0f;
        this.iPg = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iOS = new Rect[3];
        this.iPa = false;
        this.iPb = false;
        this.iPf = false;
        this.bWE = 0.0f;
        this.iPg = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.iOF = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.iOG = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.iOH = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.iOI = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        gi(context);
        resetData();
        ViewConfiguration.get(context);
        this.Zb = ViewConfiguration.getMaximumFlingVelocity();
        this.iOF.setForumTestDelClickListener(this);
        this.iOG.setForumTestDelClickListener(this);
        this.iOH.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void gi(Context context) {
        this.iOP = l.getDimens(context, R.dimen.tbds44);
        this.iOQ = l.getDimens(context, R.dimen.tbds30);
        this.iOR = l.getDimens(context, R.dimen.tbds7);
        this.iOO = l.getDimens(context, R.dimen.tbds730);
        this.iON = this.iOO - (this.iOQ * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.iOL = (int) (this.mWidth * 0.89f);
        this.mHeight = this.iOO + this.iOP;
        this.iOM = ((this.mWidth - this.iOL) - (this.iOR * 2)) / 2;
        this.iOV = this.iOQ / (this.iOL + this.iOR);
        this.iOW = this.iOO / this.iOL;
        this.iOX = this.iOL / (this.iOL + this.iOR);
        this.iOS[0] = new Rect(this.iOM - this.iOL, this.iOP + this.iOQ, this.iOM, this.iOP + this.iOQ + this.iON);
        this.iOS[1] = new Rect(this.iOM + this.iOR, this.iOP, this.iOM + this.iOR + this.iOL, this.iOP + this.iOO);
        this.iOS[2] = new Rect(this.mWidth - this.iOM, this.iOP + this.iOQ, (this.mWidth - this.iOM) + this.iOL, this.iOP + this.iOQ + this.iON);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iOZ = ValueAnimator.ofFloat(this.iOL, 0.0f);
        this.iOZ.setDuration(500L);
        this.iOZ.setInterpolator(new DecelerateInterpolator());
        this.iOZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.iPc != 1) {
                    if (ForumTestView.this.iPc == 2 || ForumTestView.this.iPc == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.iOV * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.iOW;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.iOI.setAlpha(0.0f);
                            ForumTestView.this.iOI.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.iOJ);
                            ForumTestView.this.d(ForumTestView.this.iOI);
                            ForumTestView.this.iOE.remove(ForumTestView.this.iOI.getData());
                            ForumTestView.this.pX(true);
                            ForumTestView.this.iPb = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.iOJ, floatValue, abs);
                            if ((ForumTestView.this.iOL * 2) / 5 >= ForumTestView.this.iOI.getViewRight() - ForumTestView.this.iOI.getViewLeft()) {
                                ForumTestView.this.iOI.setAlpha(0.0f);
                                ForumTestView.this.iOI.setVisibility(8);
                            } else {
                                ForumTestView.this.iOI.setViewLeft(ForumTestView.this.iOI.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iOI.setViewRight(ForumTestView.this.iOI.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iOI.setViewTop(ForumTestView.this.iOI.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.iOI.setViewBottom(ForumTestView.this.iOI.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.iOI.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.iOL * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.iOV * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.iOW;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.iOI.setAlpha(0.0f);
                        ForumTestView.this.iOI.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.iOJ);
                        ForumTestView.this.d(ForumTestView.this.iOI);
                        ForumTestView.this.d(ForumTestView.this.iOK);
                        ForumTestView.this.iOE.remove(ForumTestView.this.iOI.getData());
                        if (ForumTestView.this.iOF.getIndex() == 0) {
                            if (ForumTestView.this.iOF.getDataIndex() > ForumTestView.this.iOK.getDataIndex()) {
                                ForumTestView.this.iOF.setDataIndex(ForumTestView.this.iOF.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iOF);
                            }
                        } else if (ForumTestView.this.iOG.getIndex() == 0) {
                            if (ForumTestView.this.iOG.getDataIndex() > ForumTestView.this.iOK.getDataIndex()) {
                                ForumTestView.this.iOG.setDataIndex(ForumTestView.this.iOG.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iOG);
                            }
                        } else if (ForumTestView.this.iOH.getDataIndex() > ForumTestView.this.iOK.getDataIndex()) {
                            ForumTestView.this.iOH.setDataIndex(ForumTestView.this.iOH.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iOH);
                        }
                        if (ForumTestView.this.iOJ.getDataIndex() > ForumTestView.this.iOK.getDataIndex()) {
                            ForumTestView.this.iOJ.setDataIndex(ForumTestView.this.iOJ.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iOJ);
                        }
                        ForumTestView.this.iOK.setDataIndex(ForumTestView.this.iOK.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.iOK);
                        ForumTestView.this.pX(true);
                        ForumTestView.this.iPb = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.iOJ, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.iOK, floatValue2);
                        if ((ForumTestView.this.iOL * 2) / 5 >= ForumTestView.this.iOI.getViewRight() - ForumTestView.this.iOI.getViewLeft()) {
                            ForumTestView.this.iOI.setAlpha(0.0f);
                            ForumTestView.this.iOI.setVisibility(8);
                        } else {
                            ForumTestView.this.iOI.setViewLeft(ForumTestView.this.iOI.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iOI.setViewRight(ForumTestView.this.iOI.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iOI.setViewTop(ForumTestView.this.iOI.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.iOI.setViewBottom(ForumTestView.this.iOI.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.iOI.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.iOL * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.iOW * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.iOI.setAlpha(0.0f);
                    ForumTestView.this.iOI.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.iOE.remove(ForumTestView.this.iOI.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.iPe != null) {
                        ForumTestView.this.iPe.gl(-1L);
                    }
                    ForumTestView.this.iPb = false;
                    if (ForumTestView.this.iPe != null && y.isEmpty(ForumTestView.this.iOE)) {
                        ForumTestView.this.iPe.cxh();
                    }
                } else {
                    ForumTestView.this.iOI.setViewLeft(ForumTestView.this.iOI.getMoveLeft() + floatValue3);
                    ForumTestView.this.iOI.setViewRight(ForumTestView.this.iOI.getMoveRight() - floatValue3);
                    ForumTestView.this.iOI.setViewTop(ForumTestView.this.iOI.getMoveTop() + f);
                    ForumTestView.this.iOI.setViewBottom(ForumTestView.this.iOI.getMoveBottom() - f);
                    ForumTestView.this.iOI.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.iPg) {
                this.iPg = equipmentWidth;
                gi(getContext());
                d(this.iOF);
                d(this.iOG);
                d(this.iOH);
                d(this.iOI);
            }
            a(this.iOF);
            a(this.iOG);
            a(this.iOH);
            a(this.iOI);
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
            this.iOF.layout((int) this.iOF.getViewLeft(), (int) this.iOF.getViewTop(), (int) this.iOF.getViewRight(), (int) this.iOF.getViewBottom());
            this.iOG.layout((int) this.iOG.getViewLeft(), (int) this.iOG.getViewTop(), (int) this.iOG.getViewRight(), (int) this.iOG.getViewBottom());
            this.iOH.layout((int) this.iOH.getViewLeft(), (int) this.iOH.getViewTop(), (int) this.iOH.getViewRight(), (int) this.iOH.getViewBottom());
            this.iOI.layout((int) this.iOI.getViewLeft(), (int) this.iOI.getViewTop(), (int) this.iOI.getViewRight(), (int) this.iOI.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.iOZ == null || !this.iOZ.isRunning()) {
            if (this.iOY == null || !this.iOY.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.iOY != null) {
                        this.iOY.removeAllUpdateListeners();
                        this.iOY.cancel();
                    }
                    this.iPd = motionEvent.getPointerId(0);
                    this.iOT = x;
                    this.iOU = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.iOT - x;
                    float f2 = this.iOU - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.iPa = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.iPa) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.iOV * f3;
                    if (this.iPa) {
                        b(this.iOF, f3, f4);
                        b(this.iOG, f3, f4);
                        b(this.iOH, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Zb);
                    float xVelocity = velocityTracker.getXVelocity(this.iPd);
                    if (this.iPa || this.mDistance != 0.0f) {
                        aM(xVelocity);
                    }
                    this.iPa = false;
                    releaseVelocityTracker();
                }
                if (this.iPa || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.iOE.size() > 2) {
                if (cellForumTestView.getViewRight() < this.iOS[0].right - (this.iOL / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.iOS[0].right - (this.iOL / 2))) + this.iOS[2].left + (this.iOL / 2) + this.iOR);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.iOL);
                    cellForumTestView.setViewTop(this.iOS[2].top);
                    cellForumTestView.setViewBottom(this.iOS[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iOE.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.iOS[2].left + (this.iOL / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.iOS[2].left + (this.iOL / 2))) + ((this.iOS[0].right - (this.iOL / 2)) - this.iOR));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.iOL);
                    cellForumTestView.setViewTop(this.iOS[0].top);
                    cellForumTestView.setViewBottom(this.iOS[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iOE.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.iOS[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.iOS[0].top) {
                    cellForumTestView.setViewTop(this.iOS[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.iOS[0].bottom) {
                    cellForumTestView.setViewBottom(this.iOS[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.iOS[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.iOS[1].top) {
                    cellForumTestView.setViewTop(this.iOS[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.iOS[1].bottom) {
                    cellForumTestView.setViewBottom(this.iOS[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.iPe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(boolean z) {
        if (this.iPe != null) {
            int i = -1;
            if (this.iOF.getIndex() == 1 && this.iOF.getData() != null) {
                this.iPe.gl(this.iOF.getData().testId);
                i = this.iOF.getDataIndex();
            } else if (this.iOG.getIndex() == 1 && this.iOG.getData() != null) {
                this.iPe.gl(this.iOG.getData().testId);
                i = this.iOG.getDataIndex();
            } else if (this.iOH.getIndex() == 1 && this.iOH.getData() != null) {
                this.iPe.gl(this.iOH.getData().testId);
                i = this.iOH.getDataIndex();
            } else {
                this.iPe.gl(-1L);
            }
            if (z) {
                xP(i);
            }
        }
    }

    private void initAnimation() {
        this.iOY = ValueAnimator.ofFloat(this.iOL, 0.0f);
        this.iOY.setDuration(200L);
        this.iOY.setInterpolator(new DecelerateInterpolator());
        this.iOY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.iOL) * 0.2f;
                    if (ForumTestView.this.iPf) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cxe();
                        } else {
                            ForumTestView.this.cxf();
                        }
                        ForumTestView.this.iPf = false;
                    }
                    ForumTestView.this.bWE = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.iOF);
                    ForumTestView.this.d(ForumTestView.this.iOG);
                    ForumTestView.this.d(ForumTestView.this.iOH);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.pX(z);
                } else {
                    if (ForumTestView.this.iPf) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.xN(2) != null && ForumTestView.this.xN(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cxe();
                                ForumTestView.this.iPf = false;
                            }
                        } else if (ForumTestView.this.xN(0) != null && ForumTestView.this.xN(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cxf();
                            ForumTestView.this.iPf = false;
                        }
                    }
                    float f = ForumTestView.this.bWE - floatValue;
                    float f2 = ForumTestView.this.iOV * f;
                    ForumTestView.this.b(ForumTestView.this.iOF, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iOG, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iOH, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.bWE = floatValue;
            }
        });
    }

    private void aM(float f) {
        CellForumTestView xN;
        float viewLeft;
        float viewRight;
        this.iPf = false;
        this.bWE = 0.0f;
        initAnimation();
        if (this.iOE.size() == 2) {
            CellForumTestView cellForumTestView = null;
            CellForumTestView cellForumTestView2 = null;
            if (this.iOF.getVisibility() == 0) {
                cellForumTestView = this.iOF;
            }
            if (this.iOG.getVisibility() == 0) {
                if (cellForumTestView == null) {
                    cellForumTestView = this.iOG;
                } else {
                    cellForumTestView2 = this.iOG;
                }
            }
            if (this.iOH.getVisibility() == 0) {
                cellForumTestView2 = this.iOH;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                float viewLeft2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
                viewLeft = viewLeft2;
            } else {
                viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
            }
            if (!(viewLeft < ((float) this.iOS[0].left) || viewRight > ((float) this.iOS[2].right)) && Math.abs(this.mDistance) >= this.iOL * 0.2f) {
                this.iPf = true;
            }
        } else if (this.iOE.size() > 2 && Math.abs(this.mDistance) >= this.iOL * 0.2f) {
            this.iPf = true;
        }
        if (this.iPf && (xN = xN(1)) != null) {
            if (this.mDistance >= this.iOL) {
                this.mDistance -= this.iOL;
                this.iPf = false;
                cxf();
            } else if (this.mDistance > 0.0f && this.mDistance < this.iOL) {
                this.mDistance = this.iOS[0].right - xN.getViewRight();
            } else if (this.mDistance > (-this.iOL)) {
                this.mDistance = this.iOS[2].left - xN.getViewLeft();
            } else {
                cxe();
                this.mDistance += this.iOL;
                this.iPf = false;
            }
        }
        this.iOY.setFloatValues(0.0f, this.mDistance);
        this.iOY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxe() {
        this.iOF.setIndex(this.iOF.getIndex() + 1);
        this.iOG.setIndex(this.iOG.getIndex() + 1);
        this.iOH.setIndex(this.iOH.getIndex() + 1);
        b(this.iOF);
        b(this.iOG);
        b(this.iOH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxf() {
        this.iOF.setIndex(this.iOF.getIndex() - 1);
        this.iOG.setIndex(this.iOG.getIndex() - 1);
        this.iOH.setIndex(this.iOH.getIndex() - 1);
        b(this.iOF);
        b(this.iOG);
        b(this.iOH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView xN(int i) {
        if (this.iOF.getIndex() == i) {
            return this.iOF;
        }
        if (this.iOG.getIndex() == i) {
            return this.iOG;
        }
        if (this.iOH.getIndex() == i) {
            return this.iOH;
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
            int size = this.iOE.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int xO(int i) {
        int size = this.iOE.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.iOS[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.iOS[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.iOS[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.iOS[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.iPa && this.mDistance == 0.0f) {
            this.iOE = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.iOF.setVisibility(0);
                this.iOG.setVisibility(0);
                this.iOH.setVisibility(0);
                this.iOF.setData(list.get(0));
                this.iOG.setData(list.get(1));
                this.iOH.setData(list.get(2));
                this.iOF.setDataIndex(0);
                this.iOG.setDataIndex(1);
                this.iOH.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.iOF.setVisibility(8);
                this.iOG.setVisibility(0);
                this.iOH.setVisibility(0);
                this.iOG.setDataIndex(1);
                this.iOH.setDataIndex(0);
                this.iOG.setData(list.get(1));
                this.iOH.setData(list.get(0));
                i = 1;
            } else {
                this.iOF.setVisibility(8);
                this.iOG.setVisibility(0);
                this.iOH.setVisibility(8);
                this.iOG.setDataIndex(0);
                this.iOG.setData(list.get(0));
                i = 0;
            }
            xP(i);
        }
    }

    private void resetData() {
        this.iOF.setIndex(0);
        this.iOG.setIndex(1);
        this.iOH.setIndex(2);
        this.iOI.setIndex(1);
        d(this.iOF);
        d(this.iOG);
        d(this.iOH);
        d(this.iOI);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void xM(int i) {
        CellForumTestView cellForumTestView;
        this.iPb = true;
        this.iOI.setVisibility(0);
        this.iOI.setAlpha(1.0f);
        cxg();
        if (this.iOF.getIndex() == i && this.iOF.getVisibility() == 0) {
            cellForumTestView = this.iOF;
        } else if (this.iOG.getIndex() == i && this.iOG.getVisibility() == 0) {
            cellForumTestView = this.iOG;
        } else {
            cellForumTestView = this.iOH;
        }
        this.iOI.setData(cellForumTestView.getData());
        this.iOI.setDataIndex(cellForumTestView.getDataIndex());
        this.iOK = null;
        if (this.iOE.size() == 1) {
            this.iPc = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.iOL * 3) / 5;
        } else if (this.iOE.size() == 2) {
            this.iPc = 2;
            cellForumTestView.setVisibility(8);
            if (this.iOF.getVisibility() == 0) {
                this.iOJ = this.iOF;
            } else if (this.iOG.getVisibility() == 0) {
                this.iOJ = this.iOG;
            } else {
                this.iOJ = this.iOH;
            }
            if (this.iOJ.getViewRight() < this.iOS[1].left) {
                this.mDistance = this.iOL + this.iOR;
                this.iOJ.setIndex(this.iOJ.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.iOJ.getViewLeft() > this.iOS[1].right) {
                this.mDistance = (-this.iOL) - this.iOR;
                this.iOJ.setIndex(this.iOJ.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.iOJ);
            b(cellForumTestView);
        } else if (this.iOE.size() == 3) {
            this.iPc = 3;
            cellForumTestView.setVisibility(8);
            if (this.iOF.getIndex() == 2) {
                this.iOJ = this.iOF;
            } else if (this.iOG.getIndex() == 2) {
                this.iOJ = this.iOG;
            } else {
                this.iOJ = this.iOH;
            }
            this.mDistance = (-this.iOL) - this.iOR;
            this.iOJ.setIndex(this.iOJ.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.iOJ);
            b(cellForumTestView);
        } else {
            this.iPc = 4;
            this.iOK = cellForumTestView;
            if (this.iOF.getIndex() == 2) {
                this.iOJ = this.iOF;
            } else if (this.iOG.getIndex() == 2) {
                this.iOJ = this.iOG;
            } else {
                this.iOJ = this.iOH;
            }
            this.mDistance = (-this.iOL) - this.iOR;
            this.iOJ.setIndex(this.iOJ.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.iOJ);
            b(cellForumTestView);
            this.iOK.setViewLeft(this.iOS[2].right + this.iOR);
            this.iOK.setViewRight(this.iOS[2].right + this.iOR + this.iOL);
            this.iOK.setViewTop(this.iOS[2].top);
            this.iOK.setViewBottom(this.iOS[2].bottom);
            this.iOK.setMoveLeft(this.iOS[2].right + this.iOR);
            this.iOK.setMoveRight(this.iOS[2].right + this.iOR + this.iOL);
            this.iOK.setMoveTop(this.iOS[2].top);
            this.iOK.setMoveBottom(this.iOS[2].bottom);
            this.iOK.setData(this.iOE.get(xO(this.iOK.getDataIndex() + 2)));
        }
        this.iOZ.setFloatValues(0.0f, this.mDistance);
        this.iOZ.start();
    }

    private void cxg() {
        this.iOF.setMoveLeft(this.iOF.getViewLeft());
        this.iOF.setMoveTop(this.iOF.getViewTop());
        this.iOF.setMoveRight(this.iOF.getViewRight());
        this.iOF.setMoveBottom(this.iOF.getViewBottom());
        this.iOG.setMoveLeft(this.iOG.getViewLeft());
        this.iOG.setMoveTop(this.iOG.getViewTop());
        this.iOG.setMoveRight(this.iOG.getViewRight());
        this.iOG.setMoveBottom(this.iOG.getViewBottom());
        this.iOH.setMoveLeft(this.iOH.getViewLeft());
        this.iOH.setMoveTop(this.iOH.getViewTop());
        this.iOH.setMoveRight(this.iOH.getViewRight());
        this.iOH.setMoveBottom(this.iOH.getViewBottom());
        this.iOI.setMoveLeft(this.iOI.getViewLeft());
        this.iOI.setMoveTop(this.iOI.getViewTop());
        this.iOI.setMoveRight(this.iOI.getViewRight());
        this.iOI.setMoveBottom(this.iOI.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0205);
            this.iOF.onChangeSkinType();
            this.iOG.onChangeSkinType();
            this.iOH.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.iPa && this.mDistance == 0.0f) {
            if (this.iOY != null) {
                this.iOY.removeAllUpdateListeners();
                this.iOY.cancel();
            }
            if (this.iOZ != null) {
                this.iOZ.removeAllUpdateListeners();
                this.iOZ.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.iOF != null) {
            this.iOF.setPageId(bdUniqueId);
        }
        if (this.iOG != null) {
            this.iOG.setPageId(bdUniqueId);
        }
        if (this.iOH != null) {
            this.iOH.setPageId(bdUniqueId);
        }
    }

    public void xP(int i) {
        f fVar;
        ar a2;
        if (this.iOE != null && i >= 0 && i < this.iOE.size() && (fVar = this.iOE.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dMH().a(this.mPageId, com.baidu.tieba.s.a.Tj("" + fVar.testId), a2);
        }
    }
}
