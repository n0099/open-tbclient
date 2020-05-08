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
    private BdTypeListView aMl;
    private CommonEmptyView aWY;
    private PbListView faw;
    private TbListViewPullView fbq;
    private LoadingView fbv;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a fru;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a frv;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aMl = null;
        this.fru = null;
        this.frv = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fru = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.aMl = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fru);
        this.aMl.addAdapters(arrayList);
        this.frv = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.aMl.addHeaderView(this.frv.ayH());
        this.fbv = new LoadingView(tbPageContext.getPageActivity());
        this.fbq = new TbListViewPullView(this.mPageContext);
        this.fbq.setTag(this.mPageContext.getUniqueId());
        this.aMl.setPullRefresh(this.fbq);
        this.faw = new PbListView(this.mPageContext.getPageActivity());
        this.faw.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.frv;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.pS(i);
        this.aMl.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aMl);
        this.aMl.setDivider(null);
        if (this.frv != null) {
            this.frv.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aMl != null) {
            this.aMl.completePullRefresh();
        }
    }

    public void bok() {
        if (this.faw != null) {
            if (this.faw.getView().getParent() == null) {
                this.aMl.setNextPage(this.faw);
            }
            this.faw.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.faw.endLoadData();
        }
    }

    public void bln() {
        if (this.faw != null) {
            if (this.faw.getView().getParent() == null) {
                this.aMl.setNextPage(this.faw);
            }
            this.faw.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.faw.endLoadData();
        }
    }

    public void blo() {
        if (this.faw != null) {
            if (this.faw.getView().getParent() == null) {
                this.aMl.setNextPage(this.faw);
            }
            this.faw.showLoadingViewWithoutEmptyView();
            this.faw.startLoadData();
        }
    }

    public void boG() {
        this.aMl.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.aMl.setOnSrollToBottomListener(onScrollToBottomListener);
        this.faw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fbq.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aWY == null) {
                this.aWY = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aWY.addToParent((RelativeLayout) this.mRootView);
            }
            this.aWY.reset();
            this.aWY.setTitle(i);
            this.aWY.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aWY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aWY.setVisibility(0);
        }
    }

    public void blr() {
        if (this.aWY != null) {
            this.aWY.setVisibility(8);
        }
    }

    public void bpT() {
        if (this.aMl != null) {
            this.aMl.setVisibility(0);
        }
    }

    public void bpU() {
        if (this.aMl != null) {
            this.aMl.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aWY == null) {
                this.aWY = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aWY.addToParent((RelativeLayout) this.mRootView);
            }
            this.aWY.reset();
            this.aWY.setTitle(a.i.sdk_prc_person_forbiddenlist_empty);
            this.aWY.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aWY.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aWY != null) {
            this.aWY.setVisibility(8);
        }
    }
}
