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
/* loaded from: classes2.dex */
public class a {
    private PbListView bBr;
    private BdSwipeRefreshLayout bEe;
    private f bxm;
    private AutoBannerView ebJ;
    private BdTypeRecyclerView ebK;
    private com.baidu.tieba.homepage.daily.a.a ebL;
    private View.OnClickListener ebM;
    private TbPageContext<?> mPageContext;
    private k mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> dSP = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void h(int i, String str) {
            if (a.this.ebJ != null) {
                TiebaStatic.log(new am("c13173").w("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new am("c13174").w("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        f(this.mPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(e.h.daily_page_view, (ViewGroup) null);
        this.bEe = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.bEe.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ebK = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.daily_listview);
        this.ebK.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.ebK.setFadingEdgeLength(0);
        this.ebK.setOverScrollMode(2);
        this.ebL = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.ebK);
        this.mPullView = new k(tbPageContext);
        this.bEe.setProgressView(this.mPullView);
        this.bBr = new PbListView(pageActivity);
        this.bBr.getView();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.BF();
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.dK(e.d.cp_cont_e);
        this.bBr.setHeight(l.h(pageActivity, e.C0141e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bE(bVar.aFI());
            this.ebL.setData(bVar.getDataList());
        }
    }

    public void bE(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.ebK != null) {
            if (v.z(list)) {
                if (this.ebJ != null) {
                    this.ebK.removeHeaderView(this.ebJ);
                    this.ebJ = null;
                    return;
                }
                return;
            }
            if (this.ebJ == null) {
                this.ebJ = new AutoBannerView(this.mPageContext.getPageActivity());
                this.ebJ.setOutOnCoverViewCallback(this.dSP);
                this.ebK.addHeaderView(this.ebJ, 0);
            }
            this.ebJ.bF(list);
            this.ebJ.Ck();
        }
    }

    public void showLoadingView() {
        g(false, this.mPageContext.getResources().getDimensionPixelSize(e.C0141e.ds520));
    }

    public void g(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.bxm == null) {
            if (i < 0) {
                this.bxm = new f(pageActivity);
            } else {
                this.bxm = new f(pageActivity, i);
            }
            this.bxm.onChangeSkinType();
        }
        this.bxm.c(this.mRootView, z);
        this.ebK.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.bxm != null) {
            this.bxm.ad(this.mRootView);
            this.bxm = null;
            this.ebK.setNextPage(this.bBr);
        }
        if (this.bEe != null) {
            this.bEe.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ebM != null) {
                        a.this.ebM.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.fs(pageActivity.getResources().getDimensionPixelSize(e.C0141e.ds280));
        this.mRefreshView.hG(str);
        this.mRefreshView.c(view, false);
        this.mRefreshView.KA();
    }

    public void Wa() {
        if (this.mRefreshView != null) {
            this.mRefreshView.ad(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wb() {
        this.ebK.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.BI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wd() {
        this.ebK.setNextPage(null);
    }

    public void Wc() {
        this.ebK.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.BK();
        this.bBr.setText(this.mPageContext.getResources().getString(e.j.list_has_no_more));
    }

    public void aFG() {
        this.ebK.setNextPage(this.bBr);
        this.bBr.BJ();
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.bEe.setRefreshing(true);
    }

    public void aFH() {
        this.bEe.setRefreshing(false);
    }

    public void reload() {
        this.ebK.setSelection(0);
        startPullRefresh();
    }

    public void VY() {
        this.ebL.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bxm != null) {
                this.bxm.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dM(i);
            }
            if (this.bBr != null) {
                this.bBr.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bBr.dM(i);
            }
            if (this.ebJ != null) {
                this.ebJ.onChangeSkinType(i);
            }
            if (this.ebL != null) {
                this.ebL.onChangeSkinType(i);
            }
            al.j(this.bEe, e.d.cp_bg_line_e);
            al.j(this.ebK, e.d.cp_bg_line_d);
        }
    }

    public void a(j.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.ebK != null) {
            this.ebK.setOnSrollToBottomListener(eVar);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.ebM = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ebL != null) {
            this.ebL.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.ebJ != null) {
            this.ebJ.Cl();
        }
        this.ebK.setOnSrollToBottomListener(null);
        aFH();
    }
}
