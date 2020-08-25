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
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.frs.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, at {
    private int aiB;
    private AlaSquareRefreshManager fCH;
    private boolean fXm;
    private AlaFrsLiveModel fXn;
    private c fXo;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int fRo = 1;
    private boolean fXp = false;
    private boolean fXq = false;
    private CustomMessageListener fJR = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bGQ();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bGQ();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a fXr = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void kO(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.fXo != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fXo.getRootView());
                AlaFrsLiveFragment.this.fXo.completePullRefresh();
                AlaFrsLiveFragment.this.fXo.d(AlaFrsLiveFragment.this.fXn.getData(), z, AlaFrsLiveFragment.this.fXn.bJN());
                AlaFrsLiveFragment.this.fXo.sN(AlaFrsLiveFragment.this.fXn.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.fXn.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.fRo == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.fXp = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fXo.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.fXo.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void am(int i, String str) {
            if (AlaFrsLiveFragment.this.fXo != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fXo.getRootView());
                AlaFrsLiveFragment.this.fXo.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.fXn.getData()) <= 0 || AlaFrsLiveFragment.this.fXo == null) {
                AlaFrsLiveFragment.this.fXp = true;
                if (AlaFrsLiveFragment.this.fXo != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fXo.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private e fXs = new e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.e
        public void O(bw bwVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bwVar);
        }
    };
    private f.c fMu = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.fXn != null) {
                AlaFrsLiveFragment.this.fXn.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener fXt = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.fXn != null) {
                z = AlaFrsLiveFragment.this.fXn.bGY();
            }
            if (AlaFrsLiveFragment.this.fXo != null) {
                if (z) {
                    AlaFrsLiveFragment.this.fXo.bFS();
                } else {
                    AlaFrsLiveFragment.this.fXo.bFR();
                }
            }
        }
    };
    private d fXu = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void tj(int i) {
            if (AlaFrsLiveFragment.this.fXn != null && AlaFrsLiveFragment.this.fXn.getSortType() != i) {
                aq aqVar = new aq("c12572");
                aqVar.dD("fid", AlaFrsLiveFragment.this.forumId);
                aqVar.ai("obj_type", i);
                TiebaStatic.log(aqVar);
                AlaFrsLiveFragment.this.fXn.setSortType(i);
                AlaFrsLiveFragment.this.fXn.clearData();
                if (AlaFrsLiveFragment.this.fXo != null) {
                    AlaFrsLiveFragment.this.fXo.bJP().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aiB = i;
        if (this.fXo != null) {
            this.fXo.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fJR, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fXo = new c(getPageContext(), this.fXm, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.fXq);
        this.fXo.initView();
        this.fXo.tk(1);
        this.fXo.b(this.fXs);
        this.fXo.setListPullRefreshListener(this.fMu);
        this.fXo.setOnSrollToBottomListener(this.fXt);
        this.fXo.a(this.fXu);
        this.fXo.onChangeSkinType(this.aiB);
        bJG();
        return this.fXo.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fCH != null) {
            this.fCH.onPause();
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
            if (this.fXn == null) {
                this.fXn = new AlaFrsLiveModel(getPageContext());
                this.fXn.a(this.fXr);
                this.fXn.setForumId(this.forumId);
                this.fXn.setForumGameLabel(this.forumGameLabel);
                this.fXn.setFromType(this.fRo);
                this.fXn.refreshData();
                if (this.fXo != null) {
                    showLoadingView(this.fXo.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.fCH = new AlaSquareRefreshManager();
                this.fCH.init(this, new long[]{30000});
            } else if (this.fCH != null) {
                this.fCH.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fCH != null) {
            this.fCH.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.fXp) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.fXn != null) {
            this.fXn.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bw bwVar) {
        bw bwVar2;
        if (tbPageContext != null && bwVar != null && bwVar.beE() != null && bwVar.beY() != null) {
            aq aqVar = new aq("c12571");
            aqVar.dD("fid", this.forumId);
            aqVar.ai("obj_type", bwVar.beY().live_type);
            TiebaStatic.log(aqVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bwVar.beE().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.fXn.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bwVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).dUS) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bwVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bw bwVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bwVar.beY());
        alaLiveInfoCoreData.userName = bwVar.beE().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGQ() {
        if (this.fXo != null) {
            this.fXo.bGQ();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bJG() {
        if (this.fXo != null && this.fXo.bJH() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.fXo.bJH().setCenterTextTitle(sb.toString());
        }
    }

    public void ll(boolean z) {
        this.fXm = z;
    }

    public void setFromType(int i) {
        this.fRo = i;
    }

    public void lm(boolean z) {
        this.fXq = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bw bwVar;
        if (this.fXn == null || y.isEmpty(this.fXn.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.fXn.getData()) {
            if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.beY() != null) {
                linkedList.add(Long.valueOf(bwVar.beY().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bw bwVar;
        Long l;
        if (!y.isEmpty(list) && this.fXn != null && !y.isEmpty(this.fXn.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.fXn.getData()) {
                if ((qVar instanceof bw) && (bwVar = (bw) qVar) != null && bwVar.beY() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bwVar.beY().live_id) {
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
                this.fXn.getData().removeAll(linkedList);
                if (this.fXr != null) {
                    this.fXr.kO(this.fXn.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fCH != null) {
            this.fCH.reset(i);
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
    public NavigationBar bJH() {
        return this.fXo.bJH();
    }
}
