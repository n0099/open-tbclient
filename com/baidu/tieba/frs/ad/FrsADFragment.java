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
/* loaded from: classes9.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ah {
    private TbPageContext context;
    private long forumId;
    private String goe;
    private ADRequestModel.a gsY;
    private ADRequestModel gsZ;
    private a gta;
    private List<c> gtb;
    private com.baidu.tbadk.k.c gtc;
    private String mFrom;
    private boolean mHasMore;
    protected e gsX = null;
    private int offset = 0;
    public int Df = 0;
    private ArrayList<m> fSt = new ArrayList<>();
    private int cdv = 0;
    private int gph = 0;
    private CustomMessageListener grg = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.gtc != null && FrsADFragment.this.gtc.isViewAttached()) {
                FrsADFragment.this.gtc.mD(num.intValue());
            }
        }
    };
    private final g.c erU = new g.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (FrsADFragment.this.gsX != null) {
                if (j.isNetWorkAvailable()) {
                    FrsADFragment.this.td(2);
                    if (v.isEmpty(FrsADFragment.this.fSt)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.gsX.hu(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.gph += i2;
            if (FrsADFragment.this.gph >= FrsADFragment.this.cdv * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener gtd = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gtc != null && FrsADFragment.this.gtc.isViewAttached()) {
                        FrsADFragment.this.td(0);
                    } else if (FrsADFragment.this.gsX != null) {
                        FrsADFragment.this.gsX.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener gpk = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gtc != null && FrsADFragment.this.gtc.isViewAttached()) {
                        FrsADFragment.this.td(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.gsX != null) {
                        FrsADFragment.this.gsX.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private s gpF = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.7
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.aRP() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aGG().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.aRP(), arrayList)});
                if (!aq.isEmpty(cVar.bFY())) {
                    TiebaStatic.log(new an("c13194").cy("obj_type", cVar.bFY()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bFV();
    }

    private void bFV() {
        if (isPrimary()) {
            if (this.gtc != null && this.gtc.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.grg);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.grg);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.gtd);
        registerListener(this.gpk);
        if (this.gsZ == null) {
            this.gsZ = new ADRequestModel(this.context);
        }
        this.cdv = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.goe = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.goe = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.gsX = new e(this, inflate);
        this.gsX.setListPullRefreshListener(this.erU);
        this.gsX.setOnScrollListener(this.mScrollListener);
        this.gta = new a(this, this.gsX.getListView());
        this.gta.a(this.gpF);
        if (this.gsY == null) {
            this.gsY = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.gsX != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.gtb = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.AC();
                            return;
                        }
                        FrsADFragment.this.bcw();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.gsX != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.gtb = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.AC();
                            return;
                        }
                        FrsADFragment.this.bcw();
                    }
                }
            };
        }
        this.gsZ.a(this.gsY);
        if (!j.isNetWorkAvailable()) {
            bcw();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC() {
        if (this.gsX != null) {
            hideLoadingView();
            if (this.Df == 0) {
                if (!v.isEmpty(this.gtb)) {
                    O(true, false);
                    this.gsX.bds();
                    return;
                }
                aiu();
            } else if (this.Df == 2) {
                this.gsX.hu(false);
                if (!v.isEmpty(this.gtb)) {
                    O(true, false);
                    this.gsX.bds();
                    return;
                }
                aiu();
            } else if (this.Df == 1) {
                if (!v.isEmpty(this.gtb)) {
                    O(false, true);
                } else {
                    this.gsX.bds();
                }
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.fSt != null) {
            if (z) {
                this.fSt.clear();
            }
            if (z2) {
                for (int i = 0; i < this.fSt.size(); i++) {
                    m mVar = (m) v.getItem(this.fSt, i);
                    if (mVar instanceof c) {
                        ((c) mVar).lE(false);
                    }
                }
            }
            this.fSt.addAll(this.gtb);
            this.gsX.bGe().setData(this.fSt);
            this.gsX.bGe().notifyDataSetChanged();
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
        if (this.gsX != null && this.gsX.getListView() != null) {
            this.gsX.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdq() {
        if (this.gsX != null) {
            scrollToTop();
            this.gsX.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gsX != null) {
            if (this.gsX != null && this.gsX.getListView() != null) {
                this.gsX.getListView().stopScroll();
            }
            bcu();
            if (l.isNetOk() && this.mHasMore) {
                td(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gsX != null) {
            this.gsX.onChangeSkinType(i);
        }
        if (this.gtc != null && this.gtc.isViewAttached()) {
            this.gtc.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(int i) {
        if (this.gsZ != null) {
            bcx();
            this.Df = i;
            if (i == 0 || i == 2) {
                this.gsZ.a(this.forumId, 0, 20);
            } else if (i == 1) {
                this.gsZ.a(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.gsX == null) {
            return null;
        }
        return this.gsX.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            td(0);
            showLoadingView();
            return;
        }
        bcw();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").s("fid", this.forumId).X("obj_type", 9).X("obj_locate", 2).cy("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.gsX.lF(false);
        showLoadingView(this.gsX.bsE(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.gsX.lF(true);
        hideLoadingView(this.gsX.bsE());
    }

    private void bcu() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.gtb)) {
                this.gsX.bdt();
                return;
            } else {
                this.gsX.bds();
                return;
            }
        }
        this.gsX.bdr();
    }

    private void aiu() {
        if (this.fSt != null && this.gsX != null) {
            this.fSt.add(new n());
            this.gsX.bGe().setData(this.fSt);
            this.gsX.bGe().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcw() {
        this.gsX.lF(false);
        this.gsX.bGf().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gsX.bdt();
        this.gsX.getListView().getData().clear();
        this.gsX.bET();
        if (this.gtc == null) {
            this.gtc = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gtc.setTitle(null);
            this.gtc.setSubText(null);
            this.gtc.setButtonText(null);
            this.gtc.showRefreshButton();
            this.gtc.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gtc.onChangeSkinType();
        this.gtc.attachView(this.gsX.bsE(), true);
        MessageManager.getInstance().registerListener(this.grg);
    }

    private void bcx() {
        this.gsX.lF(true);
        this.gsX.bGf().setEnabled(true);
        if (this.gtc != null && this.gtc.isViewAttached()) {
            this.gtc.dettachView(this.gsX.bsE());
            MessageManager.getInstance().unRegisterListener(this.grg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            td(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.grg);
        if (this.gsX != null) {
            this.gsX.onDestroy();
        }
        if (this.gsZ != null) {
            this.gsZ.onDestroy();
        }
        super.onDestroy();
    }
}
