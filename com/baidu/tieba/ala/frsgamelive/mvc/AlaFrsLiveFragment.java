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
/* loaded from: classes3.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ai {
    private int Ni;
    private boolean eBV;
    private AlaFrsLiveModel eBW;
    private c eBX;
    private AlaSquareRefreshManager ekg;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private int mFromType = 1;
    private boolean eBY = false;
    private boolean eBZ = false;
    private CustomMessageListener erm = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bdr();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bdr();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a eCa = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void ie(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.eBX != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.eBX.getRootView());
                AlaFrsLiveFragment.this.eBX.completePullRefresh();
                AlaFrsLiveFragment.this.eBX.e(AlaFrsLiveFragment.this.eBW.getData(), z, AlaFrsLiveFragment.this.eBW.beS());
                AlaFrsLiveFragment.this.eBX.oP(AlaFrsLiveFragment.this.eBW.getLiveCount());
                if (v.getCount(AlaFrsLiveFragment.this.eBW.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.mFromType == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.eBY = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.eBX.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.eBX.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void ag(int i, String str) {
            if (AlaFrsLiveFragment.this.eBX != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.eBX.getRootView());
                AlaFrsLiveFragment.this.eBX.completePullRefresh();
            }
            if (v.getCount(AlaFrsLiveFragment.this.eBW.getData()) <= 0 || AlaFrsLiveFragment.this.eBX == null) {
                AlaFrsLiveFragment.this.eBY = true;
                if (AlaFrsLiveFragment.this.eBX != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.eBX.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private com.baidu.tieba.ala.d eCb = new com.baidu.tieba.ala.d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.d
        public void O(bj bjVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bjVar);
        }
    };
    private g.c etR = new g.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.eBW != null) {
                AlaFrsLiveFragment.this.eBW.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener eCc = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.eBW != null) {
                z = AlaFrsLiveFragment.this.eBW.bdz();
            }
            if (AlaFrsLiveFragment.this.eBX != null) {
                if (z) {
                    AlaFrsLiveFragment.this.eBX.bcv();
                } else {
                    AlaFrsLiveFragment.this.eBX.bcu();
                }
            }
        }
    };
    private d eCd = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void pi(int i) {
            if (AlaFrsLiveFragment.this.eBW != null && AlaFrsLiveFragment.this.eBW.getSortType() != i) {
                an anVar = new an("c12572");
                anVar.cy("fid", AlaFrsLiveFragment.this.forumId);
                anVar.X("obj_type", i);
                TiebaStatic.log(anVar);
                AlaFrsLiveFragment.this.eBW.setSortType(i);
                AlaFrsLiveFragment.this.eBW.clearData();
                if (AlaFrsLiveFragment.this.eBX != null) {
                    AlaFrsLiveFragment.this.eBX.beV().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.Ni = i;
        if (this.eBX != null) {
            this.eBX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.erm, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eBX = new c(getPageContext(), this.eBV, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.eBZ);
        this.eBX.initView();
        this.eBX.pj(1);
        this.eBX.b(this.eCb);
        this.eBX.setListPullRefreshListener(this.etR);
        this.eBX.setOnSrollToBottomListener(this.eCc);
        this.eBX.a(this.eCd);
        this.eBX.onChangeSkinType(this.Ni);
        beL();
        return this.eBX.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ekg != null) {
            this.ekg.onPause();
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
            if (this.eBW == null) {
                this.eBW = new AlaFrsLiveModel(getPageContext());
                this.eBW.a(this.eCa);
                this.eBW.setForumId(this.forumId);
                this.eBW.setForumGameLabel(this.forumGameLabel);
                this.eBW.setFromType(this.mFromType);
                this.eBW.refreshData();
                if (this.eBX != null) {
                    showLoadingView(this.eBX.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.ekg = new AlaSquareRefreshManager();
                this.ekg.init(this, new long[]{30000});
            } else if (this.ekg != null) {
                this.ekg.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.ekg != null) {
            this.ekg.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.eBY) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.eBW != null) {
            this.eBW.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bj bjVar) {
        bj bjVar2;
        if (tbPageContext != null && bjVar != null && bjVar.aCo() != null && bjVar.aCH() != null) {
            an anVar = new an("c12571");
            anVar.cy("fid", this.forumId);
            anVar.X("obj_type", bjVar.aCH().live_type);
            TiebaStatic.log(anVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bjVar.aCo().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (m mVar : this.eBW.getData()) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bjVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) mVar).cRg) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bjVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bj bjVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bjVar.aCH());
        alaLiveInfoCoreData.userName = bjVar.aCo().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdr() {
        if (this.eBX != null) {
            this.eBX.bdr();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void beL() {
        if (this.eBX != null && this.eBX.beM() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.eBX.beM().setCenterTextTitle(sb.toString());
        }
    }

    public void ix(boolean z) {
        this.eBV = z;
    }

    public void setFromType(int i) {
        this.mFromType = i;
    }

    public void iy(boolean z) {
        this.eBZ = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bj bjVar;
        if (this.eBW == null || v.isEmpty(this.eBW.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (m mVar : this.eBW.getData()) {
            if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aCH() != null) {
                linkedList.add(Long.valueOf(bjVar.aCH().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bj bjVar;
        Long l;
        if (!v.isEmpty(list) && this.eBW != null && !v.isEmpty(this.eBW.getData())) {
            LinkedList linkedList = new LinkedList();
            for (m mVar : this.eBW.getData()) {
                if ((mVar instanceof bj) && (bjVar = (bj) mVar) != null && bjVar.aCH() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bjVar.aCH().live_id) {
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
                this.eBW.getData().removeAll(linkedList);
                if (this.eCa != null) {
                    this.eCa.ie(this.eBW.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ekg != null) {
            this.ekg.reset(i);
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
    public NavigationBar beM() {
        return this.eBX.beM();
    }
}
