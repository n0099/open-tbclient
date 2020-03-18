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
import com.baidu.tieba.frs.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, aj {
    private int Nj;
    private boolean eCr;
    private AlaFrsLiveModel eCs;
    private c eCt;
    private AlaSquareRefreshManager ekw;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int mFromType = 1;
    private boolean eCu = false;
    private boolean eCv = false;
    private CustomMessageListener erJ = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bdw();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bdw();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a eCw = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void ig(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.eCt != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.eCt.getRootView());
                AlaFrsLiveFragment.this.eCt.completePullRefresh();
                AlaFrsLiveFragment.this.eCt.e(AlaFrsLiveFragment.this.eCs.getData(), z, AlaFrsLiveFragment.this.eCs.beX());
                AlaFrsLiveFragment.this.eCt.oR(AlaFrsLiveFragment.this.eCs.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.eCs.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.mFromType == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.eCu = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.eCt.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.eCt.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void ag(int i, String str) {
            if (AlaFrsLiveFragment.this.eCt != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.eCt.getRootView());
                AlaFrsLiveFragment.this.eCt.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.eCs.getData()) <= 0 || AlaFrsLiveFragment.this.eCt == null) {
                AlaFrsLiveFragment.this.eCu = true;
                if (AlaFrsLiveFragment.this.eCt != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.eCt.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d eCx = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void P(bj bjVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bjVar);
        }
    };
    private g.c eun = new g.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.eCs != null) {
                AlaFrsLiveFragment.this.eCs.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener eCy = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.eCs != null) {
                z = AlaFrsLiveFragment.this.eCs.bdE();
            }
            if (AlaFrsLiveFragment.this.eCt != null) {
                if (z) {
                    AlaFrsLiveFragment.this.eCt.bcz();
                } else {
                    AlaFrsLiveFragment.this.eCt.bcy();
                }
            }
        }
    };
    private d eCz = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void pk(int i) {
            if (AlaFrsLiveFragment.this.eCs != null && AlaFrsLiveFragment.this.eCs.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.cx("fid", AlaFrsLiveFragment.this.forumId);
                anVar.X("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.eCs.setSortType(i);
                AlaFrsLiveFragment.this.eCs.clearData();
                if (AlaFrsLiveFragment.this.eCt != null) {
                    AlaFrsLiveFragment.this.eCt.bfa().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.Nj = i;
        if (this.eCt != null) {
            this.eCt.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.erJ, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eCt = new c(getPageContext(), this.eCr, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.eCv);
        this.eCt.initView();
        this.eCt.pl(1);
        this.eCt.b(this.eCx);
        this.eCt.setListPullRefreshListener(this.eun);
        this.eCt.setOnSrollToBottomListener(this.eCy);
        this.eCt.a(this.eCz);
        this.eCt.onChangeSkinType(this.Nj);
        beQ();
        return this.eCt.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ekw != null) {
            this.ekw.onPause();
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
            if (this.eCs == null) {
                this.eCs = new AlaFrsLiveModel(getPageContext());
                this.eCs.a(this.eCw);
                this.eCs.setForumId(this.forumId);
                this.eCs.setForumGameLabel(this.forumGameLabel);
                this.eCs.setFromType(this.mFromType);
                this.eCs.refreshData();
                if (this.eCt != null) {
                    showLoadingView(this.eCt.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.ekw = new AlaSquareRefreshManager();
                this.ekw.init(this, new long[]{30000});
            } else if (this.ekw != null) {
                this.ekw.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ekw != null) {
            this.ekw.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.eCu) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.eCs != null) {
            this.eCs.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        bj bjVar2;
        if (tbPageContext != null && bjVar != null && bjVar.aCr() != null && bjVar.aCK() != null) {
            an anVar = new an("c12571");
            anVar.cx("fid", this.forumId);
            anVar.X("obj_type", bjVar.aCK().live_type);
            TiebaStatic.log(anVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCr().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (m mVar : this.eCs.getData()) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bjVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) mVar).cRt) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCK());
        alaLiveInfoCoreData.userName = bjVar.aCr().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdw() {
        if (this.eCt != null) {
            this.eCt.bdw();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void beQ() {
        if (this.eCt != null && this.eCt.beR() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.eCt.beR().setCenterTextTitle(sb.toString());
        }
    }

    public void iz(boolean z) {
        this.eCr = z;
    }

    public void setFromType(int i) {
        this.mFromType = i;
    }

    public void iA(boolean z) {
        this.eCv = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bj bjVar;
        if (this.eCs == null || v.isEmpty(this.eCs.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (m mVar : this.eCs.getData()) {
            if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aCK() != null) {
                linkedList.add(Long.valueOf(bjVar.aCK().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bj bjVar;
        Long l;
        if (!v.isEmpty(list) && this.eCs != null && !v.isEmpty(this.eCs.getData())) {
            LinkedList linkedList = new LinkedList();
            for (m mVar : this.eCs.getData()) {
                if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aCK() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bjVar.aCK().live_id) {
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
                this.eCs.getData().removeAll(linkedList);
                if (this.eCw != null) {
                    this.eCw.ig(this.eCs.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ekw != null) {
            this.ekw.reset(i);
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

    @Override // com.baidu.tieba.frs.aj
    public NavigationBar beR() {
        return this.eCt.beR();
    }
}
