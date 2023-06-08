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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.be6;
import com.baidu.tieba.ee6;
import com.baidu.tieba.fe6;
import com.baidu.tieba.ka6;
import com.baidu.tieba.re7;
import com.baidu.tieba.tg;
import com.baidu.tieba.vn;
import com.baidu.tieba.w95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, re7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public AlaFrsLiveModel e;
    public ee6 f;
    public int g;
    public boolean h;
    public boolean i;
    public AlaSquareRefreshManager j;
    public CustomMessageListener k;
    public int l;
    public AlaFrsLiveModel.b m;
    public ka6 n;
    public w95.g o;
    public BdMultiColumnListView.OnScrollToBottomListener p;
    public fe6 q;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsLiveFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaFrsLiveFragment alaFrsLiveFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length != 2) {
                    return;
                }
                if ("FrsGameLive".equals(split[0]) && 9 == tg.e(split[1], 0)) {
                    this.a.h();
                } else if ("FrsGameLiveLive".equals(split[0]) && 2 == tg.e(split[1], 0)) {
                    this.a.h();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsLiveFragment;
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                if (this.a.f != null) {
                    AlaFrsLiveFragment alaFrsLiveFragment = this.a;
                    alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.f.k());
                    this.a.f.g();
                }
                if (ListUtils.getCount(this.a.e.getData()) > 0 && this.a.f != null) {
                    this.a.showToast(str);
                    return;
                }
                this.a.h = true;
                if (this.a.f != null) {
                    AlaFrsLiveFragment alaFrsLiveFragment2 = this.a;
                    alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.f.k(), str, false);
                }
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.a.getPageContext() != null && this.a.f != null) {
                AlaFrsLiveFragment alaFrsLiveFragment = this.a;
                alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.f.k());
                this.a.f.g();
                this.a.f.w(this.a.e.getData(), z, this.a.e.h0());
                this.a.f.t(this.a.e.f0());
                if (ListUtils.getCount(this.a.e.getData()) == 0) {
                    if (this.a.g == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001621));
                    }
                    this.a.h = false;
                    AlaFrsLiveFragment alaFrsLiveFragment2 = this.a;
                    alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.f.k(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f07ff), null, this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f07fd), false, this.a.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment alaFrsLiveFragment3 = this.a;
                alaFrsLiveFragment3.hideNetRefreshView(alaFrsLiveFragment3.f.k());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ka6 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsLiveFragment;
        }

        @Override // com.baidu.tieba.ka6
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                AlaFrsLiveFragment alaFrsLiveFragment = this.a;
                alaFrsLiveFragment.P1(alaFrsLiveFragment.getPageContext(), threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements w95.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaFrsLiveFragment a;

        public d(AlaFrsLiveFragment alaFrsLiveFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaFrsLiveFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsLiveFragment;
        }

        @Override // com.baidu.tieba.w95.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.e != null) {
                this.a.e.k0();
            }
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsLiveFragment;
        }

        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null) {
                    z = this.a.e.j0();
                } else {
                    z = false;
                }
                if (this.a.f != null) {
                    if (z) {
                        this.a.f.B();
                    } else {
                        this.a.f.C();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements fe6 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaFrsLiveFragment;
        }

        @Override // com.baidu.tieba.fe6
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.e != null && this.a.e.g0() != i) {
                StatisticItem statisticItem = new StatisticItem("c12572");
                statisticItem.param("fid", this.a.a);
                statisticItem.param("obj_type", i);
                TiebaStatic.log(statisticItem);
                this.a.e.setSortType(i);
                this.a.e.clearData();
                if (this.a.f != null) {
                    this.a.f.i().startPullRefresh();
                }
            }
        }
    }

    public AlaFrsLiveFragment() {
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
        this.g = 1;
        this.h = false;
        this.i = false;
        this.k = new a(this, 0);
        this.m = new b(this);
        this.n = new c(this);
        this.o = new d(this);
        this.p = new e(this);
        this.q = new f(this);
    }

    public final void X1() {
        ee6 ee6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (ee6Var = this.f) != null && ee6Var.j() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.b, 5, true, true) + getResources().getString(R.string.obfuscated_res_0x7f0f0766));
            this.f.j().setCenterTextTitle(sb.toString());
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        InterceptResult invokeV;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AlaFrsLiveModel alaFrsLiveModel = this.e;
            if (alaFrsLiveModel != null && !ListUtils.isEmpty(alaFrsLiveModel.getData())) {
                LinkedList linkedList = new LinkedList();
                for (vn vnVar : this.e.getData()) {
                    if ((vnVar instanceof ThreadData) && (threadData = (ThreadData) vnVar) != null && threadData.getThreadAlaInfo() != null) {
                        linkedList.add(Long.valueOf(threadData.getThreadAlaInfo().live_id));
                    }
                }
                return linkedList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final AlaLiveInfoCoreData Q1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void R1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }

    public void S1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.a = str;
        }
    }

    public void T1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.b = str;
        }
    }

    public void U1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.g = i;
        }
    }

    public void V1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.d = z;
        }
    }

    public void W1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.i = z;
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (isAdded() && isPrimary()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.onChangeSkinType(i);
            this.l = i;
            ee6 ee6Var = this.f;
            if (ee6Var != null) {
                ee6Var.q(i);
            }
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(2001446, this.k, getBaseFragmentActivity().getUniqueId());
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            refreshCurrentPage();
        }
    }

    public void P1(TbPageContext<?> tbPageContext, ThreadData threadData) {
        String str;
        boolean z;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, tbPageContext, threadData) == null) && tbPageContext != null && threadData != null && threadData.getAuthor() != null && threadData.getThreadAlaInfo() != null) {
            StatisticItem statisticItem = new StatisticItem("c12571");
            statisticItem.param("fid", this.a);
            statisticItem.param("obj_type", threadData.getThreadAlaInfo().live_type);
            TiebaStatic.log(statisticItem);
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = threadData.getAuthor().getUserId();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, currentAccount);
                str = currentAccount;
            } else {
                str = "";
                z = false;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (vn vnVar : this.e.getData()) {
                if (vnVar != null && (vnVar instanceof be6) && (threadData2 = ((be6) vnVar).a) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(Q1(threadData2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
        }
    }

    public final void h() {
        ee6 ee6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (ee6Var = this.f) != null) {
            ee6Var.h();
        }
    }

    @Override // com.baidu.tieba.re7
    public NavigationBar n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.f.j();
        }
        return (NavigationBar) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDestroy();
            AlaSquareRefreshManager alaSquareRefreshManager = this.j;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onDestory();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        AlaFrsLiveModel alaFrsLiveModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onNetRefreshButtonClicked();
            if (this.h && (alaFrsLiveModel = this.e) != null) {
                alaFrsLiveModel.k0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            AlaSquareRefreshManager alaSquareRefreshManager = this.j;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, layoutInflater, viewGroup, bundle)) == null) {
            ee6 ee6Var = new ee6(getPageContext(), this.d, getPageContext().getOrignalPage().getUniqueId(), this.a, this.i);
            this.f = ee6Var;
            ee6Var.o();
            this.f.u(1);
            this.f.v(this.n);
            this.f.y(this.o);
            this.f.z(this.p);
            this.f.x(this.q);
            this.f.q(this.l);
            X1();
            return this.f.k();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPrimary();
            if (isPrimary()) {
                if (this.e == null) {
                    AlaFrsLiveModel alaFrsLiveModel = new AlaFrsLiveModel(getPageContext());
                    this.e = alaFrsLiveModel;
                    alaFrsLiveModel.m0(this.m);
                    this.e.setForumId(this.a);
                    this.e.setForumGameLabel(this.c);
                    this.e.l0(this.g);
                    this.e.k0();
                    ee6 ee6Var = this.f;
                    if (ee6Var != null) {
                        showLoadingView(ee6Var.k(), false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a6));
                    }
                    AlaSquareRefreshManager alaSquareRefreshManager = new AlaSquareRefreshManager();
                    this.j = alaSquareRefreshManager;
                    alaSquareRefreshManager.init(this, new long[]{30000});
                    return;
                }
                AlaSquareRefreshManager alaSquareRefreshManager2 = this.j;
                if (alaSquareRefreshManager2 != null) {
                    alaSquareRefreshManager2.onPageForeground(0);
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public void processCloseLives(List<Long> list) {
        AlaFrsLiveModel alaFrsLiveModel;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, list) == null) && !ListUtils.isEmpty(list) && (alaFrsLiveModel = this.e) != null && !ListUtils.isEmpty(alaFrsLiveModel.getData())) {
            LinkedList linkedList = new LinkedList();
            for (vn vnVar : this.e.getData()) {
                if ((vnVar instanceof ThreadData) && (threadData = (ThreadData) vnVar) != null && threadData.getThreadAlaInfo() != null) {
                    Long l = null;
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Long next = it.next();
                        if (next.longValue() == threadData.getThreadAlaInfo().live_id) {
                            linkedList.add(threadData);
                            l = next;
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.e.getData().removeAll(linkedList);
                AlaFrsLiveModel.b bVar = this.m;
                if (bVar != null) {
                    bVar.b(this.e.hasMore());
                }
            }
        }
    }
}
