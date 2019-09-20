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
    private g dly;
    private PbListView dpz;
    private BdSwipeRefreshLayout dra;
    private BdTypeRecyclerView geC;
    private AutoBannerView gge;
    private com.baidu.tieba.homepage.daily.a.a ggf;
    private View.OnClickListener ggg;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> ggh = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void B(int i, String str) {
            if (a.this.gge != null) {
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
        this.dra = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.daily_refresh_layout);
        this.geC = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.daily_listview);
        this.geC.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.geC.setFadingEdgeLength(0);
        this.geC.setOverScrollMode(2);
        this.ggf = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.geC);
        this.mPullView = new i(tbPageContext);
        this.dra.setProgressView(this.mPullView);
        this.dpz = new PbListView(pageActivity);
        this.dpz.getView();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.akO();
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.iW(R.color.cp_cont_e);
        this.dpz.setHeight(l.g(pageActivity, R.dimen.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cz(bVar.bwe());
            this.ggf.setData(bVar.getDataList());
        }
    }

    public void cz(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.geC != null) {
            if (v.aa(list)) {
                if (this.gge != null) {
                    this.geC.removeHeaderView(this.gge);
                    this.gge = null;
                    return;
                }
                return;
            }
            if (this.gge == null) {
                this.gge = new AutoBannerView(this.mPageContext.getPageActivity());
                this.gge.setOutOnCoverViewCallback(this.ggh);
                this.geC.addHeaderView(this.gge, 0);
            }
            this.gge.cC(list);
            this.gge.alA();
        }
    }

    public void showLoadingView() {
        o(false, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds520));
    }

    public void o(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.dly == null) {
            if (i < 0) {
                this.dly = new g(pageActivity);
            } else {
                this.dly = new g(pageActivity, i);
            }
            this.dly.onChangeSkinType();
        }
        this.dly.attachView(this.mRootView, z);
        this.geC.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.dly != null) {
            this.dly.dettachView(this.mRootView);
            this.dly = null;
            this.geC.setNextPage(this.dpz);
        }
        if (this.dra != null) {
            this.dra.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ggg != null) {
                        a.this.ggg.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.kO(pageActivity.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.mRefreshView.qY(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.atW();
    }

    public void aJN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKO() {
        this.geC.setNextPage(this.dpz);
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.akR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKQ() {
        this.geC.setNextPage(null);
    }

    public void aKP() {
        this.geC.setNextPage(this.dpz);
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.akT();
        this.dpz.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
    }

    public void bwd() {
        this.geC.setNextPage(this.dpz);
        this.dpz.akS();
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dra.setRefreshing(true);
    }

    public void aKh() {
        this.dra.setRefreshing(false);
    }

    public void reload() {
        this.geC.setSelection(0);
        startPullRefresh();
    }

    public void aKN() {
        this.ggf.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dly != null) {
                this.dly.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.iY(i);
            }
            if (this.dpz != null) {
                this.dpz.setTextColor(am.getColor(R.color.cp_cont_d));
                this.dpz.iY(i);
            }
            if (this.gge != null) {
                this.gge.onChangeSkinType(i);
            }
            if (this.ggf != null) {
                this.ggf.onChangeSkinType(i);
            }
            am.l(this.dra, R.color.cp_bg_line_e);
            am.l(this.geC, R.color.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.geC != null) {
            this.geC.setOnSrollToBottomListener(eVar);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.ggg = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ggf != null) {
            this.ggf.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.gge != null) {
            this.gge.alB();
        }
        this.geC.setOnSrollToBottomListener(null);
        aKh();
    }
}
