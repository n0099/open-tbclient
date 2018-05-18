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
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    int adl;
    private NavigationBar bfz;
    private f bhf;
    private NoNetworkView buG;
    private ChosenPostActivity cxM;
    private BdListView cxN;
    private com.baidu.tieba.chosen.posts.a cxO;
    private com.baidu.tbadk.mvc.g.a cxP;
    private boolean cxQ;
    private g cxR;
    private com.baidu.tbadk.core.view.f mPullView;
    private View mRootView;
    int paddingTop;

    protected com.baidu.tbadk.core.view.f agM() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.cxM.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cxQ = false;
        this.cxM = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Rk() {
        this.mRootView = this.cxM.getLayoutInflater().inflate(d.i.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agN() {
        this.paddingTop = this.cxM.getResources().getDimensionPixelSize(d.e.ds108);
        this.adl = this.cxM.getResources().getDimensionPixelSize(d.e.ds150);
        this.bfz = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bfz.setTitleText(d.k.recommend_frs_hot_thread_title);
        this.bfz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cxN = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.buG = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.cxO = new com.baidu.tieba.chosen.posts.a(this.cxM.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.i.chosen_picture_layout, d.i.chosen_no_picture_layout, d.i.chosen_image_text_layout}, this.cxM.Gl());
        this.cxN.setAdapter((ListAdapter) this.cxO);
        this.mPullView = agM();
        this.cxN.setPullRefresh(this.mPullView);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                b.this.cxM.agH().eE(z);
            }
        });
        this.cxN.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                tinfo item = b.this.cxO.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cxN.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view2, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.dc(b.this.getActivity().getString(d.k.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.cxO.getItem(i));
                        bVar.setUniqueId(b.this.cxM.getUniqueId());
                        b.this.cxM.Gl().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cxM.getPageContext());
                aVar.tC();
                return true;
            }
        });
        this.cxN.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.hg()) {
                    b.this.cxM.agH().agL();
                } else if (b.this.cxP != null) {
                    b.this.cxP.lM();
                    b.this.cxP.fe(d.k.no_more_msg);
                }
            }
        });
        this.cxP = new com.baidu.tbadk.mvc.g.a(this.cxM);
        this.cxP.kz();
        getListView().setNextPage(this.cxP);
        this.bhf = new f(getActivity());
        this.bhf.onChangeSkinType();
        this.bhf.d(getView(), true);
        this.cxM.agH().agK();
    }

    public Activity getActivity() {
        return this.cxM.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.FD()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.cxQ = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.cxQ = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.FE());
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
            this.cxO.bl(((Long) extra).longValue());
            if (this.cxO.getCount() <= 5) {
                agO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bhf != null) {
            this.bhf.P(getView());
        }
        if (errorData != null && this.cxO.Gh() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.k.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cxN.completePullRefreshPostDelayed(2000L);
        if (this.cxP != null) {
            this.cxP.fe(d.k.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bfz != null) {
            this.bfz.onChangeSkinType(tbPageContext, i);
        }
        if (this.cxO != null) {
            this.cxO.b(tbPageContext, i);
        }
        if (this.cxP != null) {
            this.cxP.b(tbPageContext, i);
        }
        if (this.buG != null) {
            this.buG.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Gf()) {
                this.cxP.lM();
                if (aVar.Gd()) {
                    this.cxP.fd(d.k.loading);
                } else if (!aVar.Ge()) {
                    this.cxP.fe(d.k.no_more_msg);
                }
            } else {
                this.cxP.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cxN.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> agQ = ((com.baidu.tieba.chosen.posts.request.b) aVar).agQ();
            if (agQ != null && agQ.size() > 0) {
                this.cxN.setVisibility(0);
            }
            if (this.bhf != null) {
                this.bhf.P(getView());
            }
            if (this.cxQ) {
                this.cxO.E(agQ);
                return;
            }
            this.cxO.F(agQ);
            if (agQ != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(d.k.chosen_post_recommend, new Object[]{Integer.valueOf(agQ.size())}), 0);
                a2.cm(48);
                a2.setOffsetY(this.paddingTop);
                a2.ck(this.adl);
                a2.tI().tK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agO() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.cxM.getUniqueId());
        this.cxM.Gl().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cxN;
    }

    private void showNetRefreshView(View view2, String str, boolean z) {
        if (this.cxR == null) {
            this.cxR = new g(getPageContext().getPageActivity(), new a());
        }
        this.cxR.setSubText(str);
        this.cxR.d(view2, z);
        this.cxR.Fs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view2) {
        if (this.cxR != null) {
            this.cxR.P(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.bhf.d(b.this.getView(), true);
            b.this.agO();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
