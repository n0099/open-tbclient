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
/* loaded from: classes21.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, as, au {
    private TbPageContext context;
    private long forumId;
    private String hZN;
    private ADRequestModel.a igi;
    private ADRequestModel igj;
    private a igk;
    private List<c> igl;
    private com.baidu.tbadk.k.c igm;
    private String mFrom;
    private boolean mHasMore;
    protected e igh = null;
    private int offset = 0;
    public int Yq = 0;
    private ArrayList<q> hzD = new ArrayList<>();
    private int djl = 0;
    private int iaT = 0;
    private CustomMessageListener idB = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.igm != null && FrsADFragment.this.igm.isViewAttached()) {
                FrsADFragment.this.igm.qJ(num.intValue());
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsADFragment.this.iaT += i2;
            if (FrsADFragment.this.iaT >= FrsADFragment.this.djl * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }
    };
    private CustomMessageListener ign = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.igm != null && FrsADFragment.this.igm.isViewAttached()) {
                        FrsADFragment.this.xY(0);
                    } else if (FrsADFragment.this.igh != null) {
                        FrsADFragment.this.igh.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener ibh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.igm != null && FrsADFragment.this.igm.isViewAttached()) {
                        FrsADFragment.this.xY(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.igh != null) {
                        FrsADFragment.this.igh.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private ab ibG = new ab() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (qVar != null && (qVar instanceof c) && (cVar = (c) qVar) != null && cVar.bwf() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                be.bkp().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.bwf(), arrayList)});
                if (!at.isEmpty(cVar.crL())) {
                    TiebaStatic.log(new aq("c13194").dF("obj_type", cVar.crL()).u("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        crI();
    }

    private void crI() {
        if (isPrimary()) {
            if (this.igm != null && this.igm.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.idB);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.ign);
        registerListener(this.ibh);
        if (this.igj == null) {
            this.igj = new ADRequestModel(this.context);
        }
        this.djl = UtilHelper.getScreenHeight(getActivity());
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.hZN = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hZN = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.igh = new e(this, inflate);
        this.igh.setOnScrollListener(this.mScrollListener);
        this.igk = new a(this, this.igh.getListView());
        this.igk.a(this.ibG);
        if (this.igi == null) {
            this.igi = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.igh != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.igl = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Pd();
                            return;
                        }
                        FrsADFragment.this.bHm();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.igh != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.igl = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.Pd();
                            return;
                        }
                        FrsADFragment.this.bHm();
                    }
                }
            };
        }
        this.igj.a(this.igi);
        if (!j.isNetWorkAvailable()) {
            bHm();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pd() {
        if (this.igh != null) {
            hideLoadingView();
            this.igh.crS();
            if (this.Yq == 0) {
                if (!y.isEmpty(this.igl)) {
                    Y(true, false);
                    this.igh.bIj();
                    return;
                }
                bHr();
            } else if (this.Yq == 2) {
                this.igh.ki(false);
                if (!y.isEmpty(this.igl)) {
                    Y(true, false);
                    this.igh.bIj();
                    return;
                }
                bHr();
            } else if (this.Yq == 1) {
                if (!y.isEmpty(this.igl)) {
                    Y(false, true);
                } else {
                    this.igh.bIj();
                }
            }
        }
    }

    private void Y(boolean z, boolean z2) {
        if (this.hzD != null) {
            if (z) {
                this.hzD.clear();
            }
            if (z2) {
                for (int i = 0; i < this.hzD.size(); i++) {
                    q qVar = (q) y.getItem(this.hzD, i);
                    if (qVar instanceof c) {
                        ((c) qVar).oJ(false);
                    }
                }
            }
            this.hzD.addAll(this.igl);
            com.baidu.tbadk.a.a.a.aK(this.hzD);
            this.igh.crR().setData(this.hzD);
            this.igh.crR().notifyDataSetChanged();
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
    public void coM() {
        if (this.igh != null && this.igh.getListView() != null) {
            this.igh.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.as
    public void bIh() {
        if (this.igh != null) {
            coM();
            this.igh.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.igh != null) {
            if (this.igh != null && this.igh.getListView() != null) {
                this.igh.getListView().stopScroll();
            }
            bHj();
            if (l.isNetOk() && this.mHasMore) {
                xY(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.igh != null) {
            this.igh.onChangeSkinType(i);
        }
        if (this.igm != null && this.igm.isViewAttached()) {
            this.igm.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xY(int i) {
        if (this.igj != null) {
            bHn();
            this.Yq = i;
            if (i == 0 || i == 2) {
                this.igj.c(this.forumId, 0, 20);
            } else if (i == 1) {
                this.igj.c(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.igh == null) {
            return null;
        }
        return this.igh.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            xY(0);
            showLoadingView();
            return;
        }
        bHm();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new aq("c13008").u("fid", this.forumId).ai("obj_type", 9).ai("obj_locate", 2).dF("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.igh.oL(false);
        showLoadingView(this.igh.caY(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.igh.oL(true);
        hideLoadingView(this.igh.caY());
    }

    private void bHj() {
        if (!this.mHasMore) {
            if (y.isEmpty(this.igl)) {
                this.igh.bIk();
                return;
            } else {
                this.igh.bIj();
                return;
            }
        }
        this.igh.bIi();
    }

    private void bHr() {
        if (this.hzD != null && this.igh != null) {
            this.hzD.add(new s());
            this.igh.crR().setData(this.hzD);
            this.igh.crR().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHm() {
        this.igh.oL(false);
        this.igh.oK(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.igh.bIk();
        this.igh.getListView().getData().clear();
        this.igh.cqr();
        if (this.igm == null) {
            this.igm = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.igm.setTitle(null);
            this.igm.setSubText(null);
            this.igm.setButtonText(null);
            this.igm.showRefreshButton();
            this.igm.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.igm.onChangeSkinType();
        this.igm.attachView(this.igh.caY(), true);
        MessageManager.getInstance().registerListener(this.idB);
    }

    private void bHn() {
        this.igh.oL(true);
        this.igh.oK(true);
        if (this.igm != null && this.igm.isViewAttached()) {
            this.igm.dettachView(this.igh.caY());
            MessageManager.getInstance().unRegisterListener(this.idB);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            xY(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.idB);
        if (this.igh != null) {
            this.igh.onDestroy();
        }
        if (this.igj != null) {
            this.igj.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bly() {
        if (this.igh != null) {
            if (j.isNetWorkAvailable()) {
                xY(2);
                if (y.isEmpty(this.hzD)) {
                    showLoadingView();
                    return;
                }
                return;
            }
            this.igh.ki(false);
        }
    }

    @Override // com.baidu.tieba.frs.au
    public void blz() {
    }
}
