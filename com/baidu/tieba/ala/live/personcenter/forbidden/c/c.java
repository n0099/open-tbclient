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
    private BdTypeListView aWh;
    private CommonEmptyView bjW;
    private PbListView fEE;
    private LoadingView fFE;
    private TbListViewPullView fFz;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a fVZ;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a fWa;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aWh = null;
        this.fVZ = null;
        this.fWa = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fVZ = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.aWh = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fVZ);
        this.aWh.addAdapters(arrayList);
        this.fWa = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.aWh.addHeaderView(this.fWa.aHv());
        this.fFE = new LoadingView(tbPageContext.getPageActivity());
        this.fFz = new TbListViewPullView(this.mPageContext);
        this.fFz.setTag(this.mPageContext.getUniqueId());
        this.aWh.setPullRefresh(this.fFz);
        this.fEE = new PbListView(this.mPageContext.getPageActivity());
        this.fEE.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.fWa;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.rl(i);
        this.aWh.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aWh);
        this.aWh.setDivider(null);
        if (this.fWa != null) {
            this.fWa.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aWh != null) {
            this.aWh.completePullRefresh();
        }
    }

    public void bAr() {
        if (this.fEE != null) {
            if (this.fEE.getView().getParent() == null) {
                this.aWh.setNextPage(this.fEE);
            }
            this.fEE.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fEE.endLoadData();
        }
    }

    public void bwS() {
        if (this.fEE != null) {
            if (this.fEE.getView().getParent() == null) {
                this.aWh.setNextPage(this.fEE);
            }
            this.fEE.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.fEE.endLoadData();
        }
    }

    public void bwT() {
        if (this.fEE != null) {
            if (this.fEE.getView().getParent() == null) {
                this.aWh.setNextPage(this.fEE);
            }
            this.fEE.showLoadingViewWithoutEmptyView();
            this.fEE.startLoadData();
        }
    }

    public void bAM() {
        this.aWh.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.aWh.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fEE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fFz.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bjW == null) {
                this.bjW = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bjW.addToParent((RelativeLayout) this.mRootView);
            }
            this.bjW.reset();
            this.bjW.setTitle(i);
            this.bjW.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.bjW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bjW.setVisibility(0);
        }
    }

    public void bwX() {
        if (this.bjW != null) {
            this.bjW.setVisibility(8);
        }
    }

    public void bBY() {
        if (this.aWh != null) {
            this.aWh.setVisibility(0);
        }
    }

    public void bBZ() {
        if (this.aWh != null) {
            this.aWh.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bjW == null) {
                this.bjW = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bjW.addToParent((RelativeLayout) this.mRootView);
            }
            this.bjW.reset();
            this.bjW.setTitle(a.i.sdk_prc_person_forbiddenlist_empty);
            this.bjW.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bjW.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bjW != null) {
            this.bjW.setVisibility(8);
        }
    }
}
