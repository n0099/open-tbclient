package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.d2;
import b.a.r0.x0.q0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.refresh.AlaAutoRefreshFragment;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f47102e;

    /* renamed from: f  reason: collision with root package name */
    public String f47103f;

    /* renamed from: g  reason: collision with root package name */
    public String f47104g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47105h;

    /* renamed from: i  reason: collision with root package name */
    public AlaFrsLiveModel f47106i;
    public b.a.r0.w.g.c.c j;
    public int k;
    public boolean l;
    public boolean m;
    public AlaSquareRefreshManager n;
    public CustomMessageListener o;
    public int p;
    public AlaFrsLiveModel.b q;
    public b.a.r0.w.e r;
    public f.g s;
    public BdMultiColumnListView.OnScrollToBottomListener t;
    public b.a.r0.w.g.c.d u;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f47107a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaFrsLiveFragment alaFrsLiveFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47107a = alaFrsLiveFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsGameLive".equals(split[0]) && 9 == b.a.e.e.m.b.e(split[1], 0)) {
                this.f47107a.forceRefresh();
            } else if ("FrsGameLiveLive".equals(split[0]) && 2 == b.a.e.e.m.b.e(split[1], 0)) {
                this.f47107a.forceRefresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AlaFrsLiveModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f47108a;

        public b(AlaFrsLiveFragment alaFrsLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47108a = alaFrsLiveFragment;
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f47108a.getPageContext() == null || this.f47108a.j == null) {
                return;
            }
            AlaFrsLiveFragment alaFrsLiveFragment = this.f47108a;
            alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.j.k());
            this.f47108a.j.g();
            this.f47108a.j.w(this.f47108a.f47106i.getData(), z, this.f47108a.f47106i.K());
            this.f47108a.j.t(this.f47108a.f47106i.H());
            if (ListUtils.getCount(this.f47108a.f47106i.getData()) == 0) {
                if (this.f47108a.k == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001621));
                }
                this.f47108a.l = false;
                AlaFrsLiveFragment alaFrsLiveFragment2 = this.f47108a;
                alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.j.k(), this.f47108a.getPageContext().getString(R.string.frs_game_live_no_data), null, this.f47108a.getPageContext().getString(R.string.frs_game_live_more_data), false, this.f47108a.getNetRefreshListener());
                return;
            }
            AlaFrsLiveFragment alaFrsLiveFragment3 = this.f47108a;
            alaFrsLiveFragment3.hideNetRefreshView(alaFrsLiveFragment3.j.k());
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (this.f47108a.j != null) {
                    AlaFrsLiveFragment alaFrsLiveFragment = this.f47108a;
                    alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.j.k());
                    this.f47108a.j.g();
                }
                if (ListUtils.getCount(this.f47108a.f47106i.getData()) <= 0 || this.f47108a.j == null) {
                    this.f47108a.l = true;
                    if (this.f47108a.j != null) {
                        AlaFrsLiveFragment alaFrsLiveFragment2 = this.f47108a;
                        alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.j.k(), str, false);
                        return;
                    }
                    return;
                }
                this.f47108a.showToast(str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements b.a.r0.w.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f47109a;

        public c(AlaFrsLiveFragment alaFrsLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47109a = alaFrsLiveFragment;
        }

        @Override // b.a.r0.w.e
        public void a(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
                AlaFrsLiveFragment alaFrsLiveFragment = this.f47109a;
                alaFrsLiveFragment.jumpToLiveRoom(alaFrsLiveFragment.getPageContext(), d2Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f47110e;

        public d(AlaFrsLiveFragment alaFrsLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47110e = alaFrsLiveFragment;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f47110e.f47106i == null) {
                return;
            }
            this.f47110e.f47106i.N();
        }
    }

    /* loaded from: classes9.dex */
    public class e implements BdMultiColumnListView.OnScrollToBottomListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f47111a;

        public e(AlaFrsLiveFragment alaFrsLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47111a = alaFrsLiveFragment;
        }

        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean M = this.f47111a.f47106i != null ? this.f47111a.f47106i.M() : false;
                if (this.f47111a.j != null) {
                    if (M) {
                        this.f47111a.j.B();
                    } else {
                        this.f47111a.j.C();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements b.a.r0.w.g.c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f47112a;

        public f(AlaFrsLiveFragment alaFrsLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47112a = alaFrsLiveFragment;
        }

        @Override // b.a.r0.w.g.c.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f47112a.f47106i == null || this.f47112a.f47106i.I() == i2) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c12572");
            statisticItem.param("fid", this.f47112a.f47102e);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            this.f47112a.f47106i.setSortType(i2);
            this.f47112a.f47106i.clearData();
            if (this.f47112a.j != null) {
                this.f47112a.j.i().startPullRefresh();
            }
        }
    }

    public AlaFrsLiveFragment() {
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
        this.k = 1;
        this.l = false;
        this.m = false;
        this.o = new a(this, 0);
        this.q = new b(this);
        this.r = new c(this);
        this.s = new d(this);
        this.t = new e(this);
        this.u = new f(this);
    }

    public final void forceRefresh() {
        b.a.r0.w.g.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.j) == null) {
            return;
        }
        cVar.h();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        InterceptResult invokeV;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AlaFrsLiveModel alaFrsLiveModel = this.f47106i;
            if (alaFrsLiveModel == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.f47106i.getData()) {
                if ((nVar instanceof d2) && (d2Var = (d2) nVar) != null && d2Var.l1() != null) {
                    linkedList.add(Long.valueOf(d2Var.l1().live_id));
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    @Override // b.a.r0.x0.q0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j.j() : (NavigationBar) invokeV.objValue;
    }

    public final AlaLiveInfoCoreData i(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, d2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(d2Var.l1());
            alaLiveInfoCoreData.userName = d2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? isAdded() && isPrimary() : invokeI.booleanValue;
    }

    public final void j() {
        b.a.r0.w.g.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.j) == null || cVar.j() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f47103f, 5, true, true) + getResources().getString(R.string.forum));
        this.j.j().setCenterTextTitle(sb.toString());
    }

    public void jumpToLiveRoom(TbPageContext<?> tbPageContext, d2 d2Var) {
        String str;
        boolean z;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, tbPageContext, d2Var) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.l1() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12571");
        statisticItem.param("fid", this.f47102e);
        statisticItem.param("obj_type", d2Var.l1().live_type);
        TiebaStatic.log(statisticItem);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = d2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(d2Var.l1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (n nVar : this.f47106i.getData()) {
            if (nVar != null && (nVar instanceof b.a.r0.w.g.b.c) && (d2Var2 = ((b.a.r0.w.g.b.c) nVar).f24992e) != null) {
                alaLiveInfoListCoreData.mLiveInfoList.add(i(d2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i2) {
        AlaSquareRefreshManager alaSquareRefreshManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (alaSquareRefreshManager = this.n) == null) {
            return;
        }
        alaSquareRefreshManager.reset(i2);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.p = i2;
            b.a.r0.w.g.c.c cVar = this.j;
            if (cVar != null) {
                cVar.q(i2);
            }
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(2001446, this.o, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            b.a.r0.w.g.c.c cVar = new b.a.r0.w.g.c.c(getPageContext(), this.f47105h, getPageContext().getOrignalPage().getUniqueId(), this.f47102e, this.m);
            this.j = cVar;
            cVar.o();
            this.j.u(1);
            this.j.v(this.r);
            this.j.y(this.s);
            this.j.z(this.t);
            this.j.x(this.u);
            this.j.q(this.p);
            j();
            return this.j.k();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            AlaSquareRefreshManager alaSquareRefreshManager = this.n;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onDestory();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!this.l) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
                return;
            }
            AlaFrsLiveModel alaFrsLiveModel = this.f47106i;
            if (alaFrsLiveModel != null) {
                alaFrsLiveModel.N();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            AlaSquareRefreshManager alaSquareRefreshManager = this.n;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (this.f47106i == null) {
                    AlaFrsLiveModel alaFrsLiveModel = new AlaFrsLiveModel(getPageContext());
                    this.f47106i = alaFrsLiveModel;
                    alaFrsLiveModel.P(this.q);
                    this.f47106i.setForumId(this.f47102e);
                    this.f47106i.setForumGameLabel(this.f47104g);
                    this.f47106i.O(this.k);
                    this.f47106i.N();
                    b.a.r0.w.g.c.c cVar = this.j;
                    if (cVar != null) {
                        showLoadingView(cVar.k(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                    }
                    AlaSquareRefreshManager alaSquareRefreshManager = new AlaSquareRefreshManager();
                    this.n = alaSquareRefreshManager;
                    alaSquareRefreshManager.init(this, new long[]{30000});
                    return;
                }
                AlaSquareRefreshManager alaSquareRefreshManager2 = this.n;
                if (alaSquareRefreshManager2 != null) {
                    alaSquareRefreshManager2.onPageForeground(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onStop();
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public void processCloseLives(List<Long> list) {
        AlaFrsLiveModel alaFrsLiveModel;
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || ListUtils.isEmpty(list) || (alaFrsLiveModel = this.f47106i) == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.f47106i.getData()) {
            if ((nVar instanceof d2) && (d2Var = (d2) nVar) != null && d2Var.l1() != null) {
                Long l = null;
                Iterator<Long> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long next = it.next();
                    if (next.longValue() == d2Var.l1().live_id) {
                        linkedList.add(d2Var);
                        l = next;
                        break;
                    }
                }
                if (l != null) {
                    list.remove(l);
                }
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        this.f47106i.getData().removeAll(linkedList);
        AlaFrsLiveModel.b bVar = this.q;
        if (bVar != null) {
            bVar.a(this.f47106i.J());
        }
    }

    public void setForumGameLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f47104g = str;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f47102e = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f47103f = str;
        }
    }

    public void setFromType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setIsNeedScrollDispatch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f47105h = z;
        }
    }

    public void setIsShowNavi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.m = z;
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            refreshCurrentPage();
        }
    }
}
