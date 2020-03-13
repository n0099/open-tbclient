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
    private a ekb;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a ekc;
    private boolean ekf;
    private AlaSquareRefreshManager ekg;
    private IAlaSquareTabController ekh;
    private com.baidu.tieba.ala.alasquare.live.d.a eka = null;
    private AlaSquareLiveModel ekd = null;
    private int eke = -1;
    private int mPaddingTop = 0;
    private g.c dgV = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.ekd != null) {
                AlaSquareLiveFragment.this.ekd.refresh();
            }
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.ekd != null) {
                AlaSquareLiveFragment.this.ekd.bcg();
            }
        }
    };
    private BdListView.d eki = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener ekj = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bcY().bbS();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.eke != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.ekc != null) {
                        AlaSquareLiveFragment.this.ekc.bcm();
                        if (AlaSquareLiveFragment.this.ekc.bcn() != null) {
                            c bcn = AlaSquareLiveFragment.this.ekc.bcn();
                            an anVar = new an("c12644");
                            if (bcn.ekw == 0) {
                                anVar.X("obj_type", 1);
                            } else if (bcn.ekw == 1) {
                                anVar.X("obj_type", 2);
                            }
                            anVar.cy("tid", bcn.NQ.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bcY().xJ("c12647");
                    if (AlaSquareLiveFragment.this.ekc != null) {
                        AlaSquareLiveFragment.this.ekc.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.ekc != null) {
                    AlaSquareLiveFragment.this.ekc.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.eke = i;
        }
    };
    private AlaSquareLiveModel.a ekk = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.eka != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.ekd.bch();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.eka.c(list, z, AlaSquareLiveFragment.this.ekd.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.eka.bct());
                        AlaSquareLiveFragment.this.eka.completePullRefresh();
                        AlaSquareLiveFragment.this.hO(z2);
                        AlaSquareLiveFragment.this.eka.c(list, z, AlaSquareLiveFragment.this.ekd.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.eka.bct(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.eka.bct());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void ag(int i, String str) {
            if (AlaSquareLiveFragment.this.eka != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.eka.bct());
                AlaSquareLiveFragment.this.eka.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.ekd.bch()) <= 0 || AlaSquareLiveFragment.this.eka == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.eka.bct(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.ekf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(boolean z) {
        if (getPageContext() != null) {
            if (this.ekc == null) {
                this.ekc = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.ekc.getView().setVisibility(8);
            }
            this.eka.bcw().removeHeaderView(this.ekc.getView());
            this.eka.bcw().addHeaderView(this.ekc.getView(), 1);
            if (this.ekb == null) {
                this.ekb = new a(getPageContext());
                this.ekb.getView().setVisibility(8);
            }
            this.eka.bcw().removeHeaderView(this.ekb.getView());
            this.eka.bcw().addHeaderView(this.ekb.getView(), 2);
            hP(z);
            hQ(z);
        }
    }

    private void hP(boolean z) {
        HeadLiveInfo headLiveInfo = this.ekd.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.ekc.getView().setVisibility(0);
                c cVar = new c();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                cVar.NQ = bjVar;
                cVar.ekw = headLiveInfo.is_set.intValue();
                this.ekc.a(cVar);
                this.ekc.bcm();
            } else if (this.ekc != null && this.ekc.getView() != null) {
                this.eka.bcw().removeHeaderView(this.ekc.getView());
                this.ekc.getView().setVisibility(8);
            }
        } else if (this.ekc != null && this.ekc.getView() != null) {
            this.eka.bcw().removeHeaderView(this.ekc.getView());
            this.ekc.getView().setVisibility(8);
        }
    }

    private void hQ(boolean z) {
        if (be(this.ekd.getFunctionList())) {
            this.ekb.getView().setVisibility(0);
            this.ekb.bf(this.ekd.getFunctionList());
        } else if (this.ekb != null && this.ekb.getView() != null) {
            this.eka.bcw().removeHeaderView(this.ekb.getView());
            this.ekb.getView().setVisibility(8);
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
        this.eka = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.eka.setListPullRefreshListener(this.dgV);
        this.eka.setOnSrollToBottomListener(this.Az);
        this.eka.a(this.eki, 2000);
        this.eka.setOnScrollListener(this.ekj);
        TiebaStatic.log("c12654");
        return this.eka.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.ekf && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.ekh = (IAlaSquareTabController) runTask.getData();
            this.eka.a(this.ekh);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eka != null) {
            this.eka.onChangeSkinType(i);
        }
        if (this.ekb != null) {
            this.ekb.onChangeSkinType(i);
        }
        if (this.ekc != null) {
            this.ekc.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ekd != null && v.isEmpty(this.ekd.bch()) && !this.ekd.isRefreshing()) {
                bbU();
            }
            if (this.ekg != null) {
                this.ekg.onPageForeground(0);
            }
            if (this.ekc != null) {
                this.ekc.hR(false);
                this.ekc.bcm();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bcY().ib(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ekd = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.ekk);
        this.ekg = new AlaSquareRefreshManager();
        this.ekg.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.eka == null || this.eka.bcw() == null) ? super.onGetPreLoadListView() : this.eka.bcw().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
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

    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment
    protected void bbU() {
        hideNetRefreshView(this.eka.bct());
        if (v.getCount(this.ekd.bch()) == 0 && this.eka != null) {
            showLoadingView(this.eka.bct());
        }
        this.ekd.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.ekd != null) {
            return this.ekd.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.ekd != null && !v.isEmpty(this.ekd.bch())) {
            this.ekd.bg(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ekg != null) {
            this.ekg.onPause();
        }
        if (this.ekc != null) {
            this.ekc.hR(true);
            this.ekc.stopPlay();
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
        if (this.ekg != null) {
            this.ekg.onDestory();
        }
        if (this.ekb != null) {
            this.ekb.onDestroy();
        }
        if (this.ekc != null) {
            this.ekc.onDestroy();
        }
        if (this.ekd != null) {
            this.ekd.onDestroy();
        }
        this.ekh = null;
        System.gc();
    }
}
