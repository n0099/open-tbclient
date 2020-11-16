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
import com.baidu.tieba.card.t;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.c;
/* loaded from: classes20.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener dol;
    private CustomMessageListener fDy;
    private CustomMessageListener fDz;
    private BdTypeListView ghN;
    private PbListView giV;
    private g grV;
    private int iKS;
    f.c jDY;
    private c.a jOk;
    private c jOl;
    private com.baidu.tieba.hottopic.adapter.e jTh;
    private com.baidu.tieba.hottopic.controller.d jTi;
    private com.baidu.tieba.hottopic.data.e jTj;
    private int jTk;
    private View jTl;
    private int jTm;
    private int jTn;
    private a jTo;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iKS = 0;
        this.jDY = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jTi.cJS();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cMl();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jTi.rq(true);
                HotTopicView.this.ghN.completePullRefreshPostDelayed(0L);
            }
        };
        this.dol = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jTi.cMx();
                    t.cnT().bLI();
                }
                if (HotTopicView.this.jOk != null) {
                    HotTopicView.this.jOk.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jTi.onScroll(i2, i3);
                if (HotTopicView.this.jOk != null) {
                    HotTopicView.this.jOk.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fDz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jTj != null && HotTopicView.this.jTj.cMJ() != null && HotTopicView.this.jTj.cMJ().jQL != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ga = HotTopicView.this.ga(((Long) data).longValue());
                        if (ga != null) {
                            ga.followNum++;
                            ga.setIsLiked(true);
                            HotTopicView.this.jTj.cMJ().jQN = true;
                            HotTopicView.this.jTh.a(HotTopicView.this.jTj);
                        }
                    }
                }
            }
        };
        this.fDy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jTj != null && HotTopicView.this.jTj.cMJ() != null && HotTopicView.this.jTj.cMJ().jQL != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ga = HotTopicView.this.ga(((Long) data).longValue());
                        if (ga != null) {
                            ga.followNum--;
                            ga.setIsLiked(false);
                            HotTopicView.this.jTj.cMJ().jQN = true;
                            HotTopicView.this.jTh.a(HotTopicView.this.jTj);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iKS = 0;
        this.jDY = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jTi.cJS();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cMl();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jTi.rq(true);
                HotTopicView.this.ghN.completePullRefreshPostDelayed(0L);
            }
        };
        this.dol = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jTi.cMx();
                    t.cnT().bLI();
                }
                if (HotTopicView.this.jOk != null) {
                    HotTopicView.this.jOk.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jTi.onScroll(i2, i3);
                if (HotTopicView.this.jOk != null) {
                    HotTopicView.this.jOk.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fDz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jTj != null && HotTopicView.this.jTj.cMJ() != null && HotTopicView.this.jTj.cMJ().jQL != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ga = HotTopicView.this.ga(((Long) data).longValue());
                        if (ga != null) {
                            ga.followNum++;
                            ga.setIsLiked(true);
                            HotTopicView.this.jTj.cMJ().jQN = true;
                            HotTopicView.this.jTh.a(HotTopicView.this.jTj);
                        }
                    }
                }
            }
        };
        this.fDy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jTj != null && HotTopicView.this.jTj.cMJ() != null && HotTopicView.this.jTj.cMJ().jQL != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ga = HotTopicView.this.ga(((Long) data).longValue());
                        if (ga != null) {
                            ga.followNum--;
                            ga.setIsLiked(false);
                            HotTopicView.this.jTj.cMJ().jQN = true;
                            HotTopicView.this.jTh.a(HotTopicView.this.jTj);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.iKS = 0;
        this.jDY = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jTi.cJS();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cMl();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jTi.rq(true);
                HotTopicView.this.ghN.completePullRefreshPostDelayed(0L);
            }
        };
        this.dol = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jTi.cMx();
                    t.cnT().bLI();
                }
                if (HotTopicView.this.jOk != null) {
                    HotTopicView.this.jOk.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jTi.onScroll(i2, i3);
                if (HotTopicView.this.jOk != null) {
                    HotTopicView.this.jOk.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fDz = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jTj != null && HotTopicView.this.jTj.cMJ() != null && HotTopicView.this.jTj.cMJ().jQL != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ga = HotTopicView.this.ga(((Long) data).longValue());
                        if (ga != null) {
                            ga.followNum++;
                            ga.setIsLiked(true);
                            HotTopicView.this.jTj.cMJ().jQN = true;
                            HotTopicView.this.jTh.a(HotTopicView.this.jTj);
                        }
                    }
                }
            }
        };
        this.fDy = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jTj != null && HotTopicView.this.jTj.cMJ() != null && HotTopicView.this.jTj.cMJ().jQL != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ga = HotTopicView.this.ga(((Long) data).longValue());
                        if (ga != null) {
                            ga.followNum--;
                            ga.setIsLiked(false);
                            HotTopicView.this.jTj.cMJ().jQN = true;
                            HotTopicView.this.jTh.a(HotTopicView.this.jTj);
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
            this.ghN = new BdTypeListView(context);
            this.ghN.setVerticalScrollBarEnabled(false);
            this.ghN.setDividerHeight(0);
            this.ghN.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.jDY);
            this.ghN.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.ghN.addFooterView(view);
            this.ghN.setOnScrollListener(this.dol);
            this.ghN.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.ghN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.ghN && HotTopicView.this.jTi != null) {
                        HotTopicView.this.jTi.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.jTh = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.ghN);
            addView(this.ghN);
            ((FrameLayout.LayoutParams) this.ghN.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.jTi = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.ghN);
            this.pageContext.registerListener(this.fDz);
            this.pageContext.registerListener(this.fDy);
            cNf();
            this.giV = new PbListView(context);
            this.giV.createView();
            this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.giV.setLineGone();
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        }
    }

    private void cNf() {
        this.jTl = new View(getContext());
        this.jTl.setId(R.id.view_header);
        this.jTl.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.ghN.addHeaderView(this.jTl, 0);
    }

    public BdTypeListView getListView() {
        return this.ghN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData ga(long j) {
        if (this.jTj != null && this.jTj.cMJ() != null && this.jTj.cMJ().jQL != null) {
            for (q qVar : this.jTj.cMJ().jQL) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.jTh != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.jTj = eVar;
            this.jTh.setFromCDN(eVar.csB());
            this.jTh.a(eVar);
            this.ghN.setVisibility(0);
            if (!y.isEmpty(eVar.cML())) {
                ap.setBackgroundColor(this.ghN, R.color.CAM_X0204);
            }
        }
    }

    public void rp(boolean z) {
        if (this.ghN != null) {
            this.jTi.rq(true);
            if (z) {
                this.ghN.completePullRefresh();
            } else {
                this.ghN.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void hM(boolean z) {
        if (!cml()) {
            if (this.grV == null) {
                this.grV = new g(getContext());
                this.grV.setTopMargin(getLoadingViewTopMargin());
                this.grV.bAw();
                this.grV.onChangeSkinType();
            }
            this.grV.attachView(this, z);
            this.ghN.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.grV != null) {
            this.grV.dettachView(this);
            this.grV = null;
        }
        if (!cNj() && this.jOl != null && this.jOl.cNc() != null) {
            this.ghN.smoothScrollBy((int) (-this.jOl.cNc().getY()), 1);
        }
    }

    public boolean cml() {
        if (this.grV != null) {
            return this.grV.isViewAttached();
        }
        return false;
    }

    public void aQ(String str, boolean z) {
        if (!cmm()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.VB();
                            HotTopicView.this.hM(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cMl();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.ghN.setVisibility(8);
        }
    }

    public void VB() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmm() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grV != null) {
            this.grV.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.giV.changeSkin(i);
        }
        if (this.jTh != null) {
            this.jTh.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.ghN, R.color.CAM_X0204);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
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
        if (this.jTi != null) {
            this.jTi.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jTo);
    }

    public void resume() {
        if (this.jTi != null) {
            this.jTi.rr(false);
        }
    }

    public void pause() {
        if (this.jTi != null) {
            this.jTi.rr(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.jOk = aVar;
    }

    public void CI(int i) {
        ViewGroup.LayoutParams layoutParams = this.jTl.getLayoutParams();
        layoutParams.height = i;
        this.jTl.setLayoutParams(layoutParams);
        cNg();
    }

    public void Vz() {
        if (this.ghN != null && this.giV != null) {
            this.ghN.setNextPage(this.giV);
            this.giV.setTextSize(R.dimen.tbfontsize33);
            this.giV.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.giV.startLoadData();
        }
    }

    public void VA() {
        if (this.ghN != null && this.giV != null) {
            if (this.iKS > 0) {
                this.giV.showEmptyView(this.iKS);
            }
            this.ghN.setNextPage(this.giV);
            this.giV.endLoadData();
            this.giV.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bPp() {
        if (this.ghN != null && this.giV != null) {
            this.ghN.setNextPage(null);
            this.giV.hideEmptyView();
        }
    }

    public void CJ(int i) {
        if (this.ghN != null) {
            this.ghN.smoothScrollBy(i, 1);
            cNg();
        }
    }

    public void setMainView(c cVar) {
        this.jOl = cVar;
    }

    public void aK(float f) {
        if (this.ghN != null && this.jTj != null && this.jTj.cMJ() != null) {
            this.ghN.setSelection(0);
            this.jTo = new a((int) f);
            com.baidu.adp.lib.f.e.mY().post(this.jTo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements Runnable {
        int jTq;

        public a(int i) {
            this.jTq = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.ghN.smoothScrollBy(Math.abs(this.jTq), 1);
            HotTopicView.this.cNg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNg() {
        if (cmm()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cml()) {
            this.grV.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.jOl != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.jTk = Math.abs(absListView.getChildAt(0).getTop());
                if (this.jTk > this.jTn && this.jTm <= 1) {
                    cNh();
                } else if (this.jTk < this.jTn) {
                    cNi();
                }
                this.jTn = this.jTk;
            }
            this.jTm = i;
        }
    }

    private void cNh() {
        this.jOl.a(this.ghN, Math.min(this.jTk, this.jOl.cNa()));
    }

    private void cNi() {
        if (!cNj()) {
            this.jOl.a(this.ghN, Math.min(this.jTk, this.jOl.cNa()));
        }
    }

    private boolean cNj() {
        return this.jOl.cNc() != null && this.jOl.cNc().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.jOl == null || this.jOl.cNc() == null) {
            return 0;
        }
        return (int) Math.abs(this.jOl.cNd() + this.jOl.cNc().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.jOl == null || this.jOl.cNc() == null) {
            return 0;
        }
        int height = getHeight() - this.jOl.cNd();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.jOl.cNd();
    }
}
