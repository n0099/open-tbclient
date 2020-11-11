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
    private boolean gCO;
    private AlaFrsLiveModel gCP;
    private c gCQ;
    private AlaSquareRefreshManager ghY;
    private int gwN = 1;
    private boolean gCR = false;
    private boolean gCS = false;
    private CustomMessageListener gps = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bPV();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bPV();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gCT = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void lR(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gCQ != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gCQ.getRootView());
                AlaFrsLiveFragment.this.gCQ.completePullRefresh();
                AlaFrsLiveFragment.this.gCQ.d(AlaFrsLiveFragment.this.gCP.getData(), z, AlaFrsLiveFragment.this.gCP.bSN());
                AlaFrsLiveFragment.this.gCQ.ug(AlaFrsLiveFragment.this.gCP.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gCP.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gwN == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gCR = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gCQ.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gCQ.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aE(int i, String str) {
            if (AlaFrsLiveFragment.this.gCQ != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gCQ.getRootView());
                AlaFrsLiveFragment.this.gCQ.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gCP.getData()) <= 0 || AlaFrsLiveFragment.this.gCQ == null) {
                AlaFrsLiveFragment.this.gCR = true;
                if (AlaFrsLiveFragment.this.gCQ != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gCQ.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private f gCU = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.f
        public void P(bw bwVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bwVar);
        }
    };
    private f.c grV = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gCP != null) {
                AlaFrsLiveFragment.this.gCP.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gCV = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gCP != null) {
                z = AlaFrsLiveFragment.this.gCP.bQb();
            }
            if (AlaFrsLiveFragment.this.gCQ != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gCQ.bOX();
                } else {
                    AlaFrsLiveFragment.this.gCQ.bOW();
                }
            }
        }
    };
    private d gCW = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void uC(int i) {
            if (AlaFrsLiveFragment.this.gCP != null && AlaFrsLiveFragment.this.gCP.getSortType() != i) {
                aq aqVar = new aq("c12572");
                aqVar.dR("fid", AlaFrsLiveFragment.this.forumId);
                aqVar.al("obj_type", i);
                TiebaStatic.log(aqVar);
                AlaFrsLiveFragment.this.gCP.setSortType(i);
                AlaFrsLiveFragment.this.gCP.clearData();
                if (AlaFrsLiveFragment.this.gCQ != null) {
                    AlaFrsLiveFragment.this.gCQ.bSP().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ajq = i;
        if (this.gCQ != null) {
            this.gCQ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gps, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gCQ = new c(getPageContext(), this.gCO, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gCS);
        this.gCQ.initView();
        this.gCQ.uD(1);
        this.gCQ.b(this.gCU);
        this.gCQ.setListPullRefreshListener(this.grV);
        this.gCQ.setOnSrollToBottomListener(this.gCV);
        this.gCQ.a(this.gCW);
        this.gCQ.onChangeSkinType(this.ajq);
        bSG();
        return this.gCQ.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ghY != null) {
            this.ghY.onPause();
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
            if (this.gCP == null) {
                this.gCP = new AlaFrsLiveModel(getPageContext());
                this.gCP.a(this.gCT);
                this.gCP.setForumId(this.forumId);
                this.gCP.setForumGameLabel(this.forumGameLabel);
                this.gCP.setFromType(this.gwN);
                this.gCP.refreshData();
                if (this.gCQ != null) {
                    showLoadingView(this.gCQ.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.ghY = new AlaSquareRefreshManager();
                this.ghY.init(this, new long[]{30000});
            } else if (this.ghY != null) {
                this.ghY.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ghY != null) {
            this.ghY.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gCR) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gCP != null) {
            this.gCP.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        bw bwVar2;
        if (tbPageContext != null && bwVar != null && bwVar.bmA() != null && bwVar.bmU() != null) {
            aq aqVar = new aq("c12571");
            aqVar.dR("fid", this.forumId);
            aqVar.al("obj_type", bwVar.bmU().live_type);
            TiebaStatic.log(aqVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bmA().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.gCP.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bwVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).exA) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bmU());
        alaLiveInfoCoreData.userName = bwVar.bmA().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPV() {
        if (this.gCQ != null) {
            this.gCQ.bPV();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bSG() {
        if (this.gCQ != null && this.gCQ.bSH() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gCQ.bSH().setCenterTextTitle(sb.toString());
        }
    }

    public void mm(boolean z) {
        this.gCO = z;
    }

    public void setFromType(int i) {
        this.gwN = i;
    }

    public void mn(boolean z) {
        this.gCS = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bw bwVar;
        if (this.gCP == null || y.isEmpty(this.gCP.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.gCP.getData()) {
            if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.bmU() != null) {
                linkedList.add(Long.valueOf(bwVar.bmU().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bw bwVar;
        Long l;
        if (!y.isEmpty(list) && this.gCP != null && !y.isEmpty(this.gCP.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.gCP.getData()) {
                if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.bmU() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bwVar.bmU().live_id) {
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
                this.gCP.getData().removeAll(linkedList);
                if (this.gCT != null) {
                    this.gCT.lR(this.gCP.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ghY != null) {
            this.ghY.reset(i);
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
    public NavigationBar bSH() {
        return this.gCQ.bSH();
    }
}
