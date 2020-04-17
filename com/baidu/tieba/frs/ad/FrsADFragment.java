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
    private String gYi;
    private ADRequestModel.a hda;
    private ADRequestModel hdb;
    private a hdc;
    private List<c> hdd;
    private com.baidu.tbadk.k.c hde;
    private String mFrom;
    private boolean mHasMore;
    protected e hcZ = null;
    private int offset = 0;
    public int WA = 0;
    private ArrayList<m> gxX = new ArrayList<>();
    private int cCF = 0;
    private int gZl = 0;
    private CustomMessageListener hbp = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.hde != null && FrsADFragment.this.hde.isViewAttached()) {
                FrsADFragment.this.hde.mQ(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.gZl += i2;
            if (FrsADFragment.this.gZl >= FrsADFragment.this.cCF * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener hdf = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hde != null && FrsADFragment.this.hde.isViewAttached()) {
                        FrsADFragment.this.tD(0);
                    } else if (FrsADFragment.this.hcZ != null) {
                        FrsADFragment.this.hcZ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener gZo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hde != null && FrsADFragment.this.hde.isViewAttached()) {
                        FrsADFragment.this.tD(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.hcZ != null) {
                        FrsADFragment.this.hcZ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private v gZK = new v() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.v
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.bad() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aOY().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bad(), arrayList)});
                if (!aq.isEmpty(cVar.bQM())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13194").cI("obj_type", cVar.bQM()).t("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bQJ();
    }

    private void bQJ() {
        if (isPrimary()) {
            if (this.hde != null && this.hde.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hbp);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.hdf);
        registerListener(this.gZo);
        if (this.hdb == null) {
            this.hdb = new ADRequestModel(this.context);
        }
        this.cCF = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.gYi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gYi = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.hcZ = new e(this, inflate);
        this.hcZ.setOnScrollListener(this.mScrollListener);
        this.hdc = new a(this, this.hcZ.getListView());
        this.hdc.a(this.gZK);
        if (this.hda == null) {
            this.hda = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.hcZ != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.hdd = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.FH();
                            return;
                        }
                        FrsADFragment.this.bls();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.hcZ != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.hdd = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.FH();
                            return;
                        }
                        FrsADFragment.this.bls();
                    }
                }
            };
        }
        this.hdb.a(this.hda);
        if (!j.isNetWorkAvailable()) {
            bls();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH() {
        if (this.hcZ != null) {
            hideLoadingView();
            this.hcZ.bQT();
            if (this.WA == 0) {
                if (!com.baidu.tbadk.core.util.v.isEmpty(this.hdd)) {
                    O(true, false);
                    this.hcZ.bmp();
                    return;
                }
                aqF();
            } else if (this.WA == 2) {
                this.hcZ.it(false);
                if (!com.baidu.tbadk.core.util.v.isEmpty(this.hdd)) {
                    O(true, false);
                    this.hcZ.bmp();
                    return;
                }
                aqF();
            } else if (this.WA == 1) {
                if (!com.baidu.tbadk.core.util.v.isEmpty(this.hdd)) {
                    O(false, true);
                } else {
                    this.hcZ.bmp();
                }
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.gxX != null) {
            if (z) {
                this.gxX.clear();
            }
            if (z2) {
                for (int i = 0; i < this.gxX.size(); i++) {
                    m mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.gxX, i);
                    if (mVar instanceof c) {
                        ((c) mVar).mM(false);
                    }
                }
            }
            this.gxX.addAll(this.hdd);
            this.hcZ.bQS().setData(this.gxX);
            this.hcZ.bQS().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.al
    public void bOe() {
        if (this.hcZ != null && this.hcZ.getListView() != null) {
            this.hcZ.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bmn() {
        if (this.hcZ != null) {
            bOe();
            this.hcZ.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hcZ != null) {
            if (this.hcZ != null && this.hcZ.getListView() != null) {
                this.hcZ.getListView().stopScroll();
            }
            blq();
            if (l.isNetOk() && this.mHasMore) {
                tD(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hcZ != null) {
            this.hcZ.onChangeSkinType(i);
        }
        if (this.hde != null && this.hde.isViewAttached()) {
            this.hde.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tD(int i) {
        if (this.hdb != null) {
            blt();
            this.WA = i;
            if (i == 0 || i == 2) {
                this.hdb.a(this.forumId, 0, 20);
            } else if (i == 1) {
                this.hdb.a(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.hcZ == null) {
            return null;
        }
        return this.hcZ.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            tD(0);
            showLoadingView();
            return;
        }
        bls();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").t("fid", this.forumId).af("obj_type", 9).af("obj_locate", 2).cI("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.hcZ.mO(false);
        showLoadingView(this.hcZ.bCt(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.hcZ.mO(true);
        hideLoadingView(this.hcZ.bCt());
    }

    private void blq() {
        if (!this.mHasMore) {
            if (com.baidu.tbadk.core.util.v.isEmpty(this.hdd)) {
                this.hcZ.bmq();
                return;
            } else {
                this.hcZ.bmp();
                return;
            }
        }
        this.hcZ.bmo();
    }

    private void aqF() {
        if (this.gxX != null && this.hcZ != null) {
            this.gxX.add(new p());
            this.hcZ.bQS().setData(this.gxX);
            this.hcZ.bQS().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bls() {
        this.hcZ.mO(false);
        this.hcZ.mN(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hcZ.bmq();
        this.hcZ.getListView().getData().clear();
        this.hcZ.bPE();
        if (this.hde == null) {
            this.hde = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hde.setTitle(null);
            this.hde.setSubText(null);
            this.hde.setButtonText(null);
            this.hde.showRefreshButton();
            this.hde.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hde.onChangeSkinType();
        this.hde.attachView(this.hcZ.bCt(), true);
        MessageManager.getInstance().registerListener(this.hbp);
    }

    private void blt() {
        this.hcZ.mO(true);
        this.hcZ.mN(true);
        if (this.hde != null && this.hde.isViewAttached()) {
            this.hde.dettachView(this.hcZ.bCt());
            MessageManager.getInstance().unRegisterListener(this.hbp);
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
        MessageManager.getInstance().unRegisterListener(this.hbp);
        if (this.hcZ != null) {
            this.hcZ.onDestroy();
        }
        if (this.hdb != null) {
            this.hdb.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.an
    public void aQn() {
        if (this.hcZ != null) {
            if (j.isNetWorkAvailable()) {
                tD(2);
                if (com.baidu.tbadk.core.util.v.isEmpty(this.gxX)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.hcZ.it(false);
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aQo() {
    }
}
