package com.baidu.tieba.chosen.posts;

import android.app.Activity;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class b extends c<ChosenPostActivity> {
    int bOi;
    private NoNetworkView dEc;
    private NavigationBar dbp;
    private g dly;
    private ChosenPostActivity eMr;
    private BdListView eMs;
    private com.baidu.tieba.chosen.posts.a eMt;
    private com.baidu.tbadk.mvc.g.a eMu;
    private boolean eMv;
    private h eMw;
    private i mPullView;
    private View mRootView;
    int paddingTop;

    protected i bbH() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.eMr.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eMv = false;
        this.eMr = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aLT() {
        this.mRootView = this.eMr.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbI() {
        this.paddingTop = this.eMr.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.bOi = this.eMr.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.dbp = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.dbp.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.dbp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eMs = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.dEc = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.eMt = new com.baidu.tieba.chosen.posts.a(this.eMr.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.eMr.avg());
        this.eMs.setAdapter((ListAdapter) this.eMt);
        this.mPullView = bbH();
        this.eMs.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                b.this.eMr.bbC().iS(z);
            }
        });
        this.eMs.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.eMt.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.eMs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.mQ(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.eMt.getItem(i));
                        bVar.setUniqueId(b.this.eMr.getUniqueId());
                        b.this.eMr.avg().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.eMr.getPageContext());
                aVar.agO();
                return true;
            }
        });
        this.eMs.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.kt()) {
                    b.this.eMr.bbC().bbG();
                } else if (b.this.eMu != null) {
                    b.this.eMu.ql();
                    b.this.eMu.kS(R.string.no_more_msg);
                }
            }
        });
        this.eMu = new com.baidu.tbadk.mvc.g.a(this.eMr);
        this.eMu.nZ();
        getListView().setNextPage(this.eMu);
        this.dly = new g(getActivity());
        this.dly.onChangeSkinType();
        this.dly.attachView(getView(), true);
        this.eMr.bbC().bbF();
    }

    public Activity getActivity() {
        return this.eMr.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aux()) {
            case 4097:
                this.eMv = false;
                break;
            case 4098:
                this.eMv = true;
                break;
            case 4099:
                a(bVar.auy());
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
            this.eMt.cL(((Long) extra).longValue());
            if (this.eMt.getCount() <= 5) {
                bbJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.dly != null) {
            this.dly.dettachView(getView());
        }
        if (errorData != null && this.eMt.avc() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.eMs.completePullRefreshPostDelayed(0L);
        if (this.eMu != null) {
            this.eMu.kS(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dbp != null) {
            this.dbp.onChangeSkinType(tbPageContext, i);
        }
        if (this.eMt != null) {
            this.eMt.b(tbPageContext, i);
        }
        if (this.eMu != null) {
            this.eMu.b(tbPageContext, i);
        }
        if (this.dEc != null) {
            this.dEc.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.ava()) {
                this.eMu.ql();
                if (aVar.auY()) {
                    this.eMu.kR(R.string.loading);
                } else if (!aVar.auZ()) {
                    this.eMu.kS(R.string.no_more_msg);
                }
            } else {
                this.eMu.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.eMs.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bbL = ((com.baidu.tieba.chosen.posts.request.b) aVar).bbL();
            if (bbL != null && bbL.size() > 0) {
                this.eMs.setVisibility(0);
            }
            if (this.dly != null) {
                this.dly.dettachView(getView());
            }
            if (this.eMv) {
                this.eMt.ak(bbL);
                return;
            }
            this.eMt.al(bbL);
            if (bbL != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bbL.size())}), 0);
                b.hG(48);
                b.setOffsetY(this.paddingTop);
                b.hF(this.bOi);
                b.agU().agW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbJ() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.eMr.getUniqueId());
        this.eMr.avg().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.eMs;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eMw == null) {
            this.eMw = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eMw.qY(str);
        this.eMw.attachView(view, z);
        this.eMw.atW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eMw != null) {
            this.eMw.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.dly.attachView(b.this.getView(), true);
            b.this.bbJ();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
