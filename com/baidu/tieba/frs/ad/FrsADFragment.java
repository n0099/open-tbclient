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
    private String dHV;
    private ADRequestModel.a dMr;
    private ADRequestModel dMs;
    private a dMt;
    private List<c> dMu;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dMq = null;
    private int offset = 0;
    public int RJ = 0;
    private ArrayList<h> dmJ = new ArrayList<>();
    private final j.b bRq = new j.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            if (FrsADFragment.this.dMq != null) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    FrsADFragment.this.ms(2);
                    if (v.I(FrsADFragment.this.dmJ)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dMq.di(false);
            }
        }
    };
    private CustomMessageListener dMv = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
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
                        FrsADFragment.this.ms(0);
                    } else if (FrsADFragment.this.dMq != null) {
                        FrsADFragment.this.dMq.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dIX = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
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
                        FrsADFragment.this.ms(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dMq != null) {
                        FrsADFragment.this.dMq.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dJq = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.PK() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ay.Ef().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.c(cVar.PK(), arrayList)});
                if (!ao.isEmpty(cVar.aCJ())) {
                    TiebaStatic.log(new am("c13194").aA("obj_type", cVar.aCJ()).i(ImageViewerConfig.FORUM_ID, FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dMv);
        registerListener(this.dIX);
        if (this.dMs == null) {
            this.dMs = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dHV = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dHV = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_ad_fragment, (ViewGroup) null);
        this.dMq = new e(this, inflate);
        this.dMq.a(this.bRq);
        this.dMt = new a(this, this.dMq.getListView());
        this.dMt.setOnAdapterItemClickListener(this.dJq);
        if (this.dMr == null) {
            this.dMr = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dMq != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dMu = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aaA();
                            return;
                        }
                        FrsADFragment.this.aaX();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dMq != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dMu = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aaA();
                            return;
                        }
                        FrsADFragment.this.aaX();
                    }
                }
            };
        }
        this.dMs.a(this.dMr);
        if (!com.baidu.adp.lib.util.j.kV()) {
            aaX();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaA() {
        if (this.dMq != null) {
            hideLoadingView();
            if (this.RJ == 0) {
                if (!v.I(this.dMu)) {
                    D(true, false);
                    this.dMq.aba();
                    return;
                }
                showEmptyView();
            } else if (this.RJ == 2) {
                this.dMq.di(false);
                if (!v.I(this.dMu)) {
                    D(true, false);
                    this.dMq.aba();
                    return;
                }
                showEmptyView();
            } else if (this.RJ == 1) {
                if (!v.I(this.dMu)) {
                    D(false, true);
                } else {
                    this.dMq.aba();
                }
            }
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.dmJ != null) {
            if (z) {
                this.dmJ.clear();
            }
            if (z2) {
                for (int i = 0; i < this.dmJ.size(); i++) {
                    h hVar = (h) v.d(this.dmJ, i);
                    if (hVar instanceof c) {
                        ((c) hVar).gQ(false);
                    }
                }
            }
            this.dmJ.addAll(this.dMu);
            this.dMq.aCO().setData(this.dmJ);
            this.dMq.aCO().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aAs() {
        if (this.dMq != null && this.dMq.getListView() != null) {
            this.dMq.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aaW() {
        if (this.dMq != null) {
            aAs();
            this.dMq.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dMq != null) {
            if (this.dMq != null && this.dMq.getListView() != null) {
                this.dMq.getListView().stopScroll();
            }
            aap();
            if (l.ll() && this.mHasMore) {
                ms(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dMq != null) {
            this.dMq.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (this.dMs != null) {
            aaY();
            this.RJ = i;
            if (i == 0 || i == 2) {
                this.dMs.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dMs.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dMq == null) {
            return null;
        }
        return this.dMq.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.kV()) {
            ms(0);
            showLoadingView();
            return;
        }
        aaX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dMq.gR(false);
        showLoadingView(this.dMq.aBQ(), true, getResources().getDimensionPixelSize(e.C0210e.ds250));
    }

    private void hideLoadingView() {
        this.dMq.gR(true);
        hideLoadingView(this.dMq.aBQ());
    }

    private void aap() {
        if (!this.mHasMore) {
            if (v.I(this.dMu)) {
                this.dMq.abb();
                return;
            } else {
                this.dMq.aba();
                return;
            }
        }
        this.dMq.aaZ();
    }

    private void showEmptyView() {
        if (this.dmJ != null && this.dMq != null) {
            this.dmJ.add(new m());
            this.dMq.aCO().setData(this.dmJ);
            this.dMq.aCO().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaX() {
        this.dMq.gR(false);
        this.dMq.aCP().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dMq.abb();
        this.dMq.getListView().getData().clear();
        this.dMq.aBF();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.NL();
            this.mRefreshView.gc(getResources().getDimensionPixelSize(e.C0210e.ds_102));
            this.mRefreshView.NJ().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.dMq.aBQ(), true);
    }

    private void aaY() {
        this.dMq.gR(true);
        this.dMq.aCP().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.dettachView(this.dMq.aBQ());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            ms(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dMq != null) {
            this.dMq.onDestroy();
        }
        if (this.dMs != null) {
            this.dMs.onDestroy();
        }
        super.onDestroy();
    }
}
