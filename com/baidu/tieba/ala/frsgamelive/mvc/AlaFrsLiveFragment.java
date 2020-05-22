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
    private AlaSquareRefreshManager faI;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private c fuA;
    private boolean fuy;
    private AlaFrsLiveModel fuz;
    private int fpq = 1;
    private boolean fuB = false;
    private boolean fuC = false;
    private CustomMessageListener fhS = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.brJ();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.brJ();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a fuD = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void jz(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.fuA != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fuA.getRootView());
                AlaFrsLiveFragment.this.fuA.completePullRefresh();
                AlaFrsLiveFragment.this.fuA.e(AlaFrsLiveFragment.this.fuz.getData(), z, AlaFrsLiveFragment.this.fuz.bue());
                AlaFrsLiveFragment.this.fuA.pL(AlaFrsLiveFragment.this.fuz.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.fuz.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.fpq == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.fuB = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fuA.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.fuA.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void al(int i, String str) {
            if (AlaFrsLiveFragment.this.fuA != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fuA.getRootView());
                AlaFrsLiveFragment.this.fuA.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.fuz.getData()) <= 0 || AlaFrsLiveFragment.this.fuA == null) {
                AlaFrsLiveFragment.this.fuB = true;
                if (AlaFrsLiveFragment.this.fuA != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fuA.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d fuE = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void Q(bk bkVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bkVar);
        }
    };
    private f.c fkx = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.fuz != null) {
                AlaFrsLiveFragment.this.fuz.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener fuF = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.fuz != null) {
                z = AlaFrsLiveFragment.this.fuz.brR();
            }
            if (AlaFrsLiveFragment.this.fuA != null) {
                if (z) {
                    AlaFrsLiveFragment.this.fuA.bqK();
                } else {
                    AlaFrsLiveFragment.this.fuA.bqJ();
                }
            }
        }
    };
    private d fuG = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void qg(int i) {
            if (AlaFrsLiveFragment.this.fuz != null && AlaFrsLiveFragment.this.fuz.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.dh("fid", AlaFrsLiveFragment.this.forumId);
                anVar.ag("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.fuz.setSortType(i);
                AlaFrsLiveFragment.this.fuz.clearData();
                if (AlaFrsLiveFragment.this.fuA != null) {
                    AlaFrsLiveFragment.this.fuA.bug().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.agt = i;
        if (this.fuA != null) {
            this.fuA.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fhS, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fuA = new c(getPageContext(), this.fuy, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.fuC);
        this.fuA.initView();
        this.fuA.qh(1);
        this.fuA.b(this.fuE);
        this.fuA.setListPullRefreshListener(this.fkx);
        this.fuA.setOnSrollToBottomListener(this.fuF);
        this.fuA.a(this.fuG);
        this.fuA.onChangeSkinType(this.agt);
        btX();
        return this.fuA.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.faI != null) {
            this.faI.onPause();
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
            if (this.fuz == null) {
                this.fuz = new AlaFrsLiveModel(getPageContext());
                this.fuz.a(this.fuD);
                this.fuz.setForumId(this.forumId);
                this.fuz.setForumGameLabel(this.forumGameLabel);
                this.fuz.setFromType(this.fpq);
                this.fuz.refreshData();
                if (this.fuA != null) {
                    showLoadingView(this.fuA.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.faI = new AlaSquareRefreshManager();
                this.faI.init(this, new long[]{30000});
            } else if (this.faI != null) {
                this.faI.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.faI != null) {
            this.faI.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.fuB) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.fuz != null) {
            this.fuz.refreshData();
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
            for (o oVar : this.fuz.getData()) {
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
    public void brJ() {
        if (this.fuA != null) {
            this.fuA.brJ();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void btX() {
        if (this.fuA != null && this.fuA.btY() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.fuA.btY().setCenterTextTitle(sb.toString());
        }
    }

    public void jT(boolean z) {
        this.fuy = z;
    }

    public void setFromType(int i) {
        this.fpq = i;
    }

    public void jU(boolean z) {
        this.fuC = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bk bkVar;
        if (this.fuz == null || v.isEmpty(this.fuz.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (o oVar : this.fuz.getData()) {
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
        if (!v.isEmpty(list) && this.fuz != null && !v.isEmpty(this.fuz.getData())) {
            LinkedList linkedList = new LinkedList();
            for (o oVar : this.fuz.getData()) {
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
                this.fuz.getData().removeAll(linkedList);
                if (this.fuD != null) {
                    this.fuD.jz(this.fuz.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.faI != null) {
            this.faI.reset(i);
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
    public NavigationBar btY() {
        return this.fuA.btY();
    }
}
