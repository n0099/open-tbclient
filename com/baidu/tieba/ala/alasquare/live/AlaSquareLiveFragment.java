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
    private a fCG;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a fCH;
    private boolean fCK;
    private AlaSquareRefreshManager fCL;
    private IAlaSquareTabController fCM;
    private com.baidu.tieba.ala.alasquare.live.d.a fCF = null;
    private AlaSquareLiveModel fCI = null;
    private int fCJ = -1;
    private int mPaddingTop = 0;
    private f.c eta = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.fCI != null) {
                AlaSquareLiveFragment.this.fCI.refresh();
            }
        }
    };
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.fCI != null) {
                AlaSquareLiveFragment.this.fCI.bFE();
            }
        }
    };
    private BdListView.d fCN = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener fCO = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bGy().bDW();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.fCJ != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.fCH != null) {
                        AlaSquareLiveFragment.this.fCH.bFK();
                        if (AlaSquareLiveFragment.this.fCH.bFL() != null) {
                            c bFL = AlaSquareLiveFragment.this.fCH.bFL();
                            aq aqVar = new aq("c12644");
                            if (bFL.fDb == 0) {
                                aqVar.ai("obj_type", 1);
                            } else if (bFL.fDb == 1) {
                                aqVar.ai("obj_type", 2);
                            }
                            aqVar.dD("tid", bFL.ajz.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bGy().EC("c12647");
                    if (AlaSquareLiveFragment.this.fCH != null) {
                        AlaSquareLiveFragment.this.fCH.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.fCH != null) {
                    AlaSquareLiveFragment.this.fCH.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.fCJ = i;
        }
    };
    private AlaSquareLiveModel.a fCP = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void h(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.fCF != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.fCI.bFF();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.fCF.c(list, z, AlaSquareLiveFragment.this.fCI.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.fCF.bFR());
                        AlaSquareLiveFragment.this.fCF.completePullRefresh();
                        AlaSquareLiveFragment.this.kx(z2);
                        AlaSquareLiveFragment.this.fCF.c(list, z, AlaSquareLiveFragment.this.fCI.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.fCF.bFR(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.fCF.bFR());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void am(int i, String str) {
            if (AlaSquareLiveFragment.this.fCF != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.fCF.bFR());
                AlaSquareLiveFragment.this.fCF.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.fCI.bFF()) <= 0 || AlaSquareLiveFragment.this.fCF == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.fCF.bFR(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.fCK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kx(boolean z) {
        if (getPageContext() != null) {
            if (this.fCH == null) {
                this.fCH = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.fCH.getView().setVisibility(8);
            }
            this.fCF.bFU().removeHeaderView(this.fCH.getView());
            this.fCF.bFU().addHeaderView(this.fCH.getView(), 1);
            if (this.fCG == null) {
                this.fCG = new a(getPageContext());
                this.fCG.getView().setVisibility(8);
            }
            this.fCF.bFU().removeHeaderView(this.fCG.getView());
            this.fCF.bFU().addHeaderView(this.fCG.getView(), 2);
            ky(z);
            kz(z);
        }
    }

    private void ky(boolean z) {
        HeadLiveInfo headLiveInfo = this.fCI.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.fCH.getView().setVisibility(0);
                c cVar = new c();
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                cVar.ajz = bwVar;
                cVar.fDb = headLiveInfo.is_set.intValue();
                this.fCH.a(cVar);
                this.fCH.bFK();
            } else if (this.fCH != null && this.fCH.getView() != null) {
                this.fCF.bFU().removeHeaderView(this.fCH.getView());
                this.fCH.getView().setVisibility(8);
            }
        } else if (this.fCH != null && this.fCH.getView() != null) {
            this.fCF.bFU().removeHeaderView(this.fCH.getView());
            this.fCH.getView().setVisibility(8);
        }
    }

    private void kz(boolean z) {
        if (bx(this.fCI.getFunctionList())) {
            this.fCG.getView().setVisibility(0);
            this.fCG.by(this.fCI.getFunctionList());
        } else if (this.fCG != null && this.fCG.getView() != null) {
            this.fCF.bFU().removeHeaderView(this.fCG.getView());
            this.fCG.getView().setVisibility(8);
        }
    }

    private boolean bx(List<FunctionListInfo> list) {
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
        this.fCF = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.fCF.setListPullRefreshListener(this.eta);
        this.fCF.setOnSrollToBottomListener(this.Vh);
        this.fCF.a(this.fCN, 2000);
        this.fCF.setOnScrollListener(this.fCO);
        TiebaStatic.log("c12654");
        return this.fCF.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.fCK && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.fCM = (IAlaSquareTabController) runTask.getData();
            this.fCF.a(this.fCM);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fCF != null) {
            this.fCF.onChangeSkinType(i);
        }
        if (this.fCG != null) {
            this.fCG.onChangeSkinType(i);
        }
        if (this.fCH != null) {
            this.fCH.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fCI != null && y.isEmpty(this.fCI.bFF()) && !this.fCI.isRefreshing()) {
                bFq();
            }
            if (this.fCL != null) {
                this.fCL.onPageForeground(0);
            }
            if (this.fCH != null) {
                this.fCH.kA(false);
                this.fCH.bFK();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bGy().kM(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCI = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.fCP);
        this.fCL = new AlaSquareRefreshManager();
        this.fCL.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.fCF == null || this.fCF.bFU() == null) ? super.onGetPreLoadListView() : this.fCF.bFU().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fCL != null) {
            this.fCL.reset(i);
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
    protected void bFq() {
        hideNetRefreshView(this.fCF.bFR());
        if (y.getCount(this.fCI.bFF()) == 0 && this.fCF != null) {
            showLoadingView(this.fCF.bFR());
        }
        this.fCI.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.fCI != null) {
            return this.fCI.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.fCI != null && !y.isEmpty(this.fCI.bFF())) {
            this.fCI.bz(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fCL != null) {
            this.fCL.onPause();
        }
        if (this.fCH != null) {
            this.fCH.kA(true);
            this.fCH.stopPlay();
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
        if (this.fCL != null) {
            this.fCL.onDestory();
        }
        if (this.fCG != null) {
            this.fCG.onDestroy();
        }
        if (this.fCH != null) {
            this.fCH.onDestroy();
        }
        if (this.fCI != null) {
            this.fCI.onDestroy();
        }
        this.fCM = null;
        System.gc();
    }
}
