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
    private CommonEmptyView bMk;
    private BdTypeListView bnu;
    private PbListView gNM;
    private TbListViewPullView gOG;
    private LoadingView gOL;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a hlL;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a hlM;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bnu = null;
        this.hlL = null;
        this.hlM = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hlL = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.bnu = (BdTypeListView) view.findViewById(a.f.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.hlL);
        this.bnu.addAdapters(arrayList);
        this.hlM = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.bnu.addHeaderView(this.hlM.aZl());
        this.gOL = new LoadingView(tbPageContext.getPageActivity());
        this.gOG = new TbListViewPullView(this.mPageContext);
        this.gOG.setTag(this.mPageContext.getUniqueId());
        this.bnu.setPullRefresh(this.gOG);
        this.gNM = new PbListView(this.mPageContext.getPageActivity());
        this.gNM.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.hlM;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.uS(i);
        this.bnu.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bnu);
        this.bnu.setDivider(null);
        if (this.hlM != null) {
            this.hlM.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bnu != null) {
            this.bnu.completePullRefresh();
        }
    }

    public void bVp() {
        if (this.gNM != null) {
            if (this.gNM.getView().getParent() == null) {
                this.bnu.setNextPage(this.gNM);
            }
            this.gNM.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gNM.endLoadData();
        }
    }

    public void bRx() {
        if (this.gNM != null) {
            if (this.gNM.getView().getParent() == null) {
                this.bnu.setNextPage(this.gNM);
            }
            this.gNM.setText(this.mPageContext.getResources().getString(a.h.sdk_list_no_more));
            this.gNM.endLoadData();
        }
    }

    public void bRy() {
        if (this.gNM != null) {
            if (this.gNM.getView().getParent() == null) {
                this.bnu.setNextPage(this.gNM);
            }
            this.gNM.showLoadingViewWithoutEmptyView();
            this.gNM.startLoadData();
        }
    }

    public void bVL() {
        this.bnu.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.bnu.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gNM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gOG.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bMk == null) {
                this.bMk = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bMk.addToParent((RelativeLayout) this.mRootView);
            }
            this.bMk.reset();
            this.bMk.setTitle(i);
            this.bMk.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bMk.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bMk.setVisibility(0);
        }
    }

    public void WZ() {
        if (this.bMk != null) {
            this.bMk.setVisibility(8);
        }
    }

    public void bYo() {
        if (this.bnu != null) {
            this.bnu.setVisibility(0);
        }
    }

    public void bYp() {
        if (this.bnu != null) {
            this.bnu.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bMk == null) {
                this.bMk = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bMk.addToParent((RelativeLayout) this.mRootView);
            }
            this.bMk.reset();
            this.bMk.setTitle(a.h.sdk_prc_person_forbiddenlist_empty);
            this.bMk.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bMk.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bMk != null) {
            this.bMk.setVisibility(8);
        }
    }
}
