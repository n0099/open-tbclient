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
    private Rect[] izE;
    private float izF;
    private float izG;
    private float izH;
    private float izI;
    private float izJ;
    private ValueAnimator izK;
    private ValueAnimator izL;
    private boolean izM;
    private boolean izN;
    private int izO;
    private int izP;
    private a izQ;
    private boolean izR;
    private float izS;
    private int izT;
    private List<f> izq;
    private CellForumTestView izr;
    private CellForumTestView izs;
    private CellForumTestView izt;
    private CellForumTestView izu;
    private CellForumTestView izv;
    private CellForumTestView izw;
    private int izx;
    private int izy;
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
        void cwF();

        void gg(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.izE = new Rect[3];
        this.izM = false;
        this.izN = false;
        this.izR = false;
        this.izS = 0.0f;
        this.izT = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.izE = new Rect[3];
        this.izM = false;
        this.izN = false;
        this.izR = false;
        this.izS = 0.0f;
        this.izT = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.izE = new Rect[3];
        this.izM = false;
        this.izN = false;
        this.izR = false;
        this.izS = 0.0f;
        this.izT = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.izr = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.izs = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.izt = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.izu = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        fR(context);
        resetData();
        ViewConfiguration.get(context);
        this.XQ = ViewConfiguration.getMaximumFlingVelocity();
        this.izr.setForumTestDelClickListener(this);
        this.izs.setForumTestDelClickListener(this);
        this.izt.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void fR(Context context) {
        this.izB = l.getDimens(context, R.dimen.tbds44);
        this.izC = l.getDimens(context, R.dimen.tbds30);
        this.izD = l.getDimens(context, R.dimen.tbds7);
        this.izA = l.getDimens(context, R.dimen.tbds730);
        this.izz = this.izA - (this.izC * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.izx = (int) (this.mWidth * 0.89f);
        this.mHeight = this.izA + this.izB;
        this.izy = ((this.mWidth - this.izx) - (this.izD * 2)) / 2;
        this.izH = this.izC / (this.izx + this.izD);
        this.izI = this.izA / this.izx;
        this.izJ = this.izx / (this.izx + this.izD);
        this.izE[0] = new Rect(this.izy - this.izx, this.izB + this.izC, this.izy, this.izB + this.izC + this.izz);
        this.izE[1] = new Rect(this.izy + this.izD, this.izB, this.izy + this.izD + this.izx, this.izB + this.izA);
        this.izE[2] = new Rect(this.mWidth - this.izy, this.izB + this.izC, (this.mWidth - this.izy) + this.izx, this.izB + this.izC + this.izz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.izL = ValueAnimator.ofFloat(this.izx, 0.0f);
        this.izL.setDuration(500L);
        this.izL.setInterpolator(new DecelerateInterpolator());
        this.izL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.izO != 1) {
                    if (ForumTestView.this.izO == 2 || ForumTestView.this.izO == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.izH * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.izI;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.izu.setAlpha(0.0f);
                            ForumTestView.this.izu.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.izv);
                            ForumTestView.this.d(ForumTestView.this.izu);
                            ForumTestView.this.izq.remove(ForumTestView.this.izu.getData());
                            ForumTestView.this.pu(true);
                            ForumTestView.this.izN = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.izv, floatValue, abs);
                            if ((ForumTestView.this.izx * 2) / 5 >= ForumTestView.this.izu.getViewRight() - ForumTestView.this.izu.getViewLeft()) {
                                ForumTestView.this.izu.setAlpha(0.0f);
                                ForumTestView.this.izu.setVisibility(8);
                            } else {
                                ForumTestView.this.izu.setViewLeft(ForumTestView.this.izu.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.izu.setViewRight(ForumTestView.this.izu.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.izu.setViewTop(ForumTestView.this.izu.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.izu.setViewBottom(ForumTestView.this.izu.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.izu.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.izx * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.izH * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.izI;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.izu.setAlpha(0.0f);
                        ForumTestView.this.izu.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.izv);
                        ForumTestView.this.d(ForumTestView.this.izu);
                        ForumTestView.this.d(ForumTestView.this.izw);
                        ForumTestView.this.izq.remove(ForumTestView.this.izu.getData());
                        if (ForumTestView.this.izr.getIndex() == 0) {
                            if (ForumTestView.this.izr.getDataIndex() > ForumTestView.this.izw.getDataIndex()) {
                                ForumTestView.this.izr.setDataIndex(ForumTestView.this.izr.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.izr);
                            }
                        } else if (ForumTestView.this.izs.getIndex() == 0) {
                            if (ForumTestView.this.izs.getDataIndex() > ForumTestView.this.izw.getDataIndex()) {
                                ForumTestView.this.izs.setDataIndex(ForumTestView.this.izs.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.izs);
                            }
                        } else if (ForumTestView.this.izt.getDataIndex() > ForumTestView.this.izw.getDataIndex()) {
                            ForumTestView.this.izt.setDataIndex(ForumTestView.this.izt.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.izt);
                        }
                        if (ForumTestView.this.izv.getDataIndex() > ForumTestView.this.izw.getDataIndex()) {
                            ForumTestView.this.izv.setDataIndex(ForumTestView.this.izv.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.izv);
                        }
                        ForumTestView.this.izw.setDataIndex(ForumTestView.this.izw.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.izw);
                        ForumTestView.this.pu(true);
                        ForumTestView.this.izN = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.izv, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.izw, floatValue2);
                        if ((ForumTestView.this.izx * 2) / 5 >= ForumTestView.this.izu.getViewRight() - ForumTestView.this.izu.getViewLeft()) {
                            ForumTestView.this.izu.setAlpha(0.0f);
                            ForumTestView.this.izu.setVisibility(8);
                        } else {
                            ForumTestView.this.izu.setViewLeft(ForumTestView.this.izu.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.izu.setViewRight(ForumTestView.this.izu.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.izu.setViewTop(ForumTestView.this.izu.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.izu.setViewBottom(ForumTestView.this.izu.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.izu.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.izx * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.izI * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.izu.setAlpha(0.0f);
                    ForumTestView.this.izu.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.izq.remove(ForumTestView.this.izu.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.izQ != null) {
                        ForumTestView.this.izQ.gg(-1L);
                    }
                    ForumTestView.this.izN = false;
                    if (ForumTestView.this.izQ != null && y.isEmpty(ForumTestView.this.izq)) {
                        ForumTestView.this.izQ.cwF();
                    }
                } else {
                    ForumTestView.this.izu.setViewLeft(ForumTestView.this.izu.getMoveLeft() + floatValue3);
                    ForumTestView.this.izu.setViewRight(ForumTestView.this.izu.getMoveRight() - floatValue3);
                    ForumTestView.this.izu.setViewTop(ForumTestView.this.izu.getMoveTop() + f);
                    ForumTestView.this.izu.setViewBottom(ForumTestView.this.izu.getMoveBottom() - f);
                    ForumTestView.this.izu.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.izT) {
                this.izT = equipmentWidth;
                fR(getContext());
                d(this.izr);
                d(this.izs);
                d(this.izt);
                d(this.izu);
            }
            a(this.izr);
            a(this.izs);
            a(this.izt);
            a(this.izu);
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
            this.izr.layout((int) this.izr.getViewLeft(), (int) this.izr.getViewTop(), (int) this.izr.getViewRight(), (int) this.izr.getViewBottom());
            this.izs.layout((int) this.izs.getViewLeft(), (int) this.izs.getViewTop(), (int) this.izs.getViewRight(), (int) this.izs.getViewBottom());
            this.izt.layout((int) this.izt.getViewLeft(), (int) this.izt.getViewTop(), (int) this.izt.getViewRight(), (int) this.izt.getViewBottom());
            this.izu.layout((int) this.izu.getViewLeft(), (int) this.izu.getViewTop(), (int) this.izu.getViewRight(), (int) this.izu.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.izL == null || !this.izL.isRunning()) {
            if (this.izK == null || !this.izK.isRunning()) {
                int action = motionEvent.getAction();
                Z(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.izK != null) {
                        this.izK.removeAllUpdateListeners();
                        this.izK.cancel();
                    }
                    this.izP = motionEvent.getPointerId(0);
                    this.izF = x;
                    this.izG = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.izF - x;
                    float f2 = this.izG - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.izM = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.izM) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.izH * f3;
                    if (this.izM) {
                        b(this.izr, f3, f4);
                        b(this.izs, f3, f4);
                        b(this.izt, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.XQ);
                    float xVelocity = velocityTracker.getXVelocity(this.izP);
                    if (this.izM || this.mDistance != 0.0f) {
                        aD(xVelocity);
                    }
                    this.izM = false;
                    releaseVelocityTracker();
                }
                if (this.izM || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.izq.size() > 2) {
                if (cellForumTestView.getViewRight() < this.izE[0].right - (this.izx / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.izE[0].right - (this.izx / 2))) + this.izE[2].left + (this.izx / 2) + this.izD);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.izx);
                    cellForumTestView.setViewTop(this.izE[2].top);
                    cellForumTestView.setViewBottom(this.izE[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.izq.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.izE[2].left + (this.izx / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.izE[2].left + (this.izx / 2))) + ((this.izE[0].right - (this.izx / 2)) - this.izD));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.izx);
                    cellForumTestView.setViewTop(this.izE[0].top);
                    cellForumTestView.setViewBottom(this.izE[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.izq.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.izE[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.izE[0].top) {
                    cellForumTestView.setViewTop(this.izE[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.izE[0].bottom) {
                    cellForumTestView.setViewBottom(this.izE[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.izE[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.izE[1].top) {
                    cellForumTestView.setViewTop(this.izE[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.izE[1].bottom) {
                    cellForumTestView.setViewBottom(this.izE[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.izQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(boolean z) {
        if (this.izQ != null) {
            int i = -1;
            if (this.izr.getIndex() == 1 && this.izr.getData() != null) {
                this.izQ.gg(this.izr.getData().testId);
                i = this.izr.getDataIndex();
            } else if (this.izs.getIndex() == 1 && this.izs.getData() != null) {
                this.izQ.gg(this.izs.getData().testId);
                i = this.izs.getDataIndex();
            } else if (this.izt.getIndex() == 1 && this.izt.getData() != null) {
                this.izQ.gg(this.izt.getData().testId);
                i = this.izt.getDataIndex();
            } else {
                this.izQ.gg(-1L);
            }
            if (z) {
                yX(i);
            }
        }
    }

    private void initAnimation() {
        this.izK = ValueAnimator.ofFloat(this.izx, 0.0f);
        this.izK.setDuration(200L);
        this.izK.setInterpolator(new DecelerateInterpolator());
        this.izK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.izx) * 0.2f;
                    if (ForumTestView.this.izR) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cwC();
                        } else {
                            ForumTestView.this.cwD();
                        }
                        ForumTestView.this.izR = false;
                    }
                    ForumTestView.this.izS = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.izr);
                    ForumTestView.this.d(ForumTestView.this.izs);
                    ForumTestView.this.d(ForumTestView.this.izt);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.pu(z);
                } else {
                    if (ForumTestView.this.izR) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.yV(2) != null && ForumTestView.this.yV(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cwC();
                                ForumTestView.this.izR = false;
                            }
                        } else if (ForumTestView.this.yV(0) != null && ForumTestView.this.yV(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cwD();
                            ForumTestView.this.izR = false;
                        }
                    }
                    float f = ForumTestView.this.izS - floatValue;
                    float f2 = ForumTestView.this.izH * f;
                    ForumTestView.this.b(ForumTestView.this.izr, f, f2);
                    ForumTestView.this.b(ForumTestView.this.izs, f, f2);
                    ForumTestView.this.b(ForumTestView.this.izt, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.izS = floatValue;
            }
        });
    }

    private void aD(float f) {
        CellForumTestView yV;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.izR = false;
        this.izS = 0.0f;
        initAnimation();
        if (this.izq.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.izr.getVisibility() == 0) {
                cellForumTestView3 = this.izr;
            }
            if (this.izs.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.izs;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.izs;
            }
            if (this.izt.getVisibility() == 0) {
                cellForumTestView2 = this.izt;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.izE[0].left) || viewRight > ((float) this.izE[2].right)) && Math.abs(this.mDistance) >= this.izx * 0.2f) {
                this.izR = true;
            }
        } else if (this.izq.size() > 2 && Math.abs(this.mDistance) >= this.izx * 0.2f) {
            this.izR = true;
        }
        if (this.izR && (yV = yV(1)) != null) {
            if (this.mDistance >= this.izx) {
                this.mDistance -= this.izx;
                this.izR = false;
                cwD();
            } else if (this.mDistance > 0.0f && this.mDistance < this.izx) {
                this.mDistance = this.izE[0].right - yV.getViewRight();
            } else if (this.mDistance > (-this.izx)) {
                this.mDistance = this.izE[2].left - yV.getViewLeft();
            } else {
                cwC();
                this.mDistance += this.izx;
                this.izR = false;
            }
        }
        this.izK.setFloatValues(0.0f, this.mDistance);
        this.izK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwC() {
        this.izr.setIndex(this.izr.getIndex() + 1);
        this.izs.setIndex(this.izs.getIndex() + 1);
        this.izt.setIndex(this.izt.getIndex() + 1);
        b(this.izr);
        b(this.izs);
        b(this.izt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwD() {
        this.izr.setIndex(this.izr.getIndex() - 1);
        this.izs.setIndex(this.izs.getIndex() - 1);
        this.izt.setIndex(this.izt.getIndex() - 1);
        b(this.izr);
        b(this.izs);
        b(this.izt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView yV(int i) {
        if (this.izr.getIndex() == i) {
            return this.izr;
        }
        if (this.izs.getIndex() == i) {
            return this.izs;
        }
        if (this.izt.getIndex() == i) {
            return this.izt;
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
            int size = this.izq.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int yW(int i) {
        int size = this.izq.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.izE[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.izE[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.izE[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.izE[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.izM && this.mDistance == 0.0f) {
            this.izq = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.izr.setVisibility(0);
                this.izs.setVisibility(0);
                this.izt.setVisibility(0);
                this.izr.setData(list.get(0));
                this.izs.setData(list.get(1));
                this.izt.setData(list.get(2));
                this.izr.setDataIndex(0);
                this.izs.setDataIndex(1);
                this.izt.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.izr.setVisibility(8);
                this.izs.setVisibility(0);
                this.izt.setVisibility(0);
                this.izs.setDataIndex(1);
                this.izt.setDataIndex(0);
                this.izs.setData(list.get(1));
                this.izt.setData(list.get(0));
                i = 1;
            } else {
                this.izr.setVisibility(8);
                this.izs.setVisibility(0);
                this.izt.setVisibility(8);
                this.izs.setDataIndex(0);
                this.izs.setData(list.get(0));
                i = 0;
            }
            yX(i);
        }
    }

    private void resetData() {
        this.izr.setIndex(0);
        this.izs.setIndex(1);
        this.izt.setIndex(2);
        this.izu.setIndex(1);
        d(this.izr);
        d(this.izs);
        d(this.izt);
        d(this.izu);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void yU(int i) {
        CellForumTestView cellForumTestView;
        this.izN = true;
        this.izu.setVisibility(0);
        this.izu.setAlpha(1.0f);
        cwE();
        if (this.izr.getIndex() == i && this.izr.getVisibility() == 0) {
            cellForumTestView = this.izr;
        } else if (this.izs.getIndex() == i && this.izs.getVisibility() == 0) {
            cellForumTestView = this.izs;
        } else {
            cellForumTestView = this.izt;
        }
        this.izu.setData(cellForumTestView.getData());
        this.izu.setDataIndex(cellForumTestView.getDataIndex());
        this.izw = null;
        if (this.izq.size() == 1) {
            this.izO = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.izx * 3) / 5;
        } else if (this.izq.size() == 2) {
            this.izO = 2;
            cellForumTestView.setVisibility(8);
            if (this.izr.getVisibility() == 0) {
                this.izv = this.izr;
            } else if (this.izs.getVisibility() == 0) {
                this.izv = this.izs;
            } else {
                this.izv = this.izt;
            }
            if (this.izv.getViewRight() < this.izE[1].left) {
                this.mDistance = this.izx + this.izD;
                this.izv.setIndex(this.izv.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.izv.getViewLeft() > this.izE[1].right) {
                this.mDistance = (-this.izx) - this.izD;
                this.izv.setIndex(this.izv.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.izv);
            b(cellForumTestView);
        } else if (this.izq.size() == 3) {
            this.izO = 3;
            cellForumTestView.setVisibility(8);
            if (this.izr.getIndex() == 2) {
                this.izv = this.izr;
            } else if (this.izs.getIndex() == 2) {
                this.izv = this.izs;
            } else {
                this.izv = this.izt;
            }
            this.mDistance = (-this.izx) - this.izD;
            this.izv.setIndex(this.izv.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.izv);
            b(cellForumTestView);
        } else {
            this.izO = 4;
            this.izw = cellForumTestView;
            if (this.izr.getIndex() == 2) {
                this.izv = this.izr;
            } else if (this.izs.getIndex() == 2) {
                this.izv = this.izs;
            } else {
                this.izv = this.izt;
            }
            this.mDistance = (-this.izx) - this.izD;
            this.izv.setIndex(this.izv.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.izv);
            b(cellForumTestView);
            this.izw.setViewLeft(this.izE[2].right + this.izD);
            this.izw.setViewRight(this.izE[2].right + this.izD + this.izx);
            this.izw.setViewTop(this.izE[2].top);
            this.izw.setViewBottom(this.izE[2].bottom);
            this.izw.setMoveLeft(this.izE[2].right + this.izD);
            this.izw.setMoveRight(this.izE[2].right + this.izD + this.izx);
            this.izw.setMoveTop(this.izE[2].top);
            this.izw.setMoveBottom(this.izE[2].bottom);
            this.izw.setData(this.izq.get(yW(this.izw.getDataIndex() + 2)));
        }
        this.izL.setFloatValues(0.0f, this.mDistance);
        this.izL.start();
    }

    private void cwE() {
        this.izr.setMoveLeft(this.izr.getViewLeft());
        this.izr.setMoveTop(this.izr.getViewTop());
        this.izr.setMoveRight(this.izr.getViewRight());
        this.izr.setMoveBottom(this.izr.getViewBottom());
        this.izs.setMoveLeft(this.izs.getViewLeft());
        this.izs.setMoveTop(this.izs.getViewTop());
        this.izs.setMoveRight(this.izs.getViewRight());
        this.izs.setMoveBottom(this.izs.getViewBottom());
        this.izt.setMoveLeft(this.izt.getViewLeft());
        this.izt.setMoveTop(this.izt.getViewTop());
        this.izt.setMoveRight(this.izt.getViewRight());
        this.izt.setMoveBottom(this.izt.getViewBottom());
        this.izu.setMoveLeft(this.izu.getViewLeft());
        this.izu.setMoveTop(this.izu.getViewTop());
        this.izu.setMoveRight(this.izu.getViewRight());
        this.izu.setMoveBottom(this.izu.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.CAM_X0205);
            this.izr.onChangeSkinType();
            this.izs.onChangeSkinType();
            this.izt.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.izM && this.mDistance == 0.0f) {
            if (this.izK != null) {
                this.izK.removeAllUpdateListeners();
                this.izK.cancel();
            }
            if (this.izL != null) {
                this.izL.removeAllUpdateListeners();
                this.izL.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.izr != null) {
            this.izr.setPageId(bdUniqueId);
        }
        if (this.izs != null) {
            this.izs.setPageId(bdUniqueId);
        }
        if (this.izt != null) {
            this.izt.setPageId(bdUniqueId);
        }
    }

    public void yX(int i) {
        f fVar;
        ar a2;
        if (this.izq != null && i >= 0 && i < this.izq.size() && (fVar = this.izq.get(i)) != null && (a2 = com.baidu.tieba.t.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.t.c.dOe().a(this.mPageId, com.baidu.tieba.t.a.Tt("" + fVar.testId), a2);
        }
    }
}
