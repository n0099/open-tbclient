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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.data.SpecialLiveTabInfo;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.h0.r.q.a2;
import d.b.i0.t.d.f.b.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class OtherSubTabFragment extends SpecialForumTabBaseFragment {

    /* renamed from: h  reason: collision with root package name */
    public View f14890h;
    public BdTypeListView i;
    public PbListView j;
    public g k;
    public h l;
    public f m;
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
    public class a implements d.b.i0.t.d.g.d.g {
        public a() {
        }

        @Override // d.b.i0.t.d.g.d.g
        public void a(int i, String str, a2 a2Var) {
            OtherSubTabFragment otherSubTabFragment = OtherSubTabFragment.this;
            otherSubTabFragment.X0(otherSubTabFragment.getPageContext(), a2Var, str);
            if (a2Var == null || StringUtils.isNull(str)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12904").param("tid", a2Var.w1()).param(TiebaStatic.Params.ENTRY_NAME, str));
        }

        @Override // d.b.i0.t.d.g.d.g
        public void b(d.b.i0.t.d.g.b.c cVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(int i, String str) {
            OtherSubTabFragment otherSubTabFragment = OtherSubTabFragment.this;
            otherSubTabFragment.hideLoadingView(otherSubTabFragment.f14890h);
            OtherSubTabFragment.this.V0();
            OtherSubTabFragment.this.d1();
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void b(boolean z) {
            OtherSubTabFragment.this.o = z;
            OtherSubTabFragment.this.q = true;
            OtherSubTabFragment.this.b1(false);
            OtherSubTabFragment otherSubTabFragment = OtherSubTabFragment.this;
            otherSubTabFragment.hideLoadingView(otherSubTabFragment.f14890h);
            if (ListUtils.getCount(OtherSubTabFragment.this.n.F()) == 0) {
                OtherSubTabFragment.this.d1();
                return;
            }
            OtherSubTabFragment.this.i.setData(OtherSubTabFragment.this.n.F());
            if (!OtherSubTabFragment.this.o) {
                OtherSubTabFragment.this.e1();
            } else {
                OtherSubTabFragment.this.c1();
            }
            OtherSubTabFragment.this.W0();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!l.C()) {
                OtherSubTabFragment.this.V0();
            } else if (OtherSubTabFragment.this.o) {
                OtherSubTabFragment.this.n.L();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                OtherSubTabFragment.this.n.M();
            } else {
                OtherSubTabFragment.this.b1(false);
            }
        }
    }

    public static OtherSubTabFragment Y0(int i, SpecialLiveTabInfo specialLiveTabInfo) {
        OtherSubTabFragment otherSubTabFragment = new OtherSubTabFragment();
        if (specialLiveTabInfo != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab_origin_tab_position", i);
            bundle.putParcelable("tab_origin_tab_info", specialLiveTabInfo);
            otherSubTabFragment.setArguments(bundle);
        }
        return otherSubTabFragment;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void E() {
        super.E();
        BdTypeListView bdTypeListView = this.i;
        if (bdTypeListView != null) {
            bdTypeListView.smoothScrollToPosition(0);
            this.i.F();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void G0() {
        BdTypeListView bdTypeListView = this.i;
        if (bdTypeListView != null) {
            bdTypeListView.getAdapter2().notifyDataSetChanged();
        }
    }

    public final void V0() {
        this.i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.k(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public final void W0() {
        h hVar;
        BdTypeListView bdTypeListView = this.i;
        if (bdTypeListView == null || (hVar = this.l) == null) {
            return;
        }
        this.p = false;
        bdTypeListView.removeHeaderView(hVar.b());
    }

    public final void X0(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (a2 a2Var2 : this.n.H()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(Z0(a2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_SUB_TAB, str2, z, str, null)));
    }

    public final AlaLiveInfoCoreData Z0(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public final void a1() {
        this.q = false;
        this.n.M();
        showLoadingView(this.f14890h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    public void b1(boolean z) {
        if (z) {
            return;
        }
        this.i.z();
    }

    public final void c1() {
        this.i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.O();
    }

    public final void d1() {
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
        this.i.x(this.l.b(), 0);
        this.p = true;
    }

    public final void e1() {
        this.i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.A(getResources().getString(R.string.list_no_more));
        this.j.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        g gVar = this.k;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.j;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.j.d(i);
        }
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getParcelable("tab_origin_tab_info") != null) {
            SpecialLiveTabInfo specialLiveTabInfo = (SpecialLiveTabInfo) arguments.getParcelable("tab_origin_tab_info");
            int i = specialLiveTabInfo.tabType;
            if (i == 1) {
                this.r = specialLiveTabInfo.tabName;
            } else if (i == 2) {
                this.r = "游戏";
                this.s = specialLiveTabInfo.tabName;
            }
        }
        if (this.n == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(getPageContext());
            this.n = alaNewSquareSubListModel;
            alaNewSquareSubListModel.N(this.t);
        }
        this.n.setEntryName(this.r);
        this.n.setLabelName(this.s);
        this.n.O(false);
        if (this.m == null) {
            d.b.i0.t.d.f.b.f fVar = new d.b.i0.t.d.f.b.f(getPageContext());
            this.m = fVar;
            fVar.j0(1);
            this.m.l0(new a());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f14890h == null) {
            View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.f14890h = inflate;
            BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
            this.i = bdTypeListView;
            bdTypeListView.setOnSrollToBottomListener(this.u);
            g gVar = new g(getPageContext());
            this.k = gVar;
            gVar.b(this.v);
            this.i.setPullRefresh(this.k);
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
            this.i.a(arrayList);
        }
        if (this.f14890h.getParent() != null) {
            ((ViewGroup) this.f14890h.getParent()).removeView(this.f14890h);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.f14890h;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BdTypeListView bdTypeListView = this.i;
        if (bdTypeListView != null) {
            bdTypeListView.setOnSrollToBottomListener(null);
            this.i.setScrollable(null);
        }
        AlaNewSquareSubListModel alaNewSquareSubListModel = this.n;
        if (alaNewSquareSubListModel != null) {
            alaNewSquareSubListModel.onDestroy();
        }
        hideLoadingView(this.f14890h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        a1();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.q) {
            a1();
        }
    }
}
