package com.baidu.tieba.downloadmanager.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.av6;
import com.baidu.tieba.bv6;
import com.baidu.tieba.downloadmanager.data.DownloadManageModeCardType;
import com.baidu.tieba.downloadmanager.ui.DownloadManageButton;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
import com.baidu.tieba.dv6;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.g55;
import com.baidu.tieba.h55;
import com.baidu.tieba.jv6;
import com.baidu.tieba.oj5;
import com.baidu.tieba.v55;
import com.baidu.tieba.wj5;
import com.baidu.tieba.yu6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class DownloadManagerFragment extends BaseFragment implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h A;
    public final g55.g B;
    public View a;
    public BdSwipeRefreshLayout b;
    public BdTypeRecyclerView c;
    public h55 d;
    public PbListView e;
    public DownloadManagerNoDataLayout f;
    public DownloadManagerNotLoginLayout g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public av6 m;
    public jv6 n;
    public List<yu6> o;
    public List<yu6> p;
    public RelativeLayout q;
    public TBSpecificationBtn r;
    public i s;
    public DownloadManageButton.DownloadManageType t;
    public EMTextView u;
    public RadioButton v;
    public LinearLayout w;
    public EMTextView x;
    public int y;
    public TBAlertBuilder z;

    /* loaded from: classes5.dex */
    public interface i {
        void A(DownloadManageButton.DownloadManageType downloadManageType);
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ArrayList arrayList = new ArrayList();
                for (yu6 yu6Var : this.a.o) {
                    if (yu6Var != null && yu6Var.e) {
                        arrayList.add(yu6Var);
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
                this.a.a3(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !this.a.v.isChecked();
                this.a.v.setChecked(z);
                this.a.X2(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ItemCardViewWrapperAdapter.b {
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

        @Override // com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter.b
        public void a(yu6 yu6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yu6Var) == null) {
                if (yu6Var.e) {
                    DownloadManagerFragment.G2(this.a);
                    if (this.a.y == this.a.o.size()) {
                        this.a.v.setChecked(true);
                    }
                } else {
                    DownloadManagerFragment.H2(this.a);
                    this.a.v.setChecked(false);
                }
                this.a.x.setText(String.format(TbadkApplication.getInst().getString(R.string.selected_count), Integer.valueOf(this.a.y)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerFragment a;

        public d(DownloadManagerFragment downloadManagerFragment) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.z.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ DownloadManagerFragment b;

        public e(DownloadManagerFragment downloadManagerFragment, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadManagerFragment, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = downloadManagerFragment;
            this.a = list;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.z.dismiss();
                this.b.A = new h(this.a, this.b);
                this.b.A.execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements g55.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerFragment a;

        public f(DownloadManagerFragment downloadManagerFragment) {
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

        @Override // com.baidu.tieba.g55.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.Y2(false);
                } else {
                    this.a.W2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadManagerFragment a;

        public g(DownloadManagerFragment downloadManagerFragment) {
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

    /* loaded from: classes5.dex */
    public static class h extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<yu6> a;
        public WeakReference<DownloadManagerFragment> b;

        public h(List<yu6> list, DownloadManagerFragment downloadManagerFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, downloadManagerFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.addAll(list);
            this.b = new WeakReference<>(downloadManagerFragment);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) throws IOException {
            InterceptResult invokeL;
            DownloadManagerFragment downloadManagerFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                WeakReference<DownloadManagerFragment> weakReference = this.b;
                if (weakReference != null) {
                    downloadManagerFragment = weakReference.get();
                } else {
                    downloadManagerFragment = null;
                }
                if (downloadManagerFragment == null) {
                    return Boolean.FALSE;
                }
                TbDownloadManager tbDownloadManager = new TbDownloadManager();
                for (int i = 0; i < this.a.size(); i++) {
                    yu6 yu6Var = this.a.get(i);
                    if (yu6Var != null) {
                        DownloadData k = oj5.k(yu6Var.a);
                        k.setSource(yu6Var.b);
                        tbDownloadManager.h(k);
                    }
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            DownloadManagerFragment downloadManagerFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bool) == null) {
                super.onPostExecute((h) bool);
                WeakReference<DownloadManagerFragment> weakReference = this.b;
                if (weakReference != null) {
                    downloadManagerFragment = weakReference.get();
                } else {
                    downloadManagerFragment = null;
                }
                if (downloadManagerFragment != null && bool.booleanValue()) {
                    downloadManagerFragment.V2(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements dv6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<DownloadManagerFragment> a;

        public j(DownloadManagerFragment downloadManagerFragment) {
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
            this.a = new WeakReference<>(downloadManagerFragment);
        }

        @Override // com.baidu.tieba.dv6
        public void a(List<yu6> list, List<yu6> list2, int i) {
            DownloadManagerFragment downloadManagerFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, list, list2, i) == null) && (downloadManagerFragment = this.a.get()) != null) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                downloadManagerFragment.h = z;
                downloadManagerFragment.Y2(false);
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                downloadManagerFragment.o = list;
                downloadManagerFragment.p = list2;
                downloadManagerFragment.Z2();
            }
        }

        @Override // com.baidu.tieba.dv6
        public void b(int i, String str) {
            DownloadManagerFragment downloadManagerFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (downloadManagerFragment = this.a.get()) != null) {
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                downloadManagerFragment.S2();
                downloadManagerFragment.showNetRefreshView(downloadManagerFragment.a, str, false);
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
        this.h = true;
        this.i = 3;
        this.k = false;
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.t = DownloadManageButton.DownloadManageType.NONE_TASK;
        this.y = 0;
        this.B = new f(this);
    }

    public final void W2() {
        wj5 wj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null && ((bdTypeRecyclerView.getCount() != 0 || this.c.getHeaderViewsCount() != 0) && ((wj5Var = this.mRefreshView) == null || !wj5Var.isViewAttached()))) {
                Y2(true);
            } else {
                hideNetRefreshView(this.a);
                showLoadingView(this.a);
            }
            this.m.c();
        }
    }

    public void c3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.e != null) {
            if (BdNetTypeUtil.isNetWorkAvailable() && this.c.getCount() != 0) {
                this.c.setNextPage(this.e);
                this.e.P(0);
                this.e.G(null);
                if (this.h) {
                    b3();
                    return;
                } else {
                    e3();
                    return;
                }
            }
            this.c.setNextPage(null);
        }
    }

    public static /* synthetic */ int G2(DownloadManagerFragment downloadManagerFragment) {
        int i2 = downloadManagerFragment.y;
        downloadManagerFragment.y = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int H2(DownloadManagerFragment downloadManagerFragment) {
        int i2 = downloadManagerFragment.y;
        downloadManagerFragment.y = i2 - 1;
        return i2;
    }

    public void Y2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && !z) {
            this.b.setRefreshing(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            super.hideLoadingView(view2);
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            super.onAttach(context);
            if (getActivity() instanceof i) {
                this.s = (i) getActivity();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048597, this, i2) != null) || this.i == i2) {
            return;
        }
        this.i = i2;
        changeSkinType(i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.j);
            bundle.putBoolean("tab_need_login", this.k);
            bundle.putInt("tab_source", this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            super.onUserChanged(z);
            if (this.k) {
                W2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view2) == null) {
            super.showLoadingView(view2);
            this.b.setVisibility(8);
        }
    }

    public static DownloadManagerFragment U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return new DownloadManagerFragment();
        }
        return (DownloadManagerFragment) invokeV.objValue;
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q.setVisibility(0);
            this.n.a(DownloadManageModeCardType.ENTER_MANAGE_MODE);
            this.b.setEnabled(false);
        }
    }

    public DownloadManageButton.DownloadManageType Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.t;
        }
        return (DownloadManageButton.DownloadManageType) invokeV.objValue;
    }

    public final void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.removeHeaderView(this.f);
            this.c.removeHeaderView(this.g);
        }
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.r.setOnClickListener(new a(this));
            this.w.setOnClickListener(new b(this));
            this.n.d(new c(this));
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.U();
            this.m.a();
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && isAdded()) {
            this.e.H(getResources().getString(R.string.obfuscated_res_0x7f0f0b67));
            this.e.g();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDestroy();
            h hVar = this.A;
            if (hVar != null) {
                hVar.cancel();
            }
            this.c.setOnSrollToBottomListener(null);
            this.c.setScrollable(null);
            hideLoadingView(this.a);
            av6 av6Var = this.m;
            if (av6Var != null) {
                av6Var.d(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroyView();
            this.m.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onLazyLoad();
            W2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onNetRefreshButtonClicked();
            W2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPrimary();
            if (isPrimary() && !this.isLazyLoaded) {
                onLazyLoad();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.stopScroll();
            }
            c3();
        }
    }

    public void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.setVisibility(8);
            this.n.a(DownloadManageModeCardType.EXIT_MANAGE_MODE);
            this.b.setEnabled(true);
            this.v.setChecked(false);
            X2(false);
            this.x.setText(String.format(TbadkApplication.getInst().getString(R.string.selected_count), Integer.valueOf(this.y)));
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            R2();
            if (this.k && !TbadkCoreApplication.isLogin()) {
                if (this.g == null) {
                    DownloadManagerNotLoginLayout downloadManagerNotLoginLayout = new DownloadManagerNotLoginLayout(getContext());
                    this.g = downloadManagerNotLoginLayout;
                    downloadManagerNotLoginLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    this.g.c();
                }
                this.c.addHeaderView(this.g);
                return;
            }
            this.c.addHeaderView(this.f);
        }
    }

    public final void V2(List<yu6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.o.removeAll(list);
            Z2();
            this.n.c();
            if (this.o.size() == 0) {
                this.t = DownloadManageButton.DownloadManageType.NONE_TASK;
            } else {
                this.t = DownloadManageButton.DownloadManageType.NORMAL;
            }
            i iVar = this.s;
            if (iVar != null) {
                iVar.A(this.t);
            }
        }
    }

    public final void X2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                yu6 yu6Var = this.o.get(i2);
                if (yu6Var != null) {
                    yu6Var.e = z;
                }
            }
            if (z) {
                this.y = this.o.size();
            } else {
                this.y = 0;
            }
            this.x.setText(String.format(TbadkApplication.getInst().getString(R.string.selected_count), Integer.valueOf(this.y)));
            jv6 jv6Var = this.n;
            if (jv6Var != null) {
                jv6Var.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
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
                av6 a2 = bv6.a(getPageContext(), getUniqueId(), this.j);
                this.m = a2;
                a2.d(new j(this));
            }
        }
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(this.o) == 0) {
                d3();
            } else {
                R2();
                arrayList.addAll(this.o);
                yu6 clone = ((yu6) arrayList.get(arrayList.size() - 1)).clone();
                clone.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone);
            }
            this.o.clear();
            if (!arrayList.isEmpty()) {
                DownloadManageButton.DownloadManageType downloadManageType = DownloadManageButton.DownloadManageType.NORMAL;
                this.t = downloadManageType;
                i iVar = this.s;
                if (iVar != null) {
                    iVar.A(downloadManageType);
                }
            } else {
                this.t = DownloadManageButton.DownloadManageType.NONE_TASK;
            }
            this.o.addAll(arrayList);
            if (ListUtils.getCount(this.p) != 0) {
                yu6 yu6Var = new yu6();
                yu6Var.d = false;
                arrayList.add(yu6Var);
                arrayList.addAll(this.p);
                yu6 clone2 = ((yu6) arrayList.get(arrayList.size() - 1)).clone();
                clone2.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone2);
            }
            this.c.setData(arrayList);
            this.c.post(new g(this));
        }
    }

    public final void a3(List<yu6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig(TbadkApplication.getInst().getString(R.string.think_more), TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig(TbadkApplication.getInst().getString(R.string.confirm_delete), TBAlertConfig.OperateBtnStyle.ALERT);
            TBAlertBuilder operateBtn = new TBAlertBuilder(getActivity()).setTitleStr(String.format(TbadkApplication.getInst().getString(R.string.download_delete_title), Integer.valueOf(list.size()))).setDesc(R.string.download_delete_description).setDescLightStyle(true).setOperateBtn(operateBtnConfig, operateBtnConfig2);
            this.z = operateBtn;
            operateBtn.show();
            operateBtnConfig.setListener(new d(this));
            operateBtnConfig2.setListener(new e(this, list));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = this.f;
            if (downloadManagerNoDataLayout != null) {
                downloadManagerNoDataLayout.b(getPageContext(), i2);
            }
            wj5 wj5Var = this.mRefreshView;
            if (wj5Var != null) {
                wj5Var.e(R.color.CAM_X0201);
            }
            h55 h55Var = this.d;
            if (h55Var != null) {
                h55Var.D(i2);
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.e.s(R.color.transparent);
                this.e.e(i2);
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
            TBSpecificationBtn tBSpecificationBtn = this.r;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
            EMTextView eMTextView = this.u;
            if (eMTextView != null) {
                EMManager.from(eMTextView).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0105);
            }
            RelativeLayout relativeLayout = this.q;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            }
            EMTextView eMTextView2 = this.x;
            if (eMTextView2 != null) {
                EMManager.from(eMTextView2).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0108);
            }
            TBAlertBuilder tBAlertBuilder = this.z;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048599, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d077a, viewGroup, false);
            this.a = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f09096f);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.c.setOnSrollToBottomListener(this);
            this.n = new jv6(this, this.c, this.j, this.l);
            PbListView pbListView = new PbListView(getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds182));
            this.e.B();
            this.e.L(R.dimen.tbfontsize33);
            this.e.v();
            h55 h55Var = new h55(getPageContext());
            this.d = h55Var;
            h55Var.a(this.B);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f09096e);
            this.b = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.d);
            this.q = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090974);
            this.r = (TBSpecificationBtn) this.a.findViewById(R.id.obfuscated_res_0x7f090975);
            v55 v55Var = new v55();
            v55Var.s(R.color.CAM_X0301, R.color.CAM_X0101);
            this.r.setConfig(v55Var);
            EMManager.from(this.r).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0101);
            this.r.setText(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0553));
            this.u = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090972);
            this.v = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090971);
            this.w = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090970);
            this.x = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090973);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = new DownloadManagerNoDataLayout(getContext());
            this.f = downloadManagerNoDataLayout;
            int i2 = this.j;
            if (i2 == 1) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_order);
            } else if (i2 == 2) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_download_install);
            } else if (i2 == 3) {
                downloadManagerNoDataLayout.setNoDataText(R.string.item_download);
            }
            changeSkinType(TbadkCoreApplication.getInst().getSkinType());
            T2();
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048609, this, view2, str, z) == null) {
            super.showNetRefreshView(view2, str, z);
            this.mRefreshView.e(R.color.CAM_X0201);
            this.b.setVisibility(8);
        }
    }
}
