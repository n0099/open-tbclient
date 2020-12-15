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
    private String iSP;
    private ADRequestModel.a iZe;
    private ADRequestModel iZf;
    private a iZg;
    private List<c> iZh;
    private com.baidu.tbadk.l.c iZi;
    private String mFrom;
    private boolean mHasMore;
    protected e iZd = null;
    private int offset = 0;
    public int ZJ = 0;
    private ArrayList<q> isF = new ArrayList<>();
    private int dOW = 0;
    private int iTU = 0;
    private CustomMessageListener iWz = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.iZi != null && FrsADFragment.this.iZi.isViewAttached()) {
                FrsADFragment.this.iZi.sB(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.iTU += i2;
            if (FrsADFragment.this.iTU >= FrsADFragment.this.dOW * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener iZj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iZi != null && FrsADFragment.this.iZi.isViewAttached()) {
                        FrsADFragment.this.An(0);
                    } else if (FrsADFragment.this.iZd != null) {
                        FrsADFragment.this.iZd.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener iUj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.iZi != null && FrsADFragment.this.iZi.isViewAttached()) {
                        FrsADFragment.this.An(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.iZd != null) {
                        FrsADFragment.this.iZd.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab iUI = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bGb() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                bf.bua().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bGb(), arrayList)});
                if (!au.isEmpty(cVar.cEL())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13194").dY("obj_type", cVar.cEL()).w("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cEI();
    }

    private void cEI() {
        if (isPrimary()) {
            if (this.iZi != null && this.iZi.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iWz);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.iZj);
        registerListener(this.iUj);
        if (this.iZf == null) {
            this.iZf = new ADRequestModel(this.context);
        }
        this.dOW = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.iSP = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iSP = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.iZd = new e(this, inflate);
        this.iZd.setOnScrollListener(this.mScrollListener);
        this.iZg = new a(this, this.iZd.getListView());
        this.iZg.a(this.iUI);
        if (this.iZe == null) {
            this.iZe = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.iZd != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.iZh = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.VC();
                            return;
                        }
                        FrsADFragment.this.bSf();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.iZd != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.iZh = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.VC();
                            return;
                        }
                        FrsADFragment.this.bSf();
                    }
                }
            };
        }
        this.iZf.a(this.iZe);
        if (!j.isNetWorkAvailable()) {
            bSf();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VC() {
        if (this.iZd != null) {
            hideLoadingView();
            this.iZd.cES();
            if (this.ZJ == 0) {
                if (!y.isEmpty(this.iZh)) {
                    aa(true, false);
                    this.iZd.Ya();
                    return;
                }
                bSj();
            } else if (this.ZJ == 2) {
                this.iZd.lx(false);
                if (!y.isEmpty(this.iZh)) {
                    aa(true, false);
                    this.iZd.Ya();
                    return;
                }
                bSj();
            } else if (this.ZJ == 1) {
                if (!y.isEmpty(this.iZh)) {
                    aa(false, true);
                } else {
                    this.iZd.Ya();
                }
            }
        }
    }

    private void aa(boolean z, boolean z2) {
        if (this.isF != null) {
            if (z) {
                this.isF.clear();
            }
            if (z2) {
                for (int i = 0; i < this.isF.size(); i++) {
                    q qVar = (q) y.getItem(this.isF, i);
                    if (qVar instanceof c) {
                        ((c) qVar).qp(false);
                    }
                }
            }
            this.isF.addAll(this.iZh);
            com.baidu.tbadk.a.a.a.bh(this.isF);
            this.iZd.cER().setData(this.isF);
            this.iZd.cER().notifyDataSetChanged();
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
    public void cBM() {
        if (this.iZd != null && this.iZd.getListView() != null) {
            this.iZd.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bTa() {
        if (this.iZd != null) {
            cBM();
            this.iZd.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iZd != null) {
            if (this.iZd != null && this.iZd.getListView() != null) {
                this.iZd.getListView().stopScroll();
            }
            bSc();
            if (l.isNetOk() && this.mHasMore) {
                An(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iZd != null) {
            this.iZd.onChangeSkinType(i);
        }
        if (this.iZi != null && this.iZi.isViewAttached()) {
            this.iZi.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An(int i) {
        if (this.iZf != null) {
            Yb();
            this.ZJ = i;
            if (i == 0 || i == 2) {
                this.iZf.f(this.forumId, 0, 20);
            } else if (i == 1) {
                this.iZf.f(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.iZd == null) {
            return null;
        }
        return this.iZd.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            An(0);
            showLoadingView();
            return;
        }
        bSf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").w("fid", this.forumId).al("obj_type", 9).al("obj_locate", 2).dY("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.iZd.qr(false);
        showLoadingView(this.iZd.cno(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.iZd.qr(true);
        hideLoadingView(this.iZd.cno());
    }

    private void bSc() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.iZh)) {
                this.iZd.bTb();
                return;
            } else {
                this.iZd.Ya();
                return;
            }
        }
        this.iZd.XZ();
    }

    private void bSj() {
        if (this.isF != null && this.iZd != null) {
            this.isF.add(new s());
            this.iZd.cER().setData(this.isF);
            this.iZd.cER().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSf() {
        this.iZd.qr(false);
        this.iZd.qq(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.iZd.bTb();
        this.iZd.getListView().getData().clear();
        this.iZd.cDs();
        if (this.iZi == null) {
            this.iZi = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.iZi.setTitle(null);
            this.iZi.setSubText(null);
            this.iZi.setButtonText(null);
            this.iZi.showRefreshButton();
            this.iZi.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iZi.onChangeSkinType();
        this.iZi.attachView(this.iZd.cno(), true);
        MessageManager.getInstance().registerListener(this.iWz);
    }

    private void Yb() {
        this.iZd.qr(true);
        this.iZd.qq(true);
        if (this.iZi != null && this.iZi.isViewAttached()) {
            this.iZi.dettachView(this.iZd.cno());
            MessageManager.getInstance().unRegisterListener(this.iWz);
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
        MessageManager.getInstance().unRegisterListener(this.iWz);
        if (this.iZd != null) {
            this.iZd.onDestroy();
        }
        if (this.iZf != null) {
            this.iZf.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.at
    public void bvq() {
        if (this.iZd != null) {
            if (j.isNetWorkAvailable()) {
                An(2);
                if (y.isEmpty(this.isF)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.iZd.lx(false);
        }
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
    }
}
