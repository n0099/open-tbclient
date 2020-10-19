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
    private int ajp;
    private AlaSquareRefreshManager fSg;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private boolean gmV;
    private AlaFrsLiveModel gmW;
    private c gmX;
    private int ggW = 1;
    private boolean gmY = false;
    private boolean gmZ = false;
    private CustomMessageListener fZA = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bKT();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bKT();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gna = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void lq(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gmX != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gmX.getRootView());
                AlaFrsLiveFragment.this.gmX.completePullRefresh();
                AlaFrsLiveFragment.this.gmX.d(AlaFrsLiveFragment.this.gmW.getData(), z, AlaFrsLiveFragment.this.gmW.bNI());
                AlaFrsLiveFragment.this.gmX.tD(AlaFrsLiveFragment.this.gmW.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gmW.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.ggW == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gmY = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gmX.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gmX.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void ay(int i, String str) {
            if (AlaFrsLiveFragment.this.gmX != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gmX.getRootView());
                AlaFrsLiveFragment.this.gmX.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gmW.getData()) <= 0 || AlaFrsLiveFragment.this.gmX == null) {
                AlaFrsLiveFragment.this.gmY = true;
                if (AlaFrsLiveFragment.this.gmX != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gmX.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private f gnb = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.f
        public void P(bw bwVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bwVar);
        }
    };
    private f.c gce = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gmW != null) {
                AlaFrsLiveFragment.this.gmW.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gnc = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gmW != null) {
                z = AlaFrsLiveFragment.this.gmW.bKZ();
            }
            if (AlaFrsLiveFragment.this.gmX != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gmX.bJV();
                } else {
                    AlaFrsLiveFragment.this.gmX.bJU();
                }
            }
        }
    };
    private d gnd = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void ua(int i) {
            if (AlaFrsLiveFragment.this.gmW != null && AlaFrsLiveFragment.this.gmW.getSortType() != i) {
                aq aqVar = new aq("c12572");
                aqVar.dK("fid", AlaFrsLiveFragment.this.forumId);
                aqVar.aj("obj_type", i);
                TiebaStatic.log(aqVar);
                AlaFrsLiveFragment.this.gmW.setSortType(i);
                AlaFrsLiveFragment.this.gmW.clearData();
                if (AlaFrsLiveFragment.this.gmX != null) {
                    AlaFrsLiveFragment.this.gmX.bNK().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ajp = i;
        if (this.gmX != null) {
            this.gmX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fZA, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gmX = new c(getPageContext(), this.gmV, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gmZ);
        this.gmX.initView();
        this.gmX.ub(1);
        this.gmX.b(this.gnb);
        this.gmX.setListPullRefreshListener(this.gce);
        this.gmX.setOnSrollToBottomListener(this.gnc);
        this.gmX.a(this.gnd);
        this.gmX.onChangeSkinType(this.ajp);
        bNB();
        return this.gmX.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fSg != null) {
            this.fSg.onPause();
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
            if (this.gmW == null) {
                this.gmW = new AlaFrsLiveModel(getPageContext());
                this.gmW.a(this.gna);
                this.gmW.setForumId(this.forumId);
                this.gmW.setForumGameLabel(this.forumGameLabel);
                this.gmW.setFromType(this.ggW);
                this.gmW.refreshData();
                if (this.gmX != null) {
                    showLoadingView(this.gmX.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.fSg = new AlaSquareRefreshManager();
                this.fSg.init(this, new long[]{30000});
            } else if (this.fSg != null) {
                this.fSg.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fSg != null) {
            this.fSg.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gmY) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gmW != null) {
            this.gmW.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        bw bwVar2;
        if (tbPageContext != null && bwVar != null && bwVar.bih() != null && bwVar.biB() != null) {
            aq aqVar = new aq("c12571");
            aqVar.dK("fid", this.forumId);
            aqVar.aj("obj_type", bwVar.biB().live_type);
            TiebaStatic.log(aqVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.bih().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.biB());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.gmW.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bwVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).eji) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(T(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData T(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.biB());
        alaLiveInfoCoreData.userName = bwVar.bih().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKT() {
        if (this.gmX != null) {
            this.gmX.bKT();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bNB() {
        if (this.gmX != null && this.gmX.bNC() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gmX.bNC().setCenterTextTitle(sb.toString());
        }
    }

    public void lN(boolean z) {
        this.gmV = z;
    }

    public void setFromType(int i) {
        this.ggW = i;
    }

    public void lO(boolean z) {
        this.gmZ = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bw bwVar;
        if (this.gmW == null || y.isEmpty(this.gmW.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.gmW.getData()) {
            if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.biB() != null) {
                linkedList.add(Long.valueOf(bwVar.biB().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bw bwVar;
        Long l;
        if (!y.isEmpty(list) && this.gmW != null && !y.isEmpty(this.gmW.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.gmW.getData()) {
                if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.biB() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bwVar.biB().live_id) {
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
                this.gmW.getData().removeAll(linkedList);
                if (this.gna != null) {
                    this.gna.lq(this.gmW.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fSg != null) {
            this.fSg.reset(i);
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
    public NavigationBar bNC() {
        return this.gmX.bNC();
    }
}
