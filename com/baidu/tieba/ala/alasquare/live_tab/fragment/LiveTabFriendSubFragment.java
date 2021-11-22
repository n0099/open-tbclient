package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.q0.g0.h;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
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
/* loaded from: classes8.dex */
public class LiveTabFriendSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f47760f;

    /* renamed from: g  reason: collision with root package name */
    public BdSwipeRefreshLayout f47761g;

    /* renamed from: h  reason: collision with root package name */
    public BdTypeRecyclerView f47762h;

    /* renamed from: i  reason: collision with root package name */
    public b.a.r0.w.f.c.a f47763i;
    public g j;
    public PbListView k;
    public AlaLiveTabFriendModel l;
    public int m;
    public AlaLiveTabFriendModel.b n;
    public f.g o;
    public BdListView.p p;
    public RecyclerView.OnScrollListener q;

    /* loaded from: classes8.dex */
    public class a implements AlaLiveTabFriendModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f47764a;

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
            this.f47764a = liveTabFriendSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.b
        public void a(boolean z, List<n> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.f47764a.hideLoadingView();
                this.f47764a.hideNetRefreshView();
                if (z) {
                    this.f47764a.m();
                } else {
                    this.f47764a.n();
                }
                this.f47764a.p();
                this.f47764a.setData(list);
                if (ListUtils.isEmpty(list)) {
                    this.f47764a.showEmptyView();
                } else {
                    this.f47764a.hideEmptyView();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveTabFriendModel.b
        public void b(int i2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
                this.f47764a.p();
                this.f47764a.hideLoadingView();
                this.f47764a.hideNetRefreshView();
                if (!z) {
                    if (!this.f47764a.l.a()) {
                        this.f47764a.showNetRefreshView();
                        return;
                    } else {
                        this.f47764a.showToast(R.string.data_load_error);
                        return;
                    }
                }
                this.f47764a.showToast(R.string.data_load_error);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f47765e;

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
            this.f47765e = liveTabFriendSubFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f47765e.l.refresh();
                } else {
                    this.f47765e.p();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f47766e;

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
            this.f47766e = liveTabFriendSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f47766e.j();
                } else {
                    this.f47766e.l.loadMore();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f47767a;

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
            this.f47767a = liveTabFriendSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (i3 >= 4) {
                    LiveTabFriendSubFragment liveTabFriendSubFragment = this.f47767a;
                    if (liveTabFriendSubFragment.isHideTopHeader) {
                        return;
                    }
                    liveTabFriendSubFragment.hideTopHeader();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveTabFriendSubFragment f47768e;

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
            this.f47768e = liveTabFriendSubFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A()) {
                this.f47768e.loadData();
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
            this.f47761g = (BdSwipeRefreshLayout) this.f47760f.findViewById(R.id.live_tab_refresh_layout);
            this.mTopContainer = (LinearLayout) this.f47760f.findViewById(R.id.top_container);
            g gVar = new g(getPageContext());
            this.j = gVar;
            this.f47761g.setProgressView(gVar);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f47760f.findViewById(R.id.live_tab_list_view);
            this.f47762h = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            this.f47762h.setFadingEdgeLength(0);
            this.f47762h.setOverScrollMode(2);
            this.f47763i = new b.a.r0.w.f.c.a(getPageContext(), this.f47762h, 103);
            PbListView pbListView = new PbListView(this.mContext);
            this.k = pbListView;
            pbListView.a();
            this.k.p(R.color.transparent);
            this.k.s(l.g(this.mContext, R.dimen.tbds182));
            this.k.x();
            this.k.G(R.dimen.tbfontsize33);
            this.k.E(SkinManager.getColor(R.color.CAM_X0107));
            this.k.A(R.color.CAM_X0110);
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.j.U(getPageContext().getUniqueId());
            this.f47762h.addOnScrollListener(this.q);
            k(this.o);
            l(this.p);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f47762h.setNextPage(null);
        }
    }

    public final void k(f.g gVar) {
        g gVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) || (gVar2 = this.j) == null) {
            return;
        }
        gVar2.a(gVar);
    }

    public final void l(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, pVar) == null) || (bdTypeRecyclerView = this.f47762h) == null) {
            return;
        }
        bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void loadData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.l == null) {
            return;
        }
        hideNetRefreshView();
        showLoadingView();
        this.l.refresh();
    }

    public final void m() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pbListView = this.k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f47762h.setNextPage(this.k);
        }
        this.k.s(l.g(this.mContext, R.dimen.tbds182));
        this.k.C(this.mContext.getResources().getString(R.string.loading));
        this.k.Q();
    }

    public final void n() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (pbListView = this.k) == null) {
            return;
        }
        if (pbListView.b().getParent() == null) {
            this.f47762h.setNextPage(this.k);
        }
        this.k.s(l.g(this.mContext, R.dimen.tbds182));
        this.k.C(this.mContext.getResources().getString(R.string.list_no_more));
        this.k.f();
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void notifyListViewChanged() {
        b.a.r0.w.f.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.f47763i) == null) {
            return;
        }
        aVar.b();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f47761g.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.j;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.k;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.k.d(i2);
            }
            b.a.r0.w.f.c.a aVar = this.f47763i;
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f47760f == null) {
                this.f47760f = layoutInflater.inflate(R.layout.live_tab_sub_tab_layout, (ViewGroup) null);
                initView();
                if (viewGroup != null) {
                    this.m = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.g(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                }
            }
            if (this.isAfterLazyLoaded) {
                loadData();
            }
            return this.f47760f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.f47762h;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.q);
                this.f47762h.setOnSrollToBottomListener(null);
            }
            g gVar = this.j;
            if (gVar != null) {
                gVar.a(null);
                this.j.S();
            }
            AlaLiveTabFriendModel alaLiveTabFriendModel = this.l;
            if (alaLiveTabFriendModel != null) {
                alaLiveTabFriendModel.onDestroy();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f47761g.setRefreshing(false);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment
    public void refreshPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f47762h.setSelection(0);
            o();
        }
    }

    public final void setData(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f47763i.c(list);
        }
    }

    public final void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mTopContainer.setVisibility(0);
            super.showLoadingView(this.mTopContainer, false, this.m);
        }
    }

    public final void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
}
