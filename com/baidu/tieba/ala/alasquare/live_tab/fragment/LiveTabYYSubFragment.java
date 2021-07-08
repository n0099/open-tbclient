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
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.d0.h;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveTabYYSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View n;
    public BdSwipeRefreshLayout o;
    public BdTypeRecyclerView p;
    public d.a.p0.v.d.c.a q;
    public g r;
    public PbListView s;
    public AlaLiveYYSubTabModel t;
    public int u;
    public int v;
    public AlaLiveYYSubTabModel.b w;
    public f.g x;
    public BdListView.p y;
    public RecyclerView.OnScrollListener z;

    /* loaded from: classes4.dex */
    public class a implements AlaLiveYYSubTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabYYSubFragment f13986a;

        public a(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13986a = liveTabYYSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.f13986a.l();
                this.f13986a.Y0();
                if (z) {
                    this.f13986a.e1();
                } else {
                    this.f13986a.h1();
                }
                this.f13986a.j1();
                this.f13986a.b1(list);
                if (ListUtils.isEmpty(list)) {
                    this.f13986a.M0();
                } else {
                    this.f13986a.H0();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f13986a.j1();
                this.f13986a.l();
                this.f13986a.Y0();
                if (!z) {
                    if (!this.f13986a.t.d()) {
                        this.f13986a.g1();
                        return;
                    } else {
                        this.f13986a.showToast(R.string.data_load_error);
                        return;
                    }
                }
                this.f13986a.showToast(R.string.data_load_error);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabYYSubFragment f13987e;

        public b(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13987e = liveTabYYSubFragment;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f13987e.t.refresh();
                } else {
                    this.f13987e.j1();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabYYSubFragment f13988e;

        public c(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13988e = liveTabYYSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f13988e.X0();
                } else {
                    this.f13988e.t.loadMore();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabYYSubFragment f13989a;

        public d(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13989a = liveTabYYSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 >= this.f13989a.v) {
                    LiveTabYYSubFragment liveTabYYSubFragment = this.f13989a;
                    if (liveTabYYSubFragment.f13975i) {
                        return;
                    }
                    liveTabYYSubFragment.I0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabYYSubFragment f13990e;

        public e(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13990e = liveTabYYSubFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f13990e.loadData();
            }
        }
    }

    public LiveTabYYSubFragment() {
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
        this.v = 4;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
        this.z = new d(this);
    }

    public static LiveTabYYSubFragment a1(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            Bundle bundle = new Bundle();
            LiveTabYYSubFragment liveTabYYSubFragment = new LiveTabYYSubFragment();
            bundle.putBoolean("arg_after_lazy_loaded", z);
            bundle.putInt("arg_tab_id", i2);
            liveTabYYSubFragment.setArguments(bundle);
            return liveTabYYSubFragment;
        }
        return (LiveTabYYSubFragment) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void K0() {
        d.a.p0.v.d.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.b();
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.p.setNextPage(null);
        }
    }

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13972f.setVisibility(8);
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.dettachView(this.f13972f);
                this.mRefreshView = null;
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o = (BdSwipeRefreshLayout) this.n.findViewById(R.id.live_tab_refresh_layout);
            this.f13972f = (LinearLayout) this.n.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.r = gVar;
            this.o.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.n.findViewById(R.id.live_tab_list_view);
            this.p = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f13971e));
            this.p.setFadingEdgeLength(0);
            this.p.setOverScrollMode(2);
            this.q = new d.a.p0.v.d.c.a(getPageContext(), this.p, this.j);
            PbListView pbListView = new PbListView(this.f13971e);
            this.s = pbListView;
            pbListView.a();
            this.s.o(R.color.transparent);
            this.s.r(l.g(this.f13971e, R.dimen.tbds182));
            this.s.v();
            this.s.E(R.dimen.tbfontsize33);
            this.s.C(SkinManager.getColor(R.color.CAM_X0107));
            this.s.y(R.color.CAM_X0110);
            this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.r.a0(getPageContext().getUniqueId());
            this.p.addOnScrollListener(this.z);
            c1(this.x);
            d1(this.y);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void b1(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.q.c(list);
        }
    }

    public final void c1(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || (gVar2 = this.r) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public final void d1(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) || (bdTypeRecyclerView = this.p) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void e1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.p.setNextPage(this.s);
        }
        this.s.r(l.g(this.f13971e, R.dimen.tbds182));
        this.s.A(this.f13971e.getResources().getString(R.string.loading));
        this.s.O();
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f13972f.setVisibility(0);
            super.showLoadingView(this.f13972f, false, this.u);
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f13972f.setVisibility(0);
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new e(this));
            }
            this.mRefreshView.o();
            this.mRefreshView.l(null);
            this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.k(0);
            this.mRefreshView.onChangeSkinType();
            this.mRefreshView.attachView(this.f13972f, false);
        }
    }

    public final void h1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.p.setNextPage(this.s);
        }
        this.s.r(l.g(this.f13971e, R.dimen.tbds182));
        this.s.A(this.f13971e.getResources().getString(R.string.list_no_more));
        this.s.f();
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o.setRefreshing(true);
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o.setRefreshing(false);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f13972f.setVisibility(8);
            super.hideLoadingView(this.f13972f);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.t == null) {
            return;
        }
        Y0();
        f1();
        this.t.refresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.p.setSelection(0);
            i1();
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
            d.a.p0.v.d.c.a aVar = this.q;
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
            this.f13971e = getPageContext().getPageActivity();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13974h = arguments.getBoolean("arg_after_lazy_loaded", false);
                this.j = arguments.getInt("arg_tab_id", 0);
            }
            if (this.t == null) {
                this.t = new AlaLiveYYSubTabModel(getPageContext(), this.w, this.j);
            }
            this.t.init();
            this.t.I(this.k, this.l);
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
                Z0();
                if (viewGroup != null) {
                    this.u = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                }
            }
            if (this.f13974h) {
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
                bdTypeRecyclerView.removeOnScrollListener(this.z);
                this.p.setOnSrollToBottomListener(null);
            }
            g gVar = this.r;
            if (gVar != null) {
                gVar.a(null);
                this.r.Y();
            }
            AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.t;
            if (alaLiveYYSubTabModel != null) {
                alaLiveYYSubTabModel.onDestroy();
            }
        }
    }
}
