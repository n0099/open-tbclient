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
/* loaded from: classes9.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ah {
    private TbPageContext context;
    private long forumId;
    private String gor;
    private ADRequestModel.a gtl;
    private ADRequestModel gtm;
    private a gtn;
    private List<c> gto;
    private com.baidu.tbadk.k.c gtp;
    private String mFrom;
    private boolean mHasMore;
    protected e gtk = null;
    private int offset = 0;
    public int Df = 0;
    private ArrayList<m> fSG = new ArrayList<>();
    private int cdw = 0;
    private int gpu = 0;
    private CustomMessageListener grt = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.gtp != null && FrsADFragment.this.gtp.isViewAttached()) {
                FrsADFragment.this.gtp.mD(num.intValue());
            }
        }
    };
    private final g.c esh = new g.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (FrsADFragment.this.gtk != null) {
                if (j.isNetWorkAvailable()) {
                    FrsADFragment.this.td(2);
                    if (v.isEmpty(FrsADFragment.this.fSG)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.gtk.hu(false);
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.gpu += i2;
            if (FrsADFragment.this.gpu >= FrsADFragment.this.cdw * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener gtq = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gtp != null && FrsADFragment.this.gtp.isViewAttached()) {
                        FrsADFragment.this.td(0);
                    } else if (FrsADFragment.this.gtk != null) {
                        FrsADFragment.this.gtk.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener gpx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.gtp != null && FrsADFragment.this.gtp.isViewAttached()) {
                        FrsADFragment.this.td(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.gtk != null) {
                        FrsADFragment.this.gtk.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private s gpS = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.7
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.aRQ() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.aGG().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.aRQ(), arrayList)});
                if (!aq.isEmpty(cVar.bFZ())) {
                    TiebaStatic.log(new an("c13194").cy("obj_type", cVar.bFZ()).s("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        bFW();
    }

    private void bFW() {
        if (isPrimary()) {
            if (this.gtp != null && this.gtp.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.grt);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.grt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.gtq);
        registerListener(this.gpx);
        if (this.gtm == null) {
            this.gtm = new ADRequestModel(this.context);
        }
        this.cdw = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.gor = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.gor = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.gtk = new e(this, inflate);
        this.gtk.setListPullRefreshListener(this.esh);
        this.gtk.setOnScrollListener(this.mScrollListener);
        this.gtn = new a(this, this.gtk.getListView());
        this.gtn.a(this.gpS);
        if (this.gtl == null) {
            this.gtl = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.gtk != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.gto = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.AC();
                            return;
                        }
                        FrsADFragment.this.bcx();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.gtk != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.gto = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.AC();
                            return;
                        }
                        FrsADFragment.this.bcx();
                    }
                }
            };
        }
        this.gtm.a(this.gtl);
        if (!j.isNetWorkAvailable()) {
            bcx();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC() {
        if (this.gtk != null) {
            hideLoadingView();
            if (this.Df == 0) {
                if (!v.isEmpty(this.gto)) {
                    O(true, false);
                    this.gtk.bdt();
                    return;
                }
                aiu();
            } else if (this.Df == 2) {
                this.gtk.hu(false);
                if (!v.isEmpty(this.gto)) {
                    O(true, false);
                    this.gtk.bdt();
                    return;
                }
                aiu();
            } else if (this.Df == 1) {
                if (!v.isEmpty(this.gto)) {
                    O(false, true);
                } else {
                    this.gtk.bdt();
                }
            }
        }
    }

    private void O(boolean z, boolean z2) {
        if (this.fSG != null) {
            if (z) {
                this.fSG.clear();
            }
            if (z2) {
                for (int i = 0; i < this.fSG.size(); i++) {
                    m mVar = (m) v.getItem(this.fSG, i);
                    if (mVar instanceof c) {
                        ((c) mVar).lE(false);
                    }
                }
            }
            this.fSG.addAll(this.gto);
            this.gtk.bGf().setData(this.fSG);
            this.gtk.bGf().notifyDataSetChanged();
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
        if (this.gtk != null && this.gtk.getListView() != null) {
            this.gtk.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdr() {
        if (this.gtk != null) {
            scrollToTop();
            this.gtk.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gtk != null) {
            if (this.gtk != null && this.gtk.getListView() != null) {
                this.gtk.getListView().stopScroll();
            }
            bcv();
            if (l.isNetOk() && this.mHasMore) {
                td(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gtk != null) {
            this.gtk.onChangeSkinType(i);
        }
        if (this.gtp != null && this.gtp.isViewAttached()) {
            this.gtp.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void td(int i) {
        if (this.gtm != null) {
            bcy();
            this.Df = i;
            if (i == 0 || i == 2) {
                this.gtm.a(this.forumId, 0, 20);
            } else if (i == 1) {
                this.gtm.a(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.gtk == null) {
            return null;
        }
        return this.gtk.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            td(0);
            showLoadingView();
            return;
        }
        bcx();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").s("fid", this.forumId).X("obj_type", 9).X("obj_locate", 2).cy("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.gtk.lF(false);
        showLoadingView(this.gtk.bsF(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.gtk.lF(true);
        hideLoadingView(this.gtk.bsF());
    }

    private void bcv() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.gto)) {
                this.gtk.bdu();
                return;
            } else {
                this.gtk.bdt();
                return;
            }
        }
        this.gtk.bds();
    }

    private void aiu() {
        if (this.fSG != null && this.gtk != null) {
            this.fSG.add(new n());
            this.gtk.bGf().setData(this.fSG);
            this.gtk.bGf().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        this.gtk.lF(false);
        this.gtk.bGg().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.gtk.bdu();
        this.gtk.getListView().getData().clear();
        this.gtk.bEU();
        if (this.gtp == null) {
            this.gtp = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.gtp.setTitle(null);
            this.gtp.setSubText(null);
            this.gtp.setButtonText(null);
            this.gtp.showRefreshButton();
            this.gtp.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.gtp.onChangeSkinType();
        this.gtp.attachView(this.gtk.bsF(), true);
        MessageManager.getInstance().registerListener(this.grt);
    }

    private void bcy() {
        this.gtk.lF(true);
        this.gtk.bGg().setEnabled(true);
        if (this.gtp != null && this.gtp.isViewAttached()) {
            this.gtp.dettachView(this.gtk.bsF());
            MessageManager.getInstance().unRegisterListener(this.grt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            td(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.grt);
        if (this.gtk != null) {
            this.gtk.onDestroy();
        }
        if (this.gtm != null) {
            this.gtm.onDestroy();
        }
        super.onDestroy();
    }
}
