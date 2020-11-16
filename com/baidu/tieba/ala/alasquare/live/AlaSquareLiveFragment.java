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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes4.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a ghA;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a ghB;
    private boolean ghE;
    private AlaSquareRefreshManager ghF;
    private IAlaSquareTabController ghG;
    private com.baidu.tieba.ala.alasquare.live.d.a ghz = null;
    private AlaSquareLiveModel ghC = null;
    private int ghD = -1;
    private int mPaddingTop = 0;
    private f.c eUM = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.ghC != null) {
                AlaSquareLiveFragment.this.ghC.refresh();
            }
        }
    };
    private BdListView.e VT = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.ghC != null) {
                AlaSquareLiveFragment.this.ghC.bOb();
            }
        }
    };
    private BdListView.d ghH = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener ghI = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bOV().bLI();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.ghD != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.ghB != null) {
                        AlaSquareLiveFragment.this.ghB.bOh();
                        if (AlaSquareLiveFragment.this.ghB.bOi() != null) {
                            c bOi = AlaSquareLiveFragment.this.ghB.bOi();
                            ar arVar = new ar("c12644");
                            if (bOi.ghV == 0) {
                                arVar.ak("obj_type", 1);
                            } else if (bOi.ghV == 1) {
                                arVar.ak("obj_type", 2);
                            }
                            arVar.dR("tid", bOi.akt.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bOV().FZ("c12647");
                    if (AlaSquareLiveFragment.this.ghB != null) {
                        AlaSquareLiveFragment.this.ghB.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.ghB != null) {
                    AlaSquareLiveFragment.this.ghB.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.ghD = i;
        }
    };
    private AlaSquareLiveModel.a ghJ = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void i(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.ghz != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.ghC.bOc();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.ghz.c(list, z, AlaSquareLiveFragment.this.ghC.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ghz.bOo());
                        AlaSquareLiveFragment.this.ghz.completePullRefresh();
                        AlaSquareLiveFragment.this.lz(z2);
                        AlaSquareLiveFragment.this.ghz.c(list, z, AlaSquareLiveFragment.this.ghC.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ghz.bOo(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.ghz.bOo());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aC(int i, String str) {
            if (AlaSquareLiveFragment.this.ghz != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.ghz.bOo());
                AlaSquareLiveFragment.this.ghz.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.ghC.bOc()) <= 0 || AlaSquareLiveFragment.this.ghz == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.ghz.bOo(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.ghE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz(boolean z) {
        if (getPageContext() != null) {
            if (this.ghB == null) {
                this.ghB = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.ghB.getView().setVisibility(8);
            }
            this.ghz.bOr().removeHeaderView(this.ghB.getView());
            this.ghz.bOr().addHeaderView(this.ghB.getView(), 1);
            if (this.ghA == null) {
                this.ghA = new a(getPageContext());
                this.ghA.getView().setVisibility(8);
            }
            this.ghz.bOr().removeHeaderView(this.ghA.getView());
            this.ghz.bOr().addHeaderView(this.ghA.getView(), 2);
            lA(z);
            lB(z);
        }
    }

    private void lA(boolean z) {
        HeadLiveInfo headLiveInfo = this.ghC.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.ghB.getView().setVisibility(0);
                c cVar = new c();
                bx bxVar = new bx();
                bxVar.a(threadInfo);
                cVar.akt = bxVar;
                cVar.ghV = headLiveInfo.is_set.intValue();
                this.ghB.a(cVar);
                this.ghB.bOh();
            } else if (this.ghB != null && this.ghB.getView() != null) {
                this.ghz.bOr().removeHeaderView(this.ghB.getView());
                this.ghB.getView().setVisibility(8);
            }
        } else if (this.ghB != null && this.ghB.getView() != null) {
            this.ghz.bOr().removeHeaderView(this.ghB.getView());
            this.ghB.getView().setVisibility(8);
        }
    }

    private void lB(boolean z) {
        if (bW(this.ghC.getFunctionList())) {
            this.ghA.getView().setVisibility(0);
            this.ghA.bX(this.ghC.getFunctionList());
        } else if (this.ghA != null && this.ghA.getView() != null) {
            this.ghz.bOr().removeHeaderView(this.ghA.getView());
            this.ghA.getView().setVisibility(8);
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
        this.ghz = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.ghz.setListPullRefreshListener(this.eUM);
        this.ghz.setOnSrollToBottomListener(this.VT);
        this.ghz.a(this.ghH, 2000);
        this.ghz.setOnScrollListener(this.ghI);
        TiebaStatic.log("c12654");
        return this.ghz.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.ghE && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.ghG = (IAlaSquareTabController) runTask.getData();
            this.ghz.a(this.ghG);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ghz != null) {
            this.ghz.onChangeSkinType(i);
        }
        if (this.ghA != null) {
            this.ghA.onChangeSkinType(i);
        }
        if (this.ghB != null) {
            this.ghB.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ghC != null && y.isEmpty(this.ghC.bOc()) && !this.ghC.isRefreshing()) {
                bNN();
            }
            if (this.ghF != null) {
                this.ghF.onPageForeground(0);
            }
            if (this.ghB != null) {
                this.ghB.lC(false);
                this.ghB.bOh();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bOV().lO(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ghC = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.ghJ);
        this.ghF = new AlaSquareRefreshManager();
        this.ghF.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.ghz == null || this.ghz.bOr() == null) ? super.onGetPreLoadListView() : this.ghz.bOr().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.ghF != null) {
            this.ghF.reset(i);
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
    protected void bNN() {
        hideNetRefreshView(this.ghz.bOo());
        if (y.getCount(this.ghC.bOc()) == 0 && this.ghz != null) {
            showLoadingView(this.ghz.bOo());
        }
        this.ghC.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.ghC != null) {
            return this.ghC.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.ghC != null && !y.isEmpty(this.ghC.bOc())) {
            this.ghC.bY(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ghF != null) {
            this.ghF.onPause();
        }
        if (this.ghB != null) {
            this.ghB.lC(true);
            this.ghB.stopPlay();
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
        if (this.ghF != null) {
            this.ghF.onDestory();
        }
        if (this.ghA != null) {
            this.ghA.onDestroy();
        }
        if (this.ghB != null) {
            this.ghB.onDestroy();
        }
        if (this.ghC != null) {
            this.ghC.onDestroy();
        }
        this.ghG = null;
        System.gc();
    }
}
