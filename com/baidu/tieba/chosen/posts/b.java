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
import com.baidu.tieba.f;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    private NoNetworkView bFw;
    private NavigationBar bpP;
    private f brv;
    private ChosenPostActivity cGL;
    private BdListView cGM;
    private com.baidu.tieba.chosen.posts.a cGN;
    private com.baidu.tbadk.mvc.g.a cGO;
    private boolean cGP;
    private g cGQ;
    private h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected h akp() {
        if (this.mPullView == null) {
            this.mPullView = new h(this.cGL.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cGP = false;
        this.cGL = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Vq() {
        this.mRootView = this.cGL.getLayoutInflater().inflate(f.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akq() {
        this.paddingTop = this.cGL.getResources().getDimensionPixelSize(f.e.ds108);
        this.paddingHorizontal = this.cGL.getResources().getDimensionPixelSize(f.e.ds150);
        this.bpP = (NavigationBar) getView().findViewById(f.g.chosen_post_navigation_bar);
        this.bpP.setTitleText(f.j.recommend_frs_hot_thread_title);
        this.bpP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cGM = (BdListView) getView().findViewById(f.g.chosen_post_list);
        this.bFw = (NoNetworkView) getView().findViewById(f.g.view_no_network);
        this.cGN = new com.baidu.tieba.chosen.posts.a(this.cGL.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{f.h.chosen_picture_layout, f.h.chosen_no_picture_layout, f.h.chosen_image_text_layout}, this.cGL.Kk());
        this.cGM.setAdapter((ListAdapter) this.cGN);
        this.mPullView = akp();
        this.cGM.setPullRefresh(this.mPullView);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                b.this.cGL.akk().eJ(z);
            }
        });
        this.cGM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.cGN.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cGM.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.dB(b.this.getActivity().getString(f.j.chosen_post_dialog_text));
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(f.j.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.cGN.getItem(i));
                        bVar.setUniqueId(b.this.cGL.getUniqueId());
                        b.this.cGL.Kk().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cGL.getPageContext());
                aVar.xe();
                return true;
            }
        });
        this.cGM.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.jV()) {
                    b.this.cGL.akk().ako();
                } else if (b.this.cGO != null) {
                    b.this.cGO.oC();
                    b.this.cGO.fj(f.j.no_more_msg);
                }
            }
        });
        this.cGO = new com.baidu.tbadk.mvc.g.a(this.cGL);
        this.cGO.np();
        getListView().setNextPage(this.cGO);
        this.brv = new com.baidu.tbadk.k.f(getActivity());
        this.brv.onChangeSkinType();
        this.brv.c(getView(), true);
        this.cGL.akk().akn();
    }

    public Activity getActivity() {
        return this.cGL.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.JC()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.cGP = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.cGP = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.JD());
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
            this.cGN.bn(((Long) extra).longValue());
            if (this.cGN.getCount() <= 5) {
                akr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.brv != null) {
            this.brv.Q(getView());
        }
        if (errorData != null && this.cGN.Kg() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(f.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cGM.completePullRefreshPostDelayed(2000L);
        if (this.cGO != null) {
            this.cGO.fj(f.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bpP != null) {
            this.bpP.onChangeSkinType(tbPageContext, i);
        }
        if (this.cGN != null) {
            this.cGN.b(tbPageContext, i);
        }
        if (this.cGO != null) {
            this.cGO.b(tbPageContext, i);
        }
        if (this.bFw != null) {
            this.bFw.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Ke()) {
                this.cGO.oC();
                if (aVar.Kc()) {
                    this.cGO.fi(f.j.loading);
                } else if (!aVar.Kd()) {
                    this.cGO.fj(f.j.no_more_msg);
                }
            } else {
                this.cGO.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cGM.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> akt = ((com.baidu.tieba.chosen.posts.request.b) aVar).akt();
            if (akt != null && akt.size() > 0) {
                this.cGM.setVisibility(0);
            }
            if (this.brv != null) {
                this.brv.Q(getView());
            }
            if (this.cGP) {
                this.cGN.H(akt);
                return;
            }
            this.cGN.I(akt);
            if (akt != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(f.j.chosen_post_recommend, new Object[]{Integer.valueOf(akt.size())}), 0);
                a2.cr(48);
                a2.setOffsetY(this.paddingTop);
                a2.cp(this.paddingHorizontal);
                a2.xk().xm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akr() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.cGL.getUniqueId());
        this.cGL.Kk().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cGM;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.cGQ == null) {
            this.cGQ = new com.baidu.tbadk.k.g(getPageContext().getPageActivity(), new a());
        }
        this.cGQ.hk(str);
        this.cGQ.c(view, z);
        this.cGQ.Jk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.cGQ != null) {
            this.cGQ.Q(view);
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
            b.this.brv.c(b.this.getView(), true);
            b.this.akr();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
