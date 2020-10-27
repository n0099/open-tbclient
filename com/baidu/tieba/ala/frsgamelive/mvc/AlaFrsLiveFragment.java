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
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.refresh.AlaAutoRefreshFragment;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.f;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.frs.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, at {
    private int ajq;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private AlaSquareRefreshManager gcj;
    private boolean gxa;
    private AlaFrsLiveModel gxb;
    private c gxc;
    private int gqZ = 1;
    private boolean gxd = false;
    private boolean gxe = false;
    private CustomMessageListener gjF = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bNv();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bNv();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gxf = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void lI(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gxc != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gxc.getRootView());
                AlaFrsLiveFragment.this.gxc.completePullRefresh();
                AlaFrsLiveFragment.this.gxc.d(AlaFrsLiveFragment.this.gxb.getData(), z, AlaFrsLiveFragment.this.gxb.bQn());
                AlaFrsLiveFragment.this.gxc.tW(AlaFrsLiveFragment.this.gxb.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gxb.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gqZ == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gxd = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gxc.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gxc.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aA(int i, String str) {
            if (AlaFrsLiveFragment.this.gxc != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gxc.getRootView());
                AlaFrsLiveFragment.this.gxc.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gxb.getData()) <= 0 || AlaFrsLiveFragment.this.gxc == null) {
                AlaFrsLiveFragment.this.gxd = true;
                if (AlaFrsLiveFragment.this.gxc != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gxc.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private f gxg = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.f
        public void P(bw bwVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bwVar);
        }
    };
    private f.c gmi = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gxb != null) {
                AlaFrsLiveFragment.this.gxb.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gxh = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gxb != null) {
                z = AlaFrsLiveFragment.this.gxb.bNB();
            }
            if (AlaFrsLiveFragment.this.gxc != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gxc.bMx();
                } else {
                    AlaFrsLiveFragment.this.gxc.bMw();
                }
            }
        }
    };
    private d gxi = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void us(int i) {
            if (AlaFrsLiveFragment.this.gxb != null && AlaFrsLiveFragment.this.gxb.getSortType() != i) {
                aq aqVar = new aq("c12572");
                aqVar.dR("fid", AlaFrsLiveFragment.this.forumId);
                aqVar.aj("obj_type", i);
                TiebaStatic.log(aqVar);
                AlaFrsLiveFragment.this.gxb.setSortType(i);
                AlaFrsLiveFragment.this.gxb.clearData();
                if (AlaFrsLiveFragment.this.gxc != null) {
                    AlaFrsLiveFragment.this.gxc.bQp().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ajq = i;
        if (this.gxc != null) {
            this.gxc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gjF, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gxc = new c(getPageContext(), this.gxa, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gxe);
        this.gxc.initView();
        this.gxc.ut(1);
        this.gxc.b(this.gxg);
        this.gxc.setListPullRefreshListener(this.gmi);
        this.gxc.setOnSrollToBottomListener(this.gxh);
        this.gxc.a(this.gxi);
        this.gxc.onChangeSkinType(this.ajq);
        bQg();
        return this.gxc.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gcj != null) {
            this.gcj.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.gxb == null) {
                this.gxb = new AlaFrsLiveModel(getPageContext());
                this.gxb.a(this.gxf);
                this.gxb.setForumId(this.forumId);
                this.gxb.setForumGameLabel(this.forumGameLabel);
                this.gxb.setFromType(this.gqZ);
                this.gxb.refreshData();
                if (this.gxc != null) {
                    showLoadingView(this.gxc.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.gcj = new AlaSquareRefreshManager();
                this.gcj.init(this, new long[]{30000});
            } else if (this.gcj != null) {
                this.gcj.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gcj != null) {
            this.gcj.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gxd) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gxb != null) {
            this.gxb.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        bw bwVar2;
        if (tbPageContext != null && bwVar != null && bwVar.bka() != null && bwVar.bku() != null) {
            aq aqVar = new aq("c12571");
            aqVar.dR("fid", this.forumId);
            aqVar.aj("obj_type", bwVar.bku().live_type);
            TiebaStatic.log(aqVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bka().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.gxb.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bwVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).erH) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bku());
        alaLiveInfoCoreData.userName = bwVar.bka().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNv() {
        if (this.gxc != null) {
            this.gxc.bNv();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bQg() {
        if (this.gxc != null && this.gxc.bQh() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gxc.bQh().setCenterTextTitle(sb.toString());
        }
    }

    public void md(boolean z) {
        this.gxa = z;
    }

    public void setFromType(int i) {
        this.gqZ = i;
    }

    public void me(boolean z) {
        this.gxe = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bw bwVar;
        if (this.gxb == null || y.isEmpty(this.gxb.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.gxb.getData()) {
            if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.bku() != null) {
                linkedList.add(Long.valueOf(bwVar.bku().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bw bwVar;
        Long l;
        if (!y.isEmpty(list) && this.gxb != null && !y.isEmpty(this.gxb.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.gxb.getData()) {
                if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.bku() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bwVar.bku().live_id) {
                            linkedList.add(bwVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.gxb.getData().removeAll(linkedList);
                if (this.gxf != null) {
                    this.gxf.lI(this.gxb.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gcj != null) {
            this.gcj.reset(i);
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void startRefresh(int i) {
        refreshCurrentPage();
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public boolean isForeGround(int i) {
        return isAdded() && isPrimary();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.ala.refresh.ISquareRefreshHandler
    public void markHasReaded() {
    }

    @Override // com.baidu.tieba.frs.at
    public NavigationBar bQh() {
        return this.gxc.bQh();
    }
}
