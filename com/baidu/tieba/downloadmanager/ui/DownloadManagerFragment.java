package com.baidu.tieba.downloadmanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g0.h;
import c.a.s0.s.i0.f;
import c.a.s0.s.i0.g;
import c.a.t0.p0.d.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.downloadmanager.DownloadManagerActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class DownloadManagerFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f44070e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f44071f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f44072g;

    /* renamed from: h  reason: collision with root package name */
    public g f44073h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f44074i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadManagerNoDataLayout f44075j;

    /* renamed from: k  reason: collision with root package name */
    public DownloadManagerNotLoginLayout f44076k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public c.a.t0.p0.d.a q;
    public List<c.a.t0.p0.b.b> r;
    public List<c.a.t0.p0.b.b> s;
    public final f.g t;
    public d u;

    /* loaded from: classes12.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadManagerFragment f44077e;

        public a(DownloadManagerFragment downloadManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44077e = downloadManagerFragment;
        }

        @Override // c.a.s0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    this.f44077e.p();
                } else {
                    this.f44077e.setIsRefresh(false);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerFragment a;

        public b(DownloadManagerFragment downloadManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadManagerFragment;
        }

        @Override // c.a.t0.p0.d.d
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.f44070e);
                this.a.o();
                DownloadManagerFragment downloadManagerFragment2 = this.a;
                downloadManagerFragment2.showNetRefreshView(downloadManagerFragment2.f44070e, str, false);
            }
        }

        @Override // c.a.t0.p0.d.d
        public void b(List<c.a.t0.p0.b.b> list, List<c.a.t0.p0.b.b> list2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2, i2) == null) {
                this.a.l = i2 == 1;
                this.a.setIsRefresh(false);
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.f44070e);
                this.a.r = list;
                this.a.s = list2;
                this.a.q();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadManagerFragment f44078e;

        public c(DownloadManagerFragment downloadManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44078e = downloadManagerFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f44078e.f44072g.getFirstVisiblePosition() == 0 && this.f44078e.f44072g.getLastVisiblePosition() == ((this.f44078e.f44072g.getHeaderViewsCount() + this.f44078e.f44072g.getCount()) + this.f44078e.f44072g.getFooterViewsCount()) - 1) {
                this.f44078e.onScrollToBottom();
            }
        }
    }

    public DownloadManagerFragment() {
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
        this.l = true;
        this.m = 3;
        this.o = false;
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new a(this);
        this.u = new b(this);
    }

    public static DownloadManagerFragment newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new DownloadManagerFragment() : (DownloadManagerFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = this.f44075j;
            if (downloadManagerNoDataLayout != null) {
                downloadManagerNoDataLayout.onChangeSkinType();
            }
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.f(R.color.CAM_X0201);
            }
            g gVar = this.f44073h;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f44074i;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
                this.f44074i.p(R.color.transparent);
                this.f44074i.d(i2);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f44072g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
                SkinManager.setBackgroundColor(this.f44072g, R.color.CAM_X0201);
            }
            DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = this.f44076k;
            if (downloadManagerNotLoginLayout != null) {
                downloadManagerNotLoginLayout.onChangeSkinType();
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f44071f;
            if (bdSwipeRefreshLayout != null) {
                SkinManager.setBackgroundColor(bdSwipeRefreshLayout, R.color.CAM_X0204);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            super.hideLoadingView(view);
            this.f44071f.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.hideNetRefreshView(view);
            this.f44071f.setVisibility(0);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f44072g.removeHeaderView(this.f44075j);
            this.f44072g.removeHeaderView(this.f44076k);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f44072g.setNextPage(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.m == i2) {
            return;
        }
        this.m = i2;
        changeSkinType(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.n = bundle.getInt("tab_id");
                this.o = bundle.getBoolean(DownloadManagerActivity.TAB_NEED_LOGIN);
                this.p = bundle.getInt(DownloadManagerActivity.TAB_SOURCE);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.n = arguments.getInt("tab_id");
                    this.o = arguments.getBoolean(DownloadManagerActivity.TAB_NEED_LOGIN);
                    this.p = arguments.getInt(DownloadManagerActivity.TAB_SOURCE);
                }
            }
            if (this.q == null) {
                c.a.t0.p0.d.a a2 = c.a.t0.p0.d.b.a(this, this.n);
                this.q = a2;
                a2.d(this.u);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.ordered_fragment, viewGroup, false);
            this.f44070e = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.download_manager_ordered_recycler_view);
            this.f44072g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f44072g.setOnSrollToBottomListener(this);
            new c.a.t0.p0.f.a.a(this, this.f44072g, this.n, this.p);
            PbListView pbListView = new PbListView(getContext());
            this.f44074i = pbListView;
            pbListView.a();
            this.f44074i.t(n.f(getContext(), R.dimen.tbds182));
            this.f44074i.y();
            this.f44074i.H(R.dimen.tbfontsize33);
            this.f44074i.s();
            g gVar = new g(getPageContext());
            this.f44073h = gVar;
            gVar.a(this.t);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f44070e.findViewById(R.id.download_manager_ordered_layout);
            this.f44071f = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f44073h);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = new DownloadManagerNoDataLayout(getContext());
            this.f44075j = downloadManagerNoDataLayout;
            int i2 = this.n;
            if (i2 == 1) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_order);
            } else if (i2 == 2) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_download_install);
            } else if (i2 == 3) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_download);
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f44070e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            this.f44072g.setOnSrollToBottomListener(null);
            this.f44072g.setScrollable(null);
            hideLoadingView(this.f44070e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroyView();
            this.q.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLazyLoad();
            p();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onNetRefreshButtonClicked();
            p();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            if (!isPrimary() || this.isLazyLoaded) {
                return;
            }
            onLazyLoad();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.n);
            bundle.putBoolean(DownloadManagerActivity.TAB_NEED_LOGIN, this.o);
            bundle.putInt(DownloadManagerActivity.TAB_SOURCE, this.p);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f44072g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.stopScroll();
            }
            showNextPageView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onUserChanged(z);
            if (this.o) {
                p();
            }
        }
    }

    public final void p() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f44072g;
            if (bdTypeRecyclerView != null && ((bdTypeRecyclerView.getCount() != 0 || this.f44072g.getHeaderViewsCount() != 0) && ((hVar = this.mRefreshView) == null || !hVar.isViewAttached()))) {
                setIsRefresh(true);
            } else {
                hideNetRefreshView(this.f44070e);
                showLoadingView(this.f44070e);
            }
            this.q.c();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(this.r) == 0) {
                s();
            } else {
                n();
                arrayList.addAll(this.r);
                c.a.t0.p0.b.b clone = ((c.a.t0.p0.b.b) arrayList.get(arrayList.size() - 1)).clone();
                clone.f21944h = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone);
            }
            if (ListUtils.getCount(this.s) != 0) {
                c.a.t0.p0.b.b bVar = new c.a.t0.p0.b.b();
                bVar.f21944h = false;
                arrayList.add(bVar);
                arrayList.addAll(this.s);
                c.a.t0.p0.b.b clone2 = ((c.a.t0.p0.b.b) arrayList.get(arrayList.size() - 1)).clone();
                clone2.f21944h = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone2);
            }
            this.f44072g.setData(arrayList);
            this.f44072g.post(new c(this));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f44074i.R();
            this.q.a();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            n();
            if (this.o && !TbadkCoreApplication.isLogin()) {
                if (this.f44076k == null) {
                    DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = new DownloadManagerNotLoginLayout(getContext());
                    this.f44076k = downloadManagerNotLoginLayout;
                    downloadManagerNotLoginLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    this.f44076k.onChangeSkinType();
                }
                this.f44072g.addHeaderView(this.f44076k);
                return;
            }
            this.f44072g.addHeaderView(this.f44075j);
        }
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || z) {
            return;
        }
        this.f44071f.setRefreshing(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view) == null) {
            super.showLoadingView(view);
            this.f44071f.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048599, this, view, str, z) == null) {
            super.showNetRefreshView(view, str, z);
            this.mRefreshView.f(R.color.CAM_X0201);
            this.f44071f.setVisibility(8);
        }
    }

    public void showNextPageView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f44074i == null) {
            return;
        }
        if (l.z() && this.f44072g.getCount() != 0) {
            this.f44072g.setNextPage(this.f44074i);
            this.f44074i.M(0);
            this.f44074i.C(null);
            if (this.l) {
                r();
                return;
            } else {
                t();
                return;
            }
        }
        this.f44072g.setNextPage(null);
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f44074i.D(getResources().getString(R.string.item_list_no_more));
            this.f44074i.f();
        }
    }
}
