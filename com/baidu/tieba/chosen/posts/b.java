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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class b extends c<ChosenPostActivity> {
    private g dDz;
    private NoNetworkView dIp;
    private NavigationBar djV;
    private ChosenPostActivity eUg;
    private BdListView eUh;
    private com.baidu.tieba.chosen.posts.a eUi;
    private com.baidu.tbadk.mvc.g.a eUj;
    private boolean eUk;
    private h eUl;
    int eUm;
    private i mPullView;
    private View mRootView;
    int paddingHorizontal;

    protected i bbK() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.eUg.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eUk = false;
        this.eUg = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aKW() {
        this.mRootView = this.eUg.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbL() {
        this.eUm = this.eUg.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.eUg.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.djV = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.djV.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.djV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUh = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.dIp = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.eUi = new com.baidu.tieba.chosen.posts.a(this.eUg.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.eUg.awv());
        this.eUh.setAdapter((ListAdapter) this.eUi);
        this.mPullView = bbK();
        this.eUh.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                b.this.eUg.bbF().iV(z);
            }
        });
        this.eUh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.eUi.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.eUh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.nn(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.eUi.getItem(i));
                        bVar.setUniqueId(b.this.eUg.getUniqueId());
                        b.this.eUg.awv().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.eUg.getPageContext());
                aVar.akM();
                return true;
            }
        });
        this.eUh.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.eUg.bbF().bbJ();
                } else if (b.this.eUj != null) {
                    b.this.eUj.le();
                    b.this.eUj.ke(R.string.no_more_msg);
                }
            }
        });
        this.eUj = new com.baidu.tbadk.mvc.g.a(this.eUg);
        this.eUj.createView();
        getListView().setNextPage(this.eUj);
        this.dDz = new g(getActivity());
        this.dDz.onChangeSkinType();
        this.dDz.attachView(getView(), true);
        this.eUg.bbF().bbI();
    }

    public Activity getActivity() {
        return this.eUg.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.avO()) {
            case 4097:
                this.eUk = false;
                break;
            case 4098:
                this.eUk = true;
                break;
            case 4099:
                a(bVar.avP());
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
            this.eUi.cy(((Long) extra).longValue());
            if (this.eUi.getCount() <= 5) {
                bbM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.dDz != null) {
            this.dDz.dettachView(getView());
        }
        if (errorData != null && this.eUi.aws() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.eUh.completePullRefreshPostDelayed(0L);
        if (this.eUj != null) {
            this.eUj.ke(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.djV != null) {
            this.djV.onChangeSkinType(tbPageContext, i);
        }
        if (this.eUi != null) {
            this.eUi.b(tbPageContext, i);
        }
        if (this.eUj != null) {
            this.eUj.b(tbPageContext, i);
        }
        if (this.dIp != null) {
            this.dIp.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.awq()) {
                this.eUj.le();
                if (aVar.awo()) {
                    this.eUj.kd(R.string.loading);
                } else if (!aVar.awp()) {
                    this.eUj.ke(R.string.no_more_msg);
                }
            } else {
                this.eUj.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.eUh.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bbO = ((com.baidu.tieba.chosen.posts.request.b) aVar).bbO();
            if (bbO != null && bbO.size() > 0) {
                this.eUh.setVisibility(0);
            }
            if (this.dDz != null) {
                this.dDz.dettachView(getView());
            }
            if (this.eUk) {
                this.eUi.aE(bbO);
                return;
            }
            this.eUi.aF(bbO);
            if (bbO != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bbO.size())}), 0);
                b.ib(48);
                b.setOffsetY(this.eUm);
                b.setPaddingHorizontal(this.paddingHorizontal);
                b.akQ().akR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.eUg.getUniqueId());
        this.eUg.awv().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.eUh;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eUl == null) {
            this.eUl = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eUl.setSubText(str);
        this.eUl.attachView(view, z);
        this.eUl.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eUl != null) {
            this.eUl.dettachView(view);
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
            b.this.dDz.attachView(b.this.getView(), true);
            b.this.bbM();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
