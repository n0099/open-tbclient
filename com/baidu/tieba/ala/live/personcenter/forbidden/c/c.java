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
    private CommonEmptyView aCW;
    private BdTypeListView asG;
    private com.baidu.tieba.ala.live.personcenter.forbidden.a.a eMl;
    private com.baidu.tieba.ala.live.personcenter.forbidden.d.a eMm;
    private PbListView evT;
    private LoadingView ewD;
    private TbListViewPullView ewy;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.asG = null;
        this.eMl = null;
        this.eMm = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eMl = new com.baidu.tieba.ala.live.personcenter.forbidden.a.a(this.mPageContext.getPageActivity(), this.mPageContext.getUniqueId());
        this.asG = (BdTypeListView) view.findViewById(a.g.ala_person_forbiddenlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eMl);
        this.asG.addAdapters(arrayList);
        this.eMm = new com.baidu.tieba.ala.live.personcenter.forbidden.d.a(tbPageContext);
        this.asG.addHeaderView(this.eMm.aqq());
        this.ewD = new LoadingView(tbPageContext.getPageActivity());
        this.ewy = new TbListViewPullView(this.mPageContext);
        this.ewy.setTag(this.mPageContext.getUniqueId());
        this.asG.setPullRefresh(this.ewy);
        this.evT = new PbListView(this.mPageContext.getPageActivity());
        this.evT.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        com.baidu.tieba.ala.live.personcenter.forbidden.d.a aVar = this.eMm;
        if (i <= list.size()) {
            i = list.size();
        }
        aVar.pw(i);
        this.asG.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.asG);
        this.asG.setDivider(null);
        if (this.eMm != null) {
            this.eMm.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.asG != null) {
            this.asG.completePullRefresh();
        }
    }

    public void beO() {
        if (this.evT != null) {
            if (this.evT.getView().getParent() == null) {
                this.asG.setNextPage(this.evT);
            }
            this.evT.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.evT.endLoadData();
        }
    }

    public void bcr() {
        if (this.evT != null) {
            if (this.evT.getView().getParent() == null) {
                this.asG.setNextPage(this.evT);
            }
            this.evT.setText(this.mPageContext.getResources().getString(a.i.sdk_list_no_more));
            this.evT.endLoadData();
        }
    }

    public void bcs() {
        if (this.evT != null) {
            if (this.evT.getView().getParent() == null) {
                this.asG.setNextPage(this.evT);
            }
            this.evT.showLoadingViewWithoutEmptyView();
            this.evT.startLoadData();
        }
    }

    public void bfj() {
        this.asG.setNextPage(null);
    }

    public void setOnSrollToBottomListener(final BdListView.OnScrollToBottomListener onScrollToBottomListener) {
        this.asG.setOnSrollToBottomListener(onScrollToBottomListener);
        this.evT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.personcenter.forbidden.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (onScrollToBottomListener != null) {
                    onScrollToBottomListener.onScrollToBottom();
                }
            }
        });
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.ewy.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aCW == null) {
                this.aCW = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCW.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCW.reset();
            this.aCW.setTitle(i);
            this.aCW.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aCW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aCW.setVisibility(0);
        }
    }

    public void bcv() {
        if (this.aCW != null) {
            this.aCW.setVisibility(8);
        }
    }

    public void bgw() {
        if (this.asG != null) {
            this.asG.setVisibility(0);
        }
    }

    public void bgx() {
        if (this.asG != null) {
            this.asG.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aCW == null) {
                this.aCW = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCW.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCW.reset();
            this.aCW.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aCW.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aCW.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aCW != null) {
            this.aCW.setVisibility(8);
        }
    }
}
