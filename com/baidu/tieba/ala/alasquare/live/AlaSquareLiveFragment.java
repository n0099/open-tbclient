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
    private a fFS;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a fFT;
    private boolean fFW;
    private AlaSquareRefreshManager fFX;
    private IAlaSquareTabController fFY;
    private com.baidu.tieba.ala.alasquare.live.d.a fFR = null;
    private AlaSquareLiveModel fFU = null;
    private int fFV = -1;
    private int mPaddingTop = 0;
    private f.c evf = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.fFU != null) {
                AlaSquareLiveFragment.this.fFU.refresh();
            }
        }
    };
    private BdListView.e Vz = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.fFU != null) {
                AlaSquareLiveFragment.this.fFU.bGU();
            }
        }
    };
    private BdListView.d fFZ = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener fGa = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bHO().bFm();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.fFV != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.fFT != null) {
                        AlaSquareLiveFragment.this.fFT.bHa();
                        if (AlaSquareLiveFragment.this.fFT.bHb() != null) {
                            c bHb = AlaSquareLiveFragment.this.fFT.bHb();
                            aq aqVar = new aq("c12644");
                            if (bHb.fGn == 0) {
                                aqVar.ai("obj_type", 1);
                            } else if (bHb.fGn == 1) {
                                aqVar.ai("obj_type", 2);
                            }
                            aqVar.dF("tid", bHb.ajX.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bHO().Fa("c12647");
                    if (AlaSquareLiveFragment.this.fFT != null) {
                        AlaSquareLiveFragment.this.fFT.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.fFT != null) {
                    AlaSquareLiveFragment.this.fFT.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.fFV = i;
        }
    };
    private AlaSquareLiveModel.a fGb = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void i(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.fFR != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.fFU.bGV();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.fFR.c(list, z, AlaSquareLiveFragment.this.fFU.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.fFR.bHh());
                        AlaSquareLiveFragment.this.fFR.completePullRefresh();
                        AlaSquareLiveFragment.this.kz(z2);
                        AlaSquareLiveFragment.this.fFR.c(list, z, AlaSquareLiveFragment.this.fFU.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.fFR.bHh(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.fFR.bHh());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void an(int i, String str) {
            if (AlaSquareLiveFragment.this.fFR != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.fFR.bHh());
                AlaSquareLiveFragment.this.fFR.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.fFU.bGV()) <= 0 || AlaSquareLiveFragment.this.fFR == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.fFR.bHh(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.fFW = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(boolean z) {
        if (getPageContext() != null) {
            if (this.fFT == null) {
                this.fFT = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.fFT.getView().setVisibility(8);
            }
            this.fFR.bHk().removeHeaderView(this.fFT.getView());
            this.fFR.bHk().addHeaderView(this.fFT.getView(), 1);
            if (this.fFS == null) {
                this.fFS = new a(getPageContext());
                this.fFS.getView().setVisibility(8);
            }
            this.fFR.bHk().removeHeaderView(this.fFS.getView());
            this.fFR.bHk().addHeaderView(this.fFS.getView(), 2);
            kA(z);
            kB(z);
        }
    }

    private void kA(boolean z) {
        HeadLiveInfo headLiveInfo = this.fFU.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.fFT.getView().setVisibility(0);
                c cVar = new c();
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                cVar.ajX = bwVar;
                cVar.fGn = headLiveInfo.is_set.intValue();
                this.fFT.a(cVar);
                this.fFT.bHa();
            } else if (this.fFT != null && this.fFT.getView() != null) {
                this.fFR.bHk().removeHeaderView(this.fFT.getView());
                this.fFT.getView().setVisibility(8);
            }
        } else if (this.fFT != null && this.fFT.getView() != null) {
            this.fFR.bHk().removeHeaderView(this.fFT.getView());
            this.fFT.getView().setVisibility(8);
        }
    }

    private void kB(boolean z) {
        if (bC(this.fFU.getFunctionList())) {
            this.fFS.getView().setVisibility(0);
            this.fFS.bD(this.fFU.getFunctionList());
        } else if (this.fFS != null && this.fFS.getView() != null) {
            this.fFR.bHk().removeHeaderView(this.fFS.getView());
            this.fFS.getView().setVisibility(8);
        }
    }

    private boolean bC(List<FunctionListInfo> list) {
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
        this.fFR = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.fFR.setListPullRefreshListener(this.evf);
        this.fFR.setOnSrollToBottomListener(this.Vz);
        this.fFR.a(this.fFZ, 2000);
        this.fFR.setOnScrollListener(this.fGa);
        TiebaStatic.log("c12654");
        return this.fFR.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.fFW && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.fFY = (IAlaSquareTabController) runTask.getData();
            this.fFR.a(this.fFY);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fFR != null) {
            this.fFR.onChangeSkinType(i);
        }
        if (this.fFS != null) {
            this.fFS.onChangeSkinType(i);
        }
        if (this.fFT != null) {
            this.fFT.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fFU != null && y.isEmpty(this.fFU.bGV()) && !this.fFU.isRefreshing()) {
                bGG();
            }
            if (this.fFX != null) {
                this.fFX.onPageForeground(0);
            }
            if (this.fFT != null) {
                this.fFT.kC(false);
                this.fFT.bHa();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bHO().kO(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fFU = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.fGb);
        this.fFX = new AlaSquareRefreshManager();
        this.fFX.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.fFR == null || this.fFR.bHk() == null) ? super.onGetPreLoadListView() : this.fFR.bHk().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fFX != null) {
            this.fFX.reset(i);
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
    protected void bGG() {
        hideNetRefreshView(this.fFR.bHh());
        if (y.getCount(this.fFU.bGV()) == 0 && this.fFR != null) {
            showLoadingView(this.fFR.bHh());
        }
        this.fFU.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.fFU != null) {
            return this.fFU.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.fFU != null && !y.isEmpty(this.fFU.bGV())) {
            this.fFU.bE(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fFX != null) {
            this.fFX.onPause();
        }
        if (this.fFT != null) {
            this.fFT.kC(true);
            this.fFT.stopPlay();
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
        if (this.fFX != null) {
            this.fFX.onDestory();
        }
        if (this.fFS != null) {
            this.fFS.onDestroy();
        }
        if (this.fFT != null) {
            this.fFT.onDestroy();
        }
        if (this.fFU != null) {
            this.fFU.onDestroy();
        }
        this.fFY = null;
        System.gc();
    }
}
