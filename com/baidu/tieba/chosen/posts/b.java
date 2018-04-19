package com.baidu.tieba.chosen.posts;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes3.dex */
public class b extends c<ChosenPostActivity> {
    int adl;
    private NavigationBar bfy;
    private f bha;
    private NoNetworkView btV;
    private ChosenPostActivity cwG;
    private BdListView cwH;
    private com.baidu.tieba.chosen.posts.a cwI;
    private com.baidu.tbadk.mvc.g.a cwJ;
    private boolean cwK;
    private g cwL;
    private com.baidu.tbadk.core.view.f mPullView;
    private View mRootView;
    int paddingTop;

    protected com.baidu.tbadk.core.view.f agM() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.cwG.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cwK = false;
        this.cwG = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Rn() {
        this.mRootView = this.cwG.getLayoutInflater().inflate(d.i.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agN() {
        this.paddingTop = this.cwG.getResources().getDimensionPixelSize(d.e.ds108);
        this.adl = this.cwG.getResources().getDimensionPixelSize(d.e.ds150);
        this.bfy = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bfy.setTitleText(d.k.recommend_frs_hot_thread_title);
        this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cwH = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.btV = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.cwI = new com.baidu.tieba.chosen.posts.a(this.cwG.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.i.chosen_picture_layout, d.i.chosen_no_picture_layout, d.i.chosen_image_text_layout}, this.cwG.Gn());
        this.cwH.setAdapter((ListAdapter) this.cwI);
        this.mPullView = agM();
        this.cwH.setPullRefresh(this.mPullView);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                b.this.cwG.agH().eD(z);
            }
        });
        this.cwH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                tinfo item = b.this.cwI.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cwH.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view2, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.dc(b.this.getActivity().getString(d.k.chosen_post_dialog_text));
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.a(d.k.confirm, new a.b() { // from class: com.baidu.tieba.chosen.posts.b.3.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
                        bVar.setExtra(b.this.cwI.getItem(i));
                        bVar.setUniqueId(b.this.cwG.getUniqueId());
                        b.this.cwG.Gn().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cwG.getPageContext());
                aVar.tD();
                return true;
            }
        });
        this.cwH.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.hg()) {
                    b.this.cwG.agH().agL();
                } else if (b.this.cwJ != null) {
                    b.this.cwJ.lN();
                    b.this.cwJ.fd(d.k.no_more_msg);
                }
            }
        });
        this.cwJ = new com.baidu.tbadk.mvc.g.a(this.cwG);
        this.cwJ.kA();
        getListView().setNextPage(this.cwJ);
        this.bha = new f(getActivity());
        this.bha.onChangeSkinType();
        this.bha.d(getView(), true);
        this.cwG.agH().agK();
    }

    public Activity getActivity() {
        return this.cwG.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.FF()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.cwK = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.cwK = true;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                a(bVar.FG());
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
            this.cwI.bl(((Long) extra).longValue());
            if (this.cwI.getCount() <= 5) {
                agO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bha != null) {
            this.bha.P(getView());
        }
        if (errorData != null && this.cwI.Gj() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.k.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cwH.completePullRefreshPostDelayed(2000L);
        if (this.cwJ != null) {
            this.cwJ.fd(d.k.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bfy != null) {
            this.bfy.onChangeSkinType(tbPageContext, i);
        }
        if (this.cwI != null) {
            this.cwI.b(tbPageContext, i);
        }
        if (this.cwJ != null) {
            this.cwJ.b(tbPageContext, i);
        }
        if (this.btV != null) {
            this.btV.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Gh()) {
                this.cwJ.lN();
                if (aVar.Gf()) {
                    this.cwJ.fc(d.k.loading);
                } else if (!aVar.Gg()) {
                    this.cwJ.fd(d.k.no_more_msg);
                }
            } else {
                this.cwJ.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cwH.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> agQ = ((com.baidu.tieba.chosen.posts.request.b) aVar).agQ();
            if (agQ != null && agQ.size() > 0) {
                this.cwH.setVisibility(0);
            }
            if (this.bha != null) {
                this.bha.P(getView());
            }
            if (this.cwK) {
                this.cwI.E(agQ);
                return;
            }
            this.cwI.F(agQ);
            if (agQ != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(d.k.chosen_post_recommend, new Object[]{Integer.valueOf(agQ.size())}), 0);
                a2.cl(48);
                a2.setOffsetY(this.paddingTop);
                a2.cj(this.adl);
                a2.tJ().tL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agO() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.cwG.getUniqueId());
        this.cwG.Gn().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cwH;
    }

    private void showNetRefreshView(View view2, String str, boolean z) {
        if (this.cwL == null) {
            this.cwL = new g(getPageContext().getPageActivity(), new a());
        }
        this.cwL.setSubText(str);
        this.cwL.d(view2, z);
        this.cwL.Fu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view2) {
        if (this.cwL != null) {
            this.cwL.P(view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.bha.d(b.this.getView(), true);
            b.this.agO();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
