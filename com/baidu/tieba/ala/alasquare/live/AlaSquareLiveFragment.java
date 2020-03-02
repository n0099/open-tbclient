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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.p;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.ala.alasquare.live.c.a;
import com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a ejO;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a ejP;
    private boolean ejS;
    private AlaSquareRefreshManager ejT;
    private IAlaSquareTabController ejU;
    private com.baidu.tieba.ala.alasquare.live.d.a ejN = null;
    private AlaSquareLiveModel ejQ = null;
    private int ejR = -1;
    private int mPaddingTop = 0;
    private g.c dgI = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.ejQ != null) {
                AlaSquareLiveFragment.this.ejQ.refresh();
            }
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.ejQ != null) {
                AlaSquareLiveFragment.this.ejQ.bcf();
            }
        }
    };
    private BdListView.d ejV = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener ejW = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bcX().bbR();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.ejR != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.ejP != null) {
                        AlaSquareLiveFragment.this.ejP.bcl();
                        if (AlaSquareLiveFragment.this.ejP.bcm() != null) {
                            c bcm = AlaSquareLiveFragment.this.ejP.bcm();
                            an anVar = new an("c12644");
                            if (bcm.ekj == 0) {
                                anVar.X("obj_type", 1);
                            } else if (bcm.ekj == 1) {
                                anVar.X("obj_type", 2);
                            }
                            anVar.cy("tid", bcm.NQ.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bcX().xI("c12647");
                    if (AlaSquareLiveFragment.this.ejP != null) {
                        AlaSquareLiveFragment.this.ejP.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.ejP != null) {
                    AlaSquareLiveFragment.this.ejP.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.ejR = i;
        }
    };
    private AlaSquareLiveModel.a ejX = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.ejN != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.ejQ.bcg();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.ejN.c(list, z, AlaSquareLiveFragment.this.ejQ.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ejN.bcs());
                        AlaSquareLiveFragment.this.ejN.completePullRefresh();
                        AlaSquareLiveFragment.this.hO(z2);
                        AlaSquareLiveFragment.this.ejN.c(list, z, AlaSquareLiveFragment.this.ejQ.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ejN.bcs(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.ejN.bcs());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void ag(int i, String str) {
            if (AlaSquareLiveFragment.this.ejN != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ejN.bcs());
                AlaSquareLiveFragment.this.ejN.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.ejQ.bcg()) <= 0 || AlaSquareLiveFragment.this.ejN == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ejN.bcs(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.ejS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(boolean z) {
        if (getPageContext() != null) {
            if (this.ejP == null) {
                this.ejP = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.ejP.getView().setVisibility(8);
            }
            this.ejN.bcv().removeHeaderView(this.ejP.getView());
            this.ejN.bcv().addHeaderView(this.ejP.getView(), 1);
            if (this.ejO == null) {
                this.ejO = new a(getPageContext());
                this.ejO.getView().setVisibility(8);
            }
            this.ejN.bcv().removeHeaderView(this.ejO.getView());
            this.ejN.bcv().addHeaderView(this.ejO.getView(), 2);
            hP(z);
            hQ(z);
        }
    }

    private void hP(boolean z) {
        HeadLiveInfo headLiveInfo = this.ejQ.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.ejP.getView().setVisibility(0);
                c cVar = new c();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                cVar.NQ = bjVar;
                cVar.ekj = headLiveInfo.is_set.intValue();
                this.ejP.a(cVar);
                this.ejP.bcl();
            } else if (this.ejP != null && this.ejP.getView() != null) {
                this.ejN.bcv().removeHeaderView(this.ejP.getView());
                this.ejP.getView().setVisibility(8);
            }
        } else if (this.ejP != null && this.ejP.getView() != null) {
            this.ejN.bcv().removeHeaderView(this.ejP.getView());
            this.ejP.getView().setVisibility(8);
        }
    }

    private void hQ(boolean z) {
        if (be(this.ejQ.getFunctionList())) {
            this.ejO.getView().setVisibility(0);
            this.ejO.bf(this.ejQ.getFunctionList());
        } else if (this.ejO != null && this.ejO.getView() != null) {
            this.ejN.bcv().removeHeaderView(this.ejO.getView());
            this.ejO.getView().setVisibility(8);
        }
    }

    private boolean be(List<FunctionListInfo> list) {
        int i;
        if (!v.isEmpty(list) && v.getCount(list) >= 2 && v.getCount(list) <= 3) {
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
        this.ejN = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.ejN.setListPullRefreshListener(this.dgI);
        this.ejN.setOnSrollToBottomListener(this.Az);
        this.ejN.a(this.ejV, 2000);
        this.ejN.setOnScrollListener(this.ejW);
        TiebaStatic.log("c12654");
        return this.ejN.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.ejS && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.ejU = (IAlaSquareTabController) runTask.getData();
            this.ejN.a(this.ejU);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ejN != null) {
            this.ejN.onChangeSkinType(i);
        }
        if (this.ejO != null) {
            this.ejO.onChangeSkinType(i);
        }
        if (this.ejP != null) {
            this.ejP.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ejQ != null && v.isEmpty(this.ejQ.bcg()) && !this.ejQ.isRefreshing()) {
                bbT();
            }
            if (this.ejT != null) {
                this.ejT.onPageForeground(0);
            }
            if (this.ejP != null) {
                this.ejP.hR(false);
                this.ejP.bcl();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bcX().ib(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ejQ = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.ejX);
        this.ejT = new AlaSquareRefreshManager();
        this.ejT.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.ejN == null || this.ejN.bcv() == null) ? super.onGetPreLoadListView() : this.ejN.bcv().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ejT != null) {
            this.ejT.reset(i);
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
    protected void bbT() {
        hideNetRefreshView(this.ejN.bcs());
        if (v.getCount(this.ejQ.bcg()) == 0 && this.ejN != null) {
            showLoadingView(this.ejN.bcs());
        }
        this.ejQ.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.ejQ != null) {
            return this.ejQ.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.ejQ != null && !v.isEmpty(this.ejQ.bcg())) {
            this.ejQ.bg(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ejT != null) {
            this.ejT.onPause();
        }
        if (this.ejP != null) {
            this.ejP.hR(true);
            this.ejP.stopPlay();
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
        if (this.ejT != null) {
            this.ejT.onDestory();
        }
        if (this.ejO != null) {
            this.ejO.onDestroy();
        }
        if (this.ejP != null) {
            this.ejP.onDestroy();
        }
        if (this.ejQ != null) {
            this.ejQ.onDestroy();
        }
        this.ejU = null;
        System.gc();
    }
}
