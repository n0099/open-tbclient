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
    private int aiX;
    private AlaSquareRefreshManager fFX;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private boolean gaE;
    private AlaFrsLiveModel gaF;
    private c gaG;
    private int fUD = 1;
    private boolean gaH = false;
    private boolean gaI = false;
    private CustomMessageListener fNj = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bIh();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bIh();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gaJ = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void kS(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gaG != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gaG.getRootView());
                AlaFrsLiveFragment.this.gaG.completePullRefresh();
                AlaFrsLiveFragment.this.gaG.d(AlaFrsLiveFragment.this.gaF.getData(), z, AlaFrsLiveFragment.this.gaF.bKY());
                AlaFrsLiveFragment.this.gaG.tf(AlaFrsLiveFragment.this.gaF.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gaF.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.fUD == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gaH = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gaG.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gaG.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void an(int i, String str) {
            if (AlaFrsLiveFragment.this.gaG != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gaG.getRootView());
                AlaFrsLiveFragment.this.gaG.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gaF.getData()) <= 0 || AlaFrsLiveFragment.this.gaG == null) {
                AlaFrsLiveFragment.this.gaH = true;
                if (AlaFrsLiveFragment.this.gaG != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gaG.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private f gaK = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.f
        public void P(bw bwVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bwVar);
        }
    };
    private f.c fPM = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gaF != null) {
                AlaFrsLiveFragment.this.gaF.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gaL = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gaF != null) {
                z = AlaFrsLiveFragment.this.gaF.bIp();
            }
            if (AlaFrsLiveFragment.this.gaG != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gaG.bHj();
                } else {
                    AlaFrsLiveFragment.this.gaG.bHi();
                }
            }
        }
    };
    private d gaM = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void tC(int i) {
            if (AlaFrsLiveFragment.this.gaF != null && AlaFrsLiveFragment.this.gaF.getSortType() != i) {
                aq aqVar = new aq("c12572");
                aqVar.dF("fid", AlaFrsLiveFragment.this.forumId);
                aqVar.ai("obj_type", i);
                TiebaStatic.log(aqVar);
                AlaFrsLiveFragment.this.gaF.setSortType(i);
                AlaFrsLiveFragment.this.gaF.clearData();
                if (AlaFrsLiveFragment.this.gaG != null) {
                    AlaFrsLiveFragment.this.gaG.bLa().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aiX = i;
        if (this.gaG != null) {
            this.gaG.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fNj, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gaG = new c(getPageContext(), this.gaE, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gaI);
        this.gaG.initView();
        this.gaG.tD(1);
        this.gaG.b(this.gaK);
        this.gaG.setListPullRefreshListener(this.fPM);
        this.gaG.setOnSrollToBottomListener(this.gaL);
        this.gaG.a(this.gaM);
        this.gaG.onChangeSkinType(this.aiX);
        bKR();
        return this.gaG.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fFX != null) {
            this.fFX.onPause();
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
            if (this.gaF == null) {
                this.gaF = new AlaFrsLiveModel(getPageContext());
                this.gaF.a(this.gaJ);
                this.gaF.setForumId(this.forumId);
                this.gaF.setForumGameLabel(this.forumGameLabel);
                this.gaF.setFromType(this.fUD);
                this.gaF.refreshData();
                if (this.gaG != null) {
                    showLoadingView(this.gaG.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.fFX = new AlaSquareRefreshManager();
                this.fFX.init(this, new long[]{30000});
            } else if (this.fFX != null) {
                this.fFX.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fFX != null) {
            this.fFX.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gaH) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gaF != null) {
            this.gaF.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        bw bwVar2;
        if (tbPageContext != null && bwVar != null && bwVar.bfy() != null && bwVar.bfS() != null) {
            aq aqVar = new aq("c12571");
            aqVar.dF("fid", this.forumId);
            aqVar.ai("obj_type", bwVar.bfS().live_type);
            TiebaStatic.log(aqVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bfy().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.gaF.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bwVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).dXg) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.bfS());
        alaLiveInfoCoreData.userName = bwVar.bfy().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIh() {
        if (this.gaG != null) {
            this.gaG.bIh();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bKR() {
        if (this.gaG != null && this.gaG.bKS() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gaG.bKS().setCenterTextTitle(sb.toString());
        }
    }

    public void lp(boolean z) {
        this.gaE = z;
    }

    public void setFromType(int i) {
        this.fUD = i;
    }

    public void lq(boolean z) {
        this.gaI = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bw bwVar;
        if (this.gaF == null || y.isEmpty(this.gaF.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.gaF.getData()) {
            if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.bfS() != null) {
                linkedList.add(Long.valueOf(bwVar.bfS().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bw bwVar;
        Long l;
        if (!y.isEmpty(list) && this.gaF != null && !y.isEmpty(this.gaF.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.gaF.getData()) {
                if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.bfS() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bwVar.bfS().live_id) {
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
                this.gaF.getData().removeAll(linkedList);
                if (this.gaJ != null) {
                    this.gaJ.kS(this.gaF.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fFX != null) {
            this.fFX.reset(i);
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
    public NavigationBar bKS() {
        return this.gaG.bKS();
    }
}
