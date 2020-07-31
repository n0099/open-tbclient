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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, aq, as {
    private TbPageContext context;
    private long forumId;
    private String hFr;
    private ADRequestModel.a hKT;
    private ADRequestModel hKU;
    private a hKV;
    private List<c> hKW;
    private com.baidu.tbadk.k.c hKX;
    private String mFrom;
    private boolean mHasMore;
    protected e hKS = null;
    private int offset = 0;
    public int Xq = 0;
    private ArrayList<q> hfz = new ArrayList<>();
    private int cXV = 0;
    private int hGx = 0;
    private CustomMessageListener hJb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.hKX != null && FrsADFragment.this.hKX.isViewAttached()) {
                FrsADFragment.this.hKX.oh(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.hGx += i2;
            if (FrsADFragment.this.hGx >= FrsADFragment.this.cXV * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener hKY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hKX != null && FrsADFragment.this.hKX.isViewAttached()) {
                        FrsADFragment.this.vh(0);
                    } else if (FrsADFragment.this.hKS != null) {
                        FrsADFragment.this.hKS.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener hGL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hKX != null && FrsADFragment.this.hKX.isViewAttached()) {
                        FrsADFragment.this.vh(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.hKS != null) {
                        FrsADFragment.this.hKS.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private z hHk = new z() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bmn() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bd.baV().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bmn(), arrayList)});
                if (!com.baidu.tbadk.core.util.as.isEmpty(cVar.cdT())) {
                    TiebaStatic.log(new ap("c13194").dn("obj_type", cVar.cdT()).t("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cdQ();
    }

    private void cdQ() {
        if (isPrimary()) {
            if (this.hKX != null && this.hKX.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hJb);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.hKY);
        registerListener(this.hGL);
        if (this.hKU == null) {
            this.hKU = new ADRequestModel(this.context);
        }
        this.cXV = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.hFr = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hFr = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.hKS = new e(this, inflate);
        this.hKS.setOnScrollListener(this.mScrollListener);
        this.hKV = new a(this, this.hKS.getListView());
        this.hKV.a(this.hHk);
        if (this.hKT == null) {
            this.hKT = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.hKS != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.hKW = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.IH();
                            return;
                        }
                        FrsADFragment.this.bwW();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.hKS != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.hKW = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.IH();
                            return;
                        }
                        FrsADFragment.this.bwW();
                    }
                }
            };
        }
        this.hKU.a(this.hKT);
        if (!j.isNetWorkAvailable()) {
            bwW();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IH() {
        if (this.hKS != null) {
            hideLoadingView();
            this.hKS.cea();
            if (this.Xq == 0) {
                if (!x.isEmpty(this.hKW)) {
                    S(true, false);
                    this.hKS.bxT();
                    return;
                }
                bxb();
            } else if (this.Xq == 2) {
                this.hKS.jH(false);
                if (!x.isEmpty(this.hKW)) {
                    S(true, false);
                    this.hKS.bxT();
                    return;
                }
                bxb();
            } else if (this.Xq == 1) {
                if (!x.isEmpty(this.hKW)) {
                    S(false, true);
                } else {
                    this.hKS.bxT();
                }
            }
        }
    }

    private void S(boolean z, boolean z2) {
        if (this.hfz != null) {
            if (z) {
                this.hfz.clear();
            }
            if (z2) {
                for (int i = 0; i < this.hfz.size(); i++) {
                    q qVar = (q) x.getItem(this.hfz, i);
                    if (qVar instanceof c) {
                        ((c) qVar).nX(false);
                    }
                }
            }
            this.hfz.addAll(this.hKW);
            com.baidu.tbadk.a.a.a.aG(this.hfz);
            this.hKS.cdZ().setData(this.hfz);
            this.hKS.cdZ().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.aq
    public void cbd() {
        if (this.hKS != null && this.hKS.getListView() != null) {
            this.hKS.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxR() {
        if (this.hKS != null) {
            cbd();
            this.hKS.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hKS != null) {
            if (this.hKS != null && this.hKS.getListView() != null) {
                this.hKS.getListView().stopScroll();
            }
            bwT();
            if (l.isNetOk() && this.mHasMore) {
                vh(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hKS != null) {
            this.hKS.onChangeSkinType(i);
        }
        if (this.hKX != null && this.hKX.isViewAttached()) {
            this.hKX.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(int i) {
        if (this.hKU != null) {
            bwX();
            this.Xq = i;
            if (i == 0 || i == 2) {
                this.hKU.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.hKU.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.hKS == null) {
            return null;
        }
        return this.hKS.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            vh(0);
            showLoadingView();
            return;
        }
        bwW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ap("c13008").t("fid", this.forumId).ah("obj_type", 9).ah("obj_locate", 2).dn("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.hKS.nZ(false);
        showLoadingView(this.hKS.bPb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.hKS.nZ(true);
        hideLoadingView(this.hKS.bPb());
    }

    private void bwT() {
        if (!this.mHasMore) {
            if (x.isEmpty(this.hKW)) {
                this.hKS.bxU();
                return;
            } else {
                this.hKS.bxT();
                return;
            }
        }
        this.hKS.bxS();
    }

    private void bxb() {
        if (this.hfz != null && this.hKS != null) {
            this.hfz.add(new r());
            this.hKS.cdZ().setData(this.hfz);
            this.hKS.cdZ().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwW() {
        this.hKS.nZ(false);
        this.hKS.nY(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hKS.bxU();
        this.hKS.getListView().getData().clear();
        this.hKS.ccH();
        if (this.hKX == null) {
            this.hKX = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hKX.setTitle(null);
            this.hKX.setSubText(null);
            this.hKX.setButtonText(null);
            this.hKX.showRefreshButton();
            this.hKX.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hKX.onChangeSkinType();
        this.hKX.attachView(this.hKS.bPb(), true);
        MessageManager.getInstance().registerListener(this.hJb);
    }

    private void bwX() {
        this.hKS.nZ(true);
        this.hKS.nY(true);
        if (this.hKX != null && this.hKX.isViewAttached()) {
            this.hKX.dettachView(this.hKS.bPb());
            MessageManager.getInstance().unRegisterListener(this.hJb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            vh(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hJb);
        if (this.hKS != null) {
            this.hKS.onDestroy();
        }
        if (this.hKU != null) {
            this.hKU.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.as
    public void bcg() {
        if (this.hKS != null) {
            if (j.isNetWorkAvailable()) {
                vh(2);
                if (x.isEmpty(this.hfz)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.hKS.jH(false);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bch() {
    }
}
