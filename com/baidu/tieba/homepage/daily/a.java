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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.view.AutoBannerView;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private f brt;
    private PbListView bvA;
    private BdSwipeRefreshLayout byn;
    private AutoBannerView dUv;
    private BdTypeRecyclerView dUw;
    private com.baidu.tieba.homepage.daily.a.a dUx;
    private View.OnClickListener dUy;
    private TbPageContext<?> mPageContext;
    private h mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> dLB = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void h(int i, String str) {
            if (a.this.dUv != null) {
                TiebaStatic.log(new an("c13173").r("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new an("c13174").r("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        f(this.mPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(d.h.daily_page_view, (ViewGroup) null);
        this.byn = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.byn.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.dUw = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.daily_listview);
        this.dUw.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.dUw.setFadingEdgeLength(0);
        this.dUw.setOverScrollMode(2);
        this.dUx = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.dUw);
        this.mPullView = new h(tbPageContext);
        this.byn.setProgressView(this.mPullView);
        this.bvA = new PbListView(pageActivity);
        this.bvA.getView();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.Au();
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.bvA.setHeight(l.f(pageActivity, d.e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bD(bVar.aDy());
            this.dUx.setData(bVar.getDataList());
        }
    }

    public void bD(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.dUw != null) {
            if (w.z(list)) {
                if (this.dUv != null) {
                    this.dUw.removeHeaderView(this.dUv);
                    this.dUv = null;
                    return;
                }
                return;
            }
            if (this.dUv == null) {
                this.dUv = new AutoBannerView(this.mPageContext.getPageActivity());
                this.dUv.setOutOnCoverViewCallback(this.dLB);
                this.dUw.addHeaderView(this.dUv, 0);
            }
            this.dUv.bE(list);
            this.dUv.Bb();
        }
    }

    public void showLoadingView() {
        g(false, this.mPageContext.getResources().getDimensionPixelSize(d.e.ds520));
    }

    public void g(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.brt == null) {
            if (i < 0) {
                this.brt = new f(pageActivity);
            } else {
                this.brt = new f(pageActivity, i);
            }
            this.brt.onChangeSkinType();
        }
        this.brt.c(this.mRootView, z);
        this.dUw.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.brt != null) {
            this.brt.Q(this.mRootView);
            this.brt = null;
            this.dUw.setNextPage(this.bvA);
        }
        if (this.byn != null) {
            this.byn.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.dUy != null) {
                        a.this.dUy.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.fh(pageActivity.getResources().getDimensionPixelSize(d.e.ds280));
        this.mRefreshView.hk(str);
        this.mRefreshView.c(view, false);
        this.mRefreshView.Jk();
    }

    public void Uk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.Q(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ul() {
        this.dUw.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.Ax();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Un() {
        this.dUw.setNextPage(null);
    }

    public void Um() {
        this.dUw.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.Az();
        this.bvA.setText(this.mPageContext.getResources().getString(d.j.list_has_no_more));
    }

    public void aDw() {
        this.dUw.setNextPage(this.bvA);
        this.bvA.Ay();
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.byn.setRefreshing(true);
    }

    public void aDx() {
        this.byn.setRefreshing(false);
    }

    public void reload() {
        this.dUw.setSelection(0);
        startPullRefresh();
    }

    public void Ui() {
        this.dUx.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.brt != null) {
                this.brt.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dC(i);
            }
            if (this.bvA != null) {
                this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_d));
                this.bvA.dC(i);
            }
            if (this.dUv != null) {
                this.dUv.onChangeSkinType(i);
            }
            if (this.dUx != null) {
                this.dUx.onChangeSkinType(i);
            }
            am.j(this.byn, d.C0140d.cp_bg_line_e);
            am.j(this.dUw, d.C0140d.cp_bg_line_d);
        }
    }

    public void a(g.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.dUw != null) {
            this.dUw.setOnSrollToBottomListener(eVar);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.dUy = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dUx != null) {
            this.dUx.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.dUv != null) {
            this.dUv.Bc();
        }
        this.dUw.setOnSrollToBottomListener(null);
        aDx();
    }
}
