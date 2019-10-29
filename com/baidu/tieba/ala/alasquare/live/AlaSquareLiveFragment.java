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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.AlaSquareBaseFragment;
import com.baidu.tieba.ala.alasquare.live.b.c;
import com.baidu.tieba.ala.alasquare.live.c.a;
import com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a dvo;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a dvp;
    private boolean dvs;
    private AlaSquareRefreshManager dvt;
    private IAlaSquareTabController dvu;
    private com.baidu.tieba.ala.alasquare.live.d.a dvn = null;
    private AlaSquareLiveModel dvq = null;
    private int dvr = -1;
    private int mPaddingTop = 0;
    private h.c cpS = new h.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.dvq != null) {
                AlaSquareLiveFragment.this.dvq.refresh();
            }
        }
    };
    private BdListView.e ye = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.dvq != null) {
                AlaSquareLiveFragment.this.dvq.aIW();
            }
        }
    };
    private BdListView.d dvv = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener dvw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.aJO().aIL();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.dvr != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.dvp != null) {
                        AlaSquareLiveFragment.this.dvp.aJc();
                        if (AlaSquareLiveFragment.this.dvp.aJd() != null) {
                            c aJd = AlaSquareLiveFragment.this.dvp.aJd();
                            an anVar = new an("c12644");
                            if (aJd.dvJ == 0) {
                                anVar.O("obj_type", 1);
                            } else if (aJd.dvJ == 1) {
                                anVar.O("obj_type", 2);
                            }
                            anVar.bS("tid", aJd.cry.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.aJO().sD("c12647");
                    if (AlaSquareLiveFragment.this.dvp != null) {
                        AlaSquareLiveFragment.this.dvp.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.dvp != null) {
                    AlaSquareLiveFragment.this.dvp.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.dvr = i;
        }
    };
    private AlaSquareLiveModel.a dvx = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.dvn != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.dvq.aIX();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.dvn.c(list, z, AlaSquareLiveFragment.this.dvq.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.dvn.aJj());
                        AlaSquareLiveFragment.this.dvn.completePullRefresh();
                        AlaSquareLiveFragment.this.gx(z2);
                        AlaSquareLiveFragment.this.dvn.c(list, z, AlaSquareLiveFragment.this.dvq.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.dvn.aJj(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.dvn.aJj());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void P(int i, String str) {
            if (AlaSquareLiveFragment.this.dvn != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.dvn.aJj());
                AlaSquareLiveFragment.this.dvn.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.dvq.aIX()) <= 0 || AlaSquareLiveFragment.this.dvn == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.dvn.aJj(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.dvs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(boolean z) {
        if (getPageContext() != null) {
            if (this.dvp == null) {
                this.dvp = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.dvp.getView().setVisibility(8);
            }
            this.dvn.aJm().removeHeaderView(this.dvp.getView());
            this.dvn.aJm().addHeaderView(this.dvp.getView(), 1);
            if (this.dvo == null) {
                this.dvo = new a(getPageContext());
                this.dvo.getView().setVisibility(8);
            }
            this.dvn.aJm().removeHeaderView(this.dvo.getView());
            this.dvn.aJm().addHeaderView(this.dvo.getView(), 2);
            gy(z);
            gz(z);
        }
    }

    private void gy(boolean z) {
        HeadLiveInfo headLiveInfo = this.dvq.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.dvp.getView().setVisibility(0);
                c cVar = new c();
                bh bhVar = new bh();
                bhVar.a(threadInfo);
                cVar.cry = bhVar;
                cVar.dvJ = headLiveInfo.is_set.intValue();
                this.dvp.a(cVar);
                this.dvp.aJc();
            } else if (this.dvp != null && this.dvp.getView() != null) {
                this.dvn.aJm().removeHeaderView(this.dvp.getView());
                this.dvp.getView().setVisibility(8);
            }
        } else if (this.dvp != null && this.dvp.getView() != null) {
            this.dvn.aJm().removeHeaderView(this.dvp.getView());
            this.dvp.getView().setVisibility(8);
        }
    }

    private void gz(boolean z) {
        if (bg(this.dvq.getFunctionList())) {
            this.dvo.getView().setVisibility(0);
            this.dvo.bh(this.dvq.getFunctionList());
        } else if (this.dvo != null && this.dvo.getView() != null) {
            this.dvn.aJm().removeHeaderView(this.dvo.getView());
            this.dvo.getView().setVisibility(8);
        }
    }

    private boolean bg(List<FunctionListInfo> list) {
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

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mPaddingTop == 0) {
            this.mPaddingTop = (int) getPageContext().getResources().getDimension(R.dimen.ds80);
        }
        this.dvn = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.dvn.setListPullRefreshListener(this.cpS);
        this.dvn.setOnSrollToBottomListener(this.ye);
        this.dvn.a(this.dvv, 2000);
        this.dvn.setOnScrollListener(this.dvw);
        TiebaStatic.log("c12654");
        return this.dvn.getView();
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.dvs && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.dvu = (IAlaSquareTabController) runTask.getData();
            this.dvn.a(this.dvu);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dvn != null) {
            this.dvn.onChangeSkinType(i);
        }
        if (this.dvo != null) {
            this.dvo.onChangeSkinType(i);
        }
        if (this.dvp != null) {
            this.dvp.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.dvq != null && v.isEmpty(this.dvq.aIX()) && !this.dvq.isRefreshing()) {
                aIM();
            }
            if (this.dvt != null) {
                this.dvt.onPageForeground(0);
            }
            if (this.dvp != null) {
                this.dvp.gA(false);
                this.dvp.aJc();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.aJO().gF(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dvq = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.dvx);
        this.dvt = new AlaSquareRefreshManager();
        this.dvt.init(this, new long[]{StatisticConfig.MIN_UPLOAD_INTERVAL});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.dvn == null || this.dvn.aJm() == null) ? super.onGetPreLoadListView() : this.dvn.aJm().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.dvt != null) {
            this.dvt.reset(i);
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
    protected void aIM() {
        hideNetRefreshView(this.dvn.aJj());
        if (v.getCount(this.dvq.aIX()) == 0 && this.dvn != null) {
            showLoadingView(this.dvn.aJj());
        }
        this.dvq.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.dvq != null) {
            return this.dvq.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.dvq != null && !v.isEmpty(this.dvq.aIX())) {
            this.dvq.bi(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dvt != null) {
            this.dvt.onPause();
        }
        if (this.dvp != null) {
            this.dvp.gA(true);
            this.dvp.stopPlay();
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
        if (this.dvt != null) {
            this.dvt.onDestory();
        }
        if (this.dvo != null) {
            this.dvo.onDestroy();
        }
        if (this.dvp != null) {
            this.dvp.onDestroy();
        }
        if (this.dvq != null) {
            this.dvq.onDestroy();
        }
        this.dvu = null;
        System.gc();
    }
}
