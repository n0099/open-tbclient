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
/* loaded from: classes8.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener dBw;
    private CustomMessageListener fUQ;
    private CustomMessageListener fUR;
    private BdTypeListView gAY;
    private PbListView gCf;
    private g gLj;
    private int jhZ;
    f.c keO;
    private c.a kpb;
    private c kpc;
    private com.baidu.tieba.hottopic.adapter.d ktZ;
    private com.baidu.tieba.hottopic.controller.d kua;
    private com.baidu.tieba.hottopic.data.e kub;
    private int kuc;
    private View kud;
    private int kue;
    private int kuf;
    private a kug;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jhZ = 0;
        this.keO = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kua.cSp();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cUH();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kua.sp(true);
                HotTopicView.this.gAY.completePullRefreshPostDelayed(0L);
            }
        };
        this.dBw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kua.cUT();
                    s.cvb().bRT();
                }
                if (HotTopicView.this.kpb != null) {
                    HotTopicView.this.kpb.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kua.onScroll(i2, i3);
                if (HotTopicView.this.kpb != null) {
                    HotTopicView.this.kpb.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fUR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kub != null && HotTopicView.this.kub.cVf() != null && HotTopicView.this.kub.cVf().krD != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kub.cVf().krF = true;
                            HotTopicView.this.ktZ.a(HotTopicView.this.kub);
                        }
                    }
                }
            }
        };
        this.fUQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kub != null && HotTopicView.this.kub.cVf() != null && HotTopicView.this.kub.cVf().krD != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kub.cVf().krF = true;
                            HotTopicView.this.ktZ.a(HotTopicView.this.kub);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jhZ = 0;
        this.keO = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kua.cSp();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cUH();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kua.sp(true);
                HotTopicView.this.gAY.completePullRefreshPostDelayed(0L);
            }
        };
        this.dBw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kua.cUT();
                    s.cvb().bRT();
                }
                if (HotTopicView.this.kpb != null) {
                    HotTopicView.this.kpb.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kua.onScroll(i2, i3);
                if (HotTopicView.this.kpb != null) {
                    HotTopicView.this.kpb.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fUR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kub != null && HotTopicView.this.kub.cVf() != null && HotTopicView.this.kub.cVf().krD != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kub.cVf().krF = true;
                            HotTopicView.this.ktZ.a(HotTopicView.this.kub);
                        }
                    }
                }
            }
        };
        this.fUQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kub != null && HotTopicView.this.kub.cVf() != null && HotTopicView.this.kub.cVf().krD != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kub.cVf().krF = true;
                            HotTopicView.this.ktZ.a(HotTopicView.this.kub);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.jhZ = 0;
        this.keO = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.kua.cSp();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cUH();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.kua.sp(true);
                HotTopicView.this.gAY.completePullRefreshPostDelayed(0L);
            }
        };
        this.dBw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.kua.cUT();
                    s.cvb().bRT();
                }
                if (HotTopicView.this.kpb != null) {
                    HotTopicView.this.kpb.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.kua.onScroll(i2, i3);
                if (HotTopicView.this.kpb != null) {
                    HotTopicView.this.kpb.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fUR = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kub != null && HotTopicView.this.kub.cVf() != null && HotTopicView.this.kub.cVf().krD != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum++;
                            gF.setIsLiked(true);
                            HotTopicView.this.kub.cVf().krF = true;
                            HotTopicView.this.ktZ.a(HotTopicView.this.kub);
                        }
                    }
                }
            }
        };
        this.fUQ = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.kub != null && HotTopicView.this.kub.cVf() != null && HotTopicView.this.kub.cVf().krD != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData gF = HotTopicView.this.gF(((Long) data).longValue());
                        if (gF != null) {
                            gF.followNum--;
                            gF.setIsLiked(false);
                            HotTopicView.this.kub.cVf().krF = true;
                            HotTopicView.this.ktZ.a(HotTopicView.this.kub);
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
            this.gAY = new BdTypeListView(context);
            this.gAY.setVerticalScrollBarEnabled(false);
            this.gAY.setDividerHeight(0);
            this.gAY.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.keO);
            this.gAY.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.gAY.addFooterView(view);
            this.gAY.setOnScrollListener(this.dBw);
            this.gAY.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.gAY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.gAY && HotTopicView.this.kua != null) {
                        HotTopicView.this.kua.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.ktZ = new com.baidu.tieba.hottopic.adapter.d(this.pageContext.getOrignalPage(), this.gAY);
            addView(this.gAY);
            ((FrameLayout.LayoutParams) this.gAY.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.kua = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.gAY);
            this.pageContext.registerListener(this.fUR);
            this.pageContext.registerListener(this.fUQ);
            cVB();
            this.gCf = new PbListView(context);
            this.gCf.createView();
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
            this.gCf.setLineGone();
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        }
    }

    private void cVB() {
        this.kud = new View(getContext());
        this.kud.setId(R.id.view_header);
        this.kud.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.gAY.addHeaderView(this.kud, 0);
    }

    public BdTypeListView getListView() {
        return this.gAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData gF(long j) {
        if (this.kub != null && this.kub.cVf() != null && this.kub.cVf().krD != null) {
            for (n nVar : this.kub.cVf().krD) {
                if (nVar != null && (nVar instanceof RelateForumItemData) && ((RelateForumItemData) nVar).forumId == j) {
                    return (RelateForumItemData) nVar;
                }
            }
        }
        return null;
    }

    public void c(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.ktZ != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.kub = eVar;
            this.ktZ.setFromCDN(eVar.czL());
            this.ktZ.a(eVar);
            this.gAY.setVisibility(0);
            if (!x.isEmpty(eVar.cVh())) {
                ao.setBackgroundColor(this.gAY, R.color.CAM_X0204);
            }
        }
    }

    public void so(boolean z) {
        if (this.gAY != null) {
            this.kua.sp(true);
            if (z) {
                this.gAY.completePullRefresh();
            } else {
                this.gAY.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void it(boolean z) {
        if (!ctt()) {
            if (this.gLj == null) {
                this.gLj = new g(getContext());
                this.gLj.setTopMargin(getLoadingViewTopMargin());
                this.gLj.bGt();
                this.gLj.onChangeSkinType();
            }
            this.gLj.attachView(this, z);
            this.gAY.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gLj != null) {
            this.gLj.dettachView(this);
            this.gLj = null;
        }
        if (!cVF() && this.kpc != null && this.kpc.cVy() != null) {
            this.gAY.smoothScrollBy((int) (-this.kpc.cVy().getY()), 1);
        }
    }

    public boolean ctt() {
        if (this.gLj != null) {
            return this.gLj.isViewAttached();
        }
        return false;
    }

    public void aR(String str, boolean z) {
        if (!ctu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.Zj();
                            HotTopicView.this.it(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cUH();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.gAY.setVisibility(8);
        }
    }

    public void Zj() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean ctu() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gLj != null) {
            this.gLj.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.gCf.changeSkin(i);
        }
        if (this.ktZ != null) {
            this.ktZ.notifyDataSetChanged();
        }
        ao.setBackgroundColor(this.gAY, R.color.CAM_X0204);
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
        if (this.kua != null) {
            this.kua.destroy();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.kug);
    }

    public void resume() {
        if (this.kua != null) {
            this.kua.sq(false);
        }
    }

    public void pause() {
        if (this.kua != null) {
            this.kua.sq(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.kpb = aVar;
    }

    public void DL(int i) {
        ViewGroup.LayoutParams layoutParams = this.kud.getLayoutParams();
        layoutParams.height = i;
        this.kud.setLayoutParams(layoutParams);
        cVC();
    }

    public void Zh() {
        if (this.gAY != null && this.gCf != null) {
            this.gAY.setNextPage(this.gCf);
            this.gCf.setTextSize(R.dimen.tbfontsize33);
            this.gCf.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.gCf.startLoadData();
        }
    }

    public void Zi() {
        if (this.gAY != null && this.gCf != null) {
            if (this.jhZ > 0) {
                this.gCf.showEmptyView(this.jhZ);
            }
            this.gAY.setNextPage(this.gCf);
            this.gCf.endLoadData();
            this.gCf.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bVG() {
        if (this.gAY != null && this.gCf != null) {
            this.gAY.setNextPage(null);
            this.gCf.hideEmptyView();
        }
    }

    public void DM(int i) {
        if (this.gAY != null) {
            this.gAY.smoothScrollBy(i, 1);
            cVC();
        }
    }

    public void setMainView(c cVar) {
        this.kpc = cVar;
    }

    public void aN(float f) {
        if (this.gAY != null && this.kub != null && this.kub.cVf() != null) {
            this.gAY.setSelection(0);
            this.kug = new a((int) f);
            com.baidu.adp.lib.f.e.mB().post(this.kug);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        int kui;

        public a(int i) {
            this.kui = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.gAY.smoothScrollBy(Math.abs(this.kui), 1);
            HotTopicView.this.cVC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVC() {
        if (ctu()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (ctt()) {
            this.gLj.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.kpc != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.kuc = Math.abs(absListView.getChildAt(0).getTop());
                if (this.kuc > this.kuf && this.kue <= 1) {
                    cVD();
                } else if (this.kuc < this.kuf) {
                    cVE();
                }
                this.kuf = this.kuc;
            }
            this.kue = i;
        }
    }

    private void cVD() {
        this.kpc.a(this.gAY, Math.min(this.kuc, this.kpc.cVw()));
    }

    private void cVE() {
        if (!cVF()) {
            this.kpc.a(this.gAY, Math.min(this.kuc, this.kpc.cVw()));
        }
    }

    private boolean cVF() {
        return this.kpc.cVy() != null && this.kpc.cVy().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.kpc == null || this.kpc.cVy() == null) {
            return 0;
        }
        return (int) Math.abs(this.kpc.cVz() + this.kpc.cVy().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.kpc == null || this.kpc.cVy() == null) {
            return 0;
        }
        int height = getHeight() - this.kpc.cVz();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.kpc.cVz();
    }
}
