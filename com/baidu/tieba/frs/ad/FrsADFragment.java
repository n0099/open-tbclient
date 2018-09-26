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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.e;
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
    private String dsd;
    private ADRequestModel.a dwB;
    private ADRequestModel dwC;
    private a dwD;
    private List<c> dwE;
    private long forumId;
    private String mFrom;
    private boolean mHasMore;
    protected e dwA = null;
    private int offset = 0;
    public int Rs = 0;
    private ArrayList<h> cWF = new ArrayList<>();
    private final j.b bEk = new j.b() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.2
        @Override // com.baidu.tbadk.core.view.j.b
        public void bf(boolean z) {
            if (FrsADFragment.this.dwA != null) {
                if (com.baidu.adp.lib.util.j.kK()) {
                    FrsADFragment.this.lm(2);
                    if (v.z(FrsADFragment.this.cWF)) {
                        FrsADFragment.this.showLoadingView();
                        return;
                    }
                    return;
                }
                FrsADFragment.this.dwA.cH(false);
            }
        }
    };
    private CustomMessageListener dwF = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Ks()) {
                        FrsADFragment.this.lm(0);
                    } else if (FrsADFragment.this.dwA != null) {
                        FrsADFragment.this.dwA.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dtg = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.ad.FrsADFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 90) {
                    if (FrsADFragment.this.getListView() != null) {
                        FrsADFragment.this.getListView().setSelection(0);
                    }
                    if (FrsADFragment.this.mRefreshView != null && FrsADFragment.this.mRefreshView.Ks()) {
                        FrsADFragment.this.lm(0);
                        FrsADFragment.this.showLoadingView();
                    } else if (FrsADFragment.this.dwA != null) {
                        FrsADFragment.this.dwA.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private n dtz = new n() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            c cVar;
            if (hVar != null && (hVar instanceof c) && (cVar = (c) hVar) != null && cVar.Mx() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("showad", "1"));
                ay.AN().c(FrsADFragment.this.context, new String[]{com.baidu.tbadk.browser.a.c(cVar.Mx(), arrayList)});
                if (!ao.isEmpty(cVar.ayg())) {
                    TiebaStatic.log(new am("c13194").al("obj_type", cVar.ayg()).g(ImageViewerConfig.FORUM_ID, FrsADFragment.this.forumId));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getPageContext();
        initData(bundle);
        registerListener(this.dwF);
        registerListener(this.dtg);
        if (this.dwC == null) {
            this.dwC = new ADRequestModel(this.context);
        }
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dsd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = Long.parseLong(bundle.getString("forum_id"));
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.dsd = arguments.getString("name");
            this.mFrom = arguments.getString("from");
            this.forumId = Long.parseLong(arguments.getString("forum_id"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_ad_fragment, (ViewGroup) null);
        this.dwA = new e(this, inflate);
        this.dwA.a(this.bEk);
        this.dwD = new a(this, this.dwA.getListView());
        this.dwD.setOnAdapterItemClickListener(this.dtz);
        if (this.dwB == null) {
            this.dwB = new ADRequestModel.a() { // from class: com.baidu.tieba.frs.ad.FrsADFragment.1
                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADHttpResponseMessage aDHttpResponseMessage) {
                    if (aDHttpResponseMessage != null && FrsADFragment.this.dwA != null) {
                        if (aDHttpResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDHttpResponseMessage.getOffset();
                            FrsADFragment.this.dwE = aDHttpResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDHttpResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.VC();
                            return;
                        }
                        FrsADFragment.this.VZ();
                    }
                }

                @Override // com.baidu.tieba.frs.adModel.ADRequestModel.a
                public void a(ADSocketResponseMessage aDSocketResponseMessage) {
                    if (aDSocketResponseMessage != null && FrsADFragment.this.dwA != null) {
                        if (aDSocketResponseMessage.getError() == 0) {
                            FrsADFragment.this.offset = (int) aDSocketResponseMessage.getOffset();
                            FrsADFragment.this.dwE = aDSocketResponseMessage.getList();
                            FrsADFragment.this.mHasMore = aDSocketResponseMessage.getHas_more() == 1;
                            FrsADFragment.this.VC();
                            return;
                        }
                        FrsADFragment.this.VZ();
                    }
                }
            };
        }
        this.dwC.a(this.dwB);
        if (!com.baidu.adp.lib.util.j.kK()) {
            VZ();
        }
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VC() {
        if (this.dwA != null) {
            hideLoadingView();
            if (this.Rs == 0) {
                if (!v.z(this.dwE)) {
                    A(true, false);
                    this.dwA.Wc();
                    return;
                }
                showEmptyView();
            } else if (this.Rs == 2) {
                this.dwA.cH(false);
                if (!v.z(this.dwE)) {
                    A(true, false);
                    this.dwA.Wc();
                    return;
                }
                showEmptyView();
            } else if (this.Rs == 1) {
                if (!v.z(this.dwE)) {
                    A(false, true);
                } else {
                    this.dwA.Wc();
                }
            }
        }
    }

    private void A(boolean z, boolean z2) {
        if (this.cWF != null) {
            if (z) {
                this.cWF.clear();
            }
            if (z2) {
                for (int i = 0; i < this.cWF.size(); i++) {
                    h hVar = (h) v.d(this.cWF, i);
                    if (hVar instanceof c) {
                        ((c) hVar).gn(false);
                    }
                }
            }
            this.cWF.addAll(this.dwE);
            this.dwA.ayl().setData(this.cWF);
            this.dwA.ayl().notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void avO() {
        if (this.dwA != null && this.dwA.getListView() != null) {
            this.dwA.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void VY() {
        if (this.dwA != null) {
            avO();
            this.dwA.startPullRefresh();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dwA != null) {
            if (this.dwA != null && this.dwA.getListView() != null) {
                this.dwA.getListView().stopScroll();
            }
            Vr();
            if (l.lb() && this.mHasMore) {
                lm(1);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dwA != null) {
            this.dwA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lm(int i) {
        if (this.dwC != null) {
            Wa();
            this.Rs = i;
            if (i == 0 || i == 2) {
                this.dwC.b(this.forumId, 0, 20);
            } else if (i == 1) {
                this.dwC.b(this.forumId, this.offset, 20);
            }
        }
    }

    public BdTypeRecyclerView getListView() {
        if (this.dwA == null) {
            return null;
        }
        return this.dwA.getListView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (com.baidu.adp.lib.util.j.kK()) {
            lm(0);
            showLoadingView();
            return;
        }
        VZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        this.dwA.go(false);
        showLoadingView(this.dwA.axn(), true, getResources().getDimensionPixelSize(e.C0141e.ds250));
    }

    private void hideLoadingView() {
        this.dwA.go(true);
        hideLoadingView(this.dwA.axn());
    }

    private void Vr() {
        if (!this.mHasMore) {
            if (v.z(this.dwE)) {
                this.dwA.Wd();
                return;
            } else {
                this.dwA.Wc();
                return;
            }
        }
        this.dwA.Wb();
    }

    private void showEmptyView() {
        if (this.cWF != null && this.dwA != null) {
            this.cWF.add(new m());
            this.dwA.ayl().setData(this.cWF);
            this.dwA.ayl().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VZ() {
        this.dwA.go(false);
        this.dwA.aym().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dwA.Wd();
        this.dwA.getListView().getData().clear();
        this.dwA.axc();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.KA();
            this.mRefreshView.fr(getResources().getDimensionPixelSize(e.C0141e.ds_102));
            this.mRefreshView.Ky().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dwA.axn(), true);
    }

    private void Wa() {
        this.dwA.go(true);
        this.dwA.aym().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Ks()) {
            this.mRefreshView.ad(this.dwA.axn());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            lm(0);
            showLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dwA != null) {
            this.dwA.onDestroy();
        }
        if (this.dwC != null) {
            this.dwC.onDestroy();
        }
        super.onDestroy();
    }
}
