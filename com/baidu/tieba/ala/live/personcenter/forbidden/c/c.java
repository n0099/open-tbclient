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
    private CommonEmptyView aCX;
    private BdTypeListView asG;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a eMm;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a eMn;
    private PbListView evU;
    private LoadingView ewE;
    private TbListViewPullView ewz;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.asG = null;
        this.eMm = null;
        this.eMn = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eMm = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.asG = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eMm);
        this.asG.addAdapters(arrayList);
        this.eMn = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.asG.addHeaderView(this.eMn.aqs());
        this.ewE = new LoadingView(tbPageContext.getPageActivity());
        this.ewz = new TbListViewPullView(this.mPageContext);
        this.ewz.setTag(this.mPageContext.getUniqueId());
        this.asG.setPullRefresh(this.ewz);
        this.evU = new PbListView(this.mPageContext.getPageActivity());
        this.evU.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.eMn;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.pw(i);
        this.asG.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.asG);
        this.asG.setDivider(null);
        if (this.eMn != null) {
            this.eMn.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.asG != null) {
            this.asG.completePullRefresh();
        }
    }

    public void beQ() {
        if (this.evU != null) {
            if (this.evU.getView().getParent() == null) {
                this.asG.setNextPage(this.evU);
            }
            this.evU.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.evU.endLoadData();
        }
    }

    public void bct() {
        if (this.evU != null) {
            if (this.evU.getView().getParent() == null) {
                this.asG.setNextPage(this.evU);
            }
            this.evU.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.evU.endLoadData();
        }
    }

    public void bcu() {
        if (this.evU != null) {
            if (this.evU.getView().getParent() == null) {
                this.asG.setNextPage(this.evU);
            }
            this.evU.showLoadingViewWithoutEmptyView();
            this.evU.startLoadData();
        }
    }

    public void bfl() {
        this.asG.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.asG.setOnSrollToBottomListener(onScrollToBottomListener);
        this.evU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.ewz.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aCX == null) {
                this.aCX = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCX.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCX.reset();
            this.aCX.setTitle(i);
            this.aCX.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aCX.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aCX.setVisibility(0);
        }
    }

    public void bcx() {
        if (this.aCX != null) {
            this.aCX.setVisibility(8);
        }
    }

    public void bgy() {
        if (this.asG != null) {
            this.asG.setVisibility(0);
        }
    }

    public void bgz() {
        if (this.asG != null) {
            this.asG.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aCX == null) {
                this.aCX = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCX.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCX.reset();
            this.aCX.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aCX.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aCX.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aCX != null) {
            this.aCX.setVisibility(8);
        }
    }
}
