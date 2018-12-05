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
    private f bKv;
    private PbListView bOy;
    private BdSwipeRefreshLayout bRl;
    private AutoBannerView erS;
    private BdTypeRecyclerView erT;
    private com.baidu.tieba.homepage.daily.a.a erU;
    private View.OnClickListener erV;
    private TbPageContext<?> mPageContext;
    private k mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> eiG = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void g(int i, String str) {
            if (a.this.erS != null) {
                TiebaStatic.log(new am("c13173").x("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new am("c13174").x("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        f(this.mPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(e.h.daily_page_view, (ViewGroup) null);
        this.bRl = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.bRl.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.erT = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.daily_listview);
        this.erT.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.erT.setFadingEdgeLength(0);
        this.erT.setOverScrollMode(2);
        this.erU = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.erT);
        this.mPullView = new k(tbPageContext);
        this.bRl.setProgressView(this.mPullView);
        this.bOy = new PbListView(pageActivity);
        this.bOy.getView();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.EZ();
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.ew(e.d.cp_cont_e);
        this.bOy.setHeight(l.h(pageActivity, e.C0210e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bU(bVar.aKp());
            this.erU.setData(bVar.getDataList());
        }
    }

    public void bU(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.erT != null) {
            if (v.I(list)) {
                if (this.erS != null) {
                    this.erT.removeHeaderView(this.erS);
                    this.erS = null;
                    return;
                }
                return;
            }
            if (this.erS == null) {
                this.erS = new AutoBannerView(this.mPageContext.getPageActivity());
                this.erS.setOutOnCoverViewCallback(this.eiG);
                this.erT.addHeaderView(this.erS, 0);
            }
            this.erS.bV(list);
            this.erS.FD();
        }
    }

    public void showLoadingView() {
        i(false, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds520));
    }

    public void i(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.bKv == null) {
            if (i < 0) {
                this.bKv = new f(pageActivity);
            } else {
                this.bKv = new f(pageActivity, i);
            }
            this.bKv.onChangeSkinType();
        }
        this.bKv.attachView(this.mRootView, z);
        this.erT.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.bKv != null) {
            this.bKv.dettachView(this.mRootView);
            this.bKv = null;
            this.erT.setNextPage(this.bOy);
        }
        if (this.bRl != null) {
            this.bRl.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.erV != null) {
                        a.this.erV.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.gd(pageActivity.getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.mRefreshView.in(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.NL();
    }

    public void aaY() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaZ() {
        this.erT.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.Fc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abb() {
        this.erT.setNextPage(null);
    }

    public void aba() {
        this.erT.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.Fe();
        this.bOy.setText(this.mPageContext.getResources().getString(e.j.list_has_no_more));
    }

    public void aKn() {
        this.erT.setNextPage(this.bOy);
        this.bOy.Fd();
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.bRl.setRefreshing(true);
    }

    public void aKo() {
        this.bRl.setRefreshing(false);
    }

    public void reload() {
        this.erT.setSelection(0);
        startPullRefresh();
    }

    public void aaW() {
        this.erU.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bKv != null) {
                this.bKv.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.bOy != null) {
                this.bOy.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bOy.ey(i);
            }
            if (this.erS != null) {
                this.erS.onChangeSkinType(i);
            }
            if (this.erU != null) {
                this.erU.onChangeSkinType(i);
            }
            al.j(this.bRl, e.d.cp_bg_line_e);
            al.j(this.erT, e.d.cp_bg_line_d);
        }
    }

    public void a(j.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.erT != null) {
            this.erT.setOnSrollToBottomListener(eVar);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.erV = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.erU != null) {
            this.erU.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.erS != null) {
            this.erS.FE();
        }
        this.erT.setOnSrollToBottomListener(null);
        aKo();
    }
}
