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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ar, at {
    private TbPageContext context;
    private long forumId;
    private String iSN;
    private ADRequestModel.a iZc;
    private ADRequestModel iZd;
    private a iZe;
    private List<c> iZf;
    private com.baidu.tbadk.l.c iZg;
    private String mFrom;
    private boolean mHasMore;
    protected e iZb = null;
    private int offset = 0;
    public int ZJ = 0;
    private ArrayList<q> isD = new ArrayList<>();
    private int dOW = 0;
    private int iTS = 0;
    private CustomMessageListener iWx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.iZg != null && FrsADFragment.this.iZg.isViewAttached()) {
                FrsADFragment.this.iZg.sB(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.iTS += i2;
            if (FrsADFragment.this.iTS >= FrsADFragment.this.dOW * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener iZh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iZg != null && FrsADFragment.this.iZg.isViewAttached()) {
                        FrsADFragment.this.An(0);
                    } else if (FrsADFragment.this.iZb != null) {
                        FrsADFragment.this.iZb.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener iUh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iZg != null && FrsADFragment.this.iZg.isViewAttached()) {
                        FrsADFragment.this.An(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.iZb != null) {
                        FrsADFragment.this.iZb.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab iUG = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bGb() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bf.bua().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bGb(), arrayList)});
                if (!au.isEmpty(cVar.cEK())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13194").dY("obj_type", cVar.cEK()).w("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cEH();
    }

    private void cEH() {
        if (isPrimary()) {
            if (this.iZg != null && this.iZg.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iWx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iWx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.iZh);
        registerListener(this.iUh);
        if (this.iZd == null) {
            this.iZd = new ADRequestModel(this.context);
        }
        this.dOW = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.iSN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iSN = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.iZb = new e(this, inflate);
        this.iZb.setOnScrollListener(this.mScrollListener);
        this.iZe = new a(this, this.iZb.getListView());
        this.iZe.a(this.iUG);
        if (this.iZc == null) {
            this.iZc = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.iZb != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.iZf = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.VC();
                            return;
                        }
                        FrsADFragment.this.bSe();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.iZb != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.iZf = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.VC();
                            return;
                        }
                        FrsADFragment.this.bSe();
                    }
                }
            };
        }
        this.iZd.a(this.iZc);
        if (!j.isNetWorkAvailable()) {
            bSe();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VC() {
        if (this.iZb != null) {
            hideLoadingView();
            this.iZb.cER();
            if (this.ZJ == 0) {
                if (!y.isEmpty(this.iZf)) {
                    aa(true, false);
                    this.iZb.Ya();
                    return;
                }
                bSi();
            } else if (this.ZJ == 2) {
                this.iZb.lx(false);
                if (!y.isEmpty(this.iZf)) {
                    aa(true, false);
                    this.iZb.Ya();
                    return;
                }
                bSi();
            } else if (this.ZJ == 1) {
                if (!y.isEmpty(this.iZf)) {
                    aa(false, true);
                } else {
                    this.iZb.Ya();
                }
            }
        }
    }

    private void aa(boolean z, boolean z2) {
        if (this.isD != null) {
            if (z) {
                this.isD.clear();
            }
            if (z2) {
                for (int i = 0; i < this.isD.size(); i++) {
                    q qVar = (q) y.getItem(this.isD, i);
                    if (qVar instanceof c) {
                        ((c) qVar).qp(false);
                    }
                }
            }
            this.isD.addAll(this.iZf);
            com.baidu.tbadk.a.a.a.bh(this.isD);
            this.iZb.cEQ().setData(this.isD);
            this.iZb.cEQ().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        tbPageTag.tabId = 90;
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ar
    public void cBL() {
        if (this.iZb != null && this.iZb.getListView() != null) {
            this.iZb.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bSZ() {
        if (this.iZb != null) {
            cBL();
            this.iZb.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iZb != null) {
            if (this.iZb != null && this.iZb.getListView() != null) {
                this.iZb.getListView().stopScroll();
            }
            bSb();
            if (l.isNetOk() && this.mHasMore) {
                An(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iZb != null) {
            this.iZb.onChangeSkinType(i);
        }
        if (this.iZg != null && this.iZg.isViewAttached()) {
            this.iZg.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An(int i) {
        if (this.iZd != null) {
            Yb();
            this.ZJ = i;
            if (i == 0 || i == 2) {
                this.iZd.f(this.forumId, 0, 20);
            } else if (i == 1) {
                this.iZd.f(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.iZb == null) {
            return null;
        }
        return this.iZb.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            An(0);
            showLoadingView();
            return;
        }
        bSe();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").w("fid", this.forumId).al("obj_type", 9).al("obj_locate", 2).dY("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.iZb.qr(false);
        showLoadingView(this.iZb.cnn(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.iZb.qr(true);
        hideLoadingView(this.iZb.cnn());
    }

    private void bSb() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.iZf)) {
                this.iZb.bTa();
                return;
            } else {
                this.iZb.Ya();
                return;
            }
        }
        this.iZb.XZ();
    }

    private void bSi() {
        if (this.isD != null && this.iZb != null) {
            this.isD.add(new s());
            this.iZb.cEQ().setData(this.isD);
            this.iZb.cEQ().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSe() {
        this.iZb.qr(false);
        this.iZb.qq(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iZb.bTa();
        this.iZb.getListView().getData().clear();
        this.iZb.cDr();
        if (this.iZg == null) {
            this.iZg = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.iZg.setTitle(null);
            this.iZg.setSubText(null);
            this.iZg.setButtonText(null);
            this.iZg.showRefreshButton();
            this.iZg.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iZg.onChangeSkinType();
        this.iZg.attachView(this.iZb.cnn(), true);
        MessageManager.getInstance().registerListener(this.iWx);
    }

    private void Yb() {
        this.iZb.qr(true);
        this.iZb.qq(true);
        if (this.iZg != null && this.iZg.isViewAttached()) {
            this.iZg.dettachView(this.iZb.cnn());
            MessageManager.getInstance().unRegisterListener(this.iWx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            An(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iWx);
        if (this.iZb != null) {
            this.iZb.onDestroy();
        }
        if (this.iZd != null) {
            this.iZd.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.at
    public void bvq() {
        if (this.iZb != null) {
            if (j.isNetWorkAvailable()) {
                An(2);
                if (y.isEmpty(this.isD)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.iZb.lx(false);
        }
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
    }
}
