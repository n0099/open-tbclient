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
/* loaded from: classes22.dex */
public class b extends c<ChosenPostActivity> {
    private g fQf;
    private NavigationBar fuv;
    private NoNetworkView gaU;
    private ChosenPostActivity hvD;
    private BdListView hvE;
    private com.baidu.tieba.chosen.posts.a hvF;
    private com.baidu.tbadk.mvc.g.a hvG;
    private boolean hvH;
    private h hvI;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g cfZ() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.hvD.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.hvH = false;
        this.hvD = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bKO() {
        this.mRootView = this.hvD.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cga() {
        this.paddingTop = this.hvD.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.hvD.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.fuv = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.fuv.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.fuv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hvE = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gaU = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.hvF = new com.baidu.tieba.chosen.posts.a(this.hvD.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.hvD.buV());
        this.hvE.setAdapter((ListAdapter) this.hvF);
        this.mPullView = cfZ();
        this.hvE.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.hvD.cfV().nx(z);
            }
        });
        this.hvE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.hvF.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.hvE.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.zV(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.hvF.getItem(i));
                        bVar.setUniqueId(b.this.hvD.getUniqueId());
                        b.this.hvD.buV().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.hvD.getPageContext());
                aVar.bia();
                return true;
            }
        });
        this.hvE.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.hvD.cfV().cfY();
                } else if (b.this.hvG != null) {
                    b.this.hvG.display();
                    b.this.hvG.qP(R.string.no_more_msg);
                }
            }
        });
        this.hvG = new com.baidu.tbadk.mvc.g.a(this.hvD);
        this.hvG.createView();
        getListView().setNextPage(this.hvG);
        this.fQf = new g(getActivity());
        this.fQf.onChangeSkinType();
        this.fQf.attachView(getView(), true);
        this.hvD.cfV().cfX();
    }

    public Activity getActivity() {
        return this.hvD.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.buz()) {
            case 4097:
                this.hvH = false;
                break;
            case 4098:
                this.hvH = true;
                break;
            case 4099:
                a(bVar.buA());
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
            this.hvF.eF(((Long) extra).longValue());
            if (this.hvF.getCount() <= 5) {
                cgb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.fQf != null) {
            this.fQf.dettachView(getView());
        }
        if (errorData != null && this.hvF.buR() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.hvE.completePullRefreshPostDelayed(0L);
        if (this.hvG != null) {
            this.hvG.qP(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fuv != null) {
            this.fuv.onChangeSkinType(tbPageContext, i);
        }
        if (this.hvF != null) {
            this.hvF.b(tbPageContext, i);
        }
        if (this.hvG != null) {
            this.hvG.b(tbPageContext, i);
        }
        if (this.gaU != null) {
            this.gaU.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.buP()) {
                this.hvG.display();
                if (aVar.buN()) {
                    this.hvG.qO(R.string.loading);
                } else if (!aVar.buO()) {
                    this.hvG.qP(R.string.no_more_msg);
                }
            } else {
                this.hvG.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.hvE.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> cgd = ((com.baidu.tieba.chosen.posts.request.b) aVar).cgd();
            if (cgd != null && cgd.size() > 0) {
                this.hvE.setVisibility(0);
            }
            if (this.fQf != null) {
                this.fQf.dettachView(getView());
            }
            if (this.hvH) {
                this.hvF.bi(cgd);
                return;
            }
            this.hvF.bj(cgd);
            if (cgd != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(cgd.size())}), 0);
                a2.nN(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.bif().big();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgb() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.hvD.getUniqueId());
        this.hvD.buV().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.hvE;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.hvI == null) {
            this.hvI = new h(getPageContext().getPageActivity(), new a());
        }
        this.hvI.setSubText(str);
        this.hvI.attachView(view, z);
        this.hvI.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.hvI != null) {
            this.hvI.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.fQf.attachView(b.this.getView(), true);
            b.this.cgb();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
