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
/* loaded from: classes10.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar eQM;
    private g fkQ;
    private NoNetworkView fuO;
    private ChosenPostActivity gIO;
    private BdListView gIP;
    private com.baidu.tieba.chosen.posts.a gIQ;
    private com.baidu.tbadk.mvc.g.a gIR;
    private boolean gIS;
    private h gIT;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g bLZ() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.gIO.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.gIS = false;
        this.gIO = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View btU() {
        this.mRootView = this.gIO.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bMa() {
        this.paddingTop = this.gIO.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.gIO.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.eQM = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.eQM.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.eQM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gIP = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.fuO = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.gIQ = new com.baidu.tieba.chosen.posts.a(this.gIO.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.gIO.bfm());
        this.gIP.setAdapter((ListAdapter) this.gIQ);
        this.mPullView = bLZ();
        this.gIP.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.gIO.bLV().lY(z);
            }
        });
        this.gIP.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.gIQ.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.gIP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.vO(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.gIQ.getItem(i));
                        bVar.setUniqueId(b.this.gIO.getUniqueId());
                        b.this.gIO.bfm().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.gIO.getPageContext());
                aVar.aST();
                return true;
            }
        });
        this.gIP.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.gIO.bLV().bLY();
                } else if (b.this.gIR != null) {
                    b.this.gIR.display();
                    b.this.gIR.ny(R.string.no_more_msg);
                }
            }
        });
        this.gIR = new com.baidu.tbadk.mvc.g.a(this.gIO);
        this.gIR.createView();
        getListView().setNextPage(this.gIR);
        this.fkQ = new g(getActivity());
        this.fkQ.onChangeSkinType();
        this.fkQ.attachView(getView(), true);
        this.gIO.bLV().bLX();
    }

    public Activity getActivity() {
        return this.gIO.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.beR()) {
            case 4097:
                this.gIS = false;
                break;
            case 4098:
                this.gIS = true;
                break;
            case 4099:
                a(bVar.beS());
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
            this.gIQ.dU(((Long) extra).longValue());
            if (this.gIQ.getCount() <= 5) {
                bMb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.fkQ != null) {
            this.fkQ.dettachView(getView());
        }
        if (errorData != null && this.gIQ.bfj() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.gIP.completePullRefreshPostDelayed(0L);
        if (this.gIR != null) {
            this.gIR.ny(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.eQM != null) {
            this.eQM.onChangeSkinType(tbPageContext, i);
        }
        if (this.gIQ != null) {
            this.gIQ.b(tbPageContext, i);
        }
        if (this.gIR != null) {
            this.gIR.b(tbPageContext, i);
        }
        if (this.fuO != null) {
            this.fuO.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bfh()) {
                this.gIR.display();
                if (aVar.bff()) {
                    this.gIR.nx(R.string.loading);
                } else if (!aVar.bfg()) {
                    this.gIR.ny(R.string.no_more_msg);
                }
            } else {
                this.gIR.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.gIP.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> bMd = ((com.baidu.tieba.chosen.posts.request.b) aVar).bMd();
            if (bMd != null && bMd.size() > 0) {
                this.gIP.setVisibility(0);
            }
            if (this.fkQ != null) {
                this.fkQ.dettachView(getView());
            }
            if (this.gIS) {
                this.gIQ.aO(bMd);
                return;
            }
            this.gIQ.aP(bMd);
            if (bMd != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(bMd.size())}), 0);
                a2.kL(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aSX().aSY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMb() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.gIO.getUniqueId());
        this.gIO.bfm().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.gIP;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.gIT == null) {
            this.gIT = new h(getPageContext().getPageActivity(), new a());
        }
        this.gIT.setSubText(str);
        this.gIT.attachView(view, z);
        this.gIT.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.gIT != null) {
            this.gIT.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.fkQ.attachView(b.this.getView(), true);
            b.this.bMb();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
