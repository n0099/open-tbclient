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
/* loaded from: classes6.dex */
public class b {
    private BdTypeRecyclerView Bn;
    private PbListView egU;
    private AlphaAnimation eiA;
    private View eiw;
    private AlphaAnimation eiz;
    private g eoy;
    private com.baidu.tieba.f.a gHa;
    private com.baidu.tieba.homepage.personalize.bigday.a gRq;
    private BigdaySwipeRefreshLayout gRz;
    private ImageView gVS;
    private TextView gVT;
    private com.baidu.tieba.homepage.gamevideo.a.a gVU;
    private GameVideoTitleBar gVV;
    private boolean gVW;
    private RotateAnimation gVX;
    private RotateAnimation gVY;
    private NEGFeedBackView.a gVz;
    private m glq;
    private BdUniqueId mBdUniqueId;
    private FrameLayout mContentLayout;
    private TbPageContext mPageContext;
    private h mRefreshView;
    private View mRootView;
    private boolean gVZ = false;
    private boolean glj = false;
    private int gkE = 0;
    private int efC = 0;
    private boolean mIsBackground = false;
    private boolean gWa = true;
    g.d gWb = new g.d() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.1
        @Override // com.baidu.tbadk.core.view.g.d
        public void onListPullToRefresh(boolean z) {
            b.this.bLD();
        }
    };
    g.b gWc = new g.b() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void onListPullRefreshFinished(View view, boolean z) {
            b.this.mq(true);
            if (b.this.glq != null && !b.this.mIsBackground && b.this.gWa) {
                b.this.glq.a(b.this.gkE, b.this.efC, b.this.glj, true);
            }
        }
    };
    private CustomMessageListener cHV = new CustomMessageListener(2921420) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.5.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.gVU.notifyDataSetChanged();
                    if (!b.this.mIsBackground && b.this.gWa) {
                        b.this.glq.a(b.this.gkE, b.this.efC, b.this.glj, true);
                    }
                }
            }, 500L);
        }
    };
    private View.OnTouchListener dne = new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.6
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (b.this.gHa != null) {
                b.this.gHa.onTouchEvent(motionEvent);
                return false;
            }
            return false;
        }
    };
    private a.InterfaceC0488a fLT = new a.InterfaceC0488a() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.7
        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void u(int i, int i2) {
            b.this.glj = false;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void v(int i, int i2) {
            b.this.glj = true;
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void bA(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0488a
        public void w(int i, int i2) {
        }
    };
    private CustomMessageListener gkw = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.homepage.gamevideo.view.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            af bLE;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (bLE = b.this.bLE()) != null && bLE.mT() != null) {
                    bLE.mT().b(new a.C0050a(3));
                }
            }
        }
    };
    private RecyclerView.RecyclerListener mRecyclerListener = new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.9
        @Override // android.support.v7.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view;
            if (viewHolder != null && (view = viewHolder.itemView) != null) {
                if (b.this.glq != null) {
                    b.this.glq.cg(view);
                }
                if (view.getTag() instanceof d) {
                    ((d) view.getTag()).btc().stopPlay();
                }
            }
        }
    };
    private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.10
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i != 1) {
                if (b.this.a(b.this.Bn)) {
                    b.this.aZX();
                }
                if (i == 0 && b.this.glq != null && b.this.gWa) {
                    b.this.glq.a(b.this.gkE, b.this.efC, b.this.glj, 1);
                    return;
                }
                return;
            }
            b.this.aZW();
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
            b.this.gkE = i;
            b.this.efC = (i + i2) - 1;
        }
    };

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, NEGFeedBackView.a aVar) {
        this.mPageContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.gVz = aVar;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.game_video_main_view_layout, (ViewGroup) null);
        this.mRootView.setPadding(0, 0, 0, TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gVV = (GameVideoTitleBar) this.mRootView.findViewById(R.id.game_video_title_bar);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(R.id.game_video_framelayout);
        this.Bn = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.game_video_recycle_view);
        this.Bn.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        this.gHa = new com.baidu.tieba.f.a();
        this.glq = new m(this.mPageContext, this.Bn);
        this.glq.Ac(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.glq.setUniqueId(this.mBdUniqueId);
        this.gRz = (BigdaySwipeRefreshLayout) this.mRootView.findViewById(R.id.game_video_refresh_layout);
        this.gRq = new com.baidu.tieba.homepage.personalize.bigday.a(this.mPageContext);
        this.gRz.setProgressView(this.gRq);
        int i = (int) (86.0f * this.mPageContext.getResources().getDisplayMetrics().density);
        this.gRz.setCustomDistances(i, i, i * 2);
        this.egU = new PbListView(this.mPageContext.getPageActivity());
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize36);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_d));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.egU.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.gVU = new com.baidu.tieba.homepage.gamevideo.a.a(this.mPageContext, this.Bn);
        this.gVU.b(this.gVz);
        this.gVU.setPageUniqueId(this.mBdUniqueId);
        this.eiw = this.mRootView.findViewById(R.id.game_video_divider_shadow);
        this.gVS = (ImageView) this.mRootView.findViewById(R.id.game_video_select_icon);
        this.gVT = (TextView) this.mRootView.findViewById(R.id.game_video_game_title);
        this.gVT.setText(com.baidu.tbadk.core.sharedPref.b.aCY().getString("key_game_video_tab_has_choosed_sub_class_name", ""));
        aFd();
    }

    public void init() {
        this.Bn.addOnScrollListener(this.mScrollListener);
        this.Bn.setOnTouchListener(this.dne);
        this.Bn.setRecyclerListener(this.mRecyclerListener);
        this.gHa.a(this.fLT);
        this.gRq.a(this.gWb);
        this.gRq.a(this.gWc);
        this.gRq.setTag(this.mPageContext.getUniqueId());
        registerListener();
    }

    private void registerListener() {
        this.cHV.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.cHV);
        this.gkw.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.gkw);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void startPullRefresh() {
        this.gRz.setRefreshing(true);
    }

    public void bLB() {
        if (this.Bn != null) {
            this.Bn.setSelection(0);
            aZX();
        }
    }

    public void b(g.e eVar) {
        this.gRz.c(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void aZW() {
        if (!this.gVW) {
            this.gVW = true;
            this.eiw.setVisibility(0);
            if (this.eiz == null) {
                this.eiz = new AlphaAnimation(0.0f, 1.0f);
                this.eiz.setFillAfter(true);
                this.eiz.setDuration(300L);
            }
            this.eiw.startAnimation(this.eiz);
        }
    }

    public void aZX() {
        if (this.gVW) {
            if (this.eiA == null) {
                this.eiA = new AlphaAnimation(1.0f, 0.0f);
                this.eiA.setFillAfter(true);
                this.eiA.setDuration(300L);
                this.eiA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.11
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        b.this.eiw.setVisibility(8);
                        b.this.gVW = false;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eiw.startAnimation(this.eiA);
        }
    }

    public void a(BdListView.e eVar) {
        if (this.Bn != null) {
            this.Bn.setOnSrollToBottomListener(eVar);
        }
    }

    public void setListPullRefreshListener(g.c cVar) {
        if (this.gRq != null) {
            this.gRq.setListPullRefreshListener(cVar);
        }
    }

    public void aw(List<com.baidu.adp.widget.ListView.m> list) {
        if (this.gVU != null) {
            this.gVU.setData(list);
        }
        bLC();
    }

    public void bLC() {
        if (this.glq != null && this.gWa) {
            this.glq.a(this.gkE, this.efC, this.glj, true);
        }
    }

    public void bLD() {
        if (this.glq != null) {
            this.glq.bLD();
        }
    }

    public void mq(boolean z) {
        this.gWa = z;
    }

    public af bLE() {
        if (this.glq == null || this.glq.cwe() == null || !(this.glq.cwe().getTag() instanceof af)) {
            return null;
        }
        return (af) this.glq.cwe().getTag();
    }

    public List<com.baidu.adp.widget.ListView.m> getDataList() {
        if (this.gVU != null) {
            return this.gVU.getDataList();
        }
        return null;
    }

    public void bLF() {
        aw(new LinkedList());
    }

    public void showLoadingView() {
        if (!isLoadingViewAttached()) {
            if (this.eoy == null) {
                this.eoy = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity());
                this.eoy.aNc();
                this.eoy.setTopMargin((((this.mRootView.getHeight() - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) - l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds304)) / 2) - (TbadkCoreApplication.getInst().getMainTabBottomBarHeight() / 2));
                this.eoy.onChangeSkinType();
            }
            this.eoy.attachView(this.mRootView, false);
        }
    }

    private boolean isLoadingViewAttached() {
        if (this.eoy == null) {
            return false;
        }
        return this.eoy.isViewAttached();
    }

    public void hideLoadingView() {
        if (this.eoy != null) {
            this.eoy.dettachView(this.mRootView);
        }
    }

    public void m(View.OnClickListener onClickListener) {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), onClickListener);
        }
        this.mRefreshView.showRefreshButton();
        this.mRefreshView.setSubText(null);
        this.mRefreshView.setTitle(this.mPageContext.getResources().getString(R.string.refresh_view_title_text));
        this.mRefreshView.mn(R.drawable.new_pic_emotion_08);
        this.mRefreshView.mp(0);
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void showNoDataView() {
        if (this.mRefreshView == null) {
            this.mRefreshView = new h(this.mPageContext.getPageActivity(), null);
        }
        this.mRefreshView.hideRefreshButton();
        this.mRefreshView.mn(R.drawable.new_pic_emotion_03);
        this.mRefreshView.vc(this.mPageContext.getString(R.string.no_data_common_txt));
        this.mRefreshView.attachView(this.mContentLayout, false);
    }

    public void aZK() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mContentLayout);
            this.mRefreshView = null;
        }
    }

    public void z(View.OnClickListener onClickListener) {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Bn.setNextPage(this.egU);
            }
            this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.egU.setText(this.mPageContext.getResources().getString(R.string.game_video_click_load));
            this.egU.setOnClickListener(onClickListener);
            this.egU.endLoadData();
        }
    }

    public void aZG() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Bn.setNextPage(this.egU);
            }
            this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.egU.setText(this.mPageContext.getResources().getString(R.string.game_video_no_more));
            this.egU.setOnClickListener(null);
            this.egU.endLoadData();
        }
    }

    public void aZH() {
        if (this.egU != null) {
            if (this.egU.getView().getParent() == null) {
                this.Bn.setNextPage(this.egU);
            }
            this.egU.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds178));
            this.egU.setText(this.mPageContext.getResources().getString(R.string.loading));
            this.egU.setOnClickListener(null);
            this.egU.startLoadData();
        }
    }

    public void va(int i) {
        if (this.gVU != null) {
            this.gVU.va(i);
        }
    }

    public void uS() {
        if (this.gVU != null) {
            this.gVU.notifyDataSetChanged();
        }
    }

    public void aFd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.gVS != null) {
            SvgManager.aDW().a(this.gVS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
        }
        if (this.eoy != null) {
            this.eoy.setSkinType(TbadkCoreApplication.getInst().getSkinType());
            this.eoy.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.gVT != null) {
            am.setViewTextColor(this.gVT, (int) R.color.cp_cont_b);
        }
        if (this.gRq != null) {
            this.gRq.changeSkin(skinType);
        }
        if (this.gVU != null) {
            this.gVU.notifyDataSetChanged();
        }
    }

    public void setTabInForeBackgroundState(boolean z) {
        this.mIsBackground = z;
    }

    public void setViewForeground() {
        lf(false);
    }

    public void bKv() {
        lf(true);
    }

    public void lf(boolean z) {
        boolean z2 = false;
        this.mIsBackground = z;
        if (this.glq != null) {
            this.glq.on(!z);
            af bLE = bLE();
            if (bLE != null && bLE.mT() != null) {
                z2 = bLE.mT().b(new a.C0050a(8, Boolean.valueOf(z)));
            }
            if (!z2) {
                if (z) {
                    this.glq.bLD();
                } else if (this.gWa) {
                    this.glq.a(this.gkE, this.efC, this.glj, true);
                }
            }
        }
    }

    public void onPause() {
        if (this.gVU != null) {
            this.gVU.onPause();
        }
    }

    public void onDestroy() {
        if (this.eoy != null) {
            this.eoy.release();
        }
        if (this.eiz != null) {
            this.eiz.cancel();
        }
        if (this.eiA != null) {
            this.eiA.cancel();
        }
        b((g.e) null);
        if (this.gRq != null) {
            this.gRq.release();
        }
        if (this.gVU != null) {
            this.gVU.onDestroy();
        }
        if (this.gVX != null) {
            this.gVX.cancel();
        }
        if (this.gVY != null) {
            this.gVY.cancel();
        }
        if (this.glq != null) {
            this.glq.destroy();
        }
        bLG();
        MessageManager.getInstance().unRegisterListener(this.gkw);
        MessageManager.getInstance().unRegisterListener(this.cHV);
    }

    private void bLG() {
        if (this.Bn != null) {
            this.Bn.removeOnScrollListener(this.mScrollListener);
            this.Bn.setOnTouchListener(null);
            this.Bn.setRecyclerListener(null);
        }
        if (this.gHa != null) {
            this.gHa.a((a.InterfaceC0488a) null);
        }
        if (this.gRq != null) {
            this.gRq.a((g.d) null);
            this.gRq.a((g.b) null);
        }
    }

    public void A(View.OnClickListener onClickListener) {
        if (this.gVS != null) {
            this.gVS.setOnClickListener(onClickListener);
        }
    }

    public View bLH() {
        return this.mRootView.findViewById(R.id.game_video_title_bar);
    }

    public void bLI() {
        if (this.gVX == null) {
            this.gVX = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
            this.gVX.setDuration(300L);
            this.gVX.setInterpolator(new AccelerateInterpolator());
            this.gVX.setFillAfter(true);
            this.gVX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gVS != null) {
                        SvgManager.aDW().a(b.this.gVS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.gVZ = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gVS.startAnimation(this.gVX);
    }

    public void bLJ() {
        if (this.gVY == null) {
            this.gVY = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.gVY.setDuration(300L);
            this.gVY.setInterpolator(new AccelerateInterpolator());
            this.gVY.setFillAfter(true);
            this.gVY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.view.b.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (b.this.gVS != null) {
                        SvgManager.aDW().a(b.this.gVS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                        b.this.gVZ = false;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
        this.gVS.startAnimation(this.gVY);
    }

    public boolean bLK() {
        return this.gVZ;
    }

    public void mr(boolean z) {
        this.gVZ = z;
    }

    public void ms(boolean z) {
        if (this.gVS != null) {
            this.gVS.setVisibility(0);
            if (z) {
                SvgManager.aDW().a(this.gVS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
                am.setBackgroundResource(this.gVV, R.color.cp_bg_line_d);
                return;
            }
            SvgManager.aDW().a(this.gVS, R.drawable.icon_pure_more_administration24_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL);
            am.setBackgroundResource(this.gVV, R.color.cp_bg_line_h);
        }
    }

    public void bLL() {
        if (this.gVT != null) {
            this.gVT.setVisibility(0);
        }
    }

    public void BH(String str) {
        if (!StringUtils.isNull(str) && this.gVT != null) {
            this.gVT.setVisibility(0);
            this.gVT.setText(str);
        }
    }

    public void BI(String str) {
        List<Integer> b = b(str, this.Bn);
        int intValue = b.get(0).intValue();
        int intValue2 = b.get(1).intValue();
        if (intValue != -1 && intValue2 != -1) {
            this.Bn.l(intValue, intValue2);
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
                    if (cVar.axx() != null && cVar.axx().getTid().equals(str)) {
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
