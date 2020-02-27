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
    private a ejN;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a ejO;
    private boolean ejR;
    private AlaSquareRefreshManager ejS;
    private IAlaSquareTabController ejT;
    private com.baidu.tieba.ala.alasquare.live.d.a ejM = null;
    private AlaSquareLiveModel ejP = null;
    private int ejQ = -1;
    private int mPaddingTop = 0;
    private g.c dgH = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.ejP != null) {
                AlaSquareLiveFragment.this.ejP.refresh();
            }
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.ejP != null) {
                AlaSquareLiveFragment.this.ejP.bcd();
            }
        }
    };
    private BdListView.d ejU = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener ejV = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bcV().bbP();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.ejQ != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.ejO != null) {
                        AlaSquareLiveFragment.this.ejO.bcj();
                        if (AlaSquareLiveFragment.this.ejO.bck() != null) {
                            c bck = AlaSquareLiveFragment.this.ejO.bck();
                            an anVar = new an("c12644");
                            if (bck.eki == 0) {
                                anVar.X("obj_type", 1);
                            } else if (bck.eki == 1) {
                                anVar.X("obj_type", 2);
                            }
                            anVar.cy("tid", bck.NQ.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bcV().xI("c12647");
                    if (AlaSquareLiveFragment.this.ejO != null) {
                        AlaSquareLiveFragment.this.ejO.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.ejO != null) {
                    AlaSquareLiveFragment.this.ejO.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.ejQ = i;
        }
    };
    private AlaSquareLiveModel.a ejW = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.ejM != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.ejP.bce();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.ejM.c(list, z, AlaSquareLiveFragment.this.ejP.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ejM.bcq());
                        AlaSquareLiveFragment.this.ejM.completePullRefresh();
                        AlaSquareLiveFragment.this.hO(z2);
                        AlaSquareLiveFragment.this.ejM.c(list, z, AlaSquareLiveFragment.this.ejP.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ejM.bcq(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.ejM.bcq());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void ag(int i, String str) {
            if (AlaSquareLiveFragment.this.ejM != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ejM.bcq());
                AlaSquareLiveFragment.this.ejM.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.ejP.bce()) <= 0 || AlaSquareLiveFragment.this.ejM == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ejM.bcq(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.ejR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(boolean z) {
        if (getPageContext() != null) {
            if (this.ejO == null) {
                this.ejO = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.ejO.getView().setVisibility(8);
            }
            this.ejM.bct().removeHeaderView(this.ejO.getView());
            this.ejM.bct().addHeaderView(this.ejO.getView(), 1);
            if (this.ejN == null) {
                this.ejN = new a(getPageContext());
                this.ejN.getView().setVisibility(8);
            }
            this.ejM.bct().removeHeaderView(this.ejN.getView());
            this.ejM.bct().addHeaderView(this.ejN.getView(), 2);
            hP(z);
            hQ(z);
        }
    }

    private void hP(boolean z) {
        HeadLiveInfo headLiveInfo = this.ejP.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.ejO.getView().setVisibility(0);
                c cVar = new c();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                cVar.NQ = bjVar;
                cVar.eki = headLiveInfo.is_set.intValue();
                this.ejO.a(cVar);
                this.ejO.bcj();
            } else if (this.ejO != null && this.ejO.getView() != null) {
                this.ejM.bct().removeHeaderView(this.ejO.getView());
                this.ejO.getView().setVisibility(8);
            }
        } else if (this.ejO != null && this.ejO.getView() != null) {
            this.ejM.bct().removeHeaderView(this.ejO.getView());
            this.ejO.getView().setVisibility(8);
        }
    }

    private void hQ(boolean z) {
        if (be(this.ejP.getFunctionList())) {
            this.ejN.getView().setVisibility(0);
            this.ejN.bf(this.ejP.getFunctionList());
        } else if (this.ejN != null && this.ejN.getView() != null) {
            this.ejM.bct().removeHeaderView(this.ejN.getView());
            this.ejN.getView().setVisibility(8);
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
        this.ejM = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.ejM.setListPullRefreshListener(this.dgH);
        this.ejM.setOnSrollToBottomListener(this.Az);
        this.ejM.a(this.ejU, 2000);
        this.ejM.setOnScrollListener(this.ejV);
        TiebaStatic.log("c12654");
        return this.ejM.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.ejR && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.ejT = (IAlaSquareTabController) runTask.getData();
            this.ejM.a(this.ejT);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ejM != null) {
            this.ejM.onChangeSkinType(i);
        }
        if (this.ejN != null) {
            this.ejN.onChangeSkinType(i);
        }
        if (this.ejO != null) {
            this.ejO.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ejP != null && v.isEmpty(this.ejP.bce()) && !this.ejP.isRefreshing()) {
                bbR();
            }
            if (this.ejS != null) {
                this.ejS.onPageForeground(0);
            }
            if (this.ejO != null) {
                this.ejO.hR(false);
                this.ejO.bcj();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bcV().ib(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ejP = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.ejW);
        this.ejS = new AlaSquareRefreshManager();
        this.ejS.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.ejM == null || this.ejM.bct() == null) ? super.onGetPreLoadListView() : this.ejM.bct().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ejS != null) {
            this.ejS.reset(i);
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
    protected void bbR() {
        hideNetRefreshView(this.ejM.bcq());
        if (v.getCount(this.ejP.bce()) == 0 && this.ejM != null) {
            showLoadingView(this.ejM.bcq());
        }
        this.ejP.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.ejP != null) {
            return this.ejP.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.ejP != null && !v.isEmpty(this.ejP.bce())) {
            this.ejP.bg(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ejS != null) {
            this.ejS.onPause();
        }
        if (this.ejO != null) {
            this.ejO.hR(true);
            this.ejO.stopPlay();
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
        if (this.ejS != null) {
            this.ejS.onDestory();
        }
        if (this.ejN != null) {
            this.ejN.onDestroy();
        }
        if (this.ejO != null) {
            this.ejO.onDestroy();
        }
        if (this.ejP != null) {
            this.ejP.onDestroy();
        }
        this.ejT = null;
        System.gc();
    }
}
