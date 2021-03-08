package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.c;
/* loaded from: classes7.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener dAq;
    private CustomMessageListener fTW;
    private CustomMessageListener fTX;
    private BdTypeListView gAY;
    private PbListView gCf;
    private g gLk;
    private int jkW;
    f.c kkI;
    private c.a kuT;
    private c kuU;
    private com.baidu.tieba.hottopic.adapter.d kzR;
    private com.baidu.tieba.hottopic.controller.d kzS;
    private com.baidu.tieba.hottopic.data.e kzT;
    private int kzU;
    private View kzV;
    private int kzW;
    private int kzX;
    private a kzY;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jkW = 0;
        this.kkI = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kzS.cQI();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cTc();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kzS.sy(true);
                HotTopicView.this.gAY.completePullRefreshPostDelayed(0L);
            }
        };
        this.dAq = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kzS.cTo();
                    t.csH().bOS();
                }
                if (HotTopicView.this.kuT != null) {
                    HotTopicView.this.kuT.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kzS.onScroll(i2, i3);
                if (HotTopicView.this.kuT != null) {
                    HotTopicView.this.kuT.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fTX = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kzT != null && HotTopicView.this.kzT.cTA() != null && HotTopicView.this.kzT.cTA().kxv != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kzT.cTA().kxx = true;
                            HotTopicView.this.kzR.a(HotTopicView.this.kzT);
                        }
                    }
                }
            }
        };
        this.fTW = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kzT != null && HotTopicView.this.kzT.cTA() != null && HotTopicView.this.kzT.cTA().kxv != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kzT.cTA().kxx = true;
                            HotTopicView.this.kzR.a(HotTopicView.this.kzT);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jkW = 0;
        this.kkI = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kzS.cQI();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cTc();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kzS.sy(true);
                HotTopicView.this.gAY.completePullRefreshPostDelayed(0L);
            }
        };
        this.dAq = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kzS.cTo();
                    t.csH().bOS();
                }
                if (HotTopicView.this.kuT != null) {
                    HotTopicView.this.kuT.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kzS.onScroll(i2, i3);
                if (HotTopicView.this.kuT != null) {
                    HotTopicView.this.kuT.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fTX = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kzT != null && HotTopicView.this.kzT.cTA() != null && HotTopicView.this.kzT.cTA().kxv != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kzT.cTA().kxx = true;
                            HotTopicView.this.kzR.a(HotTopicView.this.kzT);
                        }
                    }
                }
            }
        };
        this.fTW = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kzT != null && HotTopicView.this.kzT.cTA() != null && HotTopicView.this.kzT.cTA().kxv != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kzT.cTA().kxx = true;
                            HotTopicView.this.kzR.a(HotTopicView.this.kzT);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.jkW = 0;
        this.kkI = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kzS.cQI();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cTc();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kzS.sy(true);
                HotTopicView.this.gAY.completePullRefreshPostDelayed(0L);
            }
        };
        this.dAq = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kzS.cTo();
                    t.csH().bOS();
                }
                if (HotTopicView.this.kuT != null) {
                    HotTopicView.this.kuT.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kzS.onScroll(i2, i3);
                if (HotTopicView.this.kuT != null) {
                    HotTopicView.this.kuT.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fTX = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kzT != null && HotTopicView.this.kzT.cTA() != null && HotTopicView.this.kzT.cTA().kxv != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kzT.cTA().kxx = true;
                            HotTopicView.this.kzR.a(HotTopicView.this.kzT);
                        }
                    }
                }
            }
        };
        this.fTW = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kzT != null && HotTopicView.this.kzT.cTA() != null && HotTopicView.this.kzT.cTA().kxv != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kzT.cTA().kxx = true;
                            HotTopicView.this.kzR.a(HotTopicView.this.kzT);
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.f<?> J = com.baidu.adp.base.j.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        if (this.pageContext != null) {
            this.gAY = new BdTypeListView(context);
            this.gAY.setVerticalScrollBarEnabled(false);
            this.gAY.setDividerHeight(0);
            this.gAY.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.kkI);
            this.gAY.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gAY.addFooterView(view);
            this.gAY.setOnScrollListener(this.dAq);
            this.gAY.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gAY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gAY && HotTopicView.this.kzS != null) {
                        HotTopicView.this.kzS.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.kzR = new com.baidu.tieba.hottopic.adapter.d(this.pageContext.getOrignalPage(), this.gAY);
            addView(this.gAY);
            ((FrameLayout.LayoutParams) this.gAY.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.kzS = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gAY);
            this.pageContext.registerListener(this.fTX);
            this.pageContext.registerListener(this.fTW);
            cTW();
            this.gCf = new PbListView(context);
            this.gCf.createView();
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gCf.setLineGone();
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        }
    }

    private void cTW() {
        this.kzV = new View(getContext());
        this.kzV.setId(R.id.view_header);
        this.kzV.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gAY.addHeaderView(this.kzV, 0);
    }

    public BdTypeListView getListView() {
        return this.gAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gK(long j) {
        if (this.kzT != null && this.kzT.cTA() != null && this.kzT.cTA().kxv != null) {
            for (n nVar : this.kzT.cTA().kxv) {
                if (nVar != null && (nVar instanceof RelateForumItemData) && ((RelateForumItemData) nVar).forumId == j) {
                    return (RelateForumItemData) nVar;
                }
            }
        }
        return null;
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.kzR != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.kzT = eVar;
            this.kzR.setFromCDN(eVar.cxs());
            this.kzR.a(eVar);
            this.gAY.setVisibility(0);
            if (!y.isEmpty(eVar.cTC())) {
                ap.setBackgroundColor(this.gAY, R.color.CAM_X0204);
            }
        }
    }

    public void sx(boolean z) {
        if (this.gAY != null) {
            this.kzS.sy(true);
            if (z) {
                this.gAY.completePullRefresh();
            } else {
                this.gAY.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(getContext());
                this.gLk.setTopMargin(getLoadingViewTopMargin());
                this.gLk.bCV();
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
        if (!cUa() && this.kuU != null && this.kuU.cTT() != null) {
            this.gAY.smoothScrollBy((int) (-this.kuU.cTT().getY()), 1);
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
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.Xc();
                            HotTopicView.this.ir(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cTc();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gAY.setVisibility(8);
        }
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqZ() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gLk != null) {
            this.gLk.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.kzR != null) {
            this.kzR.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gAY, R.color.CAM_X0204);
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
        if (this.kzS != null) {
            this.kzS.destroy();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kzY);
    }

    public void resume() {
        if (this.kzS != null) {
            this.kzS.sz(false);
        }
    }

    public void pause() {
        if (this.kzS != null) {
            this.kzS.sz(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.kuT = aVar;
    }

    public void Cz(int i) {
        ViewGroup.LayoutParams layoutParams = this.kzV.getLayoutParams();
        layoutParams.height = i;
        this.kzV.setLayoutParams(layoutParams);
        cTX();
    }

    public void Xa() {
        if (this.gAY != null && this.gCf != null) {
            this.gAY.setNextPage(this.gCf);
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gCf.startLoadData();
        }
    }

    public void Xb() {
        if (this.gAY != null && this.gCf != null) {
            if (this.jkW > 0) {
                this.gCf.showEmptyView(this.jkW);
            }
            this.gAY.setNextPage(this.gCf);
            this.gCf.endLoadData();
            this.gCf.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bSE() {
        if (this.gAY != null && this.gCf != null) {
            this.gAY.setNextPage(null);
            this.gCf.hideEmptyView();
        }
    }

    public void CA(int i) {
        if (this.gAY != null) {
            this.gAY.smoothScrollBy(i, 1);
            cTX();
        }
    }

    public void setMainView(c cVar) {
        this.kuU = cVar;
    }

    public void aU(float f) {
        if (this.gAY != null && this.kzT != null && this.kzT.cTA() != null) {
            this.gAY.setSelection(0);
            this.kzY = new a((int) f);
            com.baidu.adp.lib.f.e.mA().post(this.kzY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        int kAa;

        public a(int i) {
            this.kAa = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gAY.smoothScrollBy(Math.abs(this.kAa), 1);
            HotTopicView.this.cTX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTX() {
        if (cqZ()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cqY()) {
            this.gLk.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.kuU != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.kzU = Math.abs(absListView.getChildAt(0).getTop());
                if (this.kzU > this.kzX && this.kzW <= 1) {
                    cTY();
                } else if (this.kzU < this.kzX) {
                    cTZ();
                }
                this.kzX = this.kzU;
            }
            this.kzW = i;
        }
    }

    private void cTY() {
        this.kuU.a(this.gAY, Math.min(this.kzU, this.kuU.cTR()));
    }

    private void cTZ() {
        if (!cUa()) {
            this.kuU.a(this.gAY, Math.min(this.kzU, this.kuU.cTR()));
        }
    }

    private boolean cUa() {
        return this.kuU.cTT() != null && this.kuU.cTT().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.kuU == null || this.kuU.cTT() == null) {
            return 0;
        }
        return (int) Math.abs(this.kuU.cTU() + this.kuU.cTT().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.kuU == null || this.kuU.cTT() == null) {
            return 0;
        }
        int height = getHeight() - this.kuU.cTU();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.kuU.cTU();
    }
}
