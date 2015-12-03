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
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.n;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.base.f<ChosenPostActivity> {
    private com.baidu.tbadk.f.f Nq;
    int XU;
    private NavigationBar aJm;
    private ChosenPostActivity aNi;
    private BdListView aNj;
    private com.baidu.tieba.chosen.posts.a aNk;
    private com.baidu.tbadk.mvc.h.a aNl;
    private boolean aNm;
    private NoNetworkView aNn;
    private com.baidu.tbadk.f.h aNo;
    private s mPullView;
    private View mRootView;
    int paddingTop;

    protected s IA() {
        if (this.mPullView == null) {
            this.mPullView = new s(this.aNi.getPageContext());
        }
        return this.mPullView;
    }

    public e(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aNm = false;
        this.aNi = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View pg() {
        this.mRootView = this.aNi.getLayoutInflater().inflate(n.g.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oX() {
        this.paddingTop = this.aNi.getResources().getDimensionPixelSize(n.d.ds108);
        this.XU = this.aNi.getResources().getDimensionPixelSize(n.d.ds150);
        this.aJm = (NavigationBar) getView().findViewById(n.f.chosen_post_navigation_bar);
        this.aJm.setTitleText(n.i.chosen_post_title);
        this.aJm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aNj = (BdListView) getView().findViewById(n.f.chosen_post_list);
        this.aNn = (NoNetworkView) getView().findViewById(n.f.view_no_network);
        this.aNk = new com.baidu.tieba.chosen.posts.a(this.aNi.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{n.g.chosen_picture_layout, n.g.chosen_no_picture_layout, n.g.chosen_image_text_layout}, this.aNi.oM());
        this.aNj.setAdapter((ListAdapter) this.aNk);
        this.mPullView = IA();
        this.aNj.setPullRefresh(this.mPullView);
        this.mPullView.a(new f(this));
        this.aNj.setOnItemClickListener(new g(this));
        this.aNj.setOnItemLongClickListener(new h(this));
        this.aNj.setExOnSrollToBottomListener(new k(this));
        this.aNl = new com.baidu.tbadk.mvc.h.a(this.aNi);
        this.aNl.nv();
        getListView().setNextPage(this.aNl);
        this.Nq = new com.baidu.tbadk.f.f(getActivity());
        this.Nq.tH();
        this.Nq.b(getView(), true);
        this.aNi.Iv().oY();
    }

    public Activity getActivity() {
        return this.aNi.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Du()) {
            case 4097:
                this.aNm = false;
                break;
            case 4098:
                this.aNm = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.Dv());
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
            this.aNk.an(((Long) extra).longValue());
            if (this.aNk.getCount() <= 5) {
                IB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.Nq != null) {
            this.Nq.v(getView());
        }
        if (errorData != null && this.aNk.Ee() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(n.i.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.aNj.completePullRefresh();
        if (this.aNl != null) {
            this.aNl.eG(n.i.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.aJm != null) {
            this.aJm.onChangeSkinType(tbPageContext, i);
        }
        if (this.aNk != null) {
            this.aNk.a(tbPageContext, i);
        }
        if (this.aNl != null) {
            this.aNl.a(tbPageContext, i);
        }
        if (this.aNn != null) {
            this.aNn.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.DU()) {
                this.aNl.oD();
                if (aVar.DS()) {
                    this.aNl.eF(n.i.loading);
                } else if (!aVar.DT()) {
                    this.aNl.eG(n.i.no_more_msg);
                }
            } else {
                this.aNl.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.aNj.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> IE = ((com.baidu.tieba.chosen.posts.request.d) aVar).IE();
            if (IE != null && IE.size() > 0) {
                this.aNj.setVisibility(0);
            }
            if (this.Nq != null) {
                this.Nq.v(getView());
            }
            if (this.aNm) {
                this.aNk.q(IE);
                return;
            }
            this.aNk.r(IE);
            if (IE != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(n.i.chosen_post_recommend, new Object[]{Integer.valueOf(IE.size())}), 0);
                a2.bZ(48);
                a2.cb(this.paddingTop);
                a2.bX(this.XU);
                a2.tC().tE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IB() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.aNi.getUniqueId());
        this.aNi.oM().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.aNj;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aNo == null) {
            this.aNo = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new a(this, null));
        }
        this.aNo.fL(str);
        this.aNo.b(view, z);
        this.aNo.Dn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aNo != null) {
            this.aNo.v(view);
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
            e.this.Nq.b(e.this.getView(), true);
            e.this.IB();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
