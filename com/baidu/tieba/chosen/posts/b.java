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
/* loaded from: classes8.dex */
public class b extends d<ChosenPostActivity> {
    private g gLj;
    private NoNetworkView gXw;
    private NavigationBar glZ;
    private ChosenPostActivity iBb;
    private BdListView iBc;
    private com.baidu.tieba.chosen.posts.a iBd;
    private com.baidu.tbadk.mvc.g.a iBe;
    private boolean iBf;
    private h iBg;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g cvL() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.iBb.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.iBf = false;
        this.iBb = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bYm() {
        this.mRootView = this.iBb.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cvM() {
        this.paddingTop = this.iBb.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.iBb.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.glZ = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.glZ.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.glZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iBc = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gXw = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.iBd = new com.baidu.tieba.chosen.posts.a(this.iBb.getPageContext(), new Class[]{c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.iBb.bHi());
        this.iBc.setAdapter((ListAdapter) this.iBd);
        this.mPullView = cvL();
        this.iBc.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.iBb.cvH().pA(z);
            }
        });
        this.iBc.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.iBd.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.iBc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.Bp(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.iBd.getItem(i));
                        bVar.setUniqueId(b.this.iBb.getUniqueId());
                        b.this.iBb.bHi().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.iBb.getPageContext());
                aVar.btX();
                return true;
            }
        });
        this.iBc.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.iBb.cvH().cvK();
                } else if (b.this.iBe != null) {
                    b.this.iBe.rV();
                    b.this.iBe.sT(R.string.no_more_msg);
                }
            }
        });
        this.iBe = new com.baidu.tbadk.mvc.g.a(this.iBb);
        this.iBe.createView();
        getListView().setNextPage(this.iBe);
        this.gLj = new g(getActivity());
        this.gLj.onChangeSkinType();
        this.gLj.attachView(getView(), true);
        this.iBb.cvH().cvJ();
    }

    public Activity getActivity() {
        return this.iBb.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bGN()) {
            case 4097:
                this.iBf = false;
                break;
            case 4098:
                this.iBf = true;
                break;
            case 4099:
                a(bVar.bGO());
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
            this.iBd.ga(((Long) extra).longValue());
            if (this.iBd.getCount() <= 5) {
                cvN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gLj != null) {
            this.gLj.dettachView(getView());
        }
        if (errorData != null && this.iBd.bHf() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.iBc.completePullRefreshPostDelayed(0L);
        if (this.iBe != null) {
            this.iBe.sT(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.glZ != null) {
            this.glZ.onChangeSkinType(tbPageContext, i);
        }
        if (this.iBd != null) {
            this.iBd.b(tbPageContext, i);
        }
        if (this.iBe != null) {
            this.iBe.b(tbPageContext, i);
        }
        if (this.gXw != null) {
            this.gXw.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bHd()) {
                this.iBe.rV();
                if (aVar.bHb()) {
                    this.iBe.sS(R.string.loading);
                } else if (!aVar.bHc()) {
                    this.iBe.sT(R.string.no_more_msg);
                }
            } else {
                this.iBe.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.iBc.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> cvP = ((com.baidu.tieba.chosen.posts.request.b) aVar).cvP();
            if (cvP != null && cvP.size() > 0) {
                this.iBc.setVisibility(0);
            }
            if (this.gLj != null) {
                this.gLj.dettachView(getView());
            }
            if (this.iBf) {
                this.iBd.bM(cvP);
                return;
            }
            this.iBd.bN(cvP);
            if (cvP != null) {
                BdToast b2 = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(cvP.size())}), 0);
                b2.pj(48);
                b2.setOffsetY(this.paddingTop);
                b2.setPaddingHorizontal(this.paddingHorizontal);
                b2.buc().bud();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvN() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.iBb.getUniqueId());
        this.iBb.bHi().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.iBc;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.iBg == null) {
            this.iBg = new h(getPageContext().getPageActivity(), new a());
        }
        this.iBg.setSubText(str);
        this.iBg.attachView(view, z);
        this.iBg.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.iBg != null) {
            this.iBg.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.gLj.attachView(b.this.getView(), true);
            b.this.cvN();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
