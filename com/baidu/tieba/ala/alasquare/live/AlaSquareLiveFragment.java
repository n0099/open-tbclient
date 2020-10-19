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
    private a fSb;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a fSc;
    private boolean fSf;
    private AlaSquareRefreshManager fSg;
    private IAlaSquareTabController fSh;
    private com.baidu.tieba.ala.alasquare.live.d.a fSa = null;
    private AlaSquareLiveModel fSd = null;
    private int fSe = -1;
    private int mPaddingTop = 0;
    private f.c eHp = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.fSd != null) {
                AlaSquareLiveFragment.this.fSd.refresh();
            }
        }
    };
    private BdListView.e VQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.fSd != null) {
                AlaSquareLiveFragment.this.fSd.bJG();
            }
        }
    };
    private BdListView.d fSi = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener fSj = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bKA().bHY();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.fSe != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.fSc != null) {
                        AlaSquareLiveFragment.this.fSc.bJM();
                        if (AlaSquareLiveFragment.this.fSc.bJN() != null) {
                            c bJN = AlaSquareLiveFragment.this.fSc.bJN();
                            aq aqVar = new aq("c12644");
                            if (bJN.fSw == 0) {
                                aqVar.aj("obj_type", 1);
                            } else if (bJN.fSw == 1) {
                                aqVar.aj("obj_type", 2);
                            }
                            aqVar.dK("tid", bJN.akp.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bKA().FL("c12647");
                    if (AlaSquareLiveFragment.this.fSc != null) {
                        AlaSquareLiveFragment.this.fSc.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.fSc != null) {
                    AlaSquareLiveFragment.this.fSc.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.fSe = i;
        }
    };
    private AlaSquareLiveModel.a fSk = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void i(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.fSa != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.fSd.bJH();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.fSa.c(list, z, AlaSquareLiveFragment.this.fSd.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.fSa.bJT());
                        AlaSquareLiveFragment.this.fSa.completePullRefresh();
                        AlaSquareLiveFragment.this.kX(z2);
                        AlaSquareLiveFragment.this.fSa.c(list, z, AlaSquareLiveFragment.this.fSd.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.fSa.bJT(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.fSa.bJT());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void ay(int i, String str) {
            if (AlaSquareLiveFragment.this.fSa != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.fSa.bJT());
                AlaSquareLiveFragment.this.fSa.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.fSd.bJH()) <= 0 || AlaSquareLiveFragment.this.fSa == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.fSa.bJT(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.fSf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kX(boolean z) {
        if (getPageContext() != null) {
            if (this.fSc == null) {
                this.fSc = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.fSc.getView().setVisibility(8);
            }
            this.fSa.bJW().removeHeaderView(this.fSc.getView());
            this.fSa.bJW().addHeaderView(this.fSc.getView(), 1);
            if (this.fSb == null) {
                this.fSb = new a(getPageContext());
                this.fSb.getView().setVisibility(8);
            }
            this.fSa.bJW().removeHeaderView(this.fSb.getView());
            this.fSa.bJW().addHeaderView(this.fSb.getView(), 2);
            kY(z);
            kZ(z);
        }
    }

    private void kY(boolean z) {
        HeadLiveInfo headLiveInfo = this.fSd.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.fSc.getView().setVisibility(0);
                c cVar = new c();
                bw bwVar = new bw();
                bwVar.a(threadInfo);
                cVar.akp = bwVar;
                cVar.fSw = headLiveInfo.is_set.intValue();
                this.fSc.a(cVar);
                this.fSc.bJM();
            } else if (this.fSc != null && this.fSc.getView() != null) {
                this.fSa.bJW().removeHeaderView(this.fSc.getView());
                this.fSc.getView().setVisibility(8);
            }
        } else if (this.fSc != null && this.fSc.getView() != null) {
            this.fSa.bJW().removeHeaderView(this.fSc.getView());
            this.fSc.getView().setVisibility(8);
        }
    }

    private void kZ(boolean z) {
        if (bF(this.fSd.getFunctionList())) {
            this.fSb.getView().setVisibility(0);
            this.fSb.bG(this.fSd.getFunctionList());
        } else if (this.fSb != null && this.fSb.getView() != null) {
            this.fSa.bJW().removeHeaderView(this.fSb.getView());
            this.fSb.getView().setVisibility(8);
        }
    }

    private boolean bF(List<FunctionListInfo> list) {
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
        this.fSa = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.fSa.setListPullRefreshListener(this.eHp);
        this.fSa.setOnSrollToBottomListener(this.VQ);
        this.fSa.a(this.fSi, 2000);
        this.fSa.setOnScrollListener(this.fSj);
        TiebaStatic.log("c12654");
        return this.fSa.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.fSf && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.fSh = (IAlaSquareTabController) runTask.getData();
            this.fSa.a(this.fSh);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fSa != null) {
            this.fSa.onChangeSkinType(i);
        }
        if (this.fSb != null) {
            this.fSb.onChangeSkinType(i);
        }
        if (this.fSc != null) {
            this.fSc.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fSd != null && y.isEmpty(this.fSd.bJH()) && !this.fSd.isRefreshing()) {
                bJs();
            }
            if (this.fSg != null) {
                this.fSg.onPageForeground(0);
            }
            if (this.fSc != null) {
                this.fSc.la(false);
                this.fSc.bJM();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bKA().lm(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fSd = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.fSk);
        this.fSg = new AlaSquareRefreshManager();
        this.fSg.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.fSa == null || this.fSa.bJW() == null) ? super.onGetPreLoadListView() : this.fSa.bJW().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fSg != null) {
            this.fSg.reset(i);
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
    protected void bJs() {
        hideNetRefreshView(this.fSa.bJT());
        if (y.getCount(this.fSd.bJH()) == 0 && this.fSa != null) {
            showLoadingView(this.fSa.bJT());
        }
        this.fSd.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.fSd != null) {
            return this.fSd.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.fSd != null && !y.isEmpty(this.fSd.bJH())) {
            this.fSd.bH(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fSg != null) {
            this.fSg.onPause();
        }
        if (this.fSc != null) {
            this.fSc.la(true);
            this.fSc.stopPlay();
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
        if (this.fSg != null) {
            this.fSg.onDestory();
        }
        if (this.fSb != null) {
            this.fSb.onDestroy();
        }
        if (this.fSc != null) {
            this.fSc.onDestroy();
        }
        if (this.fSd != null) {
            this.fSd.onDestroy();
        }
        this.fSh = null;
        System.gc();
    }
}
