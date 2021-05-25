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
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.m0.d0.h;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.m0.r.q.a2;
import d.a.n0.v.d.f.b.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {

    /* renamed from: h  reason: collision with root package name */
    public View f13857h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f13858i;
    public PbListView j;
    public g k;
    public h l;
    public d m;
    public SpecialRecommendTabModel n;
    public boolean o = true;
    public boolean p = false;
    public boolean q = false;
    public SpecialRecommendTabModel.b r = new a();
    public BdListView.p s = new b();
    public final f.g t = new c();

    /* loaded from: classes4.dex */
    public class a implements SpecialRecommendTabModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void a(int i2, String str) {
            RecommendTabFragment recommendTabFragment = RecommendTabFragment.this;
            recommendTabFragment.hideLoadingView(recommendTabFragment.f13857h);
            RecommendTabFragment.this.T0();
            RecommendTabFragment.this.Z0();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void b(List<n> list, boolean z) {
            RecommendTabFragment.this.o = z;
            RecommendTabFragment.this.q = true;
            if (!ListUtils.isEmpty(list)) {
                RecommendTabFragment.this.f13858i.setData(list);
            }
            if (!RecommendTabFragment.this.o) {
                RecommendTabFragment.this.a1();
            } else {
                RecommendTabFragment.this.Y0();
            }
            RecommendTabFragment.this.X0(false);
            RecommendTabFragment recommendTabFragment = RecommendTabFragment.this;
            recommendTabFragment.hideLoadingView(recommendTabFragment.f13857h);
            RecommendTabFragment.this.U0();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!l.D()) {
                RecommendTabFragment.this.T0();
            } else if (RecommendTabFragment.this.o) {
                RecommendTabFragment.this.n.E();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                RecommendTabFragment.this.n.F();
            } else {
                RecommendTabFragment.this.X0(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public e f13862a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.n0.v.d.f.b.d f13863b;

        /* renamed from: c  reason: collision with root package name */
        public List<d.a.c.j.e.a> f13864c = new LinkedList();

        /* loaded from: classes4.dex */
        public class a implements d.a.n0.v.d.g.d.f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecommendTabFragment f13866a;

            public a(RecommendTabFragment recommendTabFragment) {
                this.f13866a = recommendTabFragment;
            }

            @Override // d.a.n0.v.d.g.d.f
            public void a(int i2, String str, a2 a2Var) {
                d dVar = d.this;
                dVar.c(RecommendTabFragment.this.getPageContext(), a2Var, str);
                if (a2Var != null) {
                    TiebaStatic.log(new StatisticItem("c12900").param("tid", a2Var.y1()));
                }
            }

            @Override // d.a.n0.v.d.g.d.f
            public void b(d.a.n0.v.d.g.b.c cVar) {
            }
        }

        public d() {
            this.f13863b = new d.a.n0.v.d.f.b.d(RecommendTabFragment.this.getPageContext());
            e eVar = new e(RecommendTabFragment.this.getPageContext());
            this.f13862a = eVar;
            eVar.g0(2);
            this.f13864c.add(this.f13863b);
            this.f13864c.add(this.f13862a);
            this.f13862a.h0(new a(RecommendTabFragment.this));
        }

        public final void c(TbPageContext<?> tbPageContext, a2 a2Var, String str) {
            String str2;
            boolean z;
            if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.r1() == null) {
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
            alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (a2 a2Var2 : RecommendTabFragment.this.n.A()) {
                alaLiveInfoListCoreData.mLiveInfoList.add(d(a2Var2));
            }
            Activity pageActivity = tbPageContext.getPageActivity();
            if (!"颜值".equals(str)) {
                str = null;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_RECOMMEND_TAB, str2, z, str, null)));
        }

        public final AlaLiveInfoCoreData d(a2 a2Var) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
            alaLiveInfoCoreData.userName = a2Var.T().getUserName();
            return alaLiveInfoCoreData;
        }
    }

    public static RecommendTabFragment V0(int i2) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void F0() {
        BdTypeListView bdTypeListView = this.f13858i;
        if (bdTypeListView != null) {
            bdTypeListView.getAdapter2().notifyDataSetChanged();
        }
    }

    public final void T0() {
        this.f13858i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.k(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public final void U0() {
        h hVar;
        BdTypeListView bdTypeListView = this.f13858i;
        if (bdTypeListView != null && (hVar = this.l) != null) {
            bdTypeListView.removeHeaderView(hVar.b());
        }
        this.p = false;
    }

    public final void W0() {
        this.q = false;
        this.n.F();
        showLoadingView(this.f13857h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    public void X0(boolean z) {
        if (z) {
            return;
        }
        this.f13858i.z();
    }

    public final void Y0() {
        this.f13858i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.O();
    }

    public final void Z0() {
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
        if (!this.p) {
            this.f13858i.x(this.l.b(), 0);
        }
        this.p = true;
    }

    public final void a1() {
        this.f13858i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.A(getResources().getString(R.string.list_no_more));
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
        SkinManager.setBackgroundColor(this.f13858i, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.n == null) {
            SpecialRecommendTabModel specialRecommendTabModel = new SpecialRecommendTabModel(getPageContext());
            this.n = specialRecommendTabModel;
            specialRecommendTabModel.G(this.r);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f13857h == null) {
            View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.f13857h = inflate;
            BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
            this.f13858i = bdTypeListView;
            bdTypeListView.setFadingEdgeLength(0);
            this.f13858i.setOverScrollMode(2);
            this.f13858i.setScrollable(this);
            this.f13858i.setOnSrollToBottomListener(this.s);
            g gVar = new g(getPageContext());
            this.k = gVar;
            gVar.a(this.t);
            this.f13858i.setPullRefresh(this.k);
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
            d dVar = new d();
            this.m = dVar;
            this.f13858i.a(dVar.f13864c);
        }
        if (this.f13857h.getParent() != null) {
            ((ViewGroup) this.f13857h.getParent()).removeView(this.f13857h);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.f13857h;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13858i.setOnSrollToBottomListener(null);
        this.f13858i.setScrollable(null);
        this.n.onDestroy();
        hideLoadingView(this.f13857h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        W0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.q) {
            W0();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void t() {
        super.t();
        BdTypeListView bdTypeListView = this.f13858i;
        if (bdTypeListView != null) {
            bdTypeListView.smoothScrollToPosition(0);
            this.f13858i.F();
        }
    }
}
