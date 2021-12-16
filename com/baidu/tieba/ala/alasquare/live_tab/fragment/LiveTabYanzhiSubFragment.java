package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.k;
import c.a.d.f.p.m;
import c.a.d.m.e.n;
import c.a.r0.s.i0.f;
import c.a.r0.s.i0.g;
import c.a.s0.d1.s;
import c.a.s0.d1.s0;
import c.a.s0.d1.t;
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
/* loaded from: classes11.dex */
public class LiveTabYanzhiSubFragment extends LiveTabBaseSubFragment implements s0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f43275f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwipeRefreshLayout f43276g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f43277h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.s0.a0.f.c.a f43278i;

    /* renamed from: j  reason: collision with root package name */
    public g f43279j;

    /* renamed from: k  reason: collision with root package name */
    public PbListView f43280k;
    public AlaLiveTabYanzhiModel l;
    public AlaLiveTabYanzhiModel.b m;
    public f.g n;
    public BdListView.p o;
    public RecyclerView.OnScrollListener p;

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabYanzhiSubFragment f43281e;

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
            this.f43281e = liveTabYanzhiSubFragment;
        }

        @Override // c.a.r0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (k.z()) {
                    this.f43281e.l.refresh();
                } else {
                    this.f43281e.q();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabYanzhiSubFragment f43282e;

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
            this.f43282e = liveTabYanzhiSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!m.C()) {
                    this.f43282e.hideLoadingView();
                } else {
                    this.f43282e.l.loadMore();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
            this.f43277h.setNextPage(null);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f43276g = (BdSwipeRefreshLayout) this.f43275f.findViewById(R.id.live_tab_refresh_layout);
            this.mTopContainer = (LinearLayout) this.f43275f.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.f43279j = gVar;
            this.f43276g.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f43275f.findViewById(R.id.live_tab_list_view);
            this.f43277h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            this.f43277h.setFadingEdgeLength(0);
            this.f43277h.setOverScrollMode(2);
            this.f43278i = new c.a.s0.a0.f.c.a(getPageContext(), this.f43277h, 102);
            PbListView pbListView = new PbListView(this.mContext);
            this.f43280k = pbListView;
            pbListView.a();
            this.f43280k.p(R.color.transparent);
            this.f43280k.t(m.f(this.mContext, R.dimen.tbds182));
            this.f43280k.y();
            this.f43280k.H(R.dimen.tbfontsize33);
            this.f43280k.F(SkinManager.getColor(R.color.CAM_X0107));
            this.f43280k.B(R.color.CAM_X0110);
            this.f43280k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f43279j.V(getPageContext().getUniqueId());
            this.f43277h.addOnScrollListener(this.p);
            k(this.n);
            l(this.o);
            if (isFromFrs()) {
                this.f43276g.setEnabled(false);
                this.f43276g.interruptRefresh();
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) || (gVar2 = this.f43279j) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public final void l(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) || (bdTypeRecyclerView = this.f43277h) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (pbListView = this.f43280k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f43277h.setNextPage(this.f43280k);
        }
        this.f43280k.t(m.f(this.mContext, R.dimen.tbds182));
        this.f43280k.D(this.mContext.getResources().getString(R.string.loading));
        this.f43280k.R();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void notifyListViewChanged() {
        c.a.s0.a0.f.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (aVar = this.f43278i) == null) {
            return;
        }
        aVar.b();
    }

    public final void o() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (pbListView = this.f43280k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f43277h.setNextPage(this.f43280k);
        }
        this.f43280k.t(m.f(this.mContext, R.dimen.tbds182));
        this.f43280k.D(this.mContext.getResources().getString(R.string.list_no_more));
        this.f43280k.f();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f43279j;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f43280k;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f43280k.d(i2);
            }
            c.a.s0.a0.f.c.a aVar = this.f43278i;
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
            if (this.f43275f == null) {
                this.f43275f = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
                initView();
            }
            if (this.isAfterLazyLoaded) {
                loadData();
            }
            return this.f43275f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.f43277h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.p);
                this.f43277h.setOnSrollToBottomListener(null);
            }
            g gVar = this.f43279j;
            if (gVar != null) {
                gVar.a(null);
                this.f43279j.T();
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

    @Override // c.a.s0.d1.s0
    public void onLoadingComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.s0.d1.s0
    public void onPullRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (k.z()) {
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
                tVar.f16420b = true;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
                return;
            }
            this.f43276g.setRefreshing(true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (isFromFrs()) {
                t tVar = new t();
                tVar.a = 1120;
                tVar.f16420b = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
                return;
            }
            this.f43276g.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f43277h.setSelection(0);
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
            this.f43278i.c(list);
        }
    }
}
