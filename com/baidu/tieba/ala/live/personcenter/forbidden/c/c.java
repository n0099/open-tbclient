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
    private CommonEmptyView bIx;
    private BdTypeListView bnh;
    private PbListView gDK;
    private TbListViewPullView gEF;
    private LoadingView gEK;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a gZY;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a gZZ;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bnh = null;
        this.gZY = null;
        this.gZZ = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gZY = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.bnh = (BdTypeListView) view.findViewById(a.f.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gZY);
        this.bnh.addAdapters(arrayList);
        this.gZZ = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.bnh.addHeaderView(this.gZZ.baz());
        this.gEK = new LoadingView(tbPageContext.getPageActivity());
        this.gEF = new TbListViewPullView(this.mPageContext);
        this.gEF.setTag(this.mPageContext.getUniqueId());
        this.bnh.setPullRefresh(this.gEF);
        this.gDK = new PbListView(this.mPageContext.getPageActivity());
        this.gDK.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.gZZ;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.wd(i);
        this.bnh.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bnh);
        this.bnh.setDivider(null);
        if (this.gZZ != null) {
            this.gZZ.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bnh != null) {
            this.bnh.completePullRefresh();
        }
    }

    public void bVP() {
        if (this.gDK != null) {
            if (this.gDK.getView().getParent() == null) {
                this.bnh.setNextPage(this.gDK);
            }
            this.gDK.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gDK.endLoadData();
        }
    }

    public void bSa() {
        if (this.gDK != null) {
            if (this.gDK.getView().getParent() == null) {
                this.bnh.setNextPage(this.gDK);
            }
            this.gDK.setText(this.mPageContext.getResources().getString(a.h.sdk_list_no_more));
            this.gDK.endLoadData();
        }
    }

    public void bSb() {
        if (this.gDK != null) {
            if (this.gDK.getView().getParent() == null) {
                this.bnh.setNextPage(this.gDK);
            }
            this.gDK.showLoadingViewWithoutEmptyView();
            this.gDK.startLoadData();
        }
    }

    public void bWk() {
        this.bnh.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.bnh.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gDK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gEF.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bIx == null) {
                this.bIx = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bIx.addToParent((RelativeLayout) this.mRootView);
            }
            this.bIx.reset();
            this.bIx.setTitle(i);
            this.bIx.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bIx.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bIx.setVisibility(0);
        }
    }

    public void Yb() {
        if (this.bIx != null) {
            this.bIx.setVisibility(8);
        }
    }

    public void bYs() {
        if (this.bnh != null) {
            this.bnh.setVisibility(0);
        }
    }

    public void bYt() {
        if (this.bnh != null) {
            this.bnh.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bIx == null) {
                this.bIx = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bIx.addToParent((RelativeLayout) this.mRootView);
            }
            this.bIx.reset();
            this.bIx.setTitle(a.h.sdk_prc_person_forbiddenlist_empty);
            this.bIx.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bIx.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bIx != null) {
            this.bIx.setVisibility(8);
        }
    }
}
