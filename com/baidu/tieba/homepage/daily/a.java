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
    private g dhY;
    private PbListView dlY;
    private BdSwipeRefreshLayout dni;
    private BdTypeRecyclerView fWX;
    private com.baidu.tieba.homepage.daily.a.a fYA;
    private View.OnClickListener fYB;
    private AutoBannerView fYz;
    private TbPageContext<?> mPageContext;
    private i mPullView;
    private h mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> fYC = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void B(int i, String str) {
            if (a.this.fYz != null) {
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
        this.dni = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.daily_refresh_layout);
        this.fWX = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.daily_listview);
        this.fWX.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.fWX.setFadingEdgeLength(0);
        this.fWX.setOverScrollMode(2);
        this.fYA = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.fWX);
        this.mPullView = new i(tbPageContext);
        this.dni.setProgressView(this.mPullView);
        this.dlY = new PbListView(pageActivity);
        this.dlY.getView();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.ajv();
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.iN(R.color.cp_cont_e);
        this.dlY.setHeight(l.g(pageActivity, R.dimen.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            cz(bVar.btb());
            this.fYA.setData(bVar.getDataList());
        }
    }

    public void cz(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.fWX != null) {
            if (v.aa(list)) {
                if (this.fYz != null) {
                    this.fWX.removeHeaderView(this.fYz);
                    this.fYz = null;
                    return;
                }
                return;
            }
            if (this.fYz == null) {
                this.fYz = new AutoBannerView(this.mPageContext.getPageActivity());
                this.fYz.setOutOnCoverViewCallback(this.fYC);
                this.fWX.addHeaderView(this.fYz, 0);
            }
            this.fYz.cC(list);
            this.fYz.akh();
        }
    }

    public void showLoadingView() {
        o(false, this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds520));
    }

    public void o(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.dhY == null) {
            if (i < 0) {
                this.dhY = new g(pageActivity);
            } else {
                this.dhY = new g(pageActivity, i);
            }
            this.dhY.onChangeSkinType();
        }
        this.dhY.attachView(this.mRootView, z);
        this.fWX.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.dhY != null) {
            this.dhY.dettachView(this.mRootView);
            this.dhY = null;
            this.fWX.setNextPage(this.dlY);
        }
        if (this.dni != null) {
            this.dni.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.fYB != null) {
                        a.this.fYB.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.kE(pageActivity.getResources().getDimensionPixelSize(R.dimen.ds280));
        this.mRefreshView.qw(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.asB();
    }

    public void aHK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIH() {
        this.fWX.setNextPage(this.dlY);
        this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlY.ajy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIJ() {
        this.fWX.setNextPage(null);
    }

    public void aII() {
        this.fWX.setNextPage(this.dlY);
        this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlY.ajA();
        this.dlY.setText(this.mPageContext.getResources().getString(R.string.list_has_no_more));
    }

    public void bta() {
        this.fWX.setNextPage(this.dlY);
        this.dlY.ajz();
        this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.dni.setRefreshing(true);
    }

    public void aIc() {
        this.dni.setRefreshing(false);
    }

    public void reload() {
        this.fWX.setSelection(0);
        startPullRefresh();
    }

    public void aIG() {
        this.fYA.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.dhY != null) {
                this.dhY.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.iP(i);
            }
            if (this.dlY != null) {
                this.dlY.setTextColor(al.getColor(R.color.cp_cont_d));
                this.dlY.iP(i);
            }
            if (this.fYz != null) {
                this.fYz.onChangeSkinType(i);
            }
            if (this.fYA != null) {
                this.fYA.onChangeSkinType(i);
            }
            al.l(this.dni, R.color.cp_bg_line_e);
            al.l(this.fWX, R.color.cp_bg_line_d);
        }
    }

    public void setListPullRefreshListener(h.c cVar) {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(cVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.fWX != null) {
            this.fWX.setOnSrollToBottomListener(eVar);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.fYB = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.fYA != null) {
            this.fYA.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.fYz != null) {
            this.fYz.aki();
        }
        this.fWX.setOnSrollToBottomListener(null);
        aIc();
    }
}
