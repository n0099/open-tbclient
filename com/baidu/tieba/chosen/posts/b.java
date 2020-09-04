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
    private g fMR;
    private NoNetworkView fXG;
    private NavigationBar fri;
    private BdListView hoA;
    private com.baidu.tieba.chosen.posts.a hoB;
    private com.baidu.tbadk.mvc.g.a hoC;
    private boolean hoD;
    private h hoE;
    private ChosenPostActivity hoz;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g ccK() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.hoz.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.hoD = false;
        this.hoz = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bJE() {
        this.mRootView = this.hoz.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccL() {
        this.paddingTop = this.hoz.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.hoz.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.fri = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.fri.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.fri.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hoA = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.fXG = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.hoB = new com.baidu.tieba.chosen.posts.a(this.hoz.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.hoz.btR());
        this.hoA.setAdapter((ListAdapter) this.hoB);
        this.mPullView = ccK();
        this.hoA.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.hoz.ccG().nr(z);
            }
        });
        this.hoA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.hoB.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.hoA.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.zA(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.hoB.getItem(i));
                        bVar.setUniqueId(b.this.hoz.getUniqueId());
                        b.this.hoz.btR().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.hoz.getPageContext());
                aVar.bhg();
                return true;
            }
        });
        this.hoA.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.hoz.ccG().ccJ();
                } else if (b.this.hoC != null) {
                    b.this.hoC.display();
                    b.this.hoC.qy(R.string.no_more_msg);
                }
            }
        });
        this.hoC = new com.baidu.tbadk.mvc.g.a(this.hoz);
        this.hoC.createView();
        getListView().setNextPage(this.hoC);
        this.fMR = new g(getActivity());
        this.fMR.onChangeSkinType();
        this.fMR.attachView(getView(), true);
        this.hoz.ccG().ccI();
    }

    public Activity getActivity() {
        return this.hoz.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.btv()) {
            case 4097:
                this.hoD = false;
                break;
            case 4098:
                this.hoD = true;
                break;
            case 4099:
                a(bVar.btw());
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
            this.hoB.ev(((Long) extra).longValue());
            if (this.hoB.getCount() <= 5) {
                ccM();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.fMR != null) {
            this.fMR.dettachView(getView());
        }
        if (errorData != null && this.hoB.btN() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.hoA.completePullRefreshPostDelayed(0L);
        if (this.hoC != null) {
            this.hoC.qy(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fri != null) {
            this.fri.onChangeSkinType(tbPageContext, i);
        }
        if (this.hoB != null) {
            this.hoB.b(tbPageContext, i);
        }
        if (this.hoC != null) {
            this.hoC.b(tbPageContext, i);
        }
        if (this.fXG != null) {
            this.fXG.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.btL()) {
                this.hoC.display();
                if (aVar.btJ()) {
                    this.hoC.qx(R.string.loading);
                } else if (!aVar.btK()) {
                    this.hoC.qy(R.string.no_more_msg);
                }
            } else {
                this.hoC.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.hoA.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> ccO = ((com.baidu.tieba.chosen.posts.request.b) aVar).ccO();
            if (ccO != null && ccO.size() > 0) {
                this.hoA.setVisibility(0);
            }
            if (this.fMR != null) {
                this.fMR.dettachView(getView());
            }
            if (this.hoD) {
                this.hoB.be(ccO);
                return;
            }
            this.hoB.bf(ccO);
            if (ccO != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(ccO.size())}), 0);
                a2.nB(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.bhl().bhm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccM() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.hoz.getUniqueId());
        this.hoz.btR().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.hoA;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.hoE == null) {
            this.hoE = new h(getPageContext().getPageActivity(), new a());
        }
        this.hoE.setSubText(str);
        this.hoE.attachView(view, z);
        this.hoE.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.hoE != null) {
            this.hoE.dettachView(view);
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
            b.this.fMR.attachView(b.this.getView(), true);
            b.this.ccM();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
