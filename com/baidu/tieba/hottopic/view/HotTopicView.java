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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.c;
/* loaded from: classes7.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener dwK;
    private CustomMessageListener fQj;
    private CustomMessageListener fQk;
    private g gGD;
    private BdTypeListView gwr;
    private PbListView gxy;
    private int jds;
    f.c kai;
    private c.a kkw;
    private c kkx;
    private int kpA;
    private a kpB;
    private com.baidu.tieba.hottopic.adapter.d kpu;
    private com.baidu.tieba.hottopic.controller.d kpv;
    private com.baidu.tieba.hottopic.data.e kpw;
    private int kpx;
    private View kpy;
    private int kpz;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jds = 0;
        this.kai = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kpv.cOx();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cQP();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kpv.sl(true);
                HotTopicView.this.gwr.completePullRefreshPostDelayed(0L);
            }
        };
        this.dwK = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kpv.cRb();
                    s.crj().bOb();
                }
                if (HotTopicView.this.kkw != null) {
                    HotTopicView.this.kkw.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kpv.onScroll(i2, i3);
                if (HotTopicView.this.kkw != null) {
                    HotTopicView.this.kkw.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kpw != null && HotTopicView.this.kpw.cRn() != null && HotTopicView.this.kpw.cRn().kmY != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kpw.cRn().kna = true;
                            HotTopicView.this.kpu.a(HotTopicView.this.kpw);
                        }
                    }
                }
            }
        };
        this.fQj = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kpw != null && HotTopicView.this.kpw.cRn() != null && HotTopicView.this.kpw.cRn().kmY != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kpw.cRn().kna = true;
                            HotTopicView.this.kpu.a(HotTopicView.this.kpw);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jds = 0;
        this.kai = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kpv.cOx();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cQP();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kpv.sl(true);
                HotTopicView.this.gwr.completePullRefreshPostDelayed(0L);
            }
        };
        this.dwK = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kpv.cRb();
                    s.crj().bOb();
                }
                if (HotTopicView.this.kkw != null) {
                    HotTopicView.this.kkw.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kpv.onScroll(i2, i3);
                if (HotTopicView.this.kkw != null) {
                    HotTopicView.this.kkw.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kpw != null && HotTopicView.this.kpw.cRn() != null && HotTopicView.this.kpw.cRn().kmY != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kpw.cRn().kna = true;
                            HotTopicView.this.kpu.a(HotTopicView.this.kpw);
                        }
                    }
                }
            }
        };
        this.fQj = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kpw != null && HotTopicView.this.kpw.cRn() != null && HotTopicView.this.kpw.cRn().kmY != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kpw.cRn().kna = true;
                            HotTopicView.this.kpu.a(HotTopicView.this.kpw);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.jds = 0;
        this.kai = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kpv.cOx();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cQP();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kpv.sl(true);
                HotTopicView.this.gwr.completePullRefreshPostDelayed(0L);
            }
        };
        this.dwK = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kpv.cRb();
                    s.crj().bOb();
                }
                if (HotTopicView.this.kkw != null) {
                    HotTopicView.this.kkw.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kpv.onScroll(i2, i3);
                if (HotTopicView.this.kkw != null) {
                    HotTopicView.this.kkw.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fQk = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kpw != null && HotTopicView.this.kpw.cRn() != null && HotTopicView.this.kpw.cRn().kmY != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kpw.cRn().kna = true;
                            HotTopicView.this.kpu.a(HotTopicView.this.kpw);
                        }
                    }
                }
            }
        };
        this.fQj = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kpw != null && HotTopicView.this.kpw.cRn() != null && HotTopicView.this.kpw.cRn().kmY != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kpw.cRn().kna = true;
                            HotTopicView.this.kpu.a(HotTopicView.this.kpw);
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
            this.gwr = new BdTypeListView(context);
            this.gwr.setVerticalScrollBarEnabled(false);
            this.gwr.setDividerHeight(0);
            this.gwr.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.kai);
            this.gwr.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gwr.addFooterView(view);
            this.gwr.setOnScrollListener(this.dwK);
            this.gwr.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gwr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gwr && HotTopicView.this.kpv != null) {
                        HotTopicView.this.kpv.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.kpu = new com.baidu.tieba.hottopic.adapter.d(this.pageContext.getOrignalPage(), this.gwr);
            addView(this.gwr);
            ((FrameLayout.LayoutParams) this.gwr.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.kpv = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gwr);
            this.pageContext.registerListener(this.fQk);
            this.pageContext.registerListener(this.fQj);
            cRJ();
            this.gxy = new PbListView(context);
            this.gxy.createView();
            this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gxy.setLineGone();
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        }
    }

    private void cRJ() {
        this.kpy = new View(getContext());
        this.kpy.setId(R.id.view_header);
        this.kpy.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gwr.addHeaderView(this.kpy, 0);
    }

    public BdTypeListView getListView() {
        return this.gwr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gF(long j) {
        if (this.kpw != null && this.kpw.cRn() != null && this.kpw.cRn().kmY != null) {
            for (n nVar : this.kpw.cRn().kmY) {
                if (nVar != null && (nVar instanceof RelateForumItemData) && ((RelateForumItemData) nVar).forumId == j) {
                    return (RelateForumItemData) nVar;
                }
            }
        }
        return null;
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.kpu != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.kpw = eVar;
            this.kpu.setFromCDN(eVar.cvT());
            this.kpu.a(eVar);
            this.gwr.setVisibility(0);
            if (!x.isEmpty(eVar.cRp())) {
                ao.setBackgroundColor(this.gwr, R.color.CAM_X0204);
            }
        }
    }

    public void sk(boolean z) {
        if (this.gwr != null) {
            this.kpv.sl(true);
            if (z) {
                this.gwr.completePullRefresh();
            } else {
                this.gwr.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(getContext());
                this.gGD.setTopMargin(getLoadingViewTopMargin());
                this.gGD.bCA();
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this, z);
            this.gwr.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
        if (!cRN() && this.kkx != null && this.kkx.cRG() != null) {
            this.gwr.smoothScrollBy((int) (-this.kkx.cRG().getY()), 1);
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void aR(String str, boolean z) {
        if (!cpC()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.Vq();
                            HotTopicView.this.ip(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cQP();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gwr.setVisibility(8);
        }
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean cpC() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gGD != null) {
            this.gGD.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gxy.changeSkin(i);
        }
        if (this.kpu != null) {
            this.kpu.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.gwr, R.color.CAM_X0204);
        ao.setBackgroundColor(this, R.color.CAM_X0201);
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
        if (this.kpv != null) {
            this.kpv.destroy();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kpB);
    }

    public void resume() {
        if (this.kpv != null) {
            this.kpv.sm(false);
        }
    }

    public void pause() {
        if (this.kpv != null) {
            this.kpv.sm(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.kkw = aVar;
    }

    public void Cf(int i) {
        ViewGroup.LayoutParams layoutParams = this.kpy.getLayoutParams();
        layoutParams.height = i;
        this.kpy.setLayoutParams(layoutParams);
        cRK();
    }

    public void Vo() {
        if (this.gwr != null && this.gxy != null) {
            this.gwr.setNextPage(this.gxy);
            this.gxy.setTextSize(R.dimen.tbfontsize33);
            this.gxy.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gxy.startLoadData();
        }
    }

    public void Vp() {
        if (this.gwr != null && this.gxy != null) {
            if (this.jds > 0) {
                this.gxy.showEmptyView(this.jds);
            }
            this.gwr.setNextPage(this.gxy);
            this.gxy.endLoadData();
            this.gxy.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bRO() {
        if (this.gwr != null && this.gxy != null) {
            this.gwr.setNextPage(null);
            this.gxy.hideEmptyView();
        }
    }

    public void Cg(int i) {
        if (this.gwr != null) {
            this.gwr.smoothScrollBy(i, 1);
            cRK();
        }
    }

    public void setMainView(c cVar) {
        this.kkx = cVar;
    }

    public void aN(float f) {
        if (this.gwr != null && this.kpw != null && this.kpw.cRn() != null) {
            this.gwr.setSelection(0);
            this.kpB = new a((int) f);
            com.baidu.adp.lib.f.e.mB().post(this.kpB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        int kpD;

        public a(int i) {
            this.kpD = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gwr.smoothScrollBy(Math.abs(this.kpD), 1);
            HotTopicView.this.cRK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRK() {
        if (cpC()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cpB()) {
            this.gGD.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.kkx != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.kpx = Math.abs(absListView.getChildAt(0).getTop());
                if (this.kpx > this.kpA && this.kpz <= 1) {
                    cRL();
                } else if (this.kpx < this.kpA) {
                    cRM();
                }
                this.kpA = this.kpx;
            }
            this.kpz = i;
        }
    }

    private void cRL() {
        this.kkx.a(this.gwr, Math.min(this.kpx, this.kkx.cRE()));
    }

    private void cRM() {
        if (!cRN()) {
            this.kkx.a(this.gwr, Math.min(this.kpx, this.kkx.cRE()));
        }
    }

    private boolean cRN() {
        return this.kkx.cRG() != null && this.kkx.cRG().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.kkx == null || this.kkx.cRG() == null) {
            return 0;
        }
        return (int) Math.abs(this.kkx.cRH() + this.kkx.cRG().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.kkx == null || this.kkx.cRG() == null) {
            return 0;
        }
        int height = getHeight() - this.kkx.cRH();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.kkx.cRH();
    }
}
