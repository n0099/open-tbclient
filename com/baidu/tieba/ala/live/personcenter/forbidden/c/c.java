package com.baidu.tieba.ala.live.personcenter.forbidden.c;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.core.view.TbListViewPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.u.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView aMf;
    private CommonEmptyView aWT;
    private PbListView far;
    private TbListViewPullView fbl;
    private LoadingView fbq;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a fro;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a frp;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aMf = null;
        this.fro = null;
        this.frp = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fro = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.aMf = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fro);
        this.aMf.addAdapters(arrayList);
        this.frp = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.aMf.addHeaderView(this.frp.ayH());
        this.fbq = new LoadingView(tbPageContext.getPageActivity());
        this.fbl = new TbListViewPullView(this.mPageContext);
        this.fbl.setTag(this.mPageContext.getUniqueId());
        this.aMf.setPullRefresh(this.fbl);
        this.far = new PbListView(this.mPageContext.getPageActivity());
        this.far.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.frp;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.pS(i);
        this.aMf.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aMf);
        this.aMf.setDivider(null);
        if (this.frp != null) {
            this.frp.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aMf != null) {
            this.aMf.completePullRefresh();
        }
    }

    public void bom() {
        if (this.far != null) {
            if (this.far.getView().getParent() == null) {
                this.aMf.setNextPage(this.far);
            }
            this.far.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.far.endLoadData();
        }
    }

    public void blp() {
        if (this.far != null) {
            if (this.far.getView().getParent() == null) {
                this.aMf.setNextPage(this.far);
            }
            this.far.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.far.endLoadData();
        }
    }

    public void blq() {
        if (this.far != null) {
            if (this.far.getView().getParent() == null) {
                this.aMf.setNextPage(this.far);
            }
            this.far.showLoadingViewWithoutEmptyView();
            this.far.startLoadData();
        }
    }

    public void boI() {
        this.aMf.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.aMf.setOnSrollToBottomListener(onScrollToBottomListener);
        this.far.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fbl.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aWT == null) {
                this.aWT = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aWT.addToParent((RelativeLayout) this.mRootView);
            }
            this.aWT.reset();
            this.aWT.setTitle(i);
            this.aWT.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aWT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aWT.setVisibility(0);
        }
    }

    public void blt() {
        if (this.aWT != null) {
            this.aWT.setVisibility(8);
        }
    }

    public void bpV() {
        if (this.aMf != null) {
            this.aMf.setVisibility(0);
        }
    }

    public void bpW() {
        if (this.aMf != null) {
            this.aMf.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aWT == null) {
                this.aWT = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aWT.addToParent((RelativeLayout) this.mRootView);
            }
            this.aWT.reset();
            this.aWT.setTitle(a.i.sdk_prc_person_forbiddenlist_empty);
            this.aWT.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aWT.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aWT != null) {
            this.aWT.setVisibility(8);
        }
    }
}
