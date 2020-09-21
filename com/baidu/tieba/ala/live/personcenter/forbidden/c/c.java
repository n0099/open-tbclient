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
    private BdTypeListView bdX;
    private CommonEmptyView bsN;
    private PbListView fTk;
    private TbListViewPullView fUf;
    private LoadingView fUk;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a gll;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a glm;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bdX = null;
        this.gll = null;
        this.glm = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gll = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.bdX = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gll);
        this.bdX.addAdapters(arrayList);
        this.glm = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.bdX.addHeaderView(this.glm.aQZ());
        this.fUk = new LoadingView(tbPageContext.getPageActivity());
        this.fUf = new TbListViewPullView(this.mPageContext);
        this.fUf.setTag(this.mPageContext.getUniqueId());
        this.bdX.setPullRefresh(this.fUf);
        this.fTk = new PbListView(this.mPageContext.getPageActivity());
        this.fTk.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.glm;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.tQ(i);
        this.bdX.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bdX);
        this.bdX.setDivider(null);
        if (this.glm != null) {
            this.glm.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bdX != null) {
            this.bdX.completePullRefresh();
        }
    }

    public void bKX() {
        if (this.fTk != null) {
            if (this.fTk.getView().getParent() == null) {
                this.bdX.setNextPage(this.fTk);
            }
            this.fTk.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fTk.endLoadData();
        }
    }

    public void bHi() {
        if (this.fTk != null) {
            if (this.fTk.getView().getParent() == null) {
                this.bdX.setNextPage(this.fTk);
            }
            this.fTk.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.fTk.endLoadData();
        }
    }

    public void bHj() {
        if (this.fTk != null) {
            if (this.fTk.getView().getParent() == null) {
                this.bdX.setNextPage(this.fTk);
            }
            this.fTk.showLoadingViewWithoutEmptyView();
            this.fTk.startLoadData();
        }
    }

    public void bLs() {
        this.bdX.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.bdX.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fTk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fUf.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bsN == null) {
                this.bsN = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bsN.addToParent((RelativeLayout) this.mRootView);
            }
            this.bsN.reset();
            this.bsN.setTitle(i);
            this.bsN.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.bsN.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bsN.setVisibility(0);
        }
    }

    public void bHn() {
        if (this.bsN != null) {
            this.bsN.setVisibility(8);
        }
    }

    public void bMD() {
        if (this.bdX != null) {
            this.bdX.setVisibility(0);
        }
    }

    public void bME() {
        if (this.bdX != null) {
            this.bdX.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bsN == null) {
                this.bsN = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bsN.addToParent((RelativeLayout) this.mRootView);
            }
            this.bsN.reset();
            this.bsN.setTitle(a.i.sdk_prc_person_forbiddenlist_empty);
            this.bsN.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bsN.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bsN != null) {
            this.bsN.setVisibility(8);
        }
    }
}
