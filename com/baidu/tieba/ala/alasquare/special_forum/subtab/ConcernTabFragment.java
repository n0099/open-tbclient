package com.baidu.tieba.ala.alasquare.special_forum.subtab;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.h0.d0.h;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ConcernTabFragment extends SpecialForumTabBaseFragment {

    /* renamed from: h  reason: collision with root package name */
    public View f14537h;
    public BdTypeRecyclerView i;
    public BdSwipeRefreshLayout j;
    public PbListView k;
    public g l;
    public h m;
    public e n;
    public SpecialConcernTabModel o;
    public boolean r;
    public boolean p = true;
    public boolean q = false;
    public CustomMessageListener s = new a(2005016);
    public SpecialConcernTabModel.b t = new b();
    public BdListView.p u = new c();
    public final f.g v = new d();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || ConcernTabFragment.this.o == null || TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                return;
            }
            ConcernTabFragment.this.Y0();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SpecialConcernTabModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void a(int i, String str) {
            ConcernTabFragment concernTabFragment = ConcernTabFragment.this;
            concernTabFragment.hideLoadingView(concernTabFragment.f14537h);
            ConcernTabFragment.this.V0();
            ConcernTabFragment.this.b1();
        }

        @Override // com.baidu.tieba.ala.alasquare.special_forum.model.SpecialConcernTabModel.b
        public void b(List<n> list, boolean z, int i) {
            ConcernTabFragment.this.p = z;
            ConcernTabFragment.this.r = true;
            ConcernTabFragment.this.Z0(false);
            ConcernTabFragment concernTabFragment = ConcernTabFragment.this;
            concernTabFragment.hideLoadingView(concernTabFragment.f14537h);
            if (ListUtils.getCount(list) == 0) {
                ConcernTabFragment.this.b1();
            } else {
                ConcernTabFragment.this.i.setData(list);
                if (!ConcernTabFragment.this.p) {
                    ConcernTabFragment.this.c1();
                } else {
                    ConcernTabFragment.this.a1();
                }
                ConcernTabFragment.this.W0();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_SPECIAL_CONCERN_TAB_TAB_ICON, Boolean.valueOf(i > 0)));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.p {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (!l.C()) {
                ConcernTabFragment.this.V0();
            } else if (ConcernTabFragment.this.p) {
                ConcernTabFragment.this.o.x();
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
                ConcernTabFragment.this.o.y();
            } else {
                ConcernTabFragment.this.Z0(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public d.b.i0.t.d.f.b.a f14542a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.i0.t.d.f.b.b f14543b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.i0.t.d.f.b.c f14544c;

        /* renamed from: d  reason: collision with root package name */
        public List<d.b.c.j.e.a> f14545d = new LinkedList();

        /* loaded from: classes4.dex */
        public class a implements w {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ConcernTabFragment f14547e;

            public a(ConcernTabFragment concernTabFragment) {
                this.f14547e = concernTabFragment;
            }

            @Override // d.b.c.j.e.w
            public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                if (nVar == null || !(nVar instanceof d.b.i0.t.d.f.c.f)) {
                    return;
                }
                d.b.i0.t.d.f.c.f fVar = (d.b.i0.t.d.f.c.f) nVar;
                if (fVar.f62106f == null) {
                    return;
                }
                if (!l.C()) {
                    ConcernTabFragment.this.getPageContext().showToast(R.string.neterror);
                    return;
                }
                if (fVar.f62107g) {
                    TiebaStatic.log(new StatisticItem("c12896"));
                } else {
                    TiebaStatic.log(new StatisticItem("c12894"));
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(fVar.f62106f);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(ConcernTabFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SPECIAL_CONCERN_TAB, TbadkCoreApplication.getCurrentAccount(), false, "")));
            }
        }

        public e() {
            this.f14542a = new d.b.i0.t.d.f.b.a(ConcernTabFragment.this.getPageContext());
            this.f14543b = new d.b.i0.t.d.f.b.b(ConcernTabFragment.this.getPageContext());
            this.f14544c = new d.b.i0.t.d.f.b.c(ConcernTabFragment.this.getPageContext());
            this.f14543b.c0(new a(ConcernTabFragment.this));
            this.f14545d.add(this.f14542a);
            this.f14545d.add(this.f14543b);
            this.f14545d.add(this.f14544c);
        }
    }

    public static ConcernTabFragment X0(int i) {
        return new ConcernTabFragment();
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void E() {
        super.E();
        BdTypeRecyclerView bdTypeRecyclerView = this.i;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.j;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment
    public void G0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.i;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public final void V0() {
        this.i.setNextPage(null);
    }

    public final void W0() {
        h hVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.i;
        if (bdTypeRecyclerView != null && (hVar = this.m) != null) {
            bdTypeRecyclerView.removeHeaderView(hVar.b());
        }
        this.q = false;
    }

    public final void Y0() {
        this.o.y();
        showLoadingView(this.f14537h, false, getResources().getDimensionPixelSize(R.dimen.ds230));
    }

    public void Z0(boolean z) {
        if (z) {
            return;
        }
        this.j.setRefreshing(false);
    }

    public final void a1() {
        this.i.setNextPage(this.k);
        this.k.O();
    }

    public final void b1() {
        if (this.m == null) {
            h hVar = new h(getPageContext().getContext(), getNetRefreshListener());
            this.m = hVar;
            hVar.m(null);
            this.m.g(null);
            this.m.o();
            this.m.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.m.l(getPageContext().getResources().getString(R.string.square_sub_list_no_data));
        this.m.onChangeSkinType();
        if (!this.q) {
            this.i.t(this.m.b(), 0);
        }
        this.q = true;
    }

    public final void c1() {
        this.i.setNextPage(this.k);
        this.k.A(getResources().getString(R.string.list_no_more));
        this.k.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        g gVar = this.l;
        if (gVar != null) {
            gVar.I(i);
        }
        PbListView pbListView = this.k;
        if (pbListView != null) {
            pbListView.C(SkinManager.getColor(R.color.CAM_X0107));
            this.k.d(i);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.i;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
        }
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.o == null) {
            SpecialConcernTabModel specialConcernTabModel = new SpecialConcernTabModel(getPageContext());
            this.o = specialConcernTabModel;
            specialConcernTabModel.z(this.t);
        }
        MessageManager.getInstance().registerListener(this.s);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f14537h == null) {
            View inflate = layoutInflater.inflate(R.layout.special_bar_concern_tab, viewGroup, false);
            this.f14537h = inflate;
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) inflate.findViewById(R.id.content_thread);
            this.i = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            this.i.setFadingEdgeLength(0);
            this.i.setOverScrollMode(2);
            this.i.setOnSrollToBottomListener(this.u);
            g gVar = new g(getPageContext());
            this.l = gVar;
            gVar.b(this.v);
            PbListView pbListView = new PbListView(getContext());
            this.k = pbListView;
            pbListView.a();
            this.k.o(R.color.CAM_X0201);
            this.k.r(l.g(getContext(), R.dimen.tbds182));
            this.k.v();
            this.k.E(R.dimen.tbfontsize33);
            this.k.C(SkinManager.getColor(R.color.CAM_X0107));
            this.k.y(R.color.CAM_X0110);
            this.k.b().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f14537h.findViewById(R.id.pull_refresh_layout);
            this.j = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.l);
            e eVar = new e();
            this.n = eVar;
            this.i.a(eVar.f14545d);
        }
        if (this.f14537h.getParent() != null) {
            ((ViewGroup) this.f14537h.getParent()).removeView(this.f14537h);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (TbadkCoreApplication.isLogin()) {
            Y0();
        }
        return this.f14537h;
    }

    @Override // com.baidu.tieba.ala.alasquare.special_forum.subtab.SpecialForumTabBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.i.setOnSrollToBottomListener(null);
        this.i.setScrollable(null);
        this.o.onDestroy();
        hideLoadingView(this.f14537h);
        MessageManager.getInstance().unRegisterListener(this.s);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        Y0();
    }
}
