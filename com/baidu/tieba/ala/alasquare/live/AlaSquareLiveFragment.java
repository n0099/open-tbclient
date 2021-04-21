package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment;
import com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel;
import d.b.c.j.e.n;
import d.b.c.j.e.q;
import d.b.i0.r.f0.f;
import d.b.i0.r.q.a2;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {

    /* renamed from: f  reason: collision with root package name */
    public d.b.j0.t.d.b.c.a f14390f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.t.d.b.d.a f14391g;
    public boolean j;
    public AlaSquareRefreshManager l;
    public IAlaSquareTabController m;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.t.d.b.e.a f14389e = null;

    /* renamed from: h  reason: collision with root package name */
    public AlaSquareLiveModel f14392h = null;
    public int i = -1;
    public int k = 0;
    public f.g n = new a();
    public BdListView.p o = new b();
    public BdListView.o p = new c();
    public AbsListView.OnScrollListener q = new d();
    public AlaSquareLiveModel.b r = new e();

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.f14392h != null) {
                AlaSquareLiveFragment.this.f14392h.P();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.f14392h != null) {
                AlaSquareLiveFragment.this.f14392h.O();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements BdListView.o {
        public c() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.o
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AbsListView.OnScrollListener {
        public d() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.i != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.f14391g != null) {
                        AlaSquareLiveFragment.this.f14391g.b();
                        if (AlaSquareLiveFragment.this.f14391g.c() != null) {
                            d.b.j0.t.d.b.b.c c2 = AlaSquareLiveFragment.this.f14391g.c();
                            StatisticItem statisticItem = new StatisticItem("c12644");
                            int i4 = c2.f62248b;
                            if (i4 == 0) {
                                statisticItem.param("obj_type", 1);
                            } else if (i4 == 1) {
                                statisticItem.param("obj_type", 2);
                            }
                            statisticItem.param("tid", c2.f62247a.w1());
                            TiebaStatic.log(statisticItem);
                        }
                    }
                } else if (i != 2) {
                    if (i > 1 && AlaSquareLiveFragment.this.f14391g != null) {
                        AlaSquareLiveFragment.this.f14391g.j();
                    }
                } else {
                    d.b.j0.t.d.d.a.c().b("c12647");
                    if (AlaSquareLiveFragment.this.f14391g != null) {
                        AlaSquareLiveFragment.this.f14391g.j();
                    }
                }
            }
            AlaSquareLiveFragment.this.i = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                d.b.j0.t.d.d.a.c().g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements AlaSquareLiveModel.b {
        public e() {
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.b
        public void a(int i, String str) {
            if (AlaSquareLiveFragment.this.f14389e != null) {
                AlaSquareLiveFragment alaSquareLiveFragment = AlaSquareLiveFragment.this;
                alaSquareLiveFragment.hideLoadingView(alaSquareLiveFragment.f14389e.e());
                AlaSquareLiveFragment.this.f14389e.d();
            }
            if (ListUtils.getCount(AlaSquareLiveFragment.this.f14392h.H()) > 0 && AlaSquareLiveFragment.this.f14389e != null) {
                AlaSquareLiveFragment.this.showToast(str);
                return;
            }
            AlaSquareLiveFragment alaSquareLiveFragment2 = AlaSquareLiveFragment.this;
            alaSquareLiveFragment2.showNetRefreshView(alaSquareLiveFragment2.f14389e.e(), str, false);
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.b
        public void b(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() == null || AlaSquareLiveFragment.this.f14389e == null) {
                return;
            }
            List<n> H = z2 ? null : AlaSquareLiveFragment.this.f14392h.H();
            if (z2 && ListUtils.getCount(H) == 0) {
                return;
            }
            if (z3) {
                AlaSquareLiveFragment.this.f14389e.j(H, z, AlaSquareLiveFragment.this.f14392h.K());
            } else {
                AlaSquareLiveFragment alaSquareLiveFragment = AlaSquareLiveFragment.this;
                alaSquareLiveFragment.hideLoadingView(alaSquareLiveFragment.f14389e.e());
                AlaSquareLiveFragment.this.f14389e.d();
                AlaSquareLiveFragment.this.P0(z2);
                AlaSquareLiveFragment.this.f14389e.j(H, z, AlaSquareLiveFragment.this.f14392h.K());
            }
            if (ListUtils.getCount(H) == 0) {
                AlaSquareLiveFragment alaSquareLiveFragment2 = AlaSquareLiveFragment.this;
                alaSquareLiveFragment2.showNetRefreshView(alaSquareLiveFragment2.f14389e.e(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                return;
            }
            AlaSquareLiveFragment alaSquareLiveFragment3 = AlaSquareLiveFragment.this;
            alaSquareLiveFragment3.hideNetRefreshView(alaSquareLiveFragment3.f14389e.e());
        }
    }

    public AlaSquareLiveFragment() {
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    public void E0() {
        d.b.j0.t.d.b.e.a aVar;
        hideNetRefreshView(this.f14389e.e());
        if (ListUtils.getCount(this.f14392h.H()) == 0 && (aVar = this.f14389e) != null) {
            showLoadingView(aVar.e());
        }
        this.f14392h.P();
    }

    public final void O0(boolean z) {
        if (R0(this.f14392h.I())) {
            this.f14390f.h().setVisibility(0);
            this.f14390f.f(this.f14392h.I());
            return;
        }
        d.b.j0.t.d.b.c.a aVar = this.f14390f;
        if (aVar == null || aVar.h() == null) {
            return;
        }
        this.f14389e.f().removeHeaderView(this.f14390f.h());
        this.f14390f.h().setVisibility(8);
    }

    public final void P0(boolean z) {
        if (getPageContext() == null) {
            return;
        }
        if (this.f14391g == null) {
            d.b.j0.t.d.b.d.a aVar = new d.b.j0.t.d.b.d.a(getPageContext());
            this.f14391g = aVar;
            aVar.d().setVisibility(8);
        }
        this.f14389e.f().removeHeaderView(this.f14391g.d());
        this.f14389e.f().x(this.f14391g.d(), 1);
        if (this.f14390f == null) {
            d.b.j0.t.d.b.c.a aVar2 = new d.b.j0.t.d.b.c.a(getPageContext());
            this.f14390f = aVar2;
            aVar2.h().setVisibility(8);
        }
        this.f14389e.f().removeHeaderView(this.f14390f.h());
        this.f14389e.f().x(this.f14390f.h(), 2);
        Q0(z);
        O0(z);
    }

    public final void Q0(boolean z) {
        HeadLiveInfo J = this.f14392h.J();
        if (J != null && !ListUtils.isEmpty(J.head_live)) {
            ThreadInfo threadInfo = J.head_live.get(0);
            AlaLiveInfo alaLiveInfo = threadInfo.ala_info;
            if (alaLiveInfo != null && alaLiveInfo.live_status.intValue() == 1) {
                this.f14391g.d().setVisibility(0);
                d.b.j0.t.d.b.b.c cVar = new d.b.j0.t.d.b.b.c();
                a2 a2Var = new a2();
                a2Var.R2(threadInfo);
                cVar.f62247a = a2Var;
                cVar.f62248b = J.is_set.intValue();
                this.f14391g.f(cVar);
                this.f14391g.b();
                return;
            }
            d.b.j0.t.d.b.d.a aVar = this.f14391g;
            if (aVar == null || aVar.d() == null) {
                return;
            }
            this.f14389e.f().removeHeaderView(this.f14391g.d());
            this.f14391g.d().setVisibility(8);
            return;
        }
        d.b.j0.t.d.b.d.a aVar2 = this.f14391g;
        if (aVar2 == null || aVar2.d() == null) {
            return;
        }
        this.f14389e.f().removeHeaderView(this.f14391g.d());
        this.f14391g.d().setVisibility(8);
    }

    public final boolean R0(List<FunctionListInfo> list) {
        if (!ListUtils.isEmpty(list) && ListUtils.getCount(list) >= 2 && ListUtils.getCount(list) <= 3) {
            int i = 0;
            for (FunctionListInfo functionListInfo : list) {
                if (((1 == functionListInfo.id.intValue() || 3 == functionListInfo.id.intValue()) && !TextUtils.isEmpty(functionListInfo.url)) || 2 == functionListInfo.id.intValue()) {
                    i++;
                }
            }
            return i >= 2;
        }
        return false;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        AlaSquareLiveModel alaSquareLiveModel = this.f14392h;
        if (alaSquareLiveModel != null) {
            return alaSquareLiveModel.G();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a035";
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i) {
        return isAdded() && isPrimary();
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        AlaSquareRefreshManager alaSquareRefreshManager = this.l;
        if (alaSquareRefreshManager != null) {
            alaSquareRefreshManager.reset(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.j0.t.d.b.e.a aVar = this.f14389e;
        if (aVar != null) {
            aVar.i(i);
        }
        d.b.j0.t.d.b.c.a aVar2 = this.f14390f;
        if (aVar2 != null) {
            aVar2.l(i);
        }
        d.b.j0.t.d.b.d.a aVar3 = this.f14391g;
        if (aVar3 != null) {
            aVar3.g();
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14392h = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.r);
        AlaSquareRefreshManager alaSquareRefreshManager = new AlaSquareRefreshManager();
        this.l = alaSquareRefreshManager;
        alaSquareRefreshManager.init(this, new long[]{StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD});
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.k == 0) {
            this.k = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
        }
        d.b.j0.t.d.b.e.a aVar = new d.b.j0.t.d.b.e.a(getPageContext(), getUniqueId(), this.k);
        this.f14389e = aVar;
        aVar.k(this.n);
        this.f14389e.n(this.o);
        this.f14389e.m(this.p, 2000);
        this.f14389e.l(this.q);
        TiebaStatic.log("c12654");
        return this.f14389e.g();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlaSquareRefreshManager alaSquareRefreshManager = this.l;
        if (alaSquareRefreshManager != null) {
            alaSquareRefreshManager.onDestory();
        }
        d.b.j0.t.d.b.c.a aVar = this.f14390f;
        if (aVar != null) {
            aVar.m();
        }
        d.b.j0.t.d.b.d.a aVar2 = this.f14391g;
        if (aVar2 != null) {
            aVar2.h();
        }
        AlaSquareLiveModel alaSquareLiveModel = this.f14392h;
        if (alaSquareLiveModel != null) {
            alaSquareLiveModel.onDestroy();
        }
        this.m = null;
        System.gc();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        d.b.j0.t.d.b.e.a aVar = this.f14389e;
        if (aVar != null && aVar.f() != null) {
            return this.f14389e.f().getPreLoadHandle();
        }
        return super.onGetPreLoadListView();
    }

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        MessageManager.getInstance().sendMessage(new CustomMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_FRAGMENT_NET_BTN_CLICKED));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlaSquareRefreshManager alaSquareRefreshManager = this.l;
        if (alaSquareRefreshManager != null) {
            alaSquareRefreshManager.onPause();
        }
        d.b.j0.t.d.b.d.a aVar = this.f14391g;
        if (aVar != null) {
            aVar.e(true);
            this.f14391g.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            AlaSquareLiveModel alaSquareLiveModel = this.f14392h;
            if (alaSquareLiveModel != null && ListUtils.isEmpty(alaSquareLiveModel.H()) && !this.f14392h.N()) {
                E0();
            }
            AlaSquareRefreshManager alaSquareRefreshManager = this.l;
            if (alaSquareRefreshManager != null) {
                alaSquareRefreshManager.onPageForeground(0);
            }
            d.b.j0.t.d.b.d.a aVar = this.f14391g;
            if (aVar != null) {
                aVar.e(false);
                this.f14391g.b();
                return;
            }
            return;
        }
        d.b.j0.t.d.d.a.c().h(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (this.j || (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) == null || runTask.getData() == null) {
            return;
        }
        IAlaSquareTabController iAlaSquareTabController = (IAlaSquareTabController) runTask.getData();
        this.m = iAlaSquareTabController;
        this.f14389e.o(iAlaSquareTabController);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public void processCloseLives(List<Long> list) {
        AlaSquareLiveModel alaSquareLiveModel;
        if (ListUtils.isEmpty(list) || (alaSquareLiveModel = this.f14392h) == null || ListUtils.isEmpty(alaSquareLiveModel.H())) {
            return;
        }
        this.f14392h.M(list);
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i) {
        refreshCurrentPage();
    }

    public AlaSquareLiveFragment(boolean z) {
        this.j = z;
    }
}
