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
    private f bKy;
    private PbListView bOB;
    private BdSwipeRefreshLayout bRo;
    private AutoBannerView euJ;
    private BdTypeRecyclerView euK;
    private com.baidu.tieba.homepage.daily.a.a euL;
    private View.OnClickListener euM;
    private TbPageContext<?> mPageContext;
    private k mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> elw = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void g(int i, String str) {
            if (a.this.euJ != null) {
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
        this.bRo = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.bRo.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.euK = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.daily_listview);
        this.euK.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.euK.setFadingEdgeLength(0);
        this.euK.setOverScrollMode(2);
        this.euL = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.euK);
        this.mPullView = new k(tbPageContext);
        this.bRo.setProgressView(this.mPullView);
        this.bOB = new PbListView(pageActivity);
        this.bOB.getView();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.EZ();
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.ew(e.d.cp_cont_e);
        this.bOB.setHeight(l.h(pageActivity, e.C0210e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bV(bVar.aLe());
            this.euL.setData(bVar.getDataList());
        }
    }

    public void bV(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.euK != null) {
            if (v.I(list)) {
                if (this.euJ != null) {
                    this.euK.removeHeaderView(this.euJ);
                    this.euJ = null;
                    return;
                }
                return;
            }
            if (this.euJ == null) {
                this.euJ = new AutoBannerView(this.mPageContext.getPageActivity());
                this.euJ.setOutOnCoverViewCallback(this.elw);
                this.euK.addHeaderView(this.euJ, 0);
            }
            this.euJ.bW(list);
            this.euJ.FE();
        }
    }

    public void showLoadingView() {
        i(false, this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds520));
    }

    public void i(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.bKy == null) {
            if (i < 0) {
                this.bKy = new f(pageActivity);
            } else {
                this.bKy = new f(pageActivity, i);
            }
            this.bKy.onChangeSkinType();
        }
        this.bKy.attachView(this.mRootView, z);
        this.euK.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.bKy != null) {
            this.bKy.dettachView(this.mRootView);
            this.bKy = null;
            this.euK.setNextPage(this.bOB);
        }
        if (this.bRo != null) {
            this.bRo.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.euM != null) {
                        a.this.euM.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.ge(pageActivity.getResources().getDimensionPixelSize(e.C0210e.ds280));
        this.mRefreshView.io(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.NM();
    }

    public void aba() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abb() {
        this.euK.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.Fc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abd() {
        this.euK.setNextPage(null);
    }

    public void abc() {
        this.euK.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.Fe();
        this.bOB.setText(this.mPageContext.getResources().getString(e.j.list_has_no_more));
    }

    public void aLc() {
        this.euK.setNextPage(this.bOB);
        this.bOB.Fd();
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.bRo.setRefreshing(true);
    }

    public void aLd() {
        this.bRo.setRefreshing(false);
    }

    public void reload() {
        this.euK.setSelection(0);
        startPullRefresh();
    }

    public void aaY() {
        this.euL.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bKy != null) {
                this.bKy.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ey(i);
            }
            if (this.bOB != null) {
                this.bOB.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bOB.ey(i);
            }
            if (this.euJ != null) {
                this.euJ.onChangeSkinType(i);
            }
            if (this.euL != null) {
                this.euL.onChangeSkinType(i);
            }
            al.j(this.bRo, e.d.cp_bg_line_e);
            al.j(this.euK, e.d.cp_bg_line_d);
        }
    }

    public void a(j.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.euK != null) {
            this.euK.setOnSrollToBottomListener(eVar);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.euM = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.euL != null) {
            this.euL.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.euJ != null) {
            this.euJ.FF();
        }
        this.euK.setOnSrollToBottomListener(null);
        aLd();
    }
}
