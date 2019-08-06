package com.baidu.tieba.homepage.daily;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.m.g;
import com.baidu.tbadk.m.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.view.AutoBannerView;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private g djN;
    private PbListView dnN;
    private BdSwipeRefreshLayout dpp;
    private BdTypeRecyclerView gcK;
    private AutoBannerView gem;
    private com.baidu.tieba.homepage.daily.a.a gen;
    private View.OnClickListener gep;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> geq = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void B(int i, String str) {
            if (a.this.gem != null) {
                TiebaStatic.log(new an("c13173").P("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new an("c13174").P("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        g(this.mPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(R.layout.daily_page_view, (ViewGroup) null);
        this.dpp = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.daily_refresh_layout);
        this.gcK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.daily_listview);
        this.gcK.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.gcK.setFadingEdgeLength(0);
        this.gcK.setOverScrollMode(2);
        this.gen = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.gcK);
        this.mPullView = new i(tbPageContext);
        this.dpp.setProgressView(this.mPullView);
        this.dnN = new PbListView(pageActivity);
        this.dnN.getView();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.akC();
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.iT(R.color.cp_cont_e);
        this.dnN.setHeight(l.g(pageActivity, R.dimen.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cz(bVar.bvq());
            this.gen.setData(bVar.getDataList());
        }
    }

    public void cz(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.gcK != null) {
            if (v.aa(list)) {
                if (this.gem != null) {
                    this.gcK.removeHeaderView(this.gem);
                    this.gem = null;
                    return;
                }
                return;
            }
            if (this.gem == null) {
                this.gem = new AutoBannerView(this.mPageContext.getPageActivity());
                this.gem.setOutOnCoverViewCallback(this.geq);
                this.gcK.addHeaderView(this.gem, 0);
            }
            this.gem.cC(list);
            this.gem.alo();
        }
    }

    public void showLoadingView() {
        o(false, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds520));
    }

    public void o(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.djN == null) {
            if (i < 0) {
                this.djN = new g(pageActivity);
            } else {
                this.djN = new g(pageActivity, i);
            }
            this.djN.onChangeSkinType();
        }
        this.djN.attachView(this.mRootView, z);
        this.gcK.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.djN != null) {
            this.djN.dettachView(this.mRootView);
            this.djN = null;
            this.gcK.setNextPage(this.dnN);
        }
        if (this.dpp != null) {
            this.dpp.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gep != null) {
                        a.this.gep.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.kL(pageActivity.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.mRefreshView.qN(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.atK();
    }

    public void aJj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKk() {
        this.gcK.setNextPage(this.dnN);
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.akF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKm() {
        this.gcK.setNextPage(null);
    }

    public void aKl() {
        this.gcK.setNextPage(this.dnN);
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.akH();
        this.dnN.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
    }

    public void bvp() {
        this.gcK.setNextPage(this.dnN);
        this.dnN.akG();
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dpp.setRefreshing(true);
    }

    public void aJD() {
        this.dpp.setRefreshing(false);
    }

    public void reload() {
        this.gcK.setSelection(0);
        startPullRefresh();
    }

    public void aKj() {
        this.gen.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.djN != null) {
                this.djN.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.iV(i);
            }
            if (this.dnN != null) {
                this.dnN.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dnN.iV(i);
            }
            if (this.gem != null) {
                this.gem.onChangeSkinType(i);
            }
            if (this.gen != null) {
                this.gen.onChangeSkinType(i);
            }
            am.l(this.dpp, R.color.cp_bg_line_e);
            am.l(this.gcK, R.color.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.gcK != null) {
            this.gcK.setOnSrollToBottomListener(eVar);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.gep = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gen != null) {
            this.gen.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.gem != null) {
            this.gem.alp();
        }
        this.gcK.setOnSrollToBottomListener(null);
        aJD();
    }
}
