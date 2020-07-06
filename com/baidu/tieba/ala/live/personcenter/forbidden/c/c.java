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
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView aUR;
    private CommonEmptyView bjC;
    private TbListViewPullView fAp;
    private LoadingView fAu;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a fQG;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a fQH;
    private PbListView fzx;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aUR = null;
        this.fQG = null;
        this.fQH = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fQG = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.aUR = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fQG);
        this.aUR.addAdapters(arrayList);
        this.fQH = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.aUR.addHeaderView(this.fQH.aDF());
        this.fAu = new LoadingView(tbPageContext.getPageActivity());
        this.fAp = new TbListViewPullView(this.mPageContext);
        this.fAp.setTag(this.mPageContext.getUniqueId());
        this.aUR.setPullRefresh(this.fAp);
        this.fzx = new PbListView(this.mPageContext.getPageActivity());
        this.fzx.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.fQH;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.qV(i);
        this.aUR.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aUR);
        this.aUR.setDivider(null);
        if (this.fQH != null) {
            this.fQH.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aUR != null) {
            this.aUR.completePullRefresh();
        }
    }

    public void bxb() {
        if (this.fzx != null) {
            if (this.fzx.getView().getParent() == null) {
                this.aUR.setNextPage(this.fzx);
            }
            this.fzx.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fzx.endLoadData();
        }
    }

    public void btJ() {
        if (this.fzx != null) {
            if (this.fzx.getView().getParent() == null) {
                this.aUR.setNextPage(this.fzx);
            }
            this.fzx.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.fzx.endLoadData();
        }
    }

    public void btK() {
        if (this.fzx != null) {
            if (this.fzx.getView().getParent() == null) {
                this.aUR.setNextPage(this.fzx);
            }
            this.fzx.showLoadingViewWithoutEmptyView();
            this.fzx.startLoadData();
        }
    }

    public void bxw() {
        this.aUR.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.aUR.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fzx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fAp.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bjC == null) {
                this.bjC = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bjC.addToParent((RelativeLayout) this.mRootView);
            }
            this.bjC.reset();
            this.bjC.setTitle(i);
            this.bjC.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.bjC.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bjC.setVisibility(0);
        }
    }

    public void btO() {
        if (this.bjC != null) {
            this.bjC.setVisibility(8);
        }
    }

    public void byK() {
        if (this.aUR != null) {
            this.aUR.setVisibility(0);
        }
    }

    public void byL() {
        if (this.aUR != null) {
            this.aUR.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bjC == null) {
                this.bjC = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bjC.addToParent((RelativeLayout) this.mRootView);
            }
            this.bjC.reset();
            this.bjC.setTitle(a.i.sdk_prc_person_forbiddenlist_empty);
            this.bjC.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bjC.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bjC != null) {
            this.bjC.setVisibility(8);
        }
    }
}
