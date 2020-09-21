package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.c;
/* loaded from: classes20.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener cPr;
    private BdTypeListView fGf;
    private PbListView fHm;
    private g fQf;
    private CustomMessageListener fdt;
    private CustomMessageListener fdu;
    f.c iVI;
    private int icL;
    private c.a jge;
    private c jgf;
    private com.baidu.tieba.hottopic.adapter.e jld;
    private com.baidu.tieba.hottopic.controller.d jle;
    private com.baidu.tieba.hottopic.data.e jlf;
    private int jlg;
    private View jlh;
    private int jli;
    private int jlj;
    private a jlk;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.icL = 0;
        this.iVI = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jle.cAY();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cDn();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jle.qg(true);
                HotTopicView.this.fGf.completePullRefreshPostDelayed(0L);
            }
        };
        this.cPr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jle.cDz();
                    s.cfn().bFm();
                }
                if (HotTopicView.this.jge != null) {
                    HotTopicView.this.jge.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jle.onScroll(i2, i3);
                if (HotTopicView.this.jge != null) {
                    HotTopicView.this.jge.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fdu = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jlf != null && HotTopicView.this.jlf.cDL() != null && HotTopicView.this.jlf.cDL().jiG != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fi = HotTopicView.this.fi(((Long) data).longValue());
                        if (fi != null) {
                            fi.followNum++;
                            fi.setIsLiked(true);
                            HotTopicView.this.jlf.cDL().jiI = true;
                            HotTopicView.this.jld.a(HotTopicView.this.jlf);
                        }
                    }
                }
            }
        };
        this.fdt = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jlf != null && HotTopicView.this.jlf.cDL() != null && HotTopicView.this.jlf.cDL().jiG != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fi = HotTopicView.this.fi(((Long) data).longValue());
                        if (fi != null) {
                            fi.followNum--;
                            fi.setIsLiked(false);
                            HotTopicView.this.jlf.cDL().jiI = true;
                            HotTopicView.this.jld.a(HotTopicView.this.jlf);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.icL = 0;
        this.iVI = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jle.cAY();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cDn();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jle.qg(true);
                HotTopicView.this.fGf.completePullRefreshPostDelayed(0L);
            }
        };
        this.cPr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jle.cDz();
                    s.cfn().bFm();
                }
                if (HotTopicView.this.jge != null) {
                    HotTopicView.this.jge.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jle.onScroll(i2, i3);
                if (HotTopicView.this.jge != null) {
                    HotTopicView.this.jge.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fdu = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jlf != null && HotTopicView.this.jlf.cDL() != null && HotTopicView.this.jlf.cDL().jiG != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fi = HotTopicView.this.fi(((Long) data).longValue());
                        if (fi != null) {
                            fi.followNum++;
                            fi.setIsLiked(true);
                            HotTopicView.this.jlf.cDL().jiI = true;
                            HotTopicView.this.jld.a(HotTopicView.this.jlf);
                        }
                    }
                }
            }
        };
        this.fdt = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jlf != null && HotTopicView.this.jlf.cDL() != null && HotTopicView.this.jlf.cDL().jiG != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fi = HotTopicView.this.fi(((Long) data).longValue());
                        if (fi != null) {
                            fi.followNum--;
                            fi.setIsLiked(false);
                            HotTopicView.this.jlf.cDL().jiI = true;
                            HotTopicView.this.jld.a(HotTopicView.this.jlf);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.icL = 0;
        this.iVI = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jle.cAY();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cDn();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jle.qg(true);
                HotTopicView.this.fGf.completePullRefreshPostDelayed(0L);
            }
        };
        this.cPr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jle.cDz();
                    s.cfn().bFm();
                }
                if (HotTopicView.this.jge != null) {
                    HotTopicView.this.jge.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jle.onScroll(i2, i3);
                if (HotTopicView.this.jge != null) {
                    HotTopicView.this.jge.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fdu = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jlf != null && HotTopicView.this.jlf.cDL() != null && HotTopicView.this.jlf.cDL().jiG != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fi = HotTopicView.this.fi(((Long) data).longValue());
                        if (fi != null) {
                            fi.followNum++;
                            fi.setIsLiked(true);
                            HotTopicView.this.jlf.cDL().jiI = true;
                            HotTopicView.this.jld.a(HotTopicView.this.jlf);
                        }
                    }
                }
            }
        };
        this.fdt = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jlf != null && HotTopicView.this.jlf.cDL() != null && HotTopicView.this.jlf.cDL().jiG != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fi = HotTopicView.this.fi(((Long) data).longValue());
                        if (fi != null) {
                            fi.followNum--;
                            fi.setIsLiked(false);
                            HotTopicView.this.jlf.cDL().jiI = true;
                            HotTopicView.this.jld.a(HotTopicView.this.jlf);
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.e<?> I = i.I(context);
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        if (this.pageContext != null) {
            this.fGf = new BdTypeListView(context);
            this.fGf.setVerticalScrollBarEnabled(false);
            this.fGf.setDividerHeight(0);
            this.fGf.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.iVI);
            this.fGf.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.fGf.addFooterView(view);
            this.fGf.setOnScrollListener(this.cPr);
            this.fGf.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.fGf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.fGf && HotTopicView.this.jle != null) {
                        HotTopicView.this.jle.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.jld = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.fGf);
            addView(this.fGf);
            ((FrameLayout.LayoutParams) this.fGf.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.jle = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.fGf);
            this.pageContext.registerListener(this.fdu);
            this.pageContext.registerListener(this.fdt);
            cEi();
            this.fHm = new PbListView(context);
            this.fHm.createView();
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fHm.setLineGone();
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        }
    }

    private void cEi() {
        this.jlh = new View(getContext());
        this.jlh.setId(R.id.view_header);
        this.jlh.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.fGf.addHeaderView(this.jlh, 0);
    }

    public BdTypeListView getListView() {
        return this.fGf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData fi(long j) {
        if (this.jlf != null && this.jlf.cDL() != null && this.jlf.cDL().jiG != null) {
            for (q qVar : this.jlf.cDL().jiG) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.jld != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.jlf = eVar;
            this.jld.setFromCDN(eVar.cjU());
            this.jld.a(eVar);
            this.fGf.setVisibility(0);
            if (!y.isEmpty(eVar.cDN())) {
                ap.setBackgroundColor(this.fGf, R.color.cp_bg_line_c);
            }
        }
    }

    public void qf(boolean z) {
        if (this.fGf != null) {
            this.jle.qg(true);
            if (z) {
                this.fGf.completePullRefresh();
            } else {
                this.fGf.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void gR(boolean z) {
        if (!cdE()) {
            if (this.fQf == null) {
                this.fQf = new g(getContext());
                this.fQf.setTopMargin(getLoadingViewTopMargin());
                this.fQf.bue();
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
        if (!cEm() && this.jgf != null && this.jgf.cEf() != null) {
            this.fGf.smoothScrollBy((int) (-this.jgf.cEf().getY()), 1);
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
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.bHn();
                            HotTopicView.this.gR(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cDn();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.fGf.setVisibility(8);
        }
    }

    public void bHn() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cdF() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fQf != null) {
            this.fQf.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fHm.changeSkin(i);
        }
        if (this.jld != null) {
            this.jld.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fGf, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.jle != null) {
            this.jle.destroy();
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.jlk);
    }

    public void resume() {
        if (this.jle != null) {
            this.jle.qh(false);
        }
    }

    public void pause() {
        if (this.jle != null) {
            this.jle.qh(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.jge = aVar;
    }

    public void AY(int i) {
        ViewGroup.LayoutParams layoutParams = this.jlh.getLayoutParams();
        layoutParams.height = i;
        this.jlh.setLayoutParams(layoutParams);
        cEj();
    }

    public void bIi() {
        if (this.fGf != null && this.fHm != null) {
            this.fGf.setNextPage(this.fHm);
            this.fHm.setTextSize(R.dimen.tbfontsize33);
            this.fHm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fHm.startLoadData();
        }
    }

    public void bIj() {
        if (this.fGf != null && this.fHm != null) {
            if (this.icL > 0) {
                this.fHm.showEmptyView(this.icL);
            }
            this.fGf.setNextPage(this.fHm);
            this.fHm.endLoadData();
            this.fHm.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bIk() {
        if (this.fGf != null && this.fHm != null) {
            this.fGf.setNextPage(null);
            this.fHm.hideEmptyView();
        }
    }

    public void AZ(int i) {
        if (this.fGf != null) {
            this.fGf.smoothScrollBy(i, 1);
            cEj();
        }
    }

    public void setMainView(c cVar) {
        this.jgf = cVar;
    }

    public void at(float f) {
        if (this.fGf != null && this.jlf != null && this.jlf.cDL() != null) {
            this.fGf.setSelection(0);
            this.jlk = new a((int) f);
            com.baidu.adp.lib.f.e.mX().post(this.jlk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements Runnable {
        int jlm;

        public a(int i) {
            this.jlm = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.fGf.smoothScrollBy(Math.abs(this.jlm), 1);
            HotTopicView.this.cEj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEj() {
        if (cdF()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cdE()) {
            this.fQf.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.jgf != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.jlg = Math.abs(absListView.getChildAt(0).getTop());
                if (this.jlg > this.jlj && this.jli <= 1) {
                    cEk();
                } else if (this.jlg < this.jlj) {
                    cEl();
                }
                this.jlj = this.jlg;
            }
            this.jli = i;
        }
    }

    private void cEk() {
        this.jgf.a(this.fGf, Math.min(this.jlg, this.jgf.cEd()));
    }

    private void cEl() {
        if (!cEm()) {
            this.jgf.a(this.fGf, Math.min(this.jlg, this.jgf.cEd()));
        }
    }

    private boolean cEm() {
        return this.jgf.cEf() != null && this.jgf.cEf().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.jgf == null || this.jgf.cEf() == null) {
            return 0;
        }
        return (int) Math.abs(this.jgf.cEg() + this.jgf.cEf().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.jgf == null || this.jgf.cEf() == null) {
            return 0;
        }
        int height = getHeight() - this.jgf.cEg();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.jgf.cEg();
    }
}
