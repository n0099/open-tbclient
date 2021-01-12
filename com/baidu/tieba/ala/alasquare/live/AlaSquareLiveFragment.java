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
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes9.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a gwe;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a gwf;
    private boolean gwi;
    private AlaSquareRefreshManager gwj;
    private IAlaSquareTabController gwk;
    private com.baidu.tieba.ala.alasquare.live.d.a gwd = null;
    private AlaSquareLiveModel gwg = null;
    private int gwh = -1;
    private int adE = 0;
    private f.c fhg = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.gwg != null) {
                AlaSquareLiveFragment.this.gwg.refresh();
            }
        }
    };
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.gwg != null) {
                AlaSquareLiveFragment.this.gwg.bQy();
            }
        }
    };
    private BdListView.d gwl = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener gwm = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.b.a.bRu().bOb();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.gwh != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.gwf != null) {
                        AlaSquareLiveFragment.this.gwf.bQE();
                        if (AlaSquareLiveFragment.this.gwf.bQF() != null) {
                            c bQF = AlaSquareLiveFragment.this.gwf.bQF();
                            aq aqVar = new aq("c12644");
                            if (bQF.gwz == 0) {
                                aqVar.an("obj_type", 1);
                            } else if (bQF.gwz == 1) {
                                aqVar.an("obj_type", 2);
                            }
                            aqVar.dW("tid", bQF.ale.getTid());
                            TiebaStatic.log(aqVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.b.a.bRu().Fz("c12647");
                    if (AlaSquareLiveFragment.this.gwf != null) {
                        AlaSquareLiveFragment.this.gwf.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.gwf != null) {
                    AlaSquareLiveFragment.this.gwf.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.gwh = i;
        }
    };
    private AlaSquareLiveModel.a gwn = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void j(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.gwd != null) {
                List<n> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.gwg.bQz();
                }
                if (!z2 || x.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.gwd.c(list, z, AlaSquareLiveFragment.this.gwg.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gwd.bQL());
                        AlaSquareLiveFragment.this.gwd.completePullRefresh();
                        AlaSquareLiveFragment.this.mn(z2);
                        AlaSquareLiveFragment.this.gwd.c(list, z, AlaSquareLiveFragment.this.gwg.getIsSmallFollow());
                    }
                    if (x.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gwd.bQL(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.gwd.bQL());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aF(int i, String str) {
            if (AlaSquareLiveFragment.this.gwd != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gwd.bQL());
                AlaSquareLiveFragment.this.gwd.completePullRefresh();
            }
            if (x.getCount(AlaSquareLiveFragment.this.gwg.bQz()) <= 0 || AlaSquareLiveFragment.this.gwd == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gwd.bQL(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.gwi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mn(boolean z) {
        if (getPageContext() != null) {
            if (this.gwf == null) {
                this.gwf = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.gwf.getView().setVisibility(8);
            }
            this.gwd.bQO().removeHeaderView(this.gwf.getView());
            this.gwd.bQO().addHeaderView(this.gwf.getView(), 1);
            if (this.gwe == null) {
                this.gwe = new a(getPageContext());
                this.gwe.getView().setVisibility(8);
            }
            this.gwd.bQO().removeHeaderView(this.gwe.getView());
            this.gwd.bQO().addHeaderView(this.gwe.getView(), 2);
            mo(z);
            mp(z);
        }
    }

    private void mo(boolean z) {
        HeadLiveInfo headLiveInfo = this.gwg.getHeadLiveInfo();
        if (headLiveInfo != null && !x.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.gwf.getView().setVisibility(0);
                c cVar = new c();
                bz bzVar = new bz();
                bzVar.a(threadInfo);
                cVar.ale = bzVar;
                cVar.gwz = headLiveInfo.is_set.intValue();
                this.gwf.a(cVar);
                this.gwf.bQE();
            } else if (this.gwf != null && this.gwf.getView() != null) {
                this.gwd.bQO().removeHeaderView(this.gwf.getView());
                this.gwf.getView().setVisibility(8);
            }
        } else if (this.gwf != null && this.gwf.getView() != null) {
            this.gwd.bQO().removeHeaderView(this.gwf.getView());
            this.gwf.getView().setVisibility(8);
        }
    }

    private void mp(boolean z) {
        if (ch(this.gwg.getFunctionList())) {
            this.gwe.getView().setVisibility(0);
            this.gwe.ci(this.gwg.getFunctionList());
        } else if (this.gwe != null && this.gwe.getView() != null) {
            this.gwd.bQO().removeHeaderView(this.gwe.getView());
            this.gwe.getView().setVisibility(8);
        }
    }

    private boolean ch(List<FunctionListInfo> list) {
        int i;
        if (!x.isEmpty(list) && x.getCount(list) >= 2 && x.getCount(list) <= 3) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.adE == 0) {
            this.adE = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
        }
        this.gwd = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.adE);
        this.gwd.setListPullRefreshListener(this.fhg);
        this.gwd.setOnSrollToBottomListener(this.WL);
        this.gwd.a(this.gwl, 2000);
        this.gwd.setOnScrollListener(this.gwm);
        TiebaStatic.log("c12654");
        return this.gwd.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.gwi && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.gwk = (IAlaSquareTabController) runTask.getData();
            this.gwd.a(this.gwk);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gwd != null) {
            this.gwd.onChangeSkinType(i);
        }
        if (this.gwe != null) {
            this.gwe.onChangeSkinType(i);
        }
        if (this.gwf != null) {
            this.gwf.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gwg != null && x.isEmpty(this.gwg.bQz()) && !this.gwg.isRefreshing()) {
                bQg();
            }
            if (this.gwj != null) {
                this.gwj.onPageForeground(0);
            }
            if (this.gwf != null) {
                this.gwf.mq(false);
                this.gwf.bQE();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.b.a.bRu().mC(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gwg = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.gwn);
        this.gwj = new AlaSquareRefreshManager();
        this.gwj.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        return (this.gwd == null || this.gwd.bQO() == null) ? super.onGetPreLoadListView() : this.gwd.bQO().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gwj != null) {
            this.gwj.reset(i);
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
    protected void bQg() {
        hideNetRefreshView(this.gwd.bQL());
        if (x.getCount(this.gwg.bQz()) == 0 && this.gwd != null) {
            showLoadingView(this.gwd.bQL());
        }
        this.gwg.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.gwg != null) {
            return this.gwg.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!x.isEmpty(list) && this.gwg != null && !x.isEmpty(this.gwg.bQz())) {
            this.gwg.cj(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gwj != null) {
            this.gwj.onPause();
        }
        if (this.gwf != null) {
            this.gwf.mq(true);
            this.gwf.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        MessageManager.getInstance().sendMessage(new CustomMessage(AlaCmdConfigCustom.CMD_ALA_LIVE_FRAGMENT_NET_BTN_CLICKED));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.gwj != null) {
            this.gwj.onDestory();
        }
        if (this.gwe != null) {
            this.gwe.onDestroy();
        }
        if (this.gwf != null) {
            this.gwf.onDestroy();
        }
        if (this.gwg != null) {
            this.gwg.onDestroy();
        }
        this.gwk = null;
        System.gc();
    }
}
