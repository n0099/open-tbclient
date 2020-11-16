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
import com.baidu.tbadk.core.data.bx;
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
import com.baidu.tieba.frs.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, at {
    private int ajv;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private boolean gCv;
    private AlaFrsLiveModel gCw;
    private c gCx;
    private AlaSquareRefreshManager ghF;
    private int gwu = 1;
    private boolean gCy = false;
    private boolean gCz = false;
    private CustomMessageListener goZ = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bPo();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bPo();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gCA = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void lS(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gCx != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gCx.getRootView());
                AlaFrsLiveFragment.this.gCx.completePullRefresh();
                AlaFrsLiveFragment.this.gCx.d(AlaFrsLiveFragment.this.gCw.getData(), z, AlaFrsLiveFragment.this.gCw.bSg());
                AlaFrsLiveFragment.this.gCx.uE(AlaFrsLiveFragment.this.gCw.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gCw.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gwu == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gCy = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gCx.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gCx.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aC(int i, String str) {
            if (AlaFrsLiveFragment.this.gCx != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gCx.getRootView());
                AlaFrsLiveFragment.this.gCx.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gCw.getData()) <= 0 || AlaFrsLiveFragment.this.gCx == null) {
                AlaFrsLiveFragment.this.gCy = true;
                if (AlaFrsLiveFragment.this.gCx != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gCx.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private f gCB = new f() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.f
        public void R(bx bxVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bxVar);
        }
    };
    private f.c grC = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gCw != null) {
                AlaFrsLiveFragment.this.gCw.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gCC = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gCw != null) {
                z = AlaFrsLiveFragment.this.gCw.bPu();
            }
            if (AlaFrsLiveFragment.this.gCx != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gCx.bOq();
                } else {
                    AlaFrsLiveFragment.this.gCx.bOp();
                }
            }
        }
    };
    private d gCD = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void va(int i) {
            if (AlaFrsLiveFragment.this.gCw != null && AlaFrsLiveFragment.this.gCw.getSortType() != i) {
                ar arVar = new ar("c12572");
                arVar.dR("fid", AlaFrsLiveFragment.this.forumId);
                arVar.ak("obj_type", i);
                TiebaStatic.log(arVar);
                AlaFrsLiveFragment.this.gCw.setSortType(i);
                AlaFrsLiveFragment.this.gCw.clearData();
                if (AlaFrsLiveFragment.this.gCx != null) {
                    AlaFrsLiveFragment.this.gCx.bSi().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ajv = i;
        if (this.gCx != null) {
            this.gCx.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.goZ, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gCx = new c(getPageContext(), this.gCv, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gCz);
        this.gCx.initView();
        this.gCx.vb(1);
        this.gCx.b(this.gCB);
        this.gCx.setListPullRefreshListener(this.grC);
        this.gCx.setOnSrollToBottomListener(this.gCC);
        this.gCx.a(this.gCD);
        this.gCx.onChangeSkinType(this.ajv);
        bRZ();
        return this.gCx.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ghF != null) {
            this.ghF.onPause();
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
            if (this.gCw == null) {
                this.gCw = new AlaFrsLiveModel(getPageContext());
                this.gCw.a(this.gCA);
                this.gCw.setForumId(this.forumId);
                this.gCw.setForumGameLabel(this.forumGameLabel);
                this.gCw.setFromType(this.gwu);
                this.gCw.refreshData();
                if (this.gCx != null) {
                    showLoadingView(this.gCx.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.ghF = new AlaSquareRefreshManager();
                this.ghF.init(this, new long[]{30000});
            } else if (this.ghF != null) {
                this.ghF.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ghF != null) {
            this.ghF.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gCy) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gCw != null) {
            this.gCw.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bx bxVar) {
        bx bxVar2;
        if (tbPageContext != null && bxVar != null && bxVar.blC() != null && bxVar.blW() != null) {
            ar arVar = new ar("c12571");
            arVar.dR("fid", this.forumId);
            arVar.ak("obj_type", bxVar.blW().live_type);
            TiebaStatic.log(arVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bxVar.blC().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.gCw.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bxVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).evQ) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(bxVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bx bxVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bxVar.blW());
        alaLiveInfoCoreData.userName = bxVar.blC().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPo() {
        if (this.gCx != null) {
            this.gCx.bPo();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bRZ() {
        if (this.gCx != null && this.gCx.bSa() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gCx.bSa().setCenterTextTitle(sb.toString());
        }
    }

    public void mn(boolean z) {
        this.gCv = z;
    }

    public void setFromType(int i) {
        this.gwu = i;
    }

    public void mo(boolean z) {
        this.gCz = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bx bxVar;
        if (this.gCw == null || y.isEmpty(this.gCw.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.gCw.getData()) {
            if ((qVar instanceof bx) && (bxVar = (bx) qVar) != null && bxVar.blW() != null) {
                linkedList.add(Long.valueOf(bxVar.blW().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bx bxVar;
        Long l;
        if (!y.isEmpty(list) && this.gCw != null && !y.isEmpty(this.gCw.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.gCw.getData()) {
                if ((qVar instanceof bx) && (bxVar = (bx) qVar) != null && bxVar.blW() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bxVar.blW().live_id) {
                            linkedList.add(bxVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.gCw.getData().removeAll(linkedList);
                if (this.gCA != null) {
                    this.gCA.lS(this.gCw.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ghF != null) {
            this.ghF.reset(i);
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
    public NavigationBar bSa() {
        return this.gCx.bSa();
    }
}
