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
    private a faD;
    private com.baidu.tieba.ala.alasquare.live.toplivecard.a faE;
    private boolean faH;
    private AlaSquareRefreshManager faI;
    private IAlaSquareTabController faJ;
    private com.baidu.tieba.ala.alasquare.live.d.a faC = null;
    private AlaSquareLiveModel faF = null;
    private int faG = -1;
    private int mPaddingTop = 0;
    private f.c dVt = new f.c() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.1
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (AlaSquareLiveFragment.this.faF != null) {
                AlaSquareLiveFragment.this.faF.refresh();
            }
        }
    };
    private BdListView.e Uf = new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.2
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (AlaSquareLiveFragment.this.faF != null) {
                AlaSquareLiveFragment.this.faF.bqv();
            }
        }
    };
    private BdListView.d faK = new BdListView.d() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.3
        @Override // com.baidu.adp.widget.ListView.BdListView.d
        public void onScrollStop(int i, int i2) {
            MessageManager.getInstance().removeMessage(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, null);
            MessageManager.getInstance().removeMessage(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2, null);
            AlaSquareLiveFragment.this.refreshCurrentPage();
        }
    };
    private AbsListView.OnScrollListener faL = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.4
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                com.baidu.tieba.ala.alasquare.c.a.brq().bpr();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (AlaSquareLiveFragment.this.faG != i) {
                if (i == 1) {
                    if (AlaSquareLiveFragment.this.faE != null) {
                        AlaSquareLiveFragment.this.faE.bqB();
                        if (AlaSquareLiveFragment.this.faE.bqC() != null) {
                            c bqC = AlaSquareLiveFragment.this.faE.bqC();
                            an anVar = new an("c12644");
                            if (bqC.faY == 0) {
                                anVar.ag("obj_type", 1);
                            } else if (bqC.faY == 1) {
                                anVar.ag("obj_type", 2);
                            }
                            anVar.dh("tid", bqC.ahg.getTid());
                            TiebaStatic.log(anVar);
                        }
                    }
                } else if (i == 2) {
                    com.baidu.tieba.ala.alasquare.c.a.brq().AX("c12647");
                    if (AlaSquareLiveFragment.this.faE != null) {
                        AlaSquareLiveFragment.this.faE.stopPlay();
                    }
                } else if (i > 1 && AlaSquareLiveFragment.this.faE != null) {
                    AlaSquareLiveFragment.this.faE.stopPlay();
                }
            }
            AlaSquareLiveFragment.this.faG = i;
        }
    };
    private AlaSquareLiveModel.a faM = new AlaSquareLiveModel.a() { // from class: com.baidu.tieba.ala.alasquare.live.AlaSquareLiveFragment.5
        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void g(boolean z, boolean z2, boolean z3) {
            if (AlaSquareLiveFragment.this.getPageContext() != null && AlaSquareLiveFragment.this.faC != null) {
                List<o> list = null;
                if (!z2) {
                    list = AlaSquareLiveFragment.this.faF.bqw();
                }
                if (!z2 || v.getCount(list) != 0) {
                    if (z3) {
                        AlaSquareLiveFragment.this.faC.c(list, z, AlaSquareLiveFragment.this.faF.getIsSmallFollow());
                    } else {
                        AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.faC.bqI());
                        AlaSquareLiveFragment.this.faC.completePullRefresh();
                        AlaSquareLiveFragment.this.jg(z2);
                        AlaSquareLiveFragment.this.faC.c(list, z, AlaSquareLiveFragment.this.faF.getIsSmallFollow());
                    }
                    if (v.getCount(list) == 0) {
                        AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.faC.bqI(), AlaSquareLiveFragment.this.getString(R.string.no_data_text), false);
                    } else {
                        AlaSquareLiveFragment.this.hideNetRefreshView(AlaSquareLiveFragment.this.faC.bqI());
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.alasquare.live.model.AlaSquareLiveModel.a
        public void al(int i, String str) {
            if (AlaSquareLiveFragment.this.faC != null) {
                AlaSquareLiveFragment.this.hideLoadingView(AlaSquareLiveFragment.this.faC.bqI());
                AlaSquareLiveFragment.this.faC.completePullRefresh();
            }
            if (v.getCount(AlaSquareLiveFragment.this.faF.bqw()) <= 0 || AlaSquareLiveFragment.this.faC == null) {
                AlaSquareLiveFragment.this.showNetRefreshView(AlaSquareLiveFragment.this.faC.bqI(), str, false);
            } else {
                AlaSquareLiveFragment.this.showToast(str);
            }
        }
    };

    public AlaSquareLiveFragment() {
    }

    public AlaSquareLiveFragment(boolean z) {
        this.faH = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jg(boolean z) {
        if (getPageContext() != null) {
            if (this.faE == null) {
                this.faE = new com.baidu.tieba.ala.alasquare.live.toplivecard.a(getPageContext());
                this.faE.getView().setVisibility(8);
            }
            this.faC.bqL().removeHeaderView(this.faE.getView());
            this.faC.bqL().addHeaderView(this.faE.getView(), 1);
            if (this.faD == null) {
                this.faD = new a(getPageContext());
                this.faD.getView().setVisibility(8);
            }
            this.faC.bqL().removeHeaderView(this.faD.getView());
            this.faC.bqL().addHeaderView(this.faD.getView(), 2);
            jh(z);
            ji(z);
        }
    }

    private void jh(boolean z) {
        HeadLiveInfo headLiveInfo = this.faF.getHeadLiveInfo();
        if (headLiveInfo != null && !v.isEmpty(headLiveInfo.head_live)) {
            ThreadInfo threadInfo = headLiveInfo.head_live.get(0);
            if (threadInfo.ala_info != null && threadInfo.ala_info.live_status.intValue() == 1) {
                this.faE.getView().setVisibility(0);
                c cVar = new c();
                bk bkVar = new bk();
                bkVar.a(threadInfo);
                cVar.ahg = bkVar;
                cVar.faY = headLiveInfo.is_set.intValue();
                this.faE.a(cVar);
                this.faE.bqB();
            } else if (this.faE != null && this.faE.getView() != null) {
                this.faC.bqL().removeHeaderView(this.faE.getView());
                this.faE.getView().setVisibility(8);
            }
        } else if (this.faE != null && this.faE.getView() != null) {
            this.faC.bqL().removeHeaderView(this.faE.getView());
            this.faE.getView().setVisibility(8);
        }
    }

    private void ji(boolean z) {
        if (bj(this.faF.getFunctionList())) {
            this.faD.getView().setVisibility(0);
            this.faD.bk(this.faF.getFunctionList());
        } else if (this.faD != null && this.faD.getView() != null) {
            this.faC.bqL().removeHeaderView(this.faD.getView());
            this.faD.getView().setVisibility(8);
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
        this.faC = new com.baidu.tieba.ala.alasquare.live.d.a(getPageContext(), getUniqueId(), this.mPaddingTop);
        this.faC.setListPullRefreshListener(this.dVt);
        this.faC.setOnSrollToBottomListener(this.Uf);
        this.faC.a(this.faK, 2000);
        this.faC.setOnScrollListener(this.faL);
        TiebaStatic.log("c12654");
        return this.faC.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        CustomResponsedMessage runTask;
        super.onViewCreated(view, bundle);
        if (!this.faH && (runTask = MessageManager.getInstance().runTask(AlaCmdConfigCustom.CMD_ALA_SQUARE_TAB_CONTROLLER, IAlaSquareTabController.class)) != null && runTask.getData() != null) {
            this.faJ = (IAlaSquareTabController) runTask.getData();
            this.faC.a(this.faJ);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.faC != null) {
            this.faC.onChangeSkinType(i);
        }
        if (this.faD != null) {
            this.faD.onChangeSkinType(i);
        }
        if (this.faE != null) {
            this.faE.onChangeSkinType();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.faF != null && v.isEmpty(this.faF.bqw()) && !this.faF.isRefreshing()) {
                bqh();
            }
            if (this.faI != null) {
                this.faI.onPageForeground(0);
            }
            if (this.faE != null) {
                this.faE.jj(false);
                this.faE.bqB();
                return;
            }
            return;
        }
        com.baidu.tieba.ala.alasquare.c.a.brq().jv(false);
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment, com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.faF = new AlaSquareLiveModel(getPageContext(), getUniqueId(), this.faM);
        this.faI = new AlaSquareRefreshManager();
        this.faI.init(this, new long[]{30000});
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public r onGetPreLoadListView() {
        return (this.faC == null || this.faC.bqL() == null) ? super.onGetPreLoadListView() : this.faC.bqL().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.SQUARE_LIVE;
    }

    @Override // com.baidu.ala.refresh.ISquareRefreshHandler
    public void markDataLoaded(int i) {
        if (this.faI != null) {
            this.faI.reset(i);
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
    protected void bqh() {
        hideNetRefreshView(this.faC.bqI());
        if (v.getCount(this.faF.bqw()) == 0 && this.faC != null) {
            showLoadingView(this.faC.bqI());
        }
        this.faF.refresh();
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected List<Long> getCurrentLiveIds() {
        if (this.faF != null) {
            return this.faF.getCurrentLiveIds();
        }
        return null;
    }

    @Override // com.baidu.ala.refresh.AlaAutoRefreshFragment
    protected void processCloseLives(List<Long> list) {
        if (!v.isEmpty(list) && this.faF != null && !v.isEmpty(this.faF.bqw())) {
            this.faF.bl(list);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.faI != null) {
            this.faI.onPause();
        }
        if (this.faE != null) {
            this.faE.jj(true);
            this.faE.stopPlay();
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
        if (this.faI != null) {
            this.faI.onDestory();
        }
        if (this.faD != null) {
            this.faD.onDestroy();
        }
        if (this.faE != null) {
            this.faE.onDestroy();
        }
        if (this.faF != null) {
            this.faF.onDestroy();
        }
        this.faJ = null;
        System.gc();
    }
}
