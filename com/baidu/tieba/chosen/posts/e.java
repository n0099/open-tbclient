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
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.i;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f<ChosenPostActivity> {
    private com.baidu.tbadk.c.f Na;
    int Xb;
    private NavigationBar aIc;
    private boolean aKA;
    private NoNetworkView aKB;
    private com.baidu.tbadk.c.h aKC;
    private ChosenPostActivity aKw;
    private BdListView aKx;
    private com.baidu.tieba.chosen.posts.a aKy;
    private com.baidu.tbadk.mvc.h.a aKz;
    private z mPullView;
    private View mRootView;
    int paddingTop;

    protected z HG() {
        if (this.mPullView == null) {
            this.mPullView = new z(this.aKw.getPageContext());
        }
        return this.mPullView;
    }

    public e(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aKA = false;
        this.aKw = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View pb() {
        this.mRootView = this.aKw.getLayoutInflater().inflate(i.g.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oS() {
        this.paddingTop = this.aKw.getResources().getDimensionPixelSize(i.d.ds108);
        this.Xb = this.aKw.getResources().getDimensionPixelSize(i.d.ds150);
        this.aIc = (NavigationBar) getView().findViewById(i.f.chosen_post_navigation_bar);
        this.aIc.setTitleText(i.C0057i.chosen_post_title);
        this.aIc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aKx = (BdListView) getView().findViewById(i.f.chosen_post_list);
        this.aKB = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.aKy = new com.baidu.tieba.chosen.posts.a(this.aKw.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{i.g.chosen_picture_layout, i.g.chosen_no_picture_layout, i.g.chosen_image_text_layout}, this.aKw.oH());
        this.aKx.setAdapter((ListAdapter) this.aKy);
        this.mPullView = HG();
        this.aKx.setPullRefresh(this.mPullView);
        this.mPullView.a(new f(this));
        this.aKx.setOnItemClickListener(new g(this));
        this.aKx.setOnItemLongClickListener(new h(this));
        this.aKx.setExOnSrollToBottomListener(new k(this));
        this.aKz = new com.baidu.tbadk.mvc.h.a(this.aKw);
        this.aKz.nq();
        getListView().setNextPage(this.aKz);
        this.Na = new com.baidu.tbadk.c.f(getActivity());
        this.Na.ta();
        this.Na.b(getView(), true);
        this.aKw.HB().oT();
    }

    public Activity getActivity() {
        return this.aKw.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.CG()) {
            case 4097:
                this.aKA = false;
                break;
            case 4098:
                this.aKA = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.CH());
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
            this.aKy.N(((Long) extra).longValue());
            if (this.aKy.getCount() <= 5) {
                HH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.Na != null) {
            this.Na.u(getView());
        }
        if (errorData != null && this.aKy.Dq() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(i.C0057i.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.aKx.completePullRefresh();
        if (this.aKz != null) {
            this.aKz.el(i.C0057i.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.aIc != null) {
            this.aIc.onChangeSkinType(tbPageContext, i);
        }
        if (this.aKy != null) {
            this.aKy.a(tbPageContext, i);
        }
        if (this.aKz != null) {
            this.aKz.a(tbPageContext, i);
        }
        if (this.aKB != null) {
            this.aKB.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cG(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Dg()) {
                this.aKz.oy();
                if (aVar.De()) {
                    this.aKz.ek(i.C0057i.loading);
                } else if (!aVar.Df()) {
                    this.aKz.el(i.C0057i.no_more_msg);
                }
            } else {
                this.aKz.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.aKx.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> HK = ((com.baidu.tieba.chosen.posts.request.d) aVar).HK();
            if (HK != null && HK.size() > 0) {
                this.aKx.setVisibility(0);
            }
            if (this.Na != null) {
                this.Na.u(getView());
            }
            if (this.aKA) {
                this.aKy.q(HK);
                return;
            }
            this.aKy.r(HK);
            if (HK != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(i.C0057i.chosen_post_recommend, new Object[]{Integer.valueOf(HK.size())}), 0);
                a2.bO(48);
                a2.bQ(this.paddingTop);
                a2.bM(this.Xb);
                a2.sV().sX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.aKw.getUniqueId());
        this.aKw.oH().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.aKx;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aKC == null) {
            this.aKC = new com.baidu.tbadk.c.h(getPageContext().getPageActivity(), new a(this, null));
        }
        this.aKC.fi(str);
        this.aKC.b(view, z);
        this.aKC.Cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aKC != null) {
            this.aKC.u(view);
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
            e.this.Na.b(e.this.getView(), true);
            e.this.HH();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
