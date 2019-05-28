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
    private String foI;
    private long forumId;
    private ADRequestModel.a ftL;
    private ADRequestModel ftM;
    private a ftN;
    private List<c> ftO;
    private com.baidu.tbadk.m.c ftP;
    private String mFrom;
    private boolean mHasMore;
    protected e ftK = null;
    private int offset = 0;
    public int QN = 0;
    private ArrayList<m> ePx = new ArrayList<>();
    private CustomMessageListener frS = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.ftP != null && FrsADFragment.this.ftP.isViewAttached()) {
                FrsADFragment.this.ftP.kB(num.intValue());
            }
        }
    };
    private final h.c drY = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void en(boolean z) {
            if (FrsADFragment.this.ftK != null) {
                if (j.jS()) {
                    FrsADFragment.this.rx(2);
                    if (v.aa(FrsADFragment.this.ePx)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.ftK.fY(false);
            }
        }
    };
    private CustomMessageListener ftQ = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.ftP != null && FrsADFragment.this.ftP.isViewAttached()) {
                        FrsADFragment.this.rx(0);
                    } else if (FrsADFragment.this.ftK != null) {
                        FrsADFragment.this.ftK.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener fpV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.ftP != null && FrsADFragment.this.ftP.isViewAttached()) {
                        FrsADFragment.this.rx(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.ftK != null) {
                        FrsADFragment.this.ftK.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private s fqq = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.auQ() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aiz().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.d(cVar.auQ(), arrayList)});
                if (!ap.isEmpty(cVar.blX())) {
                    TiebaStatic.log(new am("c13194").bT("obj_type", cVar.blX()).l("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        blU();
    }

    private void blU() {
        if (isPrimary()) {
            if (this.ftP != null && this.ftP.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.frS);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.frS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.ftQ);
        registerListener(this.fpV);
        if (this.ftM == null) {
            this.ftM = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.foI = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.foI = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.ftK = new e(this, inflate);
        this.ftK.setListPullRefreshListener(this.drY);
        this.ftN = new a(this, this.ftK.getListView());
        this.ftN.setOnAdapterItemClickListener(this.fqq);
        if (this.ftL == null) {
            this.ftL = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.ftK != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.ftO = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aHL();
                            return;
                        }
                        FrsADFragment.this.aHJ();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.ftK != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.ftO = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aHL();
                            return;
                        }
                        FrsADFragment.this.aHJ();
                    }
                }
            };
        }
        this.ftM.a(this.ftL);
        if (!j.jS()) {
            aHJ();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHL() {
        if (this.ftK != null) {
            hideLoadingView();
            if (this.QN == 0) {
                if (!v.aa(this.ftO)) {
                    G(true, false);
                    this.ftK.aII();
                    return;
                }
                showEmptyView();
            } else if (this.QN == 2) {
                this.ftK.fY(false);
                if (!v.aa(this.ftO)) {
                    G(true, false);
                    this.ftK.aII();
                    return;
                }
                showEmptyView();
            } else if (this.QN == 1) {
                if (!v.aa(this.ftO)) {
                    G(false, true);
                } else {
                    this.ftK.aII();
                }
            }
        }
    }

    private void G(boolean z, boolean z2) {
        if (this.ePx != null) {
            if (z) {
                this.ePx.clear();
            }
            if (z2) {
                for (int i = 0; i < this.ePx.size(); i++) {
                    m mVar = (m) v.c(this.ePx, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ke(false);
                    }
                }
            }
            this.ePx.addAll(this.ftO);
            this.ftK.bmc().setData(this.ePx);
            this.ftK.bmc().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        if (this.ftK != null && this.ftK.getListView() != null) {
            this.ftK.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aIG() {
        if (this.ftK != null) {
            bjy();
            this.ftK.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ftK != null) {
            if (this.ftK != null && this.ftK.getListView() != null) {
                this.ftK.getListView().stopScroll();
            }
            aHH();
            if (l.ki() && this.mHasMore) {
                rx(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ftK != null) {
            this.ftK.onChangeSkinType(i);
        }
        if (this.ftP != null && this.ftP.isViewAttached()) {
            this.ftP.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx(int i) {
        if (this.ftM != null) {
            aHK();
            this.QN = i;
            if (i == 0 || i == 2) {
                this.ftM.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.ftM.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.ftK == null) {
            return null;
        }
        return this.ftK.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.jS()) {
            rx(0);
            showLoadingView();
            return;
        }
        aHJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new am("c13008").l("fid", this.forumId).P("obj_type", 9).P("obj_locate", 2).bT("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.ftK.kf(false);
        showLoadingView(this.ftK.bld(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.ftK.kf(true);
        hideLoadingView(this.ftK.bld());
    }

    private void aHH() {
        if (!this.mHasMore) {
            if (v.aa(this.ftO)) {
                this.ftK.aIJ();
                return;
            } else {
                this.ftK.aII();
                return;
            }
        }
        this.ftK.aIH();
    }

    private void showEmptyView() {
        if (this.ePx != null && this.ftK != null) {
            this.ePx.add(new com.baidu.tieba.frs.m());
            this.ftK.bmc().setData(this.ePx);
            this.ftK.bmc().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHJ() {
        this.ftK.kf(false);
        this.ftK.bmd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.ftK.aIJ();
        this.ftK.getListView().getData().clear();
        this.ftK.bkQ();
        if (this.ftP == null) {
            this.ftP = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.ftP.setTitle(null);
            this.ftP.qx(null);
            this.ftP.setButtonText(null);
            this.ftP.asB();
            this.ftP.asC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.ftP.onChangeSkinType();
        this.ftP.attachView(this.ftK.bld(), true);
        MessageManager.getInstance().registerListener(this.frS);
    }

    private void aHK() {
        this.ftK.kf(true);
        this.ftK.bmd().setEnabled(true);
        if (this.ftP != null && this.ftP.isViewAttached()) {
            this.ftP.dettachView(this.ftK.bld());
            MessageManager.getInstance().unRegisterListener(this.frS);
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
        MessageManager.getInstance().unRegisterListener(this.frS);
        if (this.ftK != null) {
            this.ftK.onDestroy();
        }
        if (this.ftM != null) {
            this.ftM.onDestroy();
        }
        super.onDestroy();
    }
}
