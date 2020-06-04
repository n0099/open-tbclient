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
    private List<f> gTY;
    private CellForumTestView gTZ;
    private float gUA;
    private int gUB;
    private CellForumTestView gUa;
    private CellForumTestView gUb;
    private CellForumTestView gUc;
    private CellForumTestView gUd;
    private CellForumTestView gUe;
    private int gUf;
    private int gUg;
    private int gUh;
    private int gUi;
    private int gUj;
    private int gUk;
    private int gUl;
    private Rect[] gUm;
    private float gUn;
    private float gUo;
    private float gUp;
    private float gUq;
    private float gUr;
    private ValueAnimator gUs;
    private ValueAnimator gUt;
    private boolean gUu;
    private boolean gUv;
    private int gUw;
    private int gUx;
    private a gUy;
    private boolean gUz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void bPJ();

        void ea(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gUm = new Rect[3];
        this.gUu = false;
        this.gUv = false;
        this.gUz = false;
        this.gUA = 0.0f;
        this.gUB = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gUm = new Rect[3];
        this.gUu = false;
        this.gUv = false;
        this.gUz = false;
        this.gUA = 0.0f;
        this.gUB = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gUm = new Rect[3];
        this.gUu = false;
        this.gUv = false;
        this.gUz = false;
        this.gUA = 0.0f;
        this.gUB = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.gTZ = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.gUa = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.gUb = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.gUc = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        eI(context);
        resetData();
        ViewConfiguration.get(context);
        this.Vg = ViewConfiguration.getMaximumFlingVelocity();
        this.gTZ.setForumTestDelClickListener(this);
        this.gUa.setForumTestDelClickListener(this);
        this.gUb.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void eI(Context context) {
        this.gUj = l.getDimens(context, R.dimen.tbds44);
        this.gUk = l.getDimens(context, R.dimen.tbds30);
        this.gUl = l.getDimens(context, R.dimen.tbds7);
        this.gUi = l.getDimens(context, R.dimen.tbds730);
        this.gUh = this.gUi - (this.gUk * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.gUf = (int) (this.mWidth * 0.89f);
        this.mHeight = this.gUi + this.gUj;
        this.gUg = ((this.mWidth - this.gUf) - (this.gUl * 2)) / 2;
        this.gUp = this.gUk / (this.gUf + this.gUl);
        this.gUq = this.gUi / this.gUf;
        this.gUr = this.gUf / (this.gUf + this.gUl);
        this.gUm[0] = new Rect(this.gUg - this.gUf, this.gUj + this.gUk, this.gUg, this.gUj + this.gUk + this.gUh);
        this.gUm[1] = new Rect(this.gUg + this.gUl, this.gUj, this.gUg + this.gUl + this.gUf, this.gUj + this.gUi);
        this.gUm[2] = new Rect(this.mWidth - this.gUg, this.gUj + this.gUk, (this.mWidth - this.gUg) + this.gUf, this.gUj + this.gUk + this.gUh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gUt = ValueAnimator.ofFloat(this.gUf, 0.0f);
        this.gUt.setDuration(500L);
        this.gUt.setInterpolator(new DecelerateInterpolator());
        this.gUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.gUw != 1) {
                    if (ForumTestView.this.gUw == 2 || ForumTestView.this.gUw == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.gUp * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.gUq;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.gUc.setAlpha(0.0f);
                            ForumTestView.this.gUc.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.gUd);
                            ForumTestView.this.d(ForumTestView.this.gUc);
                            ForumTestView.this.gTY.remove(ForumTestView.this.gUc.getData());
                            ForumTestView.this.mn(true);
                            ForumTestView.this.gUv = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.gUd, floatValue, abs);
                            if ((ForumTestView.this.gUf * 2) / 5 >= ForumTestView.this.gUc.getViewRight() - ForumTestView.this.gUc.getViewLeft()) {
                                ForumTestView.this.gUc.setAlpha(0.0f);
                                ForumTestView.this.gUc.setVisibility(8);
                            } else {
                                ForumTestView.this.gUc.setViewLeft(ForumTestView.this.gUc.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.gUc.setViewRight(ForumTestView.this.gUc.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.gUc.setViewTop(ForumTestView.this.gUc.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.gUc.setViewBottom(ForumTestView.this.gUc.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.gUc.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.gUf * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.gUp * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.gUq;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.gUc.setAlpha(0.0f);
                        ForumTestView.this.gUc.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.gUd);
                        ForumTestView.this.d(ForumTestView.this.gUc);
                        ForumTestView.this.d(ForumTestView.this.gUe);
                        ForumTestView.this.gTY.remove(ForumTestView.this.gUc.getData());
                        if (ForumTestView.this.gTZ.getIndex() == 0) {
                            if (ForumTestView.this.gTZ.getDataIndex() > ForumTestView.this.gUe.getDataIndex()) {
                                ForumTestView.this.gTZ.setDataIndex(ForumTestView.this.gTZ.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.gTZ);
                            }
                        } else if (ForumTestView.this.gUa.getIndex() == 0) {
                            if (ForumTestView.this.gUa.getDataIndex() > ForumTestView.this.gUe.getDataIndex()) {
                                ForumTestView.this.gUa.setDataIndex(ForumTestView.this.gUa.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.gUa);
                            }
                        } else if (ForumTestView.this.gUb.getDataIndex() > ForumTestView.this.gUe.getDataIndex()) {
                            ForumTestView.this.gUb.setDataIndex(ForumTestView.this.gUb.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.gUb);
                        }
                        if (ForumTestView.this.gUd.getDataIndex() > ForumTestView.this.gUe.getDataIndex()) {
                            ForumTestView.this.gUd.setDataIndex(ForumTestView.this.gUd.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.gUd);
                        }
                        ForumTestView.this.gUe.setDataIndex(ForumTestView.this.gUe.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.gUe);
                        ForumTestView.this.mn(true);
                        ForumTestView.this.gUv = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.gUd, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.gUe, floatValue2);
                        if ((ForumTestView.this.gUf * 2) / 5 >= ForumTestView.this.gUc.getViewRight() - ForumTestView.this.gUc.getViewLeft()) {
                            ForumTestView.this.gUc.setAlpha(0.0f);
                            ForumTestView.this.gUc.setVisibility(8);
                        } else {
                            ForumTestView.this.gUc.setViewLeft(ForumTestView.this.gUc.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.gUc.setViewRight(ForumTestView.this.gUc.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.gUc.setViewTop(ForumTestView.this.gUc.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.gUc.setViewBottom(ForumTestView.this.gUc.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.gUc.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.gUf * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.gUq * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.gUc.setAlpha(0.0f);
                    ForumTestView.this.gUc.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.gTY.remove(ForumTestView.this.gUc.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.gUy != null) {
                        ForumTestView.this.gUy.ea(-1L);
                    }
                    ForumTestView.this.gUv = false;
                    if (ForumTestView.this.gUy != null && v.isEmpty(ForumTestView.this.gTY)) {
                        ForumTestView.this.gUy.bPJ();
                    }
                } else {
                    ForumTestView.this.gUc.setViewLeft(ForumTestView.this.gUc.getMoveLeft() + floatValue3);
                    ForumTestView.this.gUc.setViewRight(ForumTestView.this.gUc.getMoveRight() - floatValue3);
                    ForumTestView.this.gUc.setViewTop(ForumTestView.this.gUc.getMoveTop() + f);
                    ForumTestView.this.gUc.setViewBottom(ForumTestView.this.gUc.getMoveBottom() - f);
                    ForumTestView.this.gUc.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.gUB) {
                this.gUB = equipmentWidth;
                eI(getContext());
                d(this.gTZ);
                d(this.gUa);
                d(this.gUb);
                d(this.gUc);
            }
            a(this.gTZ);
            a(this.gUa);
            a(this.gUb);
            a(this.gUc);
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
            this.gTZ.layout((int) this.gTZ.getViewLeft(), (int) this.gTZ.getViewTop(), (int) this.gTZ.getViewRight(), (int) this.gTZ.getViewBottom());
            this.gUa.layout((int) this.gUa.getViewLeft(), (int) this.gUa.getViewTop(), (int) this.gUa.getViewRight(), (int) this.gUa.getViewBottom());
            this.gUb.layout((int) this.gUb.getViewLeft(), (int) this.gUb.getViewTop(), (int) this.gUb.getViewRight(), (int) this.gUb.getViewBottom());
            this.gUc.layout((int) this.gUc.getViewLeft(), (int) this.gUc.getViewTop(), (int) this.gUc.getViewRight(), (int) this.gUc.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.gUt == null || !this.gUt.isRunning()) {
            if (this.gUs == null || !this.gUs.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.gUs != null) {
                        this.gUs.removeAllUpdateListeners();
                        this.gUs.cancel();
                    }
                    this.gUx = motionEvent.getPointerId(0);
                    this.gUn = x;
                    this.gUo = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.gUn - x;
                    float f2 = this.gUo - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.gUu = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.gUu) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.gUp * f3;
                    if (this.gUu) {
                        b(this.gTZ, f3, f4);
                        b(this.gUa, f3, f4);
                        b(this.gUb, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.Vg);
                    float xVelocity = velocityTracker.getXVelocity(this.gUx);
                    if (this.gUu || this.mDistance != 0.0f) {
                        ae(xVelocity);
                    }
                    this.gUu = false;
                    releaseVelocityTracker();
                }
                if (this.gUu || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.gTY.size() > 2) {
                if (cellForumTestView.getViewRight() < this.gUm[0].right - (this.gUf / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.gUm[0].right - (this.gUf / 2))) + this.gUm[2].left + (this.gUf / 2) + this.gUl);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.gUf);
                    cellForumTestView.setViewTop(this.gUm[2].top);
                    cellForumTestView.setViewBottom(this.gUm[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.gTY.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.gUm[2].left + (this.gUf / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.gUm[2].left + (this.gUf / 2))) + ((this.gUm[0].right - (this.gUf / 2)) - this.gUl));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.gUf);
                    cellForumTestView.setViewTop(this.gUm[0].top);
                    cellForumTestView.setViewBottom(this.gUm[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.gTY.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.gUm[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.gUm[0].top) {
                    cellForumTestView.setViewTop(this.gUm[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.gUm[0].bottom) {
                    cellForumTestView.setViewBottom(this.gUm[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.gUm[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.gUm[1].top) {
                    cellForumTestView.setViewTop(this.gUm[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.gUm[1].bottom) {
                    cellForumTestView.setViewBottom(this.gUm[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.gUy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(boolean z) {
        if (this.gUy != null) {
            int i = -1;
            if (this.gTZ.getIndex() == 1 && this.gTZ.getData() != null) {
                this.gUy.ea(this.gTZ.getData().testId);
                i = this.gTZ.getDataIndex();
            } else if (this.gUa.getIndex() == 1 && this.gUa.getData() != null) {
                this.gUy.ea(this.gUa.getData().testId);
                i = this.gUa.getDataIndex();
            } else if (this.gUb.getIndex() == 1 && this.gUb.getData() != null) {
                this.gUy.ea(this.gUb.getData().testId);
                i = this.gUb.getDataIndex();
            } else {
                this.gUy.ea(-1L);
            }
            if (z) {
                tb(i);
            }
        }
    }

    private void initAnimation() {
        this.gUs = ValueAnimator.ofFloat(this.gUf, 0.0f);
        this.gUs.setDuration(200L);
        this.gUs.setInterpolator(new DecelerateInterpolator());
        this.gUs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.gUf) * 0.2f;
                    if (ForumTestView.this.gUz) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bPG();
                        } else {
                            ForumTestView.this.bPH();
                        }
                        ForumTestView.this.gUz = false;
                    }
                    ForumTestView.this.gUA = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.gTZ);
                    ForumTestView.this.d(ForumTestView.this.gUa);
                    ForumTestView.this.d(ForumTestView.this.gUb);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.mn(z);
                } else {
                    if (ForumTestView.this.gUz) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.sZ(2) != null && ForumTestView.this.sZ(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bPG();
                                ForumTestView.this.gUz = false;
                            }
                        } else if (ForumTestView.this.sZ(0) != null && ForumTestView.this.sZ(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bPH();
                            ForumTestView.this.gUz = false;
                        }
                    }
                    float f = ForumTestView.this.gUA - floatValue;
                    float f2 = ForumTestView.this.gUp * f;
                    ForumTestView.this.b(ForumTestView.this.gTZ, f, f2);
                    ForumTestView.this.b(ForumTestView.this.gUa, f, f2);
                    ForumTestView.this.b(ForumTestView.this.gUb, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.gUA = floatValue;
            }
        });
    }

    private void ae(float f) {
        CellForumTestView sZ;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.gUz = false;
        this.gUA = 0.0f;
        initAnimation();
        if (this.gTY.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.gTZ.getVisibility() == 0) {
                cellForumTestView3 = this.gTZ;
            }
            if (this.gUa.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.gUa;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.gUa;
            }
            if (this.gUb.getVisibility() == 0) {
                cellForumTestView2 = this.gUb;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.gUm[0].left) || viewRight > ((float) this.gUm[2].right)) && Math.abs(this.mDistance) >= this.gUf * 0.2f) {
                this.gUz = true;
            }
        } else if (this.gTY.size() > 2 && Math.abs(this.mDistance) >= this.gUf * 0.2f) {
            this.gUz = true;
        }
        if (this.gUz && (sZ = sZ(1)) != null) {
            if (this.mDistance >= this.gUf) {
                this.mDistance -= this.gUf;
                this.gUz = false;
                bPH();
            } else if (this.mDistance > 0.0f && this.mDistance < this.gUf) {
                this.mDistance = this.gUm[0].right - sZ.getViewRight();
            } else if (this.mDistance > (-this.gUf)) {
                this.mDistance = this.gUm[2].left - sZ.getViewLeft();
            } else {
                bPG();
                this.mDistance += this.gUf;
                this.gUz = false;
            }
        }
        this.gUs.setFloatValues(0.0f, this.mDistance);
        this.gUs.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPG() {
        this.gTZ.setIndex(this.gTZ.getIndex() + 1);
        this.gUa.setIndex(this.gUa.getIndex() + 1);
        this.gUb.setIndex(this.gUb.getIndex() + 1);
        b(this.gTZ);
        b(this.gUa);
        b(this.gUb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPH() {
        this.gTZ.setIndex(this.gTZ.getIndex() - 1);
        this.gUa.setIndex(this.gUa.getIndex() - 1);
        this.gUb.setIndex(this.gUb.getIndex() - 1);
        b(this.gTZ);
        b(this.gUa);
        b(this.gUb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView sZ(int i) {
        if (this.gTZ.getIndex() == i) {
            return this.gTZ;
        }
        if (this.gUa.getIndex() == i) {
            return this.gUa;
        }
        if (this.gUb.getIndex() == i) {
            return this.gUb;
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
            int size = this.gTY.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int ta(int i) {
        int size = this.gTY.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.gUm[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.gUm[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.gUm[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.gUm[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.gUu && this.mDistance == 0.0f) {
            this.gTY = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.gTZ.setVisibility(0);
                this.gUa.setVisibility(0);
                this.gUb.setVisibility(0);
                this.gTZ.setData(list.get(0));
                this.gUa.setData(list.get(1));
                this.gUb.setData(list.get(2));
                this.gTZ.setDataIndex(0);
                this.gUa.setDataIndex(1);
                this.gUb.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.gTZ.setVisibility(8);
                this.gUa.setVisibility(0);
                this.gUb.setVisibility(0);
                this.gUa.setDataIndex(1);
                this.gUb.setDataIndex(0);
                this.gUa.setData(list.get(1));
                this.gUb.setData(list.get(0));
                i = 1;
            } else {
                this.gTZ.setVisibility(8);
                this.gUa.setVisibility(0);
                this.gUb.setVisibility(8);
                this.gUa.setDataIndex(0);
                this.gUa.setData(list.get(0));
                i = 0;
            }
            tb(i);
        }
    }

    private void resetData() {
        this.gTZ.setIndex(0);
        this.gUa.setIndex(1);
        this.gUb.setIndex(2);
        this.gUc.setIndex(1);
        d(this.gTZ);
        d(this.gUa);
        d(this.gUb);
        d(this.gUc);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void sY(int i) {
        CellForumTestView cellForumTestView;
        this.gUv = true;
        this.gUc.setVisibility(0);
        this.gUc.setAlpha(1.0f);
        bPI();
        if (this.gTZ.getIndex() == i && this.gTZ.getVisibility() == 0) {
            cellForumTestView = this.gTZ;
        } else if (this.gUa.getIndex() == i && this.gUa.getVisibility() == 0) {
            cellForumTestView = this.gUa;
        } else {
            cellForumTestView = this.gUb;
        }
        this.gUc.setData(cellForumTestView.getData());
        this.gUc.setDataIndex(cellForumTestView.getDataIndex());
        this.gUe = null;
        if (this.gTY.size() == 1) {
            this.gUw = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.gUf * 3) / 5;
        } else if (this.gTY.size() == 2) {
            this.gUw = 2;
            cellForumTestView.setVisibility(8);
            if (this.gTZ.getVisibility() == 0) {
                this.gUd = this.gTZ;
            } else if (this.gUa.getVisibility() == 0) {
                this.gUd = this.gUa;
            } else {
                this.gUd = this.gUb;
            }
            if (this.gUd.getViewRight() < this.gUm[1].left) {
                this.mDistance = this.gUf + this.gUl;
                this.gUd.setIndex(this.gUd.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.gUd.getViewLeft() > this.gUm[1].right) {
                this.mDistance = (-this.gUf) - this.gUl;
                this.gUd.setIndex(this.gUd.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.gUd);
            b(cellForumTestView);
        } else if (this.gTY.size() == 3) {
            this.gUw = 3;
            cellForumTestView.setVisibility(8);
            if (this.gTZ.getIndex() == 2) {
                this.gUd = this.gTZ;
            } else if (this.gUa.getIndex() == 2) {
                this.gUd = this.gUa;
            } else {
                this.gUd = this.gUb;
            }
            this.mDistance = (-this.gUf) - this.gUl;
            this.gUd.setIndex(this.gUd.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.gUd);
            b(cellForumTestView);
        } else {
            this.gUw = 4;
            this.gUe = cellForumTestView;
            if (this.gTZ.getIndex() == 2) {
                this.gUd = this.gTZ;
            } else if (this.gUa.getIndex() == 2) {
                this.gUd = this.gUa;
            } else {
                this.gUd = this.gUb;
            }
            this.mDistance = (-this.gUf) - this.gUl;
            this.gUd.setIndex(this.gUd.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.gUd);
            b(cellForumTestView);
            this.gUe.setViewLeft(this.gUm[2].right + this.gUl);
            this.gUe.setViewRight(this.gUm[2].right + this.gUl + this.gUf);
            this.gUe.setViewTop(this.gUm[2].top);
            this.gUe.setViewBottom(this.gUm[2].bottom);
            this.gUe.setMoveLeft(this.gUm[2].right + this.gUl);
            this.gUe.setMoveRight(this.gUm[2].right + this.gUl + this.gUf);
            this.gUe.setMoveTop(this.gUm[2].top);
            this.gUe.setMoveBottom(this.gUm[2].bottom);
            this.gUe.setData(this.gTY.get(ta(this.gUe.getDataIndex() + 2)));
        }
        this.gUt.setFloatValues(0.0f, this.mDistance);
        this.gUt.start();
    }

    private void bPI() {
        this.gTZ.setMoveLeft(this.gTZ.getViewLeft());
        this.gTZ.setMoveTop(this.gTZ.getViewTop());
        this.gTZ.setMoveRight(this.gTZ.getViewRight());
        this.gTZ.setMoveBottom(this.gTZ.getViewBottom());
        this.gUa.setMoveLeft(this.gUa.getViewLeft());
        this.gUa.setMoveTop(this.gUa.getViewTop());
        this.gUa.setMoveRight(this.gUa.getViewRight());
        this.gUa.setMoveBottom(this.gUa.getViewBottom());
        this.gUb.setMoveLeft(this.gUb.getViewLeft());
        this.gUb.setMoveTop(this.gUb.getViewTop());
        this.gUb.setMoveRight(this.gUb.getViewRight());
        this.gUb.setMoveBottom(this.gUb.getViewBottom());
        this.gUc.setMoveLeft(this.gUc.getViewLeft());
        this.gUc.setMoveTop(this.gUc.getViewTop());
        this.gUc.setMoveRight(this.gUc.getViewRight());
        this.gUc.setMoveBottom(this.gUc.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.gTZ.onChangeSkinType();
            this.gUa.onChangeSkinType();
            this.gUb.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.gUu && this.mDistance == 0.0f) {
            if (this.gUs != null) {
                this.gUs.removeAllUpdateListeners();
                this.gUs.cancel();
            }
            if (this.gUt != null) {
                this.gUt.removeAllUpdateListeners();
                this.gUt.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.gTZ != null) {
            this.gTZ.setPageId(bdUniqueId);
        }
        if (this.gUa != null) {
            this.gUa.setPageId(bdUniqueId);
        }
        if (this.gUb != null) {
            this.gUb.setPageId(bdUniqueId);
        }
    }

    public void tb(int i) {
        f fVar;
        an a2;
        if (this.gTY != null && i >= 0 && i < this.gTY.size() && (fVar = this.gTY.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.dcI().a(this.mPageId, com.baidu.tieba.s.a.Mp("" + fVar.testId), a2);
        }
    }
}
