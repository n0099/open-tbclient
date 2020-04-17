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
import com.baidu.adp.widget.ListView.m;
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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.frs.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, am {
    private int afT;
    private AlaSquareRefreshManager eNW;
    private boolean fgK;
    private AlaFrsLiveModel fgL;
    private c fgM;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int fbJ = 1;
    private boolean fgN = false;
    private boolean fgO = false;
    private CustomMessageListener eVf = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bmn();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bmn();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a fgP = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void jg(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.fgM != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fgM.getRootView());
                AlaFrsLiveFragment.this.fgM.completePullRefresh();
                AlaFrsLiveFragment.this.fgM.e(AlaFrsLiveFragment.this.fgL.getData(), z, AlaFrsLiveFragment.this.fgL.bon());
                AlaFrsLiveFragment.this.fgM.pk(AlaFrsLiveFragment.this.fgL.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.fgL.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.fbJ == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.fgN = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fgM.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.fgM.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void av(int i, String str) {
            if (AlaFrsLiveFragment.this.fgM != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fgM.getRootView());
                AlaFrsLiveFragment.this.fgM.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.fgL.getData()) <= 0 || AlaFrsLiveFragment.this.fgM == null) {
                AlaFrsLiveFragment.this.fgN = true;
                if (AlaFrsLiveFragment.this.fgM != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fgM.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d fgQ = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void P(bj bjVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bjVar);
        }
    };
    private g.c eXI = new g.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.fgL != null) {
                AlaFrsLiveFragment.this.fgL.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener fgR = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.fgL != null) {
                z = AlaFrsLiveFragment.this.fgL.bmv();
            }
            if (AlaFrsLiveFragment.this.fgM != null) {
                if (z) {
                    AlaFrsLiveFragment.this.fgM.blq();
                } else {
                    AlaFrsLiveFragment.this.fgM.blp();
                }
            }
        }
    };
    private d fgS = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void pF(int i) {
            if (AlaFrsLiveFragment.this.fgL != null && AlaFrsLiveFragment.this.fgL.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.cI("fid", AlaFrsLiveFragment.this.forumId);
                anVar.af("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.fgL.setSortType(i);
                AlaFrsLiveFragment.this.fgL.clearData();
                if (AlaFrsLiveFragment.this.fgM != null) {
                    AlaFrsLiveFragment.this.fgM.boq().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.afT = i;
        if (this.fgM != null) {
            this.fgM.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.eVf, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fgM = new c(getPageContext(), this.fgK, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.fgO);
        this.fgM.initView();
        this.fgM.pG(1);
        this.fgM.b(this.fgQ);
        this.fgM.setListPullRefreshListener(this.eXI);
        this.fgM.setOnSrollToBottomListener(this.fgR);
        this.fgM.a(this.fgS);
        this.fgM.onChangeSkinType(this.afT);
        bog();
        return this.fgM.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eNW != null) {
            this.eNW.onPause();
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
            if (this.fgL == null) {
                this.fgL = new AlaFrsLiveModel(getPageContext());
                this.fgL.a(this.fgP);
                this.fgL.setForumId(this.forumId);
                this.fgL.setForumGameLabel(this.forumGameLabel);
                this.fgL.setFromType(this.fbJ);
                this.fgL.refreshData();
                if (this.fgM != null) {
                    showLoadingView(this.fgM.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.eNW = new AlaSquareRefreshManager();
                this.eNW.init(this, new long[]{30000});
            } else if (this.eNW != null) {
                this.eNW.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.eNW != null) {
            this.eNW.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.fgN) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.fgL != null) {
            this.fgL.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        bj bjVar2;
        if (tbPageContext != null && bjVar != null && bjVar.aKE() != null && bjVar.aKX() != null) {
            an anVar = new an("c12571");
            anVar.cI("fid", this.forumId);
            anVar.af("obj_type", bjVar.aKX().live_type);
            TiebaStatic.log(anVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aKE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (m mVar : this.fgL.getData()) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bjVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) mVar).dqA) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aKX());
        alaLiveInfoCoreData.userName = bjVar.aKE().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmn() {
        if (this.fgM != null) {
            this.fgM.bmn();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bog() {
        if (this.fgM != null && this.fgM.boh() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.fgM.boh().setCenterTextTitle(sb.toString());
        }
    }

    public void jA(boolean z) {
        this.fgK = z;
    }

    public void setFromType(int i) {
        this.fbJ = i;
    }

    public void jB(boolean z) {
        this.fgO = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bj bjVar;
        if (this.fgL == null || v.isEmpty(this.fgL.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (m mVar : this.fgL.getData()) {
            if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aKX() != null) {
                linkedList.add(Long.valueOf(bjVar.aKX().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bj bjVar;
        Long l;
        if (!v.isEmpty(list) && this.fgL != null && !v.isEmpty(this.fgL.getData())) {
            LinkedList linkedList = new LinkedList();
            for (m mVar : this.fgL.getData()) {
                if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aKX() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bjVar.aKX().live_id) {
                            linkedList.add(bjVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.fgL.getData().removeAll(linkedList);
                if (this.fgP != null) {
                    this.fgP.jg(this.fgL.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.eNW != null) {
            this.eNW.reset(i);
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

    @Override // com.baidu.tieba.frs.am
    public NavigationBar boh() {
        return this.fgM.boh();
    }
}
