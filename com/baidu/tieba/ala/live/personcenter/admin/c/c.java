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
    private CommonEmptyView bFa;
    private BdTypeListView bkA;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a gPO;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a gPP;
    private PbListView gvu;
    private TbListViewPullView gwp;
    private LoadingView gwu;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bkA = null;
        this.gPO = null;
        this.gPP = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.gPO = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.bkA = (BdTypeListView) view.findViewById(a.f.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.gPO);
        this.bkA.addAdapters(arrayList);
        this.gPP = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.bkA.addHeaderView(this.gPP.aYc());
        this.gwu = new LoadingView(tbPageContext.getPageActivity());
        this.gwp = new TbListViewPullView(this.mPageContext);
        this.gwp.setTag(this.mPageContext.getUniqueId());
        this.bkA.setPullRefresh(this.gwp);
        this.gvu = new PbListView(this.mPageContext.getPageActivity());
        this.gvu.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.gPP.bJ(list.size(), i);
        this.bkA.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bkA);
        this.bkA.setDivider(null);
        if (this.gPO != null) {
            this.gPO.notifyDataSetChanged();
        }
        if (this.gPP != null) {
            this.gPP.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bkA != null) {
            this.bkA.completePullRefresh();
        }
    }

    public void bSM() {
        if (this.gvu != null) {
            if (this.gvu.getView().getParent() == null) {
                this.bkA.setNextPage(this.gvu);
            }
            this.gvu.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gvu.endLoadData();
        }
    }

    public void bTh() {
        this.bkA.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gwp.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bFa == null) {
                this.bFa = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bFa.addToParent((RelativeLayout) this.mRootView);
            }
            this.bFa.reset();
            this.bFa.setTitle(i);
            this.bFa.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bFa.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bFa.setVisibility(0);
        }
    }

    public void Wk() {
        if (this.bFa != null) {
            this.bFa.setVisibility(8);
        }
    }

    public void bVq() {
        if (this.bkA != null) {
            this.bkA.setVisibility(0);
        }
    }

    public void bVr() {
        if (this.bkA != null) {
            this.bkA.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bFa == null) {
                this.bFa = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bFa.addToParent((RelativeLayout) this.mRootView);
            }
            this.bFa.reset();
            this.bFa.setTitle(a.h.sdk_prc_person_adminlist_empty);
            this.bFa.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bFa.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bFa != null) {
            this.bFa.setVisibility(8);
        }
    }
}
