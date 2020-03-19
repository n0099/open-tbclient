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
    private a ekr;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a eks;
    private boolean ekv;
    private AlaSquareRefreshManager ekw;
    private IAlaSquareTabController ekx;
    private com.baidu.tieba.ala.alasquare.live.d.a ekq = null;
    private AlaSquareLiveModel ekt = null;
    private int eku = -1;
    private int mPaddingTop = 0;
    private g.c dhi = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.ekt != null) {
                AlaSquareLiveFragment.this.ekt.refresh();
            }
        }
    };
    private BdListView.e Az = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.ekt != null) {
                AlaSquareLiveFragment.this.ekt.bck();
            }
        }
    };
    private BdListView.d eky = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener ekz = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bdd().bbW();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.eku != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.eks != null) {
                        AlaSquareLiveFragment.this.eks.bcq();
                        if (AlaSquareLiveFragment.this.eks.bcr() != null) {
                            c bcr = AlaSquareLiveFragment.this.eks.bcr();
                            an anVar = new an("c12644");
                            if (bcr.ekM == 0) {
                                anVar.X("obj_type", 1);
                            } else if (bcr.ekM == 1) {
                                anVar.X("obj_type", 2);
                            }
                            anVar.cx("tid", bcr.NR.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bdd().xK("c12647");
                    if (AlaSquareLiveFragment.this.eks != null) {
                        AlaSquareLiveFragment.this.eks.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.eks != null) {
                    AlaSquareLiveFragment.this.eks.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.eku = i;
        }
    };
    private AlaSquareLiveModel.a ekA = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.ekq != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.ekt.bcl();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.ekq.c(list, z, AlaSquareLiveFragment.this.ekt.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ekq.bcx());
                        AlaSquareLiveFragment.this.ekq.completePullRefresh();
                        AlaSquareLiveFragment.this.hP(z2);
                        AlaSquareLiveFragment.this.ekq.c(list, z, AlaSquareLiveFragment.this.ekt.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ekq.bcx(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.ekq.bcx());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void ag(int i, String str) {
            if (AlaSquareLiveFragment.this.ekq != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ekq.bcx());
                AlaSquareLiveFragment.this.ekq.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.ekt.bcl()) <= 0 || AlaSquareLiveFragment.this.ekq == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ekq.bcx(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.ekv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hP(boolean z) {
        if (getPageContext() != null) {
            if (this.eks == null) {
                this.eks = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.eks.getView().setVisibility(8);
            }
            this.ekq.bcA().removeHeaderView(this.eks.getView());
            this.ekq.bcA().addHeaderView(this.eks.getView(), 1);
            if (this.ekr == null) {
                this.ekr = new a(getPageContext());
                this.ekr.getView().setVisibility(8);
            }
            this.ekq.bcA().removeHeaderView(this.ekr.getView());
            this.ekq.bcA().addHeaderView(this.ekr.getView(), 2);
            hQ(z);
            hR(z);
        }
    }

    private void hQ(boolean z) {
        HeadLiveInfo headLiveInfo = this.ekt.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.eks.getView().setVisibility(0);
                c cVar = new c();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                cVar.NR = bjVar;
                cVar.ekM = headLiveInfo.is_set.intValue();
                this.eks.a(cVar);
                this.eks.bcq();
            } else if (this.eks != null && this.eks.getView() != null) {
                this.ekq.bcA().removeHeaderView(this.eks.getView());
                this.eks.getView().setVisibility(8);
            }
        } else if (this.eks != null && this.eks.getView() != null) {
            this.ekq.bcA().removeHeaderView(this.eks.getView());
            this.eks.getView().setVisibility(8);
        }
    }

    private void hR(boolean z) {
        if (be(this.ekt.getFunctionList())) {
            this.ekr.getView().setVisibility(0);
            this.ekr.bf(this.ekt.getFunctionList());
        } else if (this.ekr != null && this.ekr.getView() != null) {
            this.ekq.bcA().removeHeaderView(this.ekr.getView());
            this.ekr.getView().setVisibility(8);
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
        this.ekq = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.ekq.setListPullRefreshListener(this.dhi);
        this.ekq.setOnSrollToBottomListener(this.Az);
        this.ekq.a(this.eky, 2000);
        this.ekq.setOnScrollListener(this.ekz);
        TiebaStatic.log("c12654");
        return this.ekq.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.ekv && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.ekx = (IAlaSquareTabController) runTask.getData();
            this.ekq.a(this.ekx);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ekq != null) {
            this.ekq.onChangeSkinType(i);
        }
        if (this.ekr != null) {
            this.ekr.onChangeSkinType(i);
        }
        if (this.eks != null) {
            this.eks.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ekt != null && v.isEmpty(this.ekt.bcl()) && !this.ekt.isRefreshing()) {
                bbY();
            }
            if (this.ekw != null) {
                this.ekw.onPageForeground(0);
            }
            if (this.eks != null) {
                this.eks.hS(false);
                this.eks.bcq();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bdd().id(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ekt = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.ekA);
        this.ekw = new AlaSquareRefreshManager();
        this.ekw.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.ekq == null || this.ekq.bcA() == null) ? super.onGetPreLoadListView() : this.ekq.bcA().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ekw != null) {
            this.ekw.reset(i);
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
    protected void bbY() {
        hideNetRefreshView(this.ekq.bcx());
        if (v.getCount(this.ekt.bcl()) == 0 && this.ekq != null) {
            showLoadingView(this.ekq.bcx());
        }
        this.ekt.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.ekt != null) {
            return this.ekt.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.ekt != null && !v.isEmpty(this.ekt.bcl())) {
            this.ekt.bg(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ekw != null) {
            this.ekw.onPause();
        }
        if (this.eks != null) {
            this.eks.hS(true);
            this.eks.stopPlay();
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
        if (this.ekw != null) {
            this.ekw.onDestory();
        }
        if (this.ekr != null) {
            this.ekr.onDestroy();
        }
        if (this.eks != null) {
            this.eks.onDestroy();
        }
        if (this.ekt != null) {
            this.ekt.onDestroy();
        }
        this.ekx = null;
        System.gc();
    }
}
