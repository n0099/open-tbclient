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
import com.baidu.tieba.homepage.personalize.a.f;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView Vf;
    private PbListView ePm;
    private AlphaAnimation eRA;
    private AlphaAnimation eRB;
    private View eRx;
    private g eYb;
    private m gHv;
    private com.baidu.tieba.homepage.personalize.bigday.a hHX;
    private BigdaySwipeRefreshLayout hIg;
    private ImageView hMC;
    private TextView hMD;
    private com.baidu.tieba.homepage.gamevideo.a.a hME;
    private GameVideoTitleBar hMF;
    private boolean hMG;
    private RotateAnimation hMH;
    private RotateAnimation hMI;
    private NEGFeedBackView.a hMj;
    private com.baidu.tieba.f.a hxk;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean hMJ = false;
    private boolean haF = false;
    private int gZW = 0;
    private int eNU = 0;
    private boolean mIsBackground = false;
    private boolean hMK = true;
    g.d hML = new g.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            b.this.bZf();
        }
    };
    g.b hMM = new g.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.nN(true);
            if (b.this.gHv != null && !b.this.mIsBackground && b.this.hMK) {
                b.this.gHv.a(b.this.gZW, b.this.eNU, b.this.haF, true);
            }
        }
    };
    private CustomMessageListener dlD = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.hME.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.hMK) {
                        b.this.gHv.a(b.this.gZW, b.this.eNU, b.this.haF, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener dRW = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.hxk != null) {
                b.this.hxk.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0536a gxd = new a.InterfaceC0536a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void y(int i, int i2) {
            b.this.haF = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void z(int i, int i2) {
            b.this.haF = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void A(int i, int i2) {
        }
    };
    private CustomMessageListener gZN = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bZg;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bZg = b.this.bZg()) != null && bZg.rD() != null) {
                    bZg.rD().b(new a.C0074a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.gHv != null) {
                    b.this.gHv.ct(view);
                }
                if (view.getTag() instanceof f) {
                    ((f) view.getTag()).bFB().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Vf)) {
                    b.this.blJ();
                }
                if (i == 0 && b.this.gHv != null && b.this.hMK) {
                    b.this.gHv.a(b.this.gZW, b.this.eNU, b.this.haF, 1);
                    return;
                }
                return;
            }
            b.this.blI();
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
            ca(i3, (i4 - i3) + 1);
        }

        public void ca(int i, int i2) {
            b.this.gZW = i;
            b.this.eNU = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.hMj = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.hMF = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Vf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Vf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.hxk = new com.baidu.tieba.f.a();
        this.gHv = new m(this.mPageContext, this.Vf);
        this.gHv.AY(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gHv.setUniqueId(this.mBdUniqueId);
        this.hIg = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.hHX = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.hIg.setProgressView(this.hHX);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.hIg.setCustomDistances(i, i, i * 2);
        this.ePm = new PbListView(this.mPageContext.getPageActivity());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize36);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_d));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.hME = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Vf);
        this.hME.b(this.hMj);
        this.hME.setPageUniqueId(this.mBdUniqueId);
        this.eRx = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.hMC = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.hMD = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.hMD.setText(com.baidu.tbadk.core.sharedPref.b.aNV().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aQp();
    }

    public void init() {
        this.Vf.addOnScrollListener(this.mScrollListener);
        this.Vf.setOnTouchListener(this.dRW);
        this.Vf.setRecyclerListener(this.mRecyclerListener);
        this.hxk.a(this.gxd);
        this.hHX.a(this.hML);
        this.hHX.a(this.hMM);
        this.hHX.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.dlD.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.dlD);
        this.gZN.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gZN);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.hIg.setRefreshing(true);
    }

    public void bZd() {
        if (this.Vf != null) {
            this.Vf.setSelection(0);
            blJ();
        }
    }

    public void b(g.e eVar) {
        this.hIg.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void blI() {
        if (!this.hMG) {
            this.hMG = true;
            this.eRx.setVisibility(0);
            if (this.eRA == null) {
                this.eRA = new AlphaAnimation(0.0f, 1.0f);
                this.eRA.setFillAfter(true);
                this.eRA.setDuration(300L);
            }
            this.eRx.startAnimation(this.eRA);
        }
    }

    public void blJ() {
        if (this.hMG) {
            if (this.eRB == null) {
                this.eRB = new AlphaAnimation(1.0f, 0.0f);
                this.eRB.setFillAfter(true);
                this.eRB.setDuration(300L);
                this.eRB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.eRx.setVisibility(8);
                        b.this.hMG = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eRx.startAnimation(this.eRB);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Vf != null) {
            this.Vf.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.hHX != null) {
            this.hHX.setListPullRefreshListener(cVar);
        }
    }

    public void aE(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.hME != null) {
            this.hME.setData(list);
        }
        bZe();
    }

    public void bZe() {
        if (this.gHv != null && this.hMK) {
            this.gHv.a(this.gZW, this.eNU, this.haF, true);
        }
    }

    public void bZf() {
        if (this.gHv != null) {
            this.gHv.bZf();
        }
    }

    public void nN(boolean z) {
        this.hMK = z;
    }

    public af bZg() {
        if (this.gHv == null || this.gHv.cJH() == null || !(this.gHv.cJH().getTag() instanceof af)) {
            return null;
        }
        return (af) this.gHv.cJH().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.hME != null) {
            return this.hME.getDataList();
        }
        return null;
    }

    public void bZh() {
        aE(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.eYb == null) {
                this.eYb = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.eYb.aYp();
                this.eYb.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.eYb.onChangeSkinType();
            }
            this.eYb.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.eYb == null) {
            return false;
        }
        return this.eYb.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this.mRootView);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mR(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mT(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mR(R.drawable.new_pic_emotion_03);
        this.mRefreshView.wO(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void blt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.Vf.setNextPage(this.ePm);
            }
            this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.ePm.setOnClickListener(onClickListener);
            this.ePm.endLoadData();
        }
    }

    public void blp() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.Vf.setNextPage(this.ePm);
            }
            this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.ePm.setOnClickListener(null);
            this.ePm.endLoadData();
        }
    }

    public void blq() {
        if (this.ePm != null) {
            if (this.ePm.getView().getParent() == null) {
                this.Vf.setNextPage(this.ePm);
            }
            this.ePm.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.ePm.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.ePm.setOnClickListener(null);
            this.ePm.startLoadData();
        }
    }

    public void vQ(int i) {
        if (this.hME != null) {
            this.hME.vQ(i);
        }
    }

    public void BD() {
        if (this.hME != null) {
            this.hME.notifyDataSetChanged();
        }
    }

    public void aQp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.hMC != null) {
            SvgManager.aOU().a(this.hMC, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.eYb != null) {
            this.eYb.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eYb.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.hMD != null) {
            am.setViewTextColor(this.hMD, (int) R.color.cp_cont_b);
        }
        if (this.hHX != null) {
            this.hHX.changeSkin(skinType);
        }
        if (this.hME != null) {
            this.hME.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        mC(false);
    }

    public void bXV() {
        mC(true);
    }

    public void mC(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.gHv != null) {
            this.gHv.pL(!z);
            af bZg = bZg();
            if (bZg != null && bZg.rD() != null) {
                z2 = bZg.rD().b(new a.C0074a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.gHv.bZf();
                } else if (this.hMK) {
                    this.gHv.a(this.gZW, this.eNU, this.haF, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.hME != null) {
            this.hME.onPause();
        }
    }

    public void onDestroy() {
        if (this.eYb != null) {
            this.eYb.release();
        }
        if (this.eRA != null) {
            this.eRA.cancel();
        }
        if (this.eRB != null) {
            this.eRB.cancel();
        }
        b((g.e) null);
        if (this.hHX != null) {
            this.hHX.release();
        }
        if (this.hME != null) {
            this.hME.onDestroy();
        }
        if (this.hMH != null) {
            this.hMH.cancel();
        }
        if (this.hMI != null) {
            this.hMI.cancel();
        }
        if (this.gHv != null) {
            this.gHv.destroy();
        }
        bZi();
        MessageManager.getInstance().unRegisterListener(this.gZN);
        MessageManager.getInstance().unRegisterListener(this.dlD);
    }

    private void bZi() {
        if (this.Vf != null) {
            this.Vf.removeOnScrollListener(this.mScrollListener);
            this.Vf.setOnTouchListener(null);
            this.Vf.setRecyclerListener(null);
        }
        if (this.hxk != null) {
            this.hxk.a((a.InterfaceC0536a) null);
        }
        if (this.hHX != null) {
            this.hHX.a((g.d) null);
            this.hHX.a((g.b) null);
        }
    }

    public void B(View.OnClickListener onClickListener) {
        if (this.hMC != null) {
            this.hMC.setOnClickListener(onClickListener);
        }
    }

    public View bZj() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bZk() {
        if (this.hMH == null) {
            this.hMH = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.hMH.setDuration(300L);
            this.hMH.setInterpolator(new AccelerateInterpolator());
            this.hMH.setFillAfter(true);
            this.hMH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hMC != null) {
                        SvgManager.aOU().a(b.this.hMC, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hMJ = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hMC.startAnimation(this.hMH);
    }

    public void bZl() {
        if (this.hMI == null) {
            this.hMI = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.hMI.setDuration(300L);
            this.hMI.setInterpolator(new AccelerateInterpolator());
            this.hMI.setFillAfter(true);
            this.hMI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.hMC != null) {
                        SvgManager.aOU().a(b.this.hMC, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.hMJ = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.hMC.startAnimation(this.hMI);
    }

    public boolean bZm() {
        return this.hMJ;
    }

    public void nO(boolean z) {
        this.hMJ = z;
    }

    public void nP(boolean z) {
        if (this.hMC != null) {
            this.hMC.setVisibility(0);
            if (z) {
                SvgManager.aOU().a(this.hMC, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.hMF, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aOU().a(this.hMC, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.hMF, R.color.cp_bg_line_h);
        }
    }

    public void bZn() {
        if (this.hMD != null) {
            this.hMD.setVisibility(0);
        }
    }

    public void DQ(String str) {
        if (!StringUtils.isNull(str) && this.hMD != null) {
            this.hMD.setVisibility(0);
            this.hMD.setText(str);
        }
    }

    public void DR(String str) {
        List<Integer> b = b(str, this.Vf);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Vf.l(intValue, intValue2);
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
                    if (cVar.aIw() != null && cVar.aIw().getTid().equals(str)) {
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
