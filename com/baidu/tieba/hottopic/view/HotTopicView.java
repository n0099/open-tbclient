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
/* loaded from: classes15.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener cNn;
    private BdTypeListView fCP;
    private PbListView fDW;
    private g fMN;
    private CustomMessageListener faw;
    private CustomMessageListener fax;
    private int hVF;
    f.c iMW;
    private c.a iXs;
    private c iXt;
    private com.baidu.tieba.hottopic.adapter.e jcr;
    private com.baidu.tieba.hottopic.controller.d jcs;
    private com.baidu.tieba.hottopic.data.e jct;
    private int jcu;
    private View jcv;
    private int jcw;
    private int jcx;
    private a jcy;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hVF = 0;
        this.iMW = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jcs.cxp();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).czF();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jcs.pW(true);
                HotTopicView.this.fCP.completePullRefreshPostDelayed(0L);
            }
        };
        this.cNn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jcs.czR();
                    s.cbX().bDV();
                }
                if (HotTopicView.this.iXs != null) {
                    HotTopicView.this.iXs.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jcs.onScroll(i2, i3);
                if (HotTopicView.this.iXs != null) {
                    HotTopicView.this.iXs.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fax = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jct != null && HotTopicView.this.jct.cAd() != null && HotTopicView.this.jct.cAd().iZU != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum++;
                            eU.setIsLiked(true);
                            HotTopicView.this.jct.cAd().iZW = true;
                            HotTopicView.this.jcr.a(HotTopicView.this.jct);
                        }
                    }
                }
            }
        };
        this.faw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jct != null && HotTopicView.this.jct.cAd() != null && HotTopicView.this.jct.cAd().iZU != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum--;
                            eU.setIsLiked(false);
                            HotTopicView.this.jct.cAd().iZW = true;
                            HotTopicView.this.jcr.a(HotTopicView.this.jct);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hVF = 0;
        this.iMW = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jcs.cxp();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).czF();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jcs.pW(true);
                HotTopicView.this.fCP.completePullRefreshPostDelayed(0L);
            }
        };
        this.cNn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jcs.czR();
                    s.cbX().bDV();
                }
                if (HotTopicView.this.iXs != null) {
                    HotTopicView.this.iXs.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jcs.onScroll(i2, i3);
                if (HotTopicView.this.iXs != null) {
                    HotTopicView.this.iXs.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fax = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jct != null && HotTopicView.this.jct.cAd() != null && HotTopicView.this.jct.cAd().iZU != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum++;
                            eU.setIsLiked(true);
                            HotTopicView.this.jct.cAd().iZW = true;
                            HotTopicView.this.jcr.a(HotTopicView.this.jct);
                        }
                    }
                }
            }
        };
        this.faw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jct != null && HotTopicView.this.jct.cAd() != null && HotTopicView.this.jct.cAd().iZU != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum--;
                            eU.setIsLiked(false);
                            HotTopicView.this.jct.cAd().iZW = true;
                            HotTopicView.this.jcr.a(HotTopicView.this.jct);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.hVF = 0;
        this.iMW = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jcs.cxp();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).czF();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jcs.pW(true);
                HotTopicView.this.fCP.completePullRefreshPostDelayed(0L);
            }
        };
        this.cNn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jcs.czR();
                    s.cbX().bDV();
                }
                if (HotTopicView.this.iXs != null) {
                    HotTopicView.this.iXs.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jcs.onScroll(i2, i3);
                if (HotTopicView.this.iXs != null) {
                    HotTopicView.this.iXs.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fax = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jct != null && HotTopicView.this.jct.cAd() != null && HotTopicView.this.jct.cAd().iZU != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum++;
                            eU.setIsLiked(true);
                            HotTopicView.this.jct.cAd().iZW = true;
                            HotTopicView.this.jcr.a(HotTopicView.this.jct);
                        }
                    }
                }
            }
        };
        this.faw = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jct != null && HotTopicView.this.jct.cAd() != null && HotTopicView.this.jct.cAd().iZU != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum--;
                            eU.setIsLiked(false);
                            HotTopicView.this.jct.cAd().iZW = true;
                            HotTopicView.this.jcr.a(HotTopicView.this.jct);
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
            this.fCP = new BdTypeListView(context);
            this.fCP.setVerticalScrollBarEnabled(false);
            this.fCP.setDividerHeight(0);
            this.fCP.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.iMW);
            this.fCP.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.fCP.addFooterView(view);
            this.fCP.setOnScrollListener(this.cNn);
            this.fCP.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.fCP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.fCP && HotTopicView.this.jcs != null) {
                        HotTopicView.this.jcs.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.jcr = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.fCP);
            addView(this.fCP);
            ((FrameLayout.LayoutParams) this.fCP.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.jcs = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.fCP);
            this.pageContext.registerListener(this.fax);
            this.pageContext.registerListener(this.faw);
            cAA();
            this.fDW = new PbListView(context);
            this.fDW.createView();
            this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fDW.setLineGone();
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        }
    }

    private void cAA() {
        this.jcv = new View(getContext());
        this.jcv.setId(R.id.view_header);
        this.jcv.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.fCP.addHeaderView(this.jcv, 0);
    }

    public BdTypeListView getListView() {
        return this.fCP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData eU(long j) {
        if (this.jct != null && this.jct.cAd() != null && this.jct.cAd().iZU != null) {
            for (q qVar : this.jct.cAd().iZU) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.jcr != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.jct = eVar;
            this.jcr.setFromCDN(eVar.cgE());
            this.jcr.a(eVar);
            this.fCP.setVisibility(0);
            if (!y.isEmpty(eVar.cAf())) {
                ap.setBackgroundColor(this.fCP, R.color.cp_bg_line_c);
            }
        }
    }

    public void pV(boolean z) {
        if (this.fCP != null) {
            this.jcs.pW(true);
            if (z) {
                this.fCP.completePullRefresh();
            } else {
                this.fCP.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void gS(boolean z) {
        if (!cgv()) {
            if (this.fMN == null) {
                this.fMN = new g(getContext());
                this.fMN.setTopMargin(getLoadingViewTopMargin());
                this.fMN.bsZ();
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
        if (!cAE() && this.iXt != null && this.iXt.cAx() != null) {
            this.fCP.smoothScrollBy((int) (-this.iXt.cAx().getY()), 1);
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
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.bFW();
                            HotTopicView.this.gS(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).czF();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.fCP.setVisibility(8);
        }
    }

    public void bFW() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgw() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fMN != null) {
            this.fMN.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fDW.changeSkin(i);
        }
        if (this.jcr != null) {
            this.jcr.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fCP, R.color.cp_bg_line_c);
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
        if (this.jcs != null) {
            this.jcs.destroy();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jcy);
    }

    public void resume() {
        if (this.jcs != null) {
            this.jcs.pX(false);
        }
    }

    public void pause() {
        if (this.jcs != null) {
            this.jcs.pX(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.iXs = aVar;
    }

    public void Ax(int i) {
        ViewGroup.LayoutParams layoutParams = this.jcv.getLayoutParams();
        layoutParams.height = i;
        this.jcv.setLayoutParams(layoutParams);
        cAB();
    }

    public void bGR() {
        if (this.fCP != null && this.fDW != null) {
            this.fCP.setNextPage(this.fDW);
            this.fDW.setTextSize(R.dimen.tbfontsize33);
            this.fDW.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fDW.startLoadData();
        }
    }

    public void bGS() {
        if (this.fCP != null && this.fDW != null) {
            if (this.hVF > 0) {
                this.fDW.showEmptyView(this.hVF);
            }
            this.fCP.setNextPage(this.fDW);
            this.fDW.endLoadData();
            this.fDW.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bGT() {
        if (this.fCP != null && this.fDW != null) {
            this.fCP.setNextPage(null);
            this.fDW.hideEmptyView();
        }
    }

    public void Ay(int i) {
        if (this.fCP != null) {
            this.fCP.smoothScrollBy(i, 1);
            cAB();
        }
    }

    public void setMainView(c cVar) {
        this.iXt = cVar;
    }

    public void at(float f) {
        if (this.fCP != null && this.jct != null && this.jct.cAd() != null) {
            this.fCP.setSelection(0);
            this.jcy = new a((int) f);
            com.baidu.adp.lib.f.e.mS().post(this.jcy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        int jcA;

        public a(int i) {
            this.jcA = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.fCP.smoothScrollBy(Math.abs(this.jcA), 1);
            HotTopicView.this.cAB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAB() {
        if (cgw()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cgv()) {
            this.fMN.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.iXt != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.jcu = Math.abs(absListView.getChildAt(0).getTop());
                if (this.jcu > this.jcx && this.jcw <= 1) {
                    cAC();
                } else if (this.jcu < this.jcx) {
                    cAD();
                }
                this.jcx = this.jcu;
            }
            this.jcw = i;
        }
    }

    private void cAC() {
        this.iXt.a(this.fCP, Math.min(this.jcu, this.iXt.cAv()));
    }

    private void cAD() {
        if (!cAE()) {
            this.iXt.a(this.fCP, Math.min(this.jcu, this.iXt.cAv()));
        }
    }

    private boolean cAE() {
        return this.iXt.cAx() != null && this.iXt.cAx().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.iXt == null || this.iXt.cAx() == null) {
            return 0;
        }
        return (int) Math.abs(this.iXt.cAy() + this.iXt.cAx().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.iXt == null || this.iXt.cAx() == null) {
            return 0;
        }
        int height = getHeight() - this.iXt.cAy();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.iXt.cAy();
    }
}
