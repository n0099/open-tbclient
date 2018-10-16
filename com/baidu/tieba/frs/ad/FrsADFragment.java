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
    private String dAf;
    private ADRequestModel.a dEC;
    private ADRequestModel dED;
    private a dEE;
    private List<c> dEF;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dEB = null;
    private int offset = 0;
    public int RH = 0;
    private ArrayList<h> deX = new ArrayList<>();
    private final j.b bMO = new j.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bp(boolean z) {
            if (FrsADFragment.this.dEB != null) {
                if (com.baidu.adp.lib.util.j.kX()) {
                    FrsADFragment.this.lK(2);
                    if (v.J(FrsADFragment.this.deX)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dEB.cQ(false);
            }
        }
    };
    private CustomMessageListener dEG = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Mq()) {
                        FrsADFragment.this.lK(0);
                    } else if (FrsADFragment.this.dEB != null) {
                        FrsADFragment.this.dEB.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dBh = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Mq()) {
                        FrsADFragment.this.lK(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dEB != null) {
                        FrsADFragment.this.dEB.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dBA = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.Ov() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ay.CU().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.c(cVar.Ov(), arrayList)});
                if (!ao.isEmpty(cVar.aBB())) {
                    TiebaStatic.log(new am("c13194").ax("obj_type", cVar.aBB()).h(ImageViewerConfig.FORUM_ID, FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dEG);
        registerListener(this.dBh);
        if (this.dED == null) {
            this.dED = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dAf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dAf = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_ad_fragment, (ViewGroup) null);
        this.dEB = new e(this, inflate);
        this.dEB.a(this.bMO);
        this.dEE = new a(this, this.dEB.getListView());
        this.dEE.setOnAdapterItemClickListener(this.dBA);
        if (this.dEC == null) {
            this.dEC = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dEB != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dEF = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Zj();
                            return;
                        }
                        FrsADFragment.this.ZG();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dEB != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dEF = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Zj();
                            return;
                        }
                        FrsADFragment.this.ZG();
                    }
                }
            };
        }
        this.dED.a(this.dEC);
        if (!com.baidu.adp.lib.util.j.kX()) {
            ZG();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zj() {
        if (this.dEB != null) {
            hideLoadingView();
            if (this.RH == 0) {
                if (!v.J(this.dEF)) {
                    B(true, false);
                    this.dEB.ZJ();
                    return;
                }
                showEmptyView();
            } else if (this.RH == 2) {
                this.dEB.cQ(false);
                if (!v.J(this.dEF)) {
                    B(true, false);
                    this.dEB.ZJ();
                    return;
                }
                showEmptyView();
            } else if (this.RH == 1) {
                if (!v.J(this.dEF)) {
                    B(false, true);
                } else {
                    this.dEB.ZJ();
                }
            }
        }
    }

    private void B(boolean z, boolean z2) {
        if (this.deX != null) {
            if (z) {
                this.deX.clear();
            }
            if (z2) {
                for (int i = 0; i < this.deX.size(); i++) {
                    h hVar = (h) v.d(this.deX, i);
                    if (hVar instanceof c) {
                        ((c) hVar).gF(false);
                    }
                }
            }
            this.deX.addAll(this.dEF);
            this.dEB.aBG().setData(this.deX);
            this.dEB.aBG().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void azk() {
        if (this.dEB != null && this.dEB.getListView() != null) {
            this.dEB.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void ZF() {
        if (this.dEB != null) {
            azk();
            this.dEB.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dEB != null) {
            if (this.dEB != null && this.dEB.getListView() != null) {
                this.dEB.getListView().stopScroll();
            }
            YY();
            if (l.lo() && this.mHasMore) {
                lK(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dEB != null) {
            this.dEB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lK(int i) {
        if (this.dED != null) {
            ZH();
            this.RH = i;
            if (i == 0 || i == 2) {
                this.dED.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dED.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dEB == null) {
            return null;
        }
        return this.dEB.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.kX()) {
            lK(0);
            showLoadingView();
            return;
        }
        ZG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dEB.gG(false);
        showLoadingView(this.dEB.aAI(), true, getResources().getDimensionPixelSize(e.C0175e.ds250));
    }

    private void hideLoadingView() {
        this.dEB.gG(true);
        hideLoadingView(this.dEB.aAI());
    }

    private void YY() {
        if (!this.mHasMore) {
            if (v.J(this.dEF)) {
                this.dEB.ZK();
                return;
            } else {
                this.dEB.ZJ();
                return;
            }
        }
        this.dEB.ZI();
    }

    private void showEmptyView() {
        if (this.deX != null && this.dEB != null) {
            this.deX.add(new m());
            this.dEB.aBG().setData(this.deX);
            this.dEB.aBG().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZG() {
        this.dEB.gG(false);
        this.dEB.aBH().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dEB.ZK();
        this.dEB.getListView().getData().clear();
        this.dEB.aAx();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.My();
            this.mRefreshView.fA(getResources().getDimensionPixelSize(e.C0175e.ds_102));
            this.mRefreshView.Mw().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dEB.aAI(), true);
    }

    private void ZH() {
        this.dEB.gG(true);
        this.dEB.aBH().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Mq()) {
            this.mRefreshView.ad(this.dEB.aAI());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kX()) {
            lK(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dEB != null) {
            this.dEB.onDestroy();
        }
        if (this.dED != null) {
            this.dED.onDestroy();
        }
        super.onDestroy();
    }
}
