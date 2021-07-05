package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
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
import d.a.c.k.e.n;
import d.a.c.k.e.q;
import d.a.r0.r.f0.f;
import d.a.r0.r.q.b2;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.v.d.b.e.a f13900e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.v.d.b.c.a f13901f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.v.d.b.d.a f13902g;

    /* renamed from: h  reason: collision with root package name */
    public AlaSquareLiveModel f13903h;

    /* renamed from: i  reason: collision with root package name */
    public int f13904i;
    public boolean j;
    public int k;
    public AlaSquareRefreshManager l;
    public IAlaSquareTabController m;
    public f.g n;
    public BdListView.p o;
    public BdListView.o p;
    public AbsListView.OnScrollListener q;
    public AlaSquareLiveModel.b r;

    /* loaded from: classes5.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveFragment f13905e;

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
            this.f13905e = alaSquareLiveFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f13905e.f13903h == null) {
                return;
            }
            this.f13905e.f13903h.refresh();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveFragment f13906e;

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
            this.f13906e = alaSquareLiveFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13906e.f13903h == null) {
                return;
            }
            this.f13906e.f13903h.loadMore();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveFragment f13907a;

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
            this.f13907a = alaSquareLiveFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
                MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
                this.f13907a.refreshCurrentPage();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveFragment f13908e;

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
            this.f13908e = alaSquareLiveFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                if (this.f13908e.f13904i != i2) {
                    if (i2 == 1) {
                        if (this.f13908e.f13902g != null) {
                            this.f13908e.f13902g.b();
                            if (this.f13908e.f13902g.c() != null) {
                                d.a.s0.v.d.b.b.c c2 = this.f13908e.f13902g.c();
                                StatisticItem statisticItem = new StatisticItem("c12644");
                                int i5 = c2.f67459b;
                                if (i5 == 0) {
                                    statisticItem.param("obj_type", 1);
                                } else if (i5 == 1) {
                                    statisticItem.param("obj_type", 2);
                                }
                                statisticItem.param("tid", c2.f67458a.n1());
                                TiebaStatic.log(statisticItem);
                            }
                        }
                    } else if (i2 != 2) {
                        if (i2 > 1 && this.f13908e.f13902g != null) {
                            this.f13908e.f13902g.j();
                        }
                    } else {
                        d.a.s0.v.d.d.a.c().b("c12647");
                        if (this.f13908e.f13902g != null) {
                            this.f13908e.f13902g.j();
                        }
                    }
                }
                this.f13908e.f13904i = i2;
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 0) {
                d.a.s0.v.d.d.a.c().g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements AlaSquareLiveModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaSquareLiveFragment f13909a;

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
            this.f13909a = alaSquareLiveFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.b
        public void a(boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.f13909a.getPageContext() == null || this.f13909a.f13900e == null) {
                return;
            }
            List<n> L = z2 ? null : this.f13909a.f13903h.L();
            if (z2 && ListUtils.getCount(L) == 0) {
                return;
            }
            if (z3) {
                this.f13909a.f13900e.j(L, z, this.f13909a.f13903h.O());
            } else {
                AlaSquareLiveFragment alaSquareLiveFragment = this.f13909a;
                alaSquareLiveFragment.hideLoadingView(alaSquareLiveFragment.f13900e.e());
                this.f13909a.f13900e.d();
                this.f13909a.R0(z2);
                this.f13909a.f13900e.j(L, z, this.f13909a.f13903h.O());
            }
            if (ListUtils.getCount(L) == 0) {
                AlaSquareLiveFragment alaSquareLiveFragment2 = this.f13909a;
                alaSquareLiveFragment2.showNetRefreshView(alaSquareLiveFragment2.f13900e.e(), this.f13909a.getString(R.string.no_data_text), false);
                return;
            }
            AlaSquareLiveFragment alaSquareLiveFragment3 = this.f13909a;
            alaSquareLiveFragment3.hideNetRefreshView(alaSquareLiveFragment3.f13900e.e());
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (this.f13909a.f13900e != null) {
                    AlaSquareLiveFragment alaSquareLiveFragment = this.f13909a;
                    alaSquareLiveFragment.hideLoadingView(alaSquareLiveFragment.f13900e.e());
                    this.f13909a.f13900e.d();
                }
                if (ListUtils.getCount(this.f13909a.f13903h.L()) > 0 && this.f13909a.f13900e != null) {
                    this.f13909a.showToast(str);
                    return;
                }
                AlaSquareLiveFragment alaSquareLiveFragment2 = this.f13909a;
                alaSquareLiveFragment2.showNetRefreshView(alaSquareLiveFragment2.f13900e.e(), str, false);
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
        this.f13900e = null;
        this.f13903h = null;
        this.f13904i = -1;
        this.k = 0;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
        this.q = new d(this);
        this.r = new e(this);
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    public void G0() {
        d.a.s0.v.d.b.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hideNetRefreshView(this.f13900e.e());
            if (ListUtils.getCount(this.f13903h.L()) == 0 && (aVar = this.f13900e) != null) {
                showLoadingView(aVar.e());
            }
            this.f13903h.refresh();
        }
    }

    public final void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (T0(this.f13903h.M())) {
                this.f13901f.h().setVisibility(0);
                this.f13901f.f(this.f13903h.M());
                return;
            }
            d.a.s0.v.d.b.c.a aVar = this.f13901f;
            if (aVar == null || aVar.h() == null) {
                return;
            }
            this.f13900e.f().removeHeaderView(this.f13901f.h());
            this.f13901f.h().setVisibility(8);
        }
    }

    public final void R0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || getPageContext() == null) {
            return;
        }
        if (this.f13902g == null) {
            d.a.s0.v.d.b.d.a aVar = new d.a.s0.v.d.b.d.a(getPageContext());
            this.f13902g = aVar;
            aVar.d().setVisibility(8);
        }
        this.f13900e.f().removeHeaderView(this.f13902g.d());
        this.f13900e.f().x(this.f13902g.d(), 1);
        if (this.f13901f == null) {
            d.a.s0.v.d.b.c.a aVar2 = new d.a.s0.v.d.b.c.a(getPageContext());
            this.f13901f = aVar2;
            aVar2.h().setVisibility(8);
        }
        this.f13900e.f().removeHeaderView(this.f13901f.h());
        this.f13900e.f().x(this.f13901f.h(), 2);
        S0(z);
        Q0(z);
    }

    public final void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            HeadLiveInfo N = this.f13903h.N();
            if (N != null && !ListUtils.isEmpty(N.head_live)) {
                ThreadInfo threadInfo = N.head_live.get(0);
                AlaLiveInfo alaLiveInfo = threadInfo.ala_info;
                if (alaLiveInfo != null && alaLiveInfo.live_status.intValue() == 1) {
                    this.f13902g.d().setVisibility(0);
                    d.a.s0.v.d.b.b.c cVar = new d.a.s0.v.d.b.b.c();
                    b2 b2Var = new b2();
                    b2Var.I2(threadInfo);
                    cVar.f67458a = b2Var;
                    cVar.f67459b = N.is_set.intValue();
                    this.f13902g.f(cVar);
                    this.f13902g.b();
                    return;
                }
                d.a.s0.v.d.b.d.a aVar = this.f13902g;
                if (aVar == null || aVar.d() == null) {
                    return;
                }
                this.f13900e.f().removeHeaderView(this.f13902g.d());
                this.f13902g.d().setVisibility(8);
                return;
            }
            d.a.s0.v.d.b.d.a aVar2 = this.f13902g;
            if (aVar2 == null || aVar2.d() == null) {
                return;
            }
            this.f13900e.f().removeHeaderView(this.f13902g.d());
            this.f13902g.d().setVisibility(8);
        }
    }

    public final boolean T0(List<FunctionListInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
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

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AlaSquareLiveModel alaSquareLiveModel = this.f13903h;
            if (alaSquareLiveModel != null) {
                return alaSquareLiveModel.K();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.a.r0.k0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a035" : (String) invokeV.objValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? isAdded() && isPrimary() : invokeI.booleanValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i2) {
        AlaSquareRefreshManager alaSquareRefreshManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (alaSquareRefreshManager = this.l) == null) {
            return;
        }
        alaSquareRefreshManager.reset(i2);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.s0.v.d.b.e.a aVar = this.f13900e;
            if (aVar != null) {
                aVar.i(i2);
            }
            d.a.s0.v.d.b.c.a aVar2 = this.f13901f;
            if (aVar2 != null) {
                aVar2.l(i2);
            }
            d.a.s0.v.d.b.d.a aVar3 = this.f13902g;
            if (aVar3 != null) {
                aVar3.g();
            }
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            this.f13903h = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.r);
            AlaSquareRefreshManager alaSquareRefreshManager = new AlaSquareRefreshManager();
            this.l = alaSquareRefreshManager;
            alaSquareRefreshManager.init(this, new long[]{30000});
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.k == 0) {
                this.k = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
            }
            d.a.s0.v.d.b.e.a aVar = new d.a.s0.v.d.b.e.a(getPageContext(), getUniqueId(), this.k);
            this.f13900e = aVar;
            aVar.k(this.n);
            this.f13900e.n(this.o);
            this.f13900e.m(this.p, 2000);
            this.f13900e.l(this.q);
            TiebaStatic.log("c12654");
            return this.f13900e.g();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            AlaSquareRefreshManager alaSquareRefreshManager = this.l;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onDestory();
            }
            d.a.s0.v.d.b.c.a aVar = this.f13901f;
            if (aVar != null) {
                aVar.m();
            }
            d.a.s0.v.d.b.d.a aVar2 = this.f13902g;
            if (aVar2 != null) {
                aVar2.h();
            }
            AlaSquareLiveModel alaSquareLiveModel = this.f13903h;
            if (alaSquareLiveModel != null) {
                alaSquareLiveModel.onDestroy();
            }
            this.m = null;
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.s0.v.d.b.e.a aVar = this.f13900e;
            if (aVar != null && aVar.f() != null) {
                return this.f13900e.f().getPreLoadHandle();
            }
            return super.onGetPreLoadListView();
        }
        return (q) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onNetRefreshButtonClicked();
            MessageManager.getInstance().sendMessage(new CustomMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_FRAGMENT_NET_BTN_CLICKED));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
            AlaSquareRefreshManager alaSquareRefreshManager = this.l;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onPause();
            }
            d.a.s0.v.d.b.d.a aVar = this.f13902g;
            if (aVar != null) {
                aVar.e(true);
                this.f13902g.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                AlaSquareLiveModel alaSquareLiveModel = this.f13903h;
                if (alaSquareLiveModel != null && ListUtils.isEmpty(alaSquareLiveModel.L()) && !this.f13903h.R()) {
                    G0();
                }
                AlaSquareRefreshManager alaSquareRefreshManager = this.l;
                if (alaSquareRefreshManager != null) {
                    alaSquareRefreshManager.onPageForeground(0);
                }
                d.a.s0.v.d.b.d.a aVar = this.f13902g;
                if (aVar != null) {
                    aVar.e(false);
                    this.f13902g.b();
                    return;
                }
                return;
            }
            d.a.s0.v.d.d.a.c().h(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            if (this.j || (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) == null || runTask.getData() == null) {
                return;
            }
            IAlaSquareTabController iAlaSquareTabController = (IAlaSquareTabController) runTask.getData();
            this.m = iAlaSquareTabController;
            this.f13900e.o(iAlaSquareTabController);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public void processCloseLives(List<Long> list) {
        AlaSquareLiveModel alaSquareLiveModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, list) == null) || ListUtils.isEmpty(list) || (alaSquareLiveModel = this.f13903h) == null || ListUtils.isEmpty(alaSquareLiveModel.L())) {
            return;
        }
        this.f13903h.Q(list);
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            refreshCurrentPage();
        }
    }

    public AlaSquareLiveFragment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13900e = null;
        this.f13903h = null;
        this.f13904i = -1;
        this.k = 0;
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
        this.q = new d(this);
        this.r = new e(this);
        this.j = z;
    }
}
