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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar dXE;
    private g eoy;
    private NoNetworkView ewC;
    private ChosenPostActivity fIN;
    private BdListView fIO;
    private com.baidu.tieba.chosen.posts.a fIP;
    private com.baidu.tbadk.mvc.g.a fIQ;
    private boolean fIR;
    private h fIS;
    int fIT;
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    int paddingHorizontal;

    protected com.baidu.tbadk.core.view.h bti() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.fIN.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.fIR = false;
        this.fIN = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bci() {
        this.mRootView = this.fIN.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void btj() {
        this.fIT = this.fIN.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.fIN.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.dXE = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.dXE.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.dXE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fIO = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.ewC = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.fIP = new com.baidu.tieba.chosen.posts.a(this.fIN.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.fIN.aOf());
        this.fIO.setAdapter((ListAdapter) this.fIP);
        this.mPullView = bti();
        this.fIO.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                b.this.fIN.btd().kh(z);
            }
        });
        this.fIO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.fIP.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.fIO.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.sz(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.fIP.getItem(i));
                        bVar.setUniqueId(b.this.fIN.getUniqueId());
                        b.this.fIN.aOf().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.fIN.getPageContext());
                aVar.aBW();
                return true;
            }
        });
        this.fIO.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.fIN.btd().bth();
                } else if (b.this.fIQ != null) {
                    b.this.fIQ.lw();
                    b.this.fIQ.ms(R.string.no_more_msg);
                }
            }
        });
        this.fIQ = new com.baidu.tbadk.mvc.g.a(this.fIN);
        this.fIQ.createView();
        getListView().setNextPage(this.fIQ);
        this.eoy = new com.baidu.tbadk.k.g(getActivity());
        this.eoy.onChangeSkinType();
        this.eoy.attachView(getView(), true);
        this.fIN.btd().btg();
    }

    public Activity getActivity() {
        return this.fIN.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.aNy()) {
            case 4097:
                this.fIR = false;
                break;
            case 4098:
                this.fIR = true;
                break;
            case 4099:
                a(bVar.aNz());
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
            this.fIP.de(((Long) extra).longValue());
            if (this.fIP.getCount() <= 5) {
                btk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.eoy != null) {
            this.eoy.dettachView(getView());
        }
        if (errorData != null && this.fIP.aOc() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.fIO.completePullRefreshPostDelayed(0L);
        if (this.fIQ != null) {
            this.fIQ.ms(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dXE != null) {
            this.dXE.onChangeSkinType(tbPageContext, i);
        }
        if (this.fIP != null) {
            this.fIP.b(tbPageContext, i);
        }
        if (this.fIQ != null) {
            this.fIQ.b(tbPageContext, i);
        }
        if (this.ewC != null) {
            this.ewC.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.aOa()) {
                this.fIQ.lw();
                if (aVar.aNY()) {
                    this.fIQ.mr(R.string.loading);
                } else if (!aVar.aNZ()) {
                    this.fIQ.ms(R.string.no_more_msg);
                }
            } else {
                this.fIQ.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.fIO.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> btm = ((com.baidu.tieba.chosen.posts.request.b) aVar).btm();
            if (btm != null && btm.size() > 0) {
                this.fIO.setVisibility(0);
            }
            if (this.eoy != null) {
                this.eoy.dettachView(getView());
            }
            if (this.fIR) {
                this.fIP.aK(btm);
                return;
            }
            this.fIP.aL(btm);
            if (btm != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(btm.size())}), 0);
                a2.jN(48);
                a2.setOffsetY(this.fIT);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.aCa().aCb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btk() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.fIN.getUniqueId());
        this.fIN.aOf().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.fIO;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.fIS == null) {
            this.fIS = new h(getPageContext().getPageActivity(), new a());
        }
        this.fIS.setSubText(str);
        this.fIS.attachView(view, z);
        this.fIS.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.fIS != null) {
            this.fIS.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.eoy.attachView(b.this.getView(), true);
            b.this.btk();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
