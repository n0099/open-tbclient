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
import com.baidu.tieba.gi5;
import com.baidu.tieba.l45;
import com.baidu.tieba.m45;
import com.baidu.tieba.w56;
import com.baidu.tieba.yh;
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
    public w56 n;
    public m45 o;
    public PbListView p;
    public AlaLiveYYSubTabModel q;
    public int r;
    public int s;
    public AlaLiveYYSubTabModel.c t;
    public l45.g u;
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
        public void a(boolean z, List<yh> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, list) == null) {
                this.a.hideLoadingView();
                this.a.r2();
                if (z) {
                    this.a.x2();
                } else {
                    this.a.A2();
                }
                this.a.B2();
                this.a.u2(list);
                if (ListUtils.isEmpty(list)) {
                    this.a.f2();
                } else {
                    this.a.c2();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live_tab.model.AlaLiveYYSubTabModel.c
        public void b(int i, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
                this.a.B2();
                this.a.hideLoadingView();
                this.a.r2();
                if (z) {
                    this.a.showToast(R.string.data_load_error);
                } else if (!this.a.q.c()) {
                    this.a.z2();
                } else {
                    this.a.showToast(R.string.data_load_error);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements l45.g {
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

        @Override // com.baidu.tieba.l45.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.q.refresh();
                } else {
                    this.a.B2();
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
                    this.a.q2();
                } else {
                    this.a.q.b();
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
                        liveTabYYSubFragment.d2();
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
                this.a.c();
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
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            BdTypeRecyclerView bdTypeRecyclerView = this.m;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeOnScrollListener(this.w);
                this.m.setOnSrollToBottomListener(null);
            }
            m45 m45Var = this.o;
            if (m45Var != null) {
                m45Var.a(null);
                this.o.U();
            }
            AlaLiveYYSubTabModel alaLiveYYSubTabModel = this.q;
            if (alaLiveYYSubTabModel != null) {
                alaLiveYYSubTabModel.onDestroy();
            }
        }
    }

    public final void u2(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.n.c(list);
        }
    }

    public final void v2(l45.g gVar) {
        m45 m45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, gVar) == null) && (m45Var = this.o) != null) {
            m45Var.a(gVar);
        }
    }

    public final void w2(BdListView.p pVar) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, pVar) == null) && (bdTypeRecyclerView = this.m) != null) {
            bdTypeRecyclerView.setOnSrollToBottomListener(pVar);
        }
    }

    public static LiveTabYYSubFragment t2(boolean z, int i, int i2) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.k == null) {
                this.k = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d05ee, (ViewGroup) null);
                s2();
                if (viewGroup != null) {
                    this.r = (((viewGroup.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - BdUtilHelper.getDimens(getContext(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2);
                }
            }
            if (this.d) {
                c();
            }
            return this.k;
        }
        return (View) invokeLLL.objValue;
    }

    public final void A2() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (pbListView = this.p) != null) {
            if (pbListView.c().getParent() == null) {
                this.m.setNextPage(this.p);
            }
            this.p.w(BdUtilHelper.getDimens(this.a, R.dimen.tbds182));
            this.p.H(this.a.getResources().getString(R.string.list_no_more));
            this.p.g();
        }
    }

    public final void x2() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (pbListView = this.p) != null) {
            if (pbListView.c().getParent() == null) {
                this.m.setNextPage(this.p);
            }
            this.p.w(BdUtilHelper.getDimens(this.a, R.dimen.tbds182));
            this.p.H(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c10));
            this.p.U();
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.b.setVisibility(0);
            if (this.mRefreshView == null) {
                this.mRefreshView = new gi5(getContext(), new e(this));
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

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.setRefreshing(false);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.q != null) {
            r2();
            y2();
            this.q.refresh();
        }
    }

    public final void hideLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setVisibility(8);
            super.hideLoadingView(this.b);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onLazyLoad();
            this.d = true;
            c();
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.m.setNextPage(null);
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setVisibility(8);
            gi5 gi5Var = this.mRefreshView;
            if (gi5Var != null) {
                gi5Var.dettachView(this.b);
                this.mRefreshView = null;
            }
        }
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.setVisibility(0);
            super.showLoadingView(this.b, false, this.r);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            m45 m45Var = this.o;
            if (m45Var != null) {
                m45Var.D(i);
            }
            PbListView pbListView = this.p;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0109));
                this.p.e(i);
            }
            w56 w56Var = this.n;
            if (w56Var != null) {
                w56Var.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
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

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = (BdSwipeRefreshLayout) this.k.findViewById(R.id.obfuscated_res_0x7f0915f2);
            this.b = (LinearLayout) this.k.findViewById(R.id.top_container);
            m45 m45Var = new m45(getPageContext());
            this.o = m45Var;
            this.l.setProgressView(m45Var);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.k.findViewById(R.id.obfuscated_res_0x7f0915ef);
            this.m = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
            this.m.setFadingEdgeLength(0);
            this.m.setOverScrollMode(2);
            this.n = new w56(getPageContext(), this.m, this.f, this.i, this.g);
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
            this.o.W(getPageContext().getUniqueId());
            this.m.addOnScrollListener(this.w);
            v2(this.u);
            w2(this.v);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
