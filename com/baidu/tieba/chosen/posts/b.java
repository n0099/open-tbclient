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
    private NavigationBar bDS;
    private f bKy;
    private NoNetworkView bYw;
    private ChosenPostActivity dfC;
    private BdListView dfD;
    private com.baidu.tieba.chosen.posts.a dfE;
    private com.baidu.tbadk.mvc.g.a dfF;
    private boolean dfG;
    private g dfH;
    private k mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected k arD() {
        if (this.mPullView == null) {
            this.mPullView = new k(this.dfC.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.dfG = false;
        this.dfC = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View acd() {
        this.mRootView = this.dfC.getLayoutInflater().inflate(e.h.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arE() {
        this.paddingTop = this.dfC.getResources().getDimensionPixelSize(e.C0210e.ds108);
        this.paddingHorizontal = this.dfC.getResources().getDimensionPixelSize(e.C0210e.ds150);
        this.bDS = (NavigationBar) getView().findViewById(e.g.chosen_post_navigation_bar);
        this.bDS.setTitleText(e.j.recommend_frs_hot_thread_title);
        this.bDS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dfD = (BdListView) getView().findViewById(e.g.chosen_post_list);
        this.bYw = (NoNetworkView) getView().findViewById(e.g.view_no_network);
        this.dfE = new com.baidu.tieba.chosen.posts.a(this.dfC.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{e.h.chosen_picture_layout, e.h.chosen_no_picture_layout, e.h.chosen_image_text_layout}, this.dfC.OM());
        this.dfD.setAdapter((ListAdapter) this.dfE);
        this.mPullView = arD();
        this.dfD.setPullRefresh(this.mPullView);
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                b.this.dfC.ary().fG(z);
            }
        });
        this.dfD.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.dfE.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.dfD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.dfE.getItem(i));
                        bVar.setUniqueId(b.this.dfC.getUniqueId());
                        b.this.dfC.OM().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.dfC.getPageContext());
                aVar.BF();
                return true;
            }
        });
        this.dfD.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.ll()) {
                    b.this.dfC.ary().arC();
                } else if (b.this.dfF != null) {
                    b.this.dfF.pN();
                    b.this.dfF.gh(e.j.no_more_msg);
                }
            }
        });
        this.dfF = new com.baidu.tbadk.mvc.g.a(this.dfC);
        this.dfF.oD();
        getListView().setNextPage(this.dfF);
        this.bKy = new f(getActivity());
        this.bKy.onChangeSkinType();
        this.bKy.attachView(getView(), true);
        this.dfC.ary().arB();
    }

    public Activity getActivity() {
        return this.dfC.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.Oe()) {
            case 4097:
                this.dfG = false;
                break;
            case 4098:
                this.dfG = true;
                break;
            case 4099:
                a(bVar.Of());
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
            this.dfE.bG(((Long) extra).longValue());
            if (this.dfE.getCount() <= 5) {
                arF();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bKy != null) {
            this.bKy.dettachView(getView());
        }
        if (errorData != null && this.dfE.OI() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(e.j.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.dfD.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        if (this.dfF != null) {
            this.dfF.gh(e.j.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bDS != null) {
            this.bDS.onChangeSkinType(tbPageContext, i);
        }
        if (this.dfE != null) {
            this.dfE.b(tbPageContext, i);
        }
        if (this.dfF != null) {
            this.dfF.b(tbPageContext, i);
        }
        if (this.bYw != null) {
            this.bYw.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.OG()) {
                this.dfF.pN();
                if (aVar.OE()) {
                    this.dfF.gg(e.j.loading);
                } else if (!aVar.OF()) {
                    this.dfF.gh(e.j.no_more_msg);
                }
            } else {
                this.dfF.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.dfD.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> arH = ((com.baidu.tieba.chosen.posts.request.b) aVar).arH();
            if (arH != null && arH.size() > 0) {
                this.dfD.setVisibility(0);
            }
            if (this.bKy != null) {
                this.bKy.dettachView(getView());
            }
            if (this.dfG) {
                this.dfE.Q(arH);
                return;
            }
            this.dfE.R(arH);
            if (arH != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(e.j.chosen_post_recommend, new Object[]{Integer.valueOf(arH.size())}), 0);
                a2.dn(48);
                a2.setOffsetY(this.paddingTop);
                a2.dl(this.paddingHorizontal);
                a2.BL().BN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arF() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.dfC.getUniqueId());
        this.dfC.OM().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.dfD;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.dfH == null) {
            this.dfH = new g(getPageContext().getPageActivity(), new a());
        }
        this.dfH.io(str);
        this.dfH.attachView(view, z);
        this.dfH.NM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.dfH != null) {
            this.dfH.dettachView(view);
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
            b.this.bKy.attachView(b.this.getView(), true);
            b.this.arF();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
