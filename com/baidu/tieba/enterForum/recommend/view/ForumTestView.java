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
/* loaded from: classes21.dex */
public class ForumTestView extends FrameLayout implements com.baidu.tieba.enterForum.recommend.view.a {
    private int Wy;
    private int hGA;
    private int hGB;
    private int hGC;
    private int hGD;
    private Rect[] hGE;
    private float hGF;
    private float hGG;
    private float hGH;
    private float hGI;
    private float hGJ;
    private ValueAnimator hGK;
    private ValueAnimator hGL;
    private boolean hGM;
    private boolean hGN;
    private int hGO;
    private int hGP;
    private a hGQ;
    private boolean hGR;
    private float hGS;
    private int hGT;
    private List<f> hGq;
    private CellForumTestView hGr;
    private CellForumTestView hGs;
    private CellForumTestView hGt;
    private CellForumTestView hGu;
    private CellForumTestView hGv;
    private CellForumTestView hGw;
    private int hGx;
    private int hGy;
    private int hGz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes21.dex */
    public interface a {
        void cjJ();

        void eL(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hGE = new Rect[3];
        this.hGM = false;
        this.hGN = false;
        this.hGR = false;
        this.hGS = 0.0f;
        this.hGT = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hGE = new Rect[3];
        this.hGM = false;
        this.hGN = false;
        this.hGR = false;
        this.hGS = 0.0f;
        this.hGT = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hGE = new Rect[3];
        this.hGM = false;
        this.hGN = false;
        this.hGR = false;
        this.hGS = 0.0f;
        this.hGT = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.hGr = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.hGs = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.hGt = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.hGu = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        fd(context);
        resetData();
        ViewConfiguration.get(context);
        this.Wy = ViewConfiguration.getMaximumFlingVelocity();
        this.hGr.setForumTestDelClickListener(this);
        this.hGs.setForumTestDelClickListener(this);
        this.hGt.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void fd(Context context) {
        this.hGB = l.getDimens(context, R.dimen.tbds44);
        this.hGC = l.getDimens(context, R.dimen.tbds30);
        this.hGD = l.getDimens(context, R.dimen.tbds7);
        this.hGA = l.getDimens(context, R.dimen.tbds730);
        this.hGz = this.hGA - (this.hGC * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.hGx = (int) (this.mWidth * 0.89f);
        this.mHeight = this.hGA + this.hGB;
        this.hGy = ((this.mWidth - this.hGx) - (this.hGD * 2)) / 2;
        this.hGH = this.hGC / (this.hGx + this.hGD);
        this.hGI = this.hGA / this.hGx;
        this.hGJ = this.hGx / (this.hGx + this.hGD);
        this.hGE[0] = new Rect(this.hGy - this.hGx, this.hGB + this.hGC, this.hGy, this.hGB + this.hGC + this.hGz);
        this.hGE[1] = new Rect(this.hGy + this.hGD, this.hGB, this.hGy + this.hGD + this.hGx, this.hGB + this.hGA);
        this.hGE[2] = new Rect(this.mWidth - this.hGy, this.hGB + this.hGC, (this.mWidth - this.hGy) + this.hGx, this.hGB + this.hGC + this.hGz);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.hGL = ValueAnimator.ofFloat(this.hGx, 0.0f);
        this.hGL.setDuration(500L);
        this.hGL.setInterpolator(new DecelerateInterpolator());
        this.hGL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.hGO != 1) {
                    if (ForumTestView.this.hGO == 2 || ForumTestView.this.hGO == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.hGH * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.hGI;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.hGu.setAlpha(0.0f);
                            ForumTestView.this.hGu.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.hGv);
                            ForumTestView.this.d(ForumTestView.this.hGu);
                            ForumTestView.this.hGq.remove(ForumTestView.this.hGu.getData());
                            ForumTestView.this.nP(true);
                            ForumTestView.this.hGN = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.hGv, floatValue, abs);
                            if ((ForumTestView.this.hGx * 2) / 5 >= ForumTestView.this.hGu.getViewRight() - ForumTestView.this.hGu.getViewLeft()) {
                                ForumTestView.this.hGu.setAlpha(0.0f);
                                ForumTestView.this.hGu.setVisibility(8);
                            } else {
                                ForumTestView.this.hGu.setViewLeft(ForumTestView.this.hGu.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hGu.setViewRight(ForumTestView.this.hGu.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.hGu.setViewTop(ForumTestView.this.hGu.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.hGu.setViewBottom(ForumTestView.this.hGu.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.hGu.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.hGx * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.hGH * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.hGI;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.hGu.setAlpha(0.0f);
                        ForumTestView.this.hGu.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.hGv);
                        ForumTestView.this.d(ForumTestView.this.hGu);
                        ForumTestView.this.d(ForumTestView.this.hGw);
                        ForumTestView.this.hGq.remove(ForumTestView.this.hGu.getData());
                        if (ForumTestView.this.hGr.getIndex() == 0) {
                            if (ForumTestView.this.hGr.getDataIndex() > ForumTestView.this.hGw.getDataIndex()) {
                                ForumTestView.this.hGr.setDataIndex(ForumTestView.this.hGr.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hGr);
                            }
                        } else if (ForumTestView.this.hGs.getIndex() == 0) {
                            if (ForumTestView.this.hGs.getDataIndex() > ForumTestView.this.hGw.getDataIndex()) {
                                ForumTestView.this.hGs.setDataIndex(ForumTestView.this.hGs.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.hGs);
                            }
                        } else if (ForumTestView.this.hGt.getDataIndex() > ForumTestView.this.hGw.getDataIndex()) {
                            ForumTestView.this.hGt.setDataIndex(ForumTestView.this.hGt.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hGt);
                        }
                        if (ForumTestView.this.hGv.getDataIndex() > ForumTestView.this.hGw.getDataIndex()) {
                            ForumTestView.this.hGv.setDataIndex(ForumTestView.this.hGv.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.hGv);
                        }
                        ForumTestView.this.hGw.setDataIndex(ForumTestView.this.hGw.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.hGw);
                        ForumTestView.this.nP(true);
                        ForumTestView.this.hGN = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.hGv, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.hGw, floatValue2);
                        if ((ForumTestView.this.hGx * 2) / 5 >= ForumTestView.this.hGu.getViewRight() - ForumTestView.this.hGu.getViewLeft()) {
                            ForumTestView.this.hGu.setAlpha(0.0f);
                            ForumTestView.this.hGu.setVisibility(8);
                        } else {
                            ForumTestView.this.hGu.setViewLeft(ForumTestView.this.hGu.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hGu.setViewRight(ForumTestView.this.hGu.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.hGu.setViewTop(ForumTestView.this.hGu.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.hGu.setViewBottom(ForumTestView.this.hGu.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.hGu.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.hGx * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.hGI * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.hGu.setAlpha(0.0f);
                    ForumTestView.this.hGu.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.hGq.remove(ForumTestView.this.hGu.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.hGQ != null) {
                        ForumTestView.this.hGQ.eL(-1L);
                    }
                    ForumTestView.this.hGN = false;
                    if (ForumTestView.this.hGQ != null && y.isEmpty(ForumTestView.this.hGq)) {
                        ForumTestView.this.hGQ.cjJ();
                    }
                } else {
                    ForumTestView.this.hGu.setViewLeft(ForumTestView.this.hGu.getMoveLeft() + floatValue3);
                    ForumTestView.this.hGu.setViewRight(ForumTestView.this.hGu.getMoveRight() - floatValue3);
                    ForumTestView.this.hGu.setViewTop(ForumTestView.this.hGu.getMoveTop() + f);
                    ForumTestView.this.hGu.setViewBottom(ForumTestView.this.hGu.getMoveBottom() - f);
                    ForumTestView.this.hGu.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.hGT) {
                this.hGT = equipmentWidth;
                fd(getContext());
                d(this.hGr);
                d(this.hGs);
                d(this.hGt);
                d(this.hGu);
            }
            a(this.hGr);
            a(this.hGs);
            a(this.hGt);
            a(this.hGu);
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
            this.hGr.layout((int) this.hGr.getViewLeft(), (int) this.hGr.getViewTop(), (int) this.hGr.getViewRight(), (int) this.hGr.getViewBottom());
            this.hGs.layout((int) this.hGs.getViewLeft(), (int) this.hGs.getViewTop(), (int) this.hGs.getViewRight(), (int) this.hGs.getViewBottom());
            this.hGt.layout((int) this.hGt.getViewLeft(), (int) this.hGt.getViewTop(), (int) this.hGt.getViewRight(), (int) this.hGt.getViewBottom());
            this.hGu.layout((int) this.hGu.getViewLeft(), (int) this.hGu.getViewTop(), (int) this.hGu.getViewRight(), (int) this.hGu.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.hGL == null || !this.hGL.isRunning()) {
            if (this.hGK == null || !this.hGK.isRunning()) {
                int action = motionEvent.getAction();
                Y(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.hGK != null) {
                        this.hGK.removeAllUpdateListeners();
                        this.hGK.cancel();
                    }
                    this.hGP = motionEvent.getPointerId(0);
                    this.hGF = x;
                    this.hGG = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.hGF - x;
                    float f2 = this.hGG - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.hGM = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.hGM) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.hGH * f3;
                    if (this.hGM) {
                        b(this.hGr, f3, f4);
                        b(this.hGs, f3, f4);
                        b(this.hGt, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Wy);
                    float xVelocity = velocityTracker.getXVelocity(this.hGP);
                    if (this.hGM || this.mDistance != 0.0f) {
                        am(xVelocity);
                    }
                    this.hGM = false;
                    releaseVelocityTracker();
                }
                if (this.hGM || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return true;
    }

    private void Y(MotionEvent motionEvent) {
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
            if (this.hGq.size() > 2) {
                if (cellForumTestView.getViewRight() < this.hGE[0].right - (this.hGx / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.hGE[0].right - (this.hGx / 2))) + this.hGE[2].left + (this.hGx / 2) + this.hGD);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.hGx);
                    cellForumTestView.setViewTop(this.hGE[2].top);
                    cellForumTestView.setViewBottom(this.hGE[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hGq.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.hGE[2].left + (this.hGx / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.hGE[2].left + (this.hGx / 2))) + ((this.hGE[0].right - (this.hGx / 2)) - this.hGD));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.hGx);
                    cellForumTestView.setViewTop(this.hGE[0].top);
                    cellForumTestView.setViewBottom(this.hGE[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.hGq.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.hGE[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.hGE[0].top) {
                    cellForumTestView.setViewTop(this.hGE[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.hGE[0].bottom) {
                    cellForumTestView.setViewBottom(this.hGE[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.hGE[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.hGE[1].top) {
                    cellForumTestView.setViewTop(this.hGE[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.hGE[1].bottom) {
                    cellForumTestView.setViewBottom(this.hGE[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.hGQ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nP(boolean z) {
        if (this.hGQ != null) {
            int i = -1;
            if (this.hGr.getIndex() == 1 && this.hGr.getData() != null) {
                this.hGQ.eL(this.hGr.getData().testId);
                i = this.hGr.getDataIndex();
            } else if (this.hGs.getIndex() == 1 && this.hGs.getData() != null) {
                this.hGQ.eL(this.hGs.getData().testId);
                i = this.hGs.getDataIndex();
            } else if (this.hGt.getIndex() == 1 && this.hGt.getData() != null) {
                this.hGQ.eL(this.hGt.getData().testId);
                i = this.hGt.getDataIndex();
            } else {
                this.hGQ.eL(-1L);
            }
            if (z) {
                wI(i);
            }
        }
    }

    private void initAnimation() {
        this.hGK = ValueAnimator.ofFloat(this.hGx, 0.0f);
        this.hGK.setDuration(200L);
        this.hGK.setInterpolator(new DecelerateInterpolator());
        this.hGK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.hGx) * 0.2f;
                    if (ForumTestView.this.hGR) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.cjG();
                        } else {
                            ForumTestView.this.cjH();
                        }
                        ForumTestView.this.hGR = false;
                    }
                    ForumTestView.this.hGS = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.hGr);
                    ForumTestView.this.d(ForumTestView.this.hGs);
                    ForumTestView.this.d(ForumTestView.this.hGt);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.nP(z);
                } else {
                    if (ForumTestView.this.hGR) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.wG(2) != null && ForumTestView.this.wG(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.cjG();
                                ForumTestView.this.hGR = false;
                            }
                        } else if (ForumTestView.this.wG(0) != null && ForumTestView.this.wG(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.cjH();
                            ForumTestView.this.hGR = false;
                        }
                    }
                    float f = ForumTestView.this.hGS - floatValue;
                    float f2 = ForumTestView.this.hGH * f;
                    ForumTestView.this.b(ForumTestView.this.hGr, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hGs, f, f2);
                    ForumTestView.this.b(ForumTestView.this.hGt, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.hGS = floatValue;
            }
        });
    }

    private void am(float f) {
        CellForumTestView wG;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.hGR = false;
        this.hGS = 0.0f;
        initAnimation();
        if (this.hGq.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.hGr.getVisibility() == 0) {
                cellForumTestView3 = this.hGr;
            }
            if (this.hGs.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.hGs;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.hGs;
            }
            if (this.hGt.getVisibility() == 0) {
                cellForumTestView2 = this.hGt;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.hGE[0].left) || viewRight > ((float) this.hGE[2].right)) && Math.abs(this.mDistance) >= this.hGx * 0.2f) {
                this.hGR = true;
            }
        } else if (this.hGq.size() > 2 && Math.abs(this.mDistance) >= this.hGx * 0.2f) {
            this.hGR = true;
        }
        if (this.hGR && (wG = wG(1)) != null) {
            if (this.mDistance >= this.hGx) {
                this.mDistance -= this.hGx;
                this.hGR = false;
                cjH();
            } else if (this.mDistance > 0.0f && this.mDistance < this.hGx) {
                this.mDistance = this.hGE[0].right - wG.getViewRight();
            } else if (this.mDistance > (-this.hGx)) {
                this.mDistance = this.hGE[2].left - wG.getViewLeft();
            } else {
                cjG();
                this.mDistance += this.hGx;
                this.hGR = false;
            }
        }
        this.hGK.setFloatValues(0.0f, this.mDistance);
        this.hGK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjG() {
        this.hGr.setIndex(this.hGr.getIndex() + 1);
        this.hGs.setIndex(this.hGs.getIndex() + 1);
        this.hGt.setIndex(this.hGt.getIndex() + 1);
        b(this.hGr);
        b(this.hGs);
        b(this.hGt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjH() {
        this.hGr.setIndex(this.hGr.getIndex() - 1);
        this.hGs.setIndex(this.hGs.getIndex() - 1);
        this.hGt.setIndex(this.hGt.getIndex() - 1);
        b(this.hGr);
        b(this.hGs);
        b(this.hGt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView wG(int i) {
        if (this.hGr.getIndex() == i) {
            return this.hGr;
        }
        if (this.hGs.getIndex() == i) {
            return this.hGs;
        }
        if (this.hGt.getIndex() == i) {
            return this.hGt;
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
            int size = this.hGq.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int wH(int i) {
        int size = this.hGq.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.hGE[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.hGE[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.hGE[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.hGE[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!y.isEmpty(list) && !this.hGM && this.mDistance == 0.0f) {
            this.hGq = list;
            resetData();
            if (y.getCount(list) > 2) {
                this.hGr.setVisibility(0);
                this.hGs.setVisibility(0);
                this.hGt.setVisibility(0);
                this.hGr.setData(list.get(0));
                this.hGs.setData(list.get(1));
                this.hGt.setData(list.get(2));
                this.hGr.setDataIndex(0);
                this.hGs.setDataIndex(1);
                this.hGt.setDataIndex(2);
                i = 1;
            } else if (y.getCount(list) == 2) {
                this.hGr.setVisibility(8);
                this.hGs.setVisibility(0);
                this.hGt.setVisibility(0);
                this.hGs.setDataIndex(1);
                this.hGt.setDataIndex(0);
                this.hGs.setData(list.get(1));
                this.hGt.setData(list.get(0));
                i = 1;
            } else {
                this.hGr.setVisibility(8);
                this.hGs.setVisibility(0);
                this.hGt.setVisibility(8);
                this.hGs.setDataIndex(0);
                this.hGs.setData(list.get(0));
                i = 0;
            }
            wI(i);
        }
    }

    private void resetData() {
        this.hGr.setIndex(0);
        this.hGs.setIndex(1);
        this.hGt.setIndex(2);
        this.hGu.setIndex(1);
        d(this.hGr);
        d(this.hGs);
        d(this.hGt);
        d(this.hGu);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void wF(int i) {
        CellForumTestView cellForumTestView;
        this.hGN = true;
        this.hGu.setVisibility(0);
        this.hGu.setAlpha(1.0f);
        cjI();
        if (this.hGr.getIndex() == i && this.hGr.getVisibility() == 0) {
            cellForumTestView = this.hGr;
        } else if (this.hGs.getIndex() == i && this.hGs.getVisibility() == 0) {
            cellForumTestView = this.hGs;
        } else {
            cellForumTestView = this.hGt;
        }
        this.hGu.setData(cellForumTestView.getData());
        this.hGu.setDataIndex(cellForumTestView.getDataIndex());
        this.hGw = null;
        if (this.hGq.size() == 1) {
            this.hGO = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.hGx * 3) / 5;
        } else if (this.hGq.size() == 2) {
            this.hGO = 2;
            cellForumTestView.setVisibility(8);
            if (this.hGr.getVisibility() == 0) {
                this.hGv = this.hGr;
            } else if (this.hGs.getVisibility() == 0) {
                this.hGv = this.hGs;
            } else {
                this.hGv = this.hGt;
            }
            if (this.hGv.getViewRight() < this.hGE[1].left) {
                this.mDistance = this.hGx + this.hGD;
                this.hGv.setIndex(this.hGv.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.hGv.getViewLeft() > this.hGE[1].right) {
                this.mDistance = (-this.hGx) - this.hGD;
                this.hGv.setIndex(this.hGv.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.hGv);
            b(cellForumTestView);
        } else if (this.hGq.size() == 3) {
            this.hGO = 3;
            cellForumTestView.setVisibility(8);
            if (this.hGr.getIndex() == 2) {
                this.hGv = this.hGr;
            } else if (this.hGs.getIndex() == 2) {
                this.hGv = this.hGs;
            } else {
                this.hGv = this.hGt;
            }
            this.mDistance = (-this.hGx) - this.hGD;
            this.hGv.setIndex(this.hGv.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.hGv);
            b(cellForumTestView);
        } else {
            this.hGO = 4;
            this.hGw = cellForumTestView;
            if (this.hGr.getIndex() == 2) {
                this.hGv = this.hGr;
            } else if (this.hGs.getIndex() == 2) {
                this.hGv = this.hGs;
            } else {
                this.hGv = this.hGt;
            }
            this.mDistance = (-this.hGx) - this.hGD;
            this.hGv.setIndex(this.hGv.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.hGv);
            b(cellForumTestView);
            this.hGw.setViewLeft(this.hGE[2].right + this.hGD);
            this.hGw.setViewRight(this.hGE[2].right + this.hGD + this.hGx);
            this.hGw.setViewTop(this.hGE[2].top);
            this.hGw.setViewBottom(this.hGE[2].bottom);
            this.hGw.setMoveLeft(this.hGE[2].right + this.hGD);
            this.hGw.setMoveRight(this.hGE[2].right + this.hGD + this.hGx);
            this.hGw.setMoveTop(this.hGE[2].top);
            this.hGw.setMoveBottom(this.hGE[2].bottom);
            this.hGw.setData(this.hGq.get(wH(this.hGw.getDataIndex() + 2)));
        }
        this.hGL.setFloatValues(0.0f, this.mDistance);
        this.hGL.start();
    }

    private void cjI() {
        this.hGr.setMoveLeft(this.hGr.getViewLeft());
        this.hGr.setMoveTop(this.hGr.getViewTop());
        this.hGr.setMoveRight(this.hGr.getViewRight());
        this.hGr.setMoveBottom(this.hGr.getViewBottom());
        this.hGs.setMoveLeft(this.hGs.getViewLeft());
        this.hGs.setMoveTop(this.hGs.getViewTop());
        this.hGs.setMoveRight(this.hGs.getViewRight());
        this.hGs.setMoveBottom(this.hGs.getViewBottom());
        this.hGt.setMoveLeft(this.hGt.getViewLeft());
        this.hGt.setMoveTop(this.hGt.getViewTop());
        this.hGt.setMoveRight(this.hGt.getViewRight());
        this.hGt.setMoveBottom(this.hGt.getViewBottom());
        this.hGu.setMoveLeft(this.hGu.getViewLeft());
        this.hGu.setMoveTop(this.hGu.getViewTop());
        this.hGu.setMoveRight(this.hGu.getViewRight());
        this.hGu.setMoveBottom(this.hGu.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.hGr.onChangeSkinType();
            this.hGs.onChangeSkinType();
            this.hGt.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.hGM && this.mDistance == 0.0f) {
            if (this.hGK != null) {
                this.hGK.removeAllUpdateListeners();
                this.hGK.cancel();
            }
            if (this.hGL != null) {
                this.hGL.removeAllUpdateListeners();
                this.hGL.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.hGr != null) {
            this.hGr.setPageId(bdUniqueId);
        }
        if (this.hGs != null) {
            this.hGs.setPageId(bdUniqueId);
        }
        if (this.hGt != null) {
            this.hGt.setPageId(bdUniqueId);
        }
    }

    public void wI(int i) {
        f fVar;
        aq a2;
        if (this.hGq != null && i >= 0 && i < this.hGq.size() && (fVar = this.hGq.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dzC().a(this.mPageId, com.baidu.tieba.s.a.Ra("" + fVar.testId), a2);
        }
    }
}
