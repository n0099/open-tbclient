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
    private String goc;
    private ADRequestModel.a gsW;
    private ADRequestModel gsX;
    private a gsY;
    private List<c> gsZ;
    private com.baidu.tbadk.k.c gta;
    private String mFrom;
    private boolean mHasMore;
    protected e gsV = null;
    private int offset = 0;
    public int Df = 0;
    private ArrayList<m> fSr = new ArrayList<>();
    private int cdu = 0;
    private int gpf = 0;
    private CustomMessageListener gre = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.gta != null && FrsADFragment.this.gta.isViewAttached()) {
                FrsADFragment.this.gta.mD(num.intValue());
            }
        }
    };
    private final g.c erT = new g.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (FrsADFragment.this.gsV != null) {
                if (j.isNetWorkAvailable()) {
                    FrsADFragment.this.td(2);
                    if (v.isEmpty(FrsADFragment.this.fSr)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.gsV.hu(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.gpf += i2;
            if (FrsADFragment.this.gpf >= FrsADFragment.this.cdu * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener gtb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gta != null && FrsADFragment.this.gta.isViewAttached()) {
                        FrsADFragment.this.td(0);
                    } else if (FrsADFragment.this.gsV != null) {
                        FrsADFragment.this.gsV.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener gpi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gta != null && FrsADFragment.this.gta.isViewAttached()) {
                        FrsADFragment.this.td(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.gsV != null) {
                        FrsADFragment.this.gsV.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private s gpD = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.7
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.aRN() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aGE().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.aRN(), arrayList)});
                if (!aq.isEmpty(cVar.bFW())) {
                    TiebaStatic.log(new an("c13194").cy("obj_type", cVar.bFW()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bFT();
    }

    private void bFT() {
        if (isPrimary()) {
            if (this.gta != null && this.gta.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.gre);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.gre);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.gtb);
        registerListener(this.gpi);
        if (this.gsX == null) {
            this.gsX = new ADRequestModel(this.context);
        }
        this.cdu = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.goc = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.goc = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.gsV = new e(this, inflate);
        this.gsV.setListPullRefreshListener(this.erT);
        this.gsV.setOnScrollListener(this.mScrollListener);
        this.gsY = new a(this, this.gsV.getListView());
        this.gsY.a(this.gpD);
        if (this.gsW == null) {
            this.gsW = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.gsV != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.gsZ = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.AA();
                            return;
                        }
                        FrsADFragment.this.bcu();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.gsV != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.gsZ = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.AA();
                            return;
                        }
                        FrsADFragment.this.bcu();
                    }
                }
            };
        }
        this.gsX.a(this.gsW);
        if (!j.isNetWorkAvailable()) {
            bcu();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA() {
        if (this.gsV != null) {
            hideLoadingView();
            if (this.Df == 0) {
                if (!v.isEmpty(this.gsZ)) {
                    O(true, false);
                    this.gsV.bdq();
                    return;
                }
                ais();
            } else if (this.Df == 2) {
                this.gsV.hu(false);
                if (!v.isEmpty(this.gsZ)) {
                    O(true, false);
                    this.gsV.bdq();
                    return;
                }
                ais();
            } else if (this.Df == 1) {
                if (!v.isEmpty(this.gsZ)) {
                    O(false, true);
                } else {
                    this.gsV.bdq();
                }
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.fSr != null) {
            if (z) {
                this.fSr.clear();
            }
            if (z2) {
                for (int i = 0; i < this.fSr.size(); i++) {
                    m mVar = (m) v.getItem(this.fSr, i);
                    if (mVar instanceof c) {
                        ((c) mVar).lE(false);
                    }
                }
            }
            this.fSr.addAll(this.gsZ);
            this.gsV.bGc().setData(this.fSr);
            this.gsV.bGc().notifyDataSetChanged();
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
        if (this.gsV != null && this.gsV.getListView() != null) {
            this.gsV.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdo() {
        if (this.gsV != null) {
            scrollToTop();
            this.gsV.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gsV != null) {
            if (this.gsV != null && this.gsV.getListView() != null) {
                this.gsV.getListView().stopScroll();
            }
            bcs();
            if (l.isNetOk() && this.mHasMore) {
                td(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gsV != null) {
            this.gsV.onChangeSkinType(i);
        }
        if (this.gta != null && this.gta.isViewAttached()) {
            this.gta.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(int i) {
        if (this.gsX != null) {
            bcv();
            this.Df = i;
            if (i == 0 || i == 2) {
                this.gsX.a(this.forumId, 0, 20);
            } else if (i == 1) {
                this.gsX.a(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.gsV == null) {
            return null;
        }
        return this.gsV.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            td(0);
            showLoadingView();
            return;
        }
        bcu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").s("fid", this.forumId).X("obj_type", 9).X("obj_locate", 2).cy("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.gsV.lF(false);
        showLoadingView(this.gsV.bsC(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.gsV.lF(true);
        hideLoadingView(this.gsV.bsC());
    }

    private void bcs() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.gsZ)) {
                this.gsV.bdr();
                return;
            } else {
                this.gsV.bdq();
                return;
            }
        }
        this.gsV.bdp();
    }

    private void ais() {
        if (this.fSr != null && this.gsV != null) {
            this.fSr.add(new n());
            this.gsV.bGc().setData(this.fSr);
            this.gsV.bGc().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcu() {
        this.gsV.lF(false);
        this.gsV.bGd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gsV.bdr();
        this.gsV.getListView().getData().clear();
        this.gsV.bER();
        if (this.gta == null) {
            this.gta = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gta.setTitle(null);
            this.gta.setSubText(null);
            this.gta.setButtonText(null);
            this.gta.showRefreshButton();
            this.gta.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gta.onChangeSkinType();
        this.gta.attachView(this.gsV.bsC(), true);
        MessageManager.getInstance().registerListener(this.gre);
    }

    private void bcv() {
        this.gsV.lF(true);
        this.gsV.bGd().setEnabled(true);
        if (this.gta != null && this.gta.isViewAttached()) {
            this.gta.dettachView(this.gsV.bsC());
            MessageManager.getInstance().unRegisterListener(this.gre);
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
        MessageManager.getInstance().unRegisterListener(this.gre);
        if (this.gsV != null) {
            this.gsV.onDestroy();
        }
        if (this.gsX != null) {
            this.gsX.onDestroy();
        }
        super.onDestroy();
    }
}
