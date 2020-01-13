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
/* loaded from: classes8.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar dXN;
    private g epL;
    private NoNetworkView exO;
    private ChosenPostActivity fLX;
    private BdListView fLY;
    private com.baidu.tieba.chosen.posts.a fLZ;
    private com.baidu.tbadk.mvc.g.a fMa;
    private boolean fMb;
    private h fMc;
    int fMd;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    int paddingHorizontal;

    protected com.baidu.tbadk.core.view.h buk() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.fLX.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.fMb = false;
        this.fLX = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bcD() {
        this.mRootView = this.fLX.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bul() {
        this.fMd = this.fLX.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.fLX.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.dXN = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.dXN.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.dXN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fLY = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.exO = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.fLZ = new com.baidu.tieba.chosen.posts.a(this.fLX.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.fLX.aOy());
        this.fLY.setAdapter((ListAdapter) this.fLZ);
        this.mPullView = buk();
        this.fLY.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                b.this.fLX.buf().ks(z);
            }
        });
        this.fLY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.fLZ.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.fLY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.sC(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.fLZ.getItem(i));
                        bVar.setUniqueId(b.this.fLX.getUniqueId());
                        b.this.fLX.aOy().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.fLX.getPageContext());
                aVar.aCp();
                return true;
            }
        });
        this.fLY.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.fLX.buf().buj();
                } else if (b.this.fMa != null) {
                    b.this.fMa.display();
                    b.this.fMa.ms(R.string.no_more_msg);
                }
            }
        });
        this.fMa = new com.baidu.tbadk.mvc.g.a(this.fLX);
        this.fMa.createView();
        getListView().setNextPage(this.fMa);
        this.epL = new com.baidu.tbadk.k.g(getActivity());
        this.epL.onChangeSkinType();
        this.epL.attachView(getView(), true);
        this.fLX.buf().bui();
    }

    public Activity getActivity() {
        return this.fLX.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aNR()) {
            case 4097:
                this.fMb = false;
                break;
            case 4098:
                this.fMb = true;
                break;
            case 4099:
                a(bVar.aNS());
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
            this.fLZ.dj(((Long) extra).longValue());
            if (this.fLZ.getCount() <= 5) {
                bum();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.epL != null) {
            this.epL.dettachView(getView());
        }
        if (errorData != null && this.fLZ.aOv() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.fLY.completePullRefreshPostDelayed(0L);
        if (this.fMa != null) {
            this.fMa.ms(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dXN != null) {
            this.dXN.onChangeSkinType(tbPageContext, i);
        }
        if (this.fLZ != null) {
            this.fLZ.b(tbPageContext, i);
        }
        if (this.fMa != null) {
            this.fMa.b(tbPageContext, i);
        }
        if (this.exO != null) {
            this.exO.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aOt()) {
                this.fMa.display();
                if (aVar.aOr()) {
                    this.fMa.mr(R.string.loading);
                } else if (!aVar.aOs()) {
                    this.fMa.ms(R.string.no_more_msg);
                }
            } else {
                this.fMa.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.fLY.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> buo = ((com.baidu.tieba.chosen.posts.request.b) aVar).buo();
            if (buo != null && buo.size() > 0) {
                this.fLY.setVisibility(0);
            }
            if (this.epL != null) {
                this.epL.dettachView(getView());
            }
            if (this.fMb) {
                this.fLZ.aJ(buo);
                return;
            }
            this.fLZ.aK(buo);
            if (buo != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(buo.size())}), 0);
                a2.jN(48);
                a2.setOffsetY(this.fMd);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aCt().aCu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bum() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.fLX.getUniqueId());
        this.fLX.aOy().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.fLY;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.fMc == null) {
            this.fMc = new h(getPageContext().getPageActivity(), new a());
        }
        this.fMc.setSubText(str);
        this.fMc.attachView(view, z);
        this.fMc.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.fMc != null) {
            this.fMc.dettachView(view);
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
            b.this.epL.attachView(b.this.getView(), true);
            b.this.bum();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
