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
/* loaded from: classes10.dex */
public class c {
    private CommonEmptyView bIA;
    private BdTypeListView bkb;
    private PbListView gKS;
    private TbListViewPullView gLM;
    private LoadingView gLR;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a hhh;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a hhi;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bkb = null;
        this.hhh = null;
        this.hhi = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hhh = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.bkb = (BdTypeListView) view.findViewById(a.f.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.hhh);
        this.bkb.addAdapters(arrayList);
        this.hhi = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.bkb.addHeaderView(this.hhi.aYZ());
        this.gLR = new LoadingView(tbPageContext.getPageActivity());
        this.gLM = new TbListViewPullView(this.mPageContext);
        this.gLM.setTag(this.mPageContext.getUniqueId());
        this.bkb.setPullRefresh(this.gLM);
        this.gKS = new PbListView(this.mPageContext.getPageActivity());
        this.gKS.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.hhi;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.uI(i);
        this.bkb.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bkb);
        this.bkb.setDivider(null);
        if (this.hhi != null) {
            this.hhi.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bkb != null) {
            this.bkb.completePullRefresh();
        }
    }

    public void bUE() {
        if (this.gKS != null) {
            if (this.gKS.getView().getParent() == null) {
                this.bkb.setNextPage(this.gKS);
            }
            this.gKS.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gKS.endLoadData();
        }
    }

    public void bQM() {
        if (this.gKS != null) {
            if (this.gKS.getView().getParent() == null) {
                this.bkb.setNextPage(this.gKS);
            }
            this.gKS.setText(this.mPageContext.getResources().getString(a.h.sdk_list_no_more));
            this.gKS.endLoadData();
        }
    }

    public void bQN() {
        if (this.gKS != null) {
            if (this.gKS.getView().getParent() == null) {
                this.bkb.setNextPage(this.gKS);
            }
            this.gKS.showLoadingViewWithoutEmptyView();
            this.gKS.startLoadData();
        }
    }

    public void bUZ() {
        this.bkb.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.bkb.setOnSrollToBottomListener(onScrollToBottomListener);
        this.gKS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gLM.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bIA == null) {
                this.bIA = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bIA.addToParent((RelativeLayout) this.mRootView);
            }
            this.bIA.reset();
            this.bIA.setTitle(i);
            this.bIA.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bIA.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bIA.setVisibility(0);
        }
    }

    public void Vq() {
        if (this.bIA != null) {
            this.bIA.setVisibility(8);
        }
    }

    public void bXh() {
        if (this.bkb != null) {
            this.bkb.setVisibility(0);
        }
    }

    public void bXi() {
        if (this.bkb != null) {
            this.bkb.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bIA == null) {
                this.bIA = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bIA.addToParent((RelativeLayout) this.mRootView);
            }
            this.bIA.reset();
            this.bIA.setTitle(a.h.sdk_prc_person_forbiddenlist_empty);
            this.bIA.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bIA.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bIA != null) {
            this.bIA.setVisibility(8);
        }
    }
}
