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
    private PbListView gAw;
    private g gJB;
    private BdTypeListView gzp;
    private int jjn;
    f.c kiG;
    private c.a ksR;
    private c ksS;
    private com.baidu.tieba.hottopic.adapter.d kxP;
    private com.baidu.tieba.hottopic.controller.d kxQ;
    private com.baidu.tieba.hottopic.data.e kxR;
    private int kxS;
    private View kxT;
    private int kxU;
    private int kxV;
    private a kxW;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjn = 0;
        this.kiG = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kxQ.cQB();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cSV();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kxQ.sy(true);
                HotTopicView.this.gzp.completePullRefreshPostDelayed(0L);
            }
        };
        this.dyP = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kxQ.cTh();
                    t.csB().bOM();
                }
                if (HotTopicView.this.ksR != null) {
                    HotTopicView.this.ksR.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kxQ.onScroll(i2, i3);
                if (HotTopicView.this.ksR != null) {
                    HotTopicView.this.ksR.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxR != null && HotTopicView.this.kxR.cTt() != null && HotTopicView.this.kxR.cTt().kvt != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kxR.cTt().kvv = true;
                            HotTopicView.this.kxP.a(HotTopicView.this.kxR);
                        }
                    }
                }
            }
        };
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxR != null && HotTopicView.this.kxR.cTt() != null && HotTopicView.this.kxR.cTt().kvt != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kxR.cTt().kvv = true;
                            HotTopicView.this.kxP.a(HotTopicView.this.kxR);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjn = 0;
        this.kiG = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kxQ.cQB();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cSV();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kxQ.sy(true);
                HotTopicView.this.gzp.completePullRefreshPostDelayed(0L);
            }
        };
        this.dyP = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kxQ.cTh();
                    t.csB().bOM();
                }
                if (HotTopicView.this.ksR != null) {
                    HotTopicView.this.ksR.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kxQ.onScroll(i2, i3);
                if (HotTopicView.this.ksR != null) {
                    HotTopicView.this.ksR.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxR != null && HotTopicView.this.kxR.cTt() != null && HotTopicView.this.kxR.cTt().kvt != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kxR.cTt().kvv = true;
                            HotTopicView.this.kxP.a(HotTopicView.this.kxR);
                        }
                    }
                }
            }
        };
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxR != null && HotTopicView.this.kxR.cTt() != null && HotTopicView.this.kxR.cTt().kvt != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kxR.cTt().kvv = true;
                            HotTopicView.this.kxP.a(HotTopicView.this.kxR);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.jjn = 0;
        this.kiG = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kxQ.cQB();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cSV();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kxQ.sy(true);
                HotTopicView.this.gzp.completePullRefreshPostDelayed(0L);
            }
        };
        this.dyP = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kxQ.cTh();
                    t.csB().bOM();
                }
                if (HotTopicView.this.ksR != null) {
                    HotTopicView.this.ksR.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kxQ.onScroll(i2, i3);
                if (HotTopicView.this.ksR != null) {
                    HotTopicView.this.ksR.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fSx = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxR != null && HotTopicView.this.kxR.cTt() != null && HotTopicView.this.kxR.cTt().kvt != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum++;
                            gK.setIsLiked(true);
                            HotTopicView.this.kxR.cTt().kvv = true;
                            HotTopicView.this.kxP.a(HotTopicView.this.kxR);
                        }
                    }
                }
            }
        };
        this.fSw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kxR != null && HotTopicView.this.kxR.cTt() != null && HotTopicView.this.kxR.cTt().kvt != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gK = HotTopicView.this.gK(((Long) data).longValue());
                        if (gK != null) {
                            gK.followNum--;
                            gK.setIsLiked(false);
                            HotTopicView.this.kxR.cTt().kvv = true;
                            HotTopicView.this.kxP.a(HotTopicView.this.kxR);
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
            this.gzp = new BdTypeListView(context);
            this.gzp.setVerticalScrollBarEnabled(false);
            this.gzp.setDividerHeight(0);
            this.gzp.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.kiG);
            this.gzp.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gzp.addFooterView(view);
            this.gzp.setOnScrollListener(this.dyP);
            this.gzp.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gzp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gzp && HotTopicView.this.kxQ != null) {
                        HotTopicView.this.kxQ.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.kxP = new com.baidu.tieba.hottopic.adapter.d(this.pageContext.getOrignalPage(), this.gzp);
            addView(this.gzp);
            ((FrameLayout.LayoutParams) this.gzp.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.kxQ = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gzp);
            this.pageContext.registerListener(this.fSx);
            this.pageContext.registerListener(this.fSw);
            cTP();
            this.gAw = new PbListView(context);
            this.gAw.createView();
            this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gAw.setLineGone();
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        }
    }

    private void cTP() {
        this.kxT = new View(getContext());
        this.kxT.setId(R.id.view_header);
        this.kxT.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gzp.addHeaderView(this.kxT, 0);
    }

    public BdTypeListView getListView() {
        return this.gzp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gK(long j) {
        if (this.kxR != null && this.kxR.cTt() != null && this.kxR.cTt().kvt != null) {
            for (n nVar : this.kxR.cTt().kvt) {
                if (nVar != null && (nVar instanceof RelateForumItemData) && ((RelateForumItemData) nVar).forumId == j) {
                    return (RelateForumItemData) nVar;
                }
            }
        }
        return null;
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.kxP != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.kxR = eVar;
            this.kxP.setFromCDN(eVar.cxm());
            this.kxP.a(eVar);
            this.gzp.setVisibility(0);
            if (!y.isEmpty(eVar.cTv())) {
                ap.setBackgroundColor(this.gzp, R.color.CAM_X0204);
            }
        }
    }

    public void sx(boolean z) {
        if (this.gzp != null) {
            this.kxQ.sy(true);
            if (z) {
                this.gzp.completePullRefresh();
            } else {
                this.gzp.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(getContext());
                this.gJB.setTopMargin(getLoadingViewTopMargin());
                this.gJB.bCS();
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this, z);
            this.gzp.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
        if (!cTT() && this.ksS != null && this.ksS.cTM() != null) {
            this.gzp.smoothScrollBy((int) (-this.ksS.cTM().getY()), 1);
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void aQ(String str, boolean z) {
        if (!cqT()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.WZ();
                            HotTopicView.this.ir(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cSV();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gzp.setVisibility(8);
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqT() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gJB != null) {
            this.gJB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gAw.changeSkin(i);
        }
        if (this.kxP != null) {
            this.kxP.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gzp, R.color.CAM_X0204);
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
        if (this.kxQ != null) {
            this.kxQ.destroy();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kxW);
    }

    public void resume() {
        if (this.kxQ != null) {
            this.kxQ.sz(false);
        }
    }

    public void pause() {
        if (this.kxQ != null) {
            this.kxQ.sz(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.ksR = aVar;
    }

    public void Cw(int i) {
        ViewGroup.LayoutParams layoutParams = this.kxT.getLayoutParams();
        layoutParams.height = i;
        this.kxT.setLayoutParams(layoutParams);
        cTQ();
    }

    public void WX() {
        if (this.gzp != null && this.gAw != null) {
            this.gzp.setNextPage(this.gAw);
            this.gAw.setTextSize(R.dimen.tbfontsize33);
            this.gAw.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gAw.startLoadData();
        }
    }

    public void WY() {
        if (this.gzp != null && this.gAw != null) {
            if (this.jjn > 0) {
                this.gAw.showEmptyView(this.jjn);
            }
            this.gzp.setNextPage(this.gAw);
            this.gAw.endLoadData();
            this.gAw.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bSy() {
        if (this.gzp != null && this.gAw != null) {
            this.gzp.setNextPage(null);
            this.gAw.hideEmptyView();
        }
    }

    public void Cx(int i) {
        if (this.gzp != null) {
            this.gzp.smoothScrollBy(i, 1);
            cTQ();
        }
    }

    public void setMainView(c cVar) {
        this.ksS = cVar;
    }

    public void aQ(float f) {
        if (this.gzp != null && this.kxR != null && this.kxR.cTt() != null) {
            this.gzp.setSelection(0);
            this.kxW = new a((int) f);
            com.baidu.adp.lib.f.e.mA().post(this.kxW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        int kxY;

        public a(int i) {
            this.kxY = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gzp.smoothScrollBy(Math.abs(this.kxY), 1);
            HotTopicView.this.cTQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTQ() {
        if (cqT()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cqS()) {
            this.gJB.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.ksS != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.kxS = Math.abs(absListView.getChildAt(0).getTop());
                if (this.kxS > this.kxV && this.kxU <= 1) {
                    cTR();
                } else if (this.kxS < this.kxV) {
                    cTS();
                }
                this.kxV = this.kxS;
            }
            this.kxU = i;
        }
    }

    private void cTR() {
        this.ksS.a(this.gzp, Math.min(this.kxS, this.ksS.cTK()));
    }

    private void cTS() {
        if (!cTT()) {
            this.ksS.a(this.gzp, Math.min(this.kxS, this.ksS.cTK()));
        }
    }

    private boolean cTT() {
        return this.ksS.cTM() != null && this.ksS.cTM().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.ksS == null || this.ksS.cTM() == null) {
            return 0;
        }
        return (int) Math.abs(this.ksS.cTN() + this.ksS.cTM().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.ksS == null || this.ksS.cTM() == null) {
            return 0;
        }
        int height = getHeight() - this.ksS.cTN();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.ksS.cTN();
    }
}
