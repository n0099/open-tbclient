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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.aa5;
import com.baidu.tieba.cn;
import com.baidu.tieba.d48;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.l48;
import com.baidu.tieba.p28;
import com.baidu.tieba.t38;
import com.baidu.tieba.wn5;
import com.baidu.tieba.wz4;
import com.baidu.tieba.z95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class HotTopicTabView extends FrameLayout implements z95.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public t38 c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public d48 f;
    public aa5 g;
    public LoadingView h;
    public wn5 i;
    public ScrollFragmentTabHost j;
    public int k;
    public PbListView l;
    public HotTopicHeaderView m;
    public wz4 n;
    public p28 o;
    public boolean p;
    public RecyclerView.OnScrollListener q;
    public ScrollFragmentTabHost.s r;

    /* loaded from: classes6.dex */
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
            if ((interceptable != null && interceptable.invokeLI(1048576, this, recyclerView, i) != null) || this.a.k == i || this.a.j == null) {
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
                if (this.a.o != null) {
                    this.a.o.j();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ScrollFragmentTabHost.s {
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

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.j == null) {
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

    /* loaded from: classes6.dex */
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
                this.a.c.c();
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
        this.q = new a(this);
        this.r = new b(this);
        this.b = tbPageContext;
        p(tbPageContext.getPageActivity(), str);
        q();
        v();
    }

    @Override // com.baidu.tieba.z95.g
    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c.c();
        }
    }

    public void setData(@NonNull l48 l48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, l48Var) == null) {
            y(l48Var);
            setListData(l48Var.getDataList());
        }
    }

    public void setListData(@NonNull List<cn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            if (!ListUtils.isEmpty(this.f.a())) {
                BdUtilHelper.showToast(this.b.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0a29);
            }
            this.f.d(list);
        }
    }

    public void setOnItemCoverListener(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, wz4Var) == null) {
            this.n = wz4Var;
            d48 d48Var = this.f;
            if (d48Var != null) {
                d48Var.e(wz4Var);
            }
            HotTopicHeaderView hotTopicHeaderView = this.m;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.setOnItemCoverListener(wz4Var);
            }
        }
    }

    public void setPresenter(t38 t38Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, t38Var) == null) {
            this.c = t38Var;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, scrollFragmentTabHost) == null) {
            this.j = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.r);
                this.j.b(this.r);
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            d48 d48Var = this.f;
            if (d48Var != null) {
                d48Var.f(bdUniqueId);
            }
            aa5 aa5Var = this.g;
            if (aa5Var != null) {
                aa5Var.V(bdUniqueId);
            }
        }
    }

    public final boolean w(RecyclerView recyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, recyclerView)) == null) {
            if (recyclerView == null) {
                return true;
            }
            return !recyclerView.canScrollVertically(-1);
        }
        return invokeL.booleanValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || s()) {
            return;
        }
        if (this.i == null) {
            this.i = new wn5(getContext(), new c(this));
        }
        this.i.attachView(this, z);
        this.i.o();
        this.o.r(false);
    }

    public void y(@NonNull l48 l48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, l48Var) == null) {
            if (this.m == null) {
                HotTopicHeaderView hotTopicHeaderView = new HotTopicHeaderView(getContext());
                this.m = hotTopicHeaderView;
                hotTopicHeaderView.setPageContext(this.b);
            }
            this.e.setHeaderView(this.m);
            this.m.setOnItemCoverListener(this.n);
            this.m.setData(l48Var.getResData());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.setNextPage(this.l);
            this.l.g();
            this.l.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.l.I(getResources().getString(R.string.really_great), BdUtilHelper.getDimens(getContext(), R.dimen.tbds158));
        }
    }

    public void setViewForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.r);
                this.j.b(this.r);
                this.r.c();
            }
            if (this.p) {
                this.p = false;
                if (ListUtils.isEmpty(this.f.a())) {
                    this.c.c();
                }
            }
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

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.r);
            }
            D();
            m();
            n();
            this.p = true;
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LoadingView loadingView = this.h;
            if (loadingView != null) {
                loadingView.dettachView(this);
                this.h = null;
            }
            this.o.r(true);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            wn5 wn5Var = this.i;
            if (wn5Var != null) {
                wn5Var.dettachView(this);
                this.i = null;
            }
            this.o.r(true);
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

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.addOnScrollListener(this.q);
            this.g.a(this);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            LoadingView loadingView = this.h;
            if (loadingView != null) {
                return loadingView.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            wn5 wn5Var = this.i;
            if (wn5Var != null) {
                return wn5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            HotTopicHeaderView hotTopicHeaderView = this.m;
            if (hotTopicHeaderView != null && hotTopicHeaderView.getParent() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        p28 p28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (p28Var = this.o) != null) {
            p28Var.f();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.e.setSelection(0);
            C();
            ScrollFragmentTabHost.s sVar = this.r;
            if (sVar != null) {
                sVar.c();
            }
        }
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d032f, (ViewGroup) this, true);
            this.d = (BdSwipeRefreshLayout) findViewById(R.id.obfuscated_res_0x7f090fa3);
            aa5 aa5Var = new aa5(this.b);
            this.g = aa5Var;
            this.d.setProgressView(aa5Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090fa2);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f = new d48(this.b, this.e);
            this.o = new p28(this, this.e);
            if (!TextUtils.isEmpty(str)) {
                this.o.q(str);
            }
            this.o.p(this.b);
            PbListView pbListView = new PbListView(this.b.getPageActivity());
            this.l = pbListView;
            pbListView.a();
            this.l.s(R.color.CAM_X0205);
            this.l.F(R.color.CAM_X0111);
        }
    }

    public void v() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        aa5 aa5Var = this.g;
        if (aa5Var != null) {
            aa5Var.C(skinType);
        }
        LoadingView loadingView = this.h;
        if (loadingView != null) {
            loadingView.onChangeSkinType();
        }
        wn5 wn5Var = this.i;
        if (wn5Var != null) {
            wn5Var.onChangeSkinType();
        }
        d48 d48Var = this.f;
        if (d48Var != null) {
            d48Var.c();
        }
        PbListView pbListView = this.l;
        if (pbListView != null) {
            pbListView.e(skinType);
            this.l.s(R.color.transparent);
        }
        HotTopicHeaderView hotTopicHeaderView = this.m;
        if (hotTopicHeaderView != null) {
            hotTopicHeaderView.l(skinType);
        }
        p28 p28Var = this.o;
        if (p28Var != null) {
            p28Var.o();
        }
        u();
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048603, this, z) != null) || r()) {
            return;
        }
        if (this.h == null) {
            this.h = new LoadingView(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - BdUtilHelper.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.h.cancelCenterVertical();
            this.h.setTopMargin(height);
            this.h.onChangeSkinType();
        }
        this.h.attachView(this, z);
        this.o.r(false);
    }
}
