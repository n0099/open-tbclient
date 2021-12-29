package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.d.n.e.q;
import c.a.s0.s.i0.f;
import c.a.s0.s.q.d2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment;
import com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes12.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.t0.a0.f.b.e.a f43403e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.t0.a0.f.b.c.a f43404f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.a0.f.b.d.a f43405g;

    /* renamed from: h  reason: collision with root package name */
    public AlaSquareLiveModel f43406h;

    /* renamed from: i  reason: collision with root package name */
    public int f43407i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f43408j;

    /* renamed from: k  reason: collision with root package name */
    public int f43409k;
    public AlaSquareTabInfo l;
    public AlaSquareRefreshManager m;
    public IAlaSquareTabController n;
    public f.g o;
    public BdListView.p p;
    public BdListView.o q;
    public AbsListView.OnScrollListener r;
    public AlaSquareLiveModel.b s;

    /* loaded from: classes12.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveFragment f43410e;

        public a(AlaSquareLiveFragment alaSquareLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43410e = alaSquareLiveFragment;
        }

        @Override // c.a.s0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f43410e.f43406h == null) {
                return;
            }
            this.f43410e.f43406h.refresh();
        }
    }

    /* loaded from: classes12.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveFragment f43411e;

        public b(AlaSquareLiveFragment alaSquareLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43411e = alaSquareLiveFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f43411e.f43406h == null) {
                return;
            }
            this.f43411e.f43406h.loadMore();
        }
    }

    /* loaded from: classes12.dex */
    public class c implements BdListView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSquareLiveFragment a;

        public c(AlaSquareLiveFragment alaSquareLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSquareLiveFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
                MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
                this.a.refreshCurrentPage();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveFragment f43412e;

        public d(AlaSquareLiveFragment alaSquareLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43412e = alaSquareLiveFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                if (this.f43412e.f43407i != i2) {
                    if (i2 == 1) {
                        if (this.f43412e.f43405g != null) {
                            this.f43412e.f43405g.b();
                            if (this.f43412e.f43405g.c() != null) {
                                c.a.t0.a0.f.b.b.c c2 = this.f43412e.f43405g.c();
                                StatisticItem statisticItem = new StatisticItem("c12644");
                                int i5 = c2.f14723b;
                                if (i5 == 0) {
                                    statisticItem.param("obj_type", 1);
                                } else if (i5 == 1) {
                                    statisticItem.param("obj_type", 2);
                                }
                                statisticItem.param("tid", c2.a.v1());
                                TiebaStatic.log(statisticItem);
                            }
                        }
                    } else if (i2 != 2) {
                        if (i2 > 1 && this.f43412e.f43405g != null) {
                            this.f43412e.f43405g.j();
                        }
                    } else {
                        c.a.t0.a0.f.e.a.c().b("c12647");
                        if (this.f43412e.f43405g != null) {
                            this.f43412e.f43405g.j();
                        }
                    }
                }
                this.f43412e.f43407i = i2;
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 0) {
                c.a.t0.a0.f.e.a.c().g();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements AlaSquareLiveModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSquareLiveFragment a;

        public e(AlaSquareLiveFragment alaSquareLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSquareLiveFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.b
        public void a(boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.a.getPageContext() == null || this.a.f43403e == null) {
                return;
            }
            List<n> L = z2 ? null : this.a.f43406h.L();
            if (z2 && ListUtils.getCount(L) == 0) {
                return;
            }
            if (z3) {
                this.a.f43403e.j(L, z, this.a.f43406h.O());
            } else {
                AlaSquareLiveFragment alaSquareLiveFragment = this.a;
                alaSquareLiveFragment.hideLoadingView(alaSquareLiveFragment.f43403e.e());
                this.a.f43403e.d();
                this.a.p(z2);
                this.a.f43403e.j(L, z, this.a.f43406h.O());
            }
            if (ListUtils.getCount(L) == 0) {
                AlaSquareLiveFragment alaSquareLiveFragment2 = this.a;
                alaSquareLiveFragment2.showNetRefreshView(alaSquareLiveFragment2.f43403e.e(), this.a.getString(R.string.no_data_text), false);
                return;
            }
            AlaSquareLiveFragment alaSquareLiveFragment3 = this.a;
            alaSquareLiveFragment3.hideNetRefreshView(alaSquareLiveFragment3.f43403e.e());
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (this.a.f43403e != null) {
                    AlaSquareLiveFragment alaSquareLiveFragment = this.a;
                    alaSquareLiveFragment.hideLoadingView(alaSquareLiveFragment.f43403e.e());
                    this.a.f43403e.d();
                }
                if (ListUtils.getCount(this.a.f43406h.L()) > 0 && this.a.f43403e != null) {
                    this.a.showToast(str);
                    return;
                }
                AlaSquareLiveFragment alaSquareLiveFragment2 = this.a;
                alaSquareLiveFragment2.showNetRefreshView(alaSquareLiveFragment2.f43403e.e(), str, false);
            }
        }
    }

    public AlaSquareLiveFragment() {
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
        this.f43403e = null;
        this.f43406h = null;
        this.f43407i = -1;
        this.f43409k = 0;
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    public void enterBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AlaSquareRefreshManager alaSquareRefreshManager = this.m;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onPause();
            }
            c.a.t0.a0.f.b.d.a aVar = this.f43405g;
            if (aVar != null) {
                aVar.e(true);
                this.f43405g.j();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    public void enterForeground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            AlaSquareRefreshManager alaSquareRefreshManager = this.m;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onPageForeground(0);
            }
            c.a.t0.a0.f.b.d.a aVar = this.f43405g;
            if (aVar != null) {
                aVar.e(false);
                this.f43405g.b();
            }
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AlaSquareLiveModel alaSquareLiveModel = this.f43406h;
            if (alaSquareLiveModel != null) {
                return alaSquareLiveModel.K();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a035" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    public AlaSquareTabInfo getTabInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l : (AlaSquareTabInfo) invokeV.objValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? isAdded() && isPrimary() : invokeI.booleanValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i2) {
        AlaSquareRefreshManager alaSquareRefreshManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (alaSquareRefreshManager = this.m) == null) {
            return;
        }
        alaSquareRefreshManager.reset(i2);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (r(this.f43406h.M())) {
                this.f43404f.h().setVisibility(0);
                this.f43404f.f(this.f43406h.M());
                return;
            }
            c.a.t0.a0.f.b.c.a aVar = this.f43404f;
            if (aVar == null || aVar.h() == null) {
                return;
            }
            this.f43403e.f().removeHeaderView(this.f43404f.h());
            this.f43404f.h().setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.t0.a0.f.b.e.a aVar = this.f43403e;
            if (aVar != null) {
                aVar.i(i2);
            }
            c.a.t0.a0.f.b.c.a aVar2 = this.f43404f;
            if (aVar2 != null) {
                aVar2.l(i2);
            }
            c.a.t0.a0.f.b.d.a aVar3 = this.f43405g;
            if (aVar3 != null) {
                aVar3.g();
            }
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            this.f43406h = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.s);
            AlaSquareRefreshManager alaSquareRefreshManager = new AlaSquareRefreshManager();
            this.m = alaSquareRefreshManager;
            alaSquareRefreshManager.init(this, new long[]{30000});
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f43409k == 0) {
                this.f43409k = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
            }
            c.a.t0.a0.f.b.e.a aVar = new c.a.t0.a0.f.b.e.a(getPageContext(), getUniqueId(), this.f43409k);
            this.f43403e = aVar;
            aVar.k(this.o);
            this.f43403e.n(this.p);
            this.f43403e.m(this.q, 2000);
            this.f43403e.l(this.r);
            TiebaStatic.log("c12654");
            return this.f43403e.g();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            AlaSquareRefreshManager alaSquareRefreshManager = this.m;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onDestory();
            }
            c.a.t0.a0.f.b.c.a aVar = this.f43404f;
            if (aVar != null) {
                aVar.m();
            }
            c.a.t0.a0.f.b.d.a aVar2 = this.f43405g;
            if (aVar2 != null) {
                aVar2.h();
            }
            AlaSquareLiveModel alaSquareLiveModel = this.f43406h;
            if (alaSquareLiveModel != null) {
                alaSquareLiveModel.onDestroy();
            }
            this.n = null;
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.t0.a0.f.b.e.a aVar = this.f43403e;
            if (aVar != null && aVar.f() != null) {
                return this.f43403e.f().getPreLoadHandle();
            }
            return super.onGetPreLoadListView();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onNetRefreshButtonClicked();
            MessageManager.getInstance().sendMessage(new CustomMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_FRAGMENT_NET_BTN_CLICKED));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            AlaSquareRefreshManager alaSquareRefreshManager = this.m;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onPause();
            }
            c.a.t0.a0.f.b.d.a aVar = this.f43405g;
            if (aVar != null) {
                aVar.e(true);
                this.f43405g.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                AlaSquareLiveModel alaSquareLiveModel = this.f43406h;
                if (alaSquareLiveModel != null && ListUtils.isEmpty(alaSquareLiveModel.L()) && !this.f43406h.Q()) {
                    refreshWholePage();
                }
                AlaSquareRefreshManager alaSquareRefreshManager = this.m;
                if (alaSquareRefreshManager != null) {
                    alaSquareRefreshManager.onPageForeground(0);
                }
                c.a.t0.a0.f.b.d.a aVar = this.f43405g;
                if (aVar != null) {
                    aVar.e(false);
                    this.f43405g.b();
                    return;
                }
                return;
            }
            c.a.t0.a0.f.e.a.c().h(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            if (this.f43408j || (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) == null || runTask.getData() == null) {
                return;
            }
            IAlaSquareTabController iAlaSquareTabController = (IAlaSquareTabController) runTask.getData();
            this.n = iAlaSquareTabController;
            this.f43403e.o(iAlaSquareTabController);
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || getPageContext() == null) {
            return;
        }
        if (this.f43405g == null) {
            c.a.t0.a0.f.b.d.a aVar = new c.a.t0.a0.f.b.d.a(getPageContext());
            this.f43405g = aVar;
            aVar.d().setVisibility(8);
        }
        this.f43403e.f().removeHeaderView(this.f43405g.d());
        this.f43403e.f().addHeaderView(this.f43405g.d(), 1);
        if (this.f43404f == null) {
            c.a.t0.a0.f.b.c.a aVar2 = new c.a.t0.a0.f.b.c.a(getPageContext());
            this.f43404f = aVar2;
            aVar2.h().setVisibility(8);
        }
        this.f43403e.f().removeHeaderView(this.f43404f.h());
        this.f43403e.f().addHeaderView(this.f43404f.h(), 2);
        q(z);
        o(z);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public void processCloseLives(List<Long> list) {
        AlaSquareLiveModel alaSquareLiveModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, list) == null) || ListUtils.isEmpty(list) || (alaSquareLiveModel = this.f43406h) == null || ListUtils.isEmpty(alaSquareLiveModel.L())) {
            return;
        }
        this.f43406h.P(list);
    }

    public final void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            HeadLiveInfo N = this.f43406h.N();
            if (N != null && !ListUtils.isEmpty(N.head_live)) {
                ThreadInfo threadInfo = N.head_live.get(0);
                AlaLiveInfo alaLiveInfo = threadInfo.ala_info;
                if (alaLiveInfo != null && alaLiveInfo.live_status.intValue() == 1) {
                    this.f43405g.d().setVisibility(0);
                    c.a.t0.a0.f.b.b.c cVar = new c.a.t0.a0.f.b.b.c();
                    d2 d2Var = new d2();
                    d2Var.c3(threadInfo);
                    cVar.a = d2Var;
                    cVar.f14723b = N.is_set.intValue();
                    this.f43405g.f(cVar);
                    this.f43405g.b();
                    return;
                }
                c.a.t0.a0.f.b.d.a aVar = this.f43405g;
                if (aVar == null || aVar.d() == null) {
                    return;
                }
                this.f43403e.f().removeHeaderView(this.f43405g.d());
                this.f43405g.d().setVisibility(8);
                return;
            }
            c.a.t0.a0.f.b.d.a aVar2 = this.f43405g;
            if (aVar2 == null || aVar2.d() == null) {
                return;
            }
            this.f43403e.f().removeHeaderView(this.f43405g.d());
            this.f43405g.d().setVisibility(8);
        }
    }

    public final boolean r(List<FunctionListInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, list)) == null) {
            if (!ListUtils.isEmpty(list) && ListUtils.getCount(list) >= 2 && ListUtils.getCount(list) <= 3) {
                int i2 = 0;
                for (FunctionListInfo functionListInfo : list) {
                    if (((1 == functionListInfo.id.intValue() || 3 == functionListInfo.id.intValue()) && !TextUtils.isEmpty(functionListInfo.url)) || 2 == functionListInfo.id.intValue()) {
                        i2++;
                    }
                }
                return i2 >= 2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    public void refreshWholePage() {
        c.a.t0.a0.f.b.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            hideNetRefreshView(this.f43403e.e());
            if (ListUtils.getCount(this.f43406h.L()) == 0 && (aVar = this.f43403e) != null) {
                showLoadingView(aVar.e());
            }
            this.f43406h.refresh();
        }
    }

    public void setPaddingTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.f43409k = i2;
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            refreshCurrentPage();
        }
    }

    public AlaSquareLiveFragment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f43403e = null;
        this.f43406h = null;
        this.f43407i = -1;
        this.f43409k = 0;
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        this.f43408j = z;
    }

    public AlaSquareLiveFragment(AlaSquareTabInfo alaSquareTabInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {alaSquareTabInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43403e = null;
        this.f43406h = null;
        this.f43407i = -1;
        this.f43409k = 0;
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
        this.l = alaSquareTabInfo;
    }
}
