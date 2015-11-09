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
    private com.baidu.tbadk.e.f MZ;
    int Xh;
    private NavigationBar aGn;
    private ChosenPostActivity aIH;
    private BdListView aII;
    private com.baidu.tieba.chosen.posts.a aIJ;
    private com.baidu.tbadk.mvc.h.a aIK;
    private boolean aIL;
    private NoNetworkView aIM;
    private com.baidu.tbadk.e.h aIN;
    private r mPullView;
    private View mRootView;
    int paddingTop;

    protected r Hh() {
        if (this.mPullView == null) {
            this.mPullView = new r(this.aIH.getPageContext());
        }
        return this.mPullView;
    }

    public e(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.aIL = false;
        this.aIH = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View pa() {
        this.mRootView = this.aIH.getLayoutInflater().inflate(i.g.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oR() {
        this.paddingTop = this.aIH.getResources().getDimensionPixelSize(i.d.ds108);
        this.Xh = this.aIH.getResources().getDimensionPixelSize(i.d.ds150);
        this.aGn = (NavigationBar) getView().findViewById(i.f.chosen_post_navigation_bar);
        this.aGn.setTitleText(i.h.chosen_post_title);
        this.aGn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aII = (BdListView) getView().findViewById(i.f.chosen_post_list);
        this.aIM = (NoNetworkView) getView().findViewById(i.f.view_no_network);
        this.aIJ = new com.baidu.tieba.chosen.posts.a(this.aIH.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.e.class, com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{i.g.chosen_picture_layout, i.g.chosen_no_picture_layout, i.g.chosen_image_text_layout}, this.aIH.oG());
        this.aII.setAdapter((ListAdapter) this.aIJ);
        this.mPullView = Hh();
        this.aII.setPullRefresh(this.mPullView);
        this.mPullView.a(new f(this));
        this.aII.setOnItemClickListener(new g(this));
        this.aII.setOnItemLongClickListener(new h(this));
        this.aII.setExOnSrollToBottomListener(new k(this));
        this.aIK = new com.baidu.tbadk.mvc.h.a(this.aIH);
        this.aIK.np();
        getListView().setNextPage(this.aIK);
        this.MZ = new com.baidu.tbadk.e.f(getActivity());
        this.MZ.tc();
        this.MZ.b(getView(), true);
        this.aIH.Hc().oS();
    }

    public Activity getActivity() {
        return this.aIH.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Ct()) {
            case 4097:
                this.aIL = false;
                break;
            case 4098:
                this.aIL = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.Cu());
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
            this.aIJ.af(((Long) extra).longValue());
            if (this.aIJ.getCount() <= 5) {
                Hi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.MZ != null) {
            this.MZ.u(getView());
        }
        if (errorData != null && this.aIJ.Dd() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(i.h.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.aII.completePullRefresh();
        if (this.aIK != null) {
            this.aIK.es(i.h.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.aGn != null) {
            this.aGn.onChangeSkinType(tbPageContext, i);
        }
        if (this.aIJ != null) {
            this.aIJ.a(tbPageContext, i);
        }
        if (this.aIK != null) {
            this.aIK.a(tbPageContext, i);
        }
        if (this.aIM != null) {
            this.aIM.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.CT()) {
                this.aIK.ox();
                if (aVar.CR()) {
                    this.aIK.er(i.h.loading);
                } else if (!aVar.CS()) {
                    this.aIK.es(i.h.no_more_msg);
                }
            } else {
                this.aIK.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.aII.completePullRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.d) {
            List<tinfo> Hl = ((com.baidu.tieba.chosen.posts.request.d) aVar).Hl();
            if (Hl != null && Hl.size() > 0) {
                this.aII.setVisibility(0);
            }
            if (this.MZ != null) {
                this.MZ.u(getView());
            }
            if (this.aIL) {
                this.aIJ.r(Hl);
                return;
            }
            this.aIJ.s(Hl);
            if (Hl != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(i.h.chosen_post_recommend, new Object[]{Integer.valueOf(Hl.size())}), 0);
                a2.bR(48);
                a2.bT(this.paddingTop);
                a2.bP(this.Xh);
                a2.sX().sZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hi() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.aIH.getUniqueId());
        this.aIH.oG().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.aII;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.aIN == null) {
            this.aIN = new com.baidu.tbadk.e.h(getPageContext().getPageActivity(), new a(this, null));
        }
        this.aIN.fx(str);
        this.aIN.b(view, z);
        this.aIN.Cm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.aIN != null) {
            this.aIN.u(view);
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
            e.this.MZ.b(e.this.getView(), true);
            e.this.Hi();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
