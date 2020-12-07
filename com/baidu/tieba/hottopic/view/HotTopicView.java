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
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.c;
/* loaded from: classes21.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener dvn;
    private CustomMessageListener fLk;
    private CustomMessageListener fLl;
    private g gAe;
    private BdTypeListView gpX;
    private PbListView gre;
    private int iVL;
    f.c jRB;
    private c.a kbN;
    private c kbO;
    private com.baidu.tieba.hottopic.adapter.e kgL;
    private com.baidu.tieba.hottopic.controller.d kgM;
    private com.baidu.tieba.hottopic.data.e kgN;
    private int kgO;
    private View kgP;
    private int kgQ;
    private int kgR;
    private a kgS;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVL = 0;
        this.jRB = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kgM.cPh();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cRz();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kgM.rS(true);
                HotTopicView.this.gpX.completePullRefreshPostDelayed(0L);
            }
        };
        this.dvn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kgM.cRL();
                    t.csg().bPr();
                }
                if (HotTopicView.this.kbN != null) {
                    HotTopicView.this.kbN.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kgM.onScroll(i2, i3);
                if (HotTopicView.this.kbN != null) {
                    HotTopicView.this.kbN.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgN != null && HotTopicView.this.kgN.cRX() != null && HotTopicView.this.kgN.cRX().keo != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kgN.cRX().keq = true;
                            HotTopicView.this.kgL.a(HotTopicView.this.kgN);
                        }
                    }
                }
            }
        };
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgN != null && HotTopicView.this.kgN.cRX() != null && HotTopicView.this.kgN.cRX().keo != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kgN.cRX().keq = true;
                            HotTopicView.this.kgL.a(HotTopicView.this.kgN);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVL = 0;
        this.jRB = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kgM.cPh();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cRz();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kgM.rS(true);
                HotTopicView.this.gpX.completePullRefreshPostDelayed(0L);
            }
        };
        this.dvn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kgM.cRL();
                    t.csg().bPr();
                }
                if (HotTopicView.this.kbN != null) {
                    HotTopicView.this.kbN.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kgM.onScroll(i2, i3);
                if (HotTopicView.this.kbN != null) {
                    HotTopicView.this.kbN.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgN != null && HotTopicView.this.kgN.cRX() != null && HotTopicView.this.kgN.cRX().keo != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kgN.cRX().keq = true;
                            HotTopicView.this.kgL.a(HotTopicView.this.kgN);
                        }
                    }
                }
            }
        };
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgN != null && HotTopicView.this.kgN.cRX() != null && HotTopicView.this.kgN.cRX().keo != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kgN.cRX().keq = true;
                            HotTopicView.this.kgL.a(HotTopicView.this.kgN);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.iVL = 0;
        this.jRB = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kgM.cPh();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cRz();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kgM.rS(true);
                HotTopicView.this.gpX.completePullRefreshPostDelayed(0L);
            }
        };
        this.dvn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kgM.cRL();
                    t.csg().bPr();
                }
                if (HotTopicView.this.kbN != null) {
                    HotTopicView.this.kbN.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kgM.onScroll(i2, i3);
                if (HotTopicView.this.kbN != null) {
                    HotTopicView.this.kbN.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgN != null && HotTopicView.this.kgN.cRX() != null && HotTopicView.this.kgN.cRX().keo != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kgN.cRX().keq = true;
                            HotTopicView.this.kgL.a(HotTopicView.this.kgN);
                        }
                    }
                }
            }
        };
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgN != null && HotTopicView.this.kgN.cRX() != null && HotTopicView.this.kgN.cRX().keo != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kgN.cRX().keq = true;
                            HotTopicView.this.kgL.a(HotTopicView.this.kgN);
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.e<?> J = i.J(context);
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        if (this.pageContext != null) {
            this.gpX = new BdTypeListView(context);
            this.gpX.setVerticalScrollBarEnabled(false);
            this.gpX.setDividerHeight(0);
            this.gpX.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.jRB);
            this.gpX.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gpX.addFooterView(view);
            this.gpX.setOnScrollListener(this.dvn);
            this.gpX.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gpX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gpX && HotTopicView.this.kgM != null) {
                        HotTopicView.this.kgM.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.kgL = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.gpX);
            addView(this.gpX);
            ((FrameLayout.LayoutParams) this.gpX.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.kgM = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gpX);
            this.pageContext.registerListener(this.fLl);
            this.pageContext.registerListener(this.fLk);
            cSt();
            this.gre = new PbListView(context);
            this.gre.createView();
            this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gre.setLineGone();
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        }
    }

    private void cSt() {
        this.kgP = new View(getContext());
        this.kgP.setId(R.id.view_header);
        this.kgP.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gpX.addHeaderView(this.kgP, 0);
    }

    public BdTypeListView getListView() {
        return this.gpX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gF(long j) {
        if (this.kgN != null && this.kgN.cRX() != null && this.kgN.cRX().keo != null) {
            for (q qVar : this.kgN.cRX().keo) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.kgL != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.kgN = eVar;
            this.kgL.setFromCDN(eVar.cwQ());
            this.kgL.a(eVar);
            this.gpX.setVisibility(0);
            if (!y.isEmpty(eVar.cRZ())) {
                ap.setBackgroundColor(this.gpX, R.color.CAM_X0204);
            }
        }
    }

    public void rR(boolean z) {
        if (this.gpX != null) {
            this.kgM.rS(true);
            if (z) {
                this.gpX.completePullRefresh();
            } else {
                this.gpX.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ib(boolean z) {
        if (!cqy()) {
            if (this.gAe == null) {
                this.gAe = new g(getContext());
                this.gAe.setTopMargin(getLoadingViewTopMargin());
                this.gAe.bDY();
                this.gAe.onChangeSkinType();
            }
            this.gAe.attachView(this, z);
            this.gpX.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gAe != null) {
            this.gAe.dettachView(this);
            this.gAe = null;
        }
        if (!cSx() && this.kbO != null && this.kbO.cSq() != null) {
            this.gpX.smoothScrollBy((int) (-this.kbO.cSq().getY()), 1);
        }
    }

    public boolean cqy() {
        if (this.gAe != null) {
            return this.gAe.isViewAttached();
        }
        return false;
    }

    public void aR(String str, boolean z) {
        if (!cqz()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.Yb();
                            HotTopicView.this.ib(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cRz();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gpX.setVisibility(8);
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqz() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAe != null) {
            this.gAe.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.gre.changeSkin(i);
        }
        if (this.kgL != null) {
            this.kgL.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gpX, R.color.CAM_X0204);
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
        if (this.kgM != null) {
            this.kgM.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kgS);
    }

    public void resume() {
        if (this.kgM != null) {
            this.kgM.rT(false);
        }
    }

    public void pause() {
        if (this.kgM != null) {
            this.kgM.rT(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.kbN = aVar;
    }

    public void Dx(int i) {
        ViewGroup.LayoutParams layoutParams = this.kgP.getLayoutParams();
        layoutParams.height = i;
        this.kgP.setLayoutParams(layoutParams);
        cSu();
    }

    public void XZ() {
        if (this.gpX != null && this.gre != null) {
            this.gpX.setNextPage(this.gre);
            this.gre.setTextSize(R.dimen.tbfontsize33);
            this.gre.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gre.startLoadData();
        }
    }

    public void Ya() {
        if (this.gpX != null && this.gre != null) {
            if (this.iVL > 0) {
                this.gre.showEmptyView(this.iVL);
            }
            this.gpX.setNextPage(this.gre);
            this.gre.endLoadData();
            this.gre.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bTa() {
        if (this.gpX != null && this.gre != null) {
            this.gpX.setNextPage(null);
            this.gre.hideEmptyView();
        }
    }

    public void Dy(int i) {
        if (this.gpX != null) {
            this.gpX.smoothScrollBy(i, 1);
            cSu();
        }
    }

    public void setMainView(c cVar) {
        this.kbO = cVar;
    }

    public void aL(float f) {
        if (this.gpX != null && this.kgN != null && this.kgN.cRX() != null) {
            this.gpX.setSelection(0);
            this.kgS = new a((int) f);
            com.baidu.adp.lib.f.e.mY().post(this.kgS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int kgU;

        public a(int i) {
            this.kgU = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gpX.smoothScrollBy(Math.abs(this.kgU), 1);
            HotTopicView.this.cSu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSu() {
        if (cqz()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cqy()) {
            this.gAe.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.kbO != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.kgO = Math.abs(absListView.getChildAt(0).getTop());
                if (this.kgO > this.kgR && this.kgQ <= 1) {
                    cSv();
                } else if (this.kgO < this.kgR) {
                    cSw();
                }
                this.kgR = this.kgO;
            }
            this.kgQ = i;
        }
    }

    private void cSv() {
        this.kbO.a(this.gpX, Math.min(this.kgO, this.kbO.cSo()));
    }

    private void cSw() {
        if (!cSx()) {
            this.kbO.a(this.gpX, Math.min(this.kgO, this.kbO.cSo()));
        }
    }

    private boolean cSx() {
        return this.kbO.cSq() != null && this.kbO.cSq().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.kbO == null || this.kbO.cSq() == null) {
            return 0;
        }
        return (int) Math.abs(this.kbO.cSr() + this.kbO.cSq().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.kbO == null || this.kbO.cSq() == null) {
            return 0;
        }
        int height = getHeight() - this.kbO.cSr();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.kbO.cSr();
    }
}
