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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
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
    private String dmi;
    private ADRequestModel.a dqp;
    private ADRequestModel dqq;
    private a dqr;
    private List<c> dqs;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dqo = null;
    private int offset = 0;
    public int OQ = 0;
    private ArrayList<h> cQR = new ArrayList<>();
    private final g.b byt = new g.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void aS(boolean z) {
            if (FrsADFragment.this.dqo != null) {
                if (j.jE()) {
                    FrsADFragment.this.kK(2);
                    if (w.z(FrsADFragment.this.cQR)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dqo.cp(false);
            }
        }
    };
    private CustomMessageListener dqt = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Jc()) {
                        FrsADFragment.this.kK(0);
                    } else if (FrsADFragment.this.dqo != null) {
                        FrsADFragment.this.dqo.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dnk = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Jc()) {
                        FrsADFragment.this.kK(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dqo != null) {
                        FrsADFragment.this.dqo.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dnD = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.Lc() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ay.zK().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.b(cVar.Lc(), arrayList)});
                if (!ap.isEmpty(cVar.avW())) {
                    TiebaStatic.log(new an("c13194").af("obj_type", cVar.avW()));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dqt);
        registerListener(this.dnk);
        if (this.dqq == null) {
            this.dqq = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dmi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dmi = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_ad_fragment, (ViewGroup) null);
        this.dqo = new e(this, inflate);
        this.dqo.a(this.byt);
        this.dqr = new a(this, this.dqo.getListView());
        this.dqr.setOnAdapterItemClickListener(this.dnD);
        if (this.dqp == null) {
            this.dqp = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dqo != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dqs = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.TM();
                            return;
                        }
                        FrsADFragment.this.Uj();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dqo != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dqs = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.TM();
                            return;
                        }
                        FrsADFragment.this.Uj();
                    }
                }
            };
        }
        this.dqq.a(this.dqp);
        if (!j.jE()) {
            Uj();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TM() {
        if (this.dqo != null) {
            hideLoadingView();
            if (this.OQ == 0) {
                if (!w.z(this.dqs)) {
                    y(true, false);
                    this.dqo.Um();
                    return;
                }
                showEmptyView();
            } else if (this.OQ == 2) {
                this.dqo.cp(false);
                if (!w.z(this.dqs)) {
                    y(true, false);
                    this.dqo.Um();
                    return;
                }
                showEmptyView();
            } else if (this.OQ == 1) {
                if (!w.z(this.dqs)) {
                    y(false, true);
                } else {
                    this.dqo.Um();
                }
            }
        }
    }

    private void y(boolean z, boolean z2) {
        if (this.cQR != null) {
            if (z) {
                this.cQR.clear();
            }
            if (z2) {
                for (int i = 0; i < this.cQR.size(); i++) {
                    h hVar = (h) w.d(this.cQR, i);
                    if (hVar instanceof c) {
                        ((c) hVar).fQ(false);
                    }
                }
            }
            this.cQR.addAll(this.dqs);
            this.dqo.awb().setData(this.cQR);
            this.dqo.awb().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void atY() {
        if (this.dqo != null && this.dqo.getListView() != null) {
            this.dqo.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ui() {
        if (this.dqo != null) {
            atY();
            this.dqo.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dqo != null) {
            if (this.dqo != null && this.dqo.getListView() != null) {
                this.dqo.getListView().stopScroll();
            }
            TB();
            if (l.jV() && this.mHasMore) {
                kK(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dqo != null) {
            this.dqo.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(int i) {
        if (this.dqq != null) {
            Uk();
            this.OQ = i;
            if (i == 0 || i == 2) {
                this.dqq.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dqq.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dqo == null) {
            return null;
        }
        return this.dqo.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.jE()) {
            kK(0);
            showLoadingView();
            return;
        }
        Uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dqo.fR(false);
        showLoadingView(this.dqo.awc(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    private void hideLoadingView() {
        this.dqo.fR(true);
        hideLoadingView(this.dqo.awc());
    }

    private void TB() {
        if (!this.mHasMore) {
            if (w.z(this.dqs)) {
                this.dqo.Un();
                return;
            } else {
                this.dqo.Um();
                return;
            }
        }
        this.dqo.Ul();
    }

    private void showEmptyView() {
        if (this.cQR != null && this.dqo != null) {
            this.cQR.add(new m());
            this.dqo.awb().setData(this.cQR);
            this.dqo.awb().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uj() {
        this.dqo.fR(false);
        this.dqo.awd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dqo.Un();
        this.dqo.getListView().getData().clear();
        this.dqo.avk();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jk();
            this.mRefreshView.fg(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Ji().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dqo.awc(), true);
    }

    private void Uk() {
        this.dqo.fR(true);
        this.dqo.awd().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jc()) {
            this.mRefreshView.Q(this.dqo.awc());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jE()) {
            kK(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dqo != null) {
            this.dqo.onDestroy();
        }
        if (this.dqq != null) {
            this.dqq.onDestroy();
        }
        super.onDestroy();
    }
}
