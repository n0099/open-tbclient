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
    private ADRequestModel.a fAh;
    private ADRequestModel fAi;
    private a fAj;
    private List<c> fAk;
    private com.baidu.tbadk.m.c fAl;
    private long forumId;
    private String fvg;
    private String mFrom;
    private boolean mHasMore;
    protected e fAg = null;
    private int offset = 0;
    public int AB = 0;
    private ArrayList<m> eYW = new ArrayList<>();
    private CustomMessageListener fyo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsADFragment.this.fAl != null && FrsADFragment.this.fAl.isViewAttached()) {
                FrsADFragment.this.fAl.jZ(num.intValue());
            }
        }
    };
    private final h.c dCB = new h.c() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        @Override // com.baidu.tbadk.core.view.h.c
        public void onListPullRefresh(boolean z) {
            if (FrsADFragment.this.fAg != null) {
                if (j.isNetWorkAvailable()) {
                    FrsADFragment.this.qN(2);
                    if (v.isEmpty(FrsADFragment.this.eYW)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.fAg.fU(false);
            }
        }
    };
    private CustomMessageListener fAm = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_SELECTED) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fAl != null && FrsADFragment.this.fAl.isViewAttached()) {
                        FrsADFragment.this.qN(0);
                    } else if (FrsADFragment.this.fAg != null) {
                        FrsADFragment.this.fAg.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener fws = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.fAl != null && FrsADFragment.this.fAl.isViewAttached()) {
                        FrsADFragment.this.qN(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.fAg != null) {
                        FrsADFragment.this.fAg.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                    }
                }
            }
        }
    };
    private s fwO = new s() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.6
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (mVar != null && (mVar instanceof c) && (cVar = (c) mVar) != null && cVar.axs() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ba.amQ().b(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.appendParams(cVar.axs(), arrayList)});
                if (!aq.isEmpty(cVar.blX())) {
                    TiebaStatic.log(new an("c13194").bS("obj_type", cVar.blX()).p("fid", FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        blU();
    }

    private void blU() {
        if (isPrimary()) {
            if (this.fAl != null && this.fAl.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fyo);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fyo);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.fAm);
        registerListener(this.fws);
        if (this.fAi == null) {
            this.fAi = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.fvg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fvg = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_ad_fragment, (ViewGroup) null);
        this.fAg = new e(this, inflate);
        this.fAg.setListPullRefreshListener(this.dCB);
        this.fAj = new a(this, this.fAg.getListView());
        this.fAj.a(this.fwO);
        if (this.fAh == null) {
            this.fAh = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.fAg != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.fAk = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.vU();
                            return;
                        }
                        FrsADFragment.this.aJn();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.fAg != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.fAk = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.vU();
                            return;
                        }
                        FrsADFragment.this.aJn();
                    }
                }
            };
        }
        this.fAi.a(this.fAh);
        if (!j.isNetWorkAvailable()) {
            aJn();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vU() {
        if (this.fAg != null) {
            hideLoadingView();
            if (this.AB == 0) {
                if (!v.isEmpty(this.fAk)) {
                    M(true, false);
                    this.fAg.aKj();
                    return;
                }
                aFU();
            } else if (this.AB == 2) {
                this.fAg.fU(false);
                if (!v.isEmpty(this.fAk)) {
                    M(true, false);
                    this.fAg.aKj();
                    return;
                }
                aFU();
            } else if (this.AB == 1) {
                if (!v.isEmpty(this.fAk)) {
                    M(false, true);
                } else {
                    this.fAg.aKj();
                }
            }
        }
    }

    private void M(boolean z, boolean z2) {
        if (this.eYW != null) {
            if (z) {
                this.eYW.clear();
            }
            if (z2) {
                for (int i = 0; i < this.eYW.size(); i++) {
                    m mVar = (m) v.getItem(this.eYW, i);
                    if (mVar instanceof c) {
                        ((c) mVar).ke(false);
                    }
                }
            }
            this.eYW.addAll(this.fAk);
            this.fAg.bmd().setData(this.eYW);
            this.fAg.bmd().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        if (this.fAg != null && this.fAg.getListView() != null) {
            this.fAg.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        if (this.fAg != null) {
            bjy();
            this.fAg.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fAg != null) {
            if (this.fAg != null && this.fAg.getListView() != null) {
                this.fAg.getListView().stopScroll();
            }
            aJl();
            if (l.isNetOk() && this.mHasMore) {
                qN(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.fAg != null) {
            this.fAg.onChangeSkinType(i);
        }
        if (this.fAl != null && this.fAl.isViewAttached()) {
            this.fAl.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qN(int i) {
        if (this.fAi != null) {
            aJo();
            this.AB = i;
            if (i == 0 || i == 2) {
                this.fAi.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.fAi.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.fAg == null) {
            return null;
        }
        return this.fAg.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            qN(0);
            showLoadingView();
            return;
        }
        aJn();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new an("c13008").p("fid", this.forumId).O("obj_type", 9).O("obj_locate", 2).bS("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.fAg.kf(false);
        showLoadingView(this.fAg.aYd(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    private void hideLoadingView() {
        this.fAg.kf(true);
        hideLoadingView(this.fAg.aYd());
    }

    private void aJl() {
        if (!this.mHasMore) {
            if (v.isEmpty(this.fAk)) {
                this.fAg.aKk();
                return;
            } else {
                this.fAg.aKj();
                return;
            }
        }
        this.fAg.aKi();
    }

    private void aFU() {
        if (this.eYW != null && this.fAg != null) {
            this.eYW.add(new com.baidu.tieba.frs.m());
            this.fAg.bmd().setData(this.eYW);
            this.fAg.bmd().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJn() {
        this.fAg.kf(false);
        this.fAg.bme().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        this.fAg.aKk();
        this.fAg.getListView().getData().clear();
        this.fAg.bkS();
        if (this.fAl == null) {
            this.fAl = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            this.fAl.setTitle(null);
            this.fAl.setSubText(null);
            this.fAl.setButtonText(null);
            this.fAl.showRefreshButton();
            this.fAl.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.fAl.onChangeSkinType();
        this.fAl.attachView(this.fAg.aYd(), true);
        MessageManager.getInstance().registerListener(this.fyo);
    }

    private void aJo() {
        this.fAg.kf(true);
        this.fAg.bme().setEnabled(true);
        if (this.fAl != null && this.fAl.isViewAttached()) {
            this.fAl.dettachView(this.fAg.aYd());
            MessageManager.getInstance().unRegisterListener(this.fyo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            qN(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fyo);
        if (this.fAg != null) {
            this.fAg.onDestroy();
        }
        if (this.fAi != null) {
            this.fAi.onDestroy();
        }
        super.onDestroy();
    }
}
