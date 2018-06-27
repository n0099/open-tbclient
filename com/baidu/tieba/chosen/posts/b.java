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
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    private NoNetworkView bEG;
    private NavigationBar bpg;
    private f bqL;
    private ChosenPostActivity cEi;
    private BdListView cEj;
    private com.baidu.tieba.chosen.posts.a cEk;
    private com.baidu.tbadk.mvc.g.a cEl;
    private boolean cEm;
    private g cEn;
    private h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected h ajO() {
        if (this.mPullView == null) {
            this.mPullView = new h(this.cEi.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cEm = false;
        this.cEi = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Vd() {
        this.mRootView = this.cEi.getLayoutInflater().inflate(d.i.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajP() {
        this.paddingTop = this.cEi.getResources().getDimensionPixelSize(d.e.ds108);
        this.paddingHorizontal = this.cEi.getResources().getDimensionPixelSize(d.e.ds150);
        this.bpg = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bpg.setTitleText(d.k.recommend_frs_hot_thread_title);
        this.bpg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cEj = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.bEG = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.cEk = new com.baidu.tieba.chosen.posts.a(this.cEi.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.i.chosen_picture_layout, d.i.chosen_no_picture_layout, d.i.chosen_image_text_layout}, this.cEi.Kl());
        this.cEj.setAdapter((ListAdapter) this.cEk);
        this.mPullView = ajO();
        this.cEj.setPullRefresh(this.mPullView);
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                b.this.cEi.ajJ().eI(z);
            }
        });
        this.cEj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.cEk.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cEj.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.dE(b.this.getActivity().getString(d.k.chosen_post_dialog_text));
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.cEk.getItem(i));
                        bVar.setUniqueId(b.this.cEi.getUniqueId());
                        b.this.cEi.Kl().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cEi.getPageContext());
                aVar.xn();
                return true;
            }
        });
        this.cEj.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.jU()) {
                    b.this.cEi.ajJ().ajN();
                } else if (b.this.cEl != null) {
                    b.this.cEl.oD();
                    b.this.cEl.fj(d.k.no_more_msg);
                }
            }
        });
        this.cEl = new com.baidu.tbadk.mvc.g.a(this.cEi);
        this.cEl.nn();
        getListView().setNextPage(this.cEl);
        this.bqL = new f(getActivity());
        this.bqL.onChangeSkinType();
        this.bqL.d(getView(), true);
        this.cEi.ajJ().ajM();
    }

    public Activity getActivity() {
        return this.cEi.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.JD()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.cEm = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.cEm = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.JE());
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
            this.cEk.bj(((Long) extra).longValue());
            if (this.cEk.getCount() <= 5) {
                ajQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bqL != null) {
            this.bqL.Q(getView());
        }
        if (errorData != null && this.cEk.Kh() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.k.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cEj.completePullRefreshPostDelayed(2000L);
        if (this.cEl != null) {
            this.cEl.fj(d.k.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bpg != null) {
            this.bpg.onChangeSkinType(tbPageContext, i);
        }
        if (this.cEk != null) {
            this.cEk.b(tbPageContext, i);
        }
        if (this.cEl != null) {
            this.cEl.b(tbPageContext, i);
        }
        if (this.bEG != null) {
            this.bEG.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Kf()) {
                this.cEl.oD();
                if (aVar.Kd()) {
                    this.cEl.fi(d.k.loading);
                } else if (!aVar.Ke()) {
                    this.cEl.fj(d.k.no_more_msg);
                }
            } else {
                this.cEl.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cEj.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> ajS = ((com.baidu.tieba.chosen.posts.request.b) aVar).ajS();
            if (ajS != null && ajS.size() > 0) {
                this.cEj.setVisibility(0);
            }
            if (this.bqL != null) {
                this.bqL.Q(getView());
            }
            if (this.cEm) {
                this.cEk.I(ajS);
                return;
            }
            this.cEk.J(ajS);
            if (ajS != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(d.k.chosen_post_recommend, new Object[]{Integer.valueOf(ajS.size())}), 0);
                a2.cp(48);
                a2.setOffsetY(this.paddingTop);
                a2.cn(this.paddingHorizontal);
                a2.xt().xv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajQ() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.cEi.getUniqueId());
        this.cEi.Kl().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cEj;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.cEn == null) {
            this.cEn = new com.baidu.tbadk.j.g(getPageContext().getPageActivity(), new a());
        }
        this.cEn.setSubText(str);
        this.cEn.d(view, z);
        this.cEn.Jp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.cEn != null) {
            this.cEn.Q(view);
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
            b.this.bqL.d(b.this.getView(), true);
            b.this.ajQ();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
