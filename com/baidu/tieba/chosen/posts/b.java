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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes10.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar eCn;
    private g eYg;
    private NoNetworkView fhf;
    private ChosenPostActivity gud;
    private BdListView gue;
    private com.baidu.tieba.chosen.posts.a guf;
    private com.baidu.tbadk.mvc.g.a gug;
    private boolean guh;
    private h gui;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.h bFF() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.gud.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.guh = false;
        this.gud = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bom() {
        this.mRootView = this.gud.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bFG() {
        this.paddingTop = this.gud.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.gud.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.eCn = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.eCn.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.eCn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gue = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.fhf = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.guf = new com.baidu.tieba.chosen.posts.a(this.gud.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.gud.aZc());
        this.gue.setAdapter((ListAdapter) this.guf);
        this.mPullView = bFF();
        this.gue.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                b.this.gud.bFA().lC(z);
            }
        });
        this.gue.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.guf.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.gue.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.ui(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.guf.getItem(i));
                        bVar.setUniqueId(b.this.gud.getUniqueId());
                        b.this.gud.aZc().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.gud.getPageContext());
                aVar.aMS();
                return true;
            }
        });
        this.gue.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.gud.bFA().bFE();
                } else if (b.this.gug != null) {
                    b.this.gug.display();
                    b.this.gug.mW(R.string.no_more_msg);
                }
            }
        });
        this.gug = new com.baidu.tbadk.mvc.g.a(this.gud);
        this.gug.createView();
        getListView().setNextPage(this.gug);
        this.eYg = new com.baidu.tbadk.k.g(getActivity());
        this.eYg.onChangeSkinType();
        this.eYg.attachView(getView(), true);
        this.gud.bFA().bFD();
    }

    public Activity getActivity() {
        return this.gud.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aYH()) {
            case 4097:
                this.guh = false;
                break;
            case 4098:
                this.guh = true;
                break;
            case 4099:
                a(bVar.aYI());
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
            this.guf.dT(((Long) extra).longValue());
            if (this.guf.getCount() <= 5) {
                bFH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.eYg != null) {
            this.eYg.dettachView(getView());
        }
        if (errorData != null && this.guf.aYZ() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.gue.completePullRefreshPostDelayed(0L);
        if (this.gug != null) {
            this.gug.mW(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eCn != null) {
            this.eCn.onChangeSkinType(tbPageContext, i);
        }
        if (this.guf != null) {
            this.guf.b(tbPageContext, i);
        }
        if (this.gug != null) {
            this.gug.b(tbPageContext, i);
        }
        if (this.fhf != null) {
            this.fhf.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aYX()) {
                this.gug.display();
                if (aVar.aYV()) {
                    this.gug.mV(R.string.loading);
                } else if (!aVar.aYW()) {
                    this.gug.mW(R.string.no_more_msg);
                }
            } else {
                this.gug.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.gue.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bFJ = ((com.baidu.tieba.chosen.posts.request.b) aVar).bFJ();
            if (bFJ != null && bFJ.size() > 0) {
                this.gue.setVisibility(0);
            }
            if (this.eYg != null) {
                this.eYg.dettachView(getView());
            }
            if (this.guh) {
                this.guf.aT(bFJ);
                return;
            }
            this.guf.aU(bFJ);
            if (bFJ != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bFJ.size())}), 0);
                a2.kl(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aMW().aMX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFH() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.gud.getUniqueId());
        this.gud.aZc().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.gue;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.gui == null) {
            this.gui = new h(getPageContext().getPageActivity(), new a());
        }
        this.gui.setSubText(str);
        this.gui.attachView(view, z);
        this.gui.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.gui != null) {
            this.gui.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.eYg.attachView(b.this.getView(), true);
            b.this.bFH();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
