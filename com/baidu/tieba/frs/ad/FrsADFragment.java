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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
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
    private String jat;
    private ADRequestModel.a jgK;
    private ADRequestModel jgL;
    private a jgM;
    private List<c> jgN;
    private com.baidu.tbadk.l.c jgO;
    private String mFrom;
    private boolean mHasMore;
    protected e jgJ = null;
    private int offset = 0;
    public int aaq = 0;
    private ArrayList<n> iAl = new ArrayList<>();
    private int dTc = 0;
    private int jby = 0;
    private CustomMessageListener jee = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.jgO != null && FrsADFragment.this.jgO.isViewAttached()) {
                FrsADFragment.this.jgO.rh(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.jby += i2;
            if (FrsADFragment.this.jby >= FrsADFragment.this.dTc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener jgP = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jgO != null && FrsADFragment.this.jgO.isViewAttached()) {
                        FrsADFragment.this.yT(0);
                    } else if (FrsADFragment.this.jgJ != null) {
                        FrsADFragment.this.jgJ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener jbN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jgO != null && FrsADFragment.this.jgO.isViewAttached()) {
                        FrsADFragment.this.yT(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.jgJ != null) {
                        FrsADFragment.this.jgJ.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private w jcn = new w() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (nVar != null && (nVar instanceof c) && (cVar = (c) nVar) != null && cVar.bEF() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                be.bsB().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bEF(), arrayList)});
                if (!at.isEmpty(cVar.cDP())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13194").dW("obj_type", cVar.cDP()).w("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cDM();
    }

    private void cDM() {
        if (isPrimary()) {
            if (this.jgO != null && this.jgO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jee);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.jgP);
        registerListener(this.jbN);
        if (this.jgL == null) {
            this.jgL = new ADRequestModel(this.context);
        }
        this.dTc = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jat = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.jat = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.jgJ = new e(this, inflate);
        this.jgJ.setOnScrollListener(this.mScrollListener);
        this.jgM = new a(this, this.jgJ.getListView());
        this.jgM.a(this.jcn);
        if (this.jgK == null) {
            this.jgK = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.jgJ != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.jgN = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.SM();
                            return;
                        }
                        FrsADFragment.this.bQQ();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.jgJ != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.jgN = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.SM();
                            return;
                        }
                        FrsADFragment.this.bQQ();
                    }
                }
            };
        }
        this.jgL.a(this.jgK);
        if (!j.isNetWorkAvailable()) {
            bQQ();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SM() {
        if (this.jgJ != null) {
            hideLoadingView();
            this.jgJ.cDW();
            if (this.aaq == 0) {
                if (!x.isEmpty(this.jgN)) {
                    ac(true, false);
                    this.jgJ.Vp();
                    return;
                }
                bQU();
            } else if (this.aaq == 2) {
                this.jgJ.lQ(false);
                if (!x.isEmpty(this.jgN)) {
                    ac(true, false);
                    this.jgJ.Vp();
                    return;
                }
                bQU();
            } else if (this.aaq == 1) {
                if (!x.isEmpty(this.jgN)) {
                    ac(false, true);
                } else {
                    this.jgJ.Vp();
                }
            }
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.iAl != null) {
            if (z) {
                this.iAl.clear();
            }
            if (z2) {
                for (int i = 0; i < this.iAl.size(); i++) {
                    n nVar = (n) x.getItem(this.iAl, i);
                    if (nVar instanceof c) {
                        ((c) nVar).qJ(false);
                    }
                }
            }
            this.iAl.addAll(this.jgN);
            com.baidu.tbadk.a.a.a.bo(this.iAl);
            this.jgJ.cDV().setData(this.iAl);
            this.jgJ.cDV().notifyDataSetChanged();
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
    public void cAO() {
        if (this.jgJ != null && this.jgJ.getListView() != null) {
            this.jgJ.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bRN() {
        if (this.jgJ != null) {
            cAO();
            this.jgJ.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jgJ != null) {
            if (this.jgJ != null && this.jgJ.getListView() != null) {
                this.jgJ.getListView().stopScroll();
            }
            bQN();
            if (l.isNetOk() && this.mHasMore) {
                yT(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jgJ != null) {
            this.jgJ.onChangeSkinType(i);
        }
        if (this.jgO != null && this.jgO.isViewAttached()) {
            this.jgO.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yT(int i) {
        if (this.jgL != null) {
            Vq();
            this.aaq = i;
            if (i == 0 || i == 2) {
                this.jgL.f(this.forumId, 0, 20);
            } else if (i == 1) {
                this.jgL.f(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.jgJ == null) {
            return null;
        }
        return this.jgJ.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            yT(0);
            showLoadingView();
            return;
        }
        bQQ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").w("fid", this.forumId).an("obj_type", 9).an("obj_locate", 2).dW("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jgJ.qL(false);
        showLoadingView(this.jgJ.cmp(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.jgJ.qL(true);
        hideLoadingView(this.jgJ.cmp());
    }

    private void bQN() {
        if (!this.mHasMore) {
            if (x.isEmpty(this.jgN)) {
                this.jgJ.bRO();
                return;
            } else {
                this.jgJ.Vp();
                return;
            }
        }
        this.jgJ.Vo();
    }

    private void bQU() {
        if (this.iAl != null && this.jgJ != null) {
            this.iAl.add(new s());
            this.jgJ.cDV().setData(this.iAl);
            this.jgJ.cDV().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQQ() {
        this.jgJ.qL(false);
        this.jgJ.qK(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jgJ.bRO();
        this.jgJ.getListView().getData().clear();
        this.jgJ.cCv();
        if (this.jgO == null) {
            this.jgO = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jgO.setTitle(null);
            this.jgO.setSubText(null);
            this.jgO.setButtonText(null);
            this.jgO.showRefreshButton();
            this.jgO.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jgO.onChangeSkinType();
        this.jgO.attachView(this.jgJ.cmp(), true);
        MessageManager.getInstance().registerListener(this.jee);
    }

    private void Vq() {
        this.jgJ.qL(true);
        this.jgJ.qK(true);
        if (this.jgO != null && this.jgO.isViewAttached()) {
            this.jgO.dettachView(this.jgJ.cmp());
            MessageManager.getInstance().unRegisterListener(this.jee);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            yT(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jee);
        if (this.jgJ != null) {
            this.jgJ.onDestroy();
        }
        if (this.jgL != null) {
            this.jgL.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void btS() {
        if (this.jgJ != null) {
            if (j.isNetWorkAvailable()) {
                yT(2);
                if (x.isEmpty(this.iAl)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.jgJ.lQ(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void btT() {
    }
}
