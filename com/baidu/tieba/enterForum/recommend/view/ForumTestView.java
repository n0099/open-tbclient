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
/* loaded from: classes21.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int WT;
    private CellForumTestView ioA;
    private CellForumTestView ioB;
    private CellForumTestView ioC;
    private CellForumTestView ioD;
    private CellForumTestView ioE;
    private int ioF;
    private int ioG;
    private int ioH;
    private int ioI;
    private int ioJ;
    private int ioK;
    private int ioL;
    private Rect[] ioM;
    private float ioN;
    private float ioO;
    private float ioP;
    private float ioQ;
    private float ioR;
    private ValueAnimator ioS;
    private ValueAnimator ioT;
    private boolean ioU;
    private boolean ioV;
    private int ioW;
    private int ioX;
    private a ioY;
    private boolean ioZ;
    private List<f> ioy;
    private CellForumTestView ioz;
    private float ipa;
    private int ipb;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes21.dex */
    public interface a {
        void csq();

        void fC(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ioM = new Rect[3];
        this.ioU = false;
        this.ioV = false;
        this.ioZ = false;
        this.ipa = 0.0f;
        this.ipb = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ioM = new Rect[3];
        this.ioU = false;
        this.ioV = false;
        this.ioZ = false;
        this.ipa = 0.0f;
        this.ipb = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ioM = new Rect[3];
        this.ioU = false;
        this.ioV = false;
        this.ioZ = false;
        this.ipa = 0.0f;
        this.ipb = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.ioz = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.ioA = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.ioB = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.ioC = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        fl(context);
        resetData();
        ViewConfiguration.get(context);
        this.WT = ViewConfiguration.getMaximumFlingVelocity();
        this.ioz.setForumTestDelClickListener(this);
        this.ioA.setForumTestDelClickListener(this);
        this.ioB.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void fl(Context context) {
        this.ioJ = l.getDimens(context, R.dimen.tbds44);
        this.ioK = l.getDimens(context, R.dimen.tbds30);
        this.ioL = l.getDimens(context, R.dimen.tbds7);
        this.ioI = l.getDimens(context, R.dimen.tbds730);
        this.ioH = this.ioI - (this.ioK * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.ioF = (int) (this.mWidth * 0.89f);
        this.mHeight = this.ioI + this.ioJ;
        this.ioG = ((this.mWidth - this.ioF) - (this.ioL * 2)) / 2;
        this.ioP = this.ioK / (this.ioF + this.ioL);
        this.ioQ = this.ioI / this.ioF;
        this.ioR = this.ioF / (this.ioF + this.ioL);
        this.ioM[0] = new Rect(this.ioG - this.ioF, this.ioJ + this.ioK, this.ioG, this.ioJ + this.ioK + this.ioH);
        this.ioM[1] = new Rect(this.ioG + this.ioL, this.ioJ, this.ioG + this.ioL + this.ioF, this.ioJ + this.ioI);
        this.ioM[2] = new Rect(this.mWidth - this.ioG, this.ioJ + this.ioK, (this.mWidth - this.ioG) + this.ioF, this.ioJ + this.ioK + this.ioH);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ioT = ValueAnimator.ofFloat(this.ioF, 0.0f);
        this.ioT.setDuration(500L);
        this.ioT.setInterpolator(new DecelerateInterpolator());
        this.ioT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.ioW != 1) {
                    if (ForumTestView.this.ioW == 2 || ForumTestView.this.ioW == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.ioP * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.ioQ;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.ioC.setAlpha(0.0f);
                            ForumTestView.this.ioC.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.ioD);
                            ForumTestView.this.d(ForumTestView.this.ioC);
                            ForumTestView.this.ioy.remove(ForumTestView.this.ioC.getData());
                            ForumTestView.this.oY(true);
                            ForumTestView.this.ioV = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.ioD, floatValue, abs);
                            if ((ForumTestView.this.ioF * 2) / 5 >= ForumTestView.this.ioC.getViewRight() - ForumTestView.this.ioC.getViewLeft()) {
                                ForumTestView.this.ioC.setAlpha(0.0f);
                                ForumTestView.this.ioC.setVisibility(8);
                            } else {
                                ForumTestView.this.ioC.setViewLeft(ForumTestView.this.ioC.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.ioC.setViewRight(ForumTestView.this.ioC.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.ioC.setViewTop(ForumTestView.this.ioC.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.ioC.setViewBottom(ForumTestView.this.ioC.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.ioC.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.ioF * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.ioP * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.ioQ;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.ioC.setAlpha(0.0f);
                        ForumTestView.this.ioC.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.ioD);
                        ForumTestView.this.d(ForumTestView.this.ioC);
                        ForumTestView.this.d(ForumTestView.this.ioE);
                        ForumTestView.this.ioy.remove(ForumTestView.this.ioC.getData());
                        if (ForumTestView.this.ioz.getIndex() == 0) {
                            if (ForumTestView.this.ioz.getDataIndex() > ForumTestView.this.ioE.getDataIndex()) {
                                ForumTestView.this.ioz.setDataIndex(ForumTestView.this.ioz.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.ioz);
                            }
                        } else if (ForumTestView.this.ioA.getIndex() == 0) {
                            if (ForumTestView.this.ioA.getDataIndex() > ForumTestView.this.ioE.getDataIndex()) {
                                ForumTestView.this.ioA.setDataIndex(ForumTestView.this.ioA.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.ioA);
                            }
                        } else if (ForumTestView.this.ioB.getDataIndex() > ForumTestView.this.ioE.getDataIndex()) {
                            ForumTestView.this.ioB.setDataIndex(ForumTestView.this.ioB.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.ioB);
                        }
                        if (ForumTestView.this.ioD.getDataIndex() > ForumTestView.this.ioE.getDataIndex()) {
                            ForumTestView.this.ioD.setDataIndex(ForumTestView.this.ioD.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.ioD);
                        }
                        ForumTestView.this.ioE.setDataIndex(ForumTestView.this.ioE.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.ioE);
                        ForumTestView.this.oY(true);
                        ForumTestView.this.ioV = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.ioD, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.ioE, floatValue2);
                        if ((ForumTestView.this.ioF * 2) / 5 >= ForumTestView.this.ioC.getViewRight() - ForumTestView.this.ioC.getViewLeft()) {
                            ForumTestView.this.ioC.setAlpha(0.0f);
                            ForumTestView.this.ioC.setVisibility(8);
                        } else {
                            ForumTestView.this.ioC.setViewLeft(ForumTestView.this.ioC.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.ioC.setViewRight(ForumTestView.this.ioC.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.ioC.setViewTop(ForumTestView.this.ioC.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.ioC.setViewBottom(ForumTestView.this.ioC.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.ioC.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.ioF * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.ioQ * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.ioC.setAlpha(0.0f);
                    ForumTestView.this.ioC.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.ioy.remove(ForumTestView.this.ioC.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.ioY != null) {
                        ForumTestView.this.ioY.fC(-1L);
                    }
                    ForumTestView.this.ioV = false;
                    if (ForumTestView.this.ioY != null && y.isEmpty(ForumTestView.this.ioy)) {
                        ForumTestView.this.ioY.csq();
                    }
                } else {
                    ForumTestView.this.ioC.setViewLeft(ForumTestView.this.ioC.getMoveLeft() + floatValue3);
                    ForumTestView.this.ioC.setViewRight(ForumTestView.this.ioC.getMoveRight() - floatValue3);
                    ForumTestView.this.ioC.setViewTop(ForumTestView.this.ioC.getMoveTop() + f);
                    ForumTestView.this.ioC.setViewBottom(ForumTestView.this.ioC.getMoveBottom() - f);
                    ForumTestView.this.ioC.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.ipb) {
                this.ipb = equipmentWidth;
                fl(getContext());
                d(this.ioz);
                d(this.ioA);
                d(this.ioB);
                d(this.ioC);
            }
            a(this.ioz);
            a(this.ioA);
            a(this.ioB);
            a(this.ioC);
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
            this.ioz.layout((int) this.ioz.getViewLeft(), (int) this.ioz.getViewTop(), (int) this.ioz.getViewRight(), (int) this.ioz.getViewBottom());
            this.ioA.layout((int) this.ioA.getViewLeft(), (int) this.ioA.getViewTop(), (int) this.ioA.getViewRight(), (int) this.ioA.getViewBottom());
            this.ioB.layout((int) this.ioB.getViewLeft(), (int) this.ioB.getViewTop(), (int) this.ioB.getViewRight(), (int) this.ioB.getViewBottom());
            this.ioC.layout((int) this.ioC.getViewLeft(), (int) this.ioC.getViewTop(), (int) this.ioC.getViewRight(), (int) this.ioC.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.ioT == null || !this.ioT.isRunning()) {
            if (this.ioS == null || !this.ioS.isRunning()) {
                int action = motionEvent.getAction();
                Z(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.ioS != null) {
                        this.ioS.removeAllUpdateListeners();
                        this.ioS.cancel();
                    }
                    this.ioX = motionEvent.getPointerId(0);
                    this.ioN = x;
                    this.ioO = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.ioN - x;
                    float f2 = this.ioO - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.ioU = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.ioU) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.ioP * f3;
                    if (this.ioU) {
                        b(this.ioz, f3, f4);
                        b(this.ioA, f3, f4);
                        b(this.ioB, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.WT);
                    float xVelocity = velocityTracker.getXVelocity(this.ioX);
                    if (this.ioU || this.mDistance != 0.0f) {
                        aC(xVelocity);
                    }
                    this.ioU = false;
                    releaseVelocityTracker();
                }
                if (this.ioU || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.ioy.size() > 2) {
                if (cellForumTestView.getViewRight() < this.ioM[0].right - (this.ioF / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.ioM[0].right - (this.ioF / 2))) + this.ioM[2].left + (this.ioF / 2) + this.ioL);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.ioF);
                    cellForumTestView.setViewTop(this.ioM[2].top);
                    cellForumTestView.setViewBottom(this.ioM[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.ioy.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.ioM[2].left + (this.ioF / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.ioM[2].left + (this.ioF / 2))) + ((this.ioM[0].right - (this.ioF / 2)) - this.ioL));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.ioF);
                    cellForumTestView.setViewTop(this.ioM[0].top);
                    cellForumTestView.setViewBottom(this.ioM[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.ioy.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.ioM[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.ioM[0].top) {
                    cellForumTestView.setViewTop(this.ioM[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.ioM[0].bottom) {
                    cellForumTestView.setViewBottom(this.ioM[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.ioM[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.ioM[1].top) {
                    cellForumTestView.setViewTop(this.ioM[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.ioM[1].bottom) {
                    cellForumTestView.setViewBottom(this.ioM[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.ioY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY(boolean z) {
        if (this.ioY != null) {
            int i = -1;
            if (this.ioz.getIndex() == 1 && this.ioz.getData() != null) {
                this.ioY.fC(this.ioz.getData().testId);
                i = this.ioz.getDataIndex();
            } else if (this.ioA.getIndex() == 1 && this.ioA.getData() != null) {
                this.ioY.fC(this.ioA.getData().testId);
                i = this.ioA.getDataIndex();
            } else if (this.ioB.getIndex() == 1 && this.ioB.getData() != null) {
                this.ioY.fC(this.ioB.getData().testId);
                i = this.ioB.getDataIndex();
            } else {
                this.ioY.fC(-1L);
            }
            if (z) {
                ys(i);
            }
        }
    }

    private void initAnimation() {
        this.ioS = ValueAnimator.ofFloat(this.ioF, 0.0f);
        this.ioS.setDuration(200L);
        this.ioS.setInterpolator(new DecelerateInterpolator());
        this.ioS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.ioF) * 0.2f;
                    if (ForumTestView.this.ioZ) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.csn();
                        } else {
                            ForumTestView.this.cso();
                        }
                        ForumTestView.this.ioZ = false;
                    }
                    ForumTestView.this.ipa = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.ioz);
                    ForumTestView.this.d(ForumTestView.this.ioA);
                    ForumTestView.this.d(ForumTestView.this.ioB);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.oY(z);
                } else {
                    if (ForumTestView.this.ioZ) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.yq(2) != null && ForumTestView.this.yq(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.csn();
                                ForumTestView.this.ioZ = false;
                            }
                        } else if (ForumTestView.this.yq(0) != null && ForumTestView.this.yq(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cso();
                            ForumTestView.this.ioZ = false;
                        }
                    }
                    float f = ForumTestView.this.ipa - floatValue;
                    float f2 = ForumTestView.this.ioP * f;
                    ForumTestView.this.b(ForumTestView.this.ioz, f, f2);
                    ForumTestView.this.b(ForumTestView.this.ioA, f, f2);
                    ForumTestView.this.b(ForumTestView.this.ioB, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.ipa = floatValue;
            }
        });
    }

    private void aC(float f) {
        CellForumTestView yq;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.ioZ = false;
        this.ipa = 0.0f;
        initAnimation();
        if (this.ioy.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.ioz.getVisibility() == 0) {
                cellForumTestView3 = this.ioz;
            }
            if (this.ioA.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.ioA;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.ioA;
            }
            if (this.ioB.getVisibility() == 0) {
                cellForumTestView2 = this.ioB;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.ioM[0].left) || viewRight > ((float) this.ioM[2].right)) && Math.abs(this.mDistance) >= this.ioF * 0.2f) {
                this.ioZ = true;
            }
        } else if (this.ioy.size() > 2 && Math.abs(this.mDistance) >= this.ioF * 0.2f) {
            this.ioZ = true;
        }
        if (this.ioZ && (yq = yq(1)) != null) {
            if (this.mDistance >= this.ioF) {
                this.mDistance -= this.ioF;
                this.ioZ = false;
                cso();
            } else if (this.mDistance > 0.0f && this.mDistance < this.ioF) {
                this.mDistance = this.ioM[0].right - yq.getViewRight();
            } else if (this.mDistance > (-this.ioF)) {
                this.mDistance = this.ioM[2].left - yq.getViewLeft();
            } else {
                csn();
                this.mDistance += this.ioF;
                this.ioZ = false;
            }
        }
        this.ioS.setFloatValues(0.0f, this.mDistance);
        this.ioS.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        this.ioz.setIndex(this.ioz.getIndex() + 1);
        this.ioA.setIndex(this.ioA.getIndex() + 1);
        this.ioB.setIndex(this.ioB.getIndex() + 1);
        b(this.ioz);
        b(this.ioA);
        b(this.ioB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        this.ioz.setIndex(this.ioz.getIndex() - 1);
        this.ioA.setIndex(this.ioA.getIndex() - 1);
        this.ioB.setIndex(this.ioB.getIndex() - 1);
        b(this.ioz);
        b(this.ioA);
        b(this.ioB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView yq(int i) {
        if (this.ioz.getIndex() == i) {
            return this.ioz;
        }
        if (this.ioA.getIndex() == i) {
            return this.ioA;
        }
        if (this.ioB.getIndex() == i) {
            return this.ioB;
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
            int size = this.ioy.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int yr(int i) {
        int size = this.ioy.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.ioM[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.ioM[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.ioM[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.ioM[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.ioU && this.mDistance == 0.0f) {
            this.ioy = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.ioz.setVisibility(0);
                this.ioA.setVisibility(0);
                this.ioB.setVisibility(0);
                this.ioz.setData(list.get(0));
                this.ioA.setData(list.get(1));
                this.ioB.setData(list.get(2));
                this.ioz.setDataIndex(0);
                this.ioA.setDataIndex(1);
                this.ioB.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.ioz.setVisibility(8);
                this.ioA.setVisibility(0);
                this.ioB.setVisibility(0);
                this.ioA.setDataIndex(1);
                this.ioB.setDataIndex(0);
                this.ioA.setData(list.get(1));
                this.ioB.setData(list.get(0));
                i = 1;
            } else {
                this.ioz.setVisibility(8);
                this.ioA.setVisibility(0);
                this.ioB.setVisibility(8);
                this.ioA.setDataIndex(0);
                this.ioA.setData(list.get(0));
                i = 0;
            }
            ys(i);
        }
    }

    private void resetData() {
        this.ioz.setIndex(0);
        this.ioA.setIndex(1);
        this.ioB.setIndex(2);
        this.ioC.setIndex(1);
        d(this.ioz);
        d(this.ioA);
        d(this.ioB);
        d(this.ioC);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void yp(int i) {
        CellForumTestView cellForumTestView;
        this.ioV = true;
        this.ioC.setVisibility(0);
        this.ioC.setAlpha(1.0f);
        csp();
        if (this.ioz.getIndex() == i && this.ioz.getVisibility() == 0) {
            cellForumTestView = this.ioz;
        } else if (this.ioA.getIndex() == i && this.ioA.getVisibility() == 0) {
            cellForumTestView = this.ioA;
        } else {
            cellForumTestView = this.ioB;
        }
        this.ioC.setData(cellForumTestView.getData());
        this.ioC.setDataIndex(cellForumTestView.getDataIndex());
        this.ioE = null;
        if (this.ioy.size() == 1) {
            this.ioW = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.ioF * 3) / 5;
        } else if (this.ioy.size() == 2) {
            this.ioW = 2;
            cellForumTestView.setVisibility(8);
            if (this.ioz.getVisibility() == 0) {
                this.ioD = this.ioz;
            } else if (this.ioA.getVisibility() == 0) {
                this.ioD = this.ioA;
            } else {
                this.ioD = this.ioB;
            }
            if (this.ioD.getViewRight() < this.ioM[1].left) {
                this.mDistance = this.ioF + this.ioL;
                this.ioD.setIndex(this.ioD.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.ioD.getViewLeft() > this.ioM[1].right) {
                this.mDistance = (-this.ioF) - this.ioL;
                this.ioD.setIndex(this.ioD.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.ioD);
            b(cellForumTestView);
        } else if (this.ioy.size() == 3) {
            this.ioW = 3;
            cellForumTestView.setVisibility(8);
            if (this.ioz.getIndex() == 2) {
                this.ioD = this.ioz;
            } else if (this.ioA.getIndex() == 2) {
                this.ioD = this.ioA;
            } else {
                this.ioD = this.ioB;
            }
            this.mDistance = (-this.ioF) - this.ioL;
            this.ioD.setIndex(this.ioD.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.ioD);
            b(cellForumTestView);
        } else {
            this.ioW = 4;
            this.ioE = cellForumTestView;
            if (this.ioz.getIndex() == 2) {
                this.ioD = this.ioz;
            } else if (this.ioA.getIndex() == 2) {
                this.ioD = this.ioA;
            } else {
                this.ioD = this.ioB;
            }
            this.mDistance = (-this.ioF) - this.ioL;
            this.ioD.setIndex(this.ioD.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.ioD);
            b(cellForumTestView);
            this.ioE.setViewLeft(this.ioM[2].right + this.ioL);
            this.ioE.setViewRight(this.ioM[2].right + this.ioL + this.ioF);
            this.ioE.setViewTop(this.ioM[2].top);
            this.ioE.setViewBottom(this.ioM[2].bottom);
            this.ioE.setMoveLeft(this.ioM[2].right + this.ioL);
            this.ioE.setMoveRight(this.ioM[2].right + this.ioL + this.ioF);
            this.ioE.setMoveTop(this.ioM[2].top);
            this.ioE.setMoveBottom(this.ioM[2].bottom);
            this.ioE.setData(this.ioy.get(yr(this.ioE.getDataIndex() + 2)));
        }
        this.ioT.setFloatValues(0.0f, this.mDistance);
        this.ioT.start();
    }

    private void csp() {
        this.ioz.setMoveLeft(this.ioz.getViewLeft());
        this.ioz.setMoveTop(this.ioz.getViewTop());
        this.ioz.setMoveRight(this.ioz.getViewRight());
        this.ioz.setMoveBottom(this.ioz.getViewBottom());
        this.ioA.setMoveLeft(this.ioA.getViewLeft());
        this.ioA.setMoveTop(this.ioA.getViewTop());
        this.ioA.setMoveRight(this.ioA.getViewRight());
        this.ioA.setMoveBottom(this.ioA.getViewBottom());
        this.ioB.setMoveLeft(this.ioB.getViewLeft());
        this.ioB.setMoveTop(this.ioB.getViewTop());
        this.ioB.setMoveRight(this.ioB.getViewRight());
        this.ioB.setMoveBottom(this.ioB.getViewBottom());
        this.ioC.setMoveLeft(this.ioC.getViewLeft());
        this.ioC.setMoveTop(this.ioC.getViewTop());
        this.ioC.setMoveRight(this.ioC.getViewRight());
        this.ioC.setMoveBottom(this.ioC.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0205);
            this.ioz.onChangeSkinType();
            this.ioA.onChangeSkinType();
            this.ioB.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.ioU && this.mDistance == 0.0f) {
            if (this.ioS != null) {
                this.ioS.removeAllUpdateListeners();
                this.ioS.cancel();
            }
            if (this.ioT != null) {
                this.ioT.removeAllUpdateListeners();
                this.ioT.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.ioz != null) {
            this.ioz.setPageId(bdUniqueId);
        }
        if (this.ioA != null) {
            this.ioA.setPageId(bdUniqueId);
        }
        if (this.ioB != null) {
            this.ioB.setPageId(bdUniqueId);
        }
    }

    public void ys(int i) {
        f fVar;
        ar a2;
        if (this.ioy != null && i >= 0 && i < this.ioy.size() && (fVar = this.ioy.get(i)) != null && (a2 = com.baidu.tieba.t.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.t.c.dIO().a(this.mPageId, com.baidu.tieba.t.a.Sf("" + fVar.testId), a2);
        }
    }
}
