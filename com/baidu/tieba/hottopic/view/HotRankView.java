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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
/* loaded from: classes8.dex */
public class HotRankView extends FrameLayout {
    private BdTypeListView fml;
    private g fwo;
    private View hpn;
    private com.baidu.tieba.hottopic.adapter.b iFZ;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fml = null;
        this.iFZ = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fml = null;
        this.iFZ = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.fml = null;
        this.iFZ = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.fml = new BdTypeListView(context);
        this.fml.setVerticalScrollBarEnabled(false);
        this.fml.setDividerHeight(0);
        this.fml.setSelector(17170445);
        com.baidu.adp.base.e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.hottopic.view.HotRankView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!j.isNetWorkAvailable()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                    HotRankView.this.fml.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).clf();
            }
        });
        this.fml.setPullRefresh(this.mPullView);
        this.hpn = BdListViewHelper.a(context, this.fml, BdListViewHelper.HeadType.HASTAB);
        this.fml.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.iFZ = new com.baidu.tieba.hottopic.adapter.b((HotRanklistActivity) this.pageContext.getOrignalPage(), this.fml);
        addView(this.fml);
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.hpn.getLayoutParams();
        layoutParams.height = i2;
        this.hpn.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.iFZ != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.fml.setVisibility(0);
            this.iFZ.a(jVar, str);
        }
    }

    public void oK(boolean z) {
        if (this.fml != null) {
            if (z) {
                this.fml.completePullRefresh();
            } else {
                this.fml.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void A(boolean z, int i) {
        if (!bSR()) {
            if (this.fwo == null) {
                if (i <= 0) {
                    this.fwo = new g(getContext());
                } else {
                    this.fwo = new g(getContext(), i);
                    this.fwo.bgC();
                }
                this.fwo.onChangeSkinType();
            }
            this.fwo.attachView(this, z);
            this.fml.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
        }
    }

    public boolean bSR() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    public void aI(String str, boolean z) {
        if (!bSS()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.btO();
                            HotRankView.this.A(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).clf();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.fml.setVisibility(8);
        }
    }

    public void btO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean bSS() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        an.setBackgroundColor(this.fml, R.color.cp_bg_line_d);
        this.fml.getListAdapter().notifyDataSetChanged();
        if (this.fwo != null) {
            this.fwo.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
