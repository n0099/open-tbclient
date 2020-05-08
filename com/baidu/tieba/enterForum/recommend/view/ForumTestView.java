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
    private int UR;
    private ValueAnimator gFA;
    private boolean gFB;
    private boolean gFC;
    private int gFD;
    private int gFE;
    private a gFF;
    private boolean gFG;
    private float gFH;
    private int gFI;
    private List<f> gFf;
    private CellForumTestView gFg;
    private CellForumTestView gFh;
    private CellForumTestView gFi;
    private CellForumTestView gFj;
    private CellForumTestView gFk;
    private CellForumTestView gFl;
    private int gFm;
    private int gFn;
    private int gFo;
    private int gFp;
    private int gFq;
    private int gFr;
    private int gFs;
    private Rect[] gFt;
    private float gFu;
    private float gFv;
    private float gFw;
    private float gFx;
    private float gFy;
    private ValueAnimator gFz;
    private float mDistance;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void bJn();

        void dZ(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gFt = new Rect[3];
        this.gFB = false;
        this.gFC = false;
        this.gFG = false;
        this.gFH = 0.0f;
        this.gFI = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gFt = new Rect[3];
        this.gFB = false;
        this.gFC = false;
        this.gFG = false;
        this.gFH = 0.0f;
        this.gFI = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gFt = new Rect[3];
        this.gFB = false;
        this.gFC = false;
        this.gFG = false;
        this.gFH = 0.0f;
        this.gFI = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.gFg = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.gFh = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.gFi = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.gFj = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        et(context);
        resetData();
        ViewConfiguration.get(context);
        this.UR = ViewConfiguration.getMaximumFlingVelocity();
        this.gFg.setForumTestDelClickListener(this);
        this.gFh.setForumTestDelClickListener(this);
        this.gFi.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void et(Context context) {
        this.gFq = l.getDimens(context, R.dimen.tbds44);
        this.gFr = l.getDimens(context, R.dimen.tbds30);
        this.gFs = l.getDimens(context, R.dimen.tbds7);
        this.gFp = l.getDimens(context, R.dimen.tbds730);
        this.gFo = this.gFp - (this.gFr * 2);
        this.mWidth = l.getEquipmentWidth(getContext());
        this.gFm = (int) (this.mWidth * 0.89f);
        this.mHeight = this.gFp + this.gFq;
        this.gFn = ((this.mWidth - this.gFm) - (this.gFs * 2)) / 2;
        this.gFw = this.gFr / (this.gFm + this.gFs);
        this.gFx = this.gFp / this.gFm;
        this.gFy = this.gFm / (this.gFm + this.gFs);
        this.gFt[0] = new Rect(this.gFn - this.gFm, this.gFq + this.gFr, this.gFn, this.gFq + this.gFr + this.gFo);
        this.gFt[1] = new Rect(this.gFn + this.gFs, this.gFq, this.gFn + this.gFs + this.gFm, this.gFq + this.gFp);
        this.gFt[2] = new Rect(this.mWidth - this.gFn, this.gFq + this.gFr, (this.mWidth - this.gFn) + this.gFm, this.gFq + this.gFr + this.gFo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gFA = ValueAnimator.ofFloat(this.gFm, 0.0f);
        this.gFA.setDuration(500L);
        this.gFA.setInterpolator(new DecelerateInterpolator());
        this.gFA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.gFD != 1) {
                    if (ForumTestView.this.gFD == 2 || ForumTestView.this.gFD == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.gFw * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.gFx;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                            ForumTestView.this.gFj.setAlpha(0.0f);
                            ForumTestView.this.gFj.setVisibility(8);
                            ForumTestView.this.mDistance = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.gFk);
                            ForumTestView.this.d(ForumTestView.this.gFj);
                            ForumTestView.this.gFf.remove(ForumTestView.this.gFj.getData());
                            ForumTestView.this.lS(true);
                            ForumTestView.this.gFC = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.gFk, floatValue, abs);
                            if ((ForumTestView.this.gFm * 2) / 5 >= ForumTestView.this.gFj.getViewRight() - ForumTestView.this.gFj.getViewLeft()) {
                                ForumTestView.this.gFj.setAlpha(0.0f);
                                ForumTestView.this.gFj.setVisibility(8);
                            } else {
                                ForumTestView.this.gFj.setViewLeft(ForumTestView.this.gFj.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.gFj.setViewRight(ForumTestView.this.gFj.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.gFj.setViewTop(ForumTestView.this.gFj.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.gFj.setViewBottom(ForumTestView.this.gFj.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.gFj.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.gFm * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.gFw * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.gFx;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.mDistance)) {
                        ForumTestView.this.gFj.setAlpha(0.0f);
                        ForumTestView.this.gFj.setVisibility(8);
                        ForumTestView.this.mDistance = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.gFk);
                        ForumTestView.this.d(ForumTestView.this.gFj);
                        ForumTestView.this.d(ForumTestView.this.gFl);
                        ForumTestView.this.gFf.remove(ForumTestView.this.gFj.getData());
                        if (ForumTestView.this.gFg.getIndex() == 0) {
                            if (ForumTestView.this.gFg.getDataIndex() > ForumTestView.this.gFl.getDataIndex()) {
                                ForumTestView.this.gFg.setDataIndex(ForumTestView.this.gFg.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.gFg);
                            }
                        } else if (ForumTestView.this.gFh.getIndex() == 0) {
                            if (ForumTestView.this.gFh.getDataIndex() > ForumTestView.this.gFl.getDataIndex()) {
                                ForumTestView.this.gFh.setDataIndex(ForumTestView.this.gFh.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.gFh);
                            }
                        } else if (ForumTestView.this.gFi.getDataIndex() > ForumTestView.this.gFl.getDataIndex()) {
                            ForumTestView.this.gFi.setDataIndex(ForumTestView.this.gFi.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.gFi);
                        }
                        if (ForumTestView.this.gFk.getDataIndex() > ForumTestView.this.gFl.getDataIndex()) {
                            ForumTestView.this.gFk.setDataIndex(ForumTestView.this.gFk.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.gFk);
                        }
                        ForumTestView.this.gFl.setDataIndex(ForumTestView.this.gFl.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.gFl);
                        ForumTestView.this.lS(true);
                        ForumTestView.this.gFC = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.gFk, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.gFl, floatValue2);
                        if ((ForumTestView.this.gFm * 2) / 5 >= ForumTestView.this.gFj.getViewRight() - ForumTestView.this.gFj.getViewLeft()) {
                            ForumTestView.this.gFj.setAlpha(0.0f);
                            ForumTestView.this.gFj.setVisibility(8);
                        } else {
                            ForumTestView.this.gFj.setViewLeft(ForumTestView.this.gFj.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.gFj.setViewRight(ForumTestView.this.gFj.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.gFj.setViewTop(ForumTestView.this.gFj.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.gFj.setViewBottom(ForumTestView.this.gFj.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.gFj.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.gFm * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.gFx * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.mDistance / 2.0f)) {
                    ForumTestView.this.gFj.setAlpha(0.0f);
                    ForumTestView.this.gFj.setVisibility(8);
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.gFf.remove(ForumTestView.this.gFj.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.gFF != null) {
                        ForumTestView.this.gFF.dZ(-1L);
                    }
                    ForumTestView.this.gFC = false;
                    if (ForumTestView.this.gFF != null && v.isEmpty(ForumTestView.this.gFf)) {
                        ForumTestView.this.gFF.bJn();
                    }
                } else {
                    ForumTestView.this.gFj.setViewLeft(ForumTestView.this.gFj.getMoveLeft() + floatValue3);
                    ForumTestView.this.gFj.setViewRight(ForumTestView.this.gFj.getMoveRight() - floatValue3);
                    ForumTestView.this.gFj.setViewTop(ForumTestView.this.gFj.getMoveTop() + f);
                    ForumTestView.this.gFj.setViewBottom(ForumTestView.this.gFj.getMoveBottom() - f);
                    ForumTestView.this.gFj.setAlpha(1.0f - (floatValue3 / ForumTestView.this.mDistance));
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
            if (equipmentWidth != this.gFI) {
                this.gFI = equipmentWidth;
                et(getContext());
                d(this.gFg);
                d(this.gFh);
                d(this.gFi);
                d(this.gFj);
            }
            a(this.gFg);
            a(this.gFh);
            a(this.gFi);
            a(this.gFj);
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
            this.gFg.layout((int) this.gFg.getViewLeft(), (int) this.gFg.getViewTop(), (int) this.gFg.getViewRight(), (int) this.gFg.getViewBottom());
            this.gFh.layout((int) this.gFh.getViewLeft(), (int) this.gFh.getViewTop(), (int) this.gFh.getViewRight(), (int) this.gFh.getViewBottom());
            this.gFi.layout((int) this.gFi.getViewLeft(), (int) this.gFi.getViewTop(), (int) this.gFi.getViewRight(), (int) this.gFi.getViewBottom());
            this.gFj.layout((int) this.gFj.getViewLeft(), (int) this.gFj.getViewTop(), (int) this.gFj.getViewRight(), (int) this.gFj.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.gFA == null || !this.gFA.isRunning()) {
            if (this.gFz == null || !this.gFz.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.gFz != null) {
                        this.gFz.removeAllUpdateListeners();
                        this.gFz.cancel();
                    }
                    this.gFE = motionEvent.getPointerId(0);
                    this.gFu = x;
                    this.gFv = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.gFu - x;
                    float f2 = this.gFv - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.gFB = true;
                        this.mDistance = f;
                    } else if (Math.abs(f2) > 30.0f && !this.gFB) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.gFw * f3;
                    if (this.gFB) {
                        b(this.gFg, f3, f4);
                        b(this.gFh, f3, f4);
                        b(this.gFi, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.UR);
                    float xVelocity = velocityTracker.getXVelocity(this.gFE);
                    if (this.gFB || this.mDistance != 0.0f) {
                        ag(xVelocity);
                    }
                    this.gFB = false;
                    releaseVelocityTracker();
                }
                if (this.gFB || this.mDistance != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.gFf.size() > 2) {
                if (cellForumTestView.getViewRight() < this.gFt[0].right - (this.gFm / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.gFt[0].right - (this.gFm / 2))) + this.gFt[2].left + (this.gFm / 2) + this.gFs);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.gFm);
                    cellForumTestView.setViewTop(this.gFt[2].top);
                    cellForumTestView.setViewBottom(this.gFt[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.gFf.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.gFt[2].left + (this.gFm / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.gFt[2].left + (this.gFm / 2))) + ((this.gFt[0].right - (this.gFm / 2)) - this.gFs));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.gFm);
                    cellForumTestView.setViewTop(this.gFt[0].top);
                    cellForumTestView.setViewBottom(this.gFt[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.gFf.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.gFt[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.gFt[0].top) {
                    cellForumTestView.setViewTop(this.gFt[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.gFt[0].bottom) {
                    cellForumTestView.setViewBottom(this.gFt[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.gFt[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.gFt[1].top) {
                    cellForumTestView.setViewTop(this.gFt[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.gFt[1].bottom) {
                    cellForumTestView.setViewBottom(this.gFt[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.gFF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (this.gFF != null) {
            int i = -1;
            if (this.gFg.getIndex() == 1 && this.gFg.getData() != null) {
                this.gFF.dZ(this.gFg.getData().testId);
                i = this.gFg.getDataIndex();
            } else if (this.gFh.getIndex() == 1 && this.gFh.getData() != null) {
                this.gFF.dZ(this.gFh.getData().testId);
                i = this.gFh.getDataIndex();
            } else if (this.gFi.getIndex() == 1 && this.gFi.getData() != null) {
                this.gFF.dZ(this.gFi.getData().testId);
                i = this.gFi.getDataIndex();
            } else {
                this.gFF.dZ(-1L);
            }
            if (z) {
                su(i);
            }
        }
    }

    private void initAnimation() {
        this.gFz = ValueAnimator.ofFloat(this.gFm, 0.0f);
        this.gFz.setDuration(200L);
        this.gFz.setInterpolator(new DecelerateInterpolator());
        this.gFz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.mDistance)) {
                    boolean z = Math.abs(ForumTestView.this.mDistance) >= ((float) ForumTestView.this.gFm) * 0.2f;
                    if (ForumTestView.this.gFG) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            ForumTestView.this.bJk();
                        } else {
                            ForumTestView.this.bJl();
                        }
                        ForumTestView.this.gFG = false;
                    }
                    ForumTestView.this.gFH = 0.0f;
                    ForumTestView.this.mDistance = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.gFg);
                    ForumTestView.this.d(ForumTestView.this.gFh);
                    ForumTestView.this.d(ForumTestView.this.gFi);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.lS(z);
                } else {
                    if (ForumTestView.this.gFG) {
                        if (ForumTestView.this.mDistance > 0.0f) {
                            if (ForumTestView.this.ss(2) != null && ForumTestView.this.ss(2).getViewLeft() >= l.getEquipmentWidth(ForumTestView.this.getContext())) {
                                ForumTestView.this.bJk();
                                ForumTestView.this.gFG = false;
                            }
                        } else if (ForumTestView.this.ss(0) != null && ForumTestView.this.ss(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bJl();
                            ForumTestView.this.gFG = false;
                        }
                    }
                    float f = ForumTestView.this.gFH - floatValue;
                    float f2 = ForumTestView.this.gFw * f;
                    ForumTestView.this.b(ForumTestView.this.gFg, f, f2);
                    ForumTestView.this.b(ForumTestView.this.gFh, f, f2);
                    ForumTestView.this.b(ForumTestView.this.gFi, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.gFH = floatValue;
            }
        });
    }

    private void ag(float f) {
        CellForumTestView ss;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.gFG = false;
        this.gFH = 0.0f;
        initAnimation();
        if (this.gFf.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.gFg.getVisibility() == 0) {
                cellForumTestView3 = this.gFg;
            }
            if (this.gFh.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.gFh;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.gFh;
            }
            if (this.gFi.getVisibility() == 0) {
                cellForumTestView2 = this.gFi;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.gFt[0].left) || viewRight > ((float) this.gFt[2].right)) && Math.abs(this.mDistance) >= this.gFm * 0.2f) {
                this.gFG = true;
            }
        } else if (this.gFf.size() > 2 && Math.abs(this.mDistance) >= this.gFm * 0.2f) {
            this.gFG = true;
        }
        if (this.gFG && (ss = ss(1)) != null) {
            if (this.mDistance >= this.gFm) {
                this.mDistance -= this.gFm;
                this.gFG = false;
                bJl();
            } else if (this.mDistance > 0.0f && this.mDistance < this.gFm) {
                this.mDistance = this.gFt[0].right - ss.getViewRight();
            } else if (this.mDistance > (-this.gFm)) {
                this.mDistance = this.gFt[2].left - ss.getViewLeft();
            } else {
                bJk();
                this.mDistance += this.gFm;
                this.gFG = false;
            }
        }
        this.gFz.setFloatValues(0.0f, this.mDistance);
        this.gFz.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJk() {
        this.gFg.setIndex(this.gFg.getIndex() + 1);
        this.gFh.setIndex(this.gFh.getIndex() + 1);
        this.gFi.setIndex(this.gFi.getIndex() + 1);
        b(this.gFg);
        b(this.gFh);
        b(this.gFi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJl() {
        this.gFg.setIndex(this.gFg.getIndex() - 1);
        this.gFh.setIndex(this.gFh.getIndex() - 1);
        this.gFi.setIndex(this.gFi.getIndex() - 1);
        b(this.gFg);
        b(this.gFh);
        b(this.gFi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView ss(int i) {
        if (this.gFg.getIndex() == i) {
            return this.gFg;
        }
        if (this.gFh.getIndex() == i) {
            return this.gFh;
        }
        if (this.gFi.getIndex() == i) {
            return this.gFi;
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
            int size = this.gFf.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int st(int i) {
        int size = this.gFf.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.gFt[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.gFt[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.gFt[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.gFt[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.isEmpty(list) && !this.gFB && this.mDistance == 0.0f) {
            this.gFf = list;
            resetData();
            if (v.getCount(list) > 2) {
                this.gFg.setVisibility(0);
                this.gFh.setVisibility(0);
                this.gFi.setVisibility(0);
                this.gFg.setData(list.get(0));
                this.gFh.setData(list.get(1));
                this.gFi.setData(list.get(2));
                this.gFg.setDataIndex(0);
                this.gFh.setDataIndex(1);
                this.gFi.setDataIndex(2);
                i = 1;
            } else if (v.getCount(list) == 2) {
                this.gFg.setVisibility(8);
                this.gFh.setVisibility(0);
                this.gFi.setVisibility(0);
                this.gFh.setDataIndex(1);
                this.gFi.setDataIndex(0);
                this.gFh.setData(list.get(1));
                this.gFi.setData(list.get(0));
                i = 1;
            } else {
                this.gFg.setVisibility(8);
                this.gFh.setVisibility(0);
                this.gFi.setVisibility(8);
                this.gFh.setDataIndex(0);
                this.gFh.setData(list.get(0));
                i = 0;
            }
            su(i);
        }
    }

    private void resetData() {
        this.gFg.setIndex(0);
        this.gFh.setIndex(1);
        this.gFi.setIndex(2);
        this.gFj.setIndex(1);
        d(this.gFg);
        d(this.gFh);
        d(this.gFi);
        d(this.gFj);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void sr(int i) {
        CellForumTestView cellForumTestView;
        this.gFC = true;
        this.gFj.setVisibility(0);
        this.gFj.setAlpha(1.0f);
        bJm();
        if (this.gFg.getIndex() == i && this.gFg.getVisibility() == 0) {
            cellForumTestView = this.gFg;
        } else if (this.gFh.getIndex() == i && this.gFh.getVisibility() == 0) {
            cellForumTestView = this.gFh;
        } else {
            cellForumTestView = this.gFi;
        }
        this.gFj.setData(cellForumTestView.getData());
        this.gFj.setDataIndex(cellForumTestView.getDataIndex());
        this.gFl = null;
        if (this.gFf.size() == 1) {
            this.gFD = 1;
            cellForumTestView.setVisibility(8);
            this.mDistance = (this.gFm * 3) / 5;
        } else if (this.gFf.size() == 2) {
            this.gFD = 2;
            cellForumTestView.setVisibility(8);
            if (this.gFg.getVisibility() == 0) {
                this.gFk = this.gFg;
            } else if (this.gFh.getVisibility() == 0) {
                this.gFk = this.gFh;
            } else {
                this.gFk = this.gFi;
            }
            if (this.gFk.getViewRight() < this.gFt[1].left) {
                this.mDistance = this.gFm + this.gFs;
                this.gFk.setIndex(this.gFk.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.gFk.getViewLeft() > this.gFt[1].right) {
                this.mDistance = (-this.gFm) - this.gFs;
                this.gFk.setIndex(this.gFk.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.gFk);
            b(cellForumTestView);
        } else if (this.gFf.size() == 3) {
            this.gFD = 3;
            cellForumTestView.setVisibility(8);
            if (this.gFg.getIndex() == 2) {
                this.gFk = this.gFg;
            } else if (this.gFh.getIndex() == 2) {
                this.gFk = this.gFh;
            } else {
                this.gFk = this.gFi;
            }
            this.mDistance = (-this.gFm) - this.gFs;
            this.gFk.setIndex(this.gFk.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.gFk);
            b(cellForumTestView);
        } else {
            this.gFD = 4;
            this.gFl = cellForumTestView;
            if (this.gFg.getIndex() == 2) {
                this.gFk = this.gFg;
            } else if (this.gFh.getIndex() == 2) {
                this.gFk = this.gFh;
            } else {
                this.gFk = this.gFi;
            }
            this.mDistance = (-this.gFm) - this.gFs;
            this.gFk.setIndex(this.gFk.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.gFk);
            b(cellForumTestView);
            this.gFl.setViewLeft(this.gFt[2].right + this.gFs);
            this.gFl.setViewRight(this.gFt[2].right + this.gFs + this.gFm);
            this.gFl.setViewTop(this.gFt[2].top);
            this.gFl.setViewBottom(this.gFt[2].bottom);
            this.gFl.setMoveLeft(this.gFt[2].right + this.gFs);
            this.gFl.setMoveRight(this.gFt[2].right + this.gFs + this.gFm);
            this.gFl.setMoveTop(this.gFt[2].top);
            this.gFl.setMoveBottom(this.gFt[2].bottom);
            this.gFl.setData(this.gFf.get(st(this.gFl.getDataIndex() + 2)));
        }
        this.gFA.setFloatValues(0.0f, this.mDistance);
        this.gFA.start();
    }

    private void bJm() {
        this.gFg.setMoveLeft(this.gFg.getViewLeft());
        this.gFg.setMoveTop(this.gFg.getViewTop());
        this.gFg.setMoveRight(this.gFg.getViewRight());
        this.gFg.setMoveBottom(this.gFg.getViewBottom());
        this.gFh.setMoveLeft(this.gFh.getViewLeft());
        this.gFh.setMoveTop(this.gFh.getViewTop());
        this.gFh.setMoveRight(this.gFh.getViewRight());
        this.gFh.setMoveBottom(this.gFh.getViewBottom());
        this.gFi.setMoveLeft(this.gFi.getViewLeft());
        this.gFi.setMoveTop(this.gFi.getViewTop());
        this.gFi.setMoveRight(this.gFi.getViewRight());
        this.gFi.setMoveBottom(this.gFi.getViewBottom());
        this.gFj.setMoveLeft(this.gFj.getViewLeft());
        this.gFj.setMoveTop(this.gFj.getViewTop());
        this.gFj.setMoveRight(this.gFj.getViewRight());
        this.gFj.setMoveBottom(this.gFj.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.gFg.onChangeSkinType();
            this.gFh.onChangeSkinType();
            this.gFi.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.gFB && this.mDistance == 0.0f) {
            if (this.gFz != null) {
                this.gFz.removeAllUpdateListeners();
                this.gFz.cancel();
            }
            if (this.gFA != null) {
                this.gFA.removeAllUpdateListeners();
                this.gFA.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.gFg != null) {
            this.gFg.setPageId(bdUniqueId);
        }
        if (this.gFh != null) {
            this.gFh.setPageId(bdUniqueId);
        }
        if (this.gFi != null) {
            this.gFi.setPageId(bdUniqueId);
        }
    }

    public void su(int i) {
        f fVar;
        an a2;
        if (this.gFf != null && i >= 0 && i < this.gFf.size() && (fVar = this.gFf.get(i)) != null && (a2 = com.baidu.tieba.s.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.s.c.cVo().a(this.mPageId, com.baidu.tieba.s.a.KC("" + fVar.testId), a2);
        }
    }
}
