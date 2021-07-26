package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.k.e.n;
import d.a.p0.s.f0.f;
import d.a.p0.s.q.b2;
import d.a.q0.u0.q0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, q0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f14244e;

    /* renamed from: f  reason: collision with root package name */
    public String f14245f;

    /* renamed from: g  reason: collision with root package name */
    public String f14246g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14247h;

    /* renamed from: i  reason: collision with root package name */
    public AlaFrsLiveModel f14248i;
    public d.a.q0.v.e.c.c j;
    public int k;
    public boolean l;
    public boolean m;
    public AlaSquareRefreshManager n;
    public CustomMessageListener o;
    public int p;
    public AlaFrsLiveModel.b q;
    public d.a.q0.v.c r;
    public f.g s;
    public BdMultiColumnListView.OnScrollToBottomListener t;
    public d.a.q0.v.e.c.d u;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f14249a;

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
            this.f14249a = alaFrsLiveFragment;
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
            if ("FrsGameLive".equals(split[0]) && 9 == d.a.d.e.m.b.d(split[1], 0)) {
                this.f14249a.s();
            } else if ("FrsGameLiveLive".equals(split[0]) && 2 == d.a.d.e.m.b.d(split[1], 0)) {
                this.f14249a.s();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaFrsLiveModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f14250a;

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
            this.f14250a = alaFrsLiveFragment;
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f14250a.getPageContext() == null || this.f14250a.j == null) {
                return;
            }
            AlaFrsLiveFragment alaFrsLiveFragment = this.f14250a;
            alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.j.k());
            this.f14250a.j.g();
            this.f14250a.j.w(this.f14250a.f14248i.getData(), z, this.f14250a.f14248i.K());
            this.f14250a.j.t(this.f14250a.f14248i.H());
            if (ListUtils.getCount(this.f14250a.f14248i.getData()) == 0) {
                if (this.f14250a.k == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001621));
                }
                this.f14250a.l = false;
                AlaFrsLiveFragment alaFrsLiveFragment2 = this.f14250a;
                alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.j.k(), this.f14250a.getPageContext().getString(R.string.frs_game_live_no_data), null, this.f14250a.getPageContext().getString(R.string.frs_game_live_more_data), false, this.f14250a.getNetRefreshListener());
                return;
            }
            AlaFrsLiveFragment alaFrsLiveFragment3 = this.f14250a;
            alaFrsLiveFragment3.hideNetRefreshView(alaFrsLiveFragment3.j.k());
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (this.f14250a.j != null) {
                    AlaFrsLiveFragment alaFrsLiveFragment = this.f14250a;
                    alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.j.k());
                    this.f14250a.j.g();
                }
                if (ListUtils.getCount(this.f14250a.f14248i.getData()) <= 0 || this.f14250a.j == null) {
                    this.f14250a.l = true;
                    if (this.f14250a.j != null) {
                        AlaFrsLiveFragment alaFrsLiveFragment2 = this.f14250a;
                        alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.j.k(), str, false);
                        return;
                    }
                    return;
                }
                this.f14250a.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.q0.v.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f14251a;

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
            this.f14251a = alaFrsLiveFragment;
        }

        @Override // d.a.q0.v.c
        public void a(b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) {
                AlaFrsLiveFragment alaFrsLiveFragment = this.f14251a;
                alaFrsLiveFragment.U0(alaFrsLiveFragment.getPageContext(), b2Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f14252e;

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
            this.f14252e = alaFrsLiveFragment;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f14252e.f14248i == null) {
                return;
            }
            this.f14252e.f14248i.N();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdMultiColumnListView.OnScrollToBottomListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f14253a;

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
            this.f14253a = alaFrsLiveFragment;
        }

        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean M = this.f14253a.f14248i != null ? this.f14253a.f14248i.M() : false;
                if (this.f14253a.j != null) {
                    if (M) {
                        this.f14253a.j.B();
                    } else {
                        this.f14253a.j.C();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.q0.v.e.c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f14254a;

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
            this.f14254a = alaFrsLiveFragment;
        }

        @Override // d.a.q0.v.e.c.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f14254a.f14248i == null || this.f14254a.f14248i.I() == i2) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c12572");
            statisticItem.param("fid", this.f14254a.f14244e);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            this.f14254a.f14248i.setSortType(i2);
            this.f14254a.f14248i.clearData();
            if (this.f14254a.j != null) {
                this.f14254a.j.i().startPullRefresh();
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

    public void U0(TbPageContext<?> tbPageContext, b2 b2Var) {
        String str;
        boolean z;
        b2 b2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, b2Var) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.h1() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12571");
        statisticItem.param("fid", this.f14244e);
        statisticItem.param("obj_type", b2Var.h1().live_type);
        TiebaStatic.log(statisticItem);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = b2Var.H().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(b2Var.h1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (n nVar : this.f14248i.getData()) {
            if (nVar != null && (nVar instanceof d.a.q0.v.e.b.c) && (b2Var2 = ((d.a.q0.v.e.b.c) nVar).f65316e) != null) {
                alaLiveInfoListCoreData.mLiveInfoList.add(V0(b2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
    }

    public final AlaLiveInfoCoreData V0(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(b2Var.h1());
            alaLiveInfoCoreData.userName = b2Var.H().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void W0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f14246g = str;
        }
    }

    public void X0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f14244e = str;
        }
    }

    public void Y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f14245f = str;
        }
    }

    public void Z0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.k = i2;
        }
    }

    public void a1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f14247h = z;
        }
    }

    public void b1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m = z;
        }
    }

    public final void c1() {
        d.a.q0.v.e.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (cVar = this.j) == null || cVar.j() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f14245f, 5, true, true) + getResources().getString(R.string.forum));
        this.j.j().setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        InterceptResult invokeV;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AlaFrsLiveModel alaFrsLiveModel = this.f14248i;
            if (alaFrsLiveModel == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.f14248i.getData()) {
                if ((nVar instanceof b2) && (b2Var = (b2) nVar) != null && b2Var.h1() != null) {
                    linkedList.add(Long.valueOf(b2Var.h1().live_id));
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? isAdded() && isPrimary() : invokeI.booleanValue;
    }

    @Override // d.a.q0.u0.q0
    public NavigationBar j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j.j() : (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i2) {
        AlaSquareRefreshManager alaSquareRefreshManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (alaSquareRefreshManager = this.n) == null) {
            return;
        }
        alaSquareRefreshManager.reset(i2);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.p = i2;
            d.a.q0.v.e.c.c cVar = this.j;
            if (cVar != null) {
                cVar.q(i2);
            }
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(2001446, this.o, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            d.a.q0.v.e.c.c cVar = new d.a.q0.v.e.c.c(getPageContext(), this.f14247h, getPageContext().getOrignalPage().getUniqueId(), this.f14244e, this.m);
            this.j = cVar;
            cVar.o();
            this.j.u(1);
            this.j.v(this.r);
            this.j.y(this.s);
            this.j.z(this.t);
            this.j.x(this.u);
            this.j.q(this.p);
            c1();
            return this.j.k();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!this.l) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
                return;
            }
            AlaFrsLiveModel alaFrsLiveModel = this.f14248i;
            if (alaFrsLiveModel != null) {
                alaFrsLiveModel.N();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (this.f14248i == null) {
                    AlaFrsLiveModel alaFrsLiveModel = new AlaFrsLiveModel(getPageContext());
                    this.f14248i = alaFrsLiveModel;
                    alaFrsLiveModel.P(this.q);
                    this.f14248i.setForumId(this.f14244e);
                    this.f14248i.setForumGameLabel(this.f14246g);
                    this.f14248i.O(this.k);
                    this.f14248i.N();
                    d.a.q0.v.e.c.c cVar = this.j;
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onStop();
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public void processCloseLives(List<Long> list) {
        AlaFrsLiveModel alaFrsLiveModel;
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, list) == null) || ListUtils.isEmpty(list) || (alaFrsLiveModel = this.f14248i) == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.f14248i.getData()) {
            if ((nVar instanceof b2) && (b2Var = (b2) nVar) != null && b2Var.h1() != null) {
                Long l = null;
                Iterator<Long> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long next = it.next();
                    if (next.longValue() == b2Var.h1().live_id) {
                        linkedList.add(b2Var);
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
        this.f14248i.getData().removeAll(linkedList);
        AlaFrsLiveModel.b bVar = this.q;
        if (bVar != null) {
            bVar.a(this.f14248i.J());
        }
    }

    public final void s() {
        d.a.q0.v.e.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (cVar = this.j) == null) {
            return;
        }
        cVar.h();
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            refreshCurrentPage();
        }
    }
}
