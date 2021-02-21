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
    private g gJB;
    private NoNetworkView gVO;
    private NavigationBar gjT;
    private ChosenPostActivity iCs;
    private BdListView iCt;
    private com.baidu.tieba.chosen.posts.a iCu;
    private com.baidu.tbadk.mvc.g.a iCv;
    private boolean iCw;
    private h iCx;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g ctn() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.iCs.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.iCw = false;
        this.iCs = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVr() {
        this.mRootView = this.iCs.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cto() {
        this.paddingTop = this.iCs.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.iCs.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.gjT = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.gjT.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.gjT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iCt = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gVO = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.iCu = new com.baidu.tieba.chosen.posts.a(this.iCs.getPageContext(), new Class[]{c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.iCs.bDI());
        this.iCt.setAdapter((ListAdapter) this.iCu);
        this.mPullView = ctn();
        this.iCt.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.iCs.ctj().pG(z);
            }
        });
        this.iCt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.iCu.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.iCt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.iCu.getItem(i));
                        bVar.setUniqueId(b.this.iCs.getUniqueId());
                        b.this.iCs.bDI().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.iCs.getPageContext());
                aVar.bqx();
                return true;
            }
        });
        this.iCt.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.iCs.ctj().ctm();
                } else if (b.this.iCv != null) {
                    b.this.iCv.display();
                    b.this.iCv.rs(R.string.no_more_msg);
                }
            }
        });
        this.iCv = new com.baidu.tbadk.mvc.g.a(this.iCs);
        this.iCv.createView();
        getListView().setNextPage(this.iCv);
        this.gJB = new g(getActivity());
        this.gJB.onChangeSkinType();
        this.gJB.attachView(getView(), true);
        this.iCs.ctj().ctl();
    }

    public Activity getActivity() {
        return this.iCs.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bDn()) {
            case 4097:
                this.iCw = false;
                break;
            case 4098:
                this.iCw = true;
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
            this.iCu.gf(((Long) extra).longValue());
            if (this.iCu.getCount() <= 5) {
                ctp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gJB != null) {
            this.gJB.dettachView(getView());
        }
        if (errorData != null && this.iCu.bDF() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.iCt.completePullRefreshPostDelayed(0L);
        if (this.iCv != null) {
            this.iCv.rs(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gjT != null) {
            this.gjT.onChangeSkinType(tbPageContext, i);
        }
        if (this.iCu != null) {
            this.iCu.b(tbPageContext, i);
        }
        if (this.iCv != null) {
            this.iCv.b(tbPageContext, i);
        }
        if (this.gVO != null) {
            this.gVO.onChangeSkinType(tbPageContext, i);
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
                this.iCv.display();
                if (aVar.bDB()) {
                    this.iCv.rr(R.string.loading);
                } else if (!aVar.bDC()) {
                    this.iCv.rs(R.string.no_more_msg);
                }
            } else {
                this.iCv.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.iCt.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> ctr = ((com.baidu.tieba.chosen.posts.request.b) aVar).ctr();
            if (ctr != null && ctr.size() > 0) {
                this.iCt.setVisibility(0);
            }
            if (this.gJB != null) {
                this.gJB.dettachView(getView());
            }
            if (this.iCw) {
                this.iCu.bH(ctr);
                return;
            }
            this.iCu.bI(ctr);
            if (ctr != null) {
                BdToast b2 = BdToast.b(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(ctr.size())}), 0);
                b2.nG(48);
                b2.setOffsetY(this.paddingTop);
                b2.setPaddingHorizontal(this.paddingHorizontal);
                b2.bqC().bqD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctp() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.iCs.getUniqueId());
        this.iCs.bDI().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.iCt;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.iCx == null) {
            this.iCx = new h(getPageContext().getPageActivity(), new a());
        }
        this.iCx.setSubText(str);
        this.iCx.attachView(view, z);
        this.iCx.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.iCx != null) {
            this.iCx.dettachView(view);
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
            b.this.gJB.attachView(b.this.getView(), true);
            b.this.ctp();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
