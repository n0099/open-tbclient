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
    private CommonEmptyView aCW;
    private BdTypeListView asG;
    private com.baidu.tieba.ala.live.personcenter.admin.a.a eKS;
    private com.baidu.tieba.ala.live.personcenter.admin.d.a eKT;
    private PbListView evT;
    private LoadingView ewD;
    private TbListViewPullView ewy;
    private TbPageContext mPageContext;
    private View mRootView;

    public c(TbPageContext tbPageContext, View view) {
        this.asG = null;
        this.eKS = null;
        this.eKT = null;
        this.mPageContext = tbPageContext;
        this.mRootView = view;
        this.eKS = new com.baidu.tieba.ala.live.personcenter.admin.a.a(this.mPageContext.getPageActivity(), tbPageContext.getUniqueId());
        this.asG = (BdTypeListView) view.findViewById(a.g.ala_person_adminlist_listview);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eKS);
        this.asG.addAdapters(arrayList);
        this.eKT = new com.baidu.tieba.ala.live.personcenter.admin.d.a(tbPageContext);
        this.asG.addHeaderView(this.eKT.aqq());
        this.ewD = new LoadingView(tbPageContext.getPageActivity());
        this.ewy = new TbListViewPullView(this.mPageContext);
        this.ewy.setTag(this.mPageContext.getUniqueId());
        this.asG.setPullRefresh(this.ewy);
        this.evT = new PbListView(this.mPageContext.getPageActivity());
        this.evT.createView();
    }

    public void by(List<IAdapterData> list) {
        this.eKT.pw(list.size());
        this.asG.setData(list);
    }

    public void onChangeSkinType(int i) {
        this.mPageContext.getLayoutMode().onModeChanged(this.asG);
        this.asG.setDivider(null);
        if (this.eKS != null) {
            this.eKS.notifyDataSetChanged();
        }
        if (this.eKT != null) {
            this.eKT.onChangeSkinType(i);
        }
    }

    public void completePullRefresh() {
        if (this.asG != null) {
            this.asG.completePullRefresh();
        }
    }

    public void beO() {
        if (this.evT != null) {
            if (this.evT.getView().getParent() == null) {
                this.asG.setNextPage(this.evT);
            }
            this.evT.setText(this.mPageContext.getResources().getString(a.i.sdk_load_more));
            this.evT.endLoadData();
        }
    }

    public void bfj() {
        this.asG.setNextPage(null);
    }

    public void setListPullRefreshListener(TbListCommonPullView.ListPullRefreshListener listPullRefreshListener) {
        this.ewy.setListPullRefreshListener(listPullRefreshListener);
    }

    public void a(int i, View.OnClickListener onClickListener) {
        if (this.mPageContext != null && this.mPageContext.getContext() != null && (this.mRootView instanceof RelativeLayout)) {
            if (this.aCW == null) {
                this.aCW = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCW.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCW.reset();
            this.aCW.setTitle(i);
            this.aCW.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
            this.aCW.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.LIGHT);
            this.aCW.setVisibility(0);
        }
    }

    public void bcv() {
        if (this.aCW != null) {
            this.aCW.setVisibility(8);
        }
    }

    public void bgw() {
        if (this.asG != null) {
            this.asG.setVisibility(0);
        }
    }

    public void bgx() {
        if (this.asG != null) {
            this.asG.setVisibility(4);
        }
    }

    public void showNoDataView() {
        if (this.mRootView instanceof RelativeLayout) {
            if (this.aCW == null) {
                this.aCW = new CommonEmptyView(this.mPageContext.getPageActivity());
                this.aCW.addToParent((RelativeLayout) this.mRootView);
            }
            this.aCW.reset();
            this.aCW.setTitle(a.i.sdk_prc_person_adminlist_empty);
            this.aCW.setup(CommonEmptyView.ImgType.NO_FAN, CommonEmptyView.StyleType.LIGHT);
            this.aCW.setVisibility(0);
        }
    }

    public void hideNoDataView() {
        if (this.aCW != null) {
            this.aCW.setVisibility(8);
        }
    }
}
