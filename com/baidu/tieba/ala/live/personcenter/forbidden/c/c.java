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
    private BdTypeListView bhJ;
    private CommonEmptyView bwB;
    private PbListView gfD;
    private LoadingView ggD;
    private TbListViewPullView ggy;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a gzE;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a gzF;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bhJ = null;
        this.gzE = null;
        this.gzF = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gzE = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.bhJ = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gzE);
        this.bhJ.addAdapters(arrayList);
        this.gzF = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.bhJ.addHeaderView(this.gzF.aTI());
        this.ggD = new LoadingView(tbPageContext.getPageActivity());
        this.ggy = new TbListViewPullView(this.mPageContext);
        this.ggy.setTag(this.mPageContext.getUniqueId());
        this.bhJ.setPullRefresh(this.ggy);
        this.gfD = new PbListView(this.mPageContext.getPageActivity());
        this.gfD.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.gzF;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.uv(i);
        this.bhJ.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bhJ);
        this.bhJ.setDivider(null);
        if (this.gzF != null) {
            this.gzF.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bhJ != null) {
            this.bhJ.completePullRefresh();
        }
    }

    public void bNH() {
        if (this.gfD != null) {
            if (this.gfD.getView().getParent() == null) {
                this.bhJ.setNextPage(this.gfD);
            }
            this.gfD.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.gfD.endLoadData();
        }
    }

    public void bJU() {
        if (this.gfD != null) {
            if (this.gfD.getView().getParent() == null) {
                this.bhJ.setNextPage(this.gfD);
            }
            this.gfD.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.gfD.endLoadData();
        }
    }

    public void bJV() {
        if (this.gfD != null) {
            if (this.gfD.getView().getParent() == null) {
                this.bhJ.setNextPage(this.gfD);
            }
            this.gfD.showLoadingViewWithoutEmptyView();
            this.gfD.startLoadData();
        }
    }

    public void bOc() {
        this.bhJ.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.bhJ.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gfD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.ggy.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bwB == null) {
                this.bwB = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bwB.addToParent((RelativeLayout) this.mRootView);
            }
            this.bwB.reset();
            this.bwB.setTitle(i);
            this.bwB.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.bwB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bwB.setVisibility(0);
        }
    }

    public void SK() {
        if (this.bwB != null) {
            this.bwB.setVisibility(8);
        }
    }

    public void bPU() {
        if (this.bhJ != null) {
            this.bhJ.setVisibility(0);
        }
    }

    public void bPV() {
        if (this.bhJ != null) {
            this.bhJ.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bwB == null) {
                this.bwB = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bwB.addToParent((RelativeLayout) this.mRootView);
            }
            this.bwB.reset();
            this.bwB.setTitle(a.i.sdk_prc_person_forbiddenlist_empty);
            this.bwB.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bwB.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bwB != null) {
            this.bwB.setVisibility(8);
        }
    }
}
