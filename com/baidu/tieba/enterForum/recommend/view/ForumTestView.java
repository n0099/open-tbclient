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
/* loaded from: classes4.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private List<f> fdJ;
    private CellForumTestView fdK;
    private CellForumTestView fdL;
    private CellForumTestView fdM;
    private CellForumTestView fdN;
    private CellForumTestView fdO;
    private CellForumTestView fdP;
    private int fdQ;
    private int fdR;
    private int fdS;
    private int fdT;
    private int fdU;
    private int fdV;
    private int fdW;
    private Rect[] fdX;
    private float fdY;
    private float fdZ;
    private float fea;
    private float feb;
    private float fec;
    private ValueAnimator fed;
    private float fee;
    private ValueAnimator fef;
    private boolean feg;
    private boolean feh;
    private int fei;
    private int fej;
    private a fek;
    private boolean fel;
    private float fem;
    private int fen;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;
    private int yv;

    /* loaded from: classes4.dex */
    public interface a {
        void cF(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fdX = new Rect[3];
        this.feg = false;
        this.feh = false;
        this.fel = false;
        this.fem = 0.0f;
        this.fen = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fdX = new Rect[3];
        this.feg = false;
        this.feh = false;
        this.fel = false;
        this.fem = 0.0f;
        this.fen = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fdX = new Rect[3];
        this.feg = false;
        this.feh = false;
        this.fel = false;
        this.fem = 0.0f;
        this.fen = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fdK = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fdL = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fdM = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fdN = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        ds(context);
        resetData();
        ViewConfiguration.get(context);
        this.yv = ViewConfiguration.getMaximumFlingVelocity();
        this.fdK.setForumTestDelClickListener(this);
        this.fdL.setForumTestDelClickListener(this);
        this.fdM.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void ds(Context context) {
        this.fdU = l.getDimens(context, R.dimen.tbds44);
        this.fdV = l.getDimens(context, R.dimen.tbds30);
        this.fdW = l.getDimens(context, R.dimen.tbds7);
        this.fdT = l.getDimens(context, R.dimen.tbds730);
        this.fdS = this.fdT - (this.fdV * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.fdQ = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fdT + this.fdU;
        this.fdR = ((this.mWidth - this.fdQ) - (this.fdW * 2)) / 2;
        this.fea = this.fdV / (this.fdQ + this.fdW);
        this.feb = this.fdT / this.fdQ;
        this.fec = this.fdQ / (this.fdQ + this.fdW);
        this.fdX[0] = new Rect(this.fdR - this.fdQ, this.fdU + this.fdV, this.fdR, this.fdU + this.fdV + this.fdS);
        this.fdX[1] = new Rect(this.fdR + this.fdW, this.fdU, this.fdR + this.fdW + this.fdQ, this.fdU + this.fdT);
        this.fdX[2] = new Rect(this.mWidth - this.fdR, this.fdU + this.fdV, (this.mWidth - this.fdR) + this.fdQ, this.fdU + this.fdV + this.fdS);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.fef = ValueAnimator.ofFloat(this.fdQ, 0.0f);
        this.fef.setDuration(500L);
        this.fef.setInterpolator(new DecelerateInterpolator());
        this.fef.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fei != 1) {
                    if (ForumTestView.this.fei == 2 || ForumTestView.this.fei == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fea * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.feb;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.fee)) {
                            ForumTestView.this.fdN.setAlpha(0.0f);
                            ForumTestView.this.fdN.setVisibility(8);
                            ForumTestView.this.fee = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fdO);
                            ForumTestView.this.d(ForumTestView.this.fdN);
                            ForumTestView.this.fdJ.remove(ForumTestView.this.fdN.getData());
                            ForumTestView.this.jk(true);
                            ForumTestView.this.feh = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fdO, floatValue, abs);
                            if ((ForumTestView.this.fdQ * 2) / 5 >= ForumTestView.this.fdN.getViewRight() - ForumTestView.this.fdN.getViewLeft()) {
                                ForumTestView.this.fdN.setAlpha(0.0f);
                                ForumTestView.this.fdN.setVisibility(8);
                            } else {
                                ForumTestView.this.fdN.setViewLeft(ForumTestView.this.fdN.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fdN.setViewRight(ForumTestView.this.fdN.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fdN.setViewTop(ForumTestView.this.fdN.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fdN.setViewBottom(ForumTestView.this.fdN.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fdN.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fdQ * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fea * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.feb;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.fee)) {
                        ForumTestView.this.fdN.setAlpha(0.0f);
                        ForumTestView.this.fdN.setVisibility(8);
                        ForumTestView.this.fee = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fdO);
                        ForumTestView.this.d(ForumTestView.this.fdN);
                        ForumTestView.this.d(ForumTestView.this.fdP);
                        ForumTestView.this.fdJ.remove(ForumTestView.this.fdN.getData());
                        if (ForumTestView.this.fdK.getIndex() == 0) {
                            if (ForumTestView.this.fdK.getDataIndex() > ForumTestView.this.fdP.getDataIndex()) {
                                ForumTestView.this.fdK.setDataIndex(ForumTestView.this.fdK.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fdK);
                            }
                        } else if (ForumTestView.this.fdL.getIndex() == 0) {
                            if (ForumTestView.this.fdL.getDataIndex() > ForumTestView.this.fdP.getDataIndex()) {
                                ForumTestView.this.fdL.setDataIndex(ForumTestView.this.fdL.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fdL);
                            }
                        } else if (ForumTestView.this.fdM.getDataIndex() > ForumTestView.this.fdP.getDataIndex()) {
                            ForumTestView.this.fdM.setDataIndex(ForumTestView.this.fdM.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fdM);
                        }
                        if (ForumTestView.this.fdO.getDataIndex() > ForumTestView.this.fdP.getDataIndex()) {
                            ForumTestView.this.fdO.setDataIndex(ForumTestView.this.fdO.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fdO);
                        }
                        ForumTestView.this.fdP.setDataIndex(ForumTestView.this.fdP.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fdP);
                        ForumTestView.this.jk(true);
                        ForumTestView.this.feh = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fdO, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fdP, floatValue2);
                        if ((ForumTestView.this.fdQ * 2) / 5 >= ForumTestView.this.fdN.getViewRight() - ForumTestView.this.fdN.getViewLeft()) {
                            ForumTestView.this.fdN.setAlpha(0.0f);
                            ForumTestView.this.fdN.setVisibility(8);
                        } else {
                            ForumTestView.this.fdN.setViewLeft(ForumTestView.this.fdN.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fdN.setViewRight(ForumTestView.this.fdN.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fdN.setViewTop(ForumTestView.this.fdN.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fdN.setViewBottom(ForumTestView.this.fdN.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fdN.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fdQ * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.feb * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.fee / 2.0f)) {
                    ForumTestView.this.fdN.setAlpha(0.0f);
                    ForumTestView.this.fdN.setVisibility(8);
                    ForumTestView.this.fee = 0.0f;
                    ForumTestView.this.fdJ.remove(ForumTestView.this.fdN.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.fek != null) {
                        ForumTestView.this.fek.cF(-1L);
                    }
                    ForumTestView.this.feh = false;
                } else {
                    ForumTestView.this.fdN.setViewLeft(ForumTestView.this.fdN.getMoveLeft() + floatValue3);
                    ForumTestView.this.fdN.setViewRight(ForumTestView.this.fdN.getMoveRight() - floatValue3);
                    ForumTestView.this.fdN.setViewTop(ForumTestView.this.fdN.getMoveTop() + f);
                    ForumTestView.this.fdN.setViewBottom(ForumTestView.this.fdN.getMoveBottom() - f);
                    ForumTestView.this.fdN.setAlpha(1.0f - (floatValue3 / ForumTestView.this.fee));
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
            if (equipmentWidth != this.fen) {
                this.fen = equipmentWidth;
                ds(getContext());
                d(this.fdK);
                d(this.fdL);
                d(this.fdM);
                d(this.fdN);
            }
            a(this.fdK);
            a(this.fdL);
            a(this.fdM);
            a(this.fdN);
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
            this.fdK.layout((int) this.fdK.getViewLeft(), (int) this.fdK.getViewTop(), (int) this.fdK.getViewRight(), (int) this.fdK.getViewBottom());
            this.fdL.layout((int) this.fdL.getViewLeft(), (int) this.fdL.getViewTop(), (int) this.fdL.getViewRight(), (int) this.fdL.getViewBottom());
            this.fdM.layout((int) this.fdM.getViewLeft(), (int) this.fdM.getViewTop(), (int) this.fdM.getViewRight(), (int) this.fdM.getViewBottom());
            this.fdN.layout((int) this.fdN.getViewLeft(), (int) this.fdN.getViewTop(), (int) this.fdN.getViewRight(), (int) this.fdN.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.fef == null || !this.fef.isRunning()) {
            if (this.fed == null || !this.fed.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fed != null) {
                        this.fed.removeAllUpdateListeners();
                        this.fed.cancel();
                    }
                    this.fej = motionEvent.getPointerId(0);
                    this.fdY = x;
                    this.fdZ = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fdY - x;
                    float f2 = this.fdZ - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.feg = true;
                        this.fee = f;
                    } else if (Math.abs(f2) > 30.0f && !this.feg) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fea * f3;
                    if (this.feg) {
                        b(this.fdK, f3, f4);
                        b(this.fdL, f3, f4);
                        b(this.fdM, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.yv);
                    float xVelocity = velocityTracker.getXVelocity(this.fej);
                    if (this.feg || this.fee != 0.0f) {
                        ak(xVelocity);
                    }
                    this.feg = false;
                    releaseVelocityTracker();
                }
                if (this.feg || this.fee != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.fdJ.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fdX[0].right - (this.fdQ / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fdX[0].right - (this.fdQ / 2))) + this.fdX[2].left + (this.fdQ / 2) + this.fdW);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fdQ);
                    cellForumTestView.setViewTop(this.fdX[2].top);
                    cellForumTestView.setViewBottom(this.fdX[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fdJ.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fdX[2].left + (this.fdQ / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fdX[2].left + (this.fdQ / 2))) + ((this.fdX[0].right - (this.fdQ / 2)) - this.fdW));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fdQ);
                    cellForumTestView.setViewTop(this.fdX[0].top);
                    cellForumTestView.setViewBottom(this.fdX[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.fdJ.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fdX[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fdX[0].top) {
                    cellForumTestView.setViewTop(this.fdX[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fdX[0].bottom) {
                    cellForumTestView.setViewBottom(this.fdX[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fdX[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fdX[1].top) {
                    cellForumTestView.setViewTop(this.fdX[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fdX[1].bottom) {
                    cellForumTestView.setViewBottom(this.fdX[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.fek = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk(boolean z) {
        if (this.fek != null) {
            int i = -1;
            if (this.fdK.getIndex() == 1 && this.fdK.getData() != null) {
                this.fek.cF(this.fdK.getData().testId);
                i = this.fdK.getDataIndex();
            } else if (this.fdL.getIndex() == 1 && this.fdL.getData() != null) {
                this.fek.cF(this.fdL.getData().testId);
                i = this.fdL.getDataIndex();
            } else if (this.fdM.getIndex() == 1 && this.fdM.getData() != null) {
                this.fek.cF(this.fdM.getData().testId);
                i = this.fdM.getDataIndex();
            } else {
                this.fek.cF(-1L);
            }
            if (z) {
                pG(i);
            }
        }
    }

    private void wJ() {
        this.fed = ValueAnimator.ofFloat(this.fdQ, 0.0f);
        this.fed.setDuration(200L);
        this.fed.setInterpolator(new DecelerateInterpolator());
        this.fed.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.fee)) {
                    boolean z = Math.abs(ForumTestView.this.fee) >= ((float) ForumTestView.this.fdQ) * 0.2f;
                    if (ForumTestView.this.fel) {
                        if (ForumTestView.this.fee > 0.0f) {
                            ForumTestView.this.bfd();
                        } else {
                            ForumTestView.this.bfe();
                        }
                        ForumTestView.this.fel = false;
                    }
                    ForumTestView.this.fem = 0.0f;
                    ForumTestView.this.fee = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fdK);
                    ForumTestView.this.d(ForumTestView.this.fdL);
                    ForumTestView.this.d(ForumTestView.this.fdM);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.jk(z);
                } else {
                    if (ForumTestView.this.fel) {
                        if (ForumTestView.this.fee > 0.0f) {
                            if (ForumTestView.this.pE(2) != null && ForumTestView.this.pE(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bfd();
                                ForumTestView.this.fel = false;
                            }
                        } else if (ForumTestView.this.pE(0) != null && ForumTestView.this.pE(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bfe();
                            ForumTestView.this.fel = false;
                        }
                    }
                    float f = ForumTestView.this.fem - floatValue;
                    float f2 = ForumTestView.this.fea * f;
                    ForumTestView.this.b(ForumTestView.this.fdK, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fdL, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fdM, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fem = floatValue;
            }
        });
    }

    private void ak(float f) {
        CellForumTestView pE;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fel = false;
        this.fem = 0.0f;
        wJ();
        if (this.fdJ.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fdK.getVisibility() == 0) {
                cellForumTestView3 = this.fdK;
            }
            if (this.fdL.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fdL;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fdL;
            }
            if (this.fdM.getVisibility() == 0) {
                cellForumTestView2 = this.fdM;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fdX[0].left) || viewRight > ((float) this.fdX[2].right)) && Math.abs(this.fee) >= this.fdQ * 0.2f) {
                this.fel = true;
            }
        } else if (this.fdJ.size() > 2 && Math.abs(this.fee) >= this.fdQ * 0.2f) {
            this.fel = true;
        }
        if (this.fel && (pE = pE(1)) != null) {
            if (this.fee >= this.fdQ) {
                this.fee -= this.fdQ;
                this.fel = false;
                bfe();
            } else if (this.fee > 0.0f && this.fee < this.fdQ) {
                this.fee = this.fdX[0].right - pE.getViewRight();
            } else if (this.fee > (-this.fdQ)) {
                this.fee = this.fdX[2].left - pE.getViewLeft();
            } else {
                bfd();
                this.fee += this.fdQ;
                this.fel = false;
            }
        }
        this.fed.setFloatValues(0.0f, this.fee);
        this.fed.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfd() {
        this.fdK.setIndex(this.fdK.getIndex() + 1);
        this.fdL.setIndex(this.fdL.getIndex() + 1);
        this.fdM.setIndex(this.fdM.getIndex() + 1);
        b(this.fdK);
        b(this.fdL);
        b(this.fdM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfe() {
        this.fdK.setIndex(this.fdK.getIndex() - 1);
        this.fdL.setIndex(this.fdL.getIndex() - 1);
        this.fdM.setIndex(this.fdM.getIndex() - 1);
        b(this.fdK);
        b(this.fdL);
        b(this.fdM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView pE(int i) {
        if (this.fdK.getIndex() == i) {
            return this.fdK;
        }
        if (this.fdL.getIndex() == i) {
            return this.fdL;
        }
        if (this.fdM.getIndex() == i) {
            return this.fdM;
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
            int size = this.fdJ.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int pF(int i) {
        int size = this.fdJ.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fdX[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fdX[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fdX[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fdX[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.feg && this.fee == 0.0f) {
            this.fdJ = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.fdK.setVisibility(0);
                this.fdL.setVisibility(0);
                this.fdM.setVisibility(0);
                this.fdK.setData(list.get(0));
                this.fdL.setData(list.get(1));
                this.fdM.setData(list.get(2));
                this.fdK.setDataIndex(0);
                this.fdL.setDataIndex(1);
                this.fdM.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.fdK.setVisibility(8);
                this.fdL.setVisibility(0);
                this.fdM.setVisibility(0);
                this.fdL.setDataIndex(1);
                this.fdM.setDataIndex(0);
                this.fdL.setData(list.get(1));
                this.fdM.setData(list.get(0));
                i = 1;
            } else {
                this.fdK.setVisibility(8);
                this.fdL.setVisibility(0);
                this.fdM.setVisibility(8);
                this.fdL.setDataIndex(0);
                this.fdL.setData(list.get(0));
                i = 0;
            }
            pG(i);
        }
    }

    private void resetData() {
        this.fdK.setIndex(0);
        this.fdL.setIndex(1);
        this.fdM.setIndex(2);
        this.fdN.setIndex(1);
        d(this.fdK);
        d(this.fdL);
        d(this.fdM);
        d(this.fdN);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void pD(int i) {
        CellForumTestView cellForumTestView;
        this.feh = true;
        this.fdN.setVisibility(0);
        this.fdN.setAlpha(1.0f);
        bff();
        if (this.fdK.getIndex() == i && this.fdK.getVisibility() == 0) {
            cellForumTestView = this.fdK;
        } else if (this.fdL.getIndex() == i && this.fdL.getVisibility() == 0) {
            cellForumTestView = this.fdL;
        } else {
            cellForumTestView = this.fdM;
        }
        this.fdN.setData(cellForumTestView.getData());
        this.fdN.setDataIndex(cellForumTestView.getDataIndex());
        this.fdP = null;
        if (this.fdJ.size() == 1) {
            this.fei = 1;
            cellForumTestView.setVisibility(8);
            this.fee = (this.fdQ * 3) / 5;
        } else if (this.fdJ.size() == 2) {
            this.fei = 2;
            cellForumTestView.setVisibility(8);
            if (this.fdK.getVisibility() == 0) {
                this.fdO = this.fdK;
            } else if (this.fdL.getVisibility() == 0) {
                this.fdO = this.fdL;
            } else {
                this.fdO = this.fdM;
            }
            if (this.fdO.getViewRight() < this.fdX[1].left) {
                this.fee = this.fdQ + this.fdW;
                this.fdO.setIndex(this.fdO.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fdO.getViewLeft() > this.fdX[1].right) {
                this.fee = (-this.fdQ) - this.fdW;
                this.fdO.setIndex(this.fdO.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fdO);
            b(cellForumTestView);
        } else if (this.fdJ.size() == 3) {
            this.fei = 3;
            cellForumTestView.setVisibility(8);
            if (this.fdK.getIndex() == 2) {
                this.fdO = this.fdK;
            } else if (this.fdL.getIndex() == 2) {
                this.fdO = this.fdL;
            } else {
                this.fdO = this.fdM;
            }
            this.fee = (-this.fdQ) - this.fdW;
            this.fdO.setIndex(this.fdO.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fdO);
            b(cellForumTestView);
        } else {
            this.fei = 4;
            this.fdP = cellForumTestView;
            if (this.fdK.getIndex() == 2) {
                this.fdO = this.fdK;
            } else if (this.fdL.getIndex() == 2) {
                this.fdO = this.fdL;
            } else {
                this.fdO = this.fdM;
            }
            this.fee = (-this.fdQ) - this.fdW;
            this.fdO.setIndex(this.fdO.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fdO);
            b(cellForumTestView);
            this.fdP.setViewLeft(this.fdX[2].right + this.fdW);
            this.fdP.setViewRight(this.fdX[2].right + this.fdW + this.fdQ);
            this.fdP.setViewTop(this.fdX[2].top);
            this.fdP.setViewBottom(this.fdX[2].bottom);
            this.fdP.setMoveLeft(this.fdX[2].right + this.fdW);
            this.fdP.setMoveRight(this.fdX[2].right + this.fdW + this.fdQ);
            this.fdP.setMoveTop(this.fdX[2].top);
            this.fdP.setMoveBottom(this.fdX[2].bottom);
            this.fdP.setData(this.fdJ.get(pF(this.fdP.getDataIndex() + 2)));
        }
        this.fef.setFloatValues(0.0f, this.fee);
        this.fef.start();
    }

    private void bff() {
        this.fdK.setMoveLeft(this.fdK.getViewLeft());
        this.fdK.setMoveTop(this.fdK.getViewTop());
        this.fdK.setMoveRight(this.fdK.getViewRight());
        this.fdK.setMoveBottom(this.fdK.getViewBottom());
        this.fdL.setMoveLeft(this.fdL.getViewLeft());
        this.fdL.setMoveTop(this.fdL.getViewTop());
        this.fdL.setMoveRight(this.fdL.getViewRight());
        this.fdL.setMoveBottom(this.fdL.getViewBottom());
        this.fdM.setMoveLeft(this.fdM.getViewLeft());
        this.fdM.setMoveTop(this.fdM.getViewTop());
        this.fdM.setMoveRight(this.fdM.getViewRight());
        this.fdM.setMoveBottom(this.fdM.getViewBottom());
        this.fdN.setMoveLeft(this.fdN.getViewLeft());
        this.fdN.setMoveTop(this.fdN.getViewTop());
        this.fdN.setMoveRight(this.fdN.getViewRight());
        this.fdN.setMoveBottom(this.fdN.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.fdK.onChangeSkinType();
            this.fdL.onChangeSkinType();
            this.fdM.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.feg && this.fee == 0.0f) {
            if (this.fed != null) {
                this.fed.removeAllUpdateListeners();
                this.fed.cancel();
            }
            if (this.fef != null) {
                this.fef.removeAllUpdateListeners();
                this.fef.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fdK != null) {
            this.fdK.setPageId(bdUniqueId);
        }
        if (this.fdL != null) {
            this.fdL.setPageId(bdUniqueId);
        }
        if (this.fdM != null) {
            this.fdM.setPageId(bdUniqueId);
        }
    }

    public void pG(int i) {
        f fVar;
        an a2;
        if (this.fdJ != null && i >= 0 && i < this.fdJ.size() && (fVar = this.fdJ.get(i)) != null && (a2 = com.baidu.tieba.q.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.q.c.cni().a(this.mPageId, "enterfourm_rec_" + fVar.testId, a2);
        }
    }
}
