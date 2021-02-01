package com.baidu.tieba.chosen.posts;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.d;
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
import com.baidu.tieba.chosen.posts.a.c;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes8.dex */
public class b extends d<ChosenPostActivity> {
    private g gJn;
    private NoNetworkView gVA;
    private NavigationBar gjF;
    private ChosenPostActivity iCe;
    private BdListView iCf;
    private com.baidu.tieba.chosen.posts.a iCg;
    private com.baidu.tbadk.mvc.g.a iCh;
    private boolean iCi;
    private h iCj;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g ctg() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.iCe.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.iCi = false;
        this.iCe = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVk() {
        this.mRootView = this.iCe.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cth() {
        this.paddingTop = this.iCe.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.iCe.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.gjF = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.gjF.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.gjF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iCf = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gVA = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.iCg = new com.baidu.tieba.chosen.posts.a(this.iCe.getPageContext(), new Class[]{c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.iCe.bDI());
        this.iCf.setAdapter((ListAdapter) this.iCg);
        this.mPullView = ctg();
        this.iCf.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.iCe.ctc().pG(z);
            }
        });
        this.iCf.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.iCg.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.iCf.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.Au(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.iCg.getItem(i));
                        bVar.setUniqueId(b.this.iCe.getUniqueId());
                        b.this.iCe.bDI().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.iCe.getPageContext());
                aVar.bqx();
                return true;
            }
        });
        this.iCf.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.iCe.ctc().ctf();
                } else if (b.this.iCh != null) {
                    b.this.iCh.display();
                    b.this.iCh.rs(R.string.no_more_msg);
                }
            }
        });
        this.iCh = new com.baidu.tbadk.mvc.g.a(this.iCe);
        this.iCh.createView();
        getListView().setNextPage(this.iCh);
        this.gJn = new g(getActivity());
        this.gJn.onChangeSkinType();
        this.gJn.attachView(getView(), true);
        this.iCe.ctc().cte();
    }

    public Activity getActivity() {
        return this.iCe.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bDn()) {
            case 4097:
                this.iCi = false;
                break;
            case 4098:
                this.iCi = true;
                break;
            case 4099:
                a(bVar.bDo());
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
            this.iCg.gf(((Long) extra).longValue());
            if (this.iCg.getCount() <= 5) {
                cti();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gJn != null) {
            this.gJn.dettachView(getView());
        }
        if (errorData != null && this.iCg.bDF() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.iCf.completePullRefreshPostDelayed(0L);
        if (this.iCh != null) {
            this.iCh.rs(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gjF != null) {
            this.gjF.onChangeSkinType(tbPageContext, i);
        }
        if (this.iCg != null) {
            this.iCg.b(tbPageContext, i);
        }
        if (this.iCh != null) {
            this.iCh.b(tbPageContext, i);
        }
        if (this.gVA != null) {
            this.gVA.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bDD()) {
                this.iCh.display();
                if (aVar.bDB()) {
                    this.iCh.rr(R.string.loading);
                } else if (!aVar.bDC()) {
                    this.iCh.rs(R.string.no_more_msg);
                }
            } else {
                this.iCh.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.iCf.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> ctk = ((com.baidu.tieba.chosen.posts.request.b) aVar).ctk();
            if (ctk != null && ctk.size() > 0) {
                this.iCf.setVisibility(0);
            }
            if (this.gJn != null) {
                this.gJn.dettachView(getView());
            }
            if (this.iCi) {
                this.iCg.bH(ctk);
                return;
            }
            this.iCg.bI(ctk);
            if (ctk != null) {
                BdToast b2 = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(ctk.size())}), 0);
                b2.nG(48);
                b2.setOffsetY(this.paddingTop);
                b2.setPaddingHorizontal(this.paddingHorizontal);
                b2.bqC().bqD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cti() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.iCe.getUniqueId());
        this.iCe.bDI().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.iCf;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.iCj == null) {
            this.iCj = new h(getPageContext().getPageActivity(), new a());
        }
        this.iCj.setSubText(str);
        this.iCj.attachView(view, z);
        this.iCj.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.iCj != null) {
            this.iCj.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.gJn.attachView(b.this.getView(), true);
            b.this.cti();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
