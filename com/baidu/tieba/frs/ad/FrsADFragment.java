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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, aj {
    private TbPageContext context;
    private String djs;
    private ADRequestModel.a dnw;
    private ADRequestModel dnx;
    private a dny;
    private List<c> dnz;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dnv = null;
    private int offset = 0;
    public int OU = 0;
    private ArrayList<h> cOi = new ArrayList<>();
    private final g.b bxO = new g.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void aU(boolean z) {
            if (FrsADFragment.this.dnv != null) {
                if (j.jD()) {
                    FrsADFragment.this.kz(2);
                    if (w.A(FrsADFragment.this.cOi)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dnv.cp(false);
            }
        }
    };
    private CustomMessageListener dnA = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Jh()) {
                        FrsADFragment.this.kz(0);
                    } else if (FrsADFragment.this.dnv != null) {
                        FrsADFragment.this.dnv.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dku = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Jh()) {
                        FrsADFragment.this.kz(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dnv != null) {
                        FrsADFragment.this.dnv.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dkN = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.Lh() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                az.zV().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.b(cVar.Lh(), arrayList)});
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dnA);
        registerListener(this.dku);
        if (this.dnx == null) {
            this.dnx = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.djs = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.djs = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_ad_fragment, (ViewGroup) null);
        this.dnv = new e(this, inflate);
        this.dnv.a(this.bxO);
        this.dny = new a(this, this.dnv.getListView());
        this.dny.setOnAdapterItemClickListener(this.dkN);
        if (this.dnw == null) {
            this.dnw = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dnv != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dnz = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.TE();
                            return;
                        }
                        FrsADFragment.this.Ub();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dnv != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dnz = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.TE();
                            return;
                        }
                        FrsADFragment.this.Ub();
                    }
                }
            };
        }
        this.dnx.a(this.dnw);
        if (!j.jD()) {
            Ub();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TE() {
        if (this.dnv != null) {
            hideLoadingView();
            if (this.OU == 0) {
                if (!w.A(this.dnz)) {
                    y(true, false);
                    this.dnv.Ue();
                    return;
                }
                showEmptyView();
            } else if (this.OU == 2) {
                this.dnv.cp(false);
                if (!w.A(this.dnz)) {
                    y(true, false);
                    this.dnv.Ue();
                    return;
                }
                showEmptyView();
            } else if (this.OU == 1) {
                if (!w.A(this.dnz)) {
                    y(false, true);
                } else {
                    this.dnv.Ue();
                }
            }
        }
    }

    private void y(boolean z, boolean z2) {
        if (this.cOi != null) {
            if (z) {
                this.cOi.clear();
            }
            if (z2) {
                for (int i = 0; i < this.cOi.size(); i++) {
                    h hVar = (h) w.d(this.cOi, i);
                    if (hVar instanceof c) {
                        ((c) hVar).fO(false);
                    }
                }
            }
            this.cOi.addAll(this.dnz);
            this.dnv.avw().setData(this.cOi);
            this.dnv.avw().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void atu() {
        if (this.dnv != null && this.dnv.getListView() != null) {
            this.dnv.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ua() {
        if (this.dnv != null) {
            atu();
            this.dnv.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dnv != null) {
            if (this.dnv != null && this.dnv.getListView() != null) {
                this.dnv.getListView().stopScroll();
            }
            Tt();
            if (l.jU() && this.mHasMore) {
                kz(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dnv != null) {
            this.dnv.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kz(int i) {
        if (this.dnx != null) {
            Uc();
            this.OU = i;
            if (i == 0 || i == 2) {
                this.dnx.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dnx.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dnv == null) {
            return null;
        }
        return this.dnv.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.jD()) {
            kz(0);
            showLoadingView();
            return;
        }
        Ub();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dnv.fP(false);
        showLoadingView(this.dnv.avx(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    private void hideLoadingView() {
        this.dnv.fP(true);
        hideLoadingView(this.dnv.avx());
    }

    private void Tt() {
        if (!this.mHasMore) {
            if (w.A(this.dnz)) {
                this.dnv.Uf();
                return;
            } else {
                this.dnv.Ue();
                return;
            }
        }
        this.dnv.Ud();
    }

    private void showEmptyView() {
        if (this.cOi != null && this.dnv != null) {
            this.cOi.add(new m());
            this.dnv.avw().setData(this.cOi);
            this.dnv.avw().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ub() {
        this.dnv.fP(false);
        this.dnv.avy().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dnv.Uf();
        this.dnv.getListView().getData().clear();
        this.dnv.auG();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jp();
            this.mRefreshView.ff(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Jn().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.dnv.avx(), true);
    }

    private void Uc() {
        this.dnv.fP(true);
        this.dnv.avy().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jh()) {
            this.mRefreshView.Q(this.dnv.avx());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jD()) {
            kz(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dnv != null) {
            this.dnv.onDestroy();
        }
        super.onDestroy();
    }
}
