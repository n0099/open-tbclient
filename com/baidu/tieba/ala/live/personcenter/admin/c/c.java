package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.view.View;
import android.widget.RelativeLayout;
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
    private BdTypeListView aMf;
    private CommonEmptyView aWT;
    private PbListView far;
    private TbListViewPullView fbl;
    private LoadingView fbq;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a fpV;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a fpW;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aMf = null;
        this.fpV = null;
        this.fpW = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fpV = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.aMf = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fpV);
        this.aMf.addAdapters(arrayList);
        this.fpW = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.aMf.addHeaderView(this.fpW.ayH());
        this.fbq = new LoadingView(tbPageContext.getPageActivity());
        this.fbl = new TbListViewPullView(this.mPageContext);
        this.fbl.setTag(this.mPageContext.getUniqueId());
        this.aMf.setPullRefresh(this.fbl);
        this.far = new PbListView(this.mPageContext.getPageActivity());
        this.far.createView();
    }

    public void bH(List<IAdapterData> list) {
        this.fpW.pS(list.size());
        this.aMf.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aMf);
        this.aMf.setDivider(null);
        if (this.fpV != null) {
            this.fpV.notifyDataSetChanged();
        }
        if (this.fpW != null) {
            this.fpW.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aMf != null) {
            this.aMf.completePullRefresh();
        }
    }

    public void bom() {
        if (this.far != null) {
            if (this.far.getView().getParent() == null) {
                this.aMf.setNextPage(this.far);
            }
            this.far.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.far.endLoadData();
        }
    }

    public void boI() {
        this.aMf.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fbl.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aWT == null) {
                this.aWT = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aWT.addToParent((RelativeLayout) this.mRootView);
            }
            this.aWT.reset();
            this.aWT.setTitle(i);
            this.aWT.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aWT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aWT.setVisibility(0);
        }
    }

    public void blt() {
        if (this.aWT != null) {
            this.aWT.setVisibility(8);
        }
    }

    public void bpV() {
        if (this.aMf != null) {
            this.aMf.setVisibility(0);
        }
    }

    public void bpW() {
        if (this.aMf != null) {
            this.aMf.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aWT == null) {
                this.aWT = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aWT.addToParent((RelativeLayout) this.mRootView);
            }
            this.aWT.reset();
            this.aWT.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aWT.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aWT.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aWT != null) {
            this.aWT.setVisibility(8);
        }
    }
}
