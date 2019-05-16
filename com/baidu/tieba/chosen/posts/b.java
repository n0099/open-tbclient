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
    private NavigationBar cXY;
    private g dhX;
    private NoNetworkView dyP;
    private ChosenPostActivity eFE;
    private BdListView eFF;
    private com.baidu.tieba.chosen.posts.a eFG;
    private com.baidu.tbadk.mvc.g.a eFH;
    private boolean eFI;
    private h eFJ;
    private i mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected i aYZ() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.eFE.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eFI = false;
        this.eFE = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aJF() {
        this.mRootView = this.eFE.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aZa() {
        this.paddingTop = this.eFE.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.eFE.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.cXY = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.cXY.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.cXY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eFF = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.dyP = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.eFG = new com.baidu.tieba.chosen.posts.a(this.eFE.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.eFE.atK());
        this.eFF.setAdapter((ListAdapter) this.eFG);
        this.mPullView = aYZ();
        this.eFF.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                b.this.eFE.aYU().iG(z);
            }
        });
        this.eFF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.eFG.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.eFF.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.mE(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.eFG.getItem(i));
                        bVar.setUniqueId(b.this.eFE.getUniqueId());
                        b.this.eFE.atK().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.eFE.getPageContext());
                aVar.afG();
                return true;
            }
        });
        this.eFF.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.ki()) {
                    b.this.eFE.aYU().aYY();
                } else if (b.this.eFH != null) {
                    b.this.eFH.pO();
                    b.this.eFH.kI(R.string.no_more_msg);
                }
            }
        });
        this.eFH = new com.baidu.tbadk.mvc.g.a(this.eFE);
        this.eFH.nG();
        getListView().setNextPage(this.eFH);
        this.dhX = new g(getActivity());
        this.dhX.onChangeSkinType();
        this.dhX.attachView(getView(), true);
        this.eFE.aYU().aYX();
    }

    public Activity getActivity() {
        return this.eFE.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.atb()) {
            case 4097:
                this.eFI = false;
                break;
            case 4098:
                this.eFI = true;
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
            this.eFG.cD(((Long) extra).longValue());
            if (this.eFG.getCount() <= 5) {
                aZb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.dhX != null) {
            this.dhX.dettachView(getView());
        }
        if (errorData != null && this.eFG.atG() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.eFF.completePullRefreshPostDelayed(0L);
        if (this.eFH != null) {
            this.eFH.kI(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cXY != null) {
            this.cXY.onChangeSkinType(tbPageContext, i);
        }
        if (this.eFG != null) {
            this.eFG.b(tbPageContext, i);
        }
        if (this.eFH != null) {
            this.eFH.b(tbPageContext, i);
        }
        if (this.dyP != null) {
            this.dyP.onChangeSkinType(tbPageContext, i);
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
                this.eFH.pO();
                if (aVar.atC()) {
                    this.eFH.kH(R.string.loading);
                } else if (!aVar.atD()) {
                    this.eFH.kI(R.string.no_more_msg);
                }
            } else {
                this.eFH.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.eFF.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> aZd = ((com.baidu.tieba.chosen.posts.request.b) aVar).aZd();
            if (aZd != null && aZd.size() > 0) {
                this.eFF.setVisibility(0);
            }
            if (this.dhX != null) {
                this.dhX.dettachView(getView());
            }
            if (this.eFI) {
                this.eFG.ak(aZd);
                return;
            }
            this.eFG.al(aZd);
            if (aZd != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(aZd.size())}), 0);
                b.hA(48);
                b.setOffsetY(this.paddingTop);
                b.hy(this.paddingHorizontal);
                b.afM().afO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZb() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.eFE.getUniqueId());
        this.eFE.atK().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.eFF;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eFJ == null) {
            this.eFJ = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eFJ.qx(str);
        this.eFJ.attachView(view, z);
        this.eFJ.asB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eFJ != null) {
            this.eFJ.dettachView(view);
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
            b.this.dhX.attachView(b.this.getView(), true);
            b.this.aZb();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
