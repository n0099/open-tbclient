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
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
/* loaded from: classes20.dex */
public class HotRankView extends FrameLayout {
    private BdTypeListView fGf;
    private g fQf;
    private View hPv;
    private com.baidu.tieba.hottopic.adapter.b jjQ;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGf = null;
        this.jjQ = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGf = null;
        this.jjQ = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.fGf = null;
        this.jjQ = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.fGf = new BdTypeListView(context);
        this.fGf.setVerticalScrollBarEnabled(false);
        this.fGf.setDividerHeight(0);
        this.fGf.setSelector(17170445);
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.hottopic.view.HotRankView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    HotRankView.this.fGf.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cDg();
            }
        });
        this.fGf.setPullRefresh(this.mPullView);
        this.hPv = BdListViewHelper.a(context, this.fGf, BdListViewHelper.HeadType.HASTAB);
        this.fGf.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.jjQ = new com.baidu.tieba.hottopic.adapter.b((HotRanklistActivity) this.pageContext.getOrignalPage(), this.fGf);
        addView(this.fGf);
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.hPv.getLayoutParams();
        layoutParams.height = i2;
        this.hPv.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.jjQ != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.fGf.setVisibility(0);
            this.jjQ.a(jVar, str);
        }
    }

    public void qf(boolean z) {
        if (this.fGf != null) {
            if (z) {
                this.fGf.completePullRefresh();
            } else {
                this.fGf.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void A(boolean z, int i) {
        if (!cdE()) {
            if (this.fQf == null) {
                if (i <= 0) {
                    this.fQf = new g(getContext());
                } else {
                    this.fQf = new g(getContext(), i);
                    this.fQf.bue();
                }
                this.fQf.onChangeSkinType();
            }
            this.fQf.attachView(this, z);
            this.fGf.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.fQf != null) {
            this.fQf.dettachView(this);
            this.fQf = null;
        }
    }

    public boolean cdE() {
        if (this.fQf != null) {
            return this.fQf.isViewAttached();
        }
        return false;
    }

    public void aK(String str, boolean z) {
        if (!cdF()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.bHn();
                            HotRankView.this.A(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cDg();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.fGf.setVisibility(8);
        }
    }

    public void bHn() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean cdF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fGf, R.color.cp_bg_line_d);
        this.fGf.getListAdapter().notifyDataSetChanged();
        if (this.fQf != null) {
            this.fQf.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
