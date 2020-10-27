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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, as, au {
    private TbPageContext context;
    private long forumId;
    private String iBk;
    private ADRequestModel.a iHB;
    private ADRequestModel iHC;
    private a iHD;
    private List<c> iHE;
    private com.baidu.tbadk.k.c iHF;
    private String mFrom;
    private boolean mHasMore;
    protected e iHA = null;
    private int offset = 0;
    public int YH = 0;
    private ArrayList<q> iaV = new ArrayList<>();
    private int dDO = 0;
    private int iCq = 0;
    private CustomMessageListener iEU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.iHF != null && FrsADFragment.this.iHF.isViewAttached()) {
                FrsADFragment.this.iHF.rs(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.iCq += i2;
            if (FrsADFragment.this.iCq >= FrsADFragment.this.dDO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener iHG = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iHF != null && FrsADFragment.this.iHF.isViewAttached()) {
                        FrsADFragment.this.yX(0);
                    } else if (FrsADFragment.this.iHA != null) {
                        FrsADFragment.this.iHA.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener iCE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iHF != null && FrsADFragment.this.iHF.isViewAttached()) {
                        FrsADFragment.this.yX(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.iHA != null) {
                        FrsADFragment.this.iHA.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab iDd = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bAI() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                be.boR().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bAI(), arrayList)});
                if (!at.isEmpty(cVar.cyq())) {
                    TiebaStatic.log(new aq("c13194").dR("obj_type", cVar.cyq()).w("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cyn();
    }

    private void cyn() {
        if (isPrimary()) {
            if (this.iHF != null && this.iHF.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iEU);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.iHG);
        registerListener(this.iCE);
        if (this.iHC == null) {
            this.iHC = new ADRequestModel(this.context);
        }
        this.dDO = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.iBk = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iBk = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.iHA = new e(this, inflate);
        this.iHA.setOnScrollListener(this.mScrollListener);
        this.iHD = new a(this, this.iHA.getListView());
        this.iHD.a(this.iDd);
        if (this.iHB == null) {
            this.iHB = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.iHA != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.iHE = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Rd();
                            return;
                        }
                        FrsADFragment.this.bMA();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.iHA != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.iHE = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Rd();
                            return;
                        }
                        FrsADFragment.this.bMA();
                    }
                }
            };
        }
        this.iHC.a(this.iHB);
        if (!j.isNetWorkAvailable()) {
            bMA();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rd() {
        if (this.iHA != null) {
            hideLoadingView();
            this.iHA.cyx();
            if (this.YH == 0) {
                if (!y.isEmpty(this.iHE)) {
                    aa(true, false);
                    this.iHA.TJ();
                    return;
                }
                bME();
            } else if (this.YH == 2) {
                this.iHA.kT(false);
                if (!y.isEmpty(this.iHE)) {
                    aa(true, false);
                    this.iHA.TJ();
                    return;
                }
                bME();
            } else if (this.YH == 1) {
                if (!y.isEmpty(this.iHE)) {
                    aa(false, true);
                } else {
                    this.iHA.TJ();
                }
            }
        }
    }

    private void aa(boolean z, boolean z2) {
        if (this.iaV != null) {
            if (z) {
                this.iaV.clear();
            }
            if (z2) {
                for (int i = 0; i < this.iaV.size(); i++) {
                    q qVar = (q) y.getItem(this.iaV, i);
                    if (qVar instanceof c) {
                        ((c) qVar).pG(false);
                    }
                }
            }
            this.iaV.addAll(this.iHE);
            com.baidu.tbadk.a.a.a.aX(this.iaV);
            this.iHA.cyw().setData(this.iaV);
            this.iHA.cyw().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = 90;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.as
    public void cvr() {
        if (this.iHA != null && this.iHA.getListView() != null) {
            this.iHA.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bNv() {
        if (this.iHA != null) {
            cvr();
            this.iHA.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iHA != null) {
            if (this.iHA != null && this.iHA.getListView() != null) {
                this.iHA.getListView().stopScroll();
            }
            bMx();
            if (l.isNetOk() && this.mHasMore) {
                yX(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iHA != null) {
            this.iHA.onChangeSkinType(i);
        }
        if (this.iHF != null && this.iHF.isViewAttached()) {
            this.iHF.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX(int i) {
        if (this.iHC != null) {
            TK();
            this.YH = i;
            if (i == 0 || i == 2) {
                this.iHC.c(this.forumId, 0, 20);
            } else if (i == 1) {
                this.iHC.c(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.iHA == null) {
            return null;
        }
        return this.iHA.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            yX(0);
            showLoadingView();
            return;
        }
        bMA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").w("fid", this.forumId).aj("obj_type", 9).aj("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.iHA.pI(false);
        showLoadingView(this.iHA.chy(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.iHA.pI(true);
        hideLoadingView(this.iHA.chy());
    }

    private void bMx() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.iHE)) {
                this.iHA.bNw();
                return;
            } else {
                this.iHA.TJ();
                return;
            }
        }
        this.iHA.TI();
    }

    private void bME() {
        if (this.iaV != null && this.iHA != null) {
            this.iaV.add(new s());
            this.iHA.cyw().setData(this.iaV);
            this.iHA.cyw().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        this.iHA.pI(false);
        this.iHA.pH(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iHA.bNw();
        this.iHA.getListView().getData().clear();
        this.iHA.cwW();
        if (this.iHF == null) {
            this.iHF = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iHF.setTitle(null);
            this.iHF.setSubText(null);
            this.iHF.setButtonText(null);
            this.iHF.showRefreshButton();
            this.iHF.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iHF.onChangeSkinType();
        this.iHF.attachView(this.iHA.chy(), true);
        MessageManager.getInstance().registerListener(this.iEU);
    }

    private void TK() {
        this.iHA.pI(true);
        this.iHA.pH(true);
        if (this.iHF != null && this.iHF.isViewAttached()) {
            this.iHF.dettachView(this.iHA.chy());
            MessageManager.getInstance().unRegisterListener(this.iEU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            yX(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iEU);
        if (this.iHA != null) {
            this.iHA.onDestroy();
        }
        if (this.iHC != null) {
            this.iHC.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bqb() {
        if (this.iHA != null) {
            if (j.isNetWorkAvailable()) {
                yX(2);
                if (y.isEmpty(this.iaV)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.iHA.kT(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bqc() {
    }
}
