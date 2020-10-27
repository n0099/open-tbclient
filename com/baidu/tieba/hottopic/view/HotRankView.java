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
/* loaded from: classes21.dex */
public class HotRankView extends FrameLayout {
    private BdTypeListView gcr;
    private g gmB;
    private View iqS;
    private com.baidu.tieba.hottopic.adapter.b jLn;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gcr = null;
        this.jLn = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gcr = null;
        this.jLn = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.gcr = null;
        this.jLn = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.gcr = new BdTypeListView(context);
        this.gcr.setVerticalScrollBarEnabled(false);
        this.gcr.setDividerHeight(0);
        this.gcr.setSelector(17170445);
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
                    HotRankView.this.gcr.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cJW();
            }
        });
        this.gcr.setPullRefresh(this.mPullView);
        this.iqS = BdListViewHelper.a(context, this.gcr, BdListViewHelper.HeadType.HASTAB);
        this.gcr.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.jLn = new com.baidu.tieba.hottopic.adapter.b((HotRanklistActivity) this.pageContext.getOrignalPage(), this.gcr);
        addView(this.gcr);
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.iqS.getLayoutParams();
        layoutParams.height = i2;
        this.iqS.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.jLn != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.gcr.setVisibility(0);
            this.jLn.a(jVar, str);
        }
    }

    public void rd(boolean z) {
        if (this.gcr != null) {
            if (z) {
                this.gcr.completePullRefresh();
            } else {
                this.gcr.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void D(boolean z, int i) {
        if (!ckh()) {
            if (this.gmB == null) {
                if (i <= 0) {
                    this.gmB = new g(getContext());
                } else {
                    this.gmB = new g(getContext(), i);
                    this.gmB.byH();
                }
                this.gmB.onChangeSkinType();
            }
            this.gmB.attachView(this, z);
            this.gcr.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gmB != null) {
            this.gmB.dettachView(this);
            this.gmB = null;
        }
    }

    public boolean ckh() {
        if (this.gmB != null) {
            return this.gmB.isViewAttached();
        }
        return false;
    }

    public void aQ(String str, boolean z) {
        if (!cki()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.TK();
                            HotRankView.this.D(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cJW();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.gcr.setVisibility(8);
        }
    }

    public void TK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean cki() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.gcr, R.color.cp_bg_line_d);
        this.gcr.getListAdapter().notifyDataSetChanged();
        if (this.gmB != null) {
            this.gmB.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
