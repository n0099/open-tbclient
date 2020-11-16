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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes21.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, as, au {
    private TbPageContext context;
    private long forumId;
    private String iHV;
    private ADRequestModel.a iOl;
    private ADRequestModel iOm;
    private a iOn;
    private List<c> iOo;
    private com.baidu.tbadk.k.c iOp;
    private String mFrom;
    private boolean mHasMore;
    protected e iOk = null;
    private int offset = 0;
    public int YM = 0;
    private ArrayList<q> ihK = new ArrayList<>();
    private int dHY = 0;
    private int iJb = 0;
    private CustomMessageListener iLE = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.iOp != null && FrsADFragment.this.iOp.isViewAttached()) {
                FrsADFragment.this.iOp.sa(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.iJb += i2;
            if (FrsADFragment.this.iJb >= FrsADFragment.this.dHY * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener iOq = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iOp != null && FrsADFragment.this.iOp.isViewAttached()) {
                        FrsADFragment.this.zI(0);
                    } else if (FrsADFragment.this.iOk != null) {
                        FrsADFragment.this.iOk.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener iJp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iOp != null && FrsADFragment.this.iOp.isViewAttached()) {
                        FrsADFragment.this.zI(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.iOk != null) {
                        FrsADFragment.this.iOk.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab iJO = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bCA() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bf.bqF().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bCA(), arrayList)});
                if (!com.baidu.tbadk.core.util.au.isEmpty(cVar.cAu())) {
                    TiebaStatic.log(new ar("c13194").dR("obj_type", cVar.cAu()).w("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cAr();
    }

    private void cAr() {
        if (isPrimary()) {
            if (this.iOp != null && this.iOp.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iLE);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iLE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.iOq);
        registerListener(this.iJp);
        if (this.iOm == null) {
            this.iOm = new ADRequestModel(this.context);
        }
        this.dHY = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.iHV = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iHV = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.iOk = new e(this, inflate);
        this.iOk.setOnScrollListener(this.mScrollListener);
        this.iOn = new a(this, this.iOk.getListView());
        this.iOn.a(this.iJO);
        if (this.iOl == null) {
            this.iOl = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.iOk != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.iOo = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Tc();
                            return;
                        }
                        FrsADFragment.this.bOt();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.iOk != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.iOo = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Tc();
                            return;
                        }
                        FrsADFragment.this.bOt();
                    }
                }
            };
        }
        this.iOm.a(this.iOl);
        if (!j.isNetWorkAvailable()) {
            bOt();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tc() {
        if (this.iOk != null) {
            hideLoadingView();
            this.iOk.cAB();
            if (this.YM == 0) {
                if (!y.isEmpty(this.iOo)) {
                    aa(true, false);
                    this.iOk.VA();
                    return;
                }
                bOx();
            } else if (this.YM == 2) {
                this.iOk.ld(false);
                if (!y.isEmpty(this.iOo)) {
                    aa(true, false);
                    this.iOk.VA();
                    return;
                }
                bOx();
            } else if (this.YM == 1) {
                if (!y.isEmpty(this.iOo)) {
                    aa(false, true);
                } else {
                    this.iOk.VA();
                }
            }
        }
    }

    private void aa(boolean z, boolean z2) {
        if (this.ihK != null) {
            if (z) {
                this.ihK.clear();
            }
            if (z2) {
                for (int i = 0; i < this.ihK.size(); i++) {
                    q qVar = (q) y.getItem(this.ihK, i);
                    if (qVar instanceof c) {
                        ((c) qVar).pS(false);
                    }
                }
            }
            this.ihK.addAll(this.iOo);
            com.baidu.tbadk.a.a.a.be(this.ihK);
            this.iOk.cAA().setData(this.ihK);
            this.iOk.cAA().notifyDataSetChanged();
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
    public void cxv() {
        if (this.iOk != null && this.iOk.getListView() != null) {
            this.iOk.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bPo() {
        if (this.iOk != null) {
            cxv();
            this.iOk.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iOk != null) {
            if (this.iOk != null && this.iOk.getListView() != null) {
                this.iOk.getListView().stopScroll();
            }
            bOq();
            if (l.isNetOk() && this.mHasMore) {
                zI(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iOk != null) {
            this.iOk.onChangeSkinType(i);
        }
        if (this.iOp != null && this.iOp.isViewAttached()) {
            this.iOp.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zI(int i) {
        if (this.iOm != null) {
            VB();
            this.YM = i;
            if (i == 0 || i == 2) {
                this.iOm.e(this.forumId, 0, 20);
            } else if (i == 1) {
                this.iOm.e(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.iOk == null) {
            return null;
        }
        return this.iOk.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            zI(0);
            showLoadingView();
            return;
        }
        bOt();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ar("c13008").w("fid", this.forumId).ak("obj_type", 9).ak("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.iOk.pU(false);
        showLoadingView(this.iOk.cjt(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.iOk.pU(true);
        hideLoadingView(this.iOk.cjt());
    }

    private void bOq() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.iOo)) {
                this.iOk.bPp();
                return;
            } else {
                this.iOk.VA();
                return;
            }
        }
        this.iOk.Vz();
    }

    private void bOx() {
        if (this.ihK != null && this.iOk != null) {
            this.ihK.add(new s());
            this.iOk.cAA().setData(this.ihK);
            this.iOk.cAA().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOt() {
        this.iOk.pU(false);
        this.iOk.pT(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iOk.bPp();
        this.iOk.getListView().getData().clear();
        this.iOk.cza();
        if (this.iOp == null) {
            this.iOp = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iOp.setTitle(null);
            this.iOp.setSubText(null);
            this.iOp.setButtonText(null);
            this.iOp.showRefreshButton();
            this.iOp.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iOp.onChangeSkinType();
        this.iOp.attachView(this.iOk.cjt(), true);
        MessageManager.getInstance().registerListener(this.iLE);
    }

    private void VB() {
        this.iOk.pU(true);
        this.iOk.pT(true);
        if (this.iOp != null && this.iOp.isViewAttached()) {
            this.iOp.dettachView(this.iOk.cjt());
            MessageManager.getInstance().unRegisterListener(this.iLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            zI(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iLE);
        if (this.iOk != null) {
            this.iOk.onDestroy();
        }
        if (this.iOm != null) {
            this.iOm.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void brR() {
        if (this.iOk != null) {
            if (j.isNetWorkAvailable()) {
                zI(2);
                if (y.isEmpty(this.ihK)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.iOk.ld(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void brS() {
    }
}
