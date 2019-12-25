package com.baidu.tieba.ala.live.personcenter.admin.c;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.adp.widget.listview.BdTypeListView;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.q.a;
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
    private BdTypeListView aoB;
    private CommonEmptyView axX;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a eFO;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a eFP;
    private PbListView eqw;
    private TbListViewPullView erc;
    private LoadingView erh;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aoB = null;
        this.eFO = null;
        this.eFP = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eFO = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.aoB = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eFO);
        this.aoB.addAdapters(arrayList);
        this.eFP = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.aoB.addHeaderView(this.eFP.anJ());
        this.erh = new LoadingView(tbPageContext.getPageActivity());
        this.erc = new TbListViewPullView(this.mPageContext);
        this.erc.setTag(this.mPageContext.getUniqueId());
        this.aoB.setPullRefresh(this.erc);
        this.eqw = new PbListView(this.mPageContext.getPageActivity());
        this.eqw.createView();
    }

    public void by(List<IAdapterData> list) {
        this.eFP.pj(list.size());
        this.aoB.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aoB);
        this.aoB.setDivider(null);
        if (this.eFO != null) {
            this.eFO.notifyDataSetChanged();
        }
        if (this.eFP != null) {
            this.eFP.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aoB != null) {
            this.aoB.completePullRefresh();
        }
    }

    public void bcg() {
        if (this.eqw != null) {
            if (this.eqw.getView().getParent() == null) {
                this.aoB.setNextPage(this.eqw);
            }
            this.eqw.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.eqw.endLoadData();
        }
    }

    public void bcz() {
        this.aoB.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.erc.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.axX == null) {
                this.axX = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.axX.addToParent((RelativeLayout) this.mRootView);
            }
            this.axX.reset();
            this.axX.setTitle(i);
            this.axX.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.axX.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.axX.setVisibility(0);
        }
    }

    public void aZK() {
        if (this.axX != null) {
            this.axX.setVisibility(8);
        }
    }

    public void bdR() {
        if (this.aoB != null) {
            this.aoB.setVisibility(0);
        }
    }

    public void bdS() {
        if (this.aoB != null) {
            this.aoB.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.axX == null) {
                this.axX = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.axX.addToParent((RelativeLayout) this.mRootView);
            }
            this.axX.reset();
            this.axX.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.axX.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.axX.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.axX != null) {
            this.axX.setVisibility(8);
        }
    }
}
