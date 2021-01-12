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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
/* loaded from: classes7.dex */
public class HotRankView extends FrameLayout {
    private g gGD;
    private BdTypeListView gwr;
    private View iQc;
    private com.baidu.tieba.hottopic.adapter.a koh;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gwr = null;
        this.koh = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gwr = null;
        this.koh = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.gwr = null;
        this.koh = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.gwr = new BdTypeListView(context);
        this.gwr.setVerticalScrollBarEnabled(false);
        this.gwr.setDividerHeight(0);
        this.gwr.setSelector(17170445);
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
                    HotRankView.this.gwr.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cQI();
            }
        });
        this.gwr.setPullRefresh(this.mPullView);
        this.iQc = BdListViewHelper.a(context, this.gwr, BdListViewHelper.HeadType.HASTAB);
        this.gwr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.koh = new com.baidu.tieba.hottopic.adapter.a((HotRanklistActivity) this.pageContext.getOrignalPage(), this.gwr);
        addView(this.gwr);
    }

    public void h(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.iQc.getLayoutParams();
        layoutParams.height = i2;
        this.iQc.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.koh != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.gwr.setVisibility(0);
            this.koh.a(jVar, str);
        }
    }

    public void sk(boolean z) {
        if (this.gwr != null) {
            if (z) {
                this.gwr.completePullRefresh();
            } else {
                this.gwr.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void C(boolean z, int i) {
        if (!cpB()) {
            if (this.gGD == null) {
                if (i <= 0) {
                    this.gGD = new g(getContext());
                } else {
                    this.gGD = new g(getContext(), i);
                    this.gGD.bCA();
                }
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this, z);
            this.gwr.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void aR(String str, boolean z) {
        if (!cpC()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.Vq();
                            HotRankView.this.C(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cQI();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.gwr.setVisibility(8);
        }
    }

    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean cpC() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        ao.setBackgroundColor(this.gwr, R.color.CAM_X0201);
        this.gwr.getListAdapter().notifyDataSetChanged();
        if (this.gGD != null) {
            this.gGD.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
