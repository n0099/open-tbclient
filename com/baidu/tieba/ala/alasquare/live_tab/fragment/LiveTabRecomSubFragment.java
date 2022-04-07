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
import com.repackage.do5;
import com.repackage.du4;
import com.repackage.eu4;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.uo;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public BdSwipeRefreshLayout k;
    public BdTypeRecyclerView l;
    public do5 m;
    public eu4 n;
    public PbListView o;
    public AlaLiveTabRecomModel p;
    public AlaLiveTabRecomModel.b q;
    public du4.g r;
    public BdListView.p s;
    public RecyclerView.OnScrollListener t;

    /* loaded from: classes3.dex */
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
        public void a(boolean z, List<uo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                if (z) {
                    this.a.S0();
                } else {
                    this.a.T0();
                }
                this.a.V0();
                this.a.P0(list);
                if (ListUtils.isEmpty(list)) {
                    this.a.G0();
                } else {
                    this.a.B0();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.b
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.V0();
                if (z) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0473);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements du4.g {
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

        @Override // com.repackage.du4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (mi.z()) {
                    this.a.p.refresh();
                } else {
                    this.a.V0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (!oi.C()) {
                    this.a.g();
                } else {
                    this.a.p.loadMore();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    if (liveTabRecomSubFragment.e) {
                        return;
                    }
                    liveTabRecomSubFragment.C0();
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

    public static LiveTabRecomSubFragment O0(boolean z, int i) {
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
    public void E0() {
        do5 do5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (do5Var = this.m) == null) {
            return;
        }
        do5Var.b();
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k = (BdSwipeRefreshLayout) this.j.findViewById(R.id.obfuscated_res_0x7f0912c1);
            this.b = (LinearLayout) this.j.findViewById(R.id.obfuscated_res_0x7f092092);
            eu4 eu4Var = new eu4(getPageContext());
            this.n = eu4Var;
            this.k.setProgressView(eu4Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.j.findViewById(R.id.obfuscated_res_0x7f0912bf);
            this.l = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
            this.l.setFadingEdgeLength(0);
            this.l.setOverScrollMode(2);
            this.m = new do5(getPageContext(), this.l, 101);
            PbListView pbListView = new PbListView(this.a);
            this.o = pbListView;
            pbListView.a();
            this.o.p(R.color.transparent);
            this.o.t(oi.f(this.a, R.dimen.tbds182));
            this.o.x();
            this.o.G(R.dimen.tbfontsize33);
            this.o.E(SkinManager.getColor(R.color.CAM_X0107));
            this.o.A(R.color.CAM_X0110);
            this.o.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.n.a0(getPageContext().getUniqueId());
            this.l.addOnScrollListener(this.t);
            Q0(this.r);
            R0(this.s);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void P0(List<uo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.m.c(list);
        }
    }

    public final void Q0(du4.g gVar) {
        eu4 eu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || (eu4Var = this.n) == null) {
            return;
        }
        eu4Var.f(gVar);
    }

    public final void R0(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) || (bdTypeRecyclerView = this.l) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void S0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.o) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.l.setNextPage(this.o);
        }
        this.o.t(oi.f(this.a, R.dimen.tbds182));
        this.o.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a2e));
        this.o.Q();
    }

    public final void T0() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.o) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.l.setNextPage(this.o);
        }
        this.o.t(oi.f(this.a, R.dimen.tbds182));
        this.o.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e8));
        this.o.f();
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.setRefreshing(true);
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k.setRefreshing(false);
        }
    }

    public final void g() {
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
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.setSelection(0);
            U0();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            super.onChangeSkinType(i);
            eu4 eu4Var = this.n;
            if (eu4Var != null) {
                eu4Var.H(i);
            }
            PbListView pbListView = this.o;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.o.d(i);
            }
            do5 do5Var = this.m;
            if (do5Var != null) {
                do5Var.b();
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
                this.d = arguments.getBoolean("arg_after_lazy_loaded", false);
                this.f = arguments.getInt("arg_tab_id", 1);
            }
            if (this.p == null) {
                this.p = new AlaLiveTabRecomModel(getPageContext(), this.q, this.f);
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
                this.j = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0523, (ViewGroup) null);
                N0();
            }
            if (this.d) {
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
            eu4 eu4Var = this.n;
            if (eu4Var != null) {
                eu4Var.f(null);
                this.n.Y();
            }
            AlaLiveTabRecomModel alaLiveTabRecomModel = this.p;
            if (alaLiveTabRecomModel != null) {
                alaLiveTabRecomModel.onDestroy();
            }
        }
    }
}
