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
    private List<f> inK;
    private CellForumTestView inL;
    private CellForumTestView inM;
    private CellForumTestView inN;
    private CellForumTestView inO;
    private CellForumTestView inP;
    private CellForumTestView inQ;
    private int inR;
    private int inS;
    private int inT;
    private int inU;
    private int inV;
    private int inW;
    private int inX;
    private Rect[] inY;
    private float inZ;
    private float ioa;
    private float iob;
    private float ioc;
    private float iod;
    private ValueAnimator ioe;
    private ValueAnimator iof;
    private boolean iog;
    private boolean ioh;
    private int ioi;
    private int ioj;
    private a iok;
    private boolean iol;
    private float iom;
    private int ion;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void csN();

        void fz(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.inY = new Rect[3];
        this.iog = false;
        this.ioh = false;
        this.iol = false;
        this.iom = 0.0f;
        this.ion = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.inY = new Rect[3];
        this.iog = false;
        this.ioh = false;
        this.iol = false;
        this.iom = 0.0f;
        this.ion = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.inY = new Rect[3];
        this.iog = false;
        this.ioh = false;
        this.iol = false;
        this.iom = 0.0f;
        this.ion = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.inL = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.inM = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.inN = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.inO = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        fl(context);
        resetData();
        ViewConfiguration.get(context);
        this.WP = ViewConfiguration.getMaximumFlingVelocity();
        this.inL.setForumTestDelClickListener(this);
        this.inM.setForumTestDelClickListener(this);
        this.inN.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void fl(Context context) {
        this.inV = l.getDimens(context, R.dimen.tbds44);
        this.inW = l.getDimens(context, R.dimen.tbds30);
        this.inX = l.getDimens(context, R.dimen.tbds7);
        this.inU = l.getDimens(context, R.dimen.tbds730);
        this.inT = this.inU - (this.inW * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.inR = (int) (this.mWidth * 0.89f);
        this.mHeight = this.inU + this.inV;
        this.inS = ((this.mWidth - this.inR) - (this.inX * 2)) / 2;
        this.iob = this.inW / (this.inR + this.inX);
        this.ioc = this.inU / this.inR;
        this.iod = this.inR / (this.inR + this.inX);
        this.inY[0] = new Rect(this.inS - this.inR, this.inV + this.inW, this.inS, this.inV + this.inW + this.inT);
        this.inY[1] = new Rect(this.inS + this.inX, this.inV, this.inS + this.inX + this.inR, this.inV + this.inU);
        this.inY[2] = new Rect(this.mWidth - this.inS, this.inV + this.inW, (this.mWidth - this.inS) + this.inR, this.inV + this.inW + this.inT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iof = ValueAnimator.ofFloat(this.inR, 0.0f);
        this.iof.setDuration(500L);
        this.iof.setInterpolator(new DecelerateInterpolator());
        this.iof.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.ioi != 1) {
                    if (ForumTestView.this.ioi == 2 || ForumTestView.this.ioi == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.iob * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.ioc;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.inO.setAlpha(0.0f);
                            ForumTestView.this.inO.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.inP);
                            ForumTestView.this.d(ForumTestView.this.inO);
                            ForumTestView.this.inK.remove(ForumTestView.this.inO.getData());
                            ForumTestView.this.oV(true);
                            ForumTestView.this.ioh = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.inP, floatValue, abs);
                            if ((ForumTestView.this.inR * 2) / 5 >= ForumTestView.this.inO.getViewRight() - ForumTestView.this.inO.getViewLeft()) {
                                ForumTestView.this.inO.setAlpha(0.0f);
                                ForumTestView.this.inO.setVisibility(8);
                            } else {
                                ForumTestView.this.inO.setViewLeft(ForumTestView.this.inO.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.inO.setViewRight(ForumTestView.this.inO.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.inO.setViewTop(ForumTestView.this.inO.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.inO.setViewBottom(ForumTestView.this.inO.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.inO.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.inR * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.iob * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.ioc;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.inO.setAlpha(0.0f);
                        ForumTestView.this.inO.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.inP);
                        ForumTestView.this.d(ForumTestView.this.inO);
                        ForumTestView.this.d(ForumTestView.this.inQ);
                        ForumTestView.this.inK.remove(ForumTestView.this.inO.getData());
                        if (ForumTestView.this.inL.getIndex() == 0) {
                            if (ForumTestView.this.inL.getDataIndex() > ForumTestView.this.inQ.getDataIndex()) {
                                ForumTestView.this.inL.setDataIndex(ForumTestView.this.inL.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.inL);
                            }
                        } else if (ForumTestView.this.inM.getIndex() == 0) {
                            if (ForumTestView.this.inM.getDataIndex() > ForumTestView.this.inQ.getDataIndex()) {
                                ForumTestView.this.inM.setDataIndex(ForumTestView.this.inM.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.inM);
                            }
                        } else if (ForumTestView.this.inN.getDataIndex() > ForumTestView.this.inQ.getDataIndex()) {
                            ForumTestView.this.inN.setDataIndex(ForumTestView.this.inN.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.inN);
                        }
                        if (ForumTestView.this.inP.getDataIndex() > ForumTestView.this.inQ.getDataIndex()) {
                            ForumTestView.this.inP.setDataIndex(ForumTestView.this.inP.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.inP);
                        }
                        ForumTestView.this.inQ.setDataIndex(ForumTestView.this.inQ.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.inQ);
                        ForumTestView.this.oV(true);
                        ForumTestView.this.ioh = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.inP, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.inQ, floatValue2);
                        if ((ForumTestView.this.inR * 2) / 5 >= ForumTestView.this.inO.getViewRight() - ForumTestView.this.inO.getViewLeft()) {
                            ForumTestView.this.inO.setAlpha(0.0f);
                            ForumTestView.this.inO.setVisibility(8);
                        } else {
                            ForumTestView.this.inO.setViewLeft(ForumTestView.this.inO.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.inO.setViewRight(ForumTestView.this.inO.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.inO.setViewTop(ForumTestView.this.inO.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.inO.setViewBottom(ForumTestView.this.inO.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.inO.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.inR * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.ioc * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.inO.setAlpha(0.0f);
                    ForumTestView.this.inO.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.inK.remove(ForumTestView.this.inO.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.iok != null) {
                        ForumTestView.this.iok.fz(-1L);
                    }
                    ForumTestView.this.ioh = false;
                    if (ForumTestView.this.iok != null && y.isEmpty(ForumTestView.this.inK)) {
                        ForumTestView.this.iok.csN();
                    }
                } else {
                    ForumTestView.this.inO.setViewLeft(ForumTestView.this.inO.getMoveLeft() + floatValue3);
                    ForumTestView.this.inO.setViewRight(ForumTestView.this.inO.getMoveRight() - floatValue3);
                    ForumTestView.this.inO.setViewTop(ForumTestView.this.inO.getMoveTop() + f);
                    ForumTestView.this.inO.setViewBottom(ForumTestView.this.inO.getMoveBottom() - f);
                    ForumTestView.this.inO.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.ion) {
                this.ion = equipmentWidth;
                fl(getContext());
                d(this.inL);
                d(this.inM);
                d(this.inN);
                d(this.inO);
            }
            a(this.inL);
            a(this.inM);
            a(this.inN);
            a(this.inO);
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
            this.inL.layout((int) this.inL.getViewLeft(), (int) this.inL.getViewTop(), (int) this.inL.getViewRight(), (int) this.inL.getViewBottom());
            this.inM.layout((int) this.inM.getViewLeft(), (int) this.inM.getViewTop(), (int) this.inM.getViewRight(), (int) this.inM.getViewBottom());
            this.inN.layout((int) this.inN.getViewLeft(), (int) this.inN.getViewTop(), (int) this.inN.getViewRight(), (int) this.inN.getViewBottom());
            this.inO.layout((int) this.inO.getViewLeft(), (int) this.inO.getViewTop(), (int) this.inO.getViewRight(), (int) this.inO.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.iof == null || !this.iof.isRunning()) {
            if (this.ioe == null || !this.ioe.isRunning()) {
                int action = motionEvent.getAction();
                Z(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.ioe != null) {
                        this.ioe.removeAllUpdateListeners();
                        this.ioe.cancel();
                    }
                    this.ioj = motionEvent.getPointerId(0);
                    this.inZ = x;
                    this.ioa = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.inZ - x;
                    float f2 = this.ioa - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.iog = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.iog) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.iob * f3;
                    if (this.iog) {
                        b(this.inL, f3, f4);
                        b(this.inM, f3, f4);
                        b(this.inN, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.WP);
                    float xVelocity = velocityTracker.getXVelocity(this.ioj);
                    if (this.iog || this.mDistance != 0.0f) {
                        aw(xVelocity);
                    }
                    this.iog = false;
                    releaseVelocityTracker();
                }
                if (this.iog || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return true;
    }

    private void Z(MotionEvent motionEvent) {
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
            if (this.inK.size() > 2) {
                if (cellForumTestView.getViewRight() < this.inY[0].right - (this.inR / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.inY[0].right - (this.inR / 2))) + this.inY[2].left + (this.inR / 2) + this.inX);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.inR);
                    cellForumTestView.setViewTop(this.inY[2].top);
                    cellForumTestView.setViewBottom(this.inY[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.inK.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.inY[2].left + (this.inR / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.inY[2].left + (this.inR / 2))) + ((this.inY[0].right - (this.inR / 2)) - this.inX));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.inR);
                    cellForumTestView.setViewTop(this.inY[0].top);
                    cellForumTestView.setViewBottom(this.inY[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.inK.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.inY[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.inY[0].top) {
                    cellForumTestView.setViewTop(this.inY[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.inY[0].bottom) {
                    cellForumTestView.setViewBottom(this.inY[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.inY[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.inY[1].top) {
                    cellForumTestView.setViewTop(this.inY[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.inY[1].bottom) {
                    cellForumTestView.setViewBottom(this.inY[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.iok = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oV(boolean z) {
        if (this.iok != null) {
            int i = -1;
            if (this.inL.getIndex() == 1 && this.inL.getData() != null) {
                this.iok.fz(this.inL.getData().testId);
                i = this.inL.getDataIndex();
            } else if (this.inM.getIndex() == 1 && this.inM.getData() != null) {
                this.iok.fz(this.inM.getData().testId);
                i = this.inM.getDataIndex();
            } else if (this.inN.getIndex() == 1 && this.inN.getData() != null) {
                this.iok.fz(this.inN.getData().testId);
                i = this.inN.getDataIndex();
            } else {
                this.iok.fz(-1L);
            }
            if (z) {
                xU(i);
            }
        }
    }

    private void initAnimation() {
        this.ioe = ValueAnimator.ofFloat(this.inR, 0.0f);
        this.ioe.setDuration(200L);
        this.ioe.setInterpolator(new DecelerateInterpolator());
        this.ioe.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.inR) * 0.2f;
                    if (ForumTestView.this.iol) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.csK();
                        } else {
                            ForumTestView.this.csL();
                        }
                        ForumTestView.this.iol = false;
                    }
                    ForumTestView.this.iom = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.inL);
                    ForumTestView.this.d(ForumTestView.this.inM);
                    ForumTestView.this.d(ForumTestView.this.inN);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.oV(z);
                } else {
                    if (ForumTestView.this.iol) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.xS(2) != null && ForumTestView.this.xS(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.csK();
                                ForumTestView.this.iol = false;
                            }
                        } else if (ForumTestView.this.xS(0) != null && ForumTestView.this.xS(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.csL();
                            ForumTestView.this.iol = false;
                        }
                    }
                    float f = ForumTestView.this.iom - floatValue;
                    float f2 = ForumTestView.this.iob * f;
                    ForumTestView.this.b(ForumTestView.this.inL, f, f2);
                    ForumTestView.this.b(ForumTestView.this.inM, f, f2);
                    ForumTestView.this.b(ForumTestView.this.inN, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.iom = floatValue;
            }
        });
    }

    private void aw(float f) {
        CellForumTestView xS;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.iol = false;
        this.iom = 0.0f;
        initAnimation();
        if (this.inK.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.inL.getVisibility() == 0) {
                cellForumTestView3 = this.inL;
            }
            if (this.inM.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.inM;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.inM;
            }
            if (this.inN.getVisibility() == 0) {
                cellForumTestView2 = this.inN;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.inY[0].left) || viewRight > ((float) this.inY[2].right)) && Math.abs(this.mDistance) >= this.inR * 0.2f) {
                this.iol = true;
            }
        } else if (this.inK.size() > 2 && Math.abs(this.mDistance) >= this.inR * 0.2f) {
            this.iol = true;
        }
        if (this.iol && (xS = xS(1)) != null) {
            if (this.mDistance >= this.inR) {
                this.mDistance -= this.inR;
                this.iol = false;
                csL();
            } else if (this.mDistance > 0.0f && this.mDistance < this.inR) {
                this.mDistance = this.inY[0].right - xS.getViewRight();
            } else if (this.mDistance > (-this.inR)) {
                this.mDistance = this.inY[2].left - xS.getViewLeft();
            } else {
                csK();
                this.mDistance += this.inR;
                this.iol = false;
            }
        }
        this.ioe.setFloatValues(0.0f, this.mDistance);
        this.ioe.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csK() {
        this.inL.setIndex(this.inL.getIndex() + 1);
        this.inM.setIndex(this.inM.getIndex() + 1);
        this.inN.setIndex(this.inN.getIndex() + 1);
        b(this.inL);
        b(this.inM);
        b(this.inN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csL() {
        this.inL.setIndex(this.inL.getIndex() - 1);
        this.inM.setIndex(this.inM.getIndex() - 1);
        this.inN.setIndex(this.inN.getIndex() - 1);
        b(this.inL);
        b(this.inM);
        b(this.inN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView xS(int i) {
        if (this.inL.getIndex() == i) {
            return this.inL;
        }
        if (this.inM.getIndex() == i) {
            return this.inM;
        }
        if (this.inN.getIndex() == i) {
            return this.inN;
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
            int size = this.inK.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int xT(int i) {
        int size = this.inK.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.inY[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.inY[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.inY[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.inY[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.iog && this.mDistance == 0.0f) {
            this.inK = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.inL.setVisibility(0);
                this.inM.setVisibility(0);
                this.inN.setVisibility(0);
                this.inL.setData(list.get(0));
                this.inM.setData(list.get(1));
                this.inN.setData(list.get(2));
                this.inL.setDataIndex(0);
                this.inM.setDataIndex(1);
                this.inN.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.inL.setVisibility(8);
                this.inM.setVisibility(0);
                this.inN.setVisibility(0);
                this.inM.setDataIndex(1);
                this.inN.setDataIndex(0);
                this.inM.setData(list.get(1));
                this.inN.setData(list.get(0));
                i = 1;
            } else {
                this.inL.setVisibility(8);
                this.inM.setVisibility(0);
                this.inN.setVisibility(8);
                this.inM.setDataIndex(0);
                this.inM.setData(list.get(0));
                i = 0;
            }
            xU(i);
        }
    }

    private void resetData() {
        this.inL.setIndex(0);
        this.inM.setIndex(1);
        this.inN.setIndex(2);
        this.inO.setIndex(1);
        d(this.inL);
        d(this.inM);
        d(this.inN);
        d(this.inO);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void xR(int i) {
        CellForumTestView cellForumTestView;
        this.ioh = true;
        this.inO.setVisibility(0);
        this.inO.setAlpha(1.0f);
        csM();
        if (this.inL.getIndex() == i && this.inL.getVisibility() == 0) {
            cellForumTestView = this.inL;
        } else if (this.inM.getIndex() == i && this.inM.getVisibility() == 0) {
            cellForumTestView = this.inM;
        } else {
            cellForumTestView = this.inN;
        }
        this.inO.setData(cellForumTestView.getData());
        this.inO.setDataIndex(cellForumTestView.getDataIndex());
        this.inQ = null;
        if (this.inK.size() == 1) {
            this.ioi = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.inR * 3) / 5;
        } else if (this.inK.size() == 2) {
            this.ioi = 2;
            cellForumTestView.setVisibility(8);
            if (this.inL.getVisibility() == 0) {
                this.inP = this.inL;
            } else if (this.inM.getVisibility() == 0) {
                this.inP = this.inM;
            } else {
                this.inP = this.inN;
            }
            if (this.inP.getViewRight() < this.inY[1].left) {
                this.mDistance = this.inR + this.inX;
                this.inP.setIndex(this.inP.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.inP.getViewLeft() > this.inY[1].right) {
                this.mDistance = (-this.inR) - this.inX;
                this.inP.setIndex(this.inP.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.inP);
            b(cellForumTestView);
        } else if (this.inK.size() == 3) {
            this.ioi = 3;
            cellForumTestView.setVisibility(8);
            if (this.inL.getIndex() == 2) {
                this.inP = this.inL;
            } else if (this.inM.getIndex() == 2) {
                this.inP = this.inM;
            } else {
                this.inP = this.inN;
            }
            this.mDistance = (-this.inR) - this.inX;
            this.inP.setIndex(this.inP.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.inP);
            b(cellForumTestView);
        } else {
            this.ioi = 4;
            this.inQ = cellForumTestView;
            if (this.inL.getIndex() == 2) {
                this.inP = this.inL;
            } else if (this.inM.getIndex() == 2) {
                this.inP = this.inM;
            } else {
                this.inP = this.inN;
            }
            this.mDistance = (-this.inR) - this.inX;
            this.inP.setIndex(this.inP.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.inP);
            b(cellForumTestView);
            this.inQ.setViewLeft(this.inY[2].right + this.inX);
            this.inQ.setViewRight(this.inY[2].right + this.inX + this.inR);
            this.inQ.setViewTop(this.inY[2].top);
            this.inQ.setViewBottom(this.inY[2].bottom);
            this.inQ.setMoveLeft(this.inY[2].right + this.inX);
            this.inQ.setMoveRight(this.inY[2].right + this.inX + this.inR);
            this.inQ.setMoveTop(this.inY[2].top);
            this.inQ.setMoveBottom(this.inY[2].bottom);
            this.inQ.setData(this.inK.get(xT(this.inQ.getDataIndex() + 2)));
        }
        this.iof.setFloatValues(0.0f, this.mDistance);
        this.iof.start();
    }

    private void csM() {
        this.inL.setMoveLeft(this.inL.getViewLeft());
        this.inL.setMoveTop(this.inL.getViewTop());
        this.inL.setMoveRight(this.inL.getViewRight());
        this.inL.setMoveBottom(this.inL.getViewBottom());
        this.inM.setMoveLeft(this.inM.getViewLeft());
        this.inM.setMoveTop(this.inM.getViewTop());
        this.inM.setMoveRight(this.inM.getViewRight());
        this.inM.setMoveBottom(this.inM.getViewBottom());
        this.inN.setMoveLeft(this.inN.getViewLeft());
        this.inN.setMoveTop(this.inN.getViewTop());
        this.inN.setMoveRight(this.inN.getViewRight());
        this.inN.setMoveBottom(this.inN.getViewBottom());
        this.inO.setMoveLeft(this.inO.getViewLeft());
        this.inO.setMoveTop(this.inO.getViewTop());
        this.inO.setMoveRight(this.inO.getViewRight());
        this.inO.setMoveBottom(this.inO.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.inL.onChangeSkinType();
            this.inM.onChangeSkinType();
            this.inN.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.iog && this.mDistance == 0.0f) {
            if (this.ioe != null) {
                this.ioe.removeAllUpdateListeners();
                this.ioe.cancel();
            }
            if (this.iof != null) {
                this.iof.removeAllUpdateListeners();
                this.iof.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.inL != null) {
            this.inL.setPageId(bdUniqueId);
        }
        if (this.inM != null) {
            this.inM.setPageId(bdUniqueId);
        }
        if (this.inN != null) {
            this.inN.setPageId(bdUniqueId);
        }
    }

    public void xU(int i) {
        f fVar;
        aq a2;
        if (this.inK != null && i >= 0 && i < this.inK.size() && (fVar = this.inK.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dIX().a(this.mPageId, com.baidu.tieba.s.a.SE("" + fVar.testId), a2);
        }
    }
}
