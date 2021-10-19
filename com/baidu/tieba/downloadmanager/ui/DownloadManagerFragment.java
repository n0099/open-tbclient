package com.baidu.tieba.downloadmanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.g0.h;
import c.a.q0.s.f0.f;
import c.a.q0.s.f0.g;
import c.a.r0.j0.d.d;
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
/* loaded from: classes7.dex */
public class DownloadManagerFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f50098e;

    /* renamed from: f  reason: collision with root package name */
    public BdSwipeRefreshLayout f50099f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f50100g;

    /* renamed from: h  reason: collision with root package name */
    public g f50101h;

    /* renamed from: i  reason: collision with root package name */
    public PbListView f50102i;

    /* renamed from: j  reason: collision with root package name */
    public DownloadManagerNoDataLayout f50103j;
    public DownloadManagerNotLoginLayout k;
    public boolean l;
    public int m;
    public int n;
    public boolean o;
    public c.a.r0.j0.d.a p;
    public List<c.a.r0.j0.b.b> q;
    public List<c.a.r0.j0.b.b> r;
    public final f.g s;
    public d t;

    /* loaded from: classes7.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadManagerFragment f50104e;

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
            this.f50104e = downloadManagerFragment;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f50104e.k();
                } else {
                    this.f50104e.setIsRefresh(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DownloadManagerFragment f50105a;

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
            this.f50105a = downloadManagerFragment;
        }

        @Override // c.a.r0.j0.d.d
        public void a(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                DownloadManagerFragment downloadManagerFragment = this.f50105a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.f50098e);
                this.f50105a.j();
                DownloadManagerFragment downloadManagerFragment2 = this.f50105a;
                downloadManagerFragment2.showNetRefreshView(downloadManagerFragment2.f50098e, str, false);
            }
        }

        @Override // c.a.r0.j0.d.d
        public void b(List<c.a.r0.j0.b.b> list, List<c.a.r0.j0.b.b> list2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2, i2) == null) {
                this.f50105a.l = i2 == 1;
                this.f50105a.setIsRefresh(false);
                DownloadManagerFragment downloadManagerFragment = this.f50105a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.f50098e);
                this.f50105a.q = list;
                this.f50105a.r = list2;
                this.f50105a.l();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadManagerFragment f50106e;

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
            this.f50106e = downloadManagerFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f50106e.f50100g.getFirstVisiblePosition() == 0 && this.f50106e.f50100g.getLastVisiblePosition() == ((this.f50106e.f50100g.getHeaderViewsCount() + this.f50106e.f50100g.getCount()) + this.f50106e.f50100g.getFooterViewsCount()) - 1) {
                this.f50106e.onScrollToBottom();
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
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new a(this);
        this.t = new b(this);
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
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = this.f50103j;
            if (downloadManagerNoDataLayout != null) {
                downloadManagerNoDataLayout.onChangeSkinType();
            }
            h hVar = this.mRefreshView;
            if (hVar != null) {
                hVar.f(R.color.CAM_X0201);
            }
            g gVar = this.f50101h;
            if (gVar != null) {
                gVar.D(i2);
            }
            PbListView pbListView = this.f50102i;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f50102i.o(R.color.transparent);
                this.f50102i.d(i2);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.f50100g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
                SkinManager.setBackgroundColor(this.f50100g, R.color.CAM_X0201);
            }
            DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = this.k;
            if (downloadManagerNotLoginLayout != null) {
                downloadManagerNotLoginLayout.onChangeSkinType();
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f50099f;
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
            this.f50099f.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.hideNetRefreshView(view);
            this.f50099f.setVisibility(0);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f50100g.removeHeaderView(this.f50103j);
            this.f50100g.removeHeaderView(this.k);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f50100g.setNextPage(null);
        }
    }

    public final void k() {
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f50100g;
            if (bdTypeRecyclerView != null && ((bdTypeRecyclerView.getCount() != 0 || this.f50100g.getHeaderViewsCount() != 0) && ((hVar = this.mRefreshView) == null || !hVar.isViewAttached()))) {
                setIsRefresh(true);
            } else {
                hideNetRefreshView(this.f50098e);
                showLoadingView(this.f50098e);
            }
            this.p.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(this.q) == 0) {
                n();
            } else {
                i();
                arrayList.addAll(this.q);
                c.a.r0.j0.b.b clone = ((c.a.r0.j0.b.b) arrayList.get(arrayList.size() - 1)).clone();
                clone.f19312h = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone);
            }
            if (ListUtils.getCount(this.r) != 0) {
                c.a.r0.j0.b.b bVar = new c.a.r0.j0.b.b();
                bVar.f19312h = false;
                arrayList.add(bVar);
                arrayList.addAll(this.r);
                c.a.r0.j0.b.b clone2 = ((c.a.r0.j0.b.b) arrayList.get(arrayList.size() - 1)).clone();
                clone2.f19312h = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone2);
            }
            this.f50100g.setData(arrayList);
            this.f50100g.post(new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f50102i.O();
            this.p.a();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            i();
            if (this.o && !TbadkCoreApplication.isLogin()) {
                if (this.k == null) {
                    DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = new DownloadManagerNotLoginLayout(getContext());
                    this.k = downloadManagerNotLoginLayout;
                    downloadManagerNotLoginLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    this.k.onChangeSkinType();
                }
                this.f50100g.addHeaderView(this.k);
                return;
            }
            this.f50100g.addHeaderView(this.f50103j);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f50102i.A(getResources().getString(R.string.item_list_no_more));
            this.f50102i.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || this.m == i2) {
            return;
        }
        this.m = i2;
        changeSkinType(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.n = bundle.getInt("tab_id");
                this.o = bundle.getBoolean(DownloadManagerActivity.TAB_NEED_LOGIN);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.n = arguments.getInt("tab_id");
                    this.o = arguments.getBoolean(DownloadManagerActivity.TAB_NEED_LOGIN);
                }
            }
            if (this.p == null) {
                c.a.r0.j0.d.a a2 = c.a.r0.j0.d.b.a(this, this.n);
                this.p = a2;
                a2.d(this.t);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.ordered_fragment, viewGroup, false);
            this.f50098e = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.download_manager_ordered_recycler_view);
            this.f50100g = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.f50100g.setOnSrollToBottomListener(this);
            new c.a.r0.j0.f.a.a(this, this.f50100g, this.n);
            PbListView pbListView = new PbListView(getContext());
            this.f50102i = pbListView;
            pbListView.a();
            this.f50102i.r(l.g(getContext(), R.dimen.tbds182));
            this.f50102i.v();
            this.f50102i.E(R.dimen.tbfontsize33);
            this.f50102i.q();
            g gVar = new g(getPageContext());
            this.f50101h = gVar;
            gVar.a(this.s);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f50098e.findViewById(R.id.download_manager_ordered_layout);
            this.f50099f = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f50101h);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = new DownloadManagerNoDataLayout(getContext());
            this.f50103j = downloadManagerNoDataLayout;
            int i2 = this.n;
            if (i2 == 1) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_order);
            } else if (i2 == 2) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_download_install);
            } else if (i2 == 3) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_download);
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f50098e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            this.f50100g.setOnSrollToBottomListener(null);
            this.f50100g.setScrollable(null);
            hideLoadingView(this.f50098e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroyView();
            this.p.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onLazyLoad();
            k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onNetRefreshButtonClicked();
            k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.n);
            bundle.putBoolean(DownloadManagerActivity.TAB_NEED_LOGIN, this.o);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f50100g;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.stopScroll();
            }
            showNextPageView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.onUserChanged(z);
            if (this.o) {
                k();
            }
        }
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || z) {
            return;
        }
        this.f50099f.setRefreshing(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view) == null) {
            super.showLoadingView(view);
            this.f50099f.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048600, this, view, str, z) == null) {
            super.showNetRefreshView(view, str, z);
            this.mRefreshView.f(R.color.CAM_X0201);
            this.f50099f.setVisibility(8);
        }
    }

    public void showNextPageView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.f50102i == null) {
            return;
        }
        if (j.z() && this.f50100g.getCount() != 0) {
            this.f50100g.setNextPage(this.f50102i);
            this.f50102i.J(0);
            this.f50102i.z(null);
            if (this.l) {
                m();
                return;
            } else {
                o();
                return;
            }
        }
        this.f50100g.setNextPage(null);
    }
}
