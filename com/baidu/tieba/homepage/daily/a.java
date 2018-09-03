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
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.view.AutoBannerView;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private f brv;
    private PbListView bvC;
    private BdSwipeRefreshLayout byp;
    private AutoBannerView dUq;
    private BdTypeRecyclerView dUr;
    private com.baidu.tieba.homepage.daily.a.a dUs;
    private View.OnClickListener dUt;
    private TbPageContext<?> mPageContext;
    private h mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> dLx = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void h(int i, String str) {
            if (a.this.dUq != null) {
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
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(f.h.daily_page_view, (ViewGroup) null);
        this.byp = (BdSwipeRefreshLayout) this.mRootView.findViewById(f.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.byp.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.dUr = (BdTypeRecyclerView) this.mRootView.findViewById(f.g.daily_listview);
        this.dUr.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.dUr.setFadingEdgeLength(0);
        this.dUr.setOverScrollMode(2);
        this.dUs = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.dUr);
        this.mPullView = new h(tbPageContext);
        this.byp.setProgressView(this.mPullView);
        this.bvC = new PbListView(pageActivity);
        this.bvC.getView();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.As();
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.dz(f.d.cp_cont_e);
        this.bvC.setHeight(l.f(pageActivity, f.e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bD(bVar.aDv());
            this.dUs.setData(bVar.getDataList());
        }
    }

    public void bD(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.dUr != null) {
            if (w.z(list)) {
                if (this.dUq != null) {
                    this.dUr.removeHeaderView(this.dUq);
                    this.dUq = null;
                    return;
                }
                return;
            }
            if (this.dUq == null) {
                this.dUq = new AutoBannerView(this.mPageContext.getPageActivity());
                this.dUq.setOutOnCoverViewCallback(this.dLx);
                this.dUr.addHeaderView(this.dUq, 0);
            }
            this.dUq.bE(list);
            this.dUq.AY();
        }
    }

    public void showLoadingView() {
        g(false, this.mPageContext.getResources().getDimensionPixelSize(f.e.ds520));
    }

    public void g(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.brv == null) {
            if (i < 0) {
                this.brv = new com.baidu.tbadk.k.f(pageActivity);
            } else {
                this.brv = new com.baidu.tbadk.k.f(pageActivity, i);
            }
            this.brv.onChangeSkinType();
        }
        this.brv.c(this.mRootView, z);
        this.dUr.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.brv != null) {
            this.brv.Q(this.mRootView);
            this.brv = null;
            this.dUr.setNextPage(this.bvC);
        }
        if (this.byp != null) {
            this.byp.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.dUt != null) {
                        a.this.dUt.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.fg(pageActivity.getResources().getDimensionPixelSize(f.e.ds280));
        this.mRefreshView.hk(str);
        this.mRefreshView.c(view, false);
        this.mRefreshView.Jk();
    }

    public void Un() {
        if (this.mRefreshView != null) {
            this.mRefreshView.Q(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uo() {
        this.dUr.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.Av();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uq() {
        this.dUr.setNextPage(null);
    }

    public void Up() {
        this.dUr.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.Ax();
        this.bvC.setText(this.mPageContext.getResources().getString(f.j.list_has_no_more));
    }

    public void aDt() {
        this.dUr.setNextPage(this.bvC);
        this.bvC.Aw();
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.byp.setRefreshing(true);
    }

    public void aDu() {
        this.byp.setRefreshing(false);
    }

    public void reload() {
        this.dUr.setSelection(0);
        startPullRefresh();
    }

    public void Ul() {
        this.dUs.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.brv != null) {
                this.brv.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dB(i);
            }
            if (this.bvC != null) {
                this.bvC.setTextColor(am.getColor(f.d.cp_cont_d));
                this.bvC.dB(i);
            }
            if (this.dUq != null) {
                this.dUq.onChangeSkinType(i);
            }
            if (this.dUs != null) {
                this.dUs.onChangeSkinType(i);
            }
            am.j(this.byp, f.d.cp_bg_line_e);
            am.j(this.dUr, f.d.cp_bg_line_d);
        }
    }

    public void a(g.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.dUr != null) {
            this.dUr.setOnSrollToBottomListener(eVar);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.dUt = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dUs != null) {
            this.dUs.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.dUq != null) {
            this.dUq.AZ();
        }
        this.dUr.setOnSrollToBottomListener(null);
        aDu();
    }
}
