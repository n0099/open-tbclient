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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.frs.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ar {
    private int ahx;
    private boolean fFT;
    private AlaFrsLiveModel fFU;
    private c fFV;
    private AlaSquareRefreshManager fmd;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int fAN = 1;
    private boolean fFW = false;
    private boolean fFX = false;
    private CustomMessageListener ftr = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.buI();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.buI();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a fFY = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void jM(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.fFV != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fFV.getRootView());
                AlaFrsLiveFragment.this.fFV.completePullRefresh();
                AlaFrsLiveFragment.this.fFV.e(AlaFrsLiveFragment.this.fFU.getData(), z, AlaFrsLiveFragment.this.fFU.bxc());
                AlaFrsLiveFragment.this.fFV.qm(AlaFrsLiveFragment.this.fFU.getLiveCount());
                if (w.getCount(AlaFrsLiveFragment.this.fFU.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.fAN == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.fFW = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fFV.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.fFV.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void an(int i, String str) {
            if (AlaFrsLiveFragment.this.fFV != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fFV.getRootView());
                AlaFrsLiveFragment.this.fFV.completePullRefresh();
            }
            if (w.getCount(AlaFrsLiveFragment.this.fFU.getData()) <= 0 || AlaFrsLiveFragment.this.fFV == null) {
                AlaFrsLiveFragment.this.fFW = true;
                if (AlaFrsLiveFragment.this.fFV != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fFV.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d fFZ = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void R(bu buVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), buVar);
        }
    };
    private f.c fvV = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.fFU != null) {
                AlaFrsLiveFragment.this.fFU.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener fGa = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.fFU != null) {
                z = AlaFrsLiveFragment.this.fFU.buQ();
            }
            if (AlaFrsLiveFragment.this.fFV != null) {
                if (z) {
                    AlaFrsLiveFragment.this.fFV.btK();
                } else {
                    AlaFrsLiveFragment.this.fFV.btJ();
                }
            }
        }
    };
    private d fGb = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void qH(int i) {
            if (AlaFrsLiveFragment.this.fFU != null && AlaFrsLiveFragment.this.fFU.getSortType() != i) {
                ao aoVar = new ao("c12572");
                aoVar.dk("fid", AlaFrsLiveFragment.this.forumId);
                aoVar.ag("obj_type", i);
                TiebaStatic.log(aoVar);
                AlaFrsLiveFragment.this.fFU.setSortType(i);
                AlaFrsLiveFragment.this.fFU.clearData();
                if (AlaFrsLiveFragment.this.fFV != null) {
                    AlaFrsLiveFragment.this.fFV.bxe().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ahx = i;
        if (this.fFV != null) {
            this.fFV.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.ftr, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fFV = new c(getPageContext(), this.fFT, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.fFX);
        this.fFV.initView();
        this.fFV.qI(1);
        this.fFV.b(this.fFZ);
        this.fFV.setListPullRefreshListener(this.fvV);
        this.fFV.setOnSrollToBottomListener(this.fGa);
        this.fFV.a(this.fGb);
        this.fFV.onChangeSkinType(this.ahx);
        bwV();
        return this.fFV.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fmd != null) {
            this.fmd.onPause();
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
            if (this.fFU == null) {
                this.fFU = new AlaFrsLiveModel(getPageContext());
                this.fFU.a(this.fFY);
                this.fFU.setForumId(this.forumId);
                this.fFU.setForumGameLabel(this.forumGameLabel);
                this.fFU.setFromType(this.fAN);
                this.fFU.refreshData();
                if (this.fFV != null) {
                    showLoadingView(this.fFV.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.fmd = new AlaSquareRefreshManager();
                this.fmd.init(this, new long[]{30000});
            } else if (this.fmd != null) {
                this.fmd.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.fmd != null) {
            this.fmd.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.fFW) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.fFU != null) {
            this.fFU.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bu buVar) {
        bu buVar2;
        if (tbPageContext != null && buVar != null && buVar.aSp() != null && buVar.aSJ() != null) {
            ao aoVar = new ao("c12571");
            aoVar.dk("fid", this.forumId);
            aoVar.ag("obj_type", buVar.aSJ().live_type);
            TiebaStatic.log(aoVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = buVar.aSp().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.fFU.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (buVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).dLi) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(V(buVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData V(bu buVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(buVar.aSJ());
        alaLiveInfoCoreData.userName = buVar.aSp().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buI() {
        if (this.fFV != null) {
            this.fFV.buI();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bwV() {
        if (this.fFV != null && this.fFV.bwW() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.fFV.bwW().setCenterTextTitle(sb.toString());
        }
    }

    public void kh(boolean z) {
        this.fFT = z;
    }

    public void setFromType(int i) {
        this.fAN = i;
    }

    public void ki(boolean z) {
        this.fFX = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bu buVar;
        if (this.fFU == null || w.isEmpty(this.fFU.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.fFU.getData()) {
            if ((qVar instanceof bu) && (buVar = (bu) qVar) != null && buVar.aSJ() != null) {
                linkedList.add(Long.valueOf(buVar.aSJ().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bu buVar;
        Long l;
        if (!w.isEmpty(list) && this.fFU != null && !w.isEmpty(this.fFU.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.fFU.getData()) {
                if ((qVar instanceof bu) && (buVar = (bu) qVar) != null && buVar.aSJ() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == buVar.aSJ().live_id) {
                            linkedList.add(buVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.fFU.getData().removeAll(linkedList);
                if (this.fFY != null) {
                    this.fFY.jM(this.fFU.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fmd != null) {
            this.fmd.reset(i);
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

    @Override // com.baidu.tieba.frs.ar
    public NavigationBar bwW() {
        return this.fFV.bwW();
    }
}
