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
import c.a.r0.d1.s;
import c.a.r0.d1.s0;
import c.a.r0.d1.t;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f42784f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwipeRefreshLayout f42785g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f42786h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.a0.f.c.a f42787i;

    /* renamed from: j  reason: collision with root package name */
    public g f42788j;

    /* renamed from: k  reason: collision with root package name */
    public PbListView f42789k;
    public AlaLiveTabYanzhiModel l;
    public AlaLiveTabYanzhiModel.b m;
    public f.g n;
    public BdListView.p o;
    public RecyclerView.OnScrollListener p;

    /* loaded from: classes10.dex */
    public class a implements AlaLiveTabYanzhiModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYanzhiSubFragment a;

        public a(LiveTabYanzhiSubFragment liveTabYanzhiSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYanzhiSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYanzhiSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                if (z) {
                    this.a.n();
                } else {
                    this.a.o();
                }
                this.a.q();
                this.a.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.a.q();
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
        public final /* synthetic */ LiveTabYanzhiSubFragment f42790e;

        public b(LiveTabYanzhiSubFragment liveTabYanzhiSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYanzhiSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42790e = liveTabYanzhiSubFragment;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f42790e.l.refresh();
                } else {
                    this.f42790e.q();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabYanzhiSubFragment f42791e;

        public c(LiveTabYanzhiSubFragment liveTabYanzhiSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYanzhiSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42791e = liveTabYanzhiSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.C()) {
                    this.f42791e.hideLoadingView();
                } else {
                    this.f42791e.l.loadMore();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYanzhiSubFragment a;

        public d(LiveTabYanzhiSubFragment liveTabYanzhiSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYanzhiSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYanzhiSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                String str = "dy" + i3 + ", dx" + i2;
                if (i3 >= 4) {
                    LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = this.a;
                    if (liveTabYanzhiSubFragment.isHideTopHeader) {
                        return;
                    }
                    liveTabYanzhiSubFragment.hideTopHeader();
                }
            }
        }
    }

    public LiveTabYanzhiSubFragment() {
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

    public static LiveTabYanzhiSubFragment newInstance(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65543, null, z)) == null) {
            Bundle bundle = new Bundle();
            LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = new LiveTabYanzhiSubFragment();
            bundle.putBoolean(LiveTabBaseSubFragment.ARG_AFTER_LAZY_LOADED, z);
            liveTabYanzhiSubFragment.setArguments(bundle);
            return liveTabYanzhiSubFragment;
        }
        return (LiveTabYanzhiSubFragment) invokeZ.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f42786h.setNextPage(null);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f42785g = (BdSwipeRefreshLayout) this.f42784f.findViewById(R.id.live_tab_refresh_layout);
            this.mTopContainer = (LinearLayout) this.f42784f.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.f42788j = gVar;
            this.f42785g.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f42784f.findViewById(R.id.live_tab_list_view);
            this.f42786h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            this.f42786h.setFadingEdgeLength(0);
            this.f42786h.setOverScrollMode(2);
            this.f42787i = new c.a.r0.a0.f.c.a(getPageContext(), this.f42786h, 102);
            PbListView pbListView = new PbListView(this.mContext);
            this.f42789k = pbListView;
            pbListView.a();
            this.f42789k.p(R.color.transparent);
            this.f42789k.s(l.f(this.mContext, R.dimen.tbds182));
            this.f42789k.x();
            this.f42789k.G(R.dimen.tbfontsize33);
            this.f42789k.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f42789k.A(R.color.CAM_X0110);
            this.f42789k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f42788j.V(getPageContext().getUniqueId());
            this.f42786h.addOnScrollListener(this.p);
            k(this.n);
            l(this.o);
            if (isFromFrs()) {
                this.f42785g.setEnabled(false);
                this.f42785g.interruptRefresh();
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.mFid);
            statisticItem.param("obj_locate", 2);
            statisticItem.param("obj_type", 15);
            statisticItem.eventStat();
        }
    }

    public final void k(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || (gVar2 = this.f42788j) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public final void l(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) || (bdTypeRecyclerView = this.f42786h) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (alaLiveTabYanzhiModel = this.l) == null) {
            return;
        }
        alaLiveTabYanzhiModel.refresh();
    }

    public final void n() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.f42789k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f42786h.setNextPage(this.f42789k);
        }
        this.f42789k.s(l.f(this.mContext, R.dimen.tbds182));
        this.f42789k.C(this.mContext.getResources().getString(R.string.loading));
        this.f42789k.Q();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void notifyListViewChanged() {
        c.a.r0.a0.f.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f42787i) == null) {
            return;
        }
        aVar.b();
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (pbListView = this.f42789k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f42786h.setNextPage(this.f42789k);
        }
        this.f42789k.s(l.f(this.mContext, R.dimen.tbds182));
        this.f42789k.C(this.mContext.getResources().getString(R.string.list_no_more));
        this.f42789k.f();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f42788j;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f42789k;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f42789k.d(i2);
            }
            c.a.r0.a0.f.c.a aVar = this.f42787i;
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
            }
            if (this.l == null) {
                this.l = new AlaLiveTabYanzhiModel(getPageContext(), this.m);
            }
            this.l.init();
            this.l.I(this.mFid, this.mFname);
            registerListener(this.mTopHeaderListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f42784f == null) {
                this.f42784f = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
                initView();
            }
            if (this.isAfterLazyLoaded) {
                loadData();
            }
            return this.f42784f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.f42786h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.p);
                this.f42786h.setOnSrollToBottomListener(null);
            }
            g gVar = this.f42788j;
            if (gVar != null) {
                gVar.a(null);
                this.f42788j.T();
            }
            AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.l;
            if (alaLiveTabYanzhiModel != null) {
                alaLiveTabYanzhiModel.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            j();
        }
    }

    @Override // c.a.r0.d1.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.r0.d1.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (j.z()) {
                AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.l;
                if (alaLiveTabYanzhiModel != null) {
                    alaLiveTabYanzhiModel.refresh();
                    return;
                }
                return;
            }
            q();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (isFromFrs()) {
                t tVar = new t();
                tVar.a = 1120;
                tVar.f16010b = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
                return;
            }
            this.f42785g.setRefreshing(true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (isFromFrs()) {
                t tVar = new t();
                tVar.a = 1120;
                tVar.f16010b = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
                return;
            }
            this.f42785g.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f42786h.setSelection(0);
            p();
        }
    }

    public final void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                if (list == null) {
                    list = new LinkedList<>();
                }
                list.add(new s());
            }
            this.f42787i.c(list);
        }
    }
}
