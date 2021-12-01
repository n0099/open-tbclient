package com.baidu.tieba.downloadmanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.q0.g0.h;
import c.a.q0.s.g0.f;
import c.a.q0.s.g0.g;
import c.a.r0.p0.d.d;
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
/* loaded from: classes10.dex */
public class DownloadManagerFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f43392e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f43393f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f43394g;

    /* renamed from: h  reason: collision with root package name */
    public g f43395h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f43396i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadManagerNoDataLayout f43397j;

    /* renamed from: k  reason: collision with root package name */
    public DownloadManagerNotLoginLayout f43398k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public c.a.r0.p0.d.a q;
    public List<c.a.r0.p0.b.b> r;
    public List<c.a.r0.p0.b.b> s;
    public final f.g t;
    public d u;

    /* loaded from: classes10.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadManagerFragment f43399e;

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
            this.f43399e = downloadManagerFragment;
        }

        @Override // c.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f43399e.o();
                } else {
                    this.f43399e.setIsRefresh(false);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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

        @Override // c.a.r0.p0.d.d
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.f43392e);
                this.a.n();
                DownloadManagerFragment downloadManagerFragment2 = this.a;
                downloadManagerFragment2.showNetRefreshView(downloadManagerFragment2.f43392e, str, false);
            }
        }

        @Override // c.a.r0.p0.d.d
        public void b(List<c.a.r0.p0.b.b> list, List<c.a.r0.p0.b.b> list2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2, i2) == null) {
                this.a.l = i2 == 1;
                this.a.setIsRefresh(false);
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.f43392e);
                this.a.r = list;
                this.a.s = list2;
                this.a.p();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadManagerFragment f43400e;

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
            this.f43400e = downloadManagerFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f43400e.f43394g.getFirstVisiblePosition() == 0 && this.f43400e.f43394g.getLastVisiblePosition() == ((this.f43400e.f43394g.getHeaderViewsCount() + this.f43400e.f43394g.getCount()) + this.f43400e.f43394g.getFooterViewsCount()) - 1) {
                this.f43400e.onScrollToBottom();
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
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = this.f43397j;
            if (downloadManagerNoDataLayout != null) {
                downloadManagerNoDataLayout.onChangeSkinType();
            }
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.f(R.color.CAM_X0201);
            }
            g gVar = this.f43395h;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f43396i;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.f43396i.p(R.color.transparent);
                this.f43396i.d(i2);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f43394g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
                SkinManager.setBackgroundColor(this.f43394g, R.color.CAM_X0201);
            }
            DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = this.f43398k;
            if (downloadManagerNotLoginLayout != null) {
                downloadManagerNotLoginLayout.onChangeSkinType();
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f43393f;
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
            this.f43393f.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.hideNetRefreshView(view);
            this.f43393f.setVisibility(0);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f43394g.removeHeaderView(this.f43397j);
            this.f43394g.removeHeaderView(this.f43398k);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f43394g.setNextPage(null);
        }
    }

    public final void o() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f43394g;
            if (bdTypeRecyclerView != null && ((bdTypeRecyclerView.getCount() != 0 || this.f43394g.getHeaderViewsCount() != 0) && ((hVar = this.mRefreshView) == null || !hVar.isViewAttached()))) {
                setIsRefresh(true);
            } else {
                hideNetRefreshView(this.f43392e);
                showLoadingView(this.f43392e);
            }
            this.q.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.m == i2) {
            return;
        }
        this.m = i2;
        changeSkinType(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
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
                c.a.r0.p0.d.a a2 = c.a.r0.p0.d.b.a(this, this.n);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.ordered_fragment, viewGroup, false);
            this.f43392e = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.download_manager_ordered_recycler_view);
            this.f43394g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f43394g.setOnSrollToBottomListener(this);
            new c.a.r0.p0.f.a.a(this, this.f43394g, this.n, this.p);
            PbListView pbListView = new PbListView(getContext());
            this.f43396i = pbListView;
            pbListView.a();
            this.f43396i.s(l.f(getContext(), R.dimen.tbds182));
            this.f43396i.x();
            this.f43396i.G(R.dimen.tbfontsize33);
            this.f43396i.r();
            g gVar = new g(getPageContext());
            this.f43395h = gVar;
            gVar.a(this.t);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f43392e.findViewById(R.id.download_manager_ordered_layout);
            this.f43393f = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f43395h);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = new DownloadManagerNoDataLayout(getContext());
            this.f43397j = downloadManagerNoDataLayout;
            int i2 = this.n;
            if (i2 == 1) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_order);
            } else if (i2 == 2) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_download_install);
            } else if (i2 == 3) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_download);
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f43392e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            this.f43394g.setOnSrollToBottomListener(null);
            this.f43394g.setScrollable(null);
            hideLoadingView(this.f43392e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroyView();
            this.q.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onLazyLoad();
            o();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onNetRefreshButtonClicked();
            o();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.n);
            bundle.putBoolean(DownloadManagerActivity.TAB_NEED_LOGIN, this.o);
            bundle.putInt(DownloadManagerActivity.TAB_SOURCE, this.p);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f43394g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.stopScroll();
            }
            showNextPageView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            super.onUserChanged(z);
            if (this.o) {
                o();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(this.r) == 0) {
                r();
            } else {
                l();
                arrayList.addAll(this.r);
                c.a.r0.p0.b.b clone = ((c.a.r0.p0.b.b) arrayList.get(arrayList.size() - 1)).clone();
                clone.f21009h = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone);
            }
            if (ListUtils.getCount(this.s) != 0) {
                c.a.r0.p0.b.b bVar = new c.a.r0.p0.b.b();
                bVar.f21009h = false;
                arrayList.add(bVar);
                arrayList.addAll(this.s);
                c.a.r0.p0.b.b clone2 = ((c.a.r0.p0.b.b) arrayList.get(arrayList.size() - 1)).clone();
                clone2.f21009h = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone2);
            }
            this.f43394g.setData(arrayList);
            this.f43394g.post(new c(this));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f43396i.Q();
            this.q.a();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            l();
            if (this.o && !TbadkCoreApplication.isLogin()) {
                if (this.f43398k == null) {
                    DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = new DownloadManagerNotLoginLayout(getContext());
                    this.f43398k = downloadManagerNotLoginLayout;
                    downloadManagerNotLoginLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    this.f43398k.onChangeSkinType();
                }
                this.f43394g.addHeaderView(this.f43398k);
                return;
            }
            this.f43394g.addHeaderView(this.f43397j);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f43396i.C(getResources().getString(R.string.item_list_no_more));
            this.f43396i.f();
        }
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || z) {
            return;
        }
        this.f43393f.setRefreshing(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            super.showLoadingView(view);
            this.f43393f.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048600, this, view, str, z) == null) {
            super.showNetRefreshView(view, str, z);
            this.mRefreshView.f(R.color.CAM_X0201);
            this.f43393f.setVisibility(8);
        }
    }

    public void showNextPageView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.f43396i == null) {
            return;
        }
        if (j.z() && this.f43394g.getCount() != 0) {
            this.f43394g.setNextPage(this.f43396i);
            this.f43396i.L(0);
            this.f43396i.B(null);
            if (this.l) {
                q();
                return;
            } else {
                s();
                return;
            }
        }
        this.f43394g.setNextPage(null);
    }
}
