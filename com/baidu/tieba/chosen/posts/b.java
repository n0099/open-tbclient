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
    private NavigationBar cPK;
    private g cXm;
    private NoNetworkView dog;
    private ChosenPostActivity eqk;
    private BdListView eql;
    private com.baidu.tieba.chosen.posts.a eqm;
    private com.baidu.tbadk.mvc.g.a eqn;
    private boolean eqo;
    private h eqp;
    private i mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected i aRS() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.eqk.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eqo = false;
        this.eqk = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aDv() {
        this.mRootView = this.eqk.getLayoutInflater().inflate(d.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aRT() {
        this.paddingTop = this.eqk.getResources().getDimensionPixelSize(d.e.ds108);
        this.paddingHorizontal = this.eqk.getResources().getDimensionPixelSize(d.e.ds150);
        this.cPK = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.cPK.setTitleText(d.j.recommend_frs_hot_thread_title);
        this.cPK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eql = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.dog = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.eqm = new com.baidu.tieba.chosen.posts.a(this.eqk.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.h.chosen_picture_layout, d.h.chosen_no_picture_layout, d.h.chosen_image_text_layout}, this.eqk.aoJ());
        this.eql.setAdapter((ListAdapter) this.eqm);
        this.mPullView = aRS();
        this.eql.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                b.this.eqk.aRN().ib(z);
            }
        });
        this.eql.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.eqm.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.eql.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.ly(b.this.getActivity().getString(d.j.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.eqm.getItem(i));
                        bVar.setUniqueId(b.this.eqk.getUniqueId());
                        b.this.eqk.aoJ().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.eqk.getPageContext());
                aVar.aaZ();
                return true;
            }
        });
        this.eql.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.lo()) {
                    b.this.eqk.aRN().aRR();
                } else if (b.this.eqn != null) {
                    b.this.eqn.qT();
                    b.this.eqn.jV(d.j.no_more_msg);
                }
            }
        });
        this.eqn = new com.baidu.tbadk.mvc.g.a(this.eqk);
        this.eqn.oM();
        getListView().setNextPage(this.eqn);
        this.cXm = new g(getActivity());
        this.cXm.onChangeSkinType();
        this.cXm.attachView(getView(), true);
        this.eqk.aRN().aRQ();
    }

    public Activity getActivity() {
        return this.eqk.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aob()) {
            case 4097:
                this.eqo = false;
                break;
            case 4098:
                this.eqo = true;
                break;
            case 4099:
                a(bVar.aoc());
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
            this.eqm.cg(((Long) extra).longValue());
            if (this.eqm.getCount() <= 5) {
                aRU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.cXm != null) {
            this.cXm.dettachView(getView());
        }
        if (errorData != null && this.eqm.aoF() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.eql.completePullRefreshPostDelayed(0L);
        if (this.eqn != null) {
            this.eqn.jV(d.j.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cPK != null) {
            this.cPK.onChangeSkinType(tbPageContext, i);
        }
        if (this.eqm != null) {
            this.eqm.b(tbPageContext, i);
        }
        if (this.eqn != null) {
            this.eqn.b(tbPageContext, i);
        }
        if (this.dog != null) {
            this.dog.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aoD()) {
                this.eqn.qT();
                if (aVar.aoB()) {
                    this.eqn.jU(d.j.loading);
                } else if (!aVar.aoC()) {
                    this.eqn.jV(d.j.no_more_msg);
                }
            } else {
                this.eqn.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.eql.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> aRW = ((com.baidu.tieba.chosen.posts.request.b) aVar).aRW();
            if (aRW != null && aRW.size() > 0) {
                this.eql.setVisibility(0);
            }
            if (this.cXm != null) {
                this.cXm.dettachView(getView());
            }
            if (this.eqo) {
                this.eqm.ad((List) aRW);
                return;
            }
            this.eqm.ae((List) aRW);
            if (aRW != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(d.j.chosen_post_recommend, new Object[]{Integer.valueOf(aRW.size())}), 0);
                b.gO(48);
                b.setOffsetY(this.paddingTop);
                b.gM(this.paddingHorizontal);
                b.abf().abh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRU() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.eqk.getUniqueId());
        this.eqk.aoJ().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.eql;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eqp == null) {
            this.eqp = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eqp.po(str);
        this.eqp.attachView(view, z);
        this.eqp.anB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eqp != null) {
            this.eqp.dettachView(view);
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
            b.this.cXm.attachView(b.this.getView(), true);
            b.this.aRU();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
