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
    private g gAg;
    private BdTypeListView gpZ;
    private PbListView grg;
    private int iVN;
    f.c jRD;
    private c.a kbP;
    private c kbQ;
    private com.baidu.tieba.hottopic.adapter.e kgN;
    private com.baidu.tieba.hottopic.controller.d kgO;
    private com.baidu.tieba.hottopic.data.e kgP;
    private int kgQ;
    private View kgR;
    private int kgS;
    private int kgT;
    private a kgU;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iVN = 0;
        this.jRD = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kgO.cPi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cRA();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kgO.rS(true);
                HotTopicView.this.gpZ.completePullRefreshPostDelayed(0L);
            }
        };
        this.dvn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kgO.cRM();
                    t.csh().bPs();
                }
                if (HotTopicView.this.kbP != null) {
                    HotTopicView.this.kbP.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kgO.onScroll(i2, i3);
                if (HotTopicView.this.kbP != null) {
                    HotTopicView.this.kbP.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgP != null && HotTopicView.this.kgP.cRY() != null && HotTopicView.this.kgP.cRY().keq != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kgP.cRY().kes = true;
                            HotTopicView.this.kgN.a(HotTopicView.this.kgP);
                        }
                    }
                }
            }
        };
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgP != null && HotTopicView.this.kgP.cRY() != null && HotTopicView.this.kgP.cRY().keq != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kgP.cRY().kes = true;
                            HotTopicView.this.kgN.a(HotTopicView.this.kgP);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iVN = 0;
        this.jRD = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kgO.cPi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cRA();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kgO.rS(true);
                HotTopicView.this.gpZ.completePullRefreshPostDelayed(0L);
            }
        };
        this.dvn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kgO.cRM();
                    t.csh().bPs();
                }
                if (HotTopicView.this.kbP != null) {
                    HotTopicView.this.kbP.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kgO.onScroll(i2, i3);
                if (HotTopicView.this.kbP != null) {
                    HotTopicView.this.kbP.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgP != null && HotTopicView.this.kgP.cRY() != null && HotTopicView.this.kgP.cRY().keq != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kgP.cRY().kes = true;
                            HotTopicView.this.kgN.a(HotTopicView.this.kgP);
                        }
                    }
                }
            }
        };
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgP != null && HotTopicView.this.kgP.cRY() != null && HotTopicView.this.kgP.cRY().keq != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kgP.cRY().kes = true;
                            HotTopicView.this.kgN.a(HotTopicView.this.kgP);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.iVN = 0;
        this.jRD = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kgO.cPi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cRA();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kgO.rS(true);
                HotTopicView.this.gpZ.completePullRefreshPostDelayed(0L);
            }
        };
        this.dvn = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kgO.cRM();
                    t.csh().bPs();
                }
                if (HotTopicView.this.kbP != null) {
                    HotTopicView.this.kbP.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kgO.onScroll(i2, i3);
                if (HotTopicView.this.kbP != null) {
                    HotTopicView.this.kbP.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fLl = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgP != null && HotTopicView.this.kgP.cRY() != null && HotTopicView.this.kgP.cRY().keq != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kgP.cRY().kes = true;
                            HotTopicView.this.kgN.a(HotTopicView.this.kgP);
                        }
                    }
                }
            }
        };
        this.fLk = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kgP != null && HotTopicView.this.kgP.cRY() != null && HotTopicView.this.kgP.cRY().keq != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kgP.cRY().kes = true;
                            HotTopicView.this.kgN.a(HotTopicView.this.kgP);
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
            this.gpZ = new BdTypeListView(context);
            this.gpZ.setVerticalScrollBarEnabled(false);
            this.gpZ.setDividerHeight(0);
            this.gpZ.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.jRD);
            this.gpZ.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gpZ.addFooterView(view);
            this.gpZ.setOnScrollListener(this.dvn);
            this.gpZ.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gpZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gpZ && HotTopicView.this.kgO != null) {
                        HotTopicView.this.kgO.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.kgN = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.gpZ);
            addView(this.gpZ);
            ((FrameLayout.LayoutParams) this.gpZ.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.kgO = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gpZ);
            this.pageContext.registerListener(this.fLl);
            this.pageContext.registerListener(this.fLk);
            cSu();
            this.grg = new PbListView(context);
            this.grg.createView();
            this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.grg.setLineGone();
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        }
    }

    private void cSu() {
        this.kgR = new View(getContext());
        this.kgR.setId(R.id.view_header);
        this.kgR.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gpZ.addHeaderView(this.kgR, 0);
    }

    public BdTypeListView getListView() {
        return this.gpZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gF(long j) {
        if (this.kgP != null && this.kgP.cRY() != null && this.kgP.cRY().keq != null) {
            for (q qVar : this.kgP.cRY().keq) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.kgN != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.kgP = eVar;
            this.kgN.setFromCDN(eVar.cwR());
            this.kgN.a(eVar);
            this.gpZ.setVisibility(0);
            if (!y.isEmpty(eVar.cSa())) {
                ap.setBackgroundColor(this.gpZ, R.color.CAM_X0204);
            }
        }
    }

    public void rR(boolean z) {
        if (this.gpZ != null) {
            this.kgO.rS(true);
            if (z) {
                this.gpZ.completePullRefresh();
            } else {
                this.gpZ.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ib(boolean z) {
        if (!cqz()) {
            if (this.gAg == null) {
                this.gAg = new g(getContext());
                this.gAg.setTopMargin(getLoadingViewTopMargin());
                this.gAg.bDY();
                this.gAg.onChangeSkinType();
            }
            this.gAg.attachView(this, z);
            this.gpZ.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gAg != null) {
            this.gAg.dettachView(this);
            this.gAg = null;
        }
        if (!cSy() && this.kbQ != null && this.kbQ.cSr() != null) {
            this.gpZ.smoothScrollBy((int) (-this.kbQ.cSr().getY()), 1);
        }
    }

    public boolean cqz() {
        if (this.gAg != null) {
            return this.gAg.isViewAttached();
        }
        return false;
    }

    public void aR(String str, boolean z) {
        if (!cqA()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.Yb();
                            HotTopicView.this.ib(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cRA();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gpZ.setVisibility(8);
        }
    }

    public void Yb() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cqA() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAg != null) {
            this.gAg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.grg.changeSkin(i);
        }
        if (this.kgN != null) {
            this.kgN.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.gpZ, R.color.CAM_X0204);
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
        if (this.kgO != null) {
            this.kgO.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kgU);
    }

    public void resume() {
        if (this.kgO != null) {
            this.kgO.rT(false);
        }
    }

    public void pause() {
        if (this.kgO != null) {
            this.kgO.rT(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.kbP = aVar;
    }

    public void Dx(int i) {
        ViewGroup.LayoutParams layoutParams = this.kgR.getLayoutParams();
        layoutParams.height = i;
        this.kgR.setLayoutParams(layoutParams);
        cSv();
    }

    public void XZ() {
        if (this.gpZ != null && this.grg != null) {
            this.gpZ.setNextPage(this.grg);
            this.grg.setTextSize(R.dimen.tbfontsize33);
            this.grg.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.grg.startLoadData();
        }
    }

    public void Ya() {
        if (this.gpZ != null && this.grg != null) {
            if (this.iVN > 0) {
                this.grg.showEmptyView(this.iVN);
            }
            this.gpZ.setNextPage(this.grg);
            this.grg.endLoadData();
            this.grg.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bTb() {
        if (this.gpZ != null && this.grg != null) {
            this.gpZ.setNextPage(null);
            this.grg.hideEmptyView();
        }
    }

    public void Dy(int i) {
        if (this.gpZ != null) {
            this.gpZ.smoothScrollBy(i, 1);
            cSv();
        }
    }

    public void setMainView(c cVar) {
        this.kbQ = cVar;
    }

    public void aL(float f) {
        if (this.gpZ != null && this.kgP != null && this.kgP.cRY() != null) {
            this.gpZ.setSelection(0);
            this.kgU = new a((int) f);
            com.baidu.adp.lib.f.e.mY().post(this.kgU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int kgW;

        public a(int i) {
            this.kgW = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gpZ.smoothScrollBy(Math.abs(this.kgW), 1);
            HotTopicView.this.cSv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSv() {
        if (cqA()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cqz()) {
            this.gAg.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.kbQ != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.kgQ = Math.abs(absListView.getChildAt(0).getTop());
                if (this.kgQ > this.kgT && this.kgS <= 1) {
                    cSw();
                } else if (this.kgQ < this.kgT) {
                    cSx();
                }
                this.kgT = this.kgQ;
            }
            this.kgS = i;
        }
    }

    private void cSw() {
        this.kbQ.a(this.gpZ, Math.min(this.kgQ, this.kbQ.cSp()));
    }

    private void cSx() {
        if (!cSy()) {
            this.kbQ.a(this.gpZ, Math.min(this.kgQ, this.kbQ.cSp()));
        }
    }

    private boolean cSy() {
        return this.kbQ.cSr() != null && this.kbQ.cSr().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.kbQ == null || this.kbQ.cSr() == null) {
            return 0;
        }
        return (int) Math.abs(this.kbQ.cSs() + this.kbQ.cSr().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.kbQ == null || this.kbQ.cSr() == null) {
            return 0;
        }
        int height = getHeight() - this.kbQ.cSs();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.kbQ.cSs();
    }
}
