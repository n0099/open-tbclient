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
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes23.dex */
public class b extends c<ChosenPostActivity> {
    private g gAe;
    private NoNetworkView gLI;
    private NavigationBar gcG;
    private ChosenPostActivity ioF;
    private BdListView ioG;
    private com.baidu.tieba.chosen.posts.a ioH;
    private com.baidu.tbadk.mvc.g.a ioI;
    private boolean ioJ;
    private h ioK;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g csR() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.ioF.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.ioJ = false;
        this.ioF = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVG() {
        this.mRootView = this.ioF.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void csS() {
        this.paddingTop = this.ioF.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.ioF.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.gcG = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.gcG.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.gcG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ioG = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gLI = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.ioH = new com.baidu.tieba.chosen.posts.a(this.ioF.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.ioF.bEP());
        this.ioG.setAdapter((ListAdapter) this.ioH);
        this.mPullView = csR();
        this.ioG.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.ioF.csN().pc(z);
            }
        });
        this.ioG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.ioH.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.ioG.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.Bq(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.ioH.getItem(i));
                        bVar.setUniqueId(b.this.ioF.getUniqueId());
                        b.this.ioF.bEP().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.ioF.getPageContext());
                aVar.brv();
                return true;
            }
        });
        this.ioG.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.ioF.csN().csQ();
                } else if (b.this.ioI != null) {
                    b.this.ioI.su();
                    b.this.ioI.sH(R.string.no_more_msg);
                }
            }
        });
        this.ioI = new com.baidu.tbadk.mvc.g.a(this.ioF);
        this.ioI.createView();
        getListView().setNextPage(this.ioI);
        this.gAe = new g(getActivity());
        this.gAe.onChangeSkinType();
        this.gAe.attachView(getView(), true);
        this.ioF.csN().csP();
    }

    public Activity getActivity() {
        return this.ioF.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bEt()) {
            case 4097:
                this.ioJ = false;
                break;
            case 4098:
                this.ioJ = true;
                break;
            case 4099:
                a(bVar.bEu());
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
            this.ioH.ga(((Long) extra).longValue());
            if (this.ioH.getCount() <= 5) {
                csT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gAe != null) {
            this.gAe.dettachView(getView());
        }
        if (errorData != null && this.ioH.bEL() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.ioG.completePullRefreshPostDelayed(0L);
        if (this.ioI != null) {
            this.ioI.sH(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gcG != null) {
            this.gcG.onChangeSkinType(tbPageContext, i);
        }
        if (this.ioH != null) {
            this.ioH.b(tbPageContext, i);
        }
        if (this.ioI != null) {
            this.ioI.b(tbPageContext, i);
        }
        if (this.gLI != null) {
            this.gLI.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bEJ()) {
                this.ioI.su();
                if (aVar.bEH()) {
                    this.ioI.sG(R.string.loading);
                } else if (!aVar.bEI()) {
                    this.ioI.sH(R.string.no_more_msg);
                }
            } else {
                this.ioI.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.ioG.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> csV = ((com.baidu.tieba.chosen.posts.request.b) aVar).csV();
            if (csV != null && csV.size() > 0) {
                this.ioG.setVisibility(0);
            }
            if (this.gAe != null) {
                this.gAe.dettachView(getView());
            }
            if (this.ioJ) {
                this.ioH.bF(csV);
                return;
            }
            this.ioH.bG(csV);
            if (csV != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(csV.size())}), 0);
                a2.oZ(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.brA().brB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csT() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.ioF.getUniqueId());
        this.ioF.bEP().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.ioG;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.ioK == null) {
            this.ioK = new h(getPageContext().getPageActivity(), new a());
        }
        this.ioK.setSubText(str);
        this.ioK.attachView(view, z);
        this.ioK.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.ioK != null) {
            this.ioK.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.gAe.attachView(b.this.getView(), true);
            b.this.csT();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
