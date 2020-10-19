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
    private BdTypeListView fSo;
    private g gcx;
    private View ieu;
    private com.baidu.tieba.hottopic.adapter.b jyO;
    private com.baidu.tbadk.core.view.g mPullView;
    private TbPageContext<?> pageContext;
    private h refreshView;

    public HotRankView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSo = null;
        this.jyO = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSo = null;
        this.jyO = null;
        this.mPullView = null;
        init(context);
    }

    public HotRankView(Context context) {
        super(context);
        this.fSo = null;
        this.jyO = null;
        this.mPullView = null;
        init(context);
    }

    private void init(Context context) {
        this.fSo = new BdTypeListView(context);
        this.fSo.setVerticalScrollBarEnabled(false);
        this.fSo.setDividerHeight(0);
        this.fSo.setSelector(17170445);
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
                    HotRankView.this.fSo.completePullRefreshPostDelayed(0L);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cGP();
            }
        });
        this.fSo.setPullRefresh(this.mPullView);
        this.ieu = BdListViewHelper.a(context, this.fSo, BdListViewHelper.HeadType.HASTAB);
        this.fSo.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.2
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
        this.jyO = new com.baidu.tieba.hottopic.adapter.b((HotRanklistActivity) this.pageContext.getOrignalPage(), this.fSo);
        addView(this.fSo);
    }

    public void f(View view, int i, int i2, int i3, int i4) {
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.ieu.getLayoutParams();
        layoutParams.height = i2;
        this.ieu.setLayoutParams(layoutParams);
    }

    public void b(com.baidu.tieba.hottopic.data.j jVar, String str) {
        if (this.jyO != null) {
            if (jVar == null) {
                jVar = new com.baidu.tieba.hottopic.data.j();
            }
            this.fSo.setVisibility(0);
            this.jyO.a(jVar, str);
        }
    }

    public void qL(boolean z) {
        if (this.fSo != null) {
            if (z) {
                this.fSo.completePullRefresh();
            } else {
                this.fSo.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void D(boolean z, int i) {
        if (!cha()) {
            if (this.gcx == null) {
                if (i <= 0) {
                    this.gcx = new g(getContext());
                } else {
                    this.gcx = new g(getContext(), i);
                    this.gcx.bwO();
                }
                this.gcx.onChangeSkinType();
            }
            this.gcx.attachView(this, z);
            this.fSo.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
        }
    }

    public boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    public void aO(String str, boolean z) {
        if (!chb()) {
            if (this.refreshView == null) {
                this.refreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotRankView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotRankView.this.SK();
                            HotRankView.this.D(true, l.getDimens(HotRankView.this.pageContext.getPageActivity(), R.dimen.ds500));
                            ((HotRanklistActivity) HotRankView.this.pageContext.getOrignalPage()).cGP();
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(getContext().getResources().getDimensionPixelSize(R.dimen.ds280));
            this.refreshView.attachView(this, z);
            this.refreshView.showRefreshButton();
            this.fSo.setVisibility(8);
        }
    }

    public void SK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this);
            this.refreshView = null;
        }
    }

    public boolean chb() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.fSo, R.color.cp_bg_line_d);
        this.fSo.getListAdapter().notifyDataSetChanged();
        if (this.gcx != null) {
            this.gcx.onChangeSkinType();
        }
        if (this.refreshView != null) {
            this.refreshView.onChangeSkinType();
        }
    }
}
