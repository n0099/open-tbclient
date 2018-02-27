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
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    int aRM;
    private NavigationBar bVp;
    private f bXa;
    private NoNetworkView cjN;
    private ChosenPostActivity deN;
    private BdListView deO;
    private com.baidu.tieba.chosen.posts.a deP;
    private com.baidu.tbadk.mvc.g.a deQ;
    private boolean deR;
    private g deS;
    private k mPullView;
    private View mRootView;
    int paddingTop;

    protected k amN() {
        if (this.mPullView == null) {
            this.mPullView = new k(this.deN.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.deR = false;
        this.deN = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View YN() {
        this.mRootView = this.deN.getLayoutInflater().inflate(d.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amO() {
        this.paddingTop = this.deN.getResources().getDimensionPixelSize(d.e.ds108);
        this.aRM = this.deN.getResources().getDimensionPixelSize(d.e.ds150);
        this.bVp = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bVp.setTitleText(d.j.recommend_frs_hot_thread_title);
        this.bVp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deO = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.cjN = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.deP = new com.baidu.tieba.chosen.posts.a(this.deN.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.h.chosen_picture_layout, d.h.chosen_no_picture_layout, d.h.chosen_image_text_layout}, this.deN.NK());
        this.deO.setAdapter((ListAdapter) this.deP);
        this.mPullView = amN();
        this.deO.setPullRefresh(this.mPullView);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                b.this.deN.amI().eY(z);
            }
        });
        this.deO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.deP.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.deO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.dk(b.this.getActivity().getString(d.j.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.deP.getItem(i));
                        bVar.setUniqueId(b.this.deN.getUniqueId());
                        b.this.deN.NK().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.deN.getPageContext());
                aVar.AU();
                return true;
            }
        });
        this.deO.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.pa()) {
                    b.this.deN.amI().amM();
                } else if (b.this.deQ != null) {
                    b.this.deQ.th();
                    b.this.deQ.ie(d.j.no_more_msg);
                }
            }
        });
        this.deQ = new com.baidu.tbadk.mvc.g.a(this.deN);
        this.deQ.st();
        getListView().setNextPage(this.deQ);
        this.bXa = new f(getActivity());
        this.bXa.onChangeSkinType();
        this.bXa.j(getView(), true);
        this.deN.amI().amL();
    }

    public Activity getActivity() {
        return this.deN.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Nc()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.deR = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.deR = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.Nd());
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
            this.deP.bn(((Long) extra).longValue());
            if (this.deP.getCount() <= 5) {
                amP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bXa != null) {
            this.bXa.bk(getView());
        }
        if (errorData != null && this.deP.NG() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.deO.completePullRefreshPostDelayed(2000L);
        if (this.deQ != null) {
            this.deQ.ie(d.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bVp != null) {
            this.bVp.onChangeSkinType(tbPageContext, i);
        }
        if (this.deP != null) {
            this.deP.b(tbPageContext, i);
        }
        if (this.deQ != null) {
            this.deQ.b(tbPageContext, i);
        }
        if (this.cjN != null) {
            this.cjN.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.NE()) {
                this.deQ.th();
                if (aVar.NC()) {
                    this.deQ.id(d.j.loading);
                } else if (!aVar.ND()) {
                    this.deQ.ie(d.j.no_more_msg);
                }
            } else {
                this.deQ.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.deO.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> amR = ((com.baidu.tieba.chosen.posts.request.b) aVar).amR();
            if (amR != null && amR.size() > 0) {
                this.deO.setVisibility(0);
            }
            if (this.bXa != null) {
                this.bXa.bk(getView());
            }
            if (this.deR) {
                this.deP.M(amR);
                return;
            }
            this.deP.N(amR);
            if (amR != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(d.j.chosen_post_recommend, new Object[]{Integer.valueOf(amR.size())}), 0);
                a2.fn(48);
                a2.setOffsetY(this.paddingTop);
                a2.fl(this.aRM);
                a2.Ba().Bc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amP() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.deN.getUniqueId());
        this.deN.NK().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.deO;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.deS == null) {
            this.deS = new g(getPageContext().getPageActivity(), new a());
        }
        this.deS.gW(str);
        this.deS.j(view, z);
        this.deS.MQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.deS != null) {
            this.deS.bk(view);
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
            b.this.bXa.j(b.this.getView(), true);
            b.this.amP();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
