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
    private CommonEmptyView bDp;
    private BdTypeListView biP;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a gQL;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a gQM;
    private TbListViewPullView gvW;
    private PbListView gvb;
    private LoadingView gwb;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.biP = null;
        this.gQL = null;
        this.gQM = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gQL = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.biP = (BdTypeListView) view.findViewById(a.f.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gQL);
        this.biP.addAdapters(arrayList);
        this.gQM = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.biP.addHeaderView(this.gQM.aXu());
        this.gwb = new LoadingView(tbPageContext.getPageActivity());
        this.gvW = new TbListViewPullView(this.mPageContext);
        this.gvW.setTag(this.mPageContext.getUniqueId());
        this.biP.setPullRefresh(this.gvW);
        this.gvb = new PbListView(this.mPageContext.getPageActivity());
        this.gvb.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.gQM;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.vw(i);
        this.biP.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.biP);
        this.biP.setDivider(null);
        if (this.gQM != null) {
            this.gQM.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.biP != null) {
            this.biP.completePullRefresh();
        }
    }

    public void bSf() {
        if (this.gvb != null) {
            if (this.gvb.getView().getParent() == null) {
                this.biP.setNextPage(this.gvb);
            }
            this.gvb.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gvb.endLoadData();
        }
    }

    public void bOp() {
        if (this.gvb != null) {
            if (this.gvb.getView().getParent() == null) {
                this.biP.setNextPage(this.gvb);
            }
            this.gvb.setText(this.mPageContext.getResources().getString(a.h.sdk_list_no_more));
            this.gvb.endLoadData();
        }
    }

    public void bOq() {
        if (this.gvb != null) {
            if (this.gvb.getView().getParent() == null) {
                this.biP.setNextPage(this.gvb);
            }
            this.gvb.showLoadingViewWithoutEmptyView();
            this.gvb.startLoadData();
        }
    }

    public void bSA() {
        this.biP.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.biP.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gvb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gvW.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bDp == null) {
                this.bDp = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bDp.addToParent((RelativeLayout) this.mRootView);
            }
            this.bDp.reset();
            this.bDp.setTitle(i);
            this.bDp.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bDp.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bDp.setVisibility(0);
        }
    }

    public void VB() {
        if (this.bDp != null) {
            this.bDp.setVisibility(8);
        }
    }

    public void bUJ() {
        if (this.biP != null) {
            this.biP.setVisibility(0);
        }
    }

    public void bUK() {
        if (this.biP != null) {
            this.biP.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bDp == null) {
                this.bDp = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bDp.addToParent((RelativeLayout) this.mRootView);
            }
            this.bDp.reset();
            this.bDp.setTitle(a.h.sdk_prc_person_forbiddenlist_empty);
            this.bDp.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bDp.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bDp != null) {
            this.bDp.setVisibility(8);
        }
    }
}
