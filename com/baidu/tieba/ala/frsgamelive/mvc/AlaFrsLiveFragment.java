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
    private boolean gLs;
    private AlaFrsLiveModel gLt;
    private c gLu;
    private AlaSquareRefreshManager gpP;
    private int gFf = 1;
    private boolean gLv = false;
    private boolean gLw = false;
    private CustomMessageListener gxi = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bSZ();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bSZ();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gLx = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void mn(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gLu != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gLu.getRootView());
                AlaFrsLiveFragment.this.gLu.completePullRefresh();
                AlaFrsLiveFragment.this.gLu.d(AlaFrsLiveFragment.this.gLt.getData(), z, AlaFrsLiveFragment.this.gLt.bVQ());
                AlaFrsLiveFragment.this.gLu.vi(AlaFrsLiveFragment.this.gLt.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gLt.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gFf == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gLv = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gLu.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gLu.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aC(int i, String str) {
            if (AlaFrsLiveFragment.this.gLu != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gLu.getRootView());
                AlaFrsLiveFragment.this.gLu.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gLt.getData()) <= 0 || AlaFrsLiveFragment.this.gLu == null) {
                AlaFrsLiveFragment.this.gLv = true;
                if (AlaFrsLiveFragment.this.gLu != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gLu.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private f gLy = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.f
        public void R(by byVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), byVar);
        }
    };
    private f.c gzL = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gLt != null) {
                AlaFrsLiveFragment.this.gLt.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gLz = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gLt != null) {
                z = AlaFrsLiveFragment.this.gLt.bTf();
            }
            if (AlaFrsLiveFragment.this.gLu != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gLu.bSb();
                } else {
                    AlaFrsLiveFragment.this.gLu.bSa();
                }
            }
        }
    };
    private d gLA = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void vH(int i) {
            if (AlaFrsLiveFragment.this.gLt != null && AlaFrsLiveFragment.this.gLt.getSortType() != i) {
                ar arVar = new ar("c12572");
                arVar.dY("fid", AlaFrsLiveFragment.this.forumId);
                arVar.al("obj_type", i);
                TiebaStatic.log(arVar);
                AlaFrsLiveFragment.this.gLt.setSortType(i);
                AlaFrsLiveFragment.this.gLt.clearData();
                if (AlaFrsLiveFragment.this.gLu != null) {
                    AlaFrsLiveFragment.this.gLu.bVS().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aku = i;
        if (this.gLu != null) {
            this.gLu.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gxi, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gLu = new c(getPageContext(), this.gLs, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gLw);
        this.gLu.initView();
        this.gLu.vI(1);
        this.gLu.b(this.gLy);
        this.gLu.setListPullRefreshListener(this.gzL);
        this.gLu.setOnSrollToBottomListener(this.gLz);
        this.gLu.a(this.gLA);
        this.gLu.onChangeSkinType(this.aku);
        bVJ();
        return this.gLu.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gpP != null) {
            this.gpP.onPause();
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
            if (this.gLt == null) {
                this.gLt = new AlaFrsLiveModel(getPageContext());
                this.gLt.a(this.gLx);
                this.gLt.setForumId(this.forumId);
                this.gLt.setForumGameLabel(this.forumGameLabel);
                this.gLt.setFromType(this.gFf);
                this.gLt.refreshData();
                if (this.gLu != null) {
                    showLoadingView(this.gLu.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.gpP = new AlaSquareRefreshManager();
                this.gpP.init(this, new long[]{30000});
            } else if (this.gpP != null) {
                this.gpP.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gpP != null) {
            this.gpP.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gLv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gLt != null) {
            this.gLt.refreshData();
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
            for (q qVar : this.gLt.getData()) {
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
    public void bSZ() {
        if (this.gLu != null) {
            this.gLu.bSZ();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bVJ() {
        if (this.gLu != null && this.gLu.bVK() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gLu.bVK().setCenterTextTitle(sb.toString());
        }
    }

    public void mI(boolean z) {
        this.gLs = z;
    }

    public void setFromType(int i) {
        this.gFf = i;
    }

    public void mJ(boolean z) {
        this.gLw = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        by byVar;
        if (this.gLt == null || y.isEmpty(this.gLt.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.gLt.getData()) {
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
        if (!y.isEmpty(list) && this.gLt != null && !y.isEmpty(this.gLt.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.gLt.getData()) {
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
                this.gLt.getData().removeAll(linkedList);
                if (this.gLx != null) {
                    this.gLx.mn(this.gLt.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gpP != null) {
            this.gpP.reset(i);
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
    public NavigationBar bVK() {
        return this.gLu.bVK();
    }
}
