package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.view.PbListView;
import com.baidu.live.tbadk.core.view.TbListCommonPullView;
import com.baidu.live.tbadk.core.view.TbListViewPullView;
import com.baidu.live.tbadk.loading.LoadingView;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView apn;
    private CommonEmptyView ayG;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a eGY;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a eGZ;
    private PbListView erJ;
    private TbListViewPullView eso;
    private LoadingView est;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.apn = null;
        this.eGY = null;
        this.eGZ = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eGY = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.apn = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eGY);
        this.apn.addAdapters(arrayList);
        this.eGZ = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.apn.addHeaderView(this.eGZ.aoc());
        this.est = new LoadingView(tbPageContext.getPageActivity());
        this.eso = new TbListViewPullView(this.mPageContext);
        this.eso.setTag(this.mPageContext.getUniqueId());
        this.apn.setPullRefresh(this.eso);
        this.erJ = new PbListView(this.mPageContext.getPageActivity());
        this.erJ.createView();
    }

    public void by(List<IAdapterData> list) {
        this.eGZ.pk(list.size());
        this.apn.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.apn);
        this.apn.setDivider(null);
        if (this.eGY != null) {
            this.eGY.notifyDataSetChanged();
        }
        if (this.eGZ != null) {
            this.eGZ.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.apn != null) {
            this.apn.completePullRefresh();
        }
    }

    public void bcB() {
        if (this.erJ != null) {
            if (this.erJ.getView().getParent() == null) {
                this.apn.setNextPage(this.erJ);
            }
            this.erJ.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.erJ.endLoadData();
        }
    }

    public void bcU() {
        this.apn.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.eso.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.ayG == null) {
                this.ayG = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.ayG.addToParent((RelativeLayout) this.mRootView);
            }
            this.ayG.reset();
            this.ayG.setTitle(i);
            this.ayG.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.ayG.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.ayG.setVisibility(0);
        }
    }

    public void baf() {
        if (this.ayG != null) {
            this.ayG.setVisibility(8);
        }
    }

    public void bem() {
        if (this.apn != null) {
            this.apn.setVisibility(0);
        }
    }

    public void ben() {
        if (this.apn != null) {
            this.apn.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.ayG == null) {
                this.ayG = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.ayG.addToParent((RelativeLayout) this.mRootView);
            }
            this.ayG.reset();
            this.ayG.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.ayG.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.ayG.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.ayG != null) {
            this.ayG.setVisibility(8);
        }
    }
}
