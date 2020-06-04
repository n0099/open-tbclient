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
    private com.baidu.tieba.ala.live.personcenter.admin.a.a fEf;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a fEg;
    private PbListView fok;
    private TbListViewPullView fpd;
    private LoadingView fpi;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aSl = null;
        this.fEf = null;
        this.fEg = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fEf = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.aSl = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fEf);
        this.aSl.addAdapters(arrayList);
        this.fEg = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.aSl.addHeaderView(this.fEg.aCz());
        this.fpi = new LoadingView(tbPageContext.getPageActivity());
        this.fpd = new TbListViewPullView(this.mPageContext);
        this.fpd.setTag(this.mPageContext.getUniqueId());
        this.aSl.setPullRefresh(this.fpd);
        this.fok = new PbListView(this.mPageContext.getPageActivity());
        this.fok.createView();
    }

    public void e(List<IAdapterData> list, int i) {
        this.fEg.bs(list.size(), i);
        this.aSl.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aSl);
        this.aSl.setDivider(null);
        if (this.fEf != null) {
            this.fEf.notifyDataSetChanged();
        }
        if (this.fEg != null) {
            this.fEg.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aSl != null) {
            this.aSl.completePullRefresh();
        }
    }

    public void buf() {
        if (this.fok != null) {
            if (this.fok.getView().getParent() == null) {
                this.aSl.setNextPage(this.fok);
            }
            this.fok.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fok.endLoadData();
        }
    }

    public void buA() {
        this.aSl.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fpd.setListPullRefreshListener(listPullRefreshListener);
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

    public void bqQ() {
        if (this.beq != null) {
            this.beq.setVisibility(8);
        }
    }

    public void bvO() {
        if (this.aSl != null) {
            this.aSl.setVisibility(0);
        }
    }

    public void bvP() {
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
