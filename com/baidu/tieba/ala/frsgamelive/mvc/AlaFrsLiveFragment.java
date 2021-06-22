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
import d.a.c.k.e.n;
import d.a.n0.r.f0.f;
import d.a.n0.r.q.a2;
import d.a.o0.r0.r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, r0 {

    /* renamed from: e  reason: collision with root package name */
    public String f14070e;

    /* renamed from: f  reason: collision with root package name */
    public String f14071f;

    /* renamed from: g  reason: collision with root package name */
    public String f14072g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14073h;

    /* renamed from: i  reason: collision with root package name */
    public AlaFrsLiveModel f14074i;
    public d.a.o0.v.e.c.c j;
    public AlaSquareRefreshManager n;
    public int p;
    public int k = 1;
    public boolean l = false;
    public boolean m = false;
    public CustomMessageListener o = new a(0);
    public AlaFrsLiveModel.b q = new b();
    public d.a.o0.v.c r = new c();
    public f.g s = new d();
    public BdMultiColumnListView.OnScrollToBottomListener t = new e();
    public d.a.o0.v.e.c.d u = new f();

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
                AlaFrsLiveFragment.this.u();
            } else if ("FrsGameLiveLive".equals(split[0]) && 2 == d.a.c.e.m.b.d(split[1], 0)) {
                AlaFrsLiveFragment.this.u();
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
            if (ListUtils.getCount(AlaFrsLiveFragment.this.f14074i.getData()) <= 0 || AlaFrsLiveFragment.this.j == null) {
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
            AlaFrsLiveFragment.this.j.w(AlaFrsLiveFragment.this.f14074i.getData(), z, AlaFrsLiveFragment.this.f14074i.K());
            AlaFrsLiveFragment.this.j.t(AlaFrsLiveFragment.this.f14074i.H());
            if (ListUtils.getCount(AlaFrsLiveFragment.this.f14074i.getData()) == 0) {
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
    public class c implements d.a.o0.v.c {
        public c() {
        }

        @Override // d.a.o0.v.c
        public void a(a2 a2Var) {
            AlaFrsLiveFragment alaFrsLiveFragment = AlaFrsLiveFragment.this;
            alaFrsLiveFragment.O0(alaFrsLiveFragment.getPageContext(), a2Var);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.f14074i != null) {
                AlaFrsLiveFragment.this.f14074i.N();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements BdMultiColumnListView.OnScrollToBottomListener {
        public e() {
        }

        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean M = AlaFrsLiveFragment.this.f14074i != null ? AlaFrsLiveFragment.this.f14074i.M() : false;
            if (AlaFrsLiveFragment.this.j != null) {
                if (M) {
                    AlaFrsLiveFragment.this.j.B();
                } else {
                    AlaFrsLiveFragment.this.j.C();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.o0.v.e.c.d {
        public f() {
        }

        @Override // d.a.o0.v.e.c.d
        public void a(int i2) {
            if (AlaFrsLiveFragment.this.f14074i == null || AlaFrsLiveFragment.this.f14074i.I() == i2) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c12572");
            statisticItem.param("fid", AlaFrsLiveFragment.this.f14070e);
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            AlaFrsLiveFragment.this.f14074i.setSortType(i2);
            AlaFrsLiveFragment.this.f14074i.clearData();
            if (AlaFrsLiveFragment.this.j != null) {
                AlaFrsLiveFragment.this.j.i().startPullRefresh();
            }
        }
    }

    public void O0(TbPageContext<?> tbPageContext, a2 a2Var) {
        String str;
        boolean z;
        a2 a2Var2;
        if (tbPageContext == null || a2Var == null || a2Var.T() == null || a2Var.s1() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12571");
        statisticItem.param("fid", this.f14070e);
        statisticItem.param("obj_type", a2Var.s1().live_type);
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
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (n nVar : this.f14074i.getData()) {
            if (nVar != null && (nVar instanceof d.a.o0.v.e.b.c) && (a2Var2 = ((d.a.o0.v.e.b.c) nVar).f65711e) != null) {
                alaLiveInfoListCoreData.mLiveInfoList.add(P0(a2Var2));
            }
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_SUB_LIVE, str, z, null, null)));
    }

    public final AlaLiveInfoCoreData P0(a2 a2Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(a2Var.s1());
        alaLiveInfoCoreData.userName = a2Var.T().getUserName();
        return alaLiveInfoCoreData;
    }

    public void Q0(String str) {
        this.f14072g = str;
    }

    public void R0(String str) {
        this.f14070e = str;
    }

    public void S0(String str) {
        this.f14071f = str;
    }

    public void T0(int i2) {
        this.k = i2;
    }

    public void U0(boolean z) {
        this.f14073h = z;
    }

    public void V0(boolean z) {
        this.m = z;
    }

    public final void W0() {
        d.a.o0.v.e.c.c cVar = this.j;
        if (cVar == null || cVar.j() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(UtilHelper.getFixedBarText(this.f14071f, 5, true, true) + getResources().getString(R.string.forum));
        this.j.j().setCenterTextTitle(sb.toString());
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    public List<Long> getCurrentLiveIds() {
        a2 a2Var;
        AlaFrsLiveModel alaFrsLiveModel = this.f14074i;
        if (alaFrsLiveModel == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.f14074i.getData()) {
            if ((nVar instanceof a2) && (a2Var = (a2) nVar) != null && a2Var.s1() != null) {
                linkedList.add(Long.valueOf(a2Var.s1().live_id));
            }
        }
        return linkedList;
    }

    @Override // d.a.o0.r0.r0
    public NavigationBar h0() {
        return this.j.j();
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
        d.a.o0.v.e.c.c cVar = this.j;
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
        d.a.o0.v.e.c.c cVar = new d.a.o0.v.e.c.c(getPageContext(), this.f14073h, getPageContext().getOrignalPage().getUniqueId(), this.f14070e, this.m);
        this.j = cVar;
        cVar.o();
        this.j.u(1);
        this.j.v(this.r);
        this.j.y(this.s);
        this.j.z(this.t);
        this.j.x(this.u);
        this.j.q(this.p);
        W0();
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
        AlaFrsLiveModel alaFrsLiveModel = this.f14074i;
        if (alaFrsLiveModel != null) {
            alaFrsLiveModel.N();
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
            if (this.f14074i == null) {
                AlaFrsLiveModel alaFrsLiveModel = new AlaFrsLiveModel(getPageContext());
                this.f14074i = alaFrsLiveModel;
                alaFrsLiveModel.P(this.q);
                this.f14074i.setForumId(this.f14070e);
                this.f14074i.setForumGameLabel(this.f14072g);
                this.f14074i.O(this.k);
                this.f14074i.N();
                d.a.o0.v.e.c.c cVar = this.j;
                if (cVar != null) {
                    showLoadingView(cVar.k(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                AlaSquareRefreshManager alaSquareRefreshManager = new AlaSquareRefreshManager();
                this.n = alaSquareRefreshManager;
                alaSquareRefreshManager.init(this, new long[]{30000});
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
        if (ListUtils.isEmpty(list) || (alaFrsLiveModel = this.f14074i) == null || ListUtils.isEmpty(alaFrsLiveModel.getData())) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.f14074i.getData()) {
            if ((nVar instanceof a2) && (a2Var = (a2) nVar) != null && a2Var.s1() != null) {
                Long l = null;
                Iterator<Long> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long next = it.next();
                    if (next.longValue() == a2Var.s1().live_id) {
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
        this.f14074i.getData().removeAll(linkedList);
        AlaFrsLiveModel.b bVar = this.q;
        if (bVar != null) {
            bVar.b(this.f14074i.J());
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i2) {
        refreshCurrentPage();
    }

    public final void u() {
        d.a.o0.v.e.c.c cVar = this.j;
        if (cVar != null) {
            cVar.h();
        }
    }
}
