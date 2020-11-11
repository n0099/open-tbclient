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
    private String iHh;
    private a iNA;
    private List<c> iNB;
    private com.baidu.tbadk.k.c iNC;
    private ADRequestModel.a iNy;
    private ADRequestModel iNz;
    private String mFrom;
    private boolean mHasMore;
    protected e iNx = null;
    private int offset = 0;
    public int YH = 0;
    private ArrayList<q> igW = new ArrayList<>();
    private int dJG = 0;
    private int iIn = 0;
    private CustomMessageListener iKR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.iNC != null && FrsADFragment.this.iNC.isViewAttached()) {
                FrsADFragment.this.iNC.rC(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.iIn += i2;
            if (FrsADFragment.this.iIn >= FrsADFragment.this.dJG * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener iND = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iNC != null && FrsADFragment.this.iNC.isViewAttached()) {
                        FrsADFragment.this.zk(0);
                    } else if (FrsADFragment.this.iNx != null) {
                        FrsADFragment.this.iNx.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iNC != null && FrsADFragment.this.iNC.isViewAttached()) {
                        FrsADFragment.this.zk(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.iNx != null) {
                        FrsADFragment.this.iNx.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab iJa = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bDh() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                be.brr().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bDh(), arrayList)});
                if (!at.isEmpty(cVar.cAR())) {
                    TiebaStatic.log(new aq("c13194").dR("obj_type", cVar.cAR()).w("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cAO();
    }

    private void cAO() {
        if (isPrimary()) {
            if (this.iNC != null && this.iNC.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iKR);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.iND);
        registerListener(this.iIB);
        if (this.iNz == null) {
            this.iNz = new ADRequestModel(this.context);
        }
        this.dJG = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.iHh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iHh = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.iNx = new e(this, inflate);
        this.iNx.setOnScrollListener(this.mScrollListener);
        this.iNA = new a(this, this.iNx.getListView());
        this.iNA.a(this.iJa);
        if (this.iNy == null) {
            this.iNy = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.iNx != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.iNB = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.TL();
                            return;
                        }
                        FrsADFragment.this.bPa();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.iNx != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.iNB = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.TL();
                            return;
                        }
                        FrsADFragment.this.bPa();
                    }
                }
            };
        }
        this.iNz.a(this.iNy);
        if (!j.isNetWorkAvailable()) {
            bPa();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TL() {
        if (this.iNx != null) {
            hideLoadingView();
            this.iNx.cAY();
            if (this.YH == 0) {
                if (!y.isEmpty(this.iNB)) {
                    aa(true, false);
                    this.iNx.Wj();
                    return;
                }
                bPe();
            } else if (this.YH == 2) {
                this.iNx.lc(false);
                if (!y.isEmpty(this.iNB)) {
                    aa(true, false);
                    this.iNx.Wj();
                    return;
                }
                bPe();
            } else if (this.YH == 1) {
                if (!y.isEmpty(this.iNB)) {
                    aa(false, true);
                } else {
                    this.iNx.Wj();
                }
            }
        }
    }

    private void aa(boolean z, boolean z2) {
        if (this.igW != null) {
            if (z) {
                this.igW.clear();
            }
            if (z2) {
                for (int i = 0; i < this.igW.size(); i++) {
                    q qVar = (q) y.getItem(this.igW, i);
                    if (qVar instanceof c) {
                        ((c) qVar).pP(false);
                    }
                }
            }
            this.igW.addAll(this.iNB);
            com.baidu.tbadk.a.a.a.be(this.igW);
            this.iNx.cAX().setData(this.igW);
            this.iNx.cAX().notifyDataSetChanged();
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
    public void cxS() {
        if (this.iNx != null && this.iNx.getListView() != null) {
            this.iNx.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bPV() {
        if (this.iNx != null) {
            cxS();
            this.iNx.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iNx != null) {
            if (this.iNx != null && this.iNx.getListView() != null) {
                this.iNx.getListView().stopScroll();
            }
            bOX();
            if (l.isNetOk() && this.mHasMore) {
                zk(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iNx != null) {
            this.iNx.onChangeSkinType(i);
        }
        if (this.iNC != null && this.iNC.isViewAttached()) {
            this.iNC.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(int i) {
        if (this.iNz != null) {
            Wk();
            this.YH = i;
            if (i == 0 || i == 2) {
                this.iNz.e(this.forumId, 0, 20);
            } else if (i == 1) {
                this.iNz.e(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.iNx == null) {
            return null;
        }
        return this.iNx.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            zk(0);
            showLoadingView();
            return;
        }
        bPa();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").w("fid", this.forumId).al("obj_type", 9).al("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.iNx.pR(false);
        showLoadingView(this.iNx.cka(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.iNx.pR(true);
        hideLoadingView(this.iNx.cka());
    }

    private void bOX() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.iNB)) {
                this.iNx.bPW();
                return;
            } else {
                this.iNx.Wj();
                return;
            }
        }
        this.iNx.Wi();
    }

    private void bPe() {
        if (this.igW != null && this.iNx != null) {
            this.igW.add(new s());
            this.iNx.cAX().setData(this.igW);
            this.iNx.cAX().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPa() {
        this.iNx.pR(false);
        this.iNx.pQ(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iNx.bPW();
        this.iNx.getListView().getData().clear();
        this.iNx.czx();
        if (this.iNC == null) {
            this.iNC = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iNC.setTitle(null);
            this.iNC.setSubText(null);
            this.iNC.setButtonText(null);
            this.iNC.showRefreshButton();
            this.iNC.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iNC.onChangeSkinType();
        this.iNC.attachView(this.iNx.cka(), true);
        MessageManager.getInstance().registerListener(this.iKR);
    }

    private void Wk() {
        this.iNx.pR(true);
        this.iNx.pQ(true);
        if (this.iNC != null && this.iNC.isViewAttached()) {
            this.iNC.dettachView(this.iNx.cka());
            MessageManager.getInstance().unRegisterListener(this.iKR);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            zk(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iKR);
        if (this.iNx != null) {
            this.iNx.onDestroy();
        }
        if (this.iNz != null) {
            this.iNz.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bsB() {
        if (this.iNx != null) {
            if (j.isNetWorkAvailable()) {
                zk(2);
                if (y.isEmpty(this.igW)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.iNx.lc(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bsC() {
    }
}
