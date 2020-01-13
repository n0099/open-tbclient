package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ah {
    private TbPageContext context;
    private long forumId;
    private String gmb;
    private ADRequestModel.a gqV;
    private ADRequestModel gqW;
    private a gqX;
    private List<c> gqY;
    private com.baidu.tbadk.k.c gqZ;
    private String mFrom;
    private boolean mHasMore;
    protected e gqU = null;
    private int offset = 0;
    public int CK = 0;
    private ArrayList<m> fPW = new ArrayList<>();
    private int bZo = 0;
    private int gne = 0;
    private CustomMessageListener gpd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.gqZ != null && FrsADFragment.this.gqZ.isViewAttached()) {
                FrsADFragment.this.gqZ.ml(num.intValue());
            }
        }
    };
    private final g.c enH = new g.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (FrsADFragment.this.gqU != null) {
                if (j.isNetWorkAvailable()) {
                    FrsADFragment.this.sX(2);
                    if (v.isEmpty(FrsADFragment.this.fPW)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.gqU.hn(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.gne += i2;
            if (FrsADFragment.this.gne >= FrsADFragment.this.bZo * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener gra = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gqZ != null && FrsADFragment.this.gqZ.isViewAttached()) {
                        FrsADFragment.this.sX(0);
                    } else if (FrsADFragment.this.gqU != null) {
                        FrsADFragment.this.gqU.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener gnh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gqZ != null && FrsADFragment.this.gqZ.isViewAttached()) {
                        FrsADFragment.this.sX(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.gqU != null) {
                        FrsADFragment.this.gqU.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private s gnC = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.7
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.aPw() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aEt().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.aPw(), arrayList)});
                if (!aq.isEmpty(cVar.bEu())) {
                    TiebaStatic.log(new an("c13194").cp("obj_type", cVar.bEu()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bEr();
    }

    private void bEr() {
        if (isPrimary()) {
            if (this.gqZ != null && this.gqZ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.gpd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.gpd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.gra);
        registerListener(this.gnh);
        if (this.gqW == null) {
            this.gqW = new ADRequestModel(this.context);
        }
        this.bZo = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.gmb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gmb = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.gqU = new e(this, inflate);
        this.gqU.setListPullRefreshListener(this.enH);
        this.gqU.setOnScrollListener(this.mScrollListener);
        this.gqX = new a(this, this.gqU.getListView());
        this.gqX.a(this.gnC);
        if (this.gqV == null) {
            this.gqV = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.gqU != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.gqY = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.yj();
                            return;
                        }
                        FrsADFragment.this.bae();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.gqU != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.gqY = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.yj();
                            return;
                        }
                        FrsADFragment.this.bae();
                    }
                }
            };
        }
        this.gqW.a(this.gqV);
        if (!j.isNetWorkAvailable()) {
            bae();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yj() {
        if (this.gqU != null) {
            hideLoadingView();
            if (this.CK == 0) {
                if (!v.isEmpty(this.gqY)) {
                    M(true, false);
                    this.gqU.bbb();
                    return;
                }
                age();
            } else if (this.CK == 2) {
                this.gqU.hn(false);
                if (!v.isEmpty(this.gqY)) {
                    M(true, false);
                    this.gqU.bbb();
                    return;
                }
                age();
            } else if (this.CK == 1) {
                if (!v.isEmpty(this.gqY)) {
                    M(false, true);
                } else {
                    this.gqU.bbb();
                }
            }
        }
    }

    private void M(boolean z, boolean z2) {
        if (this.fPW != null) {
            if (z) {
                this.fPW.clear();
            }
            if (z2) {
                for (int i = 0; i < this.fPW.size(); i++) {
                    m mVar = (m) v.getItem(this.fPW, i);
                    if (mVar instanceof c) {
                        ((c) mVar).lB(false);
                    }
                }
            }
            this.fPW.addAll(this.gqY);
            this.gqU.bEA().setData(this.fPW);
            this.gqU.bEA().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gqU != null && this.gqU.getListView() != null) {
            this.gqU.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void baZ() {
        if (this.gqU != null) {
            scrollToTop();
            this.gqU.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gqU != null) {
            if (this.gqU != null && this.gqU.getListView() != null) {
                this.gqU.getListView().stopScroll();
            }
            bac();
            if (l.isNetOk() && this.mHasMore) {
                sX(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gqU != null) {
            this.gqU.onChangeSkinType(i);
        }
        if (this.gqZ != null && this.gqZ.isViewAttached()) {
            this.gqZ.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sX(int i) {
        if (this.gqW != null) {
            baf();
            this.CK = i;
            if (i == 0 || i == 2) {
                this.gqW.a(this.forumId, 0, 20);
            } else if (i == 1) {
                this.gqW.a(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.gqU == null) {
            return null;
        }
        return this.gqU.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            sX(0);
            showLoadingView();
            return;
        }
        bae();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").s("fid", this.forumId).Z("obj_type", 9).Z("obj_locate", 2).cp("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.gqU.lC(false);
        showLoadingView(this.gqU.bqY(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.gqU.lC(true);
        hideLoadingView(this.gqU.bqY());
    }

    private void bac() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.gqY)) {
                this.gqU.bbc();
                return;
            } else {
                this.gqU.bbb();
                return;
            }
        }
        this.gqU.bba();
    }

    private void age() {
        if (this.fPW != null && this.gqU != null) {
            this.fPW.add(new n());
            this.gqU.bEA().setData(this.fPW);
            this.gqU.bEA().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        this.gqU.lC(false);
        this.gqU.bEB().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gqU.bbc();
        this.gqU.getListView().getData().clear();
        this.gqU.bDo();
        if (this.gqZ == null) {
            this.gqZ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gqZ.setTitle(null);
            this.gqZ.setSubText(null);
            this.gqZ.setButtonText(null);
            this.gqZ.showRefreshButton();
            this.gqZ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gqZ.onChangeSkinType();
        this.gqZ.attachView(this.gqU.bqY(), true);
        MessageManager.getInstance().registerListener(this.gpd);
    }

    private void baf() {
        this.gqU.lC(true);
        this.gqU.bEB().setEnabled(true);
        if (this.gqZ != null && this.gqZ.isViewAttached()) {
            this.gqZ.dettachView(this.gqU.bqY());
            MessageManager.getInstance().unRegisterListener(this.gpd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            sX(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gpd);
        if (this.gqU != null) {
            this.gqU.onDestroy();
        }
        if (this.gqW != null) {
            this.gqW.onDestroy();
        }
        super.onDestroy();
    }
}
