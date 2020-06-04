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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes10.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar eQX;
    private g flb;
    private NoNetworkView fuZ;
    private ChosenPostActivity gIZ;
    private BdListView gJa;
    private com.baidu.tieba.chosen.posts.a gJb;
    private com.baidu.tbadk.mvc.g.a gJc;
    private boolean gJd;
    private h gJe;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g bMb() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.gIZ.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.gJd = false;
        this.gIZ = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View btW() {
        this.mRootView = this.gIZ.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bMc() {
        this.paddingTop = this.gIZ.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.gIZ.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.eQX = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.eQX.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.eQX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gJa = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.fuZ = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.gJb = new com.baidu.tieba.chosen.posts.a(this.gIZ.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.gIZ.bfn());
        this.gJa.setAdapter((ListAdapter) this.gJb);
        this.mPullView = bMb();
        this.gJa.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.gIZ.bLX().lY(z);
            }
        });
        this.gJa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.gJb.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.gJa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.vO(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.gJb.getItem(i));
                        bVar.setUniqueId(b.this.gIZ.getUniqueId());
                        b.this.gIZ.bfn().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.gIZ.getPageContext());
                aVar.aST();
                return true;
            }
        });
        this.gJa.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.gIZ.bLX().bMa();
                } else if (b.this.gJc != null) {
                    b.this.gJc.display();
                    b.this.gJc.nA(R.string.no_more_msg);
                }
            }
        });
        this.gJc = new com.baidu.tbadk.mvc.g.a(this.gIZ);
        this.gJc.createView();
        getListView().setNextPage(this.gJc);
        this.flb = new g(getActivity());
        this.flb.onChangeSkinType();
        this.flb.attachView(getView(), true);
        this.gIZ.bLX().bLZ();
    }

    public Activity getActivity() {
        return this.gIZ.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.beS()) {
            case 4097:
                this.gJd = false;
                break;
            case 4098:
                this.gJd = true;
                break;
            case 4099:
                a(bVar.beT());
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
            this.gJb.dU(((Long) extra).longValue());
            if (this.gJb.getCount() <= 5) {
                bMd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.flb != null) {
            this.flb.dettachView(getView());
        }
        if (errorData != null && this.gJb.bfk() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.gJa.completePullRefreshPostDelayed(0L);
        if (this.gJc != null) {
            this.gJc.nA(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eQX != null) {
            this.eQX.onChangeSkinType(tbPageContext, i);
        }
        if (this.gJb != null) {
            this.gJb.b(tbPageContext, i);
        }
        if (this.gJc != null) {
            this.gJc.b(tbPageContext, i);
        }
        if (this.fuZ != null) {
            this.fuZ.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bfi()) {
                this.gJc.display();
                if (aVar.bfg()) {
                    this.gJc.nz(R.string.loading);
                } else if (!aVar.bfh()) {
                    this.gJc.nA(R.string.no_more_msg);
                }
            } else {
                this.gJc.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.gJa.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bMf = ((com.baidu.tieba.chosen.posts.request.b) aVar).bMf();
            if (bMf != null && bMf.size() > 0) {
                this.gJa.setVisibility(0);
            }
            if (this.flb != null) {
                this.flb.dettachView(getView());
            }
            if (this.gJd) {
                this.gJb.aO(bMf);
                return;
            }
            this.gJb.aP(bMf);
            if (bMf != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bMf.size())}), 0);
                a2.kN(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aSX().aSY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMd() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.gIZ.getUniqueId());
        this.gIZ.bfn().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.gJa;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.gJe == null) {
            this.gJe = new h(getPageContext().getPageActivity(), new a());
        }
        this.gJe.setSubText(str);
        this.gJe.attachView(view, z);
        this.gJe.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.gJe != null) {
            this.gJe.dettachView(view);
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
            b.this.flb.attachView(b.this.getView(), true);
            b.this.bMd();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
