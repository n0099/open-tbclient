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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.view.AutoBannerView;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private g cXp;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private AutoBannerView fHA;
    private BdTypeRecyclerView fHB;
    private com.baidu.tieba.homepage.daily.a.a fHC;
    private View.OnClickListener fHD;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> fHE = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void y(int i, String str) {
            if (a.this.fHA != null) {
                TiebaStatic.log(new am("c13173").T("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new am("c13174").T("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        g(this.mPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(d.h.daily_page_view, (ViewGroup) null);
        this.dcE = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.dcE.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.fHB = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.daily_listview);
        this.fHB.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.fHB.setFadingEdgeLength(0);
        this.fHB.setOverScrollMode(2);
        this.fHC = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.fHB);
        this.mPullView = new i(tbPageContext);
        this.dcE.setProgressView(this.mPullView);
        this.dbr = new PbListView(pageActivity);
        this.dbr.getView();
        this.dbr.ia(d.C0277d.cp_bg_line_e);
        this.dbr.aew();
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.hZ(d.C0277d.cp_cont_e);
        this.dbr.setHeight(l.h(pageActivity, d.e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cr(bVar.blB());
            this.fHC.setData(bVar.getDataList());
        }
    }

    public void cr(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.fHB != null) {
            if (v.T(list)) {
                if (this.fHA != null) {
                    this.fHB.removeHeaderView(this.fHA);
                    this.fHA = null;
                    return;
                }
                return;
            }
            if (this.fHA == null) {
                this.fHA = new AutoBannerView(this.mPageContext.getPageActivity());
                this.fHA.setOutOnCoverViewCallback(this.fHE);
                this.fHB.addHeaderView(this.fHA, 0);
            }
            this.fHA.cu(list);
            this.fHA.afi();
        }
    }

    public void showLoadingView() {
        o(false, this.mPageContext.getResources().getDimensionPixelSize(d.e.ds520));
    }

    public void o(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.cXp == null) {
            if (i < 0) {
                this.cXp = new g(pageActivity);
            } else {
                this.cXp = new g(pageActivity, i);
            }
            this.cXp.onChangeSkinType();
        }
        this.cXp.attachView(this.mRootView, z);
        this.fHB.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.cXp != null) {
            this.cXp.dettachView(this.mRootView);
            this.cXp = null;
            this.fHB.setNextPage(this.dbr);
        }
        if (this.dcE != null) {
            this.dcE.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fHD != null) {
                        a.this.fHD.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.jQ(pageActivity.getResources().getDimensionPixelSize(d.e.ds280));
        this.mRefreshView.pp(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.any();
    }

    public void aBq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCr() {
        this.fHB.setNextPage(this.dbr);
        this.dbr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aez();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCt() {
        this.fHB.setNextPage(null);
    }

    public void aCs() {
        this.fHB.setNextPage(this.dbr);
        this.dbr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeB();
        this.dbr.setText(this.mPageContext.getResources().getString(d.j.list_has_no_more));
    }

    public void blA() {
        this.fHB.setNextPage(this.dbr);
        this.dbr.aeA();
        this.dbr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dcE.setRefreshing(true);
    }

    public void aBJ() {
        this.dcE.setRefreshing(false);
    }

    public void reload() {
        this.fHB.setSelection(0);
        startPullRefresh();
    }

    public void aCq() {
        this.fHC.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.cXp != null) {
                this.cXp.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ib(i);
            }
            if (this.dbr != null) {
                this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                this.dbr.ib(i);
            }
            if (this.fHA != null) {
                this.fHA.onChangeSkinType(i);
            }
            if (this.fHC != null) {
                this.fHC.onChangeSkinType(i);
            }
            al.l(this.dcE, d.C0277d.cp_bg_line_e);
            al.l(this.fHB, d.C0277d.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.fHB != null) {
            this.fHB.setOnSrollToBottomListener(eVar);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        this.fHD = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fHC != null) {
            this.fHC.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.fHA != null) {
            this.fHA.afj();
        }
        this.fHB.setOnSrollToBottomListener(null);
        aBJ();
    }
}
