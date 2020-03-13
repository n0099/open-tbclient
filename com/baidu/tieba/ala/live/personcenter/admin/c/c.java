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
    private CommonEmptyView aCY;
    private BdTypeListView asH;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a eLg;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a eLh;
    private TbListViewPullView ewM;
    private LoadingView ewR;
    private PbListView ewh;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.asH = null;
        this.eLg = null;
        this.eLh = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eLg = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.asH = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eLg);
        this.asH.addAdapters(arrayList);
        this.eLh = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.asH.addHeaderView(this.eLh.aqs());
        this.ewR = new LoadingView(tbPageContext.getPageActivity());
        this.ewM = new TbListViewPullView(this.mPageContext);
        this.ewM.setTag(this.mPageContext.getUniqueId());
        this.asH.setPullRefresh(this.ewM);
        this.ewh = new PbListView(this.mPageContext.getPageActivity());
        this.ewh.createView();
    }

    public void by(List<IAdapterData> list) {
        this.eLh.pw(list.size());
        this.asH.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.asH);
        this.asH.setDivider(null);
        if (this.eLg != null) {
            this.eLg.notifyDataSetChanged();
        }
        if (this.eLh != null) {
            this.eLh.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.asH != null) {
            this.asH.completePullRefresh();
        }
    }

    public void beR() {
        if (this.ewh != null) {
            if (this.ewh.getView().getParent() == null) {
                this.asH.setNextPage(this.ewh);
            }
            this.ewh.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.ewh.endLoadData();
        }
    }

    public void bfm() {
        this.asH.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.ewM.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aCY == null) {
                this.aCY = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCY.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCY.reset();
            this.aCY.setTitle(i);
            this.aCY.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aCY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aCY.setVisibility(0);
        }
    }

    public void bcy() {
        if (this.aCY != null) {
            this.aCY.setVisibility(8);
        }
    }

    public void bgz() {
        if (this.asH != null) {
            this.asH.setVisibility(0);
        }
    }

    public void bgA() {
        if (this.asH != null) {
            this.asH.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aCY == null) {
                this.aCY = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCY.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCY.reset();
            this.aCY.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aCY.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aCY.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aCY != null) {
            this.aCY.setVisibility(8);
        }
    }
}
