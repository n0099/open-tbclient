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
    private a fCC;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a fCD;
    private boolean fCG;
    private AlaSquareRefreshManager fCH;
    private IAlaSquareTabController fCI;
    private com.baidu.tieba.ala.alasquare.live.d.a fCB = null;
    private AlaSquareLiveModel fCE = null;
    private int fCF = -1;
    private int mPaddingTop = 0;
    private f.c esW = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.fCE != null) {
                AlaSquareLiveFragment.this.fCE.refresh();
            }
        }
    };
    private BdListView.e Vh = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.fCE != null) {
                AlaSquareLiveFragment.this.fCE.bFD();
            }
        }
    };
    private BdListView.d fCJ = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener fCK = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bGx().bDV();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.fCF != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.fCD != null) {
                        AlaSquareLiveFragment.this.fCD.bFJ();
                        if (AlaSquareLiveFragment.this.fCD.bFK() != null) {
                            c bFK = AlaSquareLiveFragment.this.fCD.bFK();
                            aq aqVar = new aq("c12644");
                            if (bFK.fCX == 0) {
                                aqVar.ai("obj_type", 1);
                            } else if (bFK.fCX == 1) {
                                aqVar.ai("obj_type", 2);
                            }
                            aqVar.dD("tid", bFK.ajx.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bGx().EB("c12647");
                    if (AlaSquareLiveFragment.this.fCD != null) {
                        AlaSquareLiveFragment.this.fCD.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.fCD != null) {
                    AlaSquareLiveFragment.this.fCD.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.fCF = i;
        }
    };
    private AlaSquareLiveModel.a fCL = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void h(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.fCB != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.fCE.bFE();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.fCB.c(list, z, AlaSquareLiveFragment.this.fCE.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.fCB.bFQ());
                        AlaSquareLiveFragment.this.fCB.completePullRefresh();
                        AlaSquareLiveFragment.this.kv(z2);
                        AlaSquareLiveFragment.this.fCB.c(list, z, AlaSquareLiveFragment.this.fCE.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.fCB.bFQ(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.fCB.bFQ());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void am(int i, String str) {
            if (AlaSquareLiveFragment.this.fCB != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.fCB.bFQ());
                AlaSquareLiveFragment.this.fCB.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.fCE.bFE()) <= 0 || AlaSquareLiveFragment.this.fCB == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.fCB.bFQ(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.fCG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kv(boolean z) {
        if (getPageContext() != null) {
            if (this.fCD == null) {
                this.fCD = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.fCD.getView().setVisibility(8);
            }
            this.fCB.bFT().removeHeaderView(this.fCD.getView());
            this.fCB.bFT().addHeaderView(this.fCD.getView(), 1);
            if (this.fCC == null) {
                this.fCC = new a(getPageContext());
                this.fCC.getView().setVisibility(8);
            }
            this.fCB.bFT().removeHeaderView(this.fCC.getView());
            this.fCB.bFT().addHeaderView(this.fCC.getView(), 2);
            kw(z);
            kx(z);
        }
    }

    private void kw(boolean z) {
        HeadLiveInfo headLiveInfo = this.fCE.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.fCD.getView().setVisibility(0);
                c cVar = new c();
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                cVar.ajx = bwVar;
                cVar.fCX = headLiveInfo.is_set.intValue();
                this.fCD.a(cVar);
                this.fCD.bFJ();
            } else if (this.fCD != null && this.fCD.getView() != null) {
                this.fCB.bFT().removeHeaderView(this.fCD.getView());
                this.fCD.getView().setVisibility(8);
            }
        } else if (this.fCD != null && this.fCD.getView() != null) {
            this.fCB.bFT().removeHeaderView(this.fCD.getView());
            this.fCD.getView().setVisibility(8);
        }
    }

    private void kx(boolean z) {
        if (bx(this.fCE.getFunctionList())) {
            this.fCC.getView().setVisibility(0);
            this.fCC.by(this.fCE.getFunctionList());
        } else if (this.fCC != null && this.fCC.getView() != null) {
            this.fCB.bFT().removeHeaderView(this.fCC.getView());
            this.fCC.getView().setVisibility(8);
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
        this.fCB = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.fCB.setListPullRefreshListener(this.esW);
        this.fCB.setOnSrollToBottomListener(this.Vh);
        this.fCB.a(this.fCJ, 2000);
        this.fCB.setOnScrollListener(this.fCK);
        TiebaStatic.log("c12654");
        return this.fCB.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.fCG && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.fCI = (IAlaSquareTabController) runTask.getData();
            this.fCB.a(this.fCI);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fCB != null) {
            this.fCB.onChangeSkinType(i);
        }
        if (this.fCC != null) {
            this.fCC.onChangeSkinType(i);
        }
        if (this.fCD != null) {
            this.fCD.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fCE != null && y.isEmpty(this.fCE.bFE()) && !this.fCE.isRefreshing()) {
                bFp();
            }
            if (this.fCH != null) {
                this.fCH.onPageForeground(0);
            }
            if (this.fCD != null) {
                this.fCD.ky(false);
                this.fCD.bFJ();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bGx().kK(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCE = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.fCL);
        this.fCH = new AlaSquareRefreshManager();
        this.fCH.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.fCB == null || this.fCB.bFT() == null) ? super.onGetPreLoadListView() : this.fCB.bFT().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fCH != null) {
            this.fCH.reset(i);
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
    protected void bFp() {
        hideNetRefreshView(this.fCB.bFQ());
        if (y.getCount(this.fCE.bFE()) == 0 && this.fCB != null) {
            showLoadingView(this.fCB.bFQ());
        }
        this.fCE.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.fCE != null) {
            return this.fCE.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.fCE != null && !y.isEmpty(this.fCE.bFE())) {
            this.fCE.bz(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fCH != null) {
            this.fCH.onPause();
        }
        if (this.fCD != null) {
            this.fCD.ky(true);
            this.fCD.stopPlay();
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
        if (this.fCH != null) {
            this.fCH.onDestory();
        }
        if (this.fCC != null) {
            this.fCC.onDestroy();
        }
        if (this.fCD != null) {
            this.fCD.onDestroy();
        }
        if (this.fCE != null) {
            this.fCE.onDestroy();
        }
        this.fCI = null;
        System.gc();
    }
}
