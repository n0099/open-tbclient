package com.baidu.tieba.ala.frsgamelive.mvc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.refresh.AlaAutoRefreshFragment;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import d.a.c.j.e.n;
import d.a.j0.r.f0.f;
import d.a.j0.r.q.a2;
import d.a.k0.q0.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, r0 {

    /* renamed from: e  reason: collision with root package name */
    public String f14028e;

    /* renamed from: f  reason: collision with root package name */
    public String f14029f;

    /* renamed from: g  reason: collision with root package name */
    public String f14030g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14031h;

    /* renamed from: i  reason: collision with root package name */
    public AlaFrsLiveModel f14032i;
    public d.a.k0.t.e.c.c j;
    public AlaSquareRefreshManager n;
    public int p;
    public int k = 1;
    public boolean l = false;
    public boolean m = false;
    public CustomMessageListener o = new a(0);
    public AlaFrsLiveModel.b q = new b();
    public d.a.k0.t.c r = new c();
    public f.g s = new d();
    public BdMultiColumnListView.OnScrollToBottomListener t = new e();
    public d.a.k0.t.e.c.d u = new f();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                return;
            }
            String[] split = ((String) customResponsedMessage.getData()).split("_");
            if (split.length != 2) {
                return;
            }
            if ("FrsGameLive".equals(split[0]) && 9 == d.a.c.e.m.b.d(split[1], 0)) {
                AlaFrsLiveFragment.this.t();
            } else if ("FrsGameLiveLive".equals(split[0]) && 2 == d.a.c.e.m.b.d(split[1], 0)) {
                AlaFrsLiveFragment.this.t();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AlaFrsLiveModel.b {
        public b() {
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void a(int i2, String str) {
            if (AlaFrsLiveFragment.this.j != null) {
                AlaFrsLiveFragment alaFrsLiveFragment = AlaFrsLiveFragment.this;
                alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.j.k());
                AlaFrsLiveFragment.this.j.g();
            }
            if (ListUtils.getCount(AlaFrsLiveFragment.this.f14032i.getData()) <= 0 || AlaFrsLiveFragment.this.j == null) {
                AlaFrsLiveFragment.this.l = true;
                if (AlaFrsLiveFragment.this.j != null) {
                    AlaFrsLiveFragment alaFrsLiveFragment2 = AlaFrsLiveFragment.this;
                    alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.j.k(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.b
        public void b(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() == null || AlaFrsLiveFragment.this.j == null) {
                return;
            }
            AlaFrsLiveFragment alaFrsLiveFragment = AlaFrsLiveFragment.this;
            alaFrsLiveFragment.hideLoadingView(alaFrsLiveFragment.j.k());
            AlaFrsLiveFragment.this.j.g();
            AlaFrsLiveFragment.this.j.w(AlaFrsLiveFragment.this.f14032i.getData(), z, AlaFrsLiveFragment.this.f14032i.G());
            AlaFrsLiveFragment.this.j.t(AlaFrsLiveFragment.this.f14032i.D());
            if (ListUtils.getCount(AlaFrsLiveFragment.this.f14032i.getData()) == 0) {
                if (AlaFrsLiveFragment.this.k == 1) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001621));
                }
                AlaFrsLiveFragment.this.l = false;
                AlaFrsLiveFragment alaFrsLiveFragment2 = AlaFrsLiveFragment.this;
                alaFrsLiveFragment2.showNetRefreshView(alaFrsLiveFragment2.j.k(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                return;
            }
            AlaFrsLiveFragment alaFrsLiveFragment3 = AlaFrsLiveFragment.this;
            alaFrsLiveFragment3.hideNetRefreshView(alaFrsLiveFragment3.j.k());
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.k0.t.c {
        public c() {
        }

        @Override // d.a.k0.t.c
        public void a(a2 a2Var) {
            AlaFrsLiveFragment alaFrsLiveFragment = AlaFrsLiveFragment.this;
            alaFrsLiveFragment.L0(alaFrsLiveFragment.getPageContext(), a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.j0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.f14032i != null) {
                AlaFrsLiveFragment.this.f14032i.J();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdMultiColumnListView.OnScrollToBottomListener {
        public e() {
        }

        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean I = AlaFrsLiveFragment.this.f14032i != null ? AlaFrsLiveFragment.this.f14032i.I() : false;
            if (AlaFrsLiveFragment.this.j != null) {
                if (I) {
                    AlaFrsLiveFragment.this.j.B();
                } else {
                    AlaFrsLiveFragment.this.j.C();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.k0.t.e.c.d {
        public f() {
        }

        @Override // d.a.k0.t.e.c.d
        public void a(int i2) {
            if (AlaFrsLiveFragment.this.f14032i == null || AlaFrsLiveFragment.this.f14032i.E() == i2) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c12572");
            statisticItem.param("fid", AlaFrsLiveFragment.this.f14028e);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            AlaFrsLiveFragment.this.f14032i.setSortType(i2);
            AlaFrsLiveFragment.this.f14032i.clearData();
            if (AlaFrsLiveFragment.this.j != null) {
                AlaFrsLiveFragment.this.j.i().startPullRefresh();
            }
        }
    }

    public void L0(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        a2 a2Var2;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12571");
        statisticItem.param("fid", this.f14028e);
        statisticItem.param("obj_type", a2Var.q1().live_type);
        TiebaStatic.log(statisticItem);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = a2Var.T().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (n nVar : this.f14032i.getData()) {
            if (nVar != null && (nVar instanceof d.a.k0.t.e.b.c) && (a2Var2 = ((d.a.k0.t.e.b.c) nVar).f61583e) != null) {
                alaLiveInfoListCoreData.mLiveInfoList.add(M0(a2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
    }

    public final AlaLiveInfoCoreData M0(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void N0(String str) {
        this.f14030g = str;
    }

    public void O0(String str) {
        this.f14028e = str;
    }

    public void P0(String str) {
        this.f14029f = str;
    }

    public void Q0(int i2) {
        this.k = i2;
    }

    public void R0(boolean z) {
        this.f14031h = z;
    }

    public void S0(boolean z) {
        this.m = z;
    }

    public final void T0() {
        d.a.k0.t.e.c.c cVar = this.j;
        if (cVar == null || cVar.j() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f14029f, 5, true, true) + getResources().getString(R.string.forum));
        this.j.j().setCenterTextTitle(sb.toString());
    }

    @Override // d.a.k0.q0.r0
    public NavigationBar e0() {
        return this.j.j();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        a2 a2Var;
        AlaFrsLiveModel alaFrsLiveModel = this.f14032i;
        if (alaFrsLiveModel == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.f14032i.getData()) {
            if ((nVar instanceof a2) && (a2Var = (a2) nVar) != null && a2Var.q1() != null) {
                linkedList.add(Long.valueOf(a2Var.q1().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i2) {
        return isAdded() && isPrimary();
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i2) {
        AlaSquareRefreshManager alaSquareRefreshManager = this.n;
        if (alaSquareRefreshManager != null) {
            alaSquareRefreshManager.reset(i2);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.p = i2;
        d.a.k0.t.e.c.c cVar = this.j;
        if (cVar != null) {
            cVar.q(i2);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(2001446, this.o, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d.a.k0.t.e.c.c cVar = new d.a.k0.t.e.c.c(getPageContext(), this.f14031h, getPageContext().getOrignalPage().getUniqueId(), this.f14028e, this.m);
        this.j = cVar;
        cVar.o();
        this.j.u(1);
        this.j.v(this.r);
        this.j.y(this.s);
        this.j.z(this.t);
        this.j.x(this.u);
        this.j.q(this.p);
        T0();
        return this.j.k();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlaSquareRefreshManager alaSquareRefreshManager = this.n;
        if (alaSquareRefreshManager != null) {
            alaSquareRefreshManager.onDestory();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.l) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
            return;
        }
        AlaFrsLiveModel alaFrsLiveModel = this.f14032i;
        if (alaFrsLiveModel != null) {
            alaFrsLiveModel.J();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlaSquareRefreshManager alaSquareRefreshManager = this.n;
        if (alaSquareRefreshManager != null) {
            alaSquareRefreshManager.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.f14032i == null) {
                AlaFrsLiveModel alaFrsLiveModel = new AlaFrsLiveModel(getPageContext());
                this.f14032i = alaFrsLiveModel;
                alaFrsLiveModel.L(this.q);
                this.f14032i.setForumId(this.f14028e);
                this.f14032i.setForumGameLabel(this.f14030g);
                this.f14032i.K(this.k);
                this.f14032i.J();
                d.a.k0.t.e.c.c cVar = this.j;
                if (cVar != null) {
                    showLoadingView(cVar.k(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                AlaSquareRefreshManager alaSquareRefreshManager = new AlaSquareRefreshManager();
                this.n = alaSquareRefreshManager;
                alaSquareRefreshManager.init(this, new long[]{StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD});
                return;
            }
            AlaSquareRefreshManager alaSquareRefreshManager2 = this.n;
            if (alaSquareRefreshManager2 != null) {
                alaSquareRefreshManager2.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public void processCloseLives(List<Long> list) {
        AlaFrsLiveModel alaFrsLiveModel;
        a2 a2Var;
        if (ListUtils.isEmpty(list) || (alaFrsLiveModel = this.f14032i) == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.f14032i.getData()) {
            if ((nVar instanceof a2) && (a2Var = (a2) nVar) != null && a2Var.q1() != null) {
                Long l = null;
                Iterator<Long> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long next = it.next();
                    if (next.longValue() == a2Var.q1().live_id) {
                        linkedList.add(a2Var);
                        l = next;
                        break;
                    }
                }
                if (l != null) {
                    list.remove(l);
                }
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        this.f14032i.getData().removeAll(linkedList);
        AlaFrsLiveModel.b bVar = this.q;
        if (bVar != null) {
            bVar.b(this.f14032i.F());
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i2) {
        refreshCurrentPage();
    }

    public final void t() {
        d.a.k0.t.e.c.c cVar = this.j;
        if (cVar != null) {
            cVar.h();
        }
    }
}
