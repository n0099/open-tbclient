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
    private BdTypeListView aMl;
    private CommonEmptyView aWY;
    private PbListView faw;
    private TbListViewPullView fbq;
    private LoadingView fbv;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a fqa;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a fqb;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aMl = null;
        this.fqa = null;
        this.fqb = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fqa = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.aMl = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fqa);
        this.aMl.addAdapters(arrayList);
        this.fqb = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.aMl.addHeaderView(this.fqb.ayH());
        this.fbv = new LoadingView(tbPageContext.getPageActivity());
        this.fbq = new TbListViewPullView(this.mPageContext);
        this.fbq.setTag(this.mPageContext.getUniqueId());
        this.aMl.setPullRefresh(this.fbq);
        this.faw = new PbListView(this.mPageContext.getPageActivity());
        this.faw.createView();
    }

    public void bH(List<IAdapterData> list) {
        this.fqb.pS(list.size());
        this.aMl.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aMl);
        this.aMl.setDivider(null);
        if (this.fqa != null) {
            this.fqa.notifyDataSetChanged();
        }
        if (this.fqb != null) {
            this.fqb.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aMl != null) {
            this.aMl.completePullRefresh();
        }
    }

    public void bok() {
        if (this.faw != null) {
            if (this.faw.getView().getParent() == null) {
                this.aMl.setNextPage(this.faw);
            }
            this.faw.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.faw.endLoadData();
        }
    }

    public void boG() {
        this.aMl.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fbq.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aWY == null) {
                this.aWY = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aWY.addToParent((RelativeLayout) this.mRootView);
            }
            this.aWY.reset();
            this.aWY.setTitle(i);
            this.aWY.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aWY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aWY.setVisibility(0);
        }
    }

    public void blr() {
        if (this.aWY != null) {
            this.aWY.setVisibility(8);
        }
    }

    public void bpT() {
        if (this.aMl != null) {
            this.aMl.setVisibility(0);
        }
    }

    public void bpU() {
        if (this.aMl != null) {
            this.aMl.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aWY == null) {
                this.aWY = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aWY.addToParent((RelativeLayout) this.mRootView);
            }
            this.aWY.reset();
            this.aWY.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aWY.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aWY.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aWY != null) {
            this.aWY.setVisibility(8);
        }
    }
}
