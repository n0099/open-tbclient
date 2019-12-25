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
import com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel;
import com.baidu.tieba.ala.alasquare.live.toplivecard.a;
import java.util.List;
import tbclient.LiveSquare.FunctionListInfo;
import tbclient.LiveSquare.HeadLiveInfo;
import tbclient.ThreadInfo;
/* loaded from: classes2.dex */
public class AlaSquareLiveFragment extends AlaSquareBaseFragment implements ISquareRefreshHandler {
    private a efA;
    private boolean efD;
    private AlaSquareRefreshManager efE;
    private IAlaSquareTabController efF;
    private com.baidu.tieba.ala.alasquare.live.c.a efz;
    private com.baidu.tieba.ala.alasquare.live.d.a efy = null;
    private AlaSquareLiveModel efB = null;
    private int efC = -1;
    private int mPaddingTop = 0;
    private g.c dcr = new g.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.efB != null) {
                AlaSquareLiveFragment.this.efB.refresh();
            }
        }
    };
    private BdListView.e Ac = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.efB != null) {
                AlaSquareLiveFragment.this.efB.aZs();
            }
        }
    };
    private BdListView.d efG = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener efH = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.bal().aZg();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.efC != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.efA != null) {
                        AlaSquareLiveFragment.this.efA.aZy();
                        if (AlaSquareLiveFragment.this.efA.aZz() != null) {
                            c aZz = AlaSquareLiveFragment.this.efA.aZz();
                            an anVar = new an("c12644");
                            if (aZz.efU == 0) {
                                anVar.Z("obj_type", 1);
                            } else if (aZz.efU == 1) {
                                anVar.Z("obj_type", 2);
                            }
                            anVar.cp("tid", aZz.Nl.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.bal().xk("c12647");
                    if (AlaSquareLiveFragment.this.efA != null) {
                        AlaSquareLiveFragment.this.efA.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.efA != null) {
                    AlaSquareLiveFragment.this.efA.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.efC = i;
        }
    };
    private AlaSquareLiveModel.a efI = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.efy != null) {
                List<m> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.efB.aZt();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.efy.e(list, z, AlaSquareLiveFragment.this.efB.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.efy.aZF());
                        AlaSquareLiveFragment.this.efy.completePullRefresh();
                        AlaSquareLiveFragment.this.hC(z2);
                        AlaSquareLiveFragment.this.efy.e(list, z, AlaSquareLiveFragment.this.efB.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.efy.aZF(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.efy.aZF());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void ad(int i, String str) {
            if (AlaSquareLiveFragment.this.efy != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.efy.aZF());
                AlaSquareLiveFragment.this.efy.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.efB.aZt()) <= 0 || AlaSquareLiveFragment.this.efy == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.efy.aZF(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.efD = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hC(boolean z) {
        if (getPageContext() != null) {
            if (this.efA == null) {
                this.efA = new a(getPageContext());
                this.efA.getView().setVisibility(8);
            }
            this.efy.aZI().removeHeaderView(this.efA.getView());
            this.efy.aZI().addHeaderView(this.efA.getView(), 1);
            if (this.efz == null) {
                this.efz = new com.baidu.tieba.ala.alasquare.live.c.a(getPageContext());
                this.efz.getView().setVisibility(8);
            }
            this.efy.aZI().removeHeaderView(this.efz.getView());
            this.efy.aZI().addHeaderView(this.efz.getView(), 2);
            hD(z);
            hE(z);
        }
    }

    private void hD(boolean z) {
        HeadLiveInfo headLiveInfo = this.efB.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.efA.getView().setVisibility(0);
                c cVar = new c();
                bj bjVar = new bj();
                bjVar.a(threadInfo);
                cVar.Nl = bjVar;
                cVar.efU = headLiveInfo.is_set.intValue();
                this.efA.a(cVar);
                this.efA.aZy();
            } else if (this.efA != null && this.efA.getView() != null) {
                this.efy.aZI().removeHeaderView(this.efA.getView());
                this.efA.getView().setVisibility(8);
            }
        } else if (this.efA != null && this.efA.getView() != null) {
            this.efy.aZI().removeHeaderView(this.efA.getView());
            this.efA.getView().setVisibility(8);
        }
    }

    private void hE(boolean z) {
        if (bf(this.efB.getFunctionList())) {
            this.efz.getView().setVisibility(0);
            this.efz.bg(this.efB.getFunctionList());
        } else if (this.efz != null && this.efz.getView() != null) {
            this.efy.aZI().removeHeaderView(this.efz.getView());
            this.efz.getView().setVisibility(8);
        }
    }

    private boolean bf(List<FunctionListInfo> list) {
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
        this.efy = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.efy.setListPullRefreshListener(this.dcr);
        this.efy.setOnSrollToBottomListener(this.Ac);
        this.efy.a(this.efG, 2000);
        this.efy.setOnScrollListener(this.efH);
        TiebaStatic.log("c12654");
        return this.efy.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.efD && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.efF = (IAlaSquareTabController) runTask.getData();
            this.efy.a(this.efF);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.efy != null) {
            this.efy.onChangeSkinType(i);
        }
        if (this.efz != null) {
            this.efz.onChangeSkinType(i);
        }
        if (this.efA != null) {
            this.efA.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.efB != null && v.isEmpty(this.efB.aZt()) && !this.efB.isRefreshing()) {
                aZi();
            }
            if (this.efE != null) {
                this.efE.onPageForeground(0);
            }
            if (this.efA != null) {
                this.efA.hF(false);
                this.efA.aZy();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.bal().hK(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.efB = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.efI);
        this.efE = new AlaSquareRefreshManager();
        this.efE.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public p onGetPreLoadListView() {
        return (this.efy == null || this.efy.aZI() == null) ? super.onGetPreLoadListView() : this.efy.aZI().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.efE != null) {
            this.efE.reset(i);
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
    protected void aZi() {
        hideNetRefreshView(this.efy.aZF());
        if (v.getCount(this.efB.aZt()) == 0 && this.efy != null) {
            showLoadingView(this.efy.aZF());
        }
        this.efB.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.efB != null) {
            return this.efB.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.efB != null && !v.isEmpty(this.efB.aZt())) {
            this.efB.bh(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.efE != null) {
            this.efE.onPause();
        }
        if (this.efA != null) {
            this.efA.hF(true);
            this.efA.stopPlay();
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
        if (this.efE != null) {
            this.efE.onDestory();
        }
        if (this.efz != null) {
            this.efz.onDestroy();
        }
        if (this.efA != null) {
            this.efA.onDestroy();
        }
        if (this.efB != null) {
            this.efB.onDestroy();
        }
        this.efF = null;
        System.gc();
    }
}
