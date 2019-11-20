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
    private int csg;
    private boolean dIa;
    private AlaFrsLiveModel dIb;
    private c dIc;
    private AlaSquareRefreshManager duC;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int dFv = 1;
    private boolean aVy = false;
    private boolean dId = false;
    private CustomMessageListener dAQ = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.g.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.aKf();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.g.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.aKf();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a dIe = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void gI(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.dIc != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.dIc.getRootView());
                AlaFrsLiveFragment.this.dIc.completePullRefresh();
                AlaFrsLiveFragment.this.dIc.e(AlaFrsLiveFragment.this.dIb.getData(), z, AlaFrsLiveFragment.this.dIb.aKV());
                AlaFrsLiveFragment.this.dIc.mo(AlaFrsLiveFragment.this.dIb.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.dIb.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.dFv == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.aVy = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.dIc.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.dIc.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void O(int i, String str) {
            if (AlaFrsLiveFragment.this.dIc != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.dIc.getRootView());
                AlaFrsLiveFragment.this.dIc.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.dIb.getData()) <= 0 || AlaFrsLiveFragment.this.dIc == null) {
                AlaFrsLiveFragment.this.aVy = true;
                if (AlaFrsLiveFragment.this.dIc != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.dIc.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d dIf = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void I(bh bhVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bhVar);
        }
    };
    private h.c dDg = new h.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.dIb != null) {
                AlaFrsLiveFragment.this.dIb.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener dIg = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.dIb != null) {
                z = AlaFrsLiveFragment.this.dIb.aKn();
            }
            if (AlaFrsLiveFragment.this.dIc != null) {
                if (z) {
                    AlaFrsLiveFragment.this.dIc.aJj();
                } else {
                    AlaFrsLiveFragment.this.dIc.aJi();
                }
            }
        }
    };
    private d dIh = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void mB(int i) {
            if (AlaFrsLiveFragment.this.dIb != null && AlaFrsLiveFragment.this.dIb.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.bS("fid", AlaFrsLiveFragment.this.forumId);
                anVar.O("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.dIb.setSortType(i);
                AlaFrsLiveFragment.this.dIb.clearData();
                if (AlaFrsLiveFragment.this.dIc != null) {
                    AlaFrsLiveFragment.this.dIc.aKY().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.csg = i;
        if (this.dIc != null) {
            this.dIc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.dAQ, getBaseFragmentActivity().getUniqueId());
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dIc = new c(getPageContext(), this.dIa, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.dId);
        this.dIc.initView();
        this.dIc.mC(1);
        this.dIc.b(this.dIf);
        this.dIc.setListPullRefreshListener(this.dDg);
        this.dIc.setOnSrollToBottomListener(this.dIg);
        this.dIc.a(this.dIh);
        this.dIc.onChangeSkinType(this.csg);
        aKO();
        return this.dIc.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.duC != null) {
            this.duC.onPause();
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
            if (this.dIb == null) {
                this.dIb = new AlaFrsLiveModel(getPageContext());
                this.dIb.a(this.dIe);
                this.dIb.setForumId(this.forumId);
                this.dIb.setForumGameLabel(this.forumGameLabel);
                this.dIb.setFromType(this.dFv);
                this.dIb.refreshData();
                if (this.dIc != null) {
                    showLoadingView(this.dIc.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.duC = new AlaSquareRefreshManager();
                this.duC.init(this, new long[]{StatisticConfig.MIN_UPLOAD_INTERVAL});
            } else if (this.duC != null) {
                this.duC.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.duC != null) {
            this.duC.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.aVy) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.dIb != null) {
            this.dIb.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bh bhVar) {
        bh bhVar2;
        if (tbPageContext != null && bhVar != null && bhVar.aiE() != null && bhVar.aiX() != null) {
            an anVar = new an("c12571");
            anVar.bS("fid", this.forumId);
            anVar.O("obj_type", bhVar.aiX().live_type);
            TiebaStatic.log(anVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bhVar.aiE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (m mVar : this.dIb.getData()) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bhVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) mVar).caz) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(M(bhVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData M(bh bhVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bhVar.aiX());
        alaLiveInfoCoreData.userName = bhVar.aiE().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKf() {
        if (this.dIc != null) {
            this.dIc.aKf();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void aKO() {
        if (this.dIc != null && this.dIc.aKP() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.dIc.aKP().setCenterTextTitle(sb.toString());
        }
    }

    public void gZ(boolean z) {
        this.dIa = z;
    }

    public void setFromType(int i) {
        this.dFv = i;
    }

    public void ha(boolean z) {
        this.dId = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bh bhVar;
        if (this.dIb == null || v.isEmpty(this.dIb.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (m mVar : this.dIb.getData()) {
            if ((mVar instanceof bh) && (bhVar = (bh) mVar) != null && bhVar.aiX() != null) {
                linkedList.add(Long.valueOf(bhVar.aiX().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bh bhVar;
        Long l;
        if (!v.isEmpty(list) && this.dIb != null && !v.isEmpty(this.dIb.getData())) {
            LinkedList linkedList = new LinkedList();
            for (m mVar : this.dIb.getData()) {
                if ((mVar instanceof bh) && (bhVar = (bh) mVar) != null && bhVar.aiX() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bhVar.aiX().live_id) {
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
                this.dIb.getData().removeAll(linkedList);
                if (this.dIe != null) {
                    this.dIe.gI(this.dIb.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.duC != null) {
            this.duC.reset(i);
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
    public NavigationBar aKP() {
        return this.dIc.aKP();
    }
}
