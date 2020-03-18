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
import com.baidu.adp.widget.ListView.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ai {
    private TbPageContext context;
    private long forumId;
    private String gpb;
    private ADRequestModel.a gtP;
    private ADRequestModel gtQ;
    private a gtR;
    private List<c> gtS;
    private com.baidu.tbadk.k.c gtT;
    private String mFrom;
    private boolean mHasMore;
    protected e gtO = null;
    private int offset = 0;
    public int Df = 0;
    private ArrayList<m> fTp = new ArrayList<>();
    private int cdH = 0;
    private int gqe = 0;
    private CustomMessageListener gsd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.gtT != null && FrsADFragment.this.gtT.isViewAttached()) {
                FrsADFragment.this.gtT.mF(num.intValue());
            }
        }
    };
    private final g.c esD = new g.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (FrsADFragment.this.gtO != null) {
                if (j.isNetWorkAvailable()) {
                    FrsADFragment.this.tf(2);
                    if (v.isEmpty(FrsADFragment.this.fTp)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.gtO.hv(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.gqe += i2;
            if (FrsADFragment.this.gqe >= FrsADFragment.this.cdH * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener gtU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gtT != null && FrsADFragment.this.gtT.isViewAttached()) {
                        FrsADFragment.this.tf(0);
                    } else if (FrsADFragment.this.gtO != null) {
                        FrsADFragment.this.gtO.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener gqh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gtT != null && FrsADFragment.this.gtT.isViewAttached()) {
                        FrsADFragment.this.tf(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.gtO != null) {
                        FrsADFragment.this.gtO.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private s gqC = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.7
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.aRU() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aGK().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.aRU(), arrayList)});
                if (!aq.isEmpty(cVar.bGk())) {
                    TiebaStatic.log(new an("c13194").cx("obj_type", cVar.bGk()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bGh();
    }

    private void bGh() {
        if (isPrimary()) {
            if (this.gtT != null && this.gtT.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.gsd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.gsd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.gtU);
        registerListener(this.gqh);
        if (this.gtQ == null) {
            this.gtQ = new ADRequestModel(this.context);
        }
        this.cdH = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.gpb = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gpb = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.gtO = new e(this, inflate);
        this.gtO.setListPullRefreshListener(this.esD);
        this.gtO.setOnScrollListener(this.mScrollListener);
        this.gtR = new a(this, this.gtO.getListView());
        this.gtR.a(this.gqC);
        if (this.gtP == null) {
            this.gtP = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.gtO != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.gtS = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.AJ();
                            return;
                        }
                        FrsADFragment.this.bcB();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.gtO != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.gtS = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.AJ();
                            return;
                        }
                        FrsADFragment.this.bcB();
                    }
                }
            };
        }
        this.gtQ.a(this.gtP);
        if (!j.isNetWorkAvailable()) {
            bcB();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ() {
        if (this.gtO != null) {
            hideLoadingView();
            this.gtO.bGr();
            if (this.Df == 0) {
                if (!v.isEmpty(this.gtS)) {
                    O(true, false);
                    this.gtO.bdy();
                    return;
                }
                aix();
            } else if (this.Df == 2) {
                this.gtO.hv(false);
                if (!v.isEmpty(this.gtS)) {
                    O(true, false);
                    this.gtO.bdy();
                    return;
                }
                aix();
            } else if (this.Df == 1) {
                if (!v.isEmpty(this.gtS)) {
                    O(false, true);
                } else {
                    this.gtO.bdy();
                }
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.fTp != null) {
            if (z) {
                this.fTp.clear();
            }
            if (z2) {
                for (int i = 0; i < this.fTp.size(); i++) {
                    m mVar = (m) v.getItem(this.fTp, i);
                    if (mVar instanceof c) {
                        ((c) mVar).lJ(false);
                    }
                }
            }
            this.fTp.addAll(this.gtS);
            this.gtO.bGq().setData(this.fTp);
            this.gtO.bGq().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ai
    public void scrollToTop() {
        if (this.gtO != null && this.gtO.getListView() != null) {
            this.gtO.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void bdw() {
        if (this.gtO != null) {
            scrollToTop();
            this.gtO.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gtO != null) {
            if (this.gtO != null && this.gtO.getListView() != null) {
                this.gtO.getListView().stopScroll();
            }
            bcz();
            if (l.isNetOk() && this.mHasMore) {
                tf(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gtO != null) {
            this.gtO.onChangeSkinType(i);
        }
        if (this.gtT != null && this.gtT.isViewAttached()) {
            this.gtT.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf(int i) {
        if (this.gtQ != null) {
            bcC();
            this.Df = i;
            if (i == 0 || i == 2) {
                this.gtQ.a(this.forumId, 0, 20);
            } else if (i == 1) {
                this.gtQ.a(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.gtO == null) {
            return null;
        }
        return this.gtO.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            tf(0);
            showLoadingView();
            return;
        }
        bcB();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").s("fid", this.forumId).X("obj_type", 9).X("obj_locate", 2).cx("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.gtO.lK(false);
        showLoadingView(this.gtO.bsL(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.gtO.lK(true);
        hideLoadingView(this.gtO.bsL());
    }

    private void bcz() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.gtS)) {
                this.gtO.bdz();
                return;
            } else {
                this.gtO.bdy();
                return;
            }
        }
        this.gtO.bdx();
    }

    private void aix() {
        if (this.fTp != null && this.gtO != null) {
            this.fTp.add(new o());
            this.gtO.bGq().setData(this.fTp);
            this.gtO.bGq().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcB() {
        this.gtO.lK(false);
        this.gtO.bGs().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gtO.bdz();
        this.gtO.getListView().getData().clear();
        this.gtO.bFe();
        if (this.gtT == null) {
            this.gtT = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gtT.setTitle(null);
            this.gtT.setSubText(null);
            this.gtT.setButtonText(null);
            this.gtT.showRefreshButton();
            this.gtT.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gtT.onChangeSkinType();
        this.gtT.attachView(this.gtO.bsL(), true);
        MessageManager.getInstance().registerListener(this.gsd);
    }

    private void bcC() {
        this.gtO.lK(true);
        this.gtO.bGs().setEnabled(true);
        if (this.gtT != null && this.gtT.isViewAttached()) {
            this.gtT.dettachView(this.gtO.bsL());
            MessageManager.getInstance().unRegisterListener(this.gsd);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            tf(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gsd);
        if (this.gtO != null) {
            this.gtO.onDestroy();
        }
        if (this.gtQ != null) {
            this.gtQ.onDestroy();
        }
        super.onDestroy();
    }
}
