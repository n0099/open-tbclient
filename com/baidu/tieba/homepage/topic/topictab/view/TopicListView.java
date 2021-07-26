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
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicListView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f17015e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f17016f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.e1.k.b.a f17017g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f17018h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeRecyclerView f17019i;
    public d.a.q0.e1.k.b.b.a j;
    public g k;
    public d.a.p0.f0.g l;
    public h m;
    public ScrollFragmentTabHost n;
    public PbListView o;
    public RecyclerView.OnScrollListener p;
    public ScrollFragmentTabHost.s q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicListView f17020e;

        public a(TopicListView topicListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17020e = topicListView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f17020e.f17017g != null) {
                this.f17020e.f17019i.setVisibility(0);
                this.f17020e.f17017g.loadData();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ScrollFragmentTabHost scrollFragmentTabHost = this.n;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.q);
            }
            this.f17019i.removeOnScrollListener(this.p);
            p();
            d();
            e();
        }
    }

    public void d() {
        d.a.p0.f0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.dettachView(this);
        this.l = null;
    }

    public void e() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (hVar = this.m) == null) {
            return;
        }
        hVar.dettachView(this);
        this.m = null;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17019i.removeOnScrollListener(this.p);
            this.f17019i.addOnScrollListener(this.p);
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.p0.f0.g gVar = this.l;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            h hVar = this.m;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f17015e) {
            return;
        }
        this.f17015e = skinType;
        g gVar = this.k;
        if (gVar != null) {
            gVar.I(skinType);
        }
        d.a.p0.f0.g gVar2 = this.l;
        if (gVar2 != null) {
            gVar2.onChangeSkinType();
        }
        h hVar = this.m;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        d.a.q0.e1.k.b.b.a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
        PbListView pbListView = this.o;
        if (pbListView != null) {
            pbListView.d(skinType);
            this.o.o(R.color.CAM_X0205);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f17019i.setSelection(0);
            o();
            ScrollFragmentTabHost.s sVar = this.q;
            if (sVar != null) {
                sVar.c();
            }
        }
    }

    public void k() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bdTypeRecyclerView = this.f17019i) == null) {
            return;
        }
        bdTypeRecyclerView.setVisibility(0);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || g()) {
            return;
        }
        if (this.l == null) {
            this.l = new d.a.p0.f0.g(getContext());
            int height = (((getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
            this.l.h();
            this.l.q(height);
            this.l.onChangeSkinType();
        }
        this.l.attachView(this, z);
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || h()) {
            return;
        }
        if (this.m == null) {
            this.m = new h(getContext(), new a(this));
        }
        this.m.attachView(this, z);
        this.m.o();
        this.f17019i.setVisibility(8);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f17019i.setNextPage(this.o);
            this.o.f();
            this.o.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.o.r(l.g(this.f17016f.getPageActivity(), R.dimen.tbds150));
            this.o.A(getResources().getString(R.string.really_great));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f17018h.setRefreshing(true);
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
            this.f17018h.setRefreshing(false);
        }
    }

    public void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.j.b(list);
    }

    public void setListPullRefreshListener(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) || (gVar2 = this.k) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bdUniqueId) == null) {
            d.a.q0.e1.k.b.b.a aVar = this.j;
            if (aVar != null) {
                aVar.c(bdUniqueId);
            }
            g gVar = this.k;
            if (gVar != null) {
                gVar.a0(bdUniqueId);
            }
        }
    }

    public void setPresenter(d.a.q0.e1.k.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.f17017g = aVar;
        }
    }

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, scrollFragmentTabHost) == null) {
            this.n = scrollFragmentTabHost;
            if (scrollFragmentTabHost != null) {
                scrollFragmentTabHost.S(this.q);
                this.n.w(this.q);
            }
        }
    }

    public void setViewForeground() {
        ScrollFragmentTabHost scrollFragmentTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (scrollFragmentTabHost = this.n) == null) {
            return;
        }
        scrollFragmentTabHost.S(this.q);
        this.n.w(this.q);
        this.q.c();
    }
}
