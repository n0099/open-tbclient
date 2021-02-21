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
/* loaded from: classes11.dex */
public class c {
    private CommonEmptyView bMk;
    private BdTypeListView bnu;
    private PbListView gNM;
    private TbListViewPullView gOG;
    private LoadingView gOL;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a hkw;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a hkx;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.bnu = null;
        this.hkw = null;
        this.hkx = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.hkw = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.bnu = (BdTypeListView) view.findViewById(a.f.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.hkw);
        this.bnu.addAdapters(arrayList);
        this.hkx = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.bnu.addHeaderView(this.hkx.aZl());
        this.gOL = new LoadingView(tbPageContext.getPageActivity());
        this.gOG = new TbListViewPullView(this.mPageContext);
        this.gOG.setTag(this.mPageContext.getUniqueId());
        this.bnu.setPullRefresh(this.gOG);
        this.gNM = new PbListView(this.mPageContext.getPageActivity());
        this.gNM.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.hkx.bL(list.size(), i);
        this.bnu.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.bnu);
        this.bnu.setDivider(null);
        if (this.hkw != null) {
            this.hkw.notifyDataSetChanged();
        }
        if (this.hkx != null) {
            this.hkx.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.bnu != null) {
            this.bnu.completePullRefresh();
        }
    }

    public void bVp() {
        if (this.gNM != null) {
            if (this.gNM.getView().getParent() == null) {
                this.bnu.setNextPage(this.gNM);
            }
            this.gNM.setText(this.mPageContext.getResources().getString(a.h.sdk_load_more));
            this.gNM.endLoadData();
        }
    }

    public void bVL() {
        this.bnu.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.gOG.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bMk == null) {
                this.bMk = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bMk.addToParent((RelativeLayout) this.mRootView);
            }
            this.bMk.reset();
            this.bMk.setTitle(i);
            this.bMk.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
            this.bMk.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bMk.setVisibility(0);
        }
    }

    public void WZ() {
        if (this.bMk != null) {
            this.bMk.setVisibility(8);
        }
    }

    public void bYo() {
        if (this.bnu != null) {
            this.bnu.setVisibility(0);
        }
    }

    public void bYp() {
        if (this.bnu != null) {
            this.bnu.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bMk == null) {
                this.bMk = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bMk.addToParent((RelativeLayout) this.mRootView);
            }
            this.bMk.reset();
            this.bMk.setTitle(a.h.sdk_prc_person_adminlist_empty);
            this.bMk.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bMk.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bMk != null) {
            this.bMk.setVisibility(8);
        }
    }
}
