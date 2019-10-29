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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.frs.ah;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ah {
    private int csX;
    private boolean dIR;
    private AlaFrsLiveModel dIS;
    private c dIT;
    private AlaSquareRefreshManager dvt;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int dGm = 1;
    private boolean aVQ = false;
    private boolean dIU = false;
    private CustomMessageListener dBH = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.g.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.aKh();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.g.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.aKh();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a dIV = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void gI(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.dIT != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.dIT.getRootView());
                AlaFrsLiveFragment.this.dIT.completePullRefresh();
                AlaFrsLiveFragment.this.dIT.e(AlaFrsLiveFragment.this.dIS.getData(), z, AlaFrsLiveFragment.this.dIS.aKX());
                AlaFrsLiveFragment.this.dIT.mp(AlaFrsLiveFragment.this.dIS.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.dIS.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.dGm == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.aVQ = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.dIT.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.dIT.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void P(int i, String str) {
            if (AlaFrsLiveFragment.this.dIT != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.dIT.getRootView());
                AlaFrsLiveFragment.this.dIT.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.dIS.getData()) <= 0 || AlaFrsLiveFragment.this.dIT == null) {
                AlaFrsLiveFragment.this.aVQ = true;
                if (AlaFrsLiveFragment.this.dIT != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.dIT.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d dIW = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void I(bh bhVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bhVar);
        }
    };
    private h.c dDX = new h.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.dIS != null) {
                AlaFrsLiveFragment.this.dIS.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener dIX = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.dIS != null) {
                z = AlaFrsLiveFragment.this.dIS.aKp();
            }
            if (AlaFrsLiveFragment.this.dIT != null) {
                if (z) {
                    AlaFrsLiveFragment.this.dIT.aJl();
                } else {
                    AlaFrsLiveFragment.this.dIT.aJk();
                }
            }
        }
    };
    private d dIY = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void mC(int i) {
            if (AlaFrsLiveFragment.this.dIS != null && AlaFrsLiveFragment.this.dIS.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.bS("fid", AlaFrsLiveFragment.this.forumId);
                anVar.O("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.dIS.setSortType(i);
                AlaFrsLiveFragment.this.dIS.clearData();
                if (AlaFrsLiveFragment.this.dIT != null) {
                    AlaFrsLiveFragment.this.dIT.aLa().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.csX = i;
        if (this.dIT != null) {
            this.dIT.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.dBH, getBaseFragmentActivity().getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dIT = new c(getPageContext(), this.dIR, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.dIU);
        this.dIT.initView();
        this.dIT.mD(1);
        this.dIT.b(this.dIW);
        this.dIT.setListPullRefreshListener(this.dDX);
        this.dIT.setOnSrollToBottomListener(this.dIX);
        this.dIT.a(this.dIY);
        this.dIT.onChangeSkinType(this.csX);
        aKQ();
        return this.dIT.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dvt != null) {
            this.dvt.onPause();
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
            if (this.dIS == null) {
                this.dIS = new AlaFrsLiveModel(getPageContext());
                this.dIS.a(this.dIV);
                this.dIS.setForumId(this.forumId);
                this.dIS.setForumGameLabel(this.forumGameLabel);
                this.dIS.setFromType(this.dGm);
                this.dIS.refreshData();
                if (this.dIT != null) {
                    showLoadingView(this.dIT.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.dvt = new AlaSquareRefreshManager();
                this.dvt.init(this, new long[]{StatisticConfig.MIN_UPLOAD_INTERVAL});
            } else if (this.dvt != null) {
                this.dvt.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dvt != null) {
            this.dvt.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.aVQ) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.dIS != null) {
            this.dIS.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bh bhVar) {
        bh bhVar2;
        if (tbPageContext != null && bhVar != null && bhVar.aiG() != null && bhVar.aiZ() != null) {
            an anVar = new an("c12571");
            anVar.bS("fid", this.forumId);
            anVar.O("obj_type", bhVar.aiZ().live_type);
            TiebaStatic.log(anVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiG().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (m mVar : this.dIS.getData()) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bhVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) mVar).cbq) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData M(bh bhVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bhVar.aiZ());
        alaLiveInfoCoreData.userName = bhVar.aiG().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        if (this.dIT != null) {
            this.dIT.aKh();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void aKQ() {
        if (this.dIT != null && this.dIT.aKR() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.dIT.aKR().setCenterTextTitle(sb.toString());
        }
    }

    public void gZ(boolean z) {
        this.dIR = z;
    }

    public void setFromType(int i) {
        this.dGm = i;
    }

    public void ha(boolean z) {
        this.dIU = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bh bhVar;
        if (this.dIS == null || v.isEmpty(this.dIS.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (m mVar : this.dIS.getData()) {
            if ((mVar instanceof bh) && (bhVar = (bh) mVar) != null && bhVar.aiZ() != null) {
                linkedList.add(Long.valueOf(bhVar.aiZ().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bh bhVar;
        Long l;
        if (!v.isEmpty(list) && this.dIS != null && !v.isEmpty(this.dIS.getData())) {
            LinkedList linkedList = new LinkedList();
            for (m mVar : this.dIS.getData()) {
                if ((mVar instanceof bh) && (bhVar = (bh) mVar) != null && bhVar.aiZ() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bhVar.aiZ().live_id) {
                            linkedList.add(bhVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.dIS.getData().removeAll(linkedList);
                if (this.dIV != null) {
                    this.dIV.gI(this.dIS.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.dvt != null) {
            this.dvt.reset(i);
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

    @Override // com.baidu.tieba.frs.ah
    public NavigationBar aKR() {
        return this.dIT.aKR();
    }
}
