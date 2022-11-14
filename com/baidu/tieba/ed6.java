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
/* loaded from: classes3.dex */
public class ed6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumTabFeedFragment a;
    public nc6 b;
    public String c;
    public ViewGroup d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public PbListView g;
    public az4 h;
    public cl6 i;
    public SmartBubbleAnimatedView j;
    public fd6 k;
    public boolean l;
    public TextView m;
    public RecommendForumLayout n;
    public boolean o;
    public vc8 p;
    public mc6 q;
    public BdListView.p r;
    public RecyclerView.OnScrollListener s;
    public View.OnClickListener t;
    public jq4 u;
    public View.OnClickListener v;
    public PullLeftRefreshLayout.f w;

    /* loaded from: classes3.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed6 a;

        public a(ed6 ed6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed6Var;
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
                        this.a.g.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                        this.a.g.D(null);
                        if (this.a.o) {
                            this.a.g.P();
                            this.a.b.i();
                            return;
                        }
                        this.a.g.E(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a1a));
                        this.a.g.f();
                        return;
                    }
                    this.a.f.setNextPage(null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ed6 b;

        public b(ed6 ed6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ed6Var;
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

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed6 a;

        public c(ed6 ed6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.f != null) {
                    this.a.f.stopScroll();
                }
                if (this.a.g != null && this.a.b != null && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.g.N(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    this.a.g.D(null);
                    if (this.a.o) {
                        this.a.g.P();
                        this.a.b.i();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements jq4<gu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed6 a;

        public d(ed6 ed6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jq4
        /* renamed from: a */
        public void d(View view2, gu4 gu4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, gu4Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || gu4Var == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13642");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", gu4Var.j());
            int i2 = 1;
            if (this.a.n.l == 0) {
                statisticItem.param("obj_locate", 1);
                if (this.a.n.n) {
                    i2 = 3;
                }
                statisticItem.param("obj_type", i2);
            } else if (this.a.n.l == 1) {
                statisticItem.param("obj_locate", 2);
                statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.a.c);
            }
            TiebaStatic.log(statisticItem);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jq4
        /* renamed from: b */
        public void c(View view2, gu4 gu4Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, gu4Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                int i2 = 1;
                if (gu4Var == null) {
                    wa6.b(this.a.a.getPageContext(), this.a.c);
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
                } else if (gu4Var != null && this.a.a != null) {
                    String l = gu4Var.l();
                    if (!xi.isForumName(l)) {
                        return;
                    }
                    this.a.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.a.getFragmentActivity()).createNormalCfg(l, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (this.a.n == null) {
                        return;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13643");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("fid", gu4Var.j());
                    if (this.a.n.l == 0) {
                        statisticItem2.param("obj_locate", 1);
                        if (this.a.n.n) {
                            i2 = 4;
                        }
                        statisticItem2.param("obj_type", i2);
                    } else if (this.a.n.l == 1) {
                        statisticItem2.param("obj_locate", 2);
                        statisticItem2.param(TiebaStatic.Params.RESOURCE_ID, this.a.c);
                    }
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed6 a;

        public e(ed6 ed6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                wa6.b(this.a.a.getPageContext(), this.a.c);
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

    /* loaded from: classes3.dex */
    public class f implements PullLeftRefreshLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed6 a;

        public f(ed6 ed6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed6Var;
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wa6.b(this.a.a.getPageContext(), this.a.c);
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

    /* loaded from: classes3.dex */
    public class g implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ed6 a;

        public g(ed6 ed6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ed6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ed6Var;
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

    public ed6(EnterForumTabFeedFragment enterForumTabFeedFragment, nc6 nc6Var, ViewGroup viewGroup, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {enterForumTabFeedFragment, nc6Var, viewGroup, str};
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
        this.b = nc6Var;
        this.c = str;
        i(viewGroup);
        this.q = new mc6(enterForumTabFeedFragment, this.f);
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
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09206b);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.setOnSrollToBottomListener(this.r);
            this.f.addOnScrollListener(this.s);
            az4 az4Var = new az4(this.a.getPageContext());
            this.h = az4Var;
            az4Var.f(this.b);
            this.f.setRecyclerListener(new g(this));
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.g = pbListView;
            pbListView.b();
            this.g.q(R.color.CAM_X0205);
            this.g.u(yi.g(this.a.getPageContext().getPageActivity(), R.dimen.tbds182));
            this.g.z();
            this.g.I(R.dimen.tbfontsize33);
            this.g.G(SkinManager.getColor(R.color.CAM_X0107));
            this.g.C(R.color.CAM_X0110);
            this.g.t();
            this.g.D(this.t);
            if (this.e == null) {
                BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09206a);
                this.e = bdSwipeRefreshLayout;
                bdSwipeRefreshLayout.setProgressView(this.h);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
                marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + yi.g(this.a.getPageContext().getPageActivity(), R.dimen.tbds219);
                this.e.setLayoutParams(marginLayoutParams);
            }
            this.i = new cl6();
            SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(this.a.getContext());
            this.j = smartBubbleAnimatedView;
            smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, yi.g(this.a.getContext(), R.dimen.tbds83)));
            if (this.p == null) {
                vc8 vc8Var = new vc8(this.a.getPageContext(), this.f);
                this.p = vc8Var;
                vc8Var.p(2);
                this.p.u(this.a.getUniqueId());
            }
            fd6 fd6Var = new fd6(this.a.getPageContext());
            this.k = fd6Var;
            fd6Var.g(this.c);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.m == null) {
            TextView textView = new TextView(this.a.getContext());
            this.m = textView;
            textView.setPadding(yi.g(this.a.getContext(), R.dimen.tbds44), yi.g(this.a.getContext(), R.dimen.tbds60), 0, yi.g(this.a.getContext(), R.dimen.tbds24));
            this.m.setText(R.string.obfuscated_res_0x7f0f13a1);
            this.m.setTextSize(0, yi.g(this.a.getContext(), R.dimen.tbds46));
            this.m.setTypeface(Typeface.DEFAULT_BOLD);
            this.f.removeHeaderView(this.m);
            this.f.t(this.m, 0);
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
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (vc8Var = this.p) != null) {
            vc8Var.z();
            this.p.r(false);
        }
    }

    public void p() {
        vc8 vc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (vc8Var = this.p) != null) {
            vc8Var.r(true);
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
            az4 az4Var = this.h;
            if (az4Var != null) {
                az4Var.H(i);
            }
            PbListView pbListView = this.g;
            if (pbListView != null) {
                pbListView.G(SkinManager.getColor(R.color.CAM_X0107));
                this.g.d(i);
            }
            mc6 mc6Var = this.q;
            if (mc6Var != null) {
                mc6Var.b();
            }
            TextView textView = this.m;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            fd6 fd6Var = this.k;
            if (fd6Var != null) {
                fd6Var.e();
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

    public void m(cd6 cd6Var) {
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cd6Var) == null) {
            if (cd6Var != null) {
                this.o = cd6Var.c;
            }
            q(false);
            if (cd6Var != null && this.q != null && this.f != null && this.g != null) {
                j();
                u(cd6Var);
                v(cd6Var);
                if (cd6Var.e > 0) {
                    int firstVisiblePosition = this.f.getFirstVisiblePosition();
                    View childAt = this.f.getChildAt(0);
                    if (childAt == null) {
                        top = 0;
                    } else {
                        top = childAt.getTop();
                    }
                    RecyclerView.LayoutManager layoutManager = this.f.getLayoutManager();
                    int i = firstVisiblePosition - cd6Var.e;
                    if (layoutManager instanceof LinearLayoutManager) {
                        this.f.z();
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                        this.f.A();
                    }
                    cd6Var.e = 0;
                }
                this.q.d(cd6Var.d);
                this.q.c(cd6Var.b);
                this.q.b();
                if (cd6Var.h) {
                    s(cd6Var.f);
                }
                vc8 vc8Var = this.p;
                if (vc8Var != null) {
                    vc8Var.n(this.f.getFirstVisiblePosition(), this.f.getLastVisiblePosition(), false, true);
                }
            }
        }
    }

    public final void v(cd6 cd6Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, cd6Var) == null) && cd6Var != null && this.f != null && this.a != null && cd6Var.h) {
            hu4 hu4Var = cd6Var.a;
            if (hu4Var != null && !ListUtils.isEmpty(hu4Var.h())) {
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
            this.n.a(cd6Var.a);
            this.f.removeHeaderView(this.n);
            this.f.t(this.n, 0);
            StatisticItem statisticItem = new StatisticItem("c13641");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 2);
            statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.c);
            TiebaStatic.log(statisticItem);
        }
    }

    public void o(int i, int i2) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) && (bdTypeRecyclerView = this.f) != null && i < i2) {
            bdTypeRecyclerView.E(i, i2);
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
            string = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff8), Integer.valueOf(i));
        } else {
            string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff7);
        }
        if (TextUtils.isEmpty(string) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.j;
        smartBubbleAnimatedView.a = string;
        smartBubbleAnimatedView.b = 2000L;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = UtilHelper.getStatusBarHeight() + yi.g(this.a.getPageContext().getPageActivity(), R.dimen.tbds228);
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.removeView(this.j);
            this.d.addView(this.j, layoutParams);
            this.j.g();
        }
    }

    public final void u(cd6 cd6Var) {
        List<ShortUserInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cd6Var) == null) {
            dd6 dd6Var = cd6Var.g;
            if (dd6Var != null && (list = dd6Var.a) != null && list.size() > 0 && !TextUtils.isEmpty(cd6Var.g.b)) {
                this.k.f(cd6Var.g);
                if (this.k.d().getParent() == null && !this.l) {
                    this.l = true;
                    this.f.t(this.k.d(), 0);
                    StatisticItem statisticItem = new StatisticItem("c13656");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.c);
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
