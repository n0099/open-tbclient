package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel;
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
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View n;
    public BdSwipeRefreshLayout o;
    public BdTypeRecyclerView p;
    public d.a.q0.v.d.c.a q;
    public g r;
    public PbListView s;
    public AlaLiveTabFriendModel t;
    public int u;
    public AlaLiveTabFriendModel.b v;
    public f.g w;
    public BdListView.p x;
    public RecyclerView.OnScrollListener y;

    /* loaded from: classes4.dex */
    public class a implements AlaLiveTabFriendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f14025a;

        public a(LiveTabFriendSubFragment liveTabFriendSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFriendSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14025a = liveTabFriendSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.f14025a.l();
                this.f14025a.c1();
                if (z) {
                    this.f14025a.i1();
                } else {
                    this.f14025a.l1();
                }
                this.f14025a.n1();
                this.f14025a.f1(list);
                if (ListUtils.isEmpty(list)) {
                    this.f14025a.R0();
                } else {
                    this.f14025a.M0();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f14025a.n1();
                this.f14025a.l();
                this.f14025a.c1();
                if (!z) {
                    if (!this.f14025a.t.d()) {
                        this.f14025a.k1();
                        return;
                    } else {
                        this.f14025a.showToast(R.string.data_load_error);
                        return;
                    }
                }
                this.f14025a.showToast(R.string.data_load_error);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f14026e;

        public b(LiveTabFriendSubFragment liveTabFriendSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFriendSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14026e = liveTabFriendSubFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f14026e.t.refresh();
                } else {
                    this.f14026e.n1();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f14027e;

        public c(LiveTabFriendSubFragment liveTabFriendSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFriendSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14027e = liveTabFriendSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f14027e.b1();
                } else {
                    this.f14027e.t.loadMore();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f14028a;

        public d(LiveTabFriendSubFragment liveTabFriendSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFriendSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14028a = liveTabFriendSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 >= 4) {
                    LiveTabFriendSubFragment liveTabFriendSubFragment = this.f14028a;
                    if (liveTabFriendSubFragment.f14023i) {
                        return;
                    }
                    liveTabFriendSubFragment.N0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f14029e;

        public e(LiveTabFriendSubFragment liveTabFriendSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabFriendSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14029e = liveTabFriendSubFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f14029e.loadData();
            }
        }
    }

    public LiveTabFriendSubFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new c(this);
        this.y = new d(this);
    }

    public static LiveTabFriendSubFragment e1(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            Bundle bundle = new Bundle();
            LiveTabFriendSubFragment liveTabFriendSubFragment = new LiveTabFriendSubFragment();
            bundle.putBoolean("arg_after_lazy_loaded", z);
            liveTabFriendSubFragment.setArguments(bundle);
            return liveTabFriendSubFragment;
        }
        return (LiveTabFriendSubFragment) invokeZ.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void P0() {
        d.a.q0.v.d.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.b();
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.p.setNextPage(null);
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14020f.setVisibility(8);
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.dettachView(this.f14020f);
                this.mRefreshView = null;
            }
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o = (BdSwipeRefreshLayout) this.n.findViewById(R.id.live_tab_refresh_layout);
            this.f14020f = (LinearLayout) this.n.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.r = gVar;
            this.o.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.n.findViewById(R.id.live_tab_list_view);
            this.p = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f14019e));
            this.p.setFadingEdgeLength(0);
            this.p.setOverScrollMode(2);
            this.q = new d.a.q0.v.d.c.a(getPageContext(), this.p, 103);
            PbListView pbListView = new PbListView(this.f14019e);
            this.s = pbListView;
            pbListView.a();
            this.s.o(R.color.transparent);
            this.s.r(l.g(this.f14019e, R.dimen.tbds182));
            this.s.v();
            this.s.E(R.dimen.tbfontsize33);
            this.s.C(SkinManager.getColor(R.color.CAM_X0107));
            this.s.y(R.color.CAM_X0110);
            this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.r.a0(getPageContext().getUniqueId());
            this.p.addOnScrollListener(this.y);
            g1(this.w);
            h1(this.x);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void f1(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.q.c(list);
        }
    }

    public final void g1(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || (gVar2 = this.r) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public final void h1(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) || (bdTypeRecyclerView = this.p) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void i1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.p.setNextPage(this.s);
        }
        this.s.r(l.g(this.f14019e, R.dimen.tbds182));
        this.s.A(this.f14019e.getResources().getString(R.string.loading));
        this.s.O();
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f14020f.setVisibility(0);
            super.showLoadingView(this.f14020f, false, this.u);
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f14020f.setVisibility(0);
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new e(this));
            }
            this.mRefreshView.o();
            this.mRefreshView.l(null);
            this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.k(0);
            this.mRefreshView.onChangeSkinType();
            this.mRefreshView.attachView(this.f14020f, false);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f14020f.setVisibility(8);
            super.hideLoadingView(this.f14020f);
        }
    }

    public final void l1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.p.setNextPage(this.s);
        }
        this.s.r(l.g(this.f14019e, R.dimen.tbds182));
        this.s.A(this.f14019e.getResources().getString(R.string.list_no_more));
        this.s.f();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.t == null) {
            return;
        }
        c1();
        j1();
        this.t.refresh();
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.o.setRefreshing(true);
        }
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.o.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.p.setSelection(0);
            m1();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.r;
            if (gVar != null) {
                gVar.I(i2);
            }
            PbListView pbListView = this.s;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.s.d(i2);
            }
            d.a.q0.v.d.c.a aVar = this.q;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            this.f14019e = getPageContext().getPageActivity();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f14022h = arguments.getBoolean("arg_after_lazy_loaded", false);
            }
            if (this.t == null) {
                this.t = new AlaLiveTabFriendModel(getPageContext(), this.v);
                this.f14022h = true;
            }
            this.t.init();
            registerListener(this.m);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.n == null) {
                this.n = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
                d1();
                if (viewGroup != null) {
                    this.u = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                }
            }
            if (this.f14022h) {
                loadData();
            }
            return this.n;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.p;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.y);
                this.p.setOnSrollToBottomListener(null);
            }
            g gVar = this.r;
            if (gVar != null) {
                gVar.a(null);
                this.r.Y();
            }
            AlaLiveTabFriendModel alaLiveTabFriendModel = this.t;
            if (alaLiveTabFriendModel != null) {
                alaLiveTabFriendModel.onDestroy();
            }
        }
    }
}
