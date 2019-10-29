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
    private g dEq;
    private PbListView dwJ;
    private BdSwipeRefreshLayout dyk;
    private BdTypeRecyclerView gdY;
    private AutoBannerView gfB;
    private com.baidu.tieba.homepage.daily.a.a gfC;
    private View.OnClickListener gfD;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> gfE = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void F(int i, String str) {
            if (a.this.gfB != null) {
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
        this.dyk = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.daily_refresh_layout);
        this.gdY = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.daily_listview);
        this.gdY.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.gdY.setFadingEdgeLength(0);
        this.gdY.setOverScrollMode(2);
        this.gfC = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.gdY);
        this.mPullView = new i(tbPageContext);
        this.dyk.setProgressView(this.mPullView);
        this.dwJ = new PbListView(pageActivity);
        this.dwJ.getView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setLineGone();
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dwJ.setHeight(l.getDimens(pageActivity, R.dimen.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cM(bVar.btj());
            this.gfC.setData(bVar.getDataList());
        }
    }

    public void cM(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.gdY != null) {
            if (v.isEmpty(list)) {
                if (this.gfB != null) {
                    this.gdY.removeHeaderView(this.gfB);
                    this.gfB = null;
                    return;
                }
                return;
            }
            if (this.gfB == null) {
                this.gfB = new AutoBannerView(this.mPageContext.getPageActivity());
                this.gfB.setOutOnCoverViewCallback(this.gfE);
                this.gdY.addHeaderView(this.gfB, 0);
            }
            this.gfB.cP(list);
            this.gfB.aoo();
        }
    }

    public void showLoadingView() {
        p(false, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds520));
    }

    public void p(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.dEq == null) {
            if (i < 0) {
                this.dEq = new g(pageActivity);
            } else {
                this.dEq = new g(pageActivity, i);
            }
            this.dEq.onChangeSkinType();
        }
        this.dEq.attachView(this.mRootView, z);
        this.gdY.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.dEq != null) {
            this.dEq.dettachView(this.mRootView);
            this.dEq = null;
            this.gdY.setNextPage(this.dwJ);
        }
        if (this.dyk != null) {
            this.dyk.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gfD != null) {
                        a.this.gfD.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.setLayoutMargin(pageActivity.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.mRefreshView.setSubText(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.showRefreshButton();
    }

    public void aJo() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKi() {
        this.gdY.setNextPage(this.dwJ);
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.startLoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKk() {
        this.gdY.setNextPage(null);
    }

    public void aKj() {
        this.gdY.setNextPage(this.dwJ);
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.endLoadDataWithNoMore();
        this.dwJ.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
    }

    public void bti() {
        this.gdY.setNextPage(this.dwJ);
        this.dwJ.endLoadData();
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dyk.setRefreshing(true);
    }

    public void aJH() {
        this.dyk.setRefreshing(false);
    }

    public void reload() {
        this.gdY.setSelection(0);
        startPullRefresh();
    }

    public void aKh() {
        this.gfC.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dEq != null) {
                this.dEq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
            if (this.dwJ != null) {
                this.dwJ.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dwJ.changeSkin(i);
            }
            if (this.gfB != null) {
                this.gfB.onChangeSkinType(i);
            }
            if (this.gfC != null) {
                this.gfC.onChangeSkinType(i);
            }
            am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
            am.setBackgroundColor(this.gdY, R.color.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.gdY != null) {
            this.gdY.setOnSrollToBottomListener(eVar);
        }
    }

    public void x(View.OnClickListener onClickListener) {
        this.gfD = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gfC != null) {
            this.gfC.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.gfB != null) {
            this.gfB.aop();
        }
        this.gdY.setOnSrollToBottomListener(null);
        aJH();
    }
}
