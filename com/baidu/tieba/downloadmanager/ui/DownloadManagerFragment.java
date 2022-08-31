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
import com.baidu.tieba.bv4;
import com.baidu.tieba.cv4;
import com.baidu.tieba.h56;
import com.baidu.tieba.j56;
import com.baidu.tieba.k56;
import com.baidu.tieba.l65;
import com.baidu.tieba.m56;
import com.baidu.tieba.pi;
import com.baidu.tieba.r56;
import com.baidu.tieba.ri;
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
    public cv4 d;
    public PbListView e;
    public DownloadManagerNoDataLayout f;
    public DownloadManagerNotLoginLayout g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public j56 m;
    public List<h56> n;
    public List<h56> o;
    public final bv4.g p;
    public m56 q;

    /* loaded from: classes3.dex */
    public class a implements bv4.g {
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

        @Override // com.baidu.tieba.bv4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (pi.z()) {
                    this.a.D1();
                } else {
                    this.a.E1(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements m56 {
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

        @Override // com.baidu.tieba.m56
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                this.a.B1();
                DownloadManagerFragment downloadManagerFragment2 = this.a;
                downloadManagerFragment2.showNetRefreshView(downloadManagerFragment2.a, str, false);
            }
        }

        @Override // com.baidu.tieba.m56
        public void b(List<h56> list, List<h56> list2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2, i) == null) {
                this.a.h = i == 1;
                this.a.E1(false);
                DownloadManagerFragment downloadManagerFragment = this.a;
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                this.a.n = list;
                this.a.o = list2;
                this.a.F1();
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

    public static DownloadManagerFragment C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new DownloadManagerFragment() : (DownloadManagerFragment) invokeV.objValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c.removeHeaderView(this.f);
            this.c.removeHeaderView(this.g);
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public final void D1() {
        l65 l65Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null && ((bdTypeRecyclerView.getCount() != 0 || this.c.getHeaderViewsCount() != 0) && ((l65Var = this.mRefreshView) == null || !l65Var.isViewAttached()))) {
                E1(true);
            } else {
                hideNetRefreshView(this.a);
                showLoadingView(this.a);
            }
            this.m.c();
        }
    }

    public void E1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || z) {
            return;
        }
        this.b.setRefreshing(false);
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(this.n) == 0) {
                I1();
            } else {
                A1();
                arrayList.addAll(this.n);
                h56 clone = ((h56) arrayList.get(arrayList.size() - 1)).clone();
                clone.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone);
            }
            if (ListUtils.getCount(this.o) != 0) {
                h56 h56Var = new h56();
                h56Var.d = false;
                arrayList.add(h56Var);
                arrayList.addAll(this.o);
                h56 clone2 = ((h56) arrayList.get(arrayList.size() - 1)).clone();
                clone2.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone2);
            }
            this.c.setData(arrayList);
            this.c.post(new c(this));
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e.Q();
            this.m.a();
        }
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.e == null) {
            return;
        }
        if (pi.z() && this.c.getCount() != 0) {
            this.c.setNextPage(this.e);
            this.e.L(0);
            this.e.B(null);
            if (this.h) {
                G1();
                return;
            } else {
                J1();
                return;
            }
        }
        this.c.setNextPage(null);
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            A1();
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

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.C(getResources().getString(R.string.obfuscated_res_0x7f0f0995));
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
            l65 l65Var = this.mRefreshView;
            if (l65Var != null) {
                l65Var.f(R.color.CAM_X0201);
            }
            cv4 cv4Var = this.d;
            if (cv4Var != null) {
                cv4Var.H(i);
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
                this.k = bundle.getBoolean("tab_need_login");
                this.l = bundle.getInt("tab_source");
            } else {
                Bundle arguments = getArguments();
                if (arguments != null) {
                    this.j = arguments.getInt("tab_id");
                    this.k = arguments.getBoolean("tab_need_login");
                    this.l = arguments.getInt("tab_source");
                }
            }
            if (this.m == null) {
                j56 a2 = k56.a(this, this.j);
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
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d067f, viewGroup, false);
            this.a = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f090824);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.c.setOnSrollToBottomListener(this);
            new r56(this, this.c, this.j, this.l);
            PbListView pbListView = new PbListView(getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.t(ri.f(getContext(), R.dimen.tbds182));
            this.e.x();
            this.e.G(R.dimen.tbfontsize33);
            this.e.s();
            cv4 cv4Var = new cv4(getPageContext());
            this.d = cv4Var;
            cv4Var.f(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090823);
            this.b = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.d);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = new DownloadManagerNoDataLayout(getContext());
            this.f = downloadManagerNoDataLayout;
            int i = this.j;
            if (i == 1) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f0996);
            } else if (i == 2) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f098a);
            } else if (i == 3) {
                downloadManagerNoDataLayout.setNoDataText(R.string.obfuscated_res_0x7f0f0987);
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
            D1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onNetRefreshButtonClicked();
            D1();
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
            bundle.putBoolean("tab_need_login", this.k);
            bundle.putInt("tab_source", this.l);
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
            H1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            super.onUserChanged(z);
            if (this.k) {
                D1();
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
