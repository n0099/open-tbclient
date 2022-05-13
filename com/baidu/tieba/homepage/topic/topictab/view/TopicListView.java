package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ki;
import com.repackage.mi;
import com.repackage.pu4;
import com.repackage.q17;
import com.repackage.qu4;
import com.repackage.r17;
import com.repackage.ro;
import com.repackage.x45;
import com.repackage.y45;
import java.util.List;
/* loaded from: classes3.dex */
public class TopicListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public q17 c;
    public BdSwipeRefreshLayout d;
    public BdTypeRecyclerView e;
    public r17 f;
    public qu4 g;
    public x45 h;
    public y45 i;
    public ScrollFragmentTabHost j;
    public PbListView k;
    public RecyclerView.OnScrollListener l;
    public ScrollFragmentTabHost.y m;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ki.A() && this.a.c != null) {
                this.a.e.setVisibility(0);
                this.a.c.loadData();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.j;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.U(this.m);
            }
            this.e.removeOnScrollListener(this.l);
            p();
            d();
            e();
        }
    }

    public void d() {
        x45 x45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (x45Var = this.h) == null) {
            return;
        }
        x45Var.dettachView(this);
        this.h = null;
    }

    public void e() {
        y45 y45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (y45Var = this.i) == null) {
            return;
        }
        y45Var.dettachView(this);
        this.i = null;
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
            x45 x45Var = this.h;
            if (x45Var != null) {
                return x45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            y45 y45Var = this.i;
            if (y45Var != null) {
                return y45Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        qu4 qu4Var = this.g;
        if (qu4Var != null) {
            qu4Var.H(skinType);
        }
        x45 x45Var = this.h;
        if (x45Var != null) {
            x45Var.onChangeSkinType();
        }
        y45 y45Var = this.i;
        if (y45Var != null) {
            y45Var.onChangeSkinType();
        }
        r17 r17Var = this.f;
        if (r17Var != null) {
            r17Var.a();
        }
        PbListView pbListView = this.k;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.k.p(R.color.CAM_X0205);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.setSelection(0);
            o();
            ScrollFragmentTabHost.y yVar = this.m;
            if (yVar != null) {
                yVar.c();
            }
        }
    }

    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bdTypeRecyclerView = this.e) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || g()) {
            return;
        }
        if (this.h == null) {
            this.h = new x45(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - mi.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.h.i();
            this.h.s(height);
            this.h.onChangeSkinType();
        }
        this.h.attachView(this, z);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || h()) {
            return;
        }
        if (this.i == null) {
            this.i = new y45(getContext(), new a(this));
        }
        this.i.attachView(this, z);
        this.i.p();
        this.e.setVisibility(8);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.setNextPage(this.k);
            this.k.f();
            this.k.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.k.t(mi.f(this.b.getPageActivity(), R.dimen.tbds150));
            this.k.C(getResources().getString(R.string.obfuscated_res_0x7f0f0f4d));
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

    public void setData(List<ro> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.f.b(list);
    }

    public void setListPullRefreshListener(pu4.g gVar) {
        qu4 qu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) || (qu4Var = this.g) == null) {
            return;
        }
        qu4Var.e(gVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            r17 r17Var = this.f;
            if (r17Var != null) {
                r17Var.c(bdUniqueId);
            }
            qu4 qu4Var = this.g;
            if (qu4Var != null) {
                qu4Var.a0(bdUniqueId);
            }
        }
    }

    public void setPresenter(q17 q17Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, q17Var) == null) {
            this.c = q17Var;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, scrollFragmentTabHost) == null) {
            this.j = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.U(this.m);
                this.j.z(this.m);
            }
        }
    }

    public void setViewForeground() {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (scrollFragmentTabHost = this.j) == null) {
            return;
        }
        scrollFragmentTabHost.U(this.m);
        this.j.z(this.m);
        this.m.c();
    }
}
