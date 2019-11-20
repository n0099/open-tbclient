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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.ala.alasquare.live.c.a;
import com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private boolean duB;
    private AlaSquareRefreshManager duC;
    private IAlaSquareTabController duD;
    private a dux;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a duy;
    private com.baidu.tieba.ala.alasquare.live.d.a duw = null;
    private AlaSquareLiveModel duz = null;
    private int duA = -1;
    private int mPaddingTop = 0;
    private h.c cpa = new h.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.duz != null) {
                AlaSquareLiveFragment.this.duz.refresh();
            }
        }
    };
    private BdListView.e xE = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.duz != null) {
                AlaSquareLiveFragment.this.duz.aIU();
            }
        }
    };
    private BdListView.d duE = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener duF = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.aJM().aIJ();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.duA != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.duy != null) {
                        AlaSquareLiveFragment.this.duy.aJa();
                        if (AlaSquareLiveFragment.this.duy.aJb() != null) {
                            c aJb = AlaSquareLiveFragment.this.duy.aJb();
                            an anVar = new an("c12644");
                            if (aJb.duS == 0) {
                                anVar.O("obj_type", 1);
                            } else if (aJb.duS == 1) {
                                anVar.O("obj_type", 2);
                            }
                            anVar.bS("tid", aJb.cqG.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.aJM().sD("c12647");
                    if (AlaSquareLiveFragment.this.duy != null) {
                        AlaSquareLiveFragment.this.duy.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.duy != null) {
                    AlaSquareLiveFragment.this.duy.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.duA = i;
        }
    };
    private AlaSquareLiveModel.a duG = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.duw != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.duz.aIV();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.duw.a(list, z, AlaSquareLiveFragment.this.duz.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.duw.aJh());
                        AlaSquareLiveFragment.this.duw.completePullRefresh();
                        AlaSquareLiveFragment.this.gx(z2);
                        AlaSquareLiveFragment.this.duw.a(list, z, AlaSquareLiveFragment.this.duz.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.duw.aJh(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.duw.aJh());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void O(int i, String str) {
            if (AlaSquareLiveFragment.this.duw != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.duw.aJh());
                AlaSquareLiveFragment.this.duw.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.duz.aIV()) <= 0 || AlaSquareLiveFragment.this.duw == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.duw.aJh(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.duB = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        if (getPageContext() != null) {
            if (this.duy == null) {
                this.duy = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.duy.getView().setVisibility(8);
            }
            this.duw.aJk().removeHeaderView(this.duy.getView());
            this.duw.aJk().addHeaderView(this.duy.getView(), 1);
            if (this.dux == null) {
                this.dux = new a(getPageContext());
                this.dux.getView().setVisibility(8);
            }
            this.duw.aJk().removeHeaderView(this.dux.getView());
            this.duw.aJk().addHeaderView(this.dux.getView(), 2);
            gy(z);
            gz(z);
        }
    }

    private void gy(boolean z) {
        HeadLiveInfo headLiveInfo = this.duz.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.duy.getView().setVisibility(0);
                c cVar = new c();
                bh bhVar = new bh();
                bhVar.a(threadInfo);
                cVar.cqG = bhVar;
                cVar.duS = headLiveInfo.is_set.intValue();
                this.duy.a(cVar);
                this.duy.aJa();
            } else if (this.duy != null && this.duy.getView() != null) {
                this.duw.aJk().removeHeaderView(this.duy.getView());
                this.duy.getView().setVisibility(8);
            }
        } else if (this.duy != null && this.duy.getView() != null) {
            this.duw.aJk().removeHeaderView(this.duy.getView());
            this.duy.getView().setVisibility(8);
        }
    }

    private void gz(boolean z) {
        if (bg(this.duz.getFunctionList())) {
            this.dux.getView().setVisibility(0);
            this.dux.bh(this.duz.getFunctionList());
        } else if (this.dux != null && this.dux.getView() != null) {
            this.duw.aJk().removeHeaderView(this.dux.getView());
            this.dux.getView().setVisibility(8);
        }
    }

    private boolean bg(List<FunctionListInfo> list) {
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

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mPaddingTop == 0) {
            this.mPaddingTop = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
        }
        this.duw = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.duw.setListPullRefreshListener(this.cpa);
        this.duw.setOnSrollToBottomListener(this.xE);
        this.duw.a(this.duE, 2000);
        this.duw.setOnScrollListener(this.duF);
        TiebaStatic.log("c12654");
        return this.duw.getView();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.duB && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.duD = (IAlaSquareTabController) runTask.getData();
            this.duw.a(this.duD);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.duw != null) {
            this.duw.onChangeSkinType(i);
        }
        if (this.dux != null) {
            this.dux.onChangeSkinType(i);
        }
        if (this.duy != null) {
            this.duy.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.duz != null && v.isEmpty(this.duz.aIV()) && !this.duz.isRefreshing()) {
                aIK();
            }
            if (this.duC != null) {
                this.duC.onPageForeground(0);
            }
            if (this.duy != null) {
                this.duy.gA(false);
                this.duy.aJa();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.aJM().gF(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.duz = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.duG);
        this.duC = new AlaSquareRefreshManager();
        this.duC.init(this, new long[]{StatisticConfig.MIN_UPLOAD_INTERVAL});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.duw == null || this.duw.aJk() == null) ? super.onGetPreLoadListView() : this.duw.aJk().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.duC != null) {
            this.duC.reset(i);
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
    protected void aIK() {
        hideNetRefreshView(this.duw.aJh());
        if (v.getCount(this.duz.aIV()) == 0 && this.duw != null) {
            showLoadingView(this.duw.aJh());
        }
        this.duz.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.duz != null) {
            return this.duz.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.duz != null && !v.isEmpty(this.duz.aIV())) {
            this.duz.bi(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.duC != null) {
            this.duC.onPause();
        }
        if (this.duy != null) {
            this.duy.gA(true);
            this.duy.stopPlay();
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
        if (this.duC != null) {
            this.duC.onDestory();
        }
        if (this.dux != null) {
            this.dux.onDestroy();
        }
        if (this.duy != null) {
            this.duy.onDestroy();
        }
        if (this.duz != null) {
            this.duz.onDestroy();
        }
        this.duD = null;
        System.gc();
    }
}
