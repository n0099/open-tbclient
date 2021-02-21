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
/* loaded from: classes10.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ap {
    private int ajU;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private c gVA;
    private boolean gVy;
    private AlaFrsLiveModel gVz;
    private AlaSquareRefreshManager gzh;
    private int gPg = 1;
    private boolean gVB = false;
    private boolean gVC = false;
    private CustomMessageListener gGF = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bSx();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bSx();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a gVD = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void mK(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.gVA != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gVA.getRootView());
                AlaFrsLiveFragment.this.gVA.completePullRefresh();
                AlaFrsLiveFragment.this.gVA.d(AlaFrsLiveFragment.this.gVz.getData(), z, AlaFrsLiveFragment.this.gVz.bVq());
                AlaFrsLiveFragment.this.gVA.tT(AlaFrsLiveFragment.this.gVz.getLiveCount());
                if (y.getCount(AlaFrsLiveFragment.this.gVz.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.gPg == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.gVB = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gVA.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.gVA.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void aJ(int i, String str) {
            if (AlaFrsLiveFragment.this.gVA != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.gVA.getRootView());
                AlaFrsLiveFragment.this.gVA.completePullRefresh();
            }
            if (y.getCount(AlaFrsLiveFragment.this.gVz.getData()) <= 0 || AlaFrsLiveFragment.this.gVA == null) {
                AlaFrsLiveFragment.this.gVB = true;
                if (AlaFrsLiveFragment.this.gVA != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.gVA.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private h gVE = new h() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.h
        public void S(cb cbVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), cbVar);
        }
    };
    private f.c gJi = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.gVz != null) {
                AlaFrsLiveFragment.this.gVz.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener gVF = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.gVz != null) {
                z = AlaFrsLiveFragment.this.gVz.bSD();
            }
            if (AlaFrsLiveFragment.this.gVA != null) {
                if (z) {
                    AlaFrsLiveFragment.this.gVA.bRy();
                } else {
                    AlaFrsLiveFragment.this.gVA.bRx();
                }
            }
        }
    };
    private d gVG = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void us(int i) {
            if (AlaFrsLiveFragment.this.gVz != null && AlaFrsLiveFragment.this.gVz.getSortType() != i) {
                ar arVar = new ar("c12572");
                arVar.dR("fid", AlaFrsLiveFragment.this.forumId);
                arVar.ap("obj_type", i);
                TiebaStatic.log(arVar);
                AlaFrsLiveFragment.this.gVz.setSortType(i);
                AlaFrsLiveFragment.this.gVz.clearData();
                if (AlaFrsLiveFragment.this.gVA != null) {
                    AlaFrsLiveFragment.this.gVA.bVt().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ajU = i;
        if (this.gVA != null) {
            this.gVA.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.gGF, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.gVA = new c(getPageContext(), this.gVy, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.gVC);
        this.gVA.initView();
        this.gVA.ut(1);
        this.gVA.b(this.gVE);
        this.gVA.setListPullRefreshListener(this.gJi);
        this.gVA.setOnSrollToBottomListener(this.gVF);
        this.gVA.a(this.gVG);
        this.gVA.onChangeSkinType(this.ajU);
        bVj();
        return this.gVA.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gzh != null) {
            this.gzh.onPause();
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
            if (this.gVz == null) {
                this.gVz = new AlaFrsLiveModel(getPageContext());
                this.gVz.a(this.gVD);
                this.gVz.setForumId(this.forumId);
                this.gVz.setForumGameLabel(this.forumGameLabel);
                this.gVz.setFromType(this.gPg);
                this.gVz.refreshData();
                if (this.gVA != null) {
                    showLoadingView(this.gVA.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.gzh = new AlaSquareRefreshManager();
                this.gzh.init(this, new long[]{30000});
            } else if (this.gzh != null) {
                this.gzh.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gzh != null) {
            this.gzh.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.gVB) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.gVz != null) {
            this.gVz.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, cb cbVar) {
        cb cbVar2;
        if (tbPageContext != null && cbVar != null && cbVar.bnQ() != null && cbVar.boj() != null) {
            ar arVar = new ar("c12571");
            arVar.dR("fid", this.forumId);
            arVar.ap("obj_type", cbVar.boj().live_type);
            TiebaStatic.log(arVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = cbVar.bnQ().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (n nVar : this.gVz.getData()) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (cbVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) nVar).eJQ) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(W(cbVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData W(cb cbVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(cbVar.boj());
        alaLiveInfoCoreData.userName = cbVar.bnQ().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSx() {
        if (this.gVA != null) {
            this.gVA.bSx();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bVj() {
        if (this.gVA != null && this.gVA.bVk() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.gVA.bVk().setCenterTextTitle(sb.toString());
        }
    }

    public void nj(boolean z) {
        this.gVy = z;
    }

    public void setFromType(int i) {
        this.gPg = i;
    }

    public void nk(boolean z) {
        this.gVC = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        cb cbVar;
        if (this.gVz == null || y.isEmpty(this.gVz.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (n nVar : this.gVz.getData()) {
            if ((nVar instanceof cb) && (cbVar = (cb) nVar) != null && cbVar.boj() != null) {
                linkedList.add(Long.valueOf(cbVar.boj().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        cb cbVar;
        Long l;
        if (!y.isEmpty(list) && this.gVz != null && !y.isEmpty(this.gVz.getData())) {
            LinkedList linkedList = new LinkedList();
            for (n nVar : this.gVz.getData()) {
                if ((nVar instanceof cb) && (cbVar = (cb) nVar) != null && cbVar.boj() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == cbVar.boj().live_id) {
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
                this.gVz.getData().removeAll(linkedList);
                if (this.gVD != null) {
                    this.gVD.mK(this.gVz.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gzh != null) {
            this.gzh.reset(i);
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
    public NavigationBar bVk() {
        return this.gVA.bVk();
    }
}
