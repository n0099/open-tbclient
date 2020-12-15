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
    private PbListView gDM;
    private TbListViewPullView gEH;
    private LoadingView gEM;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a haa;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a hab;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bnh = null;
        this.haa = null;
        this.hab = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.haa = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.bnh = (BdTypeListView) view.findViewById(a.f.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.haa);
        this.bnh.addAdapters(arrayList);
        this.hab = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.bnh.addHeaderView(this.hab.baz());
        this.gEM = new LoadingView(tbPageContext.getPageActivity());
        this.gEH = new TbListViewPullView(this.mPageContext);
        this.gEH.setTag(this.mPageContext.getUniqueId());
        this.bnh.setPullRefresh(this.gEH);
        this.gDM = new PbListView(this.mPageContext.getPageActivity());
        this.gDM.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.hab;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.wd(i);
        this.bnh.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bnh);
        this.bnh.setDivider(null);
        if (this.hab != null) {
            this.hab.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bnh != null) {
            this.bnh.completePullRefresh();
        }
    }

    public void bVQ() {
        if (this.gDM != null) {
            if (this.gDM.getView().getParent() == null) {
                this.bnh.setNextPage(this.gDM);
            }
            this.gDM.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gDM.endLoadData();
        }
    }

    public void bSb() {
        if (this.gDM != null) {
            if (this.gDM.getView().getParent() == null) {
                this.bnh.setNextPage(this.gDM);
            }
            this.gDM.setText(this.mPageContext.getResources().getString(a.h.sdk_list_no_more));
            this.gDM.endLoadData();
        }
    }

    public void bSc() {
        if (this.gDM != null) {
            if (this.gDM.getView().getParent() == null) {
                this.bnh.setNextPage(this.gDM);
            }
            this.gDM.showLoadingViewWithoutEmptyView();
            this.gDM.startLoadData();
        }
    }

    public void bWl() {
        this.bnh.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.bnh.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gEH.setListPullRefreshListener(listPullRefreshListener);
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

    public void bYt() {
        if (this.bnh != null) {
            this.bnh.setVisibility(0);
        }
    }

    public void bYu() {
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
