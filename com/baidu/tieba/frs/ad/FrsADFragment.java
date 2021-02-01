package com.baidu.tieba.frs.ad;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ao, aq {
    private TbPageContext context;
    private long forumId;
    private String jfZ;
    private ADRequestModel.a jms;
    private ADRequestModel jmt;
    private a jmu;
    private List<c> jmv;
    private com.baidu.tbadk.l.c jmw;
    private String mFrom;
    private boolean mHasMore;
    protected e jmr = null;
    private int offset = 0;
    public int aam = 0;
    private ArrayList<n> iFV = new ArrayList<>();
    private int dVi = 0;
    private int jhe = 0;
    private CustomMessageListener jjL = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.jmw != null && FrsADFragment.this.jmw.isViewAttached()) {
                FrsADFragment.this.jmw.rm(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.jhe += i2;
            if (FrsADFragment.this.jhe >= FrsADFragment.this.dVi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener jmx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jmw != null && FrsADFragment.this.jmw.isViewAttached()) {
                        FrsADFragment.this.zd(0);
                    } else if (FrsADFragment.this.jmr != null) {
                        FrsADFragment.this.jmr.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener jht = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jmw != null && FrsADFragment.this.jmw.isViewAttached()) {
                        FrsADFragment.this.zd(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.jmr != null) {
                        FrsADFragment.this.jmr.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private w jhT = new w() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (nVar != null && (nVar instanceof c) && (cVar = (c) nVar) != null && cVar.bEY() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bf.bsV().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bEY(), arrayList)});
                if (!au.isEmpty(cVar.cFb())) {
                    TiebaStatic.log(new ar("c13194").dR("obj_type", cVar.cFb()).v("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cEY();
    }

    private void cEY() {
        if (isPrimary()) {
            if (this.jmw != null && this.jmw.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjL);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.jmx);
        registerListener(this.jht);
        if (this.jmt == null) {
            this.jmt = new ADRequestModel(this.context);
        }
        this.dVi = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jfZ = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.jfZ = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.jmr = new e(this, inflate);
        this.jmr.setOnScrollListener(this.mScrollListener);
        this.jmu = new a(this, this.jmr.getListView());
        this.jmu.a(this.jhT);
        if (this.jms == null) {
            this.jms = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.jmr != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.jmv = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Ut();
                            return;
                        }
                        FrsADFragment.this.bRu();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.jmr != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.jmv = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Ut();
                            return;
                        }
                        FrsADFragment.this.bRu();
                    }
                }
            };
        }
        if (this.jmt == null) {
            this.jmt = new ADRequestModel(this.context);
        }
        this.jmt.a(this.jms);
        if (!j.isNetWorkAvailable()) {
            bRu();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ut() {
        if (this.jmr != null) {
            hideLoadingView();
            this.jmr.cFi();
            if (this.aam == 0) {
                if (!y.isEmpty(this.jmv)) {
                    ac(true, false);
                    this.jmr.WY();
                    return;
                }
                bRy();
            } else if (this.aam == 2) {
                this.jmr.lU(false);
                if (!y.isEmpty(this.jmv)) {
                    ac(true, false);
                    this.jmr.WY();
                    return;
                }
                bRy();
            } else if (this.aam == 1) {
                if (!y.isEmpty(this.jmv)) {
                    ac(false, true);
                } else {
                    this.jmr.WY();
                }
            }
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.iFV != null) {
            if (z) {
                this.iFV.clear();
            }
            if (z2) {
                for (int i = 0; i < this.iFV.size(); i++) {
                    n nVar = (n) y.getItem(this.iFV, i);
                    if (nVar instanceof c) {
                        ((c) nVar).qT(false);
                    }
                }
            }
            this.iFV.addAll(this.jmv);
            com.baidu.tbadk.a.a.a.bj(this.iFV);
            this.jmr.cFh().setData(this.iFV);
            this.jmr.cFh().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = 90;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ao
    public void cBZ() {
        if (this.jmr != null && this.jmr.getListView() != null) {
            this.jmr.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSq() {
        if (this.jmr != null) {
            cBZ();
            this.jmr.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jmr != null) {
            if (this.jmr != null && this.jmr.getListView() != null) {
                this.jmr.getListView().stopScroll();
            }
            bRr();
            if (l.isNetOk() && this.mHasMore) {
                zd(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jmr != null) {
            this.jmr.onChangeSkinType(i);
        }
        if (this.jmw != null && this.jmw.isViewAttached()) {
            this.jmw.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zd(int i) {
        if (this.jmt != null) {
            WZ();
            this.aam = i;
            if (i == 0 || i == 2) {
                this.jmt.f(this.forumId, 0, 20);
            } else if (i == 1) {
                this.jmt.f(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.jmr == null) {
            return null;
        }
        return this.jmr.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            zd(0);
            showLoadingView();
            return;
        }
        bRu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ar("c13008").v("fid", this.forumId).ap("obj_type", 9).ap("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jmr.qV(false);
        showLoadingView(this.jmr.cnn(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.jmr.qV(true);
        hideLoadingView(this.jmr.cnn());
    }

    private void bRr() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.jmv)) {
                this.jmr.bSr();
                return;
            } else {
                this.jmr.WY();
                return;
            }
        }
        this.jmr.WX();
    }

    private void bRy() {
        if (this.iFV != null && this.jmr != null) {
            this.iFV.add(new s());
            this.jmr.cFh().setData(this.iFV);
            this.jmr.cFh().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRu() {
        this.jmr.qV(false);
        this.jmr.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jmr.bSr();
        this.jmr.getListView().getData().clear();
        this.jmr.cDH();
        if (this.jmw == null) {
            this.jmw = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jmw.setTitle(null);
            this.jmw.setSubText(null);
            this.jmw.setButtonText(null);
            this.jmw.showRefreshButton();
            this.jmw.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jmw.onChangeSkinType();
        this.jmw.attachView(this.jmr.cnn(), true);
        MessageManager.getInstance().registerListener(this.jjL);
    }

    private void WZ() {
        this.jmr.qV(true);
        this.jmr.qU(true);
        if (this.jmw != null && this.jmw.isViewAttached()) {
            this.jmw.dettachView(this.jmr.cnn());
            MessageManager.getInstance().unRegisterListener(this.jjL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            zd(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jjL);
        if (this.jmr != null) {
            this.jmr.onDestroy();
        }
        if (this.jmt != null) {
            this.jmt.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bum() {
        if (this.jmr != null) {
            if (j.isNetWorkAvailable()) {
                zd(2);
                if (y.isEmpty(this.iFV)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.jmr.lU(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
    }
}
