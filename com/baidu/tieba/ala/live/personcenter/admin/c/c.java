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
/* loaded from: classes10.dex */
public class c {
    private CommonEmptyView bNK;
    private BdTypeListView boU;
    private PbListView gPv;
    private TbListViewPullView gQp;
    private LoadingView gQu;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a hmf;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a hmg;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.boU = null;
        this.hmf = null;
        this.hmg = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hmf = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.boU = (BdTypeListView) view.findViewById(a.f.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.hmf);
        this.boU.addAdapters(arrayList);
        this.hmg = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.boU.addHeaderView(this.hmg.aZo());
        this.gQu = new LoadingView(tbPageContext.getPageActivity());
        this.gQp = new TbListViewPullView(this.mPageContext);
        this.gQp.setTag(this.mPageContext.getUniqueId());
        this.boU.setPullRefresh(this.gQp);
        this.gPv = new PbListView(this.mPageContext.getPageActivity());
        this.gPv.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.hmg.bL(list.size(), i);
        this.boU.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.boU);
        this.boU.setDivider(null);
        if (this.hmf != null) {
            this.hmf.notifyDataSetChanged();
        }
        if (this.hmg != null) {
            this.hmg.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.boU != null) {
            this.boU.completePullRefresh();
        }
    }

    public void bVv() {
        if (this.gPv != null) {
            if (this.gPv.getView().getParent() == null) {
                this.boU.setNextPage(this.gPv);
            }
            this.gPv.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gPv.endLoadData();
        }
    }

    public void bVR() {
        this.boU.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gQp.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bNK == null) {
                this.bNK = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bNK.addToParent((RelativeLayout) this.mRootView);
            }
            this.bNK.reset();
            this.bNK.setTitle(i);
            this.bNK.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bNK.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bNK.setVisibility(0);
        }
    }

    public void Xc() {
        if (this.bNK != null) {
            this.bNK.setVisibility(8);
        }
    }

    public void bYu() {
        if (this.boU != null) {
            this.boU.setVisibility(0);
        }
    }

    public void bYv() {
        if (this.boU != null) {
            this.boU.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bNK == null) {
                this.bNK = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bNK.addToParent((RelativeLayout) this.mRootView);
            }
            this.bNK.reset();
            this.bNK.setTitle(a.h.sdk_prc_person_adminlist_empty);
            this.bNK.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bNK.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bNK != null) {
            this.bNK.setVisibility(8);
        }
    }
}
