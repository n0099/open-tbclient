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
    private a eNR;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a eNS;
    private boolean eNV;
    private AlaSquareRefreshManager eNW;
    private IAlaSquareTabController eNX;
    private com.baidu.tieba.ala.alasquare.live.d.a eNQ = null;
    private AlaSquareLiveModel eNT = null;
    private int eNU = -1;
    private int mPaddingTop = 0;
    private g.c dHd = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.eNT != null) {
                AlaSquareLiveFragment.this.eNT.refresh();
            }
        }
    };
    private BdListView.e TQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.eNT != null) {
                AlaSquareLiveFragment.this.eNT.blb();
            }
        }
    };
    private BdListView.d eNY = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener eNZ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.blU().bjZ();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.eNU != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.eNS != null) {
                        AlaSquareLiveFragment.this.eNS.blh();
                        if (AlaSquareLiveFragment.this.eNS.bli() != null) {
                            c bli = AlaSquareLiveFragment.this.eNS.bli();
                            an anVar = new an("c12644");
                            if (bli.eOm == 0) {
                                anVar.af("obj_type", 1);
                            } else if (bli.eOm == 1) {
                                anVar.af("obj_type", 2);
                            }
                            anVar.cI("tid", bli.agz.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.blU().zo("c12647");
                    if (AlaSquareLiveFragment.this.eNS != null) {
                        AlaSquareLiveFragment.this.eNS.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.eNS != null) {
                    AlaSquareLiveFragment.this.eNS.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.eNU = i;
        }
    };
    private AlaSquareLiveModel.a eOa = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.eNQ != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.eNT.blc();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.eNQ.c(list, z, AlaSquareLiveFragment.this.eNT.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.eNQ.blo());
                        AlaSquareLiveFragment.this.eNQ.completePullRefresh();
                        AlaSquareLiveFragment.this.iO(z2);
                        AlaSquareLiveFragment.this.eNQ.c(list, z, AlaSquareLiveFragment.this.eNT.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.eNQ.blo(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.eNQ.blo());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void av(int i, String str) {
            if (AlaSquareLiveFragment.this.eNQ != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.eNQ.blo());
                AlaSquareLiveFragment.this.eNQ.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.eNT.blc()) <= 0 || AlaSquareLiveFragment.this.eNQ == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.eNQ.blo(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.eNV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO(boolean z) {
        if (getPageContext() != null) {
            if (this.eNS == null) {
                this.eNS = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.eNS.getView().setVisibility(8);
            }
            this.eNQ.blr().removeHeaderView(this.eNS.getView());
            this.eNQ.blr().addHeaderView(this.eNS.getView(), 1);
            if (this.eNR == null) {
                this.eNR = new a(getPageContext());
                this.eNR.getView().setVisibility(8);
            }
            this.eNQ.blr().removeHeaderView(this.eNR.getView());
            this.eNQ.blr().addHeaderView(this.eNR.getView(), 2);
            iP(z);
            iQ(z);
        }
    }

    private void iP(boolean z) {
        HeadLiveInfo headLiveInfo = this.eNT.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.eNS.getView().setVisibility(0);
                c cVar = new c();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                cVar.agz = bjVar;
                cVar.eOm = headLiveInfo.is_set.intValue();
                this.eNS.a(cVar);
                this.eNS.blh();
            } else if (this.eNS != null && this.eNS.getView() != null) {
                this.eNQ.blr().removeHeaderView(this.eNS.getView());
                this.eNS.getView().setVisibility(8);
            }
        } else if (this.eNS != null && this.eNS.getView() != null) {
            this.eNQ.blr().removeHeaderView(this.eNS.getView());
            this.eNS.getView().setVisibility(8);
        }
    }

    private void iQ(boolean z) {
        if (bo(this.eNT.getFunctionList())) {
            this.eNR.getView().setVisibility(0);
            this.eNR.bp(this.eNT.getFunctionList());
        } else if (this.eNR != null && this.eNR.getView() != null) {
            this.eNQ.blr().removeHeaderView(this.eNR.getView());
            this.eNR.getView().setVisibility(8);
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
        this.eNQ = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.eNQ.setListPullRefreshListener(this.dHd);
        this.eNQ.setOnSrollToBottomListener(this.TQ);
        this.eNQ.a(this.eNY, 2000);
        this.eNQ.setOnScrollListener(this.eNZ);
        TiebaStatic.log("c12654");
        return this.eNQ.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.eNV && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.eNX = (IAlaSquareTabController) runTask.getData();
            this.eNQ.a(this.eNX);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eNQ != null) {
            this.eNQ.onChangeSkinType(i);
        }
        if (this.eNR != null) {
            this.eNR.onChangeSkinType(i);
        }
        if (this.eNS != null) {
            this.eNS.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.eNT != null && v.isEmpty(this.eNT.blc()) && !this.eNT.isRefreshing()) {
                bkP();
            }
            if (this.eNW != null) {
                this.eNW.onPageForeground(0);
            }
            if (this.eNS != null) {
                this.eNS.iR(false);
                this.eNS.blh();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.blU().jd(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eNT = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.eOa);
        this.eNW = new AlaSquareRefreshManager();
        this.eNW.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.eNQ == null || this.eNQ.blr() == null) ? super.onGetPreLoadListView() : this.eNQ.blr().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.eNW != null) {
            this.eNW.reset(i);
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
    protected void bkP() {
        hideNetRefreshView(this.eNQ.blo());
        if (v.getCount(this.eNT.blc()) == 0 && this.eNQ != null) {
            showLoadingView(this.eNQ.blo());
        }
        this.eNT.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.eNT != null) {
            return this.eNT.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.eNT != null && !v.isEmpty(this.eNT.blc())) {
            this.eNT.bq(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.eNW != null) {
            this.eNW.onPause();
        }
        if (this.eNS != null) {
            this.eNS.iR(true);
            this.eNS.stopPlay();
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
        if (this.eNW != null) {
            this.eNW.onDestory();
        }
        if (this.eNR != null) {
            this.eNR.onDestroy();
        }
        if (this.eNS != null) {
            this.eNS.onDestroy();
        }
        if (this.eNT != null) {
            this.eNT.onDestroy();
        }
        this.eNX = null;
        System.gc();
    }
}
