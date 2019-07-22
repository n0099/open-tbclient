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
    private String ftH;
    private ADRequestModel.a fyH;
    private ADRequestModel fyI;
    private a fyJ;
    private List<c> fyK;
    private com.baidu.tbadk.m.c fyL;
    private String mFrom;
    private boolean mHasMore;
    protected e fyG = null;
    private int offset = 0;
    public int Rf = 0;
    private ArrayList<m> eUx = new ArrayList<>();
    private CustomMessageListener fwP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.fyL != null && FrsADFragment.this.fyL.isViewAttached()) {
                FrsADFragment.this.fyL.kH(num.intValue());
            }
        }
    };
    private final h.c duh = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void er(boolean z) {
            if (FrsADFragment.this.fyG != null) {
                if (j.kc()) {
                    FrsADFragment.this.rP(2);
                    if (v.aa(FrsADFragment.this.eUx)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.fyG.gc(false);
            }
        }
    };
    private CustomMessageListener fyM = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fyL != null && FrsADFragment.this.fyL.isViewAttached()) {
                        FrsADFragment.this.rP(0);
                    } else if (FrsADFragment.this.fyG != null) {
                        FrsADFragment.this.fyG.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener fuT = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fyL != null && FrsADFragment.this.fyL.isViewAttached()) {
                        FrsADFragment.this.rP(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.fyG != null) {
                        FrsADFragment.this.fyG.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private s fvo = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.avZ() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bb.ajC().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.d(cVar.avZ(), arrayList)});
                if (!aq.isEmpty(cVar.bnY())) {
                    TiebaStatic.log(new an("c13194").bT("obj_type", cVar.bnY()).l("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bnV();
    }

    private void bnV() {
        if (isPrimary()) {
            if (this.fyL != null && this.fyL.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fwP);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fwP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.fyM);
        registerListener(this.fuT);
        if (this.fyI == null) {
            this.fyI = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.ftH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.ftH = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.fyG = new e(this, inflate);
        this.fyG.setListPullRefreshListener(this.duh);
        this.fyJ = new a(this, this.fyG.getListView());
        this.fyJ.setOnAdapterItemClickListener(this.fvo);
        if (this.fyH == null) {
            this.fyH = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.fyG != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.fyK = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aJi();
                            return;
                        }
                        FrsADFragment.this.aJg();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.fyG != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.fyK = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aJi();
                            return;
                        }
                        FrsADFragment.this.aJg();
                    }
                }
            };
        }
        this.fyI.a(this.fyH);
        if (!j.kc()) {
            aJg();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJi() {
        if (this.fyG != null) {
            hideLoadingView();
            if (this.Rf == 0) {
                if (!v.aa(this.fyK)) {
                    J(true, false);
                    this.fyG.aKj();
                    return;
                }
                showEmptyView();
            } else if (this.Rf == 2) {
                this.fyG.gc(false);
                if (!v.aa(this.fyK)) {
                    J(true, false);
                    this.fyG.aKj();
                    return;
                }
                showEmptyView();
            } else if (this.Rf == 1) {
                if (!v.aa(this.fyK)) {
                    J(false, true);
                } else {
                    this.fyG.aKj();
                }
            }
        }
    }

    private void J(boolean z, boolean z2) {
        if (this.eUx != null) {
            if (z) {
                this.eUx.clear();
            }
            if (z2) {
                for (int i = 0; i < this.eUx.size(); i++) {
                    m mVar = (m) v.c(this.eUx, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ko(false);
                    }
                }
            }
            this.eUx.addAll(this.fyK);
            this.fyG.bod().setData(this.eUx);
            this.fyG.bod().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void blA() {
        if (this.fyG != null && this.fyG.getListView() != null) {
            this.fyG.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        if (this.fyG != null) {
            blA();
            this.fyG.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fyG != null) {
            if (this.fyG != null && this.fyG.getListView() != null) {
                this.fyG.getListView().stopScroll();
            }
            aJe();
            if (l.kt() && this.mHasMore) {
                rP(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fyG != null) {
            this.fyG.onChangeSkinType(i);
        }
        if (this.fyL != null && this.fyL.isViewAttached()) {
            this.fyL.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rP(int i) {
        if (this.fyI != null) {
            aJh();
            this.Rf = i;
            if (i == 0 || i == 2) {
                this.fyI.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.fyI.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.fyG == null) {
            return null;
        }
        return this.fyG.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.kc()) {
            rP(0);
            showLoadingView();
            return;
        }
        aJg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").l("fid", this.forumId).P("obj_type", 9).P("obj_locate", 2).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.fyG.kp(false);
        showLoadingView(this.fyG.aXy(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.fyG.kp(true);
        hideLoadingView(this.fyG.aXy());
    }

    private void aJe() {
        if (!this.mHasMore) {
            if (v.aa(this.fyK)) {
                this.fyG.aKk();
                return;
            } else {
                this.fyG.aKj();
                return;
            }
        }
        this.fyG.aKi();
    }

    private void showEmptyView() {
        if (this.eUx != null && this.fyG != null) {
            this.eUx.add(new com.baidu.tieba.frs.m());
            this.fyG.bod().setData(this.eUx);
            this.fyG.bod().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJg() {
        this.fyG.kp(false);
        this.fyG.boe().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fyG.aKk();
        this.fyG.getListView().getData().clear();
        this.fyG.bmS();
        if (this.fyL == null) {
            this.fyL = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fyL.setTitle(null);
            this.fyL.qN(null);
            this.fyL.setButtonText(null);
            this.fyL.atI();
            this.fyL.atJ().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fyL.onChangeSkinType();
        this.fyL.attachView(this.fyG.aXy(), true);
        MessageManager.getInstance().registerListener(this.fwP);
    }

    private void aJh() {
        this.fyG.kp(true);
        this.fyG.boe().setEnabled(true);
        if (this.fyL != null && this.fyL.isViewAttached()) {
            this.fyL.dettachView(this.fyG.aXy());
            MessageManager.getInstance().unRegisterListener(this.fwP);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            rP(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fwP);
        if (this.fyG != null) {
            this.fyG.onDestroy();
        }
        if (this.fyI != null) {
            this.fyI.onDestroy();
        }
        super.onDestroy();
    }
}
