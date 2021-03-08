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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.ala.h;
import com.baidu.tieba.frs.ap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ap {
    private int aln;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private AlaSquareRefreshManager gAQ;
    private boolean gXh;
    private AlaFrsLiveModel gXi;
    private c gXj;
    private int gQP = 1;
    private boolean gXk = false;
    private boolean gXl = false;
    private CustomMessageListener gIo = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bSD();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bSD();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gXm = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void mK(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gXj != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gXj.getRootView());
                AlaFrsLiveFragment.this.gXj.completePullRefresh();
                AlaFrsLiveFragment.this.gXj.d(AlaFrsLiveFragment.this.gXi.getData(), z, AlaFrsLiveFragment.this.gXi.bVw());
                AlaFrsLiveFragment.this.gXj.tV(AlaFrsLiveFragment.this.gXi.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gXi.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gQP == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gXk = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gXj.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gXj.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aJ(int i, String str) {
            if (AlaFrsLiveFragment.this.gXj != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gXj.getRootView());
                AlaFrsLiveFragment.this.gXj.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gXi.getData()) <= 0 || AlaFrsLiveFragment.this.gXj == null) {
                AlaFrsLiveFragment.this.gXk = true;
                if (AlaFrsLiveFragment.this.gXj != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gXj.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private h gXn = new h() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.h
        public void S(cb cbVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), cbVar);
        }
    };
    private f.c gKR = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gXi != null) {
                AlaFrsLiveFragment.this.gXi.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gXo = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gXi != null) {
                z = AlaFrsLiveFragment.this.gXi.bSJ();
            }
            if (AlaFrsLiveFragment.this.gXj != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gXj.bRE();
                } else {
                    AlaFrsLiveFragment.this.gXj.bRD();
                }
            }
        }
    };
    private d gXp = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void uu(int i) {
            if (AlaFrsLiveFragment.this.gXi != null && AlaFrsLiveFragment.this.gXi.getSortType() != i) {
                ar arVar = new ar("c12572");
                arVar.dR("fid", AlaFrsLiveFragment.this.forumId);
                arVar.aq("obj_type", i);
                TiebaStatic.log(arVar);
                AlaFrsLiveFragment.this.gXi.setSortType(i);
                AlaFrsLiveFragment.this.gXi.clearData();
                if (AlaFrsLiveFragment.this.gXj != null) {
                    AlaFrsLiveFragment.this.gXj.bVz().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aln = i;
        if (this.gXj != null) {
            this.gXj.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gIo, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gXj = new c(getPageContext(), this.gXh, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gXl);
        this.gXj.initView();
        this.gXj.uv(1);
        this.gXj.b(this.gXn);
        this.gXj.setListPullRefreshListener(this.gKR);
        this.gXj.setOnSrollToBottomListener(this.gXo);
        this.gXj.a(this.gXp);
        this.gXj.onChangeSkinType(this.aln);
        bVp();
        return this.gXj.getRootView();
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
            if (this.gXi == null) {
                this.gXi = new AlaFrsLiveModel(getPageContext());
                this.gXi.a(this.gXm);
                this.gXi.setForumId(this.forumId);
                this.gXi.setForumGameLabel(this.forumGameLabel);
                this.gXi.setFromType(this.gQP);
                this.gXi.refreshData();
                if (this.gXj != null) {
                    showLoadingView(this.gXj.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
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
        if (!this.gXk) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gXi != null) {
            this.gXi.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        cb cbVar2;
        if (tbPageContext != null && cbVar != null && cbVar.bnS() != null && cbVar.bol() != null) {
            ar arVar = new ar("c12571");
            arVar.dR("fid", this.forumId);
            arVar.aq("obj_type", cbVar.bol().live_type);
            TiebaStatic.log(arVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnS().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.bol());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (n nVar : this.gXi.getData()) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (cbVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) nVar).eLr) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(W(cbVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData W(cb cbVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(cbVar.bol());
        alaLiveInfoCoreData.userName = cbVar.bnS().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSD() {
        if (this.gXj != null) {
            this.gXj.bSD();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bVp() {
        if (this.gXj != null && this.gXj.bVq() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gXj.bVq().setCenterTextTitle(sb.toString());
        }
    }

    public void nj(boolean z) {
        this.gXh = z;
    }

    public void setFromType(int i) {
        this.gQP = i;
    }

    public void nk(boolean z) {
        this.gXl = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        cb cbVar;
        if (this.gXi == null || y.isEmpty(this.gXi.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.gXi.getData()) {
            if ((nVar instanceof cb) && (cbVar = (cb) nVar) != null && cbVar.bol() != null) {
                linkedList.add(Long.valueOf(cbVar.bol().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        cb cbVar;
        Long l;
        if (!y.isEmpty(list) && this.gXi != null && !y.isEmpty(this.gXi.getData())) {
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.gXi.getData()) {
                if ((nVar instanceof cb) && (cbVar = (cb) nVar) != null && cbVar.bol() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == cbVar.bol().live_id) {
                            linkedList.add(cbVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.gXi.getData().removeAll(linkedList);
                if (this.gXm != null) {
                    this.gXm.mK(this.gXi.hasMore());
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
    public NavigationBar bVq() {
        return this.gXj.bVq();
    }
}
