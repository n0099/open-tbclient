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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.d0.h;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.r0.r.q.b2;
import d.a.s0.v.d.f.b.e;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f14077h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f14078i;
    public PbListView j;
    public g k;
    public h l;
    public e m;
    public AlaNewSquareSubListModel n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public String s;
    public AlaNewSquareSubListModel.b t;
    public BdListView.p u;
    public final f.g v;

    /* loaded from: classes5.dex */
    public class a implements d.a.s0.v.d.g.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtherSubTabFragment f14079a;

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
            this.f14079a = otherSubTabFragment;
        }

        @Override // d.a.s0.v.d.g.d.f
        public void a(int i2, String str, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, b2Var) == null) {
                if (b2Var != null && b2Var.g1() != null && b2Var.g1().isLegalYYLiveData()) {
                    String str2 = YYLiveUtil.SOURCE_BAIDU_LIVE_CARD_ + i2;
                    AlaInfoData g1 = b2Var.g1();
                    TbPageContext<BaseFragmentActivity> pageContext = this.f14079a.getPageContext();
                    YyExtData yyExtData = g1.mYyExtData;
                    YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + g1.roomId, str2);
                } else {
                    OtherSubTabFragment otherSubTabFragment = this.f14079a;
                    otherSubTabFragment.Z0(otherSubTabFragment.getPageContext(), b2Var, str);
                }
                if (b2Var == null || StringUtils.isNull(str)) {
                    return;
                }
                StatisticItem param = new StatisticItem("c12904").param("tid", b2Var.n1()).param(TiebaStatic.Params.ENTRY_NAME, str);
                TiebaStaticHelper.addYYParam(param);
                TiebaStatic.log(param);
            }
        }

        @Override // d.a.s0.v.d.g.d.f
        public void b(d.a.s0.v.d.g.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OtherSubTabFragment f14080a;

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
            this.f14080a = otherSubTabFragment;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f14080a.o = z;
                this.f14080a.q = true;
                this.f14080a.d1(false);
                OtherSubTabFragment otherSubTabFragment = this.f14080a;
                otherSubTabFragment.hideLoadingView(otherSubTabFragment.f14077h);
                if (ListUtils.getCount(this.f14080a.n.J()) == 0) {
                    this.f14080a.f1();
                    return;
                }
                this.f14080a.f14078i.setData(this.f14080a.n.J());
                if (!this.f14080a.o) {
                    this.f14080a.g1();
                } else {
                    this.f14080a.e1();
                }
                this.f14080a.Y0();
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                OtherSubTabFragment otherSubTabFragment = this.f14080a;
                otherSubTabFragment.hideLoadingView(otherSubTabFragment.f14077h);
                this.f14080a.X0();
                this.f14080a.f1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OtherSubTabFragment f14081e;

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
            this.f14081e = otherSubTabFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!l.D()) {
                    this.f14081e.X0();
                } else if (this.f14081e.o) {
                    this.f14081e.n.P();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OtherSubTabFragment f14082e;

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
            this.f14082e = otherSubTabFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (j.z()) {
                    this.f14082e.n.Q();
                } else {
                    this.f14082e.d1(false);
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
        this.t = new b(this);
        this.u = new c(this);
        this.v = new d(this);
    }

    public static OtherSubTabFragment a1(int i2, SpecialLiveTabInfo specialLiveTabInfo) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65551, null, i2, specialLiveTabInfo)) == null) {
            OtherSubTabFragment otherSubTabFragment = new OtherSubTabFragment();
            if (specialLiveTabInfo != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("tab_origin_tab_position", i2);
                bundle.putParcelable("tab_origin_tab_info", specialLiveTabInfo);
                otherSubTabFragment.setArguments(bundle);
            }
            return otherSubTabFragment;
        }
        return (OtherSubTabFragment) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void I0() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdTypeListView = this.f14078i) == null) {
            return;
        }
        bdTypeListView.getAdapter2().notifyDataSetChanged();
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14078i.setNextPage(this.j);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.k(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
    }

    public final void Y0() {
        BdTypeListView bdTypeListView;
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bdTypeListView = this.f14078i) == null || (hVar = this.l) == null) {
            return;
        }
        this.p = false;
        bdTypeListView.removeHeaderView(hVar.b());
    }

    public final void Z0(TbPageContext<?> tbPageContext, b2 b2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, b2Var, str) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = b2Var.H().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (b2 b2Var2 : this.n.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(b1(b2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_SUB_TAB, str2, z, str, null)));
    }

    public final AlaLiveInfoCoreData b1(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
            alaLiveInfoCoreData.userName = b2Var.H().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.q = false;
            this.n.Q();
            showLoadingView(this.f14077h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
        }
    }

    public void d1(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || z) {
            return;
        }
        this.f14078i.z();
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f14078i.setNextPage(this.j);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.j.O();
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.l == null) {
                h hVar = new h(getPageContext().getContext(), getNetRefreshListener());
                this.l = hVar;
                hVar.m(null);
                this.l.g(null);
                this.l.o();
                this.l.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            this.l.l(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
            this.l.onChangeSkinType();
            if (this.p) {
                return;
            }
            this.f14078i.x(this.l.b(), 0);
            this.p = true;
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f14078i.setNextPage(this.j);
            this.j.r(l.g(getContext(), R.dimen.tbds182));
            this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.j.A(getResources().getString(R.string.live_sub_tab_no_more_data));
            this.j.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            g gVar = this.k;
            if (gVar != null) {
                gVar.I(i2);
            }
            PbListView pbListView = this.j;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
                this.j.d(i2);
            }
            SkinManager.setBackgroundColor(this.f14078i, R.color.CAM_X0201);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments == null || arguments.getParcelable("tab_origin_tab_info") == null) {
                i2 = 0;
            } else {
                SpecialLiveTabInfo specialLiveTabInfo = (SpecialLiveTabInfo) arguments.getParcelable("tab_origin_tab_info");
                if (specialLiveTabInfo.tabType == 2) {
                    this.r = "游戏";
                    this.s = specialLiveTabInfo.tabName;
                } else {
                    this.r = specialLiveTabInfo.tabName;
                }
                i2 = specialLiveTabInfo.tabId;
            }
            if (this.n == null) {
                AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(getPageContext());
                this.n = alaNewSquareSubListModel;
                alaNewSquareSubListModel.R(this.t);
            }
            this.n.setTabId(i2);
            this.n.setEntryName(this.r);
            this.n.setLabelName(this.s);
            this.n.S(false);
            if (this.m == null) {
                e eVar = new e(getPageContext());
                this.m = eVar;
                eVar.h0(1);
                this.m.i0(new a(this));
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f14077h == null) {
                View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
                this.f14077h = inflate;
                BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
                this.f14078i = bdTypeListView;
                bdTypeListView.setOnSrollToBottomListener(this.u);
                g gVar = new g(getPageContext());
                this.k = gVar;
                gVar.a(this.v);
                this.f14078i.setPullRefresh(this.k);
                PbListView pbListView = new PbListView(getContext());
                this.j = pbListView;
                pbListView.a();
                this.j.o(R.color.CAM_X0201);
                this.j.r(l.g(getContext(), R.dimen.tbds182));
                this.j.v();
                this.j.E(R.dimen.tbfontsize33);
                this.j.C(SkinManager.getColor(R.color.CAM_X0107));
                this.j.y(R.color.CAM_X0110);
                this.j.b().setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.m);
                this.f14078i.a(arrayList);
            }
            if (this.f14077h.getParent() != null) {
                ((ViewGroup) this.f14077h.getParent()).removeView(this.f14077h);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return this.f14077h;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            BdTypeListView bdTypeListView = this.f14078i;
            if (bdTypeListView != null) {
                bdTypeListView.setOnSrollToBottomListener(null);
                this.f14078i.setScrollable(null);
            }
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.n;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
            }
            hideLoadingView(this.f14077h);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onNetRefreshButtonClicked();
            c1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary() && !this.q) {
                c1();
            }
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.s();
            BdTypeListView bdTypeListView = this.f14078i;
            if (bdTypeListView != null) {
                bdTypeListView.smoothScrollToPosition(0);
                this.f14078i.F();
            }
        }
    }
}
