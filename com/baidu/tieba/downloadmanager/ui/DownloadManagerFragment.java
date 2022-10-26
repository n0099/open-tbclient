package com.baidu.tieba.downloadmanager.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.b86;
import com.baidu.tieba.ey4;
import com.baidu.tieba.fj;
import com.baidu.tieba.fy4;
import com.baidu.tieba.k95;
import com.baidu.tieba.r76;
import com.baidu.tieba.t76;
import com.baidu.tieba.u76;
import com.baidu.tieba.w76;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class DownloadManagerFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public BdSwipeRefreshLayout b;
    public BdTypeRecyclerView c;
    public fy4 d;
    public PbListView e;
    public DownloadManagerNoDataLayout f;
    public DownloadManagerNotLoginLayout g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public t76 m;
    public List n;
    public List o;
    public final ey4.g p;
    public w76 q;

    /* loaded from: classes3.dex */
    public class a implements ey4.g {
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

        @Override // com.baidu.tieba.ey4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.D1(false);
                } else {
                    this.a.C1();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements w76 {
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

        @Override // com.baidu.tieba.w76
        public void a(List list, List list2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, list, list2, i) == null) {
                DownloadManagerFragment downloadManagerFragment = this.a;
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                downloadManagerFragment.h = z;
                this.a.D1(false);
                DownloadManagerFragment downloadManagerFragment2 = this.a;
                downloadManagerFragment2.hideLoadingView(downloadManagerFragment2.a);
                this.a.n = list;
                this.a.o = list2;
                this.a.E1();
            }
        }

        @Override // com.baidu.tieba.w76
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                this.a.A1();
                DownloadManagerFragment downloadManagerFragment2 = this.a;
                downloadManagerFragment2.showNetRefreshView(downloadManagerFragment2.a, str, false);
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

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            z1();
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

    public static DownloadManagerFragment B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new DownloadManagerFragment();
        }
        return (DownloadManagerFragment) invokeV.objValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.R();
            this.m.a();
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.D(getResources().getString(R.string.obfuscated_res_0x7f0f09b5));
            this.e.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            this.c.setOnSrollToBottomListener(null);
            this.c.setScrollable(null);
            hideLoadingView(this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            this.m.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onLazyLoad();
            C1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onNetRefreshButtonClicked();
            C1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPrimary();
            if (isPrimary() && !this.isLazyLoaded) {
                onLazyLoad();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.stopScroll();
            }
            G1();
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.c.removeHeaderView(this.f);
            this.c.removeHeaderView(this.g);
        }
    }

    public void D1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && !z) {
            this.b.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            super.hideLoadingView(view2);
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048588, this, i) != null) || this.i == i) {
            return;
        }
        this.i = i;
        changeSkinType(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt(TiebaStatic.Params.TAB_ID, this.j);
            bundle.putBoolean("tab_need_login", this.k);
            bundle.putInt("tab_source", this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            super.onUserChanged(z);
            if (this.k) {
                C1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.showLoadingView(view2);
            this.b.setVisibility(8);
        }
    }

    public final void C1() {
        k95 k95Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null && ((bdTypeRecyclerView.getCount() != 0 || this.c.getHeaderViewsCount() != 0) && ((k95Var = this.mRefreshView) == null || !k95Var.isViewAttached()))) {
                D1(true);
            } else {
                hideNetRefreshView(this.a);
                showLoadingView(this.a);
            }
            this.m.c();
        }
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.e != null) {
            if (BdNetTypeUtil.isNetWorkAvailable() && this.c.getCount() != 0) {
                this.c.setNextPage(this.e);
                this.e.M(0);
                this.e.C(null);
                if (this.h) {
                    F1();
                    return;
                } else {
                    I1();
                    return;
                }
            }
            this.c.setNextPage(null);
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(this.n) == 0) {
                H1();
            } else {
                z1();
                arrayList.addAll(this.n);
                r76 clone = ((r76) arrayList.get(arrayList.size() - 1)).clone();
                clone.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone);
            }
            if (ListUtils.getCount(this.o) != 0) {
                r76 r76Var = new r76();
                r76Var.d = false;
                arrayList.add(r76Var);
                arrayList.addAll(this.o);
                r76 clone2 = ((r76) arrayList.get(arrayList.size() - 1)).clone();
                clone2.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone2);
            }
            this.c.setData(arrayList);
            this.c.post(new c(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = this.f;
            if (downloadManagerNoDataLayout != null) {
                downloadManagerNoDataLayout.b();
            }
            k95 k95Var = this.mRefreshView;
            if (k95Var != null) {
                k95Var.f(R.color.CAM_X0201);
            }
            fy4 fy4Var = this.d;
            if (fy4Var != null) {
                fy4Var.H(i);
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0109));
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                this.j = bundle.getInt(TiebaStatic.Params.TAB_ID);
                this.k = bundle.getBoolean("tab_need_login");
                this.l = bundle.getInt("tab_source");
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.j = arguments.getInt(TiebaStatic.Params.TAB_ID);
                    this.k = arguments.getBoolean("tab_need_login");
                    this.l = arguments.getInt("tab_source");
                }
            }
            if (this.m == null) {
                t76 a2 = u76.a(this, this.j);
                this.m = a2;
                a2.d(this.q);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0696, viewGroup, false);
            this.a = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f090842);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.c.setOnSrollToBottomListener(this);
            new b86(this, this.c, this.j, this.l);
            PbListView pbListView = new PbListView(getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.t(fj.f(getContext(), R.dimen.tbds182));
            this.e.y();
            this.e.H(R.dimen.tbfontsize33);
            this.e.s();
            fy4 fy4Var = new fy4(getPageContext());
            this.d = fy4Var;
            fy4Var.f(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090841);
            this.b = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.d);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = new DownloadManagerNoDataLayout(getContext());
            this.f = downloadManagerNoDataLayout;
            int i = this.j;
            if (i == 1) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f09b6);
            } else if (i == 2) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f09aa);
            } else if (i == 3) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f09a7);
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048600, this, view2, str, z) == null) {
            super.showNetRefreshView(view2, str, z);
            this.mRefreshView.f(R.color.CAM_X0201);
            this.b.setVisibility(8);
        }
    }
}
