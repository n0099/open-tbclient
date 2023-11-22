package com.baidu.tieba;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.g55;
import com.baidu.tieba.homepage.personalize.adapter.HomePageCardVideoViewHolder;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.mu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class ci8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView.RecyclerListener A;
    public RecyclerView.OnScrollListener B;
    public BaseFragment a;
    public TbPageContext b;
    public View c;
    public BdTypeRecyclerView d;
    public BigdaySwipeRefreshLayout e;
    public fe8 f;
    public bf8 g;
    public wj5 h;
    public PbListView i;
    public LoadingView j;
    public sh8 k;
    public View l;
    public FrameLayout m;
    public w8a n;
    public NEGFeedBackView.NEGFeedbackEventCallback o;
    public y98 p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public BdUniqueId v;
    public g55.h w;
    public g55.f x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci8 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.k.c();
                    this.a.a.A();
                    if (!this.a.a.s && this.a.a.t) {
                        this.a.a.n.n(this.a.a.q, this.a.a.r, this.a.a.u, true);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ci8 ci8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci8Var, Integer.valueOf(i)};
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
            this.a = ci8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                SafeHandler.getInst().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements g55.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci8 a;

        public a(ci8 ci8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci8Var;
        }

        @Override // com.baidu.tieba.g55.h
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.Y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements g55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci8 a;

        public b(ci8 ci8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci8Var;
        }

        @Override // com.baidu.tieba.g55.f
        public void a(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                this.a.N(true);
                if (this.a.n != null && !this.a.s && this.a.t) {
                    this.a.n.n(this.a.q, this.a.r, this.a.u, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ci8 ci8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci8Var, Integer.valueOf(i)};
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
            this.a = ci8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder q;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (q = this.a.q()) != null && q.a() != null) {
                    q.a().q(new mu.a(3));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci8 a;

        public e(ci8 ci8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci8Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, viewHolder) != null) || viewHolder == null || (view2 = viewHolder.itemView) == null) {
                return;
            }
            if (this.a.n != null) {
                this.a.n.k(view2);
            }
            if (view2.getTag() instanceof HomePageCardVideoViewHolder) {
                ((HomePageCardVideoViewHolder) view2.getTag()).a().stopPlay();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ ci8 b;

        public f(ci8 ci8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci8Var;
            this.a = -1;
        }

        public final void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.q = i;
            this.b.r = (i + i2) - 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (i == 0 && this.b.n != null && this.b.t) {
                    this.b.n.m(this.b.q, this.b.r, this.b.u, 1);
                }
                if (this.a == i) {
                    return;
                }
                this.a = i;
                if (i != 1) {
                    this.b.a0();
                } else {
                    this.b.P(true);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i, i2) == null) {
                int i4 = 0;
                if (recyclerView instanceof BdRecyclerView) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i4 = bdRecyclerView.getFirstVisiblePosition();
                    i3 = bdRecyclerView.getLastVisiblePosition();
                } else {
                    i3 = 0;
                }
                a(i4, (i3 - i4) + 1);
                if (this.b.p != null) {
                    this.b.p.j();
                }
            }
        }
    }

    public ci8(BaseFragment baseFragment, TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext, bdUniqueId, nEGFeedbackEventCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.t = true;
        this.u = false;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this, 2921420);
        this.z = new d(this, 2921381);
        this.A = new e(this);
        this.B = new f(this);
        this.a = baseFragment;
        this.b = tbPageContext;
        this.v = bdUniqueId;
        this.o = nEGFeedbackEventCallback;
        x();
    }

    public final boolean H(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, recyclerView)) == null) {
            if (recyclerView == null || !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void L(List<oi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            sh8 sh8Var = this.k;
            if (sh8Var != null) {
                sh8Var.f(list);
            }
            G();
        }
    }

    public void M(g55.g gVar) {
        fe8 fe8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) && (fe8Var = this.f) != null) {
            fe8Var.a(gVar);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.t = z;
        }
    }

    public void O(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921400, Boolean.valueOf(z)));
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.s = z;
        }
    }

    public void Z(g55.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iVar) == null) {
            this.e.z(iVar);
        }
    }

    public void A() {
        y98 y98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (y98Var = this.p) != null) {
            y98Var.f();
        }
    }

    public void D() {
        sh8 sh8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (sh8Var = this.k) != null) {
            sh8Var.e();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            B(true);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            B(false);
        }
    }

    public void G() {
        w8a w8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (w8aVar = this.n) != null && this.t) {
            w8aVar.n(this.q, this.r, this.u, true);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            sh8 sh8Var = this.k;
            if (sh8Var != null) {
                sh8Var.c();
            }
            A();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.y.setTag(this.v);
            MessageManager.getInstance().registerListener(this.y);
            this.z.setTag(this.v);
            MessageManager.getInstance().registerListener(this.z);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.e.setRefreshing(true);
        }
    }

    public void Y() {
        w8a w8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (w8aVar = this.n) != null) {
            w8aVar.y();
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (H(this.d)) {
                P(false);
            } else {
                P(true);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            L(new LinkedList());
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.d;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.B);
                this.d.setRecyclerListener(null);
            }
            fe8 fe8Var = this.f;
            if (fe8Var != null) {
                fe8Var.b(null);
                this.f.e(null);
            }
        }
    }

    public List<oi> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            sh8 sh8Var = this.k;
            if (sh8Var != null) {
                return sh8Var.a();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void u() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (loadingView = this.j) != null) {
            loadingView.dettachView(this.c);
        }
    }

    public void v() {
        wj5 wj5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (wj5Var = this.h) != null) {
            wj5Var.dettachView(this.m);
            this.h = null;
        }
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            LoadingView loadingView = this.j;
            if (loadingView == null) {
                return false;
            }
            return loadingView.isViewAttached();
        }
        return invokeV.booleanValue;
    }

    public void z() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (bdTypeRecyclerView = this.d) != null) {
            bdTypeRecyclerView.setSelection(0);
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.s = z;
            w8a w8aVar = this.n;
            if (w8aVar == null) {
                return;
            }
            w8aVar.r(!z);
            ThreadCardViewHolder q = q();
            boolean z2 = false;
            if (q != null && q.a() != null) {
                z2 = q.a().q(new mu.a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.n.y();
                } else if (this.t) {
                    this.n.n(this.q, this.r, this.u, true);
                }
            }
        }
    }

    public void R(View.OnClickListener onClickListener) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) && (pbListView = this.i) != null) {
            if (pbListView.c().getParent() == null) {
                this.d.setNextPage(this.i);
            }
            this.i.w(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds178));
            this.i.H(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f1837));
            this.i.G(onClickListener);
            this.i.g();
        }
    }

    public void U(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            if (this.h == null) {
                this.h = new wj5(this.b.getPageActivity(), onClickListener);
            }
            this.h.o();
            this.h.l(null);
            this.h.m(this.b.getResources().getString(R.string.refresh_view_title_text));
            this.h.h(R.drawable.new_pic_emotion_08);
            this.h.k(0);
            this.h.attachView(this.m, false);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LoadingView loadingView = this.j;
            if (loadingView != null) {
                loadingView.release();
            }
            Z(null);
            fe8 fe8Var = this.f;
            if (fe8Var != null) {
                fe8Var.U();
            }
            sh8 sh8Var = this.k;
            if (sh8Var != null) {
                sh8Var.d();
            }
            w8a w8aVar = this.n;
            if (w8aVar != null) {
                w8aVar.h();
            }
            p();
            MessageManager.getInstance().unRegisterListener(this.z);
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || y()) {
            return;
        }
        if (this.j == null) {
            LoadingView loadingView = new LoadingView(this.b.getPageActivity());
            this.j = loadingView;
            loadingView.onChangeSkinType();
        }
        this.j.attachView(this.c, false);
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.h == null) {
                this.h = new wj5(this.b.getPageActivity(), null);
            }
            this.h.d();
            this.h.h(R.drawable.new_pic_emotion_03);
            this.h.n(this.b.getString(R.string.no_data_common_txt));
            this.h.attachView(this.m, false);
        }
    }

    public final ThreadCardViewHolder q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            w8a w8aVar = this.n;
            if (w8aVar != null && w8aVar.j() != null && (this.n.j().getTag() instanceof ThreadCardViewHolder)) {
                return (ThreadCardViewHolder) this.n.j().getTag();
            }
            return null;
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.addOnScrollListener(this.B);
            this.d.setRecyclerListener(this.A);
            this.f.b(this.w);
            this.f.e(this.x);
            this.f.W(this.b.getUniqueId());
            J();
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            List<Integer> t = t(str, this.d);
            int intValue = t.get(0).intValue();
            int intValue2 = t.get(1).intValue();
            if (intValue != -1 && intValue2 != -1) {
                this.d.removeItemList(intValue, intValue2);
            }
        }
    }

    public void S() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (pbListView = this.i) != null) {
            if (pbListView.c().getParent() == null) {
                this.d.setNextPage(this.i);
            }
            this.i.w(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds178));
            this.i.H(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f0c22));
            this.i.G(null);
            this.i.U();
        }
    }

    public void W() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (pbListView = this.i) != null) {
            if (pbListView.c().getParent() == null) {
                this.d.setNextPage(this.i);
            }
            this.i.w(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds178));
            this.i.H(this.b.getResources().getString(R.string.obfuscated_res_0x7f0f183a));
            this.i.G(null);
            this.i.g();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            LoadingView loadingView = this.j;
            if (loadingView != null) {
                loadingView.setSkinType(TbadkCoreApplication.getInst().getSkinType());
                this.j.onChangeSkinType();
            }
            wj5 wj5Var = this.h;
            if (wj5Var != null) {
                wj5Var.onChangeSkinType();
            }
            fe8 fe8Var = this.f;
            if (fe8Var != null) {
                fe8Var.D(skinType);
            }
            sh8 sh8Var = this.k;
            if (sh8Var != null) {
                sh8Var.c();
            }
            A();
            y98 y98Var = this.p;
            if (y98Var != null) {
                y98Var.o();
            }
        }
    }

    public final List<Integer> t(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z = false;
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < bdTypeRecyclerView.getCount(); i3++) {
                oi item = bdTypeRecyclerView.getItem(i3);
                if (item instanceof gm6) {
                    gm6 gm6Var = (gm6) item;
                    if (gm6Var.getThreadData() != null && gm6Var.getThreadData().getTid().equals(str)) {
                        if (!z) {
                            i = i3;
                        }
                        z = true;
                        i2 = i3;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i));
            arrayList.add(Integer.valueOf(i2));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            View inflate = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0a02, (ViewGroup) null);
            this.c = inflate;
            inflate.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092980);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.c.findViewById(R.id.obfuscated_res_0x7f092983);
            this.d = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.b.getPageActivity()));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.d.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.p = new y98(this.m, this.d);
            if (this.a.getArguments() != null) {
                this.p.q(this.a.getArguments().getString("tab_name"));
            }
            this.p.p(this.b);
            w8a w8aVar = new w8a(this.b, this.d);
            this.n = w8aVar;
            w8aVar.w(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.n.u(this.v);
            this.e = (BigdaySwipeRefreshLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092984);
            fe8 fe8Var = new fe8(this.b);
            this.f = fe8Var;
            this.e.setProgressView(fe8Var);
            int i = (int) (this.b.getResources().getDisplayMetrics().density * 86.0f);
            this.e.setCustomDistances(i, i, i * 2);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.i = pbListView;
            pbListView.a();
            this.i.s(R.color.transparent);
            this.i.w(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds178));
            this.i.B();
            this.i.L(R.dimen.tbfontsize36);
            this.i.J(SkinManager.getColor(R.color.CAM_X0109));
            this.i.F(R.color.CAM_X0110);
            this.i.c().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            sh8 sh8Var = new sh8(this.b, this.d);
            this.k = sh8Var;
            sh8Var.g(this.o);
            this.k.h(this.v);
            bf8 bf8Var = new bf8();
            this.g = bf8Var;
            bf8Var.a(this.v);
            this.k.i(this.g);
            this.l = this.c.findViewById(R.id.obfuscated_res_0x7f09297d);
            n();
        }
    }
}
