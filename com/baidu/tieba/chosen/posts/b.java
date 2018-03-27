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
    int aRO;
    private NavigationBar bVs;
    private f bXd;
    private NoNetworkView cjQ;
    private ChosenPostActivity deQ;
    private BdListView deR;
    private com.baidu.tieba.chosen.posts.a deS;
    private com.baidu.tbadk.mvc.g.a deT;
    private boolean deU;
    private g deV;
    private k mPullView;
    private View mRootView;
    int paddingTop;

    protected k amO() {
        if (this.mPullView == null) {
            this.mPullView = new k(this.deQ.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.deU = false;
        this.deQ = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View YO() {
        this.mRootView = this.deQ.getLayoutInflater().inflate(d.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amP() {
        this.paddingTop = this.deQ.getResources().getDimensionPixelSize(d.e.ds108);
        this.aRO = this.deQ.getResources().getDimensionPixelSize(d.e.ds150);
        this.bVs = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bVs.setTitleText(d.j.recommend_frs_hot_thread_title);
        this.bVs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.deR = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.cjQ = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.deS = new com.baidu.tieba.chosen.posts.a(this.deQ.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.h.chosen_picture_layout, d.h.chosen_no_picture_layout, d.h.chosen_image_text_layout}, this.deQ.NL());
        this.deR.setAdapter((ListAdapter) this.deS);
        this.mPullView = amO();
        this.deR.setPullRefresh(this.mPullView);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                b.this.deQ.amJ().eY(z);
            }
        });
        this.deR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.deS.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.deR.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.deS.getItem(i));
                        bVar.setUniqueId(b.this.deQ.getUniqueId());
                        b.this.deQ.NL().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.deQ.getPageContext());
                aVar.AV();
                return true;
            }
        });
        this.deR.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.pa()) {
                    b.this.deQ.amJ().amN();
                } else if (b.this.deT != null) {
                    b.this.deT.th();
                    b.this.deT.ie(d.j.no_more_msg);
                }
            }
        });
        this.deT = new com.baidu.tbadk.mvc.g.a(this.deQ);
        this.deT.st();
        getListView().setNextPage(this.deT);
        this.bXd = new f(getActivity());
        this.bXd.onChangeSkinType();
        this.bXd.j(getView(), true);
        this.deQ.amJ().amM();
    }

    public Activity getActivity() {
        return this.deQ.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Nd()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.deU = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.deU = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.Ne());
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
            this.deS.bn(((Long) extra).longValue());
            if (this.deS.getCount() <= 5) {
                amQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bXd != null) {
            this.bXd.bk(getView());
        }
        if (errorData != null && this.deS.NH() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.deR.completePullRefreshPostDelayed(2000L);
        if (this.deT != null) {
            this.deT.ie(d.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bVs != null) {
            this.bVs.onChangeSkinType(tbPageContext, i);
        }
        if (this.deS != null) {
            this.deS.b(tbPageContext, i);
        }
        if (this.deT != null) {
            this.deT.b(tbPageContext, i);
        }
        if (this.cjQ != null) {
            this.cjQ.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.NF()) {
                this.deT.th();
                if (aVar.ND()) {
                    this.deT.id(d.j.loading);
                } else if (!aVar.NE()) {
                    this.deT.ie(d.j.no_more_msg);
                }
            } else {
                this.deT.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.deR.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> amS = ((com.baidu.tieba.chosen.posts.request.b) aVar).amS();
            if (amS != null && amS.size() > 0) {
                this.deR.setVisibility(0);
            }
            if (this.bXd != null) {
                this.bXd.bk(getView());
            }
            if (this.deU) {
                this.deS.M(amS);
                return;
            }
            this.deS.N(amS);
            if (amS != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(d.j.chosen_post_recommend, new Object[]{Integer.valueOf(amS.size())}), 0);
                a2.fn(48);
                a2.setOffsetY(this.paddingTop);
                a2.fl(this.aRO);
                a2.Bb().Bd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amQ() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.deQ.getUniqueId());
        this.deQ.NL().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.deR;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.deV == null) {
            this.deV = new g(getPageContext().getPageActivity(), new a());
        }
        this.deV.gW(str);
        this.deV.j(view, z);
        this.deV.MR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.deV != null) {
            this.deV.bk(view);
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
            b.this.bXd.j(b.this.getView(), true);
            b.this.amQ();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
