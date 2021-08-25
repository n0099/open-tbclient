package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.p0.s.f0.f;
import c.a.p0.s.f0.g;
import c.a.q0.v0.r0;
import c.a.q0.v0.s;
import c.a.q0.v0.t;
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
/* loaded from: classes7.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f49293f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwipeRefreshLayout f49294g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f49295h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.v.d.c.a f49296i;

    /* renamed from: j  reason: collision with root package name */
    public g f49297j;
    public PbListView k;
    public AlaLiveTabYanzhiModel l;
    public AlaLiveTabYanzhiModel.b m;
    public f.g n;
    public BdListView.p o;
    public RecyclerView.OnScrollListener p;

    /* loaded from: classes7.dex */
    public class a implements AlaLiveTabYanzhiModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabYanzhiSubFragment f49298a;

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
            this.f49298a = liveTabYanzhiSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                if (z) {
                    this.f49298a.j();
                } else {
                    this.f49298a.k();
                }
                this.f49298a.m();
                this.f49298a.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabYanzhiModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f49298a.m();
                if (z) {
                    this.f49298a.showToast(R.string.data_load_error);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabYanzhiSubFragment f49299e;

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
            this.f49299e = liveTabYanzhiSubFragment;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f49299e.l.refresh();
                } else {
                    this.f49299e.m();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabYanzhiSubFragment f49300e;

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
            this.f49300e = liveTabYanzhiSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f49300e.hideLoadingView();
                } else {
                    this.f49300e.l.loadMore();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabYanzhiSubFragment f49301a;

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
            this.f49301a = liveTabYanzhiSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                String str = "dy" + i3 + ", dx" + i2;
                if (i3 >= 4) {
                    LiveTabYanzhiSubFragment liveTabYanzhiSubFragment = this.f49301a;
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

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13008");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.mFid);
            statisticItem.param("obj_locate", 2);
            statisticItem.param("obj_type", 15);
            statisticItem.eventStat();
        }
    }

    public final void h(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || (gVar2 = this.f49297j) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49295h.setNextPage(null);
        }
    }

    public final void i(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, pVar) == null) || (bdTypeRecyclerView = this.f49295h) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f49294g = (BdSwipeRefreshLayout) this.f49293f.findViewById(R.id.live_tab_refresh_layout);
            this.mTopContainer = (LinearLayout) this.f49293f.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.f49297j = gVar;
            this.f49294g.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f49293f.findViewById(R.id.live_tab_list_view);
            this.f49295h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            this.f49295h.setFadingEdgeLength(0);
            this.f49295h.setOverScrollMode(2);
            this.f49296i = new c.a.q0.v.d.c.a(getPageContext(), this.f49295h, 102);
            PbListView pbListView = new PbListView(this.mContext);
            this.k = pbListView;
            pbListView.a();
            this.k.o(R.color.transparent);
            this.k.r(l.g(this.mContext, R.dimen.tbds182));
            this.k.v();
            this.k.E(R.dimen.tbfontsize33);
            this.k.C(SkinManager.getColor(R.color.CAM_X0107));
            this.k.y(R.color.CAM_X0110);
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f49297j.V(getPageContext().getUniqueId());
            this.f49295h.addOnScrollListener(this.p);
            h(this.n);
            i(this.o);
            if (isFromFrs()) {
                this.f49294g.setEnabled(false);
                this.f49294g.interruptRefresh();
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void j() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (pbListView = this.k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f49295h.setNextPage(this.k);
        }
        this.k.r(l.g(this.mContext, R.dimen.tbds182));
        this.k.A(this.mContext.getResources().getString(R.string.loading));
        this.k.O();
    }

    public final void k() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f49295h.setNextPage(this.k);
        }
        this.k.r(l.g(this.mContext, R.dimen.tbds182));
        this.k.A(this.mContext.getResources().getString(R.string.list_no_more));
        this.k.f();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (isFromFrs()) {
                t tVar = new t();
                tVar.f27158a = 1120;
                tVar.f27159b = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
                return;
            }
            this.f49294g.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        AlaLiveTabYanzhiModel alaLiveTabYanzhiModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (alaLiveTabYanzhiModel = this.l) == null) {
            return;
        }
        alaLiveTabYanzhiModel.refresh();
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (isFromFrs()) {
                t tVar = new t();
                tVar.f27158a = 1120;
                tVar.f27159b = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
                return;
            }
            this.f49294g.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void notifyListViewChanged() {
        c.a.q0.v.d.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.f49296i) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f49297j;
            if (gVar != null) {
                gVar.D(i2);
            }
            PbListView pbListView = this.k;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.k.d(i2);
            }
            c.a.q0.v.d.c.a aVar = this.f49296i;
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f49293f == null) {
                this.f49293f = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
                initView();
            }
            if (this.isAfterLazyLoaded) {
                loadData();
            }
            return this.f49293f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.f49295h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.p);
                this.f49295h.setOnSrollToBottomListener(null);
            }
            g gVar = this.f49297j;
            if (gVar != null) {
                gVar.a(null);
                this.f49297j.T();
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
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            g();
        }
    }

    @Override // c.a.q0.v0.r0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // c.a.q0.v0.r0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (j.z()) {
                AlaLiveTabYanzhiModel alaLiveTabYanzhiModel = this.l;
                if (alaLiveTabYanzhiModel != null) {
                    alaLiveTabYanzhiModel.refresh();
                    return;
                }
                return;
            }
            m();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f49295h.setSelection(0);
            l();
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
            this.f49296i.c(list);
        }
    }
}
