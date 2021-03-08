package com.baidu.tieba.chosen.posts;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.chosen.posts.a.c;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class b extends d<ChosenPostActivity> {
    private g gLk;
    private NoNetworkView gXx;
    private NavigationBar glw;
    private ChosenPostActivity iEb;
    private BdListView iEc;
    private com.baidu.tieba.chosen.posts.a iEd;
    private com.baidu.tbadk.mvc.g.a iEe;
    private boolean iEf;
    private h iEg;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g ctt() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.iEb.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.iEf = false;
        this.iEb = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVx() {
        this.mRootView = this.iEb.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ctu() {
        this.paddingTop = this.iEb.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.iEb.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.glw = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.glw.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.glw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iEc = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gXx = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.iEd = new com.baidu.tieba.chosen.posts.a(this.iEb.getPageContext(), new Class[]{c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.iEb.bDL());
        this.iEc.setAdapter((ListAdapter) this.iEd);
        this.mPullView = ctt();
        this.iEc.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.iEb.ctp().pG(z);
            }
        });
        this.iEc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.iEd.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.iEc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.AB(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.iEd.getItem(i));
                        bVar.setUniqueId(b.this.iEb.getUniqueId());
                        b.this.iEb.bDL().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.iEb.getPageContext());
                aVar.bqz();
                return true;
            }
        });
        this.iEc.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.iEb.ctp().cts();
                } else if (b.this.iEe != null) {
                    b.this.iEe.display();
                    b.this.iEe.rt(R.string.no_more_msg);
                }
            }
        });
        this.iEe = new com.baidu.tbadk.mvc.g.a(this.iEb);
        this.iEe.createView();
        getListView().setNextPage(this.iEe);
        this.gLk = new g(getActivity());
        this.gLk.onChangeSkinType();
        this.gLk.attachView(getView(), true);
        this.iEb.ctp().ctr();
    }

    public Activity getActivity() {
        return this.iEb.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bDq()) {
            case 4097:
                this.iEf = false;
                break;
            case 4098:
                this.iEf = true;
                break;
            case 4099:
                a(bVar.bDr());
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
            this.iEd.gf(((Long) extra).longValue());
            if (this.iEd.getCount() <= 5) {
                ctv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gLk != null) {
            this.gLk.dettachView(getView());
        }
        if (errorData != null && this.iEd.bDI() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.iEc.completePullRefreshPostDelayed(0L);
        if (this.iEe != null) {
            this.iEe.rt(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.glw != null) {
            this.glw.onChangeSkinType(tbPageContext, i);
        }
        if (this.iEd != null) {
            this.iEd.b(tbPageContext, i);
        }
        if (this.iEe != null) {
            this.iEe.b(tbPageContext, i);
        }
        if (this.gXx != null) {
            this.gXx.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bDG()) {
                this.iEe.display();
                if (aVar.bDE()) {
                    this.iEe.rs(R.string.loading);
                } else if (!aVar.bDF()) {
                    this.iEe.rt(R.string.no_more_msg);
                }
            } else {
                this.iEe.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.iEc.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> ctx = ((com.baidu.tieba.chosen.posts.request.b) aVar).ctx();
            if (ctx != null && ctx.size() > 0) {
                this.iEc.setVisibility(0);
            }
            if (this.gLk != null) {
                this.gLk.dettachView(getView());
            }
            if (this.iEf) {
                this.iEd.bH(ctx);
                return;
            }
            this.iEd.bI(ctx);
            if (ctx != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(ctx.size())}), 0);
                b.nH(48);
                b.setOffsetY(this.paddingTop);
                b.setPaddingHorizontal(this.paddingHorizontal);
                b.bqE().bqF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctv() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.iEb.getUniqueId());
        this.iEb.bDL().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.iEc;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.iEg == null) {
            this.iEg = new h(getPageContext().getPageActivity(), new a());
        }
        this.iEg.setSubText(str);
        this.iEg.attachView(view, z);
        this.iEg.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.iEg != null) {
            this.iEg.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.gLk.attachView(b.this.getView(), true);
            b.this.ctv();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
