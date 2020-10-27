package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.t;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.ala.alasquare.live.c.a;
import com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a gce;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a gcf;
    private boolean gci;
    private AlaSquareRefreshManager gcj;
    private IAlaSquareTabController gck;
    private com.baidu.tieba.ala.alasquare.live.d.a gcd = null;
    private AlaSquareLiveModel gcg = null;
    private int gch = -1;
    private int mPaddingTop = 0;
    private f.c ePL = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.gcg != null) {
                AlaSquareLiveFragment.this.gcg.refresh();
            }
        }
    };
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.gcg != null) {
                AlaSquareLiveFragment.this.gcg.bMi();
            }
        }
    };
    private BdListView.d gcl = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener gcm = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bNc().bJQ();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.gch != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.gcf != null) {
                        AlaSquareLiveFragment.this.gcf.bMo();
                        if (AlaSquareLiveFragment.this.gcf.bMp() != null) {
                            c bMp = AlaSquareLiveFragment.this.gcf.bMp();
                            aq aqVar = new aq("c12644");
                            if (bMp.gcz == 0) {
                                aqVar.aj("obj_type", 1);
                            } else if (bMp.gcz == 1) {
                                aqVar.aj("obj_type", 2);
                            }
                            aqVar.dR("tid", bMp.akq.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bNc().Gk("c12647");
                    if (AlaSquareLiveFragment.this.gcf != null) {
                        AlaSquareLiveFragment.this.gcf.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.gcf != null) {
                    AlaSquareLiveFragment.this.gcf.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.gch = i;
        }
    };
    private AlaSquareLiveModel.a gcn = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void i(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.gcd != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.gcg.bMj();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.gcd.c(list, z, AlaSquareLiveFragment.this.gcg.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gcd.bMv());
                        AlaSquareLiveFragment.this.gcd.completePullRefresh();
                        AlaSquareLiveFragment.this.lp(z2);
                        AlaSquareLiveFragment.this.gcd.c(list, z, AlaSquareLiveFragment.this.gcg.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gcd.bMv(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.gcd.bMv());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aA(int i, String str) {
            if (AlaSquareLiveFragment.this.gcd != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gcd.bMv());
                AlaSquareLiveFragment.this.gcd.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.gcg.bMj()) <= 0 || AlaSquareLiveFragment.this.gcd == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gcd.bMv(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.gci = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lp(boolean z) {
        if (getPageContext() != null) {
            if (this.gcf == null) {
                this.gcf = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.gcf.getView().setVisibility(8);
            }
            this.gcd.bMy().removeHeaderView(this.gcf.getView());
            this.gcd.bMy().addHeaderView(this.gcf.getView(), 1);
            if (this.gce == null) {
                this.gce = new a(getPageContext());
                this.gce.getView().setVisibility(8);
            }
            this.gcd.bMy().removeHeaderView(this.gce.getView());
            this.gcd.bMy().addHeaderView(this.gce.getView(), 2);
            lq(z);
            lr(z);
        }
    }

    private void lq(boolean z) {
        HeadLiveInfo headLiveInfo = this.gcg.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.gcf.getView().setVisibility(0);
                c cVar = new c();
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                cVar.akq = bwVar;
                cVar.gcz = headLiveInfo.is_set.intValue();
                this.gcf.a(cVar);
                this.gcf.bMo();
            } else if (this.gcf != null && this.gcf.getView() != null) {
                this.gcd.bMy().removeHeaderView(this.gcf.getView());
                this.gcf.getView().setVisibility(8);
            }
        } else if (this.gcf != null && this.gcf.getView() != null) {
            this.gcd.bMy().removeHeaderView(this.gcf.getView());
            this.gcf.getView().setVisibility(8);
        }
    }

    private void lr(boolean z) {
        if (bP(this.gcg.getFunctionList())) {
            this.gce.getView().setVisibility(0);
            this.gce.bQ(this.gcg.getFunctionList());
        } else if (this.gce != null && this.gce.getView() != null) {
            this.gcd.bMy().removeHeaderView(this.gce.getView());
            this.gce.getView().setVisibility(8);
        }
    }

    private boolean bP(List<FunctionListInfo> list) {
        int i;
        if (!y.isEmpty(list) && y.getCount(list) >= 2 && y.getCount(list) <= 3) {
            int i2 = 0;
            for (FunctionListInfo functionListInfo : list) {
                if ((1 == functionListInfo.id.intValue() || 3 == functionListInfo.id.intValue()) && !TextUtils.isEmpty(functionListInfo.url)) {
                    i = i2 + 1;
                } else {
                    i = 2 == functionListInfo.id.intValue() ? i2 + 1 : i2;
                }
                i2 = i;
            }
            return i2 >= 2;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mPaddingTop == 0) {
            this.mPaddingTop = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
        }
        this.gcd = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.gcd.setListPullRefreshListener(this.ePL);
        this.gcd.setOnSrollToBottomListener(this.VR);
        this.gcd.a(this.gcl, 2000);
        this.gcd.setOnScrollListener(this.gcm);
        TiebaStatic.log("c12654");
        return this.gcd.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.gci && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.gck = (IAlaSquareTabController) runTask.getData();
            this.gcd.a(this.gck);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gcd != null) {
            this.gcd.onChangeSkinType(i);
        }
        if (this.gce != null) {
            this.gce.onChangeSkinType(i);
        }
        if (this.gcf != null) {
            this.gcf.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gcg != null && y.isEmpty(this.gcg.bMj()) && !this.gcg.isRefreshing()) {
                bLU();
            }
            if (this.gcj != null) {
                this.gcj.onPageForeground(0);
            }
            if (this.gcf != null) {
                this.gcf.ls(false);
                this.gcf.bMo();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bNc().lE(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gcg = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.gcn);
        this.gcj = new AlaSquareRefreshManager();
        this.gcj.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.gcd == null || this.gcd.bMy() == null) ? super.onGetPreLoadListView() : this.gcd.bMy().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gcj != null) {
            this.gcj.reset(i);
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

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    protected void bLU() {
        hideNetRefreshView(this.gcd.bMv());
        if (y.getCount(this.gcg.bMj()) == 0 && this.gcd != null) {
            showLoadingView(this.gcd.bMv());
        }
        this.gcg.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.gcg != null) {
            return this.gcg.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.gcg != null && !y.isEmpty(this.gcg.bMj())) {
            this.gcg.bR(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gcj != null) {
            this.gcj.onPause();
        }
        if (this.gcf != null) {
            this.gcf.ls(true);
            this.gcf.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        MessageManager.getInstance().sendMessage(new CustomMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_FRAGMENT_NET_BTN_CLICKED));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gcj != null) {
            this.gcj.onDestory();
        }
        if (this.gce != null) {
            this.gce.onDestroy();
        }
        if (this.gcf != null) {
            this.gcf.onDestroy();
        }
        if (this.gcg != null) {
            this.gcg.onDestroy();
        }
        this.gck = null;
        System.gc();
    }
}
