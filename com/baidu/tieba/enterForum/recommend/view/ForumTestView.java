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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import java.util.List;
/* loaded from: classes2.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int XO;
    private List<f> iLF;
    private CellForumTestView iLG;
    private CellForumTestView iLH;
    private CellForumTestView iLI;
    private CellForumTestView iLJ;
    private CellForumTestView iLK;
    private CellForumTestView iLL;
    private int iLM;
    private int iLN;
    private int iLO;
    private int iLP;
    private int iLQ;
    private int iLR;
    private int iLS;
    private Rect[] iLT;
    private float iLU;
    private float iLV;
    private float iLW;
    private float iLX;
    private float iLY;
    private ValueAnimator iLZ;
    private ValueAnimator iMa;
    private boolean iMb;
    private boolean iMc;
    private int iMd;
    private int iMe;
    private a iMf;
    private boolean iMg;
    private float iMh;
    private int iMi;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void czz();

        void gg(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iLT = new Rect[3];
        this.iMb = false;
        this.iMc = false;
        this.iMg = false;
        this.iMh = 0.0f;
        this.iMi = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iLT = new Rect[3];
        this.iMb = false;
        this.iMc = false;
        this.iMg = false;
        this.iMh = 0.0f;
        this.iMi = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iLT = new Rect[3];
        this.iMb = false;
        this.iMc = false;
        this.iMg = false;
        this.iMh = 0.0f;
        this.iMi = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.iLG = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.iLH = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.iLI = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.iLJ = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        gk(context);
        resetData();
        ViewConfiguration.get(context);
        this.XO = ViewConfiguration.getMaximumFlingVelocity();
        this.iLG.setForumTestDelClickListener(this);
        this.iLH.setForumTestDelClickListener(this);
        this.iLI.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void gk(Context context) {
        this.iLQ = l.getDimens(context, R.dimen.tbds44);
        this.iLR = l.getDimens(context, R.dimen.tbds30);
        this.iLS = l.getDimens(context, R.dimen.tbds7);
        this.iLP = l.getDimens(context, R.dimen.tbds730);
        this.iLO = this.iLP - (this.iLR * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.iLM = (int) (this.mWidth * 0.89f);
        this.mHeight = this.iLP + this.iLQ;
        this.iLN = ((this.mWidth - this.iLM) - (this.iLS * 2)) / 2;
        this.iLW = this.iLR / (this.iLM + this.iLS);
        this.iLX = this.iLP / this.iLM;
        this.iLY = this.iLM / (this.iLM + this.iLS);
        this.iLT[0] = new Rect(this.iLN - this.iLM, this.iLQ + this.iLR, this.iLN, this.iLQ + this.iLR + this.iLO);
        this.iLT[1] = new Rect(this.iLN + this.iLS, this.iLQ, this.iLN + this.iLS + this.iLM, this.iLQ + this.iLP);
        this.iLT[2] = new Rect(this.mWidth - this.iLN, this.iLQ + this.iLR, (this.mWidth - this.iLN) + this.iLM, this.iLQ + this.iLR + this.iLO);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.iMa = ValueAnimator.ofFloat(this.iLM, 0.0f);
        this.iMa.setDuration(500L);
        this.iMa.setInterpolator(new DecelerateInterpolator());
        this.iMa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.iMd != 1) {
                    if (ForumTestView.this.iMd == 2 || ForumTestView.this.iMd == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.iLW * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.iLX;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.iLJ.setAlpha(0.0f);
                            ForumTestView.this.iLJ.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.iLK);
                            ForumTestView.this.d(ForumTestView.this.iLJ);
                            ForumTestView.this.iLF.remove(ForumTestView.this.iLJ.getData());
                            ForumTestView.this.pR(true);
                            ForumTestView.this.iMc = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.iLK, floatValue, abs);
                            if ((ForumTestView.this.iLM * 2) / 5 >= ForumTestView.this.iLJ.getViewRight() - ForumTestView.this.iLJ.getViewLeft()) {
                                ForumTestView.this.iLJ.setAlpha(0.0f);
                                ForumTestView.this.iLJ.setVisibility(8);
                            } else {
                                ForumTestView.this.iLJ.setViewLeft(ForumTestView.this.iLJ.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iLJ.setViewRight(ForumTestView.this.iLJ.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.iLJ.setViewTop(ForumTestView.this.iLJ.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.iLJ.setViewBottom(ForumTestView.this.iLJ.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.iLJ.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.iLM * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.iLW * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.iLX;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.iLJ.setAlpha(0.0f);
                        ForumTestView.this.iLJ.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.iLK);
                        ForumTestView.this.d(ForumTestView.this.iLJ);
                        ForumTestView.this.d(ForumTestView.this.iLL);
                        ForumTestView.this.iLF.remove(ForumTestView.this.iLJ.getData());
                        if (ForumTestView.this.iLG.getIndex() == 0) {
                            if (ForumTestView.this.iLG.getDataIndex() > ForumTestView.this.iLL.getDataIndex()) {
                                ForumTestView.this.iLG.setDataIndex(ForumTestView.this.iLG.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iLG);
                            }
                        } else if (ForumTestView.this.iLH.getIndex() == 0) {
                            if (ForumTestView.this.iLH.getDataIndex() > ForumTestView.this.iLL.getDataIndex()) {
                                ForumTestView.this.iLH.setDataIndex(ForumTestView.this.iLH.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.iLH);
                            }
                        } else if (ForumTestView.this.iLI.getDataIndex() > ForumTestView.this.iLL.getDataIndex()) {
                            ForumTestView.this.iLI.setDataIndex(ForumTestView.this.iLI.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iLI);
                        }
                        if (ForumTestView.this.iLK.getDataIndex() > ForumTestView.this.iLL.getDataIndex()) {
                            ForumTestView.this.iLK.setDataIndex(ForumTestView.this.iLK.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.iLK);
                        }
                        ForumTestView.this.iLL.setDataIndex(ForumTestView.this.iLL.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.iLL);
                        ForumTestView.this.pR(true);
                        ForumTestView.this.iMc = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.iLK, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.iLL, floatValue2);
                        if ((ForumTestView.this.iLM * 2) / 5 >= ForumTestView.this.iLJ.getViewRight() - ForumTestView.this.iLJ.getViewLeft()) {
                            ForumTestView.this.iLJ.setAlpha(0.0f);
                            ForumTestView.this.iLJ.setVisibility(8);
                        } else {
                            ForumTestView.this.iLJ.setViewLeft(ForumTestView.this.iLJ.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iLJ.setViewRight(ForumTestView.this.iLJ.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.iLJ.setViewTop(ForumTestView.this.iLJ.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.iLJ.setViewBottom(ForumTestView.this.iLJ.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.iLJ.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.iLM * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.iLX * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.iLJ.setAlpha(0.0f);
                    ForumTestView.this.iLJ.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.iLF.remove(ForumTestView.this.iLJ.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.iMf != null) {
                        ForumTestView.this.iMf.gg(-1L);
                    }
                    ForumTestView.this.iMc = false;
                    if (ForumTestView.this.iMf != null && x.isEmpty(ForumTestView.this.iLF)) {
                        ForumTestView.this.iMf.czz();
                    }
                } else {
                    ForumTestView.this.iLJ.setViewLeft(ForumTestView.this.iLJ.getMoveLeft() + floatValue3);
                    ForumTestView.this.iLJ.setViewRight(ForumTestView.this.iLJ.getMoveRight() - floatValue3);
                    ForumTestView.this.iLJ.setViewTop(ForumTestView.this.iLJ.getMoveTop() + f);
                    ForumTestView.this.iLJ.setViewBottom(ForumTestView.this.iLJ.getMoveBottom() - f);
                    ForumTestView.this.iLJ.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.iMi) {
                this.iMi = equipmentWidth;
                gk(getContext());
                d(this.iLG);
                d(this.iLH);
                d(this.iLI);
                d(this.iLJ);
            }
            a(this.iLG);
            a(this.iLH);
            a(this.iLI);
            a(this.iLJ);
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
            this.iLG.layout((int) this.iLG.getViewLeft(), (int) this.iLG.getViewTop(), (int) this.iLG.getViewRight(), (int) this.iLG.getViewBottom());
            this.iLH.layout((int) this.iLH.getViewLeft(), (int) this.iLH.getViewTop(), (int) this.iLH.getViewRight(), (int) this.iLH.getViewBottom());
            this.iLI.layout((int) this.iLI.getViewLeft(), (int) this.iLI.getViewTop(), (int) this.iLI.getViewRight(), (int) this.iLI.getViewBottom());
            this.iLJ.layout((int) this.iLJ.getViewLeft(), (int) this.iLJ.getViewTop(), (int) this.iLJ.getViewRight(), (int) this.iLJ.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.iMa == null || !this.iMa.isRunning()) {
            if (this.iLZ == null || !this.iLZ.isRunning()) {
                int action = motionEvent.getAction();
                Z(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.iLZ != null) {
                        this.iLZ.removeAllUpdateListeners();
                        this.iLZ.cancel();
                    }
                    this.iMe = motionEvent.getPointerId(0);
                    this.iLU = x;
                    this.iLV = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.iLU - x;
                    float f2 = this.iLV - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.iMb = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.iMb) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.iLW * f3;
                    if (this.iMb) {
                        b(this.iLG, f3, f4);
                        b(this.iLH, f3, f4);
                        b(this.iLI, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.XO);
                    float xVelocity = velocityTracker.getXVelocity(this.iMe);
                    if (this.iMb || this.mDistance != 0.0f) {
                        aF(xVelocity);
                    }
                    this.iMb = false;
                    releaseVelocityTracker();
                }
                if (this.iMb || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.iLF.size() > 2) {
                if (cellForumTestView.getViewRight() < this.iLT[0].right - (this.iLM / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.iLT[0].right - (this.iLM / 2))) + this.iLT[2].left + (this.iLM / 2) + this.iLS);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.iLM);
                    cellForumTestView.setViewTop(this.iLT[2].top);
                    cellForumTestView.setViewBottom(this.iLT[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iLF.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.iLT[2].left + (this.iLM / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.iLT[2].left + (this.iLM / 2))) + ((this.iLT[0].right - (this.iLM / 2)) - this.iLS));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.iLM);
                    cellForumTestView.setViewTop(this.iLT[0].top);
                    cellForumTestView.setViewBottom(this.iLT[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.iLF.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.iLT[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.iLT[0].top) {
                    cellForumTestView.setViewTop(this.iLT[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.iLT[0].bottom) {
                    cellForumTestView.setViewBottom(this.iLT[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.iLT[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.iLT[1].top) {
                    cellForumTestView.setViewTop(this.iLT[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.iLT[1].bottom) {
                    cellForumTestView.setViewBottom(this.iLT[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.iMf = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(boolean z) {
        if (this.iMf != null) {
            int i = -1;
            if (this.iLG.getIndex() == 1 && this.iLG.getData() != null) {
                this.iMf.gg(this.iLG.getData().testId);
                i = this.iLG.getDataIndex();
            } else if (this.iLH.getIndex() == 1 && this.iLH.getData() != null) {
                this.iMf.gg(this.iLH.getData().testId);
                i = this.iLH.getDataIndex();
            } else if (this.iLI.getIndex() == 1 && this.iLI.getData() != null) {
                this.iMf.gg(this.iLI.getData().testId);
                i = this.iLI.getDataIndex();
            } else {
                this.iMf.gg(-1L);
            }
            if (z) {
                zk(i);
            }
        }
    }

    private void initAnimation() {
        this.iLZ = ValueAnimator.ofFloat(this.iLM, 0.0f);
        this.iLZ.setDuration(200L);
        this.iLZ.setInterpolator(new DecelerateInterpolator());
        this.iLZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.iLM) * 0.2f;
                    if (ForumTestView.this.iMg) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.czw();
                        } else {
                            ForumTestView.this.czx();
                        }
                        ForumTestView.this.iMg = false;
                    }
                    ForumTestView.this.iMh = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.iLG);
                    ForumTestView.this.d(ForumTestView.this.iLH);
                    ForumTestView.this.d(ForumTestView.this.iLI);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.pR(z);
                } else {
                    if (ForumTestView.this.iMg) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.zi(2) != null && ForumTestView.this.zi(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.czw();
                                ForumTestView.this.iMg = false;
                            }
                        } else if (ForumTestView.this.zi(0) != null && ForumTestView.this.zi(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.czx();
                            ForumTestView.this.iMg = false;
                        }
                    }
                    float f = ForumTestView.this.iMh - floatValue;
                    float f2 = ForumTestView.this.iLW * f;
                    ForumTestView.this.b(ForumTestView.this.iLG, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iLH, f, f2);
                    ForumTestView.this.b(ForumTestView.this.iLI, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.iMh = floatValue;
            }
        });
    }

    private void aF(float f) {
        CellForumTestView zi;
        float viewLeft;
        float viewRight;
        this.iMg = false;
        this.iMh = 0.0f;
        initAnimation();
        if (this.iLF.size() == 2) {
            CellForumTestView cellForumTestView = null;
            CellForumTestView cellForumTestView2 = null;
            if (this.iLG.getVisibility() == 0) {
                cellForumTestView = this.iLG;
            }
            if (this.iLH.getVisibility() == 0) {
                if (cellForumTestView == null) {
                    cellForumTestView = this.iLH;
                } else {
                    cellForumTestView2 = this.iLH;
                }
            }
            if (this.iLI.getVisibility() == 0) {
                cellForumTestView2 = this.iLI;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                float viewLeft2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
                viewLeft = viewLeft2;
            } else {
                viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
            }
            if (!(viewLeft < ((float) this.iLT[0].left) || viewRight > ((float) this.iLT[2].right)) && Math.abs(this.mDistance) >= this.iLM * 0.2f) {
                this.iMg = true;
            }
        } else if (this.iLF.size() > 2 && Math.abs(this.mDistance) >= this.iLM * 0.2f) {
            this.iMg = true;
        }
        if (this.iMg && (zi = zi(1)) != null) {
            if (this.mDistance >= this.iLM) {
                this.mDistance -= this.iLM;
                this.iMg = false;
                czx();
            } else if (this.mDistance > 0.0f && this.mDistance < this.iLM) {
                this.mDistance = this.iLT[0].right - zi.getViewRight();
            } else if (this.mDistance > (-this.iLM)) {
                this.mDistance = this.iLT[2].left - zi.getViewLeft();
            } else {
                czw();
                this.mDistance += this.iLM;
                this.iMg = false;
            }
        }
        this.iLZ.setFloatValues(0.0f, this.mDistance);
        this.iLZ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czw() {
        this.iLG.setIndex(this.iLG.getIndex() + 1);
        this.iLH.setIndex(this.iLH.getIndex() + 1);
        this.iLI.setIndex(this.iLI.getIndex() + 1);
        b(this.iLG);
        b(this.iLH);
        b(this.iLI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czx() {
        this.iLG.setIndex(this.iLG.getIndex() - 1);
        this.iLH.setIndex(this.iLH.getIndex() - 1);
        this.iLI.setIndex(this.iLI.getIndex() - 1);
        b(this.iLG);
        b(this.iLH);
        b(this.iLI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView zi(int i) {
        if (this.iLG.getIndex() == i) {
            return this.iLG;
        }
        if (this.iLH.getIndex() == i) {
            return this.iLH;
        }
        if (this.iLI.getIndex() == i) {
            return this.iLI;
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
            int size = this.iLF.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int zj(int i) {
        int size = this.iLF.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.iLT[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.iLT[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.iLT[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.iLT[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!x.isEmpty(list) && !this.iMb && this.mDistance == 0.0f) {
            this.iLF = list;
            resetData();
            if (x.getCount(list) > 2) {
                this.iLG.setVisibility(0);
                this.iLH.setVisibility(0);
                this.iLI.setVisibility(0);
                this.iLG.setData(list.get(0));
                this.iLH.setData(list.get(1));
                this.iLI.setData(list.get(2));
                this.iLG.setDataIndex(0);
                this.iLH.setDataIndex(1);
                this.iLI.setDataIndex(2);
                i = 1;
            } else if (x.getCount(list) == 2) {
                this.iLG.setVisibility(8);
                this.iLH.setVisibility(0);
                this.iLI.setVisibility(0);
                this.iLH.setDataIndex(1);
                this.iLI.setDataIndex(0);
                this.iLH.setData(list.get(1));
                this.iLI.setData(list.get(0));
                i = 1;
            } else {
                this.iLG.setVisibility(8);
                this.iLH.setVisibility(0);
                this.iLI.setVisibility(8);
                this.iLH.setDataIndex(0);
                this.iLH.setData(list.get(0));
                i = 0;
            }
            zk(i);
        }
    }

    private void resetData() {
        this.iLG.setIndex(0);
        this.iLH.setIndex(1);
        this.iLI.setIndex(2);
        this.iLJ.setIndex(1);
        d(this.iLG);
        d(this.iLH);
        d(this.iLI);
        d(this.iLJ);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void zh(int i) {
        CellForumTestView cellForumTestView;
        this.iMc = true;
        this.iLJ.setVisibility(0);
        this.iLJ.setAlpha(1.0f);
        czy();
        if (this.iLG.getIndex() == i && this.iLG.getVisibility() == 0) {
            cellForumTestView = this.iLG;
        } else if (this.iLH.getIndex() == i && this.iLH.getVisibility() == 0) {
            cellForumTestView = this.iLH;
        } else {
            cellForumTestView = this.iLI;
        }
        this.iLJ.setData(cellForumTestView.getData());
        this.iLJ.setDataIndex(cellForumTestView.getDataIndex());
        this.iLL = null;
        if (this.iLF.size() == 1) {
            this.iMd = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.iLM * 3) / 5;
        } else if (this.iLF.size() == 2) {
            this.iMd = 2;
            cellForumTestView.setVisibility(8);
            if (this.iLG.getVisibility() == 0) {
                this.iLK = this.iLG;
            } else if (this.iLH.getVisibility() == 0) {
                this.iLK = this.iLH;
            } else {
                this.iLK = this.iLI;
            }
            if (this.iLK.getViewRight() < this.iLT[1].left) {
                this.mDistance = this.iLM + this.iLS;
                this.iLK.setIndex(this.iLK.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.iLK.getViewLeft() > this.iLT[1].right) {
                this.mDistance = (-this.iLM) - this.iLS;
                this.iLK.setIndex(this.iLK.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.iLK);
            b(cellForumTestView);
        } else if (this.iLF.size() == 3) {
            this.iMd = 3;
            cellForumTestView.setVisibility(8);
            if (this.iLG.getIndex() == 2) {
                this.iLK = this.iLG;
            } else if (this.iLH.getIndex() == 2) {
                this.iLK = this.iLH;
            } else {
                this.iLK = this.iLI;
            }
            this.mDistance = (-this.iLM) - this.iLS;
            this.iLK.setIndex(this.iLK.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.iLK);
            b(cellForumTestView);
        } else {
            this.iMd = 4;
            this.iLL = cellForumTestView;
            if (this.iLG.getIndex() == 2) {
                this.iLK = this.iLG;
            } else if (this.iLH.getIndex() == 2) {
                this.iLK = this.iLH;
            } else {
                this.iLK = this.iLI;
            }
            this.mDistance = (-this.iLM) - this.iLS;
            this.iLK.setIndex(this.iLK.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.iLK);
            b(cellForumTestView);
            this.iLL.setViewLeft(this.iLT[2].right + this.iLS);
            this.iLL.setViewRight(this.iLT[2].right + this.iLS + this.iLM);
            this.iLL.setViewTop(this.iLT[2].top);
            this.iLL.setViewBottom(this.iLT[2].bottom);
            this.iLL.setMoveLeft(this.iLT[2].right + this.iLS);
            this.iLL.setMoveRight(this.iLT[2].right + this.iLS + this.iLM);
            this.iLL.setMoveTop(this.iLT[2].top);
            this.iLL.setMoveBottom(this.iLT[2].bottom);
            this.iLL.setData(this.iLF.get(zj(this.iLL.getDataIndex() + 2)));
        }
        this.iMa.setFloatValues(0.0f, this.mDistance);
        this.iMa.start();
    }

    private void czy() {
        this.iLG.setMoveLeft(this.iLG.getViewLeft());
        this.iLG.setMoveTop(this.iLG.getViewTop());
        this.iLG.setMoveRight(this.iLG.getViewRight());
        this.iLG.setMoveBottom(this.iLG.getViewBottom());
        this.iLH.setMoveLeft(this.iLH.getViewLeft());
        this.iLH.setMoveTop(this.iLH.getViewTop());
        this.iLH.setMoveRight(this.iLH.getViewRight());
        this.iLH.setMoveBottom(this.iLH.getViewBottom());
        this.iLI.setMoveLeft(this.iLI.getViewLeft());
        this.iLI.setMoveTop(this.iLI.getViewTop());
        this.iLI.setMoveRight(this.iLI.getViewRight());
        this.iLI.setMoveBottom(this.iLI.getViewBottom());
        this.iLJ.setMoveLeft(this.iLJ.getViewLeft());
        this.iLJ.setMoveTop(this.iLJ.getViewTop());
        this.iLJ.setMoveRight(this.iLJ.getViewRight());
        this.iLJ.setMoveBottom(this.iLJ.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ao.setBackgroundColor(this, R.color.CAM_X0205);
            this.iLG.onChangeSkinType();
            this.iLH.onChangeSkinType();
            this.iLI.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.iMb && this.mDistance == 0.0f) {
            if (this.iLZ != null) {
                this.iLZ.removeAllUpdateListeners();
                this.iLZ.cancel();
            }
            if (this.iMa != null) {
                this.iMa.removeAllUpdateListeners();
                this.iMa.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.iLG != null) {
            this.iLG.setPageId(bdUniqueId);
        }
        if (this.iLH != null) {
            this.iLH.setPageId(bdUniqueId);
        }
        if (this.iLI != null) {
            this.iLI.setPageId(bdUniqueId);
        }
    }

    public void zk(int i) {
        f fVar;
        aq a2;
        if (this.iLF != null && i >= 0 && i < this.iLF.size() && (fVar = this.iLF.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dNX().a(this.mPageId, com.baidu.tieba.s.a.Tc("" + fVar.testId), a2);
        }
    }
}
