package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.n0.d0.h;
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import d.a.n0.r.q.a2;
import d.a.o0.v.d.f.b.e;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendTabFragment extends SpecialForumTabBaseFragment {

    /* renamed from: h  reason: collision with root package name */
    public View f13996h;

    /* renamed from: i  reason: collision with root package name */
    public BdTypeListView f13997i;
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
            recommendTabFragment.hideLoadingView(recommendTabFragment.f13996h);
            RecommendTabFragment.this.W0();
            RecommendTabFragment.this.c1();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialRecommendTabModel.b
        public void b(List<n> list, boolean z) {
            RecommendTabFragment.this.o = z;
            RecommendTabFragment.this.q = true;
            if (!ListUtils.isEmpty(list)) {
                RecommendTabFragment.this.f13997i.setData(list);
            }
            if (!RecommendTabFragment.this.o) {
                RecommendTabFragment.this.d1();
            } else {
                RecommendTabFragment.this.b1();
            }
            RecommendTabFragment.this.a1(false);
            RecommendTabFragment recommendTabFragment = RecommendTabFragment.this;
            recommendTabFragment.hideLoadingView(recommendTabFragment.f13996h);
            RecommendTabFragment.this.X0();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!l.D()) {
                RecommendTabFragment.this.W0();
            } else if (RecommendTabFragment.this.o) {
                RecommendTabFragment.this.n.H();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (j.z()) {
                RecommendTabFragment.this.n.I();
            } else {
                RecommendTabFragment.this.a1(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public e f14001a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.o0.v.d.f.b.d f14002b;

        /* renamed from: c  reason: collision with root package name */
        public List<d.a.c.k.e.a> f14003c = new LinkedList();

        /* loaded from: classes4.dex */
        public class a implements d.a.o0.v.d.g.d.f {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ RecommendTabFragment f14005a;

            public a(RecommendTabFragment recommendTabFragment) {
                this.f14005a = recommendTabFragment;
            }

            @Override // d.a.o0.v.d.g.d.f
            public void a(int i2, String str, a2 a2Var) {
                if (a2Var != null && a2Var.s1() != null && a2Var.s1().isLegalYYLiveData()) {
                    AlaInfoData s1 = a2Var.s1();
                    TbPageContext<BaseFragmentActivity> pageContext = RecommendTabFragment.this.getPageContext();
                    YyExtData yyExtData = s1.mYyExtData;
                    String str2 = yyExtData.mSid;
                    String str3 = yyExtData.mSsid;
                    String str4 = yyExtData.mTemplateId;
                    YYLiveUtil.jumpToYYLiveRoom(pageContext, str2, str3, str4, "" + s1.roomId, "baidu_live_zhibo_block_1");
                }
                if (a2Var != null) {
                    StatisticItem param = new StatisticItem("c12900").param("tid", a2Var.z1());
                    TiebaStaticHelper.addYYParam(param);
                    TiebaStatic.log(param);
                }
            }

            @Override // d.a.o0.v.d.g.d.f
            public void b(d.a.o0.v.d.g.b.c cVar) {
            }
        }

        public d() {
            this.f14002b = new d.a.o0.v.d.f.b.d(RecommendTabFragment.this.getPageContext());
            e eVar = new e(RecommendTabFragment.this.getPageContext());
            this.f14001a = eVar;
            eVar.h0(2);
            this.f14003c.add(this.f14002b);
            this.f14003c.add(this.f14001a);
            this.f14001a.i0(new a(RecommendTabFragment.this));
        }
    }

    public static RecommendTabFragment Y0(int i2) {
        return new RecommendTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void I0() {
        BdTypeListView bdTypeListView = this.f13997i;
        if (bdTypeListView != null) {
            bdTypeListView.getAdapter2().notifyDataSetChanged();
        }
    }

    public final void W0() {
        this.f13997i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.k(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public final void X0() {
        h hVar;
        BdTypeListView bdTypeListView = this.f13997i;
        if (bdTypeListView != null && (hVar = this.l) != null) {
            bdTypeListView.removeHeaderView(hVar.b());
        }
        this.p = false;
    }

    public final void Z0() {
        this.q = false;
        this.n.I();
        showLoadingView(this.f13996h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    public void a1(boolean z) {
        if (z) {
            return;
        }
        this.f13997i.z();
    }

    public final void b1() {
        this.f13997i.setNextPage(this.j);
        this.j.r(l.g(getContext(), R.dimen.tbds182));
        this.j.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.j.O();
    }

    public final void c1() {
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
            this.f13997i.x(this.l.b(), 0);
        }
        this.p = true;
    }

    public final void d1() {
        this.f13997i.setNextPage(this.j);
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
        SkinManager.setBackgroundColor(this.f13997i, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.n == null) {
            SpecialRecommendTabModel specialRecommendTabModel = new SpecialRecommendTabModel(getPageContext());
            this.n = specialRecommendTabModel;
            specialRecommendTabModel.J(this.r);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f13996h == null) {
            View inflate = layoutInflater.inflate(R.layout.special_bar_recommend_tab, viewGroup, false);
            this.f13996h = inflate;
            BdTypeListView bdTypeListView = (BdTypeListView) inflate.findViewById(R.id.content_thread);
            this.f13997i = bdTypeListView;
            bdTypeListView.setFadingEdgeLength(0);
            this.f13997i.setOverScrollMode(2);
            this.f13997i.setScrollable(this);
            this.f13997i.setOnSrollToBottomListener(this.s);
            g gVar = new g(getPageContext());
            this.k = gVar;
            gVar.a(this.t);
            this.f13997i.setPullRefresh(this.k);
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
            this.f13997i.a(dVar.f14003c);
        }
        if (this.f13996h.getParent() != null) {
            ((ViewGroup) this.f13996h.getParent()).removeView(this.f13996h);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return this.f13996h;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13997i.setOnSrollToBottomListener(null);
        this.f13997i.setScrollable(null);
        this.n.onDestroy();
        hideLoadingView(this.f13996h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        Z0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && !this.q) {
            Z0();
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void u() {
        super.u();
        BdTypeListView bdTypeListView = this.f13997i;
        if (bdTypeListView != null) {
            bdTypeListView.smoothScrollToPosition(0);
            this.f13997i.F();
        }
    }
}
