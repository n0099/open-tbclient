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
    private NavigationBar cPM;
    private g cXp;
    private NoNetworkView doj;
    private ChosenPostActivity epW;
    private BdListView epX;
    private com.baidu.tieba.chosen.posts.a epY;
    private com.baidu.tbadk.mvc.g.a epZ;
    private boolean eqa;
    private h eqb;
    private i mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected i aRQ() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.epW.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eqa = false;
        this.epW = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aDs() {
        this.mRootView = this.epW.getLayoutInflater().inflate(d.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aRR() {
        this.paddingTop = this.epW.getResources().getDimensionPixelSize(d.e.ds108);
        this.paddingHorizontal = this.epW.getResources().getDimensionPixelSize(d.e.ds150);
        this.cPM = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.cPM.setTitleText(d.j.recommend_frs_hot_thread_title);
        this.cPM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.epX = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.doj = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.epY = new com.baidu.tieba.chosen.posts.a(this.epW.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.h.chosen_picture_layout, d.h.chosen_no_picture_layout, d.h.chosen_image_text_layout}, this.epW.aoG());
        this.epX.setAdapter((ListAdapter) this.epY);
        this.mPullView = aRQ();
        this.epX.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                b.this.epW.aRL().ib(z);
            }
        });
        this.epX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.epY.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.epX.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.epY.getItem(i));
                        bVar.setUniqueId(b.this.epW.getUniqueId());
                        b.this.epW.aoG().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.epW.getPageContext());
                aVar.aaW();
                return true;
            }
        });
        this.epX.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.lo()) {
                    b.this.epW.aRL().aRP();
                } else if (b.this.epZ != null) {
                    b.this.epZ.qT();
                    b.this.epZ.jU(d.j.no_more_msg);
                }
            }
        });
        this.epZ = new com.baidu.tbadk.mvc.g.a(this.epW);
        this.epZ.oM();
        getListView().setNextPage(this.epZ);
        this.cXp = new g(getActivity());
        this.cXp.onChangeSkinType();
        this.cXp.attachView(getView(), true);
        this.epW.aRL().aRO();
    }

    public Activity getActivity() {
        return this.epW.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.anY()) {
            case 4097:
                this.eqa = false;
                break;
            case 4098:
                this.eqa = true;
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
            this.epY.cg(((Long) extra).longValue());
            if (this.epY.getCount() <= 5) {
                aRS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.cXp != null) {
            this.cXp.dettachView(getView());
        }
        if (errorData != null && this.epY.aoC() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.epX.completePullRefreshPostDelayed(0L);
        if (this.epZ != null) {
            this.epZ.jU(d.j.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cPM != null) {
            this.cPM.onChangeSkinType(tbPageContext, i);
        }
        if (this.epY != null) {
            this.epY.b(tbPageContext, i);
        }
        if (this.epZ != null) {
            this.epZ.b(tbPageContext, i);
        }
        if (this.doj != null) {
            this.doj.onChangeSkinType(tbPageContext, i);
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
                this.epZ.qT();
                if (aVar.aoy()) {
                    this.epZ.jT(d.j.loading);
                } else if (!aVar.aoz()) {
                    this.epZ.jU(d.j.no_more_msg);
                }
            } else {
                this.epZ.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.epX.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> aRU = ((com.baidu.tieba.chosen.posts.request.b) aVar).aRU();
            if (aRU != null && aRU.size() > 0) {
                this.epX.setVisibility(0);
            }
            if (this.cXp != null) {
                this.cXp.dettachView(getView());
            }
            if (this.eqa) {
                this.epY.ad(aRU);
                return;
            }
            this.epY.ae(aRU);
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
        bVar.setUniqueId(this.epW.getUniqueId());
        this.epW.aoG().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.epX;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eqb == null) {
            this.eqb = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eqb.pp(str);
        this.eqb.attachView(view, z);
        this.eqb.any();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eqb != null) {
            this.eqb.dettachView(view);
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
            b.this.cXp.attachView(b.this.getView(), true);
            b.this.aRS();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
