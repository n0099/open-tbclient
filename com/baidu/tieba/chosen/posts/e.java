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
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.i;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f<ChosenPostActivity> {
    private com.baidu.tbadk.e.f MY;
    int Xe;
    private NavigationBar aHt;
    private ChosenPostActivity aJN;
    private BdListView aJO;
    private com.baidu.tieba.chosen.posts.a aJP;
    private com.baidu.tbadk.mvc.h.a aJQ;
    private boolean aJR;
    private NoNetworkView aJS;
    private com.baidu.tbadk.e.h aJT;
    private r mPullView;
    private View mRootView;
    int paddingTop;

    protected r Hk() {
        if (this.mPullView == null) {
            this.mPullView = new r(this.aJN.getPageContext());
        }
        return this.mPullView;
    }

    public e(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aJR = false;
        this.aJN = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oZ() {
        this.mRootView = this.aJN.getLayoutInflater().inflate(i.g.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.paddingTop = this.aJN.getResources().getDimensionPixelSize(i.d.ds108);
        this.Xe = this.aJN.getResources().getDimensionPixelSize(i.d.ds150);
        this.aHt = (NavigationBar) getView().findViewById(i.f.chosen_post_navigation_bar);
        this.aHt.setTitleText(i.h.chosen_post_title);
        this.aHt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aJO = (BdListView) getView().findViewById(i.f.chosen_post_list);
        this.aJS = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.aJP = new com.baidu.tieba.chosen.posts.a(this.aJN.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{i.g.chosen_picture_layout, i.g.chosen_no_picture_layout, i.g.chosen_image_text_layout}, this.aJN.oF());
        this.aJO.setAdapter((ListAdapter) this.aJP);
        this.mPullView = Hk();
        this.aJO.setPullRefresh(this.mPullView);
        this.mPullView.a(new f(this));
        this.aJO.setOnItemClickListener(new g(this));
        this.aJO.setOnItemLongClickListener(new h(this));
        this.aJO.setExOnSrollToBottomListener(new k(this));
        this.aJQ = new com.baidu.tbadk.mvc.h.a(this.aJN);
        this.aJQ.no();
        getListView().setNextPage(this.aJQ);
        this.MY = new com.baidu.tbadk.e.f(getActivity());
        this.MY.sZ();
        this.MY.b(getView(), true);
        this.aJN.Hf().oR();
    }

    public Activity getActivity() {
        return this.aJN.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.CA()) {
            case 4097:
                this.aJR = false;
                break;
            case 4098:
                this.aJR = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.CB());
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
            this.aJP.af(((Long) extra).longValue());
            if (this.aJP.getCount() <= 5) {
                Hl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.MY != null) {
            this.MY.u(getView());
        }
        if (errorData != null && this.aJP.Dk() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(i.h.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.aJO.completePullRefresh();
        if (this.aJQ != null) {
            this.aJQ.eu(i.h.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.aHt != null) {
            this.aHt.onChangeSkinType(tbPageContext, i);
        }
        if (this.aJP != null) {
            this.aJP.a(tbPageContext, i);
        }
        if (this.aJQ != null) {
            this.aJQ.a(tbPageContext, i);
        }
        if (this.aJS != null) {
            this.aJS.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Da()) {
                this.aJQ.ow();
                if (aVar.CY()) {
                    this.aJQ.et(i.h.loading);
                } else if (!aVar.CZ()) {
                    this.aJQ.eu(i.h.no_more_msg);
                }
            } else {
                this.aJQ.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.aJO.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> Ho = ((com.baidu.tieba.chosen.posts.request.d) aVar).Ho();
            if (Ho != null && Ho.size() > 0) {
                this.aJO.setVisibility(0);
            }
            if (this.MY != null) {
                this.MY.u(getView());
            }
            if (this.aJR) {
                this.aJP.q(Ho);
                return;
            }
            this.aJP.r(Ho);
            if (Ho != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(i.h.chosen_post_recommend, new Object[]{Integer.valueOf(Ho.size())}), 0);
                a2.bR(48);
                a2.bT(this.paddingTop);
                a2.bP(this.Xe);
                a2.sU().sW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.aJN.getUniqueId());
        this.aJN.oF().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.aJO;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aJT == null) {
            this.aJT = new com.baidu.tbadk.e.h(getPageContext().getPageActivity(), new a(this, null));
        }
        this.aJT.fv(str);
        this.aJT.b(view, z);
        this.aJT.Ct();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aJT != null) {
            this.aJT.u(view);
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
            e.this.MY.b(e.this.getView(), true);
            e.this.Hl();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
