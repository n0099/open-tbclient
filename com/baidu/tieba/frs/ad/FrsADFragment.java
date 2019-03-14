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
    private String eYK;
    private ADRequestModel.a fdJ;
    private ADRequestModel fdK;
    private a fdL;
    private List<c> fdM;
    private com.baidu.tbadk.m.c fdN;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e fdI = null;
    private int offset = 0;
    public int Td = 0;
    private ArrayList<m> eAh = new ArrayList<>();
    private CustomMessageListener fbP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.fdN != null && FrsADFragment.this.fdN.isViewAttached()) {
                FrsADFragment.this.fdN.jO(num.intValue());
            }
        }
    };
    private final h.c dhq = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (FrsADFragment.this.fdI != null) {
                if (j.kY()) {
                    FrsADFragment.this.qu(2);
                    if (v.T(FrsADFragment.this.eAh)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.fdI.fB(false);
            }
        }
    };
    private CustomMessageListener fdO = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fdN != null && FrsADFragment.this.fdN.isViewAttached()) {
                        FrsADFragment.this.qu(0);
                    } else if (FrsADFragment.this.fdI != null) {
                        FrsADFragment.this.fdI.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener eZU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fdN != null && FrsADFragment.this.fdN.isViewAttached()) {
                        FrsADFragment.this.qu(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.fdI != null) {
                        FrsADFragment.this.fdI.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private s fao = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.apP() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.adD().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.e(cVar.apP(), arrayList)});
                if (!ap.isEmpty(cVar.beE())) {
                    TiebaStatic.log(new am("c13194").bJ("obj_type", cVar.beE()).k(ImageViewerConfig.FORUM_ID, FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        beB();
    }

    private void beB() {
        if (isPrimary()) {
            if (this.fdN != null && this.fdN.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fbP);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fbP);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.fdO);
        registerListener(this.eZU);
        if (this.fdK == null) {
            this.fdK = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.eYK = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eYK = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_ad_fragment, (ViewGroup) null);
        this.fdI = new e(this, inflate);
        this.fdI.setListPullRefreshListener(this.dhq);
        this.fdL = new a(this, this.fdI.getListView());
        this.fdL.setOnAdapterItemClickListener(this.fao);
        if (this.fdJ == null) {
            this.fdJ = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.fdI != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.fdM = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aBu();
                            return;
                        }
                        FrsADFragment.this.aBs();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.fdI != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.fdM = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aBu();
                            return;
                        }
                        FrsADFragment.this.aBs();
                    }
                }
            };
        }
        this.fdK.a(this.fdJ);
        if (!j.kY()) {
            aBs();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.fdI != null) {
            hideLoadingView();
            if (this.Td == 0) {
                if (!v.T(this.fdM)) {
                    H(true, false);
                    this.fdI.aCv();
                    return;
                }
                showEmptyView();
            } else if (this.Td == 2) {
                this.fdI.fB(false);
                if (!v.T(this.fdM)) {
                    H(true, false);
                    this.fdI.aCv();
                    return;
                }
                showEmptyView();
            } else if (this.Td == 1) {
                if (!v.T(this.fdM)) {
                    H(false, true);
                } else {
                    this.fdI.aCv();
                }
            }
        }
    }

    private void H(boolean z, boolean z2) {
        if (this.eAh != null) {
            if (z) {
                this.eAh.clear();
            }
            if (z2) {
                for (int i = 0; i < this.eAh.size(); i++) {
                    m mVar = (m) v.c(this.eAh, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ju(false);
                    }
                }
            }
            this.eAh.addAll(this.fdM);
            this.fdI.beJ().setData(this.eAh);
            this.fdI.beJ().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcd() {
        if (this.fdI != null && this.fdI.getListView() != null) {
            this.fdI.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCt() {
        if (this.fdI != null) {
            bcd();
            this.fdI.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fdI != null) {
            if (this.fdI != null && this.fdI.getListView() != null) {
                this.fdI.getListView().stopScroll();
            }
            aBq();
            if (l.lo() && this.mHasMore) {
                qu(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fdI != null) {
            this.fdI.onChangeSkinType(i);
        }
        if (this.fdN != null && this.fdN.isViewAttached()) {
            this.fdN.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu(int i) {
        if (this.fdK != null) {
            aBt();
            this.Td = i;
            if (i == 0 || i == 2) {
                this.fdK.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.fdK.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.fdI == null) {
            return null;
        }
        return this.fdI.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.kY()) {
            qu(0);
            showLoadingView();
            return;
        }
        aBs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.fdI.jv(false);
        showLoadingView(this.fdI.bdL(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    private void hideLoadingView() {
        this.fdI.jv(true);
        hideLoadingView(this.fdI.bdL());
    }

    private void aBq() {
        if (!this.mHasMore) {
            if (v.T(this.fdM)) {
                this.fdI.aCw();
                return;
            } else {
                this.fdI.aCv();
                return;
            }
        }
        this.fdI.aCu();
    }

    private void showEmptyView() {
        if (this.eAh != null && this.fdI != null) {
            this.eAh.add(new com.baidu.tieba.frs.m());
            this.fdI.beJ().setData(this.eAh);
            this.fdI.beJ().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        this.fdI.jv(false);
        this.fdI.beK().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fdI.aCw();
        this.fdI.getListView().getData().clear();
        this.fdI.bdx();
        if (this.fdN == null) {
            this.fdN = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fdN.setTitle(null);
            this.fdN.po(null);
            this.fdN.setButtonText(null);
            this.fdN.anB();
            this.fdN.anC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fdN.onChangeSkinType();
        this.fdN.attachView(this.fdI.bdL(), true);
        MessageManager.getInstance().registerListener(this.fbP);
    }

    private void aBt() {
        this.fdI.jv(true);
        this.fdI.beK().setEnabled(true);
        if (this.fdN != null && this.fdN.isViewAttached()) {
            this.fdN.dettachView(this.fdI.bdL());
            MessageManager.getInstance().unRegisterListener(this.fbP);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kY()) {
            qu(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fbP);
        if (this.fdI != null) {
            this.fdI.onDestroy();
        }
        if (this.fdK != null) {
            this.fdK.onDestroy();
        }
        super.onDestroy();
    }
}
