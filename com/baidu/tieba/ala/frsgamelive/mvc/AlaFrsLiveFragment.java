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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.f;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.frs.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, as {
    private int aku;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private boolean gLu;
    private AlaFrsLiveModel gLv;
    private c gLw;
    private AlaSquareRefreshManager gpR;
    private int gFh = 1;
    private boolean gLx = false;
    private boolean gLy = false;
    private CustomMessageListener gxk = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bTa();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bTa();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gLz = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void mn(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gLw != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gLw.getRootView());
                AlaFrsLiveFragment.this.gLw.completePullRefresh();
                AlaFrsLiveFragment.this.gLw.d(AlaFrsLiveFragment.this.gLv.getData(), z, AlaFrsLiveFragment.this.gLv.bVR());
                AlaFrsLiveFragment.this.gLw.vi(AlaFrsLiveFragment.this.gLv.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gLv.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gFh == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gLx = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gLw.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gLw.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aC(int i, String str) {
            if (AlaFrsLiveFragment.this.gLw != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gLw.getRootView());
                AlaFrsLiveFragment.this.gLw.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gLv.getData()) <= 0 || AlaFrsLiveFragment.this.gLw == null) {
                AlaFrsLiveFragment.this.gLx = true;
                if (AlaFrsLiveFragment.this.gLw != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gLw.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private f gLA = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.f
        public void R(by byVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), byVar);
        }
    };
    private f.c gzN = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gLv != null) {
                AlaFrsLiveFragment.this.gLv.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gLB = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gLv != null) {
                z = AlaFrsLiveFragment.this.gLv.bTg();
            }
            if (AlaFrsLiveFragment.this.gLw != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gLw.bSc();
                } else {
                    AlaFrsLiveFragment.this.gLw.bSb();
                }
            }
        }
    };
    private d gLC = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void vH(int i) {
            if (AlaFrsLiveFragment.this.gLv != null && AlaFrsLiveFragment.this.gLv.getSortType() != i) {
                ar arVar = new ar("c12572");
                arVar.dY("fid", AlaFrsLiveFragment.this.forumId);
                arVar.al("obj_type", i);
                TiebaStatic.log(arVar);
                AlaFrsLiveFragment.this.gLv.setSortType(i);
                AlaFrsLiveFragment.this.gLv.clearData();
                if (AlaFrsLiveFragment.this.gLw != null) {
                    AlaFrsLiveFragment.this.gLw.bVT().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aku = i;
        if (this.gLw != null) {
            this.gLw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gxk, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gLw = new c(getPageContext(), this.gLu, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gLy);
        this.gLw.initView();
        this.gLw.vI(1);
        this.gLw.b(this.gLA);
        this.gLw.setListPullRefreshListener(this.gzN);
        this.gLw.setOnSrollToBottomListener(this.gLB);
        this.gLw.a(this.gLC);
        this.gLw.onChangeSkinType(this.aku);
        bVK();
        return this.gLw.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gpR != null) {
            this.gpR.onPause();
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
            if (this.gLv == null) {
                this.gLv = new AlaFrsLiveModel(getPageContext());
                this.gLv.a(this.gLz);
                this.gLv.setForumId(this.forumId);
                this.gLv.setForumGameLabel(this.forumGameLabel);
                this.gLv.setFromType(this.gFh);
                this.gLv.refreshData();
                if (this.gLw != null) {
                    showLoadingView(this.gLw.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.gpR = new AlaSquareRefreshManager();
                this.gpR.init(this, new long[]{30000});
            } else if (this.gpR != null) {
                this.gpR.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gpR != null) {
            this.gpR.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gLx) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gLv != null) {
            this.gLv.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, by byVar) {
        by byVar2;
        if (tbPageContext != null && byVar != null && byVar.boP() != null && byVar.bpj() != null) {
            ar arVar = new ar("c12571");
            arVar.dY("fid", this.forumId);
            arVar.al("obj_type", byVar.bpj().live_type);
            TiebaStatic.log(arVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = byVar.boP().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.gLv.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (byVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).eCR) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(byVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData V(by byVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(byVar.bpj());
        alaLiveInfoCoreData.userName = byVar.boP().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTa() {
        if (this.gLw != null) {
            this.gLw.bTa();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bVK() {
        if (this.gLw != null && this.gLw.bVL() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gLw.bVL().setCenterTextTitle(sb.toString());
        }
    }

    public void mI(boolean z) {
        this.gLu = z;
    }

    public void setFromType(int i) {
        this.gFh = i;
    }

    public void mJ(boolean z) {
        this.gLy = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        by byVar;
        if (this.gLv == null || y.isEmpty(this.gLv.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.gLv.getData()) {
            if ((qVar instanceof by) && (byVar = (by) qVar) != null && byVar.bpj() != null) {
                linkedList.add(Long.valueOf(byVar.bpj().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        by byVar;
        Long l;
        if (!y.isEmpty(list) && this.gLv != null && !y.isEmpty(this.gLv.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.gLv.getData()) {
                if ((qVar instanceof by) && (byVar = (by) qVar) != null && byVar.bpj() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == byVar.bpj().live_id) {
                            linkedList.add(byVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.gLv.getData().removeAll(linkedList);
                if (this.gLz != null) {
                    this.gLz.mn(this.gLv.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gpR != null) {
            this.gpR.reset(i);
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

    @Override // com.baidu.tieba.frs.as
    public NavigationBar bVL() {
        return this.gLw.bVL();
    }
}
