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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    private String foH;
    private long forumId;
    private ADRequestModel.a ftK;
    private ADRequestModel ftL;
    private a ftM;
    private List<c> ftN;
    private com.baidu.tbadk.m.c ftO;
    private String mFrom;
    private boolean mHasMore;
    protected e ftJ = null;
    private int offset = 0;
    public int QN = 0;
    private ArrayList<m> ePw = new ArrayList<>();
    private CustomMessageListener frR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.ftO != null && FrsADFragment.this.ftO.isViewAttached()) {
                FrsADFragment.this.ftO.kB(num.intValue());
            }
        }
    };
    private final h.c drX = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (FrsADFragment.this.ftJ != null) {
                if (j.jS()) {
                    FrsADFragment.this.rx(2);
                    if (v.aa(FrsADFragment.this.ePw)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.ftJ.fY(false);
            }
        }
    };
    private CustomMessageListener ftP = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.ftO != null && FrsADFragment.this.ftO.isViewAttached()) {
                        FrsADFragment.this.rx(0);
                    } else if (FrsADFragment.this.ftJ != null) {
                        FrsADFragment.this.ftJ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener fpU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.ftO != null && FrsADFragment.this.ftO.isViewAttached()) {
                        FrsADFragment.this.rx(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.ftJ != null) {
                        FrsADFragment.this.ftJ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private s fqp = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.auQ() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aiz().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.d(cVar.auQ(), arrayList)});
                if (!ap.isEmpty(cVar.blU())) {
                    TiebaStatic.log(new am("c13194").bT("obj_type", cVar.blU()).l("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        blR();
    }

    private void blR() {
        if (isPrimary()) {
            if (this.ftO != null && this.ftO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.frR);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.frR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.ftP);
        registerListener(this.fpU);
        if (this.ftL == null) {
            this.ftL = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.foH = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.foH = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.ftJ = new e(this, inflate);
        this.ftJ.setListPullRefreshListener(this.drX);
        this.ftM = new a(this, this.ftJ.getListView());
        this.ftM.setOnAdapterItemClickListener(this.fqp);
        if (this.ftK == null) {
            this.ftK = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.ftJ != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.ftN = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aHI();
                            return;
                        }
                        FrsADFragment.this.aHG();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.ftJ != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.ftN = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aHI();
                            return;
                        }
                        FrsADFragment.this.aHG();
                    }
                }
            };
        }
        this.ftL.a(this.ftK);
        if (!j.jS()) {
            aHG();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHI() {
        if (this.ftJ != null) {
            hideLoadingView();
            if (this.QN == 0) {
                if (!v.aa(this.ftN)) {
                    G(true, false);
                    this.ftJ.aIF();
                    return;
                }
                showEmptyView();
            } else if (this.QN == 2) {
                this.ftJ.fY(false);
                if (!v.aa(this.ftN)) {
                    G(true, false);
                    this.ftJ.aIF();
                    return;
                }
                showEmptyView();
            } else if (this.QN == 1) {
                if (!v.aa(this.ftN)) {
                    G(false, true);
                } else {
                    this.ftJ.aIF();
                }
            }
        }
    }

    private void G(boolean z, boolean z2) {
        if (this.ePw != null) {
            if (z) {
                this.ePw.clear();
            }
            if (z2) {
                for (int i = 0; i < this.ePw.size(); i++) {
                    m mVar = (m) v.c(this.ePw, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ke(false);
                    }
                }
            }
            this.ePw.addAll(this.ftN);
            this.ftJ.blZ().setData(this.ePw);
            this.ftJ.blZ().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjv() {
        if (this.ftJ != null && this.ftJ.getListView() != null) {
            this.ftJ.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aID() {
        if (this.ftJ != null) {
            bjv();
            this.ftJ.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ftJ != null) {
            if (this.ftJ != null && this.ftJ.getListView() != null) {
                this.ftJ.getListView().stopScroll();
            }
            aHE();
            if (l.ki() && this.mHasMore) {
                rx(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ftJ != null) {
            this.ftJ.onChangeSkinType(i);
        }
        if (this.ftO != null && this.ftO.isViewAttached()) {
            this.ftO.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx(int i) {
        if (this.ftL != null) {
            aHH();
            this.QN = i;
            if (i == 0 || i == 2) {
                this.ftL.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.ftL.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.ftJ == null) {
            return null;
        }
        return this.ftJ.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.jS()) {
            rx(0);
            showLoadingView();
            return;
        }
        aHG();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new am("c13008").l("fid", this.forumId).P("obj_type", 9).P("obj_locate", 2).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.ftJ.kf(false);
        showLoadingView(this.ftJ.bla(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.ftJ.kf(true);
        hideLoadingView(this.ftJ.bla());
    }

    private void aHE() {
        if (!this.mHasMore) {
            if (v.aa(this.ftN)) {
                this.ftJ.aIG();
                return;
            } else {
                this.ftJ.aIF();
                return;
            }
        }
        this.ftJ.aIE();
    }

    private void showEmptyView() {
        if (this.ePw != null && this.ftJ != null) {
            this.ePw.add(new com.baidu.tieba.frs.m());
            this.ftJ.blZ().setData(this.ePw);
            this.ftJ.blZ().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHG() {
        this.ftJ.kf(false);
        this.ftJ.bma().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.ftJ.aIG();
        this.ftJ.getListView().getData().clear();
        this.ftJ.bkN();
        if (this.ftO == null) {
            this.ftO = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.ftO.setTitle(null);
            this.ftO.qx(null);
            this.ftO.setButtonText(null);
            this.ftO.asB();
            this.ftO.asC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.ftO.onChangeSkinType();
        this.ftO.attachView(this.ftJ.bla(), true);
        MessageManager.getInstance().registerListener(this.frR);
    }

    private void aHH() {
        this.ftJ.kf(true);
        this.ftJ.bma().setEnabled(true);
        if (this.ftO != null && this.ftO.isViewAttached()) {
            this.ftO.dettachView(this.ftJ.bla());
            MessageManager.getInstance().unRegisterListener(this.frR);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jS()) {
            rx(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.frR);
        if (this.ftJ != null) {
            this.ftJ.onDestroy();
        }
        if (this.ftL != null) {
            this.ftL.onDestroy();
        }
        super.onDestroy();
    }
}
