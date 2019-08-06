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
    private int NZ;
    private float faA;
    private float faB;
    private float faC;
    private ValueAnimator faD;
    private float faE;
    private ValueAnimator faF;
    private boolean faG;
    private boolean faH;
    private int faI;
    private int faJ;
    private a faK;
    private boolean faL;
    private float faM;
    private int faN;
    private List<f> faj;
    private CellForumTestView fak;
    private CellForumTestView fal;
    private CellForumTestView fam;
    private CellForumTestView fan;
    private CellForumTestView fao;
    private CellForumTestView fap;
    private int faq;
    private int far;
    private int fas;
    private int fat;
    private int fau;
    private int fav;
    private int faw;
    private Rect[] fax;
    private float fay;
    private float faz;
    private int mHeight;
    private float mLastMotionX;
    private BdUniqueId mPageId;
    private int mSkinType;
    private VelocityTracker mVelocityTracker;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void dd(long j);
    }

    public ForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fax = new Rect[3];
        this.faG = false;
        this.faH = false;
        this.faL = false;
        this.faM = 0.0f;
        this.faN = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fax = new Rect[3];
        this.faG = false;
        this.faH = false;
        this.faL = false;
        this.faM = 0.0f;
        this.faN = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fax = new Rect[3];
        this.faG = false;
        this.faH = false;
        this.faL = false;
        this.faM = 0.0f;
        this.faN = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.fak = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.fal = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.fam = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.fan = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        dE(context);
        resetData();
        ViewConfiguration.get(context);
        this.NZ = ViewConfiguration.getMaximumFlingVelocity();
        this.fak.setForumTestDelClickListener(this);
        this.fal.setForumTestDelClickListener(this);
        this.fam.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void dE(Context context) {
        this.fau = l.g(context, R.dimen.tbds44);
        this.fav = l.g(context, R.dimen.tbds30);
        this.faw = l.g(context, R.dimen.tbds7);
        this.fat = l.g(context, R.dimen.tbds730);
        this.fas = this.fat - (this.fav * 2);
        this.mWidth = l.af(getContext());
        this.faq = (int) (this.mWidth * 0.89f);
        this.mHeight = this.fat + this.fau;
        this.far = ((this.mWidth - this.faq) - (this.faw * 2)) / 2;
        this.faA = this.fav / (this.faq + this.faw);
        this.faB = this.fat / this.faq;
        this.faC = this.faq / (this.faq + this.faw);
        this.fax[0] = new Rect(this.far - this.faq, this.fau + this.fav, this.far, this.fau + this.fav + this.fas);
        this.fax[1] = new Rect(this.far + this.faw, this.fau, this.far + this.faw + this.faq, this.fau + this.fat);
        this.fax[2] = new Rect(this.mWidth - this.far, this.fau + this.fav, (this.mWidth - this.far) + this.faq, this.fau + this.fav + this.fas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.faF = ValueAnimator.ofFloat(this.faq, 0.0f);
        this.faF.setDuration(500L);
        this.faF.setInterpolator(new DecelerateInterpolator());
        this.faF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.faI != 1) {
                    if (ForumTestView.this.faI == 2 || ForumTestView.this.faI == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.faA * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.faB;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.faE)) {
                            ForumTestView.this.fan.setAlpha(0.0f);
                            ForumTestView.this.fan.setVisibility(8);
                            ForumTestView.this.faE = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.fao);
                            ForumTestView.this.d(ForumTestView.this.fan);
                            ForumTestView.this.faj.remove(ForumTestView.this.fan.getData());
                            ForumTestView.this.js(true);
                            ForumTestView.this.faH = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.fao, floatValue, abs);
                            if ((ForumTestView.this.faq * 2) / 5 >= ForumTestView.this.fan.getViewRight() - ForumTestView.this.fan.getViewLeft()) {
                                ForumTestView.this.fan.setAlpha(0.0f);
                                ForumTestView.this.fan.setVisibility(8);
                            } else {
                                ForumTestView.this.fan.setViewLeft(ForumTestView.this.fan.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fan.setViewRight(ForumTestView.this.fan.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.fan.setViewTop(ForumTestView.this.fan.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.fan.setViewBottom(ForumTestView.this.fan.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.fan.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.faq * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.faA * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.faB;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.faE)) {
                        ForumTestView.this.fan.setAlpha(0.0f);
                        ForumTestView.this.fan.setVisibility(8);
                        ForumTestView.this.faE = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.fao);
                        ForumTestView.this.d(ForumTestView.this.fan);
                        ForumTestView.this.d(ForumTestView.this.fap);
                        ForumTestView.this.faj.remove(ForumTestView.this.fan.getData());
                        if (ForumTestView.this.fak.getIndex() == 0) {
                            if (ForumTestView.this.fak.getDataIndex() > ForumTestView.this.fap.getDataIndex()) {
                                ForumTestView.this.fak.setDataIndex(ForumTestView.this.fak.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fak);
                            }
                        } else if (ForumTestView.this.fal.getIndex() == 0) {
                            if (ForumTestView.this.fal.getDataIndex() > ForumTestView.this.fap.getDataIndex()) {
                                ForumTestView.this.fal.setDataIndex(ForumTestView.this.fal.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.fal);
                            }
                        } else if (ForumTestView.this.fam.getDataIndex() > ForumTestView.this.fap.getDataIndex()) {
                            ForumTestView.this.fam.setDataIndex(ForumTestView.this.fam.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fam);
                        }
                        if (ForumTestView.this.fao.getDataIndex() > ForumTestView.this.fap.getDataIndex()) {
                            ForumTestView.this.fao.setDataIndex(ForumTestView.this.fao.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.fao);
                        }
                        ForumTestView.this.fap.setDataIndex(ForumTestView.this.fap.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fap);
                        ForumTestView.this.js(true);
                        ForumTestView.this.faH = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.fao, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fap, floatValue2);
                        if ((ForumTestView.this.faq * 2) / 5 >= ForumTestView.this.fan.getViewRight() - ForumTestView.this.fan.getViewLeft()) {
                            ForumTestView.this.fan.setAlpha(0.0f);
                            ForumTestView.this.fan.setVisibility(8);
                        } else {
                            ForumTestView.this.fan.setViewLeft(ForumTestView.this.fan.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fan.setViewRight(ForumTestView.this.fan.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.fan.setViewTop(ForumTestView.this.fan.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.fan.setViewBottom(ForumTestView.this.fan.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.fan.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.faq * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.faB * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.faE / 2.0f)) {
                    ForumTestView.this.fan.setAlpha(0.0f);
                    ForumTestView.this.fan.setVisibility(8);
                    ForumTestView.this.faE = 0.0f;
                    ForumTestView.this.faj.remove(ForumTestView.this.fan.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.faK != null) {
                        ForumTestView.this.faK.dd(-1L);
                    }
                    ForumTestView.this.faH = false;
                } else {
                    ForumTestView.this.fan.setViewLeft(ForumTestView.this.fan.getMoveLeft() + floatValue3);
                    ForumTestView.this.fan.setViewRight(ForumTestView.this.fan.getMoveRight() - floatValue3);
                    ForumTestView.this.fan.setViewTop(ForumTestView.this.fan.getMoveTop() + f);
                    ForumTestView.this.fan.setViewBottom(ForumTestView.this.fan.getMoveBottom() - f);
                    ForumTestView.this.fan.setAlpha(1.0f - (floatValue3 / ForumTestView.this.faE));
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
            int af = l.af(getContext());
            if (af != this.faN) {
                this.faN = af;
                dE(getContext());
                d(this.fak);
                d(this.fal);
                d(this.fam);
                d(this.fan);
            }
            a(this.fak);
            a(this.fal);
            a(this.fam);
            a(this.fan);
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
            this.fak.layout((int) this.fak.getViewLeft(), (int) this.fak.getViewTop(), (int) this.fak.getViewRight(), (int) this.fak.getViewBottom());
            this.fal.layout((int) this.fal.getViewLeft(), (int) this.fal.getViewTop(), (int) this.fal.getViewRight(), (int) this.fal.getViewBottom());
            this.fam.layout((int) this.fam.getViewLeft(), (int) this.fam.getViewTop(), (int) this.fam.getViewRight(), (int) this.fam.getViewBottom());
            this.fan.layout((int) this.fan.getViewLeft(), (int) this.fan.getViewTop(), (int) this.fan.getViewRight(), (int) this.fan.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.faF == null || !this.faF.isRunning()) {
            if (this.faD == null || !this.faD.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.faD != null) {
                        this.faD.removeAllUpdateListeners();
                        this.faD.cancel();
                    }
                    this.faJ = motionEvent.getPointerId(0);
                    this.fay = x;
                    this.faz = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fay - x;
                    float f2 = this.faz - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.faG = true;
                        this.faE = f;
                    } else if (Math.abs(f2) > 30.0f && !this.faG) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.faA * f3;
                    if (this.faG) {
                        b(this.fak, f3, f4);
                        b(this.fal, f3, f4);
                        b(this.fam, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.NZ);
                    float xVelocity = velocityTracker.getXVelocity(this.faJ);
                    if (this.faG || this.faE != 0.0f) {
                        aE(xVelocity);
                    }
                    this.faG = false;
                    releaseVelocityTracker();
                }
                if (this.faG || this.faE != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.faj.size() > 2) {
                if (cellForumTestView.getViewRight() < this.fax[0].right - (this.faq / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.fax[0].right - (this.faq / 2))) + this.fax[2].left + (this.faq / 2) + this.faw);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.faq);
                    cellForumTestView.setViewTop(this.fax[2].top);
                    cellForumTestView.setViewBottom(this.fax[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.faj.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.fax[2].left + (this.faq / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.fax[2].left + (this.faq / 2))) + ((this.fax[0].right - (this.faq / 2)) - this.faw));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.faq);
                    cellForumTestView.setViewTop(this.fax[0].top);
                    cellForumTestView.setViewBottom(this.fax[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.faj.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.fax[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.fax[0].top) {
                    cellForumTestView.setViewTop(this.fax[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.fax[0].bottom) {
                    cellForumTestView.setViewBottom(this.fax[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.fax[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.fax[1].top) {
                    cellForumTestView.setViewTop(this.fax[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.fax[1].bottom) {
                    cellForumTestView.setViewBottom(this.fax[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.faK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if (this.faK != null) {
            int i = -1;
            if (this.fak.getIndex() == 1 && this.fak.getData() != null) {
                this.faK.dd(this.fak.getData().testId);
                i = this.fak.getDataIndex();
            } else if (this.fal.getIndex() == 1 && this.fal.getData() != null) {
                this.faK.dd(this.fal.getData().testId);
                i = this.fal.getDataIndex();
            } else if (this.fam.getIndex() == 1 && this.fam.getData() != null) {
                this.faK.dd(this.fam.getData().testId);
                i = this.fam.getDataIndex();
            } else {
                this.faK.dd(-1L);
            }
            if (z) {
                qI(i);
            }
        }
    }

    private void Ub() {
        this.faD = ValueAnimator.ofFloat(this.faq, 0.0f);
        this.faD.setDuration(200L);
        this.faD.setInterpolator(new DecelerateInterpolator());
        this.faD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.faE)) {
                    boolean z = Math.abs(ForumTestView.this.faE) >= ((float) ForumTestView.this.faq) * 0.2f;
                    if (ForumTestView.this.faL) {
                        if (ForumTestView.this.faE > 0.0f) {
                            ForumTestView.this.bgF();
                        } else {
                            ForumTestView.this.bgG();
                        }
                        ForumTestView.this.faL = false;
                    }
                    ForumTestView.this.faM = 0.0f;
                    ForumTestView.this.faE = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.fak);
                    ForumTestView.this.d(ForumTestView.this.fal);
                    ForumTestView.this.d(ForumTestView.this.fam);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.js(z);
                } else {
                    if (ForumTestView.this.faL) {
                        if (ForumTestView.this.faE > 0.0f) {
                            if (ForumTestView.this.qG(2) != null && ForumTestView.this.qG(2).getViewLeft() >= l.af(ForumTestView.this.getContext())) {
                                ForumTestView.this.bgF();
                                ForumTestView.this.faL = false;
                            }
                        } else if (ForumTestView.this.qG(0) != null && ForumTestView.this.qG(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bgG();
                            ForumTestView.this.faL = false;
                        }
                    }
                    float f = ForumTestView.this.faM - floatValue;
                    float f2 = ForumTestView.this.faA * f;
                    ForumTestView.this.b(ForumTestView.this.fak, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fal, f, f2);
                    ForumTestView.this.b(ForumTestView.this.fam, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.faM = floatValue;
            }
        });
    }

    private void aE(float f) {
        CellForumTestView qG;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.faL = false;
        this.faM = 0.0f;
        Ub();
        if (this.faj.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.fak.getVisibility() == 0) {
                cellForumTestView3 = this.fak;
            }
            if (this.fal.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.fal;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.fal;
            }
            if (this.fam.getVisibility() == 0) {
                cellForumTestView2 = this.fam;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.fax[0].left) || viewRight > ((float) this.fax[2].right)) && Math.abs(this.faE) >= this.faq * 0.2f) {
                this.faL = true;
            }
        } else if (this.faj.size() > 2 && Math.abs(this.faE) >= this.faq * 0.2f) {
            this.faL = true;
        }
        if (this.faL && (qG = qG(1)) != null) {
            if (this.faE >= this.faq) {
                this.faE -= this.faq;
                this.faL = false;
                bgG();
            } else if (this.faE > 0.0f && this.faE < this.faq) {
                this.faE = this.fax[0].right - qG.getViewRight();
            } else if (this.faE > (-this.faq)) {
                this.faE = this.fax[2].left - qG.getViewLeft();
            } else {
                bgF();
                this.faE += this.faq;
                this.faL = false;
            }
        }
        this.faD.setFloatValues(0.0f, this.faE);
        this.faD.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgF() {
        this.fak.setIndex(this.fak.getIndex() + 1);
        this.fal.setIndex(this.fal.getIndex() + 1);
        this.fam.setIndex(this.fam.getIndex() + 1);
        b(this.fak);
        b(this.fal);
        b(this.fam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgG() {
        this.fak.setIndex(this.fak.getIndex() - 1);
        this.fal.setIndex(this.fal.getIndex() - 1);
        this.fam.setIndex(this.fam.getIndex() - 1);
        b(this.fak);
        b(this.fal);
        b(this.fam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView qG(int i) {
        if (this.fak.getIndex() == i) {
            return this.fak;
        }
        if (this.fal.getIndex() == i) {
            return this.fal;
        }
        if (this.fam.getIndex() == i) {
            return this.fam;
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
            int size = this.faj.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int qH(int i) {
        int size = this.faj.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.fax[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.fax[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.fax[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.fax[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.aa(list) && !this.faG && this.faE == 0.0f) {
            this.faj = list;
            resetData();
            if (v.Z(list) > 2) {
                this.fak.setVisibility(0);
                this.fal.setVisibility(0);
                this.fam.setVisibility(0);
                this.fak.setData(list.get(0));
                this.fal.setData(list.get(1));
                this.fam.setData(list.get(2));
                this.fak.setDataIndex(0);
                this.fal.setDataIndex(1);
                this.fam.setDataIndex(2);
                i = 1;
            } else if (v.Z(list) == 2) {
                this.fak.setVisibility(8);
                this.fal.setVisibility(0);
                this.fam.setVisibility(0);
                this.fal.setDataIndex(1);
                this.fam.setDataIndex(0);
                this.fal.setData(list.get(1));
                this.fam.setData(list.get(0));
                i = 1;
            } else {
                this.fak.setVisibility(8);
                this.fal.setVisibility(0);
                this.fam.setVisibility(8);
                this.fal.setDataIndex(0);
                this.fal.setData(list.get(0));
                i = 0;
            }
            qI(i);
        }
    }

    private void resetData() {
        this.fak.setIndex(0);
        this.fal.setIndex(1);
        this.fam.setIndex(2);
        this.fan.setIndex(1);
        d(this.fak);
        d(this.fal);
        d(this.fam);
        d(this.fan);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void qF(int i) {
        CellForumTestView cellForumTestView;
        this.faH = true;
        this.fan.setVisibility(0);
        this.fan.setAlpha(1.0f);
        bgH();
        if (this.fak.getIndex() == i && this.fak.getVisibility() == 0) {
            cellForumTestView = this.fak;
        } else if (this.fal.getIndex() == i && this.fal.getVisibility() == 0) {
            cellForumTestView = this.fal;
        } else {
            cellForumTestView = this.fam;
        }
        this.fan.setData(cellForumTestView.getData());
        this.fan.setDataIndex(cellForumTestView.getDataIndex());
        this.fap = null;
        if (this.faj.size() == 1) {
            this.faI = 1;
            cellForumTestView.setVisibility(8);
            this.faE = (this.faq * 3) / 5;
        } else if (this.faj.size() == 2) {
            this.faI = 2;
            cellForumTestView.setVisibility(8);
            if (this.fak.getVisibility() == 0) {
                this.fao = this.fak;
            } else if (this.fal.getVisibility() == 0) {
                this.fao = this.fal;
            } else {
                this.fao = this.fam;
            }
            if (this.fao.getViewRight() < this.fax[1].left) {
                this.faE = this.faq + this.faw;
                this.fao.setIndex(this.fao.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.fao.getViewLeft() > this.fax[1].right) {
                this.faE = (-this.faq) - this.faw;
                this.fao.setIndex(this.fao.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.fao);
            b(cellForumTestView);
        } else if (this.faj.size() == 3) {
            this.faI = 3;
            cellForumTestView.setVisibility(8);
            if (this.fak.getIndex() == 2) {
                this.fao = this.fak;
            } else if (this.fal.getIndex() == 2) {
                this.fao = this.fal;
            } else {
                this.fao = this.fam;
            }
            this.faE = (-this.faq) - this.faw;
            this.fao.setIndex(this.fao.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.fao);
            b(cellForumTestView);
        } else {
            this.faI = 4;
            this.fap = cellForumTestView;
            if (this.fak.getIndex() == 2) {
                this.fao = this.fak;
            } else if (this.fal.getIndex() == 2) {
                this.fao = this.fal;
            } else {
                this.fao = this.fam;
            }
            this.faE = (-this.faq) - this.faw;
            this.fao.setIndex(this.fao.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.fao);
            b(cellForumTestView);
            this.fap.setViewLeft(this.fax[2].right + this.faw);
            this.fap.setViewRight(this.fax[2].right + this.faw + this.faq);
            this.fap.setViewTop(this.fax[2].top);
            this.fap.setViewBottom(this.fax[2].bottom);
            this.fap.setMoveLeft(this.fax[2].right + this.faw);
            this.fap.setMoveRight(this.fax[2].right + this.faw + this.faq);
            this.fap.setMoveTop(this.fax[2].top);
            this.fap.setMoveBottom(this.fax[2].bottom);
            this.fap.setData(this.faj.get(qH(this.fap.getDataIndex() + 2)));
        }
        this.faF.setFloatValues(0.0f, this.faE);
        this.faF.start();
    }

    private void bgH() {
        this.fak.setMoveLeft(this.fak.getViewLeft());
        this.fak.setMoveTop(this.fak.getViewTop());
        this.fak.setMoveRight(this.fak.getViewRight());
        this.fak.setMoveBottom(this.fak.getViewBottom());
        this.fal.setMoveLeft(this.fal.getViewLeft());
        this.fal.setMoveTop(this.fal.getViewTop());
        this.fal.setMoveRight(this.fal.getViewRight());
        this.fal.setMoveBottom(this.fal.getViewBottom());
        this.fam.setMoveLeft(this.fam.getViewLeft());
        this.fam.setMoveTop(this.fam.getViewTop());
        this.fam.setMoveRight(this.fam.getViewRight());
        this.fam.setMoveBottom(this.fam.getViewBottom());
        this.fan.setMoveLeft(this.fan.getViewLeft());
        this.fan.setMoveTop(this.fan.getViewTop());
        this.fan.setMoveRight(this.fan.getViewRight());
        this.fan.setMoveBottom(this.fan.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_c);
            this.fak.onChangeSkinType();
            this.fal.onChangeSkinType();
            this.fam.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.faG && this.faE == 0.0f) {
            if (this.faD != null) {
                this.faD.removeAllUpdateListeners();
                this.faD.cancel();
            }
            if (this.faF != null) {
                this.faF.removeAllUpdateListeners();
                this.faF.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.fak != null) {
            this.fak.setPageId(bdUniqueId);
        }
        if (this.fal != null) {
            this.fal.setPageId(bdUniqueId);
        }
        if (this.fam != null) {
            this.fam.setPageId(bdUniqueId);
        }
    }

    public void qI(int i) {
        f fVar;
        an a2;
        if (this.faj != null && i >= 0 && i < this.faj.size() && (fVar = this.faj.get(i)) != null && (a2 = com.baidu.tieba.q.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.q.c.coG().a(this.mPageId, "enterfourm_rec_" + fVar.testId, a2);
        }
    }
}
