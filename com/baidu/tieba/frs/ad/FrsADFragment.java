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
import com.baidu.tbadk.core.util.ba;
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
    private ADRequestModel.a fAT;
    private ADRequestModel fAU;
    private a fAV;
    private List<c> fAW;
    private com.baidu.tbadk.m.c fAX;
    private long forumId;
    private String fvT;
    private String mFrom;
    private boolean mHasMore;
    protected e fAS = null;
    private int offset = 0;
    public int Re = 0;
    private ArrayList<m> eWk = new ArrayList<>();
    private CustomMessageListener fzb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.fAX != null && FrsADFragment.this.fAX.isViewAttached()) {
                FrsADFragment.this.fAX.kL(num.intValue());
            }
        }
    };
    private final h.c dvZ = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void eu(boolean z) {
            if (FrsADFragment.this.fAS != null) {
                if (j.kc()) {
                    FrsADFragment.this.rU(2);
                    if (v.aa(FrsADFragment.this.eWk)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.fAS.gf(false);
            }
        }
    };
    private CustomMessageListener fAY = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fAX != null && FrsADFragment.this.fAX.isViewAttached()) {
                        FrsADFragment.this.rU(0);
                    } else if (FrsADFragment.this.fAS != null) {
                        FrsADFragment.this.fAS.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener fxf = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fAX != null && FrsADFragment.this.fAX.isViewAttached()) {
                        FrsADFragment.this.rU(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.fAS != null) {
                        FrsADFragment.this.fAS.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private s fxA = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.awn() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.ajK().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.c(cVar.awn(), arrayList)});
                if (!aq.isEmpty(cVar.boT())) {
                    TiebaStatic.log(new an("c13194").bT("obj_type", cVar.boT()).n("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        boQ();
    }

    private void boQ() {
        if (isPrimary()) {
            if (this.fAX != null && this.fAX.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fzb);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fzb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.fAY);
        registerListener(this.fxf);
        if (this.fAU == null) {
            this.fAU = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.fvT = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fvT = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.fAS = new e(this, inflate);
        this.fAS.setListPullRefreshListener(this.dvZ);
        this.fAV = new a(this, this.fAS.getListView());
        this.fAV.setOnAdapterItemClickListener(this.fxA);
        if (this.fAT == null) {
            this.fAT = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.fAS != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.fAW = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aJO();
                            return;
                        }
                        FrsADFragment.this.aJM();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.fAS != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.fAW = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aJO();
                            return;
                        }
                        FrsADFragment.this.aJM();
                    }
                }
            };
        }
        this.fAU.a(this.fAT);
        if (!j.kc()) {
            aJM();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJO() {
        if (this.fAS != null) {
            hideLoadingView();
            if (this.Re == 0) {
                if (!v.aa(this.fAW)) {
                    J(true, false);
                    this.fAS.aKP();
                    return;
                }
                showEmptyView();
            } else if (this.Re == 2) {
                this.fAS.gf(false);
                if (!v.aa(this.fAW)) {
                    J(true, false);
                    this.fAS.aKP();
                    return;
                }
                showEmptyView();
            } else if (this.Re == 1) {
                if (!v.aa(this.fAW)) {
                    J(false, true);
                } else {
                    this.fAS.aKP();
                }
            }
        }
    }

    private void J(boolean z, boolean z2) {
        if (this.eWk != null) {
            if (z) {
                this.eWk.clear();
            }
            if (z2) {
                for (int i = 0; i < this.eWk.size(); i++) {
                    m mVar = (m) v.c(this.eWk, i);
                    if (mVar instanceof c) {
                        ((c) mVar).kr(false);
                    }
                }
            }
            this.eWk.addAll(this.fAW);
            this.fAS.boZ().setData(this.eWk);
            this.fAS.boZ().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bms() {
        if (this.fAS != null && this.fAS.getListView() != null) {
            this.fAS.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKN() {
        if (this.fAS != null) {
            bms();
            this.fAS.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fAS != null) {
            if (this.fAS != null && this.fAS.getListView() != null) {
                this.fAS.getListView().stopScroll();
            }
            aJK();
            if (l.kt() && this.mHasMore) {
                rU(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fAS != null) {
            this.fAS.onChangeSkinType(i);
        }
        if (this.fAX != null && this.fAX.isViewAttached()) {
            this.fAX.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU(int i) {
        if (this.fAU != null) {
            aJN();
            this.Re = i;
            if (i == 0 || i == 2) {
                this.fAU.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.fAU.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.fAS == null) {
            return null;
        }
        return this.fAS.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.kc()) {
            rU(0);
            showLoadingView();
            return;
        }
        aJM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").n("fid", this.forumId).P("obj_type", 9).P("obj_locate", 2).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.fAS.ks(false);
        showLoadingView(this.fAS.aYe(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.fAS.ks(true);
        hideLoadingView(this.fAS.aYe());
    }

    private void aJK() {
        if (!this.mHasMore) {
            if (v.aa(this.fAW)) {
                this.fAS.aKQ();
                return;
            } else {
                this.fAS.aKP();
                return;
            }
        }
        this.fAS.aKO();
    }

    private void showEmptyView() {
        if (this.eWk != null && this.fAS != null) {
            this.eWk.add(new com.baidu.tieba.frs.m());
            this.fAS.boZ().setData(this.eWk);
            this.fAS.boZ().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJM() {
        this.fAS.ks(false);
        this.fAS.bpa().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fAS.aKQ();
        this.fAS.getListView().getData().clear();
        this.fAS.bnN();
        if (this.fAX == null) {
            this.fAX = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fAX.setTitle(null);
            this.fAX.qY(null);
            this.fAX.setButtonText(null);
            this.fAX.atW();
            this.fAX.atX().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fAX.onChangeSkinType();
        this.fAX.attachView(this.fAS.aYe(), true);
        MessageManager.getInstance().registerListener(this.fzb);
    }

    private void aJN() {
        this.fAS.ks(true);
        this.fAS.bpa().setEnabled(true);
        if (this.fAX != null && this.fAX.isViewAttached()) {
            this.fAX.dettachView(this.fAS.aYe());
            MessageManager.getInstance().unRegisterListener(this.fzb);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            rU(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fzb);
        if (this.fAS != null) {
            this.fAS.onDestroy();
        }
        if (this.fAU != null) {
            this.fAU.onDestroy();
        }
        super.onDestroy();
    }
}
