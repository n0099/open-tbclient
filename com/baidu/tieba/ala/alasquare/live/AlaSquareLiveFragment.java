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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes10.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a gyO;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a gyP;
    private boolean gyS;
    private AlaSquareRefreshManager gyT;
    private IAlaSquareTabController gyU;
    private com.baidu.tieba.ala.alasquare.live.d.a gyN = null;
    private AlaSquareLiveModel gyQ = null;
    private int gyR = -1;
    private int mPaddingTop = 0;
    private f.c fjz = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.gyQ != null) {
                AlaSquareLiveFragment.this.gyQ.refresh();
            }
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.gyQ != null) {
                AlaSquareLiveFragment.this.gyQ.bRc();
            }
        }
    };
    private BdListView.d gyV = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener gyW = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.b.a.bRX().bOF();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.gyR != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.gyP != null) {
                        AlaSquareLiveFragment.this.gyP.bRi();
                        if (AlaSquareLiveFragment.this.gyP.bRj() != null) {
                            c bRj = AlaSquareLiveFragment.this.gyP.bRj();
                            ar arVar = new ar("c12644");
                            if (bRj.gzj == 0) {
                                arVar.ap("obj_type", 1);
                            } else if (bRj.gzj == 1) {
                                arVar.ap("obj_type", 2);
                            }
                            arVar.dR("tid", bRj.akU.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.b.a.bRX().FX("c12647");
                    if (AlaSquareLiveFragment.this.gyP != null) {
                        AlaSquareLiveFragment.this.gyP.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.gyP != null) {
                    AlaSquareLiveFragment.this.gyP.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.gyR = i;
        }
    };
    private AlaSquareLiveModel.a gyX = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void j(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.gyN != null) {
                List<n> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.gyQ.bRd();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.gyN.c(list, z, AlaSquareLiveFragment.this.gyQ.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gyN.bRp());
                        AlaSquareLiveFragment.this.gyN.completePullRefresh();
                        AlaSquareLiveFragment.this.mr(z2);
                        AlaSquareLiveFragment.this.gyN.c(list, z, AlaSquareLiveFragment.this.gyQ.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gyN.bRp(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.gyN.bRp());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aJ(int i, String str) {
            if (AlaSquareLiveFragment.this.gyN != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gyN.bRp());
                AlaSquareLiveFragment.this.gyN.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.gyQ.bRd()) <= 0 || AlaSquareLiveFragment.this.gyN == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gyN.bRp(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.gyS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(boolean z) {
        if (getPageContext() != null) {
            if (this.gyP == null) {
                this.gyP = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.gyP.getView().setVisibility(8);
            }
            this.gyN.bRs().removeHeaderView(this.gyP.getView());
            this.gyN.bRs().addHeaderView(this.gyP.getView(), 1);
            if (this.gyO == null) {
                this.gyO = new a(getPageContext());
                this.gyO.getView().setVisibility(8);
            }
            this.gyN.bRs().removeHeaderView(this.gyO.getView());
            this.gyN.bRs().addHeaderView(this.gyO.getView(), 2);
            ms(z);
            mt(z);
        }
    }

    private void ms(boolean z) {
        HeadLiveInfo headLiveInfo = this.gyQ.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.gyP.getView().setVisibility(0);
                c cVar = new c();
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cVar.akU = cbVar;
                cVar.gzj = headLiveInfo.is_set.intValue();
                this.gyP.a(cVar);
                this.gyP.bRi();
            } else if (this.gyP != null && this.gyP.getView() != null) {
                this.gyN.bRs().removeHeaderView(this.gyP.getView());
                this.gyP.getView().setVisibility(8);
            }
        } else if (this.gyP != null && this.gyP.getView() != null) {
            this.gyN.bRs().removeHeaderView(this.gyP.getView());
            this.gyP.getView().setVisibility(8);
        }
    }

    private void mt(boolean z) {
        if (cc(this.gyQ.getFunctionList())) {
            this.gyO.getView().setVisibility(0);
            this.gyO.cd(this.gyQ.getFunctionList());
        } else if (this.gyO != null && this.gyO.getView() != null) {
            this.gyN.bRs().removeHeaderView(this.gyO.getView());
            this.gyO.getView().setVisibility(8);
        }
    }

    private boolean cc(List<FunctionListInfo> list) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mPaddingTop == 0) {
            this.mPaddingTop = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
        }
        this.gyN = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.gyN.setListPullRefreshListener(this.fjz);
        this.gyN.setOnSrollToBottomListener(this.WH);
        this.gyN.a(this.gyV, 2000);
        this.gyN.setOnScrollListener(this.gyW);
        TiebaStatic.log("c12654");
        return this.gyN.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.gyS && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.gyU = (IAlaSquareTabController) runTask.getData();
            this.gyN.a(this.gyU);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gyN != null) {
            this.gyN.onChangeSkinType(i);
        }
        if (this.gyO != null) {
            this.gyO.onChangeSkinType(i);
        }
        if (this.gyP != null) {
            this.gyP.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gyQ != null && y.isEmpty(this.gyQ.bRd()) && !this.gyQ.isRefreshing()) {
                bQK();
            }
            if (this.gyT != null) {
                this.gyT.onPageForeground(0);
            }
            if (this.gyP != null) {
                this.gyP.mu(false);
                this.gyP.bRi();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.b.a.bRX().mG(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gyQ = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.gyX);
        this.gyT = new AlaSquareRefreshManager();
        this.gyT.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        return (this.gyN == null || this.gyN.bRs() == null) ? super.onGetPreLoadListView() : this.gyN.bRs().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gyT != null) {
            this.gyT.reset(i);
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
    protected void bQK() {
        hideNetRefreshView(this.gyN.bRp());
        if (y.getCount(this.gyQ.bRd()) == 0 && this.gyN != null) {
            showLoadingView(this.gyN.bRp());
        }
        this.gyQ.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.gyQ != null) {
            return this.gyQ.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.gyQ != null && !y.isEmpty(this.gyQ.bRd())) {
            this.gyQ.ce(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gyT != null) {
            this.gyT.onPause();
        }
        if (this.gyP != null) {
            this.gyP.mu(true);
            this.gyP.stopPlay();
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
        if (this.gyT != null) {
            this.gyT.onDestory();
        }
        if (this.gyO != null) {
            this.gyO.onDestroy();
        }
        if (this.gyP != null) {
            this.gyP.onDestroy();
        }
        if (this.gyQ != null) {
            this.gyQ.onDestroy();
        }
        this.gyU = null;
        System.gc();
    }
}
