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
import com.baidu.adp.widget.ListView.n;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.ala.g;
import com.baidu.tieba.frs.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ap {
    private int akf;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private boolean gSA;
    private AlaFrsLiveModel gSB;
    private c gSC;
    private AlaSquareRefreshManager gwj;
    private int gMm = 1;
    private boolean gSD = false;
    private boolean gSE = false;
    private CustomMessageListener gDH = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bRN();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bRN();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gSF = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void mG(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gSC != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gSC.getRootView());
                AlaFrsLiveFragment.this.gSC.completePullRefresh();
                AlaFrsLiveFragment.this.gSC.d(AlaFrsLiveFragment.this.gSB.getData(), z, AlaFrsLiveFragment.this.gSB.bUF());
                AlaFrsLiveFragment.this.gSC.tN(AlaFrsLiveFragment.this.gSB.getLiveCount());
                if (x.getCount(AlaFrsLiveFragment.this.gSB.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gMm == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gSD = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gSC.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gSC.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aF(int i, String str) {
            if (AlaFrsLiveFragment.this.gSC != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gSC.getRootView());
                AlaFrsLiveFragment.this.gSC.completePullRefresh();
            }
            if (x.getCount(AlaFrsLiveFragment.this.gSB.getData()) <= 0 || AlaFrsLiveFragment.this.gSC == null) {
                AlaFrsLiveFragment.this.gSD = true;
                if (AlaFrsLiveFragment.this.gSC != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gSC.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private g gSG = new g() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.g
        public void R(bz bzVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bzVar);
        }
    };
    private f.c gGk = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gSB != null) {
                AlaFrsLiveFragment.this.gSB.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gSH = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gSB != null) {
                z = AlaFrsLiveFragment.this.gSB.bRT();
            }
            if (AlaFrsLiveFragment.this.gSC != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gSC.bQN();
                } else {
                    AlaFrsLiveFragment.this.gSC.bQM();
                }
            }
        }
    };
    private d gSI = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void um(int i) {
            if (AlaFrsLiveFragment.this.gSB != null && AlaFrsLiveFragment.this.gSB.getSortType() != i) {
                aq aqVar = new aq("c12572");
                aqVar.dW("fid", AlaFrsLiveFragment.this.forumId);
                aqVar.an("obj_type", i);
                TiebaStatic.log(aqVar);
                AlaFrsLiveFragment.this.gSB.setSortType(i);
                AlaFrsLiveFragment.this.gSB.clearData();
                if (AlaFrsLiveFragment.this.gSC != null) {
                    AlaFrsLiveFragment.this.gSC.bUH().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.akf = i;
        if (this.gSC != null) {
            this.gSC.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gDH, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gSC = new c(getPageContext(), this.gSA, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gSE);
        this.gSC.initView();
        this.gSC.un(1);
        this.gSC.b(this.gSG);
        this.gSC.setListPullRefreshListener(this.gGk);
        this.gSC.setOnSrollToBottomListener(this.gSH);
        this.gSC.a(this.gSI);
        this.gSC.onChangeSkinType(this.akf);
        bUy();
        return this.gSC.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gwj != null) {
            this.gwj.onPause();
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            if (this.gSB == null) {
                this.gSB = new AlaFrsLiveModel(getPageContext());
                this.gSB.a(this.gSF);
                this.gSB.setForumId(this.forumId);
                this.gSB.setForumGameLabel(this.forumGameLabel);
                this.gSB.setFromType(this.gMm);
                this.gSB.refreshData();
                if (this.gSC != null) {
                    showLoadingView(this.gSC.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.gwj = new AlaSquareRefreshManager();
                this.gwj.init(this, new long[]{30000});
            } else if (this.gwj != null) {
                this.gwj.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gwj != null) {
            this.gwj.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gSD) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gSB != null) {
            this.gSB.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        bz bzVar2;
        if (tbPageContext != null && bzVar != null && bzVar.bnx() != null && bzVar.bnQ() != null) {
            aq aqVar = new aq("c12571");
            aqVar.dW("fid", this.forumId);
            aqVar.an("obj_type", bzVar.bnQ().live_type);
            TiebaStatic.log(aqVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.bnx().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (n nVar : this.gSB.getData()) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bzVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) nVar).eHK) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bz bzVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bzVar.bnQ());
        alaLiveInfoCoreData.userName = bzVar.bnx().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        if (this.gSC != null) {
            this.gSC.bRN();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bUy() {
        if (this.gSC != null && this.gSC.bUz() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gSC.bUz().setCenterTextTitle(sb.toString());
        }
    }

    public void ne(boolean z) {
        this.gSA = z;
    }

    public void setFromType(int i) {
        this.gMm = i;
    }

    public void nf(boolean z) {
        this.gSE = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bz bzVar;
        if (this.gSB == null || x.isEmpty(this.gSB.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.gSB.getData()) {
            if ((nVar instanceof bz) && (bzVar = (bz) nVar) != null && bzVar.bnQ() != null) {
                linkedList.add(Long.valueOf(bzVar.bnQ().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bz bzVar;
        Long l;
        if (!x.isEmpty(list) && this.gSB != null && !x.isEmpty(this.gSB.getData())) {
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.gSB.getData()) {
                if ((nVar instanceof bz) && (bzVar = (bz) nVar) != null && bzVar.bnQ() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bzVar.bnQ().live_id) {
                            linkedList.add(bzVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.gSB.getData().removeAll(linkedList);
                if (this.gSF != null) {
                    this.gSF.mG(this.gSB.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gwj != null) {
            this.gwj.reset(i);
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

    @Override // com.baidu.tieba.frs.ap
    public NavigationBar bUz() {
        return this.gSC.bUz();
    }
}
