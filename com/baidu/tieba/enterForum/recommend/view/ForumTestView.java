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
/* loaded from: classes22.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int XQ;
    private int izA;
    private int izB;
    private int izC;
    private int izD;
    private int izE;
    private int izF;
    private Rect[] izG;
    private float izH;
    private float izI;
    private float izJ;
    private float izK;
    private float izL;
    private ValueAnimator izM;
    private ValueAnimator izN;
    private boolean izO;
    private boolean izP;
    private int izQ;
    private int izR;
    private a izS;
    private boolean izT;
    private float izU;
    private int izV;
    private List<f> izs;
    private CellForumTestView izt;
    private CellForumTestView izu;
    private CellForumTestView izv;
    private CellForumTestView izw;
    private CellForumTestView izx;
    private CellForumTestView izy;
    private int izz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void cwG();

        void gg(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.izG = new Rect[3];
        this.izO = false;
        this.izP = false;
        this.izT = false;
        this.izU = 0.0f;
        this.izV = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.izG = new Rect[3];
        this.izO = false;
        this.izP = false;
        this.izT = false;
        this.izU = 0.0f;
        this.izV = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.izG = new Rect[3];
        this.izO = false;
        this.izP = false;
        this.izT = false;
        this.izU = 0.0f;
        this.izV = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.izt = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.izu = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.izv = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.izw = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        fR(context);
        resetData();
        ViewConfiguration.get(context);
        this.XQ = ViewConfiguration.getMaximumFlingVelocity();
        this.izt.setForumTestDelClickListener(this);
        this.izu.setForumTestDelClickListener(this);
        this.izv.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void fR(Context context) {
        this.izD = l.getDimens(context, R.dimen.tbds44);
        this.izE = l.getDimens(context, R.dimen.tbds30);
        this.izF = l.getDimens(context, R.dimen.tbds7);
        this.izC = l.getDimens(context, R.dimen.tbds730);
        this.izB = this.izC - (this.izE * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.izz = (int) (this.mWidth * 0.89f);
        this.mHeight = this.izC + this.izD;
        this.izA = ((this.mWidth - this.izz) - (this.izF * 2)) / 2;
        this.izJ = this.izE / (this.izz + this.izF);
        this.izK = this.izC / this.izz;
        this.izL = this.izz / (this.izz + this.izF);
        this.izG[0] = new Rect(this.izA - this.izz, this.izD + this.izE, this.izA, this.izD + this.izE + this.izB);
        this.izG[1] = new Rect(this.izA + this.izF, this.izD, this.izA + this.izF + this.izz, this.izD + this.izC);
        this.izG[2] = new Rect(this.mWidth - this.izA, this.izD + this.izE, (this.mWidth - this.izA) + this.izz, this.izD + this.izE + this.izB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.izN = ValueAnimator.ofFloat(this.izz, 0.0f);
        this.izN.setDuration(500L);
        this.izN.setInterpolator(new DecelerateInterpolator());
        this.izN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.izQ != 1) {
                    if (ForumTestView.this.izQ == 2 || ForumTestView.this.izQ == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.izJ * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.izK;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.izw.setAlpha(0.0f);
                            ForumTestView.this.izw.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.izx);
                            ForumTestView.this.d(ForumTestView.this.izw);
                            ForumTestView.this.izs.remove(ForumTestView.this.izw.getData());
                            ForumTestView.this.pu(true);
                            ForumTestView.this.izP = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.izx, floatValue, abs);
                            if ((ForumTestView.this.izz * 2) / 5 >= ForumTestView.this.izw.getViewRight() - ForumTestView.this.izw.getViewLeft()) {
                                ForumTestView.this.izw.setAlpha(0.0f);
                                ForumTestView.this.izw.setVisibility(8);
                            } else {
                                ForumTestView.this.izw.setViewLeft(ForumTestView.this.izw.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.izw.setViewRight(ForumTestView.this.izw.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.izw.setViewTop(ForumTestView.this.izw.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.izw.setViewBottom(ForumTestView.this.izw.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.izw.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.izz * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.izJ * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.izK;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.izw.setAlpha(0.0f);
                        ForumTestView.this.izw.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.izx);
                        ForumTestView.this.d(ForumTestView.this.izw);
                        ForumTestView.this.d(ForumTestView.this.izy);
                        ForumTestView.this.izs.remove(ForumTestView.this.izw.getData());
                        if (ForumTestView.this.izt.getIndex() == 0) {
                            if (ForumTestView.this.izt.getDataIndex() > ForumTestView.this.izy.getDataIndex()) {
                                ForumTestView.this.izt.setDataIndex(ForumTestView.this.izt.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.izt);
                            }
                        } else if (ForumTestView.this.izu.getIndex() == 0) {
                            if (ForumTestView.this.izu.getDataIndex() > ForumTestView.this.izy.getDataIndex()) {
                                ForumTestView.this.izu.setDataIndex(ForumTestView.this.izu.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.izu);
                            }
                        } else if (ForumTestView.this.izv.getDataIndex() > ForumTestView.this.izy.getDataIndex()) {
                            ForumTestView.this.izv.setDataIndex(ForumTestView.this.izv.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.izv);
                        }
                        if (ForumTestView.this.izx.getDataIndex() > ForumTestView.this.izy.getDataIndex()) {
                            ForumTestView.this.izx.setDataIndex(ForumTestView.this.izx.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.izx);
                        }
                        ForumTestView.this.izy.setDataIndex(ForumTestView.this.izy.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.izy);
                        ForumTestView.this.pu(true);
                        ForumTestView.this.izP = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.izx, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.izy, floatValue2);
                        if ((ForumTestView.this.izz * 2) / 5 >= ForumTestView.this.izw.getViewRight() - ForumTestView.this.izw.getViewLeft()) {
                            ForumTestView.this.izw.setAlpha(0.0f);
                            ForumTestView.this.izw.setVisibility(8);
                        } else {
                            ForumTestView.this.izw.setViewLeft(ForumTestView.this.izw.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.izw.setViewRight(ForumTestView.this.izw.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.izw.setViewTop(ForumTestView.this.izw.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.izw.setViewBottom(ForumTestView.this.izw.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.izw.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.izz * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.izK * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.izw.setAlpha(0.0f);
                    ForumTestView.this.izw.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.izs.remove(ForumTestView.this.izw.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.izS != null) {
                        ForumTestView.this.izS.gg(-1L);
                    }
                    ForumTestView.this.izP = false;
                    if (ForumTestView.this.izS != null && y.isEmpty(ForumTestView.this.izs)) {
                        ForumTestView.this.izS.cwG();
                    }
                } else {
                    ForumTestView.this.izw.setViewLeft(ForumTestView.this.izw.getMoveLeft() + floatValue3);
                    ForumTestView.this.izw.setViewRight(ForumTestView.this.izw.getMoveRight() - floatValue3);
                    ForumTestView.this.izw.setViewTop(ForumTestView.this.izw.getMoveTop() + f);
                    ForumTestView.this.izw.setViewBottom(ForumTestView.this.izw.getMoveBottom() - f);
                    ForumTestView.this.izw.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.izV) {
                this.izV = equipmentWidth;
                fR(getContext());
                d(this.izt);
                d(this.izu);
                d(this.izv);
                d(this.izw);
            }
            a(this.izt);
            a(this.izu);
            a(this.izv);
            a(this.izw);
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
            this.izt.layout((int) this.izt.getViewLeft(), (int) this.izt.getViewTop(), (int) this.izt.getViewRight(), (int) this.izt.getViewBottom());
            this.izu.layout((int) this.izu.getViewLeft(), (int) this.izu.getViewTop(), (int) this.izu.getViewRight(), (int) this.izu.getViewBottom());
            this.izv.layout((int) this.izv.getViewLeft(), (int) this.izv.getViewTop(), (int) this.izv.getViewRight(), (int) this.izv.getViewBottom());
            this.izw.layout((int) this.izw.getViewLeft(), (int) this.izw.getViewTop(), (int) this.izw.getViewRight(), (int) this.izw.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.izN == null || !this.izN.isRunning()) {
            if (this.izM == null || !this.izM.isRunning()) {
                int action = motionEvent.getAction();
                Z(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.izM != null) {
                        this.izM.removeAllUpdateListeners();
                        this.izM.cancel();
                    }
                    this.izR = motionEvent.getPointerId(0);
                    this.izH = x;
                    this.izI = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.izH - x;
                    float f2 = this.izI - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.izO = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.izO) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.izJ * f3;
                    if (this.izO) {
                        b(this.izt, f3, f4);
                        b(this.izu, f3, f4);
                        b(this.izv, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.XQ);
                    float xVelocity = velocityTracker.getXVelocity(this.izR);
                    if (this.izO || this.mDistance != 0.0f) {
                        aD(xVelocity);
                    }
                    this.izO = false;
                    releaseVelocityTracker();
                }
                if (this.izO || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.izs.size() > 2) {
                if (cellForumTestView.getViewRight() < this.izG[0].right - (this.izz / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.izG[0].right - (this.izz / 2))) + this.izG[2].left + (this.izz / 2) + this.izF);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.izz);
                    cellForumTestView.setViewTop(this.izG[2].top);
                    cellForumTestView.setViewBottom(this.izG[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.izs.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.izG[2].left + (this.izz / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.izG[2].left + (this.izz / 2))) + ((this.izG[0].right - (this.izz / 2)) - this.izF));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.izz);
                    cellForumTestView.setViewTop(this.izG[0].top);
                    cellForumTestView.setViewBottom(this.izG[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.izs.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.izG[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.izG[0].top) {
                    cellForumTestView.setViewTop(this.izG[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.izG[0].bottom) {
                    cellForumTestView.setViewBottom(this.izG[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.izG[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.izG[1].top) {
                    cellForumTestView.setViewTop(this.izG[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.izG[1].bottom) {
                    cellForumTestView.setViewBottom(this.izG[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.izS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (this.izS != null) {
            int i = -1;
            if (this.izt.getIndex() == 1 && this.izt.getData() != null) {
                this.izS.gg(this.izt.getData().testId);
                i = this.izt.getDataIndex();
            } else if (this.izu.getIndex() == 1 && this.izu.getData() != null) {
                this.izS.gg(this.izu.getData().testId);
                i = this.izu.getDataIndex();
            } else if (this.izv.getIndex() == 1 && this.izv.getData() != null) {
                this.izS.gg(this.izv.getData().testId);
                i = this.izv.getDataIndex();
            } else {
                this.izS.gg(-1L);
            }
            if (z) {
                yX(i);
            }
        }
    }

    private void initAnimation() {
        this.izM = ValueAnimator.ofFloat(this.izz, 0.0f);
        this.izM.setDuration(200L);
        this.izM.setInterpolator(new DecelerateInterpolator());
        this.izM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.izz) * 0.2f;
                    if (ForumTestView.this.izT) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cwD();
                        } else {
                            ForumTestView.this.cwE();
                        }
                        ForumTestView.this.izT = false;
                    }
                    ForumTestView.this.izU = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.izt);
                    ForumTestView.this.d(ForumTestView.this.izu);
                    ForumTestView.this.d(ForumTestView.this.izv);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.pu(z);
                } else {
                    if (ForumTestView.this.izT) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.yV(2) != null && ForumTestView.this.yV(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cwD();
                                ForumTestView.this.izT = false;
                            }
                        } else if (ForumTestView.this.yV(0) != null && ForumTestView.this.yV(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cwE();
                            ForumTestView.this.izT = false;
                        }
                    }
                    float f = ForumTestView.this.izU - floatValue;
                    float f2 = ForumTestView.this.izJ * f;
                    ForumTestView.this.b(ForumTestView.this.izt, f, f2);
                    ForumTestView.this.b(ForumTestView.this.izu, f, f2);
                    ForumTestView.this.b(ForumTestView.this.izv, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.izU = floatValue;
            }
        });
    }

    private void aD(float f) {
        CellForumTestView yV;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.izT = false;
        this.izU = 0.0f;
        initAnimation();
        if (this.izs.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.izt.getVisibility() == 0) {
                cellForumTestView3 = this.izt;
            }
            if (this.izu.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.izu;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.izu;
            }
            if (this.izv.getVisibility() == 0) {
                cellForumTestView2 = this.izv;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.izG[0].left) || viewRight > ((float) this.izG[2].right)) && Math.abs(this.mDistance) >= this.izz * 0.2f) {
                this.izT = true;
            }
        } else if (this.izs.size() > 2 && Math.abs(this.mDistance) >= this.izz * 0.2f) {
            this.izT = true;
        }
        if (this.izT && (yV = yV(1)) != null) {
            if (this.mDistance >= this.izz) {
                this.mDistance -= this.izz;
                this.izT = false;
                cwE();
            } else if (this.mDistance > 0.0f && this.mDistance < this.izz) {
                this.mDistance = this.izG[0].right - yV.getViewRight();
            } else if (this.mDistance > (-this.izz)) {
                this.mDistance = this.izG[2].left - yV.getViewLeft();
            } else {
                cwD();
                this.mDistance += this.izz;
                this.izT = false;
            }
        }
        this.izM.setFloatValues(0.0f, this.mDistance);
        this.izM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwD() {
        this.izt.setIndex(this.izt.getIndex() + 1);
        this.izu.setIndex(this.izu.getIndex() + 1);
        this.izv.setIndex(this.izv.getIndex() + 1);
        b(this.izt);
        b(this.izu);
        b(this.izv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwE() {
        this.izt.setIndex(this.izt.getIndex() - 1);
        this.izu.setIndex(this.izu.getIndex() - 1);
        this.izv.setIndex(this.izv.getIndex() - 1);
        b(this.izt);
        b(this.izu);
        b(this.izv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView yV(int i) {
        if (this.izt.getIndex() == i) {
            return this.izt;
        }
        if (this.izu.getIndex() == i) {
            return this.izu;
        }
        if (this.izv.getIndex() == i) {
            return this.izv;
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
            int size = this.izs.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int yW(int i) {
        int size = this.izs.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.izG[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.izG[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.izG[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.izG[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.izO && this.mDistance == 0.0f) {
            this.izs = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.izt.setVisibility(0);
                this.izu.setVisibility(0);
                this.izv.setVisibility(0);
                this.izt.setData(list.get(0));
                this.izu.setData(list.get(1));
                this.izv.setData(list.get(2));
                this.izt.setDataIndex(0);
                this.izu.setDataIndex(1);
                this.izv.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.izt.setVisibility(8);
                this.izu.setVisibility(0);
                this.izv.setVisibility(0);
                this.izu.setDataIndex(1);
                this.izv.setDataIndex(0);
                this.izu.setData(list.get(1));
                this.izv.setData(list.get(0));
                i = 1;
            } else {
                this.izt.setVisibility(8);
                this.izu.setVisibility(0);
                this.izv.setVisibility(8);
                this.izu.setDataIndex(0);
                this.izu.setData(list.get(0));
                i = 0;
            }
            yX(i);
        }
    }

    private void resetData() {
        this.izt.setIndex(0);
        this.izu.setIndex(1);
        this.izv.setIndex(2);
        this.izw.setIndex(1);
        d(this.izt);
        d(this.izu);
        d(this.izv);
        d(this.izw);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void yU(int i) {
        CellForumTestView cellForumTestView;
        this.izP = true;
        this.izw.setVisibility(0);
        this.izw.setAlpha(1.0f);
        cwF();
        if (this.izt.getIndex() == i && this.izt.getVisibility() == 0) {
            cellForumTestView = this.izt;
        } else if (this.izu.getIndex() == i && this.izu.getVisibility() == 0) {
            cellForumTestView = this.izu;
        } else {
            cellForumTestView = this.izv;
        }
        this.izw.setData(cellForumTestView.getData());
        this.izw.setDataIndex(cellForumTestView.getDataIndex());
        this.izy = null;
        if (this.izs.size() == 1) {
            this.izQ = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.izz * 3) / 5;
        } else if (this.izs.size() == 2) {
            this.izQ = 2;
            cellForumTestView.setVisibility(8);
            if (this.izt.getVisibility() == 0) {
                this.izx = this.izt;
            } else if (this.izu.getVisibility() == 0) {
                this.izx = this.izu;
            } else {
                this.izx = this.izv;
            }
            if (this.izx.getViewRight() < this.izG[1].left) {
                this.mDistance = this.izz + this.izF;
                this.izx.setIndex(this.izx.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.izx.getViewLeft() > this.izG[1].right) {
                this.mDistance = (-this.izz) - this.izF;
                this.izx.setIndex(this.izx.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.izx);
            b(cellForumTestView);
        } else if (this.izs.size() == 3) {
            this.izQ = 3;
            cellForumTestView.setVisibility(8);
            if (this.izt.getIndex() == 2) {
                this.izx = this.izt;
            } else if (this.izu.getIndex() == 2) {
                this.izx = this.izu;
            } else {
                this.izx = this.izv;
            }
            this.mDistance = (-this.izz) - this.izF;
            this.izx.setIndex(this.izx.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.izx);
            b(cellForumTestView);
        } else {
            this.izQ = 4;
            this.izy = cellForumTestView;
            if (this.izt.getIndex() == 2) {
                this.izx = this.izt;
            } else if (this.izu.getIndex() == 2) {
                this.izx = this.izu;
            } else {
                this.izx = this.izv;
            }
            this.mDistance = (-this.izz) - this.izF;
            this.izx.setIndex(this.izx.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.izx);
            b(cellForumTestView);
            this.izy.setViewLeft(this.izG[2].right + this.izF);
            this.izy.setViewRight(this.izG[2].right + this.izF + this.izz);
            this.izy.setViewTop(this.izG[2].top);
            this.izy.setViewBottom(this.izG[2].bottom);
            this.izy.setMoveLeft(this.izG[2].right + this.izF);
            this.izy.setMoveRight(this.izG[2].right + this.izF + this.izz);
            this.izy.setMoveTop(this.izG[2].top);
            this.izy.setMoveBottom(this.izG[2].bottom);
            this.izy.setData(this.izs.get(yW(this.izy.getDataIndex() + 2)));
        }
        this.izN.setFloatValues(0.0f, this.mDistance);
        this.izN.start();
    }

    private void cwF() {
        this.izt.setMoveLeft(this.izt.getViewLeft());
        this.izt.setMoveTop(this.izt.getViewTop());
        this.izt.setMoveRight(this.izt.getViewRight());
        this.izt.setMoveBottom(this.izt.getViewBottom());
        this.izu.setMoveLeft(this.izu.getViewLeft());
        this.izu.setMoveTop(this.izu.getViewTop());
        this.izu.setMoveRight(this.izu.getViewRight());
        this.izu.setMoveBottom(this.izu.getViewBottom());
        this.izv.setMoveLeft(this.izv.getViewLeft());
        this.izv.setMoveTop(this.izv.getViewTop());
        this.izv.setMoveRight(this.izv.getViewRight());
        this.izv.setMoveBottom(this.izv.getViewBottom());
        this.izw.setMoveLeft(this.izw.getViewLeft());
        this.izw.setMoveTop(this.izw.getViewTop());
        this.izw.setMoveRight(this.izw.getViewRight());
        this.izw.setMoveBottom(this.izw.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0205);
            this.izt.onChangeSkinType();
            this.izu.onChangeSkinType();
            this.izv.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.izO && this.mDistance == 0.0f) {
            if (this.izM != null) {
                this.izM.removeAllUpdateListeners();
                this.izM.cancel();
            }
            if (this.izN != null) {
                this.izN.removeAllUpdateListeners();
                this.izN.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.izt != null) {
            this.izt.setPageId(bdUniqueId);
        }
        if (this.izu != null) {
            this.izu.setPageId(bdUniqueId);
        }
        if (this.izv != null) {
            this.izv.setPageId(bdUniqueId);
        }
    }

    public void yX(int i) {
        f fVar;
        ar a2;
        if (this.izs != null && i >= 0 && i < this.izs.size() && (fVar = this.izs.get(i)) != null && (a2 = com.baidu.tieba.t.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.t.c.dOf().a(this.mPageId, com.baidu.tieba.t.a.Tt("" + fVar.testId), a2);
        }
    }
}
