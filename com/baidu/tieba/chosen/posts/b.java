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
    private NoNetworkView eBX;
    private NavigationBar ebR;
    private g etW;
    private ChosenPostActivity fOt;
    private BdListView fOu;
    private com.baidu.tieba.chosen.posts.a fOv;
    private com.baidu.tbadk.mvc.g.a fOw;
    private boolean fOx;
    private h fOy;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.h bvO() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.fOt.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.fOx = false;
        this.fOt = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View beQ() {
        this.mRootView = this.fOt.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bvP() {
        this.paddingTop = this.fOt.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.fOt.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.ebR = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.ebR.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.ebR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fOu = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.eBX = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.fOv = new com.baidu.tieba.chosen.posts.a(this.fOt.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.fOt.aQN());
        this.fOu.setAdapter((ListAdapter) this.fOv);
        this.mPullView = bvO();
        this.fOu.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                b.this.fOt.bvJ().ku(z);
            }
        });
        this.fOu.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.fOv.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.fOu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.fOv.getItem(i));
                        bVar.setUniqueId(b.this.fOt.getUniqueId());
                        b.this.fOt.aQN().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.fOt.getPageContext());
                aVar.aEA();
                return true;
            }
        });
        this.fOu.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.fOt.bvJ().bvN();
                } else if (b.this.fOw != null) {
                    b.this.fOw.display();
                    b.this.fOw.mJ(R.string.no_more_msg);
                }
            }
        });
        this.fOw = new com.baidu.tbadk.mvc.g.a(this.fOt);
        this.fOw.createView();
        getListView().setNextPage(this.fOw);
        this.etW = new com.baidu.tbadk.k.g(getActivity());
        this.etW.onChangeSkinType();
        this.etW.attachView(getView(), true);
        this.fOt.bvJ().bvM();
    }

    public Activity getActivity() {
        return this.fOt.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aQl()) {
            case 4097:
                this.fOx = false;
                break;
            case 4098:
                this.fOx = true;
                break;
            case 4099:
                a(bVar.aQm());
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
            this.fOv.dl(((Long) extra).longValue());
            if (this.fOv.getCount() <= 5) {
                bvQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.etW != null) {
            this.etW.dettachView(getView());
        }
        if (errorData != null && this.fOv.aQK() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.fOu.completePullRefreshPostDelayed(0L);
        if (this.fOw != null) {
            this.fOw.mJ(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.ebR != null) {
            this.ebR.onChangeSkinType(tbPageContext, i);
        }
        if (this.fOv != null) {
            this.fOv.b(tbPageContext, i);
        }
        if (this.fOw != null) {
            this.fOw.b(tbPageContext, i);
        }
        if (this.eBX != null) {
            this.eBX.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aQI()) {
                this.fOw.display();
                if (aVar.aQG()) {
                    this.fOw.mI(R.string.loading);
                } else if (!aVar.aQH()) {
                    this.fOw.mJ(R.string.no_more_msg);
                }
            } else {
                this.fOw.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.fOu.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bvS = ((com.baidu.tieba.chosen.posts.request.b) aVar).bvS();
            if (bvS != null && bvS.size() > 0) {
                this.fOu.setVisibility(0);
            }
            if (this.etW != null) {
                this.etW.dettachView(getView());
            }
            if (this.fOx) {
                this.fOv.aJ(bvS);
                return;
            }
            this.fOv.aK(bvS);
            if (bvS != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bvS.size())}), 0);
                a2.ke(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aEE().aEF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvQ() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.fOt.getUniqueId());
        this.fOt.aQN().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.fOu;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.fOy == null) {
            this.fOy = new h(getPageContext().getPageActivity(), new a());
        }
        this.fOy.setSubText(str);
        this.fOy.attachView(view, z);
        this.fOy.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.fOy != null) {
            this.fOy.dettachView(view);
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
            b.this.etW.attachView(b.this.getView(), true);
            b.this.bvQ();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
