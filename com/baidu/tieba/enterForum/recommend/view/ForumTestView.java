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
import com.repackage.bj8;
import com.repackage.dj8;
import com.repackage.l66;
import com.repackage.m66;
import com.repackage.oi;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumTestView extends FrameLayout implements m66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueAnimator A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public int F;
    public VelocityTracker G;
    public c H;
    public boolean I;
    public float J;
    public int K;
    public int a;
    public List<l66> b;
    public BdUniqueId c;
    public CellForumTestView d;
    public CellForumTestView e;
    public CellForumTestView f;
    public CellForumTestView g;
    public CellForumTestView h;
    public CellForumTestView i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Rect[] s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public ValueAnimator y;
    public float z;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumTestView a;

        public a(ForumTestView forumTestView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumTestView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.a.D != 1) {
                    if (this.a.D != 2 && this.a.D != 3) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float abs = Math.abs(this.a.w * floatValue);
                        float abs2 = Math.abs(floatValue) * this.a.x;
                        if (Math.abs(floatValue) >= Math.abs(this.a.z)) {
                            this.a.g.setAlpha(0.0f);
                            this.a.g.setVisibility(8);
                            this.a.z = 0.0f;
                            ForumTestView forumTestView = this.a;
                            forumTestView.T(forumTestView.h);
                            ForumTestView forumTestView2 = this.a;
                            forumTestView2.T(forumTestView2.g);
                            ForumTestView forumTestView3 = this.a;
                            forumTestView3.T(forumTestView3.i);
                            this.a.b.remove(this.a.g.getData());
                            if (this.a.d.getIndex() == 0) {
                                if (this.a.d.getDataIndex() > this.a.i.getDataIndex()) {
                                    this.a.d.setDataIndex(this.a.d.getDataIndex() - 1);
                                    ForumTestView forumTestView4 = this.a;
                                    forumTestView4.R(forumTestView4.d);
                                }
                            } else if (this.a.e.getIndex() == 0) {
                                if (this.a.e.getDataIndex() > this.a.i.getDataIndex()) {
                                    this.a.e.setDataIndex(this.a.e.getDataIndex() - 1);
                                    ForumTestView forumTestView5 = this.a;
                                    forumTestView5.R(forumTestView5.e);
                                }
                            } else if (this.a.f.getDataIndex() > this.a.i.getDataIndex()) {
                                this.a.f.setDataIndex(this.a.f.getDataIndex() - 1);
                                ForumTestView forumTestView6 = this.a;
                                forumTestView6.R(forumTestView6.f);
                            }
                            if (this.a.h.getDataIndex() > this.a.i.getDataIndex()) {
                                this.a.h.setDataIndex(this.a.h.getDataIndex() - 1);
                                ForumTestView forumTestView7 = this.a;
                                forumTestView7.R(forumTestView7.h);
                            }
                            this.a.i.setDataIndex(this.a.i.getDataIndex() + 1);
                            ForumTestView forumTestView8 = this.a;
                            forumTestView8.R(forumTestView8.i);
                            this.a.O(true);
                            this.a.C = false;
                        } else {
                            ForumTestView forumTestView9 = this.a;
                            forumTestView9.M(forumTestView9.h, floatValue, abs);
                            ForumTestView forumTestView10 = this.a;
                            forumTestView10.G(forumTestView10.i, floatValue);
                            if ((this.a.l * 2) / 5 >= this.a.g.getViewRight() - this.a.g.getViewLeft()) {
                                this.a.g.setAlpha(0.0f);
                                this.a.g.setVisibility(8);
                            } else {
                                this.a.g.setViewLeft(this.a.g.getMoveLeft() + (Math.abs(floatValue) / 2.0f));
                                this.a.g.setViewRight(this.a.g.getMoveRight() - (Math.abs(floatValue) / 2.0f));
                                float f = abs2 / 2.0f;
                                this.a.g.setViewTop(this.a.g.getMoveTop() + f);
                                this.a.g.setViewBottom(this.a.g.getMoveBottom() - f);
                                this.a.g.setAlpha(1.0f - (Math.abs(floatValue) / ((this.a.l * 3) / 5)));
                            }
                        }
                        this.a.requestLayout();
                        return;
                    }
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float abs3 = Math.abs(this.a.w * floatValue2);
                    float abs4 = Math.abs(floatValue2) * this.a.x;
                    if (Math.abs(floatValue2) >= Math.abs(this.a.z)) {
                        this.a.g.setAlpha(0.0f);
                        this.a.g.setVisibility(8);
                        this.a.z = 0.0f;
                        ForumTestView forumTestView11 = this.a;
                        forumTestView11.T(forumTestView11.h);
                        ForumTestView forumTestView12 = this.a;
                        forumTestView12.T(forumTestView12.g);
                        this.a.b.remove(this.a.g.getData());
                        this.a.O(true);
                        this.a.C = false;
                    } else {
                        ForumTestView forumTestView13 = this.a;
                        forumTestView13.M(forumTestView13.h, floatValue2, abs3);
                        if ((this.a.l * 2) / 5 >= this.a.g.getViewRight() - this.a.g.getViewLeft()) {
                            this.a.g.setAlpha(0.0f);
                            this.a.g.setVisibility(8);
                        } else {
                            this.a.g.setViewLeft(this.a.g.getMoveLeft() + (Math.abs(floatValue2) / 2.0f));
                            this.a.g.setViewRight(this.a.g.getMoveRight() - (Math.abs(floatValue2) / 2.0f));
                            float f2 = abs4 / 2.0f;
                            this.a.g.setViewTop(this.a.g.getMoveTop() + f2);
                            this.a.g.setViewBottom(this.a.g.getMoveBottom() - f2);
                            this.a.g.setAlpha(1.0f - (Math.abs(floatValue2) / ((this.a.l * 3) / 5)));
                        }
                    }
                    this.a.requestLayout();
                    return;
                }
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 2.0f;
                float f3 = this.a.x * floatValue3;
                if (Math.abs(floatValue3) >= Math.abs(this.a.z / 2.0f)) {
                    this.a.g.setAlpha(0.0f);
                    this.a.g.setVisibility(8);
                    this.a.z = 0.0f;
                    this.a.b.remove(this.a.g.getData());
                    this.a.setVisibility(8);
                    if (this.a.H != null) {
                        this.a.H.b(-1L);
                    }
                    this.a.C = false;
                    if (this.a.H != null && ListUtils.isEmpty(this.a.b)) {
                        this.a.H.a();
                    }
                } else {
                    this.a.g.setViewLeft(this.a.g.getMoveLeft() + floatValue3);
                    this.a.g.setViewRight(this.a.g.getMoveRight() - floatValue3);
                    this.a.g.setViewTop(this.a.g.getMoveTop() + f3);
                    this.a.g.setViewBottom(this.a.g.getMoveBottom() - f3);
                    this.a.g.setAlpha(1.0f - (floatValue3 / this.a.z));
                }
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumTestView a;

        public b(ForumTestView forumTestView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumTestView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumTestView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (Math.abs(floatValue) >= Math.abs(this.a.z)) {
                    boolean z = Math.abs(this.a.z) >= ((float) this.a.l) * 0.2f;
                    if (this.a.I) {
                        if (this.a.z > 0.0f) {
                            this.a.W();
                        } else {
                            this.a.X();
                        }
                        this.a.I = false;
                    }
                    this.a.J = 0.0f;
                    this.a.z = 0.0f;
                    ForumTestView forumTestView = this.a;
                    forumTestView.T(forumTestView.d);
                    ForumTestView forumTestView2 = this.a;
                    forumTestView2.T(forumTestView2.e);
                    ForumTestView forumTestView3 = this.a;
                    forumTestView3.T(forumTestView3.f);
                    this.a.requestLayout();
                    this.a.O(z);
                } else {
                    if (this.a.I) {
                        if (this.a.z > 0.0f) {
                            if (this.a.I(2) != null && this.a.I(2).getViewLeft() >= oi.k(this.a.getContext())) {
                                this.a.W();
                                this.a.I = false;
                            }
                        } else if (this.a.I(0) != null && this.a.I(0).getViewRight() <= 0.0f) {
                            this.a.X();
                            this.a.I = false;
                        }
                    }
                    float f = this.a.J - floatValue;
                    float f2 = this.a.w * f;
                    ForumTestView forumTestView4 = this.a;
                    forumTestView4.V(forumTestView4.d, f, f2);
                    ForumTestView forumTestView5 = this.a;
                    forumTestView5.V(forumTestView5.e, f, f2);
                    ForumTestView forumTestView6 = this.a;
                    forumTestView6.V(forumTestView6.f, f, f2);
                    this.a.requestLayout();
                }
                this.a.J = floatValue;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();

        void b(long j);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.s = new Rect[3];
        this.B = false;
        this.I = false;
        this.J = 0.0f;
        this.K = 0;
        J(context);
    }

    public final void D(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
            if (this.G == null) {
                this.G = VelocityTracker.obtain();
            }
            this.G.addMovement(motionEvent);
        }
    }

    public void E(int i) {
        List<l66> list;
        l66 l66Var;
        int i2;
        StatisticItem j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (list = this.b) == null || i < 0 || i >= list.size() || (l66Var = this.b.get(i)) == null || (j = bj8.j(false, "a065", "common_exp", i2, (i2 = i + 1), false, null, String.valueOf(l66Var.a), 0)) == null) {
            return;
        }
        dj8 g = dj8.g();
        BdUniqueId bdUniqueId = this.c;
        g.d(bdUniqueId, bj8.b("" + l66Var.a), j);
    }

    public final void F(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.p = oi.f(context, R.dimen.tbds44);
            this.q = oi.f(context, R.dimen.tbds30);
            this.r = oi.f(context, R.dimen.tbds7);
            int f = oi.f(context, R.dimen.tbds730);
            this.o = f;
            this.n = f - (this.q * 2);
            int k = oi.k(getContext());
            this.j = k;
            int i = (int) (k * 0.89f);
            this.l = i;
            int i2 = this.o;
            this.k = this.p + i2;
            int i3 = this.r;
            this.m = ((k - i) - (i3 * 2)) / 2;
            this.w = this.q / (i3 + i);
            this.x = i2 / i;
            Rect[] rectArr = this.s;
            int i4 = this.m;
            int i5 = this.p;
            int i6 = this.q;
            rectArr[0] = new Rect(i4 - this.l, i5 + i6, i4, i5 + i6 + this.n);
            Rect[] rectArr2 = this.s;
            int i7 = this.m;
            int i8 = this.r;
            int i9 = this.p;
            rectArr2[1] = new Rect(i7 + i8, i9, i7 + i8 + this.l, this.o + i9);
            Rect[] rectArr3 = this.s;
            int i10 = this.j;
            int i11 = this.m;
            int i12 = this.p;
            int i13 = this.q;
            rectArr3[2] = new Rect(i10 - i11, i12 + i13, (i10 - i11) + this.l, i12 + i13 + this.n);
        }
    }

    public final void G(CellForumTestView cellForumTestView, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048579, this, cellForumTestView, f) == null) || cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(cellForumTestView.getMoveLeft() + f);
        cellForumTestView.setViewRight(cellForumTestView.getMoveRight() + f);
    }

    public final int H(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int size = this.b.size();
            int i2 = i % size;
            return i2 < 0 ? size - Math.abs(i2) : i2;
        }
        return invokeI.intValue;
    }

    public final CellForumTestView I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.d.getIndex() == i) {
                return this.d;
            }
            if (this.e.getIndex() == i) {
                return this.e;
            }
            if (this.f.getIndex() == i) {
                return this.f;
            }
            return null;
        }
        return (CellForumTestView) invokeI.objValue;
    }

    public final void J(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02d6, (ViewGroup) this, true);
            this.d = (CellForumTestView) findViewById(R.id.obfuscated_res_0x7f090a8e);
            this.e = (CellForumTestView) findViewById(R.id.obfuscated_res_0x7f090a90);
            this.f = (CellForumTestView) findViewById(R.id.obfuscated_res_0x7f090a8f);
            this.g = (CellForumTestView) findViewById(R.id.obfuscated_res_0x7f090a8d);
            F(context);
            Q();
            ViewConfiguration.get(context);
            this.F = ViewConfiguration.getMaximumFlingVelocity();
            this.d.setForumTestDelClickListener(this);
            this.e.setForumTestDelClickListener(this);
            this.f.setForumTestDelClickListener(this);
            N();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.l, 0.0f);
            this.y = ofFloat;
            ofFloat.setDuration(200L);
            this.y.setInterpolator(new DecelerateInterpolator());
            this.y.addUpdateListener(new b(this));
        }
    }

    public final void L(CellForumTestView cellForumTestView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cellForumTestView) == null) || cellForumTestView == null) {
            return;
        }
        cellForumTestView.getLayoutParams().width = (int) (cellForumTestView.getViewRight() - cellForumTestView.getViewLeft());
        cellForumTestView.getLayoutParams().height = (int) (cellForumTestView.getViewBottom() - cellForumTestView.getViewTop());
    }

    public final void M(CellForumTestView cellForumTestView, float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{cellForumTestView, Float.valueOf(f), Float.valueOf(f2)}) == null) || cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(cellForumTestView.getMoveLeft() + f);
        cellForumTestView.setViewRight(cellForumTestView.getMoveRight() + f);
        cellForumTestView.setViewTop(cellForumTestView.getMoveTop() - f2);
        cellForumTestView.setViewBottom(cellForumTestView.getMoveBottom() + f2);
    }

    public void N() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        SkinManager.setBackgroundColor(this, R.color.CAM_X0205);
        this.d.b();
        this.e.b();
        this.f.b();
    }

    public final void O(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.H == null) {
            return;
        }
        int i = -1;
        if (this.d.getIndex() == 1 && this.d.getData() != null) {
            this.H.b(this.d.getData().a);
            i = this.d.getDataIndex();
        } else if (this.e.getIndex() == 1 && this.e.getData() != null) {
            this.H.b(this.e.getData().a);
            i = this.e.getDataIndex();
        } else if (this.f.getIndex() == 1 && this.f.getData() != null) {
            this.H.b(this.f.getData().a);
            i = this.f.getDataIndex();
        } else {
            this.H.b(-1L);
        }
        if (z) {
            E(i);
        }
    }

    public final void P() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (velocityTracker = this.G) == null) {
            return;
        }
        velocityTracker.clear();
        this.G.recycle();
        this.G = null;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d.setIndex(0);
            this.e.setIndex(1);
            this.f.setIndex(2);
            this.g.setIndex(1);
            T(this.d);
            T(this.e);
            T(this.f);
            T(this.g);
        }
    }

    public final void R(CellForumTestView cellForumTestView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, cellForumTestView) == null) || cellForumTestView == null) {
            return;
        }
        int size = this.b.size();
        int dataIndex = cellForumTestView.getDataIndex() % size;
        if (dataIndex < 0) {
            dataIndex = size - Math.abs(dataIndex);
        }
        cellForumTestView.setDataIndex(dataIndex);
    }

    public final void S(CellForumTestView cellForumTestView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, cellForumTestView) == null) || cellForumTestView == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, cellForumTestView) == null) || cellForumTestView == null) {
            return;
        }
        cellForumTestView.setViewLeft(this.s[cellForumTestView.getIndex()].left);
        cellForumTestView.setViewTop(this.s[cellForumTestView.getIndex()].top);
        cellForumTestView.setViewRight(this.s[cellForumTestView.getIndex()].right);
        cellForumTestView.setViewBottom(this.s[cellForumTestView.getIndex()].bottom);
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            CellForumTestView cellForumTestView = this.d;
            cellForumTestView.setMoveLeft(cellForumTestView.getViewLeft());
            CellForumTestView cellForumTestView2 = this.d;
            cellForumTestView2.setMoveTop(cellForumTestView2.getViewTop());
            CellForumTestView cellForumTestView3 = this.d;
            cellForumTestView3.setMoveRight(cellForumTestView3.getViewRight());
            CellForumTestView cellForumTestView4 = this.d;
            cellForumTestView4.setMoveBottom(cellForumTestView4.getViewBottom());
            CellForumTestView cellForumTestView5 = this.e;
            cellForumTestView5.setMoveLeft(cellForumTestView5.getViewLeft());
            CellForumTestView cellForumTestView6 = this.e;
            cellForumTestView6.setMoveTop(cellForumTestView6.getViewTop());
            CellForumTestView cellForumTestView7 = this.e;
            cellForumTestView7.setMoveRight(cellForumTestView7.getViewRight());
            CellForumTestView cellForumTestView8 = this.e;
            cellForumTestView8.setMoveBottom(cellForumTestView8.getViewBottom());
            CellForumTestView cellForumTestView9 = this.f;
            cellForumTestView9.setMoveLeft(cellForumTestView9.getViewLeft());
            CellForumTestView cellForumTestView10 = this.f;
            cellForumTestView10.setMoveTop(cellForumTestView10.getViewTop());
            CellForumTestView cellForumTestView11 = this.f;
            cellForumTestView11.setMoveRight(cellForumTestView11.getViewRight());
            CellForumTestView cellForumTestView12 = this.f;
            cellForumTestView12.setMoveBottom(cellForumTestView12.getViewBottom());
            CellForumTestView cellForumTestView13 = this.g;
            cellForumTestView13.setMoveLeft(cellForumTestView13.getViewLeft());
            CellForumTestView cellForumTestView14 = this.g;
            cellForumTestView14.setMoveTop(cellForumTestView14.getViewTop());
            CellForumTestView cellForumTestView15 = this.g;
            cellForumTestView15.setMoveRight(cellForumTestView15.getViewRight());
            CellForumTestView cellForumTestView16 = this.g;
            cellForumTestView16.setMoveBottom(cellForumTestView16.getViewBottom());
        }
    }

    public final void V(CellForumTestView cellForumTestView, float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{cellForumTestView, Float.valueOf(f), Float.valueOf(f2)}) == null) || cellForumTestView == null || cellForumTestView.getVisibility() == 8) {
            return;
        }
        if (this.b.size() > 2) {
            if (cellForumTestView.getViewRight() < this.s[0].right - (this.l / 2) && f > 0.0f) {
                float viewRight = cellForumTestView.getViewRight();
                Rect[] rectArr = this.s;
                int i = rectArr[0].right;
                int i2 = this.l;
                cellForumTestView.setViewLeft(rectArr[2].left + (i2 / 2) + this.r + (viewRight - (i - (i2 / 2))));
                cellForumTestView.setViewRight(cellForumTestView.getViewLeft() + this.l);
                cellForumTestView.setViewTop(this.s[2].top);
                cellForumTestView.setViewBottom(this.s[2].bottom);
                cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() + 3);
                R(cellForumTestView);
                cellForumTestView.setData(this.b.get(cellForumTestView.getDataIndex()));
            } else if (cellForumTestView.getViewLeft() > this.s[2].left + (this.l / 2) && f < 0.0f) {
                float viewLeft = cellForumTestView.getViewLeft();
                Rect[] rectArr2 = this.s;
                int i3 = rectArr2[2].left;
                int i4 = this.l;
                cellForumTestView.setViewRight(((rectArr2[0].right - (i4 / 2)) - this.r) + (viewLeft - (i3 + (i4 / 2))));
                cellForumTestView.setViewLeft(cellForumTestView.getViewRight() - this.l);
                cellForumTestView.setViewTop(this.s[0].top);
                cellForumTestView.setViewBottom(this.s[0].bottom);
                cellForumTestView.setDataIndex(cellForumTestView.getDataIndex() - 3);
                R(cellForumTestView);
                cellForumTestView.setData(this.b.get(cellForumTestView.getDataIndex()));
            }
        }
        cellForumTestView.setViewLeft(cellForumTestView.getViewLeft() - f);
        cellForumTestView.setViewRight(cellForumTestView.getViewRight() - f);
        if (cellForumTestView.getViewLeft() <= this.s[1].left) {
            cellForumTestView.setViewTop(cellForumTestView.getViewTop() + f2);
            cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() - f2);
            float viewTop = cellForumTestView.getViewTop();
            Rect[] rectArr3 = this.s;
            if (viewTop > rectArr3[0].top) {
                cellForumTestView.setViewTop(rectArr3[0].top);
            }
            float viewBottom = cellForumTestView.getViewBottom();
            Rect[] rectArr4 = this.s;
            if (viewBottom < rectArr4[0].bottom) {
                cellForumTestView.setViewBottom(rectArr4[0].bottom);
            }
        } else if (cellForumTestView.getViewLeft() <= this.s[2].left) {
            cellForumTestView.setViewTop(cellForumTestView.getViewTop() - f2);
            cellForumTestView.setViewBottom(cellForumTestView.getViewBottom() + f2);
            float viewTop2 = cellForumTestView.getViewTop();
            Rect[] rectArr5 = this.s;
            if (viewTop2 < rectArr5[1].top) {
                cellForumTestView.setViewTop(rectArr5[1].top);
            }
            float viewBottom2 = cellForumTestView.getViewBottom();
            Rect[] rectArr6 = this.s;
            if (viewBottom2 > rectArr6[1].bottom) {
                cellForumTestView.setViewBottom(rectArr6[1].bottom);
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            CellForumTestView cellForumTestView = this.d;
            cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
            CellForumTestView cellForumTestView2 = this.e;
            cellForumTestView2.setIndex(cellForumTestView2.getIndex() + 1);
            CellForumTestView cellForumTestView3 = this.f;
            cellForumTestView3.setIndex(cellForumTestView3.getIndex() + 1);
            S(this.d);
            S(this.e);
            S(this.f);
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            CellForumTestView cellForumTestView = this.d;
            cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
            CellForumTestView cellForumTestView2 = this.e;
            cellForumTestView2.setIndex(cellForumTestView2.getIndex() - 1);
            CellForumTestView cellForumTestView3 = this.f;
            cellForumTestView3.setIndex(cellForumTestView3.getIndex() - 1);
            S(this.d);
            S(this.e);
            S(this.f);
        }
    }

    public final void Y(float f) {
        CellForumTestView I;
        float viewRight;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f) == null) {
            this.I = false;
            this.J = 0.0f;
            K();
            if (this.b.size() == 2) {
                CellForumTestView cellForumTestView = null;
                CellForumTestView cellForumTestView2 = this.d.getVisibility() == 0 ? this.d : null;
                if (this.e.getVisibility() == 0) {
                    if (cellForumTestView2 == null) {
                        cellForumTestView2 = this.e;
                    } else {
                        cellForumTestView = this.e;
                    }
                }
                if (this.f.getVisibility() == 0) {
                    cellForumTestView = this.f;
                }
                if (cellForumTestView2.getIndex() < cellForumTestView.getIndex()) {
                    f2 = cellForumTestView2.getViewLeft();
                    viewRight = cellForumTestView.getViewRight();
                } else {
                    float viewLeft = cellForumTestView.getViewLeft();
                    viewRight = cellForumTestView2.getViewRight();
                    f2 = viewLeft;
                }
                Rect[] rectArr = this.s;
                if (!(f2 < ((float) rectArr[0].left) || viewRight > ((float) rectArr[2].right)) && Math.abs(this.z) >= this.l * 0.2f) {
                    this.I = true;
                }
            } else if (this.b.size() > 2 && Math.abs(this.z) >= this.l * 0.2f) {
                this.I = true;
            }
            if (this.I && (I = I(1)) != null) {
                float f3 = this.z;
                int i = this.l;
                if (f3 >= i) {
                    this.z = f3 - i;
                    this.I = false;
                    X();
                } else if (f3 > 0.0f && f3 < i) {
                    this.z = this.s[0].right - I.getViewRight();
                } else if (this.z > (-this.l)) {
                    this.z = this.s[2].left - I.getViewLeft();
                } else {
                    W();
                    this.z += this.l;
                    this.I = false;
                }
            }
            this.y.setFloatValues(0.0f, this.z);
            this.y.start();
        }
    }

    @Override // com.repackage.m66
    public void a(int i) {
        CellForumTestView cellForumTestView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.g.setVisibility(0);
            this.g.setAlpha(1.0f);
            U();
            if (this.d.getIndex() == i && this.d.getVisibility() == 0) {
                cellForumTestView = this.d;
            } else if (this.e.getIndex() == i && this.e.getVisibility() == 0) {
                cellForumTestView = this.e;
            } else {
                cellForumTestView = this.f;
            }
            this.g.setData(cellForumTestView.getData());
            this.g.setDataIndex(cellForumTestView.getDataIndex());
            this.i = null;
            if (this.b.size() == 1) {
                this.D = 1;
                cellForumTestView.setVisibility(8);
                this.z = (this.l * 3) / 5;
            } else if (this.b.size() == 2) {
                this.D = 2;
                cellForumTestView.setVisibility(8);
                if (this.d.getVisibility() == 0) {
                    this.h = this.d;
                } else if (this.e.getVisibility() == 0) {
                    this.h = this.e;
                } else {
                    this.h = this.f;
                }
                if (this.h.getViewRight() < this.s[1].left) {
                    this.z = this.l + this.r;
                    CellForumTestView cellForumTestView2 = this.h;
                    cellForumTestView2.setIndex(cellForumTestView2.getIndex() + 1);
                    cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
                } else if (this.h.getViewLeft() > this.s[1].right) {
                    this.z = (-this.l) - this.r;
                    CellForumTestView cellForumTestView3 = this.h;
                    cellForumTestView3.setIndex(cellForumTestView3.getIndex() - 1);
                    cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
                }
                S(this.h);
                S(cellForumTestView);
            } else if (this.b.size() == 3) {
                this.D = 3;
                cellForumTestView.setVisibility(8);
                if (this.d.getIndex() == 2) {
                    this.h = this.d;
                } else if (this.e.getIndex() == 2) {
                    this.h = this.e;
                } else {
                    this.h = this.f;
                }
                this.z = (-this.l) - this.r;
                CellForumTestView cellForumTestView4 = this.h;
                cellForumTestView4.setIndex(cellForumTestView4.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() - 1);
                S(this.h);
                S(cellForumTestView);
            } else {
                this.D = 4;
                this.i = cellForumTestView;
                if (this.d.getIndex() == 2) {
                    this.h = this.d;
                } else if (this.e.getIndex() == 2) {
                    this.h = this.e;
                } else {
                    this.h = this.f;
                }
                this.z = (-this.l) - this.r;
                CellForumTestView cellForumTestView5 = this.h;
                cellForumTestView5.setIndex(cellForumTestView5.getIndex() - 1);
                cellForumTestView.setIndex(cellForumTestView.getIndex() + 1);
                S(this.h);
                S(cellForumTestView);
                this.i.setViewLeft(this.s[2].right + this.r);
                this.i.setViewRight(this.s[2].right + this.r + this.l);
                this.i.setViewTop(this.s[2].top);
                this.i.setViewBottom(this.s[2].bottom);
                this.i.setMoveLeft(this.s[2].right + this.r);
                this.i.setMoveRight(this.s[2].right + this.r + this.l);
                this.i.setMoveTop(this.s[2].top);
                this.i.setMoveBottom(this.s[2].bottom);
                CellForumTestView cellForumTestView6 = this.i;
                cellForumTestView6.setData(this.b.get(H(cellForumTestView6.getDataIndex() + 2)));
            }
            this.A.setFloatValues(0.0f, this.z);
            this.A.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) {
            getParent().requestDisallowInterceptTouchEvent(true);
            ValueAnimator valueAnimator2 = this.A;
            if ((valueAnimator2 == null || !valueAnimator2.isRunning()) && ((valueAnimator = this.y) == null || !valueAnimator.isRunning())) {
                int action = motionEvent.getAction();
                D(motionEvent);
                VelocityTracker velocityTracker = this.G;
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                int i = action & 255;
                if (i == 0) {
                    ValueAnimator valueAnimator3 = this.y;
                    if (valueAnimator3 != null) {
                        valueAnimator3.removeAllUpdateListeners();
                        this.y.cancel();
                    }
                    this.E = motionEvent.getPointerId(0);
                    this.t = x;
                    this.u = y;
                    this.v = x;
                } else if (i == 2) {
                    float f = this.t - x;
                    float f2 = this.u - y;
                    if (Math.abs(f) / (Math.abs(f2) + 1.0f) > 1.0f) {
                        this.B = true;
                        this.z = f;
                    } else if (Math.abs(f2) > 30.0f && !this.B) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    float f3 = this.v - x;
                    float f4 = this.w * f3;
                    if (this.B) {
                        V(this.d, f3, f4);
                        V(this.e, f3, f4);
                        V(this.f, f3, f4);
                        requestLayout();
                    }
                    this.v = x;
                } else if (i == 1 || i == 3) {
                    velocityTracker.computeCurrentVelocity(1000, this.F);
                    float xVelocity = velocityTracker.getXVelocity(this.E);
                    if (this.B || this.z != 0.0f) {
                        Y(xVelocity);
                    }
                    this.B = false;
                    P();
                }
                if (this.B || this.z != 0.0f || motionEvent.getPointerCount() >= 2) {
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
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onAttachedToWindow();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.l, 0.0f);
            this.A = ofFloat;
            ofFloat.setDuration(500L);
            this.A.setInterpolator(new DecelerateInterpolator());
            this.A.addUpdateListener(new a(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!this.B && this.z == 0.0f) {
                ValueAnimator valueAnimator = this.y;
                if (valueAnimator != null) {
                    valueAnimator.removeAllUpdateListeners();
                    this.y.cancel();
                }
                ValueAnimator valueAnimator2 = this.A;
                if (valueAnimator2 != null) {
                    valueAnimator2.removeAllUpdateListeners();
                    this.A.cancel();
                }
            }
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (getVisibility() == 0) {
                CellForumTestView cellForumTestView = this.d;
                cellForumTestView.layout((int) cellForumTestView.getViewLeft(), (int) this.d.getViewTop(), (int) this.d.getViewRight(), (int) this.d.getViewBottom());
                CellForumTestView cellForumTestView2 = this.e;
                cellForumTestView2.layout((int) cellForumTestView2.getViewLeft(), (int) this.e.getViewTop(), (int) this.e.getViewRight(), (int) this.e.getViewBottom());
                CellForumTestView cellForumTestView3 = this.f;
                cellForumTestView3.layout((int) cellForumTestView3.getViewLeft(), (int) this.f.getViewTop(), (int) this.f.getViewRight(), (int) this.f.getViewBottom());
                CellForumTestView cellForumTestView4 = this.g;
                cellForumTestView4.layout((int) cellForumTestView4.getViewLeft(), (int) this.g.getViewTop(), (int) this.g.getViewRight(), (int) this.g.getViewBottom());
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i, i2) == null) {
            if (getVisibility() == 0) {
                int k = oi.k(getContext());
                if (k != this.K) {
                    this.K = k;
                    F(getContext());
                    T(this.d);
                    T(this.e);
                    T(this.f);
                    T(this.g);
                }
                L(this.d);
                L(this.e);
                L(this.f);
                L(this.g);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.j, 1073741824), View.MeasureSpec.makeMeasureSpec(this.k, 1073741824));
                return;
            }
            super.onMeasure(i, i2);
        }
    }

    public void setData(List<l66> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, list) == null) || ListUtils.isEmpty(list) || this.B || this.z != 0.0f) {
            return;
        }
        this.b = list;
        Q();
        int i = 1;
        if (ListUtils.getCount(list) > 2) {
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.d.setData(list.get(0));
            this.e.setData(list.get(1));
            this.f.setData(list.get(2));
            this.d.setDataIndex(0);
            this.e.setDataIndex(1);
            this.f.setDataIndex(2);
        } else if (ListUtils.getCount(list) == 2) {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.f.setVisibility(0);
            this.e.setDataIndex(1);
            this.f.setDataIndex(0);
            this.e.setData(list.get(1));
            this.f.setData(list.get(0));
        } else {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.f.setVisibility(8);
            this.e.setDataIndex(0);
            this.e.setData(list.get(0));
            i = 0;
        }
        E(i);
    }

    public void setOnSecectedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) {
            this.H = cVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
            CellForumTestView cellForumTestView = this.d;
            if (cellForumTestView != null) {
                cellForumTestView.setPageId(bdUniqueId);
            }
            CellForumTestView cellForumTestView2 = this.e;
            if (cellForumTestView2 != null) {
                cellForumTestView2.setPageId(bdUniqueId);
            }
            CellForumTestView cellForumTestView3 = this.f;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.s = new Rect[3];
        this.B = false;
        this.I = false;
        this.J = 0.0f;
        this.K = 0;
        J(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.s = new Rect[3];
        this.B = false;
        this.I = false;
        this.J = 0.0f;
        this.K = 0;
        J(context);
    }
}
