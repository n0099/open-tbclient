package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.g0.h;
import c.a.s0.s.j0.f;
import c.a.s0.s.j0.g;
import c.a.s0.s.q.e2;
import c.a.t0.a0.f.g.b.e;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAB_ORIGIN_TAB_INFO = "tab_origin_tab_info";
    public static final String TAB_ORIGIN_TAB_POSITION = "tab_origin_tab_position";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f41997h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f41998i;

    /* renamed from: j  reason: collision with root package name */
    public PbListView f41999j;
    public g k;
    public h l;
    public e m;
    public AlaNewSquareSubListModel n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public String s;
    public String t;
    public String u;
    public AlaNewSquareSubListModel.b v;
    public BdListView.p w;
    public final f.g x;

    /* loaded from: classes12.dex */
    public class a implements c.a.t0.a0.f.h.d.f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = otherSubTabFragment;
        }

        @Override // c.a.t0.a0.f.h.d.f
        public void a(int i2, String str, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, e2Var) == null) {
                String str2 = "";
                if (e2Var != null && e2Var.o1() != null && e2Var.o1().isLegalYYLiveData()) {
                    String str3 = YYLiveUtil.SOURCE_BAIDU_LIVE_CARD_ + i2;
                    AlaInfoData o1 = e2Var.o1();
                    TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
                    YyExtData yyExtData = o1.mYyExtData;
                    YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + o1.roomId, str3);
                } else {
                    OtherSubTabFragment otherSubTabFragment = this.a;
                    otherSubTabFragment.y(otherSubTabFragment.getPageContext(), e2Var, str);
                }
                if (e2Var == null || StringUtils.isNull(str)) {
                    return;
                }
                StatisticItem param = new StatisticItem("c12904").param("tid", e2Var.v1()).param(TiebaStatic.Params.ENTRY_NAME, str);
                param.param("fid", this.a.t);
                param.param("fname", this.a.u);
                int calculateLiveType = YYLiveUtil.calculateLiveType(e2Var.o1());
                if (e2Var.o1() != null && e2Var.o1().isLegalYYLiveData()) {
                    TiebaStaticHelper.addYYParam(param, e2Var.o1().mYyExtData);
                    str2 = TiebaStatic.YYValues.YY_LIVE;
                }
                param.param("obj_param1", calculateLiveType);
                param.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                TiebaStatic.log(param);
            }
        }

        @Override // c.a.t0.a0.f.h.d.f
        public void b(c.a.t0.a0.f.h.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.o = z;
                this.a.q = true;
                this.a.setIsRefresh(false);
                OtherSubTabFragment otherSubTabFragment = this.a;
                otherSubTabFragment.hideLoadingView(otherSubTabFragment.f41997h);
                if (ListUtils.getCount(this.a.n.J()) == 0) {
                    this.a.showNetRefreshView();
                    return;
                }
                this.a.f41998i.setData(this.a.n.J());
                if (!this.a.o) {
                    this.a.C();
                } else {
                    this.a.B();
                }
                this.a.hideNetRefreshView();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                OtherSubTabFragment otherSubTabFragment = this.a;
                otherSubTabFragment.hideLoadingView(otherSubTabFragment.f41997h);
                this.a.x();
                this.a.showNetRefreshView();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OtherSubTabFragment f42000e;

        public c(OtherSubTabFragment otherSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {otherSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42000e = otherSubTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!n.C()) {
                    this.f42000e.x();
                } else if (this.f42000e.o) {
                    this.f42000e.n.P();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OtherSubTabFragment f42001e;

        public d(OtherSubTabFragment otherSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {otherSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42001e = otherSubTabFragment;
        }

        @Override // c.a.s0.s.j0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (l.z()) {
                    this.f42001e.n.Q();
                } else {
                    this.f42001e.setIsRefresh(false);
                }
            }
        }
    }

    public OtherSubTabFragment() {
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
        this.o = true;
        this.p = false;
        this.q = false;
        this.t = "";
        this.u = "";
        this.v = new b(this);
        this.w = new c(this);
        this.x = new d(this);
    }

    public static OtherSubTabFragment newInstance(int i2, SpecialLiveTabInfo specialLiveTabInfo, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i2), specialLiveTabInfo, str, str2})) == null) {
            OtherSubTabFragment otherSubTabFragment = new OtherSubTabFragment();
            if (specialLiveTabInfo != null) {
                Bundle bundle = new Bundle();
                bundle.putInt(TAB_ORIGIN_TAB_POSITION, i2);
                bundle.putParcelable(TAB_ORIGIN_TAB_INFO, specialLiveTabInfo);
                bundle.putString("forum_id", str);
                bundle.putString("forum_name", str2);
                otherSubTabFragment.setArguments(bundle);
            }
            return otherSubTabFragment;
        }
        return (OtherSubTabFragment) invokeCommon.objValue;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.q = false;
            this.n.Q();
            showLoadingView(this.f41997h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f41998i.setNextPage(this.f41999j);
            this.f41999j.t(n.f(getContext(), R.dimen.tbds182));
            this.f41999j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f41999j.R();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f41998i.setNextPage(this.f41999j);
            this.f41999j.t(n.f(getContext(), R.dimen.tbds182));
            this.f41999j.M(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f41999j.D(getResources().getString(R.string.live_sub_tab_no_more_data));
            this.f41999j.f();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void forceRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.forceRefresh();
            BdTypeListView bdTypeListView = this.f41998i;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.f41998i.startPullRefresh();
            }
        }
    }

    public final void hideNetRefreshView() {
        BdTypeListView bdTypeListView;
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bdTypeListView = this.f41998i) == null || (hVar = this.l) == null) {
            return;
        }
        this.p = false;
        bdTypeListView.removeHeaderView(hVar.b());
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void notifyDataSetChanged() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bdTypeListView = this.f41998i) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.k;
            if (gVar != null) {
                gVar.C(i2);
            }
            PbListView pbListView = this.f41999j;
            if (pbListView != null) {
                pbListView.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f41999j.d(i2);
            }
            SkinManager.setBackgroundColor(this.f41998i, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments == null || arguments.getParcelable(TAB_ORIGIN_TAB_INFO) == null) {
                i2 = 0;
            } else {
                SpecialLiveTabInfo specialLiveTabInfo = (SpecialLiveTabInfo) arguments.getParcelable(TAB_ORIGIN_TAB_INFO);
                if (specialLiveTabInfo.tabType == 2) {
                    this.r = "游戏";
                    this.s = specialLiveTabInfo.tabName;
                } else {
                    this.r = specialLiveTabInfo.tabName;
                }
                i2 = specialLiveTabInfo.tabId;
            }
            if (arguments != null) {
                this.t = arguments.getString("forum_id");
                this.u = arguments.getString("forum_name");
            }
            if (this.n == null) {
                AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(getPageContext());
                this.n = alaNewSquareSubListModel;
                alaNewSquareSubListModel.R(this.v);
            }
            this.n.setTabId(i2);
            this.n.setEntryName(this.r);
            this.n.setLabelName(this.s);
            this.n.S(false);
            if (this.m == null) {
                e eVar = new e(getPageContext());
                this.m = eVar;
                eVar.c0(1);
                this.m.d0(new a(this));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f41997h == null) {
                View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
                this.f41997h = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
                this.f41998i = bdTypeListView;
                bdTypeListView.setOnSrollToBottomListener(this.w);
                g gVar = new g(getPageContext());
                this.k = gVar;
                gVar.a(this.x);
                this.f41998i.setPullRefresh(this.k);
                PbListView pbListView = new PbListView(getContext());
                this.f41999j = pbListView;
                pbListView.a();
                this.f41999j.p(R.color.CAM_X0201);
                this.f41999j.t(n.f(getContext(), R.dimen.tbds182));
                this.f41999j.y();
                this.f41999j.H(R.dimen.tbfontsize33);
                this.f41999j.F(SkinManager.getColor(R.color.CAM_X0107));
                this.f41999j.B(R.color.CAM_X0110);
                this.f41999j.b().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.m);
                this.f41998i.addAdapters(arrayList);
            }
            if (this.f41997h.getParent() != null) {
                ((ViewGroup) this.f41997h.getParent()).removeView(this.f41997h);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f41997h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            BdTypeListView bdTypeListView = this.f41998i;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f41998i.setScrollable(null);
            }
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.n;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
            }
            hideLoadingView(this.f41997h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onNetRefreshButtonClicked();
            A();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.q) {
                A();
            }
        }
    }

    public void setIsRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || z) {
            return;
        }
        this.f41998i.completePullRefresh();
    }

    public final void showNetRefreshView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.l == null) {
                h hVar = new h(getPageContext().getContext(), getNetRefreshListener());
                this.l = hVar;
                hVar.n(null);
                this.l.g(null);
                this.l.p();
                this.l.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.l.m(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
            this.l.onChangeSkinType();
            if (this.p) {
                return;
            }
            this.f41998i.addHeaderView(this.l.b(), 0);
            this.p = true;
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f41998i.setNextPage(this.f41999j);
            this.f41999j.t(n.f(getContext(), R.dimen.tbds182));
            this.f41999j.l(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void y(TbPageContext<?> tbPageContext, e2 e2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048591, this, tbPageContext, e2Var, str) == null) || tbPageContext == null || e2Var == null || e2Var.J() == null || e2Var.o1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = e2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(e2Var.o1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (e2 e2Var2 : this.n.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(z(e2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_SUB_TAB, str2, z, str, null)));
    }

    public final AlaLiveInfoCoreData z(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, e2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(e2Var.o1());
            alaLiveInfoCoreData.userName = e2Var.J().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }
}
