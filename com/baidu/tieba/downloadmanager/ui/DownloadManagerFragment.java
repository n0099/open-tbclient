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
import com.baidu.tieba.R;
import com.baidu.tieba.dn5;
import com.baidu.tieba.downloadmanager.data.DownloadManageModeCardType;
import com.baidu.tieba.downloadmanager.ui.DownloadManageButton;
import com.baidu.tieba.downloadmanager.ui.adapter.ItemCardViewWrapperAdapter;
import com.baidu.tieba.ea5;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.ox6;
import com.baidu.tieba.p95;
import com.baidu.tieba.q95;
import com.baidu.tieba.qx6;
import com.baidu.tieba.rx6;
import com.baidu.tieba.tx6;
import com.baidu.tieba.vm5;
import com.baidu.tieba.zx6;
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
    public final p95.g B;
    public View a;
    public BdSwipeRefreshLayout b;
    public BdTypeRecyclerView c;
    public q95 d;
    public PbListView e;
    public DownloadManagerNoDataLayout f;
    public DownloadManagerNotLoginLayout g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public qx6 m;
    public zx6 n;
    public List<ox6> o;
    public List<ox6> p;
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
        void E(DownloadManageButton.DownloadManageType downloadManageType);
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
                for (ox6 ox6Var : this.a.o) {
                    if (ox6Var != null && ox6Var.e) {
                        arrayList.add(ox6Var);
                    }
                }
                if (arrayList.size() == 0) {
                    return;
                }
                this.a.A2(arrayList);
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
                this.a.x2(z);
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
        public void a(ox6 ox6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ox6Var) == null) {
                if (ox6Var.e) {
                    DownloadManagerFragment.g2(this.a);
                    if (this.a.y == this.a.o.size()) {
                        this.a.v.setChecked(true);
                    }
                } else {
                    DownloadManagerFragment.h2(this.a);
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
    public class f implements p95.g {
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

        @Override // com.baidu.tieba.p95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.y2(false);
                } else {
                    this.a.w2();
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
        public List<ox6> a;
        public WeakReference<DownloadManagerFragment> b;

        public h(List<ox6> list, DownloadManagerFragment downloadManagerFragment) {
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
                    tbDownloadManager.h(vm5.k(this.a.get(i).a));
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
                    downloadManagerFragment.v2(this.a);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements tx6 {
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

        @Override // com.baidu.tieba.tx6
        public void a(List<ox6> list, List<ox6> list2, int i) {
            DownloadManagerFragment downloadManagerFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048576, this, list, list2, i) == null) && (downloadManagerFragment = this.a.get()) != null) {
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                downloadManagerFragment.h = z;
                downloadManagerFragment.y2(false);
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                downloadManagerFragment.o = list;
                downloadManagerFragment.p = list2;
                downloadManagerFragment.z2();
            }
        }

        @Override // com.baidu.tieba.tx6
        public void b(int i, String str) {
            DownloadManagerFragment downloadManagerFragment;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (downloadManagerFragment = this.a.get()) != null) {
                downloadManagerFragment.hideLoadingView(downloadManagerFragment.a);
                downloadManagerFragment.s2();
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

    public void C2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.e != null) {
            if (BdNetTypeUtil.isNetWorkAvailable() && this.c.getCount() != 0) {
                this.c.setNextPage(this.e);
                this.e.P(0);
                this.e.G(null);
                if (this.h) {
                    B2();
                    return;
                } else {
                    E2();
                    return;
                }
            }
            this.c.setNextPage(null);
        }
    }

    public final void w2() {
        dn5 dn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null && ((bdTypeRecyclerView.getCount() != 0 || this.c.getHeaderViewsCount() != 0) && ((dn5Var = this.mRefreshView) == null || !dn5Var.isViewAttached()))) {
                y2(true);
            } else {
                hideNetRefreshView(this.a);
                showLoadingView(this.a);
            }
            this.m.c();
        }
    }

    public static /* synthetic */ int g2(DownloadManagerFragment downloadManagerFragment) {
        int i2 = downloadManagerFragment.y;
        downloadManagerFragment.y = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int h2(DownloadManagerFragment downloadManagerFragment) {
        int i2 = downloadManagerFragment.y;
        downloadManagerFragment.y = i2 - 1;
        return i2;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            super.hideLoadingView(view2);
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            super.hideNetRefreshView(view2);
            this.b.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            super.onAttach(context);
            if (getActivity() instanceof i) {
                this.s = (i) getActivity();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i2) != null) || this.i == i2) {
            return;
        }
        this.i = i2;
        changeSkinType(i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putInt("tab_id", this.j);
            bundle.putBoolean("tab_need_login", this.k);
            bundle.putInt("tab_source", this.l);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            super.onUserChanged(z);
            if (this.k) {
                w2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view2) == null) {
            super.showLoadingView(view2);
            this.b.setVisibility(8);
        }
    }

    public void y2(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048608, this, z) == null) && !z) {
            this.b.setRefreshing(false);
        }
    }

    public static DownloadManagerFragment u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            return new DownloadManagerFragment();
        }
        return (DownloadManagerFragment) invokeV.objValue;
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.U();
            this.m.a();
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && isAdded()) {
            this.e.H(getResources().getString(R.string.obfuscated_res_0x7f0f0b36));
            this.e.g();
        }
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.q.setVisibility(0);
            this.n.a(DownloadManageModeCardType.ENTER_MANAGE_MODE);
            this.b.setEnabled(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            h hVar = this.A;
            if (hVar != null) {
                hVar.cancel();
            }
            this.c.setOnSrollToBottomListener(null);
            this.c.setScrollable(null);
            hideLoadingView(this.a);
            qx6 qx6Var = this.m;
            if (qx6Var != null) {
                qx6Var.d(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroyView();
            this.m.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onLazyLoad();
            w2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onNetRefreshButtonClicked();
            w2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPrimary();
            if (isPrimary() && !this.isLazyLoaded) {
                onLazyLoad();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.c;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.stopScroll();
            }
            C2();
        }
    }

    public DownloadManageButton.DownloadManageType q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.t;
        }
        return (DownloadManageButton.DownloadManageType) invokeV.objValue;
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.c.removeHeaderView(this.f);
            this.c.removeHeaderView(this.g);
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.r.setOnClickListener(new a(this));
            this.w.setOnClickListener(new b(this));
            this.n.d(new c(this));
        }
    }

    public final void A2(List<ox6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig(TbadkApplication.getInst().getString(R.string.think_more), TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig(TbadkApplication.getInst().getString(R.string.confirm_delete), TBAlertConfig.OperateBtnStyle.ALERT);
            TBAlertBuilder operateBtn = new TBAlertBuilder(getActivity()).setTitleStr(String.format(TbadkApplication.getInst().getString(R.string.download_delete_title), Integer.valueOf(list.size()))).setDesc(R.string.download_delete_description).setDescLightStyle(true).setOperateBtn(operateBtnConfig, operateBtnConfig2);
            this.z = operateBtn;
            operateBtn.show();
            operateBtnConfig.setListener(new d(this));
            operateBtnConfig2.setListener(new e(this, list));
        }
    }

    public final void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            r2();
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

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.q.setVisibility(8);
            this.n.a(DownloadManageModeCardType.EXIT_MANAGE_MODE);
            this.b.setEnabled(true);
            this.v.setChecked(false);
            x2(false);
            this.x.setText(String.format(TbadkApplication.getInst().getString(R.string.selected_count), Integer.valueOf(this.y)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            DownloadManagerNoDataLayout downloadManagerNoDataLayout = this.f;
            if (downloadManagerNoDataLayout != null) {
                downloadManagerNoDataLayout.b(getPageContext(), i2);
            }
            dn5 dn5Var = this.mRefreshView;
            if (dn5Var != null) {
                dn5Var.e(R.color.CAM_X0201);
            }
            q95 q95Var = this.d;
            if (q95Var != null) {
                q95Var.C(i2);
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
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
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
                qx6 a2 = rx6.a(getPageContext(), getUniqueId(), this.j);
                this.m = a2;
                a2.d(new j(this));
            }
        }
    }

    public final void x2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                ox6 ox6Var = this.o.get(i2);
                if (ox6Var != null) {
                    ox6Var.e = z;
                }
            }
            if (z) {
                this.y = this.o.size();
            } else {
                this.y = 0;
            }
            this.x.setText(String.format(TbadkApplication.getInst().getString(R.string.selected_count), Integer.valueOf(this.y)));
            zx6 zx6Var = this.n;
            if (zx6Var != null) {
                zx6Var.c();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0760, viewGroup, false);
            this.a = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f090943);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.c.setOnSrollToBottomListener(this);
            this.n = new zx6(this, this.c, this.j, this.l);
            PbListView pbListView = new PbListView(getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.w(BdUtilHelper.getDimens(getContext(), R.dimen.tbds182));
            this.e.B();
            this.e.L(R.dimen.tbfontsize33);
            this.e.v();
            q95 q95Var = new q95(getPageContext());
            this.d = q95Var;
            q95Var.a(this.B);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090942);
            this.b = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.d);
            this.q = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090948);
            this.r = (TBSpecificationBtn) this.a.findViewById(R.id.obfuscated_res_0x7f090949);
            ea5 ea5Var = new ea5();
            ea5Var.s(R.color.CAM_X0301, R.color.CAM_X0101);
            this.r.setConfig(ea5Var);
            EMManager.from(this.r).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0101);
            this.r.setText(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0548));
            this.u = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090946);
            this.v = (RadioButton) this.a.findViewById(R.id.obfuscated_res_0x7f090945);
            this.w = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090944);
            this.x = (EMTextView) this.a.findViewById(R.id.obfuscated_res_0x7f090947);
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
            t2();
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048603, this, view2, str, z) == null) {
            super.showNetRefreshView(view2, str, z);
            this.mRefreshView.e(R.color.CAM_X0201);
            this.b.setVisibility(8);
        }
    }

    public final void v2(List<ox6> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            this.o.removeAll(list);
            z2();
            this.n.c();
            if (this.o.size() == 0) {
                this.t = DownloadManageButton.DownloadManageType.NONE_TASK;
            } else {
                this.t = DownloadManageButton.DownloadManageType.NORMAL;
            }
            i iVar = this.s;
            if (iVar != null) {
                iVar.E(this.t);
            }
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            ArrayList arrayList = new ArrayList();
            if (ListUtils.getCount(this.o) == 0) {
                D2();
            } else {
                r2();
                arrayList.addAll(this.o);
                ox6 clone = ((ox6) arrayList.get(arrayList.size() - 1)).clone();
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
                    iVar.E(downloadManageType);
                }
            } else {
                this.t = DownloadManageButton.DownloadManageType.NONE_TASK;
            }
            this.o.addAll(arrayList);
            if (ListUtils.getCount(this.p) != 0) {
                ox6 ox6Var = new ox6();
                ox6Var.d = false;
                arrayList.add(ox6Var);
                arrayList.addAll(this.p);
                ox6 clone2 = ((ox6) arrayList.get(arrayList.size() - 1)).clone();
                clone2.d = false;
                arrayList.remove(arrayList.get(arrayList.size() - 1));
                arrayList.add(clone2);
            }
            this.c.setData(arrayList);
            this.c.post(new g(this));
        }
    }
}
