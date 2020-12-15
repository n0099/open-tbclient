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
    private g gAg;
    private BdTypeListView gpZ;
    private View iIy;
    private com.baidu.tieba.hottopic.adapter.b kfA;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gpZ = null;
        this.kfA = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gpZ = null;
        this.kfA = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.gpZ = null;
        this.kfA = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.gpZ = new BdTypeListView(context);
        this.gpZ.setVerticalScrollBarEnabled(false);
        this.gpZ.setDividerHeight(0);
        this.gpZ.setSelector(17170445);
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
                    HotRankView.this.gpZ.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cRt();
            }
        });
        this.gpZ.setPullRefresh(this.mPullView);
        this.iIy = BdListViewHelper.a(context, this.gpZ, BdListViewHelper.HeadType.HASTAB);
        this.gpZ.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.kfA = new com.baidu.tieba.hottopic.adapter.b((HotRanklistActivity) this.pageContext.getOrignalPage(), this.gpZ);
        addView(this.gpZ);
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.iIy.getLayoutParams();
        layoutParams.height = i2;
        this.iIy.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.kfA != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.gpZ.setVisibility(0);
            this.kfA.a(jVar, str);
        }
    }

    public void rR(boolean z) {
        if (this.gpZ != null) {
            if (z) {
                this.gpZ.completePullRefresh();
            } else {
                this.gpZ.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void D(boolean z, int i) {
        if (!cqz()) {
            if (this.gAg == null) {
                if (i <= 0) {
                    this.gAg = new g(getContext());
                } else {
                    this.gAg = new g(getContext(), i);
                    this.gAg.bDY();
                }
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this, z);
            this.gpZ.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void aR(String str, boolean z) {
        if (!cqA()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.Yb();
                            HotRankView.this.D(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cRt();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.gpZ.setVisibility(8);
        }
    }

    public void Yb() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean cqA() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gpZ, R.color.CAM_X0201);
        this.gpZ.getListAdapter().notifyDataSetChanged();
        if (this.gAg != null) {
            this.gAg.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
