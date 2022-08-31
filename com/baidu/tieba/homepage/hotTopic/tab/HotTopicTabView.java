package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ay6;
import com.baidu.tieba.bv4;
import com.baidu.tieba.cn4;
import com.baidu.tieba.cv4;
import com.baidu.tieba.gw6;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.hx6;
import com.baidu.tieba.k65;
import com.baidu.tieba.l65;
import com.baidu.tieba.pi;
import com.baidu.tieba.pn;
import com.baidu.tieba.ri;
import com.baidu.tieba.rx6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class HotTopicTabView extends FrameLayout implements bv4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public BaseFragment b;
    public TbPageContext<?> c;
    public hx6 d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public rx6 g;
    public cv4 h;
    public k65 i;
    public l65 j;
    public ScrollFragmentTabHost k;
    public int l;
    public PbListView m;
    public HotTopicHeaderView n;
    public TabLayout.OnTabSelectedListener o;
    public cn4 p;
    public gw6 q;
    public boolean r;
    public RecyclerView.OnScrollListener s;
    public ScrollFragmentTabHost.y t;

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabView a;

        public a(HotTopicTabView hotTopicTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicTabView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) || this.a.l == i || this.a.k == null) {
                return;
            }
            this.a.l = i;
            if (this.a.l == 1) {
                this.a.k.a();
            } else if (this.a.w(recyclerView)) {
                this.a.k.c();
            } else {
                this.a.k.a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (this.a.q != null) {
                    this.a.q.j();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ScrollFragmentTabHost.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabView a;

        public b(HotTopicTabView hotTopicTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicTabView;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.y
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.k == null) {
                return;
            }
            this.a.l = -1;
            HotTopicTabView hotTopicTabView = this.a;
            if (hotTopicTabView.w(hotTopicTabView.f)) {
                this.a.k.c();
            } else {
                this.a.k.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabView a;

        public c(HotTopicTabView hotTopicTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && pi.A() && this.a.d != null) {
                this.a.z(false);
                this.a.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabView(BaseFragment baseFragment, TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tbPageContext};
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
        this.l = -1;
        this.s = new a(this);
        this.t = new b(this);
        this.b = baseFragment;
        this.c = tbPageContext;
        p(tbPageContext.getPageActivity());
        q();
        v();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || s()) {
            return;
        }
        if (this.j == null) {
            this.j = new l65(getContext(), new c(this));
        }
        this.j.attachView(this, z);
        this.j.p();
        this.q.q(false);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.setNextPage(this.m);
            this.m.f();
            this.m.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.m.D(getResources().getString(R.string.obfuscated_res_0x7f0f0f83), ri.f(getContext(), R.dimen.tbds158));
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.setRefreshing(true);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.bv4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.d.a();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.k;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.t);
            }
            D();
            m();
            n();
            this.r = true;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            k65 k65Var = this.i;
            if (k65Var != null) {
                k65Var.dettachView(this);
                this.i = null;
            }
            this.q.q(true);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            l65 l65Var = this.j;
            if (l65Var != null) {
                l65Var.dettachView(this);
                this.j = null;
            }
            this.q.q(true);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f.setNextPage(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l();
            super.onDetachedFromWindow();
        }
    }

    public final void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02d5, (ViewGroup) this, true);
            this.e = (BdSwipeRefreshLayout) findViewById(R.id.obfuscated_res_0x7f090db4);
            cv4 cv4Var = new cv4(this.c);
            this.h = cv4Var;
            this.e.setProgressView(cv4Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090db3);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.g = new rx6(this.c, this.f);
            this.q = new gw6(this, this.f);
            if (this.b.getArguments() != null) {
                this.q.p(this.b.getArguments().getString("tab_name"));
            }
            this.q.o(this.c);
            PbListView pbListView = new PbListView(this.c.getPageActivity());
            this.m = pbListView;
            pbListView.a();
            this.m.p(R.color.CAM_X0205);
            this.m.A(R.color.CAM_X0111);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f.addOnScrollListener(this.s);
            this.h.f(this);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            k65 k65Var = this.i;
            if (k65Var != null) {
                return k65Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            l65 l65Var = this.j;
            if (l65Var != null) {
                return l65Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setData(@NonNull ay6 ay6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ay6Var) == null) {
            y(ay6Var);
            setListData(ay6Var.getDataList());
        }
    }

    public void setListData(@NonNull List<pn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.g.d(list);
        }
    }

    public void setOnItemCoverListener(cn4 cn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cn4Var) == null) {
            this.p = cn4Var;
            rx6 rx6Var = this.g;
            if (rx6Var != null) {
                rx6Var.e(cn4Var);
            }
            HotTopicHeaderView hotTopicHeaderView = this.n;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.setOnItemCoverListener(cn4Var);
            }
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onTabSelectedListener) == null) {
            this.o = onTabSelectedListener;
        }
    }

    public void setPresenter(hx6 hx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hx6Var) == null) {
            this.d = hx6Var;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, scrollFragmentTabHost) == null) {
            this.k = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.t);
                this.k.b(this.t);
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            rx6 rx6Var = this.g;
            if (rx6Var != null) {
                rx6Var.f(bdUniqueId);
            }
            cv4 cv4Var = this.h;
            if (cv4Var != null) {
                cv4Var.b0(bdUniqueId);
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.k;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.t);
                this.k.b(this.t);
                this.t.c();
            }
            if (this.r) {
                this.r = false;
                if (ListUtils.isEmpty(this.g.a())) {
                    this.d.a();
                }
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            HotTopicHeaderView hotTopicHeaderView = this.n;
            return (hotTopicHeaderView == null || hotTopicHeaderView.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        gw6 gw6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (gw6Var = this.q) == null) {
            return;
        }
        gw6Var.f();
    }

    public void v() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        cv4 cv4Var = this.h;
        if (cv4Var != null) {
            cv4Var.H(skinType);
        }
        k65 k65Var = this.i;
        if (k65Var != null) {
            k65Var.onChangeSkinType();
        }
        l65 l65Var = this.j;
        if (l65Var != null) {
            l65Var.onChangeSkinType();
        }
        rx6 rx6Var = this.g;
        if (rx6Var != null) {
            rx6Var.c();
        }
        PbListView pbListView = this.m;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.m.p(R.color.transparent);
        }
        HotTopicHeaderView hotTopicHeaderView = this.n;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.i(skinType);
        }
        gw6 gw6Var = this.q;
        if (gw6Var != null) {
            gw6Var.n();
        }
        u();
    }

    public final boolean w(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, recyclerView)) == null) {
            if (recyclerView == null) {
                return true;
            }
            return !recyclerView.canScrollVertically(-1);
        }
        return invokeL.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.f.setSelection(0);
            C();
            ScrollFragmentTabHost.y yVar = this.t;
            if (yVar != null) {
                yVar.c();
            }
        }
    }

    public void y(@NonNull ay6 ay6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, ay6Var) == null) {
            if (this.n == null) {
                HotTopicHeaderView hotTopicHeaderView = new HotTopicHeaderView(getContext());
                this.n = hotTopicHeaderView;
                hotTopicHeaderView.setPageContext(this.c);
            }
            this.f.setHeaderView(this.n);
            this.n.setOnItemCoverListener(this.p);
            this.n.setOnTabSelectedListener(this.o);
            this.n.setData(ay6Var.getResData());
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || r()) {
            return;
        }
        if (this.i == null) {
            this.i = new k65(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - ri.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.i.i();
            this.i.s(height);
            this.i.onChangeSkinType();
        }
        this.i.attachView(this, z);
        this.q.q(false);
    }
}
