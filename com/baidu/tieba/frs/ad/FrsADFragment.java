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
    private String dBw;
    private ADRequestModel.a dFS;
    private ADRequestModel dFT;
    private a dFU;
    private List<c> dFV;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dFR = null;
    private int offset = 0;
    public int RJ = 0;
    private ArrayList<h> dgc = new ArrayList<>();
    private final j.b bNz = new j.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bG(boolean z) {
            if (FrsADFragment.this.dFR != null) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    FrsADFragment.this.mc(2);
                    if (v.I(FrsADFragment.this.dgc)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dFR.dh(false);
            }
        }
    };
    private CustomMessageListener dFW = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
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
                        FrsADFragment.this.mc(0);
                    } else if (FrsADFragment.this.dFR != null) {
                        FrsADFragment.this.dFR.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dCy = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
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
                        FrsADFragment.this.mc(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dFR != null) {
                        FrsADFragment.this.dFR.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dCR = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.OE() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ay.Db().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.c(cVar.OE(), arrayList)});
                if (!ao.isEmpty(cVar.aAZ())) {
                    TiebaStatic.log(new am("c13194").ax("obj_type", cVar.aAZ()).h(ImageViewerConfig.FORUM_ID, FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dFW);
        registerListener(this.dCy);
        if (this.dFT == null) {
            this.dFT = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dBw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dBw = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_ad_fragment, (ViewGroup) null);
        this.dFR = new e(this, inflate);
        this.dFR.a(this.bNz);
        this.dFU = new a(this, this.dFR.getListView());
        this.dFU.setOnAdapterItemClickListener(this.dCR);
        if (this.dFS == null) {
            this.dFS = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dFR != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dFV = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Zu();
                            return;
                        }
                        FrsADFragment.this.ZR();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dFR != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dFV = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Zu();
                            return;
                        }
                        FrsADFragment.this.ZR();
                    }
                }
            };
        }
        this.dFT.a(this.dFS);
        if (!com.baidu.adp.lib.util.j.kV()) {
            ZR();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zu() {
        if (this.dFR != null) {
            hideLoadingView();
            if (this.RJ == 0) {
                if (!v.I(this.dFV)) {
                    D(true, false);
                    this.dFR.ZU();
                    return;
                }
                showEmptyView();
            } else if (this.RJ == 2) {
                this.dFR.dh(false);
                if (!v.I(this.dFV)) {
                    D(true, false);
                    this.dFR.ZU();
                    return;
                }
                showEmptyView();
            } else if (this.RJ == 1) {
                if (!v.I(this.dFV)) {
                    D(false, true);
                } else {
                    this.dFR.ZU();
                }
            }
        }
    }

    private void D(boolean z, boolean z2) {
        if (this.dgc != null) {
            if (z) {
                this.dgc.clear();
            }
            if (z2) {
                for (int i = 0; i < this.dgc.size(); i++) {
                    h hVar = (h) v.d(this.dgc, i);
                    if (hVar instanceof c) {
                        ((c) hVar).gP(false);
                    }
                }
            }
            this.dgc.addAll(this.dFV);
            this.dFR.aBe().setData(this.dgc);
            this.dFR.aBe().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void ayI() {
        if (this.dFR != null && this.dFR.getListView() != null) {
            this.dFR.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void ZQ() {
        if (this.dFR != null) {
            ayI();
            this.dFR.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dFR != null) {
            if (this.dFR != null && this.dFR.getListView() != null) {
                this.dFR.getListView().stopScroll();
            }
            Zj();
            if (l.lm() && this.mHasMore) {
                mc(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dFR != null) {
            this.dFR.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(int i) {
        if (this.dFT != null) {
            ZS();
            this.RJ = i;
            if (i == 0 || i == 2) {
                this.dFT.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dFT.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dFR == null) {
            return null;
        }
        return this.dFR.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.kV()) {
            mc(0);
            showLoadingView();
            return;
        }
        ZR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dFR.gQ(false);
        showLoadingView(this.dFR.aAg(), true, getResources().getDimensionPixelSize(e.C0200e.ds250));
    }

    private void hideLoadingView() {
        this.dFR.gQ(true);
        hideLoadingView(this.dFR.aAg());
    }

    private void Zj() {
        if (!this.mHasMore) {
            if (v.I(this.dFV)) {
                this.dFR.ZV();
                return;
            } else {
                this.dFR.ZU();
                return;
            }
        }
        this.dFR.ZT();
    }

    private void showEmptyView() {
        if (this.dgc != null && this.dFR != null) {
            this.dgc.add(new m());
            this.dFR.aBe().setData(this.dgc);
            this.dFR.aBe().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZR() {
        this.dFR.gQ(false);
        this.dFR.aBf().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dFR.ZV();
        this.dFR.getListView().getData().clear();
        this.dFR.azV();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.MH();
            this.mRefreshView.fO(getResources().getDimensionPixelSize(e.C0200e.ds_102));
            this.mRefreshView.MF().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.attachView(this.dFR.aAg(), true);
    }

    private void ZS() {
        this.dFR.gQ(true);
        this.dFR.aBf().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.isViewAttached()) {
            this.mRefreshView.dettachView(this.dFR.aAg());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            mc(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dFR != null) {
            this.dFR.onDestroy();
        }
        if (this.dFT != null) {
            this.dFT.onDestroy();
        }
        super.onDestroy();
    }
}
