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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes3.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a flY;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a flZ;
    private boolean fmc;
    private AlaSquareRefreshManager fmd;
    private IAlaSquareTabController fme;
    private com.baidu.tieba.ala.alasquare.live.d.a flX = null;
    private AlaSquareLiveModel fma = null;
    private int fmb = -1;
    private int mPaddingTop = 0;
    private f.c ecS = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.fma != null) {
                AlaSquareLiveFragment.this.fma.refresh();
            }
        }
    };
    private BdListView.e UJ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.fma != null) {
                AlaSquareLiveFragment.this.fma.btv();
            }
        }
    };
    private BdListView.d fmf = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener fmg = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bup().brU();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.fmb != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.flZ != null) {
                        AlaSquareLiveFragment.this.flZ.btB();
                        if (AlaSquareLiveFragment.this.flZ.btC() != null) {
                            c btC = AlaSquareLiveFragment.this.flZ.btC();
                            ao aoVar = new ao("c12644");
                            if (btC.fmt == 0) {
                                aoVar.ag("obj_type", 1);
                            } else if (btC.fmt == 1) {
                                aoVar.ag("obj_type", 2);
                            }
                            aoVar.dk("tid", btC.aiq.getTid());
                            TiebaStatic.log(aoVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bup().Bw("c12647");
                    if (AlaSquareLiveFragment.this.flZ != null) {
                        AlaSquareLiveFragment.this.flZ.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.flZ != null) {
                    AlaSquareLiveFragment.this.flZ.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.fmb = i;
        }
    };
    private AlaSquareLiveModel.a fmh = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.flX != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.fma.btw();
                }
                if (!z2 || w.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.flX.c(list, z, AlaSquareLiveFragment.this.fma.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.flX.btI());
                        AlaSquareLiveFragment.this.flX.completePullRefresh();
                        AlaSquareLiveFragment.this.jt(z2);
                        AlaSquareLiveFragment.this.flX.c(list, z, AlaSquareLiveFragment.this.fma.getIsSmallFollow());
                    }
                    if (w.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.flX.btI(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.flX.btI());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void an(int i, String str) {
            if (AlaSquareLiveFragment.this.flX != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.flX.btI());
                AlaSquareLiveFragment.this.flX.completePullRefresh();
            }
            if (w.getCount(AlaSquareLiveFragment.this.fma.btw()) <= 0 || AlaSquareLiveFragment.this.flX == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.flX.btI(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.fmc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jt(boolean z) {
        if (getPageContext() != null) {
            if (this.flZ == null) {
                this.flZ = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.flZ.getView().setVisibility(8);
            }
            this.flX.btL().removeHeaderView(this.flZ.getView());
            this.flX.btL().addHeaderView(this.flZ.getView(), 1);
            if (this.flY == null) {
                this.flY = new a(getPageContext());
                this.flY.getView().setVisibility(8);
            }
            this.flX.btL().removeHeaderView(this.flY.getView());
            this.flX.btL().addHeaderView(this.flY.getView(), 2);
            ju(z);
            jv(z);
        }
    }

    private void ju(boolean z) {
        HeadLiveInfo headLiveInfo = this.fma.getHeadLiveInfo();
        if (headLiveInfo != null && !w.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.flZ.getView().setVisibility(0);
                c cVar = new c();
                bu buVar = new bu();
                buVar.a(threadInfo);
                cVar.aiq = buVar;
                cVar.fmt = headLiveInfo.is_set.intValue();
                this.flZ.a(cVar);
                this.flZ.btB();
            } else if (this.flZ != null && this.flZ.getView() != null) {
                this.flX.btL().removeHeaderView(this.flZ.getView());
                this.flZ.getView().setVisibility(8);
            }
        } else if (this.flZ != null && this.flZ.getView() != null) {
            this.flX.btL().removeHeaderView(this.flZ.getView());
            this.flZ.getView().setVisibility(8);
        }
    }

    private void jv(boolean z) {
        if (bt(this.fma.getFunctionList())) {
            this.flY.getView().setVisibility(0);
            this.flY.aP(this.fma.getFunctionList());
        } else if (this.flY != null && this.flY.getView() != null) {
            this.flX.btL().removeHeaderView(this.flY.getView());
            this.flY.getView().setVisibility(8);
        }
    }

    private boolean bt(List<FunctionListInfo> list) {
        int i;
        if (!w.isEmpty(list) && w.getCount(list) >= 2 && w.getCount(list) <= 3) {
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
        this.flX = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.flX.setListPullRefreshListener(this.ecS);
        this.flX.setOnSrollToBottomListener(this.UJ);
        this.flX.a(this.fmf, 2000);
        this.flX.setOnScrollListener(this.fmg);
        TiebaStatic.log("c12654");
        return this.flX.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.fmc && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.fme = (IAlaSquareTabController) runTask.getData();
            this.flX.a(this.fme);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.flX != null) {
            this.flX.onChangeSkinType(i);
        }
        if (this.flY != null) {
            this.flY.onChangeSkinType(i);
        }
        if (this.flZ != null) {
            this.flZ.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fma != null && w.isEmpty(this.fma.btw()) && !this.fma.isRefreshing()) {
                bth();
            }
            if (this.fmd != null) {
                this.fmd.onPageForeground(0);
            }
            if (this.flZ != null) {
                this.flZ.jw(false);
                this.flZ.btB();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bup().jI(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fma = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.fmh);
        this.fmd = new AlaSquareRefreshManager();
        this.fmd.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.flX == null || this.flX.btL() == null) ? super.onGetPreLoadListView() : this.flX.btL().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.fmd != null) {
            this.fmd.reset(i);
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
    protected void bth() {
        hideNetRefreshView(this.flX.btI());
        if (w.getCount(this.fma.btw()) == 0 && this.flX != null) {
            showLoadingView(this.flX.btI());
        }
        this.fma.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.fma != null) {
            return this.fma.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!w.isEmpty(list) && this.fma != null && !w.isEmpty(this.fma.btw())) {
            this.fma.bu(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fmd != null) {
            this.fmd.onPause();
        }
        if (this.flZ != null) {
            this.flZ.jw(true);
            this.flZ.stopPlay();
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
        if (this.fmd != null) {
            this.fmd.onDestory();
        }
        if (this.flY != null) {
            this.flY.onDestroy();
        }
        if (this.flZ != null) {
            this.flZ.onDestroy();
        }
        if (this.fma != null) {
            this.fma.onDestroy();
        }
        this.fme = null;
        System.gc();
    }
}
