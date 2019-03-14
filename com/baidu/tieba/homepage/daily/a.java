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
    private g cXm;
    private PbListView dbn;
    private BdSwipeRefreshLayout dcA;
    private AutoBannerView fHM;
    private BdTypeRecyclerView fHN;
    private com.baidu.tieba.homepage.daily.a.a fHO;
    private View.OnClickListener fHP;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> fHQ = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void y(int i, String str) {
            if (a.this.fHM != null) {
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
        this.dcA = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.dcA.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.fHN = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.daily_listview);
        this.fHN.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.fHN.setFadingEdgeLength(0);
        this.fHN.setOverScrollMode(2);
        this.fHO = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.fHN);
        this.mPullView = new i(tbPageContext);
        this.dcA.setProgressView(this.mPullView);
        this.dbn = new PbListView(pageActivity);
        this.dbn.getView();
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.aez();
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.dbn.setHeight(l.h(pageActivity, d.e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cu(bVar.blE());
            this.fHO.setData(bVar.getDataList());
        }
    }

    public void cu(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.fHN != null) {
            if (v.T(list)) {
                if (this.fHM != null) {
                    this.fHN.removeHeaderView(this.fHM);
                    this.fHM = null;
                    return;
                }
                return;
            }
            if (this.fHM == null) {
                this.fHM = new AutoBannerView(this.mPageContext.getPageActivity());
                this.fHM.setOutOnCoverViewCallback(this.fHQ);
                this.fHN.addHeaderView(this.fHM, 0);
            }
            this.fHM.cx(list);
            this.fHM.afl();
        }
    }

    public void showLoadingView() {
        o(false, this.mPageContext.getResources().getDimensionPixelSize(d.e.ds520));
    }

    public void o(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.cXm == null) {
            if (i < 0) {
                this.cXm = new g(pageActivity);
            } else {
                this.cXm = new g(pageActivity, i);
            }
            this.cXm.onChangeSkinType();
        }
        this.cXm.attachView(this.mRootView, z);
        this.fHN.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.cXm != null) {
            this.cXm.dettachView(this.mRootView);
            this.cXm = null;
            this.fHN.setNextPage(this.dbn);
        }
        if (this.dcA != null) {
            this.dcA.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fHP != null) {
                        a.this.fHP.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.jR(pageActivity.getResources().getDimensionPixelSize(d.e.ds280));
        this.mRefreshView.po(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.anB();
    }

    public void aBt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCu() {
        this.fHN.setNextPage(this.dbn);
        this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbn.aeC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCw() {
        this.fHN.setNextPage(null);
    }

    public void aCv() {
        this.fHN.setNextPage(this.dbn);
        this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbn.aeE();
        this.dbn.setText(this.mPageContext.getResources().getString(d.j.list_has_no_more));
    }

    public void blD() {
        this.fHN.setNextPage(this.dbn);
        this.dbn.aeD();
        this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dcA.setRefreshing(true);
    }

    public void aBM() {
        this.dcA.setRefreshing(false);
    }

    public void reload() {
        this.fHN.setSelection(0);
        startPullRefresh();
    }

    public void aCt() {
        this.fHO.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.cXm != null) {
                this.cXm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ic(i);
            }
            if (this.dbn != null) {
                this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                this.dbn.ic(i);
            }
            if (this.fHM != null) {
                this.fHM.onChangeSkinType(i);
            }
            if (this.fHO != null) {
                this.fHO.onChangeSkinType(i);
            }
            al.l(this.dcA, d.C0277d.cp_bg_line_e);
            al.l(this.fHN, d.C0277d.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.fHN != null) {
            this.fHN.setOnSrollToBottomListener(eVar);
        }
    }

    public void u(View.OnClickListener onClickListener) {
        this.fHP = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fHO != null) {
            this.fHO.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.fHM != null) {
            this.fHM.afm();
        }
        this.fHN.setOnSrollToBottomListener(null);
        aBM();
    }
}
