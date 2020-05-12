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
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, al, an {
    private TbPageContext context;
    private long forumId;
    private String gYo;
    private ADRequestModel.a hdg;
    private ADRequestModel hdh;
    private a hdi;
    private List<c> hdj;
    private com.baidu.tbadk.k.c hdk;
    private String mFrom;
    private boolean mHasMore;
    protected e hdf = null;
    private int offset = 0;
    public int WD = 0;
    private ArrayList<m> gyd = new ArrayList<>();
    private int cCL = 0;
    private int gZr = 0;
    private CustomMessageListener hbv = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.hdk != null && FrsADFragment.this.hdk.isViewAttached()) {
                FrsADFragment.this.hdk.mQ(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.gZr += i2;
            if (FrsADFragment.this.gZr >= FrsADFragment.this.cCL * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener hdl = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hdk != null && FrsADFragment.this.hdk.isViewAttached()) {
                        FrsADFragment.this.tD(0);
                    } else if (FrsADFragment.this.hdf != null) {
                        FrsADFragment.this.hdf.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener gZu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hdk != null && FrsADFragment.this.hdk.isViewAttached()) {
                        FrsADFragment.this.tD(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.hdf != null) {
                        FrsADFragment.this.hdf.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private v gZQ = new v() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.bab() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aOV().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bab(), arrayList)});
                if (!aq.isEmpty(cVar.bQL())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13194").cI("obj_type", cVar.bQL()).t("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bQI();
    }

    private void bQI() {
        if (isPrimary()) {
            if (this.hdk != null && this.hdk.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hbv);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hbv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.hdl);
        registerListener(this.gZu);
        if (this.hdh == null) {
            this.hdh = new ADRequestModel(this.context);
        }
        this.cCL = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.gYo = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gYo = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.hdf = new e(this, inflate);
        this.hdf.setOnScrollListener(this.mScrollListener);
        this.hdi = new a(this, this.hdf.getListView());
        this.hdi.a(this.gZQ);
        if (this.hdg == null) {
            this.hdg = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.hdf != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.hdj = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.FG();
                            return;
                        }
                        FrsADFragment.this.blq();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.hdf != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.hdj = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.FG();
                            return;
                        }
                        FrsADFragment.this.blq();
                    }
                }
            };
        }
        this.hdh.a(this.hdg);
        if (!j.isNetWorkAvailable()) {
            blq();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FG() {
        if (this.hdf != null) {
            hideLoadingView();
            this.hdf.bQS();
            if (this.WD == 0) {
                if (!com.baidu.tbadk.core.util.v.isEmpty(this.hdj)) {
                    O(true, false);
                    this.hdf.bmn();
                    return;
                }
                aqE();
            } else if (this.WD == 2) {
                this.hdf.it(false);
                if (!com.baidu.tbadk.core.util.v.isEmpty(this.hdj)) {
                    O(true, false);
                    this.hdf.bmn();
                    return;
                }
                aqE();
            } else if (this.WD == 1) {
                if (!com.baidu.tbadk.core.util.v.isEmpty(this.hdj)) {
                    O(false, true);
                } else {
                    this.hdf.bmn();
                }
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.gyd != null) {
            if (z) {
                this.gyd.clear();
            }
            if (z2) {
                for (int i = 0; i < this.gyd.size(); i++) {
                    m mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.gyd, i);
                    if (mVar instanceof c) {
                        ((c) mVar).mM(false);
                    }
                }
            }
            this.gyd.addAll(this.hdj);
            this.hdf.bQR().setData(this.gyd);
            this.hdf.bQR().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.al
    public void bOd() {
        if (this.hdf != null && this.hdf.getListView() != null) {
            this.hdf.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bml() {
        if (this.hdf != null) {
            bOd();
            this.hdf.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hdf != null) {
            if (this.hdf != null && this.hdf.getListView() != null) {
                this.hdf.getListView().stopScroll();
            }
            blo();
            if (l.isNetOk() && this.mHasMore) {
                tD(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hdf != null) {
            this.hdf.onChangeSkinType(i);
        }
        if (this.hdk != null && this.hdk.isViewAttached()) {
            this.hdk.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tD(int i) {
        if (this.hdh != null) {
            blr();
            this.WD = i;
            if (i == 0 || i == 2) {
                this.hdh.a(this.forumId, 0, 20);
            } else if (i == 1) {
                this.hdh.a(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.hdf == null) {
            return null;
        }
        return this.hdf.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            tD(0);
            showLoadingView();
            return;
        }
        blq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").t("fid", this.forumId).af("obj_type", 9).af("obj_locate", 2).cI("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.hdf.mO(false);
        showLoadingView(this.hdf.bCr(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.hdf.mO(true);
        hideLoadingView(this.hdf.bCr());
    }

    private void blo() {
        if (!this.mHasMore) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.hdj)) {
                this.hdf.bmo();
                return;
            } else {
                this.hdf.bmn();
                return;
            }
        }
        this.hdf.bmm();
    }

    private void aqE() {
        if (this.gyd != null && this.hdf != null) {
            this.gyd.add(new p());
            this.hdf.bQR().setData(this.gyd);
            this.hdf.bQR().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blq() {
        this.hdf.mO(false);
        this.hdf.mN(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hdf.bmo();
        this.hdf.getListView().getData().clear();
        this.hdf.bPD();
        if (this.hdk == null) {
            this.hdk = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hdk.setTitle(null);
            this.hdk.setSubText(null);
            this.hdk.setButtonText(null);
            this.hdk.showRefreshButton();
            this.hdk.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hdk.onChangeSkinType();
        this.hdk.attachView(this.hdf.bCr(), true);
        MessageManager.getInstance().registerListener(this.hbv);
    }

    private void blr() {
        this.hdf.mO(true);
        this.hdf.mN(true);
        if (this.hdk != null && this.hdk.isViewAttached()) {
            this.hdk.dettachView(this.hdf.bCr());
            MessageManager.getInstance().unRegisterListener(this.hbv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            tD(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hbv);
        if (this.hdf != null) {
            this.hdf.onDestroy();
        }
        if (this.hdh != null) {
            this.hdh.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.an
    public void aQk() {
        if (this.hdf != null) {
            if (j.isNetWorkAvailable()) {
                tD(2);
                if (com.baidu.tbadk.core.util.v.isEmpty(this.gyd)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.hdf.it(false);
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aQl() {
    }
}
