package com.baidu.tieba.homepage.gamevideo.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.a.d;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView BK;
    private PbListView elj;
    private View enu;
    private AlphaAnimation eny;
    private AlphaAnimation enz;
    private g etX;
    private com.baidu.tieba.f.a gMq;
    private com.baidu.tieba.homepage.personalize.bigday.a gWN;
    private BigdaySwipeRefreshLayout gWW;
    private m gqC;
    private NEGFeedBackView.a haZ;
    private ImageView hbs;
    private TextView hbt;
    private com.baidu.tieba.homepage.gamevideo.a.a hbu;
    private GameVideoTitleBar hbv;
    private boolean hbw;
    private RotateAnimation hbx;
    private RotateAnimation hby;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean hbz = false;
    private boolean gqv = false;
    private int gpQ = 0;
    private int ejR = 0;
    private boolean mIsBackground = false;
    private boolean hbA = true;
    g.d hbB = new g.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            b.this.bOp();
        }
    };
    g.b hbC = new g.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.mD(true);
            if (b.this.gqC != null && !b.this.mIsBackground && b.this.hbA) {
                b.this.gqC.a(b.this.gpQ, b.this.ejR, b.this.gqv, true);
            }
        }
    };
    private CustomMessageListener cMl = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.hbu.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.hbA) {
                        b.this.gqC.a(b.this.gpQ, b.this.ejR, b.this.gqv, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener drA = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.gMq != null) {
                b.this.gMq.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0499a fRz = new a.InterfaceC0499a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void z(int i, int i2) {
            b.this.gqv = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void A(int i, int i2) {
            b.this.gqv = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0499a
        public void B(int i, int i2) {
        }
    };
    private CustomMessageListener gpI = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bOq;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bOq = b.this.bOq()) != null && bOq.nk() != null) {
                    bOq.nk().b(new a.C0052a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.gqC != null) {
                    b.this.gqC.cl(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).bvK().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.BK)) {
                    b.this.bcN();
                }
                if (i == 0 && b.this.gqC != null && b.this.hbA) {
                    b.this.gqC.a(b.this.gpQ, b.this.ejR, b.this.gqv, 1);
                    return;
                }
                return;
            }
            b.this.bcM();
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            int i4 = 0;
            if (recyclerView == null || !(recyclerView instanceof BdRecyclerView)) {
                i3 = 0;
            } else {
                i3 = ((BdRecyclerView) recyclerView).getFirstVisiblePosition();
                i4 = ((BdRecyclerView) recyclerView).getLastVisiblePosition();
            }
            bT(i3, (i4 - i3) + 1);
        }

        public void bT(int i, int i2) {
            b.this.gpQ = i;
            b.this.ejR = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.haZ = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hbv = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gMq = new com.baidu.tieba.f.a();
        this.gqC = new m(this.mPageContext, this.BK);
        this.gqC.Aq(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gqC.setUniqueId(this.mBdUniqueId);
        this.gWW = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gWN = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gWW.setProgressView(this.gWN);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gWW.setCustomDistances(i, i, i * 2);
        this.elj = new PbListView(this.mPageContext.getPageActivity());
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize36);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_d));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elj.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hbu = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.BK);
        this.hbu.b(this.haZ);
        this.hbu.setPageUniqueId(this.mBdUniqueId);
        this.enu = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.hbs = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.hbt = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.hbt.setText(com.baidu.tbadk.core.sharedPref.b.aFD().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aHN();
    }

    public void init() {
        this.BK.addOnScrollListener(this.mScrollListener);
        this.BK.setOnTouchListener(this.drA);
        this.BK.setRecyclerListener(this.mRecyclerListener);
        this.gMq.a(this.fRz);
        this.gWN.a(this.hbB);
        this.gWN.a(this.hbC);
        this.gWN.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cMl.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cMl);
        this.gpI.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gpI);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.gWW.setRefreshing(true);
    }

    public void bOn() {
        if (this.BK != null) {
            this.BK.setSelection(0);
            bcN();
        }
    }

    public void b(g.e eVar) {
        this.gWW.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bcM() {
        if (!this.hbw) {
            this.hbw = true;
            this.enu.setVisibility(0);
            if (this.eny == null) {
                this.eny = new AlphaAnimation(0.0f, 1.0f);
                this.eny.setFillAfter(true);
                this.eny.setDuration(300L);
            }
            this.enu.startAnimation(this.eny);
        }
    }

    public void bcN() {
        if (this.hbw) {
            if (this.enz == null) {
                this.enz = new AlphaAnimation(1.0f, 0.0f);
                this.enz.setFillAfter(true);
                this.enz.setDuration(300L);
                this.enz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.enu.setVisibility(8);
                        b.this.hbw = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.enu.startAnimation(this.enz);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.BK != null) {
            this.BK.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gWN != null) {
            this.gWN.setListPullRefreshListener(cVar);
        }
    }

    public void av(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hbu != null) {
            this.hbu.setData(list);
        }
        bOo();
    }

    public void bOo() {
        if (this.gqC != null && this.hbA) {
            this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
        }
    }

    public void bOp() {
        if (this.gqC != null) {
            this.gqC.bOp();
        }
    }

    public void mD(boolean z) {
        this.hbA = z;
    }

    public af bOq() {
        if (this.gqC == null || this.gqC.cyI() == null || !(this.gqC.cyI().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gqC.cyI().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.hbu != null) {
            return this.hbu.getDataList();
        }
        return null;
    }

    public void bOr() {
        av(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.etX == null) {
                this.etX = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.etX.aPT();
                this.etX.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.etX.onChangeSkinType();
            }
            this.etX.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.etX == null) {
            return false;
        }
        return this.etX.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.etX != null) {
            this.etX.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mE(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mG(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mE(R.drawable.new_pic_emotion_03);
        this.mRefreshView.vy(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void bcx() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.BK.setNextPage(this.elj);
            }
            this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elj.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.elj.setOnClickListener(onClickListener);
            this.elj.endLoadData();
        }
    }

    public void bct() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.BK.setNextPage(this.elj);
            }
            this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elj.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.elj.setOnClickListener(null);
            this.elj.endLoadData();
        }
    }

    public void bcu() {
        if (this.elj != null) {
            if (this.elj.getView().getParent() == null) {
                this.BK.setNextPage(this.elj);
            }
            this.elj.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.elj.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.elj.setOnClickListener(null);
            this.elj.startLoadData();
        }
    }

    public void vl(int i) {
        if (this.hbu != null) {
            this.hbu.vl(i);
        }
    }

    public void wN() {
        if (this.hbu != null) {
            this.hbu.notifyDataSetChanged();
        }
    }

    public void aHN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.hbs != null) {
            SvgManager.aGC().a(this.hbs, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.etX != null) {
            this.etX.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.etX.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hbt != null) {
            am.setViewTextColor(this.hbt, (int) R.color.cp_cont_b);
        }
        if (this.gWN != null) {
            this.gWN.changeSkin(skinType);
        }
        if (this.hbu != null) {
            this.hbu.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        lt(false);
    }

    public void bNf() {
        lt(true);
    }

    public void lt(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gqC != null) {
            this.gqC.oB(!z);
            af bOq = bOq();
            if (bOq != null && bOq.nk() != null) {
                z2 = bOq.nk().b(new a.C0052a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gqC.bOp();
                } else if (this.hbA) {
                    this.gqC.a(this.gpQ, this.ejR, this.gqv, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.hbu != null) {
            this.hbu.onPause();
        }
    }

    public void onDestroy() {
        if (this.etX != null) {
            this.etX.release();
        }
        if (this.eny != null) {
            this.eny.cancel();
        }
        if (this.enz != null) {
            this.enz.cancel();
        }
        b((g.e) null);
        if (this.gWN != null) {
            this.gWN.release();
        }
        if (this.hbu != null) {
            this.hbu.onDestroy();
        }
        if (this.hbx != null) {
            this.hbx.cancel();
        }
        if (this.hby != null) {
            this.hby.cancel();
        }
        if (this.gqC != null) {
            this.gqC.destroy();
        }
        bOs();
        MessageManager.getInstance().unRegisterListener(this.gpI);
        MessageManager.getInstance().unRegisterListener(this.cMl);
    }

    private void bOs() {
        if (this.BK != null) {
            this.BK.removeOnScrollListener(this.mScrollListener);
            this.BK.setOnTouchListener(null);
            this.BK.setRecyclerListener(null);
        }
        if (this.gMq != null) {
            this.gMq.a((a.InterfaceC0499a) null);
        }
        if (this.gWN != null) {
            this.gWN.a((g.d) null);
            this.gWN.a((g.b) null);
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.hbs != null) {
            this.hbs.setOnClickListener(onClickListener);
        }
    }

    public View bOt() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bOu() {
        if (this.hbx == null) {
            this.hbx = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.hbx.setDuration(300L);
            this.hbx.setInterpolator(new AccelerateInterpolator());
            this.hbx.setFillAfter(true);
            this.hbx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hbs != null) {
                        SvgManager.aGC().a(b.this.hbs, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hbz = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hbs.startAnimation(this.hbx);
    }

    public void bOv() {
        if (this.hby == null) {
            this.hby = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.hby.setDuration(300L);
            this.hby.setInterpolator(new AccelerateInterpolator());
            this.hby.setFillAfter(true);
            this.hby.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hbs != null) {
                        SvgManager.aGC().a(b.this.hbs, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hbz = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hbs.startAnimation(this.hby);
    }

    public boolean bOw() {
        return this.hbz;
    }

    public void mE(boolean z) {
        this.hbz = z;
    }

    public void mF(boolean z) {
        if (this.hbs != null) {
            this.hbs.setVisibility(0);
            if (z) {
                SvgManager.aGC().a(this.hbs, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.hbv, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aGC().a(this.hbs, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.hbv, R.color.cp_bg_line_h);
        }
    }

    public void bOx() {
        if (this.hbt != null) {
            this.hbt.setVisibility(0);
        }
    }

    public void Ch(String str) {
        if (!StringUtils.isNull(str) && this.hbt != null) {
            this.hbt.setVisibility(0);
            this.hbt.setText(str);
        }
    }

    public void Ci(String str) {
        List<Integer> b = b(str, this.BK);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.BK.m(intValue, intValue2);
        }
    }

    private List<Integer> b(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        int i = 0;
        ArrayList arrayList = new ArrayList(2);
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            int i4 = i;
            if (i4 < bdTypeRecyclerView.getCount()) {
                com.baidu.adp.widget.ListView.m item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.aAg() != null && cVar.aAg().getTid().equals(str)) {
                        if (!z) {
                            i3 = i4;
                        }
                        z = true;
                        i2 = i4;
                    }
                }
                i = i4 + 1;
            } else {
                arrayList.add(Integer.valueOf(i3));
                arrayList.add(Integer.valueOf(i2));
                return arrayList;
            }
        }
    }
}
