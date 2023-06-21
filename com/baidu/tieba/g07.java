package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.home.EnterForumDelegateStatic;
import com.baidu.tieba.enterForum.home.EnterForumFragment;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.enterForum.view.EnterForumAdView;
import com.baidu.tieba.kz6;
import com.baidu.tieba.l07;
import com.baidu.tieba.ln;
import com.baidu.tieba.nf;
import com.baidu.tieba.view.CommonTipView;
import com.baidu.tieba.view.GuidePopupWindow;
import com.baidu.tieba.x95;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class g07 implements EnterForumAdView.c {
    public static /* synthetic */ Interceptable $ic;
    public static boolean R;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public x95.g B;
    public x95.g C;
    public AbsListView.OnScrollListener D;
    public View.OnClickListener E;
    public int F;
    public int G;
    public CustomMessageListener H;
    public kz6.b I;
    public boolean J;
    public boolean K;
    public Runnable L;
    public View M;
    public float N;
    public ImageView O;
    public boolean P;
    public boolean Q;
    public Context a;
    public final EnterForumFragment b;
    public y95 c;
    public BdListView d;
    public yx6 e;
    public List<hy6> f;
    public z35 g;
    public ViewEventCenter h;
    public CommonTipView i;
    public View j;
    public an5 k;
    public View l;
    public EnterForumAdView m;
    public View n;
    public GuidePopupWindow o;
    public mf p;
    public int q;
    public l07 r;
    public ey6 s;
    public boolean t;
    public kz6 u;
    public PbListView v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947740187, "Lcom/baidu/tieba/g07;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947740187, "Lcom/baidu/tieba/g07;");
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            /* renamed from: com.baidu.tieba.g07$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class RunnableC0303a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0303a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                        return;
                    }
                    this.a.a.a.P = false;
                }
            }

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ViewGroup viewGroup = (ViewGroup) this.a.a.M.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.a.a.M);
                        viewGroup.removeView(this.a.a.O);
                    }
                    this.a.a.O.setVisibility(0);
                    this.a.a.P = false;
                    this.a.a.r0();
                    this.a.a.G = 0;
                    this.a.a.w0(0);
                    this.a.a.P = true;
                    this.a.a.c.z();
                    this.a.a.d.y();
                    this.a.a.c.C(0, -this.a.a.c.p(), 0, 0);
                    xg.a().postDelayed(new RunnableC0303a(this), 0L);
                    this.a.a.d.setVisibility(0);
                }
            }
        }

        public n(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                xg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements x95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        /* renamed from: com.baidu.tieba.g07$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0302a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0302a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.d.setSelection(0);
                }
            }
        }

        public a(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // com.baidu.tieba.x95.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || this.a.P) {
                return;
            }
            dy9.g().j(this.a.b.getUniqueId());
            if (this.a.B != null) {
                this.a.A = false;
                this.a.B.f(z);
            }
            if (!z) {
                return;
            }
            g07 g07Var = this.a;
            if (!g07Var.J && g07Var.s != null && this.a.s.a) {
                if (this.a.s.b > 0) {
                    this.a.d.D(0, 0, 0);
                    this.a.p0();
                    return;
                }
                xg.a().post(new RunnableC0302a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public b(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.V();
                this.a.G0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements lf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        @Override // com.baidu.tieba.lf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.lf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 16;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.lf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.lf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public c(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // com.baidu.tieba.lf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = layoutInflater.inflate(R.layout.tips_blue_left_up, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0924ab)).setText(this.a.q);
                this.a.b.getPageContext().getLayoutMode().k(inflate);
                return inflate;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements nf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.nf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.nf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public e(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p != null) {
                this.a.p.d();
                this.a.p = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public f(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                EnterForumAdView.c(this.a.b.getPageContext().getUniqueId(), this.a.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final /* synthetic */ g07 b;

        public g(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g07Var;
            this.a = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (this.b.N <= (this.b.a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.b.N) {
                                this.b.o0();
                            } else {
                                this.b.j0();
                            }
                            this.b.N = 0.0f;
                            this.a = 0.0f;
                        } else {
                            if (motionEvent.getRawY() < this.b.N) {
                                this.b.s0(motionEvent.getRawY() - this.b.N);
                                if (this.b.O != null) {
                                    this.b.O.setVisibility(8);
                                }
                            }
                            if (Math.abs(motionEvent.getRawY() - this.b.N) > this.a) {
                                this.a = Math.abs(motionEvent.getRawY() - this.b.N);
                            }
                        }
                    } else {
                        if (this.b.N <= (this.b.a.getResources().getDisplayMetrics().heightPixels * 2) / 3 || motionEvent.getRawY() >= this.b.N) {
                            this.b.o0();
                            if (this.a < 50.0f) {
                                this.b.M.performClick();
                            }
                        } else {
                            this.b.j0();
                        }
                        this.b.N = 0.0f;
                        this.a = 0.0f;
                    }
                } else {
                    this.b.N = motionEvent.getRawY();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public h(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.j0();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ g07 b;

        public i(g07 g07Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g07Var;
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup viewGroup;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.b.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.b.m.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        this.b.O();
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        marginLayoutParams.setMargins(0, intValue, 0, 0);
                        this.b.m.setLayoutParams(marginLayoutParams);
                        if (intValue / this.a < 0.2d) {
                            if (this.b.m.getParent() != this.b.m.getRootView() && (viewGroup = (ViewGroup) this.b.m.getRootView()) != null) {
                                ((ViewGroup) this.b.m.getParent()).removeView(this.b.m);
                                if (this.b.m.getParent() == null) {
                                    ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                    marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                    viewGroup.addView(this.b.m, marginLayoutParams2);
                                }
                                viewGroup.bringChildToFront(this.b.M);
                                viewGroup.bringChildToFront(this.b.O);
                            }
                        } else if (this.b.m.getParent() == this.b.m.getRootView()) {
                            if (this.b.m.getParent() != null) {
                                ViewGroup viewGroup2 = (ViewGroup) this.b.m.getRootView();
                                ((ViewGroup) this.b.m.getParent()).removeView(this.b.m);
                            }
                            if (this.b.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                                this.b.b.J1().addView(this.b.m, 0, marginLayoutParams3);
                            }
                        }
                    }
                }
                this.b.P = false;
                this.b.w0(((intValue - this.a) * 2) + 0);
                this.b.P = true;
                float abs = Math.abs(intValue / this.a);
                this.b.d.setAlpha(abs);
                View P = this.b.b.L1().P();
                if (P != null) {
                    P.setAlpha(abs);
                }
                View findViewById = this.b.b.J1().getRootView().findViewById(R.id.tabcontainer_wrapper);
                if (findViewById != null) {
                    findViewById.setAlpha(abs);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ View b;
        public final /* synthetic */ g07 c;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public j(g07 g07Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var, Integer.valueOf(i), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g07Var;
            this.a = i;
            this.b = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.c.m != null) {
                    ViewGroup.LayoutParams layoutParams = this.c.m.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        this.c.O();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(0, 0, 0, 0);
                        this.c.m.setLayoutParams(layoutParams2);
                    }
                }
                this.c.c.z();
                this.c.d.y();
                this.c.c.C(0, -this.c.c.p(), 0, 0);
                this.c.P = false;
                this.c.w0(0 - (this.a * 2));
                this.c.P = true;
                this.c.d.setVisibility(8);
                this.c.M.setEnabled(true);
                FrameLayout frameLayout = (FrameLayout) this.b;
                if (this.c.M.getParent() == null) {
                    frameLayout.addView(this.c.M, new FrameLayout.LayoutParams(-1, -1));
                }
                if (this.c.O.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.bottomMargin = this.c.a.getResources().getDimensionPixelOffset(R.dimen.tbds107);
                    layoutParams3.gravity = 81;
                    frameLayout.addView(this.c.O, layoutParams3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public k(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.s0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public l(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.s0(0.0f);
            this.a.c.z();
            this.a.d.y();
            this.a.c.C(0, -this.a.c.p(), 0, 0);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public m(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.s0(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ g07 b;

        public o(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g07Var;
            this.a = -1;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                if (this.b.b.isPrimary() && this.a != 1 && i == 0) {
                    for (int i4 = i; i4 < i + i2; i4++) {
                        Object itemAtPosition = this.b.d.getItemAtPosition(i4);
                        if (itemAtPosition != null && (itemAtPosition instanceof h25)) {
                            h25 h25Var = (h25) itemAtPosition;
                            if (h25Var.c() == 1 && this.b.d.getItemAtPosition(i4) == ListUtils.getItem(this.b.f, 0)) {
                                this.b.D0(h25Var, this.b.d.getChildAt(i4).findViewById(R.id.obfuscated_res_0x7f090bbd));
                            }
                        }
                    }
                }
                this.b.r.onScroll(absListView, i, i2, i3);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                this.b.r.onScrollStateChanged(absListView, i);
                if (this.a != i) {
                    this.a = i;
                    if (i != 1) {
                        this.b.K();
                        return;
                    }
                    if (this.b.s == null || !this.b.s.a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
                    }
                    this.b.U();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public p(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.s != null && this.a.s.a) {
                g07 g07Var = this.a;
                if (g07Var.J) {
                    EnterForumAdView unused = g07Var.m;
                    EnterForumAdView.c(this.a.b.getUniqueId(), this.a.b.getContext());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(g07 g07Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.C0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements kz6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public r(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // com.baidu.tieba.kz6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                g07 g07Var = this.a;
                if (g07Var.z && !g07Var.A) {
                    if (this.a.e != null && !ListUtils.isEmpty(this.a.e.f()) && this.a.u.e() != null && !ListUtils.isEmpty(this.a.u.e().a())) {
                        ArrayList arrayList = new ArrayList(this.a.e.f());
                        arrayList.add(this.a.R());
                        arrayList.addAll(this.a.u.e().a());
                        this.a.e.l(arrayList, false);
                        this.a.A = true;
                    }
                } else if (!z && this.a.e != null && !ListUtils.isEmpty(this.a.e.f())) {
                    ArrayList arrayList2 = new ArrayList(this.a.e.f());
                    arrayList2.addAll(this.a.u.e().a());
                    this.a.e.l(arrayList2, false);
                    this.a.d.setNextPage(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements l07.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public s(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // com.baidu.tieba.l07.c
        public void a(AbsListView absListView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLII(1048576, this, absListView, i, i2) != null) || this.a.P) {
                return;
            }
            this.a.F = -i;
            g07 g07Var = this.a;
            if (g07Var.J) {
                g07Var.k0();
            } else if (g07Var.s != null && this.a.s.a) {
                this.a.r0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public t(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void C(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bdListView) != null) {
                return;
            }
            this.a.E0();
            if (this.a.u != null) {
                this.a.u.i();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements ln.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public u(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // com.baidu.tieba.ln.a
        public void a(ln lnVar, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{lnVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) {
                return;
            }
            this.a.G = i3;
            g07 g07Var = this.a;
            if (!g07Var.J && g07Var.s != null && this.a.s.a && !this.a.P) {
                this.a.r0();
                if (i3 <= this.a.y) {
                    return;
                }
                this.a.G = 0;
                g07 g07Var2 = this.a;
                g07Var2.B0(g07Var2.b.L1().N());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g07 a;

        public v(g07 g07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g07Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k0();
            }
        }
    }

    public g07(EnterForumFragment enterForumFragment, View view2, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumFragment, view2, viewEventCenter, recentlyVisitedForumModel, enterForumModel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = true;
        this.z = false;
        this.A = false;
        this.C = new a(this);
        this.D = new o(this);
        this.E = new p(this);
        this.F = 0;
        this.G = 0;
        this.H = new q(this, 2921474);
        this.I = new r(this);
        this.J = false;
        this.K = false;
        this.L = new v(this);
        this.P = false;
        this.b = enterForumFragment;
        this.w = (UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0) + wi.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds238);
        this.x = wi.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds114);
        this.y = wi.g(enterForumFragment.getPageContext().getPageActivity(), R.dimen.tbds300);
        this.h = viewEventCenter;
        Y(view2);
        yx6 yx6Var = new yx6(this.b.getPageContext(), this.h, recentlyVisitedForumModel, enterForumModel, this);
        this.e = yx6Var;
        this.d.setAdapter((ListAdapter) yx6Var);
        if (enterForumFragment != null) {
            PbListView pbListView = new PbListView(enterForumFragment.getContext());
            this.v = pbListView;
            pbListView.a();
            this.v.w(wi.g(this.a, R.dimen.tbds589));
        }
        d0(TbadkCoreApplication.getInst().getSkinType());
        m0();
        this.o = new GuidePopupWindow(this.b.getFragmentActivity());
    }

    public void A0(kz6 kz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kz6Var) == null) {
            this.u = kz6Var;
            kz6Var.l(this.I);
        }
    }

    public void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.e.j(i2);
        }
    }

    public void v0(x95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, gVar) == null) {
            this.B = gVar;
        }
    }

    public void x0(BdUniqueId bdUniqueId) {
        yx6 yx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, bdUniqueId) == null) && (yx6Var = this.e) != null) {
            yx6Var.m(bdUniqueId);
        }
    }

    public void y0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048624, this, z) == null) && (enterForumAdView = this.m) != null) {
            enterForumAdView.setRecentlyIsExtend(z);
        }
    }

    public void z0(boolean z) {
        EnterForumAdView enterForumAdView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z) == null) && (enterForumAdView = this.m) != null) {
            enterForumAdView.setRecentlyIsShow(z);
        }
    }

    public void n0(hy6 hy6Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048612, this, hy6Var, z) == null) {
            this.f.remove(hy6Var);
            l0(this.f, this.g, z);
            c0(z);
        }
    }

    public void B0(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) != null) || !(view2 instanceof FrameLayout) || this.P) {
            return;
        }
        this.c.v();
        this.P = true;
        this.m.getAdImageView().getLocationInWindow(new int[2]);
        SkinManager.setImageResource(this.O, R.drawable.icon_jinba_retract_n);
        int P = P();
        ValueAnimator ofInt = ValueAnimator.ofInt(P, 0);
        ofInt.addUpdateListener(new i(this, P));
        ofInt.addListener(new j(this, P, view2));
        ofInt.setDuration(300L);
        ofInt.start();
        this.m.requestFocus();
        this.m.requestFocusFromTouch();
    }

    public void F0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (this.k == null) {
                this.k = new an5(this.b.getPageContext().getContext(), new b(this));
            }
            this.l = view2;
            this.k.k(this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703c3));
            this.k.attachView(view2, false);
            this.k.p();
            this.d.setVisibility(8);
            if (this.b.L1() != null) {
                this.b.L1().Z();
                this.b.L1().c0();
            }
        }
    }

    public void q0(ey6 ey6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, ey6Var) == null) {
            this.s = ey6Var;
            yx6 yx6Var = this.e;
            if (yx6Var != null) {
                yx6Var.k(ey6Var);
            }
            if (ey6Var != null && ey6Var.a) {
                if (this.c.getView() != null) {
                    this.c.getView().setScaleX(0.5f);
                    this.c.getView().setScaleY(0.5f);
                }
                this.c.Q(R.raw.ad_refresh_load);
                return;
            }
            if (this.c.getView() != null) {
                this.c.getView().setScaleX(1.0f);
                this.c.getView().setScaleY(1.0f);
            }
            this.c.Q(R.raw.lottie_common_pull_refresh);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !a0() || !this.Q) {
            return;
        }
        this.o.s();
        this.o.v();
        this.o.setCancelable(false);
        o95.p().A("has_guide_popup_window_been_shown", true);
        zg.i(this.o, this.b.getFragmentActivity());
    }

    public final void E0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (pbListView = this.v) != null) {
            if (pbListView.c().getParent() == null) {
                this.d.setNextPage(this.v);
            }
            this.v.w(wi.g(this.a, R.dimen.tbds400));
            this.v.U();
        }
    }

    public final gy6 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            gy6 gy6Var = new gy6(this.a.getResources().getString(R.string.recommend_hot_forum_title), false, true);
            gy6Var.g = R.dimen.M_W_X004;
            gy6Var.h = R.dimen.tbds112;
            gy6Var.j = R.dimen.M_W_X005;
            gy6Var.i = R.dimen.T_X07;
            return gy6Var;
        }
        return (gy6) invokeV.objValue;
    }

    public final int S() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = 0;
            if (EnterForumDelegateStatic.e.Z() != null) {
                z = true;
            } else {
                z = false;
            }
            int i3 = this.w - this.x;
            if (z) {
                i2 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds25);
            }
            return i3 - i2;
        }
        return invokeV.intValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            an5 an5Var = this.k;
            if (an5Var != null) {
                an5Var.dettachView(this.l);
                this.k = null;
                this.l = null;
            }
            this.d.setVisibility(0);
            if (this.b.L1() != null) {
                this.b.L1().Z();
                this.b.L1().c0();
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            View view2 = new View(this.a);
            this.M = view2;
            view2.setOnClickListener(new f(this));
            this.M.setOnTouchListener(new g(this));
            ImageView imageView = new ImageView(this.a);
            this.O = imageView;
            imageView.setOnClickListener(new h(this));
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            ImageView imageView = this.O;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(P(), 0);
            ofInt.addUpdateListener(new k(this));
            ofInt.addListener(new l(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public void D0(h25 h25Var, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, h25Var, view2) != null) || !TbadkCoreApplication.isLogin() || R || this.b.getActivity() == null || this.b.getPageContext() == null || !(h25Var instanceof hy6)) {
            return;
        }
        hy6 hy6Var = (hy6) h25Var;
        if (hy6Var.u() != 0 && hy6Var.s() != 0 && !o95.p().w("enter_forum_new_forum_long_press_guide", "").equals(hy6Var.getId())) {
            this.q = R.string.obfuscated_res_0x7f0f0503;
        } else if (o95.p().r("enter_forum_long_press_guide", 0L) != 0) {
            return;
        } else {
            this.q = R.string.obfuscated_res_0x7f0f0791;
        }
        if (view2 != null) {
            R = true;
            nf nfVar = new nf();
            nfVar.k(view2);
            nfVar.c(0);
            nfVar.j(true);
            nfVar.i(false);
            nfVar.d(true);
            nfVar.a(new c(this));
            nfVar.h(new d(this));
            mf b2 = nfVar.b();
            this.p = b2;
            b2.k(false);
            this.p.l(true);
            this.p.m(this.b.getActivity());
            int i2 = this.q;
            if (i2 == R.string.obfuscated_res_0x7f0f0503) {
                o95.p().J("enter_forum_new_forum_long_press_guide", hy6Var.getId());
            } else if (i2 == R.string.obfuscated_res_0x7f0f0791) {
                o95.p().H("enter_forum_long_press_guide", 1L);
            }
            xg.a().postDelayed(new e(this), 5000L);
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.E();
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            yx6 yx6Var = this.e;
            if (yx6Var == null) {
                return false;
            }
            return yx6Var.e();
        }
        return invokeV.booleanValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.J) {
                this.K = true;
                return;
            }
            this.K = false;
            this.d.z(0L);
        }
    }

    public final int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int O = O();
            if (this.J) {
                return -this.a.getResources().getDimensionPixelOffset(R.dimen.tbds589);
            }
            return (this.F + this.G) - O;
        }
        return invokeV.intValue;
    }

    public final int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.getResources().getDimensionPixelOffset(R.dimen.tbds934);
        }
        return invokeV.intValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public BdListView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.d;
        }
        return (BdListView) invokeV.objValue;
    }

    public an5 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.k;
        }
        return (an5) invokeV.objValue;
    }

    public void U() {
        mf mfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (mfVar = this.p) != null) {
            mfVar.d();
            this.p = null;
        }
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (ListUtils.isEmpty(this.f)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (!TbadkCoreApplication.isLogin() || o95.p().l("has_guide_popup_window_been_shown", false)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            BdListView bdListView = this.d;
            if (bdListView == null || bdListView.getChildCount() == 0 || this.d.getChildAt(0).getTop() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            CommonTipView commonTipView = this.i;
            if (commonTipView != null) {
                commonTipView.i();
            }
            yx6 yx6Var = this.e;
            if (yx6Var != null) {
                yx6Var.h();
            }
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            U();
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.J = false;
            r0();
            w0(0);
            if (this.K) {
                this.d.z(0L);
            }
            this.K = false;
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.b.registerListener(this.H);
        }
    }

    @Override // com.baidu.tieba.enterForum.view.EnterForumAdView.c
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.P) {
            j0();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (b0()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
                return;
            }
            ey6 ey6Var = this.s;
            if (ey6Var != null && ey6Var.a) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.FALSE));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.TRUE));
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.b.isAdded() && this.b.isPrimary()) {
                R = false;
                yx6 yx6Var = this.e;
                if (yx6Var != null) {
                    yx6Var.i();
                    BdListView bdListView = this.d;
                    if (bdListView != null) {
                        Object itemAtPosition = this.d.getItemAtPosition(bdListView.getLastVisiblePosition());
                        if (itemAtPosition != null && (itemAtPosition instanceof h25) && ((h25) itemAtPosition).c() == 5) {
                            this.e.n();
                        }
                    }
                }
                if (this.P) {
                    this.m.requestFocus();
                    this.m.requestFocusFromTouch();
                    return;
                }
                return;
            }
            U();
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.M.setEnabled(false);
            int N = N();
            Math.abs(N / (S() - N));
            this.O.setVisibility(8);
            int i2 = ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin;
            ValueAnimator ofInt = ValueAnimator.ofInt(P(), N);
            ofInt.addUpdateListener(new m(this));
            ofInt.addListener(new n(this));
            ofInt.setDuration(300L);
            ofInt.start();
        }
    }

    public final void r0() {
        EnterForumAdView enterForumAdView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && !this.P && (enterForumAdView = this.m) != null) {
            ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                int O = O();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.J) {
                    i2 = -this.a.getResources().getDimensionPixelOffset(R.dimen.tbds589);
                } else {
                    i2 = (this.F + this.G) - O;
                }
                layoutParams2.setMargins(0, i2, 0, 0);
                this.m.setLayoutParams(layoutParams2);
                this.m.setAdViewHeight(layoutParams2.height - O);
            }
        }
    }

    public void X(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            EnterForumAdView enterForumAdView = (EnterForumAdView) view2.getRootView().findViewById(R.id.obfuscated_res_0x7f0909f8);
            this.m = enterForumAdView;
            if (enterForumAdView != null) {
                r0();
                this.m.setTag(this.b.getUniqueId());
                this.m.setAdData();
                this.m.setEventCenter(this.h);
                this.m.setOnBackPressedListener(this);
            }
        }
    }

    public final void w0(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048622, this, i2) != null) || this.P) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
        int i3 = 0;
        if (EnterForumDelegateStatic.e.Z() != null) {
            z = true;
        } else {
            z = false;
        }
        int i4 = (i2 + this.w) - this.x;
        if (z) {
            i3 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds25);
        }
        marginLayoutParams.topMargin = i4 - i3;
        this.d.setLayoutParams(marginLayoutParams);
    }

    public final void Y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            this.a = view2.getContext();
            l07 l07Var = new l07();
            this.r = l07Var;
            l07Var.a(new s(this));
            this.d = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f09150d);
            w0(0);
            this.d.setBackgroundColor(0);
            this.d.setVerticalScrollBarEnabled(false);
            this.d.setOnScrollListener(this.D);
            this.d.setExOnSrollToBottomListener(new t(this));
            this.d.setFastScrollEnabled(false);
            this.d.setMaxHeight(this.a.getResources().getDisplayMetrics().heightPixels);
            BdListView.C(1.0f);
            if (this.b.L1() != null) {
                this.b.L1().f0(this);
            }
            y95 y95Var = new y95(this.b.getPageContext());
            this.c = y95Var;
            y95Var.B(new u(this));
            this.c.Z(true);
            this.c.f(this.C);
            y95 y95Var2 = this.c;
            if (y95Var2 != null) {
                y95Var2.a0(this.b.getUniqueId());
            }
            this.d.setPullRefresh(this.c);
            FrameLayout frameLayout = new FrameLayout(this.b.getPageContext().getPageActivity());
            View view3 = new View(this.b.getPageContext().getPageActivity());
            this.n = view3;
            frameLayout.addView(view3, new FrameLayout.LayoutParams(-1, this.x));
            this.d.getAdapter2().e(frameLayout, 0);
            this.j = new View(this.b.getActivity());
            this.j.setLayoutParams(new AbsListView.LayoutParams(-1, wi.g(this.b.getActivity(), R.dimen.obfuscated_res_0x7f0703e6)));
            this.j.setBackgroundResource(R.color.CAM_X0201);
            this.c.S(this.E);
            this.c.getView().setOnClickListener(this.E);
            this.n.setOnClickListener(this.E);
            W();
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.e.notifyDataSetChanged();
            View view2 = this.j;
            if (view2 != null && view2.getLayoutParams() != null) {
                if (z) {
                    this.j.getLayoutParams().height = wi.g(this.a, R.dimen.obfuscated_res_0x7f0703e6);
                    return;
                }
                this.j.getLayoutParams().height = wi.g(this.a, R.dimen.obfuscated_res_0x7f0703e6) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            }
        }
    }

    public void d0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 2 && TbadkCoreApplication.isLogin()) {
                this.d.removeFooterView(this.j);
            }
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.d.removeFooterView(this.j);
            }
            yx6 yx6Var = this.e;
            if (yx6Var != null) {
                yx6Var.g(i2);
            }
            y95 y95Var = this.c;
            if (y95Var != null) {
                y95Var.H(i2);
            }
            an5 an5Var = this.k;
            if (an5Var != null) {
                an5Var.onChangeSkinType();
            }
            GuidePopupWindow guidePopupWindow = this.o;
            if (guidePopupWindow != null) {
                guidePopupWindow.j();
            }
            SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
        }
    }

    public void t0(oy6 oy6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, oy6Var) != null) || oy6Var == null) {
            return;
        }
        if (StringUtils.isNull(oy6Var.d())) {
            this.Q = false;
        } else {
            this.Q = true;
        }
        this.o.q(oy6Var.c());
        this.o.r(oy6Var.b(), oy6Var.e());
        this.o.n(oy6Var.a());
        this.o.x(oy6Var.d());
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && this.t != z) {
            this.t = z;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.d.getLayoutParams();
            if (!z) {
                marginLayoutParams.topMargin += this.d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            } else {
                marginLayoutParams.topMargin -= this.d.getResources().getDimensionPixelOffset(R.dimen.tbds105);
            }
            this.d.setLayoutParams(marginLayoutParams);
        }
    }

    public void i0() {
        EnterForumFragment enterForumFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && TbadkCoreApplication.getCurrentAccount() == null && o95.p().l("enter_forum_login_tip", true) && (enterForumFragment = this.b) != null && enterForumFragment.getActivity() != null && this.b.K1() != null) {
            if (this.i == null) {
                this.i = new CommonTipView(this.b.getActivity());
            }
            this.i.setText(R.string.obfuscated_res_0x7f0f065a);
            this.i.k(this.b.K1(), TbadkCoreApplication.getInst().getSkinType());
            o95.p().A("enter_forum_login_tip", false);
        }
    }

    public void p0() {
        int dimensionPixelSize;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || this.P) {
            return;
        }
        this.J = true;
        r0();
        int dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds466) - this.c.p();
        EnterForumAdView enterForumAdView = this.m;
        if (enterForumAdView != null) {
            if (!enterForumAdView.f()) {
                dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds370) + this.a.getResources().getDimensionPixelSize(R.dimen.tbds134);
            } else if (!this.m.e()) {
                dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.tbds370);
            }
            dimensionPixelOffset += dimensionPixelSize;
        }
        w0(dimensionPixelOffset);
        xg.a().removeCallbacks(this.L);
        xg.a().postDelayed(this.L, 3000L);
    }

    public void l0(List<hy6> list, z35 z35Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048610, this, list, z35Var, z) == null) {
            this.m.setAdData();
            EnterForumDelegateStatic.e.b0(this.a);
            this.f = list;
            this.g = z35Var;
            ArrayList arrayList = new ArrayList();
            boolean z2 = !ListUtils.isEmpty(list);
            boolean z3 = !ListUtils.isEmpty(list);
            if (!TbadkCoreApplication.isLogin()) {
                cy6 cy6Var = new cy6();
                cy6Var.setTitle(this.a.getResources().getString(R.string.my_forum_sort_it));
                cy6Var.e();
                arrayList.add(cy6Var);
            } else {
                h25 h25Var = new h25();
                h25Var.d(4);
                arrayList.add(h25Var);
                if (z3) {
                    gy6 gy6Var = new gy6(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0cee), z2, false);
                    iy6 iy6Var = new iy6();
                    iy6Var.d = gy6Var;
                    iy6Var.e = list;
                    arrayList.add(iy6Var);
                }
            }
            kz6 kz6Var = this.u;
            if (kz6Var != null && kz6Var.g() && this.u.e() != null) {
                this.A = true;
                arrayList.add(R());
                arrayList.addAll(this.u.e().a());
            } else {
                this.A = false;
            }
            V();
            this.e.l(arrayList, z);
        }
    }

    public final void s0(float f2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048618, this, f2) == null) {
            int N = N();
            int S = S() - N;
            float f3 = N;
            float abs = Math.abs(f3 / S);
            int i2 = (int) f2;
            EnterForumAdView enterForumAdView = this.m;
            if (enterForumAdView != null) {
                ViewGroup.LayoutParams layoutParams = enterForumAdView.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    O();
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.setMargins(0, i2, 0, 0);
                    this.m.setLayoutParams(marginLayoutParams);
                    if (Math.abs(marginLayoutParams.topMargin) < marginLayoutParams.height * 0.2d) {
                        if (this.m.getParent() != this.m.getRootView() && (viewGroup = (ViewGroup) this.m.getRootView()) != null) {
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                            if (this.m.getParent() == null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                                marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
                                viewGroup.addView(this.m, marginLayoutParams2);
                            }
                            viewGroup.bringChildToFront(this.M);
                            viewGroup.bringChildToFront(this.O);
                        }
                    } else if (this.m.getParent() == this.m.getRootView()) {
                        if (this.m.getParent() != null) {
                            ViewGroup viewGroup2 = (ViewGroup) this.m.getRootView();
                            ((ViewGroup) this.m.getParent()).removeView(this.m);
                        }
                        if (this.m.getParent() == null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(marginLayoutParams.width, marginLayoutParams.height);
                            marginLayoutParams3.topMargin = marginLayoutParams.topMargin;
                            this.b.J1().addView(this.m, 0, marginLayoutParams3);
                        }
                    }
                }
            }
            this.d.setVisibility(0);
            this.P = false;
            float f4 = i2;
            w0(((int) ((f4 * abs) - (abs * f3))) * 2);
            this.P = true;
            float abs2 = Math.abs(f4 / f3);
            this.d.setAlpha(abs2);
            View P = this.b.L1().P();
            if (P != null) {
                P.setAlpha(abs2);
            }
            View findViewById = this.b.J1().getRootView().findViewById(R.id.tabcontainer_wrapper);
            if (findViewById != null) {
                findViewById.setAlpha(abs2);
            }
        }
    }
}
