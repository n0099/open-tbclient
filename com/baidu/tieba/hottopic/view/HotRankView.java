package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.base.f;
import com.baidu.adp.base.j;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
/* loaded from: classes8.dex */
public class HotRankView extends FrameLayout {
    private g gJB;
    private BdTypeListView gzp;
    private View iVX;
    private com.baidu.tieba.hottopic.adapter.a kwC;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzp = null;
        this.kwC = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzp = null;
        this.kwC = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.gzp = null;
        this.kwC = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.gzp = new BdTypeListView(context);
        this.gzp.setVerticalScrollBarEnabled(false);
        this.gzp.setDividerHeight(0);
        this.gzp.setSelector(17170445);
        f<?> K = j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.hottopic.view.HotRankView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    HotRankView.this.gzp.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cSO();
            }
        });
        this.gzp.setPullRefresh(this.mPullView);
        this.iVX = BdListViewHelper.a(context, this.gzp, BdListViewHelper.HeadType.HASTAB);
        this.gzp.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_ON_SCROLL));
            }
        });
        this.kwC = new com.baidu.tieba.hottopic.adapter.a((HotRanklistActivity) this.pageContext.getOrignalPage(), this.gzp);
        addView(this.gzp);
    }

    public void h(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.iVX.getLayoutParams();
        layoutParams.height = i2;
        this.iVX.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.kwC != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.gzp.setVisibility(0);
            this.kwC.a(jVar, str);
        }
    }

    public void sx(boolean z) {
        if (this.gzp != null) {
            if (z) {
                this.gzp.completePullRefresh();
            } else {
                this.gzp.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void C(boolean z, int i) {
        if (!cqS()) {
            if (this.gJB == null) {
                if (i <= 0) {
                    this.gJB = new g(getContext());
                } else {
                    this.gJB = new g(getContext(), i);
                    this.gJB.bCS();
                }
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this, z);
            this.gzp.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void aQ(String str, boolean z) {
        if (!cqT()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.WZ();
                            HotRankView.this.C(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cSO();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.gzp.setVisibility(8);
        }
    }

    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean cqT() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gzp, R.color.CAM_X0201);
        this.gzp.getListAdapter().notifyDataSetChanged();
        if (this.gJB != null) {
            this.gJB.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
