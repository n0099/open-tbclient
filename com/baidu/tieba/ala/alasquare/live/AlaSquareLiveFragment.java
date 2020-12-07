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
import com.baidu.tbadk.core.data.by;
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
/* loaded from: classes6.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a gpK;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a gpL;
    private boolean gpO;
    private AlaSquareRefreshManager gpP;
    private IAlaSquareTabController gpQ;
    private com.baidu.tieba.ala.alasquare.live.d.a gpJ = null;
    private AlaSquareLiveModel gpM = null;
    private int gpN = -1;
    private int mPaddingTop = 0;
    private f.c fci = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.gpM != null) {
                AlaSquareLiveFragment.this.gpM.refresh();
            }
        }
    };
    private BdListView.e WQ = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.gpM != null) {
                AlaSquareLiveFragment.this.gpM.bRM();
            }
        }
    };
    private BdListView.d gpR = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener gpS = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bSG().bPr();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.gpN != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.gpL != null) {
                        AlaSquareLiveFragment.this.gpL.bRS();
                        if (AlaSquareLiveFragment.this.gpL.bRT() != null) {
                            c bRT = AlaSquareLiveFragment.this.gpL.bRT();
                            ar arVar = new ar("c12644");
                            if (bRT.gqf == 0) {
                                arVar.al("obj_type", 1);
                            } else if (bRT.gqf == 1) {
                                arVar.al("obj_type", 2);
                            }
                            arVar.dY("tid", bRT.alu.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bSG().GN("c12647");
                    if (AlaSquareLiveFragment.this.gpL != null) {
                        AlaSquareLiveFragment.this.gpL.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.gpL != null) {
                    AlaSquareLiveFragment.this.gpL.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.gpN = i;
        }
    };
    private AlaSquareLiveModel.a gpT = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void i(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.gpJ != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.gpM.bRN();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.gpJ.c(list, z, AlaSquareLiveFragment.this.gpM.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gpJ.bRZ());
                        AlaSquareLiveFragment.this.gpJ.completePullRefresh();
                        AlaSquareLiveFragment.this.lU(z2);
                        AlaSquareLiveFragment.this.gpJ.c(list, z, AlaSquareLiveFragment.this.gpM.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gpJ.bRZ(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.gpJ.bRZ());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aC(int i, String str) {
            if (AlaSquareLiveFragment.this.gpJ != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gpJ.bRZ());
                AlaSquareLiveFragment.this.gpJ.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.gpM.bRN()) <= 0 || AlaSquareLiveFragment.this.gpJ == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gpJ.bRZ(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.gpO = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lU(boolean z) {
        if (getPageContext() != null) {
            if (this.gpL == null) {
                this.gpL = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.gpL.getView().setVisibility(8);
            }
            this.gpJ.bSc().removeHeaderView(this.gpL.getView());
            this.gpJ.bSc().addHeaderView(this.gpL.getView(), 1);
            if (this.gpK == null) {
                this.gpK = new a(getPageContext());
                this.gpK.getView().setVisibility(8);
            }
            this.gpJ.bSc().removeHeaderView(this.gpK.getView());
            this.gpJ.bSc().addHeaderView(this.gpK.getView(), 2);
            lV(z);
            lW(z);
        }
    }

    private void lV(boolean z) {
        HeadLiveInfo headLiveInfo = this.gpM.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.gpL.getView().setVisibility(0);
                c cVar = new c();
                by byVar = new by();
                byVar.a(threadInfo);
                cVar.alu = byVar;
                cVar.gqf = headLiveInfo.is_set.intValue();
                this.gpL.a(cVar);
                this.gpL.bRS();
            } else if (this.gpL != null && this.gpL.getView() != null) {
                this.gpJ.bSc().removeHeaderView(this.gpL.getView());
                this.gpL.getView().setVisibility(8);
            }
        } else if (this.gpL != null && this.gpL.getView() != null) {
            this.gpJ.bSc().removeHeaderView(this.gpL.getView());
            this.gpL.getView().setVisibility(8);
        }
    }

    private void lW(boolean z) {
        if (ca(this.gpM.getFunctionList())) {
            this.gpK.getView().setVisibility(0);
            this.gpK.cb(this.gpM.getFunctionList());
        } else if (this.gpK != null && this.gpK.getView() != null) {
            this.gpJ.bSc().removeHeaderView(this.gpK.getView());
            this.gpK.getView().setVisibility(8);
        }
    }

    private boolean ca(List<FunctionListInfo> list) {
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
        this.gpJ = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.gpJ.setListPullRefreshListener(this.fci);
        this.gpJ.setOnSrollToBottomListener(this.WQ);
        this.gpJ.a(this.gpR, 2000);
        this.gpJ.setOnScrollListener(this.gpS);
        TiebaStatic.log("c12654");
        return this.gpJ.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.gpO && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.gpQ = (IAlaSquareTabController) runTask.getData();
            this.gpJ.a(this.gpQ);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gpJ != null) {
            this.gpJ.onChangeSkinType(i);
        }
        if (this.gpK != null) {
            this.gpK.onChangeSkinType(i);
        }
        if (this.gpL != null) {
            this.gpL.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gpM != null && y.isEmpty(this.gpM.bRN()) && !this.gpM.isRefreshing()) {
                bRy();
            }
            if (this.gpP != null) {
                this.gpP.onPageForeground(0);
            }
            if (this.gpL != null) {
                this.gpL.lX(false);
                this.gpL.bRS();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bSG().mj(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gpM = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.gpT);
        this.gpP = new AlaSquareRefreshManager();
        this.gpP.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.gpJ == null || this.gpJ.bSc() == null) ? super.onGetPreLoadListView() : this.gpJ.bSc().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gpP != null) {
            this.gpP.reset(i);
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
    protected void bRy() {
        hideNetRefreshView(this.gpJ.bRZ());
        if (y.getCount(this.gpM.bRN()) == 0 && this.gpJ != null) {
            showLoadingView(this.gpJ.bRZ());
        }
        this.gpM.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.gpM != null) {
            return this.gpM.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.gpM != null && !y.isEmpty(this.gpM.bRN())) {
            this.gpM.cc(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gpP != null) {
            this.gpP.onPause();
        }
        if (this.gpL != null) {
            this.gpL.lX(true);
            this.gpL.stopPlay();
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
        if (this.gpP != null) {
            this.gpP.onDestory();
        }
        if (this.gpK != null) {
            this.gpK.onDestroy();
        }
        if (this.gpL != null) {
            this.gpL.onDestroy();
        }
        if (this.gpM != null) {
            this.gpM.onDestroy();
        }
        this.gpQ = null;
        System.gc();
    }
}
