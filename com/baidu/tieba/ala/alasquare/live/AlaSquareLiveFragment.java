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
/* loaded from: classes2.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a efJ;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a efK;
    private boolean efN;
    private AlaSquareRefreshManager efO;
    private IAlaSquareTabController efP;
    private com.baidu.tieba.ala.alasquare.live.d.a efI = null;
    private AlaSquareLiveModel efL = null;
    private int efM = -1;
    private int mPaddingTop = 0;
    private g.c dcC = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.efL != null) {
                AlaSquareLiveFragment.this.efL.refresh();
            }
        }
    };
    private BdListView.e Ah = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.efL != null) {
                AlaSquareLiveFragment.this.efL.aZN();
            }
        }
    };
    private BdListView.d efQ = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener efR = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.baG().aZA();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.efM != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.efK != null) {
                        AlaSquareLiveFragment.this.efK.aZT();
                        if (AlaSquareLiveFragment.this.efK.aZU() != null) {
                            c aZU = AlaSquareLiveFragment.this.efK.aZU();
                            an anVar = new an("c12644");
                            if (aZU.ege == 0) {
                                anVar.Z("obj_type", 1);
                            } else if (aZU.ege == 1) {
                                anVar.Z("obj_type", 2);
                            }
                            anVar.cp("tid", aZU.Np.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.baG().xo("c12647");
                    if (AlaSquareLiveFragment.this.efK != null) {
                        AlaSquareLiveFragment.this.efK.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.efK != null) {
                    AlaSquareLiveFragment.this.efK.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.efM = i;
        }
    };
    private AlaSquareLiveModel.a efS = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.efI != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.efL.aZO();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.efI.c(list, z, AlaSquareLiveFragment.this.efL.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.efI.baa());
                        AlaSquareLiveFragment.this.efI.completePullRefresh();
                        AlaSquareLiveFragment.this.hH(z2);
                        AlaSquareLiveFragment.this.efI.c(list, z, AlaSquareLiveFragment.this.efL.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.efI.baa(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.efI.baa());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void af(int i, String str) {
            if (AlaSquareLiveFragment.this.efI != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.efI.baa());
                AlaSquareLiveFragment.this.efI.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.efL.aZO()) <= 0 || AlaSquareLiveFragment.this.efI == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.efI.baa(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.efN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(boolean z) {
        if (getPageContext() != null) {
            if (this.efK == null) {
                this.efK = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.efK.getView().setVisibility(8);
            }
            this.efI.bad().removeHeaderView(this.efK.getView());
            this.efI.bad().addHeaderView(this.efK.getView(), 1);
            if (this.efJ == null) {
                this.efJ = new a(getPageContext());
                this.efJ.getView().setVisibility(8);
            }
            this.efI.bad().removeHeaderView(this.efJ.getView());
            this.efI.bad().addHeaderView(this.efJ.getView(), 2);
            hI(z);
            hJ(z);
        }
    }

    private void hI(boolean z) {
        HeadLiveInfo headLiveInfo = this.efL.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.efK.getView().setVisibility(0);
                c cVar = new c();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                cVar.Np = bjVar;
                cVar.ege = headLiveInfo.is_set.intValue();
                this.efK.a(cVar);
                this.efK.aZT();
            } else if (this.efK != null && this.efK.getView() != null) {
                this.efI.bad().removeHeaderView(this.efK.getView());
                this.efK.getView().setVisibility(8);
            }
        } else if (this.efK != null && this.efK.getView() != null) {
            this.efI.bad().removeHeaderView(this.efK.getView());
            this.efK.getView().setVisibility(8);
        }
    }

    private void hJ(boolean z) {
        if (be(this.efL.getFunctionList())) {
            this.efJ.getView().setVisibility(0);
            this.efJ.bf(this.efL.getFunctionList());
        } else if (this.efJ != null && this.efJ.getView() != null) {
            this.efI.bad().removeHeaderView(this.efJ.getView());
            this.efJ.getView().setVisibility(8);
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
        this.efI = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.efI.setListPullRefreshListener(this.dcC);
        this.efI.setOnSrollToBottomListener(this.Ah);
        this.efI.a(this.efQ, 2000);
        this.efI.setOnScrollListener(this.efR);
        TiebaStatic.log("c12654");
        return this.efI.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.efN && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.efP = (IAlaSquareTabController) runTask.getData();
            this.efI.a(this.efP);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.efI != null) {
            this.efI.onChangeSkinType(i);
        }
        if (this.efJ != null) {
            this.efJ.onChangeSkinType(i);
        }
        if (this.efK != null) {
            this.efK.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.efL != null && v.isEmpty(this.efL.aZO()) && !this.efL.isRefreshing()) {
                aZC();
            }
            if (this.efO != null) {
                this.efO.onPageForeground(0);
            }
            if (this.efK != null) {
                this.efK.hK(false);
                this.efK.aZT();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.baG().hU(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.efL = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.efS);
        this.efO = new AlaSquareRefreshManager();
        this.efO.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.efI == null || this.efI.bad() == null) ? super.onGetPreLoadListView() : this.efI.bad().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.efO != null) {
            this.efO.reset(i);
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
    protected void aZC() {
        hideNetRefreshView(this.efI.baa());
        if (v.getCount(this.efL.aZO()) == 0 && this.efI != null) {
            showLoadingView(this.efI.baa());
        }
        this.efL.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.efL != null) {
            return this.efL.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.efL != null && !v.isEmpty(this.efL.aZO())) {
            this.efL.bg(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.efO != null) {
            this.efO.onPause();
        }
        if (this.efK != null) {
            this.efK.hK(true);
            this.efK.stopPlay();
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
        if (this.efO != null) {
            this.efO.onDestory();
        }
        if (this.efJ != null) {
            this.efJ.onDestroy();
        }
        if (this.efK != null) {
            this.efK.onDestroy();
        }
        if (this.efL != null) {
            this.efL.onDestroy();
        }
        this.efP = null;
        System.gc();
    }
}
