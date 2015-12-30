package com.baidu.tieba.chosen.posts;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.n;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f<ChosenPostActivity> {
    private com.baidu.tbadk.f.f NG;
    int Yx;
    private NavigationBar aKK;
    private ChosenPostActivity aRb;
    private BdListView aRc;
    private com.baidu.tieba.chosen.posts.a aRd;
    private com.baidu.tbadk.mvc.h.a aRe;
    private boolean aRf;
    private NoNetworkView aRg;
    private com.baidu.tbadk.f.h aRh;
    private t mPullView;
    private View mRootView;
    int paddingTop;

    protected t IS() {
        if (this.mPullView == null) {
            this.mPullView = new t(this.aRb.getPageContext());
        }
        return this.mPullView;
    }

    public e(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aRf = false;
        this.aRb = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oE() {
        this.mRootView = this.aRb.getLayoutInflater().inflate(n.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ov() {
        this.paddingTop = this.aRb.getResources().getDimensionPixelSize(n.e.ds108);
        this.Yx = this.aRb.getResources().getDimensionPixelSize(n.e.ds150);
        this.aKK = (NavigationBar) getView().findViewById(n.g.chosen_post_navigation_bar);
        this.aKK.setTitleText(n.j.chosen_post_title);
        this.aKK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aRc = (BdListView) getView().findViewById(n.g.chosen_post_list);
        this.aRg = (NoNetworkView) getView().findViewById(n.g.view_no_network);
        this.aRd = new com.baidu.tieba.chosen.posts.a(this.aRb.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{n.h.chosen_picture_layout, n.h.chosen_no_picture_layout, n.h.chosen_image_text_layout}, this.aRb.ok());
        this.aRc.setAdapter((ListAdapter) this.aRd);
        this.mPullView = IS();
        this.aRc.setPullRefresh(this.mPullView);
        this.mPullView.a(new f(this));
        this.aRc.setOnItemClickListener(new g(this));
        this.aRc.setOnItemLongClickListener(new h(this));
        this.aRc.setExOnSrollToBottomListener(new k(this));
        this.aRe = new com.baidu.tbadk.mvc.h.a(this.aRb);
        this.aRe.mT();
        getListView().setNextPage(this.aRe);
        this.NG = new com.baidu.tbadk.f.f(getActivity());
        this.NG.tr();
        this.NG.b(getView(), true);
        this.aRb.IN().ow();
    }

    public Activity getActivity() {
        return this.aRb.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Dj()) {
            case 4097:
                this.aRf = false;
                break;
            case 4098:
                this.aRf = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.Dk());
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
            this.aRd.ao(((Long) extra).longValue());
            if (this.aRd.getCount() <= 5) {
                IT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.NG != null) {
            this.NG.u(getView());
        }
        if (errorData != null && this.aRd.DT() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(n.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.aRc.completePullRefresh();
        if (this.aRe != null) {
            this.aRe.eA(n.j.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.aKK != null) {
            this.aKK.onChangeSkinType(tbPageContext, i);
        }
        if (this.aRd != null) {
            this.aRd.a(tbPageContext, i);
        }
        if (this.aRe != null) {
            this.aRe.a(tbPageContext, i);
        }
        if (this.aRg != null) {
            this.aRg.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.DJ()) {
                this.aRe.ob();
                if (aVar.DH()) {
                    this.aRe.ez(n.j.loading);
                } else if (!aVar.DI()) {
                    this.aRe.eA(n.j.no_more_msg);
                }
            } else {
                this.aRe.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.aRc.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> IV = ((com.baidu.tieba.chosen.posts.request.d) aVar).IV();
            if (IV != null && IV.size() > 0) {
                this.aRc.setVisibility(0);
            }
            if (this.NG != null) {
                this.NG.u(getView());
            }
            if (this.aRf) {
                this.aRd.r(IV);
                return;
            }
            this.aRd.s(IV);
            if (IV != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(n.j.chosen_post_recommend, new Object[]{Integer.valueOf(IV.size())}), 0);
                a2.bS(48);
                a2.bU(this.paddingTop);
                a2.bQ(this.Yx);
                a2.tm().to();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.aRb.getUniqueId());
        this.aRb.ok().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.aRc;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aRh == null) {
            this.aRh = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new a(this, null));
        }
        this.aRh.fP(str);
        this.aRh.b(view, z);
        this.aRh.Dc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aRh != null) {
            this.aRh.u(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(e eVar, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.hideNetRefreshView(e.this.getView());
            e.this.NG.b(e.this.getView(), true);
            e.this.IT();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
