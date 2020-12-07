package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
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
/* loaded from: classes21.dex */
public class HotRankView extends FrameLayout {
    private g gAe;
    private BdTypeListView gpX;
    private View iIw;
    private com.baidu.tieba.hottopic.adapter.b kfy;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gpX = null;
        this.kfy = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gpX = null;
        this.kfy = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.gpX = null;
        this.kfy = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.gpX = new BdTypeListView(context);
        this.gpX.setVerticalScrollBarEnabled(false);
        this.gpX.setDividerHeight(0);
        this.gpX.setSelector(17170445);
        com.baidu.adp.base.e<?> J = i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.hottopic.view.HotRankView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    HotRankView.this.gpX.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cRs();
            }
        });
        this.gpX.setPullRefresh(this.mPullView);
        this.iIw = BdListViewHelper.a(context, this.gpX, BdListViewHelper.HeadType.HASTAB);
        this.gpX.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.kfy = new com.baidu.tieba.hottopic.adapter.b((HotRanklistActivity) this.pageContext.getOrignalPage(), this.gpX);
        addView(this.gpX);
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.iIw.getLayoutParams();
        layoutParams.height = i2;
        this.iIw.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.kfy != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.gpX.setVisibility(0);
            this.kfy.a(jVar, str);
        }
    }

    public void rR(boolean z) {
        if (this.gpX != null) {
            if (z) {
                this.gpX.completePullRefresh();
            } else {
                this.gpX.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void D(boolean z, int i) {
        if (!cqy()) {
            if (this.gAe == null) {
                if (i <= 0) {
                    this.gAe = new g(getContext());
                } else {
                    this.gAe = new g(getContext(), i);
                    this.gAe.bDY();
                }
                this.gAe.onChangeSkinType();
            }
            this.gAe.attachView(this, z);
            this.gpX.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
        }
    }

    public boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    public void aR(String str, boolean z) {
        if (!cqz()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.Yb();
                            HotRankView.this.D(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cRs();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.gpX.setVisibility(8);
        }
    }

    public void Yb() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean cqz() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gpX, R.color.CAM_X0201);
        this.gpX.getListAdapter().notifyDataSetChanged();
        if (this.gAe != null) {
            this.gAe.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
