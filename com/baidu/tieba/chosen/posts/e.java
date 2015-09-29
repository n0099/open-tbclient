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
    private com.baidu.tbadk.e.f MX;
    int Xc;
    private NavigationBar aHi;
    private ChosenPostActivity aJC;
    private BdListView aJD;
    private com.baidu.tieba.chosen.posts.a aJE;
    private com.baidu.tbadk.mvc.h.a aJF;
    private boolean aJG;
    private NoNetworkView aJH;
    private com.baidu.tbadk.e.h aJI;
    private r mPullView;
    private View mRootView;
    int paddingTop;

    protected r Ho() {
        if (this.mPullView == null) {
            this.mPullView = new r(this.aJC.getPageContext());
        }
        return this.mPullView;
    }

    public e(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aJG = false;
        this.aJC = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oZ() {
        this.mRootView = this.aJC.getLayoutInflater().inflate(i.g.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.paddingTop = this.aJC.getResources().getDimensionPixelSize(i.d.ds108);
        this.Xc = this.aJC.getResources().getDimensionPixelSize(i.d.ds150);
        this.aHi = (NavigationBar) getView().findViewById(i.f.chosen_post_navigation_bar);
        this.aHi.setTitleText(i.h.chosen_post_title);
        this.aHi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aJD = (BdListView) getView().findViewById(i.f.chosen_post_list);
        this.aJH = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.aJE = new com.baidu.tieba.chosen.posts.a(this.aJC.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{i.g.chosen_picture_layout, i.g.chosen_no_picture_layout, i.g.chosen_image_text_layout}, this.aJC.oF());
        this.aJD.setAdapter((ListAdapter) this.aJE);
        this.mPullView = Ho();
        this.aJD.setPullRefresh(this.mPullView);
        this.mPullView.a(new f(this));
        this.aJD.setOnItemClickListener(new g(this));
        this.aJD.setOnItemLongClickListener(new h(this));
        this.aJD.setExOnSrollToBottomListener(new k(this));
        this.aJF = new com.baidu.tbadk.mvc.h.a(this.aJC);
        this.aJF.no();
        getListView().setNextPage(this.aJF);
        this.MX = new com.baidu.tbadk.e.f(getActivity());
        this.MX.tc();
        this.MX.b(getView(), true);
        this.aJC.Hj().oR();
    }

    public Activity getActivity() {
        return this.aJC.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.CD()) {
            case 4097:
                this.aJG = false;
                break;
            case 4098:
                this.aJG = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.CE());
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
            this.aJE.X(((Long) extra).longValue());
            if (this.aJE.getCount() <= 5) {
                Hp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.MX != null) {
            this.MX.u(getView());
        }
        if (errorData != null && this.aJE.Dn() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(i.h.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.aJD.completePullRefresh();
        if (this.aJF != null) {
            this.aJF.eu(i.h.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.aHi != null) {
            this.aHi.onChangeSkinType(tbPageContext, i);
        }
        if (this.aJE != null) {
            this.aJE.a(tbPageContext, i);
        }
        if (this.aJF != null) {
            this.aJF.a(tbPageContext, i);
        }
        if (this.aJH != null) {
            this.aJH.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Dd()) {
                this.aJF.ow();
                if (aVar.Db()) {
                    this.aJF.et(i.h.loading);
                } else if (!aVar.Dc()) {
                    this.aJF.eu(i.h.no_more_msg);
                }
            } else {
                this.aJF.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.aJD.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> Hs = ((com.baidu.tieba.chosen.posts.request.d) aVar).Hs();
            if (Hs != null && Hs.size() > 0) {
                this.aJD.setVisibility(0);
            }
            if (this.MX != null) {
                this.MX.u(getView());
            }
            if (this.aJG) {
                this.aJE.q(Hs);
                return;
            }
            this.aJE.r(Hs);
            if (Hs != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(i.h.chosen_post_recommend, new Object[]{Integer.valueOf(Hs.size())}), 0);
                a2.bR(48);
                a2.bT(this.paddingTop);
                a2.bP(this.Xc);
                a2.sX().sZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.aJC.getUniqueId());
        this.aJC.oF().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.aJD;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aJI == null) {
            this.aJI = new com.baidu.tbadk.e.h(getPageContext().getPageActivity(), new a(this, null));
        }
        this.aJI.fv(str);
        this.aJI.b(view, z);
        this.aJI.Cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aJI != null) {
            this.aJI.u(view);
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
            e.this.MX.b(e.this.getView(), true);
            e.this.Hp();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
