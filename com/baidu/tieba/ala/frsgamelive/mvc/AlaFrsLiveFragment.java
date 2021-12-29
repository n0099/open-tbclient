package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.d.n.e.n;
import c.a.s0.s.i0.f;
import c.a.s0.s.q.d2;
import c.a.t0.d1.r0;
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
/* loaded from: classes12.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f43623e;

    /* renamed from: f  reason: collision with root package name */
    public String f43624f;

    /* renamed from: g  reason: collision with root package name */
    public String f43625g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43626h;

    /* renamed from: i  reason: collision with root package name */
    public AlaFrsLiveModel f43627i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.t0.a0.g.c.c f43628j;

    /* renamed from: k  reason: collision with root package name */
    public int f43629k;
    public boolean l;
    public boolean m;
    public AlaSquareRefreshManager n;
    public CustomMessageListener o;
    public int p;
    public AlaFrsLiveModel.b q;
    public c.a.t0.a0.e r;
    public f.g s;
    public BdMultiColumnListView.OnScrollToBottomListener t;
    public c.a.t0.a0.g.c.d u;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsLiveFragment a;

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
            this.a = alaFrsLiveFragment;
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
            if ("FrsGameLive".equals(split[0]) && 9 == c.a.d.f.m.b.e(split[1], 0)) {
                this.a.forceRefresh();
            } else if ("FrsGameLiveLive".equals(split[0]) && 2 == c.a.d.f.m.b.e(split[1], 0)) {
                this.a.forceRefresh();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements AlaFrsLiveModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsLiveFragment a;

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
            this.a = alaFrsLiveFragment;
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.getPageContext() == null || this.a.f43628j == null) {
                return;
            }
            AlaFrsLiveFragment alaFrsLiveFragment = this.a;
            alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.f43628j.k());
            this.a.f43628j.g();
            this.a.f43628j.w(this.a.f43627i.getData(), z, this.a.f43627i.J());
            this.a.f43628j.t(this.a.f43627i.H());
            if (ListUtils.getCount(this.a.f43627i.getData()) == 0) {
                if (this.a.f43629k == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001621));
                }
                this.a.l = false;
                AlaFrsLiveFragment alaFrsLiveFragment2 = this.a;
                alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.f43628j.k(), this.a.getPageContext().getString(R.string.frs_game_live_no_data), null, this.a.getPageContext().getString(R.string.frs_game_live_more_data), false, this.a.getNetRefreshListener());
                return;
            }
            AlaFrsLiveFragment alaFrsLiveFragment3 = this.a;
            alaFrsLiveFragment3.hideNetRefreshView(alaFrsLiveFragment3.f43628j.k());
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (this.a.f43628j != null) {
                    AlaFrsLiveFragment alaFrsLiveFragment = this.a;
                    alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.f43628j.k());
                    this.a.f43628j.g();
                }
                if (ListUtils.getCount(this.a.f43627i.getData()) <= 0 || this.a.f43628j == null) {
                    this.a.l = true;
                    if (this.a.f43628j != null) {
                        AlaFrsLiveFragment alaFrsLiveFragment2 = this.a;
                        alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.f43628j.k(), str, false);
                        return;
                    }
                    return;
                }
                this.a.showToast(str);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements c.a.t0.a0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsLiveFragment a;

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
            this.a = alaFrsLiveFragment;
        }

        @Override // c.a.t0.a0.e
        public void a(d2 d2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
                AlaFrsLiveFragment alaFrsLiveFragment = this.a;
                alaFrsLiveFragment.jumpToLiveRoom(alaFrsLiveFragment.getPageContext(), d2Var);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaFrsLiveFragment f43630e;

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
            this.f43630e = alaFrsLiveFragment;
        }

        @Override // c.a.s0.s.i0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f43630e.f43627i == null) {
                return;
            }
            this.f43630e.f43627i.M();
        }
    }

    /* loaded from: classes12.dex */
    public class e implements BdMultiColumnListView.OnScrollToBottomListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsLiveFragment a;

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
            this.a = alaFrsLiveFragment;
        }

        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean L = this.a.f43627i != null ? this.a.f43627i.L() : false;
                if (this.a.f43628j != null) {
                    if (L) {
                        this.a.f43628j.B();
                    } else {
                        this.a.f43628j.C();
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements c.a.t0.a0.g.c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsLiveFragment a;

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
            this.a = alaFrsLiveFragment;
        }

        @Override // c.a.t0.a0.g.c.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f43627i == null || this.a.f43627i.I() == i2) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c12572");
            statisticItem.param("fid", this.a.f43623e);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            this.a.f43627i.setSortType(i2);
            this.a.f43627i.clearData();
            if (this.a.f43628j != null) {
                this.a.f43628j.i().startPullRefresh();
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
        this.f43629k = 1;
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
        c.a.t0.a0.g.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f43628j) == null) {
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
            AlaFrsLiveModel alaFrsLiveModel = this.f43627i;
            if (alaFrsLiveModel == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.f43627i.getData()) {
                if ((nVar instanceof d2) && (d2Var = (d2) nVar) != null && d2Var.o1() != null) {
                    linkedList.add(Long.valueOf(d2Var.o1().live_id));
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    @Override // c.a.t0.d1.r0
    public NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43628j.j() : (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? isAdded() && isPrimary() : invokeI.booleanValue;
    }

    public void jumpToLiveRoom(TbPageContext<?> tbPageContext, d2 d2Var) {
        String str;
        boolean z;
        d2 d2Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, d2Var) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.o1() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12571");
        statisticItem.param("fid", this.f43623e);
        statisticItem.param("obj_type", d2Var.o1().live_type);
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
        alaLiveInfoCoreData.fillWithInfoData(d2Var.o1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (n nVar : this.f43627i.getData()) {
            if (nVar != null && (nVar instanceof c.a.t0.a0.g.b.c) && (d2Var2 = ((c.a.t0.a0.g.b.c) nVar).f15124e) != null) {
                alaLiveInfoListCoreData.mLiveInfoList.add(n(d2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i2) {
        AlaSquareRefreshManager alaSquareRefreshManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (alaSquareRefreshManager = this.n) == null) {
            return;
        }
        alaSquareRefreshManager.reset(i2);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final AlaLiveInfoCoreData n(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, d2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(d2Var.o1());
            alaLiveInfoCoreData.userName = d2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public final void o() {
        c.a.t0.a0.g.c.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (cVar = this.f43628j) == null || cVar.j() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f43624f, 5, true, true) + getResources().getString(R.string.forum));
        this.f43628j.j().setCenterTextTitle(sb.toString());
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
            c.a.t0.a0.g.c.c cVar = this.f43628j;
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
            c.a.t0.a0.g.c.c cVar = new c.a.t0.a0.g.c.c(getPageContext(), this.f43626h, getPageContext().getOrignalPage().getUniqueId(), this.f43623e, this.m);
            this.f43628j = cVar;
            cVar.o();
            this.f43628j.u(1);
            this.f43628j.v(this.r);
            this.f43628j.y(this.s);
            this.f43628j.z(this.t);
            this.f43628j.x(this.u);
            this.f43628j.q(this.p);
            o();
            return this.f43628j.k();
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
            AlaFrsLiveModel alaFrsLiveModel = this.f43627i;
            if (alaFrsLiveModel != null) {
                alaFrsLiveModel.M();
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
                if (this.f43627i == null) {
                    AlaFrsLiveModel alaFrsLiveModel = new AlaFrsLiveModel(getPageContext());
                    this.f43627i = alaFrsLiveModel;
                    alaFrsLiveModel.O(this.q);
                    this.f43627i.setForumId(this.f43623e);
                    this.f43627i.setForumGameLabel(this.f43625g);
                    this.f43627i.N(this.f43629k);
                    this.f43627i.M();
                    c.a.t0.a0.g.c.c cVar = this.f43628j;
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
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || ListUtils.isEmpty(list) || (alaFrsLiveModel = this.f43627i) == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.f43627i.getData()) {
            if ((nVar instanceof d2) && (d2Var = (d2) nVar) != null && d2Var.o1() != null) {
                Long l = null;
                Iterator<Long> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long next = it.next();
                    if (next.longValue() == d2Var.o1().live_id) {
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
        this.f43627i.getData().removeAll(linkedList);
        AlaFrsLiveModel.b bVar = this.q;
        if (bVar != null) {
            bVar.a(this.f43627i.hasMore());
        }
    }

    public void setForumGameLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.f43625g = str;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.f43623e = str;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.f43624f = str;
        }
    }

    public void setFromType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.f43629k = i2;
        }
    }

    public void setIsNeedScrollDispatch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f43626h = z;
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
