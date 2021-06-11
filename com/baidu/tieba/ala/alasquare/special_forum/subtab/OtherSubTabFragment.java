package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.d0.h;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.f.b.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {

    /* renamed from: h  reason: collision with root package name */
    public View f13908h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f13909i;
    public PbListView j;
    public g k;
    public h l;
    public e m;
    public AlaNewSquareSubListModel n;
    public String r;
    public String s;
    public boolean o = true;
    public boolean p = false;
    public boolean q = false;
    public AlaNewSquareSubListModel.b t = new b();
    public BdListView.p u = new c();
    public final f.g v = new d();

    /* loaded from: classes4.dex */
    public class a implements d.a.n0.v.d.g.d.f {
        public a() {
        }

        @Override // d.a.n0.v.d.g.d.f
        public void a(int i2, String str, a2 a2Var) {
            if (a2Var != null && a2Var.s1() != null && a2Var.s1().isLegalYYLiveData()) {
                String str2 = YYLiveUtil.SOURCE_BAIDU_LIVE_CARD_ + i2;
                AlaInfoData s1 = a2Var.s1();
                TbPageContext<BaseFragmentActivity> pageContext = OtherSubTabFragment.this.getPageContext();
                YyExtData yyExtData = s1.mYyExtData;
                YYLiveUtil.jumpToYYLiveRoom(pageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + s1.roomId, str2);
            } else {
                OtherSubTabFragment otherSubTabFragment = OtherSubTabFragment.this;
                otherSubTabFragment.Z0(otherSubTabFragment.getPageContext(), a2Var, str);
            }
            if (a2Var == null || StringUtils.isNull(str)) {
                return;
            }
            StatisticItem param = new StatisticItem("c12904").param("tid", a2Var.z1()).param(TiebaStatic.Params.ENTRY_NAME, str);
            TiebaStaticHelper.addYYParam(param);
            TiebaStatic.log(param);
        }

        @Override // d.a.n0.v.d.g.d.f
        public void b(d.a.n0.v.d.g.b.c cVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i2, String str) {
            OtherSubTabFragment otherSubTabFragment = OtherSubTabFragment.this;
            otherSubTabFragment.hideLoadingView(otherSubTabFragment.f13908h);
            OtherSubTabFragment.this.X0();
            OtherSubTabFragment.this.f1();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            OtherSubTabFragment.this.o = z;
            OtherSubTabFragment.this.q = true;
            OtherSubTabFragment.this.d1(false);
            OtherSubTabFragment otherSubTabFragment = OtherSubTabFragment.this;
            otherSubTabFragment.hideLoadingView(otherSubTabFragment.f13908h);
            if (ListUtils.getCount(OtherSubTabFragment.this.n.J()) == 0) {
                OtherSubTabFragment.this.f1();
                return;
            }
            OtherSubTabFragment.this.f13909i.setData(OtherSubTabFragment.this.n.J());
            if (!OtherSubTabFragment.this.o) {
                OtherSubTabFragment.this.g1();
            } else {
                OtherSubTabFragment.this.e1();
            }
            OtherSubTabFragment.this.Y0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!l.D()) {
                OtherSubTabFragment.this.X0();
            } else if (OtherSubTabFragment.this.o) {
                OtherSubTabFragment.this.n.P();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                OtherSubTabFragment.this.n.Q();
            } else {
                OtherSubTabFragment.this.d1(false);
            }
        }
    }

    public static OtherSubTabFragment a1(int i2, SpecialLiveTabInfo specialLiveTabInfo) {
        OtherSubTabFragment otherSubTabFragment = new OtherSubTabFragment();
        if (specialLiveTabInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_origin_tab_position", i2);
            bundle.putParcelable("tab_origin_tab_info", specialLiveTabInfo);
            otherSubTabFragment.setArguments(bundle);
        }
        return otherSubTabFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void I0() {
        BdTypeListView bdTypeListView = this.f13909i;
        if (bdTypeListView != null) {
            bdTypeListView.getAdapter2().notifyDataSetChanged();
        }
    }

    public final void X0() {
        this.f13909i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.k(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public final void Y0() {
        h hVar;
        BdTypeListView bdTypeListView = this.f13909i;
        if (bdTypeListView == null || (hVar = this.l) == null) {
            return;
        }
        this.p = false;
        bdTypeListView.removeHeaderView(hVar.b());
    }

    public final void Z0(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = a2Var.T().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (a2 a2Var2 : this.n.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(b1(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_SUB_TAB, str2, z, str, null)));
    }

    public final AlaLiveInfoCoreData b1(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public final void c1() {
        this.q = false;
        this.n.Q();
        showLoadingView(this.f13908h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    public void d1(boolean z) {
        if (z) {
            return;
        }
        this.f13909i.z();
    }

    public final void e1() {
        this.f13909i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.O();
    }

    public final void f1() {
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
        this.f13909i.x(this.l.b(), 0);
        this.p = true;
    }

    public final void g1() {
        this.f13909i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.A(getResources().getString(R.string.live_sub_tab_no_more_data));
        this.j.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
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
        SkinManager.setBackgroundColor(this.f13909i, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i2;
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
            this.m.i0(new a());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f13908h == null) {
            View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.f13908h = inflate;
            BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
            this.f13909i = bdTypeListView;
            bdTypeListView.setOnSrollToBottomListener(this.u);
            g gVar = new g(getPageContext());
            this.k = gVar;
            gVar.a(this.v);
            this.f13909i.setPullRefresh(this.k);
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
            this.f13909i.a(arrayList);
        }
        if (this.f13908h.getParent() != null) {
            ((ViewGroup) this.f13908h.getParent()).removeView(this.f13908h);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.f13908h;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BdTypeListView bdTypeListView = this.f13909i;
        if (bdTypeListView != null) {
            bdTypeListView.setOnSrollToBottomListener(null);
            this.f13909i.setScrollable(null);
        }
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.n;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
        }
        hideLoadingView(this.f13908h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        c1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.q) {
            c1();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void u() {
        super.u();
        BdTypeListView bdTypeListView = this.f13909i;
        if (bdTypeListView != null) {
            bdTypeListView.smoothScrollToPosition(0);
            this.f13909i.F();
        }
    }
}
