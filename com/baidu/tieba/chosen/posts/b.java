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
/* loaded from: classes23.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar fGE;
    private g gcx;
    private NoNetworkView gnl;
    private com.baidu.tieba.chosen.posts.a hKA;
    private com.baidu.tbadk.mvc.g.a hKB;
    private boolean hKC;
    private h hKD;
    private ChosenPostActivity hKy;
    private BdListView hKz;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g cjv() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.hKy.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.hKC = false;
        this.hKy = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bNy() {
        this.mRootView = this.hKy.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cjw() {
        this.paddingTop = this.hKy.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.hKy.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.fGE = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.fGE.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.fGE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hKz = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gnl = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.hKA = new com.baidu.tieba.chosen.posts.a(this.hKy.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.hKy.bxF());
        this.hKz.setAdapter((ListAdapter) this.hKA);
        this.mPullView = cjv();
        this.hKz.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.hKy.cjr().oc(z);
            }
        });
        this.hKz.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.hKA.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.hKz.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.AH(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.hKA.getItem(i));
                        bVar.setUniqueId(b.this.hKy.getUniqueId());
                        b.this.hKy.bxF().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.hKy.getPageContext());
                aVar.bkJ();
                return true;
            }
        });
        this.hKz.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.hKy.cjr().cju();
                } else if (b.this.hKB != null) {
                    b.this.hKB.display();
                    b.this.hKB.rn(R.string.no_more_msg);
                }
            }
        });
        this.hKB = new com.baidu.tbadk.mvc.g.a(this.hKy);
        this.hKB.createView();
        getListView().setNextPage(this.hKB);
        this.gcx = new g(getActivity());
        this.gcx.onChangeSkinType();
        this.gcx.attachView(getView(), true);
        this.hKy.cjr().cjt();
    }

    public Activity getActivity() {
        return this.hKy.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bxj()) {
            case 4097:
                this.hKC = false;
                break;
            case 4098:
                this.hKC = true;
                break;
            case 4099:
                a(bVar.bxk());
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
            this.hKA.eW(((Long) extra).longValue());
            if (this.hKA.getCount() <= 5) {
                cjx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gcx != null) {
            this.gcx.dettachView(getView());
        }
        if (errorData != null && this.hKA.bxB() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.hKz.completePullRefreshPostDelayed(0L);
        if (this.hKB != null) {
            this.hKB.rn(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fGE != null) {
            this.fGE.onChangeSkinType(tbPageContext, i);
        }
        if (this.hKA != null) {
            this.hKA.b(tbPageContext, i);
        }
        if (this.hKB != null) {
            this.hKB.b(tbPageContext, i);
        }
        if (this.gnl != null) {
            this.gnl.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bxz()) {
                this.hKB.display();
                if (aVar.bxx()) {
                    this.hKB.rm(R.string.loading);
                } else if (!aVar.bxy()) {
                    this.hKB.rn(R.string.no_more_msg);
                }
            } else {
                this.hKB.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.hKz.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> cjz = ((com.baidu.tieba.chosen.posts.request.b) aVar).cjz();
            if (cjz != null && cjz.size() > 0) {
                this.hKz.setVisibility(0);
            }
            if (this.gcx != null) {
                this.gcx.dettachView(getView());
            }
            if (this.hKC) {
                this.hKA.bl(cjz);
                return;
            }
            this.hKA.bm(cjz);
            if (cjz != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(cjz.size())}), 0);
                a2.ok(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.bkO().bkP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjx() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.hKy.getUniqueId());
        this.hKy.bxF().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.hKz;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.hKD == null) {
            this.hKD = new h(getPageContext().getPageActivity(), new a());
        }
        this.hKD.setSubText(str);
        this.hKD.attachView(view, z);
        this.hKD.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.hKD != null) {
            this.hKD.dettachView(view);
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
            b.this.gcx.attachView(b.this.getView(), true);
            b.this.cjx();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
