package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.view.View;
import android.widget.RelativeLayout;
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
    private BdTypeListView aWh;
    private CommonEmptyView bjW;
    private PbListView fEE;
    private LoadingView fFE;
    private TbListViewPullView fFz;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a fUH;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a fUI;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aWh = null;
        this.fUH = null;
        this.fUI = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fUH = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.aWh = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fUH);
        this.aWh.addAdapters(arrayList);
        this.fUI = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.aWh.addHeaderView(this.fUI.aHv());
        this.fFE = new LoadingView(tbPageContext.getPageActivity());
        this.fFz = new TbListViewPullView(this.mPageContext);
        this.fFz.setTag(this.mPageContext.getUniqueId());
        this.aWh.setPullRefresh(this.fFz);
        this.fEE = new PbListView(this.mPageContext.getPageActivity());
        this.fEE.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.fUI.bz(list.size(), i);
        this.aWh.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aWh);
        this.aWh.setDivider(null);
        if (this.fUH != null) {
            this.fUH.notifyDataSetChanged();
        }
        if (this.fUI != null) {
            this.fUI.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aWh != null) {
            this.aWh.completePullRefresh();
        }
    }

    public void bAr() {
        if (this.fEE != null) {
            if (this.fEE.getView().getParent() == null) {
                this.aWh.setNextPage(this.fEE);
            }
            this.fEE.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fEE.endLoadData();
        }
    }

    public void bAM() {
        this.aWh.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fFz.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bjW == null) {
                this.bjW = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bjW.addToParent((RelativeLayout) this.mRootView);
            }
            this.bjW.reset();
            this.bjW.setTitle(i);
            this.bjW.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.bjW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bjW.setVisibility(0);
        }
    }

    public void bwX() {
        if (this.bjW != null) {
            this.bjW.setVisibility(8);
        }
    }

    public void bBY() {
        if (this.aWh != null) {
            this.aWh.setVisibility(0);
        }
    }

    public void bBZ() {
        if (this.aWh != null) {
            this.aWh.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bjW == null) {
                this.bjW = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bjW.addToParent((RelativeLayout) this.mRootView);
            }
            this.bjW.reset();
            this.bjW.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.bjW.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bjW.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bjW != null) {
            this.bjW.setVisibility(8);
        }
    }
}
