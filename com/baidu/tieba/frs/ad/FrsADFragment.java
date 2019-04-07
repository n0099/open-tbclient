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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ag {
    private TbPageContext context;
    private String eYw;
    private com.baidu.tbadk.m.c fdA;
    private ADRequestModel.a fdw;
    private ADRequestModel fdx;
    private a fdy;
    private List<c> fdz;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e fdv = null;
    private int offset = 0;
    public int Td = 0;
    private ArrayList<m> ezS = new ArrayList<>();
    private CustomMessageListener fbC = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.fdA != null && FrsADFragment.this.fdA.isViewAttached()) {
                FrsADFragment.this.fdA.jN(num.intValue());
            }
        }
    };
    private final h.c dht = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (FrsADFragment.this.fdv != null) {
                if (j.kY()) {
                    FrsADFragment.this.qq(2);
                    if (v.T(FrsADFragment.this.ezS)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.fdv.fB(false);
            }
        }
    };
    private CustomMessageListener fdB = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fdA != null && FrsADFragment.this.fdA.isViewAttached()) {
                        FrsADFragment.this.qq(0);
                    } else if (FrsADFragment.this.fdv != null) {
                        FrsADFragment.this.fdv.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener eZG = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fdA != null && FrsADFragment.this.fdA.isViewAttached()) {
                        FrsADFragment.this.qq(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.fdv != null) {
                        FrsADFragment.this.fdv.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private s faa = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.apM() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.adA().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.e(cVar.apM(), arrayList)});
                if (!ap.isEmpty(cVar.beC())) {
                    TiebaStatic.log(new am("c13194").bJ("obj_type", cVar.beC()).k(ImageViewerConfig.FORUM_ID, FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bez();
    }

    private void bez() {
        if (isPrimary()) {
            if (this.fdA != null && this.fdA.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fbC);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fbC);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.fdB);
        registerListener(this.eZG);
        if (this.fdx == null) {
            this.fdx = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.eYw = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eYw = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_ad_fragment, (ViewGroup) null);
        this.fdv = new e(this, inflate);
        this.fdv.setListPullRefreshListener(this.dht);
        this.fdy = new a(this, this.fdv.getListView());
        this.fdy.setOnAdapterItemClickListener(this.faa);
        if (this.fdw == null) {
            this.fdw = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.fdv != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.fdz = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aBr();
                            return;
                        }
                        FrsADFragment.this.aBp();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.fdv != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.fdz = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aBr();
                            return;
                        }
                        FrsADFragment.this.aBp();
                    }
                }
            };
        }
        this.fdx.a(this.fdw);
        if (!j.kY()) {
            aBp();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        if (this.fdv != null) {
            hideLoadingView();
            if (this.Td == 0) {
                if (!v.T(this.fdz)) {
                    F(true, false);
                    this.fdv.aCs();
                    return;
                }
                showEmptyView();
            } else if (this.Td == 2) {
                this.fdv.fB(false);
                if (!v.T(this.fdz)) {
                    F(true, false);
                    this.fdv.aCs();
                    return;
                }
                showEmptyView();
            } else if (this.Td == 1) {
                if (!v.T(this.fdz)) {
                    F(false, true);
                } else {
                    this.fdv.aCs();
                }
            }
        }
    }

    private void F(boolean z, boolean z2) {
        if (this.ezS != null) {
            if (z) {
                this.ezS.clear();
            }
            if (z2) {
                for (int i = 0; i < this.ezS.size(); i++) {
                    m mVar = (m) v.c(this.ezS, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ju(false);
                    }
                }
            }
            this.ezS.addAll(this.fdz);
            this.fdv.beH().setData(this.ezS);
            this.fdv.beH().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcb() {
        if (this.fdv != null && this.fdv.getListView() != null) {
            this.fdv.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCq() {
        if (this.fdv != null) {
            bcb();
            this.fdv.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fdv != null) {
            if (this.fdv != null && this.fdv.getListView() != null) {
                this.fdv.getListView().stopScroll();
            }
            aBn();
            if (l.lo() && this.mHasMore) {
                qq(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fdv != null) {
            this.fdv.onChangeSkinType(i);
        }
        if (this.fdA != null && this.fdA.isViewAttached()) {
            this.fdA.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qq(int i) {
        if (this.fdx != null) {
            aBq();
            this.Td = i;
            if (i == 0 || i == 2) {
                this.fdx.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.fdx.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.fdv == null) {
            return null;
        }
        return this.fdv.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.kY()) {
            qq(0);
            showLoadingView();
            return;
        }
        aBp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.fdv.jv(false);
        showLoadingView(this.fdv.bdJ(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    private void hideLoadingView() {
        this.fdv.jv(true);
        hideLoadingView(this.fdv.bdJ());
    }

    private void aBn() {
        if (!this.mHasMore) {
            if (v.T(this.fdz)) {
                this.fdv.aCt();
                return;
            } else {
                this.fdv.aCs();
                return;
            }
        }
        this.fdv.aCr();
    }

    private void showEmptyView() {
        if (this.ezS != null && this.fdv != null) {
            this.ezS.add(new com.baidu.tieba.frs.m());
            this.fdv.beH().setData(this.ezS);
            this.fdv.beH().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBp() {
        this.fdv.jv(false);
        this.fdv.beI().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fdv.aCt();
        this.fdv.getListView().getData().clear();
        this.fdv.bdv();
        if (this.fdA == null) {
            this.fdA = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fdA.setTitle(null);
            this.fdA.pp(null);
            this.fdA.setButtonText(null);
            this.fdA.any();
            this.fdA.anz().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fdA.onChangeSkinType();
        this.fdA.attachView(this.fdv.bdJ(), true);
        MessageManager.getInstance().registerListener(this.fbC);
    }

    private void aBq() {
        this.fdv.jv(true);
        this.fdv.beI().setEnabled(true);
        if (this.fdA != null && this.fdA.isViewAttached()) {
            this.fdA.dettachView(this.fdv.bdJ());
            MessageManager.getInstance().unRegisterListener(this.fbC);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kY()) {
            qq(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fbC);
        if (this.fdv != null) {
            this.fdv.onDestroy();
        }
        if (this.fdx != null) {
            this.fdx.onDestroy();
        }
        super.onDestroy();
    }
}
