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
    private BdTypeListView agA;
    private CommonEmptyView aqh;
    private PbListView dEI;
    private TbListViewPullView dEZ;
    private LoadingView dFe;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a dRA;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a dRB;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.agA = null;
        this.dRA = null;
        this.dRB = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.dRA = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.agA = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.dRA);
        this.agA.addAdapters(arrayList);
        this.dRB = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.agA.addHeaderView(this.dRB.Yr());
        this.dFe = new LoadingView(tbPageContext.getPageActivity());
        this.dEZ = new TbListViewPullView(this.mPageContext);
        this.dEZ.setTag(this.mPageContext.getUniqueId());
        this.agA.setPullRefresh(this.dEZ);
        this.dEI = new PbListView(this.mPageContext.getPageActivity());
        this.dEI.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.dRB;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.mT(i);
        this.agA.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.agA);
        this.agA.setDivider(null);
        if (this.dRB != null) {
            this.dRB.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.agA != null) {
            this.agA.completePullRefresh();
        }
    }

    public void aKU() {
        if (this.dEI != null) {
            if (this.dEI.getView().getParent() == null) {
                this.agA.setNextPage(this.dEI);
            }
            this.dEI.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.dEI.endLoadData();
        }
    }

    public void aJi() {
        if (this.dEI != null) {
            if (this.dEI.getView().getParent() == null) {
                this.agA.setNextPage(this.dEI);
            }
            this.dEI.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.dEI.endLoadData();
        }
    }

    public void aJj() {
        if (this.dEI != null) {
            if (this.dEI.getView().getParent() == null) {
                this.agA.setNextPage(this.dEI);
            }
            this.dEI.showLoadingViewWithoutEmptyView();
            this.dEI.startLoadData();
        }
    }

    public void aLp() {
        this.agA.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.agA.setOnSrollToBottomListener(onScrollToBottomListener);
        this.dEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.dEZ.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aqh == null) {
                this.aqh = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aqh.addToParent((RelativeLayout) this.mRootView);
            }
            this.aqh.reset();
            this.aqh.setTitle(i);
            this.aqh.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aqh.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aqh.setVisibility(0);
        }
    }

    public void aJm() {
        if (this.aqh != null) {
            this.aqh.setVisibility(8);
        }
    }

    public void aMo() {
        if (this.agA != null) {
            this.agA.setVisibility(0);
        }
    }

    public void aMp() {
        if (this.agA != null) {
            this.agA.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aqh == null) {
                this.aqh = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aqh.addToParent((RelativeLayout) this.mRootView);
            }
            this.aqh.reset();
            this.aqh.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aqh.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aqh.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aqh != null) {
            this.aqh.setVisibility(8);
        }
    }
}
