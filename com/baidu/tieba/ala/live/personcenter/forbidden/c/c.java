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
/* loaded from: classes11.dex */
public class c {
    private CommonEmptyView bNm;
    private BdTypeListView boO;
    private PbListView gPy;
    private TbListViewPullView gQs;
    private LoadingView gQx;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a hlO;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a hlP;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.boO = null;
        this.hlO = null;
        this.hlP = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hlO = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.boO = (BdTypeListView) view.findViewById(a.f.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.hlO);
        this.boO.addAdapters(arrayList);
        this.hlP = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.boO.addHeaderView(this.hlP.bcS());
        this.gQx = new LoadingView(tbPageContext.getPageActivity());
        this.gQs = new TbListViewPullView(this.mPageContext);
        this.gQs.setTag(this.mPageContext.getUniqueId());
        this.boO.setPullRefresh(this.gQs);
        this.gPy = new PbListView(this.mPageContext.getPageActivity());
        this.gPy.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.hlP;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.wo(i);
        this.boO.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.boO);
        this.boO.setDivider(null);
        if (this.hlP != null) {
            this.hlP.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.boO != null) {
            this.boO.completePullRefresh();
        }
    }

    public void bYv() {
        if (this.gPy != null) {
            if (this.gPy.getView().getParent() == null) {
                this.boO.setNextPage(this.gPy);
            }
            this.gPy.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gPy.endLoadData();
        }
    }

    public void bUD() {
        if (this.gPy != null) {
            if (this.gPy.getView().getParent() == null) {
                this.boO.setNextPage(this.gPy);
            }
            this.gPy.setText(this.mPageContext.getResources().getString(a.h.sdk_list_no_more));
            this.gPy.endLoadData();
        }
    }

    public void bUE() {
        if (this.gPy != null) {
            if (this.gPy.getView().getParent() == null) {
                this.boO.setNextPage(this.gPy);
            }
            this.gPy.showLoadingViewWithoutEmptyView();
            this.gPy.startLoadData();
        }
    }

    public void bYQ() {
        this.boO.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.boO.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gPy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gQs.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bNm == null) {
                this.bNm = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bNm.addToParent((RelativeLayout) this.mRootView);
            }
            this.bNm.reset();
            this.bNm.setTitle(i);
            this.bNm.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bNm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bNm.setVisibility(0);
        }
    }

    public void Zi() {
        if (this.bNm != null) {
            this.bNm.setVisibility(8);
        }
    }

    public void caY() {
        if (this.boO != null) {
            this.boO.setVisibility(0);
        }
    }

    public void caZ() {
        if (this.boO != null) {
            this.boO.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bNm == null) {
                this.bNm = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bNm.addToParent((RelativeLayout) this.mRootView);
            }
            this.bNm.reset();
            this.bNm.setTitle(a.h.sdk_prc_person_forbiddenlist_empty);
            this.bNm.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bNm.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bNm != null) {
            this.bNm.setVisibility(8);
        }
    }
}
