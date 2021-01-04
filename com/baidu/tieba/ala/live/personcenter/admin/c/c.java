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
/* loaded from: classes11.dex */
public class c {
    private CommonEmptyView bNm;
    private BdTypeListView boO;
    private PbListView gPy;
    private TbListViewPullView gQs;
    private LoadingView gQx;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a hkA;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a hkz;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.boO = null;
        this.hkz = null;
        this.hkA = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hkz = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.boO = (BdTypeListView) view.findViewById(a.f.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.hkz);
        this.boO.addAdapters(arrayList);
        this.hkA = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.boO.addHeaderView(this.hkA.bcS());
        this.gQx = new LoadingView(tbPageContext.getPageActivity());
        this.gQs = new TbListViewPullView(this.mPageContext);
        this.gQs.setTag(this.mPageContext.getUniqueId());
        this.boO.setPullRefresh(this.gQs);
        this.gPy = new PbListView(this.mPageContext.getPageActivity());
        this.gPy.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.hkA.bM(list.size(), i);
        this.boO.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.boO);
        this.boO.setDivider(null);
        if (this.hkz != null) {
            this.hkz.notifyDataSetChanged();
        }
        if (this.hkA != null) {
            this.hkA.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.boO != null) {
            this.boO.completePullRefresh();
        }
    }

    public void bYv() {
        if (this.gPy != null) {
            if (this.gPy.getView().getParent() == null) {
                this.boO.setNextPage(this.gPy);
            }
            this.gPy.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gPy.endLoadData();
        }
    }

    public void bYQ() {
        this.boO.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gQs.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bNm == null) {
                this.bNm = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bNm.addToParent((RelativeLayout) this.mRootView);
            }
            this.bNm.reset();
            this.bNm.setTitle(i);
            this.bNm.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bNm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bNm.setVisibility(0);
        }
    }

    public void Zi() {
        if (this.bNm != null) {
            this.bNm.setVisibility(8);
        }
    }

    public void caY() {
        if (this.boO != null) {
            this.boO.setVisibility(0);
        }
    }

    public void caZ() {
        if (this.boO != null) {
            this.boO.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bNm == null) {
                this.bNm = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bNm.addToParent((RelativeLayout) this.mRootView);
            }
            this.bNm.reset();
            this.bNm.setTitle(a.h.sdk_prc_person_adminlist_empty);
            this.bNm.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bNm.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bNm != null) {
            this.bNm.setVisibility(8);
        }
    }
}
