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
    private String jhW;
    private ADRequestModel.a jop;
    private ADRequestModel joq;
    private a jor;
    private List<c> jos;
    private com.baidu.tbadk.l.c jot;
    private String mFrom;
    private boolean mHasMore;
    protected e joo = null;
    private int offset = 0;
    public int abG = 0;
    private ArrayList<n> iHS = new ArrayList<>();
    private int dWJ = 0;
    private int jjc = 0;
    private CustomMessageListener jlI = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.jot != null && FrsADFragment.this.jot.isViewAttached()) {
                FrsADFragment.this.jot.rn(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.jjc += i2;
            if (FrsADFragment.this.jjc >= FrsADFragment.this.dWJ * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener jou = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jot != null && FrsADFragment.this.jot.isViewAttached()) {
                        FrsADFragment.this.ze(0);
                    } else if (FrsADFragment.this.joo != null) {
                        FrsADFragment.this.joo.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener jjr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.jot != null && FrsADFragment.this.jot.isViewAttached()) {
                        FrsADFragment.this.ze(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.joo != null) {
                        FrsADFragment.this.joo.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private w jjR = new w() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.w
        public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (nVar != null && (nVar instanceof c) && (cVar = (c) nVar) != null && cVar.bFc() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bf.bsY().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bFc(), arrayList)});
                if (!au.isEmpty(cVar.cFo())) {
                    TiebaStatic.log(new ar("c13194").dR("obj_type", cVar.cFo()).v("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cFl();
    }

    private void cFl() {
        if (isPrimary()) {
            if (this.jot != null && this.jot.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jlI);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.jou);
        registerListener(this.jjr);
        if (this.joq == null) {
            this.joq = new ADRequestModel(this.context);
        }
        this.dWJ = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.jhW = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.jhW = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.joo = new e(this, inflate);
        this.joo.setOnScrollListener(this.mScrollListener);
        this.jor = new a(this, this.joo.getListView());
        this.jor.a(this.jjR);
        if (this.jop == null) {
            this.jop = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.joo != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.jos = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Uw();
                            return;
                        }
                        FrsADFragment.this.bRH();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.joo != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.jos = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Uw();
                            return;
                        }
                        FrsADFragment.this.bRH();
                    }
                }
            };
        }
        if (this.joq == null) {
            this.joq = new ADRequestModel(this.context);
        }
        this.joq.a(this.jop);
        if (!j.isNetWorkAvailable()) {
            bRH();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uw() {
        if (this.joo != null) {
            hideLoadingView();
            this.joo.cFv();
            if (this.abG == 0) {
                if (!y.isEmpty(this.jos)) {
                    ac(true, false);
                    this.joo.Xb();
                    return;
                }
                bRL();
            } else if (this.abG == 2) {
                this.joo.lU(false);
                if (!y.isEmpty(this.jos)) {
                    ac(true, false);
                    this.joo.Xb();
                    return;
                }
                bRL();
            } else if (this.abG == 1) {
                if (!y.isEmpty(this.jos)) {
                    ac(false, true);
                } else {
                    this.joo.Xb();
                }
            }
        }
    }

    private void ac(boolean z, boolean z2) {
        if (this.iHS != null) {
            if (z) {
                this.iHS.clear();
            }
            if (z2) {
                for (int i = 0; i < this.iHS.size(); i++) {
                    n nVar = (n) y.getItem(this.iHS, i);
                    if (nVar instanceof c) {
                        ((c) nVar).qT(false);
                    }
                }
            }
            this.iHS.addAll(this.jos);
            com.baidu.tbadk.a.a.a.bj(this.iHS);
            this.joo.cFu().setData(this.iHS);
            this.joo.cFu().notifyDataSetChanged();
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
    public void cCm() {
        if (this.joo != null && this.joo.getListView() != null) {
            this.joo.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSD() {
        if (this.joo != null) {
            cCm();
            this.joo.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.joo != null) {
            if (this.joo != null && this.joo.getListView() != null) {
                this.joo.getListView().stopScroll();
            }
            bRE();
            if (l.isNetOk() && this.mHasMore) {
                ze(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.joo != null) {
            this.joo.onChangeSkinType(i);
        }
        if (this.jot != null && this.jot.isViewAttached()) {
            this.jot.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ze(int i) {
        if (this.joq != null) {
            Xc();
            this.abG = i;
            if (i == 0 || i == 2) {
                this.joq.f(this.forumId, 0, 20);
            } else if (i == 1) {
                this.joq.f(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.joo == null) {
            return null;
        }
        return this.joo.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            ze(0);
            showLoadingView();
            return;
        }
        bRH();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ar("c13008").v("fid", this.forumId).aq("obj_type", 9).aq("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.joo.qV(false);
        showLoadingView(this.joo.cnA(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.joo.qV(true);
        hideLoadingView(this.joo.cnA());
    }

    private void bRE() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.jos)) {
                this.joo.bSE();
                return;
            } else {
                this.joo.Xb();
                return;
            }
        }
        this.joo.Xa();
    }

    private void bRL() {
        if (this.iHS != null && this.joo != null) {
            this.iHS.add(new s());
            this.joo.cFu().setData(this.iHS);
            this.joo.cFu().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRH() {
        this.joo.qV(false);
        this.joo.qU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.joo.bSE();
        this.joo.getListView().getData().clear();
        this.joo.cDU();
        if (this.jot == null) {
            this.jot = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jot.setTitle(null);
            this.jot.setSubText(null);
            this.jot.setButtonText(null);
            this.jot.showRefreshButton();
            this.jot.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jot.onChangeSkinType();
        this.jot.attachView(this.joo.cnA(), true);
        MessageManager.getInstance().registerListener(this.jlI);
    }

    private void Xc() {
        this.joo.qV(true);
        this.joo.qU(true);
        if (this.jot != null && this.jot.isViewAttached()) {
            this.jot.dettachView(this.joo.cnA());
            MessageManager.getInstance().unRegisterListener(this.jlI);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            ze(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jlI);
        if (this.joo != null) {
            this.joo.onDestroy();
        }
        if (this.joq != null) {
            this.joq.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bup() {
        if (this.joo != null) {
            if (j.isNetWorkAvailable()) {
                ze(2);
                if (y.isEmpty(this.iHS)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.joo.lU(false);
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void buq() {
    }
}
