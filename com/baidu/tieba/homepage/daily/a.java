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
    private g cXq;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private AutoBannerView fHN;
    private BdTypeRecyclerView fHO;
    private com.baidu.tieba.homepage.daily.a.a fHP;
    private View.OnClickListener fHQ;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> fHR = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void y(int i, String str) {
            if (a.this.fHN != null) {
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
        this.fHO = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.daily_listview);
        this.fHO.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.fHO.setFadingEdgeLength(0);
        this.fHO.setOverScrollMode(2);
        this.fHP = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.fHO);
        this.mPullView = new i(tbPageContext);
        this.dcE.setProgressView(this.mPullView);
        this.dbr = new PbListView(pageActivity);
        this.dbr.getView();
        this.dbr.ib(d.C0236d.cp_bg_line_e);
        this.dbr.aez();
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.ia(d.C0236d.cp_cont_e);
        this.dbr.setHeight(l.h(pageActivity, d.e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cu(bVar.blF());
            this.fHP.setData(bVar.getDataList());
        }
    }

    public void cu(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.fHO != null) {
            if (v.T(list)) {
                if (this.fHN != null) {
                    this.fHO.removeHeaderView(this.fHN);
                    this.fHN = null;
                    return;
                }
                return;
            }
            if (this.fHN == null) {
                this.fHN = new AutoBannerView(this.mPageContext.getPageActivity());
                this.fHN.setOutOnCoverViewCallback(this.fHR);
                this.fHO.addHeaderView(this.fHN, 0);
            }
            this.fHN.cx(list);
            this.fHN.afl();
        }
    }

    public void showLoadingView() {
        o(false, this.mPageContext.getResources().getDimensionPixelSize(d.e.ds520));
    }

    public void o(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.cXq == null) {
            if (i < 0) {
                this.cXq = new g(pageActivity);
            } else {
                this.cXq = new g(pageActivity, i);
            }
            this.cXq.onChangeSkinType();
        }
        this.cXq.attachView(this.mRootView, z);
        this.fHO.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.cXq != null) {
            this.cXq.dettachView(this.mRootView);
            this.cXq = null;
            this.fHO.setNextPage(this.dbr);
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
                    if (a.this.fHQ != null) {
                        a.this.fHQ.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.jR(pageActivity.getResources().getDimensionPixelSize(d.e.ds280));
        this.mRefreshView.po(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.anC();
    }

    public void aBu() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCv() {
        this.fHO.setNextPage(this.dbr);
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCx() {
        this.fHO.setNextPage(null);
    }

    public void aCw() {
        this.fHO.setNextPage(this.dbr);
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeE();
        this.dbr.setText(this.mPageContext.getResources().getString(d.j.list_has_no_more));
    }

    public void blE() {
        this.fHO.setNextPage(this.dbr);
        this.dbr.aeD();
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dcE.setRefreshing(true);
    }

    public void aBN() {
        this.dcE.setRefreshing(false);
    }

    public void reload() {
        this.fHO.setSelection(0);
        startPullRefresh();
    }

    public void aCu() {
        this.fHP.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.cXq != null) {
                this.cXq.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ic(i);
            }
            if (this.dbr != null) {
                this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_d));
                this.dbr.ic(i);
            }
            if (this.fHN != null) {
                this.fHN.onChangeSkinType(i);
            }
            if (this.fHP != null) {
                this.fHP.onChangeSkinType(i);
            }
            al.l(this.dcE, d.C0236d.cp_bg_line_e);
            al.l(this.fHO, d.C0236d.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.fHO != null) {
            this.fHO.setOnSrollToBottomListener(eVar);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        this.fHQ = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fHP != null) {
            this.fHP.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.fHN != null) {
            this.fHN.afm();
        }
        this.fHO.setOnSrollToBottomListener(null);
        aBN();
    }
}
