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
    private BdTypeListView aSl;
    private CommonEmptyView beq;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a fFm;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a fFn;
    private PbListView fnZ;
    private TbListViewPullView foS;
    private LoadingView foX;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aSl = null;
        this.fFm = null;
        this.fFn = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fFm = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.aSl = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fFm);
        this.aSl.addAdapters(arrayList);
        this.fFn = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.aSl.addHeaderView(this.fFn.aCz());
        this.foX = new LoadingView(tbPageContext.getPageActivity());
        this.foS = new TbListViewPullView(this.mPageContext);
        this.foS.setTag(this.mPageContext.getUniqueId());
        this.aSl.setPullRefresh(this.foS);
        this.fnZ = new PbListView(this.mPageContext.getPageActivity());
        this.fnZ.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.fFn;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.qu(i);
        this.aSl.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aSl);
        this.aSl.setDivider(null);
        if (this.fFn != null) {
            this.fFn.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aSl != null) {
            this.aSl.completePullRefresh();
        }
    }

    public void bud() {
        if (this.fnZ != null) {
            if (this.fnZ.getView().getParent() == null) {
                this.aSl.setNextPage(this.fnZ);
            }
            this.fnZ.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fnZ.endLoadData();
        }
    }

    public void bqJ() {
        if (this.fnZ != null) {
            if (this.fnZ.getView().getParent() == null) {
                this.aSl.setNextPage(this.fnZ);
            }
            this.fnZ.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.fnZ.endLoadData();
        }
    }

    public void bqK() {
        if (this.fnZ != null) {
            if (this.fnZ.getView().getParent() == null) {
                this.aSl.setNextPage(this.fnZ);
            }
            this.fnZ.showLoadingViewWithoutEmptyView();
            this.fnZ.startLoadData();
        }
    }

    public void buy() {
        this.aSl.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.aSl.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fnZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.foS.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.beq == null) {
                this.beq = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.beq.addToParent((RelativeLayout) this.mRootView);
            }
            this.beq.reset();
            this.beq.setTitle(i);
            this.beq.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.beq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.beq.setVisibility(0);
        }
    }

    public void bqO() {
        if (this.beq != null) {
            this.beq.setVisibility(8);
        }
    }

    public void bvM() {
        if (this.aSl != null) {
            this.aSl.setVisibility(0);
        }
    }

    public void bvN() {
        if (this.aSl != null) {
            this.aSl.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.beq == null) {
                this.beq = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.beq.addToParent((RelativeLayout) this.mRootView);
            }
            this.beq.reset();
            this.beq.setTitle(a.i.sdk_prc_person_forbiddenlist_empty);
            this.beq.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.beq.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.beq != null) {
            this.beq.setVisibility(8);
        }
    }
}
