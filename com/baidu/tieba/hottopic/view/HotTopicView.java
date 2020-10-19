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
/* loaded from: classes21.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener dbw;
    private BdTypeListView fSo;
    private PbListView fTv;
    private CustomMessageListener fpG;
    private CustomMessageListener fpH;
    private g gcx;
    private int irM;
    private com.baidu.tieba.hottopic.adapter.e jAb;
    private com.baidu.tieba.hottopic.controller.d jAc;
    private com.baidu.tieba.hottopic.data.e jAd;
    private int jAe;
    private View jAf;
    private int jAg;
    private int jAh;
    private a jAi;
    f.c jkG;
    private c.a jvd;
    private c jve;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.irM = 0;
        this.jkG = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jAc.cEF();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cGW();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jAc.qM(true);
                HotTopicView.this.fSo.completePullRefreshPostDelayed(0L);
            }
        };
        this.dbw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jAc.cHi();
                    s.ciJ().bHY();
                }
                if (HotTopicView.this.jvd != null) {
                    HotTopicView.this.jvd.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jAc.onScroll(i2, i3);
                if (HotTopicView.this.jvd != null) {
                    HotTopicView.this.jvd.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fpH = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jAd != null && HotTopicView.this.jAd.cHu() != null && HotTopicView.this.jAd.cHu().jxE != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fA = HotTopicView.this.fA(((Long) data).longValue());
                        if (fA != null) {
                            fA.followNum++;
                            fA.setIsLiked(true);
                            HotTopicView.this.jAd.cHu().jxG = true;
                            HotTopicView.this.jAb.a(HotTopicView.this.jAd);
                        }
                    }
                }
            }
        };
        this.fpG = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jAd != null && HotTopicView.this.jAd.cHu() != null && HotTopicView.this.jAd.cHu().jxE != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fA = HotTopicView.this.fA(((Long) data).longValue());
                        if (fA != null) {
                            fA.followNum--;
                            fA.setIsLiked(false);
                            HotTopicView.this.jAd.cHu().jxG = true;
                            HotTopicView.this.jAb.a(HotTopicView.this.jAd);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.irM = 0;
        this.jkG = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jAc.cEF();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cGW();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jAc.qM(true);
                HotTopicView.this.fSo.completePullRefreshPostDelayed(0L);
            }
        };
        this.dbw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jAc.cHi();
                    s.ciJ().bHY();
                }
                if (HotTopicView.this.jvd != null) {
                    HotTopicView.this.jvd.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jAc.onScroll(i2, i3);
                if (HotTopicView.this.jvd != null) {
                    HotTopicView.this.jvd.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fpH = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jAd != null && HotTopicView.this.jAd.cHu() != null && HotTopicView.this.jAd.cHu().jxE != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fA = HotTopicView.this.fA(((Long) data).longValue());
                        if (fA != null) {
                            fA.followNum++;
                            fA.setIsLiked(true);
                            HotTopicView.this.jAd.cHu().jxG = true;
                            HotTopicView.this.jAb.a(HotTopicView.this.jAd);
                        }
                    }
                }
            }
        };
        this.fpG = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jAd != null && HotTopicView.this.jAd.cHu() != null && HotTopicView.this.jAd.cHu().jxE != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fA = HotTopicView.this.fA(((Long) data).longValue());
                        if (fA != null) {
                            fA.followNum--;
                            fA.setIsLiked(false);
                            HotTopicView.this.jAd.cHu().jxG = true;
                            HotTopicView.this.jAb.a(HotTopicView.this.jAd);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.irM = 0;
        this.jkG = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.jAc.cEF();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cGW();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.jAc.qM(true);
                HotTopicView.this.fSo.completePullRefreshPostDelayed(0L);
            }
        };
        this.dbw = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.jAc.cHi();
                    s.ciJ().bHY();
                }
                if (HotTopicView.this.jvd != null) {
                    HotTopicView.this.jvd.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.jAc.onScroll(i2, i3);
                if (HotTopicView.this.jvd != null) {
                    HotTopicView.this.jvd.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.fpH = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jAd != null && HotTopicView.this.jAd.cHu() != null && HotTopicView.this.jAd.cHu().jxE != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fA = HotTopicView.this.fA(((Long) data).longValue());
                        if (fA != null) {
                            fA.followNum++;
                            fA.setIsLiked(true);
                            HotTopicView.this.jAd.cHu().jxG = true;
                            HotTopicView.this.jAb.a(HotTopicView.this.jAd);
                        }
                    }
                }
            }
        };
        this.fpG = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.jAd != null && HotTopicView.this.jAd.cHu() != null && HotTopicView.this.jAd.cHu().jxE != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData fA = HotTopicView.this.fA(((Long) data).longValue());
                        if (fA != null) {
                            fA.followNum--;
                            fA.setIsLiked(false);
                            HotTopicView.this.jAd.cHu().jxG = true;
                            HotTopicView.this.jAb.a(HotTopicView.this.jAd);
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
            this.fSo = new BdTypeListView(context);
            this.fSo.setVerticalScrollBarEnabled(false);
            this.fSo.setDividerHeight(0);
            this.fSo.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.jkG);
            this.fSo.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.fSo.addFooterView(view);
            this.fSo.setOnScrollListener(this.dbw);
            this.fSo.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.fSo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.fSo && HotTopicView.this.jAc != null) {
                        HotTopicView.this.jAc.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.jAb = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.fSo);
            addView(this.fSo);
            ((FrameLayout.LayoutParams) this.fSo.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.jAc = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.fSo);
            this.pageContext.registerListener(this.fpH);
            this.pageContext.registerListener(this.fpG);
            cHR();
            this.fTv = new PbListView(context);
            this.fTv.createView();
            this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fTv.setLineGone();
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        }
    }

    private void cHR() {
        this.jAf = new View(getContext());
        this.jAf.setId(R.id.view_header);
        this.jAf.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.fSo.addHeaderView(this.jAf, 0);
    }

    public BdTypeListView getListView() {
        return this.fSo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData fA(long j) {
        if (this.jAd != null && this.jAd.cHu() != null && this.jAd.cHu().jxE != null) {
            for (q qVar : this.jAd.cHu().jxE) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.jAb != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.jAd = eVar;
            this.jAb.setFromCDN(eVar.cnq());
            this.jAb.a(eVar);
            this.fSo.setVisibility(0);
            if (!y.isEmpty(eVar.cHw())) {
                ap.setBackgroundColor(this.fSo, R.color.cp_bg_line_c);
            }
        }
    }

    public void qL(boolean z) {
        if (this.fSo != null) {
            this.jAc.qM(true);
            if (z) {
                this.fSo.completePullRefresh();
            } else {
                this.fSo.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void hn(boolean z) {
        if (!cha()) {
            if (this.gcx == null) {
                this.gcx = new g(getContext());
                this.gcx.setTopMargin(getLoadingViewTopMargin());
                this.gcx.bwO();
                this.gcx.onChangeSkinType();
            }
            this.gcx.attachView(this, z);
            this.fSo.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.gcx != null) {
            this.gcx.dettachView(this);
            this.gcx = null;
        }
        if (!cHV() && this.jve != null && this.jve.cHO() != null) {
            this.fSo.smoothScrollBy((int) (-this.jve.cHO().getY()), 1);
        }
    }

    public boolean cha() {
        if (this.gcx != null) {
            return this.gcx.isViewAttached();
        }
        return false;
    }

    public void aO(String str, boolean z) {
        if (!chb()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.SK();
                            HotTopicView.this.hn(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cGW();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.fSo.setVisibility(8);
        }
    }

    public void SK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean chb() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gcx != null) {
            this.gcx.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.fTv.changeSkin(i);
        }
        if (this.jAb != null) {
            this.jAb.notifyDataSetChanged();
        }
        ap.setBackgroundColor(this.fSo, R.color.cp_bg_line_c);
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
        if (this.jAc != null) {
            this.jAc.destroy();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.jAi);
    }

    public void resume() {
        if (this.jAc != null) {
            this.jAc.qN(false);
        }
    }

    public void pause() {
        if (this.jAc != null) {
            this.jAc.qN(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.jvd = aVar;
    }

    public void BE(int i) {
        ViewGroup.LayoutParams layoutParams = this.jAf.getLayoutParams();
        layoutParams.height = i;
        this.jAf.setLayoutParams(layoutParams);
        cHS();
    }

    public void SI() {
        if (this.fSo != null && this.fTv != null) {
            this.fSo.setNextPage(this.fTv);
            this.fTv.setTextSize(R.dimen.tbfontsize33);
            this.fTv.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fTv.startLoadData();
        }
    }

    public void SJ() {
        if (this.fSo != null && this.fTv != null) {
            if (this.irM > 0) {
                this.fTv.showEmptyView(this.irM);
            }
            this.fSo.setNextPage(this.fTv);
            this.fTv.endLoadData();
            this.fTv.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void bKU() {
        if (this.fSo != null && this.fTv != null) {
            this.fSo.setNextPage(null);
            this.fTv.hideEmptyView();
        }
    }

    public void BF(int i) {
        if (this.fSo != null) {
            this.fSo.smoothScrollBy(i, 1);
            cHS();
        }
    }

    public void setMainView(c cVar) {
        this.jve = cVar;
    }

    public void az(float f) {
        if (this.fSo != null && this.jAd != null && this.jAd.cHu() != null) {
            this.fSo.setSelection(0);
            this.jAi = new a((int) f);
            com.baidu.adp.lib.f.e.mY().post(this.jAi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        int jAk;

        public a(int i) {
            this.jAk = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.fSo.smoothScrollBy(Math.abs(this.jAk), 1);
            HotTopicView.this.cHS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHS() {
        if (chb()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (cha()) {
            this.gcx.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.jve != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.jAe = Math.abs(absListView.getChildAt(0).getTop());
                if (this.jAe > this.jAh && this.jAg <= 1) {
                    cHT();
                } else if (this.jAe < this.jAh) {
                    cHU();
                }
                this.jAh = this.jAe;
            }
            this.jAg = i;
        }
    }

    private void cHT() {
        this.jve.a(this.fSo, Math.min(this.jAe, this.jve.cHM()));
    }

    private void cHU() {
        if (!cHV()) {
            this.jve.a(this.fSo, Math.min(this.jAe, this.jve.cHM()));
        }
    }

    private boolean cHV() {
        return this.jve.cHO() != null && this.jve.cHO().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.jve == null || this.jve.cHO() == null) {
            return 0;
        }
        return (int) Math.abs(this.jve.cHP() + this.jve.cHO().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.jve == null || this.jve.cHO() == null) {
            return 0;
        }
        int height = getHeight() - this.jve.cHP();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.jve.cHP();
    }
}
