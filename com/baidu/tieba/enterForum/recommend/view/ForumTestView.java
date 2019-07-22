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
    private List<f> eZV;
    private CellForumTestView eZW;
    private CellForumTestView eZX;
    private CellForumTestView eZY;
    private CellForumTestView eZZ;
    private CellForumTestView faa;
    private CellForumTestView fab;
    private int fac;
    private int fad;
    private int fae;
    private int faf;
    private int fag;
    private int fah;
    private int fai;
    private Rect[] faj;
    private float fak;
    private float fal;
    private float fam;
    private float fan;
    private float fao;
    private ValueAnimator fap;
    private float faq;
    private ValueAnimator far;
    private boolean fas;
    private boolean fat;
    private int fau;
    private int fav;
    private a faw;
    private boolean fax;
    private float fay;
    private int faz;
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
        this.faj = new Rect[3];
        this.fas = false;
        this.fat = false;
        this.fax = false;
        this.fay = 0.0f;
        this.faz = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.faj = new Rect[3];
        this.fas = false;
        this.fat = false;
        this.fax = false;
        this.fay = 0.0f;
        this.faz = 0;
        init(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.faj = new Rect[3];
        this.fas = false;
        this.fat = false;
        this.fax = false;
        this.fay = 0.0f;
        this.faz = 0;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.eZW = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.eZX = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.eZY = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.eZZ = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        dD(context);
        resetData();
        ViewConfiguration.get(context);
        this.NZ = ViewConfiguration.getMaximumFlingVelocity();
        this.eZW.setForumTestDelClickListener(this);
        this.eZX.setForumTestDelClickListener(this);
        this.eZY.setForumTestDelClickListener(this);
        onChangeSkinType();
    }

    private void dD(Context context) {
        this.fag = l.g(context, R.dimen.tbds44);
        this.fah = l.g(context, R.dimen.tbds30);
        this.fai = l.g(context, R.dimen.tbds7);
        this.faf = l.g(context, R.dimen.tbds730);
        this.fae = this.faf - (this.fah * 2);
        this.mWidth = l.af(getContext());
        this.fac = (int) (this.mWidth * 0.89f);
        this.mHeight = this.faf + this.fag;
        this.fad = ((this.mWidth - this.fac) - (this.fai * 2)) / 2;
        this.fam = this.fah / (this.fac + this.fai);
        this.fan = this.faf / this.fac;
        this.fao = this.fac / (this.fac + this.fai);
        this.faj[0] = new Rect(this.fad - this.fac, this.fag + this.fah, this.fad, this.fag + this.fah + this.fae);
        this.faj[1] = new Rect(this.fad + this.fai, this.fag, this.fad + this.fai + this.fac, this.fag + this.faf);
        this.faj[2] = new Rect(this.mWidth - this.fad, this.fag + this.fah, (this.mWidth - this.fad) + this.fac, this.fag + this.fah + this.fae);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.far = ValueAnimator.ofFloat(this.fac, 0.0f);
        this.far.setDuration(500L);
        this.far.setInterpolator(new DecelerateInterpolator());
        this.far.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (ForumTestView.this.fau != 1) {
                    if (ForumTestView.this.fau == 2 || ForumTestView.this.fau == 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(ForumTestView.this.fam * floatValue);
                        float abs2 = Math.abs(floatValue) * ForumTestView.this.fan;
                        if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.faq)) {
                            ForumTestView.this.eZZ.setAlpha(0.0f);
                            ForumTestView.this.eZZ.setVisibility(8);
                            ForumTestView.this.faq = 0.0f;
                            ForumTestView.this.d(ForumTestView.this.faa);
                            ForumTestView.this.d(ForumTestView.this.eZZ);
                            ForumTestView.this.eZV.remove(ForumTestView.this.eZZ.getData());
                            ForumTestView.this.js(true);
                            ForumTestView.this.fat = false;
                        } else {
                            ForumTestView.this.a(ForumTestView.this.faa, floatValue, abs);
                            if ((ForumTestView.this.fac * 2) / 5 >= ForumTestView.this.eZZ.getViewRight() - ForumTestView.this.eZZ.getViewLeft()) {
                                ForumTestView.this.eZZ.setAlpha(0.0f);
                                ForumTestView.this.eZZ.setVisibility(8);
                            } else {
                                ForumTestView.this.eZZ.setViewLeft(ForumTestView.this.eZZ.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eZZ.setViewRight(ForumTestView.this.eZZ.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                ForumTestView.this.eZZ.setViewTop(ForumTestView.this.eZZ.getMoveTop() + (abs2 / 2.0f));
                                ForumTestView.this.eZZ.setViewBottom(ForumTestView.this.eZZ.getMoveBottom() - (abs2 / 2.0f));
                                ForumTestView.this.eZZ.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.fac * 3) / 5)));
                            }
                        }
                        ForumTestView.this.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(ForumTestView.this.fam * floatValue2);
                    float abs4 = Math.abs(floatValue2) * ForumTestView.this.fan;
                    if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.faq)) {
                        ForumTestView.this.eZZ.setAlpha(0.0f);
                        ForumTestView.this.eZZ.setVisibility(8);
                        ForumTestView.this.faq = 0.0f;
                        ForumTestView.this.d(ForumTestView.this.faa);
                        ForumTestView.this.d(ForumTestView.this.eZZ);
                        ForumTestView.this.d(ForumTestView.this.fab);
                        ForumTestView.this.eZV.remove(ForumTestView.this.eZZ.getData());
                        if (ForumTestView.this.eZW.getIndex() == 0) {
                            if (ForumTestView.this.eZW.getDataIndex() > ForumTestView.this.fab.getDataIndex()) {
                                ForumTestView.this.eZW.setDataIndex(ForumTestView.this.eZW.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eZW);
                            }
                        } else if (ForumTestView.this.eZX.getIndex() == 0) {
                            if (ForumTestView.this.eZX.getDataIndex() > ForumTestView.this.fab.getDataIndex()) {
                                ForumTestView.this.eZX.setDataIndex(ForumTestView.this.eZX.getDataIndex() - 1);
                                ForumTestView.this.c(ForumTestView.this.eZX);
                            }
                        } else if (ForumTestView.this.eZY.getDataIndex() > ForumTestView.this.fab.getDataIndex()) {
                            ForumTestView.this.eZY.setDataIndex(ForumTestView.this.eZY.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.eZY);
                        }
                        if (ForumTestView.this.faa.getDataIndex() > ForumTestView.this.fab.getDataIndex()) {
                            ForumTestView.this.faa.setDataIndex(ForumTestView.this.faa.getDataIndex() - 1);
                            ForumTestView.this.c(ForumTestView.this.faa);
                        }
                        ForumTestView.this.fab.setDataIndex(ForumTestView.this.fab.getDataIndex() + 1);
                        ForumTestView.this.c(ForumTestView.this.fab);
                        ForumTestView.this.js(true);
                        ForumTestView.this.fat = false;
                    } else {
                        ForumTestView.this.a(ForumTestView.this.faa, floatValue2, abs3);
                        ForumTestView.this.a(ForumTestView.this.fab, floatValue2);
                        if ((ForumTestView.this.fac * 2) / 5 >= ForumTestView.this.eZZ.getViewRight() - ForumTestView.this.eZZ.getViewLeft()) {
                            ForumTestView.this.eZZ.setAlpha(0.0f);
                            ForumTestView.this.eZZ.setVisibility(8);
                        } else {
                            ForumTestView.this.eZZ.setViewLeft(ForumTestView.this.eZZ.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eZZ.setViewRight(ForumTestView.this.eZZ.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            ForumTestView.this.eZZ.setViewTop(ForumTestView.this.eZZ.getMoveTop() + (abs4 / 2.0f));
                            ForumTestView.this.eZZ.setViewBottom(ForumTestView.this.eZZ.getMoveBottom() - (abs4 / 2.0f));
                            ForumTestView.this.eZZ.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.fac * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f = ForumTestView.this.fan * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.faq / 2.0f)) {
                    ForumTestView.this.eZZ.setAlpha(0.0f);
                    ForumTestView.this.eZZ.setVisibility(8);
                    ForumTestView.this.faq = 0.0f;
                    ForumTestView.this.eZV.remove(ForumTestView.this.eZZ.getData());
                    ForumTestView.this.setVisibility(8);
                    if (ForumTestView.this.faw != null) {
                        ForumTestView.this.faw.dd(-1L);
                    }
                    ForumTestView.this.fat = false;
                } else {
                    ForumTestView.this.eZZ.setViewLeft(ForumTestView.this.eZZ.getMoveLeft() + floatValue3);
                    ForumTestView.this.eZZ.setViewRight(ForumTestView.this.eZZ.getMoveRight() - floatValue3);
                    ForumTestView.this.eZZ.setViewTop(ForumTestView.this.eZZ.getMoveTop() + f);
                    ForumTestView.this.eZZ.setViewBottom(ForumTestView.this.eZZ.getMoveBottom() - f);
                    ForumTestView.this.eZZ.setAlpha(1.0f - (floatValue3 / ForumTestView.this.faq));
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
            if (af != this.faz) {
                this.faz = af;
                dD(getContext());
                d(this.eZW);
                d(this.eZX);
                d(this.eZY);
                d(this.eZZ);
            }
            a(this.eZW);
            a(this.eZX);
            a(this.eZY);
            a(this.eZZ);
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
            this.eZW.layout((int) this.eZW.getViewLeft(), (int) this.eZW.getViewTop(), (int) this.eZW.getViewRight(), (int) this.eZW.getViewBottom());
            this.eZX.layout((int) this.eZX.getViewLeft(), (int) this.eZX.getViewTop(), (int) this.eZX.getViewRight(), (int) this.eZX.getViewBottom());
            this.eZY.layout((int) this.eZY.getViewLeft(), (int) this.eZY.getViewTop(), (int) this.eZY.getViewRight(), (int) this.eZY.getViewBottom());
            this.eZZ.layout((int) this.eZZ.getViewLeft(), (int) this.eZZ.getViewTop(), (int) this.eZZ.getViewRight(), (int) this.eZZ.getViewBottom());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.far == null || !this.far.isRunning()) {
            if (this.fap == null || !this.fap.isRunning()) {
                int action = motionEvent.getAction();
                acquireVelocityTracker(motionEvent);
                VelocityTracker velocityTracker = this.mVelocityTracker;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    if (this.fap != null) {
                        this.fap.removeAllUpdateListeners();
                        this.fap.cancel();
                    }
                    this.fav = motionEvent.getPointerId(0);
                    this.fak = x;
                    this.fal = y;
                    this.mLastMotionX = x;
                } else if (i == 2) {
                    float f = this.fak - x;
                    float f2 = this.fal - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.fas = true;
                        this.faq = f;
                    } else if (Math.abs(f2) > 30.0f && !this.fas) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.mLastMotionX - x;
                    float f4 = this.fam * f3;
                    if (this.fas) {
                        b(this.eZW, f3, f4);
                        b(this.eZX, f3, f4);
                        b(this.eZY, f3, f4);
                        requestLayout();
                    }
                    this.mLastMotionX = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.NZ);
                    float xVelocity = velocityTracker.getXVelocity(this.fav);
                    if (this.fas || this.faq != 0.0f) {
                        aE(xVelocity);
                    }
                    this.fas = false;
                    releaseVelocityTracker();
                }
                if (this.fas || this.faq != 0.0f || motionEvent.getPointerCount() >= 2) {
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
            if (this.eZV.size() > 2) {
                if (cellForumTestView.getViewRight() < this.faj[0].right - (this.fac / 2) && f > 0.0f) {
                    cellForumTestView.setViewLeft((cellForumTestView.getViewRight() - (this.faj[0].right - (this.fac / 2))) + this.faj[2].left + (this.fac / 2) + this.fai);
                    cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.fac);
                    cellForumTestView.setViewTop(this.faj[2].top);
                    cellForumTestView.setViewBottom(this.faj[2].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eZV.get(cellForumTestView.getDataIndex()));
                } else if (cellForumTestView.getViewLeft() > this.faj[2].left + (this.fac / 2) && f < 0.0f) {
                    cellForumTestView.setViewRight((cellForumTestView.getViewLeft() - (this.faj[2].left + (this.fac / 2))) + ((this.faj[0].right - (this.fac / 2)) - this.fai));
                    cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.fac);
                    cellForumTestView.setViewTop(this.faj[0].top);
                    cellForumTestView.setViewBottom(this.faj[0].bottom);
                    cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                    c(cellForumTestView);
                    cellForumTestView.setData(this.eZV.get(cellForumTestView.getDataIndex()));
                }
            }
            cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
            cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
            if (cellForumTestView.getViewLeft() <= this.faj[1].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
                if (cellForumTestView.getViewTop() > this.faj[0].top) {
                    cellForumTestView.setViewTop(this.faj[0].top);
                }
                if (cellForumTestView.getViewBottom() < this.faj[0].bottom) {
                    cellForumTestView.setViewBottom(this.faj[0].bottom);
                }
            } else if (cellForumTestView.getViewLeft() <= this.faj[2].left) {
                cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
                cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
                if (cellForumTestView.getViewTop() < this.faj[1].top) {
                    cellForumTestView.setViewTop(this.faj[1].top);
                }
                if (cellForumTestView.getViewBottom() > this.faj[1].bottom) {
                    cellForumTestView.setViewBottom(this.faj[1].bottom);
                }
            }
        }
    }

    public void setOnSecectedListener(a aVar) {
        this.faw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void js(boolean z) {
        if (this.faw != null) {
            int i = -1;
            if (this.eZW.getIndex() == 1 && this.eZW.getData() != null) {
                this.faw.dd(this.eZW.getData().testId);
                i = this.eZW.getDataIndex();
            } else if (this.eZX.getIndex() == 1 && this.eZX.getData() != null) {
                this.faw.dd(this.eZX.getData().testId);
                i = this.eZX.getDataIndex();
            } else if (this.eZY.getIndex() == 1 && this.eZY.getData() != null) {
                this.faw.dd(this.eZY.getData().testId);
                i = this.eZY.getDataIndex();
            } else {
                this.faw.dd(-1L);
            }
            if (z) {
                qG(i);
            }
        }
    }

    private void Ub() {
        this.fap = ValueAnimator.ofFloat(this.fac, 0.0f);
        this.fap.setDuration(200L);
        this.fap.setInterpolator(new DecelerateInterpolator());
        this.fap.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.enterForum.recommend.view.ForumTestView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.faq)) {
                    boolean z = Math.abs(ForumTestView.this.faq) >= ((float) ForumTestView.this.fac) * 0.2f;
                    if (ForumTestView.this.fax) {
                        if (ForumTestView.this.faq > 0.0f) {
                            ForumTestView.this.bgC();
                        } else {
                            ForumTestView.this.bgD();
                        }
                        ForumTestView.this.fax = false;
                    }
                    ForumTestView.this.fay = 0.0f;
                    ForumTestView.this.faq = 0.0f;
                    ForumTestView.this.d(ForumTestView.this.eZW);
                    ForumTestView.this.d(ForumTestView.this.eZX);
                    ForumTestView.this.d(ForumTestView.this.eZY);
                    ForumTestView.this.requestLayout();
                    ForumTestView.this.js(z);
                } else {
                    if (ForumTestView.this.fax) {
                        if (ForumTestView.this.faq > 0.0f) {
                            if (ForumTestView.this.qE(2) != null && ForumTestView.this.qE(2).getViewLeft() >= l.af(ForumTestView.this.getContext())) {
                                ForumTestView.this.bgC();
                                ForumTestView.this.fax = false;
                            }
                        } else if (ForumTestView.this.qE(0) != null && ForumTestView.this.qE(0).getViewRight() <= 0.0f) {
                            ForumTestView.this.bgD();
                            ForumTestView.this.fax = false;
                        }
                    }
                    float f = ForumTestView.this.fay - floatValue;
                    float f2 = ForumTestView.this.fam * f;
                    ForumTestView.this.b(ForumTestView.this.eZW, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eZX, f, f2);
                    ForumTestView.this.b(ForumTestView.this.eZY, f, f2);
                    ForumTestView.this.requestLayout();
                }
                ForumTestView.this.fay = floatValue;
            }
        });
    }

    private void aE(float f) {
        CellForumTestView qE;
        CellForumTestView cellForumTestView;
        CellForumTestView cellForumTestView2;
        float viewRight;
        float f2;
        this.fax = false;
        this.fay = 0.0f;
        Ub();
        if (this.eZV.size() == 2) {
            CellForumTestView cellForumTestView3 = null;
            if (this.eZW.getVisibility() == 0) {
                cellForumTestView3 = this.eZW;
            }
            if (this.eZX.getVisibility() != 0) {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = null;
            } else if (cellForumTestView3 == null) {
                cellForumTestView = this.eZX;
                cellForumTestView2 = null;
            } else {
                cellForumTestView = cellForumTestView3;
                cellForumTestView2 = this.eZX;
            }
            if (this.eZY.getVisibility() == 0) {
                cellForumTestView2 = this.eZY;
            }
            if (cellForumTestView.getIndex() < cellForumTestView2.getIndex()) {
                f2 = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
            } else {
                float viewLeft = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
                f2 = viewLeft;
            }
            if (!(f2 < ((float) this.faj[0].left) || viewRight > ((float) this.faj[2].right)) && Math.abs(this.faq) >= this.fac * 0.2f) {
                this.fax = true;
            }
        } else if (this.eZV.size() > 2 && Math.abs(this.faq) >= this.fac * 0.2f) {
            this.fax = true;
        }
        if (this.fax && (qE = qE(1)) != null) {
            if (this.faq >= this.fac) {
                this.faq -= this.fac;
                this.fax = false;
                bgD();
            } else if (this.faq > 0.0f && this.faq < this.fac) {
                this.faq = this.faj[0].right - qE.getViewRight();
            } else if (this.faq > (-this.fac)) {
                this.faq = this.faj[2].left - qE.getViewLeft();
            } else {
                bgC();
                this.faq += this.fac;
                this.fax = false;
            }
        }
        this.fap.setFloatValues(0.0f, this.faq);
        this.fap.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgC() {
        this.eZW.setIndex(this.eZW.getIndex() + 1);
        this.eZX.setIndex(this.eZX.getIndex() + 1);
        this.eZY.setIndex(this.eZY.getIndex() + 1);
        b(this.eZW);
        b(this.eZX);
        b(this.eZY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgD() {
        this.eZW.setIndex(this.eZW.getIndex() - 1);
        this.eZX.setIndex(this.eZX.getIndex() - 1);
        this.eZY.setIndex(this.eZY.getIndex() - 1);
        b(this.eZW);
        b(this.eZX);
        b(this.eZY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CellForumTestView qE(int i) {
        if (this.eZW.getIndex() == i) {
            return this.eZW;
        }
        if (this.eZX.getIndex() == i) {
            return this.eZX;
        }
        if (this.eZY.getIndex() == i) {
            return this.eZY;
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
            int size = this.eZV.size();
            int dataIndex = cellForumTestView.getDataIndex() % size;
            if (dataIndex < 0) {
                dataIndex = size - Math.abs(dataIndex);
            }
            cellForumTestView.setDataIndex(dataIndex);
        }
    }

    private int qF(int i) {
        int size = this.eZV.size();
        int i2 = i % size;
        if (i2 < 0) {
            return size - Math.abs(i2);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CellForumTestView cellForumTestView) {
        if (cellForumTestView != null) {
            cellForumTestView.setViewLeft(this.faj[cellForumTestView.getIndex()].left);
            cellForumTestView.setViewTop(this.faj[cellForumTestView.getIndex()].top);
            cellForumTestView.setViewRight(this.faj[cellForumTestView.getIndex()].right);
            cellForumTestView.setViewBottom(this.faj[cellForumTestView.getIndex()].bottom);
        }
    }

    public void setData(List<f> list) {
        int i;
        if (!v.aa(list) && !this.fas && this.faq == 0.0f) {
            this.eZV = list;
            resetData();
            if (v.Z(list) > 2) {
                this.eZW.setVisibility(0);
                this.eZX.setVisibility(0);
                this.eZY.setVisibility(0);
                this.eZW.setData(list.get(0));
                this.eZX.setData(list.get(1));
                this.eZY.setData(list.get(2));
                this.eZW.setDataIndex(0);
                this.eZX.setDataIndex(1);
                this.eZY.setDataIndex(2);
                i = 1;
            } else if (v.Z(list) == 2) {
                this.eZW.setVisibility(8);
                this.eZX.setVisibility(0);
                this.eZY.setVisibility(0);
                this.eZX.setDataIndex(1);
                this.eZY.setDataIndex(0);
                this.eZX.setData(list.get(1));
                this.eZY.setData(list.get(0));
                i = 1;
            } else {
                this.eZW.setVisibility(8);
                this.eZX.setVisibility(0);
                this.eZY.setVisibility(8);
                this.eZX.setDataIndex(0);
                this.eZX.setData(list.get(0));
                i = 0;
            }
            qG(i);
        }
    }

    private void resetData() {
        this.eZW.setIndex(0);
        this.eZX.setIndex(1);
        this.eZY.setIndex(2);
        this.eZZ.setIndex(1);
        d(this.eZW);
        d(this.eZX);
        d(this.eZY);
        d(this.eZZ);
    }

    @Override // com.baidu.tieba.enterForum.recommend.view.a
    public void qD(int i) {
        CellForumTestView cellForumTestView;
        this.fat = true;
        this.eZZ.setVisibility(0);
        this.eZZ.setAlpha(1.0f);
        bgE();
        if (this.eZW.getIndex() == i && this.eZW.getVisibility() == 0) {
            cellForumTestView = this.eZW;
        } else if (this.eZX.getIndex() == i && this.eZX.getVisibility() == 0) {
            cellForumTestView = this.eZX;
        } else {
            cellForumTestView = this.eZY;
        }
        this.eZZ.setData(cellForumTestView.getData());
        this.eZZ.setDataIndex(cellForumTestView.getDataIndex());
        this.fab = null;
        if (this.eZV.size() == 1) {
            this.fau = 1;
            cellForumTestView.setVisibility(8);
            this.faq = (this.fac * 3) / 5;
        } else if (this.eZV.size() == 2) {
            this.fau = 2;
            cellForumTestView.setVisibility(8);
            if (this.eZW.getVisibility() == 0) {
                this.faa = this.eZW;
            } else if (this.eZX.getVisibility() == 0) {
                this.faa = this.eZX;
            } else {
                this.faa = this.eZY;
            }
            if (this.faa.getViewRight() < this.faj[1].left) {
                this.faq = this.fac + this.fai;
                this.faa.setIndex(this.faa.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.faa.getViewLeft() > this.faj[1].right) {
                this.faq = (-this.fac) - this.fai;
                this.faa.setIndex(this.faa.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            b(this.faa);
            b(cellForumTestView);
        } else if (this.eZV.size() == 3) {
            this.fau = 3;
            cellForumTestView.setVisibility(8);
            if (this.eZW.getIndex() == 2) {
                this.faa = this.eZW;
            } else if (this.eZX.getIndex() == 2) {
                this.faa = this.eZX;
            } else {
                this.faa = this.eZY;
            }
            this.faq = (-this.fac) - this.fai;
            this.faa.setIndex(this.faa.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            b(this.faa);
            b(cellForumTestView);
        } else {
            this.fau = 4;
            this.fab = cellForumTestView;
            if (this.eZW.getIndex() == 2) {
                this.faa = this.eZW;
            } else if (this.eZX.getIndex() == 2) {
                this.faa = this.eZX;
            } else {
                this.faa = this.eZY;
            }
            this.faq = (-this.fac) - this.fai;
            this.faa.setIndex(this.faa.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            b(this.faa);
            b(cellForumTestView);
            this.fab.setViewLeft(this.faj[2].right + this.fai);
            this.fab.setViewRight(this.faj[2].right + this.fai + this.fac);
            this.fab.setViewTop(this.faj[2].top);
            this.fab.setViewBottom(this.faj[2].bottom);
            this.fab.setMoveLeft(this.faj[2].right + this.fai);
            this.fab.setMoveRight(this.faj[2].right + this.fai + this.fac);
            this.fab.setMoveTop(this.faj[2].top);
            this.fab.setMoveBottom(this.faj[2].bottom);
            this.fab.setData(this.eZV.get(qF(this.fab.getDataIndex() + 2)));
        }
        this.far.setFloatValues(0.0f, this.faq);
        this.far.start();
    }

    private void bgE() {
        this.eZW.setMoveLeft(this.eZW.getViewLeft());
        this.eZW.setMoveTop(this.eZW.getViewTop());
        this.eZW.setMoveRight(this.eZW.getViewRight());
        this.eZW.setMoveBottom(this.eZW.getViewBottom());
        this.eZX.setMoveLeft(this.eZX.getViewLeft());
        this.eZX.setMoveTop(this.eZX.getViewTop());
        this.eZX.setMoveRight(this.eZX.getViewRight());
        this.eZX.setMoveBottom(this.eZX.getViewBottom());
        this.eZY.setMoveLeft(this.eZY.getViewLeft());
        this.eZY.setMoveTop(this.eZY.getViewTop());
        this.eZY.setMoveRight(this.eZY.getViewRight());
        this.eZY.setMoveBottom(this.eZY.getViewBottom());
        this.eZZ.setMoveLeft(this.eZZ.getViewLeft());
        this.eZZ.setMoveTop(this.eZZ.getViewTop());
        this.eZZ.setMoveRight(this.eZZ.getViewRight());
        this.eZZ.setMoveBottom(this.eZZ.getViewBottom());
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.l(this, R.color.cp_bg_line_c);
            this.eZW.onChangeSkinType();
            this.eZX.onChangeSkinType();
            this.eZY.onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.fas && this.faq == 0.0f) {
            if (this.fap != null) {
                this.fap.removeAllUpdateListeners();
                this.fap.cancel();
            }
            if (this.far != null) {
                this.far.removeAllUpdateListeners();
                this.far.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        if (this.eZW != null) {
            this.eZW.setPageId(bdUniqueId);
        }
        if (this.eZX != null) {
            this.eZX.setPageId(bdUniqueId);
        }
        if (this.eZY != null) {
            this.eZY.setPageId(bdUniqueId);
        }
    }

    public void qG(int i) {
        f fVar;
        an a2;
        if (this.eZV != null && i >= 0 && i < this.eZV.size() && (fVar = this.eZV.get(i)) != null && (a2 = com.baidu.tieba.q.a.a(false, "a065", "common_exp", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
            com.baidu.tieba.q.c.coo().a(this.mPageId, "enterfourm_rec_" + fVar.testId, a2);
        }
    }
}
