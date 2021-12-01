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
import c.a.q0.g0.h;
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
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f42758f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwipeRefreshLayout f42759g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f42760h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.a0.f.c.a f42761i;

    /* renamed from: j  reason: collision with root package name */
    public g f42762j;

    /* renamed from: k  reason: collision with root package name */
    public PbListView f42763k;
    public AlaLiveTabFriendModel l;
    public int m;
    public AlaLiveTabFriendModel.b n;
    public f.g o;
    public BdListView.p p;
    public RecyclerView.OnScrollListener q;

    /* loaded from: classes10.dex */
    public class a implements AlaLiveTabFriendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFriendSubFragment a;

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
            this.a = liveTabFriendSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.hideLoadingView();
                this.a.hideNetRefreshView();
                if (z) {
                    this.a.q();
                } else {
                    this.a.r();
                }
                this.a.t();
                this.a.setData(list);
                if (ListUtils.isEmpty(list)) {
                    this.a.showEmptyView();
                } else {
                    this.a.hideEmptyView();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.a.t();
                this.a.hideLoadingView();
                this.a.hideNetRefreshView();
                if (!z) {
                    if (!this.a.l.a()) {
                        this.a.showNetRefreshView();
                        return;
                    } else {
                        this.a.showToast(R.string.data_load_error);
                        return;
                    }
                }
                this.a.showToast(R.string.data_load_error);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f42764e;

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
            this.f42764e = liveTabFriendSubFragment;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f42764e.l.refresh();
                } else {
                    this.f42764e.t();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f42765e;

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
            this.f42765e = liveTabFriendSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.C()) {
                    this.f42765e.n();
                } else {
                    this.f42765e.l.loadMore();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabFriendSubFragment a;

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
            this.a = liveTabFriendSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 >= 4) {
                    LiveTabFriendSubFragment liveTabFriendSubFragment = this.a;
                    if (liveTabFriendSubFragment.isHideTopHeader) {
                        return;
                    }
                    liveTabFriendSubFragment.hideTopHeader();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f42766e;

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
            this.f42766e = liveTabFriendSubFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f42766e.loadData();
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
        this.m = 0;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
        this.q = new d(this);
    }

    public static LiveTabFriendSubFragment newInstance(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            Bundle bundle = new Bundle();
            LiveTabFriendSubFragment liveTabFriendSubFragment = new LiveTabFriendSubFragment();
            bundle.putBoolean(LiveTabBaseSubFragment.ARG_AFTER_LAZY_LOADED, z);
            liveTabFriendSubFragment.setArguments(bundle);
            return liveTabFriendSubFragment;
        }
        return (LiveTabFriendSubFragment) invokeZ.objValue;
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTopContainer.setVisibility(8);
            super.hideLoadingView(this.mTopContainer);
        }
    }

    public final void hideNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mTopContainer.setVisibility(8);
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.dettachView(this.mTopContainer);
                this.mRefreshView = null;
            }
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f42759g = (BdSwipeRefreshLayout) this.f42758f.findViewById(R.id.live_tab_refresh_layout);
            this.mTopContainer = (LinearLayout) this.f42758f.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.f42762j = gVar;
            this.f42759g.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f42758f.findViewById(R.id.live_tab_list_view);
            this.f42760h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            this.f42760h.setFadingEdgeLength(0);
            this.f42760h.setOverScrollMode(2);
            this.f42761i = new c.a.r0.a0.f.c.a(getPageContext(), this.f42760h, 103);
            PbListView pbListView = new PbListView(this.mContext);
            this.f42763k = pbListView;
            pbListView.a();
            this.f42763k.p(R.color.transparent);
            this.f42763k.s(l.f(this.mContext, R.dimen.tbds182));
            this.f42763k.x();
            this.f42763k.G(R.dimen.tbfontsize33);
            this.f42763k.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f42763k.A(R.color.CAM_X0110);
            this.f42763k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f42762j.V(getPageContext().getUniqueId());
            this.f42760h.addOnScrollListener(this.q);
            o(this.o);
            p(this.p);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.l == null) {
            return;
        }
        hideNetRefreshView();
        showLoadingView();
        this.l.refresh();
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f42760h.setNextPage(null);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void notifyListViewChanged() {
        c.a.r0.a0.f.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f42761i) == null) {
            return;
        }
        aVar.b();
    }

    public final void o(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) || (gVar2 = this.f42762j) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.f42762j;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f42763k;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f42763k.d(i2);
            }
            c.a.r0.a0.f.c.a aVar = this.f42761i;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            this.mContext = getPageContext().getPageActivity();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.isAfterLazyLoaded = arguments.getBoolean(LiveTabBaseSubFragment.ARG_AFTER_LAZY_LOADED, false);
            }
            if (this.l == null) {
                this.l = new AlaLiveTabFriendModel(getPageContext(), this.n);
                this.isAfterLazyLoaded = true;
            }
            this.l.init();
            registerListener(this.mTopHeaderListener);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f42758f == null) {
                this.f42758f = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
                initView();
                if (viewGroup != null) {
                    this.m = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.f(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                }
            }
            if (this.isAfterLazyLoaded) {
                loadData();
            }
            return this.f42758f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.f42760h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.q);
                this.f42760h.setOnSrollToBottomListener(null);
            }
            g gVar = this.f42762j;
            if (gVar != null) {
                gVar.a(null);
                this.f42762j.T();
            }
            AlaLiveTabFriendModel alaLiveTabFriendModel = this.l;
            if (alaLiveTabFriendModel != null) {
                alaLiveTabFriendModel.onDestroy();
            }
        }
    }

    public final void p(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, pVar) == null) || (bdTypeRecyclerView = this.f42760h) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    public final void q() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (pbListView = this.f42763k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f42760h.setNextPage(this.f42763k);
        }
        this.f42763k.s(l.f(this.mContext, R.dimen.tbds182));
        this.f42763k.C(this.mContext.getResources().getString(R.string.loading));
        this.f42763k.Q();
    }

    public final void r() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (pbListView = this.f42763k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f42760h.setNextPage(this.f42763k);
        }
        this.f42763k.s(l.f(this.mContext, R.dimen.tbds182));
        this.f42763k.C(this.mContext.getResources().getString(R.string.list_no_more));
        this.f42763k.f();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f42760h.setSelection(0);
            s();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f42759g.setRefreshing(true);
        }
    }

    public final void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.f42761i.c(list);
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.mTopContainer.setVisibility(0);
            super.showLoadingView(this.mTopContainer, false, this.m);
        }
    }

    public final void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mTopContainer.setVisibility(0);
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new e(this));
            }
            this.mRefreshView.o();
            this.mRefreshView.l(null);
            this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
            this.mRefreshView.i(R.drawable.new_pic_emotion_08);
            this.mRefreshView.k(0);
            this.mRefreshView.onChangeSkinType();
            this.mRefreshView.attachView(this.mTopContainer, false);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f42759g.setRefreshing(false);
        }
    }
}
