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
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.tabs.TabLayout;
import com.repackage.bw6;
import com.repackage.fu4;
import com.repackage.gu4;
import com.repackage.iu6;
import com.repackage.j55;
import com.repackage.jm4;
import com.repackage.jv6;
import com.repackage.k55;
import com.repackage.ni;
import com.repackage.nn;
import com.repackage.pi;
import com.repackage.sv6;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class HotTopicTabView extends FrameLayout implements fu4.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public BaseFragment b;
    public TbPageContext<?> c;
    public jv6 d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public sv6 g;
    public gu4 h;
    public j55 i;
    public k55 j;
    public ScrollFragmentTabHost k;
    public int l;
    public PbListView m;
    public HotTopicHeaderView n;
    public TabLayout.OnTabSelectedListener o;
    public jm4 p;
    public iu6 q;
    public boolean r;
    public RecyclerView.OnScrollListener s;
    public ScrollFragmentTabHost.y t;

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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ni.A() && this.a.d != null) {
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
            this.j = new k55(getContext(), new c(this));
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
            this.m.D(getResources().getString(R.string.obfuscated_res_0x7f0f0f62), pi.f(getContext(), R.dimen.tbds158));
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

    @Override // com.repackage.fu4.g
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
            j55 j55Var = this.i;
            if (j55Var != null) {
                j55Var.dettachView(this);
                this.i = null;
            }
            this.q.q(true);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            k55 k55Var = this.j;
            if (k55Var != null) {
                k55Var.dettachView(this);
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02d2, (ViewGroup) this, true);
            this.e = (BdSwipeRefreshLayout) findViewById(R.id.obfuscated_res_0x7f090d72);
            gu4 gu4Var = new gu4(this.c);
            this.h = gu4Var;
            this.e.setProgressView(gu4Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090d71);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.f.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.g = new sv6(this.c, this.f);
            this.q = new iu6(this, this.f);
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
            j55 j55Var = this.i;
            if (j55Var != null) {
                return j55Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            k55 k55Var = this.j;
            if (k55Var != null) {
                return k55Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setData(@NonNull bw6 bw6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bw6Var) == null) {
            y(bw6Var);
            setListData(bw6Var.getDataList());
        }
    }

    public void setListData(@NonNull List<nn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.g.d(list);
        }
    }

    public void setOnItemCoverListener(jm4 jm4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jm4Var) == null) {
            this.p = jm4Var;
            sv6 sv6Var = this.g;
            if (sv6Var != null) {
                sv6Var.e(jm4Var);
            }
            HotTopicHeaderView hotTopicHeaderView = this.n;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.setOnItemCoverListener(jm4Var);
            }
        }
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onTabSelectedListener) == null) {
            this.o = onTabSelectedListener;
        }
    }

    public void setPresenter(jv6 jv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, jv6Var) == null) {
            this.d = jv6Var;
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
            sv6 sv6Var = this.g;
            if (sv6Var != null) {
                sv6Var.f(bdUniqueId);
            }
            gu4 gu4Var = this.h;
            if (gu4Var != null) {
                gu4Var.b0(bdUniqueId);
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
        iu6 iu6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (iu6Var = this.q) == null) {
            return;
        }
        iu6Var.f();
    }

    public void v() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        gu4 gu4Var = this.h;
        if (gu4Var != null) {
            gu4Var.H(skinType);
        }
        j55 j55Var = this.i;
        if (j55Var != null) {
            j55Var.onChangeSkinType();
        }
        k55 k55Var = this.j;
        if (k55Var != null) {
            k55Var.onChangeSkinType();
        }
        sv6 sv6Var = this.g;
        if (sv6Var != null) {
            sv6Var.c();
        }
        PbListView pbListView = this.m;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.m.p(R.color.transparent);
        }
        HotTopicHeaderView hotTopicHeaderView = this.n;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.c(skinType);
        }
        iu6 iu6Var = this.q;
        if (iu6Var != null) {
            iu6Var.n();
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

    public void y(@NonNull bw6 bw6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bw6Var) == null) {
            if (this.n == null) {
                this.n = new HotTopicHeaderView(getContext());
            }
            this.f.setHeaderView(this.n);
            this.n.setOnItemCoverListener(this.p);
            this.n.setOnTabSelectedListener(this.o);
            this.n.setData(bw6Var.getResData());
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || r()) {
            return;
        }
        if (this.i == null) {
            this.i = new j55(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - pi.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.i.i();
            this.i.s(height);
            this.i.onChangeSkinType();
        }
        this.i.attachView(this, z);
        this.q.q(false);
    }
}
