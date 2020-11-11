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
/* loaded from: classes23.dex */
public class b extends c<ChosenPostActivity> {
    private NavigationBar fUP;
    private NoNetworkView gDe;
    private g gso;
    private ChosenPostActivity icS;
    private BdListView icT;
    private com.baidu.tieba.chosen.posts.a icU;
    private com.baidu.tbadk.mvc.g.a icV;
    private boolean icW;
    private h icX;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g cpd() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.icS.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.icW = false;
        this.icS = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bSD() {
        this.mRootView = this.icS.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cpe() {
        this.paddingTop = this.icS.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.icS.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.fUP = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.fUP.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.fUP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.icT = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gDe = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.icU = new com.baidu.tieba.chosen.posts.a(this.icS.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.icS.bBX());
        this.icT.setAdapter((ListAdapter) this.icU);
        this.mPullView = cpd();
        this.icT.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.icS.coZ().oD(z);
            }
        });
        this.icT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.icU.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.icT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.Bo(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.icU.getItem(i));
                        bVar.setUniqueId(b.this.icS.getUniqueId());
                        b.this.icS.bBX().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.icS.getPageContext());
                aVar.bpc();
                return true;
            }
        });
        this.icT.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.icS.coZ().cpc();
                } else if (b.this.icV != null) {
                    b.this.icV.display();
                    b.this.icV.rI(R.string.no_more_msg);
                }
            }
        });
        this.icV = new com.baidu.tbadk.mvc.g.a(this.icS);
        this.icV.createView();
        getListView().setNextPage(this.icV);
        this.gso = new g(getActivity());
        this.gso.onChangeSkinType();
        this.gso.attachView(getView(), true);
        this.icS.coZ().cpb();
    }

    public Activity getActivity() {
        return this.icS.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bBB()) {
            case 4097:
                this.icW = false;
                break;
            case 4098:
                this.icW = true;
                break;
            case 4099:
                a(bVar.bBC());
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
            this.icU.ft(((Long) extra).longValue());
            if (this.icU.getCount() <= 5) {
                cpf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gso != null) {
            this.gso.dettachView(getView());
        }
        if (errorData != null && this.icU.bBT() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.icT.completePullRefreshPostDelayed(0L);
        if (this.icV != null) {
            this.icV.rI(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fUP != null) {
            this.fUP.onChangeSkinType(tbPageContext, i);
        }
        if (this.icU != null) {
            this.icU.b(tbPageContext, i);
        }
        if (this.icV != null) {
            this.icV.b(tbPageContext, i);
        }
        if (this.gDe != null) {
            this.gDe.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bBR()) {
                this.icV.display();
                if (aVar.bBP()) {
                    this.icV.rH(R.string.loading);
                } else if (!aVar.bBQ()) {
                    this.icV.rI(R.string.no_more_msg);
                }
            } else {
                this.icV.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.icT.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> cph = ((com.baidu.tieba.chosen.posts.request.b) aVar).cph();
            if (cph != null && cph.size() > 0) {
                this.icT.setVisibility(0);
            }
            if (this.gso != null) {
                this.gso.dettachView(getView());
            }
            if (this.icW) {
                this.icU.bB(cph);
                return;
            }
            this.icU.bC(cph);
            if (cph != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(cph.size())}), 0);
                a2.oF(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.bph().bpi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpf() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.icS.getUniqueId());
        this.icS.bBX().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.icT;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.icX == null) {
            this.icX = new h(getPageContext().getPageActivity(), new a());
        }
        this.icX.setSubText(str);
        this.icX.attachView(view, z);
        this.icX.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.icX != null) {
            this.icX.dettachView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.hideNetRefreshView(b.this.getView());
            b.this.gso.attachView(b.this.getView(), true);
            b.this.cpf();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
