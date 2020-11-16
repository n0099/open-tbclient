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
    private CommonEmptyView bDp;
    private BdTypeListView biP;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a gPv;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a gPw;
    private TbListViewPullView gvW;
    private PbListView gvb;
    private LoadingView gwb;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.biP = null;
        this.gPv = null;
        this.gPw = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gPv = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.biP = (BdTypeListView) view.findViewById(a.f.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gPv);
        this.biP.addAdapters(arrayList);
        this.gPw = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.biP.addHeaderView(this.gPw.aXu());
        this.gwb = new LoadingView(tbPageContext.getPageActivity());
        this.gvW = new TbListViewPullView(this.mPageContext);
        this.gvW.setTag(this.mPageContext.getUniqueId());
        this.biP.setPullRefresh(this.gvW);
        this.gvb = new PbListView(this.mPageContext.getPageActivity());
        this.gvb.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.gPw.bJ(list.size(), i);
        this.biP.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.biP);
        this.biP.setDivider(null);
        if (this.gPv != null) {
            this.gPv.notifyDataSetChanged();
        }
        if (this.gPw != null) {
            this.gPw.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.biP != null) {
            this.biP.completePullRefresh();
        }
    }

    public void bSf() {
        if (this.gvb != null) {
            if (this.gvb.getView().getParent() == null) {
                this.biP.setNextPage(this.gvb);
            }
            this.gvb.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gvb.endLoadData();
        }
    }

    public void bSA() {
        this.biP.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gvW.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bDp == null) {
                this.bDp = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bDp.addToParent((RelativeLayout) this.mRootView);
            }
            this.bDp.reset();
            this.bDp.setTitle(i);
            this.bDp.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bDp.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bDp.setVisibility(0);
        }
    }

    public void VB() {
        if (this.bDp != null) {
            this.bDp.setVisibility(8);
        }
    }

    public void bUJ() {
        if (this.biP != null) {
            this.biP.setVisibility(0);
        }
    }

    public void bUK() {
        if (this.biP != null) {
            this.biP.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bDp == null) {
                this.bDp = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bDp.addToParent((RelativeLayout) this.mRootView);
            }
            this.bDp.reset();
            this.bDp.setTitle(a.h.sdk_prc_person_adminlist_empty);
            this.bDp.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bDp.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bDp != null) {
            this.bDp.setVisibility(8);
        }
    }
}
