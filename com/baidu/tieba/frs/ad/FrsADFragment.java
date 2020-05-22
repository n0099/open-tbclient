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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
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
    private String hna;
    private ADRequestModel.a hrU;
    private ADRequestModel hrV;
    private a hrW;
    private List<c> hrX;
    private com.baidu.tbadk.k.c hrY;
    private String mFrom;
    private boolean mHasMore;
    protected e hrT = null;
    private int offset = 0;
    public int WR = 0;
    private ArrayList<o> gMN = new ArrayList<>();
    private int cOy = 0;
    private int hod = 0;
    private CustomMessageListener hqj = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.hrY != null && FrsADFragment.this.hrY.isViewAttached()) {
                FrsADFragment.this.hrY.ns(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.hod += i2;
            if (FrsADFragment.this.hod >= FrsADFragment.this.cOy * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener hrZ = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hrY != null && FrsADFragment.this.hrY.isViewAttached()) {
                        FrsADFragment.this.ui(0);
                    } else if (FrsADFragment.this.hrT != null) {
                        FrsADFragment.this.hrT.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener hoi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hrY != null && FrsADFragment.this.hrY.isViewAttached()) {
                        FrsADFragment.this.ui(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.hrT != null) {
                        FrsADFragment.this.hrT.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private x hoE = new x() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (oVar != null && (oVar instanceof c) && (cVar = (c) oVar) != null && cVar.bgl() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aUZ().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bgl(), arrayList)});
                if (!aq.isEmpty(cVar.bXh())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13194").dh("obj_type", cVar.bXh()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bXe();
    }

    private void bXe() {
        if (isPrimary()) {
            if (this.hrY != null && this.hrY.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hqj);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.hrZ);
        registerListener(this.hoi);
        if (this.hrV == null) {
            this.hrV = new ADRequestModel(this.context);
        }
        this.cOy = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.hna = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hna = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.hrT = new e(this, inflate);
        this.hrT.setOnScrollListener(this.mScrollListener);
        this.hrW = new a(this, this.hrT.getListView());
        this.hrW.a(this.hoE);
        if (this.hrU == null) {
            this.hrU = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.hrT != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.hrX = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Ho();
                            return;
                        }
                        FrsADFragment.this.bqN();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.hrT != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.hrX = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Ho();
                            return;
                        }
                        FrsADFragment.this.bqN();
                    }
                }
            };
        }
        this.hrV.a(this.hrU);
        if (!j.isNetWorkAvailable()) {
            bqN();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ho() {
        if (this.hrT != null) {
            hideLoadingView();
            this.hrT.bXo();
            if (this.WR == 0) {
                if (!v.isEmpty(this.hrX)) {
                    R(true, false);
                    this.hrT.brL();
                    return;
                }
                bqS();
            } else if (this.WR == 2) {
                this.hrT.iQ(false);
                if (!v.isEmpty(this.hrX)) {
                    R(true, false);
                    this.hrT.brL();
                    return;
                }
                bqS();
            } else if (this.WR == 1) {
                if (!v.isEmpty(this.hrX)) {
                    R(false, true);
                } else {
                    this.hrT.brL();
                }
            }
        }
    }

    private void R(boolean z, boolean z2) {
        if (this.gMN != null) {
            if (z) {
                this.gMN.clear();
            }
            if (z2) {
                for (int i = 0; i < this.gMN.size(); i++) {
                    o oVar = (o) v.getItem(this.gMN, i);
                    if (oVar instanceof c) {
                        ((c) oVar).nh(false);
                    }
                }
            }
            this.gMN.addAll(this.hrX);
            com.baidu.tbadk.a.a.c.a(com.baidu.tbadk.a.a.c.aMx(), this.gMN);
            this.hrT.bXn().setData(this.gMN);
            this.hrT.bXn().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.al
    public void bUy() {
        if (this.hrT != null && this.hrT.getListView() != null) {
            this.hrT.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void brJ() {
        if (this.hrT != null) {
            bUy();
            this.hrT.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hrT != null) {
            if (this.hrT != null && this.hrT.getListView() != null) {
                this.hrT.getListView().stopScroll();
            }
            bqK();
            if (l.isNetOk() && this.mHasMore) {
                ui(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hrT != null) {
            this.hrT.onChangeSkinType(i);
        }
        if (this.hrY != null && this.hrY.isViewAttached()) {
            this.hrY.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(int i) {
        if (this.hrV != null) {
            bqO();
            this.WR = i;
            if (i == 0 || i == 2) {
                this.hrV.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.hrV.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.hrT == null) {
            return null;
        }
        return this.hrT.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            ui(0);
            showLoadingView();
            return;
        }
        bqN();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c13008").s("fid", this.forumId).ag("obj_type", 9).ag("obj_locate", 2).dh("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.hrT.nj(false);
        showLoadingView(this.hrT.bIL(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.hrT.nj(true);
        hideLoadingView(this.hrT.bIL());
    }

    private void bqK() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.hrX)) {
                this.hrT.brM();
                return;
            } else {
                this.hrT.brL();
                return;
            }
        }
        this.hrT.brK();
    }

    private void bqS() {
        if (this.gMN != null && this.hrT != null) {
            this.gMN.add(new p());
            this.hrT.bXn().setData(this.gMN);
            this.hrT.bXn().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqN() {
        this.hrT.nj(false);
        this.hrT.ni(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hrT.brM();
        this.hrT.getListView().getData().clear();
        this.hrT.bVZ();
        if (this.hrY == null) {
            this.hrY = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hrY.setTitle(null);
            this.hrY.setSubText(null);
            this.hrY.setButtonText(null);
            this.hrY.showRefreshButton();
            this.hrY.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hrY.onChangeSkinType();
        this.hrY.attachView(this.hrT.bIL(), true);
        MessageManager.getInstance().registerListener(this.hqj);
    }

    private void bqO() {
        this.hrT.nj(true);
        this.hrT.ni(true);
        if (this.hrY != null && this.hrY.isViewAttached()) {
            this.hrY.dettachView(this.hrT.bIL());
            MessageManager.getInstance().unRegisterListener(this.hqj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            ui(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hqj);
        if (this.hrT != null) {
            this.hrT.onDestroy();
        }
        if (this.hrV != null) {
            this.hrV.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.an
    public void aWo() {
        if (this.hrT != null) {
            if (j.isNetWorkAvailable()) {
                ui(2);
                if (v.isEmpty(this.gMN)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.hrT.iQ(false);
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
    }
}
