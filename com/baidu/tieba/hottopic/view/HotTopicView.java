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
    AbsListView.OnScrollListener cNr;
    private BdTypeListView fCT;
    private PbListView fEa;
    private g fMR;
    private CustomMessageListener faA;
    private CustomMessageListener faB;
    private int hVL;
    f.c iNc;
    private c.a iXy;
    private c iXz;
    private int jcA;
    private View jcB;
    private int jcC;
    private int jcD;
    private a jcE;
    private com.baidu.tieba.hottopic.adapter.e jcx;
    private com.baidu.tieba.hottopic.controller.d jcy;
    private com.baidu.tieba.hottopic.data.e jcz;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hVL = 0;
        this.iNc = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jcy.cxq();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).czG();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jcy.pY(true);
                HotTopicView.this.fCT.completePullRefreshPostDelayed(0L);
            }
        };
        this.cNr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jcy.czS();
                    s.cbY().bDW();
                }
                if (HotTopicView.this.iXy != null) {
                    HotTopicView.this.iXy.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jcy.onScroll(i2, i3);
                if (HotTopicView.this.iXy != null) {
                    HotTopicView.this.iXy.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.faB = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jcz != null && HotTopicView.this.jcz.cAe() != null && HotTopicView.this.jcz.cAe().jaa != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum++;
                            eU.setIsLiked(true);
                            HotTopicView.this.jcz.cAe().jac = true;
                            HotTopicView.this.jcx.a(HotTopicView.this.jcz);
                        }
                    }
                }
            }
        };
        this.faA = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jcz != null && HotTopicView.this.jcz.cAe() != null && HotTopicView.this.jcz.cAe().jaa != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum--;
                            eU.setIsLiked(false);
                            HotTopicView.this.jcz.cAe().jac = true;
                            HotTopicView.this.jcx.a(HotTopicView.this.jcz);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hVL = 0;
        this.iNc = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jcy.cxq();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).czG();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jcy.pY(true);
                HotTopicView.this.fCT.completePullRefreshPostDelayed(0L);
            }
        };
        this.cNr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jcy.czS();
                    s.cbY().bDW();
                }
                if (HotTopicView.this.iXy != null) {
                    HotTopicView.this.iXy.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jcy.onScroll(i2, i3);
                if (HotTopicView.this.iXy != null) {
                    HotTopicView.this.iXy.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.faB = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jcz != null && HotTopicView.this.jcz.cAe() != null && HotTopicView.this.jcz.cAe().jaa != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum++;
                            eU.setIsLiked(true);
                            HotTopicView.this.jcz.cAe().jac = true;
                            HotTopicView.this.jcx.a(HotTopicView.this.jcz);
                        }
                    }
                }
            }
        };
        this.faA = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jcz != null && HotTopicView.this.jcz.cAe() != null && HotTopicView.this.jcz.cAe().jaa != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum--;
                            eU.setIsLiked(false);
                            HotTopicView.this.jcz.cAe().jac = true;
                            HotTopicView.this.jcx.a(HotTopicView.this.jcz);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.hVL = 0;
        this.iNc = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jcy.cxq();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).czG();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jcy.pY(true);
                HotTopicView.this.fCT.completePullRefreshPostDelayed(0L);
            }
        };
        this.cNr = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jcy.czS();
                    s.cbY().bDW();
                }
                if (HotTopicView.this.iXy != null) {
                    HotTopicView.this.iXy.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jcy.onScroll(i2, i3);
                if (HotTopicView.this.iXy != null) {
                    HotTopicView.this.iXy.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.faB = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jcz != null && HotTopicView.this.jcz.cAe() != null && HotTopicView.this.jcz.cAe().jaa != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum++;
                            eU.setIsLiked(true);
                            HotTopicView.this.jcz.cAe().jac = true;
                            HotTopicView.this.jcx.a(HotTopicView.this.jcz);
                        }
                    }
                }
            }
        };
        this.faA = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jcz != null && HotTopicView.this.jcz.cAe() != null && HotTopicView.this.jcz.cAe().jaa != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eU = HotTopicView.this.eU(((Long) data).longValue());
                        if (eU != null) {
                            eU.followNum--;
                            eU.setIsLiked(false);
                            HotTopicView.this.jcz.cAe().jac = true;
                            HotTopicView.this.jcx.a(HotTopicView.this.jcz);
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
            this.fCT = new BdTypeListView(context);
            this.fCT.setVerticalScrollBarEnabled(false);
            this.fCT.setDividerHeight(0);
            this.fCT.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.iNc);
            this.fCT.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.fCT.addFooterView(view);
            this.fCT.setOnScrollListener(this.cNr);
            this.fCT.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.fCT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.fCT && HotTopicView.this.jcy != null) {
                        HotTopicView.this.jcy.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.jcx = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.fCT);
            addView(this.fCT);
            ((FrameLayout.LayoutParams) this.fCT.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.jcy = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.fCT);
            this.pageContext.registerListener(this.faB);
            this.pageContext.registerListener(this.faA);
            cAB();
            this.fEa = new PbListView(context);
            this.fEa.createView();
            this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fEa.setLineGone();
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        }
    }

    private void cAB() {
        this.jcB = new View(getContext());
        this.jcB.setId(R.id.view_header);
        this.jcB.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.fCT.addHeaderView(this.jcB, 0);
    }

    public BdTypeListView getListView() {
        return this.fCT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData eU(long j) {
        if (this.jcz != null && this.jcz.cAe() != null && this.jcz.cAe().jaa != null) {
            for (q qVar : this.jcz.cAe().jaa) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.jcx != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.jcz = eVar;
            this.jcx.setFromCDN(eVar.cgF());
            this.jcx.a(eVar);
            this.fCT.setVisibility(0);
            if (!y.isEmpty(eVar.cAg())) {
                ap.setBackgroundColor(this.fCT, R.color.cp_bg_line_c);
            }
        }
    }

    public void pX(boolean z) {
        if (this.fCT != null) {
            this.jcy.pY(true);
            if (z) {
                this.fCT.completePullRefresh();
            } else {
                this.fCT.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void gT(boolean z) {
        if (!cgw()) {
            if (this.fMR == null) {
                this.fMR = new g(getContext());
                this.fMR.setTopMargin(getLoadingViewTopMargin());
                this.fMR.bta();
                this.fMR.onChangeSkinType();
            }
            this.fMR.attachView(this, z);
            this.fCT.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.fMR != null) {
            this.fMR.dettachView(this);
            this.fMR = null;
        }
        if (!cAF() && this.iXz != null && this.iXz.cAy() != null) {
            this.fCT.smoothScrollBy((int) (-this.iXz.cAy().getY()), 1);
        }
    }

    public boolean cgw() {
        if (this.fMR != null) {
            return this.fMR.isViewAttached();
        }
        return false;
    }

    public void aK(String str, boolean z) {
        if (!cgx()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.bFX();
                            HotTopicView.this.gT(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).czG();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.fCT.setVisibility(8);
        }
    }

    public void bFX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cgx() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fMR != null) {
            this.fMR.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fEa.changeSkin(i);
        }
        if (this.jcx != null) {
            this.jcx.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fCT, R.color.cp_bg_line_c);
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
        if (this.jcy != null) {
            this.jcy.destroy();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.jcE);
    }

    public void resume() {
        if (this.jcy != null) {
            this.jcy.pZ(false);
        }
    }

    public void pause() {
        if (this.jcy != null) {
            this.jcy.pZ(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.iXy = aVar;
    }

    public void Ax(int i) {
        ViewGroup.LayoutParams layoutParams = this.jcB.getLayoutParams();
        layoutParams.height = i;
        this.jcB.setLayoutParams(layoutParams);
        cAC();
    }

    public void bGS() {
        if (this.fCT != null && this.fEa != null) {
            this.fCT.setNextPage(this.fEa);
            this.fEa.setTextSize(R.dimen.tbfontsize33);
            this.fEa.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fEa.startLoadData();
        }
    }

    public void bGT() {
        if (this.fCT != null && this.fEa != null) {
            if (this.hVL > 0) {
                this.fEa.showEmptyView(this.hVL);
            }
            this.fCT.setNextPage(this.fEa);
            this.fEa.endLoadData();
            this.fEa.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bGU() {
        if (this.fCT != null && this.fEa != null) {
            this.fCT.setNextPage(null);
            this.fEa.hideEmptyView();
        }
    }

    public void Ay(int i) {
        if (this.fCT != null) {
            this.fCT.smoothScrollBy(i, 1);
            cAC();
        }
    }

    public void setMainView(c cVar) {
        this.iXz = cVar;
    }

    public void at(float f) {
        if (this.fCT != null && this.jcz != null && this.jcz.cAe() != null) {
            this.fCT.setSelection(0);
            this.jcE = new a((int) f);
            com.baidu.adp.lib.f.e.mS().post(this.jcE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        int jcG;

        public a(int i) {
            this.jcG = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.fCT.smoothScrollBy(Math.abs(this.jcG), 1);
            HotTopicView.this.cAC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAC() {
        if (cgx()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cgw()) {
            this.fMR.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.iXz != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.jcA = Math.abs(absListView.getChildAt(0).getTop());
                if (this.jcA > this.jcD && this.jcC <= 1) {
                    cAD();
                } else if (this.jcA < this.jcD) {
                    cAE();
                }
                this.jcD = this.jcA;
            }
            this.jcC = i;
        }
    }

    private void cAD() {
        this.iXz.a(this.fCT, Math.min(this.jcA, this.iXz.cAw()));
    }

    private void cAE() {
        if (!cAF()) {
            this.iXz.a(this.fCT, Math.min(this.jcA, this.iXz.cAw()));
        }
    }

    private boolean cAF() {
        return this.iXz.cAy() != null && this.iXz.cAy().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.iXz == null || this.iXz.cAy() == null) {
            return 0;
        }
        return (int) Math.abs(this.iXz.cAz() + this.iXz.cAy().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.iXz == null || this.iXz.cAy() == null) {
            return 0;
        }
        int height = getHeight() - this.iXz.cAz();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.iXz.cAz();
    }
}
