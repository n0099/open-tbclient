package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, aj {
    private TbPageContext context;
    private String dLt;
    private ADRequestModel.a dPP;
    private ADRequestModel dPQ;
    private a dPR;
    private List<c> dPS;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dPO = null;
    private int offset = 0;
    public int RV = 0;
    private ArrayList<h> dqo = new ArrayList<>();
    private final j.b bSf = new j.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bI(boolean z) {
            if (FrsADFragment.this.dPO != null) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    FrsADFragment.this.mG(2);
                    if (v.I(FrsADFragment.this.dqo)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dPO.dl(false);
            }
        }
    };
    private CustomMessageListener dPT = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.isViewAttached()) {
                        FrsADFragment.this.mG(0);
                    } else if (FrsADFragment.this.dPO != null) {
                        FrsADFragment.this.dPO.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dMv = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.isViewAttached()) {
                        FrsADFragment.this.mG(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dPO != null) {
                        FrsADFragment.this.dPO.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dMO = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.Qe() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ay.Es().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.c(cVar.Qe(), arrayList)});
                if (!ao.isEmpty(cVar.aDV())) {
                    TiebaStatic.log(new am("c13194").aB("obj_type", cVar.aDV()).i(ImageViewerConfig.FORUM_ID, FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dPT);
        registerListener(this.dMv);
        if (this.dPQ == null) {
            this.dPQ = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dLt = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dLt = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_ad_fragment, (ViewGroup) null);
        this.dPO = new e(this, inflate);
        this.dPO.a(this.bSf);
        this.dPR = new a(this, this.dPO.getListView());
        this.dPR.setOnAdapterItemClickListener(this.dMO);
        if (this.dPP == null) {
            this.dPP = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dPO != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dPS = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aaZ();
                            return;
                        }
                        FrsADFragment.this.abw();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dPO != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dPS = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aaZ();
                            return;
                        }
                        FrsADFragment.this.abw();
                    }
                }
            };
        }
        this.dPQ.a(this.dPP);
        if (!com.baidu.adp.lib.util.j.kV()) {
            abw();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaZ() {
        if (this.dPO != null) {
            hideLoadingView();
            if (this.RV == 0) {
                if (!v.I(this.dPS)) {
                    D(true, false);
                    this.dPO.abz();
                    return;
                }
                showEmptyView();
            } else if (this.RV == 2) {
                this.dPO.dl(false);
                if (!v.I(this.dPS)) {
                    D(true, false);
                    this.dPO.abz();
                    return;
                }
                showEmptyView();
            } else if (this.RV == 1) {
                if (!v.I(this.dPS)) {
                    D(false, true);
                } else {
                    this.dPO.abz();
                }
            }
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.dqo != null) {
            if (z) {
                this.dqo.clear();
            }
            if (z2) {
                for (int i = 0; i < this.dqo.size(); i++) {
                    h hVar = (h) v.d(this.dqo, i);
                    if (hVar instanceof c) {
                        ((c) hVar).gW(false);
                    }
                }
            }
            this.dqo.addAll(this.dPS);
            this.dPO.aEa().setData(this.dqo);
            this.dPO.aEa().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aBE() {
        if (this.dPO != null && this.dPO.getListView() != null) {
            this.dPO.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void abv() {
        if (this.dPO != null) {
            aBE();
            this.dPO.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dPO != null) {
            if (this.dPO != null && this.dPO.getListView() != null) {
                this.dPO.getListView().stopScroll();
            }
            aaO();
            if (l.ll() && this.mHasMore) {
                mG(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dPO != null) {
            this.dPO.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mG(int i) {
        if (this.dPQ != null) {
            abx();
            this.RV = i;
            if (i == 0 || i == 2) {
                this.dPQ.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dPQ.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dPO == null) {
            return null;
        }
        return this.dPO.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.kV()) {
            mG(0);
            showLoadingView();
            return;
        }
        abw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dPO.gX(false);
        showLoadingView(this.dPO.aDc(), true, getResources().getDimensionPixelSize(e.C0210e.ds250));
    }

    private void hideLoadingView() {
        this.dPO.gX(true);
        hideLoadingView(this.dPO.aDc());
    }

    private void aaO() {
        if (!this.mHasMore) {
            if (v.I(this.dPS)) {
                this.dPO.abA();
                return;
            } else {
                this.dPO.abz();
                return;
            }
        }
        this.dPO.aby();
    }

    private void showEmptyView() {
        if (this.dqo != null && this.dPO != null) {
            this.dqo.add(new m());
            this.dPO.aEa().setData(this.dqo);
            this.dPO.aEa().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abw() {
        this.dPO.gX(false);
        this.dPO.aEb().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dPO.abA();
        this.dPO.getListView().getData().clear();
        this.dPO.aCR();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Od();
            this.mRefreshView.gd(getResources().getDimensionPixelSize(e.C0210e.ds_102));
            this.mRefreshView.Ob().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.dPO.aDc(), true);
    }

    private void abx() {
        this.dPO.gX(true);
        this.dPO.aEb().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.dettachView(this.dPO.aDc());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            mG(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dPO != null) {
            this.dPO.onDestroy();
        }
        if (this.dPQ != null) {
            this.dPQ.onDestroy();
        }
        super.onDestroy();
    }
}
