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
    private NavigationBar fUw;
    private NoNetworkView gCL;
    private g grV;
    private ChosenPostActivity idL;
    private BdListView idM;
    private com.baidu.tieba.chosen.posts.a idN;
    private com.baidu.tbadk.mvc.g.a idO;
    private boolean idP;
    private h idQ;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g coE() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.idL.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.idP = false;
        this.idL = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bRW() {
        this.mRootView = this.idL.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void coF() {
        this.paddingTop = this.idL.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.idL.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.fUw = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.fUw.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.fUw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.idM = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gCL = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.idN = new com.baidu.tieba.chosen.posts.a(this.idL.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.idL.bBn());
        this.idM.setAdapter((ListAdapter) this.idN);
        this.mPullView = coE();
        this.idM.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.idL.coA().oG(z);
            }
        });
        this.idM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.idN.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.idM.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.AJ(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.idN.getItem(i));
                        bVar.setUniqueId(b.this.idL.getUniqueId());
                        b.this.idL.bBn().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.idL.getPageContext());
                aVar.bog();
                return true;
            }
        });
        this.idM.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.idL.coA().coD();
                } else if (b.this.idO != null) {
                    b.this.idO.display();
                    b.this.idO.sg(R.string.no_more_msg);
                }
            }
        });
        this.idO = new com.baidu.tbadk.mvc.g.a(this.idL);
        this.idO.createView();
        getListView().setNextPage(this.idO);
        this.grV = new g(getActivity());
        this.grV.onChangeSkinType();
        this.grV.attachView(getView(), true);
        this.idL.coA().coC();
    }

    public Activity getActivity() {
        return this.idL.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bAR()) {
            case 4097:
                this.idP = false;
                break;
            case 4098:
                this.idP = true;
                break;
            case 4099:
                a(bVar.bAS());
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
            this.idN.fw(((Long) extra).longValue());
            if (this.idN.getCount() <= 5) {
                coG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.grV != null) {
            this.grV.dettachView(getView());
        }
        if (errorData != null && this.idN.bBj() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.idM.completePullRefreshPostDelayed(0L);
        if (this.idO != null) {
            this.idO.sg(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fUw != null) {
            this.fUw.onChangeSkinType(tbPageContext, i);
        }
        if (this.idN != null) {
            this.idN.b(tbPageContext, i);
        }
        if (this.idO != null) {
            this.idO.b(tbPageContext, i);
        }
        if (this.gCL != null) {
            this.gCL.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bBh()) {
                this.idO.display();
                if (aVar.bBf()) {
                    this.idO.sf(R.string.loading);
                } else if (!aVar.bBg()) {
                    this.idO.sg(R.string.no_more_msg);
                }
            } else {
                this.idO.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.idM.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> coI = ((com.baidu.tieba.chosen.posts.request.b) aVar).coI();
            if (coI != null && coI.size() > 0) {
                this.idM.setVisibility(0);
            }
            if (this.grV != null) {
                this.grV.dettachView(getView());
            }
            if (this.idP) {
                this.idN.bB(coI);
                return;
            }
            this.idN.bC(coI);
            if (coI != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(coI.size())}), 0);
                a2.oB(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.bol().bom();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coG() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.idL.getUniqueId());
        this.idL.bBn().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.idM;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.idQ == null) {
            this.idQ = new h(getPageContext().getPageActivity(), new a());
        }
        this.idQ.setSubText(str);
        this.idQ.attachView(view, z);
        this.idQ.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.idQ != null) {
            this.idQ.dettachView(view);
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
            b.this.grV.attachView(b.this.getView(), true);
            b.this.coG();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
