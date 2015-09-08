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
    private com.baidu.tbadk.e.f MY;
    int Xk;
    private NavigationBar aIp;
    private ChosenPostActivity aKJ;
    private BdListView aKK;
    private com.baidu.tieba.chosen.posts.a aKL;
    private com.baidu.tbadk.mvc.h.a aKM;
    private boolean aKN;
    private NoNetworkView aKO;
    private com.baidu.tbadk.e.h aKP;
    private z mPullView;
    private View mRootView;
    int paddingTop;

    protected z Hu() {
        if (this.mPullView == null) {
            this.mPullView = new z(this.aKJ.getPageContext());
        }
        return this.mPullView;
    }

    public e(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aKN = false;
        this.aKJ = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View oY() {
        this.mRootView = this.aKJ.getLayoutInflater().inflate(i.g.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oP() {
        this.paddingTop = this.aKJ.getResources().getDimensionPixelSize(i.d.ds108);
        this.Xk = this.aKJ.getResources().getDimensionPixelSize(i.d.ds150);
        this.aIp = (NavigationBar) getView().findViewById(i.f.chosen_post_navigation_bar);
        this.aIp.setTitleText(i.h.chosen_post_title);
        this.aIp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aKK = (BdListView) getView().findViewById(i.f.chosen_post_list);
        this.aKO = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.aKL = new com.baidu.tieba.chosen.posts.a(this.aKJ.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{i.g.chosen_picture_layout, i.g.chosen_no_picture_layout, i.g.chosen_image_text_layout}, this.aKJ.oE());
        this.aKK.setAdapter((ListAdapter) this.aKL);
        this.mPullView = Hu();
        this.aKK.setPullRefresh(this.mPullView);
        this.mPullView.a(new f(this));
        this.aKK.setOnItemClickListener(new g(this));
        this.aKK.setOnItemLongClickListener(new h(this));
        this.aKK.setExOnSrollToBottomListener(new k(this));
        this.aKM = new com.baidu.tbadk.mvc.h.a(this.aKJ);
        this.aKM.nn();
        getListView().setNextPage(this.aKM);
        this.MY = new com.baidu.tbadk.e.f(getActivity());
        this.MY.tf();
        this.MY.b(getView(), true);
        this.aKJ.Hp().oQ();
    }

    public Activity getActivity() {
        return this.aKJ.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.CQ()) {
            case 4097:
                this.aKN = false;
                break;
            case 4098:
                this.aKN = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.CR());
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
            this.aKL.O(((Long) extra).longValue());
            if (this.aKL.getCount() <= 5) {
                Hv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.MY != null) {
            this.MY.u(getView());
        }
        if (errorData != null && this.aKL.DA() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(i.h.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.aKK.completePullRefresh();
        if (this.aKM != null) {
            this.aKM.et(i.h.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.aIp != null) {
            this.aIp.onChangeSkinType(tbPageContext, i);
        }
        if (this.aKL != null) {
            this.aKL.a(tbPageContext, i);
        }
        if (this.aKM != null) {
            this.aKM.a(tbPageContext, i);
        }
        if (this.aKO != null) {
            this.aKO.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Dq()) {
                this.aKM.ov();
                if (aVar.Do()) {
                    this.aKM.es(i.h.loading);
                } else if (!aVar.Dp()) {
                    this.aKM.et(i.h.no_more_msg);
                }
            } else {
                this.aKM.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.aKK.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> Hy = ((com.baidu.tieba.chosen.posts.request.d) aVar).Hy();
            if (Hy != null && Hy.size() > 0) {
                this.aKK.setVisibility(0);
            }
            if (this.MY != null) {
                this.MY.u(getView());
            }
            if (this.aKN) {
                this.aKL.r(Hy);
                return;
            }
            this.aKL.s(Hy);
            if (Hy != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(i.h.chosen_post_recommend, new Object[]{Integer.valueOf(Hy.size())}), 0);
                a2.bR(48);
                a2.bT(this.paddingTop);
                a2.bP(this.Xk);
                a2.ta().tc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.aKJ.getUniqueId());
        this.aKJ.oE().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.aKK;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aKP == null) {
            this.aKP = new com.baidu.tbadk.e.h(getPageContext().getPageActivity(), new a(this, null));
        }
        this.aKP.fq(str);
        this.aKP.b(view, z);
        this.aKP.CK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aKP != null) {
            this.aKP.u(view);
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
            e.this.Hv();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
