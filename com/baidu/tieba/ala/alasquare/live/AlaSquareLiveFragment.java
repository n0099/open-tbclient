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
    private a eNW;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a eNX;
    private boolean eOa;
    private AlaSquareRefreshManager eOb;
    private IAlaSquareTabController eOc;
    private com.baidu.tieba.ala.alasquare.live.d.a eNV = null;
    private AlaSquareLiveModel eNY = null;
    private int eNZ = -1;
    private int mPaddingTop = 0;
    private g.c dHh = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.eNY != null) {
                AlaSquareLiveFragment.this.eNY.refresh();
            }
        }
    };
    private BdListView.e TT = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.eNY != null) {
                AlaSquareLiveFragment.this.eNY.bkZ();
            }
        }
    };
    private BdListView.d eOd = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener eOe = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.blS().bjX();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.eNZ != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.eNX != null) {
                        AlaSquareLiveFragment.this.eNX.blf();
                        if (AlaSquareLiveFragment.this.eNX.blg() != null) {
                            c blg = AlaSquareLiveFragment.this.eNX.blg();
                            an anVar = new an("c12644");
                            if (blg.eOr == 0) {
                                anVar.af("obj_type", 1);
                            } else if (blg.eOr == 1) {
                                anVar.af("obj_type", 2);
                            }
                            anVar.cI("tid", blg.agC.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.blS().zr("c12647");
                    if (AlaSquareLiveFragment.this.eNX != null) {
                        AlaSquareLiveFragment.this.eNX.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.eNX != null) {
                    AlaSquareLiveFragment.this.eNX.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.eNZ = i;
        }
    };
    private AlaSquareLiveModel.a eOf = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.eNV != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.eNY.bla();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.eNV.c(list, z, AlaSquareLiveFragment.this.eNY.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.eNV.blm());
                        AlaSquareLiveFragment.this.eNV.completePullRefresh();
                        AlaSquareLiveFragment.this.iO(z2);
                        AlaSquareLiveFragment.this.eNV.c(list, z, AlaSquareLiveFragment.this.eNY.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.eNV.blm(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.eNV.blm());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void av(int i, String str) {
            if (AlaSquareLiveFragment.this.eNV != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.eNV.blm());
                AlaSquareLiveFragment.this.eNV.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.eNY.bla()) <= 0 || AlaSquareLiveFragment.this.eNV == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.eNV.blm(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.eOa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO(boolean z) {
        if (getPageContext() != null) {
            if (this.eNX == null) {
                this.eNX = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.eNX.getView().setVisibility(8);
            }
            this.eNV.blp().removeHeaderView(this.eNX.getView());
            this.eNV.blp().addHeaderView(this.eNX.getView(), 1);
            if (this.eNW == null) {
                this.eNW = new a(getPageContext());
                this.eNW.getView().setVisibility(8);
            }
            this.eNV.blp().removeHeaderView(this.eNW.getView());
            this.eNV.blp().addHeaderView(this.eNW.getView(), 2);
            iP(z);
            iQ(z);
        }
    }

    private void iP(boolean z) {
        HeadLiveInfo headLiveInfo = this.eNY.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.eNX.getView().setVisibility(0);
                c cVar = new c();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                cVar.agC = bjVar;
                cVar.eOr = headLiveInfo.is_set.intValue();
                this.eNX.a(cVar);
                this.eNX.blf();
            } else if (this.eNX != null && this.eNX.getView() != null) {
                this.eNV.blp().removeHeaderView(this.eNX.getView());
                this.eNX.getView().setVisibility(8);
            }
        } else if (this.eNX != null && this.eNX.getView() != null) {
            this.eNV.blp().removeHeaderView(this.eNX.getView());
            this.eNX.getView().setVisibility(8);
        }
    }

    private void iQ(boolean z) {
        if (bo(this.eNY.getFunctionList())) {
            this.eNW.getView().setVisibility(0);
            this.eNW.bp(this.eNY.getFunctionList());
        } else if (this.eNW != null && this.eNW.getView() != null) {
            this.eNV.blp().removeHeaderView(this.eNW.getView());
            this.eNW.getView().setVisibility(8);
        }
    }

    private boolean bo(List<FunctionListInfo> list) {
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
        this.eNV = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.eNV.setListPullRefreshListener(this.dHh);
        this.eNV.setOnSrollToBottomListener(this.TT);
        this.eNV.a(this.eOd, 2000);
        this.eNV.setOnScrollListener(this.eOe);
        TiebaStatic.log("c12654");
        return this.eNV.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.eOa && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.eOc = (IAlaSquareTabController) runTask.getData();
            this.eNV.a(this.eOc);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eNV != null) {
            this.eNV.onChangeSkinType(i);
        }
        if (this.eNW != null) {
            this.eNW.onChangeSkinType(i);
        }
        if (this.eNX != null) {
            this.eNX.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.eNY != null && v.isEmpty(this.eNY.bla()) && !this.eNY.isRefreshing()) {
                bkN();
            }
            if (this.eOb != null) {
                this.eOb.onPageForeground(0);
            }
            if (this.eNX != null) {
                this.eNX.iR(false);
                this.eNX.blf();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.blS().jd(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eNY = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.eOf);
        this.eOb = new AlaSquareRefreshManager();
        this.eOb.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.eNV == null || this.eNV.blp() == null) ? super.onGetPreLoadListView() : this.eNV.blp().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.eOb != null) {
            this.eOb.reset(i);
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
    protected void bkN() {
        hideNetRefreshView(this.eNV.blm());
        if (v.getCount(this.eNY.bla()) == 0 && this.eNV != null) {
            showLoadingView(this.eNV.blm());
        }
        this.eNY.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.eNY != null) {
            return this.eNY.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.eNY != null && !v.isEmpty(this.eNY.bla())) {
            this.eNY.bq(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eOb != null) {
            this.eOb.onPause();
        }
        if (this.eNX != null) {
            this.eNX.iR(true);
            this.eNX.stopPlay();
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
        if (this.eOb != null) {
            this.eOb.onDestory();
        }
        if (this.eNW != null) {
            this.eNW.onDestroy();
        }
        if (this.eNX != null) {
            this.eNX.onDestroy();
        }
        if (this.eNY != null) {
            this.eNY.onDestroy();
        }
        this.eOc = null;
        System.gc();
    }
}
