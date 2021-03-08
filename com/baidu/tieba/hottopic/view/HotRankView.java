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
/* loaded from: classes7.dex */
public class HotRankView extends FrameLayout {
    private BdTypeListView gAY;
    private g gLk;
    private View iXG;
    private com.baidu.tieba.hottopic.adapter.a kyE;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAY = null;
        this.kyE = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAY = null;
        this.kyE = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.gAY = null;
        this.kyE = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.gAY = new BdTypeListView(context);
        this.gAY.setVerticalScrollBarEnabled(false);
        this.gAY.setDividerHeight(0);
        this.gAY.setSelector(17170445);
        f<?> J = j.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.hottopic.view.HotRankView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    HotRankView.this.gAY.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cSV();
            }
        });
        this.gAY.setPullRefresh(this.mPullView);
        this.iXG = BdListViewHelper.a(context, this.gAY, BdListViewHelper.HeadType.HASTAB);
        this.gAY.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.kyE = new com.baidu.tieba.hottopic.adapter.a((HotRanklistActivity) this.pageContext.getOrignalPage(), this.gAY);
        addView(this.gAY);
    }

    public void h(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.iXG.getLayoutParams();
        layoutParams.height = i2;
        this.iXG.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.kyE != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.gAY.setVisibility(0);
            this.kyE.a(jVar, str);
        }
    }

    public void sx(boolean z) {
        if (this.gAY != null) {
            if (z) {
                this.gAY.completePullRefresh();
            } else {
                this.gAY.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void C(boolean z, int i) {
        if (!cqY()) {
            if (this.gLk == null) {
                if (i <= 0) {
                    this.gLk = new g(getContext());
                } else {
                    this.gLk = new g(getContext(), i);
                    this.gLk.bCV();
                }
                this.gLk.onChangeSkinType();
            }
            this.gLk.attachView(this, z);
            this.gAY.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
    }

    public boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    public void aQ(String str, boolean z) {
        if (!cqZ()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.Xc();
                            HotRankView.this.C(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cSV();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.gAY.setVisibility(8);
        }
    }

    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean cqZ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        ap.setBackgroundColor(this.gAY, R.color.CAM_X0201);
        this.gAY.getListAdapter().notifyDataSetChanged();
        if (this.gLk != null) {
            this.gLk.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
