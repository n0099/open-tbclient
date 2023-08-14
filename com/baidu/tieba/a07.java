package com.baidu.tieba;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ShortUserInfo;
/* loaded from: classes5.dex */
public class a07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public jz6 b;
    public String c;
    public ViewGroup d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public PbListView g;
    public j95 h;
    public eh7 i;
    public SmartBubbleAnimatedView j;
    public b07 k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public jt9 p;
    public iz6 q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;
    public mz4 u;
    public View.OnClickListener v;
    public PullLeftRefreshLayout.f w;

    /* loaded from: classes5.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public a(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                if (this.a.g != null && this.a.b != null) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.f.setNextPage(this.a.g);
                        this.a.g.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                        this.a.g.G(null);
                        if (this.a.o) {
                            this.a.g.R();
                            this.a.b.j();
                            return;
                        }
                        this.a.g.H(this.a.a.getResources().getString(R.string.list_has_no_more));
                        this.a.g.g();
                        return;
                    }
                    this.a.f.setNextPage(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ a07 b;

        public b(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a07Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) && i == 0) {
                if (this.b.p != null) {
                    this.b.p.n(this.b.f.getFirstVisiblePosition(), this.b.f.getLastVisiblePosition(), this.a, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(true ^ this.b.k())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 > 0) {
                    this.a = false;
                } else {
                    this.a = true;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public c(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                if (this.a.g != null && this.a.b != null && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.g.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.g.G(null);
                    if (this.a.o) {
                        this.a.g.R();
                        this.a.b.j();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements mz4<g35> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public d(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mz4
        /* renamed from: a */
        public void c(View view2, g35 g35Var, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, g35Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || g35Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", g35Var.f());
            int i2 = 1;
            if (this.a.n.l == 0) {
                statisticItem.param("obj_locate", 1);
                if (this.a.n.n) {
                    i2 = 3;
                }
                statisticItem.param("obj_type", i2);
            } else if (this.a.n.l == 1) {
                statisticItem.param("obj_locate", 2);
                statisticItem.param("resource_id", this.a.c);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mz4
        /* renamed from: b */
        public void d(View view2, g35 g35Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, g35Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                int i2 = 1;
                if (g35Var == null) {
                    ux6.b(this.a.a.getPageContext(), this.a.c);
                    if (this.a.n == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13645");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", 1);
                    if (this.a.n.n) {
                        i2 = 5;
                    }
                    statisticItem.param("obj_type", i2);
                    statisticItem.param("obj_source", 5);
                    TiebaStatic.log(statisticItem);
                } else if (g35Var != null && this.a.a != null) {
                    String g = g35Var.g();
                    if (!bi.isForumName(g)) {
                        return;
                    }
                    this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getFragmentActivity()).createNormalCfg(g, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (this.a.n == null) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13643");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", g35Var.f());
                    if (this.a.n.l == 0) {
                        statisticItem2.param("obj_locate", 1);
                        if (this.a.n.n) {
                            i2 = 4;
                        }
                        statisticItem2.param("obj_type", i2);
                    } else if (this.a.n.l == 1) {
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param("resource_id", this.a.c);
                    }
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public e(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ux6.b(this.a.a.getPageContext(), this.a.c);
                if (this.a.n == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                int i = 1;
                statisticItem.param("obj_locate", 1);
                if (this.a.n.n) {
                    i = 5;
                }
                statisticItem.param("obj_type", i);
                statisticItem.param("obj_source", 2);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public f(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux6.b(this.a.a.getPageContext(), this.a.c);
                StatisticItem statisticItem = new StatisticItem("c13645");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                int i = 1;
                statisticItem.param("obj_locate", 1);
                if (this.a.n.n) {
                    i = 5;
                }
                statisticItem.param("obj_type", i);
                statisticItem.param("obj_source", 4);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a07 a;

        public g(a07 a07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a07Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null && this.a.p != null) {
                this.a.p.k(view2);
            }
        }
    }

    public a07(EnterForumTabFeedFragment enterForumTabFeedFragment, jz6 jz6Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, jz6Var, viewGroup, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.s = new b(this);
        this.t = new c(this);
        this.u = new d(this);
        this.v = new e(this);
        this.w = new f(this);
        this.a = enterForumTabFeedFragment;
        this.b = jz6Var;
        this.c = str;
        i(viewGroup);
        this.q = new iz6(enterForumTabFeedFragment, this.f);
        q(false);
    }

    public void q(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (bdSwipeRefreshLayout = this.e) != null) {
            bdSwipeRefreshLayout.setRefreshing(z);
        }
    }

    public void r(boolean z) {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (bdSwipeRefreshLayout = this.e) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            bdSwipeRefreshLayout.setVisibility(i);
        }
    }

    public final void i(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
            this.d = viewGroup;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09234c);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setOnSrollToBottomListener(this.r);
            this.f.addOnScrollListener(this.s);
            j95 j95Var = new j95(this.a.getPageContext());
            this.h = j95Var;
            j95Var.a(this.b);
            this.f.setRecyclerListener(new g(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.g = pbListView;
            pbListView.c();
            this.g.s(R.color.CAM_X0205);
            this.g.w(BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.g.B();
            this.g.L(R.dimen.tbfontsize33);
            this.g.J(SkinManager.getColor(R.color.CAM_X0107));
            this.g.F(R.color.CAM_X0110);
            this.g.v();
            this.g.G(this.t);
            if (this.e == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09234b);
                this.e = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.h);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
                marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.tbds219);
                this.e.setLayoutParams(marginLayoutParams);
            }
            this.i = new eh7();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.j = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds83)));
            if (this.p == null) {
                jt9 jt9Var = new jt9(this.a.getPageContext(), this.f);
                this.p = jt9Var;
                jt9Var.p(2);
                this.p.u(this.a.getUniqueId());
            }
            b07 b07Var = new b07(this.a.getPageContext());
            this.k = b07Var;
            b07Var.g(this.c);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m == null) {
            TextView textView = new TextView(this.a.getContext());
            this.m = textView;
            textView.setPadding(BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds44), BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds60), 0, BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.obfuscated_res_0x7f0f15b0);
            this.m.setTextSize(0, BdUtilHelper.getDimens(this.a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f.removeHeaderView(this.m);
            this.f.addHeaderView(this.m, 0);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f;
            if (bdTypeRecyclerView == null || bdTypeRecyclerView.getChildCount() == 0 || this.f.getChildAt(0).getTop() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jt9Var = this.p) != null) {
            jt9Var.z();
            this.p.r(false);
        }
    }

    public void p() {
        jt9 jt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (jt9Var = this.p) != null) {
            jt9Var.r(true);
            BdTypeRecyclerView bdTypeRecyclerView = this.f;
            if (bdTypeRecyclerView != null) {
                this.p.n(bdTypeRecyclerView.getFirstVisiblePosition(), this.f.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void t() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (bdTypeRecyclerView = this.f) != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            j95 j95Var = this.h;
            if (j95Var != null) {
                j95Var.C(i);
            }
            PbListView pbListView = this.g;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
                this.g.e(i);
            }
            iz6 iz6Var = this.q;
            if (iz6Var != null) {
                iz6Var.b();
            }
            TextView textView = this.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            b07 b07Var = this.k;
            if (b07Var != null) {
                b07Var.e();
            }
            RecommendForumLayout recommendForumLayout = this.n;
            if (recommendForumLayout != null) {
                recommendForumLayout.c();
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i);
            }
        }
    }

    public void m(yz6 yz6Var) {
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yz6Var) == null) {
            if (yz6Var != null) {
                this.o = yz6Var.c;
            }
            q(false);
            if (yz6Var != null && this.q != null && this.f != null && this.g != null) {
                j();
                u(yz6Var);
                v(yz6Var);
                if (yz6Var.e > 0) {
                    int firstVisiblePosition = this.f.getFirstVisiblePosition();
                    View childAt = this.f.getChildAt(0);
                    if (childAt == null) {
                        top = 0;
                    } else {
                        top = childAt.getTop();
                    }
                    RecyclerView.LayoutManager layoutManager = this.f.getLayoutManager();
                    int i = firstVisiblePosition - yz6Var.e;
                    if (layoutManager instanceof LinearLayoutManager) {
                        this.f.startInterceptLayout();
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                        this.f.stopIntercerceptLayout();
                    }
                    yz6Var.e = 0;
                }
                this.q.d(yz6Var.d);
                this.q.c(yz6Var.b);
                this.q.b();
                if (yz6Var.h) {
                    s(yz6Var.f);
                }
                jt9 jt9Var = this.p;
                if (jt9Var != null) {
                    jt9Var.n(this.f.getFirstVisiblePosition(), this.f.getLastVisiblePosition(), false, true);
                }
            }
        }
    }

    public final void v(yz6 yz6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, yz6Var) == null) && yz6Var != null && this.f != null && this.a != null && yz6Var.h) {
            h35 h35Var = yz6Var.a;
            if (h35Var != null && !ListUtils.isEmpty(h35Var.e())) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                RecommendForumLayout recommendForumLayout = this.n;
                if (recommendForumLayout != null) {
                    this.f.removeHeaderView(recommendForumLayout);
                    return;
                }
                return;
            }
            if (this.n == null) {
                RecommendForumLayout recommendForumLayout2 = new RecommendForumLayout(this.a.getPageContext());
                this.n = recommendForumLayout2;
                recommendForumLayout2.setShowMore(true);
                this.n.setSquareEntranceAtStart(true);
                this.n.setTabName(this.c);
                this.n.setFrom(1);
            }
            this.n.setOnClickRightArrowListener(this.v);
            this.n.setOnRullOkCallbackr(this.w);
            this.n.setOnItemCoverListener(this.u);
            this.n.a(yz6Var.a);
            this.f.removeHeaderView(this.n);
            this.f.addHeaderView(this.n, 0);
            StatisticItem statisticItem = new StatisticItem("c13641");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 2);
            statisticItem.param("resource_id", this.c);
            TiebaStatic.log(statisticItem);
        }
    }

    public void o(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) && (bdTypeRecyclerView = this.f) != null && i < i2) {
            bdTypeRecyclerView.removeItemList(i, i2);
        }
    }

    public final void s(int i) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048586, this, i) != null) || i < 0) {
            return;
        }
        this.i.f();
        if (i > 0) {
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
        }
        if (TextUtils.isEmpty(string) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        smartBubbleAnimatedView.a = string;
        smartBubbleAnimatedView.b = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + BdUtilHelper.getDimens(this.a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public final void u(yz6 yz6Var) {
        List<ShortUserInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, yz6Var) == null) {
            zz6 zz6Var = yz6Var.g;
            if (zz6Var != null && (list = zz6Var.a) != null && list.size() > 0 && !TextUtils.isEmpty(yz6Var.g.b)) {
                this.k.f(yz6Var.g);
                if (this.k.d().getParent() == null && !this.l) {
                    this.l = true;
                    this.f.addHeaderView(this.k.d(), 0);
                    StatisticItem statisticItem = new StatisticItem("c13656");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("resource_id", this.c);
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            this.l = false;
            this.f.removeHeaderView(this.k.d());
        }
    }
}
