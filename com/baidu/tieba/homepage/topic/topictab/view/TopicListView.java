package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tieba.R;
import com.baidu.tieba.bn;
import com.baidu.tieba.dn5;
import com.baidu.tieba.e98;
import com.baidu.tieba.f98;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.p95;
import com.baidu.tieba.q95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class TopicListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public e98 c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public f98 f;
    public q95 g;
    public LoadingView h;
    public dn5 i;
    public ScrollFragmentTabHost j;
    public PbListView k;
    public RecyclerView.OnScrollListener l;
    public ScrollFragmentTabHost.s m;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicListView a;

        public a(TopicListView topicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately() && this.a.c != null) {
                this.a.e.setVisibility(0);
                this.a.c.b();
            }
        }
    }

    public void setData(List<bn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f.b(list);
    }

    public void setListPullRefreshListener(p95.g gVar) {
        q95 q95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) && (q95Var = this.g) != null) {
            q95Var.a(gVar);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            f98 f98Var = this.f;
            if (f98Var != null) {
                f98Var.c(bdUniqueId);
            }
            q95 q95Var = this.g;
            if (q95Var != null) {
                q95Var.V(bdUniqueId);
            }
        }
    }

    public void setPresenter(e98 e98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, e98Var) == null) {
            this.c = e98Var;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, scrollFragmentTabHost) == null) {
            this.j = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.m);
                this.j.b(this.m);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.e(this.m);
            }
            this.e.removeOnScrollListener(this.l);
            p();
            d();
            e();
        }
    }

    public void d() {
        LoadingView loadingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (loadingView = this.h) != null) {
            loadingView.dettachView(this);
            this.h = null;
        }
    }

    public void e() {
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (dn5Var = this.i) != null) {
            dn5Var.dettachView(this);
            this.i = null;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.removeOnScrollListener(this.l);
            this.e.addOnScrollListener(this.l);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            LoadingView loadingView = this.h;
            if (loadingView != null) {
                return loadingView.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            dn5 dn5Var = this.i;
            if (dn5Var != null) {
                return dn5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.setSelection(0);
            o();
            ScrollFragmentTabHost.s sVar = this.m;
            if (sVar != null) {
                sVar.c();
            }
        }
    }

    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (bdTypeRecyclerView = this.e) != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.d.setRefreshing(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            c();
            super.onDetachedFromWindow();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.d.setRefreshing(false);
        }
    }

    public void setViewForeground() {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (scrollFragmentTabHost = this.j) != null) {
            scrollFragmentTabHost.e(this.m);
            this.j.b(this.m);
            this.m.c();
        }
    }

    public void i() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        q95 q95Var = this.g;
        if (q95Var != null) {
            q95Var.C(skinType);
        }
        LoadingView loadingView = this.h;
        if (loadingView != null) {
            loadingView.onChangeSkinType();
        }
        dn5 dn5Var = this.i;
        if (dn5Var != null) {
            dn5Var.onChangeSkinType();
        }
        f98 f98Var = this.f;
        if (f98Var != null) {
            f98Var.a();
        }
        PbListView pbListView = this.k;
        if (pbListView != null) {
            pbListView.e(skinType);
            this.k.s(R.color.CAM_X0205);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.setNextPage(this.k);
            this.k.g();
            this.k.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.k.w(BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds150));
            this.k.H(getResources().getString(R.string.really_great));
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048585, this, z) != null) || g()) {
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
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048586, this, z) != null) || h()) {
            return;
        }
        if (this.i == null) {
            this.i = new dn5(getContext(), new a(this));
        }
        this.i.attachView(this, z);
        this.i.o();
        this.e.setVisibility(8);
    }
}
