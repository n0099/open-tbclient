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
    private NoNetworkView eCl;
    private NavigationBar ecf;
    private g euk;
    private ChosenPostActivity fOI;
    private BdListView fOJ;
    private com.baidu.tieba.chosen.posts.a fOK;
    private com.baidu.tbadk.mvc.g.a fOL;
    private boolean fOM;
    private h fON;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.h bvR() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.fOI.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.fOM = false;
        this.fOI = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View beT() {
        this.mRootView = this.fOI.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bvS() {
        this.paddingTop = this.fOI.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.fOI.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.ecf = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.ecf.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.ecf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fOJ = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.eCl = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.fOK = new com.baidu.tieba.chosen.posts.a(this.fOI.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.fOI.aQQ());
        this.fOJ.setAdapter((ListAdapter) this.fOK);
        this.mPullView = bvR();
        this.fOJ.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                b.this.fOI.bvM().ku(z);
            }
        });
        this.fOJ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.fOK.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.fOJ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.fOK.getItem(i));
                        bVar.setUniqueId(b.this.fOI.getUniqueId());
                        b.this.fOI.aQQ().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.fOI.getPageContext());
                aVar.aEC();
                return true;
            }
        });
        this.fOJ.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.fOI.bvM().bvQ();
                } else if (b.this.fOL != null) {
                    b.this.fOL.display();
                    b.this.fOL.mJ(R.string.no_more_msg);
                }
            }
        });
        this.fOL = new com.baidu.tbadk.mvc.g.a(this.fOI);
        this.fOL.createView();
        getListView().setNextPage(this.fOL);
        this.euk = new com.baidu.tbadk.k.g(getActivity());
        this.euk.onChangeSkinType();
        this.euk.attachView(getView(), true);
        this.fOI.bvM().bvP();
    }

    public Activity getActivity() {
        return this.fOI.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aQo()) {
            case 4097:
                this.fOM = false;
                break;
            case 4098:
                this.fOM = true;
                break;
            case 4099:
                a(bVar.aQp());
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
            this.fOK.dl(((Long) extra).longValue());
            if (this.fOK.getCount() <= 5) {
                bvT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.euk != null) {
            this.euk.dettachView(getView());
        }
        if (errorData != null && this.fOK.aQN() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.fOJ.completePullRefreshPostDelayed(0L);
        if (this.fOL != null) {
            this.fOL.mJ(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.ecf != null) {
            this.ecf.onChangeSkinType(tbPageContext, i);
        }
        if (this.fOK != null) {
            this.fOK.b(tbPageContext, i);
        }
        if (this.fOL != null) {
            this.fOL.b(tbPageContext, i);
        }
        if (this.eCl != null) {
            this.eCl.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aQL()) {
                this.fOL.display();
                if (aVar.aQJ()) {
                    this.fOL.mI(R.string.loading);
                } else if (!aVar.aQK()) {
                    this.fOL.mJ(R.string.no_more_msg);
                }
            } else {
                this.fOL.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.fOJ.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bvV = ((com.baidu.tieba.chosen.posts.request.b) aVar).bvV();
            if (bvV != null && bvV.size() > 0) {
                this.fOJ.setVisibility(0);
            }
            if (this.euk != null) {
                this.euk.dettachView(getView());
            }
            if (this.fOM) {
                this.fOK.aJ(bvV);
                return;
            }
            this.fOK.aK(bvV);
            if (bvV != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bvV.size())}), 0);
                a2.ke(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aEG().aEH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvT() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.fOI.getUniqueId());
        this.fOI.aQQ().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.fOJ;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.fON == null) {
            this.fON = new h(getPageContext().getPageActivity(), new a());
        }
        this.fON.setSubText(str);
        this.fON.attachView(view, z);
        this.fON.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.fON != null) {
            this.fON.dettachView(view);
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
            b.this.euk.attachView(b.this.getView(), true);
            b.this.bvT();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
