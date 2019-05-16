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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
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
    private g dhX;
    private PbListView dlX;
    private BdSwipeRefreshLayout dnh;
    private BdTypeRecyclerView fWU;
    private AutoBannerView fYw;
    private com.baidu.tieba.homepage.daily.a.a fYx;
    private View.OnClickListener fYy;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> fYz = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void B(int i, String str) {
            if (a.this.fYw != null) {
                TiebaStatic.log(new am("c13173").P("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new am("c13174").P("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        g(this.mPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(R.layout.daily_page_view, (ViewGroup) null);
        this.dnh = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.daily_refresh_layout);
        this.fWU = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.daily_listview);
        this.fWU.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.fWU.setFadingEdgeLength(0);
        this.fWU.setOverScrollMode(2);
        this.fYx = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.fWU);
        this.mPullView = new i(tbPageContext);
        this.dnh.setProgressView(this.mPullView);
        this.dlX = new PbListView(pageActivity);
        this.dlX.getView();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.ajv();
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.iN(R.color.cp_cont_e);
        this.dlX.setHeight(l.g(pageActivity, R.dimen.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cz(bVar.bsX());
            this.fYx.setData(bVar.getDataList());
        }
    }

    public void cz(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.fWU != null) {
            if (v.aa(list)) {
                if (this.fYw != null) {
                    this.fWU.removeHeaderView(this.fYw);
                    this.fYw = null;
                    return;
                }
                return;
            }
            if (this.fYw == null) {
                this.fYw = new AutoBannerView(this.mPageContext.getPageActivity());
                this.fYw.setOutOnCoverViewCallback(this.fYz);
                this.fWU.addHeaderView(this.fYw, 0);
            }
            this.fYw.cC(list);
            this.fYw.akh();
        }
    }

    public void showLoadingView() {
        o(false, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds520));
    }

    public void o(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.dhX == null) {
            if (i < 0) {
                this.dhX = new g(pageActivity);
            } else {
                this.dhX = new g(pageActivity, i);
            }
            this.dhX.onChangeSkinType();
        }
        this.dhX.attachView(this.mRootView, z);
        this.fWU.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.dhX != null) {
            this.dhX.dettachView(this.mRootView);
            this.dhX = null;
            this.fWU.setNextPage(this.dlX);
        }
        if (this.dnh != null) {
            this.dnh.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fYy != null) {
                        a.this.fYy.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.kE(pageActivity.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.mRefreshView.qx(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.asB();
    }

    public void aHH() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIE() {
        this.fWU.setNextPage(this.dlX);
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.ajy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIG() {
        this.fWU.setNextPage(null);
    }

    public void aIF() {
        this.fWU.setNextPage(this.dlX);
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.ajA();
        this.dlX.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
    }

    public void bsW() {
        this.fWU.setNextPage(this.dlX);
        this.dlX.ajz();
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dnh.setRefreshing(true);
    }

    public void aHZ() {
        this.dnh.setRefreshing(false);
    }

    public void reload() {
        this.fWU.setSelection(0);
        startPullRefresh();
    }

    public void aID() {
        this.fYx.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dhX != null) {
                this.dhX.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.iP(i);
            }
            if (this.dlX != null) {
                this.dlX.setTextColor(al.getColor(R.color.cp_cont_d));
                this.dlX.iP(i);
            }
            if (this.fYw != null) {
                this.fYw.onChangeSkinType(i);
            }
            if (this.fYx != null) {
                this.fYx.onChangeSkinType(i);
            }
            al.l(this.dnh, R.color.cp_bg_line_e);
            al.l(this.fWU, R.color.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.fWU != null) {
            this.fWU.setOnSrollToBottomListener(eVar);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.fYy = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fYx != null) {
            this.fYx.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.fYw != null) {
            this.fYw.aki();
        }
        this.fWU.setOnSrollToBottomListener(null);
        aHZ();
    }
}
