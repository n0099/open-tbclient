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
/* loaded from: classes3.dex */
public class c {
    private BdTypeListView aUR;
    private CommonEmptyView bjC;
    private TbListViewPullView fAp;
    private LoadingView fAu;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a fPo;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a fPp;
    private PbListView fzx;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.aUR = null;
        this.fPo = null;
        this.fPp = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.fPo = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.aUR = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.fPo);
        this.aUR.addAdapters(arrayList);
        this.fPp = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.aUR.addHeaderView(this.fPp.aDF());
        this.fAu = new LoadingView(tbPageContext.getPageActivity());
        this.fAp = new TbListViewPullView(this.mPageContext);
        this.fAp.setTag(this.mPageContext.getUniqueId());
        this.aUR.setPullRefresh(this.fAp);
        this.fzx = new PbListView(this.mPageContext.getPageActivity());
        this.fzx.createView();
    }

    public void f(List<IAdapterData> list, int i) {
        this.fPp.bw(list.size(), i);
        this.aUR.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.aUR);
        this.aUR.setDivider(null);
        if (this.fPo != null) {
            this.fPo.notifyDataSetChanged();
        }
        if (this.fPp != null) {
            this.fPp.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.aUR != null) {
            this.aUR.completePullRefresh();
        }
    }

    public void bxa() {
        if (this.fzx != null) {
            if (this.fzx.getView().getParent() == null) {
                this.aUR.setNextPage(this.fzx);
            }
            this.fzx.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.fzx.endLoadData();
        }
    }

    public void bxv() {
        this.aUR.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.fAp.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.bjC == null) {
                this.bjC = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bjC.addToParent((RelativeLayout) this.mRootView);
            }
            this.bjC.reset();
            this.bjC.setTitle(i);
            this.bjC.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.bjC.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.bjC.setVisibility(0);
        }
    }

    public void btN() {
        if (this.bjC != null) {
            this.bjC.setVisibility(8);
        }
    }

    public void byJ() {
        if (this.aUR != null) {
            this.aUR.setVisibility(0);
        }
    }

    public void byK() {
        if (this.aUR != null) {
            this.aUR.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.bjC == null) {
                this.bjC = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.bjC.addToParent((RelativeLayout) this.mRootView);
            }
            this.bjC.reset();
            this.bjC.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.bjC.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.bjC.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.bjC != null) {
            this.bjC.setVisibility(8);
        }
    }
}
