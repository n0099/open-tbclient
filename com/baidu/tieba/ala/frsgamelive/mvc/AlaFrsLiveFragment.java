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
import com.baidu.adp.widget.ListView.o;
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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.frs.am;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, am {
    private int agt;
    private AlaSquareRefreshManager faT;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private boolean fuJ;
    private AlaFrsLiveModel fuK;
    private c fuL;
    private int fpC = 1;
    private boolean fuM = false;
    private boolean fuN = false;
    private CustomMessageListener fie = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.brL();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.brL();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a fuO = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void jz(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.fuL != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fuL.getRootView());
                AlaFrsLiveFragment.this.fuL.completePullRefresh();
                AlaFrsLiveFragment.this.fuL.e(AlaFrsLiveFragment.this.fuK.getData(), z, AlaFrsLiveFragment.this.fuK.bug());
                AlaFrsLiveFragment.this.fuL.pN(AlaFrsLiveFragment.this.fuK.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.fuK.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.fpC == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.fuM = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fuL.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.fuL.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void al(int i, String str) {
            if (AlaFrsLiveFragment.this.fuL != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fuL.getRootView());
                AlaFrsLiveFragment.this.fuL.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.fuK.getData()) <= 0 || AlaFrsLiveFragment.this.fuL == null) {
                AlaFrsLiveFragment.this.fuM = true;
                if (AlaFrsLiveFragment.this.fuL != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fuL.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d fuP = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void Q(bk bkVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bkVar);
        }
    };
    private f.c fkI = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.fuK != null) {
                AlaFrsLiveFragment.this.fuK.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener fuQ = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.fuK != null) {
                z = AlaFrsLiveFragment.this.fuK.brT();
            }
            if (AlaFrsLiveFragment.this.fuL != null) {
                if (z) {
                    AlaFrsLiveFragment.this.fuL.bqM();
                } else {
                    AlaFrsLiveFragment.this.fuL.bqL();
                }
            }
        }
    };
    private d fuR = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void qi(int i) {
            if (AlaFrsLiveFragment.this.fuK != null && AlaFrsLiveFragment.this.fuK.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.dh("fid", AlaFrsLiveFragment.this.forumId);
                anVar.ag("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.fuK.setSortType(i);
                AlaFrsLiveFragment.this.fuK.clearData();
                if (AlaFrsLiveFragment.this.fuL != null) {
                    AlaFrsLiveFragment.this.fuL.bui().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.agt = i;
        if (this.fuL != null) {
            this.fuL.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fie, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fuL = new c(getPageContext(), this.fuJ, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.fuN);
        this.fuL.initView();
        this.fuL.qj(1);
        this.fuL.b(this.fuP);
        this.fuL.setListPullRefreshListener(this.fkI);
        this.fuL.setOnSrollToBottomListener(this.fuQ);
        this.fuL.a(this.fuR);
        this.fuL.onChangeSkinType(this.agt);
        btZ();
        return this.fuL.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.faT != null) {
            this.faT.onPause();
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
            if (this.fuK == null) {
                this.fuK = new AlaFrsLiveModel(getPageContext());
                this.fuK.a(this.fuO);
                this.fuK.setForumId(this.forumId);
                this.fuK.setForumGameLabel(this.forumGameLabel);
                this.fuK.setFromType(this.fpC);
                this.fuK.refreshData();
                if (this.fuL != null) {
                    showLoadingView(this.fuL.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.faT = new AlaSquareRefreshManager();
                this.faT.init(this, new long[]{30000});
            } else if (this.faT != null) {
                this.faT.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.faT != null) {
            this.faT.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.fuM) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.fuK != null) {
            this.fuK.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bk bkVar) {
        bk bkVar2;
        if (tbPageContext != null && bkVar != null && bkVar.aQx() != null && bkVar.aQS() != null) {
            an anVar = new an("c12571");
            anVar.dh("fid", this.forumId);
            anVar.ag("obj_type", bkVar.aQS().live_type);
            TiebaStatic.log(anVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bkVar.aQx().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (o oVar : this.fuK.getData()) {
                if (oVar != null && (oVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bkVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) oVar).dEA) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(U(bkVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData U(bk bkVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bkVar.aQS());
        alaLiveInfoCoreData.userName = bkVar.aQx().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brL() {
        if (this.fuL != null) {
            this.fuL.brL();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void btZ() {
        if (this.fuL != null && this.fuL.bua() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.fuL.bua().setCenterTextTitle(sb.toString());
        }
    }

    public void jT(boolean z) {
        this.fuJ = z;
    }

    public void setFromType(int i) {
        this.fpC = i;
    }

    public void jU(boolean z) {
        this.fuN = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bk bkVar;
        if (this.fuK == null || v.isEmpty(this.fuK.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (o oVar : this.fuK.getData()) {
            if ((oVar instanceof bk) && (bkVar = (bk) oVar) != null && bkVar.aQS() != null) {
                linkedList.add(Long.valueOf(bkVar.aQS().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bk bkVar;
        Long l;
        if (!v.isEmpty(list) && this.fuK != null && !v.isEmpty(this.fuK.getData())) {
            LinkedList linkedList = new LinkedList();
            for (o oVar : this.fuK.getData()) {
                if ((oVar instanceof bk) && (bkVar = (bk) oVar) != null && bkVar.aQS() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bkVar.aQS().live_id) {
                            linkedList.add(bkVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.fuK.getData().removeAll(linkedList);
                if (this.fuO != null) {
                    this.fuO.jz(this.fuK.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.faT != null) {
            this.faT.reset(i);
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
    public NavigationBar bua() {
        return this.fuL.bua();
    }
}
