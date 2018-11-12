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
    private NavigationBar bAs;
    private f bGG;
    private NoNetworkView bUB;
    private ChosenPostActivity cWa;
    private BdListView cWb;
    private com.baidu.tieba.chosen.posts.a cWc;
    private com.baidu.tbadk.mvc.g.a cWd;
    private boolean cWe;
    private g cWf;
    private k mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected k apb() {
        if (this.mPullView == null) {
            this.mPullView = new k(this.cWa.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cWe = false;
        this.cWa = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aaV() {
        this.mRootView = this.cWa.getLayoutInflater().inflate(e.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void apc() {
        this.paddingTop = this.cWa.getResources().getDimensionPixelSize(e.C0200e.ds108);
        this.paddingHorizontal = this.cWa.getResources().getDimensionPixelSize(e.C0200e.ds150);
        this.bAs = (NavigationBar) getView().findViewById(e.g.chosen_post_navigation_bar);
        this.bAs.setTitleText(e.j.recommend_frs_hot_thread_title);
        this.bAs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cWb = (BdListView) getView().findViewById(e.g.chosen_post_list);
        this.bUB = (NoNetworkView) getView().findViewById(e.g.view_no_network);
        this.cWc = new com.baidu.tieba.chosen.posts.a(this.cWa.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{e.h.chosen_picture_layout, e.h.chosen_no_picture_layout, e.h.chosen_image_text_layout}, this.cWa.NH());
        this.cWb.setAdapter((ListAdapter) this.cWc);
        this.mPullView = apb();
        this.cWb.setPullRefresh(this.mPullView);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                b.this.cWa.aoW().fD(z);
            }
        });
        this.cWb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.cWc.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cWb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.ej(b.this.getActivity().getString(e.j.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.cWc.getItem(i));
                        bVar.setUniqueId(b.this.cWa.getUniqueId());
                        b.this.cWa.NH().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cWa.getPageContext());
                aVar.AB();
                return true;
            }
        });
        this.cWb.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.lm()) {
                    b.this.cWa.aoW().apa();
                } else if (b.this.cWd != null) {
                    b.this.cWd.pO();
                    b.this.cWd.fS(e.j.no_more_msg);
                }
            }
        });
        this.cWd = new com.baidu.tbadk.mvc.g.a(this.cWa);
        this.cWd.oE();
        getListView().setNextPage(this.cWd);
        this.bGG = new f(getActivity());
        this.bGG.onChangeSkinType();
        this.bGG.attachView(getView(), true);
        this.cWa.aoW().aoZ();
    }

    public Activity getActivity() {
        return this.cWa.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.MZ()) {
            case 4097:
                this.cWe = false;
                break;
            case 4098:
                this.cWe = true;
                break;
            case 4099:
                a(bVar.Na());
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
            this.cWc.bu(((Long) extra).longValue());
            if (this.cWc.getCount() <= 5) {
                apd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bGG != null) {
            this.bGG.dettachView(getView());
        }
        if (errorData != null && this.cWc.ND() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(e.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cWb.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        if (this.cWd != null) {
            this.cWd.fS(e.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bAs != null) {
            this.bAs.onChangeSkinType(tbPageContext, i);
        }
        if (this.cWc != null) {
            this.cWc.b(tbPageContext, i);
        }
        if (this.cWd != null) {
            this.cWd.b(tbPageContext, i);
        }
        if (this.bUB != null) {
            this.bUB.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.NB()) {
                this.cWd.pO();
                if (aVar.Nz()) {
                    this.cWd.fR(e.j.loading);
                } else if (!aVar.NA()) {
                    this.cWd.fS(e.j.no_more_msg);
                }
            } else {
                this.cWd.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cWb.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> apf = ((com.baidu.tieba.chosen.posts.request.b) aVar).apf();
            if (apf != null && apf.size() > 0) {
                this.cWb.setVisibility(0);
            }
            if (this.bGG != null) {
                this.bGG.dettachView(getView());
            }
            if (this.cWe) {
                this.cWc.Q(apf);
                return;
            }
            this.cWc.R(apf);
            if (apf != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(e.j.chosen_post_recommend, new Object[]{Integer.valueOf(apf.size())}), 0);
                a2.cZ(48);
                a2.setOffsetY(this.paddingTop);
                a2.cX(this.paddingHorizontal);
                a2.AH().AJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apd() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.cWa.getUniqueId());
        this.cWa.NH().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cWb;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.cWf == null) {
            this.cWf = new g(getPageContext().getPageActivity(), new a());
        }
        this.cWf.hV(str);
        this.cWf.attachView(view, z);
        this.cWf.MH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.cWf != null) {
            this.cWf.dettachView(view);
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
            b.this.bGG.attachView(b.this.getView(), true);
            b.this.apd();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
