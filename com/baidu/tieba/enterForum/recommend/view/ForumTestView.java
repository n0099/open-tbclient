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
    private int Vg;
    private List<f> gTN;
    private CellForumTestView gTO;
    private CellForumTestView gTP;
    private CellForumTestView gTQ;
    private CellForumTestView gTR;
    private CellForumTestView gTS;
    private CellForumTestView gTT;
    private int gTU;
    private int gTV;
    private int gTW;
    private int gTX;
    private int gTY;
    private int gTZ;
    private int gUa;
    private Rect[] gUb;
    private float gUc;
    private float gUd;
    private float gUe;
    private float gUf;
    private float gUg;
    private ValueAnimator gUh;
    private ValueAnimator gUi;
    private boolean gUj;
    private boolean gUk;
    private int gUl;
    private int gUm;
    private a gUn;
    private boolean gUo;
    private float gUp;
    private int gUq;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void bPH();

        void ea(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gUb = new Rect[3];
        this.gUj = false;
        this.gUk = false;
        this.gUo = false;
        this.gUp = 0.0f;
        this.gUq = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gUb = new Rect[3];
        this.gUj = false;
        this.gUk = false;
        this.gUo = false;
        this.gUp = 0.0f;
        this.gUq = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gUb = new Rect[3];
        this.gUj = false;
        this.gUk = false;
        this.gUo = false;
        this.gUp = 0.0f;
        this.gUq = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.gTO = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.gTP = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.gTQ = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.gTR = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eI(context);
        resetData();
        ViewConfiguration.get(context);
        this.Vg = ViewConfiguration.getMaximumFlingVelocity();
        this.gTO.setForumTestDelClickListener(this);
        this.gTP.setForumTestDelClickListener(this);
        this.gTQ.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eI(Context context) {
        this.gTY = l.getDimens(context, R.dimen.tbds44);
        this.gTZ = l.getDimens(context, R.dimen.tbds30);
        this.gUa = l.getDimens(context, R.dimen.tbds7);
        this.gTX = l.getDimens(context, R.dimen.tbds730);
        this.gTW = this.gTX - (this.gTZ * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.gTU = (int) (this.mWidth * 0.89f);
        this.mHeight = this.gTX + this.gTY;
        this.gTV = ((this.mWidth - this.gTU) - (this.gUa * 2)) / 2;
        this.gUe = this.gTZ / (this.gTU + this.gUa);
        this.gUf = this.gTX / this.gTU;
        this.gUg = this.gTU / (this.gTU + this.gUa);
        this.gUb[0] = new Rect(this.gTV - this.gTU, this.gTY + this.gTZ, this.gTV, this.gTY + this.gTZ + this.gTW);
        this.gUb[1] = new Rect(this.gTV + this.gUa, this.gTY, this.gTV + this.gUa + this.gTU, this.gTY + this.gTX);
        this.gUb[2] = new Rect(this.mWidth - this.gTV, this.gTY + this.gTZ, (this.mWidth - this.gTV) + this.gTU, this.gTY + this.gTZ + this.gTW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gUi = ValueAnimator.ofFloat(this.gTU, 0.0f);
        this.gUi.setDuration(500L);
        this.gUi.setInterpolator(new DecelerateInterpolator());
        this.gUi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.gUl != 1) {
                    if (ForumTestView.this.gUl == 2 || ForumTestView.this.gUl == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.gUe * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.gUf;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.gTR.setAlpha(0.0f);
                            ForumTestView.this.gTR.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.gTS);
                            ForumTestView.this.d(ForumTestView.this.gTR);
                            ForumTestView.this.gTN.remove(ForumTestView.this.gTR.getData());
                            ForumTestView.this.mn(true);
                            ForumTestView.this.gUk = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.gTS, floatValue, abs);
                            if ((ForumTestView.this.gTU * 2) / 5 >= ForumTestView.this.gTR.getViewRight() - ForumTestView.this.gTR.getViewLeft()) {
                                ForumTestView.this.gTR.setAlpha(0.0f);
                                ForumTestView.this.gTR.setVisibility(8);
                            } else {
                                ForumTestView.this.gTR.setViewLeft(ForumTestView.this.gTR.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.gTR.setViewRight(ForumTestView.this.gTR.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.gTR.setViewTop(ForumTestView.this.gTR.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.gTR.setViewBottom(ForumTestView.this.gTR.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.gTR.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.gTU * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.gUe * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.gUf;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.gTR.setAlpha(0.0f);
                        ForumTestView.this.gTR.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.gTS);
                        ForumTestView.this.d(ForumTestView.this.gTR);
                        ForumTestView.this.d(ForumTestView.this.gTT);
                        ForumTestView.this.gTN.remove(ForumTestView.this.gTR.getData());
                        if (ForumTestView.this.gTO.getIndex() == 0) {
                            if (ForumTestView.this.gTO.getDataIndex() > ForumTestView.this.gTT.getDataIndex()) {
                                ForumTestView.this.gTO.setDataIndex(ForumTestView.this.gTO.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.gTO);
                            }
                        } else if (ForumTestView.this.gTP.getIndex() == 0) {
                            if (ForumTestView.this.gTP.getDataIndex() > ForumTestView.this.gTT.getDataIndex()) {
                                ForumTestView.this.gTP.setDataIndex(ForumTestView.this.gTP.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.gTP);
                            }
                        } else if (ForumTestView.this.gTQ.getDataIndex() > ForumTestView.this.gTT.getDataIndex()) {
                            ForumTestView.this.gTQ.setDataIndex(ForumTestView.this.gTQ.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.gTQ);
                        }
                        if (ForumTestView.this.gTS.getDataIndex() > ForumTestView.this.gTT.getDataIndex()) {
                            ForumTestView.this.gTS.setDataIndex(ForumTestView.this.gTS.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.gTS);
                        }
                        ForumTestView.this.gTT.setDataIndex(ForumTestView.this.gTT.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.gTT);
                        ForumTestView.this.mn(true);
                        ForumTestView.this.gUk = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.gTS, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.gTT, floatValue2);
                        if ((ForumTestView.this.gTU * 2) / 5 >= ForumTestView.this.gTR.getViewRight() - ForumTestView.this.gTR.getViewLeft()) {
                            ForumTestView.this.gTR.setAlpha(0.0f);
                            ForumTestView.this.gTR.setVisibility(8);
                        } else {
                            ForumTestView.this.gTR.setViewLeft(ForumTestView.this.gTR.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.gTR.setViewRight(ForumTestView.this.gTR.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.gTR.setViewTop(ForumTestView.this.gTR.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.gTR.setViewBottom(ForumTestView.this.gTR.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.gTR.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.gTU * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.gUf * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.gTR.setAlpha(0.0f);
                    ForumTestView.this.gTR.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.gTN.remove(ForumTestView.this.gTR.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.gUn != null) {
                        ForumTestView.this.gUn.ea(-1L);
                    }
                    ForumTestView.this.gUk = false;
                    if (ForumTestView.this.gUn != null && v.isEmpty(ForumTestView.this.gTN)) {
                        ForumTestView.this.gUn.bPH();
                    }
                } else {
                    ForumTestView.this.gTR.setViewLeft(ForumTestView.this.gTR.getMoveLeft() + floatValue3);
                    ForumTestView.this.gTR.setViewRight(ForumTestView.this.gTR.getMoveRight() - floatValue3);
                    ForumTestView.this.gTR.setViewTop(ForumTestView.this.gTR.getMoveTop() + f);
                    ForumTestView.this.gTR.setViewBottom(ForumTestView.this.gTR.getMoveBottom() - f);
                    ForumTestView.this.gTR.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.gUq) {
                this.gUq = equipmentWidth;
                eI(getContext());
                d(this.gTO);
                d(this.gTP);
                d(this.gTQ);
                d(this.gTR);
            }
            a(this.gTO);
            a(this.gTP);
            a(this.gTQ);
            a(this.gTR);
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
            this.gTO.layout((int) this.gTO.getViewLeft(), (int) this.gTO.getViewTop(), (int) this.gTO.getViewRight(), (int) this.gTO.getViewBottom());
            this.gTP.layout((int) this.gTP.getViewLeft(), (int) this.gTP.getViewTop(), (int) this.gTP.getViewRight(), (int) this.gTP.getViewBottom());
            this.gTQ.layout((int) this.gTQ.getViewLeft(), (int) this.gTQ.getViewTop(), (int) this.gTQ.getViewRight(), (int) this.gTQ.getViewBottom());
            this.gTR.layout((int) this.gTR.getViewLeft(), (int) this.gTR.getViewTop(), (int) this.gTR.getViewRight(), (int) this.gTR.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.gUi == null || !this.gUi.isRunning()) {
            if (this.gUh == null || !this.gUh.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.gUh != null) {
                        this.gUh.removeAllUpdateListeners();
                        this.gUh.cancel();
                    }
                    this.gUm = motionEvent.getPointerId(0);
                    this.gUc = x;
                    this.gUd = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.gUc - x;
                    float f2 = this.gUd - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.gUj = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.gUj) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.gUe * f3;
                    if (this.gUj) {
                        b(this.gTO, f3, f4);
                        b(this.gTP, f3, f4);
                        b(this.gTQ, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Vg);
                    float xVelocity = velocityTracker.getXVelocity(this.gUm);
                    if (this.gUj || this.mDistance != 0.0f) {
                        ae(xVelocity);
                    }
                    this.gUj = false;
                    releaseVelocityTracker();
                }
                if (this.gUj || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.gTN.size() > 2) {
                if (cellForumTestView.getViewRight() < this.gUb[0].right - (this.gTU / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.gUb[0].right - (this.gTU / 2))) + this.gUb[2].left + (this.gTU / 2) + this.gUa);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.gTU);
                    cellForumTestView.setViewTop(this.gUb[2].top);
                    cellForumTestView.setViewBottom(this.gUb[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.gTN.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.gUb[2].left + (this.gTU / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.gUb[2].left + (this.gTU / 2))) + ((this.gUb[0].right - (this.gTU / 2)) - this.gUa));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.gTU);
                    cellForumTestView.setViewTop(this.gUb[0].top);
                    cellForumTestView.setViewBottom(this.gUb[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.gTN.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.gUb[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.gUb[0].top) {
                    cellForumTestView.setViewTop(this.gUb[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.gUb[0].bottom) {
                    cellForumTestView.setViewBottom(this.gUb[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.gUb[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.gUb[1].top) {
                    cellForumTestView.setViewTop(this.gUb[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.gUb[1].bottom) {
                    cellForumTestView.setViewBottom(this.gUb[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.gUn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(boolean z) {
        if (this.gUn != null) {
            int i = -1;
            if (this.gTO.getIndex() == 1 && this.gTO.getData() != null) {
                this.gUn.ea(this.gTO.getData().testId);
                i = this.gTO.getDataIndex();
            } else if (this.gTP.getIndex() == 1 && this.gTP.getData() != null) {
                this.gUn.ea(this.gTP.getData().testId);
                i = this.gTP.getDataIndex();
            } else if (this.gTQ.getIndex() == 1 && this.gTQ.getData() != null) {
                this.gUn.ea(this.gTQ.getData().testId);
                i = this.gTQ.getDataIndex();
            } else {
                this.gUn.ea(-1L);
            }
            if (z) {
                sZ(i);
            }
        }
    }

    private void initAnimation() {
        this.gUh = ValueAnimator.ofFloat(this.gTU, 0.0f);
        this.gUh.setDuration(200L);
        this.gUh.setInterpolator(new DecelerateInterpolator());
        this.gUh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.gTU) * 0.2f;
                    if (ForumTestView.this.gUo) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bPE();
                        } else {
                            ForumTestView.this.bPF();
                        }
                        ForumTestView.this.gUo = false;
                    }
                    ForumTestView.this.gUp = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.gTO);
                    ForumTestView.this.d(ForumTestView.this.gTP);
                    ForumTestView.this.d(ForumTestView.this.gTQ);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.mn(z);
                } else {
                    if (ForumTestView.this.gUo) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.sX(2) != null && ForumTestView.this.sX(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bPE();
                                ForumTestView.this.gUo = false;
                            }
                        } else if (ForumTestView.this.sX(0) != null && ForumTestView.this.sX(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bPF();
                            ForumTestView.this.gUo = false;
                        }
                    }
                    float f = ForumTestView.this.gUp - floatValue;
                    float f2 = ForumTestView.this.gUe * f;
                    ForumTestView.this.b(ForumTestView.this.gTO, f, f2);
                    ForumTestView.this.b(ForumTestView.this.gTP, f, f2);
                    ForumTestView.this.b(ForumTestView.this.gTQ, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.gUp = floatValue;
            }
        });
    }

    private void ae(float f) {
        CellForumTestView sX;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.gUo = false;
        this.gUp = 0.0f;
        initAnimation();
        if (this.gTN.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.gTO.getVisibility() == 0) {
                cellForumTestView3 = this.gTO;
            }
            if (this.gTP.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.gTP;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.gTP;
            }
            if (this.gTQ.getVisibility() == 0) {
                cellForumTestView2 = this.gTQ;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.gUb[0].left) || viewRight > ((float) this.gUb[2].right)) && Math.abs(this.mDistance) >= this.gTU * 0.2f) {
                this.gUo = true;
            }
        } else if (this.gTN.size() > 2 && Math.abs(this.mDistance) >= this.gTU * 0.2f) {
            this.gUo = true;
        }
        if (this.gUo && (sX = sX(1)) != null) {
            if (this.mDistance >= this.gTU) {
                this.mDistance -= this.gTU;
                this.gUo = false;
                bPF();
            } else if (this.mDistance > 0.0f && this.mDistance < this.gTU) {
                this.mDistance = this.gUb[0].right - sX.getViewRight();
            } else if (this.mDistance > (-this.gTU)) {
                this.mDistance = this.gUb[2].left - sX.getViewLeft();
            } else {
                bPE();
                this.mDistance += this.gTU;
                this.gUo = false;
            }
        }
        this.gUh.setFloatValues(0.0f, this.mDistance);
        this.gUh.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPE() {
        this.gTO.setIndex(this.gTO.getIndex() + 1);
        this.gTP.setIndex(this.gTP.getIndex() + 1);
        this.gTQ.setIndex(this.gTQ.getIndex() + 1);
        b(this.gTO);
        b(this.gTP);
        b(this.gTQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPF() {
        this.gTO.setIndex(this.gTO.getIndex() - 1);
        this.gTP.setIndex(this.gTP.getIndex() - 1);
        this.gTQ.setIndex(this.gTQ.getIndex() - 1);
        b(this.gTO);
        b(this.gTP);
        b(this.gTQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView sX(int i) {
        if (this.gTO.getIndex() == i) {
            return this.gTO;
        }
        if (this.gTP.getIndex() == i) {
            return this.gTP;
        }
        if (this.gTQ.getIndex() == i) {
            return this.gTQ;
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
            int size = this.gTN.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int sY(int i) {
        int size = this.gTN.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.gUb[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.gUb[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.gUb[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.gUb[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.gUj && this.mDistance == 0.0f) {
            this.gTN = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.gTO.setVisibility(0);
                this.gTP.setVisibility(0);
                this.gTQ.setVisibility(0);
                this.gTO.setData(list.get(0));
                this.gTP.setData(list.get(1));
                this.gTQ.setData(list.get(2));
                this.gTO.setDataIndex(0);
                this.gTP.setDataIndex(1);
                this.gTQ.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.gTO.setVisibility(8);
                this.gTP.setVisibility(0);
                this.gTQ.setVisibility(0);
                this.gTP.setDataIndex(1);
                this.gTQ.setDataIndex(0);
                this.gTP.setData(list.get(1));
                this.gTQ.setData(list.get(0));
                i = 1;
            } else {
                this.gTO.setVisibility(8);
                this.gTP.setVisibility(0);
                this.gTQ.setVisibility(8);
                this.gTP.setDataIndex(0);
                this.gTP.setData(list.get(0));
                i = 0;
            }
            sZ(i);
        }
    }

    private void resetData() {
        this.gTO.setIndex(0);
        this.gTP.setIndex(1);
        this.gTQ.setIndex(2);
        this.gTR.setIndex(1);
        d(this.gTO);
        d(this.gTP);
        d(this.gTQ);
        d(this.gTR);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void sW(int i) {
        CellForumTestView cellForumTestView;
        this.gUk = true;
        this.gTR.setVisibility(0);
        this.gTR.setAlpha(1.0f);
        bPG();
        if (this.gTO.getIndex() == i && this.gTO.getVisibility() == 0) {
            cellForumTestView = this.gTO;
        } else if (this.gTP.getIndex() == i && this.gTP.getVisibility() == 0) {
            cellForumTestView = this.gTP;
        } else {
            cellForumTestView = this.gTQ;
        }
        this.gTR.setData(cellForumTestView.getData());
        this.gTR.setDataIndex(cellForumTestView.getDataIndex());
        this.gTT = null;
        if (this.gTN.size() == 1) {
            this.gUl = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.gTU * 3) / 5;
        } else if (this.gTN.size() == 2) {
            this.gUl = 2;
            cellForumTestView.setVisibility(8);
            if (this.gTO.getVisibility() == 0) {
                this.gTS = this.gTO;
            } else if (this.gTP.getVisibility() == 0) {
                this.gTS = this.gTP;
            } else {
                this.gTS = this.gTQ;
            }
            if (this.gTS.getViewRight() < this.gUb[1].left) {
                this.mDistance = this.gTU + this.gUa;
                this.gTS.setIndex(this.gTS.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.gTS.getViewLeft() > this.gUb[1].right) {
                this.mDistance = (-this.gTU) - this.gUa;
                this.gTS.setIndex(this.gTS.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.gTS);
            b(cellForumTestView);
        } else if (this.gTN.size() == 3) {
            this.gUl = 3;
            cellForumTestView.setVisibility(8);
            if (this.gTO.getIndex() == 2) {
                this.gTS = this.gTO;
            } else if (this.gTP.getIndex() == 2) {
                this.gTS = this.gTP;
            } else {
                this.gTS = this.gTQ;
            }
            this.mDistance = (-this.gTU) - this.gUa;
            this.gTS.setIndex(this.gTS.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.gTS);
            b(cellForumTestView);
        } else {
            this.gUl = 4;
            this.gTT = cellForumTestView;
            if (this.gTO.getIndex() == 2) {
                this.gTS = this.gTO;
            } else if (this.gTP.getIndex() == 2) {
                this.gTS = this.gTP;
            } else {
                this.gTS = this.gTQ;
            }
            this.mDistance = (-this.gTU) - this.gUa;
            this.gTS.setIndex(this.gTS.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.gTS);
            b(cellForumTestView);
            this.gTT.setViewLeft(this.gUb[2].right + this.gUa);
            this.gTT.setViewRight(this.gUb[2].right + this.gUa + this.gTU);
            this.gTT.setViewTop(this.gUb[2].top);
            this.gTT.setViewBottom(this.gUb[2].bottom);
            this.gTT.setMoveLeft(this.gUb[2].right + this.gUa);
            this.gTT.setMoveRight(this.gUb[2].right + this.gUa + this.gTU);
            this.gTT.setMoveTop(this.gUb[2].top);
            this.gTT.setMoveBottom(this.gUb[2].bottom);
            this.gTT.setData(this.gTN.get(sY(this.gTT.getDataIndex() + 2)));
        }
        this.gUi.setFloatValues(0.0f, this.mDistance);
        this.gUi.start();
    }

    private void bPG() {
        this.gTO.setMoveLeft(this.gTO.getViewLeft());
        this.gTO.setMoveTop(this.gTO.getViewTop());
        this.gTO.setMoveRight(this.gTO.getViewRight());
        this.gTO.setMoveBottom(this.gTO.getViewBottom());
        this.gTP.setMoveLeft(this.gTP.getViewLeft());
        this.gTP.setMoveTop(this.gTP.getViewTop());
        this.gTP.setMoveRight(this.gTP.getViewRight());
        this.gTP.setMoveBottom(this.gTP.getViewBottom());
        this.gTQ.setMoveLeft(this.gTQ.getViewLeft());
        this.gTQ.setMoveTop(this.gTQ.getViewTop());
        this.gTQ.setMoveRight(this.gTQ.getViewRight());
        this.gTQ.setMoveBottom(this.gTQ.getViewBottom());
        this.gTR.setMoveLeft(this.gTR.getViewLeft());
        this.gTR.setMoveTop(this.gTR.getViewTop());
        this.gTR.setMoveRight(this.gTR.getViewRight());
        this.gTR.setMoveBottom(this.gTR.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.gTO.onChangeSkinType();
            this.gTP.onChangeSkinType();
            this.gTQ.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.gUj && this.mDistance == 0.0f) {
            if (this.gUh != null) {
                this.gUh.removeAllUpdateListeners();
                this.gUh.cancel();
            }
            if (this.gUi != null) {
                this.gUi.removeAllUpdateListeners();
                this.gUi.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.gTO != null) {
            this.gTO.setPageId(bdUniqueId);
        }
        if (this.gTP != null) {
            this.gTP.setPageId(bdUniqueId);
        }
        if (this.gTQ != null) {
            this.gTQ.setPageId(bdUniqueId);
        }
    }

    public void sZ(int i) {
        f fVar;
        an a2;
        if (this.gTN != null && i >= 0 && i < this.gTN.size() && (fVar = this.gTN.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dct().a(this.mPageId, com.baidu.tieba.s.a.Mo("" + fVar.testId), a2);
        }
    }
}
