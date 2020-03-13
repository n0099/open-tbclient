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
    private CommonEmptyView aCY;
    private BdTypeListView asH;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a eMA;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a eMz;
    private TbListViewPullView ewM;
    private LoadingView ewR;
    private PbListView ewh;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.asH = null;
        this.eMz = null;
        this.eMA = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eMz = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.asH = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eMz);
        this.asH.addAdapters(arrayList);
        this.eMA = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.asH.addHeaderView(this.eMA.aqs());
        this.ewR = new LoadingView(tbPageContext.getPageActivity());
        this.ewM = new TbListViewPullView(this.mPageContext);
        this.ewM.setTag(this.mPageContext.getUniqueId());
        this.asH.setPullRefresh(this.ewM);
        this.ewh = new PbListView(this.mPageContext.getPageActivity());
        this.ewh.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.eMA;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.pw(i);
        this.asH.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.asH);
        this.asH.setDivider(null);
        if (this.eMA != null) {
            this.eMA.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.asH != null) {
            this.asH.completePullRefresh();
        }
    }

    public void beR() {
        if (this.ewh != null) {
            if (this.ewh.getView().getParent() == null) {
                this.asH.setNextPage(this.ewh);
            }
            this.ewh.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.ewh.endLoadData();
        }
    }

    public void bcu() {
        if (this.ewh != null) {
            if (this.ewh.getView().getParent() == null) {
                this.asH.setNextPage(this.ewh);
            }
            this.ewh.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.ewh.endLoadData();
        }
    }

    public void bcv() {
        if (this.ewh != null) {
            if (this.ewh.getView().getParent() == null) {
                this.asH.setNextPage(this.ewh);
            }
            this.ewh.showLoadingViewWithoutEmptyView();
            this.ewh.startLoadData();
        }
    }

    public void bfm() {
        this.asH.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.asH.setOnSrollToBottomListener(onScrollToBottomListener);
        this.ewh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.ewM.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aCY == null) {
                this.aCY = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCY.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCY.reset();
            this.aCY.setTitle(i);
            this.aCY.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aCY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aCY.setVisibility(0);
        }
    }

    public void bcy() {
        if (this.aCY != null) {
            this.aCY.setVisibility(8);
        }
    }

    public void bgz() {
        if (this.asH != null) {
            this.asH.setVisibility(0);
        }
    }

    public void bgA() {
        if (this.asH != null) {
            this.asH.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aCY == null) {
                this.aCY = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCY.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCY.reset();
            this.aCY.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aCY.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aCY.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aCY != null) {
            this.aCY.setVisibility(8);
        }
    }
}
