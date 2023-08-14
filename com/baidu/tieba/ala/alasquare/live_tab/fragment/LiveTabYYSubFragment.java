package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel;
import com.baidu.tieba.i95;
import com.baidu.tieba.j95;
import com.baidu.tieba.j96;
import com.baidu.tieba.om5;
import com.baidu.tieba.ym;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class LiveTabYYSubFragment extends LiveTabBaseSubFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View k;
    public BdSwipeRefreshLayout l;
    public BdTypeRecyclerView m;
    public j96 n;
    public j95 o;
    public PbListView p;
    public AlaLiveYYSubTabModel q;
    public int r;
    public int s;
    public AlaLiveYYSubTabModel.c t;
    public i95.g u;
    public BdListView.p v;
    public RecyclerView.OnScrollListener w;

    /* loaded from: classes5.dex */
    public class a implements AlaLiveYYSubTabModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public a(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.c
        public void a(boolean z, List<ym> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.hideLoadingView();
                this.a.X1();
                if (z) {
                    this.a.d2();
                } else {
                    this.a.g2();
                }
                this.a.h2();
                this.a.a2(list);
                if (ListUtils.isEmpty(list)) {
                    this.a.L1();
                } else {
                    this.a.I1();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.c
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.h2();
                this.a.hideLoadingView();
                this.a.X1();
                if (z) {
                    this.a.showToast(R.string.data_load_error);
                } else if (!this.a.q.d()) {
                    this.a.f2();
                } else {
                    this.a.showToast(R.string.data_load_error);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements i95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public b(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // com.baidu.tieba.i95.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.q.refresh();
                } else {
                    this.a.h2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public c(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!BdUtilHelper.isNetOk()) {
                    this.a.W1();
                } else {
                    this.a.q.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public d(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 >= this.a.s) {
                    LiveTabYYSubFragment liveTabYYSubFragment = this.a;
                    if (!liveTabYYSubFragment.e) {
                        liveTabYYSubFragment.J1();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabYYSubFragment a;

        public e(LiveTabYYSubFragment liveTabYYSubFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabYYSubFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveTabYYSubFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.b();
            }
        }
    }

    public LiveTabYYSubFragment() {
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
        this.r = 0;
        this.s = 4;
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
        this.w = new d(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.m;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.w);
                this.m.setOnSrollToBottomListener(null);
            }
            j95 j95Var = this.o;
            if (j95Var != null) {
                j95Var.a(null);
                this.o.T();
            }
            AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.q;
            if (alaLiveYYSubTabModel != null) {
                alaLiveYYSubTabModel.onDestroy();
            }
        }
    }

    public final void a2(List<ym> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.n.c(list);
        }
    }

    public final void b2(i95.g gVar) {
        j95 j95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) && (j95Var = this.o) != null) {
            j95Var.a(gVar);
        }
    }

    public final void c2(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, pVar) == null) && (bdTypeRecyclerView = this.m) != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public static LiveTabYYSubFragment Z1(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            Bundle bundle = new Bundle();
            LiveTabYYSubFragment liveTabYYSubFragment = new LiveTabYYSubFragment();
            bundle.putBoolean("arg_after_lazy_loaded", z);
            bundle.putInt("arg_tab_id", i);
            bundle.putInt("arg_obj_locate", i2);
            liveTabYYSubFragment.setArguments(bundle);
            return liveTabYYSubFragment;
        }
        return (LiveTabYYSubFragment) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.k == null) {
                this.k = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d05e3, (ViewGroup) null);
                Y1();
                if (viewGroup != null) {
                    this.r = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - BdUtilHelper.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                }
            }
            if (this.d) {
                b();
            }
            return this.k;
        }
        return (View) invokeLLL.objValue;
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.m.setNextPage(null);
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.setVisibility(8);
            om5 om5Var = this.mRefreshView;
            if (om5Var != null) {
                om5Var.dettachView(this.b);
                this.mRefreshView = null;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.q != null) {
            X1();
            e2();
            this.q.refresh();
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b.setVisibility(0);
            super.showLoadingView(this.b, false, this.r);
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.setRefreshing(false);
        }
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.setVisibility(8);
            super.hideLoadingView(this.b);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onLazyLoad();
            this.d = true;
            b();
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l = (BdSwipeRefreshLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0915cf);
            this.b = (LinearLayout) this.k.findViewById(R.id.top_container);
            j95 j95Var = new j95(getPageContext());
            this.o = j95Var;
            this.l.setProgressView(j95Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.k.findViewById(R.id.obfuscated_res_0x7f0915cc);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
            this.m.setFadingEdgeLength(0);
            this.m.setOverScrollMode(2);
            this.n = new j96(getPageContext(), this.m, this.f, this.i, this.g);
            PbListView pbListView = new PbListView(this.a);
            this.p = pbListView;
            pbListView.a();
            this.p.s(R.color.transparent);
            this.p.w(BdUtilHelper.getDimens(this.a, R.dimen.tbds182));
            this.p.B();
            this.p.L(R.dimen.tbfontsize33);
            this.p.J(SkinManager.getColor(R.color.CAM_X0107));
            this.p.F(R.color.CAM_X0110);
            this.p.c().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.o.V(getPageContext().getUniqueId());
            this.m.addOnScrollListener(this.w);
            b2(this.u);
            c2(this.v);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void d2() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (pbListView = this.p) != null) {
            if (pbListView.c().getParent() == null) {
                this.m.setNextPage(this.p);
            }
            this.p.w(BdUtilHelper.getDimens(this.a, R.dimen.tbds182));
            this.p.H(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0be4));
            this.p.U();
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setVisibility(0);
            if (this.mRefreshView == null) {
                this.mRefreshView = new om5(getContext(), new e(this));
            }
            this.mRefreshView.o();
            this.mRefreshView.l(null);
            this.mRefreshView.m(getResources().getString(R.string.refresh_view_title_text));
            this.mRefreshView.h(R.drawable.new_pic_emotion_08);
            this.mRefreshView.k(0);
            this.mRefreshView.onChangeSkinType();
            this.mRefreshView.attachView(this.b, false);
        }
    }

    public final void g2() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (pbListView = this.p) != null) {
            if (pbListView.c().getParent() == null) {
                this.m.setNextPage(this.p);
            }
            this.p.w(BdUtilHelper.getDimens(this.a, R.dimen.tbds182));
            this.p.H(this.a.getResources().getString(R.string.list_no_more));
            this.p.g();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            j95 j95Var = this.o;
            if (j95Var != null) {
                j95Var.C(i);
            }
            PbListView pbListView = this.p;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.p.e(i);
            }
            j96 j96Var = this.n;
            if (j96Var != null) {
                j96Var.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            this.a = getPageContext().getPageActivity();
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.d = arguments.getBoolean("arg_after_lazy_loaded", false);
                this.f = arguments.getInt("arg_tab_id", 0);
                this.i = arguments.getInt("arg_obj_locate", 0);
            }
            if (this.q == null) {
                this.q = new AlaLiveYYSubTabModel(getPageContext(), this.t, this.f, this.i);
            }
            this.q.init();
            this.q.setForumInfo(this.g, this.h);
            registerListener(this.j);
        }
    }
}
