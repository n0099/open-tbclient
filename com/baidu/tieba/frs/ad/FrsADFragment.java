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
/* loaded from: classes16.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, as, au {
    private TbPageContext context;
    private long forumId;
    private String hSN;
    private ADRequestModel.a hZe;
    private ADRequestModel hZf;
    private a hZg;
    private List<c> hZh;
    private com.baidu.tbadk.k.c hZi;
    private String mFrom;
    private boolean mHasMore;
    protected e hZd = null;
    private int offset = 0;
    public int XX = 0;
    private ArrayList<q> hsy = new ArrayList<>();
    private int dhi = 0;
    private int hTT = 0;
    private CustomMessageListener hWx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.hZi != null && FrsADFragment.this.hZi.isViewAttached()) {
                FrsADFragment.this.hZi.qs(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.hTT += i2;
            if (FrsADFragment.this.hTT >= FrsADFragment.this.dhi * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener hZj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hZi != null && FrsADFragment.this.hZi.isViewAttached()) {
                        FrsADFragment.this.xz(0);
                    } else if (FrsADFragment.this.hZd != null) {
                        FrsADFragment.this.hZd.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener hUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.hZi != null && FrsADFragment.this.hZi.isViewAttached()) {
                        FrsADFragment.this.xz(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.hZd != null) {
                        FrsADFragment.this.hZd.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab hUG = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bvb() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                be.bju().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bvb(), arrayList)});
                if (!at.isEmpty(cVar.coy())) {
                    TiebaStatic.log(new aq("c13194").dD("obj_type", cVar.coy()).u("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cov();
    }

    private void cov() {
        if (isPrimary()) {
            if (this.hZi != null && this.hZi.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hWx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hWx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.hZj);
        registerListener(this.hUh);
        if (this.hZf == null) {
            this.hZf = new ADRequestModel(this.context);
        }
        this.dhi = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.hSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hSN = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.hZd = new e(this, inflate);
        this.hZd.setOnScrollListener(this.mScrollListener);
        this.hZg = new a(this, this.hZd.getListView());
        this.hZg.a(this.hUG);
        if (this.hZe == null) {
            this.hZe = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.hZd != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.hZh = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.OA();
                            return;
                        }
                        FrsADFragment.this.bFW();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.hZd != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.hZh = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.OA();
                            return;
                        }
                        FrsADFragment.this.bFW();
                    }
                }
            };
        }
        this.hZf.a(this.hZe);
        if (!j.isNetWorkAvailable()) {
            bFW();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OA() {
        if (this.hZd != null) {
            hideLoadingView();
            this.hZd.coF();
            if (this.XX == 0) {
                if (!y.isEmpty(this.hZh)) {
                    W(true, false);
                    this.hZd.bGT();
                    return;
                }
                bGb();
            } else if (this.XX == 2) {
                this.hZd.kh(false);
                if (!y.isEmpty(this.hZh)) {
                    W(true, false);
                    this.hZd.bGT();
                    return;
                }
                bGb();
            } else if (this.XX == 1) {
                if (!y.isEmpty(this.hZh)) {
                    W(false, true);
                } else {
                    this.hZd.bGT();
                }
            }
        }
    }

    private void W(boolean z, boolean z2) {
        if (this.hsy != null) {
            if (z) {
                this.hsy.clear();
            }
            if (z2) {
                for (int i = 0; i < this.hsy.size(); i++) {
                    q qVar = (q) y.getItem(this.hsy, i);
                    if (qVar instanceof c) {
                        ((c) qVar).oD(false);
                    }
                }
            }
            this.hsy.addAll(this.hZh);
            com.baidu.tbadk.a.a.a.aG(this.hsy);
            this.hZd.coE().setData(this.hsy);
            this.hZd.coE().notifyDataSetChanged();
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
    public void clA() {
        if (this.hZd != null && this.hZd.getListView() != null) {
            this.hZd.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bGR() {
        if (this.hZd != null) {
            clA();
            this.hZd.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hZd != null) {
            if (this.hZd != null && this.hZd.getListView() != null) {
                this.hZd.getListView().stopScroll();
            }
            bFT();
            if (l.isNetOk() && this.mHasMore) {
                xz(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hZd != null) {
            this.hZd.onChangeSkinType(i);
        }
        if (this.hZi != null && this.hZi.isViewAttached()) {
            this.hZi.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz(int i) {
        if (this.hZf != null) {
            bFX();
            this.XX = i;
            if (i == 0 || i == 2) {
                this.hZf.c(this.forumId, 0, 20);
            } else if (i == 1) {
                this.hZf.c(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.hZd == null) {
            return null;
        }
        return this.hZd.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            xz(0);
            showLoadingView();
            return;
        }
        bFW();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").u("fid", this.forumId).ai("obj_type", 9).ai("obj_locate", 2).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.hZd.oF(false);
        showLoadingView(this.hZd.bZc(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.hZd.oF(true);
        hideLoadingView(this.hZd.bZc());
    }

    private void bFT() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.hZh)) {
                this.hZd.bGU();
                return;
            } else {
                this.hZd.bGT();
                return;
            }
        }
        this.hZd.bGS();
    }

    private void bGb() {
        if (this.hsy != null && this.hZd != null) {
            this.hsy.add(new s());
            this.hZd.coE().setData(this.hsy);
            this.hZd.coE().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        this.hZd.oF(false);
        this.hZd.oE(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.hZd.bGU();
        this.hZd.getListView().getData().clear();
        this.hZd.cnf();
        if (this.hZi == null) {
            this.hZi = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hZi.setTitle(null);
            this.hZi.setSubText(null);
            this.hZi.setButtonText(null);
            this.hZi.showRefreshButton();
            this.hZi.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hZi.onChangeSkinType();
        this.hZi.attachView(this.hZd.bZc(), true);
        MessageManager.getInstance().registerListener(this.hWx);
    }

    private void bFX() {
        this.hZd.oF(true);
        this.hZd.oE(true);
        if (this.hZi != null && this.hZi.isViewAttached()) {
            this.hZi.dettachView(this.hZd.bZc());
            MessageManager.getInstance().unRegisterListener(this.hWx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            xz(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hWx);
        if (this.hZd != null) {
            this.hZd.onDestroy();
        }
        if (this.hZf != null) {
            this.hZf.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bkD() {
        if (this.hZd != null) {
            if (j.isNetWorkAvailable()) {
                xz(2);
                if (y.isEmpty(this.hsy)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.hZd.kh(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
    }
}
