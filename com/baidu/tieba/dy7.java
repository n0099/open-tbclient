package com.baidu.tieba;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.aa5;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoTitleBar;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.vw6;
import com.baidu.tieba.wz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class dy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public BdUniqueId B;
    public vw6 C;
    public NEGFeedBackView.b D;
    public ex7 E;
    public aa5.h F;
    public aa5.f G;
    public CustomMessageListener H;
    public View.OnTouchListener I;
    public vw6.b J;
    public CustomMessageListener K;
    public RecyclerView.RecyclerListener L;
    public RecyclerView.OnScrollListener M;
    public BaseFragment a;
    public TbPageContext b;
    public View c;
    public BdTypeRecyclerView d;
    public BigdaySwipeRefreshLayout e;
    public h18 f;
    public PbListView g;
    public dn5 h;
    public ImageView i;
    public TextView j;
    public px7 k;
    public View l;
    public FrameLayout m;
    public en5 n;
    public GameVideoTitleBar o;
    public AlphaAnimation p;
    public AlphaAnimation q;
    public boolean r;
    public RotateAnimation s;
    public RotateAnimation t;
    public boolean u;
    public boolean v;
    public io9 w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.k.c();
                    this.a.a.I();
                    if (!this.a.a.z && this.a.a.A) {
                        this.a.a.w.n(this.a.a.x, this.a.a.y, this.a.a.v, true);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(dy7 dy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var, Integer.valueOf(i)};
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
            this.a = dy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                yg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public a(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.a.i != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.i, R.drawable.obfuscated_res_0x7f080b56, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                this.a.u = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public b(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.a.i != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.i, R.drawable.obfuscated_res_0x7f080b56, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
                this.a.u = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements aa5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        public c(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        @Override // com.baidu.tieba.aa5.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.o0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements aa5.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        public d(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        @Override // com.baidu.tieba.aa5.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.Z(true);
                if (this.a.w != null && !this.a.z && this.a.A) {
                    this.a.w.n(this.a.x, this.a.y, this.a.v, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        public f(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.C != null) {
                    this.a.C.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements vw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        @Override // com.baidu.tieba.vw6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.vw6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public g(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        @Override // com.baidu.tieba.vw6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.a.v = false;
        }

        @Override // com.baidu.tieba.vw6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) != null) {
                return;
            }
            this.a.v = true;
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(dy7 dy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var, Integer.valueOf(i)};
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
            this.a = dy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder w;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (w = this.a.w()) != null && w.a() != null) {
                    w.a().p(new wz.a(3));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        public i(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, viewHolder) != null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.w != null) {
                this.a.w.k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).a().stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        public j(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.a.x = i;
            this.a.y = (i + i2) - 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (i == 1) {
                    this.a.m0();
                    return;
                }
                dy7 dy7Var = this.a;
                if (dy7Var.O(dy7Var.d)) {
                    this.a.v();
                }
                if (i == 0 && this.a.w != null && this.a.A) {
                    this.a.w.m(this.a.x, this.a.y, this.a.v, 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i, i2) == null) {
                int i4 = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i4 = bdRecyclerView.getFirstVisiblePosition();
                    i3 = bdRecyclerView.getLastVisiblePosition();
                } else {
                    i3 = 0;
                }
                a(i4, (i3 - i4) + 1);
                if (this.a.E != null) {
                    this.a.E.j();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dy7 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public k(dy7 dy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dy7Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.l.setVisibility(8);
                this.a.r = false;
            }
        }
    }

    public dy7(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.v = false;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = true;
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e(this, 2921420);
        this.I = new f(this);
        this.J = new g(this);
        this.K = new h(this, 2921381);
        this.L = new i(this);
        this.M = new j(this);
        this.a = baseFragment;
        this.b = tbPageContext;
        this.B = bdUniqueId;
        this.D = bVar;
        E();
    }

    public final boolean O(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, recyclerView)) == null) {
            if (recyclerView == null || !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.u = z;
        }
    }

    public void U(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            px7 px7Var = this.k;
            if (px7Var != null) {
                px7Var.f(list);
            }
            N();
        }
    }

    public void V(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, str) != null) || StringUtils.isNull(str) || (textView = this.j) == null) {
            return;
        }
        textView.setVisibility(0);
        this.j.setText(str);
    }

    public void W(int i2) {
        px7 px7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && (px7Var = this.k) != null) {
            px7Var.g(i2);
        }
    }

    public void X(aa5.g gVar) {
        h18 h18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, gVar) == null) && (h18Var = this.f) != null) {
            h18Var.f(gVar);
        }
    }

    public void Y(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) && (imageView = this.i) != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.A = z;
        }
    }

    public void a0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, pVar) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.z = z;
        }
    }

    public void p0(aa5.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, iVar) == null) {
            this.e.z(iVar);
        }
    }

    public final List<Integer> A(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                xn item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof yo6) {
                    yo6 yo6Var = (yo6) item;
                    if (yo6Var.getThreadData() != null && yo6Var.getThreadData().getTid().equals(str)) {
                        if (!z) {
                            i2 = i4;
                        }
                        z = true;
                        i3 = i4;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void B() {
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (dn5Var = this.h) != null) {
            dn5Var.dettachView(this.c);
        }
    }

    public void C() {
        en5 en5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (en5Var = this.n) != null) {
            en5Var.dettachView(this.m);
            this.n = null;
        }
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            dn5 dn5Var = this.h;
            if (dn5Var == null) {
                return false;
            }
            return dn5Var.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void H() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setSelection(0);
            v();
        }
    }

    public void I() {
        ex7 ex7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (ex7Var = this.E) != null) {
            ex7Var.f();
        }
    }

    public void L() {
        px7 px7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (px7Var = this.k) != null) {
            px7Var.e();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            J(true);
        }
    }

    public void N() {
        io9 io9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (io9Var = this.w) != null && this.A) {
            io9Var.n(this.x, this.y, this.v, true);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            px7 px7Var = this.k;
            if (px7Var != null) {
                px7Var.c();
            }
            I();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.H.setTag(this.B);
            MessageManager.getInstance().registerListener(this.H);
            this.K.setTag(this.B);
            MessageManager.getInstance().registerListener(this.K);
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            J(false);
        }
    }

    public void g0() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (textView = this.j) != null) {
            textView.setVisibility(0);
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.e.setRefreshing(true);
        }
    }

    public void o0() {
        io9 io9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (io9Var = this.w) != null) {
            io9Var.y();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            U(new LinkedList());
        }
    }

    public List<xn> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            px7 px7Var = this.k;
            if (px7Var != null) {
                return px7Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.c.findViewById(R.id.obfuscated_res_0x7f090dec);
        }
        return (View) invokeV.objValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.addOnScrollListener(this.M);
            this.d.setOnTouchListener(this.I);
            this.d.setRecyclerListener(this.L);
            this.C.d(this.J);
            this.f.g(this.F);
            this.f.m(this.G);
            this.f.a0(this.b.getUniqueId());
            Q();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            dn5 dn5Var = this.h;
            if (dn5Var != null) {
                dn5Var.n();
            }
            AlphaAnimation alphaAnimation = this.p;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            AlphaAnimation alphaAnimation2 = this.q;
            if (alphaAnimation2 != null) {
                alphaAnimation2.cancel();
            }
            p0(null);
            h18 h18Var = this.f;
            if (h18Var != null) {
                h18Var.Y();
            }
            px7 px7Var = this.k;
            if (px7Var != null) {
                px7Var.d();
            }
            RotateAnimation rotateAnimation = this.s;
            if (rotateAnimation != null) {
                rotateAnimation.cancel();
            }
            RotateAnimation rotateAnimation2 = this.t;
            if (rotateAnimation2 != null) {
                rotateAnimation2.cancel();
            }
            io9 io9Var = this.w;
            if (io9Var != null) {
                io9Var.h();
            }
            u();
            MessageManager.getInstance().unRegisterListener(this.K);
            MessageManager.getInstance().unRegisterListener(this.H);
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.t == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
                this.t = rotateAnimation;
                rotateAnimation.setDuration(300L);
                this.t.setInterpolator(new AccelerateInterpolator());
                this.t.setFillAfter(true);
                this.t.setAnimationListener(new b(this));
            }
            this.i.startAnimation(this.t);
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.s == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
                this.s = rotateAnimation;
                rotateAnimation.setDuration(300L);
                this.s.setInterpolator(new AccelerateInterpolator());
                this.s.setFillAfter(true);
                this.s.setAnimationListener(new a(this));
            }
            this.i.startAnimation(this.s);
        }
    }

    public void h0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (pbListView = this.g) != null) {
            if (pbListView.c().getParent() == null) {
                this.d.setNextPage(this.g);
            }
            this.g.w(xi.g(this.b.getPageActivity(), R.dimen.tbds178));
            this.g.H(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0bd7));
            this.g.G(null);
            this.g.U();
        }
    }

    public void l0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (pbListView = this.g) != null) {
            if (pbListView.c().getParent() == null) {
                this.d.setNextPage(this.g);
            }
            this.g.w(xi.g(this.b.getPageActivity(), R.dimen.tbds178));
            this.g.H(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f08c5));
            this.g.G(null);
            this.g.g();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03c4, (ViewGroup) null);
            this.c = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.o = (GameVideoTitleBar) this.c.findViewById(R.id.obfuscated_res_0x7f090dec);
            this.m = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090de7);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f090de9);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.b.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.d.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.E = new ex7(this.m, this.d);
            if (this.a.getArguments() != null) {
                this.E.q(this.a.getArguments().getString("tab_name"));
            }
            this.E.p(this.b);
            this.C = new vw6();
            io9 io9Var = new io9(this.b, this.d);
            this.w = io9Var;
            io9Var.w(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.w.u(this.B);
            this.e = (BigdaySwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090dea);
            h18 h18Var = new h18(this.b);
            this.f = h18Var;
            this.e.setProgressView(h18Var);
            int i2 = (int) (this.b.getResources().getDisplayMetrics().density * 86.0f);
            this.e.setCustomDistances(i2, i2, i2 * 2);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.g = pbListView;
            pbListView.a();
            this.g.s(R.color.transparent);
            this.g.w(xi.g(this.b.getPageActivity(), R.dimen.tbds178));
            this.g.B();
            this.g.L(R.dimen.tbfontsize36);
            this.g.J(SkinManager.getColor(R.color.CAM_X0109));
            this.g.F(R.color.CAM_X0110);
            this.g.c().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            px7 px7Var = new px7(this.b, this.d);
            this.k = px7Var;
            px7Var.h(this.D);
            this.k.i(this.B);
            this.l = this.c.findViewById(R.id.obfuscated_res_0x7f090de6);
            this.i = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090deb);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090de8);
            this.j = textView;
            textView.setText(r95.p().w("key_game_video_tab_has_choosed_sub_class_name", ""));
            s();
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.z = z;
            io9 io9Var = this.w;
            if (io9Var == null) {
                return;
            }
            io9Var.r(!z);
            ThreadCardViewHolder w = w();
            boolean z2 = false;
            if (w != null && w.a() != null) {
                z2 = w.a().p(new wz.a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.w.y();
                } else if (this.A) {
                    this.w.n(this.x, this.y, this.v, true);
                }
            }
        }
    }

    public void T(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048595, this, z) != null) || (imageView = this.i) == null) {
            return;
        }
        imageView.setVisibility(0);
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080b56, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0201);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080b56, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
        SkinManager.setBackgroundResource(this.o, R.color.CAM_X0207);
    }

    public void d0(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) && (pbListView = this.g) != null) {
            if (pbListView.c().getParent() == null) {
                this.d.setNextPage(this.g);
            }
            this.g.w(xi.g(this.b.getPageActivity(), R.dimen.tbds178));
            this.g.H(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f08c4));
            this.g.G(onClickListener);
            this.g.g();
        }
    }

    public void j0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            if (this.n == null) {
                this.n = new en5(this.b.getPageActivity(), onClickListener);
            }
            this.n.p();
            this.n.m(null);
            this.n.n(this.b.getResources().getString(R.string.refresh_view_title_text));
            this.n.i(R.drawable.new_pic_emotion_08);
            this.n.l(0);
            this.n.attachView(this.m, false);
        }
    }

    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            List<Integer> A = A(str, this.d);
            int intValue = A.get(0).intValue();
            int intValue2 = A.get(1).intValue();
            if (intValue != -1 && intValue2 != -1) {
                this.d.removeItemList(intValue, intValue2);
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048610, this) != null) || G()) {
            return;
        }
        if (this.h == null) {
            dn5 dn5Var = new dn5(this.b.getPageActivity());
            this.h = dn5Var;
            dn5Var.i();
            this.h.t((((this.c.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - xi.g(this.b.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
            this.h.onChangeSkinType();
        }
        this.h.attachView(this.c, false);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (this.i != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.obfuscated_res_0x7f080b56, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            }
            dn5 dn5Var = this.h;
            if (dn5Var != null) {
                dn5Var.s(TbadkCoreApplication.getInst().getSkinType());
                this.h.onChangeSkinType();
            }
            en5 en5Var = this.n;
            if (en5Var != null) {
                en5Var.onChangeSkinType();
            }
            TextView textView = this.j;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            h18 h18Var = this.f;
            if (h18Var != null) {
                h18Var.H(skinType);
            }
            px7 px7Var = this.k;
            if (px7Var != null) {
                px7Var.c();
            }
            I();
            ex7 ex7Var = this.E;
            if (ex7Var != null) {
                ex7Var.o();
            }
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.n == null) {
                this.n = new en5(this.b.getPageActivity(), null);
            }
            this.n.e();
            this.n.i(R.drawable.new_pic_emotion_03);
            this.n.o(this.b.getString(R.string.no_data_common_txt));
            this.n.attachView(this.m, false);
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || this.r) {
            return;
        }
        this.r = true;
        this.l.setVisibility(0);
        if (this.p == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.p = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.p.setDuration(300L);
        }
        this.l.startAnimation(this.p);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.M);
                this.d.setOnTouchListener(null);
                this.d.setRecyclerListener(null);
            }
            vw6 vw6Var = this.C;
            if (vw6Var != null) {
                vw6Var.d(null);
            }
            h18 h18Var = this.f;
            if (h18Var != null) {
                h18Var.g(null);
                this.f.m(null);
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || !this.r) {
            return;
        }
        if (this.q == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.q = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.q.setDuration(300L);
            this.q.setAnimationListener(new k(this));
        }
        this.l.startAnimation(this.q);
    }

    public ThreadCardViewHolder w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            io9 io9Var = this.w;
            if (io9Var != null && io9Var.j() != null && (this.w.j().getTag() instanceof ThreadCardViewHolder)) {
                return (ThreadCardViewHolder) this.w.j().getTag();
            }
            return null;
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }
}
