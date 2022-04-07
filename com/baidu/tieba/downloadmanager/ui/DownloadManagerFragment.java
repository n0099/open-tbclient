package com.baidu.tieba.downloadmanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.repackage.a36;
import com.repackage.c36;
import com.repackage.du4;
import com.repackage.eu4;
import com.repackage.h36;
import com.repackage.h45;
import com.repackage.mi;
import com.repackage.oi;
import com.repackage.x26;
import com.repackage.z26;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class DownloadManagerFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BdSwipeRefreshLayout b;
    public BdTypeRecyclerView c;
    public eu4 d;
    public PbListView e;
    public DownloadManagerNoDataLayout f;
    public DownloadManagerNotLoginLayout g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public z26 m;
    public List<x26> n;
    public List<x26> o;
    public final du4.g p;
    public c36 q;

    /* loaded from: classes3.dex */
    public class a implements du4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerFragment a;

        public a(DownloadManagerFragment downloadManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadManagerFragment;
        }

        @Override // com.repackage.du4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (mi.z()) {
                    this.a.M0();
                } else {
                    this.a.N0(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c36 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadManagerFragment;
        }

        @Override // com.repackage.c36
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                this.a.K0();
                DownloadManagerFragment downloadManagerFragment2 = this.a;
                downloadManagerFragment2.showNetRefreshView(downloadManagerFragment2.a, str, false);
            }
        }

        @Override // com.repackage.c36
        public void b(List<x26> list, List<x26> list2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2, i) == null) {
                this.a.h = i == 1;
                this.a.N0(false);
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                this.a.n = list;
                this.a.o = list2;
                this.a.O0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerFragment a;

        public c(DownloadManagerFragment downloadManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadManagerFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c.getFirstVisiblePosition() == 0 && this.a.c.getLastVisiblePosition() == ((this.a.c.getHeaderViewsCount() + this.a.c.getCount()) + this.a.c.getFooterViewsCount()) - 1) {
                this.a.onScrollToBottom();
            }
        }
    }

    public DownloadManagerFragment() {
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
        this.h = true;
        this.i = 3;
        this.k = false;
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
    }

    public static DownloadManagerFragment L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new DownloadManagerFragment() : (DownloadManagerFragment) invokeV.objValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.removeHeaderView(this.f);
            this.c.removeHeaderView(this.g);
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public final void M0() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null && ((bdTypeRecyclerView.getCount() != 0 || this.c.getHeaderViewsCount() != 0) && ((h45Var = this.mRefreshView) == null || !h45Var.isViewAttached()))) {
                N0(true);
            } else {
                hideNetRefreshView(this.a);
                showLoadingView(this.a);
            }
            this.m.c();
        }
    }

    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || z) {
            return;
        }
        this.b.setRefreshing(false);
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(this.n) == 0) {
                R0();
            } else {
                J0();
                arrayList.addAll(this.n);
                x26 clone = ((x26) arrayList.get(arrayList.size() - 1)).clone();
                clone.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone);
            }
            if (ListUtils.getCount(this.o) != 0) {
                x26 x26Var = new x26();
                x26Var.d = false;
                arrayList.add(x26Var);
                arrayList.addAll(this.o);
                x26 clone2 = ((x26) arrayList.get(arrayList.size() - 1)).clone();
                clone2.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone2);
            }
            this.c.setData(arrayList);
            this.c.post(new c(this));
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.Q();
            this.m.a();
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.e == null) {
            return;
        }
        if (mi.z() && this.c.getCount() != 0) {
            this.c.setNextPage(this.e);
            this.e.L(0);
            this.e.B(null);
            if (this.h) {
                P0();
                return;
            } else {
                S0();
                return;
            }
        }
        this.c.setNextPage(null);
    }

    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            J0();
            if (this.k && !TbadkCoreApplication.isLogin()) {
                if (this.g == null) {
                    DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = new DownloadManagerNotLoginLayout(getContext());
                    this.g = downloadManagerNotLoginLayout;
                    downloadManagerNotLoginLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    this.g.c();
                }
                this.c.s(this.g);
                return;
            }
            this.c.s(this.f);
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.C(getResources().getString(R.string.obfuscated_res_0x7f0f0975));
            this.e.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = this.f;
            if (downloadManagerNoDataLayout != null) {
                downloadManagerNoDataLayout.b();
            }
            h45 h45Var = this.mRefreshView;
            if (h45Var != null) {
                h45Var.f(R.color.CAM_X0201);
            }
            eu4 eu4Var = this.d;
            if (eu4Var != null) {
                eu4Var.H(i);
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.e.p(R.color.transparent);
                this.e.d(i);
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = this.g;
            if (downloadManagerNotLoginLayout != null) {
                downloadManagerNotLoginLayout.c();
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.b;
            if (bdSwipeRefreshLayout != null) {
                SkinManager.setBackgroundColor(bdSwipeRefreshLayout, R.color.CAM_X0204);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            super.hideLoadingView(view2);
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || this.i == i) {
            return;
        }
        this.i = i;
        changeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.j = bundle.getInt("tab_id");
                this.k = bundle.getBoolean(DownloadManagerActivity.TAB_NEED_LOGIN);
                this.l = bundle.getInt(DownloadManagerActivity.TAB_SOURCE);
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.j = arguments.getInt("tab_id");
                    this.k = arguments.getBoolean(DownloadManagerActivity.TAB_NEED_LOGIN);
                    this.l = arguments.getInt(DownloadManagerActivity.TAB_SOURCE);
                }
            }
            if (this.m == null) {
                z26 a2 = a36.a(this, this.j);
                this.m = a2;
                a2.d(this.q);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d064e, viewGroup, false);
            this.a = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f09082a);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.c.setOnSrollToBottomListener(this);
            new h36(this, this.c, this.j, this.l);
            PbListView pbListView = new PbListView(getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.t(oi.f(getContext(), R.dimen.tbds182));
            this.e.x();
            this.e.G(R.dimen.tbfontsize33);
            this.e.s();
            eu4 eu4Var = new eu4(getPageContext());
            this.d = eu4Var;
            eu4Var.f(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090829);
            this.b = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.d);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = new DownloadManagerNoDataLayout(getContext());
            this.f = downloadManagerNoDataLayout;
            int i = this.j;
            if (i == 1) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f0976);
            } else if (i == 2) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f096a);
            } else if (i == 3) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f0967);
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            this.c.setOnSrollToBottomListener(null);
            this.c.setScrollable(null);
            hideLoadingView(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroyView();
            this.m.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onLazyLoad();
            M0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onNetRefreshButtonClicked();
            M0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.j);
            bundle.putBoolean(DownloadManagerActivity.TAB_NEED_LOGIN, this.k);
            bundle.putInt(DownloadManagerActivity.TAB_SOURCE, this.l);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.stopScroll();
            }
            Q0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            super.onUserChanged(z);
            if (this.k) {
                M0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view2) == null) {
            super.showLoadingView(view2);
            this.b.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048601, this, view2, str, z) == null) {
            super.showNetRefreshView(view2, str, z);
            this.mRefreshView.f(R.color.CAM_X0201);
            this.b.setVisibility(8);
        }
    }
}
