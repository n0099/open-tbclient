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
    private g dEq;
    private NoNetworkView dJg;
    private NavigationBar dkM;
    private ChosenPostActivity eUX;
    private BdListView eUY;
    private com.baidu.tieba.chosen.posts.a eUZ;
    private com.baidu.tbadk.mvc.g.a eVa;
    private boolean eVb;
    private h eVc;
    int eVd;
    private i mPullView;
    private View mRootView;
    int paddingHorizontal;

    protected i bbM() {
        if (this.mPullView == null) {
            this.mPullView = new i(this.eUX.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.eVb = false;
        this.eUX = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aKY() {
        this.mRootView = this.eUX.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bbN() {
        this.eVd = this.eUX.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.eUX.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.dkM = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.dkM.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.dkM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eUY = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.dJg = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.eUZ = new com.baidu.tieba.chosen.posts.a(this.eUX.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.eUX.awx());
        this.eUY.setAdapter((ListAdapter) this.eUZ);
        this.mPullView = bbM();
        this.eUY.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                b.this.eUX.bbH().iV(z);
            }
        });
        this.eUY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.eUZ.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.eUY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.eUZ.getItem(i));
                        bVar.setUniqueId(b.this.eUX.getUniqueId());
                        b.this.eUX.awx().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.eUX.getPageContext());
                aVar.akO();
                return true;
            }
        });
        this.eUY.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.eUX.bbH().bbL();
                } else if (b.this.eVa != null) {
                    b.this.eVa.le();
                    b.this.eVa.kf(R.string.no_more_msg);
                }
            }
        });
        this.eVa = new com.baidu.tbadk.mvc.g.a(this.eUX);
        this.eVa.createView();
        getListView().setNextPage(this.eVa);
        this.dEq = new g(getActivity());
        this.dEq.onChangeSkinType();
        this.dEq.attachView(getView(), true);
        this.eUX.bbH().bbK();
    }

    public Activity getActivity() {
        return this.eUX.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.avQ()) {
            case 4097:
                this.eVb = false;
                break;
            case 4098:
                this.eVb = true;
                break;
            case 4099:
                a(bVar.avR());
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
            this.eUZ.cz(((Long) extra).longValue());
            if (this.eUZ.getCount() <= 5) {
                bbO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.dEq != null) {
            this.dEq.dettachView(getView());
        }
        if (errorData != null && this.eUZ.awu() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.eUY.completePullRefreshPostDelayed(0L);
        if (this.eVa != null) {
            this.eVa.kf(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dkM != null) {
            this.dkM.onChangeSkinType(tbPageContext, i);
        }
        if (this.eUZ != null) {
            this.eUZ.b(tbPageContext, i);
        }
        if (this.eVa != null) {
            this.eVa.b(tbPageContext, i);
        }
        if (this.dJg != null) {
            this.dJg.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aws()) {
                this.eVa.le();
                if (aVar.awq()) {
                    this.eVa.ke(R.string.loading);
                } else if (!aVar.awr()) {
                    this.eVa.kf(R.string.no_more_msg);
                }
            } else {
                this.eVa.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.eUY.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bbQ = ((com.baidu.tieba.chosen.posts.request.b) aVar).bbQ();
            if (bbQ != null && bbQ.size() > 0) {
                this.eUY.setVisibility(0);
            }
            if (this.dEq != null) {
                this.dEq.dettachView(getView());
            }
            if (this.eVb) {
                this.eUZ.aE(bbQ);
                return;
            }
            this.eUZ.aF(bbQ);
            if (bbQ != null) {
                BdToast b = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bbQ.size())}), 0);
                b.ic(48);
                b.setOffsetY(this.eVd);
                b.setPaddingHorizontal(this.paddingHorizontal);
                b.akS().akT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbO() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.eUX.getUniqueId());
        this.eUX.awx().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.eUY;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.eVc == null) {
            this.eVc = new com.baidu.tbadk.m.h(getPageContext().getPageActivity(), new a());
        }
        this.eVc.setSubText(str);
        this.eVc.attachView(view, z);
        this.eVc.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.eVc != null) {
            this.eVc.dettachView(view);
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
            b.this.dEq.attachView(b.this.getView(), true);
            b.this.bbO();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
