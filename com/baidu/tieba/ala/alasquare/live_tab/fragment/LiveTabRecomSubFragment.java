package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.o0.r.l0.f;
import c.a.o0.r.l0.g;
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
import java.util.List;
/* loaded from: classes5.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public BdSwipeRefreshLayout k;
    public BdTypeRecyclerView l;
    public c.a.p0.c0.f.c.a m;
    public g n;
    public PbListView o;
    public AlaLiveTabRecomModel p;
    public AlaLiveTabRecomModel.b q;
    public f.g r;
    public BdListView.p s;
    public RecyclerView.OnScrollListener t;

    /* loaded from: classes5.dex */
    public class a implements AlaLiveTabRecomModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabRecomSubFragment a;

        public a(LiveTabRecomSubFragment liveTabRecomSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabRecomSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabRecomSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                if (z) {
                    this.a.T0();
                } else {
                    this.a.U0();
                }
                this.a.W0();
                this.a.Q0(list);
                if (ListUtils.isEmpty(list)) {
                    this.a.H0();
                } else {
                    this.a.C0();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.b
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.W0();
                if (z) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f046c);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabRecomSubFragment a;

        public b(LiveTabRecomSubFragment liveTabRecomSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabRecomSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabRecomSubFragment;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    this.a.p.refresh();
                } else {
                    this.a.W0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabRecomSubFragment a;

        public c(LiveTabRecomSubFragment liveTabRecomSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabRecomSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabRecomSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.d.f.p.n.C()) {
                    this.a.d();
                } else {
                    this.a.p.loadMore();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabRecomSubFragment a;

        public d(LiveTabRecomSubFragment liveTabRecomSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabRecomSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabRecomSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 >= 4) {
                    LiveTabRecomSubFragment liveTabRecomSubFragment = this.a;
                    if (liveTabRecomSubFragment.f31273e) {
                        return;
                    }
                    liveTabRecomSubFragment.D0();
                }
            }
        }
    }

    public LiveTabRecomSubFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this);
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
    }

    public static LiveTabRecomSubFragment P0(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Bundle bundle = new Bundle();
            LiveTabRecomSubFragment liveTabRecomSubFragment = new LiveTabRecomSubFragment();
            bundle.putBoolean("arg_after_lazy_loaded", z);
            bundle.putInt("arg_tab_id", i);
            liveTabRecomSubFragment.setArguments(bundle);
            return liveTabRecomSubFragment;
        }
        return (LiveTabRecomSubFragment) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void F0() {
        c.a.p0.c0.f.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.b();
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = (BdSwipeRefreshLayout) this.j.findViewById(R.id.obfuscated_res_0x7f0912cd);
            this.f31270b = (LinearLayout) this.j.findViewById(R.id.obfuscated_res_0x7f0920ad);
            g gVar = new g(getPageContext());
            this.n = gVar;
            this.k.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.j.findViewById(R.id.obfuscated_res_0x7f0912cb);
            this.l = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
            this.l.setFadingEdgeLength(0);
            this.l.setOverScrollMode(2);
            this.m = new c.a.p0.c0.f.c.a(getPageContext(), this.l, 101);
            PbListView pbListView = new PbListView(this.a);
            this.o = pbListView;
            pbListView.a();
            this.o.p(R.color.transparent);
            this.o.t(c.a.d.f.p.n.f(this.a, R.dimen.tbds182));
            this.o.y();
            this.o.H(R.dimen.tbfontsize33);
            this.o.F(SkinManager.getColor(R.color.CAM_X0107));
            this.o.B(R.color.CAM_X0110);
            this.o.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.n.a0(getPageContext().getUniqueId());
            this.l.addOnScrollListener(this.t);
            R0(this.r);
            S0(this.s);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void Q0(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.m.c(list);
        }
    }

    public final void R0(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || (gVar2 = this.n) == null) {
            return;
        }
        gVar2.f(gVar);
    }

    public final void S0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) || (bdTypeRecyclerView = this.l) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void T0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.o) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.l.setNextPage(this.o);
        }
        this.o.t(c.a.d.f.p.n.f(this.a, R.dimen.tbds182));
        this.o.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a2e));
        this.o.R();
    }

    public final void U0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.o) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.l.setNextPage(this.o);
        }
        this.o.t(c.a.d.f.p.n.f(this.a, R.dimen.tbds182));
        this.o.D(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
        this.o.f();
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.setRefreshing(true);
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.setRefreshing(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        AlaLiveTabRecomModel alaLiveTabRecomModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (alaLiveTabRecomModel = this.p) == null) {
            return;
        }
        alaLiveTabRecomModel.refresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.setSelection(0);
            V0();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            g gVar = this.n;
            if (gVar != null) {
                gVar.H(i);
            }
            PbListView pbListView = this.o;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.o.d(i);
            }
            c.a.p0.c0.f.c.a aVar = this.m;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = getPageContext().getPageActivity();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.f31272d = arguments.getBoolean("arg_after_lazy_loaded", false);
                this.f31274f = arguments.getInt("arg_tab_id", 1);
            }
            if (this.p == null) {
                this.p = new AlaLiveTabRecomModel(getPageContext(), this.q, this.f31274f);
            }
            this.p.init();
            registerListener(this.i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.j == null) {
                this.j = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0528, (ViewGroup) null);
                O0();
            }
            if (this.f31272d) {
                loadData();
            }
            return this.j;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.t);
                this.l.setOnSrollToBottomListener(null);
            }
            g gVar = this.n;
            if (gVar != null) {
                gVar.f(null);
                this.n.Y();
            }
            AlaLiveTabRecomModel alaLiveTabRecomModel = this.p;
            if (alaLiveTabRecomModel != null) {
                alaLiveTabRecomModel.onDestroy();
            }
        }
    }
}
