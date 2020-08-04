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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    AbsListView.OnScrollListener cEp;
    private CustomMessageListener ePQ;
    private CustomMessageListener ePR;
    private g fBv;
    private BdTypeListView frv;
    private PbListView fsC;
    private int hIp;
    private c.a iIu;
    private c iIv;
    private a iNA;
    private com.baidu.tieba.hottopic.adapter.e iNt;
    private com.baidu.tieba.hottopic.controller.d iNu;
    private com.baidu.tieba.hottopic.data.e iNv;
    private int iNw;
    private View iNx;
    private int iNy;
    private int iNz;
    f.c iyi;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hIp = 0;
        this.iyi = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.iNu.cmG();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).coM();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.iNu.pq(true);
                HotTopicView.this.frv.completePullRefreshPostDelayed(0L);
            }
        };
        this.cEp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.iNu.coY();
                    s.bRL().bva();
                }
                if (HotTopicView.this.iIu != null) {
                    HotTopicView.this.iIu.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.iNu.onScroll(i2, i3);
                if (HotTopicView.this.iIu != null) {
                    HotTopicView.this.iIu.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iNv != null && HotTopicView.this.iNv.cpk() != null && HotTopicView.this.iNv.cpk().iKW != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eI = HotTopicView.this.eI(((Long) data).longValue());
                        if (eI != null) {
                            eI.followNum++;
                            eI.setIsLiked(true);
                            HotTopicView.this.iNv.cpk().iKY = true;
                            HotTopicView.this.iNt.a(HotTopicView.this.iNv);
                        }
                    }
                }
            }
        };
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iNv != null && HotTopicView.this.iNv.cpk() != null && HotTopicView.this.iNv.cpk().iKW != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eI = HotTopicView.this.eI(((Long) data).longValue());
                        if (eI != null) {
                            eI.followNum--;
                            eI.setIsLiked(false);
                            HotTopicView.this.iNv.cpk().iKY = true;
                            HotTopicView.this.iNt.a(HotTopicView.this.iNv);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hIp = 0;
        this.iyi = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.iNu.cmG();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).coM();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.iNu.pq(true);
                HotTopicView.this.frv.completePullRefreshPostDelayed(0L);
            }
        };
        this.cEp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.iNu.coY();
                    s.bRL().bva();
                }
                if (HotTopicView.this.iIu != null) {
                    HotTopicView.this.iIu.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.iNu.onScroll(i2, i3);
                if (HotTopicView.this.iIu != null) {
                    HotTopicView.this.iIu.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iNv != null && HotTopicView.this.iNv.cpk() != null && HotTopicView.this.iNv.cpk().iKW != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eI = HotTopicView.this.eI(((Long) data).longValue());
                        if (eI != null) {
                            eI.followNum++;
                            eI.setIsLiked(true);
                            HotTopicView.this.iNv.cpk().iKY = true;
                            HotTopicView.this.iNt.a(HotTopicView.this.iNv);
                        }
                    }
                }
            }
        };
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iNv != null && HotTopicView.this.iNv.cpk() != null && HotTopicView.this.iNv.cpk().iKW != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eI = HotTopicView.this.eI(((Long) data).longValue());
                        if (eI != null) {
                            eI.followNum--;
                            eI.setIsLiked(false);
                            HotTopicView.this.iNv.cpk().iKY = true;
                            HotTopicView.this.iNt.a(HotTopicView.this.iNv);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.hIp = 0;
        this.iyi = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.iNu.cmG();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).coM();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.iNu.pq(true);
                HotTopicView.this.frv.completePullRefreshPostDelayed(0L);
            }
        };
        this.cEp = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.iNu.coY();
                    s.bRL().bva();
                }
                if (HotTopicView.this.iIu != null) {
                    HotTopicView.this.iIu.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.iNu.onScroll(i2, i3);
                if (HotTopicView.this.iIu != null) {
                    HotTopicView.this.iIu.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.ePR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iNv != null && HotTopicView.this.iNv.cpk() != null && HotTopicView.this.iNv.cpk().iKW != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eI = HotTopicView.this.eI(((Long) data).longValue());
                        if (eI != null) {
                            eI.followNum++;
                            eI.setIsLiked(true);
                            HotTopicView.this.iNv.cpk().iKY = true;
                            HotTopicView.this.iNt.a(HotTopicView.this.iNv);
                        }
                    }
                }
            }
        };
        this.ePQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iNv != null && HotTopicView.this.iNv.cpk() != null && HotTopicView.this.iNv.cpk().iKW != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData eI = HotTopicView.this.eI(((Long) data).longValue());
                        if (eI != null) {
                            eI.followNum--;
                            eI.setIsLiked(false);
                            HotTopicView.this.iNv.cpk().iKY = true;
                            HotTopicView.this.iNt.a(HotTopicView.this.iNv);
                        }
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        com.baidu.adp.base.e<?> G = i.G(context);
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        if (this.pageContext != null) {
            this.frv = new BdTypeListView(context);
            this.frv.setVerticalScrollBarEnabled(false);
            this.frv.setDividerHeight(0);
            this.frv.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.iyi);
            this.frv.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.frv.addFooterView(view);
            this.frv.setOnScrollListener(this.cEp);
            this.frv.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.frv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.frv && HotTopicView.this.iNu != null) {
                        HotTopicView.this.iNu.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.iNt = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.frv);
            addView(this.frv);
            ((FrameLayout.LayoutParams) this.frv.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.iNu = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.frv);
            this.pageContext.registerListener(this.ePR);
            this.pageContext.registerListener(this.ePQ);
            cpI();
            this.fsC = new PbListView(context);
            this.fsC.createView();
            this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fsC.setLineGone();
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        }
    }

    private void cpI() {
        this.iNx = new View(getContext());
        this.iNx.setId(R.id.view_header);
        this.iNx.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.frv.addHeaderView(this.iNx, 0);
    }

    public BdTypeListView getListView() {
        return this.frv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData eI(long j) {
        if (this.iNv != null && this.iNv.cpk() != null && this.iNv.cpk().iKW != null) {
            for (q qVar : this.iNv.cpk().iKW) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.iNt != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.iNv = eVar;
            this.iNt.setFromCDN(eVar.bWr());
            this.iNt.a(eVar);
            this.frv.setVisibility(0);
            if (!x.isEmpty(eVar.cpm())) {
                ao.setBackgroundColor(this.frv, R.color.cp_bg_line_c);
            }
        }
    }

    public void pp(boolean z) {
        if (this.frv != null) {
            this.iNu.pq(true);
            if (z) {
                this.frv.completePullRefresh();
            } else {
                this.frv.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void gw(boolean z) {
        if (!bWi()) {
            if (this.fBv == null) {
                this.fBv = new g(getContext());
                this.fBv.setTopMargin(getLoadingViewTopMargin());
                this.fBv.bkn();
                this.fBv.onChangeSkinType();
            }
            this.fBv.attachView(this, z);
            this.frv.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this);
            this.fBv = null;
        }
        if (!cpM() && this.iIv != null && this.iIv.cpF() != null) {
            this.frv.smoothScrollBy((int) (-this.iIv.cpF().getY()), 1);
        }
    }

    public boolean bWi() {
        if (this.fBv != null) {
            return this.fBv.isViewAttached();
        }
        return false;
    }

    public void aG(String str, boolean z) {
        if (!bWj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.bwX();
                            HotTopicView.this.gw(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).coM();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.frv.setVisibility(8);
        }
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bWj() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fBv != null) {
            this.fBv.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.fsC.changeSkin(i);
        }
        if (this.iNt != null) {
            this.iNt.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.frv, R.color.cp_bg_line_c);
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
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
        if (this.iNu != null) {
            this.iNu.destroy();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iNA);
    }

    public void resume() {
        if (this.iNu != null) {
            this.iNu.pr(false);
        }
    }

    public void pause() {
        if (this.iNu != null) {
            this.iNu.pr(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.iIu = aVar;
    }

    public void yd(int i) {
        ViewGroup.LayoutParams layoutParams = this.iNx.getLayoutParams();
        layoutParams.height = i;
        this.iNx.setLayoutParams(layoutParams);
        cpJ();
    }

    public void bxS() {
        if (this.frv != null && this.fsC != null) {
            this.frv.setNextPage(this.fsC);
            this.fsC.setTextSize(R.dimen.tbfontsize33);
            this.fsC.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fsC.startLoadData();
        }
    }

    public void bxT() {
        if (this.frv != null && this.fsC != null) {
            if (this.hIp > 0) {
                this.fsC.showEmptyView(this.hIp);
            }
            this.frv.setNextPage(this.fsC);
            this.fsC.endLoadData();
            this.fsC.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bxU() {
        if (this.frv != null && this.fsC != null) {
            this.frv.setNextPage(null);
            this.fsC.hideEmptyView();
        }
    }

    public void ye(int i) {
        if (this.frv != null) {
            this.frv.smoothScrollBy(i, 1);
            cpJ();
        }
    }

    public void setMainView(c cVar) {
        this.iIv = cVar;
    }

    public void an(float f) {
        if (this.frv != null && this.iNv != null && this.iNv.cpk() != null) {
            this.frv.setSelection(0);
            this.iNA = new a((int) f);
            com.baidu.adp.lib.f.e.lt().post(this.iNA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a implements Runnable {
        int iNC;

        public a(int i) {
            this.iNC = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.frv.smoothScrollBy(Math.abs(this.iNC), 1);
            HotTopicView.this.cpJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpJ() {
        if (bWj()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (bWi()) {
            this.fBv.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.iIv != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.iNw = Math.abs(absListView.getChildAt(0).getTop());
                if (this.iNw > this.iNz && this.iNy <= 1) {
                    cpK();
                } else if (this.iNw < this.iNz) {
                    cpL();
                }
                this.iNz = this.iNw;
            }
            this.iNy = i;
        }
    }

    private void cpK() {
        this.iIv.a(this.frv, Math.min(this.iNw, this.iIv.cpD()));
    }

    private void cpL() {
        if (!cpM()) {
            this.iIv.a(this.frv, Math.min(this.iNw, this.iIv.cpD()));
        }
    }

    private boolean cpM() {
        return this.iIv.cpF() != null && this.iIv.cpF().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.iIv == null || this.iIv.cpF() == null) {
            return 0;
        }
        return (int) Math.abs(this.iIv.cpG() + this.iIv.cpF().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.iIv == null || this.iIv.cpF() == null) {
            return 0;
        }
        int height = getHeight() - this.iIv.cpG();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.iIv.cpG();
    }
}
