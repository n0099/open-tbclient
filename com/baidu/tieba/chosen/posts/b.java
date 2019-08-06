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
    int bNJ;
    private NavigationBar cZD;
    private NoNetworkView dCr;
    private g djN;
    private ChosenPostActivity eKI;
    private BdListView eKJ;
    private com.baidu.tieba.chosen.posts.a eKK;
    private com.baidu.tbadk.mvc.g.a eKL;
    private boolean eKM;
    private h eKN;
    private i mPullView;
    private View mRootView;
    int paddingTop;

    protected i bbd() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.eKI.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eKM = false;
        this.eKI = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aLp() {
        this.mRootView = this.eKI.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbe() {
        this.paddingTop = this.eKI.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.bNJ = this.eKI.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.cZD = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.cZD.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.cZD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eKJ = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.dCr = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.eKK = new com.baidu.tieba.chosen.posts.a(this.eKI.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.eKI.auU());
        this.eKJ.setAdapter((ListAdapter) this.eKK);
        this.mPullView = bbd();
        this.eKJ.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                b.this.eKI.baY().iP(z);
            }
        });
        this.eKJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.eKK.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.eKJ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.eKK.getItem(i));
                        bVar.setUniqueId(b.this.eKI.getUniqueId());
                        b.this.eKI.auU().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.eKI.getPageContext());
                aVar.agK();
                return true;
            }
        });
        this.eKJ.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.kt()) {
                    b.this.eKI.baY().bbc();
                } else if (b.this.eKL != null) {
                    b.this.eKL.qk();
                    b.this.eKL.kP(R.string.no_more_msg);
                }
            }
        });
        this.eKL = new com.baidu.tbadk.mvc.g.a(this.eKI);
        this.eKL.nZ();
        getListView().setNextPage(this.eKL);
        this.djN = new g(getActivity());
        this.djN.onChangeSkinType();
        this.djN.attachView(getView(), true);
        this.eKI.baY().bbb();
    }

    public Activity getActivity() {
        return this.eKI.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aul()) {
            case 4097:
                this.eKM = false;
                break;
            case 4098:
                this.eKM = true;
                break;
            case 4099:
                a(bVar.aum());
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
            this.eKK.cI(((Long) extra).longValue());
            if (this.eKK.getCount() <= 5) {
                bbf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.djN != null) {
            this.djN.dettachView(getView());
        }
        if (errorData != null && this.eKK.auQ() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.eKJ.completePullRefreshPostDelayed(0L);
        if (this.eKL != null) {
            this.eKL.kP(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cZD != null) {
            this.cZD.onChangeSkinType(tbPageContext, i);
        }
        if (this.eKK != null) {
            this.eKK.b(tbPageContext, i);
        }
        if (this.eKL != null) {
            this.eKL.b(tbPageContext, i);
        }
        if (this.dCr != null) {
            this.dCr.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.auO()) {
                this.eKL.qk();
                if (aVar.auM()) {
                    this.eKL.kO(R.string.loading);
                } else if (!aVar.auN()) {
                    this.eKL.kP(R.string.no_more_msg);
                }
            } else {
                this.eKL.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.eKJ.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bbh = ((com.baidu.tieba.chosen.posts.request.b) aVar).bbh();
            if (bbh != null && bbh.size() > 0) {
                this.eKJ.setVisibility(0);
            }
            if (this.djN != null) {
                this.djN.dettachView(getView());
            }
            if (this.eKM) {
                this.eKK.ak(bbh);
                return;
            }
            this.eKK.al(bbh);
            if (bbh != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bbh.size())}), 0);
                b.hG(48);
                b.setOffsetY(this.paddingTop);
                b.hE(this.bNJ);
                b.agQ().agS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbf() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.eKI.getUniqueId());
        this.eKI.auU().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.eKJ;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eKN == null) {
            this.eKN = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eKN.qN(str);
        this.eKN.attachView(view, z);
        this.eKN.atK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eKN != null) {
            this.eKN.dettachView(view);
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
            b.this.djN.attachView(b.this.getView(), true);
            b.this.bbf();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
