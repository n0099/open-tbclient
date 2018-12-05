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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tieba.e;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar bDP;
    private f bKv;
    private NoNetworkView bYt;
    private ChosenPostActivity dcK;
    private BdListView dcL;
    private com.baidu.tieba.chosen.posts.a dcM;
    private com.baidu.tbadk.mvc.g.a dcN;
    private boolean dcO;
    private g dcP;
    private k mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected k aqO() {
        if (this.mPullView == null) {
            this.mPullView = new k(this.dcK.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.dcO = false;
        this.dcK = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View acb() {
        this.mRootView = this.dcK.getLayoutInflater().inflate(e.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqP() {
        this.paddingTop = this.dcK.getResources().getDimensionPixelSize(e.C0210e.ds108);
        this.paddingHorizontal = this.dcK.getResources().getDimensionPixelSize(e.C0210e.ds150);
        this.bDP = (NavigationBar) getView().findViewById(e.g.chosen_post_navigation_bar);
        this.bDP.setTitleText(e.j.recommend_frs_hot_thread_title);
        this.bDP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dcL = (BdListView) getView().findViewById(e.g.chosen_post_list);
        this.bYt = (NoNetworkView) getView().findViewById(e.g.view_no_network);
        this.dcM = new com.baidu.tieba.chosen.posts.a(this.dcK.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{e.h.chosen_picture_layout, e.h.chosen_no_picture_layout, e.h.chosen_image_text_layout}, this.dcK.OL());
        this.dcL.setAdapter((ListAdapter) this.dcM);
        this.mPullView = aqO();
        this.dcL.setPullRefresh(this.mPullView);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                b.this.dcK.aqJ().fE(z);
            }
        });
        this.dcL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.dcM.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.dcL.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.eB(b.this.getActivity().getString(e.j.chosen_post_dialog_text));
                aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.dcM.getItem(i));
                        bVar.setUniqueId(b.this.dcK.getUniqueId());
                        b.this.dcK.OL().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.dcK.getPageContext());
                aVar.BF();
                return true;
            }
        });
        this.dcL.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.ll()) {
                    b.this.dcK.aqJ().aqN();
                } else if (b.this.dcN != null) {
                    b.this.dcN.pN();
                    b.this.dcN.gg(e.j.no_more_msg);
                }
            }
        });
        this.dcN = new com.baidu.tbadk.mvc.g.a(this.dcK);
        this.dcN.oD();
        getListView().setNextPage(this.dcN);
        this.bKv = new f(getActivity());
        this.bKv.onChangeSkinType();
        this.bKv.attachView(getView(), true);
        this.dcK.aqJ().aqM();
    }

    public Activity getActivity() {
        return this.dcK.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Od()) {
            case 4097:
                this.dcO = false;
                break;
            case 4098:
                this.dcO = true;
                break;
            case 4099:
                a(bVar.Oe());
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
            this.dcM.bB(((Long) extra).longValue());
            if (this.dcM.getCount() <= 5) {
                aqQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bKv != null) {
            this.bKv.dettachView(getView());
        }
        if (errorData != null && this.dcM.OH() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(e.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.dcL.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        if (this.dcN != null) {
            this.dcN.gg(e.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bDP != null) {
            this.bDP.onChangeSkinType(tbPageContext, i);
        }
        if (this.dcM != null) {
            this.dcM.b(tbPageContext, i);
        }
        if (this.dcN != null) {
            this.dcN.b(tbPageContext, i);
        }
        if (this.bYt != null) {
            this.bYt.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.OF()) {
                this.dcN.pN();
                if (aVar.OD()) {
                    this.dcN.gf(e.j.loading);
                } else if (!aVar.OE()) {
                    this.dcN.gg(e.j.no_more_msg);
                }
            } else {
                this.dcN.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.dcL.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> aqS = ((com.baidu.tieba.chosen.posts.request.b) aVar).aqS();
            if (aqS != null && aqS.size() > 0) {
                this.dcL.setVisibility(0);
            }
            if (this.bKv != null) {
                this.bKv.dettachView(getView());
            }
            if (this.dcO) {
                this.dcM.Q(aqS);
                return;
            }
            this.dcM.R(aqS);
            if (aqS != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(e.j.chosen_post_recommend, new Object[]{Integer.valueOf(aqS.size())}), 0);
                a2.dn(48);
                a2.setOffsetY(this.paddingTop);
                a2.dl(this.paddingHorizontal);
                a2.BL().BN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqQ() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.dcK.getUniqueId());
        this.dcK.OL().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.dcL;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.dcP == null) {
            this.dcP = new g(getPageContext().getPageActivity(), new a());
        }
        this.dcP.in(str);
        this.dcP.attachView(view, z);
        this.dcP.NL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.dcP != null) {
            this.dcP.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.bKv.attachView(b.this.getView(), true);
            b.this.aqQ();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
