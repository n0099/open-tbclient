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
    private a gzc;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a gzd;
    private boolean gzg;
    private AlaSquareRefreshManager gzh;
    private IAlaSquareTabController gzi;
    private com.baidu.tieba.ala.alasquare.live.d.a gzb = null;
    private AlaSquareLiveModel gze = null;
    private int gzf = -1;
    private int mPaddingTop = 0;
    private f.c fjz = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.gze != null) {
                AlaSquareLiveFragment.this.gze.refresh();
            }
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.gze != null) {
                AlaSquareLiveFragment.this.gze.bRj();
            }
        }
    };
    private BdListView.d gzj = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener gzk = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.b.a.bSe().bOM();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.gzf != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.gzd != null) {
                        AlaSquareLiveFragment.this.gzd.bRp();
                        if (AlaSquareLiveFragment.this.gzd.bRq() != null) {
                            c bRq = AlaSquareLiveFragment.this.gzd.bRq();
                            ar arVar = new ar("c12644");
                            if (bRq.gzx == 0) {
                                arVar.ap("obj_type", 1);
                            } else if (bRq.gzx == 1) {
                                arVar.ap("obj_type", 2);
                            }
                            arVar.dR("tid", bRq.akU.getTid());
                            TiebaStatic.log(arVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.b.a.bSe().FY("c12647");
                    if (AlaSquareLiveFragment.this.gzd != null) {
                        AlaSquareLiveFragment.this.gzd.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.gzd != null) {
                    AlaSquareLiveFragment.this.gzd.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.gzf = i;
        }
    };
    private AlaSquareLiveModel.a gzl = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void j(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.gzb != null) {
                List<n> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.gze.bRk();
                }
                if (!z2 || y.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.gzb.c(list, z, AlaSquareLiveFragment.this.gze.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gzb.bRw());
                        AlaSquareLiveFragment.this.gzb.completePullRefresh();
                        AlaSquareLiveFragment.this.mr(z2);
                        AlaSquareLiveFragment.this.gzb.c(list, z, AlaSquareLiveFragment.this.gze.getIsSmallFollow());
                    }
                    if (y.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gzb.bRw(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.gzb.bRw());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void aJ(int i, String str) {
            if (AlaSquareLiveFragment.this.gzb != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.gzb.bRw());
                AlaSquareLiveFragment.this.gzb.completePullRefresh();
            }
            if (y.getCount(AlaSquareLiveFragment.this.gze.bRk()) <= 0 || AlaSquareLiveFragment.this.gzb == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.gzb.bRw(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.gzg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mr(boolean z) {
        if (getPageContext() != null) {
            if (this.gzd == null) {
                this.gzd = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.gzd.getView().setVisibility(8);
            }
            this.gzb.bRz().removeHeaderView(this.gzd.getView());
            this.gzb.bRz().addHeaderView(this.gzd.getView(), 1);
            if (this.gzc == null) {
                this.gzc = new a(getPageContext());
                this.gzc.getView().setVisibility(8);
            }
            this.gzb.bRz().removeHeaderView(this.gzc.getView());
            this.gzb.bRz().addHeaderView(this.gzc.getView(), 2);
            ms(z);
            mt(z);
        }
    }

    private void ms(boolean z) {
        HeadLiveInfo headLiveInfo = this.gze.getHeadLiveInfo();
        if (headLiveInfo != null && !y.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.gzd.getView().setVisibility(0);
                c cVar = new c();
                cb cbVar = new cb();
                cbVar.a(threadInfo);
                cVar.akU = cbVar;
                cVar.gzx = headLiveInfo.is_set.intValue();
                this.gzd.a(cVar);
                this.gzd.bRp();
            } else if (this.gzd != null && this.gzd.getView() != null) {
                this.gzb.bRz().removeHeaderView(this.gzd.getView());
                this.gzd.getView().setVisibility(8);
            }
        } else if (this.gzd != null && this.gzd.getView() != null) {
            this.gzb.bRz().removeHeaderView(this.gzd.getView());
            this.gzd.getView().setVisibility(8);
        }
    }

    private void mt(boolean z) {
        if (cc(this.gze.getFunctionList())) {
            this.gzc.getView().setVisibility(0);
            this.gzc.cd(this.gze.getFunctionList());
        } else if (this.gzc != null && this.gzc.getView() != null) {
            this.gzb.bRz().removeHeaderView(this.gzc.getView());
            this.gzc.getView().setVisibility(8);
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
        this.gzb = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.gzb.setListPullRefreshListener(this.fjz);
        this.gzb.setOnSrollToBottomListener(this.WH);
        this.gzb.a(this.gzj, 2000);
        this.gzb.setOnScrollListener(this.gzk);
        TiebaStatic.log("c12654");
        return this.gzb.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.gzg && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.gzi = (IAlaSquareTabController) runTask.getData();
            this.gzb.a(this.gzi);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gzb != null) {
            this.gzb.onChangeSkinType(i);
        }
        if (this.gzc != null) {
            this.gzc.onChangeSkinType(i);
        }
        if (this.gzd != null) {
            this.gzd.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gze != null && y.isEmpty(this.gze.bRk()) && !this.gze.isRefreshing()) {
                bQR();
            }
            if (this.gzh != null) {
                this.gzh.onPageForeground(0);
            }
            if (this.gzd != null) {
                this.gzd.mu(false);
                this.gzd.bRp();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.b.a.bSe().mG(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gze = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.gzl);
        this.gzh = new AlaSquareRefreshManager();
        this.gzh.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public q onGetPreLoadListView() {
        return (this.gzb == null || this.gzb.bRz() == null) ? super.onGetPreLoadListView() : this.gzb.bRz().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.gzh != null) {
            this.gzh.reset(i);
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
    protected void bQR() {
        hideNetRefreshView(this.gzb.bRw());
        if (y.getCount(this.gze.bRk()) == 0 && this.gzb != null) {
            showLoadingView(this.gzb.bRw());
        }
        this.gze.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.gze != null) {
            return this.gze.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!y.isEmpty(list) && this.gze != null && !y.isEmpty(this.gze.bRk())) {
            this.gze.ce(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gzh != null) {
            this.gzh.onPause();
        }
        if (this.gzd != null) {
            this.gzd.mu(true);
            this.gzd.stopPlay();
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
        if (this.gzh != null) {
            this.gzh.onDestory();
        }
        if (this.gzc != null) {
            this.gzc.onDestroy();
        }
        if (this.gzd != null) {
            this.gzd.onDestroy();
        }
        if (this.gze != null) {
            this.gze.onDestroy();
        }
        this.gzi = null;
        System.gc();
    }
}
