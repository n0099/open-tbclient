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
    private NavigationBar cYa;
    private g dhY;
    private NoNetworkView dyQ;
    private ChosenPostActivity eFF;
    private BdListView eFG;
    private com.baidu.tieba.chosen.posts.a eFH;
    private com.baidu.tbadk.mvc.g.a eFI;
    private boolean eFJ;
    private h eFK;
    private i mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected i aZc() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.eFF.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eFJ = false;
        this.eFF = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aJI() {
        this.mRootView = this.eFF.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZd() {
        this.paddingTop = this.eFF.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.eFF.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.cYa = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.cYa.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.cYa.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eFG = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.dyQ = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.eFH = new com.baidu.tieba.chosen.posts.a(this.eFF.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.eFF.atK());
        this.eFG.setAdapter((ListAdapter) this.eFH);
        this.mPullView = aZc();
        this.eFG.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                b.this.eFF.aYX().iG(z);
            }
        });
        this.eFG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.eFH.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.eFG.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.mD(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.eFH.getItem(i));
                        bVar.setUniqueId(b.this.eFF.getUniqueId());
                        b.this.eFF.atK().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.eFF.getPageContext());
                aVar.afG();
                return true;
            }
        });
        this.eFG.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.ki()) {
                    b.this.eFF.aYX().aZb();
                } else if (b.this.eFI != null) {
                    b.this.eFI.pO();
                    b.this.eFI.kI(R.string.no_more_msg);
                }
            }
        });
        this.eFI = new com.baidu.tbadk.mvc.g.a(this.eFF);
        this.eFI.nG();
        getListView().setNextPage(this.eFI);
        this.dhY = new g(getActivity());
        this.dhY.onChangeSkinType();
        this.dhY.attachView(getView(), true);
        this.eFF.aYX().aZa();
    }

    public Activity getActivity() {
        return this.eFF.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.atb()) {
            case 4097:
                this.eFJ = false;
                break;
            case 4098:
                this.eFJ = true;
                break;
            case 4099:
                a(bVar.atc());
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
            this.eFH.cD(((Long) extra).longValue());
            if (this.eFH.getCount() <= 5) {
                aZe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.dhY != null) {
            this.dhY.dettachView(getView());
        }
        if (errorData != null && this.eFH.atG() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.eFG.completePullRefreshPostDelayed(0L);
        if (this.eFI != null) {
            this.eFI.kI(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cYa != null) {
            this.cYa.onChangeSkinType(tbPageContext, i);
        }
        if (this.eFH != null) {
            this.eFH.b(tbPageContext, i);
        }
        if (this.eFI != null) {
            this.eFI.b(tbPageContext, i);
        }
        if (this.dyQ != null) {
            this.dyQ.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.atE()) {
                this.eFI.pO();
                if (aVar.atC()) {
                    this.eFI.kH(R.string.loading);
                } else if (!aVar.atD()) {
                    this.eFI.kI(R.string.no_more_msg);
                }
            } else {
                this.eFI.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.eFG.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> aZg = ((com.baidu.tieba.chosen.posts.request.b) aVar).aZg();
            if (aZg != null && aZg.size() > 0) {
                this.eFG.setVisibility(0);
            }
            if (this.dhY != null) {
                this.dhY.dettachView(getView());
            }
            if (this.eFJ) {
                this.eFH.ak(aZg);
                return;
            }
            this.eFH.al(aZg);
            if (aZg != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(aZg.size())}), 0);
                b.hA(48);
                b.setOffsetY(this.paddingTop);
                b.hy(this.paddingHorizontal);
                b.afM().afO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZe() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.eFF.getUniqueId());
        this.eFF.atK().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.eFG;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eFK == null) {
            this.eFK = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eFK.qw(str);
        this.eFK.attachView(view, z);
        this.eFK.asB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eFK != null) {
            this.eFK.dettachView(view);
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
            b.this.dhY.attachView(b.this.getView(), true);
            b.this.aZe();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
