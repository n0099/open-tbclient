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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import com.repackage.ft4;
import com.repackage.gt4;
import com.repackage.gu6;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.kl4;
import com.repackage.li;
import com.repackage.ot6;
import com.repackage.s35;
import com.repackage.t35;
import com.repackage.xt6;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class HotTopicTabView extends FrameLayout implements ft4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public ot6 c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public xt6 f;
    public gt4 g;
    public s35 h;
    public t35 i;
    public ScrollFragmentTabHost j;
    public int k;
    public PbListView l;
    public HotTopicHeaderView m;
    public TabLayout.OnTabSelectedListener n;
    public kl4 o;
    public boolean p;
    public RecyclerView.OnScrollListener q;
    public ScrollFragmentTabHost.x r;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) || this.a.k == i || this.a.j == null) {
                return;
            }
            this.a.k = i;
            if (this.a.k == 1) {
                this.a.j.Y();
            } else if (this.a.r(recyclerView)) {
                this.a.j.C();
            } else {
                this.a.j.Y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ScrollFragmentTabHost.x {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.x
        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            this.a.k = -1;
            HotTopicTabView hotTopicTabView = this.a;
            if (hotTopicTabView.r(hotTopicTabView.e)) {
                this.a.j.C();
            } else {
                this.a.j.Y();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ji.A() && this.a.c != null) {
                this.a.u(false);
                this.a.c.loadData();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabView(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.k = -1;
        this.q = new a(this);
        this.r = new b(this);
        this.b = tbPageContext;
        l(tbPageContext.getPageActivity());
        m();
        q();
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.U(this.r);
            }
            y();
            i();
            j();
            this.p = true;
        }
    }

    public void i() {
        s35 s35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (s35Var = this.h) == null) {
            return;
        }
        s35Var.dettachView(this);
        this.h = null;
    }

    public void j() {
        t35 t35Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (t35Var = this.i) == null) {
            return;
        }
        t35Var.dettachView(this);
        this.i = null;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.setNextPage(null);
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02d3, (ViewGroup) this, true);
            this.d = (BdSwipeRefreshLayout) findViewById(R.id.obfuscated_res_0x7f090d73);
            gt4 gt4Var = new gt4(this.b);
            this.g = gt4Var;
            this.d.setProgressView(gt4Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090d72);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f = new xt6(this.b, this.e);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.l = pbListView;
            pbListView.a();
            this.l.p(R.color.CAM_X0205);
            this.l.A(R.color.CAM_X0111);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.addOnScrollListener(this.q);
            this.g.e(this);
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            s35 s35Var = this.h;
            if (s35Var != null) {
                return s35Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            t35 t35Var = this.i;
            if (t35Var != null) {
                return t35Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h();
            super.onDetachedFromWindow();
        }
    }

    @Override // com.repackage.ft4.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.c.loadData();
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            HotTopicHeaderView hotTopicHeaderView = this.m;
            return (hotTopicHeaderView == null || hotTopicHeaderView.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void q() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        gt4 gt4Var = this.g;
        if (gt4Var != null) {
            gt4Var.H(skinType);
        }
        s35 s35Var = this.h;
        if (s35Var != null) {
            s35Var.onChangeSkinType();
        }
        t35 t35Var = this.i;
        if (t35Var != null) {
            t35Var.onChangeSkinType();
        }
        xt6 xt6Var = this.f;
        if (xt6Var != null) {
            xt6Var.c();
        }
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.l.p(R.color.transparent);
        }
        HotTopicHeaderView hotTopicHeaderView = this.m;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.c(skinType);
        }
    }

    public final boolean r(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, recyclerView)) == null) {
            if (recyclerView == null) {
                return true;
            }
            return !recyclerView.canScrollVertically(-1);
        }
        return invokeL.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.setSelection(0);
            x();
            ScrollFragmentTabHost.x xVar = this.r;
            if (xVar != null) {
                xVar.c();
            }
        }
    }

    public void setData(@NonNull gu6 gu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gu6Var) == null) {
            t(gu6Var);
            setListData(gu6Var.getDataList());
        }
    }

    public void setListData(@NonNull List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f.d(list);
        }
    }

    public void setOnItemCoverListener(kl4 kl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, kl4Var) == null) {
            this.o = kl4Var;
            xt6 xt6Var = this.f;
            if (xt6Var != null) {
                xt6Var.e(kl4Var);
            }
            HotTopicHeaderView hotTopicHeaderView = this.m;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.setOnItemCoverListener(kl4Var);
            }
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onTabSelectedListener) == null) {
            this.n = onTabSelectedListener;
        }
    }

    public void setPresenter(ot6 ot6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, ot6Var) == null) {
            this.c = ot6Var;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, scrollFragmentTabHost) == null) {
            this.j = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.U(this.r);
                this.j.z(this.r);
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            xt6 xt6Var = this.f;
            if (xt6Var != null) {
                xt6Var.f(bdUniqueId);
            }
            gt4 gt4Var = this.g;
            if (gt4Var != null) {
                gt4Var.a0(bdUniqueId);
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.U(this.r);
                this.j.z(this.r);
                this.r.c();
            }
            if (this.p) {
                this.p = false;
                if (ListUtils.isEmpty(this.f.a())) {
                    this.c.loadData();
                }
            }
        }
    }

    public void t(@NonNull gu6 gu6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gu6Var) == null) {
            if (this.m == null) {
                this.m = new HotTopicHeaderView(getContext());
            }
            this.e.setHeaderView(this.m);
            this.m.setOnItemCoverListener(this.o);
            this.m.setOnTabSelectedListener(this.n);
            this.m.setData(gu6Var.getResData());
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || n()) {
            return;
        }
        if (this.h == null) {
            this.h = new s35(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - li.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.h.i();
            this.h.s(height);
            this.h.onChangeSkinType();
        }
        this.h.attachView(this, z);
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || o()) {
            return;
        }
        if (this.i == null) {
            this.i = new t35(getContext(), new c(this));
        }
        this.i.attachView(this, z);
        this.i.p();
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.e.setNextPage(this.l);
            this.l.f();
            this.l.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.l.D(getResources().getString(R.string.obfuscated_res_0x7f0f0f5c), li.f(getContext(), R.dimen.tbds158));
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.d.setRefreshing(true);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.d.setRefreshing(false);
        }
    }
}
