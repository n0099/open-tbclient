package com.baidu.tieba.chosen.posts;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar cPN;
    private g cXq;
    private NoNetworkView dok;
    private ChosenPostActivity epX;
    private BdListView epY;
    private com.baidu.tieba.chosen.posts.a epZ;
    private com.baidu.tbadk.mvc.g.a eqa;
    private boolean eqb;
    private h eqc;
    private i mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected i aRQ() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.epX.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eqb = false;
        this.epX = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aDs() {
        this.mRootView = this.epX.getLayoutInflater().inflate(d.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aRR() {
        this.paddingTop = this.epX.getResources().getDimensionPixelSize(d.e.ds108);
        this.paddingHorizontal = this.epX.getResources().getDimensionPixelSize(d.e.ds150);
        this.cPN = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.cPN.setTitleText(d.j.recommend_frs_hot_thread_title);
        this.cPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.epY = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.dok = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.epZ = new com.baidu.tieba.chosen.posts.a(this.epX.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.h.chosen_picture_layout, d.h.chosen_no_picture_layout, d.h.chosen_image_text_layout}, this.epX.aoG());
        this.epY.setAdapter((ListAdapter) this.epZ);
        this.mPullView = aRQ();
        this.epY.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                b.this.epX.aRL().ib(z);
            }
        });
        this.epY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.epZ.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.epY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.lz(b.this.getActivity().getString(d.j.chosen_post_dialog_text));
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.epZ.getItem(i));
                        bVar.setUniqueId(b.this.epX.getUniqueId());
                        b.this.epX.aoG().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.epX.getPageContext());
                aVar.aaW();
                return true;
            }
        });
        this.epY.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.lo()) {
                    b.this.epX.aRL().aRP();
                } else if (b.this.eqa != null) {
                    b.this.eqa.qT();
                    b.this.eqa.jU(d.j.no_more_msg);
                }
            }
        });
        this.eqa = new com.baidu.tbadk.mvc.g.a(this.epX);
        this.eqa.oM();
        getListView().setNextPage(this.eqa);
        this.cXq = new g(getActivity());
        this.cXq.onChangeSkinType();
        this.cXq.attachView(getView(), true);
        this.epX.aRL().aRO();
    }

    public Activity getActivity() {
        return this.epX.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.anY()) {
            case 4097:
                this.eqb = false;
                break;
            case 4098:
                this.eqb = true;
                break;
            case 4099:
                a(bVar.anZ());
                break;
            case 4102:
                c(bVar);
                break;
        }
        return false;
    }

    private void c(com.baidu.tbadk.mvc.c.b bVar) {
        Object extra = bVar.getExtra();
        if (extra instanceof Long) {
            this.epZ.cg(((Long) extra).longValue());
            if (this.epZ.getCount() <= 5) {
                aRS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.cXq != null) {
            this.cXq.dettachView(getView());
        }
        if (errorData != null && this.epZ.aoC() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.epY.completePullRefreshPostDelayed(0L);
        if (this.eqa != null) {
            this.eqa.jU(d.j.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cPN != null) {
            this.cPN.onChangeSkinType(tbPageContext, i);
        }
        if (this.epZ != null) {
            this.epZ.b(tbPageContext, i);
        }
        if (this.eqa != null) {
            this.eqa.b(tbPageContext, i);
        }
        if (this.dok != null) {
            this.dok.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aoA()) {
                this.eqa.qT();
                if (aVar.aoy()) {
                    this.eqa.jT(d.j.loading);
                } else if (!aVar.aoz()) {
                    this.eqa.jU(d.j.no_more_msg);
                }
            } else {
                this.eqa.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.epY.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> aRU = ((com.baidu.tieba.chosen.posts.request.b) aVar).aRU();
            if (aRU != null && aRU.size() > 0) {
                this.epY.setVisibility(0);
            }
            if (this.cXq != null) {
                this.cXq.dettachView(getView());
            }
            if (this.eqb) {
                this.epZ.ad(aRU);
                return;
            }
            this.epZ.ae(aRU);
            if (aRU != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(d.j.chosen_post_recommend, new Object[]{Integer.valueOf(aRU.size())}), 0);
                b.gN(48);
                b.setOffsetY(this.paddingTop);
                b.gL(this.paddingHorizontal);
                b.abc().abe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRS() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.epX.getUniqueId());
        this.epX.aoG().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.epY;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eqc == null) {
            this.eqc = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eqc.pp(str);
        this.eqc.attachView(view, z);
        this.eqc.any();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eqc != null) {
            this.eqc.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.cXq.attachView(b.this.getView(), true);
            b.this.aRS();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
