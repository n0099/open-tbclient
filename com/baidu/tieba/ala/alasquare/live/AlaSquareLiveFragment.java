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
    private a ghT;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a ghU;
    private boolean ghX;
    private AlaSquareRefreshManager ghY;
    private IAlaSquareTabController ghZ;
    private com.baidu.tieba.ala.alasquare.live.d.a ghS = null;
    private AlaSquareLiveModel ghV = null;
    private int ghW = -1;
    private int mPaddingTop = 0;
    private f.c eVA = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.ghV != null) {
                AlaSquareLiveFragment.this.ghV.refresh();
            }
        }
    };
    private BdListView.e VR = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.ghV != null) {
                AlaSquareLiveFragment.this.ghV.bOI();
            }
        }
    };
    private BdListView.d gia = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener gib = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bPC().bMp();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.ghW != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.ghU != null) {
                        AlaSquareLiveFragment.this.ghU.bOO();
                        if (AlaSquareLiveFragment.this.ghU.bOP() != null) {
                            c bOP = AlaSquareLiveFragment.this.ghU.bOP();
                            aq aqVar = new aq("c12644");
                            if (bOP.gip == 0) {
                                aqVar.al("obj_type", 1);
                            } else if (bOP.gip == 1) {
                                aqVar.al("obj_type", 2);
                            }
                            aqVar.dR("tid", bOP.akq.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bPC().Gy("c12647");
                    if (AlaSquareLiveFragment.this.ghU != null) {
                        AlaSquareLiveFragment.this.ghU.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.ghU != null) {
                    AlaSquareLiveFragment.this.ghU.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.ghW = i;
        }
    };
    private AlaSquareLiveModel.a gic = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void i(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.ghS != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.ghV.bOJ();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.ghS.c(list, z, AlaSquareLiveFragment.this.ghV.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ghS.bOV());
                        AlaSquareLiveFragment.this.ghS.completePullRefresh();
                        AlaSquareLiveFragment.this.ly(z2);
                        AlaSquareLiveFragment.this.ghS.c(list, z, AlaSquareLiveFragment.this.ghV.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ghS.bOV(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.ghS.bOV());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aE(int i, String str) {
            if (AlaSquareLiveFragment.this.ghS != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ghS.bOV());
                AlaSquareLiveFragment.this.ghS.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.ghV.bOJ()) <= 0 || AlaSquareLiveFragment.this.ghS == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ghS.bOV(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.ghX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ly(boolean z) {
        if (getPageContext() != null) {
            if (this.ghU == null) {
                this.ghU = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.ghU.getView().setVisibility(8);
            }
            this.ghS.bOY().removeHeaderView(this.ghU.getView());
            this.ghS.bOY().addHeaderView(this.ghU.getView(), 1);
            if (this.ghT == null) {
                this.ghT = new a(getPageContext());
                this.ghT.getView().setVisibility(8);
            }
            this.ghS.bOY().removeHeaderView(this.ghT.getView());
            this.ghS.bOY().addHeaderView(this.ghT.getView(), 2);
            lz(z);
            lA(z);
        }
    }

    private void lz(boolean z) {
        HeadLiveInfo headLiveInfo = this.ghV.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.ghU.getView().setVisibility(0);
                c cVar = new c();
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                cVar.akq = bwVar;
                cVar.gip = headLiveInfo.is_set.intValue();
                this.ghU.a(cVar);
                this.ghU.bOO();
            } else if (this.ghU != null && this.ghU.getView() != null) {
                this.ghS.bOY().removeHeaderView(this.ghU.getView());
                this.ghU.getView().setVisibility(8);
            }
        } else if (this.ghU != null && this.ghU.getView() != null) {
            this.ghS.bOY().removeHeaderView(this.ghU.getView());
            this.ghU.getView().setVisibility(8);
        }
    }

    private void lA(boolean z) {
        if (bW(this.ghV.getFunctionList())) {
            this.ghT.getView().setVisibility(0);
            this.ghT.bX(this.ghV.getFunctionList());
        } else if (this.ghT != null && this.ghT.getView() != null) {
            this.ghS.bOY().removeHeaderView(this.ghT.getView());
            this.ghT.getView().setVisibility(8);
        }
    }

    private boolean bW(List<FunctionListInfo> list) {
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
        this.ghS = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.ghS.setListPullRefreshListener(this.eVA);
        this.ghS.setOnSrollToBottomListener(this.VR);
        this.ghS.a(this.gia, 2000);
        this.ghS.setOnScrollListener(this.gib);
        TiebaStatic.log("c12654");
        return this.ghS.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.ghX && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.ghZ = (IAlaSquareTabController) runTask.getData();
            this.ghS.a(this.ghZ);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ghS != null) {
            this.ghS.onChangeSkinType(i);
        }
        if (this.ghT != null) {
            this.ghT.onChangeSkinType(i);
        }
        if (this.ghU != null) {
            this.ghU.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ghV != null && y.isEmpty(this.ghV.bOJ()) && !this.ghV.isRefreshing()) {
                bOu();
            }
            if (this.ghY != null) {
                this.ghY.onPageForeground(0);
            }
            if (this.ghU != null) {
                this.ghU.lB(false);
                this.ghU.bOO();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bPC().lN(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ghV = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.gic);
        this.ghY = new AlaSquareRefreshManager();
        this.ghY.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.ghS == null || this.ghS.bOY() == null) ? super.onGetPreLoadListView() : this.ghS.bOY().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ghY != null) {
            this.ghY.reset(i);
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
    protected void bOu() {
        hideNetRefreshView(this.ghS.bOV());
        if (y.getCount(this.ghV.bOJ()) == 0 && this.ghS != null) {
            showLoadingView(this.ghS.bOV());
        }
        this.ghV.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.ghV != null) {
            return this.ghV.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.ghV != null && !y.isEmpty(this.ghV.bOJ())) {
            this.ghV.bY(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ghY != null) {
            this.ghY.onPause();
        }
        if (this.ghU != null) {
            this.ghU.lB(true);
            this.ghU.stopPlay();
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
        if (this.ghY != null) {
            this.ghY.onDestory();
        }
        if (this.ghT != null) {
            this.ghT.onDestroy();
        }
        if (this.ghU != null) {
            this.ghU.onDestroy();
        }
        if (this.ghV != null) {
            this.ghV.onDestroy();
        }
        this.ghZ = null;
        System.gc();
    }
}
