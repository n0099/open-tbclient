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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes6.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a gpM;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a gpN;
    private boolean gpQ;
    private AlaSquareRefreshManager gpR;
    private IAlaSquareTabController gpS;
    private com.baidu.tieba.ala.alasquare.live.d.a gpL = null;
    private AlaSquareLiveModel gpO = null;
    private int gpP = -1;
    private int mPaddingTop = 0;
    private f.c fci = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.gpO != null) {
                AlaSquareLiveFragment.this.gpO.refresh();
            }
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.gpO != null) {
                AlaSquareLiveFragment.this.gpO.bRN();
            }
        }
    };
    private BdListView.d gpT = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener gpU = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bSH().bPs();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.gpP != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.gpN != null) {
                        AlaSquareLiveFragment.this.gpN.bRT();
                        if (AlaSquareLiveFragment.this.gpN.bRU() != null) {
                            c bRU = AlaSquareLiveFragment.this.gpN.bRU();
                            ar arVar = new ar("c12644");
                            if (bRU.gqh == 0) {
                                arVar.al("obj_type", 1);
                            } else if (bRU.gqh == 1) {
                                arVar.al("obj_type", 2);
                            }
                            arVar.dY("tid", bRU.alu.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bSH().GN("c12647");
                    if (AlaSquareLiveFragment.this.gpN != null) {
                        AlaSquareLiveFragment.this.gpN.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.gpN != null) {
                    AlaSquareLiveFragment.this.gpN.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.gpP = i;
        }
    };
    private AlaSquareLiveModel.a gpV = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void i(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.gpL != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.gpO.bRO();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.gpL.c(list, z, AlaSquareLiveFragment.this.gpO.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gpL.bSa());
                        AlaSquareLiveFragment.this.gpL.completePullRefresh();
                        AlaSquareLiveFragment.this.lU(z2);
                        AlaSquareLiveFragment.this.gpL.c(list, z, AlaSquareLiveFragment.this.gpO.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gpL.bSa(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.gpL.bSa());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aC(int i, String str) {
            if (AlaSquareLiveFragment.this.gpL != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gpL.bSa());
                AlaSquareLiveFragment.this.gpL.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.gpO.bRO()) <= 0 || AlaSquareLiveFragment.this.gpL == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gpL.bSa(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.gpQ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(boolean z) {
        if (getPageContext() != null) {
            if (this.gpN == null) {
                this.gpN = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.gpN.getView().setVisibility(8);
            }
            this.gpL.bSd().removeHeaderView(this.gpN.getView());
            this.gpL.bSd().addHeaderView(this.gpN.getView(), 1);
            if (this.gpM == null) {
                this.gpM = new a(getPageContext());
                this.gpM.getView().setVisibility(8);
            }
            this.gpL.bSd().removeHeaderView(this.gpM.getView());
            this.gpL.bSd().addHeaderView(this.gpM.getView(), 2);
            lV(z);
            lW(z);
        }
    }

    private void lV(boolean z) {
        HeadLiveInfo headLiveInfo = this.gpO.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.gpN.getView().setVisibility(0);
                c cVar = new c();
                by byVar = new by();
                byVar.a(threadInfo);
                cVar.alu = byVar;
                cVar.gqh = headLiveInfo.is_set.intValue();
                this.gpN.a(cVar);
                this.gpN.bRT();
            } else if (this.gpN != null && this.gpN.getView() != null) {
                this.gpL.bSd().removeHeaderView(this.gpN.getView());
                this.gpN.getView().setVisibility(8);
            }
        } else if (this.gpN != null && this.gpN.getView() != null) {
            this.gpL.bSd().removeHeaderView(this.gpN.getView());
            this.gpN.getView().setVisibility(8);
        }
    }

    private void lW(boolean z) {
        if (ca(this.gpO.getFunctionList())) {
            this.gpM.getView().setVisibility(0);
            this.gpM.cb(this.gpO.getFunctionList());
        } else if (this.gpM != null && this.gpM.getView() != null) {
            this.gpL.bSd().removeHeaderView(this.gpM.getView());
            this.gpM.getView().setVisibility(8);
        }
    }

    private boolean ca(List<FunctionListInfo> list) {
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
        this.gpL = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.gpL.setListPullRefreshListener(this.fci);
        this.gpL.setOnSrollToBottomListener(this.WQ);
        this.gpL.a(this.gpT, 2000);
        this.gpL.setOnScrollListener(this.gpU);
        TiebaStatic.log("c12654");
        return this.gpL.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.gpQ && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.gpS = (IAlaSquareTabController) runTask.getData();
            this.gpL.a(this.gpS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gpL != null) {
            this.gpL.onChangeSkinType(i);
        }
        if (this.gpM != null) {
            this.gpM.onChangeSkinType(i);
        }
        if (this.gpN != null) {
            this.gpN.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gpO != null && y.isEmpty(this.gpO.bRO()) && !this.gpO.isRefreshing()) {
                bRz();
            }
            if (this.gpR != null) {
                this.gpR.onPageForeground(0);
            }
            if (this.gpN != null) {
                this.gpN.lX(false);
                this.gpN.bRT();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bSH().mj(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gpO = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.gpV);
        this.gpR = new AlaSquareRefreshManager();
        this.gpR.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.gpL == null || this.gpL.bSd() == null) ? super.onGetPreLoadListView() : this.gpL.bSd().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gpR != null) {
            this.gpR.reset(i);
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
    protected void bRz() {
        hideNetRefreshView(this.gpL.bSa());
        if (y.getCount(this.gpO.bRO()) == 0 && this.gpL != null) {
            showLoadingView(this.gpL.bSa());
        }
        this.gpO.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.gpO != null) {
            return this.gpO.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.gpO != null && !y.isEmpty(this.gpO.bRO())) {
            this.gpO.cc(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gpR != null) {
            this.gpR.onPause();
        }
        if (this.gpN != null) {
            this.gpN.lX(true);
            this.gpN.stopPlay();
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
        if (this.gpR != null) {
            this.gpR.onDestory();
        }
        if (this.gpM != null) {
            this.gpM.onDestroy();
        }
        if (this.gpN != null) {
            this.gpN.onDestroy();
        }
        if (this.gpO != null) {
            this.gpO.onDestroy();
        }
        this.gpS = null;
        System.gc();
    }
}
