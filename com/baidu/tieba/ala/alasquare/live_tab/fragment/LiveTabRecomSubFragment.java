package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.d.m.e.n;
import c.a.q0.s.g0.f;
import c.a.q0.s.g0.g;
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
/* loaded from: classes10.dex */
public class LiveTabRecomSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f42767f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwipeRefreshLayout f42768g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f42769h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.a0.f.c.a f42770i;

    /* renamed from: j  reason: collision with root package name */
    public g f42771j;

    /* renamed from: k  reason: collision with root package name */
    public PbListView f42772k;
    public AlaLiveTabRecomModel l;
    public AlaLiveTabRecomModel.b m;
    public f.g n;
    public BdListView.p o;
    public RecyclerView.OnScrollListener p;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    this.a.l();
                } else {
                    this.a.n();
                }
                this.a.p();
                this.a.setData(list);
                if (ListUtils.isEmpty(list)) {
                    this.a.showEmptyView();
                } else {
                    this.a.hideEmptyView();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabRecomModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.a.p();
                if (z) {
                    this.a.showToast(R.string.data_load_error);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabRecomSubFragment f42773e;

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
            this.f42773e = liveTabRecomSubFragment;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f42773e.l.refresh();
                } else {
                    this.f42773e.p();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabRecomSubFragment f42774e;

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
            this.f42774e = liveTabRecomSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.C()) {
                    this.f42774e.hideLoadingView();
                } else {
                    this.f42774e.l.loadMore();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabRecomSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 >= 4) {
                    LiveTabRecomSubFragment liveTabRecomSubFragment = this.a;
                    if (liveTabRecomSubFragment.isHideTopHeader) {
                        return;
                    }
                    liveTabRecomSubFragment.hideTopHeader();
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
        this.m = new a(this);
        this.n = new b(this);
        this.o = new c(this);
        this.p = new d(this);
    }

    public static LiveTabRecomSubFragment newInstance(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            Bundle bundle = new Bundle();
            LiveTabRecomSubFragment liveTabRecomSubFragment = new LiveTabRecomSubFragment();
            bundle.putBoolean(LiveTabBaseSubFragment.ARG_AFTER_LAZY_LOADED, z);
            bundle.putInt(LiveTabBaseSubFragment.ARG_TAB_ID, i2);
            liveTabRecomSubFragment.setArguments(bundle);
            return liveTabRecomSubFragment;
        }
        return (LiveTabRecomSubFragment) invokeCommon.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f42769h.setNextPage(null);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f42768g = (BdSwipeRefreshLayout) this.f42767f.findViewById(R.id.live_tab_refresh_layout);
            this.mTopContainer = (LinearLayout) this.f42767f.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.f42771j = gVar;
            this.f42768g.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f42767f.findViewById(R.id.live_tab_list_view);
            this.f42769h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            this.f42769h.setFadingEdgeLength(0);
            this.f42769h.setOverScrollMode(2);
            this.f42770i = new c.a.r0.a0.f.c.a(getPageContext(), this.f42769h, 101);
            PbListView pbListView = new PbListView(this.mContext);
            this.f42772k = pbListView;
            pbListView.a();
            this.f42772k.p(R.color.transparent);
            this.f42772k.s(l.f(this.mContext, R.dimen.tbds182));
            this.f42772k.x();
            this.f42772k.G(R.dimen.tbfontsize33);
            this.f42772k.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f42772k.A(R.color.CAM_X0110);
            this.f42772k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f42771j.V(getPageContext().getUniqueId());
            this.f42769h.addOnScrollListener(this.p);
            j(this.n);
            k(this.o);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void j(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) || (gVar2 = this.f42771j) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public final void k(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) || (bdTypeRecyclerView = this.f42769h) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void l() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (pbListView = this.f42772k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f42769h.setNextPage(this.f42772k);
        }
        this.f42772k.s(l.f(this.mContext, R.dimen.tbds182));
        this.f42772k.C(this.mContext.getResources().getString(R.string.loading));
        this.f42772k.Q();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        AlaLiveTabRecomModel alaLiveTabRecomModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alaLiveTabRecomModel = this.l) == null) {
            return;
        }
        alaLiveTabRecomModel.refresh();
    }

    public final void n() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.f42772k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f42769h.setNextPage(this.f42772k);
        }
        this.f42772k.s(l.f(this.mContext, R.dimen.tbds182));
        this.f42772k.C(this.mContext.getResources().getString(R.string.list_no_more));
        this.f42772k.f();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void notifyListViewChanged() {
        c.a.r0.a0.f.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f42770i) == null) {
            return;
        }
        aVar.b();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f42768g.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f42771j;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f42772k;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f42772k.d(i2);
            }
            c.a.r0.a0.f.c.a aVar = this.f42770i;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = getPageContext().getPageActivity();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.isAfterLazyLoaded = arguments.getBoolean(LiveTabBaseSubFragment.ARG_AFTER_LAZY_LOADED, false);
                this.tabId = arguments.getInt(LiveTabBaseSubFragment.ARG_TAB_ID, 1);
            }
            if (this.l == null) {
                this.l = new AlaLiveTabRecomModel(getPageContext(), this.m, this.tabId);
            }
            this.l.init();
            registerListener(this.mTopHeaderListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f42767f == null) {
                this.f42767f = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
                initView();
            }
            if (this.isAfterLazyLoaded) {
                loadData();
            }
            return this.f42767f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.f42769h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.p);
                this.f42769h.setOnSrollToBottomListener(null);
            }
            g gVar = this.f42771j;
            if (gVar != null) {
                gVar.a(null);
                this.f42771j.T();
            }
            AlaLiveTabRecomModel alaLiveTabRecomModel = this.l;
            if (alaLiveTabRecomModel != null) {
                alaLiveTabRecomModel.onDestroy();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f42768g.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f42769h.setSelection(0);
            o();
        }
    }

    public final void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f42770i.c(list);
        }
    }
}
