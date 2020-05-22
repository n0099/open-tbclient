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
    private BdTypeListView aSl;
    private CommonEmptyView beq;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a fDU;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a fDV;
    private PbListView fnZ;
    private TbListViewPullView foS;
    private LoadingView foX;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aSl = null;
        this.fDU = null;
        this.fDV = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fDU = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.aSl = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fDU);
        this.aSl.addAdapters(arrayList);
        this.fDV = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.aSl.addHeaderView(this.fDV.aCz());
        this.foX = new LoadingView(tbPageContext.getPageActivity());
        this.foS = new TbListViewPullView(this.mPageContext);
        this.foS.setTag(this.mPageContext.getUniqueId());
        this.aSl.setPullRefresh(this.foS);
        this.fnZ = new PbListView(this.mPageContext.getPageActivity());
        this.fnZ.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        this.fDV.bs(list.size(), i);
        this.aSl.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aSl);
        this.aSl.setDivider(null);
        if (this.fDU != null) {
            this.fDU.notifyDataSetChanged();
        }
        if (this.fDV != null) {
            this.fDV.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aSl != null) {
            this.aSl.completePullRefresh();
        }
    }

    public void bud() {
        if (this.fnZ != null) {
            if (this.fnZ.getView().getParent() == null) {
                this.aSl.setNextPage(this.fnZ);
            }
            this.fnZ.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fnZ.endLoadData();
        }
    }

    public void buy() {
        this.aSl.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.foS.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.beq == null) {
                this.beq = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.beq.addToParent((RelativeLayout) this.mRootView);
            }
            this.beq.reset();
            this.beq.setTitle(i);
            this.beq.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.beq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.beq.setVisibility(0);
        }
    }

    public void bqO() {
        if (this.beq != null) {
            this.beq.setVisibility(8);
        }
    }

    public void bvM() {
        if (this.aSl != null) {
            this.aSl.setVisibility(0);
        }
    }

    public void bvN() {
        if (this.aSl != null) {
            this.aSl.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.beq == null) {
                this.beq = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.beq.addToParent((RelativeLayout) this.mRootView);
            }
            this.beq.reset();
            this.beq.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.beq.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.beq.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.beq != null) {
            this.beq.setVisibility(8);
        }
    }
}
