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
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ah {
    private TbPageContext context;
    private long forumId;
    private String giS;
    private ADRequestModel.a gnM;
    private ADRequestModel gnN;
    private a gnO;
    private List<c> gnP;
    private com.baidu.tbadk.k.c gnQ;
    private String mFrom;
    private boolean mHasMore;
    protected e gnL = null;
    private int offset = 0;
    public int CF = 0;
    private ArrayList<m> fMN = new ArrayList<>();
    private int bZc = 0;
    private int gjV = 0;
    private CustomMessageListener glU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.gnQ != null && FrsADFragment.this.gnQ.isViewAttached()) {
                FrsADFragment.this.gnQ.ml(num.intValue());
            }
        }
    };
    private final g.c emI = new g.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (FrsADFragment.this.gnL != null) {
                if (j.isNetWorkAvailable()) {
                    FrsADFragment.this.sS(2);
                    if (v.isEmpty(FrsADFragment.this.fMN)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.gnL.hi(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.gjV += i2;
            if (FrsADFragment.this.gjV >= FrsADFragment.this.bZc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener gnR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gnQ != null && FrsADFragment.this.gnQ.isViewAttached()) {
                        FrsADFragment.this.sS(0);
                    } else if (FrsADFragment.this.gnL != null) {
                        FrsADFragment.this.gnL.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener gjY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gnQ != null && FrsADFragment.this.gnQ.isViewAttached()) {
                        FrsADFragment.this.sS(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.gnL != null) {
                        FrsADFragment.this.gnL.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private s gkt = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.7
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.aPd() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aEa().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.aPd(), arrayList)});
                if (!aq.isEmpty(cVar.bDs())) {
                    TiebaStatic.log(new an("c13194").cp("obj_type", cVar.bDs()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bDp();
    }

    private void bDp() {
        if (isPrimary()) {
            if (this.gnQ != null && this.gnQ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.glU);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.glU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.gnR);
        registerListener(this.gjY);
        if (this.gnN == null) {
            this.gnN = new ADRequestModel(this.context);
        }
        this.bZc = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.giS = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.giS = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.gnL = new e(this, inflate);
        this.gnL.setListPullRefreshListener(this.emI);
        this.gnL.setOnScrollListener(this.mScrollListener);
        this.gnO = new a(this, this.gnL.getListView());
        this.gnO.a(this.gkt);
        if (this.gnM == null) {
            this.gnM = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.gnL != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.gnP = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.xT();
                            return;
                        }
                        FrsADFragment.this.aZJ();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.gnL != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.gnP = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.xT();
                            return;
                        }
                        FrsADFragment.this.aZJ();
                    }
                }
            };
        }
        this.gnN.a(this.gnM);
        if (!j.isNetWorkAvailable()) {
            aZJ();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xT() {
        if (this.gnL != null) {
            hideLoadingView();
            if (this.CF == 0) {
                if (!v.isEmpty(this.gnP)) {
                    M(true, false);
                    this.gnL.baG();
                    return;
                }
                afL();
            } else if (this.CF == 2) {
                this.gnL.hi(false);
                if (!v.isEmpty(this.gnP)) {
                    M(true, false);
                    this.gnL.baG();
                    return;
                }
                afL();
            } else if (this.CF == 1) {
                if (!v.isEmpty(this.gnP)) {
                    M(false, true);
                } else {
                    this.gnL.baG();
                }
            }
        }
    }

    private void M(boolean z, boolean z2) {
        if (this.fMN != null) {
            if (z) {
                this.fMN.clear();
            }
            if (z2) {
                for (int i = 0; i < this.fMN.size(); i++) {
                    m mVar = (m) v.getItem(this.fMN, i);
                    if (mVar instanceof c) {
                        ((c) mVar).lq(false);
                    }
                }
            }
            this.fMN.addAll(this.gnP);
            this.gnL.bDy().setData(this.fMN);
            this.gnL.bDy().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        if (this.gnL != null && this.gnL.getListView() != null) {
            this.gnL.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void baE() {
        if (this.gnL != null) {
            scrollToTop();
            this.gnL.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gnL != null) {
            if (this.gnL != null && this.gnL.getListView() != null) {
                this.gnL.getListView().stopScroll();
            }
            aZH();
            if (l.isNetOk() && this.mHasMore) {
                sS(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gnL != null) {
            this.gnL.onChangeSkinType(i);
        }
        if (this.gnQ != null && this.gnQ.isViewAttached()) {
            this.gnQ.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(int i) {
        if (this.gnN != null) {
            aZK();
            this.CF = i;
            if (i == 0 || i == 2) {
                this.gnN.a(this.forumId, 0, 20);
            } else if (i == 1) {
                this.gnN.a(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.gnL == null) {
            return null;
        }
        return this.gnL.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            sS(0);
            showLoadingView();
            return;
        }
        aZJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").s("fid", this.forumId).Z("obj_type", 9).Z("obj_locate", 2).cp("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.gnL.lr(false);
        showLoadingView(this.gnL.bpX(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.gnL.lr(true);
        hideLoadingView(this.gnL.bpX());
    }

    private void aZH() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.gnP)) {
                this.gnL.baH();
                return;
            } else {
                this.gnL.baG();
                return;
            }
        }
        this.gnL.baF();
    }

    private void afL() {
        if (this.fMN != null && this.gnL != null) {
            this.fMN.add(new n());
            this.gnL.bDy().setData(this.fMN);
            this.gnL.bDy().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZJ() {
        this.gnL.lr(false);
        this.gnL.bDz().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gnL.baH();
        this.gnL.getListView().getData().clear();
        this.gnL.bCm();
        if (this.gnQ == null) {
            this.gnQ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gnQ.setTitle(null);
            this.gnQ.setSubText(null);
            this.gnQ.setButtonText(null);
            this.gnQ.showRefreshButton();
            this.gnQ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gnQ.onChangeSkinType();
        this.gnQ.attachView(this.gnL.bpX(), true);
        MessageManager.getInstance().registerListener(this.glU);
    }

    private void aZK() {
        this.gnL.lr(true);
        this.gnL.bDz().setEnabled(true);
        if (this.gnQ != null && this.gnQ.isViewAttached()) {
            this.gnQ.dettachView(this.gnL.bpX());
            MessageManager.getInstance().unRegisterListener(this.glU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            sS(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.glU);
        if (this.gnL != null) {
            this.gnL.onDestroy();
        }
        if (this.gnN != null) {
            this.gnN.onDestroy();
        }
        super.onDestroy();
    }
}
