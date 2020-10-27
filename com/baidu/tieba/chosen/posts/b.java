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
    private NavigationBar fOZ;
    private g gmB;
    private NoNetworkView gxq;
    private ChosenPostActivity hWV;
    private BdListView hWW;
    private com.baidu.tieba.chosen.posts.a hWX;
    private com.baidu.tbadk.mvc.g.a hWY;
    private boolean hWZ;
    private h hXa;
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    int paddingHorizontal;
    int paddingTop;

    protected com.baidu.tbadk.core.view.g cmC() {
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.hWV.getPageContext());
        }
        return this.mPullView;
    }

    public b(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        this.hWZ = false;
        this.hWV = chosenPostActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bQd() {
        this.mRootView = this.hWV.getLayoutInflater().inflate(R.layout.chosen_post_activity, (ViewGroup) null);
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cmD() {
        this.paddingTop = this.hWV.getResources().getDimensionPixelSize(R.dimen.ds108);
        this.paddingHorizontal = this.hWV.getResources().getDimensionPixelSize(R.dimen.ds150);
        this.fOZ = (NavigationBar) getView().findViewById(R.id.chosen_post_navigation_bar);
        this.fOZ.setTitleText(R.string.recommend_frs_hot_thread_title);
        this.fOZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hWW = (BdListView) getView().findViewById(R.id.chosen_post_list);
        this.gxq = (NoNetworkView) getView().findViewById(R.id.view_no_network);
        this.hWX = new com.baidu.tieba.chosen.posts.a(this.hWV.getPageContext(), new Class[]{com.baidu.tieba.chosen.posts.a.c.class, com.baidu.tieba.chosen.posts.a.b.class, com.baidu.tieba.chosen.posts.a.a.class}, new int[]{R.layout.chosen_picture_layout, R.layout.chosen_no_picture_layout, R.layout.chosen_image_text_layout}, this.hWV.bzy());
        this.hWW.setAdapter((ListAdapter) this.hWX);
        this.mPullView = cmC();
        this.hWW.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.chosen.posts.b.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                b.this.hWV.cmy().ou(z);
            }
        });
        this.hWW.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.chosen.posts.b.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                tinfo item = b.this.hWX.getItem(i);
                if (item != null) {
                    TiebaStatic.eventStat(b.this.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
                    b.this.getPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(b.this.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
                }
            }
        });
        this.hWW.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.chosen.posts.b.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(b.this.getActivity());
                aVar.Ba(b.this.getActivity().getString(R.string.chosen_post_dialog_text));
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
                        bVar.setExtra(b.this.hWX.getItem(i));
                        bVar.setUniqueId(b.this.hWV.getUniqueId());
                        b.this.hWV.bzy().dispatchMvcEvent(bVar);
                    }
                });
                aVar.b(b.this.hWV.getPageContext());
                aVar.bmC();
                return true;
            }
        });
        this.hWW.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.chosen.posts.b.4
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                if (l.isNetOk()) {
                    b.this.hWV.cmy().cmB();
                } else if (b.this.hWY != null) {
                    b.this.hWY.display();
                    b.this.hWY.ry(R.string.no_more_msg);
                }
            }
        });
        this.hWY = new com.baidu.tbadk.mvc.g.a(this.hWV);
        this.hWY.createView();
        getListView().setNextPage(this.hWY);
        this.gmB = new g(getActivity());
        this.gmB.onChangeSkinType();
        this.gmB.attachView(getView(), true);
        this.hWV.cmy().cmA();
    }

    public Activity getActivity() {
        return this.hWV.getPageContext().getPageActivity();
    }

    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        switch (bVar.bzc()) {
            case 4097:
                this.hWZ = false;
                break;
            case 4098:
                this.hWZ = true;
                break;
            case 4099:
                a(bVar.bzd());
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
            this.hWX.eX(((Long) extra).longValue());
            if (this.hWX.getCount() <= 5) {
                cmE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (this.gmB != null) {
            this.gmB.dettachView(getView());
        }
        if (errorData != null && this.hWX.bzu() <= 0) {
            showNetRefreshView(getView(), getPageContext().getResources().getString(R.string.net_error_text, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
        }
        this.hWW.completePullRefreshPostDelayed(0L);
        if (this.hWY != null) {
            this.hWY.ry(R.string.no_more_msg);
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.fOZ != null) {
            this.fOZ.onChangeSkinType(tbPageContext, i);
        }
        if (this.hWX != null) {
            this.hWX.b(tbPageContext, i);
        }
        if (this.hWY != null) {
            this.hWY.b(tbPageContext, i);
        }
        if (this.gxq != null) {
            this.gxq.onChangeSkinType(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.bzs()) {
                this.hWY.display();
                if (aVar.bzq()) {
                    this.hWY.rx(R.string.loading);
                } else if (!aVar.bzr()) {
                    this.hWY.ry(R.string.no_more_msg);
                }
            } else {
                this.hWY.hide();
            }
            if (!aVar.isPullRefreshing()) {
                this.hWW.completePullRefreshPostDelayed(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof com.baidu.tieba.chosen.posts.request.b) {
            List<tinfo> cmG = ((com.baidu.tieba.chosen.posts.request.b) aVar).cmG();
            if (cmG != null && cmG.size() > 0) {
                this.hWW.setVisibility(0);
            }
            if (this.gmB != null) {
                this.gmB.dettachView(getView());
            }
            if (this.hWZ) {
                this.hWX.bu(cmG);
                return;
            }
            this.hWX.bv(cmG);
            if (cmG != null) {
                BdToast a2 = BdToast.a(getActivity(), getActivity().getString(R.string.chosen_post_recommend, new Object[]{Integer.valueOf(cmG.size())}), 0);
                a2.ov(48);
                a2.setOffsetY(this.paddingTop);
                a2.setPaddingHorizontal(this.paddingHorizontal);
                a2.bmH().bmI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmE() {
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4100, null, null, null);
        bVar.setUniqueId(this.hWV.getUniqueId());
        this.hWV.bzy().dispatchMvcEvent(bVar);
    }

    public BdListView getListView() {
        return this.hWW;
    }

    private void showNetRefreshView(View view, String str, boolean z) {
        if (this.hXa == null) {
            this.hXa = new h(getPageContext().getPageActivity(), new a());
        }
        this.hXa.setSubText(str);
        this.hXa.attachView(view, z);
        this.hXa.showRefreshButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNetRefreshView(View view) {
        if (this.hXa != null) {
            this.hXa.dettachView(view);
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
            b.this.gmB.attachView(b.this.getView(), true);
            b.this.cmE();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
