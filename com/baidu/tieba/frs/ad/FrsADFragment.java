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
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.adModel.ADHttpResponseMessage;
import com.baidu.tieba.frs.adModel.ADRequestModel;
import com.baidu.tieba.frs.adModel.ADSocketResponseMessage;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FrsADFragment extends BaseFragment implements BdListView.e, aj {
    private TbPageContext context;
    private String dmg;
    private ADRequestModel.a dqn;
    private ADRequestModel dqo;
    private a dqp;
    private List<c> dqq;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dqm = null;
    private int offset = 0;
    public int OQ = 0;
    private ArrayList<h> cQO = new ArrayList<>();
    private final g.b byv = new g.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            if (FrsADFragment.this.dqm != null) {
                if (j.jE()) {
                    FrsADFragment.this.kJ(2);
                    if (w.z(FrsADFragment.this.cQO)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dqm.cq(false);
            }
        }
    };
    private CustomMessageListener dqr = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Jc()) {
                        FrsADFragment.this.kJ(0);
                    } else if (FrsADFragment.this.dqm != null) {
                        FrsADFragment.this.dqm.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dni = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Jc()) {
                        FrsADFragment.this.kJ(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dqm != null) {
                        FrsADFragment.this.dqm.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dnB = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.Lg() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                az.zI().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.b(cVar.Lg(), arrayList)});
                if (!ap.isEmpty(cVar.avV())) {
                    TiebaStatic.log(new an("c13194").ae("obj_type", cVar.avV()));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dqr);
        registerListener(this.dni);
        if (this.dqo == null) {
            this.dqo = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dmg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dmg = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.frs_ad_fragment, (ViewGroup) null);
        this.dqm = new e(this, inflate);
        this.dqm.a(this.byv);
        this.dqp = new a(this, this.dqm.getListView());
        this.dqp.setOnAdapterItemClickListener(this.dnB);
        if (this.dqn == null) {
            this.dqn = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dqm != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dqq = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.TP();
                            return;
                        }
                        FrsADFragment.this.Um();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dqm != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dqq = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.TP();
                            return;
                        }
                        FrsADFragment.this.Um();
                    }
                }
            };
        }
        this.dqo.a(this.dqn);
        if (!j.jE()) {
            Um();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TP() {
        if (this.dqm != null) {
            hideLoadingView();
            if (this.OQ == 0) {
                if (!w.z(this.dqq)) {
                    y(true, false);
                    this.dqm.Up();
                    return;
                }
                showEmptyView();
            } else if (this.OQ == 2) {
                this.dqm.cq(false);
                if (!w.z(this.dqq)) {
                    y(true, false);
                    this.dqm.Up();
                    return;
                }
                showEmptyView();
            } else if (this.OQ == 1) {
                if (!w.z(this.dqq)) {
                    y(false, true);
                } else {
                    this.dqm.Up();
                }
            }
        }
    }

    private void y(boolean z, boolean z2) {
        if (this.cQO != null) {
            if (z) {
                this.cQO.clear();
            }
            if (z2) {
                for (int i = 0; i < this.cQO.size(); i++) {
                    h hVar = (h) w.d(this.cQO, i);
                    if (hVar instanceof c) {
                        ((c) hVar).fQ(false);
                    }
                }
            }
            this.cQO.addAll(this.dqq);
            this.dqm.awa().setData(this.cQO);
            this.dqm.awa().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void atX() {
        if (this.dqm != null && this.dqm.getListView() != null) {
            this.dqm.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ul() {
        if (this.dqm != null) {
            atX();
            this.dqm.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dqm != null) {
            if (this.dqm != null && this.dqm.getListView() != null) {
                this.dqm.getListView().stopScroll();
            }
            TE();
            if (l.jV() && this.mHasMore) {
                kJ(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dqm != null) {
            this.dqm.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kJ(int i) {
        if (this.dqo != null) {
            Un();
            this.OQ = i;
            if (i == 0 || i == 2) {
                this.dqo.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dqo.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dqm == null) {
            return null;
        }
        return this.dqm.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.jE()) {
            kJ(0);
            showLoadingView();
            return;
        }
        Um();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dqm.fR(false);
        showLoadingView(this.dqm.awb(), true, getResources().getDimensionPixelSize(f.e.ds250));
    }

    private void hideLoadingView() {
        this.dqm.fR(true);
        hideLoadingView(this.dqm.awb());
    }

    private void TE() {
        if (!this.mHasMore) {
            if (w.z(this.dqq)) {
                this.dqm.Uq();
                return;
            } else {
                this.dqm.Up();
                return;
            }
        }
        this.dqm.Uo();
    }

    private void showEmptyView() {
        if (this.cQO != null && this.dqm != null) {
            this.cQO.add(new m());
            this.dqm.awa().setData(this.cQO);
            this.dqm.awa().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Um() {
        this.dqm.fR(false);
        this.dqm.awc().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dqm.Uq();
        this.dqm.getListView().getData().clear();
        this.dqm.avj();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jk();
            this.mRefreshView.ff(getResources().getDimensionPixelSize(f.e.ds_102));
            this.mRefreshView.Ji().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dqm.awb(), true);
    }

    private void Un() {
        this.dqm.fR(true);
        this.dqm.awc().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jc()) {
            this.mRefreshView.Q(this.dqm.awb());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jE()) {
            kJ(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dqm != null) {
            this.dqm.onDestroy();
        }
        if (this.dqo != null) {
            this.dqo.onDestroy();
        }
        super.onDestroy();
    }
}
