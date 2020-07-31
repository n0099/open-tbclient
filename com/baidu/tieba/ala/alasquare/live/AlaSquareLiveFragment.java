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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes4.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a frh;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a fri;
    private boolean frl;
    private AlaSquareRefreshManager frm;
    private IAlaSquareTabController frn;
    private com.baidu.tieba.ala.alasquare.live.d.a frg = null;
    private AlaSquareLiveModel frj = null;
    private int frk = -1;
    private int mPaddingTop = 0;
    private f.c ejc = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.frj != null) {
                AlaSquareLiveFragment.this.frj.refresh();
            }
        }
    };
    private BdListView.e UC = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.frj != null) {
                AlaSquareLiveFragment.this.frj.bwE();
            }
        }
    };
    private BdListView.d fro = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener frp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bxy().bva();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.frk != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.fri != null) {
                        AlaSquareLiveFragment.this.fri.bwK();
                        if (AlaSquareLiveFragment.this.fri.bwL() != null) {
                            c bwL = AlaSquareLiveFragment.this.fri.bwL();
                            ap apVar = new ap("c12644");
                            if (bwL.frD == 0) {
                                apVar.ah("obj_type", 1);
                            } else if (bwL.frD == 1) {
                                apVar.ah("obj_type", 2);
                            }
                            apVar.dn("tid", bwL.aii.getTid());
                            TiebaStatic.log(apVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bxy().Ch("c12647");
                    if (AlaSquareLiveFragment.this.fri != null) {
                        AlaSquareLiveFragment.this.fri.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.fri != null) {
                    AlaSquareLiveFragment.this.fri.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.frk = i;
        }
    };
    private AlaSquareLiveModel.a frq = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.frg != null) {
                List<q> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.frj.bwF();
                }
                if (!z2 || x.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.frg.c(list, z, AlaSquareLiveFragment.this.frj.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.frg.bwR());
                        AlaSquareLiveFragment.this.frg.completePullRefresh();
                        AlaSquareLiveFragment.this.jX(z2);
                        AlaSquareLiveFragment.this.frg.c(list, z, AlaSquareLiveFragment.this.frj.getIsSmallFollow());
                    }
                    if (x.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.frg.bwR(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.frg.bwR());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void ao(int i, String str) {
            if (AlaSquareLiveFragment.this.frg != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.frg.bwR());
                AlaSquareLiveFragment.this.frg.completePullRefresh();
            }
            if (x.getCount(AlaSquareLiveFragment.this.frj.bwF()) <= 0 || AlaSquareLiveFragment.this.frg == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.frg.bwR(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.frl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jX(boolean z) {
        if (getPageContext() != null) {
            if (this.fri == null) {
                this.fri = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.fri.getView().setVisibility(8);
            }
            this.frg.bwU().removeHeaderView(this.fri.getView());
            this.frg.bwU().addHeaderView(this.fri.getView(), 1);
            if (this.frh == null) {
                this.frh = new a(getPageContext());
                this.frh.getView().setVisibility(8);
            }
            this.frg.bwU().removeHeaderView(this.frh.getView());
            this.frg.bwU().addHeaderView(this.frh.getView(), 2);
            jY(z);
            jZ(z);
        }
    }

    private void jY(boolean z) {
        HeadLiveInfo headLiveInfo = this.frj.getHeadLiveInfo();
        if (headLiveInfo != null && !x.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.fri.getView().setVisibility(0);
                c cVar = new c();
                bv bvVar = new bv();
                bvVar.a(threadInfo);
                cVar.aii = bvVar;
                cVar.frD = headLiveInfo.is_set.intValue();
                this.fri.a(cVar);
                this.fri.bwK();
            } else if (this.fri != null && this.fri.getView() != null) {
                this.frg.bwU().removeHeaderView(this.fri.getView());
                this.fri.getView().setVisibility(8);
            }
        } else if (this.fri != null && this.fri.getView() != null) {
            this.frg.bwU().removeHeaderView(this.fri.getView());
            this.fri.getView().setVisibility(8);
        }
    }

    private void jZ(boolean z) {
        if (bx(this.frj.getFunctionList())) {
            this.frh.getView().setVisibility(0);
            this.frh.aV(this.frj.getFunctionList());
        } else if (this.frh != null && this.frh.getView() != null) {
            this.frg.bwU().removeHeaderView(this.frh.getView());
            this.frh.getView().setVisibility(8);
        }
    }

    private boolean bx(List<FunctionListInfo> list) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mPaddingTop == 0) {
            this.mPaddingTop = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
        }
        this.frg = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.frg.setListPullRefreshListener(this.ejc);
        this.frg.setOnSrollToBottomListener(this.UC);
        this.frg.a(this.fro, 2000);
        this.frg.setOnScrollListener(this.frp);
        TiebaStatic.log("c12654");
        return this.frg.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.frl && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.frn = (IAlaSquareTabController) runTask.getData();
            this.frg.a(this.frn);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.frg != null) {
            this.frg.onChangeSkinType(i);
        }
        if (this.frh != null) {
            this.frh.onChangeSkinType(i);
        }
        if (this.fri != null) {
            this.fri.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.frj != null && x.isEmpty(this.frj.bwF()) && !this.frj.isRefreshing()) {
                bwq();
            }
            if (this.frm != null) {
                this.frm.onPageForeground(0);
            }
            if (this.fri != null) {
                this.fri.ka(false);
                this.fri.bwK();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bxy().km(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.frj = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.frq);
        this.frm = new AlaSquareRefreshManager();
        this.frm.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public t onGetPreLoadListView() {
        return (this.frg == null || this.frg.bwU() == null) ? super.onGetPreLoadListView() : this.frg.bwU().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.frm != null) {
            this.frm.reset(i);
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
    protected void bwq() {
        hideNetRefreshView(this.frg.bwR());
        if (x.getCount(this.frj.bwF()) == 0 && this.frg != null) {
            showLoadingView(this.frg.bwR());
        }
        this.frj.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.frj != null) {
            return this.frj.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!x.isEmpty(list) && this.frj != null && !x.isEmpty(this.frj.bwF())) {
            this.frj.by(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.frm != null) {
            this.frm.onPause();
        }
        if (this.fri != null) {
            this.fri.ka(true);
            this.fri.stopPlay();
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
        if (this.frm != null) {
            this.frm.onDestory();
        }
        if (this.frh != null) {
            this.frh.onDestroy();
        }
        if (this.fri != null) {
            this.fri.onDestroy();
        }
        if (this.frj != null) {
            this.frj.onDestroy();
        }
        this.frn = null;
        System.gc();
    }
}
