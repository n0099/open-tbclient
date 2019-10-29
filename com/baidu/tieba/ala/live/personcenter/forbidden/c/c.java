package com.baidu.tieba.ala.live.personcenter.forbidden.c;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.core.view.TbListViewPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private BdTypeListView agS;
    private CommonEmptyView aqz;
    private TbListViewPullView dFQ;
    private LoadingView dFV;
    private PbListView dFz;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a dSr;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a dSs;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.agS = null;
        this.dSr = null;
        this.dSs = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dSr = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.agS = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.dSr);
        this.agS.addAdapters(arrayList);
        this.dSs = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.agS.addHeaderView(this.dSs.Yt());
        this.dFV = new LoadingView(tbPageContext.getPageActivity());
        this.dFQ = new TbListViewPullView(this.mPageContext);
        this.dFQ.setTag(this.mPageContext.getUniqueId());
        this.agS.setPullRefresh(this.dFQ);
        this.dFz = new PbListView(this.mPageContext.getPageActivity());
        this.dFz.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.dSs;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.mU(i);
        this.agS.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.agS);
        this.agS.setDivider(null);
        if (this.dSs != null) {
            this.dSs.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.agS != null) {
            this.agS.completePullRefresh();
        }
    }

    public void aKW() {
        if (this.dFz != null) {
            if (this.dFz.getView().getParent() == null) {
                this.agS.setNextPage(this.dFz);
            }
            this.dFz.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.dFz.endLoadData();
        }
    }

    public void aJk() {
        if (this.dFz != null) {
            if (this.dFz.getView().getParent() == null) {
                this.agS.setNextPage(this.dFz);
            }
            this.dFz.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.dFz.endLoadData();
        }
    }

    public void aJl() {
        if (this.dFz != null) {
            if (this.dFz.getView().getParent() == null) {
                this.agS.setNextPage(this.dFz);
            }
            this.dFz.showLoadingViewWithoutEmptyView();
            this.dFz.startLoadData();
        }
    }

    public void aLr() {
        this.agS.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.agS.setOnSrollToBottomListener(onScrollToBottomListener);
        this.dFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.dFQ.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aqz == null) {
                this.aqz = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aqz.addToParent((RelativeLayout) this.mRootView);
            }
            this.aqz.reset();
            this.aqz.setTitle(i);
            this.aqz.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aqz.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aqz.setVisibility(0);
        }
    }

    public void aJo() {
        if (this.aqz != null) {
            this.aqz.setVisibility(8);
        }
    }

    public void aMq() {
        if (this.agS != null) {
            this.agS.setVisibility(0);
        }
    }

    public void aMr() {
        if (this.agS != null) {
            this.agS.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aqz == null) {
                this.aqz = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aqz.addToParent((RelativeLayout) this.mRootView);
            }
            this.aqz.reset();
            this.aqz.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aqz.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aqz.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aqz != null) {
            this.aqz.setVisibility(8);
        }
    }
}
