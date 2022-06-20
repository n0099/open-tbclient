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
import com.baidu.tbadk.core.data.ThreadData;
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
import com.repackage.nn;
import com.repackage.ot4;
import com.repackage.rn;
import com.repackage.sn5;
import com.repackage.tn5;
import com.repackage.un5;
import com.repackage.wn5;
import com.repackage.yp5;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wn5 a;
    public tn5 b;
    public un5 c;
    public AlaSquareLiveModel d;
    public int e;
    public boolean f;
    public int g;
    public AlaSquareRefreshManager h;
    public IAlaSquareTabController i;
    public ot4.g j;
    public BdListView.p k;
    public BdListView.o l;
    public AbsListView.OnScrollListener m;
    public AlaSquareLiveModel.b n;

    /* loaded from: classes3.dex */
    public class a implements ot4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSquareLiveFragment a;

        public a(AlaSquareLiveFragment alaSquareLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSquareLiveFragment;
        }

        @Override // com.repackage.ot4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.d == null) {
                return;
            }
            this.a.d.refresh();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSquareLiveFragment a;

        public b(AlaSquareLiveFragment alaSquareLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSquareLiveFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.d == null) {
                return;
            }
            this.a.d.b();
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSquareLiveFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
                MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
                this.a.refreshCurrentPage();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaSquareLiveFragment a;

        public d(AlaSquareLiveFragment alaSquareLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaSquareLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaSquareLiveFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                if (this.a.e != i) {
                    if (i == 1) {
                        if (this.a.c != null) {
                            this.a.c.b();
                            if (this.a.c.c() != null) {
                                sn5 c = this.a.c.c();
                                StatisticItem statisticItem = new StatisticItem("c12644");
                                int i4 = c.b;
                                if (i4 == 0) {
                                    statisticItem.param("obj_type", 1);
                                } else if (i4 == 1) {
                                    statisticItem.param("obj_type", 2);
                                }
                                statisticItem.param("tid", c.a.getTid());
                                TiebaStatic.log(statisticItem);
                            }
                        }
                    } else if (i != 2) {
                        if (i > 1 && this.a.c != null) {
                            this.a.c.j();
                        }
                    } else {
                        yp5.c().b("c12647");
                        if (this.a.c != null) {
                            this.a.c.j();
                        }
                    }
                }
                this.a.e = i;
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 0) {
                yp5.c().g();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || this.a.getPageContext() == null || this.a.a == null) {
                return;
            }
            List<nn> O = z2 ? null : this.a.d.O();
            if (z2 && ListUtils.getCount(O) == 0) {
                return;
            }
            if (z3) {
                this.a.a.j(O, z, this.a.d.R());
            } else {
                AlaSquareLiveFragment alaSquareLiveFragment = this.a;
                alaSquareLiveFragment.hideLoadingView(alaSquareLiveFragment.a.e());
                this.a.a.d();
                this.a.D1(z2);
                this.a.a.j(O, z, this.a.d.R());
            }
            if (ListUtils.getCount(O) == 0) {
                AlaSquareLiveFragment alaSquareLiveFragment2 = this.a;
                alaSquareLiveFragment2.showNetRefreshView(alaSquareLiveFragment2.a.e(), this.a.getString(R.string.obfuscated_res_0x7f0f0c51), false);
                return;
            }
            AlaSquareLiveFragment alaSquareLiveFragment3 = this.a;
            alaSquareLiveFragment3.hideNetRefreshView(alaSquareLiveFragment3.a.e());
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.b
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (this.a.a != null) {
                    AlaSquareLiveFragment alaSquareLiveFragment = this.a;
                    alaSquareLiveFragment.hideLoadingView(alaSquareLiveFragment.a.e());
                    this.a.a.d();
                }
                if (ListUtils.getCount(this.a.d.O()) > 0 && this.a.a != null) {
                    this.a.showToast(str);
                    return;
                }
                AlaSquareLiveFragment alaSquareLiveFragment2 = this.a;
                alaSquareLiveFragment2.showNetRefreshView(alaSquareLiveFragment2.a.e(), str, false);
            }
        }
    }

    public AlaSquareLiveFragment() {
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
        this.a = null;
        this.d = null;
        this.e = -1;
        this.g = 0;
        this.j = new a(this);
        this.k = new b(this);
        this.l = new c(this);
        this.m = new d(this);
        this.n = new e(this);
    }

    public final void C1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (F1(this.d.P())) {
                this.b.h().setVisibility(0);
                this.b.f(this.d.P());
                return;
            }
            tn5 tn5Var = this.b;
            if (tn5Var == null || tn5Var.h() == null) {
                return;
            }
            this.a.f().removeHeaderView(this.b.h());
            this.b.h().setVisibility(8);
        }
    }

    public final void D1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || getPageContext() == null) {
            return;
        }
        if (this.c == null) {
            un5 un5Var = new un5(getPageContext());
            this.c = un5Var;
            un5Var.d().setVisibility(8);
        }
        this.a.f().removeHeaderView(this.c.d());
        this.a.f().x(this.c.d(), 1);
        if (this.b == null) {
            tn5 tn5Var = new tn5(getPageContext());
            this.b = tn5Var;
            tn5Var.h().setVisibility(8);
        }
        this.a.f().removeHeaderView(this.b.h());
        this.a.f().x(this.b.h(), 2);
        E1(z);
        C1(z);
    }

    public final void E1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            HeadLiveInfo Q = this.d.Q();
            if (Q != null && !ListUtils.isEmpty(Q.head_live)) {
                ThreadInfo threadInfo = Q.head_live.get(0);
                AlaLiveInfo alaLiveInfo = threadInfo.ala_info;
                if (alaLiveInfo != null && alaLiveInfo.live_status.intValue() == 1) {
                    this.c.d().setVisibility(0);
                    sn5 sn5Var = new sn5();
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    sn5Var.a = threadData;
                    sn5Var.b = Q.is_set.intValue();
                    this.c.f(sn5Var);
                    this.c.b();
                    return;
                }
                un5 un5Var = this.c;
                if (un5Var == null || un5Var.d() == null) {
                    return;
                }
                this.a.f().removeHeaderView(this.c.d());
                this.c.d().setVisibility(8);
                return;
            }
            un5 un5Var2 = this.c;
            if (un5Var2 == null || un5Var2.d() == null) {
                return;
            }
            this.a.f().removeHeaderView(this.c.d());
            this.c.d().setVisibility(8);
        }
    }

    public final boolean F1(List<FunctionListInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (!ListUtils.isEmpty(list) && ListUtils.getCount(list) >= 2 && ListUtils.getCount(list) <= 3) {
                int i = 0;
                for (FunctionListInfo functionListInfo : list) {
                    if (((1 == functionListInfo.id.intValue() || 3 == functionListInfo.id.intValue()) && !TextUtils.isEmpty(functionListInfo.url)) || 2 == functionListInfo.id.intValue()) {
                        i++;
                    }
                }
                return i >= 2;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AlaSquareLiveModel alaSquareLiveModel = this.d;
            if (alaSquareLiveModel != null) {
                return alaSquareLiveModel.N();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.t75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "a035" : (String) invokeV.objValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? isAdded() && isPrimary() : invokeI.booleanValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        AlaSquareRefreshManager alaSquareRefreshManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (alaSquareRefreshManager = this.h) == null) {
            return;
        }
        alaSquareRefreshManager.reset(i);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            wn5 wn5Var = this.a;
            if (wn5Var != null) {
                wn5Var.i(i);
            }
            tn5 tn5Var = this.b;
            if (tn5Var != null) {
                tn5Var.l(i);
            }
            un5 un5Var = this.c;
            if (un5Var != null) {
                un5Var.g();
            }
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            this.d = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.n);
            AlaSquareRefreshManager alaSquareRefreshManager = new AlaSquareRefreshManager();
            this.h = alaSquareRefreshManager;
            alaSquareRefreshManager.init(this, new long[]{30000});
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.g == 0) {
                this.g = (int) getPageContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f070275);
            }
            wn5 wn5Var = new wn5(getPageContext(), getUniqueId(), this.g);
            this.a = wn5Var;
            wn5Var.k(this.j);
            this.a.n(this.k);
            this.a.m(this.l, 2000);
            this.a.l(this.m);
            TiebaStatic.log("c12654");
            return this.a.g();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            AlaSquareRefreshManager alaSquareRefreshManager = this.h;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onDestory();
            }
            tn5 tn5Var = this.b;
            if (tn5Var != null) {
                tn5Var.m();
            }
            un5 un5Var = this.c;
            if (un5Var != null) {
                un5Var.h();
            }
            AlaSquareLiveModel alaSquareLiveModel = this.d;
            if (alaSquareLiveModel != null) {
                alaSquareLiveModel.onDestroy();
            }
            this.i = null;
            System.gc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public rn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            wn5 wn5Var = this.a;
            if (wn5Var != null && wn5Var.f() != null) {
                return this.a.f().getPreLoadHandle();
            }
            return super.onGetPreLoadListView();
        }
        return (rn) invokeV.objValue;
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
            AlaSquareRefreshManager alaSquareRefreshManager = this.h;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onPause();
            }
            un5 un5Var = this.c;
            if (un5Var != null) {
                un5Var.e(true);
                this.c.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                AlaSquareLiveModel alaSquareLiveModel = this.d;
                if (alaSquareLiveModel != null && ListUtils.isEmpty(alaSquareLiveModel.O()) && !this.d.T()) {
                    r1();
                }
                AlaSquareRefreshManager alaSquareRefreshManager = this.h;
                if (alaSquareRefreshManager != null) {
                    alaSquareRefreshManager.onPageForeground(0);
                }
                un5 un5Var = this.c;
                if (un5Var != null) {
                    un5Var.e(false);
                    this.c.b();
                    return;
                }
                return;
            }
            yp5.c().h(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            if (this.f || (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) == null || runTask.getData() == null) {
                return;
            }
            IAlaSquareTabController iAlaSquareTabController = (IAlaSquareTabController) runTask.getData();
            this.i = iAlaSquareTabController;
            this.a.o(iAlaSquareTabController);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public void processCloseLives(List<Long> list) {
        AlaSquareLiveModel alaSquareLiveModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || ListUtils.isEmpty(list) || (alaSquareLiveModel = this.d) == null || ListUtils.isEmpty(alaSquareLiveModel.O())) {
            return;
        }
        this.d.S(list);
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    public void r1() {
        wn5 wn5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            hideNetRefreshView(this.a.e());
            if (ListUtils.getCount(this.d.O()) == 0 && (wn5Var = this.a) != null) {
                showLoadingView(wn5Var.e());
            }
            this.d.refresh();
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.d = null;
        this.e = -1;
        this.g = 0;
        this.j = new a(this);
        this.k = new b(this);
        this.l = new c(this);
        this.m = new d(this);
        this.n = new e(this);
        this.f = z;
    }
}
