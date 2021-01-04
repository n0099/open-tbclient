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
    private String jfa;
    private ADRequestModel.a jlr;
    private ADRequestModel jls;
    private a jlt;
    private List<c> jlu;
    private com.baidu.tbadk.l.c jlv;
    private String mFrom;
    private boolean mHasMore;
    protected e jlq = null;
    private int offset = 0;
    public int aas = 0;
    private ArrayList<n> iES = new ArrayList<>();
    private int dXO = 0;
    private int jgf = 0;
    private CustomMessageListener jiM = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.jlv != null && FrsADFragment.this.jlv.isViewAttached()) {
                FrsADFragment.this.jlv.sN(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.jgf += i2;
            if (FrsADFragment.this.jgf >= FrsADFragment.this.dXO * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener jlw = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jlv != null && FrsADFragment.this.jlv.isViewAttached()) {
                        FrsADFragment.this.Az(0);
                    } else if (FrsADFragment.this.jlq != null) {
                        FrsADFragment.this.jlq.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener jgu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jlv != null && FrsADFragment.this.jlv.isViewAttached()) {
                        FrsADFragment.this.Az(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.jlq != null) {
                        FrsADFragment.this.jlq.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private w jgU = new w() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (nVar != null && (nVar instanceof c) && (cVar = (c) nVar) != null && cVar.bIw() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                be.bwu().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bIw(), arrayList)});
                if (!at.isEmpty(cVar.cHG())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13194").dX("obj_type", cVar.cHG()).w("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cHD();
    }

    private void cHD() {
        if (isPrimary()) {
            if (this.jlv != null && this.jlv.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jiM);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.jlw);
        registerListener(this.jgu);
        if (this.jls == null) {
            this.jls = new ADRequestModel(this.context);
        }
        this.dXO = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jfa = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.jfa = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.jlq = new e(this, inflate);
        this.jlq.setOnScrollListener(this.mScrollListener);
        this.jlt = new a(this, this.jlq.getListView());
        this.jlt.a(this.jgU);
        if (this.jlr == null) {
            this.jlr = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.jlq != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.jlu = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.WE();
                            return;
                        }
                        FrsADFragment.this.bUH();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.jlq != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.jlu = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.WE();
                            return;
                        }
                        FrsADFragment.this.bUH();
                    }
                }
            };
        }
        this.jls.a(this.jlr);
        if (!j.isNetWorkAvailable()) {
            bUH();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WE() {
        if (this.jlq != null) {
            hideLoadingView();
            this.jlq.cHN();
            if (this.aas == 0) {
                if (!x.isEmpty(this.jlu)) {
                    ac(true, false);
                    this.jlq.Zh();
                    return;
                }
                bUL();
            } else if (this.aas == 2) {
                this.jlq.lU(false);
                if (!x.isEmpty(this.jlu)) {
                    ac(true, false);
                    this.jlq.Zh();
                    return;
                }
                bUL();
            } else if (this.aas == 1) {
                if (!x.isEmpty(this.jlu)) {
                    ac(false, true);
                } else {
                    this.jlq.Zh();
                }
            }
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.iES != null) {
            if (z) {
                this.iES.clear();
            }
            if (z2) {
                for (int i = 0; i < this.iES.size(); i++) {
                    n nVar = (n) x.getItem(this.iES, i);
                    if (nVar instanceof c) {
                        ((c) nVar).qN(false);
                    }
                }
            }
            this.iES.addAll(this.jlu);
            com.baidu.tbadk.a.a.a.bo(this.iES);
            this.jlq.cHM().setData(this.iES);
            this.jlq.cHM().notifyDataSetChanged();
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
    public void cEF() {
        if (this.jlq != null && this.jlq.getListView() != null) {
            this.jlq.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bVE() {
        if (this.jlq != null) {
            cEF();
            this.jlq.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jlq != null) {
            if (this.jlq != null && this.jlq.getListView() != null) {
                this.jlq.getListView().stopScroll();
            }
            bUE();
            if (l.isNetOk() && this.mHasMore) {
                Az(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jlq != null) {
            this.jlq.onChangeSkinType(i);
        }
        if (this.jlv != null && this.jlv.isViewAttached()) {
            this.jlv.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az(int i) {
        if (this.jls != null) {
            Zi();
            this.aas = i;
            if (i == 0 || i == 2) {
                this.jls.f(this.forumId, 0, 20);
            } else if (i == 1) {
                this.jls.f(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.jlq == null) {
            return null;
        }
        return this.jlq.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            Az(0);
            showLoadingView();
            return;
        }
        bUH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").w("fid", this.forumId).an("obj_type", 9).an("obj_locate", 2).dX("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.jlq.qP(false);
        showLoadingView(this.jlq.cqg(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.jlq.qP(true);
        hideLoadingView(this.jlq.cqg());
    }

    private void bUE() {
        if (!this.mHasMore) {
            if (x.isEmpty(this.jlu)) {
                this.jlq.bVF();
                return;
            } else {
                this.jlq.Zh();
                return;
            }
        }
        this.jlq.Zg();
    }

    private void bUL() {
        if (this.iES != null && this.jlq != null) {
            this.iES.add(new s());
            this.jlq.cHM().setData(this.iES);
            this.jlq.cHM().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUH() {
        this.jlq.qP(false);
        this.jlq.qO(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.jlq.bVF();
        this.jlq.getListView().getData().clear();
        this.jlq.cGm();
        if (this.jlv == null) {
            this.jlv = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jlv.setTitle(null);
            this.jlv.setSubText(null);
            this.jlv.setButtonText(null);
            this.jlv.showRefreshButton();
            this.jlv.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jlv.onChangeSkinType();
        this.jlv.attachView(this.jlq.cqg(), true);
        MessageManager.getInstance().registerListener(this.jiM);
    }

    private void Zi() {
        this.jlq.qP(true);
        this.jlq.qO(true);
        if (this.jlv != null && this.jlv.isViewAttached()) {
            this.jlv.dettachView(this.jlq.cqg());
            MessageManager.getInstance().unRegisterListener(this.jiM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            Az(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jiM);
        if (this.jlq != null) {
            this.jlq.onDestroy();
        }
        if (this.jls != null) {
            this.jls.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxL() {
        if (this.jlq != null) {
            if (j.isNetWorkAvailable()) {
                Az(2);
                if (x.isEmpty(this.iES)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.jlq.lU(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxM() {
    }
}
