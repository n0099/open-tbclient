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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.e;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel;
import com.baidu.tieba.frs.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaFrsLiveFragment extends AlaAutoRefreshFragment implements ISquareRefreshHandler, ar {
    private int aho;
    private boolean fLo;
    private AlaFrsLiveModel fLp;
    private c fLq;
    private String forumGameLabel;
    private String forumId;
    private String forumName;
    private AlaSquareRefreshManager frm;
    private int fFX = 1;
    private boolean fLr = false;
    private boolean fLs = false;
    private CustomMessageListener fyz = new CustomMessageListener(0) { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                if (split.length == 2) {
                    if ("FrsGameLive".equals(split[0]) && 9 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bxR();
                    } else if ("FrsGameLiveLive".equals(split[0]) && 2 == com.baidu.adp.lib.f.b.toInt(split[1], 0)) {
                        AlaFrsLiveFragment.this.bxR();
                    }
                }
            }
        }
    };
    private AlaFrsLiveModel.a fLt = new AlaFrsLiveModel.a() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.2
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void kq(boolean z) {
            if (AlaFrsLiveFragment.this.getPageContext() != null && AlaFrsLiveFragment.this.fLq != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fLq.getRootView());
                AlaFrsLiveFragment.this.fLq.completePullRefresh();
                AlaFrsLiveFragment.this.fLq.d(AlaFrsLiveFragment.this.fLp.getData(), z, AlaFrsLiveFragment.this.fLp.bAs());
                AlaFrsLiveFragment.this.fLq.qB(AlaFrsLiveFragment.this.fLp.getLiveCount());
                if (x.getCount(AlaFrsLiveFragment.this.fLp.getData()) == 0) {
                    if (AlaFrsLiveFragment.this.fFX == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRA_SWITCH_TO_VIDEO));
                    }
                    AlaFrsLiveFragment.this.fLr = false;
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fLq.getRootView(), AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_no_data), null, AlaFrsLiveFragment.this.getPageContext().getString(R.string.frs_game_live_more_data), false, AlaFrsLiveFragment.this.getNetRefreshListener());
                    return;
                }
                AlaFrsLiveFragment.this.hideNetRefreshView(AlaFrsLiveFragment.this.fLq.getRootView());
            }
        }

        @Override // com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveModel.a
        public void ao(int i, String str) {
            if (AlaFrsLiveFragment.this.fLq != null) {
                AlaFrsLiveFragment.this.hideLoadingView(AlaFrsLiveFragment.this.fLq.getRootView());
                AlaFrsLiveFragment.this.fLq.completePullRefresh();
            }
            if (x.getCount(AlaFrsLiveFragment.this.fLp.getData()) <= 0 || AlaFrsLiveFragment.this.fLq == null) {
                AlaFrsLiveFragment.this.fLr = true;
                if (AlaFrsLiveFragment.this.fLq != null) {
                    AlaFrsLiveFragment.this.showNetRefreshView(AlaFrsLiveFragment.this.fLq.getRootView(), str, false);
                    return;
                }
                return;
            }
            AlaFrsLiveFragment.this.showToast(str);
        }
    };
    private e fLu = new e() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.3
        @Override // com.baidu.tieba.ala.e
        public void O(bv bvVar) {
            AlaFrsLiveFragment.this.a(AlaFrsLiveFragment.this.getPageContext(), bvVar);
        }
    };
    private f.c fBc = new f.c() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaFrsLiveFragment.this.fLp != null) {
                AlaFrsLiveFragment.this.fLp.refreshData();
            }
        }
    };
    private BdMultiColumnListView.OnScrollToBottomListener fLv = new BdMultiColumnListView.OnScrollToBottomListener() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.5
        @Override // com.baidu.ala.widget.multicolumn.BdMultiColumnListView.OnScrollToBottomListener
        public void onScrollToBottom() {
            boolean z = false;
            if (AlaFrsLiveFragment.this.fLp != null) {
                z = AlaFrsLiveFragment.this.fLp.bxZ();
            }
            if (AlaFrsLiveFragment.this.fLq != null) {
                if (z) {
                    AlaFrsLiveFragment.this.fLq.bwT();
                } else {
                    AlaFrsLiveFragment.this.fLq.bwS();
                }
            }
        }
    };
    private d fLw = new d() { // from class: com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsLiveFragment.6
        @Override // com.baidu.tieba.ala.frsgamelive.mvc.d
        public void qX(int i) {
            if (AlaFrsLiveFragment.this.fLp != null && AlaFrsLiveFragment.this.fLp.getSortType() != i) {
                ap apVar = new ap("c12572");
                apVar.dn("fid", AlaFrsLiveFragment.this.forumId);
                apVar.ah("obj_type", i);
                TiebaStatic.log(apVar);
                AlaFrsLiveFragment.this.fLp.setSortType(i);
                AlaFrsLiveFragment.this.fLp.clearData();
                if (AlaFrsLiveFragment.this.fLq != null) {
                    AlaFrsLiveFragment.this.fLq.bAu().startPullRefresh();
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aho = i;
        if (this.fLq != null) {
            this.fLq.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(CmdConfigCustom.CMD_FORCE_REFRESH, this.fyz, getBaseFragmentActivity().getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.fLq = new c(getPageContext(), this.fLo, getPageContext().getOrignalPage().getUniqueId(), this.forumId, this.fLs);
        this.fLq.initView();
        this.fLq.qY(1);
        this.fLq.b(this.fLu);
        this.fLq.setListPullRefreshListener(this.fBc);
        this.fLq.setOnSrollToBottomListener(this.fLv);
        this.fLq.a(this.fLw);
        this.fLq.onChangeSkinType(this.aho);
        bAl();
        return this.fLq.getRootView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.frm != null) {
            this.frm.onPause();
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
            if (this.fLp == null) {
                this.fLp = new AlaFrsLiveModel(getPageContext());
                this.fLp.a(this.fLt);
                this.fLp.setForumId(this.forumId);
                this.fLp.setForumGameLabel(this.forumGameLabel);
                this.fLp.setFromType(this.fFX);
                this.fLp.refreshData();
                if (this.fLq != null) {
                    showLoadingView(this.fLq.getRootView(), false, getResources().getDimensionPixelSize(R.dimen.ds270));
                }
                this.frm = new AlaSquareRefreshManager();
                this.frm.init(this, new long[]{30000});
            } else if (this.frm != null) {
                this.frm.onPageForeground(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.frm != null) {
            this.frm.onDestory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (!this.fLr) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) AlaCmdConfigCustom.CMD_ALA_ALL_LIVE_SIMPLE, new IntentConfig(getPageContext().getPageActivity())));
        } else if (this.fLp != null) {
            this.fLp.refreshData();
        }
    }

    public void a(TbPageContext<?> tbPageContext, bv bvVar) {
        bv bvVar2;
        if (tbPageContext != null && bvVar != null && bvVar.aWl() != null && bvVar.aWF() != null) {
            ap apVar = new ap("c12571");
            apVar.dn("fid", this.forumId);
            apVar.ah("obj_type", bvVar.aWF().live_type);
            TiebaStatic.log(apVar);
            boolean z = false;
            String str = "";
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = bvVar.aWl().getUserId();
                str = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, str);
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
            AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
            alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
            for (q qVar : this.fLp.getData()) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.ala.frsgamelive.b.c) && (bvVar2 = ((com.baidu.tieba.ala.frsgamelive.b.c) qVar).dLK) != null) {
                    alaLiveInfoListCoreData.mLiveInfoList.add(S(bvVar2));
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, alaLiveInfoListCoreData, "square_sub_live", str, z, null, null)));
        }
    }

    private AlaLiveInfoCoreData S(bv bvVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(bvVar.aWF());
        alaLiveInfoCoreData.userName = bvVar.aWl().getUserName();
        return alaLiveInfoCoreData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxR() {
        if (this.fLq != null) {
            this.fLq.bxR();
        }
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    private void bAl() {
        if (this.fLq != null && this.fLq.bAm() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilHelper.getFixedBarText(this.forumName, 5, true, true) + getResources().getString(R.string.forum));
            this.fLq.bAm().setCenterTextTitle(sb.toString());
        }
    }

    public void kL(boolean z) {
        this.fLo = z;
    }

    public void setFromType(int i) {
        this.fFX = i;
    }

    public void kM(boolean z) {
        this.fLs = z;
    }

    public void setForumGameLabel(String str) {
        this.forumGameLabel = str;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        bv bvVar;
        if (this.fLp == null || x.isEmpty(this.fLp.getData())) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (q qVar : this.fLp.getData()) {
            if ((qVar instanceof bv) && (bvVar = (bv) qVar) != null && bvVar.aWF() != null) {
                linkedList.add(Long.valueOf(bvVar.aWF().live_id));
            }
        }
        return linkedList;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        bv bvVar;
        Long l;
        if (!x.isEmpty(list) && this.fLp != null && !x.isEmpty(this.fLp.getData())) {
            LinkedList linkedList = new LinkedList();
            for (q qVar : this.fLp.getData()) {
                if ((qVar instanceof bv) && (bvVar = (bv) qVar) != null && bvVar.aWF() != null) {
                    Iterator<Long> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            l = null;
                            break;
                        }
                        l = it.next();
                        if (l.longValue() == bvVar.aWF().live_id) {
                            linkedList.add(bvVar);
                            break;
                        }
                    }
                    if (l != null) {
                        list.remove(l);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                this.fLp.getData().removeAll(linkedList);
                if (this.fLt != null) {
                    this.fLt.kq(this.fLp.hasMore());
                }
            }
        }
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.frm != null) {
            this.frm.reset(i);
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
    public NavigationBar bAm() {
        return this.fLq.bAm();
    }
}
