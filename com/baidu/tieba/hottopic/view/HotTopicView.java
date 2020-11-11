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
    AbsListView.OnScrollListener dpT;
    private CustomMessageListener fDV;
    private CustomMessageListener fDW;
    private BdTypeListView gih;
    private PbListView gjo;
    private g gso;
    private int iKf;
    f.c jDa;
    private c.a jNA;
    private c jNB;
    private int jSA;
    private View jSB;
    private int jSC;
    private int jSD;
    private a jSE;
    private com.baidu.tieba.hottopic.adapter.e jSx;
    private com.baidu.tieba.hottopic.controller.d jSy;
    private com.baidu.tieba.hottopic.data.e jSz;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iKf = 0;
        this.jDa = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jSy.cKn();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cME();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jSy.rn(true);
                HotTopicView.this.gih.completePullRefreshPostDelayed(0L);
            }
        };
        this.dpT = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jSy.cMQ();
                    t.cor().bMp();
                }
                if (HotTopicView.this.jNA != null) {
                    HotTopicView.this.jNA.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jSy.onScroll(i2, i3);
                if (HotTopicView.this.jNA != null) {
                    HotTopicView.this.jNA.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jSz != null && HotTopicView.this.jSz.cNc() != null && HotTopicView.this.jSz.cNc().jQb != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fX = HotTopicView.this.fX(((Long) data).longValue());
                        if (fX != null) {
                            fX.followNum++;
                            fX.setIsLiked(true);
                            HotTopicView.this.jSz.cNc().jQd = true;
                            HotTopicView.this.jSx.a(HotTopicView.this.jSz);
                        }
                    }
                }
            }
        };
        this.fDV = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jSz != null && HotTopicView.this.jSz.cNc() != null && HotTopicView.this.jSz.cNc().jQb != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fX = HotTopicView.this.fX(((Long) data).longValue());
                        if (fX != null) {
                            fX.followNum--;
                            fX.setIsLiked(false);
                            HotTopicView.this.jSz.cNc().jQd = true;
                            HotTopicView.this.jSx.a(HotTopicView.this.jSz);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iKf = 0;
        this.jDa = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jSy.cKn();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cME();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jSy.rn(true);
                HotTopicView.this.gih.completePullRefreshPostDelayed(0L);
            }
        };
        this.dpT = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jSy.cMQ();
                    t.cor().bMp();
                }
                if (HotTopicView.this.jNA != null) {
                    HotTopicView.this.jNA.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jSy.onScroll(i2, i3);
                if (HotTopicView.this.jNA != null) {
                    HotTopicView.this.jNA.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jSz != null && HotTopicView.this.jSz.cNc() != null && HotTopicView.this.jSz.cNc().jQb != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fX = HotTopicView.this.fX(((Long) data).longValue());
                        if (fX != null) {
                            fX.followNum++;
                            fX.setIsLiked(true);
                            HotTopicView.this.jSz.cNc().jQd = true;
                            HotTopicView.this.jSx.a(HotTopicView.this.jSz);
                        }
                    }
                }
            }
        };
        this.fDV = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jSz != null && HotTopicView.this.jSz.cNc() != null && HotTopicView.this.jSz.cNc().jQb != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fX = HotTopicView.this.fX(((Long) data).longValue());
                        if (fX != null) {
                            fX.followNum--;
                            fX.setIsLiked(false);
                            HotTopicView.this.jSz.cNc().jQd = true;
                            HotTopicView.this.jSx.a(HotTopicView.this.jSz);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.iKf = 0;
        this.jDa = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jSy.cKn();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cME();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jSy.rn(true);
                HotTopicView.this.gih.completePullRefreshPostDelayed(0L);
            }
        };
        this.dpT = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jSy.cMQ();
                    t.cor().bMp();
                }
                if (HotTopicView.this.jNA != null) {
                    HotTopicView.this.jNA.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jSy.onScroll(i2, i3);
                if (HotTopicView.this.jNA != null) {
                    HotTopicView.this.jNA.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fDW = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jSz != null && HotTopicView.this.jSz.cNc() != null && HotTopicView.this.jSz.cNc().jQb != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fX = HotTopicView.this.fX(((Long) data).longValue());
                        if (fX != null) {
                            fX.followNum++;
                            fX.setIsLiked(true);
                            HotTopicView.this.jSz.cNc().jQd = true;
                            HotTopicView.this.jSx.a(HotTopicView.this.jSz);
                        }
                    }
                }
            }
        };
        this.fDV = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jSz != null && HotTopicView.this.jSz.cNc() != null && HotTopicView.this.jSz.cNc().jQb != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fX = HotTopicView.this.fX(((Long) data).longValue());
                        if (fX != null) {
                            fX.followNum--;
                            fX.setIsLiked(false);
                            HotTopicView.this.jSz.cNc().jQd = true;
                            HotTopicView.this.jSx.a(HotTopicView.this.jSz);
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
            this.gih = new BdTypeListView(context);
            this.gih.setVerticalScrollBarEnabled(false);
            this.gih.setDividerHeight(0);
            this.gih.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.jDa);
            this.gih.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gih.addFooterView(view);
            this.gih.setOnScrollListener(this.dpT);
            this.gih.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gih.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gih && HotTopicView.this.jSy != null) {
                        HotTopicView.this.jSy.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.jSx = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.gih);
            addView(this.gih);
            ((FrameLayout.LayoutParams) this.gih.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.jSy = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gih);
            this.pageContext.registerListener(this.fDW);
            this.pageContext.registerListener(this.fDV);
            cNz();
            this.gjo = new PbListView(context);
            this.gjo.createView();
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.gjo.setLineGone();
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        }
    }

    private void cNz() {
        this.jSB = new View(getContext());
        this.jSB.setId(R.id.view_header);
        this.jSB.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gih.addHeaderView(this.jSB, 0);
    }

    public BdTypeListView getListView() {
        return this.gih;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData fX(long j) {
        if (this.jSz != null && this.jSz.cNc() != null && this.jSz.cNc().jQb != null) {
            for (q qVar : this.jSz.cNc().jQb) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.jSx != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.jSz = eVar;
            this.jSx.setFromCDN(eVar.csY());
            this.jSx.a(eVar);
            this.gih.setVisibility(0);
            if (!y.isEmpty(eVar.cNe())) {
                ap.setBackgroundColor(this.gih, R.color.cp_bg_line_c);
            }
        }
    }

    public void rm(boolean z) {
        if (this.gih != null) {
            this.jSy.rn(true);
            if (z) {
                this.gih.completePullRefresh();
            } else {
                this.gih.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void hJ(boolean z) {
        if (!cmJ()) {
            if (this.gso == null) {
                this.gso = new g(getContext());
                this.gso.setTopMargin(getLoadingViewTopMargin());
                this.gso.bBg();
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this, z);
            this.gih.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this);
            this.gso = null;
        }
        if (!cND() && this.jNB != null && this.jNB.cNw() != null) {
            this.gih.smoothScrollBy((int) (-this.jNB.cNw().getY()), 1);
        }
    }

    public boolean cmJ() {
        if (this.gso != null) {
            return this.gso.isViewAttached();
        }
        return false;
    }

    public void aQ(String str, boolean z) {
        if (!cmK()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.Wk();
                            HotTopicView.this.hJ(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cME();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gih.setVisibility(8);
        }
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cmK() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gso != null) {
            this.gso.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.gjo.changeSkin(i);
        }
        if (this.jSx != null) {
            this.jSx.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gih, R.color.cp_bg_line_c);
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
        if (this.jSy != null) {
            this.jSy.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jSE);
    }

    public void resume() {
        if (this.jSy != null) {
            this.jSy.ro(false);
        }
    }

    public void pause() {
        if (this.jSy != null) {
            this.jSy.ro(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.jNA = aVar;
    }

    public void Ck(int i) {
        ViewGroup.LayoutParams layoutParams = this.jSB.getLayoutParams();
        layoutParams.height = i;
        this.jSB.setLayoutParams(layoutParams);
        cNA();
    }

    public void Wi() {
        if (this.gih != null && this.gjo != null) {
            this.gih.setNextPage(this.gjo);
            this.gjo.setTextSize(R.dimen.tbfontsize33);
            this.gjo.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gjo.startLoadData();
        }
    }

    public void Wj() {
        if (this.gih != null && this.gjo != null) {
            if (this.iKf > 0) {
                this.gjo.showEmptyView(this.iKf);
            }
            this.gih.setNextPage(this.gjo);
            this.gjo.endLoadData();
            this.gjo.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bPW() {
        if (this.gih != null && this.gjo != null) {
            this.gih.setNextPage(null);
            this.gjo.hideEmptyView();
        }
    }

    public void Cl(int i) {
        if (this.gih != null) {
            this.gih.smoothScrollBy(i, 1);
            cNA();
        }
    }

    public void setMainView(c cVar) {
        this.jNB = cVar;
    }

    public void aD(float f) {
        if (this.gih != null && this.jSz != null && this.jSz.cNc() != null) {
            this.gih.setSelection(0);
            this.jSE = new a((int) f);
            com.baidu.adp.lib.f.e.mY().post(this.jSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int jSG;

        public a(int i) {
            this.jSG = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gih.smoothScrollBy(Math.abs(this.jSG), 1);
            HotTopicView.this.cNA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNA() {
        if (cmK()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cmJ()) {
            this.gso.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.jNB != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.jSA = Math.abs(absListView.getChildAt(0).getTop());
                if (this.jSA > this.jSD && this.jSC <= 1) {
                    cNB();
                } else if (this.jSA < this.jSD) {
                    cNC();
                }
                this.jSD = this.jSA;
            }
            this.jSC = i;
        }
    }

    private void cNB() {
        this.jNB.a(this.gih, Math.min(this.jSA, this.jNB.cNu()));
    }

    private void cNC() {
        if (!cND()) {
            this.jNB.a(this.gih, Math.min(this.jSA, this.jNB.cNu()));
        }
    }

    private boolean cND() {
        return this.jNB.cNw() != null && this.jNB.cNw().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.jNB == null || this.jNB.cNw() == null) {
            return 0;
        }
        return (int) Math.abs(this.jNB.cNx() + this.jNB.cNw().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.jNB == null || this.jNB.cNw() == null) {
            return 0;
        }
        int height = getHeight() - this.jNB.cNx();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.jNB.cNx();
    }
}
