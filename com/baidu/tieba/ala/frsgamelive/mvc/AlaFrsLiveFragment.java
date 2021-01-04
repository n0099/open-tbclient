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
/* loaded from: classes10.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ap {
    private int akW;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private AlaSquareRefreshManager gAQ;
    private boolean gXg;
    private AlaFrsLiveModel gXh;
    private c gXi;
    private int gQS = 1;
    private boolean gXj = false;
    private boolean gXk = false;
    private CustomMessageListener gIn = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bVE();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bVE();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gXl = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void mK(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gXi != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gXi.getRootView());
                AlaFrsLiveFragment.this.gXi.completePullRefresh();
                AlaFrsLiveFragment.this.gXi.d(AlaFrsLiveFragment.this.gXh.getData(), z, AlaFrsLiveFragment.this.gXh.bYw());
                AlaFrsLiveFragment.this.gXi.vt(AlaFrsLiveFragment.this.gXh.getLiveCount());
                if (x.getCount(AlaFrsLiveFragment.this.gXh.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gQS == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gXj = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gXi.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gXi.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aE(int i, String str) {
            if (AlaFrsLiveFragment.this.gXi != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gXi.getRootView());
                AlaFrsLiveFragment.this.gXi.completePullRefresh();
            }
            if (x.getCount(AlaFrsLiveFragment.this.gXh.getData()) <= 0 || AlaFrsLiveFragment.this.gXi == null) {
                AlaFrsLiveFragment.this.gXj = true;
                if (AlaFrsLiveFragment.this.gXi != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gXi.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private g gXm = new g() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.g
        public void R(bz bzVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bzVar);
        }
    };
    private f.c gKQ = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gXh != null) {
                AlaFrsLiveFragment.this.gXh.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gXn = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gXh != null) {
                z = AlaFrsLiveFragment.this.gXh.bVK();
            }
            if (AlaFrsLiveFragment.this.gXi != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gXi.bUE();
                } else {
                    AlaFrsLiveFragment.this.gXi.bUD();
                }
            }
        }
    };
    private d gXo = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void vS(int i) {
            if (AlaFrsLiveFragment.this.gXh != null && AlaFrsLiveFragment.this.gXh.getSortType() != i) {
                aq aqVar = new aq("c12572");
                aqVar.dX("fid", AlaFrsLiveFragment.this.forumId);
                aqVar.an("obj_type", i);
                TiebaStatic.log(aqVar);
                AlaFrsLiveFragment.this.gXh.setSortType(i);
                AlaFrsLiveFragment.this.gXh.clearData();
                if (AlaFrsLiveFragment.this.gXi != null) {
                    AlaFrsLiveFragment.this.gXi.bYy().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.akW = i;
        if (this.gXi != null) {
            this.gXi.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gIn, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gXi = new c(getPageContext(), this.gXg, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gXk);
        this.gXi.initView();
        this.gXi.vT(1);
        this.gXi.b(this.gXm);
        this.gXi.setListPullRefreshListener(this.gKQ);
        this.gXi.setOnSrollToBottomListener(this.gXn);
        this.gXi.a(this.gXo);
        this.gXi.onChangeSkinType(this.akW);
        bYp();
        return this.gXi.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gAQ != null) {
            this.gAQ.onPause();
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
            if (this.gXh == null) {
                this.gXh = new AlaFrsLiveModel(getPageContext());
                this.gXh.a(this.gXl);
                this.gXh.setForumId(this.forumId);
                this.gXh.setForumGameLabel(this.forumGameLabel);
                this.gXh.setFromType(this.gQS);
                this.gXh.refreshData();
                if (this.gXi != null) {
                    showLoadingView(this.gXi.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.gAQ = new AlaSquareRefreshManager();
                this.gAQ.init(this, new long[]{30000});
            } else if (this.gAQ != null) {
                this.gAQ.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gAQ != null) {
            this.gAQ.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gXj) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gXh != null) {
            this.gXh.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bz bzVar) {
        bz bzVar2;
        if (tbPageContext != null && bzVar != null && bzVar.brq() != null && bzVar.brJ() != null) {
            aq aqVar = new aq("c12571");
            aqVar.dX("fid", this.forumId);
            aqVar.an("obj_type", bzVar.brJ().live_type);
            TiebaStatic.log(aqVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bzVar.brq().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (n nVar : this.gXh.getData()) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bzVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) nVar).eMv) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bzVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bz bzVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bzVar.brJ());
        alaLiveInfoCoreData.userName = bzVar.brq().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVE() {
        if (this.gXi != null) {
            this.gXi.bVE();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bYp() {
        if (this.gXi != null && this.gXi.bYq() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gXi.bYq().setCenterTextTitle(sb.toString());
        }
    }

    public void ni(boolean z) {
        this.gXg = z;
    }

    public void setFromType(int i) {
        this.gQS = i;
    }

    public void nj(boolean z) {
        this.gXk = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bz bzVar;
        if (this.gXh == null || x.isEmpty(this.gXh.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.gXh.getData()) {
            if ((nVar instanceof bz) && (bzVar = (bz) nVar) != null && bzVar.brJ() != null) {
                linkedList.add(Long.valueOf(bzVar.brJ().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bz bzVar;
        Long l;
        if (!x.isEmpty(list) && this.gXh != null && !x.isEmpty(this.gXh.getData())) {
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.gXh.getData()) {
                if ((nVar instanceof bz) && (bzVar = (bz) nVar) != null && bzVar.brJ() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bzVar.brJ().live_id) {
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
                this.gXh.getData().removeAll(linkedList);
                if (this.gXl != null) {
                    this.gXl.mK(this.gXh.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gAQ != null) {
            this.gAQ.reset(i);
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
    public NavigationBar bYq() {
        return this.gXi.bYq();
    }
}
