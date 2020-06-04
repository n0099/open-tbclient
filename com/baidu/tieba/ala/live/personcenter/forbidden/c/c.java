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
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a fFx;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a fFy;
    private PbListView fok;
    private TbListViewPullView fpd;
    private LoadingView fpi;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aSl = null;
        this.fFx = null;
        this.fFy = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fFx = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.aSl = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fFx);
        this.aSl.addAdapters(arrayList);
        this.fFy = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.aSl.addHeaderView(this.fFy.aCz());
        this.fpi = new LoadingView(tbPageContext.getPageActivity());
        this.fpd = new TbListViewPullView(this.mPageContext);
        this.fpd.setTag(this.mPageContext.getUniqueId());
        this.aSl.setPullRefresh(this.fpd);
        this.fok = new PbListView(this.mPageContext.getPageActivity());
        this.fok.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.fFy;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.qw(i);
        this.aSl.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aSl);
        this.aSl.setDivider(null);
        if (this.fFy != null) {
            this.fFy.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aSl != null) {
            this.aSl.completePullRefresh();
        }
    }

    public void buf() {
        if (this.fok != null) {
            if (this.fok.getView().getParent() == null) {
                this.aSl.setNextPage(this.fok);
            }
            this.fok.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fok.endLoadData();
        }
    }

    public void bqL() {
        if (this.fok != null) {
            if (this.fok.getView().getParent() == null) {
                this.aSl.setNextPage(this.fok);
            }
            this.fok.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.fok.endLoadData();
        }
    }

    public void bqM() {
        if (this.fok != null) {
            if (this.fok.getView().getParent() == null) {
                this.aSl.setNextPage(this.fok);
            }
            this.fok.showLoadingViewWithoutEmptyView();
            this.fok.startLoadData();
        }
    }

    public void buA() {
        this.aSl.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.aSl.setOnSrollToBottomListener(onScrollToBottomListener);
        this.fok.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fpd.setListPullRefreshListener(listPullRefreshListener);
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

    public void bqQ() {
        if (this.beq != null) {
            this.beq.setVisibility(8);
        }
    }

    public void bvO() {
        if (this.aSl != null) {
            this.aSl.setVisibility(0);
        }
    }

    public void bvP() {
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
