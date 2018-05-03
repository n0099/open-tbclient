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
    private ChosenPostActivity cwD;
    private BdListView cwE;
    private com.baidu.tieba.chosen.posts.a cwF;
    private com.baidu.tbadk.mvc.g.a cwG;
    private boolean cwH;
    private g cwI;
    private com.baidu.tbadk.core.view.f mPullView;
    private View mRootView;
    int paddingTop;

    protected com.baidu.tbadk.core.view.f agM() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.cwD.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.cwH = false;
        this.cwD = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Rn() {
        this.mRootView = this.cwD.getLayoutInflater().inflate(d.i.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agN() {
        this.paddingTop = this.cwD.getResources().getDimensionPixelSize(d.e.ds108);
        this.adl = this.cwD.getResources().getDimensionPixelSize(d.e.ds150);
        this.bfy = (NavigationBar) getView().findViewById(d.g.chosen_post_navigation_bar);
        this.bfy.setTitleText(d.k.recommend_frs_hot_thread_title);
        this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cwE = (BdListView) getView().findViewById(d.g.chosen_post_list);
        this.btV = (NoNetworkView) getView().findViewById(d.g.view_no_network);
        this.cwF = new com.baidu.tieba.chosen.posts.a(this.cwD.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{d.i.chosen_picture_layout, d.i.chosen_no_picture_layout, d.i.chosen_image_text_layout}, this.cwD.Gn());
        this.cwE.setAdapter((ListAdapter) this.cwF);
        this.mPullView = agM();
        this.cwE.setPullRefresh(this.mPullView);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                b.this.cwD.agH().eD(z);
            }
        });
        this.cwE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                tinfo item = b.this.cwF.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.cwE.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
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
                        bVar.setExtra(b.this.cwF.getItem(i));
                        bVar.setUniqueId(b.this.cwD.getUniqueId());
                        b.this.cwD.Gn().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.cwD.getPageContext());
                aVar.tD();
                return true;
            }
        });
        this.cwE.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                if (l.hg()) {
                    b.this.cwD.agH().agL();
                } else if (b.this.cwG != null) {
                    b.this.cwG.lN();
                    b.this.cwG.fd(d.k.no_more_msg);
                }
            }
        });
        this.cwG = new com.baidu.tbadk.mvc.g.a(this.cwD);
        this.cwG.kA();
        getListView().setNextPage(this.cwG);
        this.bha = new f(getActivity());
        this.bha.onChangeSkinType();
        this.bha.d(getView(), true);
        this.cwD.agH().agK();
    }

    public Activity getActivity() {
        return this.cwD.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.FF()) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                this.cwH = false;
                break;
            case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                this.cwH = true;
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
            this.cwF.bl(((Long) extra).longValue());
            if (this.cwF.getCount() <= 5) {
                agO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.bha != null) {
            this.bha.P(getView());
        }
        if (errorData != null && this.cwF.Gj() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(d.k.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.cwE.completePullRefreshPostDelayed(2000L);
        if (this.cwG != null) {
            this.cwG.fd(d.k.no_more_msg);
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.bfy != null) {
            this.bfy.onChangeSkinType(tbPageContext, i);
        }
        if (this.cwF != null) {
            this.cwF.b(tbPageContext, i);
        }
        if (this.cwG != null) {
            this.cwG.b(tbPageContext, i);
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
                this.cwG.lN();
                if (aVar.Gf()) {
                    this.cwG.fc(d.k.loading);
                } else if (!aVar.Gg()) {
                    this.cwG.fd(d.k.no_more_msg);
                }
            } else {
                this.cwG.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.cwE.completePullRefreshPostDelayed(2000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> agQ = ((com.baidu.tieba.chosen.posts.request.b) aVar).agQ();
            if (agQ != null && agQ.size() > 0) {
                this.cwE.setVisibility(0);
            }
            if (this.bha != null) {
                this.bha.P(getView());
            }
            if (this.cwH) {
                this.cwF.E(agQ);
                return;
            }
            this.cwF.F(agQ);
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
        bVar.setUniqueId(this.cwD.getUniqueId());
        this.cwD.Gn().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.cwE;
    }

    private void showNetRefreshView(View view2, String str, boolean z) {
        if (this.cwI == null) {
            this.cwI = new g(getPageContext().getPageActivity(), new a());
        }
        this.cwI.setSubText(str);
        this.cwI.d(view2, z);
        this.cwI.Fu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view2) {
        if (this.cwI != null) {
            this.cwI.P(view2);
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
