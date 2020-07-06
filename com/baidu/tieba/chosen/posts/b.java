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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes10.dex */
public class b extends c<ChosenPostActivity> {
    private NoNetworkView fGj;
    private NavigationBar fbi;
    private g fwo;
    private ChosenPostActivity gVZ;
    private BdListView gWa;
    private com.baidu.tieba.chosen.posts.a gWb;
    private com.baidu.tbadk.mvc.g.a gWc;
    private boolean gWd;
    private h gWe;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g bPm() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.gVZ.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.gWd = false;
        this.gVZ = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bwS() {
        this.mRootView = this.gVZ.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPn() {
        this.paddingTop = this.gVZ.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.gVZ.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.fbi = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.fbi.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.fbi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gWa = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.fGj = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.gWb = new com.baidu.tieba.chosen.posts.a(this.gVZ.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.gVZ.bhs());
        this.gWa.setAdapter((ListAdapter) this.gWb);
        this.mPullView = bPm();
        this.gWa.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.gVZ.bPi().mh(z);
            }
        });
        this.gWa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.gWb.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.gWa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.we(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.gWb.getItem(i));
                        bVar.setUniqueId(b.this.gVZ.getUniqueId());
                        b.this.gVZ.bhs().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.gVZ.getPageContext());
                aVar.aUN();
                return true;
            }
        });
        this.gWa.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.gVZ.bPi().bPl();
                } else if (b.this.gWc != null) {
                    b.this.gWc.display();
                    b.this.gWc.nV(R.string.no_more_msg);
                }
            }
        });
        this.gWc = new com.baidu.tbadk.mvc.g.a(this.gVZ);
        this.gWc.createView();
        getListView().setNextPage(this.gWc);
        this.fwo = new g(getActivity());
        this.fwo.onChangeSkinType();
        this.fwo.attachView(getView(), true);
        this.gVZ.bPi().bPk();
    }

    public Activity getActivity() {
        return this.gVZ.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bgX()) {
            case 4097:
                this.gWd = false;
                break;
            case 4098:
                this.gWd = true;
                break;
            case 4099:
                a(bVar.bgY());
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
            this.gWb.dX(((Long) extra).longValue());
            if (this.gWb.getCount() <= 5) {
                bPo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.fwo != null) {
            this.fwo.dettachView(getView());
        }
        if (errorData != null && this.gWb.bhp() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.gWa.completePullRefreshPostDelayed(0L);
        if (this.gWc != null) {
            this.gWc.nV(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fbi != null) {
            this.fbi.onChangeSkinType(tbPageContext, i);
        }
        if (this.gWb != null) {
            this.gWb.b(tbPageContext, i);
        }
        if (this.gWc != null) {
            this.gWc.b(tbPageContext, i);
        }
        if (this.fGj != null) {
            this.fGj.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bhn()) {
                this.gWc.display();
                if (aVar.bhl()) {
                    this.gWc.nU(R.string.loading);
                } else if (!aVar.bhm()) {
                    this.gWc.nV(R.string.no_more_msg);
                }
            } else {
                this.gWc.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.gWa.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bPq = ((com.baidu.tieba.chosen.posts.request.b) aVar).bPq();
            if (bPq != null && bPq.size() > 0) {
                this.gWa.setVisibility(0);
            }
            if (this.fwo != null) {
                this.fwo.dettachView(getView());
            }
            if (this.gWd) {
                this.gWb.aY(bPq);
                return;
            }
            this.gWb.aZ(bPq);
            if (bPq != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bPq.size())}), 0);
                a2.lb(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aUR().aUS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPo() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.gVZ.getUniqueId());
        this.gVZ.bhs().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.gWa;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.gWe == null) {
            this.gWe = new h(getPageContext().getPageActivity(), new a());
        }
        this.gWe.setSubText(str);
        this.gWe.attachView(view, z);
        this.gWe.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.gWe != null) {
            this.gWe.dettachView(view);
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
            b.this.fwo.attachView(b.this.getView(), true);
            b.this.bPo();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
