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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.e;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar bEF;
    private f bLl;
    private NoNetworkView bZh;
    private ChosenPostActivity dgo;
    private BdListView dgp;
    private com.baidu.tieba.chosen.posts.a dgq;
    private com.baidu.tbadk.mvc.g.a dgr;
    private boolean dgs;
    private g dgt;
    private k mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected k asb() {
        if (this.mPullView == null) {
            this.mPullView = new k(this.dgo.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.dgs = false;
        this.dgo = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View acA() {
        this.mRootView = this.dgo.getLayoutInflater().inflate(e.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asc() {
        this.paddingTop = this.dgo.getResources().getDimensionPixelSize(e.C0210e.ds108);
        this.paddingHorizontal = this.dgo.getResources().getDimensionPixelSize(e.C0210e.ds150);
        this.bEF = (NavigationBar) getView().findViewById(e.g.chosen_post_navigation_bar);
        this.bEF.setTitleText(e.j.recommend_frs_hot_thread_title);
        this.bEF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dgp = (BdListView) getView().findViewById(e.g.chosen_post_list);
        this.bZh = (NoNetworkView) getView().findViewById(e.g.view_no_network);
        this.dgq = new com.baidu.tieba.chosen.posts.a(this.dgo.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{e.h.chosen_picture_layout, e.h.chosen_no_picture_layout, e.h.chosen_image_text_layout}, this.dgo.Pe());
        this.dgp.setAdapter((ListAdapter) this.dgq);
        this.mPullView = asb();
        this.dgp.setPullRefresh(this.mPullView);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                b.this.dgo.arW().fJ(z);
            }
        });
        this.dgp.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.dgq.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.dgp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.eK(b.this.getActivity().getString(e.j.chosen_post_dialog_text));
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.dgq.getItem(i));
                        bVar.setUniqueId(b.this.dgo.getUniqueId());
                        b.this.dgo.Pe().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.dgo.getPageContext());
                aVar.BS();
                return true;
            }
        });
        this.dgp.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.ll()) {
                    b.this.dgo.arW().asa();
                } else if (b.this.dgr != null) {
                    b.this.dgr.pR();
                    b.this.dgr.gh(e.j.no_more_msg);
                }
            }
        });
        this.dgr = new com.baidu.tbadk.mvc.g.a(this.dgo);
        this.dgr.oH();
        getListView().setNextPage(this.dgr);
        this.bLl = new f(getActivity());
        this.bLl.onChangeSkinType();
        this.bLl.attachView(getView(), true);
        this.dgo.arW().arZ();
    }

    public Activity getActivity() {
        return this.dgo.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Ow()) {
            case 4097:
                this.dgs = false;
                break;
            case 4098:
                this.dgs = true;
                break;
            case 4099:
                a(bVar.Ox());
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
            this.dgq.bG(((Long) extra).longValue());
            if (this.dgq.getCount() <= 5) {
                asd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bLl != null) {
            this.bLl.dettachView(getView());
        }
        if (errorData != null && this.dgq.Pa() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(e.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.dgp.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        if (this.dgr != null) {
            this.dgr.gh(e.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bEF != null) {
            this.bEF.onChangeSkinType(tbPageContext, i);
        }
        if (this.dgq != null) {
            this.dgq.b(tbPageContext, i);
        }
        if (this.dgr != null) {
            this.dgr.b(tbPageContext, i);
        }
        if (this.bZh != null) {
            this.bZh.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.OY()) {
                this.dgr.pR();
                if (aVar.OW()) {
                    this.dgr.gg(e.j.loading);
                } else if (!aVar.OX()) {
                    this.dgr.gh(e.j.no_more_msg);
                }
            } else {
                this.dgr.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.dgp.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> asf = ((com.baidu.tieba.chosen.posts.request.b) aVar).asf();
            if (asf != null && asf.size() > 0) {
                this.dgp.setVisibility(0);
            }
            if (this.bLl != null) {
                this.bLl.dettachView(getView());
            }
            if (this.dgs) {
                this.dgq.R(asf);
                return;
            }
            this.dgq.S(asf);
            if (asf != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(e.j.chosen_post_recommend, new Object[]{Integer.valueOf(asf.size())}), 0);
                a2.dn(48);
                a2.setOffsetY(this.paddingTop);
                a2.dl(this.paddingHorizontal);
                a2.BY().Ca();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asd() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.dgo.getUniqueId());
        this.dgo.Pe().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.dgp;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.dgt == null) {
            this.dgt = new g(getPageContext().getPageActivity(), new a());
        }
        this.dgt.iC(str);
        this.dgt.attachView(view, z);
        this.dgt.Od();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.dgt != null) {
            this.dgt.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.bLl.attachView(b.this.getView(), true);
            b.this.asd();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
