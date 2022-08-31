package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import com.baidu.tieba.bv4;
import com.baidu.tieba.cu5;
import com.baidu.tieba.cv4;
import com.baidu.tieba.ft5;
import com.baidu.tieba.ju5;
import com.baidu.tieba.l65;
import com.baidu.tieba.pi;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View d;
    public BdTypeListView e;
    public PbListView f;
    public cv4 g;
    public l65 h;
    public ft5 i;
    public AlaNewSquareSubListModel j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public String o;
    public String p;
    public String q;
    public AlaNewSquareSubListModel.b r;
    public BdListView.p s;
    public final bv4.g t;

    /* loaded from: classes3.dex */
    public class a implements ju5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OtherSubTabFragment a;

        public a(OtherSubTabFragment otherSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {otherSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = otherSubTabFragment;
        }

        @Override // com.baidu.tieba.ju5
        public void a(int i, String str, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, threadData) == null) {
                String str2 = "";
                if (threadData != null && threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().isLegalYYLiveData()) {
                    String str3 = YYLiveUtil.SOURCE_BAIDU_LIVE_CARD_ + i;
                    AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                    TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
                    YyExtData yyExtData = threadAlaInfo.mYyExtData;
                    YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + threadAlaInfo.roomId, str3);
                } else {
                    OtherSubTabFragment otherSubTabFragment = this.a;
                    otherSubTabFragment.N1(otherSubTabFragment.getPageContext(), threadData, str);
                }
                if (threadData == null || StringUtils.isNull(str)) {
                    return;
                }
                StatisticItem param = new StatisticItem("c12904").param("tid", threadData.getTid()).param(TiebaStatic.Params.ENTRY_NAME, str);
                param.param("fid", this.a.p);
                param.param("fname", this.a.q);
                int calculateLiveType = YYLiveUtil.calculateLiveType(threadData.getThreadAlaInfo());
                if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(param, threadData.getThreadAlaInfo().mYyExtData);
                    str2 = TiebaStatic.YYValues.YY_LIVE;
                }
                param.param("obj_param1", calculateLiveType);
                param.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                TiebaStatic.log(param);
            }
        }

        @Override // com.baidu.tieba.ju5
        public void b(cu5 cu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cu5Var) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OtherSubTabFragment a;

        public b(OtherSubTabFragment otherSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {otherSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = otherSubTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.k = z;
                this.a.m = true;
                this.a.R1(false);
                OtherSubTabFragment otherSubTabFragment = this.a;
                otherSubTabFragment.hideLoadingView(otherSubTabFragment.d);
                if (ListUtils.getCount(this.a.j.M()) == 0) {
                    this.a.T1();
                    return;
                }
                this.a.e.setData(this.a.j.M());
                if (!this.a.k) {
                    this.a.U1();
                } else {
                    this.a.S1();
                }
                this.a.M1();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                OtherSubTabFragment otherSubTabFragment = this.a;
                otherSubTabFragment.hideLoadingView(otherSubTabFragment.d);
                this.a.L1();
                this.a.T1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OtherSubTabFragment a;

        public c(OtherSubTabFragment otherSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {otherSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = otherSubTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ri.D()) {
                    this.a.L1();
                } else if (this.a.k) {
                    this.a.j.S();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements bv4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OtherSubTabFragment a;

        public d(OtherSubTabFragment otherSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {otherSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = otherSubTabFragment;
        }

        @Override // com.baidu.tieba.bv4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (pi.z()) {
                    this.a.j.T();
                } else {
                    this.a.R1(false);
                }
            }
        }
    }

    public OtherSubTabFragment() {
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
        this.k = true;
        this.l = false;
        this.m = false;
        this.p = "";
        this.q = "";
        this.r = new b(this);
        this.s = new c(this);
        this.t = new d(this);
    }

    public static OtherSubTabFragment O1(int i, SpecialLiveTabInfo specialLiveTabInfo, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i), specialLiveTabInfo, str, str2})) == null) {
            OtherSubTabFragment otherSubTabFragment = new OtherSubTabFragment();
            if (specialLiveTabInfo != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("tab_origin_tab_position", i);
                bundle.putParcelable("tab_origin_tab_info", specialLiveTabInfo);
                bundle.putString("forum_id", str);
                bundle.putString("forum_name", str2);
                otherSubTabFragment.setArguments(bundle);
            }
            return otherSubTabFragment;
        }
        return (OtherSubTabFragment) invokeCommon.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(ri.f(getContext(), R.dimen.tbds182));
            this.f.l(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void M1() {
        BdTypeListView bdTypeListView;
        l65 l65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeListView = this.e) == null || (l65Var = this.h) == null) {
            return;
        }
        this.l = false;
        bdTypeListView.removeHeaderView(l65Var.b());
    }

    public final void N1(TbPageContext<?> tbPageContext, ThreadData threadData, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, threadData, str) == null) || tbPageContext == null || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = threadData.getAuthor().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (ThreadData threadData2 : this.j.O()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(P1(threadData2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_SUB_TAB, str2, z, str, null)));
    }

    public final AlaLiveInfoCoreData P1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, threadData)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(threadData.getThreadAlaInfo());
            alaLiveInfoCoreData.userName = threadData.getAuthor().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.m = false;
            this.j.T();
            showLoadingView(this.d, false, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027e));
        }
    }

    public void R1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || z) {
            return;
        }
        this.e.z();
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(ri.f(getContext(), R.dimen.tbds182));
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.Q();
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.h == null) {
                l65 l65Var = new l65(getPageContext().getContext(), getNetRefreshListener());
                this.h = l65Var;
                l65Var.n(null);
                this.h.g(null);
                this.h.p();
                this.h.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.h.m(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f11db));
            this.h.onChangeSkinType();
            if (this.l) {
                return;
            }
            this.e.x(this.h.b(), 0);
            this.l = true;
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.setNextPage(this.f);
            this.f.t(ri.f(getContext(), R.dimen.tbds182));
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.C(getResources().getString(R.string.obfuscated_res_0x7f0f0a19));
            this.f.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            cv4 cv4Var = this.g;
            if (cv4Var != null) {
                cv4Var.H(i);
            }
            PbListView pbListView = this.f;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f.d(i);
            }
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments == null || arguments.getParcelable("tab_origin_tab_info") == null) {
                i = 0;
            } else {
                SpecialLiveTabInfo specialLiveTabInfo = (SpecialLiveTabInfo) arguments.getParcelable("tab_origin_tab_info");
                if (specialLiveTabInfo.tabType == 2) {
                    this.n = "游戏";
                    this.o = specialLiveTabInfo.tabName;
                } else {
                    this.n = specialLiveTabInfo.tabName;
                }
                i = specialLiveTabInfo.tabId;
            }
            if (arguments != null) {
                this.p = arguments.getString("forum_id");
                this.q = arguments.getString("forum_name");
            }
            if (this.j == null) {
                AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(getPageContext());
                this.j = alaNewSquareSubListModel;
                alaNewSquareSubListModel.U(this.r);
            }
            this.j.setTabId(i);
            this.j.setEntryName(this.n);
            this.j.setLabelName(this.o);
            this.j.V(false);
            if (this.i == null) {
                ft5 ft5Var = new ft5(getPageContext());
                this.i = ft5Var;
                ft5Var.v(1);
                this.i.w(new a(this));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.d == null) {
                View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07c1, viewGroup, false);
                this.d = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.obfuscated_res_0x7f0906dc);
                this.e = bdTypeListView;
                bdTypeListView.setOnSrollToBottomListener(this.s);
                cv4 cv4Var = new cv4(getPageContext());
                this.g = cv4Var;
                cv4Var.f(this.t);
                this.e.setPullRefresh(this.g);
                PbListView pbListView = new PbListView(getContext());
                this.f = pbListView;
                pbListView.a();
                this.f.p(R.color.CAM_X0201);
                this.f.t(ri.f(getContext(), R.dimen.tbds182));
                this.f.x();
                this.f.G(R.dimen.tbfontsize33);
                this.f.E(SkinManager.getColor(R.color.CAM_X0107));
                this.f.A(R.color.CAM_X0110);
                this.f.b().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.i);
                this.e.a(arrayList);
            }
            if (this.d.getParent() != null) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            BdTypeListView bdTypeListView = this.e;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.e.setScrollable(null);
            }
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.j;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
            }
            hideLoadingView(this.d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onNetRefreshButtonClicked();
            Q1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.m) {
                Q1();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void t1() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (bdTypeListView = this.e) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.x();
            BdTypeListView bdTypeListView = this.e;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.e.F();
            }
        }
    }
}
