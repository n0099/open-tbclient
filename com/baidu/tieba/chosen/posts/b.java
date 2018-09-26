package com.baidu.tieba.chosen.posts;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.e;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    private NoNetworkView bLl;
    private NavigationBar bvF;
    private f bxm;
    private ChosenPostActivity cMC;
    private BdListView cMD;
    private com.baidu.tieba.chosen.posts.a cME;
    private com.baidu.tbadk.mvc.g.a cMF;
    private boolean cMG;
    private g cMH;
    private k mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected k ama() {
        if (this.mPullView == null) {
            this.mPullView = new k(this.cMC.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cMG = false;
        this.cMC = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Xd() {
        this.mRootView = this.cMC.getLayoutInflater().inflate(e.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amb() {
        this.paddingTop = this.cMC.getResources().getDimensionPixelSize(e.C0141e.ds108);
        this.paddingHorizontal = this.cMC.getResources().getDimensionPixelSize(e.C0141e.ds150);
        this.bvF = (NavigationBar) getView().findViewById(e.g.chosen_post_navigation_bar);
        this.bvF.setTitleText(e.j.recommend_frs_hot_thread_title);
        this.bvF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cMD = (BdListView) getView().findViewById(e.g.chosen_post_list);
        this.bLl = (NoNetworkView) getView().findViewById(e.g.view_no_network);
        this.cME = new com.baidu.tieba.chosen.posts.a(this.cMC.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{e.h.chosen_picture_layout, e.h.chosen_no_picture_layout, e.h.chosen_image_text_layout}, this.cMC.LA());
        this.cMD.setAdapter((ListAdapter) this.cME);
        this.mPullView = ama();
        this.cMD.setPullRefresh(this.mPullView);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                b.this.cMC.alV().fa(z);
            }
        });
        this.cMD.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.cME.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cMD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.dT(b.this.getActivity().getString(e.j.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.cME.getItem(i));
                        bVar.setUniqueId(b.this.cMC.getUniqueId());
                        b.this.cMC.LA().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cMC.getPageContext());
                aVar.yl();
                return true;
            }
        });
        this.cMD.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.lb()) {
                    b.this.cMC.alV().alZ();
                } else if (b.this.cMF != null) {
                    b.this.cMF.pI();
                    b.this.cMF.fv(e.j.no_more_msg);
                }
            }
        });
        this.cMF = new com.baidu.tbadk.mvc.g.a(this.cMC);
        this.cMF.ov();
        getListView().setNextPage(this.cMF);
        this.bxm = new f(getActivity());
        this.bxm.onChangeSkinType();
        this.bxm.c(getView(), true);
        this.cMC.alV().alY();
    }

    public Activity getActivity() {
        return this.cMC.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.KS()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.cMG = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.cMG = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.KT());
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
            this.cME.br(((Long) extra).longValue());
            if (this.cME.getCount() <= 5) {
                amc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bxm != null) {
            this.bxm.ad(getView());
        }
        if (errorData != null && this.cME.Lw() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(e.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cMD.completePullRefreshPostDelayed(2000L);
        if (this.cMF != null) {
            this.cMF.fv(e.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bvF != null) {
            this.bvF.onChangeSkinType(tbPageContext, i);
        }
        if (this.cME != null) {
            this.cME.b(tbPageContext, i);
        }
        if (this.cMF != null) {
            this.cMF.b(tbPageContext, i);
        }
        if (this.bLl != null) {
            this.bLl.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Lu()) {
                this.cMF.pI();
                if (aVar.Ls()) {
                    this.cMF.fu(e.j.loading);
                } else if (!aVar.Lt()) {
                    this.cMF.fv(e.j.no_more_msg);
                }
            } else {
                this.cMF.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cMD.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> ame = ((com.baidu.tieba.chosen.posts.request.b) aVar).ame();
            if (ame != null && ame.size() > 0) {
                this.cMD.setVisibility(0);
            }
            if (this.bxm != null) {
                this.bxm.ad(getView());
            }
            if (this.cMG) {
                this.cME.I(ame);
                return;
            }
            this.cME.J(ame);
            if (ame != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(e.j.chosen_post_recommend, new Object[]{Integer.valueOf(ame.size())}), 0);
                a2.cB(48);
                a2.setOffsetY(this.paddingTop);
                a2.cz(this.paddingHorizontal);
                a2.yr().yt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amc() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.cMC.getUniqueId());
        this.cMC.LA().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cMD;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.cMH == null) {
            this.cMH = new g(getPageContext().getPageActivity(), new a());
        }
        this.cMH.hG(str);
        this.cMH.c(view, z);
        this.cMH.KA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.cMH != null) {
            this.cMH.ad(view);
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
            b.this.bxm.c(b.this.getView(), true);
            b.this.amc();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
