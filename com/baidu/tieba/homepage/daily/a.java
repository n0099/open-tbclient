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
    private g djG;
    private PbListView dnG;
    private BdSwipeRefreshLayout dpi;
    private BdTypeRecyclerView gbU;
    private AutoBannerView gdw;
    private com.baidu.tieba.homepage.daily.a.a gdx;
    private View.OnClickListener gdy;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> gdz = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void B(int i, String str) {
            if (a.this.gdw != null) {
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
        this.dpi = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.daily_refresh_layout);
        this.gbU = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.daily_listview);
        this.gbU.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.gbU.setFadingEdgeLength(0);
        this.gbU.setOverScrollMode(2);
        this.gdx = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.gbU);
        this.mPullView = new i(tbPageContext);
        this.dpi.setProgressView(this.mPullView);
        this.dnG = new PbListView(pageActivity);
        this.dnG.getView();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.akA();
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.iT(R.color.cp_cont_e);
        this.dnG.setHeight(l.g(pageActivity, R.dimen.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cA(bVar.bvd());
            this.gdx.setData(bVar.getDataList());
        }
    }

    public void cA(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.gbU != null) {
            if (v.aa(list)) {
                if (this.gdw != null) {
                    this.gbU.removeHeaderView(this.gdw);
                    this.gdw = null;
                    return;
                }
                return;
            }
            if (this.gdw == null) {
                this.gdw = new AutoBannerView(this.mPageContext.getPageActivity());
                this.gdw.setOutOnCoverViewCallback(this.gdz);
                this.gbU.addHeaderView(this.gdw, 0);
            }
            this.gdw.cD(list);
            this.gdw.alm();
        }
    }

    public void showLoadingView() {
        o(false, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds520));
    }

    public void o(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.djG == null) {
            if (i < 0) {
                this.djG = new g(pageActivity);
            } else {
                this.djG = new g(pageActivity, i);
            }
            this.djG.onChangeSkinType();
        }
        this.djG.attachView(this.mRootView, z);
        this.gbU.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.djG != null) {
            this.djG.dettachView(this.mRootView);
            this.djG = null;
            this.gbU.setNextPage(this.dnG);
        }
        if (this.dpi != null) {
            this.dpi.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gdy != null) {
                        a.this.gdy.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.kK(pageActivity.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.mRefreshView.qN(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.atI();
    }

    public void aJh() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKi() {
        this.gbU.setNextPage(this.dnG);
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.akD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKk() {
        this.gbU.setNextPage(null);
    }

    public void aKj() {
        this.gbU.setNextPage(this.dnG);
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.akF();
        this.dnG.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
    }

    public void bvc() {
        this.gbU.setNextPage(this.dnG);
        this.dnG.akE();
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dpi.setRefreshing(true);
    }

    public void aJB() {
        this.dpi.setRefreshing(false);
    }

    public void reload() {
        this.gbU.setSelection(0);
        startPullRefresh();
    }

    public void aKh() {
        this.gdx.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.djG != null) {
                this.djG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.iV(i);
            }
            if (this.dnG != null) {
                this.dnG.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dnG.iV(i);
            }
            if (this.gdw != null) {
                this.gdw.onChangeSkinType(i);
            }
            if (this.gdx != null) {
                this.gdx.onChangeSkinType(i);
            }
            am.l(this.dpi, R.color.cp_bg_line_e);
            am.l(this.gbU, R.color.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.gbU != null) {
            this.gbU.setOnSrollToBottomListener(eVar);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.gdy = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.gdx != null) {
            this.gdx.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.gdw != null) {
            this.gdw.aln();
        }
        this.gbU.setOnSrollToBottomListener(null);
        aJB();
    }
}
