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
/* loaded from: classes7.dex */
public class c {
    private BdTypeListView bby;
    private CommonEmptyView bpE;
    private PbListView fPZ;
    private TbListViewPullView fQU;
    private LoadingView fQZ;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a ggK;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a ggL;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bby = null;
        this.ggK = null;
        this.ggL = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.ggK = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.bby = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ggK);
        this.bby.addAdapters(arrayList);
        this.ggL = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.bby.addHeaderView(this.ggL.aQn());
        this.fQZ = new LoadingView(tbPageContext.getPageActivity());
        this.fQU = new TbListViewPullView(this.mPageContext);
        this.fQU.setTag(this.mPageContext.getUniqueId());
        this.bby.setPullRefresh(this.fQU);
        this.fPZ = new PbListView(this.mPageContext.getPageActivity());
        this.fPZ.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.ggL.bH(list.size(), i);
        this.bby.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bby);
        this.bby.setDivider(null);
        if (this.ggK != null) {
            this.ggK.notifyDataSetChanged();
        }
        if (this.ggL != null) {
            this.ggL.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bby != null) {
            this.bby.completePullRefresh();
        }
    }

    public void bJN() {
        if (this.fPZ != null) {
            if (this.fPZ.getView().getParent() == null) {
                this.bby.setNextPage(this.fPZ);
            }
            this.fPZ.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fPZ.endLoadData();
        }
    }

    public void bKi() {
        this.bby.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fQU.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bpE == null) {
                this.bpE = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bpE.addToParent((RelativeLayout) this.mRootView);
            }
            this.bpE.reset();
            this.bpE.setTitle(i);
            this.bpE.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.bpE.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bpE.setVisibility(0);
        }
    }

    public void bFX() {
        if (this.bpE != null) {
            this.bpE.setVisibility(8);
        }
    }

    public void bLt() {
        if (this.bby != null) {
            this.bby.setVisibility(0);
        }
    }

    public void bLu() {
        if (this.bby != null) {
            this.bby.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bpE == null) {
                this.bpE = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bpE.addToParent((RelativeLayout) this.mRootView);
            }
            this.bpE.reset();
            this.bpE.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.bpE.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bpE.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bpE != null) {
            this.bpE.setVisibility(8);
        }
    }
}
