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
    private g gAg;
    private NoNetworkView gLK;
    private NavigationBar gcI;
    private ChosenPostActivity ioH;
    private BdListView ioI;
    private com.baidu.tieba.chosen.posts.a ioJ;
    private com.baidu.tbadk.mvc.g.a ioK;
    private boolean ioL;
    private h ioM;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g csS() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.ioH.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.ioL = false;
        this.ioH = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVH() {
        this.mRootView = this.ioH.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void csT() {
        this.paddingTop = this.ioH.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.ioH.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.gcI = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.gcI.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.gcI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ioI = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gLK = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.ioJ = new com.baidu.tieba.chosen.posts.a(this.ioH.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.ioH.bEP());
        this.ioI.setAdapter((ListAdapter) this.ioJ);
        this.mPullView = csS();
        this.ioI.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.ioH.csO().pc(z);
            }
        });
        this.ioI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.ioJ.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.ioI.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.ioJ.getItem(i));
                        bVar.setUniqueId(b.this.ioH.getUniqueId());
                        b.this.ioH.bEP().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.ioH.getPageContext());
                aVar.brv();
                return true;
            }
        });
        this.ioI.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.ioH.csO().csR();
                } else if (b.this.ioK != null) {
                    b.this.ioK.su();
                    b.this.ioK.sH(R.string.no_more_msg);
                }
            }
        });
        this.ioK = new com.baidu.tbadk.mvc.g.a(this.ioH);
        this.ioK.createView();
        getListView().setNextPage(this.ioK);
        this.gAg = new g(getActivity());
        this.gAg.onChangeSkinType();
        this.gAg.attachView(getView(), true);
        this.ioH.csO().csQ();
    }

    public Activity getActivity() {
        return this.ioH.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bEt()) {
            case 4097:
                this.ioL = false;
                break;
            case 4098:
                this.ioL = true;
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
            this.ioJ.ga(((Long) extra).longValue());
            if (this.ioJ.getCount() <= 5) {
                csU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gAg != null) {
            this.gAg.dettachView(getView());
        }
        if (errorData != null && this.ioJ.bEL() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.ioI.completePullRefreshPostDelayed(0L);
        if (this.ioK != null) {
            this.ioK.sH(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gcI != null) {
            this.gcI.onChangeSkinType(tbPageContext, i);
        }
        if (this.ioJ != null) {
            this.ioJ.b(tbPageContext, i);
        }
        if (this.ioK != null) {
            this.ioK.b(tbPageContext, i);
        }
        if (this.gLK != null) {
            this.gLK.onChangeSkinType(tbPageContext, i);
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
                this.ioK.su();
                if (aVar.bEH()) {
                    this.ioK.sG(R.string.loading);
                } else if (!aVar.bEI()) {
                    this.ioK.sH(R.string.no_more_msg);
                }
            } else {
                this.ioK.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.ioI.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> csW = ((com.baidu.tieba.chosen.posts.request.b) aVar).csW();
            if (csW != null && csW.size() > 0) {
                this.ioI.setVisibility(0);
            }
            if (this.gAg != null) {
                this.gAg.dettachView(getView());
            }
            if (this.ioL) {
                this.ioJ.bF(csW);
                return;
            }
            this.ioJ.bG(csW);
            if (csW != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(csW.size())}), 0);
                a2.oZ(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.brA().brB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csU() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.ioH.getUniqueId());
        this.ioH.bEP().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.ioI;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.ioM == null) {
            this.ioM = new h(getPageContext().getPageActivity(), new a());
        }
        this.ioM.setSubText(str);
        this.ioM.attachView(view, z);
        this.ioM.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.ioM != null) {
            this.ioM.dettachView(view);
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
            b.this.gAg.attachView(b.this.getView(), true);
            b.this.csU();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
