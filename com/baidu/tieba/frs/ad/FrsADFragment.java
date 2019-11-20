package com.baidu.tieba.frs.ad;

import android.os.Bundle;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.ag;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, ag {
    private TbPageContext context;
    private long forumId;
    private String fup;
    private ADRequestModel.a fzq;
    private ADRequestModel fzr;
    private a fzs;
    private List<c> fzt;
    private com.baidu.tbadk.m.c fzu;
    private String mFrom;
    private boolean mHasMore;
    protected e fzp = null;
    private int offset = 0;
    public int Aa = 0;
    private ArrayList<m> eYf = new ArrayList<>();
    private CustomMessageListener fxx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.fzu != null && FrsADFragment.this.fzu.isViewAttached()) {
                FrsADFragment.this.fzu.jY(num.intValue());
            }
        }
    };
    private final h.c dBK = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (FrsADFragment.this.fzp != null) {
                if (j.isNetWorkAvailable()) {
                    FrsADFragment.this.qM(2);
                    if (v.isEmpty(FrsADFragment.this.eYf)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.fzp.fU(false);
            }
        }
    };
    private CustomMessageListener fzv = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fzu != null && FrsADFragment.this.fzu.isViewAttached()) {
                        FrsADFragment.this.qM(0);
                    } else if (FrsADFragment.this.fzp != null) {
                        FrsADFragment.this.fzp.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener fvB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fzu != null && FrsADFragment.this.fzu.isViewAttached()) {
                        FrsADFragment.this.qM(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.fzp != null) {
                        FrsADFragment.this.fzp.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private s fvX = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.axq() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.amO().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.axq(), arrayList)});
                if (!aq.isEmpty(cVar.blV())) {
                    TiebaStatic.log(new an("c13194").bS("obj_type", cVar.blV()).p("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        blS();
    }

    private void blS() {
        if (isPrimary()) {
            if (this.fzu != null && this.fzu.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fxx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fxx);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.fzv);
        registerListener(this.fvB);
        if (this.fzr == null) {
            this.fzr = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.fup = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fup = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.fzp = new e(this, inflate);
        this.fzp.setListPullRefreshListener(this.dBK);
        this.fzs = new a(this, this.fzp.getListView());
        this.fzs.a(this.fvX);
        if (this.fzq == null) {
            this.fzq = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.fzp != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.fzt = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.vV();
                            return;
                        }
                        FrsADFragment.this.aJl();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.fzp != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.fzt = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.vV();
                            return;
                        }
                        FrsADFragment.this.aJl();
                    }
                }
            };
        }
        this.fzr.a(this.fzq);
        if (!j.isNetWorkAvailable()) {
            aJl();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV() {
        if (this.fzp != null) {
            hideLoadingView();
            if (this.Aa == 0) {
                if (!v.isEmpty(this.fzt)) {
                    M(true, false);
                    this.fzp.aKh();
                    return;
                }
                aFS();
            } else if (this.Aa == 2) {
                this.fzp.fU(false);
                if (!v.isEmpty(this.fzt)) {
                    M(true, false);
                    this.fzp.aKh();
                    return;
                }
                aFS();
            } else if (this.Aa == 1) {
                if (!v.isEmpty(this.fzt)) {
                    M(false, true);
                } else {
                    this.fzp.aKh();
                }
            }
        }
    }

    private void M(boolean z, boolean z2) {
        if (this.eYf != null) {
            if (z) {
                this.eYf.clear();
            }
            if (z2) {
                for (int i = 0; i < this.eYf.size(); i++) {
                    m mVar = (m) v.getItem(this.eYf, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ke(false);
                    }
                }
            }
            this.eYf.addAll(this.fzt);
            this.fzp.bmb().setData(this.eYf);
            this.fzp.bmb().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjw() {
        if (this.fzp != null && this.fzp.getListView() != null) {
            this.fzp.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKf() {
        if (this.fzp != null) {
            bjw();
            this.fzp.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fzp != null) {
            if (this.fzp != null && this.fzp.getListView() != null) {
                this.fzp.getListView().stopScroll();
            }
            aJj();
            if (l.isNetOk() && this.mHasMore) {
                qM(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fzp != null) {
            this.fzp.onChangeSkinType(i);
        }
        if (this.fzu != null && this.fzu.isViewAttached()) {
            this.fzu.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(int i) {
        if (this.fzr != null) {
            aJm();
            this.Aa = i;
            if (i == 0 || i == 2) {
                this.fzr.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.fzr.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.fzp == null) {
            return null;
        }
        return this.fzp.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            qM(0);
            showLoadingView();
            return;
        }
        aJl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").p("fid", this.forumId).O("obj_type", 9).O("obj_locate", 2).bS("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.fzp.kf(false);
        showLoadingView(this.fzp.aYb(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.fzp.kf(true);
        hideLoadingView(this.fzp.aYb());
    }

    private void aJj() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.fzt)) {
                this.fzp.aKi();
                return;
            } else {
                this.fzp.aKh();
                return;
            }
        }
        this.fzp.aKg();
    }

    private void aFS() {
        if (this.eYf != null && this.fzp != null) {
            this.eYf.add(new com.baidu.tieba.frs.m());
            this.fzp.bmb().setData(this.eYf);
            this.fzp.bmb().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJl() {
        this.fzp.kf(false);
        this.fzp.bmc().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.fzp.aKi();
        this.fzp.getListView().getData().clear();
        this.fzp.bkQ();
        if (this.fzu == null) {
            this.fzu = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fzu.setTitle(null);
            this.fzu.setSubText(null);
            this.fzu.setButtonText(null);
            this.fzu.showRefreshButton();
            this.fzu.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fzu.onChangeSkinType();
        this.fzu.attachView(this.fzp.aYb(), true);
        MessageManager.getInstance().registerListener(this.fxx);
    }

    private void aJm() {
        this.fzp.kf(true);
        this.fzp.bmc().setEnabled(true);
        if (this.fzu != null && this.fzu.isViewAttached()) {
            this.fzu.dettachView(this.fzp.aYb());
            MessageManager.getInstance().unRegisterListener(this.fxx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            qM(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fxx);
        if (this.fzp != null) {
            this.fzp.onDestroy();
        }
        if (this.fzr != null) {
            this.fzr.onDestroy();
        }
        super.onDestroy();
    }
}
