package com.baidu.tieba.homepage.hotTopic.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.f95;
import com.baidu.tieba.fy6;
import com.baidu.tieba.g95;
import com.baidu.tieba.gz6;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.qp4;
import com.baidu.tieba.qz6;
import com.baidu.tieba.yx4;
import com.baidu.tieba.zx4;
import com.baidu.tieba.zz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class HotTopicTabView extends FrameLayout implements yx4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public gz6 c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public qz6 f;
    public zx4 g;
    public f95 h;
    public g95 i;
    public ScrollFragmentTabHost j;
    public int k;
    public PbListView l;
    public HotTopicHeaderView m;
    public TabLayout.OnTabSelectedListener n;
    public qp4 o;
    public fy6 p;
    public boolean q;
    public RecyclerView.OnScrollListener r;
    public ScrollFragmentTabHost.y s;

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
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) || this.a.k == i || this.a.j == null) {
                return;
            }
            this.a.k = i;
            if (this.a.k == 1) {
                this.a.j.a();
            } else if (this.a.w(recyclerView)) {
                this.a.j.c();
            } else {
                this.a.j.a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (this.a.p != null) {
                    this.a.p.j();
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            this.a.k = -1;
            HotTopicTabView hotTopicTabView = this.a;
            if (hotTopicTabView.w(hotTopicTabView.e)) {
                this.a.j.c();
            } else {
                this.a.j.a();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately() && this.a.c != null) {
                this.a.z(false);
                this.a.c.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabView(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.r = new a(this);
        this.s = new b(this);
        this.b = tbPageContext;
        p(tbPageContext.getPageActivity(), str);
        q();
        v();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || s()) {
            return;
        }
        if (this.i == null) {
            this.i = new g95(getContext(), new c(this));
        }
        this.i.attachView(this, z);
        this.i.p();
        this.p.q(false);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setNextPage(this.l);
            this.l.f();
            this.l.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.l.E(getResources().getString(R.string.obfuscated_res_0x7f0f0fa2), ej.f(getContext(), R.dimen.tbds158));
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.setRefreshing(true);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.yx4.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c.a();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.s);
            }
            D();
            m();
            n();
            this.q = true;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            f95 f95Var = this.h;
            if (f95Var != null) {
                f95Var.dettachView(this);
                this.h = null;
            }
            this.p.q(true);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            g95 g95Var = this.i;
            if (g95Var != null) {
                g95Var.dettachView(this);
                this.i = null;
            }
            this.p.q(true);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.setNextPage(null);
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

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02da, (ViewGroup) this, true);
            this.d = (BdSwipeRefreshLayout) findViewById(R.id.obfuscated_res_0x7f090dcf);
            zx4 zx4Var = new zx4(this.b);
            this.g = zx4Var;
            this.d.setProgressView(zx4Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090dce);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f = new qz6(this.b, this.e);
            this.p = new fy6(this, this.e);
            if (!TextUtils.isEmpty(str)) {
                this.p.p(str);
            }
            this.p.o(this.b);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.l = pbListView;
            pbListView.a();
            this.l.p(R.color.CAM_X0205);
            this.l.B(R.color.CAM_X0111);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.addOnScrollListener(this.r);
            this.g.f(this);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            f95 f95Var = this.h;
            if (f95Var != null) {
                return f95Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            g95 g95Var = this.i;
            if (g95Var != null) {
                return g95Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setData(@NonNull zz6 zz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zz6Var) == null) {
            y(zz6Var);
            setListData(zz6Var.getDataList());
        }
    }

    public void setListData(@NonNull List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f.d(list);
        }
    }

    public void setOnItemCoverListener(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, qp4Var) == null) {
            this.o = qp4Var;
            qz6 qz6Var = this.f;
            if (qz6Var != null) {
                qz6Var.e(qp4Var);
            }
            HotTopicHeaderView hotTopicHeaderView = this.m;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.setOnItemCoverListener(qp4Var);
            }
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onTabSelectedListener) == null) {
            this.n = onTabSelectedListener;
        }
    }

    public void setPresenter(gz6 gz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gz6Var) == null) {
            this.c = gz6Var;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, scrollFragmentTabHost) == null) {
            this.j = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.s);
                this.j.b(this.s);
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            qz6 qz6Var = this.f;
            if (qz6Var != null) {
                qz6Var.f(bdUniqueId);
            }
            zx4 zx4Var = this.g;
            if (zx4Var != null) {
                zx4Var.b0(bdUniqueId);
            }
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.s);
                this.j.b(this.s);
                this.s.c();
            }
            if (this.q) {
                this.q = false;
                if (ListUtils.isEmpty(this.f.a())) {
                    this.c.a();
                }
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            HotTopicHeaderView hotTopicHeaderView = this.m;
            return (hotTopicHeaderView == null || hotTopicHeaderView.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        fy6 fy6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (fy6Var = this.p) == null) {
            return;
        }
        fy6Var.f();
    }

    public void v() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        zx4 zx4Var = this.g;
        if (zx4Var != null) {
            zx4Var.H(skinType);
        }
        f95 f95Var = this.h;
        if (f95Var != null) {
            f95Var.onChangeSkinType();
        }
        g95 g95Var = this.i;
        if (g95Var != null) {
            g95Var.onChangeSkinType();
        }
        qz6 qz6Var = this.f;
        if (qz6Var != null) {
            qz6Var.c();
        }
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.l.p(R.color.transparent);
        }
        HotTopicHeaderView hotTopicHeaderView = this.m;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.i(skinType);
        }
        fy6 fy6Var = this.p;
        if (fy6Var != null) {
            fy6Var.n();
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
            this.e.setSelection(0);
            C();
            ScrollFragmentTabHost.y yVar = this.s;
            if (yVar != null) {
                yVar.c();
            }
        }
    }

    public void y(@NonNull zz6 zz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, zz6Var) == null) {
            if (this.m == null) {
                HotTopicHeaderView hotTopicHeaderView = new HotTopicHeaderView(getContext());
                this.m = hotTopicHeaderView;
                hotTopicHeaderView.setPageContext(this.b);
            }
            this.e.setHeaderView(this.m);
            this.m.setOnItemCoverListener(this.o);
            this.m.setOnTabSelectedListener(this.n);
            this.m.setData(zz6Var.getResData());
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || r()) {
            return;
        }
        if (this.h == null) {
            this.h = new f95(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - ej.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.h.i();
            this.h.s(height);
            this.h.onChangeSkinType();
        }
        this.h.attachView(this, z);
        this.p.q(false);
    }
}
