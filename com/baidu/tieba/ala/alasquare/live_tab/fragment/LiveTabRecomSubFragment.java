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
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import java.util.List;
/* loaded from: classes5.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View n;
    public BdSwipeRefreshLayout o;
    public BdTypeRecyclerView p;
    public d.a.s0.v.d.c.a q;
    public g r;
    public PbListView s;
    public AlaLiveTabRecomModel t;
    public AlaLiveTabRecomModel.b u;
    public f.g v;
    public BdListView.p w;
    public RecyclerView.OnScrollListener x;

    /* loaded from: classes5.dex */
    public class a implements AlaLiveTabRecomModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabRecomSubFragment f13943a;

        public a(LiveTabRecomSubFragment liveTabRecomSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabRecomSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13943a = liveTabRecomSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                if (z) {
                    this.f13943a.X0();
                } else {
                    this.f13943a.Y0();
                }
                this.f13943a.a1();
                this.f13943a.U0(list);
                if (ListUtils.isEmpty(list)) {
                    this.f13943a.L0();
                } else {
                    this.f13943a.G0();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f13943a.a1();
                if (z) {
                    this.f13943a.showToast(R.string.data_load_error);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabRecomSubFragment f13944e;

        public b(LiveTabRecomSubFragment liveTabRecomSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabRecomSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13944e = liveTabRecomSubFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f13944e.t.refresh();
                } else {
                    this.f13944e.a1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabRecomSubFragment f13945e;

        public c(LiveTabRecomSubFragment liveTabRecomSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabRecomSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13945e = liveTabRecomSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f13945e.m();
                } else {
                    this.f13945e.t.loadMore();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabRecomSubFragment f13946a;

        public d(LiveTabRecomSubFragment liveTabRecomSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabRecomSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13946a = liveTabRecomSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 >= 4) {
                    LiveTabRecomSubFragment liveTabRecomSubFragment = this.f13946a;
                    if (liveTabRecomSubFragment.f13936i) {
                        return;
                    }
                    liveTabRecomSubFragment.H0();
                }
            }
        }
    }

    public LiveTabRecomSubFragment() {
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
        this.u = new a(this);
        this.v = new b(this);
        this.w = new c(this);
        this.x = new d(this);
    }

    public static LiveTabRecomSubFragment T0(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            Bundle bundle = new Bundle();
            LiveTabRecomSubFragment liveTabRecomSubFragment = new LiveTabRecomSubFragment();
            bundle.putBoolean("arg_after_lazy_loaded", z);
            bundle.putInt("arg_tab_id", i2);
            liveTabRecomSubFragment.setArguments(bundle);
            return liveTabRecomSubFragment;
        }
        return (LiveTabRecomSubFragment) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void J0() {
        d.a.s0.v.d.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.q) == null) {
            return;
        }
        aVar.b();
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.o = (BdSwipeRefreshLayout) this.n.findViewById(R.id.live_tab_refresh_layout);
            this.f13933f = (LinearLayout) this.n.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.r = gVar;
            this.o.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.n.findViewById(R.id.live_tab_list_view);
            this.p = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.f13932e));
            this.p.setFadingEdgeLength(0);
            this.p.setOverScrollMode(2);
            this.q = new d.a.s0.v.d.c.a(getPageContext(), this.p, 101);
            PbListView pbListView = new PbListView(this.f13932e);
            this.s = pbListView;
            pbListView.a();
            this.s.o(R.color.transparent);
            this.s.r(l.g(this.f13932e, R.dimen.tbds182));
            this.s.v();
            this.s.E(R.dimen.tbfontsize33);
            this.s.C(SkinManager.getColor(R.color.CAM_X0107));
            this.s.y(R.color.CAM_X0110);
            this.s.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.r.a0(getPageContext().getUniqueId());
            this.p.addOnScrollListener(this.x);
            V0(this.v);
            W0(this.w);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void U0(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.q.c(list);
        }
    }

    public final void V0(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || (gVar2 = this.r) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public final void W0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) || (bdTypeRecyclerView = this.p) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void X0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.p.setNextPage(this.s);
        }
        this.s.r(l.g(this.f13932e, R.dimen.tbds182));
        this.s.A(this.f13932e.getResources().getString(R.string.loading));
        this.s.O();
    }

    public final void Y0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.s) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.p.setNextPage(this.s);
        }
        this.s.r(l.g(this.f13932e, R.dimen.tbds182));
        this.s.A(this.f13932e.getResources().getString(R.string.list_no_more));
        this.s.f();
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.o.setRefreshing(true);
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.o.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        AlaLiveTabRecomModel alaLiveTabRecomModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (alaLiveTabRecomModel = this.t) == null) {
            return;
        }
        alaLiveTabRecomModel.refresh();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.p.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
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
            d.a.s0.v.d.c.a aVar = this.q;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            this.f13932e = getPageContext().getPageActivity();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f13935h = arguments.getBoolean("arg_after_lazy_loaded", false);
                this.j = arguments.getInt("arg_tab_id", 1);
            }
            if (this.t == null) {
                this.t = new AlaLiveTabRecomModel(getPageContext(), this.u, this.j);
            }
            this.t.init();
            registerListener(this.m);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.n == null) {
                this.n = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
                S0();
            }
            if (this.f13935h) {
                loadData();
            }
            return this.n;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.p;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.x);
                this.p.setOnSrollToBottomListener(null);
            }
            g gVar = this.r;
            if (gVar != null) {
                gVar.a(null);
                this.r.Y();
            }
            AlaLiveTabRecomModel alaLiveTabRecomModel = this.t;
            if (alaLiveTabRecomModel != null) {
                alaLiveTabRecomModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.p.setSelection(0);
            Z0();
        }
    }
}
