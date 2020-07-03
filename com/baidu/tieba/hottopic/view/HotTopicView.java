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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.view.c;
/* loaded from: classes8.dex */
public class HotTopicView extends FrameLayout {
    AbsListView.OnScrollListener cBC;
    private CustomMessageListener eJu;
    private CustomMessageListener eJv;
    private BdTypeListView fml;
    private PbListView fnt;
    private g fwo;
    private int hCr;
    private c.a iCo;
    private c iCp;
    private com.baidu.tieba.hottopic.adapter.e iHm;
    private com.baidu.tieba.hottopic.controller.d iHn;
    private com.baidu.tieba.hottopic.data.e iHo;
    private int iHp;
    private View iHq;
    private int iHr;
    private int iHs;
    private a iHt;
    f.c isc;
    private com.baidu.tbadk.core.view.g mPullView;
    private h mRefreshView;
    private TbPageContext<HotTopicActivity> pageContext;

    public HotTopicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hCr = 0;
        this.isc = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.iHn.cje();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cll();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.iHn.oL(true);
                HotTopicView.this.fml.completePullRefreshPostDelayed(0L);
            }
        };
        this.cBC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.iHn.clx();
                    s.bOA().brT();
                }
                if (HotTopicView.this.iCo != null) {
                    HotTopicView.this.iCo.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.iHn.onScroll(i2, i3);
                if (HotTopicView.this.iCo != null) {
                    HotTopicView.this.iCo.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.eJv = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iHo != null && HotTopicView.this.iHo.clJ() != null && HotTopicView.this.iHo.clJ().iEQ != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ev = HotTopicView.this.ev(((Long) data).longValue());
                        if (ev != null) {
                            ev.followNum++;
                            ev.setIsLiked(true);
                            HotTopicView.this.iHo.clJ().iES = true;
                            HotTopicView.this.iHm.a(HotTopicView.this.iHo);
                        }
                    }
                }
            }
        };
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iHo != null && HotTopicView.this.iHo.clJ() != null && HotTopicView.this.iHo.clJ().iEQ != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ev = HotTopicView.this.ev(((Long) data).longValue());
                        if (ev != null) {
                            ev.followNum--;
                            ev.setIsLiked(false);
                            HotTopicView.this.iHo.clJ().iES = true;
                            HotTopicView.this.iHm.a(HotTopicView.this.iHo);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hCr = 0;
        this.isc = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.iHn.cje();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cll();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.iHn.oL(true);
                HotTopicView.this.fml.completePullRefreshPostDelayed(0L);
            }
        };
        this.cBC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.iHn.clx();
                    s.bOA().brT();
                }
                if (HotTopicView.this.iCo != null) {
                    HotTopicView.this.iCo.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.iHn.onScroll(i2, i3);
                if (HotTopicView.this.iCo != null) {
                    HotTopicView.this.iCo.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.eJv = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iHo != null && HotTopicView.this.iHo.clJ() != null && HotTopicView.this.iHo.clJ().iEQ != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ev = HotTopicView.this.ev(((Long) data).longValue());
                        if (ev != null) {
                            ev.followNum++;
                            ev.setIsLiked(true);
                            HotTopicView.this.iHo.clJ().iES = true;
                            HotTopicView.this.iHm.a(HotTopicView.this.iHo);
                        }
                    }
                }
            }
        };
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iHo != null && HotTopicView.this.iHo.clJ() != null && HotTopicView.this.iHo.clJ().iEQ != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ev = HotTopicView.this.ev(((Long) data).longValue());
                        if (ev != null) {
                            ev.followNum--;
                            ev.setIsLiked(false);
                            HotTopicView.this.iHo.clJ().iES = true;
                            HotTopicView.this.iHm.a(HotTopicView.this.iHo);
                        }
                    }
                }
            }
        };
        init(context);
    }

    public HotTopicView(Context context) {
        super(context);
        this.hCr = 0;
        this.isc = new f.c() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (j.isNetWorkAvailable()) {
                    HotTopicView.this.iHn.cje();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_REFRESH_VIDEO));
                    ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cll();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_PAUSE_VIDEO));
                HotTopicView.this.iHn.oL(true);
                HotTopicView.this.fml.completePullRefreshPostDelayed(0L);
            }
        };
        this.cBC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (i2 == 0) {
                    HotTopicView.this.iHn.clx();
                    s.bOA().brT();
                }
                if (HotTopicView.this.iCo != null) {
                    HotTopicView.this.iCo.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                HotTopicView.this.iHn.onScroll(i2, i3);
                if (HotTopicView.this.iCo != null) {
                    HotTopicView.this.iCo.onScroll(absListView, i2, i3, i4);
                }
                HotTopicView.this.a(absListView, i2);
            }
        };
        this.eJv = new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iHo != null && HotTopicView.this.iHo.clJ() != null && HotTopicView.this.iHo.clJ().iEQ != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ev = HotTopicView.this.ev(((Long) data).longValue());
                        if (ev != null) {
                            ev.followNum++;
                            ev.setIsLiked(true);
                            HotTopicView.this.iHo.clJ().iES = true;
                            HotTopicView.this.iHm.a(HotTopicView.this.iHo);
                        }
                    }
                }
            }
        };
        this.eJu = new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.hottopic.view.HotTopicView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && HotTopicView.this.iHo != null && HotTopicView.this.iHo.clJ() != null && HotTopicView.this.iHo.clJ().iEQ != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof Long) {
                        RelateForumItemData ev = HotTopicView.this.ev(((Long) data).longValue());
                        if (ev != null) {
                            ev.followNum--;
                            ev.setIsLiked(false);
                            HotTopicView.this.iHo.clJ().iES = true;
                            HotTopicView.this.iHm.a(HotTopicView.this.iHo);
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
            this.fml = new BdTypeListView(context);
            this.fml.setVerticalScrollBarEnabled(false);
            this.fml.setDividerHeight(0);
            this.fml.setSelector(17170445);
            this.mPullView = new com.baidu.tbadk.core.view.g(this.pageContext);
            this.mPullView.setListPullRefreshListener(this.isc);
            this.fml.setPullRefresh(this.mPullView);
            View view = new View(context);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88)));
            this.fml.addFooterView(view);
            this.fml.setOnScrollListener(this.cBC);
            this.fml.setOnSrollToBottomListener(this.pageContext.getOrignalPage());
            this.fml.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (view2 == HotTopicView.this.fml && HotTopicView.this.iHn != null) {
                        HotTopicView.this.iHn.onTouch(motionEvent);
                        return false;
                    }
                    return false;
                }
            });
            this.iHm = new com.baidu.tieba.hottopic.adapter.e(this.pageContext.getOrignalPage(), this.fml);
            addView(this.fml);
            ((FrameLayout.LayoutParams) this.fml.getLayoutParams()).topMargin = getResources().getDimensionPixelOffset(R.dimen.line_magin_bottom);
            this.iHn = new com.baidu.tieba.hottopic.controller.d(this.pageContext, this.fml);
            this.pageContext.registerListener(this.eJv);
            this.pageContext.registerListener(this.eJu);
            cmh();
            this.fnt = new PbListView(context);
            this.fnt.createView();
            this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.fnt.setLineGone();
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        }
    }

    private void cmh() {
        this.iHq = new View(getContext());
        this.iHq.setId(R.id.view_header);
        this.iHq.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        this.fml.addHeaderView(this.iHq, 0);
    }

    public BdTypeListView getListView() {
        return this.fml;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData ev(long j) {
        if (this.iHo != null && this.iHo.clJ() != null && this.iHo.clJ().iEQ != null) {
            for (q qVar : this.iHo.clJ().iEQ) {
                if (qVar != null && (qVar instanceof RelateForumItemData) && ((RelateForumItemData) qVar).forumId == j) {
                    return (RelateForumItemData) qVar;
                }
            }
        }
        return null;
    }

    public void d(com.baidu.tieba.hottopic.data.e eVar) {
        if (this.iHm != null) {
            if (eVar == null) {
                eVar = new com.baidu.tieba.hottopic.data.e();
            }
            this.iHo = eVar;
            this.iHm.setFromCDN(eVar.bSZ());
            this.iHm.a(eVar);
            this.fml.setVisibility(0);
            if (!w.isEmpty(eVar.clL())) {
                an.setBackgroundColor(this.fml, R.color.cp_bg_line_c);
            }
        }
    }

    public void oK(boolean z) {
        if (this.fml != null) {
            this.iHn.oL(true);
            if (z) {
                this.fml.completePullRefresh();
            } else {
                this.fml.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ga(boolean z) {
        if (!bSQ()) {
            if (this.fwo == null) {
                this.fwo = new g(getContext());
                this.fwo.setTopMargin(getLoadingViewTopMargin());
                this.fwo.bgC();
                this.fwo.onChangeSkinType();
            }
            this.fwo.attachView(this, z);
            this.fml.setVisibility(8);
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this);
            this.fwo = null;
        }
        if (!cml() && this.iCp != null && this.iCp.cme() != null) {
            this.fml.smoothScrollBy((int) (-this.iCp.cme().getY()), 1);
        }
    }

    public boolean bSQ() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    public void aI(String str, boolean z) {
        if (!bSR()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.HotTopicView.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            HotTopicView.this.btN();
                            HotTopicView.this.ga(true);
                            ((HotTopicActivity) HotTopicView.this.pageContext.getOrignalPage()).cll();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(getTopMargin());
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.fml.setVisibility(8);
        }
    }

    public void btN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
    }

    public boolean bSR() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fwo != null) {
            this.fwo.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_d));
            this.fnt.changeSkin(i);
        }
        if (this.iHm != null) {
            this.iHm.notifyDataSetChanged();
        }
        an.setBackgroundColor(this.fml, R.color.cp_bg_line_c);
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
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
        if (this.iHn != null) {
            this.iHn.destroy();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.iHt);
    }

    public void resume() {
        if (this.iHn != null) {
            this.iHn.oM(false);
        }
    }

    public void pause() {
        if (this.iHn != null) {
            this.iHn.oM(true);
        }
    }

    public void setScrollCallback(c.a aVar) {
        this.iCo = aVar;
    }

    public void xL(int i) {
        ViewGroup.LayoutParams layoutParams = this.iHq.getLayoutParams();
        layoutParams.height = i;
        this.iHq.setLayoutParams(layoutParams);
        cmi();
    }

    public void buI() {
        if (this.fml != null && this.fnt != null) {
            this.fml.setNextPage(this.fnt);
            this.fnt.setTextSize(R.dimen.tbfontsize33);
            this.fnt.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
            this.fnt.startLoadData();
        }
    }

    public void buJ() {
        if (this.fml != null && this.fnt != null) {
            if (this.hCr > 0) {
                this.fnt.showEmptyView(this.hCr);
            }
            this.fml.setNextPage(this.fnt);
            this.fnt.endLoadData();
            this.fnt.setText(getContext().getResources().getString(R.string.list_no_more));
        }
    }

    public void buK() {
        if (this.fml != null && this.fnt != null) {
            this.fml.setNextPage(null);
            this.fnt.hideEmptyView();
        }
    }

    public void xM(int i) {
        if (this.fml != null) {
            this.fml.smoothScrollBy(i, 1);
            cmi();
        }
    }

    public void setMainView(c cVar) {
        this.iCp = cVar;
    }

    public void an(float f) {
        if (this.fml != null && this.iHo != null && this.iHo.clJ() != null) {
            this.fml.setSelection(0);
            this.iHt = new a((int) f);
            com.baidu.adp.lib.f.e.lt().post(this.iHt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        int iHv;

        public a(int i) {
            this.iHv = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            HotTopicView.this.fml.smoothScrollBy(Math.abs(this.iHv), 1);
            HotTopicView.this.cmi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmi() {
        if (bSR()) {
            this.mRefreshView.setLayoutMargin(getTopMargin());
        }
        if (bSQ()) {
            this.fwo.setTopMargin(getLoadingViewTopMargin());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AbsListView absListView, int i) {
        if (this.iCp != null) {
            if (absListView != null && absListView.getChildCount() > 0 && absListView.getChildAt(0) != null && i == 0) {
                this.iHp = Math.abs(absListView.getChildAt(0).getTop());
                if (this.iHp > this.iHs && this.iHr <= 1) {
                    cmj();
                } else if (this.iHp < this.iHs) {
                    cmk();
                }
                this.iHs = this.iHp;
            }
            this.iHr = i;
        }
    }

    private void cmj() {
        this.iCp.a(this.fml, Math.min(this.iHp, this.iCp.cmc()));
    }

    private void cmk() {
        if (!cml()) {
            this.iCp.a(this.fml, Math.min(this.iHp, this.iCp.cmc()));
        }
    }

    private boolean cml() {
        return this.iCp.cme() != null && this.iCp.cme().getY() == 0.0f;
    }

    private int getTopMargin() {
        if (this.iCp == null || this.iCp.cme() == null) {
            return 0;
        }
        return (int) Math.abs(this.iCp.cmf() + this.iCp.cme().getY());
    }

    private int getLoadingViewTopMargin() {
        if (this.iCp == null || this.iCp.cme() == null) {
            return 0;
        }
        int height = getHeight() - this.iCp.cmf();
        return ((height - l.getDimens(getContext(), R.dimen.tbds304)) / 2) + this.iCp.cmf();
    }
}
