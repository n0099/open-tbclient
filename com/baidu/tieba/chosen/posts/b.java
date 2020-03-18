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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes10.dex */
public class b extends c<ChosenPostActivity> {
    private NoNetworkView eCH;
    private NavigationBar ecv;
    private g euG;
    private ChosenPostActivity fPq;
    private BdListView fPr;
    private com.baidu.tieba.chosen.posts.a fPs;
    private com.baidu.tbadk.mvc.g.a fPt;
    private boolean fPu;
    private h fPv;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.h bvW() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.fPq.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.fPu = false;
        this.fPq = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View beY() {
        this.mRootView = this.fPq.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bvX() {
        this.paddingTop = this.fPq.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.fPq.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.ecv = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.ecv.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.ecv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fPr = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.eCH = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.fPs = new com.baidu.tieba.chosen.posts.a(this.fPq.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.fPq.aQU());
        this.fPr.setAdapter((ListAdapter) this.fPs);
        this.mPullView = bvW();
        this.fPr.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                b.this.fPq.bvR().kz(z);
            }
        });
        this.fPr.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.fPs.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.fPr.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.sR(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.fPs.getItem(i));
                        bVar.setUniqueId(b.this.fPq.getUniqueId());
                        b.this.fPq.aQU().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.fPq.getPageContext());
                aVar.aEG();
                return true;
            }
        });
        this.fPr.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.fPq.bvR().bvV();
                } else if (b.this.fPt != null) {
                    b.this.fPt.display();
                    b.this.fPt.mL(R.string.no_more_msg);
                }
            }
        });
        this.fPt = new com.baidu.tbadk.mvc.g.a(this.fPq);
        this.fPt.createView();
        getListView().setNextPage(this.fPt);
        this.euG = new com.baidu.tbadk.k.g(getActivity());
        this.euG.onChangeSkinType();
        this.euG.attachView(getView(), true);
        this.fPq.bvR().bvU();
    }

    public Activity getActivity() {
        return this.fPq.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aQs()) {
            case 4097:
                this.fPu = false;
                break;
            case 4098:
                this.fPu = true;
                break;
            case 4099:
                a(bVar.aQt());
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
            this.fPs.dl(((Long) extra).longValue());
            if (this.fPs.getCount() <= 5) {
                bvY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.euG != null) {
            this.euG.dettachView(getView());
        }
        if (errorData != null && this.fPs.aQR() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.fPr.completePullRefreshPostDelayed(0L);
        if (this.fPt != null) {
            this.fPt.mL(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.ecv != null) {
            this.ecv.onChangeSkinType(tbPageContext, i);
        }
        if (this.fPs != null) {
            this.fPs.b(tbPageContext, i);
        }
        if (this.fPt != null) {
            this.fPt.b(tbPageContext, i);
        }
        if (this.eCH != null) {
            this.eCH.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aQP()) {
                this.fPt.display();
                if (aVar.aQN()) {
                    this.fPt.mK(R.string.loading);
                } else if (!aVar.aQO()) {
                    this.fPt.mL(R.string.no_more_msg);
                }
            } else {
                this.fPt.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.fPr.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bwa = ((com.baidu.tieba.chosen.posts.request.b) aVar).bwa();
            if (bwa != null && bwa.size() > 0) {
                this.fPr.setVisibility(0);
            }
            if (this.euG != null) {
                this.euG.dettachView(getView());
            }
            if (this.fPu) {
                this.fPs.aJ(bwa);
                return;
            }
            this.fPs.aK(bwa);
            if (bwa != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bwa.size())}), 0);
                a2.ke(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aEK().aEL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvY() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.fPq.getUniqueId());
        this.fPq.aQU().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.fPr;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.fPv == null) {
            this.fPv = new h(getPageContext().getPageActivity(), new a());
        }
        this.fPv.setSubText(str);
        this.fPv.attachView(view, z);
        this.fPv.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.fPv != null) {
            this.fPv.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.euG.attachView(b.this.getView(), true);
            b.this.bvY();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
