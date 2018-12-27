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
    private String dKJ;
    private ADRequestModel.a dPf;
    private ADRequestModel dPg;
    private a dPh;
    private List<c> dPi;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dPe = null;
    private int offset = 0;
    public int RJ = 0;
    private ArrayList<h> dpB = new ArrayList<>();
    private final j.b bRt = new j.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bH(boolean z) {
            if (FrsADFragment.this.dPe != null) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    FrsADFragment.this.mF(2);
                    if (v.I(FrsADFragment.this.dpB)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dPe.di(false);
            }
        }
    };
    private CustomMessageListener dPj = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
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
                        FrsADFragment.this.mF(0);
                    } else if (FrsADFragment.this.dPe != null) {
                        FrsADFragment.this.dPe.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dLL = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
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
                        FrsADFragment.this.mF(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dPe != null) {
                        FrsADFragment.this.dPe.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dMe = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.PM() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ay.Ef().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.c(cVar.PM(), arrayList)});
                if (!ao.isEmpty(cVar.aDy())) {
                    TiebaStatic.log(new am("c13194").aA("obj_type", cVar.aDy()).i(ImageViewerConfig.FORUM_ID, FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dPj);
        registerListener(this.dLL);
        if (this.dPg == null) {
            this.dPg = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dKJ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dKJ = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_ad_fragment, (ViewGroup) null);
        this.dPe = new e(this, inflate);
        this.dPe.a(this.bRt);
        this.dPh = new a(this, this.dPe.getListView());
        this.dPh.setOnAdapterItemClickListener(this.dMe);
        if (this.dPf == null) {
            this.dPf = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dPe != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dPi = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aaC();
                            return;
                        }
                        FrsADFragment.this.aaZ();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dPe != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dPi = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aaC();
                            return;
                        }
                        FrsADFragment.this.aaZ();
                    }
                }
            };
        }
        this.dPg.a(this.dPf);
        if (!com.baidu.adp.lib.util.j.kV()) {
            aaZ();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaC() {
        if (this.dPe != null) {
            hideLoadingView();
            if (this.RJ == 0) {
                if (!v.I(this.dPi)) {
                    D(true, false);
                    this.dPe.abc();
                    return;
                }
                showEmptyView();
            } else if (this.RJ == 2) {
                this.dPe.di(false);
                if (!v.I(this.dPi)) {
                    D(true, false);
                    this.dPe.abc();
                    return;
                }
                showEmptyView();
            } else if (this.RJ == 1) {
                if (!v.I(this.dPi)) {
                    D(false, true);
                } else {
                    this.dPe.abc();
                }
            }
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.dpB != null) {
            if (z) {
                this.dpB.clear();
            }
            if (z2) {
                for (int i = 0; i < this.dpB.size(); i++) {
                    h hVar = (h) v.d(this.dpB, i);
                    if (hVar instanceof c) {
                        ((c) hVar).gT(false);
                    }
                }
            }
            this.dpB.addAll(this.dPi);
            this.dPe.aDD().setData(this.dpB);
            this.dPe.aDD().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aBh() {
        if (this.dPe != null && this.dPe.getListView() != null) {
            this.dPe.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aaY() {
        if (this.dPe != null) {
            aBh();
            this.dPe.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dPe != null) {
            if (this.dPe != null && this.dPe.getListView() != null) {
                this.dPe.getListView().stopScroll();
            }
            aar();
            if (l.ll() && this.mHasMore) {
                mF(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dPe != null) {
            this.dPe.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mF(int i) {
        if (this.dPg != null) {
            aba();
            this.RJ = i;
            if (i == 0 || i == 2) {
                this.dPg.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dPg.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dPe == null) {
            return null;
        }
        return this.dPe.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.kV()) {
            mF(0);
            showLoadingView();
            return;
        }
        aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dPe.gU(false);
        showLoadingView(this.dPe.aCF(), true, getResources().getDimensionPixelSize(e.C0210e.ds250));
    }

    private void hideLoadingView() {
        this.dPe.gU(true);
        hideLoadingView(this.dPe.aCF());
    }

    private void aar() {
        if (!this.mHasMore) {
            if (v.I(this.dPi)) {
                this.dPe.abd();
                return;
            } else {
                this.dPe.abc();
                return;
            }
        }
        this.dPe.abb();
    }

    private void showEmptyView() {
        if (this.dpB != null && this.dPe != null) {
            this.dpB.add(new m());
            this.dPe.aDD().setData(this.dpB);
            this.dPe.aDD().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaZ() {
        this.dPe.gU(false);
        this.dPe.aDE().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dPe.abd();
        this.dPe.getListView().getData().clear();
        this.dPe.aCu();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.NM();
            this.mRefreshView.gd(getResources().getDimensionPixelSize(e.C0210e.ds_102));
            this.mRefreshView.NK().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.dPe.aCF(), true);
    }

    private void aba() {
        this.dPe.gU(true);
        this.dPe.aDE().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.dettachView(this.dPe.aCF());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            mF(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dPe != null) {
            this.dPe.onDestroy();
        }
        if (this.dPg != null) {
            this.dPg.onDestroy();
        }
        super.onDestroy();
    }
}
