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
import com.baidu.tieba.frs.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ai {
    private int MH;
    private AlaSquareRefreshManager efO;
    private c exA;
    private boolean exy;
    private AlaFrsLiveModel exz;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int mFromType = 1;
    private boolean exB = false;
    private boolean exC = false;
    private CustomMessageListener emK = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.baZ();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.baZ();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a exD = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void hX(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.exA != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.exA.getRootView());
                AlaFrsLiveFragment.this.exA.completePullRefresh();
                AlaFrsLiveFragment.this.exA.e(AlaFrsLiveFragment.this.exz.getData(), z, AlaFrsLiveFragment.this.exz.bcC());
                AlaFrsLiveFragment.this.exA.oy(AlaFrsLiveFragment.this.exz.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.exz.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.mFromType == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.exB = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.exA.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.exA.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void af(int i, String str) {
            if (AlaFrsLiveFragment.this.exA != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.exA.getRootView());
                AlaFrsLiveFragment.this.exA.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.exz.getData()) <= 0 || AlaFrsLiveFragment.this.exA == null) {
                AlaFrsLiveFragment.this.exB = true;
                if (AlaFrsLiveFragment.this.exA != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.exA.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d exE = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void N(bj bjVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bjVar);
        }
    };
    private g.c eps = new g.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.exz != null) {
                AlaFrsLiveFragment.this.exz.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener exF = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.exz != null) {
                z = AlaFrsLiveFragment.this.exz.bbh();
            }
            if (AlaFrsLiveFragment.this.exA != null) {
                if (z) {
                    AlaFrsLiveFragment.this.exA.bac();
                } else {
                    AlaFrsLiveFragment.this.exA.bab();
                }
            }
        }
    };
    private d exG = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void oS(int i) {
            if (AlaFrsLiveFragment.this.exz != null && AlaFrsLiveFragment.this.exz.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.cp("fid", AlaFrsLiveFragment.this.forumId);
                anVar.Z("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.exz.setSortType(i);
                AlaFrsLiveFragment.this.exz.clearData();
                if (AlaFrsLiveFragment.this.exA != null) {
                    AlaFrsLiveFragment.this.exA.bcF().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.MH = i;
        if (this.exA != null) {
            this.exA.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.emK, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.exA = new c(getPageContext(), this.exy, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.exC);
        this.exA.initView();
        this.exA.oT(1);
        this.exA.b(this.exE);
        this.exA.setListPullRefreshListener(this.eps);
        this.exA.setOnSrollToBottomListener(this.exF);
        this.exA.a(this.exG);
        this.exA.onChangeSkinType(this.MH);
        bcv();
        return this.exA.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.efO != null) {
            this.efO.onPause();
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
            if (this.exz == null) {
                this.exz = new AlaFrsLiveModel(getPageContext());
                this.exz.a(this.exD);
                this.exz.setForumId(this.forumId);
                this.exz.setForumGameLabel(this.forumGameLabel);
                this.exz.setFromType(this.mFromType);
                this.exz.refreshData();
                if (this.exA != null) {
                    showLoadingView(this.exA.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.efO = new AlaSquareRefreshManager();
                this.efO.init(this, new long[]{30000});
            } else if (this.efO != null) {
                this.efO.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.efO != null) {
            this.efO.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.exB) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.exz != null) {
            this.exz.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        bj bjVar2;
        if (tbPageContext != null && bjVar != null && bjVar.azX() != null && bjVar.aAq() != null) {
            an anVar = new an("c12571");
            anVar.cp("fid", this.forumId);
            anVar.Z("obj_type", bjVar.aAq().live_type);
            TiebaStatic.log(anVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.azX().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (m mVar : this.exz.getData()) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bjVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) mVar).cNb) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(R(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData R(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aAq());
        alaLiveInfoCoreData.userName = bjVar.azX().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baZ() {
        if (this.exA != null) {
            this.exA.baZ();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bcv() {
        if (this.exA != null && this.exA.bcw() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.exA.bcw().setCenterTextTitle(sb.toString());
        }
    }

    public void iq(boolean z) {
        this.exy = z;
    }

    public void setFromType(int i) {
        this.mFromType = i;
    }

    public void ir(boolean z) {
        this.exC = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bj bjVar;
        if (this.exz == null || v.isEmpty(this.exz.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (m mVar : this.exz.getData()) {
            if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aAq() != null) {
                linkedList.add(Long.valueOf(bjVar.aAq().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bj bjVar;
        Long l;
        if (!v.isEmpty(list) && this.exz != null && !v.isEmpty(this.exz.getData())) {
            LinkedList linkedList = new LinkedList();
            for (m mVar : this.exz.getData()) {
                if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aAq() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bjVar.aAq().live_id) {
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
                this.exz.getData().removeAll(linkedList);
                if (this.exD != null) {
                    this.exD.hX(this.exz.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.efO != null) {
            this.efO.reset(i);
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

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar bcw() {
        return this.exA.bcw();
    }
}
