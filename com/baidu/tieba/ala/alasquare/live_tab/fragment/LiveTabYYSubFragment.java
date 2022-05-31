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
import com.repackage.ft4;
import com.repackage.gt4;
import com.repackage.ji;
import com.repackage.jn;
import com.repackage.li;
import com.repackage.t35;
import com.repackage.zm5;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveTabYYSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View j;
    public BdSwipeRefreshLayout k;
    public BdTypeRecyclerView l;
    public zm5 m;
    public gt4 n;
    public PbListView o;
    public AlaLiveYYSubTabModel p;
    public int q;
    public int r;
    public AlaLiveYYSubTabModel.b s;
    public ft4.g t;
    public BdListView.p u;
    public RecyclerView.OnScrollListener v;

    /* loaded from: classes3.dex */
    public class a implements AlaLiveYYSubTabModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public a(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.b
        public void a(boolean z, List<jn> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.g();
                this.a.V0();
                if (z) {
                    this.a.b1();
                } else {
                    this.a.e1();
                }
                this.a.g1();
                this.a.Y0(list);
                if (ListUtils.isEmpty(list)) {
                    this.a.J0();
                } else {
                    this.a.E0();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.b
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.g1();
                this.a.g();
                this.a.V0();
                if (!z) {
                    if (!this.a.p.a()) {
                        this.a.d1();
                        return;
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0482);
                        return;
                    }
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0482);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ft4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public b(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // com.repackage.ft4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ji.z()) {
                    this.a.p.refresh();
                } else {
                    this.a.g1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public c(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!li.D()) {
                    this.a.U0();
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
        public final /* synthetic */ LiveTabYYSubFragment a;

        public d(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 >= this.a.r) {
                    LiveTabYYSubFragment liveTabYYSubFragment = this.a;
                    if (liveTabYYSubFragment.e) {
                        return;
                    }
                    liveTabYYSubFragment.F0();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public e(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ji.A()) {
                this.a.loadData();
            }
        }
    }

    public LiveTabYYSubFragment() {
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
        this.q = 0;
        this.r = 4;
        this.s = new a(this);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new d(this);
    }

    public static LiveTabYYSubFragment X0(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            Bundle bundle = new Bundle();
            LiveTabYYSubFragment liveTabYYSubFragment = new LiveTabYYSubFragment();
            bundle.putBoolean("arg_after_lazy_loaded", z);
            bundle.putInt("arg_tab_id", i);
            liveTabYYSubFragment.setArguments(bundle);
            return liveTabYYSubFragment;
        }
        return (LiveTabYYSubFragment) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void H0() {
        zm5 zm5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (zm5Var = this.m) == null) {
            return;
        }
        zm5Var.b();
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.setNextPage(null);
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setVisibility(8);
            t35 t35Var = this.mRefreshView;
            if (t35Var != null) {
                t35Var.dettachView(this.b);
                this.mRefreshView = null;
            }
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = (BdSwipeRefreshLayout) this.j.findViewById(R.id.obfuscated_res_0x7f091294);
            this.b = (LinearLayout) this.j.findViewById(R.id.obfuscated_res_0x7f092094);
            gt4 gt4Var = new gt4(getPageContext());
            this.n = gt4Var;
            this.k.setProgressView(gt4Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.j.findViewById(R.id.obfuscated_res_0x7f091292);
            this.l = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
            this.l.setFadingEdgeLength(0);
            this.l.setOverScrollMode(2);
            this.m = new zm5(getPageContext(), this.l, this.f);
            PbListView pbListView = new PbListView(this.a);
            this.o = pbListView;
            pbListView.a();
            this.o.p(R.color.transparent);
            this.o.t(li.f(this.a, R.dimen.tbds182));
            this.o.x();
            this.o.G(R.dimen.tbfontsize33);
            this.o.E(SkinManager.getColor(R.color.CAM_X0107));
            this.o.A(R.color.CAM_X0110);
            this.o.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.n.a0(getPageContext().getUniqueId());
            this.l.addOnScrollListener(this.v);
            Z0(this.t);
            a1(this.u);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void Y0(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.m.c(list);
        }
    }

    public final void Z0(ft4.g gVar) {
        gt4 gt4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || (gt4Var = this.n) == null) {
            return;
        }
        gt4Var.e(gVar);
    }

    public final void a1(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) || (bdTypeRecyclerView = this.l) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void b1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pbListView = this.o) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.l.setNextPage(this.o);
        }
        this.o.t(li.f(this.a, R.dimen.tbds182));
        this.o.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a3b));
        this.o.Q();
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b.setVisibility(0);
            super.showLoadingView(this.b, false, this.q);
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setVisibility(0);
            if (this.mRefreshView == null) {
                this.mRefreshView = new t35(getContext(), new e(this));
            }
            this.mRefreshView.p();
            this.mRefreshView.m(null);
            this.mRefreshView.n(getResources().getString(R.string.obfuscated_res_0x7f0f0f95));
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.l(0);
            this.mRefreshView.onChangeSkinType();
            this.mRefreshView.attachView(this.b, false);
        }
    }

    public final void e1() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (pbListView = this.o) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.l.setNextPage(this.o);
        }
        this.o.t(li.f(this.a, R.dimen.tbds182));
        this.o.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09f5));
        this.o.f();
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k.setRefreshing(true);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.setVisibility(8);
            super.hideLoadingView(this.b);
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.l.setSelection(0);
            f1();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.p == null) {
            return;
        }
        V0();
        c1();
        this.p.refresh();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            super.onChangeSkinType(i);
            gt4 gt4Var = this.n;
            if (gt4Var != null) {
                gt4Var.H(i);
            }
            PbListView pbListView = this.o;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.o.d(i);
            }
            zm5 zm5Var = this.m;
            if (zm5Var != null) {
                zm5Var.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = getPageContext().getPageActivity();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.d = arguments.getBoolean("arg_after_lazy_loaded", false);
                this.f = arguments.getInt("arg_tab_id", 0);
            }
            if (this.p == null) {
                this.p = new AlaLiveYYSubTabModel(getPageContext(), this.s, this.f);
            }
            this.p.init();
            this.p.K(this.g, this.h);
            registerListener(this.i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.j == null) {
                this.j = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d050d, (ViewGroup) null);
                W0();
                if (viewGroup != null) {
                    this.q = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - li.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                }
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.l;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.v);
                this.l.setOnSrollToBottomListener(null);
            }
            gt4 gt4Var = this.n;
            if (gt4Var != null) {
                gt4Var.e(null);
                this.n.Y();
            }
            AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.p;
            if (alaLiveYYSubTabModel != null) {
                alaLiveYYSubTabModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onLazyLoad();
            this.d = true;
            loadData();
        }
    }
}
