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
/* loaded from: classes9.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a gAL;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a gAM;
    private boolean gAP;
    private AlaSquareRefreshManager gAQ;
    private IAlaSquareTabController gAR;
    private com.baidu.tieba.ala.alasquare.live.d.a gAK = null;
    private AlaSquareLiveModel gAN = null;
    private int gAO = -1;
    private int mPaddingTop = 0;
    private f.c fkY = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.gAN != null) {
                AlaSquareLiveFragment.this.gAN.refresh();
            }
        }
    };
    private BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.gAN != null) {
                AlaSquareLiveFragment.this.gAN.bRp();
            }
        }
    };
    private BdListView.d gAS = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener gAT = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.b.a.bSk().bOS();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.gAO != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.gAM != null) {
                        AlaSquareLiveFragment.this.gAM.bRv();
                        if (AlaSquareLiveFragment.this.gAM.bRw() != null) {
                            c bRw = AlaSquareLiveFragment.this.gAM.bRw();
                            ar arVar = new ar("c12644");
                            if (bRw.gBg == 0) {
                                arVar.aq("obj_type", 1);
                            } else if (bRw.gBg == 1) {
                                arVar.aq("obj_type", 2);
                            }
                            arVar.dR("tid", bRw.amn.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.b.a.bSk().Gh("c12647");
                    if (AlaSquareLiveFragment.this.gAM != null) {
                        AlaSquareLiveFragment.this.gAM.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.gAM != null) {
                    AlaSquareLiveFragment.this.gAM.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.gAO = i;
        }
    };
    private AlaSquareLiveModel.a gAU = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void j(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.gAK != null) {
                List<n> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.gAN.bRq();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.gAK.c(list, z, AlaSquareLiveFragment.this.gAN.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gAK.bRC());
                        AlaSquareLiveFragment.this.gAK.completePullRefresh();
                        AlaSquareLiveFragment.this.mr(z2);
                        AlaSquareLiveFragment.this.gAK.c(list, z, AlaSquareLiveFragment.this.gAN.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gAK.bRC(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.gAK.bRC());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aJ(int i, String str) {
            if (AlaSquareLiveFragment.this.gAK != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gAK.bRC());
                AlaSquareLiveFragment.this.gAK.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.gAN.bRq()) <= 0 || AlaSquareLiveFragment.this.gAK == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gAK.bRC(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.gAP = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(boolean z) {
        if (getPageContext() != null) {
            if (this.gAM == null) {
                this.gAM = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.gAM.getView().setVisibility(8);
            }
            this.gAK.bRF().removeHeaderView(this.gAM.getView());
            this.gAK.bRF().addHeaderView(this.gAM.getView(), 1);
            if (this.gAL == null) {
                this.gAL = new a(getPageContext());
                this.gAL.getView().setVisibility(8);
            }
            this.gAK.bRF().removeHeaderView(this.gAL.getView());
            this.gAK.bRF().addHeaderView(this.gAL.getView(), 2);
            ms(z);
            mt(z);
        }
    }

    private void ms(boolean z) {
        HeadLiveInfo headLiveInfo = this.gAN.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.gAM.getView().setVisibility(0);
                c cVar = new c();
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cVar.amn = cbVar;
                cVar.gBg = headLiveInfo.is_set.intValue();
                this.gAM.a(cVar);
                this.gAM.bRv();
            } else if (this.gAM != null && this.gAM.getView() != null) {
                this.gAK.bRF().removeHeaderView(this.gAM.getView());
                this.gAM.getView().setVisibility(8);
            }
        } else if (this.gAM != null && this.gAM.getView() != null) {
            this.gAK.bRF().removeHeaderView(this.gAM.getView());
            this.gAM.getView().setVisibility(8);
        }
    }

    private void mt(boolean z) {
        if (cc(this.gAN.getFunctionList())) {
            this.gAL.getView().setVisibility(0);
            this.gAL.cd(this.gAN.getFunctionList());
        } else if (this.gAL != null && this.gAL.getView() != null) {
            this.gAK.bRF().removeHeaderView(this.gAL.getView());
            this.gAL.getView().setVisibility(8);
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
        this.gAK = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.gAK.setListPullRefreshListener(this.fkY);
        this.gAK.setOnSrollToBottomListener(this.Yb);
        this.gAK.a(this.gAS, 2000);
        this.gAK.setOnScrollListener(this.gAT);
        TiebaStatic.log("c12654");
        return this.gAK.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.gAP && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.gAR = (IAlaSquareTabController) runTask.getData();
            this.gAK.a(this.gAR);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gAK != null) {
            this.gAK.onChangeSkinType(i);
        }
        if (this.gAL != null) {
            this.gAL.onChangeSkinType(i);
        }
        if (this.gAM != null) {
            this.gAM.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gAN != null && y.isEmpty(this.gAN.bRq()) && !this.gAN.isRefreshing()) {
                bQX();
            }
            if (this.gAQ != null) {
                this.gAQ.onPageForeground(0);
            }
            if (this.gAM != null) {
                this.gAM.mu(false);
                this.gAM.bRv();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.b.a.bSk().mG(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAN = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.gAU);
        this.gAQ = new AlaSquareRefreshManager();
        this.gAQ.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        return (this.gAK == null || this.gAK.bRF() == null) ? super.onGetPreLoadListView() : this.gAK.bRF().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gAQ != null) {
            this.gAQ.reset(i);
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
    protected void bQX() {
        hideNetRefreshView(this.gAK.bRC());
        if (y.getCount(this.gAN.bRq()) == 0 && this.gAK != null) {
            showLoadingView(this.gAK.bRC());
        }
        this.gAN.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.gAN != null) {
            return this.gAN.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.gAN != null && !y.isEmpty(this.gAN.bRq())) {
            this.gAN.ce(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gAQ != null) {
            this.gAQ.onPause();
        }
        if (this.gAM != null) {
            this.gAM.mu(true);
            this.gAM.stopPlay();
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
        if (this.gAQ != null) {
            this.gAQ.onDestory();
        }
        if (this.gAL != null) {
            this.gAL.onDestroy();
        }
        if (this.gAM != null) {
            this.gAM.onDestroy();
        }
        if (this.gAN != null) {
            this.gAN.onDestroy();
        }
        this.gAR = null;
        System.gc();
    }
}
