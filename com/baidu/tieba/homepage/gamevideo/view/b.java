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
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.a.a;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.c;
import com.baidu.tieba.f.a;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.play.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private BdTypeRecyclerView Xe;
    private PbListView gjo;
    private View glJ;
    private AlphaAnimation glM;
    private AlphaAnimation glN;
    private g gso;
    private i iqn;
    private ImageView jAS;
    private TextView jAT;
    private com.baidu.tieba.homepage.gamevideo.a.a jAU;
    private GameVideoTitleBar jAV;
    private boolean jAW;
    private RotateAnimation jAX;
    private RotateAnimation jAY;
    private NEGFeedBackView.a jAz;
    private com.baidu.tieba.f.a jiW;
    private BigdaySwipeRefreshLayout jvC;
    private com.baidu.tieba.homepage.personalize.bigday.a jvt;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean jAZ = false;
    private boolean iKg = false;
    private int iJw = 0;
    private int ghW = 0;
    private boolean mIsBackground = false;
    private boolean jBa = true;
    f.d jBb = new f.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.f.d
        public void onListPullToRefresh(boolean z) {
            b.this.cKn();
        }
    };
    f.b jBc = new f.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.qV(true);
            if (b.this.iqn != null && !b.this.mIsBackground && b.this.jBa) {
                b.this.iqn.a(b.this.iJw, b.this.ghW, b.this.iKg, true);
            }
        }
    };
    private CustomMessageListener eyc = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.jAU.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.jBa) {
                        b.this.iqn.a(b.this.iJw, b.this.ghW, b.this.iKg, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener fzb = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.jiW != null) {
                b.this.jiW.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0719a igd = new a.InterfaceC0719a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void H(int i, int i2) {
            b.this.iKg = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void I(int i, int i2) {
            b.this.iKg = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0719a
        public void J(int i, int i2) {
        }
    };
    private CustomMessageListener iJd = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            am cKo;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (cKo = b.this.cKo()) != null && cKo.tW() != null) {
                    cKo.tW().b(new a.C0097a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.iqn != null) {
                    b.this.iqn.da(view);
                }
                if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.g) {
                    ((com.baidu.tieba.homepage.personalize.a.g) view.getTag()).coY().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Xe)) {
                    b.this.bPr();
                }
                if (i == 0 && b.this.iqn != null && b.this.jBa) {
                    b.this.iqn.a(b.this.iJw, b.this.ghW, b.this.iKg, 1);
                    return;
                }
                return;
            }
            b.this.bPq();
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
            cD(i3, (i4 - i3) + 1);
        }

        public void cD(int i, int i2) {
            b.this.iJw = i;
            b.this.ghW = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.jAz = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.jAV = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.jiW = new com.baidu.tieba.f.a();
        this.iqn = new i(this.mPageContext, this.Xe);
        this.iqn.Ht(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.iqn.setUniqueId(this.mBdUniqueId);
        this.jvC = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.jvt = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.jvC.setProgressView(this.jvt);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.jvC.setCustomDistances(i, i, i * 2);
        this.gjo = new PbListView(this.mPageContext.getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize36);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.jAU = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Xe);
        this.jAU.b(this.jAz);
        this.jAU.setPageUniqueId(this.mBdUniqueId);
        this.glJ = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.jAS = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.jAT = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.jAT.setText(com.baidu.tbadk.core.sharedPref.b.bqh().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        bsD();
    }

    public void init() {
        this.Xe.addOnScrollListener(this.mScrollListener);
        this.Xe.setOnTouchListener(this.fzb);
        this.Xe.setRecyclerListener(this.mRecyclerListener);
        this.jiW.a(this.igd);
        this.jvt.a(this.jBb);
        this.jvt.a(this.jBc);
        this.jvt.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.eyc.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.eyc);
        this.iJd.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.iJd);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.jvC.setRefreshing(true);
    }

    public void cKl() {
        if (this.Xe != null) {
            this.Xe.setSelection(0);
            bPr();
        }
    }

    public void b(f.e eVar) {
        this.jvC.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void bPq() {
        if (!this.jAW) {
            this.jAW = true;
            this.glJ.setVisibility(0);
            if (this.glM == null) {
                this.glM = new AlphaAnimation(0.0f, 1.0f);
                this.glM.setFillAfter(true);
                this.glM.setDuration(300L);
            }
            this.glJ.startAnimation(this.glM);
        }
    }

    public void bPr() {
        if (this.jAW) {
            if (this.glN == null) {
                this.glN = new AlphaAnimation(1.0f, 0.0f);
                this.glN.setFillAfter(true);
                this.glN.setDuration(300L);
                this.glN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.glJ.setVisibility(8);
                        b.this.jAW = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.glJ.startAnimation(this.glN);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Xe != null) {
            this.Xe.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        if (this.jvt != null) {
            this.jvt.setListPullRefreshListener(cVar);
        }
    }

    public void bi(List<q> list) {
        if (this.jAU != null) {
            this.jAU.setData(list);
        }
        cKm();
    }

    public void cKm() {
        if (this.iqn != null && this.jBa) {
            this.iqn.a(this.iJw, this.ghW, this.iKg, true);
        }
    }

    public void cKn() {
        if (this.iqn != null) {
            this.iqn.cKn();
        }
    }

    public void qV(boolean z) {
        this.jBa = z;
    }

    public am cKo() {
        if (this.iqn == null || this.iqn.dwW() == null || !(this.iqn.dwW().getTag() instanceof am)) {
            return null;
        }
        return (am) this.iqn.dwW().getTag();
    }

    public List<q> getDataList() {
        if (this.jAU != null) {
            return this.jAU.getDataList();
        }
        return null;
    }

    public void cKp() {
        bi(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.gso == null) {
                this.gso = new g(this.mPageContext.getPageActivity());
                this.gso.bBg();
                this.gso.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.gso.onChangeSkinType();
            }
            this.gso.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.gso == null) {
            return false;
        }
        return this.gso.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.gso != null) {
            this.gso.dettachView(this.mRootView);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.rD(R.drawable.new_pic_emotion_08);
        this.mRefreshView.rF(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.rD(R.drawable.new_pic_emotion_03);
        this.mRefreshView.Ed(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void Wk() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void C(View.OnClickListener onClickListener) {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.Xe.setNextPage(this.gjo);
            }
            this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.gjo.setOnClickListener(onClickListener);
            this.gjo.endLoadData();
        }
    }

    public void bOW() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.Xe.setNextPage(this.gjo);
            }
            this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.gjo.setOnClickListener(null);
            this.gjo.endLoadData();
        }
    }

    public void bOX() {
        if (this.gjo != null) {
            if (this.gjo.getView().getParent() == null) {
                this.Xe.setNextPage(this.gjo);
            }
            this.gjo.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.gjo.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.gjo.setOnClickListener(null);
            this.gjo.startLoadData();
        }
    }

    public void BD(int i) {
        if (this.jAU != null) {
            this.jAU.BD(i);
        }
    }

    public void LZ() {
        if (this.jAU != null) {
            this.jAU.notifyDataSetChanged();
        }
    }

    public void bsD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.jAS != null) {
            SvgManager.brn().a(this.jAS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.gso != null) {
            this.gso.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.gso.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.jAT != null) {
            ap.setViewTextColor(this.jAT, R.color.cp_cont_b);
        }
        if (this.jvt != null) {
            this.jvt.changeSkin(skinType);
        }
        if (this.jAU != null) {
            this.jAU.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        pF(false);
    }

    public void cIG() {
        pF(true);
    }

    public void pF(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.iqn != null) {
            this.iqn.sX(!z);
            am cKo = cKo();
            if (cKo != null && cKo.tW() != null) {
                z2 = cKo.tW().b(new a.C0097a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.iqn.cKn();
                } else if (this.jBa) {
                    this.iqn.a(this.iJw, this.ghW, this.iKg, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.jAU != null) {
            this.jAU.onPause();
        }
    }

    public void onDestroy() {
        if (this.gso != null) {
            this.gso.release();
        }
        if (this.glM != null) {
            this.glM.cancel();
        }
        if (this.glN != null) {
            this.glN.cancel();
        }
        b((f.e) null);
        if (this.jvt != null) {
            this.jvt.release();
        }
        if (this.jAU != null) {
            this.jAU.onDestroy();
        }
        if (this.jAX != null) {
            this.jAX.cancel();
        }
        if (this.jAY != null) {
            this.jAY.cancel();
        }
        if (this.iqn != null) {
            this.iqn.destroy();
        }
        cKq();
        MessageManager.getInstance().unRegisterListener(this.iJd);
        MessageManager.getInstance().unRegisterListener(this.eyc);
    }

    private void cKq() {
        if (this.Xe != null) {
            this.Xe.removeOnScrollListener(this.mScrollListener);
            this.Xe.setOnTouchListener(null);
            this.Xe.setRecyclerListener(null);
        }
        if (this.jiW != null) {
            this.jiW.a((a.InterfaceC0719a) null);
        }
        if (this.jvt != null) {
            this.jvt.a((f.d) null);
            this.jvt.a((f.b) null);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        if (this.jAS != null) {
            this.jAS.setOnClickListener(onClickListener);
        }
    }

    public View cKr() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void cKs() {
        if (this.jAX == null) {
            this.jAX = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.jAX.setDuration(300L);
            this.jAX.setInterpolator(new AccelerateInterpolator());
            this.jAX.setFillAfter(true);
            this.jAX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jAS != null) {
                        SvgManager.brn().a(b.this.jAS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jAZ = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jAS.startAnimation(this.jAX);
    }

    public void cKt() {
        if (this.jAY == null) {
            this.jAY = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.jAY.setDuration(300L);
            this.jAY.setInterpolator(new AccelerateInterpolator());
            this.jAY.setFillAfter(true);
            this.jAY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.jAS != null) {
                        SvgManager.brn().a(b.this.jAS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.jAZ = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.jAS.startAnimation(this.jAY);
    }

    public boolean cKu() {
        return this.jAZ;
    }

    public void qW(boolean z) {
        this.jAZ = z;
    }

    public void qX(boolean z) {
        if (this.jAS != null) {
            this.jAS.setVisibility(0);
            if (z) {
                SvgManager.brn().a(this.jAS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                ap.setBackgroundResource(this.jAV, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.brn().a(this.jAS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            ap.setBackgroundResource(this.jAV, R.color.cp_bg_line_h);
        }
    }

    public void cKv() {
        if (this.jAT != null) {
            this.jAT.setVisibility(0);
        }
    }

    public void LM(String str) {
        if (!StringUtils.isNull(str) && this.jAT != null) {
            this.jAT.setVisibility(0);
            this.jAT.setText(str);
        }
    }

    public void LN(String str) {
        List<Integer> b = b(str, this.Xe);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Xe.o(intValue, intValue2);
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
                q item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof c) {
                    c cVar = (c) item;
                    if (cVar.bjZ() != null && cVar.bjZ().getTid().equals(str)) {
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
