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
/* loaded from: classes15.dex */
public class HotRankView extends FrameLayout {
    private BdTypeListView fCP;
    private g fMN;
    private View hIo;
    private com.baidu.tieba.hottopic.adapter.b jbe;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fCP = null;
        this.jbe = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCP = null;
        this.jbe = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.fCP = null;
        this.jbe = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.fCP = new BdTypeListView(context);
        this.fCP.setVerticalScrollBarEnabled(false);
        this.fCP.setDividerHeight(0);
        this.fCP.setSelector(17170445);
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
                    HotRankView.this.fCP.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).czy();
            }
        });
        this.fCP.setPullRefresh(this.mPullView);
        this.hIo = BdListViewHelper.a(context, this.fCP, BdListViewHelper.HeadType.HASTAB);
        this.fCP.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.jbe = new com.baidu.tieba.hottopic.adapter.b((HotRanklistActivity) this.pageContext.getOrignalPage(), this.fCP);
        addView(this.fCP);
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.hIo.getLayoutParams();
        layoutParams.height = i2;
        this.hIo.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.jbe != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.fCP.setVisibility(0);
            this.jbe.a(jVar, str);
        }
    }

    public void pV(boolean z) {
        if (this.fCP != null) {
            if (z) {
                this.fCP.completePullRefresh();
            } else {
                this.fCP.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void A(boolean z, int i) {
        if (!cgv()) {
            if (this.fMN == null) {
                if (i <= 0) {
                    this.fMN = new g(getContext());
                } else {
                    this.fMN = new g(getContext(), i);
                    this.fMN.bsZ();
                }
                this.fMN.onChangeSkinType();
            }
            this.fMN.attachView(this, z);
            this.fCP.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.fMN != null) {
            this.fMN.dettachView(this);
            this.fMN = null;
        }
    }

    public boolean cgv() {
        if (this.fMN != null) {
            return this.fMN.isViewAttached();
        }
        return false;
    }

    public void aK(String str, boolean z) {
        if (!cgw()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.bFW();
                            HotRankView.this.A(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).czy();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.fCP.setVisibility(8);
        }
    }

    public void bFW() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean cgw() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fCP, R.color.cp_bg_line_d);
        this.fCP.getListAdapter().notifyDataSetChanged();
        if (this.fMN != null) {
            this.fMN.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
