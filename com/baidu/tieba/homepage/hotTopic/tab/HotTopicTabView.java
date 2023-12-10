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
import com.baidu.tieba.av4;
import com.baidu.tieba.de8;
import com.baidu.tieba.fk5;
import com.baidu.tieba.fp5;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.ne8;
import com.baidu.tieba.p55;
import com.baidu.tieba.pi;
import com.baidu.tieba.q55;
import com.baidu.tieba.ve8;
import com.baidu.tieba.zc8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.util.List;
import kotlin.Pair;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class HotTopicTabView extends FrameLayout implements p55.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public de8 c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public ne8 f;
    public q55 g;
    public LoadingView h;
    public fk5 i;
    public ScrollFragmentTabHost j;
    public int k;
    public PbListView l;
    public HotTopicHeaderView m;
    public av4 n;
    public zc8 o;
    public boolean p;
    public RecyclerView.OnScrollListener q;
    public BdUniqueId r;
    public ScrollFragmentTabHost.s s;

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
        this.s = new b(this);
        this.b = tbPageContext;
        p(tbPageContext.getPageActivity(), str);
        q();
        v();
    }

    @Override // com.baidu.tieba.p55.g
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c.c();
        }
    }

    public void setData(@NonNull ve8 ve8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ve8Var) == null) {
            y(ve8Var);
            setListData(ve8Var.getDataList());
        }
    }

    public void setListData(@NonNull List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            if (!ListUtils.isEmpty(this.f.a())) {
                BdUtilHelper.showToast(this.b.getPageActivity(), (int) R.string.obfuscated_res_0x7f0f0a4c);
            }
            this.f.d(list);
        }
    }

    public void setOnItemCoverListener(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, av4Var) == null) {
            this.n = av4Var;
            ne8 ne8Var = this.f;
            if (ne8Var != null) {
                ne8Var.e(av4Var);
            }
            HotTopicHeaderView hotTopicHeaderView = this.m;
            if (hotTopicHeaderView != null) {
                hotTopicHeaderView.setOnItemCoverListener(av4Var);
            }
        }
    }

    public void setPresenter(de8 de8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, de8Var) == null) {
            this.c = de8Var;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, scrollFragmentTabHost) == null) {
            this.j = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.s);
                this.j.b(this.s);
            }
        }
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdUniqueId) == null) {
            this.r = bdUniqueId;
            ne8 ne8Var = this.f;
            if (ne8Var != null) {
                ne8Var.f(bdUniqueId);
            }
            q55 q55Var = this.g;
            if (q55Var != null) {
                q55Var.W(bdUniqueId);
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
            this.i = new fk5(getContext(), new c(this));
        }
        this.i.attachView(this, z);
        this.i.q();
        fp5.a.a(this.r, new Pair<>(PushMessageHelper.ERROR_TYPE, "home_popular"), new Pair<>("error_info", "home popular net error"));
        this.o.r(false);
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
                scrollFragmentTabHost.e(this.s);
                this.j.b(this.s);
                this.s.c();
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

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.s);
            }
            D();
            l();
            m();
            this.p = true;
        }
    }

    public void l() {
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

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            fk5 fk5Var = this.i;
            if (fk5Var != null) {
                fk5Var.dettachView(this);
                this.i = null;
            }
            this.o.r(true);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.setNextPage(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            k();
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
            fk5 fk5Var = this.i;
            if (fk5Var != null) {
                return fk5Var.isViewAttached();
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
        zc8 zc8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (zc8Var = this.o) != null) {
            zc8Var.f();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.e.setSelection(0);
            C();
            ScrollFragmentTabHost.s sVar = this.s;
            if (sVar != null) {
                sVar.c();
            }
        }
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0347, (ViewGroup) this, true);
            this.d = (BdSwipeRefreshLayout) findViewById(R.id.obfuscated_res_0x7f091012);
            q55 q55Var = new q55(this.b);
            this.g = q55Var;
            this.d.setProgressView(q55Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f091011);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.e.setFadingEdgeLength(0);
            this.e.setOverScrollMode(2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            this.e.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
            this.f = new ne8(this.b, this.e);
            this.o = new zc8(this, this.e);
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
        q55 q55Var = this.g;
        if (q55Var != null) {
            q55Var.D(skinType);
        }
        LoadingView loadingView = this.h;
        if (loadingView != null) {
            loadingView.onChangeSkinType();
        }
        fk5 fk5Var = this.i;
        if (fk5Var != null) {
            fk5Var.onChangeSkinType();
        }
        ne8 ne8Var = this.f;
        if (ne8Var != null) {
            ne8Var.c();
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
        zc8 zc8Var = this.o;
        if (zc8Var != null) {
            zc8Var.o();
        }
        u();
    }

    public void y(@NonNull ve8 ve8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, ve8Var) == null) {
            if (this.m == null) {
                HotTopicHeaderView hotTopicHeaderView = new HotTopicHeaderView(getContext());
                this.m = hotTopicHeaderView;
                hotTopicHeaderView.setPageContext(this.b);
            }
            this.e.setHeaderView(this.m);
            this.m.setOnItemCoverListener(this.n);
            this.m.setData(ve8Var.getResData());
            fp5.a.h(this.r);
        }
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
