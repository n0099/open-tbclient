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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import d.b.i0.i0.k.c.f;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumTestView extends FrameLayout implements d.b.i0.i0.k.d.a {
    public float A;
    public float B;
    public ValueAnimator C;
    public float D;
    public ValueAnimator E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public int J;
    public VelocityTracker K;
    public c L;
    public boolean M;
    public float N;
    public int O;

    /* renamed from: e  reason: collision with root package name */
    public int f15162e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f15163f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f15164g;

    /* renamed from: h  reason: collision with root package name */
    public CellForumTestView f15165h;
    public CellForumTestView i;
    public CellForumTestView j;
    public CellForumTestView k;
    public CellForumTestView l;
    public CellForumTestView m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public Rect[] w;
    public float x;
    public float y;
    public float z;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (ForumTestView.this.H != 1) {
                if (ForumTestView.this.H != 2 && ForumTestView.this.H != 3) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs = Math.abs(ForumTestView.this.A * floatValue);
                    float abs2 = Math.abs(floatValue) * ForumTestView.this.B;
                    if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.D)) {
                        ForumTestView.this.k.setAlpha(0.0f);
                        ForumTestView.this.k.setVisibility(8);
                        ForumTestView.this.D = 0.0f;
                        ForumTestView forumTestView = ForumTestView.this;
                        forumTestView.T(forumTestView.l);
                        ForumTestView forumTestView2 = ForumTestView.this;
                        forumTestView2.T(forumTestView2.k);
                        ForumTestView forumTestView3 = ForumTestView.this;
                        forumTestView3.T(forumTestView3.m);
                        ForumTestView.this.f15163f.remove(ForumTestView.this.k.getData());
                        if (ForumTestView.this.f15165h.getIndex() == 0) {
                            if (ForumTestView.this.f15165h.getDataIndex() > ForumTestView.this.m.getDataIndex()) {
                                ForumTestView.this.f15165h.setDataIndex(ForumTestView.this.f15165h.getDataIndex() - 1);
                                ForumTestView forumTestView4 = ForumTestView.this;
                                forumTestView4.R(forumTestView4.f15165h);
                            }
                        } else if (ForumTestView.this.i.getIndex() == 0) {
                            if (ForumTestView.this.i.getDataIndex() > ForumTestView.this.m.getDataIndex()) {
                                ForumTestView.this.i.setDataIndex(ForumTestView.this.i.getDataIndex() - 1);
                                ForumTestView forumTestView5 = ForumTestView.this;
                                forumTestView5.R(forumTestView5.i);
                            }
                        } else if (ForumTestView.this.j.getDataIndex() > ForumTestView.this.m.getDataIndex()) {
                            ForumTestView.this.j.setDataIndex(ForumTestView.this.j.getDataIndex() - 1);
                            ForumTestView forumTestView6 = ForumTestView.this;
                            forumTestView6.R(forumTestView6.j);
                        }
                        if (ForumTestView.this.l.getDataIndex() > ForumTestView.this.m.getDataIndex()) {
                            ForumTestView.this.l.setDataIndex(ForumTestView.this.l.getDataIndex() - 1);
                            ForumTestView forumTestView7 = ForumTestView.this;
                            forumTestView7.R(forumTestView7.l);
                        }
                        ForumTestView.this.m.setDataIndex(ForumTestView.this.m.getDataIndex() + 1);
                        ForumTestView forumTestView8 = ForumTestView.this;
                        forumTestView8.R(forumTestView8.m);
                        ForumTestView.this.O(true);
                        ForumTestView.this.G = false;
                    } else {
                        ForumTestView forumTestView9 = ForumTestView.this;
                        forumTestView9.M(forumTestView9.l, floatValue, abs);
                        ForumTestView forumTestView10 = ForumTestView.this;
                        forumTestView10.G(forumTestView10.m, floatValue);
                        if ((ForumTestView.this.p * 2) / 5 >= ForumTestView.this.k.getViewRight() - ForumTestView.this.k.getViewLeft()) {
                            ForumTestView.this.k.setAlpha(0.0f);
                            ForumTestView.this.k.setVisibility(8);
                        } else {
                            ForumTestView.this.k.setViewLeft(ForumTestView.this.k.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                            ForumTestView.this.k.setViewRight(ForumTestView.this.k.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                            float f2 = abs2 / 2.0f;
                            ForumTestView.this.k.setViewTop(ForumTestView.this.k.getMoveTop() + f2);
                            ForumTestView.this.k.setViewBottom(ForumTestView.this.k.getMoveBottom() - f2);
                            ForumTestView.this.k.setAlpha(1.0f - (Math.abs(floatValue) / ((ForumTestView.this.p * 3) / 5)));
                        }
                    }
                    ForumTestView.this.requestLayout();
                    return;
                }
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float abs3 = Math.abs(ForumTestView.this.A * floatValue2);
                float abs4 = Math.abs(floatValue2) * ForumTestView.this.B;
                if (Math.abs(floatValue2) >= Math.abs(ForumTestView.this.D)) {
                    ForumTestView.this.k.setAlpha(0.0f);
                    ForumTestView.this.k.setVisibility(8);
                    ForumTestView.this.D = 0.0f;
                    ForumTestView forumTestView11 = ForumTestView.this;
                    forumTestView11.T(forumTestView11.l);
                    ForumTestView forumTestView12 = ForumTestView.this;
                    forumTestView12.T(forumTestView12.k);
                    ForumTestView.this.f15163f.remove(ForumTestView.this.k.getData());
                    ForumTestView.this.O(true);
                    ForumTestView.this.G = false;
                } else {
                    ForumTestView forumTestView13 = ForumTestView.this;
                    forumTestView13.M(forumTestView13.l, floatValue2, abs3);
                    if ((ForumTestView.this.p * 2) / 5 >= ForumTestView.this.k.getViewRight() - ForumTestView.this.k.getViewLeft()) {
                        ForumTestView.this.k.setAlpha(0.0f);
                        ForumTestView.this.k.setVisibility(8);
                    } else {
                        ForumTestView.this.k.setViewLeft(ForumTestView.this.k.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                        ForumTestView.this.k.setViewRight(ForumTestView.this.k.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                        float f3 = abs4 / 2.0f;
                        ForumTestView.this.k.setViewTop(ForumTestView.this.k.getMoveTop() + f3);
                        ForumTestView.this.k.setViewBottom(ForumTestView.this.k.getMoveBottom() - f3);
                        ForumTestView.this.k.setAlpha(1.0f - (Math.abs(floatValue2) / ((ForumTestView.this.p * 3) / 5)));
                    }
                }
                ForumTestView.this.requestLayout();
                return;
            }
            float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
            float f4 = ForumTestView.this.B * floatValue3;
            if (Math.abs(floatValue3) >= Math.abs(ForumTestView.this.D / 2.0f)) {
                ForumTestView.this.k.setAlpha(0.0f);
                ForumTestView.this.k.setVisibility(8);
                ForumTestView.this.D = 0.0f;
                ForumTestView.this.f15163f.remove(ForumTestView.this.k.getData());
                ForumTestView.this.setVisibility(8);
                if (ForumTestView.this.L != null) {
                    ForumTestView.this.L.a(-1L);
                }
                ForumTestView.this.G = false;
                if (ForumTestView.this.L != null && ListUtils.isEmpty(ForumTestView.this.f15163f)) {
                    ForumTestView.this.L.b();
                }
            } else {
                ForumTestView.this.k.setViewLeft(ForumTestView.this.k.getMoveLeft() + floatValue3);
                ForumTestView.this.k.setViewRight(ForumTestView.this.k.getMoveRight() - floatValue3);
                ForumTestView.this.k.setViewTop(ForumTestView.this.k.getMoveTop() + f4);
                ForumTestView.this.k.setViewBottom(ForumTestView.this.k.getMoveBottom() - f4);
                ForumTestView.this.k.setAlpha(1.0f - (floatValue3 / ForumTestView.this.D));
            }
            ForumTestView.this.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (Math.abs(floatValue) >= Math.abs(ForumTestView.this.D)) {
                boolean z = Math.abs(ForumTestView.this.D) >= ((float) ForumTestView.this.p) * 0.2f;
                if (ForumTestView.this.M) {
                    if (ForumTestView.this.D > 0.0f) {
                        ForumTestView.this.W();
                    } else {
                        ForumTestView.this.X();
                    }
                    ForumTestView.this.M = false;
                }
                ForumTestView.this.N = 0.0f;
                ForumTestView.this.D = 0.0f;
                ForumTestView forumTestView = ForumTestView.this;
                forumTestView.T(forumTestView.f15165h);
                ForumTestView forumTestView2 = ForumTestView.this;
                forumTestView2.T(forumTestView2.i);
                ForumTestView forumTestView3 = ForumTestView.this;
                forumTestView3.T(forumTestView3.j);
                ForumTestView.this.requestLayout();
                ForumTestView.this.O(z);
            } else {
                if (ForumTestView.this.M) {
                    if (ForumTestView.this.D > 0.0f) {
                        if (ForumTestView.this.I(2) != null && ForumTestView.this.I(2).getViewLeft() >= l.k(ForumTestView.this.getContext())) {
                            ForumTestView.this.W();
                            ForumTestView.this.M = false;
                        }
                    } else if (ForumTestView.this.I(0) != null && ForumTestView.this.I(0).getViewRight() <= 0.0f) {
                        ForumTestView.this.X();
                        ForumTestView.this.M = false;
                    }
                }
                float f2 = ForumTestView.this.N - floatValue;
                float f3 = ForumTestView.this.A * f2;
                ForumTestView forumTestView4 = ForumTestView.this;
                forumTestView4.V(forumTestView4.f15165h, f2, f3);
                ForumTestView forumTestView5 = ForumTestView.this;
                forumTestView5.V(forumTestView5.i, f2, f3);
                ForumTestView forumTestView6 = ForumTestView.this;
                forumTestView6.V(forumTestView6.j, f2, f3);
                ForumTestView.this.requestLayout();
            }
            ForumTestView.this.N = floatValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(long j);

        void b();
    }

    public ForumTestView(Context context) {
        super(context);
        this.f15162e = 3;
        this.w = new Rect[3];
        this.F = false;
        this.M = false;
        this.N = 0.0f;
        this.O = 0;
        J(context);
    }

    public final void D(MotionEvent motionEvent) {
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
    }

    public void E(int i) {
        f fVar;
        int i2;
        StatisticItem l;
        List<f> list = this.f15163f;
        if (list == null || i < 0 || i >= list.size() || (fVar = this.f15163f.get(i)) == null || (l = d.b.i0.c3.a.l(false, "a065", "common_exp", i2, (i2 = i + 1), false, null, String.valueOf(fVar.f56778a), 0)) == null) {
            return;
        }
        d.b.i0.c3.c g2 = d.b.i0.c3.c.g();
        BdUniqueId bdUniqueId = this.f15164g;
        g2.d(bdUniqueId, d.b.i0.c3.a.b("" + fVar.f56778a), l);
    }

    public final void F(Context context) {
        this.t = l.g(context, R.dimen.tbds44);
        this.u = l.g(context, R.dimen.tbds30);
        this.v = l.g(context, R.dimen.tbds7);
        int g2 = l.g(context, R.dimen.tbds730);
        this.s = g2;
        this.r = g2 - (this.u * 2);
        int k = l.k(getContext());
        this.n = k;
        int i = (int) (k * 0.89f);
        this.p = i;
        int i2 = this.s;
        this.o = this.t + i2;
        int i3 = this.v;
        this.q = ((k - i) - (i3 * 2)) / 2;
        this.A = this.u / (i3 + i);
        this.B = i2 / i;
        Rect[] rectArr = this.w;
        int i4 = this.q;
        int i5 = this.t;
        int i6 = this.u;
        rectArr[0] = new Rect(i4 - this.p, i5 + i6, i4, i5 + i6 + this.r);
        Rect[] rectArr2 = this.w;
        int i7 = this.q;
        int i8 = this.v;
        int i9 = this.t;
        rectArr2[1] = new Rect(i7 + i8, i9, i7 + i8 + this.p, this.s + i9);
        Rect[] rectArr3 = this.w;
        int i10 = this.n;
        int i11 = this.q;
        int i12 = this.t;
        int i13 = this.u;
        rectArr3[2] = new Rect(i10 - i11, i12 + i13, (i10 - i11) + this.p, i12 + i13 + this.r);
    }

    public final void G(CellForumTestView cellForumTestView, float f2) {
        if (cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(cellForumTestView.getMoveLeft() + f2);
        cellForumTestView.setViewRight(cellForumTestView.getMoveRight() + f2);
    }

    public final int H(int i) {
        int size = this.f15163f.size();
        int i2 = i % size;
        return i2 < 0 ? size - Math.abs(i2) : i2;
    }

    public final CellForumTestView I(int i) {
        if (this.f15165h.getIndex() == i) {
            return this.f15165h;
        }
        if (this.i.getIndex() == i) {
            return this.i;
        }
        if (this.j.getIndex() == i) {
            return this.j;
        }
        return null;
    }

    public final void J(Context context) {
        LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
        this.f15165h = (CellForumTestView) findViewById(R.id.forum_test_view_one);
        this.i = (CellForumTestView) findViewById(R.id.forum_test_view_two);
        this.j = (CellForumTestView) findViewById(R.id.forum_test_view_three);
        this.k = (CellForumTestView) findViewById(R.id.forum_test_view_del);
        F(context);
        Q();
        ViewConfiguration.get(context);
        this.J = ViewConfiguration.getMaximumFlingVelocity();
        this.f15165h.setForumTestDelClickListener(this);
        this.i.setForumTestDelClickListener(this);
        this.j.setForumTestDelClickListener(this);
        N();
    }

    public final void K() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.p, 0.0f);
        this.C = ofFloat;
        ofFloat.setDuration(200L);
        this.C.setInterpolator(new DecelerateInterpolator());
        this.C.addUpdateListener(new b());
    }

    public final void L(CellForumTestView cellForumTestView) {
        if (cellForumTestView == null) {
            return;
        }
        cellForumTestView.getLayoutParams().width = (int) (cellForumTestView.getViewRight() - cellForumTestView.getViewLeft());
        cellForumTestView.getLayoutParams().height = (int) (cellForumTestView.getViewBottom() - cellForumTestView.getViewTop());
    }

    public final void M(CellForumTestView cellForumTestView, float f2, float f3) {
        if (cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(cellForumTestView.getMoveLeft() + f2);
        cellForumTestView.setViewRight(cellForumTestView.getMoveRight() + f2);
        cellForumTestView.setViewTop(cellForumTestView.getMoveTop() - f3);
        cellForumTestView.setViewBottom(cellForumTestView.getMoveBottom() + f3);
    }

    public void N() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == this.f15162e) {
            return;
        }
        this.f15162e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        this.f15165h.b();
        this.i.b();
        this.j.b();
    }

    public final void O(boolean z) {
        if (this.L != null) {
            int i = -1;
            if (this.f15165h.getIndex() == 1 && this.f15165h.getData() != null) {
                this.L.a(this.f15165h.getData().f56778a);
                i = this.f15165h.getDataIndex();
            } else if (this.i.getIndex() == 1 && this.i.getData() != null) {
                this.L.a(this.i.getData().f56778a);
                i = this.i.getDataIndex();
            } else if (this.j.getIndex() == 1 && this.j.getData() != null) {
                this.L.a(this.j.getData().f56778a);
                i = this.j.getDataIndex();
            } else {
                this.L.a(-1L);
            }
            if (z) {
                E(i);
            }
        }
    }

    public final void P() {
        VelocityTracker velocityTracker = this.K;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.K.recycle();
            this.K = null;
        }
    }

    public final void Q() {
        this.f15165h.setIndex(0);
        this.i.setIndex(1);
        this.j.setIndex(2);
        this.k.setIndex(1);
        T(this.f15165h);
        T(this.i);
        T(this.j);
        T(this.k);
    }

    public final void R(CellForumTestView cellForumTestView) {
        if (cellForumTestView == null) {
            return;
        }
        int size = this.f15163f.size();
        int dataIndex = cellForumTestView.getDataIndex() % size;
        if (dataIndex < 0) {
            dataIndex = size - Math.abs(dataIndex);
        }
        cellForumTestView.setDataIndex(dataIndex);
    }

    public final void S(CellForumTestView cellForumTestView) {
        if (cellForumTestView == null) {
            return;
        }
        int index = cellForumTestView.getIndex() % 3;
        if (index == -2) {
            index = 1;
        }
        if (index == -1) {
            index = 2;
        }
        cellForumTestView.setIndex(index);
    }

    public final void T(CellForumTestView cellForumTestView) {
        if (cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(this.w[cellForumTestView.getIndex()].left);
        cellForumTestView.setViewTop(this.w[cellForumTestView.getIndex()].top);
        cellForumTestView.setViewRight(this.w[cellForumTestView.getIndex()].right);
        cellForumTestView.setViewBottom(this.w[cellForumTestView.getIndex()].bottom);
    }

    public final void U() {
        CellForumTestView cellForumTestView = this.f15165h;
        cellForumTestView.setMoveLeft(cellForumTestView.getViewLeft());
        CellForumTestView cellForumTestView2 = this.f15165h;
        cellForumTestView2.setMoveTop(cellForumTestView2.getViewTop());
        CellForumTestView cellForumTestView3 = this.f15165h;
        cellForumTestView3.setMoveRight(cellForumTestView3.getViewRight());
        CellForumTestView cellForumTestView4 = this.f15165h;
        cellForumTestView4.setMoveBottom(cellForumTestView4.getViewBottom());
        CellForumTestView cellForumTestView5 = this.i;
        cellForumTestView5.setMoveLeft(cellForumTestView5.getViewLeft());
        CellForumTestView cellForumTestView6 = this.i;
        cellForumTestView6.setMoveTop(cellForumTestView6.getViewTop());
        CellForumTestView cellForumTestView7 = this.i;
        cellForumTestView7.setMoveRight(cellForumTestView7.getViewRight());
        CellForumTestView cellForumTestView8 = this.i;
        cellForumTestView8.setMoveBottom(cellForumTestView8.getViewBottom());
        CellForumTestView cellForumTestView9 = this.j;
        cellForumTestView9.setMoveLeft(cellForumTestView9.getViewLeft());
        CellForumTestView cellForumTestView10 = this.j;
        cellForumTestView10.setMoveTop(cellForumTestView10.getViewTop());
        CellForumTestView cellForumTestView11 = this.j;
        cellForumTestView11.setMoveRight(cellForumTestView11.getViewRight());
        CellForumTestView cellForumTestView12 = this.j;
        cellForumTestView12.setMoveBottom(cellForumTestView12.getViewBottom());
        CellForumTestView cellForumTestView13 = this.k;
        cellForumTestView13.setMoveLeft(cellForumTestView13.getViewLeft());
        CellForumTestView cellForumTestView14 = this.k;
        cellForumTestView14.setMoveTop(cellForumTestView14.getViewTop());
        CellForumTestView cellForumTestView15 = this.k;
        cellForumTestView15.setMoveRight(cellForumTestView15.getViewRight());
        CellForumTestView cellForumTestView16 = this.k;
        cellForumTestView16.setMoveBottom(cellForumTestView16.getViewBottom());
    }

    public final void V(CellForumTestView cellForumTestView, float f2, float f3) {
        if (cellForumTestView == null || cellForumTestView.getVisibility() == 8) {
            return;
        }
        if (this.f15163f.size() > 2) {
            if (cellForumTestView.getViewRight() < this.w[0].right - (this.p / 2) && f2 > 0.0f) {
                float viewRight = cellForumTestView.getViewRight();
                Rect[] rectArr = this.w;
                int i = rectArr[0].right;
                int i2 = this.p;
                cellForumTestView.setViewLeft(rectArr[2].left + (i2 / 2) + this.v + (viewRight - (i - (i2 / 2))));
                cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.p);
                cellForumTestView.setViewTop(this.w[2].top);
                cellForumTestView.setViewBottom(this.w[2].bottom);
                cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                R(cellForumTestView);
                cellForumTestView.setData(this.f15163f.get(cellForumTestView.getDataIndex()));
            } else if (cellForumTestView.getViewLeft() > this.w[2].left + (this.p / 2) && f2 < 0.0f) {
                float viewLeft = cellForumTestView.getViewLeft();
                Rect[] rectArr2 = this.w;
                int i3 = rectArr2[2].left;
                int i4 = this.p;
                cellForumTestView.setViewRight(((rectArr2[0].right - (i4 / 2)) - this.v) + (viewLeft - (i3 + (i4 / 2))));
                cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.p);
                cellForumTestView.setViewTop(this.w[0].top);
                cellForumTestView.setViewBottom(this.w[0].bottom);
                cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                R(cellForumTestView);
                cellForumTestView.setData(this.f15163f.get(cellForumTestView.getDataIndex()));
            }
        }
        cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f2);
        cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f2);
        if (cellForumTestView.getViewLeft() <= this.w[1].left) {
            cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f3);
            cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f3);
            float viewTop = cellForumTestView.getViewTop();
            Rect[] rectArr3 = this.w;
            if (viewTop > rectArr3[0].top) {
                cellForumTestView.setViewTop(rectArr3[0].top);
            }
            float viewBottom = cellForumTestView.getViewBottom();
            Rect[] rectArr4 = this.w;
            if (viewBottom < rectArr4[0].bottom) {
                cellForumTestView.setViewBottom(rectArr4[0].bottom);
            }
        } else if (cellForumTestView.getViewLeft() <= this.w[2].left) {
            cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f3);
            cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f3);
            float viewTop2 = cellForumTestView.getViewTop();
            Rect[] rectArr5 = this.w;
            if (viewTop2 < rectArr5[1].top) {
                cellForumTestView.setViewTop(rectArr5[1].top);
            }
            float viewBottom2 = cellForumTestView.getViewBottom();
            Rect[] rectArr6 = this.w;
            if (viewBottom2 > rectArr6[1].bottom) {
                cellForumTestView.setViewBottom(rectArr6[1].bottom);
            }
        }
    }

    public final void W() {
        CellForumTestView cellForumTestView = this.f15165h;
        cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
        CellForumTestView cellForumTestView2 = this.i;
        cellForumTestView2.setIndex(cellForumTestView2.getIndex() + 1);
        CellForumTestView cellForumTestView3 = this.j;
        cellForumTestView3.setIndex(cellForumTestView3.getIndex() + 1);
        S(this.f15165h);
        S(this.i);
        S(this.j);
    }

    public final void X() {
        CellForumTestView cellForumTestView = this.f15165h;
        cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
        CellForumTestView cellForumTestView2 = this.i;
        cellForumTestView2.setIndex(cellForumTestView2.getIndex() - 1);
        CellForumTestView cellForumTestView3 = this.j;
        cellForumTestView3.setIndex(cellForumTestView3.getIndex() - 1);
        S(this.f15165h);
        S(this.i);
        S(this.j);
    }

    public final void Y(float f2) {
        CellForumTestView I;
        float viewRight;
        float f3;
        this.M = false;
        this.N = 0.0f;
        K();
        if (this.f15163f.size() == 2) {
            CellForumTestView cellForumTestView = null;
            CellForumTestView cellForumTestView2 = this.f15165h.getVisibility() == 0 ? this.f15165h : null;
            if (this.i.getVisibility() == 0) {
                if (cellForumTestView2 == null) {
                    cellForumTestView2 = this.i;
                } else {
                    cellForumTestView = this.i;
                }
            }
            if (this.j.getVisibility() == 0) {
                cellForumTestView = this.j;
            }
            if (cellForumTestView2.getIndex() < cellForumTestView.getIndex()) {
                f3 = cellForumTestView2.getViewLeft();
                viewRight = cellForumTestView.getViewRight();
            } else {
                float viewLeft = cellForumTestView.getViewLeft();
                viewRight = cellForumTestView2.getViewRight();
                f3 = viewLeft;
            }
            Rect[] rectArr = this.w;
            if (!(f3 < ((float) rectArr[0].left) || viewRight > ((float) rectArr[2].right)) && Math.abs(this.D) >= this.p * 0.2f) {
                this.M = true;
            }
        } else if (this.f15163f.size() > 2 && Math.abs(this.D) >= this.p * 0.2f) {
            this.M = true;
        }
        if (this.M && (I = I(1)) != null) {
            float f4 = this.D;
            int i = this.p;
            if (f4 >= i) {
                this.D = f4 - i;
                this.M = false;
                X();
            } else if (f4 > 0.0f && f4 < i) {
                this.D = this.w[0].right - I.getViewRight();
            } else if (this.D > (-this.p)) {
                this.D = this.w[2].left - I.getViewLeft();
            } else {
                W();
                this.D += this.p;
                this.M = false;
            }
        }
        this.C.setFloatValues(0.0f, this.D);
        this.C.start();
    }

    @Override // d.b.i0.i0.k.d.a
    public void a(int i) {
        CellForumTestView cellForumTestView;
        this.k.setVisibility(0);
        this.k.setAlpha(1.0f);
        U();
        if (this.f15165h.getIndex() == i && this.f15165h.getVisibility() == 0) {
            cellForumTestView = this.f15165h;
        } else if (this.i.getIndex() == i && this.i.getVisibility() == 0) {
            cellForumTestView = this.i;
        } else {
            cellForumTestView = this.j;
        }
        this.k.setData(cellForumTestView.getData());
        this.k.setDataIndex(cellForumTestView.getDataIndex());
        this.m = null;
        if (this.f15163f.size() == 1) {
            this.H = 1;
            cellForumTestView.setVisibility(8);
            this.D = (this.p * 3) / 5;
        } else if (this.f15163f.size() == 2) {
            this.H = 2;
            cellForumTestView.setVisibility(8);
            if (this.f15165h.getVisibility() == 0) {
                this.l = this.f15165h;
            } else if (this.i.getVisibility() == 0) {
                this.l = this.i;
            } else {
                this.l = this.j;
            }
            if (this.l.getViewRight() < this.w[1].left) {
                this.D = this.p + this.v;
                CellForumTestView cellForumTestView2 = this.l;
                cellForumTestView2.setIndex(cellForumTestView2.getIndex() + 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            } else if (this.l.getViewLeft() > this.w[1].right) {
                this.D = (-this.p) - this.v;
                CellForumTestView cellForumTestView3 = this.l;
                cellForumTestView3.setIndex(cellForumTestView3.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            }
            S(this.l);
            S(cellForumTestView);
        } else if (this.f15163f.size() == 3) {
            this.H = 3;
            cellForumTestView.setVisibility(8);
            if (this.f15165h.getIndex() == 2) {
                this.l = this.f15165h;
            } else if (this.i.getIndex() == 2) {
                this.l = this.i;
            } else {
                this.l = this.j;
            }
            this.D = (-this.p) - this.v;
            CellForumTestView cellForumTestView4 = this.l;
            cellForumTestView4.setIndex(cellForumTestView4.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            S(this.l);
            S(cellForumTestView);
        } else {
            this.H = 4;
            this.m = cellForumTestView;
            if (this.f15165h.getIndex() == 2) {
                this.l = this.f15165h;
            } else if (this.i.getIndex() == 2) {
                this.l = this.i;
            } else {
                this.l = this.j;
            }
            this.D = (-this.p) - this.v;
            CellForumTestView cellForumTestView5 = this.l;
            cellForumTestView5.setIndex(cellForumTestView5.getIndex() - 1);
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            S(this.l);
            S(cellForumTestView);
            this.m.setViewLeft(this.w[2].right + this.v);
            this.m.setViewRight(this.w[2].right + this.v + this.p);
            this.m.setViewTop(this.w[2].top);
            this.m.setViewBottom(this.w[2].bottom);
            this.m.setMoveLeft(this.w[2].right + this.v);
            this.m.setMoveRight(this.w[2].right + this.v + this.p);
            this.m.setMoveTop(this.w[2].top);
            this.m.setMoveBottom(this.w[2].bottom);
            CellForumTestView cellForumTestView6 = this.m;
            cellForumTestView6.setData(this.f15163f.get(H(cellForumTestView6.getDataIndex() + 2)));
        }
        this.E.setFloatValues(0.0f, this.D);
        this.E.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ValueAnimator valueAnimator;
        getParent().requestDisallowInterceptTouchEvent(true);
        ValueAnimator valueAnimator2 = this.E;
        if ((valueAnimator2 == null || !valueAnimator2.isRunning()) && ((valueAnimator = this.C) == null || !valueAnimator.isRunning())) {
            int action = motionEvent.getAction();
            D(motionEvent);
            VelocityTracker velocityTracker = this.K;
            float x = motionEvent.getX(0);
            float y = motionEvent.getY(0);
            int i = action & 255;
            if (i == 0) {
                ValueAnimator valueAnimator3 = this.C;
                if (valueAnimator3 != null) {
                    valueAnimator3.removeAllUpdateListeners();
                    this.C.cancel();
                }
                this.I = motionEvent.getPointerId(0);
                this.x = x;
                this.y = y;
                this.z = x;
            } else if (i == 2) {
                float f2 = this.x - x;
                float f3 = this.y - y;
                if (Math.abs(f2) / (Math.abs(f3) + 1.0f) > 1.0f) {
                    this.F = true;
                    this.D = f2;
                } else if (Math.abs(f3) > 30.0f && !this.F) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                float f4 = this.z - x;
                float f5 = this.A * f4;
                if (this.F) {
                    V(this.f15165h, f4, f5);
                    V(this.i, f4, f5);
                    V(this.j, f4, f5);
                    requestLayout();
                }
                this.z = x;
            } else if (i == 1 || i == 3) {
                velocityTracker.computeCurrentVelocity(1000, this.J);
                float xVelocity = velocityTracker.getXVelocity(this.I);
                if (this.F || this.D != 0.0f) {
                    Y(xVelocity);
                }
                this.F = false;
                P();
            }
            if (this.F || this.D != 0.0f || motionEvent.getPointerCount() >= 2) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.p, 0.0f);
        this.E = ofFloat;
        ofFloat.setDuration(500L);
        this.E.setInterpolator(new DecelerateInterpolator());
        this.E.addUpdateListener(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (!this.F && this.D == 0.0f) {
            ValueAnimator valueAnimator = this.C;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                this.C.cancel();
            }
            ValueAnimator valueAnimator2 = this.E;
            if (valueAnimator2 != null) {
                valueAnimator2.removeAllUpdateListeners();
                this.E.cancel();
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getVisibility() == 0) {
            CellForumTestView cellForumTestView = this.f15165h;
            cellForumTestView.layout((int) cellForumTestView.getViewLeft(), (int) this.f15165h.getViewTop(), (int) this.f15165h.getViewRight(), (int) this.f15165h.getViewBottom());
            CellForumTestView cellForumTestView2 = this.i;
            cellForumTestView2.layout((int) cellForumTestView2.getViewLeft(), (int) this.i.getViewTop(), (int) this.i.getViewRight(), (int) this.i.getViewBottom());
            CellForumTestView cellForumTestView3 = this.j;
            cellForumTestView3.layout((int) cellForumTestView3.getViewLeft(), (int) this.j.getViewTop(), (int) this.j.getViewRight(), (int) this.j.getViewBottom());
            CellForumTestView cellForumTestView4 = this.k;
            cellForumTestView4.layout((int) cellForumTestView4.getViewLeft(), (int) this.k.getViewTop(), (int) this.k.getViewRight(), (int) this.k.getViewBottom());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (getVisibility() == 0) {
            int k = l.k(getContext());
            if (k != this.O) {
                this.O = k;
                F(getContext());
                T(this.f15165h);
                T(this.i);
                T(this.j);
                T(this.k);
            }
            L(this.f15165h);
            L(this.i);
            L(this.j);
            L(this.k);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.o, 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setData(List<f> list) {
        if (ListUtils.isEmpty(list) || this.F || this.D != 0.0f) {
            return;
        }
        this.f15163f = list;
        Q();
        int i = 1;
        if (ListUtils.getCount(list) > 2) {
            this.f15165h.setVisibility(0);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.f15165h.setData(list.get(0));
            this.i.setData(list.get(1));
            this.j.setData(list.get(2));
            this.f15165h.setDataIndex(0);
            this.i.setDataIndex(1);
            this.j.setDataIndex(2);
        } else if (ListUtils.getCount(list) == 2) {
            this.f15165h.setVisibility(8);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.i.setDataIndex(1);
            this.j.setDataIndex(0);
            this.i.setData(list.get(1));
            this.j.setData(list.get(0));
        } else {
            this.f15165h.setVisibility(8);
            this.i.setVisibility(0);
            this.j.setVisibility(8);
            this.i.setDataIndex(0);
            this.i.setData(list.get(0));
            i = 0;
        }
        E(i);
    }

    public void setOnSecectedListener(c cVar) {
        this.L = cVar;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.f15164g = bdUniqueId;
        CellForumTestView cellForumTestView = this.f15165h;
        if (cellForumTestView != null) {
            cellForumTestView.setPageId(bdUniqueId);
        }
        CellForumTestView cellForumTestView2 = this.i;
        if (cellForumTestView2 != null) {
            cellForumTestView2.setPageId(bdUniqueId);
        }
        CellForumTestView cellForumTestView3 = this.j;
        if (cellForumTestView3 != null) {
            cellForumTestView3.setPageId(bdUniqueId);
        }
    }

    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15162e = 3;
        this.w = new Rect[3];
        this.F = false;
        this.M = false;
        this.N = 0.0f;
        this.O = 0;
        J(context);
    }

    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15162e = 3;
        this.w = new Rect[3];
        this.F = false;
        this.M = false;
        this.N = 0.0f;
        this.O = 0;
        J(context);
    }
}
