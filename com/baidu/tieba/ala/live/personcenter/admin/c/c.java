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
    private BdTypeListView bbw;
    private CommonEmptyView bpB;
    private PbListView fPV;
    private TbListViewPullView fQQ;
    private LoadingView fQV;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a ggG;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a ggH;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bbw = null;
        this.ggG = null;
        this.ggH = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.ggG = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.bbw = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ggG);
        this.bbw.addAdapters(arrayList);
        this.ggH = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.bbw.addHeaderView(this.ggH.aQn());
        this.fQV = new LoadingView(tbPageContext.getPageActivity());
        this.fQQ = new TbListViewPullView(this.mPageContext);
        this.fQQ.setTag(this.mPageContext.getUniqueId());
        this.bbw.setPullRefresh(this.fQQ);
        this.fPV = new PbListView(this.mPageContext.getPageActivity());
        this.fPV.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.ggH.bH(list.size(), i);
        this.bbw.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bbw);
        this.bbw.setDivider(null);
        if (this.ggG != null) {
            this.ggG.notifyDataSetChanged();
        }
        if (this.ggH != null) {
            this.ggH.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bbw != null) {
            this.bbw.completePullRefresh();
        }
    }

    public void bJM() {
        if (this.fPV != null) {
            if (this.fPV.getView().getParent() == null) {
                this.bbw.setNextPage(this.fPV);
            }
            this.fPV.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fPV.endLoadData();
        }
    }

    public void bKh() {
        this.bbw.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fQQ.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bpB == null) {
                this.bpB = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bpB.addToParent((RelativeLayout) this.mRootView);
            }
            this.bpB.reset();
            this.bpB.setTitle(i);
            this.bpB.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.bpB.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bpB.setVisibility(0);
        }
    }

    public void bFW() {
        if (this.bpB != null) {
            this.bpB.setVisibility(8);
        }
    }

    public void bLs() {
        if (this.bbw != null) {
            this.bbw.setVisibility(0);
        }
    }

    public void bLt() {
        if (this.bbw != null) {
            this.bbw.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bpB == null) {
                this.bpB = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bpB.addToParent((RelativeLayout) this.mRootView);
            }
            this.bpB.reset();
            this.bpB.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.bpB.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bpB.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bpB != null) {
            this.bpB.setVisibility(8);
        }
    }
}
