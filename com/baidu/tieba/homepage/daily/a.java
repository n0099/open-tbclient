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
    private f bLl;
    private PbListView bPm;
    private BdSwipeRefreshLayout bRZ;
    private AutoBannerView evp;
    private BdTypeRecyclerView evq;
    private com.baidu.tieba.homepage.daily.a.a evr;
    private View.OnClickListener evs;
    private TbPageContext<?> mPageContext;
    private k mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> emc = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void i(int i, String str) {
            if (a.this.evp != null) {
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
        this.bRZ = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.bRZ.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.evq = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.daily_listview);
        this.evq.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.evq.setFadingEdgeLength(0);
        this.evq.setOverScrollMode(2);
        this.evr = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.evq);
        this.mPullView = new k(tbPageContext);
        this.bRZ.setProgressView(this.mPullView);
        this.bPm = new PbListView(pageActivity);
        this.bPm.getView();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.Fm();
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.ew(e.d.cp_cont_e);
        this.bPm.setHeight(l.h(pageActivity, e.C0210e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bW(bVar.aLC());
            this.evr.setData(bVar.getDataList());
        }
    }

    public void bW(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.evq != null) {
            if (v.I(list)) {
                if (this.evp != null) {
                    this.evq.removeHeaderView(this.evp);
                    this.evp = null;
                    return;
                }
                return;
            }
            if (this.evp == null) {
                this.evp = new AutoBannerView(this.mPageContext.getPageActivity());
                this.evp.setOutOnCoverViewCallback(this.emc);
                this.evq.addHeaderView(this.evp, 0);
            }
            this.evp.bX(list);
            this.evp.FR();
        }
    }

    public void showLoadingView() {
        i(false, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds520));
    }

    public void i(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.bLl == null) {
            if (i < 0) {
                this.bLl = new f(pageActivity);
            } else {
                this.bLl = new f(pageActivity, i);
            }
            this.bLl.onChangeSkinType();
        }
        this.bLl.attachView(this.mRootView, z);
        this.evq.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.bLl != null) {
            this.bLl.dettachView(this.mRootView);
            this.bLl = null;
            this.evq.setNextPage(this.bPm);
        }
        if (this.bRZ != null) {
            this.bRZ.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.evs != null) {
                        a.this.evs.onClick(view2);
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
        this.evq.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.Fp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abA() {
        this.evq.setNextPage(null);
    }

    public void abz() {
        this.evq.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.Fr();
        this.bPm.setText(this.mPageContext.getResources().getString(e.j.list_has_no_more));
    }

    public void aLA() {
        this.evq.setNextPage(this.bPm);
        this.bPm.Fq();
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.bRZ.setRefreshing(true);
    }

    public void aLB() {
        this.bRZ.setRefreshing(false);
    }

    public void reload() {
        this.evq.setSelection(0);
        startPullRefresh();
    }

    public void abv() {
        this.evr.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bLl != null) {
                this.bLl.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.bPm != null) {
                this.bPm.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bPm.ey(i);
            }
            if (this.evp != null) {
                this.evp.onChangeSkinType(i);
            }
            if (this.evr != null) {
                this.evr.onChangeSkinType(i);
            }
            al.j(this.bRZ, e.d.cp_bg_line_e);
            al.j(this.evq, e.d.cp_bg_line_d);
        }
    }

    public void a(j.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.evq != null) {
            this.evq.setOnSrollToBottomListener(eVar);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.evs = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.evr != null) {
            this.evr.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.evp != null) {
            this.evp.FS();
        }
        this.evq.setOnSrollToBottomListener(null);
        aLB();
    }
}
