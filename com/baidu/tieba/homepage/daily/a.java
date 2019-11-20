package com.baidu.tieba.homepage.daily;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.view.AutoBannerView;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private g dDz;
    private PbListView dvS;
    private BdSwipeRefreshLayout dxt;
    private BdTypeRecyclerView gdh;
    private AutoBannerView geK;
    private com.baidu.tieba.homepage.daily.a.a geL;
    private View.OnClickListener geM;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> geN = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void E(int i, String str) {
            if (a.this.geK != null) {
                TiebaStatic.log(new an("c13173").O("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new an("c13174").O("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        g(this.mPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(R.layout.daily_page_view, (ViewGroup) null);
        this.dxt = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.daily_refresh_layout);
        this.gdh = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.daily_listview);
        this.gdh.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.gdh.setFadingEdgeLength(0);
        this.gdh.setOverScrollMode(2);
        this.geL = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.gdh);
        this.mPullView = new i(tbPageContext);
        this.dxt.setProgressView(this.mPullView);
        this.dvS = new PbListView(pageActivity);
        this.dvS.getView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setLineGone();
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.setHeight(l.getDimens(pageActivity, R.dimen.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cM(bVar.bth());
            this.geL.setData(bVar.getDataList());
        }
    }

    public void cM(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.gdh != null) {
            if (v.isEmpty(list)) {
                if (this.geK != null) {
                    this.gdh.removeHeaderView(this.geK);
                    this.geK = null;
                    return;
                }
                return;
            }
            if (this.geK == null) {
                this.geK = new AutoBannerView(this.mPageContext.getPageActivity());
                this.geK.setOutOnCoverViewCallback(this.geN);
                this.gdh.addHeaderView(this.geK, 0);
            }
            this.geK.cP(list);
            this.geK.aom();
        }
    }

    public void showLoadingView() {
        p(false, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds520));
    }

    public void p(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.dDz == null) {
            if (i < 0) {
                this.dDz = new g(pageActivity);
            } else {
                this.dDz = new g(pageActivity, i);
            }
            this.dDz.onChangeSkinType();
        }
        this.dDz.attachView(this.mRootView, z);
        this.gdh.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.dDz != null) {
            this.dDz.dettachView(this.mRootView);
            this.dDz = null;
            this.gdh.setNextPage(this.dvS);
        }
        if (this.dxt != null) {
            this.dxt.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.geM != null) {
                        a.this.geM.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.setLayoutMargin(pageActivity.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.mRefreshView.setSubText(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.showRefreshButton();
    }

    public void aJm() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKg() {
        this.gdh.setNextPage(this.dvS);
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKi() {
        this.gdh.setNextPage(null);
    }

    public void aKh() {
        this.gdh.setNextPage(this.dvS);
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.endLoadDataWithNoMore();
        this.dvS.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
    }

    public void btg() {
        this.gdh.setNextPage(this.dvS);
        this.dvS.endLoadData();
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dxt.setRefreshing(true);
    }

    public void aJF() {
        this.dxt.setRefreshing(false);
    }

    public void reload() {
        this.gdh.setSelection(0);
        startPullRefresh();
    }

    public void aKf() {
        this.geL.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dDz != null) {
                this.dDz.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.dvS != null) {
                this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dvS.changeSkin(i);
            }
            if (this.geK != null) {
                this.geK.onChangeSkinType(i);
            }
            if (this.geL != null) {
                this.geL.onChangeSkinType(i);
            }
            am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gdh, R.color.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.gdh != null) {
            this.gdh.setOnSrollToBottomListener(eVar);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        this.geM = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.geL != null) {
            this.geL.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.geK != null) {
            this.geK.aon();
        }
        this.gdh.setOnSrollToBottomListener(null);
        aJF();
    }
}
