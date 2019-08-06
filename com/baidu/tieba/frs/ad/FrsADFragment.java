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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ag {
    private TbPageContext context;
    private long forumId;
    private String fug;
    private ADRequestModel.a fzg;
    private ADRequestModel fzh;
    private a fzi;
    private List<c> fzj;
    private com.baidu.tbadk.m.c fzk;
    private String mFrom;
    private boolean mHasMore;
    protected e fzf = null;
    private int offset = 0;
    public int Rf = 0;
    private ArrayList<m> eUE = new ArrayList<>();
    private CustomMessageListener fxo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.fzk != null && FrsADFragment.this.fzk.isViewAttached()) {
                FrsADFragment.this.fzk.kI(num.intValue());
            }
        }
    };
    private final h.c duo = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (FrsADFragment.this.fzf != null) {
                if (j.kc()) {
                    FrsADFragment.this.rR(2);
                    if (v.aa(FrsADFragment.this.eUE)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.fzf.gc(false);
            }
        }
    };
    private CustomMessageListener fzl = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fzk != null && FrsADFragment.this.fzk.isViewAttached()) {
                        FrsADFragment.this.rR(0);
                    } else if (FrsADFragment.this.fzf != null) {
                        FrsADFragment.this.fzf.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener fvs = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fzk != null && FrsADFragment.this.fzk.isViewAttached()) {
                        FrsADFragment.this.rR(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.fzf != null) {
                        FrsADFragment.this.fzf.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private s fvN = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.awb() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bb.ajE().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.d(cVar.awb(), arrayList)});
                if (!aq.isEmpty(cVar.boi())) {
                    TiebaStatic.log(new an("c13194").bT("obj_type", cVar.boi()).l("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bof();
    }

    private void bof() {
        if (isPrimary()) {
            if (this.fzk != null && this.fzk.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fxo);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fxo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.fzl);
        registerListener(this.fvs);
        if (this.fzh == null) {
            this.fzh = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.fug = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fug = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.fzf = new e(this, inflate);
        this.fzf.setListPullRefreshListener(this.duo);
        this.fzi = new a(this, this.fzf.getListView());
        this.fzi.setOnAdapterItemClickListener(this.fvN);
        if (this.fzg == null) {
            this.fzg = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.fzf != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.fzj = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aJk();
                            return;
                        }
                        FrsADFragment.this.aJi();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.fzf != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.fzj = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aJk();
                            return;
                        }
                        FrsADFragment.this.aJi();
                    }
                }
            };
        }
        this.fzh.a(this.fzg);
        if (!j.kc()) {
            aJi();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJk() {
        if (this.fzf != null) {
            hideLoadingView();
            if (this.Rf == 0) {
                if (!v.aa(this.fzj)) {
                    J(true, false);
                    this.fzf.aKl();
                    return;
                }
                showEmptyView();
            } else if (this.Rf == 2) {
                this.fzf.gc(false);
                if (!v.aa(this.fzj)) {
                    J(true, false);
                    this.fzf.aKl();
                    return;
                }
                showEmptyView();
            } else if (this.Rf == 1) {
                if (!v.aa(this.fzj)) {
                    J(false, true);
                } else {
                    this.fzf.aKl();
                }
            }
        }
    }

    private void J(boolean z, boolean z2) {
        if (this.eUE != null) {
            if (z) {
                this.eUE.clear();
            }
            if (z2) {
                for (int i = 0; i < this.eUE.size(); i++) {
                    m mVar = (m) v.c(this.eUE, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ko(false);
                    }
                }
            }
            this.eUE.addAll(this.fzj);
            this.fzf.boo().setData(this.eUE);
            this.fzf.boo().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void blH() {
        if (this.fzf != null && this.fzf.getListView() != null) {
            this.fzf.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKj() {
        if (this.fzf != null) {
            blH();
            this.fzf.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fzf != null) {
            if (this.fzf != null && this.fzf.getListView() != null) {
                this.fzf.getListView().stopScroll();
            }
            aJg();
            if (l.kt() && this.mHasMore) {
                rR(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fzf != null) {
            this.fzf.onChangeSkinType(i);
        }
        if (this.fzk != null && this.fzk.isViewAttached()) {
            this.fzk.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(int i) {
        if (this.fzh != null) {
            aJj();
            this.Rf = i;
            if (i == 0 || i == 2) {
                this.fzh.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.fzh.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.fzf == null) {
            return null;
        }
        return this.fzf.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.kc()) {
            rR(0);
            showLoadingView();
            return;
        }
        aJi();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").l("fid", this.forumId).P("obj_type", 9).P("obj_locate", 2).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.fzf.kp(false);
        showLoadingView(this.fzf.aXA(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.fzf.kp(true);
        hideLoadingView(this.fzf.aXA());
    }

    private void aJg() {
        if (!this.mHasMore) {
            if (v.aa(this.fzj)) {
                this.fzf.aKm();
                return;
            } else {
                this.fzf.aKl();
                return;
            }
        }
        this.fzf.aKk();
    }

    private void showEmptyView() {
        if (this.eUE != null && this.fzf != null) {
            this.eUE.add(new com.baidu.tieba.frs.m());
            this.fzf.boo().setData(this.eUE);
            this.fzf.boo().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJi() {
        this.fzf.kp(false);
        this.fzf.bop().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fzf.aKm();
        this.fzf.getListView().getData().clear();
        this.fzf.bnc();
        if (this.fzk == null) {
            this.fzk = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fzk.setTitle(null);
            this.fzk.qN(null);
            this.fzk.setButtonText(null);
            this.fzk.atK();
            this.fzk.atL().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fzk.onChangeSkinType();
        this.fzk.attachView(this.fzf.aXA(), true);
        MessageManager.getInstance().registerListener(this.fxo);
    }

    private void aJj() {
        this.fzf.kp(true);
        this.fzf.bop().setEnabled(true);
        if (this.fzk != null && this.fzk.isViewAttached()) {
            this.fzk.dettachView(this.fzf.aXA());
            MessageManager.getInstance().unRegisterListener(this.fxo);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            rR(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fxo);
        if (this.fzf != null) {
            this.fzf.onDestroy();
        }
        if (this.fzh != null) {
            this.fzh.onDestroy();
        }
        super.onDestroy();
    }
}
