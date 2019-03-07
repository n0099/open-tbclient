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
    private String eYL;
    private ADRequestModel.a fdK;
    private ADRequestModel fdL;
    private a fdM;
    private List<c> fdN;
    private com.baidu.tbadk.m.c fdO;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e fdJ = null;
    private int offset = 0;
    public int Tc = 0;
    private ArrayList<m> eAl = new ArrayList<>();
    private CustomMessageListener fbQ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.fdO != null && FrsADFragment.this.fdO.isViewAttached()) {
                FrsADFragment.this.fdO.jO(num.intValue());
            }
        }
    };
    private final h.c dhu = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void dR(boolean z) {
            if (FrsADFragment.this.fdJ != null) {
                if (j.kY()) {
                    FrsADFragment.this.qu(2);
                    if (v.T(FrsADFragment.this.eAl)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.fdJ.fB(false);
            }
        }
    };
    private CustomMessageListener fdP = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fdO != null && FrsADFragment.this.fdO.isViewAttached()) {
                        FrsADFragment.this.qu(0);
                    } else if (FrsADFragment.this.fdJ != null) {
                        FrsADFragment.this.fdJ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener eZV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fdO != null && FrsADFragment.this.fdO.isViewAttached()) {
                        FrsADFragment.this.qu(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.fdJ != null) {
                        FrsADFragment.this.fdJ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private s fap = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
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
            if (this.fdO != null && this.fdO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fbQ);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fbQ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.fdP);
        registerListener(this.eZV);
        if (this.fdL == null) {
            this.fdL = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.eYL = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.eYL = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_ad_fragment, (ViewGroup) null);
        this.fdJ = new e(this, inflate);
        this.fdJ.setListPullRefreshListener(this.dhu);
        this.fdM = new a(this, this.fdJ.getListView());
        this.fdM.setOnAdapterItemClickListener(this.fap);
        if (this.fdK == null) {
            this.fdK = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.fdJ != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.fdN = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aBu();
                            return;
                        }
                        FrsADFragment.this.aBs();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.fdJ != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.fdN = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.aBu();
                            return;
                        }
                        FrsADFragment.this.aBs();
                    }
                }
            };
        }
        this.fdL.a(this.fdK);
        if (!j.kY()) {
            aBs();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        if (this.fdJ != null) {
            hideLoadingView();
            if (this.Tc == 0) {
                if (!v.T(this.fdN)) {
                    H(true, false);
                    this.fdJ.aCv();
                    return;
                }
                showEmptyView();
            } else if (this.Tc == 2) {
                this.fdJ.fB(false);
                if (!v.T(this.fdN)) {
                    H(true, false);
                    this.fdJ.aCv();
                    return;
                }
                showEmptyView();
            } else if (this.Tc == 1) {
                if (!v.T(this.fdN)) {
                    H(false, true);
                } else {
                    this.fdJ.aCv();
                }
            }
        }
    }

    private void H(boolean z, boolean z2) {
        if (this.eAl != null) {
            if (z) {
                this.eAl.clear();
            }
            if (z2) {
                for (int i = 0; i < this.eAl.size(); i++) {
                    m mVar = (m) v.c(this.eAl, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ju(false);
                    }
                }
            }
            this.eAl.addAll(this.fdN);
            this.fdJ.beJ().setData(this.eAl);
            this.fdJ.beJ().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcd() {
        if (this.fdJ != null && this.fdJ.getListView() != null) {
            this.fdJ.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCt() {
        if (this.fdJ != null) {
            bcd();
            this.fdJ.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fdJ != null) {
            if (this.fdJ != null && this.fdJ.getListView() != null) {
                this.fdJ.getListView().stopScroll();
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
        if (this.fdJ != null) {
            this.fdJ.onChangeSkinType(i);
        }
        if (this.fdO != null && this.fdO.isViewAttached()) {
            this.fdO.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu(int i) {
        if (this.fdL != null) {
            aBt();
            this.Tc = i;
            if (i == 0 || i == 2) {
                this.fdL.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.fdL.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.fdJ == null) {
            return null;
        }
        return this.fdJ.getListView();
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
        this.fdJ.jv(false);
        showLoadingView(this.fdJ.bdL(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    private void hideLoadingView() {
        this.fdJ.jv(true);
        hideLoadingView(this.fdJ.bdL());
    }

    private void aBq() {
        if (!this.mHasMore) {
            if (v.T(this.fdN)) {
                this.fdJ.aCw();
                return;
            } else {
                this.fdJ.aCv();
                return;
            }
        }
        this.fdJ.aCu();
    }

    private void showEmptyView() {
        if (this.eAl != null && this.fdJ != null) {
            this.eAl.add(new com.baidu.tieba.frs.m());
            this.fdJ.beJ().setData(this.eAl);
            this.fdJ.beJ().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        this.fdJ.jv(false);
        this.fdJ.beK().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.fdJ.aCw();
        this.fdJ.getListView().getData().clear();
        this.fdJ.bdx();
        if (this.fdO == null) {
            this.fdO = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fdO.setTitle(null);
            this.fdO.po(null);
            this.fdO.setButtonText(null);
            this.fdO.anC();
            this.fdO.anD().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fdO.onChangeSkinType();
        this.fdO.attachView(this.fdJ.bdL(), true);
        MessageManager.getInstance().registerListener(this.fbQ);
    }

    private void aBt() {
        this.fdJ.jv(true);
        this.fdJ.beK().setEnabled(true);
        if (this.fdO != null && this.fdO.isViewAttached()) {
            this.fdO.dettachView(this.fdJ.bdL());
            MessageManager.getInstance().unRegisterListener(this.fbQ);
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
        MessageManager.getInstance().unRegisterListener(this.fbQ);
        if (this.fdJ != null) {
            this.fdJ.onDestroy();
        }
        if (this.fdL != null) {
            this.fdL.onDestroy();
        }
        super.onDestroy();
    }
}
