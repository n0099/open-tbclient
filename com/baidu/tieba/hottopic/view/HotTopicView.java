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
/* loaded from: classes8.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener dyP;
    private CustomMessageListener fSw;
    private CustomMessageListener fSx;
    private PbListView gAi;
    private g gJn;
    private BdTypeListView gzb;
    private int jiZ;
    f.c kis;
    private c.a ksD;
    private c ksE;
    private com.baidu.tieba.hottopic.adapter.d kxB;
    private com.baidu.tieba.hottopic.controller.d kxC;
    private com.baidu.tieba.hottopic.data.e kxD;
    private int kxE;
    private View kxF;
    private int kxG;
    private int kxH;
    private a kxI;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jiZ = 0;
        this.kis = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kxC.cQu();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cSO();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kxC.sy(true);
                HotTopicView.this.gzb.completePullRefreshPostDelayed(0L);
            }
        };
        this.dyP = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kxC.cTa();
                    t.csu().bOF();
                }
                if (HotTopicView.this.ksD != null) {
                    HotTopicView.this.ksD.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kxC.onScroll(i2, i3);
                if (HotTopicView.this.ksD != null) {
                    HotTopicView.this.ksD.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxD != null && HotTopicView.this.kxD.cTm() != null && HotTopicView.this.kxD.cTm().kvf != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kxD.cTm().kvh = true;
                            HotTopicView.this.kxB.a(HotTopicView.this.kxD);
                        }
                    }
                }
            }
        };
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxD != null && HotTopicView.this.kxD.cTm() != null && HotTopicView.this.kxD.cTm().kvf != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kxD.cTm().kvh = true;
                            HotTopicView.this.kxB.a(HotTopicView.this.kxD);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jiZ = 0;
        this.kis = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kxC.cQu();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cSO();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kxC.sy(true);
                HotTopicView.this.gzb.completePullRefreshPostDelayed(0L);
            }
        };
        this.dyP = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kxC.cTa();
                    t.csu().bOF();
                }
                if (HotTopicView.this.ksD != null) {
                    HotTopicView.this.ksD.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kxC.onScroll(i2, i3);
                if (HotTopicView.this.ksD != null) {
                    HotTopicView.this.ksD.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxD != null && HotTopicView.this.kxD.cTm() != null && HotTopicView.this.kxD.cTm().kvf != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kxD.cTm().kvh = true;
                            HotTopicView.this.kxB.a(HotTopicView.this.kxD);
                        }
                    }
                }
            }
        };
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxD != null && HotTopicView.this.kxD.cTm() != null && HotTopicView.this.kxD.cTm().kvf != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kxD.cTm().kvh = true;
                            HotTopicView.this.kxB.a(HotTopicView.this.kxD);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.jiZ = 0;
        this.kis = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kxC.cQu();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cSO();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kxC.sy(true);
                HotTopicView.this.gzb.completePullRefreshPostDelayed(0L);
            }
        };
        this.dyP = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kxC.cTa();
                    t.csu().bOF();
                }
                if (HotTopicView.this.ksD != null) {
                    HotTopicView.this.ksD.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kxC.onScroll(i2, i3);
                if (HotTopicView.this.ksD != null) {
                    HotTopicView.this.ksD.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxD != null && HotTopicView.this.kxD.cTm() != null && HotTopicView.this.kxD.cTm().kvf != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kxD.cTm().kvh = true;
                            HotTopicView.this.kxB.a(HotTopicView.this.kxD);
                        }
                    }
                }
            }
        };
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxD != null && HotTopicView.this.kxD.cTm() != null && HotTopicView.this.kxD.cTm().kvf != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kxD.cTm().kvh = true;
                            HotTopicView.this.kxB.a(HotTopicView.this.kxD);
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.f<?> K = com.baidu.adp.base.j.K(context);
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        if (this.pageContext != null) {
            this.gzb = new BdTypeListView(context);
            this.gzb.setVerticalScrollBarEnabled(false);
            this.gzb.setDividerHeight(0);
            this.gzb.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.kis);
            this.gzb.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gzb.addFooterView(view);
            this.gzb.setOnScrollListener(this.dyP);
            this.gzb.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gzb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gzb && HotTopicView.this.kxC != null) {
                        HotTopicView.this.kxC.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.kxB = new com.baidu.tieba.hottopic.adapter.d(this.pageContext.getOrignalPage(), this.gzb);
            addView(this.gzb);
            ((FrameLayout.LayoutParams) this.gzb.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.kxC = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gzb);
            this.pageContext.registerListener(this.fSx);
            this.pageContext.registerListener(this.fSw);
            cTI();
            this.gAi = new PbListView(context);
            this.gAi.createView();
            this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gAi.setLineGone();
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        }
    }

    private void cTI() {
        this.kxF = new View(getContext());
        this.kxF.setId(R.id.view_header);
        this.kxF.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gzb.addHeaderView(this.kxF, 0);
    }

    public BdTypeListView getListView() {
        return this.gzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gK(long j) {
        if (this.kxD != null && this.kxD.cTm() != null && this.kxD.cTm().kvf != null) {
            for (n nVar : this.kxD.cTm().kvf) {
                if (nVar != null && (nVar instanceof RelateForumItemData) && ((RelateForumItemData) nVar).forumId == j) {
                    return (RelateForumItemData) nVar;
                }
            }
        }
        return null;
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.kxB != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.kxD = eVar;
            this.kxB.setFromCDN(eVar.cxf());
            this.kxB.a(eVar);
            this.gzb.setVisibility(0);
            if (!y.isEmpty(eVar.cTo())) {
                ap.setBackgroundColor(this.gzb, R.color.CAM_X0204);
            }
        }
    }

    public void sx(boolean z) {
        if (this.gzb != null) {
            this.kxC.sy(true);
            if (z) {
                this.gzb.completePullRefresh();
            } else {
                this.gzb.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ir(boolean z) {
        if (!cqL()) {
            if (this.gJn == null) {
                this.gJn = new g(getContext());
                this.gJn.setTopMargin(getLoadingViewTopMargin());
                this.gJn.bCS();
                this.gJn.onChangeSkinType();
            }
            this.gJn.attachView(this, z);
            this.gzb.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gJn != null) {
            this.gJn.dettachView(this);
            this.gJn = null;
        }
        if (!cTM() && this.ksE != null && this.ksE.cTF() != null) {
            this.gzb.smoothScrollBy((int) (-this.ksE.cTF().getY()), 1);
        }
    }

    public boolean cqL() {
        if (this.gJn != null) {
            return this.gJn.isViewAttached();
        }
        return false;
    }

    public void aQ(String str, boolean z) {
        if (!cqM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.WZ();
                            HotTopicView.this.ir(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cSO();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gzb.setVisibility(8);
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqM() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gJn != null) {
            this.gJn.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAi.changeSkin(i);
        }
        if (this.kxB != null) {
            this.kxB.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gzb, R.color.CAM_X0204);
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
        if (this.kxC != null) {
            this.kxC.destroy();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kxI);
    }

    public void resume() {
        if (this.kxC != null) {
            this.kxC.sz(false);
        }
    }

    public void pause() {
        if (this.kxC != null) {
            this.kxC.sz(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.ksD = aVar;
    }

    public void Cw(int i) {
        ViewGroup.LayoutParams layoutParams = this.kxF.getLayoutParams();
        layoutParams.height = i;
        this.kxF.setLayoutParams(layoutParams);
        cTJ();
    }

    public void WX() {
        if (this.gzb != null && this.gAi != null) {
            this.gzb.setNextPage(this.gAi);
            this.gAi.setTextSize(R.dimen.tbfontsize33);
            this.gAi.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gAi.startLoadData();
        }
    }

    public void WY() {
        if (this.gzb != null && this.gAi != null) {
            if (this.jiZ > 0) {
                this.gAi.showEmptyView(this.jiZ);
            }
            this.gzb.setNextPage(this.gAi);
            this.gAi.endLoadData();
            this.gAi.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bSr() {
        if (this.gzb != null && this.gAi != null) {
            this.gzb.setNextPage(null);
            this.gAi.hideEmptyView();
        }
    }

    public void Cx(int i) {
        if (this.gzb != null) {
            this.gzb.smoothScrollBy(i, 1);
            cTJ();
        }
    }

    public void setMainView(c cVar) {
        this.ksE = cVar;
    }

    public void aQ(float f) {
        if (this.gzb != null && this.kxD != null && this.kxD.cTm() != null) {
            this.gzb.setSelection(0);
            this.kxI = new a((int) f);
            com.baidu.adp.lib.f.e.mA().post(this.kxI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        int kxK;

        public a(int i) {
            this.kxK = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gzb.smoothScrollBy(Math.abs(this.kxK), 1);
            HotTopicView.this.cTJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTJ() {
        if (cqM()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cqL()) {
            this.gJn.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.ksE != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.kxE = Math.abs(absListView.getChildAt(0).getTop());
                if (this.kxE > this.kxH && this.kxG <= 1) {
                    cTK();
                } else if (this.kxE < this.kxH) {
                    cTL();
                }
                this.kxH = this.kxE;
            }
            this.kxG = i;
        }
    }

    private void cTK() {
        this.ksE.a(this.gzb, Math.min(this.kxE, this.ksE.cTD()));
    }

    private void cTL() {
        if (!cTM()) {
            this.ksE.a(this.gzb, Math.min(this.kxE, this.ksE.cTD()));
        }
    }

    private boolean cTM() {
        return this.ksE.cTF() != null && this.ksE.cTF().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.ksE == null || this.ksE.cTF() == null) {
            return 0;
        }
        return (int) Math.abs(this.ksE.cTG() + this.ksE.cTF().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.ksE == null || this.ksE.cTF() == null) {
            return 0;
        }
        int height = getHeight() - this.ksE.cTG();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.ksE.cTG();
    }
}
