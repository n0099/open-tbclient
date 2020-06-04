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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.r;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.refresh.AlaSquareRefreshManager;
import com.baidu.ala.refresh.ISquareRefreshHandler;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes3.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a faO;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a faP;
    private boolean faS;
    private AlaSquareRefreshManager faT;
    private IAlaSquareTabController faU;
    private com.baidu.tieba.ala.alasquare.live.d.a faN = null;
    private AlaSquareLiveModel faQ = null;
    private int faR = -1;
    private int mPaddingTop = 0;
    private f.c dVt = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.faQ != null) {
                AlaSquareLiveFragment.this.faQ.refresh();
            }
        }
    };
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.faQ != null) {
                AlaSquareLiveFragment.this.faQ.bqx();
            }
        }
    };
    private BdListView.d faV = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener faW = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.brs().bpt();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.faR != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.faP != null) {
                        AlaSquareLiveFragment.this.faP.bqD();
                        if (AlaSquareLiveFragment.this.faP.bqE() != null) {
                            c bqE = AlaSquareLiveFragment.this.faP.bqE();
                            an anVar = new an("c12644");
                            if (bqE.fbj == 0) {
                                anVar.ag("obj_type", 1);
                            } else if (bqE.fbj == 1) {
                                anVar.ag("obj_type", 2);
                            }
                            anVar.dh("tid", bqE.ahg.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.brs().AX("c12647");
                    if (AlaSquareLiveFragment.this.faP != null) {
                        AlaSquareLiveFragment.this.faP.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.faP != null) {
                    AlaSquareLiveFragment.this.faP.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.faR = i;
        }
    };
    private AlaSquareLiveModel.a faX = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.faN != null) {
                List<o> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.faQ.bqy();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.faN.c(list, z, AlaSquareLiveFragment.this.faQ.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.faN.bqK());
                        AlaSquareLiveFragment.this.faN.completePullRefresh();
                        AlaSquareLiveFragment.this.jg(z2);
                        AlaSquareLiveFragment.this.faN.c(list, z, AlaSquareLiveFragment.this.faQ.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.faN.bqK(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.faN.bqK());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void al(int i, String str) {
            if (AlaSquareLiveFragment.this.faN != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.faN.bqK());
                AlaSquareLiveFragment.this.faN.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.faQ.bqy()) <= 0 || AlaSquareLiveFragment.this.faN == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.faN.bqK(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.faS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jg(boolean z) {
        if (getPageContext() != null) {
            if (this.faP == null) {
                this.faP = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.faP.getView().setVisibility(8);
            }
            this.faN.bqN().removeHeaderView(this.faP.getView());
            this.faN.bqN().addHeaderView(this.faP.getView(), 1);
            if (this.faO == null) {
                this.faO = new a(getPageContext());
                this.faO.getView().setVisibility(8);
            }
            this.faN.bqN().removeHeaderView(this.faO.getView());
            this.faN.bqN().addHeaderView(this.faO.getView(), 2);
            jh(z);
            ji(z);
        }
    }

    private void jh(boolean z) {
        HeadLiveInfo headLiveInfo = this.faQ.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.faP.getView().setVisibility(0);
                c cVar = new c();
                bk bkVar = new bk();
                bkVar.a(threadInfo);
                cVar.ahg = bkVar;
                cVar.fbj = headLiveInfo.is_set.intValue();
                this.faP.a(cVar);
                this.faP.bqD();
            } else if (this.faP != null && this.faP.getView() != null) {
                this.faN.bqN().removeHeaderView(this.faP.getView());
                this.faP.getView().setVisibility(8);
            }
        } else if (this.faP != null && this.faP.getView() != null) {
            this.faN.bqN().removeHeaderView(this.faP.getView());
            this.faP.getView().setVisibility(8);
        }
    }

    private void ji(boolean z) {
        if (bj(this.faQ.getFunctionList())) {
            this.faO.getView().setVisibility(0);
            this.faO.bk(this.faQ.getFunctionList());
        } else if (this.faO != null && this.faO.getView() != null) {
            this.faN.bqN().removeHeaderView(this.faO.getView());
            this.faO.getView().setVisibility(8);
        }
    }

    private boolean bj(List<FunctionListInfo> list) {
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
        this.faN = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.faN.setListPullRefreshListener(this.dVt);
        this.faN.setOnSrollToBottomListener(this.Uf);
        this.faN.a(this.faV, 2000);
        this.faN.setOnScrollListener(this.faW);
        TiebaStatic.log("c12654");
        return this.faN.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.faS && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.faU = (IAlaSquareTabController) runTask.getData();
            this.faN.a(this.faU);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.faN != null) {
            this.faN.onChangeSkinType(i);
        }
        if (this.faO != null) {
            this.faO.onChangeSkinType(i);
        }
        if (this.faP != null) {
            this.faP.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.faQ != null && v.isEmpty(this.faQ.bqy()) && !this.faQ.isRefreshing()) {
                bqj();
            }
            if (this.faT != null) {
                this.faT.onPageForeground(0);
            }
            if (this.faP != null) {
                this.faP.jj(false);
                this.faP.bqD();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.brs().jv(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.faQ = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.faX);
        this.faT = new AlaSquareRefreshManager();
        this.faT.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public r onGetPreLoadListView() {
        return (this.faN == null || this.faN.bqN() == null) ? super.onGetPreLoadListView() : this.faN.bqN().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.faT != null) {
            this.faT.reset(i);
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
    protected void bqj() {
        hideNetRefreshView(this.faN.bqK());
        if (v.getCount(this.faQ.bqy()) == 0 && this.faN != null) {
            showLoadingView(this.faN.bqK());
        }
        this.faQ.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.faQ != null) {
            return this.faQ.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.faQ != null && !v.isEmpty(this.faQ.bqy())) {
            this.faQ.bl(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.faT != null) {
            this.faT.onPause();
        }
        if (this.faP != null) {
            this.faP.jj(true);
            this.faP.stopPlay();
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
        if (this.faT != null) {
            this.faT.onDestory();
        }
        if (this.faO != null) {
            this.faO.onDestroy();
        }
        if (this.faP != null) {
            this.faP.onDestroy();
        }
        if (this.faQ != null) {
            this.faQ.onDestroy();
        }
        this.faU = null;
        System.gc();
    }
}
