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
    private NoNetworkView eBY;
    private NavigationBar ebS;
    private g etX;
    private h fOA;
    private ChosenPostActivity fOv;
    private BdListView fOw;
    private com.baidu.tieba.chosen.posts.a fOx;
    private com.baidu.tbadk.mvc.g.a fOy;
    private boolean fOz;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.h bvQ() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.fOv.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.fOz = false;
        this.fOv = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View beS() {
        this.mRootView = this.fOv.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bvR() {
        this.paddingTop = this.fOv.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.fOv.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.ebS = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.ebS.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.ebS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fOw = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.eBY = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.fOx = new com.baidu.tieba.chosen.posts.a(this.fOv.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.fOv.aQP());
        this.fOw.setAdapter((ListAdapter) this.fOx);
        this.mPullView = bvQ();
        this.fOw.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                b.this.fOv.bvL().ku(z);
            }
        });
        this.fOw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.fOx.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.fOw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.sS(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.fOx.getItem(i));
                        bVar.setUniqueId(b.this.fOv.getUniqueId());
                        b.this.fOv.aQP().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.fOv.getPageContext());
                aVar.aEC();
                return true;
            }
        });
        this.fOw.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.fOv.bvL().bvP();
                } else if (b.this.fOy != null) {
                    b.this.fOy.display();
                    b.this.fOy.mJ(R.string.no_more_msg);
                }
            }
        });
        this.fOy = new com.baidu.tbadk.mvc.g.a(this.fOv);
        this.fOy.createView();
        getListView().setNextPage(this.fOy);
        this.etX = new com.baidu.tbadk.k.g(getActivity());
        this.etX.onChangeSkinType();
        this.etX.attachView(getView(), true);
        this.fOv.bvL().bvO();
    }

    public Activity getActivity() {
        return this.fOv.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aQn()) {
            case 4097:
                this.fOz = false;
                break;
            case 4098:
                this.fOz = true;
                break;
            case 4099:
                a(bVar.aQo());
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
            this.fOx.dl(((Long) extra).longValue());
            if (this.fOx.getCount() <= 5) {
                bvS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.etX != null) {
            this.etX.dettachView(getView());
        }
        if (errorData != null && this.fOx.aQM() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.fOw.completePullRefreshPostDelayed(0L);
        if (this.fOy != null) {
            this.fOy.mJ(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.ebS != null) {
            this.ebS.onChangeSkinType(tbPageContext, i);
        }
        if (this.fOx != null) {
            this.fOx.b(tbPageContext, i);
        }
        if (this.fOy != null) {
            this.fOy.b(tbPageContext, i);
        }
        if (this.eBY != null) {
            this.eBY.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aQK()) {
                this.fOy.display();
                if (aVar.aQI()) {
                    this.fOy.mI(R.string.loading);
                } else if (!aVar.aQJ()) {
                    this.fOy.mJ(R.string.no_more_msg);
                }
            } else {
                this.fOy.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.fOw.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bvU = ((com.baidu.tieba.chosen.posts.request.b) aVar).bvU();
            if (bvU != null && bvU.size() > 0) {
                this.fOw.setVisibility(0);
            }
            if (this.etX != null) {
                this.etX.dettachView(getView());
            }
            if (this.fOz) {
                this.fOx.aJ(bvU);
                return;
            }
            this.fOx.aK(bvU);
            if (bvU != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bvU.size())}), 0);
                a2.ke(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aEG().aEH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvS() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.fOv.getUniqueId());
        this.fOv.aQP().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.fOw;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.fOA == null) {
            this.fOA = new h(getPageContext().getPageActivity(), new a());
        }
        this.fOA.setSubText(str);
        this.fOA.attachView(view, z);
        this.fOA.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.fOA != null) {
            this.fOA.dettachView(view);
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
            b.this.etX.attachView(b.this.getView(), true);
            b.this.bvS();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
