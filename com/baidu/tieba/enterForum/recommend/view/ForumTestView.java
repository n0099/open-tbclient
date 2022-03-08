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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.r0.u0.k.c.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class ForumTestView extends FrameLayout implements c.a.r0.u0.k.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    public int f41299e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f41300f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f41301g;

    /* renamed from: h  reason: collision with root package name */
    public CellForumTestView f41302h;

    /* renamed from: i  reason: collision with root package name */
    public CellForumTestView f41303i;

    /* renamed from: j  reason: collision with root package name */
    public CellForumTestView f41304j;
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

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumTestView f41305e;

        public a(ForumTestView forumTestView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41305e = forumTestView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.f41305e.H != 1) {
                    if (this.f41305e.H != 2 && this.f41305e.H != 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(this.f41305e.A * floatValue);
                        float abs2 = Math.abs(floatValue) * this.f41305e.B;
                        if (Math.abs(floatValue) >= Math.abs(this.f41305e.D)) {
                            this.f41305e.k.setAlpha(0.0f);
                            this.f41305e.k.setVisibility(8);
                            this.f41305e.D = 0.0f;
                            ForumTestView forumTestView = this.f41305e;
                            forumTestView.Q(forumTestView.l);
                            ForumTestView forumTestView2 = this.f41305e;
                            forumTestView2.Q(forumTestView2.k);
                            ForumTestView forumTestView3 = this.f41305e;
                            forumTestView3.Q(forumTestView3.m);
                            this.f41305e.f41300f.remove(this.f41305e.k.getData());
                            if (this.f41305e.f41302h.getIndex() == 0) {
                                if (this.f41305e.f41302h.getDataIndex() > this.f41305e.m.getDataIndex()) {
                                    this.f41305e.f41302h.setDataIndex(this.f41305e.f41302h.getDataIndex() - 1);
                                    ForumTestView forumTestView4 = this.f41305e;
                                    forumTestView4.O(forumTestView4.f41302h);
                                }
                            } else if (this.f41305e.f41303i.getIndex() == 0) {
                                if (this.f41305e.f41303i.getDataIndex() > this.f41305e.m.getDataIndex()) {
                                    this.f41305e.f41303i.setDataIndex(this.f41305e.f41303i.getDataIndex() - 1);
                                    ForumTestView forumTestView5 = this.f41305e;
                                    forumTestView5.O(forumTestView5.f41303i);
                                }
                            } else if (this.f41305e.f41304j.getDataIndex() > this.f41305e.m.getDataIndex()) {
                                this.f41305e.f41304j.setDataIndex(this.f41305e.f41304j.getDataIndex() - 1);
                                ForumTestView forumTestView6 = this.f41305e;
                                forumTestView6.O(forumTestView6.f41304j);
                            }
                            if (this.f41305e.l.getDataIndex() > this.f41305e.m.getDataIndex()) {
                                this.f41305e.l.setDataIndex(this.f41305e.l.getDataIndex() - 1);
                                ForumTestView forumTestView7 = this.f41305e;
                                forumTestView7.O(forumTestView7.l);
                            }
                            this.f41305e.m.setDataIndex(this.f41305e.m.getDataIndex() + 1);
                            ForumTestView forumTestView8 = this.f41305e;
                            forumTestView8.O(forumTestView8.m);
                            this.f41305e.L(true);
                            this.f41305e.G = false;
                        } else {
                            ForumTestView forumTestView9 = this.f41305e;
                            forumTestView9.K(forumTestView9.l, floatValue, abs);
                            ForumTestView forumTestView10 = this.f41305e;
                            forumTestView10.E(forumTestView10.m, floatValue);
                            if ((this.f41305e.p * 2) / 5 >= this.f41305e.k.getViewRight() - this.f41305e.k.getViewLeft()) {
                                this.f41305e.k.setAlpha(0.0f);
                                this.f41305e.k.setVisibility(8);
                            } else {
                                this.f41305e.k.setViewLeft(this.f41305e.k.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                this.f41305e.k.setViewRight(this.f41305e.k.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                float f2 = abs2 / 2.0f;
                                this.f41305e.k.setViewTop(this.f41305e.k.getMoveTop() + f2);
                                this.f41305e.k.setViewBottom(this.f41305e.k.getMoveBottom() - f2);
                                this.f41305e.k.setAlpha(1.0f - (Math.abs(floatValue) / ((this.f41305e.p * 3) / 5)));
                            }
                        }
                        this.f41305e.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(this.f41305e.A * floatValue2);
                    float abs4 = Math.abs(floatValue2) * this.f41305e.B;
                    if (Math.abs(floatValue2) >= Math.abs(this.f41305e.D)) {
                        this.f41305e.k.setAlpha(0.0f);
                        this.f41305e.k.setVisibility(8);
                        this.f41305e.D = 0.0f;
                        ForumTestView forumTestView11 = this.f41305e;
                        forumTestView11.Q(forumTestView11.l);
                        ForumTestView forumTestView12 = this.f41305e;
                        forumTestView12.Q(forumTestView12.k);
                        this.f41305e.f41300f.remove(this.f41305e.k.getData());
                        this.f41305e.L(true);
                        this.f41305e.G = false;
                    } else {
                        ForumTestView forumTestView13 = this.f41305e;
                        forumTestView13.K(forumTestView13.l, floatValue2, abs3);
                        if ((this.f41305e.p * 2) / 5 >= this.f41305e.k.getViewRight() - this.f41305e.k.getViewLeft()) {
                            this.f41305e.k.setAlpha(0.0f);
                            this.f41305e.k.setVisibility(8);
                        } else {
                            this.f41305e.k.setViewLeft(this.f41305e.k.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            this.f41305e.k.setViewRight(this.f41305e.k.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            float f3 = abs4 / 2.0f;
                            this.f41305e.k.setViewTop(this.f41305e.k.getMoveTop() + f3);
                            this.f41305e.k.setViewBottom(this.f41305e.k.getMoveBottom() - f3);
                            this.f41305e.k.setAlpha(1.0f - (Math.abs(floatValue2) / ((this.f41305e.p * 3) / 5)));
                        }
                    }
                    this.f41305e.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f4 = this.f41305e.B * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(this.f41305e.D / 2.0f)) {
                    this.f41305e.k.setAlpha(0.0f);
                    this.f41305e.k.setVisibility(8);
                    this.f41305e.D = 0.0f;
                    this.f41305e.f41300f.remove(this.f41305e.k.getData());
                    this.f41305e.setVisibility(8);
                    if (this.f41305e.L != null) {
                        this.f41305e.L.onSelected(-1L);
                    }
                    this.f41305e.G = false;
                    if (this.f41305e.L != null && ListUtils.isEmpty(this.f41305e.f41300f)) {
                        this.f41305e.L.onListCleared();
                    }
                } else {
                    this.f41305e.k.setViewLeft(this.f41305e.k.getMoveLeft() + floatValue3);
                    this.f41305e.k.setViewRight(this.f41305e.k.getMoveRight() - floatValue3);
                    this.f41305e.k.setViewTop(this.f41305e.k.getMoveTop() + f4);
                    this.f41305e.k.setViewBottom(this.f41305e.k.getMoveBottom() - f4);
                    this.f41305e.k.setAlpha(1.0f - (floatValue3 / this.f41305e.D));
                }
                this.f41305e.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumTestView f41306e;

        public b(ForumTestView forumTestView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41306e = forumTestView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(this.f41306e.D)) {
                    boolean z = Math.abs(this.f41306e.D) >= ((float) this.f41306e.p) * 0.2f;
                    if (this.f41306e.M) {
                        if (this.f41306e.D > 0.0f) {
                            this.f41306e.T();
                        } else {
                            this.f41306e.U();
                        }
                        this.f41306e.M = false;
                    }
                    this.f41306e.N = 0.0f;
                    this.f41306e.D = 0.0f;
                    ForumTestView forumTestView = this.f41306e;
                    forumTestView.Q(forumTestView.f41302h);
                    ForumTestView forumTestView2 = this.f41306e;
                    forumTestView2.Q(forumTestView2.f41303i);
                    ForumTestView forumTestView3 = this.f41306e;
                    forumTestView3.Q(forumTestView3.f41304j);
                    this.f41306e.requestLayout();
                    this.f41306e.L(z);
                } else {
                    if (this.f41306e.M) {
                        if (this.f41306e.D > 0.0f) {
                            if (this.f41306e.G(2) != null && this.f41306e.G(2).getViewLeft() >= n.k(this.f41306e.getContext())) {
                                this.f41306e.T();
                                this.f41306e.M = false;
                            }
                        } else if (this.f41306e.G(0) != null && this.f41306e.G(0).getViewRight() <= 0.0f) {
                            this.f41306e.U();
                            this.f41306e.M = false;
                        }
                    }
                    float f2 = this.f41306e.N - floatValue;
                    float f3 = this.f41306e.A * f2;
                    ForumTestView forumTestView4 = this.f41306e;
                    forumTestView4.S(forumTestView4.f41302h, f2, f3);
                    ForumTestView forumTestView5 = this.f41306e;
                    forumTestView5.S(forumTestView5.f41303i, f2, f3);
                    ForumTestView forumTestView6 = this.f41306e;
                    forumTestView6.S(forumTestView6.f41304j, f2, f3);
                    this.f41306e.requestLayout();
                }
                this.f41306e.N = floatValue;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onListCleared();

        void onSelected(long j2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTestView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41299e = 3;
        this.w = new Rect[3];
        this.F = false;
        this.M = false;
        this.N = 0.0f;
        this.O = 0;
        H(context);
    }

    public final void C(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
            if (this.K == null) {
                this.K = VelocityTracker.obtain();
            }
            this.K.addMovement(motionEvent);
        }
    }

    public final void D(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.t = n.f(context, R.dimen.tbds44);
            this.u = n.f(context, R.dimen.tbds30);
            this.v = n.f(context, R.dimen.tbds7);
            int f2 = n.f(context, R.dimen.tbds730);
            this.s = f2;
            this.r = f2 - (this.u * 2);
            int k = n.k(getContext());
            this.n = k;
            int i2 = (int) (k * 0.89f);
            this.p = i2;
            int i3 = this.s;
            this.o = this.t + i3;
            int i4 = this.v;
            this.q = ((k - i2) - (i4 * 2)) / 2;
            this.A = this.u / (i4 + i2);
            this.B = i3 / i2;
            Rect[] rectArr = this.w;
            int i5 = this.q;
            int i6 = this.t;
            int i7 = this.u;
            rectArr[0] = new Rect(i5 - this.p, i6 + i7, i5, i6 + i7 + this.r);
            Rect[] rectArr2 = this.w;
            int i8 = this.q;
            int i9 = this.v;
            int i10 = this.t;
            rectArr2[1] = new Rect(i8 + i9, i10, i8 + i9 + this.p, this.s + i10);
            Rect[] rectArr3 = this.w;
            int i11 = this.n;
            int i12 = this.q;
            int i13 = this.t;
            int i14 = this.u;
            rectArr3[2] = new Rect(i11 - i12, i13 + i14, (i11 - i12) + this.p, i13 + i14 + this.r);
        }
    }

    public final void E(CellForumTestView cellForumTestView, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, cellForumTestView, f2) == null) || cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(cellForumTestView.getMoveLeft() + f2);
        cellForumTestView.setViewRight(cellForumTestView.getMoveRight() + f2);
    }

    public final int F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f41300f.size();
            int i3 = i2 % size;
            return i3 < 0 ? size - Math.abs(i3) : i3;
        }
        return invokeI.intValue;
    }

    public final CellForumTestView G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (this.f41302h.getIndex() == i2) {
                return this.f41302h;
            }
            if (this.f41303i.getIndex() == i2) {
                return this.f41303i;
            }
            if (this.f41304j.getIndex() == i2) {
                return this.f41304j;
            }
            return null;
        }
        return (CellForumTestView) invokeI.objValue;
    }

    public final void H(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.forum_test_layout, (ViewGroup) this, true);
            this.f41302h = (CellForumTestView) findViewById(R.id.forum_test_view_one);
            this.f41303i = (CellForumTestView) findViewById(R.id.forum_test_view_two);
            this.f41304j = (CellForumTestView) findViewById(R.id.forum_test_view_three);
            this.k = (CellForumTestView) findViewById(R.id.forum_test_view_del);
            D(context);
            N();
            ViewConfiguration.get(context);
            this.J = ViewConfiguration.getMaximumFlingVelocity();
            this.f41302h.setForumTestDelClickListener(this);
            this.f41303i.setForumTestDelClickListener(this);
            this.f41304j.setForumTestDelClickListener(this);
            onChangeSkinType();
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.p, 0.0f);
            this.C = ofFloat;
            ofFloat.setDuration(200L);
            this.C.setInterpolator(new DecelerateInterpolator());
            this.C.addUpdateListener(new b(this));
        }
    }

    public final void J(CellForumTestView cellForumTestView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cellForumTestView) == null) || cellForumTestView == null) {
            return;
        }
        cellForumTestView.getLayoutParams().width = (int) (cellForumTestView.getViewRight() - cellForumTestView.getViewLeft());
        cellForumTestView.getLayoutParams().height = (int) (cellForumTestView.getViewBottom() - cellForumTestView.getViewTop());
    }

    public final void K(CellForumTestView cellForumTestView, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{cellForumTestView, Float.valueOf(f2), Float.valueOf(f3)}) == null) || cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(cellForumTestView.getMoveLeft() + f2);
        cellForumTestView.setViewRight(cellForumTestView.getMoveRight() + f2);
        cellForumTestView.setViewTop(cellForumTestView.getMoveTop() - f3);
        cellForumTestView.setViewBottom(cellForumTestView.getMoveBottom() + f3);
    }

    public final void L(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || this.L == null) {
            return;
        }
        int i2 = -1;
        if (this.f41302h.getIndex() == 1 && this.f41302h.getData() != null) {
            this.L.onSelected(this.f41302h.getData().a);
            i2 = this.f41302h.getDataIndex();
        } else if (this.f41303i.getIndex() == 1 && this.f41303i.getData() != null) {
            this.L.onSelected(this.f41303i.getData().a);
            i2 = this.f41303i.getDataIndex();
        } else if (this.f41304j.getIndex() == 1 && this.f41304j.getData() != null) {
            this.L.onSelected(this.f41304j.getData().a);
            i2 = this.f41304j.getDataIndex();
        } else {
            this.L.onSelected(-1L);
        }
        if (z) {
            addShowLog(i2);
        }
    }

    public final void M() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (velocityTracker = this.K) == null) {
            return;
        }
        velocityTracker.clear();
        this.K.recycle();
        this.K = null;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f41302h.setIndex(0);
            this.f41303i.setIndex(1);
            this.f41304j.setIndex(2);
            this.k.setIndex(1);
            Q(this.f41302h);
            Q(this.f41303i);
            Q(this.f41304j);
            Q(this.k);
        }
    }

    public final void O(CellForumTestView cellForumTestView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, cellForumTestView) == null) || cellForumTestView == null) {
            return;
        }
        int size = this.f41300f.size();
        int dataIndex = cellForumTestView.getDataIndex() % size;
        if (dataIndex < 0) {
            dataIndex = size - Math.abs(dataIndex);
        }
        cellForumTestView.setDataIndex(dataIndex);
    }

    public final void P(CellForumTestView cellForumTestView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cellForumTestView) == null) || cellForumTestView == null) {
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

    public final void Q(CellForumTestView cellForumTestView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, cellForumTestView) == null) || cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(this.w[cellForumTestView.getIndex()].left);
        cellForumTestView.setViewTop(this.w[cellForumTestView.getIndex()].top);
        cellForumTestView.setViewRight(this.w[cellForumTestView.getIndex()].right);
        cellForumTestView.setViewBottom(this.w[cellForumTestView.getIndex()].bottom);
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            CellForumTestView cellForumTestView = this.f41302h;
            cellForumTestView.setMoveLeft(cellForumTestView.getViewLeft());
            CellForumTestView cellForumTestView2 = this.f41302h;
            cellForumTestView2.setMoveTop(cellForumTestView2.getViewTop());
            CellForumTestView cellForumTestView3 = this.f41302h;
            cellForumTestView3.setMoveRight(cellForumTestView3.getViewRight());
            CellForumTestView cellForumTestView4 = this.f41302h;
            cellForumTestView4.setMoveBottom(cellForumTestView4.getViewBottom());
            CellForumTestView cellForumTestView5 = this.f41303i;
            cellForumTestView5.setMoveLeft(cellForumTestView5.getViewLeft());
            CellForumTestView cellForumTestView6 = this.f41303i;
            cellForumTestView6.setMoveTop(cellForumTestView6.getViewTop());
            CellForumTestView cellForumTestView7 = this.f41303i;
            cellForumTestView7.setMoveRight(cellForumTestView7.getViewRight());
            CellForumTestView cellForumTestView8 = this.f41303i;
            cellForumTestView8.setMoveBottom(cellForumTestView8.getViewBottom());
            CellForumTestView cellForumTestView9 = this.f41304j;
            cellForumTestView9.setMoveLeft(cellForumTestView9.getViewLeft());
            CellForumTestView cellForumTestView10 = this.f41304j;
            cellForumTestView10.setMoveTop(cellForumTestView10.getViewTop());
            CellForumTestView cellForumTestView11 = this.f41304j;
            cellForumTestView11.setMoveRight(cellForumTestView11.getViewRight());
            CellForumTestView cellForumTestView12 = this.f41304j;
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
    }

    public final void S(CellForumTestView cellForumTestView, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{cellForumTestView, Float.valueOf(f2), Float.valueOf(f3)}) == null) || cellForumTestView == null || cellForumTestView.getVisibility() == 8) {
            return;
        }
        if (this.f41300f.size() > 2) {
            if (cellForumTestView.getViewRight() < this.w[0].right - (this.p / 2) && f2 > 0.0f) {
                float viewRight = cellForumTestView.getViewRight();
                Rect[] rectArr = this.w;
                int i2 = rectArr[0].right;
                int i3 = this.p;
                cellForumTestView.setViewLeft(rectArr[2].left + (i3 / 2) + this.v + (viewRight - (i2 - (i3 / 2))));
                cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.p);
                cellForumTestView.setViewTop(this.w[2].top);
                cellForumTestView.setViewBottom(this.w[2].bottom);
                cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                O(cellForumTestView);
                cellForumTestView.setData(this.f41300f.get(cellForumTestView.getDataIndex()));
            } else if (cellForumTestView.getViewLeft() > this.w[2].left + (this.p / 2) && f2 < 0.0f) {
                float viewLeft = cellForumTestView.getViewLeft();
                Rect[] rectArr2 = this.w;
                int i4 = rectArr2[2].left;
                int i5 = this.p;
                cellForumTestView.setViewRight(((rectArr2[0].right - (i5 / 2)) - this.v) + (viewLeft - (i4 + (i5 / 2))));
                cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.p);
                cellForumTestView.setViewTop(this.w[0].top);
                cellForumTestView.setViewBottom(this.w[0].bottom);
                cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                O(cellForumTestView);
                cellForumTestView.setData(this.f41300f.get(cellForumTestView.getDataIndex()));
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

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CellForumTestView cellForumTestView = this.f41302h;
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            CellForumTestView cellForumTestView2 = this.f41303i;
            cellForumTestView2.setIndex(cellForumTestView2.getIndex() + 1);
            CellForumTestView cellForumTestView3 = this.f41304j;
            cellForumTestView3.setIndex(cellForumTestView3.getIndex() + 1);
            P(this.f41302h);
            P(this.f41303i);
            P(this.f41304j);
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            CellForumTestView cellForumTestView = this.f41302h;
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            CellForumTestView cellForumTestView2 = this.f41303i;
            cellForumTestView2.setIndex(cellForumTestView2.getIndex() - 1);
            CellForumTestView cellForumTestView3 = this.f41304j;
            cellForumTestView3.setIndex(cellForumTestView3.getIndex() - 1);
            P(this.f41302h);
            P(this.f41303i);
            P(this.f41304j);
        }
    }

    public final void V(float f2) {
        CellForumTestView G;
        float viewRight;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            this.M = false;
            this.N = 0.0f;
            I();
            if (this.f41300f.size() == 2) {
                CellForumTestView cellForumTestView = null;
                CellForumTestView cellForumTestView2 = this.f41302h.getVisibility() == 0 ? this.f41302h : null;
                if (this.f41303i.getVisibility() == 0) {
                    if (cellForumTestView2 == null) {
                        cellForumTestView2 = this.f41303i;
                    } else {
                        cellForumTestView = this.f41303i;
                    }
                }
                if (this.f41304j.getVisibility() == 0) {
                    cellForumTestView = this.f41304j;
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
            } else if (this.f41300f.size() > 2 && Math.abs(this.D) >= this.p * 0.2f) {
                this.M = true;
            }
            if (this.M && (G = G(1)) != null) {
                float f4 = this.D;
                int i2 = this.p;
                if (f4 >= i2) {
                    this.D = f4 - i2;
                    this.M = false;
                    U();
                } else if (f4 > 0.0f && f4 < i2) {
                    this.D = this.w[0].right - G.getViewRight();
                } else if (this.D > (-this.p)) {
                    this.D = this.w[2].left - G.getViewLeft();
                } else {
                    T();
                    this.D += this.p;
                    this.M = false;
                }
            }
            this.C.setFloatValues(0.0f, this.D);
            this.C.start();
        }
    }

    public void addShowLog(int i2) {
        List<f> list;
        f fVar;
        int i3;
        StatisticItem l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (list = this.f41300f) == null || i2 < 0 || i2 >= list.size() || (fVar = this.f41300f.get(i2)) == null || (l = c.a.r0.x3.a.l(false, "a065", "common_exp", i3, (i3 = i2 + 1), false, null, String.valueOf(fVar.a), 0)) == null) {
            return;
        }
        c.a.r0.x3.c g2 = c.a.r0.x3.c.g();
        BdUniqueId bdUniqueId = this.f41301g;
        g2.d(bdUniqueId, c.a.r0.x3.a.b("" + fVar.a), l);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            getParent().requestDisallowInterceptTouchEvent(true);
            ValueAnimator valueAnimator2 = this.E;
            if ((valueAnimator2 == null || !valueAnimator2.isRunning()) && ((valueAnimator = this.C) == null || !valueAnimator.isRunning())) {
                int action = motionEvent.getAction();
                C(motionEvent);
                VelocityTracker velocityTracker = this.K;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i2 = action & 255;
                if (i2 == 0) {
                    ValueAnimator valueAnimator3 = this.C;
                    if (valueAnimator3 != null) {
                        valueAnimator3.removeAllUpdateListeners();
                        this.C.cancel();
                    }
                    this.I = motionEvent.getPointerId(0);
                    this.x = x;
                    this.y = y;
                    this.z = x;
                } else if (i2 == 2) {
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
                        S(this.f41302h, f4, f5);
                        S(this.f41303i, f4, f5);
                        S(this.f41304j, f4, f5);
                        requestLayout();
                    }
                    this.z = x;
                } else if (i2 == 1 || i2 == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.J);
                    float xVelocity = velocityTracker.getXVelocity(this.I);
                    if (this.F || this.D != 0.0f) {
                        V(xVelocity);
                    }
                    this.F = false;
                    M();
                }
                if (this.F || this.D != 0.0f || motionEvent.getPointerCount() >= 2) {
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onAttachedToWindow();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.p, 0.0f);
            this.E = ofFloat;
            ofFloat.setDuration(500L);
            this.E.setInterpolator(new DecelerateInterpolator());
            this.E.addUpdateListener(new a(this));
        }
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f41299e) {
            return;
        }
        this.f41299e = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        this.f41302h.onChangeSkinType();
        this.f41303i.onChangeSkinType();
        this.f41304j.onChangeSkinType();
    }

    @Override // c.a.r0.u0.k.d.a
    public void onDelClick(int i2) {
        CellForumTestView cellForumTestView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.k.setVisibility(0);
            this.k.setAlpha(1.0f);
            R();
            if (this.f41302h.getIndex() == i2 && this.f41302h.getVisibility() == 0) {
                cellForumTestView = this.f41302h;
            } else if (this.f41303i.getIndex() == i2 && this.f41303i.getVisibility() == 0) {
                cellForumTestView = this.f41303i;
            } else {
                cellForumTestView = this.f41304j;
            }
            this.k.setData(cellForumTestView.getData());
            this.k.setDataIndex(cellForumTestView.getDataIndex());
            this.m = null;
            if (this.f41300f.size() == 1) {
                this.H = 1;
                cellForumTestView.setVisibility(8);
                this.D = (this.p * 3) / 5;
            } else if (this.f41300f.size() == 2) {
                this.H = 2;
                cellForumTestView.setVisibility(8);
                if (this.f41302h.getVisibility() == 0) {
                    this.l = this.f41302h;
                } else if (this.f41303i.getVisibility() == 0) {
                    this.l = this.f41303i;
                } else {
                    this.l = this.f41304j;
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
                P(this.l);
                P(cellForumTestView);
            } else if (this.f41300f.size() == 3) {
                this.H = 3;
                cellForumTestView.setVisibility(8);
                if (this.f41302h.getIndex() == 2) {
                    this.l = this.f41302h;
                } else if (this.f41303i.getIndex() == 2) {
                    this.l = this.f41303i;
                } else {
                    this.l = this.f41304j;
                }
                this.D = (-this.p) - this.v;
                CellForumTestView cellForumTestView4 = this.l;
                cellForumTestView4.setIndex(cellForumTestView4.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
                P(this.l);
                P(cellForumTestView);
            } else {
                this.H = 4;
                this.m = cellForumTestView;
                if (this.f41302h.getIndex() == 2) {
                    this.l = this.f41302h;
                } else if (this.f41303i.getIndex() == 2) {
                    this.l = this.f41303i;
                } else {
                    this.l = this.f41304j;
                }
                this.D = (-this.p) - this.v;
                CellForumTestView cellForumTestView5 = this.l;
                cellForumTestView5.setIndex(cellForumTestView5.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
                P(this.l);
                P(cellForumTestView);
                this.m.setViewLeft(this.w[2].right + this.v);
                this.m.setViewRight(this.w[2].right + this.v + this.p);
                this.m.setViewTop(this.w[2].top);
                this.m.setViewBottom(this.w[2].bottom);
                this.m.setMoveLeft(this.w[2].right + this.v);
                this.m.setMoveRight(this.w[2].right + this.v + this.p);
                this.m.setMoveTop(this.w[2].top);
                this.m.setMoveBottom(this.w[2].bottom);
                CellForumTestView cellForumTestView6 = this.m;
                cellForumTestView6.setData(this.f41300f.get(F(cellForumTestView6.getDataIndex() + 2)));
            }
            this.E.setFloatValues(0.0f, this.D);
            this.E.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
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
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (getVisibility() == 0) {
                CellForumTestView cellForumTestView = this.f41302h;
                cellForumTestView.layout((int) cellForumTestView.getViewLeft(), (int) this.f41302h.getViewTop(), (int) this.f41302h.getViewRight(), (int) this.f41302h.getViewBottom());
                CellForumTestView cellForumTestView2 = this.f41303i;
                cellForumTestView2.layout((int) cellForumTestView2.getViewLeft(), (int) this.f41303i.getViewTop(), (int) this.f41303i.getViewRight(), (int) this.f41303i.getViewBottom());
                CellForumTestView cellForumTestView3 = this.f41304j;
                cellForumTestView3.layout((int) cellForumTestView3.getViewLeft(), (int) this.f41304j.getViewTop(), (int) this.f41304j.getViewRight(), (int) this.f41304j.getViewBottom());
                CellForumTestView cellForumTestView4 = this.k;
                cellForumTestView4.layout((int) cellForumTestView4.getViewLeft(), (int) this.k.getViewTop(), (int) this.k.getViewRight(), (int) this.k.getViewBottom());
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) {
            if (getVisibility() == 0) {
                int k = n.k(getContext());
                if (k != this.O) {
                    this.O = k;
                    D(getContext());
                    Q(this.f41302h);
                    Q(this.f41303i);
                    Q(this.f41304j);
                    Q(this.k);
                }
                J(this.f41302h);
                J(this.f41303i);
                J(this.f41304j);
                J(this.k);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.n, 1073741824), View.MeasureSpec.makeMeasureSpec(this.o, 1073741824));
                return;
            }
            super.onMeasure(i2, i3);
        }
    }

    public void refreshAnswer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.f41302h.getIndex() == 1) {
                this.f41302h.refreshAnswer();
            } else if (this.f41303i.getIndex() == 1) {
                this.f41303i.refreshAnswer();
            } else if (this.f41304j.getIndex() == 1) {
                this.f41304j.refreshAnswer();
            }
        }
    }

    public void setData(List<f> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, list) == null) || ListUtils.isEmpty(list) || this.F || this.D != 0.0f) {
            return;
        }
        this.f41300f = list;
        N();
        int i2 = 1;
        if (ListUtils.getCount(list) > 2) {
            this.f41302h.setVisibility(0);
            this.f41303i.setVisibility(0);
            this.f41304j.setVisibility(0);
            this.f41302h.setData(list.get(0));
            this.f41303i.setData(list.get(1));
            this.f41304j.setData(list.get(2));
            this.f41302h.setDataIndex(0);
            this.f41303i.setDataIndex(1);
            this.f41304j.setDataIndex(2);
        } else if (ListUtils.getCount(list) == 2) {
            this.f41302h.setVisibility(8);
            this.f41303i.setVisibility(0);
            this.f41304j.setVisibility(0);
            this.f41303i.setDataIndex(1);
            this.f41304j.setDataIndex(0);
            this.f41303i.setData(list.get(1));
            this.f41304j.setData(list.get(0));
        } else {
            this.f41302h.setVisibility(8);
            this.f41303i.setVisibility(0);
            this.f41304j.setVisibility(8);
            this.f41303i.setDataIndex(0);
            this.f41303i.setData(list.get(0));
            i2 = 0;
        }
        addShowLog(i2);
    }

    public void setOnSecectedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, cVar) == null) {
            this.L = cVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            this.f41301g = bdUniqueId;
            CellForumTestView cellForumTestView = this.f41302h;
            if (cellForumTestView != null) {
                cellForumTestView.setPageId(bdUniqueId);
            }
            CellForumTestView cellForumTestView2 = this.f41303i;
            if (cellForumTestView2 != null) {
                cellForumTestView2.setPageId(bdUniqueId);
            }
            CellForumTestView cellForumTestView3 = this.f41304j;
            if (cellForumTestView3 != null) {
                cellForumTestView3.setPageId(bdUniqueId);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41299e = 3;
        this.w = new Rect[3];
        this.F = false;
        this.M = false;
        this.N = 0.0f;
        this.O = 0;
        H(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTestView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f41299e = 3;
        this.w = new Rect[3];
        this.F = false;
        this.M = false;
        this.N = 0.0f;
        this.O = 0;
        H(context);
    }
}
