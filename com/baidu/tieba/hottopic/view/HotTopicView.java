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
/* loaded from: classes21.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener djY;
    private CustomMessageListener fyf;
    private CustomMessageListener fyg;
    private BdTypeListView gcr;
    private PbListView gdy;
    private g gmB;
    private int iEi;
    private c.a jHC;
    private c jHD;
    private com.baidu.tieba.hottopic.adapter.e jMA;
    private com.baidu.tieba.hottopic.controller.d jMB;
    private com.baidu.tieba.hottopic.data.e jMC;
    private int jMD;
    private View jME;
    private int jMF;
    private int jMG;
    private a jMH;
    f.c jxd;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iEi = 0;
        this.jxd = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jMB.cHM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cKd();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jMB.re(true);
                HotTopicView.this.gcr.completePullRefreshPostDelayed(0L);
            }
        };
        this.djY = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jMB.cKp();
                    t.clQ().bJQ();
                }
                if (HotTopicView.this.jHC != null) {
                    HotTopicView.this.jHC.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jMB.onScroll(i2, i3);
                if (HotTopicView.this.jHC != null) {
                    HotTopicView.this.jHC.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fyg = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jMC != null && HotTopicView.this.jMC.cKB() != null && HotTopicView.this.jMC.cKB().jKd != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fB = HotTopicView.this.fB(((Long) data).longValue());
                        if (fB != null) {
                            fB.followNum++;
                            fB.setIsLiked(true);
                            HotTopicView.this.jMC.cKB().jKf = true;
                            HotTopicView.this.jMA.a(HotTopicView.this.jMC);
                        }
                    }
                }
            }
        };
        this.fyf = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jMC != null && HotTopicView.this.jMC.cKB() != null && HotTopicView.this.jMC.cKB().jKd != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fB = HotTopicView.this.fB(((Long) data).longValue());
                        if (fB != null) {
                            fB.followNum--;
                            fB.setIsLiked(false);
                            HotTopicView.this.jMC.cKB().jKf = true;
                            HotTopicView.this.jMA.a(HotTopicView.this.jMC);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iEi = 0;
        this.jxd = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jMB.cHM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cKd();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jMB.re(true);
                HotTopicView.this.gcr.completePullRefreshPostDelayed(0L);
            }
        };
        this.djY = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jMB.cKp();
                    t.clQ().bJQ();
                }
                if (HotTopicView.this.jHC != null) {
                    HotTopicView.this.jHC.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jMB.onScroll(i2, i3);
                if (HotTopicView.this.jHC != null) {
                    HotTopicView.this.jHC.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fyg = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jMC != null && HotTopicView.this.jMC.cKB() != null && HotTopicView.this.jMC.cKB().jKd != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fB = HotTopicView.this.fB(((Long) data).longValue());
                        if (fB != null) {
                            fB.followNum++;
                            fB.setIsLiked(true);
                            HotTopicView.this.jMC.cKB().jKf = true;
                            HotTopicView.this.jMA.a(HotTopicView.this.jMC);
                        }
                    }
                }
            }
        };
        this.fyf = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jMC != null && HotTopicView.this.jMC.cKB() != null && HotTopicView.this.jMC.cKB().jKd != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fB = HotTopicView.this.fB(((Long) data).longValue());
                        if (fB != null) {
                            fB.followNum--;
                            fB.setIsLiked(false);
                            HotTopicView.this.jMC.cKB().jKf = true;
                            HotTopicView.this.jMA.a(HotTopicView.this.jMC);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.iEi = 0;
        this.jxd = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jMB.cHM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cKd();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jMB.re(true);
                HotTopicView.this.gcr.completePullRefreshPostDelayed(0L);
            }
        };
        this.djY = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jMB.cKp();
                    t.clQ().bJQ();
                }
                if (HotTopicView.this.jHC != null) {
                    HotTopicView.this.jHC.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jMB.onScroll(i2, i3);
                if (HotTopicView.this.jHC != null) {
                    HotTopicView.this.jHC.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fyg = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jMC != null && HotTopicView.this.jMC.cKB() != null && HotTopicView.this.jMC.cKB().jKd != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fB = HotTopicView.this.fB(((Long) data).longValue());
                        if (fB != null) {
                            fB.followNum++;
                            fB.setIsLiked(true);
                            HotTopicView.this.jMC.cKB().jKf = true;
                            HotTopicView.this.jMA.a(HotTopicView.this.jMC);
                        }
                    }
                }
            }
        };
        this.fyf = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jMC != null && HotTopicView.this.jMC.cKB() != null && HotTopicView.this.jMC.cKB().jKd != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fB = HotTopicView.this.fB(((Long) data).longValue());
                        if (fB != null) {
                            fB.followNum--;
                            fB.setIsLiked(false);
                            HotTopicView.this.jMC.cKB().jKf = true;
                            HotTopicView.this.jMA.a(HotTopicView.this.jMC);
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
            this.gcr = new BdTypeListView(context);
            this.gcr.setVerticalScrollBarEnabled(false);
            this.gcr.setDividerHeight(0);
            this.gcr.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.jxd);
            this.gcr.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gcr.addFooterView(view);
            this.gcr.setOnScrollListener(this.djY);
            this.gcr.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gcr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gcr && HotTopicView.this.jMB != null) {
                        HotTopicView.this.jMB.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.jMA = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.gcr);
            addView(this.gcr);
            ((FrameLayout.LayoutParams) this.gcr.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.jMB = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gcr);
            this.pageContext.registerListener(this.fyg);
            this.pageContext.registerListener(this.fyf);
            cKY();
            this.gdy = new PbListView(context);
            this.gdy.createView();
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.gdy.setLineGone();
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        }
    }

    private void cKY() {
        this.jME = new View(getContext());
        this.jME.setId(R.id.view_header);
        this.jME.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gcr.addHeaderView(this.jME, 0);
    }

    public BdTypeListView getListView() {
        return this.gcr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData fB(long j) {
        if (this.jMC != null && this.jMC.cKB() != null && this.jMC.cKB().jKd != null) {
            for (q qVar : this.jMC.cKB().jKd) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.jMA != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.jMC = eVar;
            this.jMA.setFromCDN(eVar.cqx());
            this.jMA.a(eVar);
            this.gcr.setVisibility(0);
            if (!y.isEmpty(eVar.cKD())) {
                ap.setBackgroundColor(this.gcr, R.color.cp_bg_line_c);
            }
        }
    }

    public void rd(boolean z) {
        if (this.gcr != null) {
            this.jMB.re(true);
            if (z) {
                this.gcr.completePullRefresh();
            } else {
                this.gcr.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void hA(boolean z) {
        if (!ckh()) {
            if (this.gmB == null) {
                this.gmB = new g(getContext());
                this.gmB.setTopMargin(getLoadingViewTopMargin());
                this.gmB.byH();
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
        if (!cLc() && this.jHD != null && this.jHD.cKV() != null) {
            this.gcr.smoothScrollBy((int) (-this.jHD.cKV().getY()), 1);
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
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.TK();
                            HotTopicView.this.hA(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cKd();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gcr.setVisibility(8);
        }
    }

    public void TK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cki() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gmB != null) {
            this.gmB.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gdy.changeSkin(i);
        }
        if (this.jMA != null) {
            this.jMA.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gcr, R.color.cp_bg_line_c);
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
        if (this.jMB != null) {
            this.jMB.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jMH);
    }

    public void resume() {
        if (this.jMB != null) {
            this.jMB.rf(false);
        }
    }

    public void pause() {
        if (this.jMB != null) {
            this.jMB.rf(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.jHC = aVar;
    }

    public void BX(int i) {
        ViewGroup.LayoutParams layoutParams = this.jME.getLayoutParams();
        layoutParams.height = i;
        this.jME.setLayoutParams(layoutParams);
        cKZ();
    }

    public void TI() {
        if (this.gcr != null && this.gdy != null) {
            this.gcr.setNextPage(this.gdy);
            this.gdy.setTextSize(R.dimen.tbfontsize33);
            this.gdy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gdy.startLoadData();
        }
    }

    public void TJ() {
        if (this.gcr != null && this.gdy != null) {
            if (this.iEi > 0) {
                this.gdy.showEmptyView(this.iEi);
            }
            this.gcr.setNextPage(this.gdy);
            this.gdy.endLoadData();
            this.gdy.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bNw() {
        if (this.gcr != null && this.gdy != null) {
            this.gcr.setNextPage(null);
            this.gdy.hideEmptyView();
        }
    }

    public void BY(int i) {
        if (this.gcr != null) {
            this.gcr.smoothScrollBy(i, 1);
            cKZ();
        }
    }

    public void setMainView(c cVar) {
        this.jHD = cVar;
    }

    public void aB(float f) {
        if (this.gcr != null && this.jMC != null && this.jMC.cKB() != null) {
            this.gcr.setSelection(0);
            this.jMH = new a((int) f);
            com.baidu.adp.lib.f.e.mY().post(this.jMH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int jMJ;

        public a(int i) {
            this.jMJ = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gcr.smoothScrollBy(Math.abs(this.jMJ), 1);
            HotTopicView.this.cKZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKZ() {
        if (cki()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (ckh()) {
            this.gmB.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.jHD != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.jMD = Math.abs(absListView.getChildAt(0).getTop());
                if (this.jMD > this.jMG && this.jMF <= 1) {
                    cLa();
                } else if (this.jMD < this.jMG) {
                    cLb();
                }
                this.jMG = this.jMD;
            }
            this.jMF = i;
        }
    }

    private void cLa() {
        this.jHD.a(this.gcr, Math.min(this.jMD, this.jHD.cKT()));
    }

    private void cLb() {
        if (!cLc()) {
            this.jHD.a(this.gcr, Math.min(this.jMD, this.jHD.cKT()));
        }
    }

    private boolean cLc() {
        return this.jHD.cKV() != null && this.jHD.cKV().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.jHD == null || this.jHD.cKV() == null) {
            return 0;
        }
        return (int) Math.abs(this.jHD.cKW() + this.jHD.cKV().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.jHD == null || this.jHD.cKV() == null) {
            return 0;
        }
        int height = getHeight() - this.jHD.cKW();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.jHD.cKW();
    }
}
