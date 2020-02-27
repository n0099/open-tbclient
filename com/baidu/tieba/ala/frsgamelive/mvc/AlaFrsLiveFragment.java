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
import com.baidu.tieba.frs.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ai {
    private int Ni;
    private boolean eBH;
    private AlaFrsLiveModel eBI;
    private c eBJ;
    private AlaSquareRefreshManager ejS;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int mFromType = 1;
    private boolean eBK = false;
    private boolean eBL = false;
    private CustomMessageListener eqY = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bdo();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bdo();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a eBM = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void ie(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.eBJ != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.eBJ.getRootView());
                AlaFrsLiveFragment.this.eBJ.completePullRefresh();
                AlaFrsLiveFragment.this.eBJ.e(AlaFrsLiveFragment.this.eBI.getData(), z, AlaFrsLiveFragment.this.eBI.beP());
                AlaFrsLiveFragment.this.eBJ.oP(AlaFrsLiveFragment.this.eBI.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.eBI.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.mFromType == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.eBK = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.eBJ.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.eBJ.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void ag(int i, String str) {
            if (AlaFrsLiveFragment.this.eBJ != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.eBJ.getRootView());
                AlaFrsLiveFragment.this.eBJ.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.eBI.getData()) <= 0 || AlaFrsLiveFragment.this.eBJ == null) {
                AlaFrsLiveFragment.this.eBK = true;
                if (AlaFrsLiveFragment.this.eBJ != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.eBJ.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d eBN = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void O(bj bjVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bjVar);
        }
    };
    private g.c etD = new g.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.eBI != null) {
                AlaFrsLiveFragment.this.eBI.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener eBO = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.eBI != null) {
                z = AlaFrsLiveFragment.this.eBI.bdw();
            }
            if (AlaFrsLiveFragment.this.eBJ != null) {
                if (z) {
                    AlaFrsLiveFragment.this.eBJ.bcs();
                } else {
                    AlaFrsLiveFragment.this.eBJ.bcr();
                }
            }
        }
    };
    private d eBP = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void pi(int i) {
            if (AlaFrsLiveFragment.this.eBI != null && AlaFrsLiveFragment.this.eBI.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.cy("fid", AlaFrsLiveFragment.this.forumId);
                anVar.X("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.eBI.setSortType(i);
                AlaFrsLiveFragment.this.eBI.clearData();
                if (AlaFrsLiveFragment.this.eBJ != null) {
                    AlaFrsLiveFragment.this.eBJ.beS().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.Ni = i;
        if (this.eBJ != null) {
            this.eBJ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.eqY, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eBJ = new c(getPageContext(), this.eBH, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.eBL);
        this.eBJ.initView();
        this.eBJ.pj(1);
        this.eBJ.b(this.eBN);
        this.eBJ.setListPullRefreshListener(this.etD);
        this.eBJ.setOnSrollToBottomListener(this.eBO);
        this.eBJ.a(this.eBP);
        this.eBJ.onChangeSkinType(this.Ni);
        beI();
        return this.eBJ.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ejS != null) {
            this.ejS.onPause();
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
            if (this.eBI == null) {
                this.eBI = new AlaFrsLiveModel(getPageContext());
                this.eBI.a(this.eBM);
                this.eBI.setForumId(this.forumId);
                this.eBI.setForumGameLabel(this.forumGameLabel);
                this.eBI.setFromType(this.mFromType);
                this.eBI.refreshData();
                if (this.eBJ != null) {
                    showLoadingView(this.eBJ.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.ejS = new AlaSquareRefreshManager();
                this.ejS.init(this, new long[]{30000});
            } else if (this.ejS != null) {
                this.ejS.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ejS != null) {
            this.ejS.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.eBK) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.eBI != null) {
            this.eBI.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        bj bjVar2;
        if (tbPageContext != null && bjVar != null && bjVar.aCm() != null && bjVar.aCF() != null) {
            an anVar = new an("c12571");
            anVar.cy("fid", this.forumId);
            anVar.X("obj_type", bjVar.aCF().live_type);
            TiebaStatic.log(anVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCm().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (m mVar : this.eBI.getData()) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bjVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) mVar).cRe) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCF());
        alaLiveInfoCoreData.userName = bjVar.aCm().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdo() {
        if (this.eBJ != null) {
            this.eBJ.bdo();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void beI() {
        if (this.eBJ != null && this.eBJ.beJ() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.eBJ.beJ().setCenterTextTitle(sb.toString());
        }
    }

    public void ix(boolean z) {
        this.eBH = z;
    }

    public void setFromType(int i) {
        this.mFromType = i;
    }

    public void iy(boolean z) {
        this.eBL = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bj bjVar;
        if (this.eBI == null || v.isEmpty(this.eBI.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (m mVar : this.eBI.getData()) {
            if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aCF() != null) {
                linkedList.add(Long.valueOf(bjVar.aCF().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bj bjVar;
        Long l;
        if (!v.isEmpty(list) && this.eBI != null && !v.isEmpty(this.eBI.getData())) {
            LinkedList linkedList = new LinkedList();
            for (m mVar : this.eBI.getData()) {
                if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aCF() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bjVar.aCF().live_id) {
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
                this.eBI.getData().removeAll(linkedList);
                if (this.eBM != null) {
                    this.eBM.ie(this.eBI.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ejS != null) {
            this.ejS.reset(i);
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

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar beJ() {
        return this.eBJ.beJ();
    }
}
