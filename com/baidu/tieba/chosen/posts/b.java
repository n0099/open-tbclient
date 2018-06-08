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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    private NoNetworkView bCJ;
    private NavigationBar bnG;
    private f bpl;
    private ChosenPostActivity cGp;
    private BdListView cGq;
    private com.baidu.tieba.chosen.posts.a cGr;
    private com.baidu.tbadk.mvc.g.a cGs;
    private boolean cGt;
    private g cGu;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g aku() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.cGp.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cGt = false;
        this.cGp = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View UI() {
        this.mRootView = this.cGp.getLayoutInflater().inflate(d.i.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void akv() {
        this.paddingTop = this.cGp.getResources().getDimensionPixelSize(d.e.ds108);
        this.paddingHorizontal = this.cGp.getResources().getDimensionPixelSize(d.e.ds150);
        this.bnG = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bnG.setTitleText(d.k.recommend_frs_hot_thread_title);
        this.bnG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cGq = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.bCJ = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.cGr = new com.baidu.tieba.chosen.posts.a(this.cGp.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.i.chosen_picture_layout, d.i.chosen_no_picture_layout, d.i.chosen_image_text_layout}, this.cGp.JT());
        this.cGq.setAdapter((ListAdapter) this.cGr);
        this.mPullView = aku();
        this.cGq.setPullRefresh(this.mPullView);
        this.mPullView.a(new f.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                b.this.cGp.akp().eI(z);
            }
        });
        this.cGq.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.cGr.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cGq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.dB(b.this.getActivity().getString(d.k.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.cGr.getItem(i));
                        bVar.setUniqueId(b.this.cGp.getUniqueId());
                        b.this.cGp.JT().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cGp.getPageContext());
                aVar.xa();
                return true;
            }
        });
        this.cGq.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.jU()) {
                    b.this.cGp.akp().akt();
                } else if (b.this.cGs != null) {
                    b.this.cGs.oD();
                    b.this.cGs.fi(d.k.no_more_msg);
                }
            }
        });
        this.cGs = new com.baidu.tbadk.mvc.g.a(this.cGp);
        this.cGs.nn();
        getListView().setNextPage(this.cGs);
        this.bpl = new com.baidu.tbadk.j.f(getActivity());
        this.bpl.onChangeSkinType();
        this.bpl.d(getView(), true);
        this.cGp.akp().aks();
    }

    public Activity getActivity() {
        return this.cGp.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Jl()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.cGt = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.cGt = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.Jm());
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
            this.cGr.bp(((Long) extra).longValue());
            if (this.cGr.getCount() <= 5) {
                akw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bpl != null) {
            this.bpl.P(getView());
        }
        if (errorData != null && this.cGr.JP() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.k.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cGq.completePullRefreshPostDelayed(2000L);
        if (this.cGs != null) {
            this.cGs.fi(d.k.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bnG != null) {
            this.bnG.onChangeSkinType(tbPageContext, i);
        }
        if (this.cGr != null) {
            this.cGr.b(tbPageContext, i);
        }
        if (this.cGs != null) {
            this.cGs.b(tbPageContext, i);
        }
        if (this.bCJ != null) {
            this.bCJ.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.JN()) {
                this.cGs.oD();
                if (aVar.JL()) {
                    this.cGs.fh(d.k.loading);
                } else if (!aVar.JM()) {
                    this.cGs.fi(d.k.no_more_msg);
                }
            } else {
                this.cGs.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cGq.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> aky = ((com.baidu.tieba.chosen.posts.request.b) aVar).aky();
            if (aky != null && aky.size() > 0) {
                this.cGq.setVisibility(0);
            }
            if (this.bpl != null) {
                this.bpl.P(getView());
            }
            if (this.cGt) {
                this.cGr.H(aky);
                return;
            }
            this.cGr.I(aky);
            if (aky != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(d.k.chosen_post_recommend, new Object[]{Integer.valueOf(aky.size())}), 0);
                a2.co(48);
                a2.setOffsetY(this.paddingTop);
                a2.cm(this.paddingHorizontal);
                a2.xg().xi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akw() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.cGp.getUniqueId());
        this.cGp.JT().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cGq;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.cGu == null) {
            this.cGu = new g(getPageContext().getPageActivity(), new a());
        }
        this.cGu.setSubText(str);
        this.cGu.d(view, z);
        this.cGu.IX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.cGu != null) {
            this.cGu.P(view);
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
            b.this.bpl.d(b.this.getView(), true);
            b.this.akw();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
