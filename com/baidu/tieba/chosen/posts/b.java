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
/* loaded from: classes17.dex */
public class b extends c<ChosenPostActivity> {
    private g fMN;
    private NoNetworkView fXC;
    private NavigationBar fre;
    private h hoA;
    private ChosenPostActivity hov;
    private BdListView how;
    private com.baidu.tieba.chosen.posts.a hox;
    private com.baidu.tbadk.mvc.g.a hoy;
    private boolean hoz;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g ccJ() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.hov.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.hoz = false;
        this.hov = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bJD() {
        this.mRootView = this.hov.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccK() {
        this.paddingTop = this.hov.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.hov.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.fre = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.fre.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.fre.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.how = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.fXC = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.hox = new com.baidu.tieba.chosen.posts.a(this.hov.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.hov.btQ());
        this.how.setAdapter((ListAdapter) this.hox);
        this.mPullView = ccJ();
        this.how.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.hov.ccF().np(z);
            }
        });
        this.how.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.hox.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.how.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.zz(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.hox.getItem(i));
                        bVar.setUniqueId(b.this.hov.getUniqueId());
                        b.this.hov.btQ().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.hov.getPageContext());
                aVar.bhg();
                return true;
            }
        });
        this.how.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.hov.ccF().ccI();
                } else if (b.this.hoy != null) {
                    b.this.hoy.display();
                    b.this.hoy.qy(R.string.no_more_msg);
                }
            }
        });
        this.hoy = new com.baidu.tbadk.mvc.g.a(this.hov);
        this.hoy.createView();
        getListView().setNextPage(this.hoy);
        this.fMN = new g(getActivity());
        this.fMN.onChangeSkinType();
        this.fMN.attachView(getView(), true);
        this.hov.ccF().ccH();
    }

    public Activity getActivity() {
        return this.hov.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.btu()) {
            case 4097:
                this.hoz = false;
                break;
            case 4098:
                this.hoz = true;
                break;
            case 4099:
                a(bVar.btv());
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
            this.hox.ev(((Long) extra).longValue());
            if (this.hox.getCount() <= 5) {
                ccL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.fMN != null) {
            this.fMN.dettachView(getView());
        }
        if (errorData != null && this.hox.btM() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.how.completePullRefreshPostDelayed(0L);
        if (this.hoy != null) {
            this.hoy.qy(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fre != null) {
            this.fre.onChangeSkinType(tbPageContext, i);
        }
        if (this.hox != null) {
            this.hox.b(tbPageContext, i);
        }
        if (this.hoy != null) {
            this.hoy.b(tbPageContext, i);
        }
        if (this.fXC != null) {
            this.fXC.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.btK()) {
                this.hoy.display();
                if (aVar.btI()) {
                    this.hoy.qx(R.string.loading);
                } else if (!aVar.btJ()) {
                    this.hoy.qy(R.string.no_more_msg);
                }
            } else {
                this.hoy.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.how.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> ccN = ((com.baidu.tieba.chosen.posts.request.b) aVar).ccN();
            if (ccN != null && ccN.size() > 0) {
                this.how.setVisibility(0);
            }
            if (this.fMN != null) {
                this.fMN.dettachView(getView());
            }
            if (this.hoz) {
                this.hox.be(ccN);
                return;
            }
            this.hox.bf(ccN);
            if (ccN != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(ccN.size())}), 0);
                a2.nB(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.bhl().bhm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccL() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.hov.getUniqueId());
        this.hov.btQ().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.how;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.hoA == null) {
            this.hoA = new h(getPageContext().getPageActivity(), new a());
        }
        this.hoA.setSubText(str);
        this.hoA.attachView(view, z);
        this.hoA.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.hoA != null) {
            this.hoA.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.fMN.attachView(b.this.getView(), true);
            b.this.ccL();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
