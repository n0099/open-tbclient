package com.baidu.tieba.homepage.daily;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.view.AutoBannerView;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private f bLm;
    private PbListView bPn;
    private BdSwipeRefreshLayout bSa;
    private AutoBannerView evq;
    private BdTypeRecyclerView evr;
    private com.baidu.tieba.homepage.daily.a.a evs;
    private View.OnClickListener evt;
    private TbPageContext<?> mPageContext;
    private k mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> emd = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void i(int i, String str) {
            if (a.this.evq != null) {
                TiebaStatic.log(new am("c13173").y("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new am("c13174").y("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        f(this.mPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(e.h.daily_page_view, (ViewGroup) null);
        this.bSa = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.bSa.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.evr = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.daily_listview);
        this.evr.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.evr.setFadingEdgeLength(0);
        this.evr.setOverScrollMode(2);
        this.evs = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.evr);
        this.mPullView = new k(tbPageContext);
        this.bSa.setProgressView(this.mPullView);
        this.bPn = new PbListView(pageActivity);
        this.bPn.getView();
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.Fm();
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.ew(e.d.cp_cont_e);
        this.bPn.setHeight(l.h(pageActivity, e.C0210e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bW(bVar.aLC());
            this.evs.setData(bVar.getDataList());
        }
    }

    public void bW(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.evr != null) {
            if (v.I(list)) {
                if (this.evq != null) {
                    this.evr.removeHeaderView(this.evq);
                    this.evq = null;
                    return;
                }
                return;
            }
            if (this.evq == null) {
                this.evq = new AutoBannerView(this.mPageContext.getPageActivity());
                this.evq.setOutOnCoverViewCallback(this.emd);
                this.evr.addHeaderView(this.evq, 0);
            }
            this.evq.bX(list);
            this.evq.FR();
        }
    }

    public void showLoadingView() {
        i(false, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds520));
    }

    public void i(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.bLm == null) {
            if (i < 0) {
                this.bLm = new f(pageActivity);
            } else {
                this.bLm = new f(pageActivity, i);
            }
            this.bLm.onChangeSkinType();
        }
        this.bLm.attachView(this.mRootView, z);
        this.evr.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.bLm != null) {
            this.bLm.dettachView(this.mRootView);
            this.bLm = null;
            this.evr.setNextPage(this.bPn);
        }
        if (this.bSa != null) {
            this.bSa.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.evt != null) {
                        a.this.evt.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.ge(pageActivity.getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.mRefreshView.iC(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.Od();
    }

    public void abx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
        this.evr.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.Fp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abA() {
        this.evr.setNextPage(null);
    }

    public void abz() {
        this.evr.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.Fr();
        this.bPn.setText(this.mPageContext.getResources().getString(e.j.list_has_no_more));
    }

    public void aLA() {
        this.evr.setNextPage(this.bPn);
        this.bPn.Fq();
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.bSa.setRefreshing(true);
    }

    public void aLB() {
        this.bSa.setRefreshing(false);
    }

    public void reload() {
        this.evr.setSelection(0);
        startPullRefresh();
    }

    public void abv() {
        this.evs.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bLm != null) {
                this.bLm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.bPn != null) {
                this.bPn.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bPn.ey(i);
            }
            if (this.evq != null) {
                this.evq.onChangeSkinType(i);
            }
            if (this.evs != null) {
                this.evs.onChangeSkinType(i);
            }
            al.j(this.bSa, e.d.cp_bg_line_e);
            al.j(this.evr, e.d.cp_bg_line_d);
        }
    }

    public void a(j.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.evr != null) {
            this.evr.setOnSrollToBottomListener(eVar);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.evt = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.evs != null) {
            this.evs.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.evq != null) {
            this.evq.FS();
        }
        this.evr.setOnSrollToBottomListener(null);
        aLB();
    }
}
