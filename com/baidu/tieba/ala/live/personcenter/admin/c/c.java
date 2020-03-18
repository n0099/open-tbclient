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
    private CommonEmptyView aDm;
    private BdTypeListView asR;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a eLC;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a eLD;
    private PbListView ewD;
    private TbListViewPullView exi;
    private LoadingView exn;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.asR = null;
        this.eLC = null;
        this.eLD = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eLC = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.asR = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eLC);
        this.asR.addAdapters(arrayList);
        this.eLD = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.asR.addHeaderView(this.eLD.aqv());
        this.exn = new LoadingView(tbPageContext.getPageActivity());
        this.exi = new TbListViewPullView(this.mPageContext);
        this.exi.setTag(this.mPageContext.getUniqueId());
        this.asR.setPullRefresh(this.exi);
        this.ewD = new PbListView(this.mPageContext.getPageActivity());
        this.ewD.createView();
    }

    public void by(List<IAdapterData> list) {
        this.eLD.py(list.size());
        this.asR.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.asR);
        this.asR.setDivider(null);
        if (this.eLC != null) {
            this.eLC.notifyDataSetChanged();
        }
        if (this.eLD != null) {
            this.eLD.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.asR != null) {
            this.asR.completePullRefresh();
        }
    }

    public void beW() {
        if (this.ewD != null) {
            if (this.ewD.getView().getParent() == null) {
                this.asR.setNextPage(this.ewD);
            }
            this.ewD.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.ewD.endLoadData();
        }
    }

    public void bfr() {
        this.asR.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.exi.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aDm == null) {
                this.aDm = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aDm.addToParent((RelativeLayout) this.mRootView);
            }
            this.aDm.reset();
            this.aDm.setTitle(i);
            this.aDm.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aDm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aDm.setVisibility(0);
        }
    }

    public void bcC() {
        if (this.aDm != null) {
            this.aDm.setVisibility(8);
        }
    }

    public void bgE() {
        if (this.asR != null) {
            this.asR.setVisibility(0);
        }
    }

    public void bgF() {
        if (this.asR != null) {
            this.asR.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aDm == null) {
                this.aDm = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aDm.addToParent((RelativeLayout) this.mRootView);
            }
            this.aDm.reset();
            this.aDm.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aDm.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aDm.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aDm != null) {
            this.aDm.setVisibility(8);
        }
    }
}
