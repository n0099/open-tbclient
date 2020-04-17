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
    private NavigationBar eCi;
    private g eYb;
    private NoNetworkView fha;
    private ChosenPostActivity gtX;
    private BdListView gtY;
    private com.baidu.tieba.chosen.posts.a gtZ;
    private com.baidu.tbadk.mvc.g.a gua;
    private boolean gub;
    private h guc;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.h bFH() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.gtX.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.gub = false;
        this.gtX = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View boo() {
        this.mRootView = this.gtX.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bFI() {
        this.paddingTop = this.gtX.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.gtX.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.eCi = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.eCi.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.eCi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gtY = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.fha = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.gtZ = new com.baidu.tieba.chosen.posts.a(this.gtX.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.gtX.aZe());
        this.gtY.setAdapter((ListAdapter) this.gtZ);
        this.mPullView = bFH();
        this.gtY.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                b.this.gtX.bFC().lC(z);
            }
        });
        this.gtY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.gtZ.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.gtY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.uf(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.gtZ.getItem(i));
                        bVar.setUniqueId(b.this.gtX.getUniqueId());
                        b.this.gtX.aZe().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.gtX.getPageContext());
                aVar.aMU();
                return true;
            }
        });
        this.gtY.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.gtX.bFC().bFG();
                } else if (b.this.gua != null) {
                    b.this.gua.display();
                    b.this.gua.mW(R.string.no_more_msg);
                }
            }
        });
        this.gua = new com.baidu.tbadk.mvc.g.a(this.gtX);
        this.gua.createView();
        getListView().setNextPage(this.gua);
        this.eYb = new com.baidu.tbadk.k.g(getActivity());
        this.eYb.onChangeSkinType();
        this.eYb.attachView(getView(), true);
        this.gtX.bFC().bFF();
    }

    public Activity getActivity() {
        return this.gtX.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aYJ()) {
            case 4097:
                this.gub = false;
                break;
            case 4098:
                this.gub = true;
                break;
            case 4099:
                a(bVar.aYK());
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
            this.gtZ.dT(((Long) extra).longValue());
            if (this.gtZ.getCount() <= 5) {
                bFJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.eYb != null) {
            this.eYb.dettachView(getView());
        }
        if (errorData != null && this.gtZ.aZb() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.gtY.completePullRefreshPostDelayed(0L);
        if (this.gua != null) {
            this.gua.mW(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eCi != null) {
            this.eCi.onChangeSkinType(tbPageContext, i);
        }
        if (this.gtZ != null) {
            this.gtZ.b(tbPageContext, i);
        }
        if (this.gua != null) {
            this.gua.b(tbPageContext, i);
        }
        if (this.fha != null) {
            this.fha.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aYZ()) {
                this.gua.display();
                if (aVar.aYX()) {
                    this.gua.mV(R.string.loading);
                } else if (!aVar.aYY()) {
                    this.gua.mW(R.string.no_more_msg);
                }
            } else {
                this.gua.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.gtY.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bFL = ((com.baidu.tieba.chosen.posts.request.b) aVar).bFL();
            if (bFL != null && bFL.size() > 0) {
                this.gtY.setVisibility(0);
            }
            if (this.eYb != null) {
                this.eYb.dettachView(getView());
            }
            if (this.gub) {
                this.gtZ.aT(bFL);
                return;
            }
            this.gtZ.aU(bFL);
            if (bFL != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bFL.size())}), 0);
                a2.kl(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aMY().aMZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFJ() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.gtX.getUniqueId());
        this.gtX.aZe().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.gtY;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.guc == null) {
            this.guc = new h(getPageContext().getPageActivity(), new a());
        }
        this.guc.setSubText(str);
        this.guc.attachView(view, z);
        this.guc.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.guc != null) {
            this.guc.dettachView(view);
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
            b.this.eYb.attachView(b.this.getView(), true);
            b.this.bFJ();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
