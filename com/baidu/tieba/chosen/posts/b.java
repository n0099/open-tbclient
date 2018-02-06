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
    int aRX;
    private NavigationBar bVB;
    private f bXm;
    private NoNetworkView cjZ;
    private ChosenPostActivity deZ;
    private BdListView dfa;
    private com.baidu.tieba.chosen.posts.a dfb;
    private com.baidu.tbadk.mvc.g.a dfc;
    private boolean dfd;
    private g dfe;
    private k mPullView;
    private View mRootView;
    int paddingTop;

    protected k amO() {
        if (this.mPullView == null) {
            this.mPullView = new k(this.deZ.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.dfd = false;
        this.deZ = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View YO() {
        this.mRootView = this.deZ.getLayoutInflater().inflate(d.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amP() {
        this.paddingTop = this.deZ.getResources().getDimensionPixelSize(d.e.ds108);
        this.aRX = this.deZ.getResources().getDimensionPixelSize(d.e.ds150);
        this.bVB = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bVB.setTitleText(d.j.recommend_frs_hot_thread_title);
        this.bVB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dfa = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.cjZ = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.dfb = new com.baidu.tieba.chosen.posts.a(this.deZ.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.h.chosen_picture_layout, d.h.chosen_no_picture_layout, d.h.chosen_image_text_layout}, this.deZ.NL());
        this.dfa.setAdapter((ListAdapter) this.dfb);
        this.mPullView = amO();
        this.dfa.setPullRefresh(this.mPullView);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                b.this.deZ.amJ().eY(z);
            }
        });
        this.dfa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.dfb.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.dfa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.dfb.getItem(i));
                        bVar.setUniqueId(b.this.deZ.getUniqueId());
                        b.this.deZ.NL().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.deZ.getPageContext());
                aVar.AU();
                return true;
            }
        });
        this.dfa.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.pa()) {
                    b.this.deZ.amJ().amN();
                } else if (b.this.dfc != null) {
                    b.this.dfc.th();
                    b.this.dfc.ie(d.j.no_more_msg);
                }
            }
        });
        this.dfc = new com.baidu.tbadk.mvc.g.a(this.deZ);
        this.dfc.st();
        getListView().setNextPage(this.dfc);
        this.bXm = new f(getActivity());
        this.bXm.onChangeSkinType();
        this.bXm.j(getView(), true);
        this.deZ.amJ().amM();
    }

    public Activity getActivity() {
        return this.deZ.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Nd()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.dfd = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.dfd = true;
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
            this.dfb.bn(((Long) extra).longValue());
            if (this.dfb.getCount() <= 5) {
                amQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bXm != null) {
            this.bXm.bk(getView());
        }
        if (errorData != null && this.dfb.NH() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.dfa.completePullRefreshPostDelayed(2000L);
        if (this.dfc != null) {
            this.dfc.ie(d.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bVB != null) {
            this.bVB.onChangeSkinType(tbPageContext, i);
        }
        if (this.dfb != null) {
            this.dfb.b(tbPageContext, i);
        }
        if (this.dfc != null) {
            this.dfc.b(tbPageContext, i);
        }
        if (this.cjZ != null) {
            this.cjZ.onChangeSkinType(tbPageContext, i);
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
                this.dfc.th();
                if (aVar.ND()) {
                    this.dfc.id(d.j.loading);
                } else if (!aVar.NE()) {
                    this.dfc.ie(d.j.no_more_msg);
                }
            } else {
                this.dfc.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.dfa.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> amS = ((com.baidu.tieba.chosen.posts.request.b) aVar).amS();
            if (amS != null && amS.size() > 0) {
                this.dfa.setVisibility(0);
            }
            if (this.bXm != null) {
                this.bXm.bk(getView());
            }
            if (this.dfd) {
                this.dfb.M(amS);
                return;
            }
            this.dfb.N(amS);
            if (amS != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(d.j.chosen_post_recommend, new Object[]{Integer.valueOf(amS.size())}), 0);
                a2.fn(48);
                a2.setOffsetY(this.paddingTop);
                a2.fl(this.aRX);
                a2.Ba().Bc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amQ() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.deZ.getUniqueId());
        this.deZ.NL().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.dfa;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.dfe == null) {
            this.dfe = new g(getPageContext().getPageActivity(), new a());
        }
        this.dfe.gW(str);
        this.dfe.j(view, z);
        this.dfe.MR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.dfe != null) {
            this.dfe.bk(view);
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
            b.this.bXm.j(b.this.getView(), true);
            b.this.amQ();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
