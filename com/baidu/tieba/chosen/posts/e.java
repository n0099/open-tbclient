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
import com.baidu.tieba.t;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f<ChosenPostActivity> {
    private com.baidu.tbadk.f.f Oj;
    int YN;
    private NavigationBar aLP;
    private ChosenPostActivity aTi;
    private BdListView aTj;
    private com.baidu.tieba.chosen.posts.a aTk;
    private com.baidu.tbadk.mvc.h.a aTl;
    private boolean aTm;
    private NoNetworkView aTn;
    private com.baidu.tbadk.f.h aTo;
    private t mPullView;
    private View mRootView;
    int paddingTop;

    protected t KK() {
        if (this.mPullView == null) {
            this.mPullView = new t(this.aTi.getPageContext());
        }
        return this.mPullView;
    }

    public e(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aTm = false;
        this.aTi = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View pa() {
        this.mRootView = this.aTi.getLayoutInflater().inflate(t.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.paddingTop = this.aTi.getResources().getDimensionPixelSize(t.e.ds108);
        this.YN = this.aTi.getResources().getDimensionPixelSize(t.e.ds150);
        this.aLP = (NavigationBar) getView().findViewById(t.g.chosen_post_navigation_bar);
        this.aLP.setTitleText(t.j.chosen_post_title);
        this.aLP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aTj = (BdListView) getView().findViewById(t.g.chosen_post_list);
        this.aTn = (NoNetworkView) getView().findViewById(t.g.view_no_network);
        this.aTk = new com.baidu.tieba.chosen.posts.a(this.aTi.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{t.h.chosen_picture_layout, t.h.chosen_no_picture_layout, t.h.chosen_image_text_layout}, this.aTi.oF());
        this.aTj.setAdapter((ListAdapter) this.aTk);
        this.mPullView = KK();
        this.aTj.setPullRefresh(this.mPullView);
        this.mPullView.a(new f(this));
        this.aTj.setOnItemClickListener(new g(this));
        this.aTj.setOnItemLongClickListener(new h(this));
        this.aTj.setExOnSrollToBottomListener(new k(this));
        this.aTl = new com.baidu.tbadk.mvc.h.a(this.aTi);
        this.aTl.ni();
        KM().setNextPage(this.aTl);
        this.Oj = new com.baidu.tbadk.f.f(getActivity());
        this.Oj.uv();
        this.Oj.c(getView(), true);
        this.aTi.KF().oR();
    }

    public Activity getActivity() {
        return this.aTi.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.EE()) {
            case 4097:
                this.aTm = false;
                break;
            case 4098:
                this.aTm = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.EF());
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
            this.aTk.ar(((Long) extra).longValue());
            if (this.aTk.getCount() <= 5) {
                KL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.Oj != null) {
            this.Oj.H(getView());
        }
        if (errorData != null && this.aTk.Fn() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(t.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.aTj.nr();
        if (this.aTl != null) {
            this.aTl.eU(t.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.aLP != null) {
            this.aLP.onChangeSkinType(tbPageContext, i);
        }
        if (this.aTk != null) {
            this.aTk.a(tbPageContext, i);
        }
        if (this.aTl != null) {
            this.aTl.a(tbPageContext, i);
        }
        if (this.aTn != null) {
            this.aTn.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Fd()) {
                this.aTl.ow();
                if (aVar.Fb()) {
                    this.aTl.eT(t.j.loading);
                } else if (!aVar.Fc()) {
                    this.aTl.eU(t.j.no_more_msg);
                }
            } else {
                this.aTl.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.aTj.nr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> KO = ((com.baidu.tieba.chosen.posts.request.d) aVar).KO();
            if (KO != null && KO.size() > 0) {
                this.aTj.setVisibility(0);
            }
            if (this.Oj != null) {
                this.Oj.H(getView());
            }
            if (this.aTm) {
                this.aTk.v(KO);
                return;
            }
            this.aTk.w(KO);
            if (KO != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(t.j.chosen_post_recommend, new Object[]{Integer.valueOf(KO.size())}), 0);
                a2.cl(48);
                a2.cn(this.paddingTop);
                a2.cj(this.YN);
                a2.uq().us();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KL() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.aTi.getUniqueId());
        this.aTi.oF().dispatchMvcEvent(bVar);
    }

    public BdListView KM() {
        return this.aTj;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aTo == null) {
            this.aTo = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new a(this, null));
        }
        this.aTo.fN(str);
        this.aTo.c(view, z);
        this.aTo.Eu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aTo != null) {
            this.aTo.H(view);
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
            e.this.Oj.c(e.this.getView(), true);
            e.this.KL();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
