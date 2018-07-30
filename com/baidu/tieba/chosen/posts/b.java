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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    private NoNetworkView bFw;
    private NavigationBar bpN;
    private f brt;
    private ChosenPostActivity cGO;
    private BdListView cGP;
    private com.baidu.tieba.chosen.posts.a cGQ;
    private com.baidu.tbadk.mvc.g.a cGR;
    private boolean cGS;
    private g cGT;
    private h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected h akn() {
        if (this.mPullView == null) {
            this.mPullView = new h(this.cGO.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cGS = false;
        this.cGO = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Vm() {
        this.mRootView = this.cGO.getLayoutInflater().inflate(d.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ako() {
        this.paddingTop = this.cGO.getResources().getDimensionPixelSize(d.e.ds108);
        this.paddingHorizontal = this.cGO.getResources().getDimensionPixelSize(d.e.ds150);
        this.bpN = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bpN.setTitleText(d.j.recommend_frs_hot_thread_title);
        this.bpN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cGP = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.bFw = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.cGQ = new com.baidu.tieba.chosen.posts.a(this.cGO.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.h.chosen_picture_layout, d.h.chosen_no_picture_layout, d.h.chosen_image_text_layout}, this.cGO.Kg());
        this.cGP.setAdapter((ListAdapter) this.cGQ);
        this.mPullView = akn();
        this.cGP.setPullRefresh(this.mPullView);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                b.this.cGO.aki().eJ(z);
            }
        });
        this.cGP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.cGQ.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cGP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.dB(b.this.getActivity().getString(d.j.chosen_post_dialog_text));
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(d.j.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.cGQ.getItem(i));
                        bVar.setUniqueId(b.this.cGO.getUniqueId());
                        b.this.cGO.Kg().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cGO.getPageContext());
                aVar.xf();
                return true;
            }
        });
        this.cGP.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.jV()) {
                    b.this.cGO.aki().akm();
                } else if (b.this.cGR != null) {
                    b.this.cGR.oF();
                    b.this.cGR.fk(d.j.no_more_msg);
                }
            }
        });
        this.cGR = new com.baidu.tbadk.mvc.g.a(this.cGO);
        this.cGR.np();
        getListView().setNextPage(this.cGR);
        this.brt = new f(getActivity());
        this.brt.onChangeSkinType();
        this.brt.c(getView(), true);
        this.cGO.aki().akl();
    }

    public Activity getActivity() {
        return this.cGO.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Jy()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.cGS = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.cGS = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.Jz());
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
            this.cGQ.bn(((Long) extra).longValue());
            if (this.cGQ.getCount() <= 5) {
                akp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.brt != null) {
            this.brt.Q(getView());
        }
        if (errorData != null && this.cGQ.Kc() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cGP.completePullRefreshPostDelayed(2000L);
        if (this.cGR != null) {
            this.cGR.fk(d.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bpN != null) {
            this.bpN.onChangeSkinType(tbPageContext, i);
        }
        if (this.cGQ != null) {
            this.cGQ.b(tbPageContext, i);
        }
        if (this.cGR != null) {
            this.cGR.b(tbPageContext, i);
        }
        if (this.bFw != null) {
            this.bFw.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Ka()) {
                this.cGR.oF();
                if (aVar.JY()) {
                    this.cGR.fj(d.j.loading);
                } else if (!aVar.JZ()) {
                    this.cGR.fk(d.j.no_more_msg);
                }
            } else {
                this.cGR.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cGP.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> akr = ((com.baidu.tieba.chosen.posts.request.b) aVar).akr();
            if (akr != null && akr.size() > 0) {
                this.cGP.setVisibility(0);
            }
            if (this.brt != null) {
                this.brt.Q(getView());
            }
            if (this.cGS) {
                this.cGQ.H(akr);
                return;
            }
            this.cGQ.I(akr);
            if (akr != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(d.j.chosen_post_recommend, new Object[]{Integer.valueOf(akr.size())}), 0);
                a2.cr(48);
                a2.setOffsetY(this.paddingTop);
                a2.cp(this.paddingHorizontal);
                a2.xl().xn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akp() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.cGO.getUniqueId());
        this.cGO.Kg().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cGP;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.cGT == null) {
            this.cGT = new com.baidu.tbadk.k.g(getPageContext().getPageActivity(), new a());
        }
        this.cGT.hk(str);
        this.cGT.c(view, z);
        this.cGT.Jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.cGT != null) {
            this.cGT.Q(view);
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
            b.this.brt.c(b.this.getView(), true);
            b.this.akp();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
