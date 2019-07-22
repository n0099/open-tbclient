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
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class b extends c<ChosenPostActivity> {
    int bNE;
    private NavigationBar cZw;
    private NoNetworkView dCk;
    private g djG;
    private ChosenPostActivity eKB;
    private BdListView eKC;
    private com.baidu.tieba.chosen.posts.a eKD;
    private com.baidu.tbadk.mvc.g.a eKE;
    private boolean eKF;
    private h eKG;
    private i mPullView;
    private View mRootView;
    int paddingTop;

    protected i bbb() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.eKB.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eKF = false;
        this.eKB = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aLn() {
        this.mRootView = this.eKB.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbc() {
        this.paddingTop = this.eKB.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.bNE = this.eKB.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.cZw = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.cZw.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.cZw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKC = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.dCk = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.eKD = new com.baidu.tieba.chosen.posts.a(this.eKB.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.eKB.auS());
        this.eKC.setAdapter((ListAdapter) this.eKD);
        this.mPullView = bbb();
        this.eKC.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                b.this.eKB.baW().iP(z);
            }
        });
        this.eKC.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.eKD.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.eKC.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.mO(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.eKD.getItem(i));
                        bVar.setUniqueId(b.this.eKB.getUniqueId());
                        b.this.eKB.auS().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.eKB.getPageContext());
                aVar.agI();
                return true;
            }
        });
        this.eKC.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.kt()) {
                    b.this.eKB.baW().bba();
                } else if (b.this.eKE != null) {
                    b.this.eKE.qk();
                    b.this.eKE.kO(R.string.no_more_msg);
                }
            }
        });
        this.eKE = new com.baidu.tbadk.mvc.g.a(this.eKB);
        this.eKE.nZ();
        getListView().setNextPage(this.eKE);
        this.djG = new g(getActivity());
        this.djG.onChangeSkinType();
        this.djG.attachView(getView(), true);
        this.eKB.baW().baZ();
    }

    public Activity getActivity() {
        return this.eKB.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.auj()) {
            case 4097:
                this.eKF = false;
                break;
            case 4098:
                this.eKF = true;
                break;
            case 4099:
                a(bVar.auk());
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
            this.eKD.cI(((Long) extra).longValue());
            if (this.eKD.getCount() <= 5) {
                bbd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.djG != null) {
            this.djG.dettachView(getView());
        }
        if (errorData != null && this.eKD.auO() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.eKC.completePullRefreshPostDelayed(0L);
        if (this.eKE != null) {
            this.eKE.kO(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cZw != null) {
            this.cZw.onChangeSkinType(tbPageContext, i);
        }
        if (this.eKD != null) {
            this.eKD.b(tbPageContext, i);
        }
        if (this.eKE != null) {
            this.eKE.b(tbPageContext, i);
        }
        if (this.dCk != null) {
            this.dCk.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.auM()) {
                this.eKE.qk();
                if (aVar.auK()) {
                    this.eKE.kN(R.string.loading);
                } else if (!aVar.auL()) {
                    this.eKE.kO(R.string.no_more_msg);
                }
            } else {
                this.eKE.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.eKC.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bbf = ((com.baidu.tieba.chosen.posts.request.b) aVar).bbf();
            if (bbf != null && bbf.size() > 0) {
                this.eKC.setVisibility(0);
            }
            if (this.djG != null) {
                this.djG.dettachView(getView());
            }
            if (this.eKF) {
                this.eKD.ak(bbf);
                return;
            }
            this.eKD.al(bbf);
            if (bbf != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bbf.size())}), 0);
                b.hG(48);
                b.setOffsetY(this.paddingTop);
                b.hE(this.bNE);
                b.agO().agQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbd() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.eKB.getUniqueId());
        this.eKB.auS().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.eKC;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eKG == null) {
            this.eKG = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eKG.qN(str);
        this.eKG.attachView(view, z);
        this.eKG.atI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eKG != null) {
            this.eKG.dettachView(view);
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
            b.this.djG.attachView(b.this.getView(), true);
            b.this.bbd();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
