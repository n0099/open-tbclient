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
    private CommonEmptyView aCX;
    private BdTypeListView asG;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a eKT;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a eKU;
    private PbListView evU;
    private LoadingView ewE;
    private TbListViewPullView ewz;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.asG = null;
        this.eKT = null;
        this.eKU = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eKT = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.asG = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eKT);
        this.asG.addAdapters(arrayList);
        this.eKU = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.asG.addHeaderView(this.eKU.aqs());
        this.ewE = new LoadingView(tbPageContext.getPageActivity());
        this.ewz = new TbListViewPullView(this.mPageContext);
        this.ewz.setTag(this.mPageContext.getUniqueId());
        this.asG.setPullRefresh(this.ewz);
        this.evU = new PbListView(this.mPageContext.getPageActivity());
        this.evU.createView();
    }

    public void by(List<IAdapterData> list) {
        this.eKU.pw(list.size());
        this.asG.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.asG);
        this.asG.setDivider(null);
        if (this.eKT != null) {
            this.eKT.notifyDataSetChanged();
        }
        if (this.eKU != null) {
            this.eKU.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.asG != null) {
            this.asG.completePullRefresh();
        }
    }

    public void beQ() {
        if (this.evU != null) {
            if (this.evU.getView().getParent() == null) {
                this.asG.setNextPage(this.evU);
            }
            this.evU.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.evU.endLoadData();
        }
    }

    public void bfl() {
        this.asG.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.ewz.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aCX == null) {
                this.aCX = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCX.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCX.reset();
            this.aCX.setTitle(i);
            this.aCX.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aCX.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aCX.setVisibility(0);
        }
    }

    public void bcx() {
        if (this.aCX != null) {
            this.aCX.setVisibility(8);
        }
    }

    public void bgy() {
        if (this.asG != null) {
            this.asG.setVisibility(0);
        }
    }

    public void bgz() {
        if (this.asG != null) {
            this.asG.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aCX == null) {
                this.aCX = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCX.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCX.reset();
            this.aCX.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aCX.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aCX.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aCX != null) {
            this.aCX.setVisibility(8);
        }
    }
}
