package com.baidu.tieba.ala.live.personcenter.forbidden.c;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.core.view.TbListViewPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private BdTypeListView bjg;
    private CommonEmptyView byP;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a gLs;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a gLt;
    private PbListView gpG;
    private TbListViewPullView gqB;
    private LoadingView gqG;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bjg = null;
        this.gLs = null;
        this.gLt = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gLs = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.bjg = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gLs);
        this.bjg.addAdapters(arrayList);
        this.gLt = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.bjg.addHeaderView(this.gLt.aVC());
        this.gqG = new LoadingView(tbPageContext.getPageActivity());
        this.gqB = new TbListViewPullView(this.mPageContext);
        this.gqB.setTag(this.mPageContext.getUniqueId());
        this.bjg.setPullRefresh(this.gqB);
        this.gpG = new PbListView(this.mPageContext.getPageActivity());
        this.gpG.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.gLt;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.uO(i);
        this.bjg.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bjg);
        this.bjg.setDivider(null);
        if (this.gLt != null) {
            this.gLt.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bjg != null) {
            this.bjg.completePullRefresh();
        }
    }

    public void bQm() {
        if (this.gpG != null) {
            if (this.gpG.getView().getParent() == null) {
                this.bjg.setNextPage(this.gpG);
            }
            this.gpG.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.gpG.endLoadData();
        }
    }

    public void bMw() {
        if (this.gpG != null) {
            if (this.gpG.getView().getParent() == null) {
                this.bjg.setNextPage(this.gpG);
            }
            this.gpG.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.gpG.endLoadData();
        }
    }

    public void bMx() {
        if (this.gpG != null) {
            if (this.gpG.getView().getParent() == null) {
                this.bjg.setNextPage(this.gpG);
            }
            this.gpG.showLoadingViewWithoutEmptyView();
            this.gpG.startLoadData();
        }
    }

    public void bQH() {
        this.bjg.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.bjg.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gpG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gqB.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.byP == null) {
                this.byP = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.byP.addToParent((RelativeLayout) this.mRootView);
            }
            this.byP.reset();
            this.byP.setTitle(i);
            this.byP.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.byP.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.byP.setVisibility(0);
        }
    }

    public void TK() {
        if (this.byP != null) {
            this.byP.setVisibility(8);
        }
    }

    public void bSR() {
        if (this.bjg != null) {
            this.bjg.setVisibility(0);
        }
    }

    public void bSS() {
        if (this.bjg != null) {
            this.bjg.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.byP == null) {
                this.byP = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.byP.addToParent((RelativeLayout) this.mRootView);
            }
            this.byP.reset();
            this.byP.setTitle(a.i.sdk_prc_person_forbiddenlist_empty);
            this.byP.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.byP.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.byP != null) {
            this.byP.setVisibility(8);
        }
    }
}
